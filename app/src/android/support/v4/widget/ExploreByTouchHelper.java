package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper
  extends AccessibilityDelegateCompat
{
  private static final String DEFAULT_CLASS_NAME = "android.view.View";
  public static final int HOST_ID = -1;
  public static final int INVALID_ID = Integer.MIN_VALUE;
  private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
  private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter()
  {
    public void obtainBounds(AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat, Rect paramAnonymousRect)
    {
      paramAnonymousAccessibilityNodeInfoCompat.getBoundsInParent(paramAnonymousRect);
    }
  };
  private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter()
  {
    public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> paramAnonymousSparseArrayCompat, int paramAnonymousInt)
    {
      return (AccessibilityNodeInfoCompat)paramAnonymousSparseArrayCompat.valueAt(paramAnonymousInt);
    }
    
    public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> paramAnonymousSparseArrayCompat)
    {
      return paramAnonymousSparseArrayCompat.size();
    }
  };
  private int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
  private final View mHost;
  private int mHoveredVirtualViewId = Integer.MIN_VALUE;
  private int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
  private final AccessibilityManager mManager;
  private MyNodeProvider mNodeProvider;
  private final int[] mTempGlobalRect = new int[2];
  private final Rect mTempParentRect = new Rect();
  private final Rect mTempScreenRect = new Rect();
  private final Rect mTempVisibleRect = new Rect();
  
  public ExploreByTouchHelper(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("View may not be null");
    }
    this.mHost = paramView;
    this.mManager = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
    paramView.setFocusable(true);
    if (ViewCompat.getImportantForAccessibility(paramView) == 0) {
      ViewCompat.setImportantForAccessibility(paramView, 1);
    }
  }
  
  private boolean clearAccessibilityFocus(int paramInt)
  {
    if (this.mAccessibilityFocusedVirtualViewId == paramInt)
    {
      this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
      this.mHost.invalidate();
      sendEventForVirtualView(paramInt, 65536);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean clickKeyboardFocusedVirtualView()
  {
    if ((this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) && (onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private AccessibilityEvent createEvent(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (AccessibilityEvent localAccessibilityEvent = createEventForChild(paramInt1, paramInt2);; localAccessibilityEvent = createEventForHost(paramInt2)) {
      return localAccessibilityEvent;
    }
  }
  
  private AccessibilityEvent createEventForChild(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    AccessibilityRecordCompat localAccessibilityRecordCompat = AccessibilityEventCompat.asRecord(localAccessibilityEvent);
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = obtainAccessibilityNodeInfo(paramInt1);
    localAccessibilityRecordCompat.getText().add(localAccessibilityNodeInfoCompat.getText());
    localAccessibilityRecordCompat.setContentDescription(localAccessibilityNodeInfoCompat.getContentDescription());
    localAccessibilityRecordCompat.setScrollable(localAccessibilityNodeInfoCompat.isScrollable());
    localAccessibilityRecordCompat.setPassword(localAccessibilityNodeInfoCompat.isPassword());
    localAccessibilityRecordCompat.setEnabled(localAccessibilityNodeInfoCompat.isEnabled());
    localAccessibilityRecordCompat.setChecked(localAccessibilityNodeInfoCompat.isChecked());
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityRecordCompat.setClassName(localAccessibilityNodeInfoCompat.getClassName());
    localAccessibilityRecordCompat.setSource(this.mHost, paramInt1);
    localAccessibilityEvent.setPackageName(this.mHost.getContext().getPackageName());
    return localAccessibilityEvent;
  }
  
  private AccessibilityEvent createEventForHost(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
    ViewCompat.onInitializeAccessibilityEvent(this.mHost, localAccessibilityEvent);
    return localAccessibilityEvent;
  }
  
  @NonNull
  private AccessibilityNodeInfoCompat createNodeForChild(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    localAccessibilityNodeInfoCompat.setEnabled(true);
    localAccessibilityNodeInfoCompat.setFocusable(true);
    localAccessibilityNodeInfoCompat.setClassName("android.view.View");
    localAccessibilityNodeInfoCompat.setBoundsInParent(INVALID_PARENT_BOUNDS);
    localAccessibilityNodeInfoCompat.setBoundsInScreen(INVALID_PARENT_BOUNDS);
    onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat);
    if ((localAccessibilityNodeInfoCompat.getText() == null) && (localAccessibilityNodeInfoCompat.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    localAccessibilityNodeInfoCompat.getBoundsInParent(this.mTempParentRect);
    if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }
    int i = localAccessibilityNodeInfoCompat.getActions();
    if ((i & 0x40) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    if ((i & 0x80) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    localAccessibilityNodeInfoCompat.setPackageName(this.mHost.getContext().getPackageName());
    localAccessibilityNodeInfoCompat.setSource(this.mHost, paramInt);
    localAccessibilityNodeInfoCompat.setParent(this.mHost);
    boolean bool;
    if (this.mAccessibilityFocusedVirtualViewId == paramInt)
    {
      localAccessibilityNodeInfoCompat.setAccessibilityFocused(true);
      localAccessibilityNodeInfoCompat.addAction(128);
      if (this.mKeyboardFocusedVirtualViewId != paramInt) {
        break label363;
      }
      bool = true;
      label216:
      if (!bool) {
        break label368;
      }
      localAccessibilityNodeInfoCompat.addAction(2);
    }
    for (;;)
    {
      localAccessibilityNodeInfoCompat.setFocused(bool);
      if (intersectVisibleToUser(this.mTempParentRect))
      {
        localAccessibilityNodeInfoCompat.setVisibleToUser(true);
        localAccessibilityNodeInfoCompat.setBoundsInParent(this.mTempParentRect);
      }
      localAccessibilityNodeInfoCompat.getBoundsInScreen(this.mTempScreenRect);
      if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS))
      {
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        localAccessibilityNodeInfoCompat.getBoundsInParent(this.mTempScreenRect);
        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        localAccessibilityNodeInfoCompat.setBoundsInScreen(this.mTempScreenRect);
      }
      return localAccessibilityNodeInfoCompat;
      localAccessibilityNodeInfoCompat.setAccessibilityFocused(false);
      localAccessibilityNodeInfoCompat.addAction(64);
      break;
      label363:
      bool = false;
      break label216;
      label368:
      if (localAccessibilityNodeInfoCompat.isFocusable()) {
        localAccessibilityNodeInfoCompat.addAction(1);
      }
    }
  }
  
  @NonNull
  private AccessibilityNodeInfoCompat createNodeForHost()
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(this.mHost);
    ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, localAccessibilityNodeInfoCompat);
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    if ((localAccessibilityNodeInfoCompat.getChildCount() > 0) && (localArrayList.size() > 0)) {
      throw new RuntimeException("Views cannot have both real and virtual children");
    }
    int i = 0;
    int j = localArrayList.size();
    while (i < j)
    {
      localAccessibilityNodeInfoCompat.addChild(this.mHost, ((Integer)localArrayList.get(i)).intValue());
      i++;
    }
    return localAccessibilityNodeInfoCompat;
  }
  
  private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes()
  {
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    SparseArrayCompat localSparseArrayCompat = new SparseArrayCompat();
    for (int i = 0; i < localArrayList.size(); i++) {
      localSparseArrayCompat.put(i, createNodeForChild(i));
    }
    return localSparseArrayCompat;
  }
  
  private void getBoundsInParent(int paramInt, Rect paramRect)
  {
    obtainAccessibilityNodeInfo(paramInt).getBoundsInParent(paramRect);
  }
  
  private static Rect guessPreviouslyFocusedRect(@NonNull View paramView, int paramInt, @NonNull Rect paramRect)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      paramRect.set(i, 0, i, j);
    }
    for (;;)
    {
      return paramRect;
      paramRect.set(0, j, i, j);
      continue;
      paramRect.set(-1, 0, -1, j);
      continue;
      paramRect.set(0, -1, i, -1);
    }
  }
  
  private boolean intersectVisibleToUser(Rect paramRect)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramRect != null)
    {
      if (!paramRect.isEmpty()) {
        break label19;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label19:
      bool1 = bool2;
      if (this.mHost.getWindowVisibility() == 0)
      {
        for (Object localObject = this.mHost.getParent();; localObject = ((View)localObject).getParent())
        {
          if (!(localObject instanceof View)) {
            break label87;
          }
          localObject = (View)localObject;
          bool1 = bool2;
          if (ViewCompat.getAlpha((View)localObject) <= 0.0F) {
            break;
          }
          bool1 = bool2;
          if (((View)localObject).getVisibility() != 0) {
            break;
          }
        }
        label87:
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
            bool1 = paramRect.intersect(this.mTempVisibleRect);
          }
        }
      }
    }
  }
  
  private static int keyToDirection(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      paramInt = 130;
    }
    for (;;)
    {
      return paramInt;
      paramInt = 17;
      continue;
      paramInt = 33;
      continue;
      paramInt = 66;
    }
  }
  
  private boolean moveFocus(int paramInt, @Nullable Rect paramRect)
  {
    SparseArrayCompat localSparseArrayCompat = getAllNodes();
    int i = this.mKeyboardFocusedVirtualViewId;
    if (i == Integer.MIN_VALUE) {}
    for (AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = null;; localAccessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)localSparseArrayCompat.get(i)) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      }
    }
    boolean bool;
    if (ViewCompat.getLayoutDirection(this.mHost) == 1)
    {
      bool = true;
      paramRect = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInRelativeDirection(localSparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, localAccessibilityNodeInfoCompat, paramInt, bool, false);
      if (paramRect != null) {
        break label237;
      }
    }
    label237:
    for (paramInt = Integer.MIN_VALUE;; paramInt = localSparseArrayCompat.keyAt(localSparseArrayCompat.indexOfValue(paramRect)))
    {
      return requestKeyboardFocusForVirtualView(paramInt);
      bool = false;
      break;
      Rect localRect = new Rect();
      if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
        getBoundsInParent(this.mKeyboardFocusedVirtualViewId, localRect);
      }
      for (;;)
      {
        paramRect = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInAbsoluteDirection(localSparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, localAccessibilityNodeInfoCompat, localRect, paramInt);
        break;
        if (paramRect != null) {
          localRect.set(paramRect);
        } else {
          guessPreviouslyFocusedRect(this.mHost, paramInt, localRect);
        }
      }
    }
  }
  
  private boolean performActionForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool;
    switch (paramInt2)
    {
    default: 
      bool = onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);
    }
    for (;;)
    {
      return bool;
      bool = requestAccessibilityFocus(paramInt1);
      continue;
      bool = clearAccessibilityFocus(paramInt1);
      continue;
      bool = requestKeyboardFocusForVirtualView(paramInt1);
      continue;
      bool = clearKeyboardFocusForVirtualView(paramInt1);
    }
  }
  
  private boolean performActionForHost(int paramInt, Bundle paramBundle)
  {
    return ViewCompat.performAccessibilityAction(this.mHost, paramInt, paramBundle);
  }
  
  private boolean requestAccessibilityFocus(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mManager.isEnabled())
    {
      if (AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) {
        break label28;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label28:
      bool1 = bool2;
      if (this.mAccessibilityFocusedVirtualViewId != paramInt)
      {
        if (this.mAccessibilityFocusedVirtualViewId != Integer.MIN_VALUE) {
          clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
        }
        this.mAccessibilityFocusedVirtualViewId = paramInt;
        this.mHost.invalidate();
        sendEventForVirtualView(paramInt, 32768);
        bool1 = true;
      }
    }
  }
  
  private void updateHoveredVirtualView(int paramInt)
  {
    if (this.mHoveredVirtualViewId == paramInt) {}
    for (;;)
    {
      return;
      int i = this.mHoveredVirtualViewId;
      this.mHoveredVirtualViewId = paramInt;
      sendEventForVirtualView(paramInt, 128);
      sendEventForVirtualView(i, 256);
    }
  }
  
  public final boolean clearKeyboardFocusForVirtualView(int paramInt)
  {
    boolean bool = false;
    if (this.mKeyboardFocusedVirtualViewId != paramInt) {}
    for (;;)
    {
      return bool;
      this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
      onVirtualViewKeyboardFocusChanged(paramInt, false);
      sendEventForVirtualView(paramInt, 8);
      bool = true;
    }
  }
  
  public final boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.mManager.isEnabled())
    {
      if (AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) {
        break label34;
      }
      bool1 = bool3;
    }
    for (;;)
    {
      return bool1;
      label34:
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      default: 
        bool1 = bool3;
        break;
      case 7: 
      case 9: 
        int i = getVirtualViewAt(paramMotionEvent.getX(), paramMotionEvent.getY());
        updateHoveredVirtualView(i);
        if (i != Integer.MIN_VALUE) {}
        for (bool1 = bool2;; bool1 = false) {
          break;
        }
      case 10: 
        bool1 = bool3;
        if (this.mAccessibilityFocusedVirtualViewId != Integer.MIN_VALUE)
        {
          updateHoveredVirtualView(Integer.MIN_VALUE);
          bool1 = true;
        }
        break;
      }
    }
  }
  
  public final boolean dispatchKeyEvent(@NonNull KeyEvent paramKeyEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramKeyEvent.getAction() != 1)
    {
      i = paramKeyEvent.getKeyCode();
      switch (i)
      {
      default: 
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (KeyEventCompat.hasNoModifiers(paramKeyEvent))
      {
        int k = keyToDirection(i);
        int j = paramKeyEvent.getRepeatCount();
        i = 0;
        bool2 = bool3;
        for (;;)
        {
          bool1 = bool2;
          if (i >= j + 1) {
            break;
          }
          bool1 = bool2;
          if (!moveFocus(k, null)) {
            break;
          }
          bool2 = true;
          i++;
        }
        bool1 = bool2;
        if (KeyEventCompat.hasNoModifiers(paramKeyEvent))
        {
          bool1 = bool2;
          if (paramKeyEvent.getRepeatCount() == 0)
          {
            clickKeyboardFocusedVirtualView();
            bool1 = true;
            continue;
            if (KeyEventCompat.hasNoModifiers(paramKeyEvent))
            {
              bool1 = moveFocus(2, null);
            }
            else
            {
              bool1 = bool2;
              if (KeyEventCompat.hasModifiers(paramKeyEvent, 1)) {
                bool1 = moveFocus(1, null);
              }
            }
          }
        }
      }
    }
  }
  
  public final int getAccessibilityFocusedVirtualViewId()
  {
    return this.mAccessibilityFocusedVirtualViewId;
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    if (this.mNodeProvider == null) {
      this.mNodeProvider = new MyNodeProvider();
    }
    return this.mNodeProvider;
  }
  
  @Deprecated
  public int getFocusedVirtualView()
  {
    return getAccessibilityFocusedVirtualViewId();
  }
  
  public final int getKeyboardFocusedVirtualViewId()
  {
    return this.mKeyboardFocusedVirtualViewId;
  }
  
  protected abstract int getVirtualViewAt(float paramFloat1, float paramFloat2);
  
  protected abstract void getVisibleVirtualViews(List<Integer> paramList);
  
  public final void invalidateRoot()
  {
    invalidateVirtualView(-1, 1);
  }
  
  public final void invalidateVirtualView(int paramInt)
  {
    invalidateVirtualView(paramInt, 0);
  }
  
  public final void invalidateVirtualView(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != Integer.MIN_VALUE) && (this.mManager.isEnabled()))
    {
      ViewParent localViewParent = this.mHost.getParent();
      if (localViewParent != null)
      {
        AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, 2048);
        AccessibilityEventCompat.setContentChangeTypes(localAccessibilityEvent, paramInt2);
        ViewParentCompat.requestSendAccessibilityEvent(localViewParent, this.mHost, localAccessibilityEvent);
      }
    }
  }
  
  @NonNull
  AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int paramInt)
  {
    if (paramInt == -1) {}
    for (AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = createNodeForHost();; localAccessibilityNodeInfoCompat = createNodeForChild(paramInt)) {
      return localAccessibilityNodeInfoCompat;
    }
  }
  
  public final void onFocusChanged(boolean paramBoolean, int paramInt, @Nullable Rect paramRect)
  {
    if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
      clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
    }
    if (paramBoolean) {
      moveFocus(paramInt, paramRect);
    }
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    onPopulateEventForHost(paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    onPopulateNodeForHost(paramAccessibilityNodeInfoCompat);
  }
  
  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle);
  
  protected void onPopulateEventForHost(AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
  
  protected abstract void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
  
  protected void onVirtualViewKeyboardFocusChanged(int paramInt, boolean paramBoolean) {}
  
  boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    switch (paramInt1)
    {
    }
    for (boolean bool = performActionForChild(paramInt1, paramInt2, paramBundle);; bool = performActionForHost(paramInt2, paramBundle)) {
      return bool;
    }
  }
  
  public final boolean requestKeyboardFocusForVirtualView(int paramInt)
  {
    boolean bool = false;
    if ((!this.mHost.isFocused()) && (!this.mHost.requestFocus())) {}
    for (;;)
    {
      return bool;
      if (this.mKeyboardFocusedVirtualViewId != paramInt)
      {
        if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
          clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        this.mKeyboardFocusedVirtualViewId = paramInt;
        onVirtualViewKeyboardFocusChanged(paramInt, true);
        sendEventForVirtualView(paramInt, 8);
        bool = true;
      }
    }
  }
  
  public final boolean sendEventForVirtualView(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 != Integer.MIN_VALUE)
    {
      if (this.mManager.isEnabled()) {
        break label27;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label27:
      ViewParent localViewParent = this.mHost.getParent();
      bool1 = bool2;
      if (localViewParent != null)
      {
        AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, paramInt2);
        bool1 = ViewParentCompat.requestSendAccessibilityEvent(localViewParent, this.mHost, localAccessibilityEvent);
      }
    }
  }
  
  private class MyNodeProvider
    extends AccessibilityNodeProviderCompat
  {
    MyNodeProvider() {}
    
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
    {
      return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(paramInt));
    }
    
    public AccessibilityNodeInfoCompat findFocus(int paramInt)
    {
      if (paramInt == 2)
      {
        paramInt = ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId;
        if (paramInt != Integer.MIN_VALUE) {
          break label34;
        }
      }
      label34:
      for (AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = null;; localAccessibilityNodeInfoCompat = createAccessibilityNodeInfo(paramInt))
      {
        return localAccessibilityNodeInfoCompat;
        paramInt = ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
        break;
      }
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return ExploreByTouchHelper.this.performAction(paramInt1, paramInt2, paramBundle);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\widget\ExploreByTouchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */