package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
  implements DrawerLayoutImpl
{
  private static final boolean ALLOW_EDGE_LOCK = false;
  static final boolean CAN_HIDE_DESCENDANTS;
  private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  private static final int DRAWER_ELEVATION = 10;
  static final DrawerLayoutCompatImpl IMPL;
  static final int[] LAYOUT_ATTRS;
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  public static final int LOCK_MODE_UNDEFINED = 3;
  public static final int LOCK_MODE_UNLOCKED = 0;
  private static final int MIN_DRAWER_MARGIN = 64;
  private static final int MIN_FLING_VELOCITY = 400;
  private static final int PEEK_DELAY = 160;
  private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "DrawerLayout";
  private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
  private final ChildAccessibilityDelegate mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
  private boolean mChildrenCanceledTouch;
  private boolean mDisallowInterceptRequested;
  private boolean mDrawStatusBarBackground;
  private float mDrawerElevation;
  private int mDrawerState;
  private boolean mFirstLayout = true;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private Object mLastInsets;
  private final ViewDragCallback mLeftCallback;
  private final ViewDragHelper mLeftDragger;
  @Nullable
  private DrawerListener mListener;
  private List<DrawerListener> mListeners;
  private int mLockModeEnd = 3;
  private int mLockModeLeft = 3;
  private int mLockModeRight = 3;
  private int mLockModeStart = 3;
  private int mMinDrawerMargin;
  private final ArrayList<View> mNonDrawerViews;
  private final ViewDragCallback mRightCallback;
  private final ViewDragHelper mRightDragger;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private Paint mScrimPaint = new Paint();
  private Drawable mShadowEnd = null;
  private Drawable mShadowLeft = null;
  private Drawable mShadowLeftResolved;
  private Drawable mShadowRight = null;
  private Drawable mShadowRightResolved;
  private Drawable mShadowStart = null;
  private Drawable mStatusBarBackground;
  private CharSequence mTitleLeft;
  private CharSequence mTitleRight;
  
  static
  {
    boolean bool2 = true;
    LAYOUT_ATTRS = new int[] { 16842931 };
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      CAN_HIDE_DESCENDANTS = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label65;
      }
      bool1 = bool2;
      label37:
      SET_DRAWER_SHADOW_FROM_ELEVATION = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label70;
      }
    }
    label65:
    label70:
    for (IMPL = new DrawerLayoutCompatImplApi21();; IMPL = new DrawerLayoutCompatImplBase())
    {
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label37;
    }
  }
  
  public DrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.mMinDrawerMargin = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.mLeftCallback = new ViewDragCallback(3);
    this.mRightCallback = new ViewDragCallback(5);
    this.mLeftDragger = ViewDragHelper.create(this, 1.0F, this.mLeftCallback);
    this.mLeftDragger.setEdgeTrackingEnabled(1);
    this.mLeftDragger.setMinVelocity(f2);
    this.mLeftCallback.setDragger(this.mLeftDragger);
    this.mRightDragger = ViewDragHelper.create(this, 1.0F, this.mRightCallback);
    this.mRightDragger.setEdgeTrackingEnabled(2);
    this.mRightDragger.setMinVelocity(f2);
    this.mRightCallback.setDragger(this.mRightDragger);
    setFocusableInTouchMode(true);
    ViewCompat.setImportantForAccessibility(this, 1);
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
    ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
    if (ViewCompat.getFitsSystemWindows(this))
    {
      IMPL.configureApplyInsets(this);
      this.mStatusBarBackground = IMPL.getDefaultStatusBarBackground(paramContext);
    }
    this.mDrawerElevation = (10.0F * f1);
    this.mNonDrawerViews = new ArrayList();
  }
  
  static String gravityToString(int paramInt)
  {
    String str;
    if ((paramInt & 0x3) == 3) {
      str = "LEFT";
    }
    for (;;)
    {
      return str;
      if ((paramInt & 0x5) == 5) {
        str = "RIGHT";
      } else {
        str = Integer.toHexString(paramInt);
      }
    }
  }
  
  private static boolean hasOpaqueBackground(View paramView)
  {
    boolean bool2 = false;
    paramView = paramView.getBackground();
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.getOpacity() == -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean hasPeekingDrawer()
  {
    int j = getChildCount();
    int i = 0;
    if (i < j) {
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).isPeeking) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i++;
      break;
    }
  }
  
  private boolean hasVisibleDrawer()
  {
    if (findVisibleDrawer() != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static boolean includeChildForAccessibility(View paramView)
  {
    if ((ViewCompat.getImportantForAccessibility(paramView) != 4) && (ViewCompat.getImportantForAccessibility(paramView) != 2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean mirror(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (!DrawableCompat.isAutoMirrored(paramDrawable))) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      DrawableCompat.setLayoutDirection(paramDrawable, paramInt);
    }
  }
  
  private Drawable resolveLeftShadow()
  {
    int i = ViewCompat.getLayoutDirection(this);
    Drawable localDrawable;
    if (i == 0)
    {
      if (this.mShadowStart == null) {
        break label58;
      }
      mirror(this.mShadowStart, i);
      localDrawable = this.mShadowStart;
    }
    for (;;)
    {
      return localDrawable;
      if (this.mShadowEnd != null)
      {
        mirror(this.mShadowEnd, i);
        localDrawable = this.mShadowEnd;
      }
      else
      {
        label58:
        localDrawable = this.mShadowLeft;
      }
    }
  }
  
  private Drawable resolveRightShadow()
  {
    int i = ViewCompat.getLayoutDirection(this);
    Drawable localDrawable;
    if (i == 0)
    {
      if (this.mShadowEnd == null) {
        break label58;
      }
      mirror(this.mShadowEnd, i);
      localDrawable = this.mShadowEnd;
    }
    for (;;)
    {
      return localDrawable;
      if (this.mShadowStart != null)
      {
        mirror(this.mShadowStart, i);
        localDrawable = this.mShadowStart;
      }
      else
      {
        label58:
        localDrawable = this.mShadowRight;
      }
    }
  }
  
  private void resolveShadowDrawables()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {}
    for (;;)
    {
      return;
      this.mShadowLeftResolved = resolveLeftShadow();
      this.mShadowRightResolved = resolveRightShadow();
    }
  }
  
  private void updateChildrenImportantForAccessibility(View paramView, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (((!paramBoolean) && (!isDrawerView(localView))) || ((paramBoolean) && (localView == paramView))) {
        ViewCompat.setImportantForAccessibility(localView, 1);
      }
      for (;;)
      {
        i++;
        break;
        ViewCompat.setImportantForAccessibility(localView, 4);
      }
    }
  }
  
  public void addDrawerListener(@NonNull DrawerListener paramDrawerListener)
  {
    if (paramDrawerListener == null) {}
    for (;;)
    {
      return;
      if (this.mListeners == null) {
        this.mListeners = new ArrayList();
      }
      this.mListeners.add(paramDrawerListener);
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {}
    for (;;)
    {
      return;
      int k = getChildCount();
      int j = 0;
      int i = 0;
      View localView;
      if (i < k)
      {
        localView = getChildAt(i);
        if (isDrawerView(localView)) {
          if (isDrawerOpen(localView))
          {
            j = 1;
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        for (;;)
        {
          i++;
          break;
          this.mNonDrawerViews.add(localView);
        }
      }
      if (j == 0)
      {
        j = this.mNonDrawerViews.size();
        for (i = 0; i < j; i++)
        {
          localView = (View)this.mNonDrawerViews.get(i);
          if (localView.getVisibility() == 0) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
      }
      this.mNonDrawerViews.clear();
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((findOpenDrawer() != null) || (isDrawerView(paramView))) {
      ViewCompat.setImportantForAccessibility(paramView, 4);
    }
    for (;;)
    {
      if (!CAN_HIDE_DESCENDANTS) {
        ViewCompat.setAccessibilityDelegate(paramView, this.mChildAccessibilityDelegate);
      }
      return;
      ViewCompat.setImportantForAccessibility(paramView, 1);
    }
  }
  
  void cancelChildViewTouch()
  {
    if (!this.mChildrenCanceledTouch)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      int j = getChildCount();
      for (int i = 0; i < j; i++) {
        getChildAt(i).dispatchTouchEvent(localMotionEvent);
      }
      localMotionEvent.recycle();
      this.mChildrenCanceledTouch = true;
    }
  }
  
  boolean checkDrawerViewAbsoluteGravity(View paramView, int paramInt)
  {
    if ((getDrawerViewAbsoluteGravity(paramView) & paramInt) == paramInt) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void closeDrawer(int paramInt)
  {
    closeDrawer(paramInt, true);
  }
  
  public void closeDrawer(int paramInt, boolean paramBoolean)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt));
    }
    closeDrawer(localView, paramBoolean);
  }
  
  public void closeDrawer(View paramView)
  {
    closeDrawer(paramView, true);
  }
  
  public void closeDrawer(View paramView, boolean paramBoolean)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.onScreen = 0.0F;
      localLayoutParams.openState = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      if (paramBoolean)
      {
        localLayoutParams.openState |= 0x4;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
          this.mLeftDragger.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
        } else {
          this.mRightDragger.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
        }
      }
      else
      {
        moveDrawerToOffset(paramView, 0.0F);
        updateDrawerState(localLayoutParams.gravity, 0, paramView);
        paramView.setVisibility(4);
      }
    }
  }
  
  public void closeDrawers()
  {
    closeDrawers(false);
  }
  
  void closeDrawers(boolean paramBoolean)
  {
    int i = 0;
    int n = getChildCount();
    int j = 0;
    while (j < n)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int k = i;
      if (isDrawerView(localView))
      {
        if ((paramBoolean) && (!localLayoutParams.isPeeking)) {
          k = i;
        }
      }
      else
      {
        j++;
        i = k;
        continue;
      }
      int m = localView.getWidth();
      if (checkDrawerViewAbsoluteGravity(localView, 3)) {
        i |= this.mLeftDragger.smoothSlideViewTo(localView, -m, localView.getTop());
      }
      for (;;)
      {
        localLayoutParams.isPeeking = false;
        m = i;
        break;
        i |= this.mRightDragger.smoothSlideViewTo(localView, getWidth(), localView.getTop());
      }
    }
    this.mLeftCallback.removeCallbacks();
    this.mRightCallback.removeCallbacks();
    if (i != 0) {
      invalidate();
    }
  }
  
  public void computeScroll()
  {
    int j = getChildCount();
    float f = 0.0F;
    for (int i = 0; i < j; i++) {
      f = Math.max(f, ((LayoutParams)getChildAt(i).getLayoutParams()).onScreen);
    }
    this.mScrimOpacity = f;
    if ((this.mLeftDragger.continueSettling(true) | this.mRightDragger.continueSettling(true))) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void dispatchOnDrawerClosed(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((localLayoutParams.openState & 0x1) == 1)
    {
      localLayoutParams.openState = 0;
      if (this.mListeners != null) {
        for (int i = this.mListeners.size() - 1; i >= 0; i--) {
          ((DrawerListener)this.mListeners.get(i)).onDrawerClosed(paramView);
        }
      }
      updateChildrenImportantForAccessibility(paramView, false);
      if (hasWindowFocus())
      {
        paramView = getRootView();
        if (paramView != null) {
          paramView.sendAccessibilityEvent(32);
        }
      }
    }
  }
  
  void dispatchOnDrawerOpened(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((localLayoutParams.openState & 0x1) == 0)
    {
      localLayoutParams.openState = 1;
      if (this.mListeners != null) {
        for (int i = this.mListeners.size() - 1; i >= 0; i--) {
          ((DrawerListener)this.mListeners.get(i)).onDrawerOpened(paramView);
        }
      }
      updateChildrenImportantForAccessibility(paramView, true);
      if (hasWindowFocus()) {
        sendAccessibilityEvent(32);
      }
    }
  }
  
  void dispatchOnDrawerSlide(View paramView, float paramFloat)
  {
    if (this.mListeners != null) {
      for (int i = this.mListeners.size() - 1; i >= 0; i--) {
        ((DrawerListener)this.mListeners.get(i)).onDrawerSlide(paramView, paramFloat);
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i3 = getHeight();
    boolean bool1 = isContentView(paramView);
    int j = 0;
    int m = 0;
    int i = getWidth();
    int i2 = paramCanvas.save();
    int k = i;
    if (bool1)
    {
      int i4 = getChildCount();
      k = 0;
      j = m;
      if (k < i4)
      {
        View localView = getChildAt(k);
        m = j;
        int n = i;
        if (localView != paramView)
        {
          m = j;
          n = i;
          if (localView.getVisibility() == 0)
          {
            m = j;
            n = i;
            if (hasOpaqueBackground(localView))
            {
              m = j;
              n = i;
              if (isDrawerView(localView))
              {
                if (localView.getHeight() >= i3) {
                  break label163;
                }
                n = i;
                m = j;
              }
            }
          }
        }
        for (;;)
        {
          k++;
          j = m;
          i = n;
          break;
          label163:
          int i1;
          if (checkDrawerViewAbsoluteGravity(localView, 3))
          {
            i1 = localView.getRight();
            m = j;
            n = i;
            if (i1 > j)
            {
              m = i1;
              n = i;
            }
          }
          else
          {
            i1 = localView.getLeft();
            m = j;
            n = i;
            if (i1 < i)
            {
              n = i1;
              m = j;
            }
          }
        }
      }
      paramCanvas.clipRect(j, 0, i, getHeight());
      k = i;
    }
    boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i2);
    if ((this.mScrimOpacity > 0.0F) && (bool1))
    {
      i = (int)(((this.mScrimColor & 0xFF000000) >>> 24) * this.mScrimOpacity);
      m = this.mScrimColor;
      this.mScrimPaint.setColor(i << 24 | m & 0xFFFFFF);
      paramCanvas.drawRect(j, 0.0F, k, getHeight(), this.mScrimPaint);
    }
    for (;;)
    {
      return bool2;
      float f;
      if ((this.mShadowLeftResolved != null) && (checkDrawerViewAbsoluteGravity(paramView, 3)))
      {
        k = this.mShadowLeftResolved.getIntrinsicWidth();
        i = paramView.getRight();
        j = this.mLeftDragger.getEdgeSize();
        f = Math.max(0.0F, Math.min(i / j, 1.0F));
        this.mShadowLeftResolved.setBounds(i, paramView.getTop(), i + k, paramView.getBottom());
        this.mShadowLeftResolved.setAlpha((int)(255.0F * f));
        this.mShadowLeftResolved.draw(paramCanvas);
      }
      else if ((this.mShadowRightResolved != null) && (checkDrawerViewAbsoluteGravity(paramView, 5)))
      {
        m = this.mShadowRightResolved.getIntrinsicWidth();
        i = paramView.getLeft();
        k = getWidth();
        j = this.mRightDragger.getEdgeSize();
        f = Math.max(0.0F, Math.min((k - i) / j, 1.0F));
        this.mShadowRightResolved.setBounds(i - m, paramView.getTop(), i, paramView.getBottom());
        this.mShadowRightResolved.setAlpha((int)(255.0F * f));
        this.mShadowRightResolved.draw(paramCanvas);
      }
    }
  }
  
  View findDrawerWithGravity(int paramInt)
  {
    int j = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    int i = getChildCount();
    paramInt = 0;
    View localView;
    if (paramInt < i)
    {
      localView = getChildAt(paramInt);
      if ((getDrawerViewAbsoluteGravity(localView) & 0x7) != (j & 0x7)) {}
    }
    for (;;)
    {
      return localView;
      paramInt++;
      break;
      localView = null;
    }
  }
  
  View findOpenDrawer()
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    if (i < j)
    {
      localView = getChildAt(i);
      if ((((LayoutParams)localView.getLayoutParams()).openState & 0x1) != 1) {}
    }
    for (;;)
    {
      return localView;
      i++;
      break;
      localView = null;
    }
  }
  
  View findVisibleDrawer()
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    if (i < j)
    {
      localView = getChildAt(i);
      if ((!isDrawerView(localView)) || (!isDrawerVisible(localView))) {}
    }
    for (;;)
    {
      return localView;
      i++;
      break;
      localView = null;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
    }
    for (;;)
    {
      return paramLayoutParams;
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        paramLayoutParams = new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      } else {
        paramLayoutParams = new LayoutParams(paramLayoutParams);
      }
    }
  }
  
  public float getDrawerElevation()
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {}
    for (float f = this.mDrawerElevation;; f = 0.0F) {
      return f;
    }
  }
  
  public int getDrawerLockMode(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    switch (paramInt)
    {
    }
    label50:
    label191:
    label214:
    for (;;)
    {
      paramInt = 0;
      for (;;)
      {
        return paramInt;
        if (this.mLockModeLeft != 3)
        {
          paramInt = this.mLockModeLeft;
        }
        else
        {
          if (i == 0) {}
          for (paramInt = this.mLockModeStart; paramInt != 3; paramInt = this.mLockModeEnd) {
            break label50;
          }
          if (this.mLockModeRight != 3)
          {
            paramInt = this.mLockModeRight;
          }
          else
          {
            if (i == 0) {}
            for (paramInt = this.mLockModeEnd; paramInt != 3; paramInt = this.mLockModeStart) {
              break label50;
            }
            if (this.mLockModeStart != 3)
            {
              paramInt = this.mLockModeStart;
            }
            else
            {
              if (i == 0) {}
              for (paramInt = this.mLockModeLeft; paramInt != 3; paramInt = this.mLockModeRight) {
                break label50;
              }
              if (this.mLockModeEnd == 3) {
                break label191;
              }
              paramInt = this.mLockModeEnd;
            }
          }
        }
      }
      if (i == 0) {}
      for (paramInt = this.mLockModeRight;; paramInt = this.mLockModeLeft)
      {
        if (paramInt == 3) {
          break label214;
        }
        break;
      }
    }
  }
  
  public int getDrawerLockMode(View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return getDrawerLockMode(((LayoutParams)paramView.getLayoutParams()).gravity);
  }
  
  @Nullable
  public CharSequence getDrawerTitle(int paramInt)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    CharSequence localCharSequence;
    if (paramInt == 3) {
      localCharSequence = this.mTitleLeft;
    }
    for (;;)
    {
      return localCharSequence;
      if (paramInt == 5) {
        localCharSequence = this.mTitleRight;
      } else {
        localCharSequence = null;
      }
    }
  }
  
  int getDrawerViewAbsoluteGravity(View paramView)
  {
    return GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
  }
  
  float getDrawerViewOffset(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).onScreen;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.mStatusBarBackground;
  }
  
  boolean isContentView(View paramView)
  {
    if (((LayoutParams)paramView.getLayoutParams()).gravity == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isDrawerOpen(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null) {}
    for (boolean bool = isDrawerOpen(localView);; bool = false) {
      return bool;
    }
  }
  
  public boolean isDrawerOpen(View paramView)
  {
    boolean bool = true;
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    if ((((LayoutParams)paramView.getLayoutParams()).openState & 0x1) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  boolean isDrawerView(View paramView)
  {
    int i = GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView));
    boolean bool;
    if ((i & 0x3) != 0) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((i & 0x5) != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public boolean isDrawerVisible(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null) {}
    for (boolean bool = isDrawerVisible(localView);; bool = false) {
      return bool;
    }
  }
  
  public boolean isDrawerVisible(View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    if (((LayoutParams)paramView.getLayoutParams()).onScreen > 0.0F) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void moveDrawerToOffset(View paramView, float paramFloat)
  {
    float f = getDrawerViewOffset(paramView);
    int j = paramView.getWidth();
    int i = (int)(j * f);
    i = (int)(j * paramFloat) - i;
    if (checkDrawerViewAbsoluteGravity(paramView, 3)) {}
    for (;;)
    {
      paramView.offsetLeftAndRight(i);
      setDrawerViewOffset(paramView, paramFloat);
      return;
      i = -i;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mDrawStatusBarBackground) && (this.mStatusBarBackground != null))
    {
      int i = IMPL.getTopInset(this.mLastInsets);
      if (i > 0)
      {
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        this.mStatusBarBackground.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    boolean bool2 = this.mLeftDragger.shouldInterceptTouchEvent(paramMotionEvent);
    boolean bool3 = this.mRightDragger.shouldInterceptTouchEvent(paramMotionEvent);
    int k = 0;
    int j = 0;
    switch (i)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (((bool2 | bool3)) || (i != 0) || (hasPeekingDrawer()) || (this.mChildrenCanceledTouch)) {
        bool1 = true;
      }
      return bool1;
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      this.mInitialMotionX = f2;
      this.mInitialMotionY = f1;
      i = k;
      if (this.mScrimOpacity > 0.0F)
      {
        paramMotionEvent = this.mLeftDragger.findTopChildUnder((int)f2, (int)f1);
        i = k;
        if (paramMotionEvent != null)
        {
          i = k;
          if (isContentView(paramMotionEvent)) {
            i = 1;
          }
        }
      }
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      continue;
      i = j;
      if (this.mLeftDragger.checkTouchSlop(3))
      {
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        i = j;
        continue;
        closeDrawers(true);
        this.mDisallowInterceptRequested = false;
        this.mChildrenCanceledTouch = false;
        i = j;
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (hasVisibleDrawer())) {
      paramKeyEvent.startTracking();
    }
    for (boolean bool = true;; bool = super.onKeyDown(paramInt, paramKeyEvent)) {
      return bool;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 4)
    {
      paramKeyEvent = findVisibleDrawer();
      if ((paramKeyEvent != null) && (getDrawerLockMode(paramKeyEvent) == 0)) {
        closeDrawers();
      }
      if (paramKeyEvent != null) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = super.onKeyUp(paramInt, paramKeyEvent);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    int m = paramInt3 - paramInt1;
    int n = getChildCount();
    paramInt3 = 0;
    if (paramInt3 < n)
    {
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() == 8) {}
      LayoutParams localLayoutParams;
      for (;;)
      {
        paramInt3++;
        break;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!isContentView(localView)) {
          break label110;
        }
        localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
      }
      label110:
      int i1 = localView.getMeasuredWidth();
      int i2 = localView.getMeasuredHeight();
      int i;
      float f;
      label162:
      int j;
      if (checkDrawerViewAbsoluteGravity(localView, 3))
      {
        i = -i1 + (int)(i1 * localLayoutParams.onScreen);
        f = (i1 + i) / i1;
        if (f == localLayoutParams.onScreen) {
          break label310;
        }
        j = 1;
        label176:
        switch (localLayoutParams.gravity & 0x70)
        {
        default: 
          localView.layout(i, localLayoutParams.topMargin, i + i1, localLayoutParams.topMargin + i2);
          label237:
          if (j != 0) {
            setDrawerViewOffset(localView, f);
          }
          if (localLayoutParams.onScreen <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * localLayoutParams.onScreen);
        f = (m - i) / i1;
        break label162;
        label310:
        j = 0;
        break label176;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i, paramInt1 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i + i1, paramInt1 - localLayoutParams.bottomMargin);
        break label237;
        int i3 = paramInt4 - paramInt2;
        int k = (i3 - i2) / 2;
        if (k < localLayoutParams.topMargin) {
          paramInt1 = localLayoutParams.topMargin;
        }
        for (;;)
        {
          localView.layout(i, paramInt1, i + i1, paramInt1 + i2);
          break;
          paramInt1 = k;
          if (k + i2 > i3 - localLayoutParams.bottomMargin) {
            paramInt1 = i3 - localLayoutParams.bottomMargin - i2;
          }
        }
      }
    }
    this.mInLayout = false;
    this.mFirstLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int m;
    int k;
    if (i1 == 1073741824)
    {
      m = j;
      k = i;
      if (n == 1073741824) {}
    }
    else
    {
      if (!isInEditMode()) {
        break label187;
      }
      if (i1 != Integer.MIN_VALUE) {
        break label152;
      }
      if (n != Integer.MIN_VALUE) {
        break label164;
      }
      k = i;
      m = j;
    }
    label76:
    setMeasuredDimension(k, m);
    if ((this.mLastInsets != null) && (ViewCompat.getFitsSystemWindows(this))) {}
    int i4;
    View localView;
    for (n = 1;; n = 0)
    {
      i4 = ViewCompat.getLayoutDirection(this);
      j = 0;
      i = 0;
      int i3 = getChildCount();
      for (i1 = 0;; i1++)
      {
        if (i1 >= i3) {
          return;
        }
        localView = getChildAt(i1);
        if (localView.getVisibility() != 8) {
          break;
        }
      }
      label152:
      if (i1 != 0) {
        break;
      }
      i = 300;
      break;
      label164:
      m = j;
      k = i;
      if (n != 0) {
        break label76;
      }
      m = 300;
      k = i;
      break label76;
      label187:
      throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
    }
    LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
    int i2;
    if (n != 0)
    {
      i2 = GravityCompat.getAbsoluteGravity(localLayoutParams.gravity, i4);
      if (!ViewCompat.getFitsSystemWindows(localView)) {
        break label312;
      }
      IMPL.dispatchChildInsets(localView, this.mLastInsets, i2);
    }
    for (;;)
    {
      if (!isContentView(localView)) {
        break label331;
      }
      localView.measure(View.MeasureSpec.makeMeasureSpec(k - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(m - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
      break;
      label312:
      IMPL.applyMarginInsets(localLayoutParams, this.mLastInsets, i2);
    }
    label331:
    if (isDrawerView(localView))
    {
      if ((SET_DRAWER_SHADOW_FROM_ELEVATION) && (ViewCompat.getElevation(localView) != this.mDrawerElevation)) {
        ViewCompat.setElevation(localView, this.mDrawerElevation);
      }
      int i5 = getDrawerViewAbsoluteGravity(localView) & 0x7;
      if (i5 == 3) {}
      for (i2 = 1; ((i2 != 0) && (j != 0)) || ((i2 == 0) && (i != 0)); i2 = 0) {
        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(i5) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
      }
      if (i2 != 0) {
        j = 1;
      }
      for (;;)
      {
        localView.measure(getChildMeasureSpec(paramInt1, this.mMinDrawerMargin + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
        break;
        i = 1;
      }
    }
    throw new IllegalStateException("Child " + localView + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      SavedState localSavedState = (SavedState)paramParcelable;
      super.onRestoreInstanceState(localSavedState.getSuperState());
      if (localSavedState.openDrawerGravity != 0)
      {
        paramParcelable = findDrawerWithGravity(localSavedState.openDrawerGravity);
        if (paramParcelable != null) {
          openDrawer(paramParcelable);
        }
      }
      if (localSavedState.lockModeLeft != 3) {
        setDrawerLockMode(localSavedState.lockModeLeft, 3);
      }
      if (localSavedState.lockModeRight != 3) {
        setDrawerLockMode(localSavedState.lockModeRight, 5);
      }
      if (localSavedState.lockModeStart != 3) {
        setDrawerLockMode(localSavedState.lockModeStart, 8388611);
      }
      if (localSavedState.lockModeEnd != 3) {
        setDrawerLockMode(localSavedState.lockModeEnd, 8388613);
      }
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    resolveShadowDrawables();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int m = getChildCount();
    label119:
    label124:
    label129:
    for (int i = 0;; i++)
    {
      LayoutParams localLayoutParams;
      int j;
      if (i < m)
      {
        localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
        if (localLayoutParams.openState != 1) {
          break label119;
        }
        j = 1;
        if (localLayoutParams.openState != 2) {
          break label124;
        }
      }
      for (int k = 1;; k = 0)
      {
        if ((j == 0) && (k == 0)) {
          break label129;
        }
        localSavedState.openDrawerGravity = localLayoutParams.gravity;
        localSavedState.lockModeLeft = this.mLockModeLeft;
        localSavedState.lockModeRight = this.mLockModeRight;
        localSavedState.lockModeStart = this.mLockModeStart;
        localSavedState.lockModeEnd = this.mLockModeEnd;
        return localSavedState;
        j = 0;
        break;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mLeftDragger.processTouchEvent(paramMotionEvent);
    this.mRightDragger.processTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      this.mInitialMotionX = f2;
      this.mInitialMotionY = f1;
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      continue;
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      boolean bool2 = true;
      paramMotionEvent = this.mLeftDragger.findTopChildUnder((int)f2, (int)f1);
      boolean bool1 = bool2;
      if (paramMotionEvent != null)
      {
        bool1 = bool2;
        if (isContentView(paramMotionEvent))
        {
          f2 -= this.mInitialMotionX;
          f1 -= this.mInitialMotionY;
          int i = this.mLeftDragger.getTouchSlop();
          bool1 = bool2;
          if (f2 * f2 + f1 * f1 < i * i)
          {
            paramMotionEvent = findOpenDrawer();
            bool1 = bool2;
            if (paramMotionEvent != null) {
              if (getDrawerLockMode(paramMotionEvent) != 2) {
                break label219;
              }
            }
          }
        }
      }
      label219:
      for (bool1 = true;; bool1 = false)
      {
        closeDrawers(bool1);
        this.mDisallowInterceptRequested = false;
        break;
      }
      closeDrawers(true);
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
    }
  }
  
  public void openDrawer(int paramInt)
  {
    openDrawer(paramInt, true);
  }
  
  public void openDrawer(int paramInt, boolean paramBoolean)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt));
    }
    openDrawer(localView, paramBoolean);
  }
  
  public void openDrawer(View paramView)
  {
    openDrawer(paramView, true);
  }
  
  public void openDrawer(View paramView, boolean paramBoolean)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (this.mFirstLayout)
    {
      localLayoutParams.onScreen = 1.0F;
      localLayoutParams.openState = 1;
      updateChildrenImportantForAccessibility(paramView, true);
    }
    for (;;)
    {
      invalidate();
      return;
      if (paramBoolean)
      {
        localLayoutParams.openState |= 0x2;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
          this.mLeftDragger.smoothSlideViewTo(paramView, 0, paramView.getTop());
        } else {
          this.mRightDragger.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
        }
      }
      else
      {
        moveDrawerToOffset(paramView, 1.0F);
        updateDrawerState(localLayoutParams.gravity, 0, paramView);
        paramView.setVisibility(0);
      }
    }
  }
  
  public void removeDrawerListener(@NonNull DrawerListener paramDrawerListener)
  {
    if (paramDrawerListener == null) {}
    for (;;)
    {
      return;
      if (this.mListeners != null) {
        this.mListeners.remove(paramDrawerListener);
      }
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.mDisallowInterceptRequested = paramBoolean;
    if (paramBoolean) {
      closeDrawers(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  public void setChildInsets(Object paramObject, boolean paramBoolean)
  {
    this.mLastInsets = paramObject;
    this.mDrawStatusBarBackground = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setWillNotDraw(paramBoolean);
      requestLayout();
      return;
    }
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    this.mDrawerElevation = paramFloat;
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      if (isDrawerView(localView)) {
        ViewCompat.setElevation(localView, this.mDrawerElevation);
      }
    }
  }
  
  @Deprecated
  public void setDrawerListener(DrawerListener paramDrawerListener)
  {
    if (this.mListener != null) {
      removeDrawerListener(this.mListener);
    }
    if (paramDrawerListener != null) {
      addDrawerListener(paramDrawerListener);
    }
    this.mListener = paramDrawerListener;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }
  
  public void setDrawerLockMode(int paramInt1, int paramInt2)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i == 3)
        {
          localObject = this.mLeftDragger;
          label67:
          ((ViewDragHelper)localObject).cancel();
        }
      }
      else {
        switch (paramInt1)
        {
        }
      }
      break;
    }
    for (;;)
    {
      return;
      this.mLockModeLeft = paramInt1;
      break;
      this.mLockModeRight = paramInt1;
      break;
      this.mLockModeStart = paramInt1;
      break;
      this.mLockModeEnd = paramInt1;
      break;
      localObject = this.mRightDragger;
      break label67;
      localObject = findDrawerWithGravity(i);
      if (localObject != null)
      {
        openDrawer((View)localObject);
        continue;
        localObject = findDrawerWithGravity(i);
        if (localObject != null) {
          closeDrawer((View)localObject);
        }
      }
    }
  }
  
  public void setDrawerLockMode(int paramInt, View paramView)
  {
    if (!isDrawerView(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a " + "drawer with appropriate layout_gravity");
    }
    setDrawerLockMode(paramInt, ((LayoutParams)paramView.getLayoutParams()).gravity);
  }
  
  public void setDrawerShadow(@DrawableRes int paramInt1, int paramInt2)
  {
    setDrawerShadow(ContextCompat.getDrawable(getContext(), paramInt1), paramInt2);
  }
  
  public void setDrawerShadow(Drawable paramDrawable, int paramInt)
  {
    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
      return;
    }
    if ((paramInt & 0x800003) == 8388611) {
      this.mShadowStart = paramDrawable;
    }
    for (;;)
    {
      resolveShadowDrawables();
      invalidate();
      break;
      if ((paramInt & 0x800005) == 8388613)
      {
        this.mShadowEnd = paramDrawable;
      }
      else if ((paramInt & 0x3) == 3)
      {
        this.mShadowLeft = paramDrawable;
      }
      else
      {
        if ((paramInt & 0x5) != 5) {
          break;
        }
        this.mShadowRight = paramDrawable;
      }
    }
  }
  
  public void setDrawerTitle(int paramInt, CharSequence paramCharSequence)
  {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (paramInt == 3) {
      this.mTitleLeft = paramCharSequence;
    }
    for (;;)
    {
      return;
      if (paramInt == 5) {
        this.mTitleRight = paramCharSequence;
      }
    }
  }
  
  void setDrawerViewOffset(View paramView, float paramFloat)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == localLayoutParams.onScreen) {}
    for (;;)
    {
      return;
      localLayoutParams.onScreen = paramFloat;
      dispatchOnDrawerSlide(paramView, paramFloat);
    }
  }
  
  public void setScrimColor(@ColorInt int paramInt)
  {
    this.mScrimColor = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = ContextCompat.getDrawable(getContext(), paramInt);; localDrawable = null)
    {
      this.mStatusBarBackground = localDrawable;
      invalidate();
      return;
    }
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    this.mStatusBarBackground = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(@ColorInt int paramInt)
  {
    this.mStatusBarBackground = new ColorDrawable(paramInt);
    invalidate();
  }
  
  void updateDrawerState(int paramInt1, int paramInt2, View paramView)
  {
    paramInt1 = this.mLeftDragger.getViewDragState();
    int i = this.mRightDragger.getViewDragState();
    LayoutParams localLayoutParams;
    if ((paramInt1 == 1) || (i == 1))
    {
      paramInt1 = 1;
      if ((paramView != null) && (paramInt2 == 0))
      {
        localLayoutParams = (LayoutParams)paramView.getLayoutParams();
        if (localLayoutParams.onScreen != 0.0F) {
          break label144;
        }
        dispatchOnDrawerClosed(paramView);
      }
    }
    for (;;)
    {
      if (paramInt1 == this.mDrawerState) {
        return;
      }
      this.mDrawerState = paramInt1;
      if (this.mListeners == null) {
        return;
      }
      for (paramInt2 = this.mListeners.size() - 1; paramInt2 >= 0; paramInt2--) {
        ((DrawerListener)this.mListeners.get(paramInt2)).onDrawerStateChanged(paramInt1);
      }
      if ((paramInt1 == 2) || (i == 2))
      {
        paramInt1 = 2;
        break;
      }
      paramInt1 = 0;
      break;
      label144:
      if (localLayoutParams.onScreen == 1.0F) {
        dispatchOnDrawerOpened(paramView);
      }
    }
  }
  
  class AccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    private final Rect mTmpRect = new Rect();
    
    AccessibilityDelegate() {}
    
    private void addChildrenForAccessibility(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, ViewGroup paramViewGroup)
    {
      int j = paramViewGroup.getChildCount();
      for (int i = 0; i < j; i++)
      {
        View localView = paramViewGroup.getChildAt(i);
        if (DrawerLayout.includeChildForAccessibility(localView)) {
          paramAccessibilityNodeInfoCompat.addChild(localView);
        }
      }
    }
    
    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
    {
      Rect localRect = this.mTmpRect;
      paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
      paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
      paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
      paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
      paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
      paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
      paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
      paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
      paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
      paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
      paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
      paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
    }
    
    public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramView = paramAccessibilityEvent.getText();
        paramAccessibilityEvent = DrawerLayout.this.findVisibleDrawer();
        if (paramAccessibilityEvent != null)
        {
          int i = DrawerLayout.this.getDrawerViewAbsoluteGravity(paramAccessibilityEvent);
          paramAccessibilityEvent = DrawerLayout.this.getDrawerTitle(i);
          if (paramAccessibilityEvent != null) {
            paramView.add(paramAccessibilityEvent);
          }
        }
      }
      for (boolean bool = true;; bool = super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent)) {
        return bool;
      }
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
        super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      }
      for (;;)
      {
        paramAccessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
        paramAccessibilityNodeInfoCompat.setFocusable(false);
        paramAccessibilityNodeInfoCompat.setFocused(false);
        paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
        paramAccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        return;
        AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
        super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
        paramAccessibilityNodeInfoCompat.setSource(paramView);
        ViewParent localViewParent = ViewCompat.getParentForAccessibility(paramView);
        if ((localViewParent instanceof View)) {
          paramAccessibilityNodeInfoCompat.setParent((View)localViewParent);
        }
        copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
        localAccessibilityNodeInfoCompat.recycle();
        addChildrenForAccessibility(paramAccessibilityNodeInfoCompat, (ViewGroup)paramView);
      }
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((DrawerLayout.CAN_HIDE_DESCENDANTS) || (DrawerLayout.includeChildForAccessibility(paramView))) {}
      for (boolean bool = super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);; bool = false) {
        return bool;
      }
    }
  }
  
  final class ChildAccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    ChildAccessibilityDelegate() {}
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      if (!DrawerLayout.includeChildForAccessibility(paramView)) {
        paramAccessibilityNodeInfoCompat.setParent(null);
      }
    }
  }
  
  static abstract interface DrawerLayoutCompatImpl
  {
    public abstract void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt);
    
    public abstract void configureApplyInsets(View paramView);
    
    public abstract void dispatchChildInsets(View paramView, Object paramObject, int paramInt);
    
    public abstract Drawable getDefaultStatusBarBackground(Context paramContext);
    
    public abstract int getTopInset(Object paramObject);
  }
  
  static class DrawerLayoutCompatImplApi21
    implements DrawerLayout.DrawerLayoutCompatImpl
  {
    public void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt)
    {
      DrawerLayoutCompatApi21.applyMarginInsets(paramMarginLayoutParams, paramObject, paramInt);
    }
    
    public void configureApplyInsets(View paramView)
    {
      DrawerLayoutCompatApi21.configureApplyInsets(paramView);
    }
    
    public void dispatchChildInsets(View paramView, Object paramObject, int paramInt)
    {
      DrawerLayoutCompatApi21.dispatchChildInsets(paramView, paramObject, paramInt);
    }
    
    public Drawable getDefaultStatusBarBackground(Context paramContext)
    {
      return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(paramContext);
    }
    
    public int getTopInset(Object paramObject)
    {
      return DrawerLayoutCompatApi21.getTopInset(paramObject);
    }
  }
  
  static class DrawerLayoutCompatImplBase
    implements DrawerLayout.DrawerLayoutCompatImpl
  {
    public void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt) {}
    
    public void configureApplyInsets(View paramView) {}
    
    public void dispatchChildInsets(View paramView, Object paramObject, int paramInt) {}
    
    public Drawable getDefaultStatusBarBackground(Context paramContext)
    {
      return null;
    }
    
    public int getTopInset(Object paramObject)
    {
      return 0;
    }
  }
  
  public static abstract interface DrawerListener
  {
    public abstract void onDrawerClosed(View paramView);
    
    public abstract void onDrawerOpened(View paramView);
    
    public abstract void onDrawerSlide(View paramView, float paramFloat);
    
    public abstract void onDrawerStateChanged(int paramInt);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int FLAG_IS_CLOSING = 4;
    private static final int FLAG_IS_OPENED = 1;
    private static final int FLAG_IS_OPENING = 2;
    public int gravity = 0;
    boolean isPeeking;
    float onScreen;
    int openState;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
      this.gravity = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.gravity = paramLayoutParams.gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
    {
      public DrawerLayout.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new DrawerLayout.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public DrawerLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new DrawerLayout.SavedState[paramAnonymousInt];
      }
    });
    int lockModeEnd;
    int lockModeLeft;
    int lockModeRight;
    int lockModeStart;
    int openDrawerGravity = 0;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.openDrawerGravity = paramParcel.readInt();
      this.lockModeLeft = paramParcel.readInt();
      this.lockModeRight = paramParcel.readInt();
      this.lockModeStart = paramParcel.readInt();
      this.lockModeEnd = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.openDrawerGravity);
      paramParcel.writeInt(this.lockModeLeft);
      paramParcel.writeInt(this.lockModeRight);
      paramParcel.writeInt(this.lockModeStart);
      paramParcel.writeInt(this.lockModeEnd);
    }
  }
  
  public static abstract class SimpleDrawerListener
    implements DrawerLayout.DrawerListener
  {
    public void onDrawerClosed(View paramView) {}
    
    public void onDrawerOpened(View paramView) {}
    
    public void onDrawerSlide(View paramView, float paramFloat) {}
    
    public void onDrawerStateChanged(int paramInt) {}
  }
  
  private class ViewDragCallback
    extends ViewDragHelper.Callback
  {
    private final int mAbsGravity;
    private ViewDragHelper mDragger;
    private final Runnable mPeekRunnable = new Runnable()
    {
      public void run()
      {
        DrawerLayout.ViewDragCallback.this.peekDrawer();
      }
    };
    
    ViewDragCallback(int paramInt)
    {
      this.mAbsGravity = paramInt;
    }
    
    private void closeOtherDrawer()
    {
      int i = 3;
      if (this.mAbsGravity == 3) {
        i = 5;
      }
      View localView = DrawerLayout.this.findDrawerWithGravity(i);
      if (localView != null) {
        DrawerLayout.this.closeDrawer(localView);
      }
    }
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3)) {}
      for (paramInt1 = Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));; paramInt1 = Math.max(paramInt2 - paramView.getWidth(), Math.min(paramInt1, paramInt2)))
      {
        return paramInt1;
        paramInt2 = DrawerLayout.this.getWidth();
      }
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      if (DrawerLayout.this.isDrawerView(paramView)) {}
      for (int i = paramView.getWidth();; i = 0) {
        return i;
      }
    }
    
    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      if ((paramInt1 & 0x1) == 1) {}
      for (View localView = DrawerLayout.this.findDrawerWithGravity(3);; localView = DrawerLayout.this.findDrawerWithGravity(5))
      {
        if ((localView != null) && (DrawerLayout.this.getDrawerLockMode(localView) == 0)) {
          this.mDragger.captureChildView(localView, paramInt2);
        }
        return;
      }
    }
    
    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }
    
    public void onEdgeTouched(int paramInt1, int paramInt2)
    {
      DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
    }
    
    public void onViewCaptured(View paramView, int paramInt)
    {
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).isPeeking = false;
      closeOtherDrawer();
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      DrawerLayout.this.updateDrawerState(this.mAbsGravity, paramInt, this.mDragger.getCapturedView());
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      paramInt2 = paramView.getWidth();
      float f;
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        f = (paramInt2 + paramInt1) / paramInt2;
        DrawerLayout.this.setDrawerViewOffset(paramView, f);
        if (f != 0.0F) {
          break label76;
        }
      }
      label76:
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        paramView.setVisibility(paramInt1);
        DrawerLayout.this.invalidate();
        return;
        f = (DrawerLayout.this.getWidth() - paramInt1) / paramInt2;
        break;
      }
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      paramFloat2 = DrawerLayout.this.getDrawerViewOffset(paramView);
      int j = paramView.getWidth();
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {}
        for (i = 0;; i = -j)
        {
          this.mDragger.settleCapturedViewAt(i, paramView.getTop());
          DrawerLayout.this.invalidate();
          return;
        }
      }
      int i = DrawerLayout.this.getWidth();
      if ((paramFloat1 < 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
        i -= j;
      }
      for (;;)
      {
        break;
      }
    }
    
    void peekDrawer()
    {
      int j = 0;
      int k = this.mDragger.getEdgeSize();
      int i;
      View localView;
      if (this.mAbsGravity == 3)
      {
        i = 1;
        if (i == 0) {
          break label149;
        }
        localView = DrawerLayout.this.findDrawerWithGravity(3);
        if (localView != null) {
          j = -localView.getWidth();
        }
        j += k;
      }
      for (;;)
      {
        if ((localView != null) && (((i != 0) && (localView.getLeft() < j)) || ((i == 0) && (localView.getLeft() > j) && (DrawerLayout.this.getDrawerLockMode(localView) == 0))))
        {
          DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          this.mDragger.smoothSlideViewTo(localView, j, localView.getTop());
          localLayoutParams.isPeeking = true;
          DrawerLayout.this.invalidate();
          closeOtherDrawer();
          DrawerLayout.this.cancelChildViewTouch();
        }
        return;
        i = 0;
        break;
        label149:
        localView = DrawerLayout.this.findDrawerWithGravity(5);
        j = DrawerLayout.this.getWidth() - k;
      }
    }
    
    public void removeCallbacks()
    {
      DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
    }
    
    public void setDragger(ViewDragHelper paramViewDragHelper)
    {
      this.mDragger = paramViewDragHelper;
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      if ((DrawerLayout.this.isDrawerView(paramView)) && (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, this.mAbsGravity)) && (DrawerLayout.this.getDrawerLockMode(paramView) == 0)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\widget\DrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */