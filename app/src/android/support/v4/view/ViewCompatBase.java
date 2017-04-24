package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import java.lang.reflect.Field;

class ViewCompatBase
{
  private static final String TAG = "ViewCompatBase";
  private static Field sMinHeightField;
  private static boolean sMinHeightFieldFetched;
  private static Field sMinWidthField;
  private static boolean sMinWidthFieldFetched;
  
  static ColorStateList getBackgroundTintList(View paramView)
  {
    if ((paramView instanceof TintableBackgroundView)) {}
    for (paramView = ((TintableBackgroundView)paramView).getSupportBackgroundTintList();; paramView = null) {
      return paramView;
    }
  }
  
  static PorterDuff.Mode getBackgroundTintMode(View paramView)
  {
    if ((paramView instanceof TintableBackgroundView)) {}
    for (paramView = ((TintableBackgroundView)paramView).getSupportBackgroundTintMode();; paramView = null) {
      return paramView;
    }
  }
  
  static Display getDisplay(View paramView)
  {
    if (isAttachedToWindow(paramView)) {}
    for (paramView = ((WindowManager)paramView.getContext().getSystemService("window")).getDefaultDisplay();; paramView = null) {
      return paramView;
    }
  }
  
  static int getMinimumHeight(View paramView)
  {
    if (!sMinHeightFieldFetched) {}
    try
    {
      sMinHeightField = View.class.getDeclaredField("mMinHeight");
      sMinHeightField.setAccessible(true);
      sMinHeightFieldFetched = true;
      if (sMinHeightField != null) {}
      for (;;)
      {
        try
        {
          i = ((Integer)sMinHeightField.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
        int i = 0;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
  
  static int getMinimumWidth(View paramView)
  {
    if (!sMinWidthFieldFetched) {}
    try
    {
      sMinWidthField = View.class.getDeclaredField("mMinWidth");
      sMinWidthField.setAccessible(true);
      sMinWidthFieldFetched = true;
      if (sMinWidthField != null) {}
      for (;;)
      {
        try
        {
          i = ((Integer)sMinWidthField.get(paramView)).intValue();
          return i;
        }
        catch (Exception paramView) {}
        int i = 0;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
  }
  
  static boolean isAttachedToWindow(View paramView)
  {
    if (paramView.getWindowToken() != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static boolean isLaidOut(View paramView)
  {
    if ((paramView.getWidth() > 0) && (paramView.getHeight() > 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static void offsetLeftAndRight(View paramView, int paramInt)
  {
    int i = paramView.getLeft();
    paramView.offsetLeftAndRight(paramInt);
    if (paramInt != 0)
    {
      ViewParent localViewParent = paramView.getParent();
      if (!(localViewParent instanceof View)) {
        break label58;
      }
      paramInt = Math.abs(paramInt);
      ((View)localViewParent).invalidate(i - paramInt, paramView.getTop(), paramView.getWidth() + i + paramInt, paramView.getBottom());
    }
    for (;;)
    {
      return;
      label58:
      paramView.invalidate();
    }
  }
  
  static void offsetTopAndBottom(View paramView, int paramInt)
  {
    int i = paramView.getTop();
    paramView.offsetTopAndBottom(paramInt);
    if (paramInt != 0)
    {
      ViewParent localViewParent = paramView.getParent();
      if (!(localViewParent instanceof View)) {
        break label58;
      }
      paramInt = Math.abs(paramInt);
      ((View)localViewParent).invalidate(paramView.getLeft(), i - paramInt, paramView.getRight(), paramView.getHeight() + i + paramInt);
    }
    for (;;)
    {
      return;
      label58:
      paramView.invalidate();
    }
  }
  
  static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList)
  {
    if ((paramView instanceof TintableBackgroundView)) {
      ((TintableBackgroundView)paramView).setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode)
  {
    if ((paramView instanceof TintableBackgroundView)) {
      ((TintableBackgroundView)paramView).setSupportBackgroundTintMode(paramMode);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\view\ViewCompatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */