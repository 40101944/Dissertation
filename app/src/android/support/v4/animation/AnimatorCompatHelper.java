package android.support.v4.animation;

import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.view.View;

@RestrictTo({android.support.annotation.RestrictTo.Scope.GROUP_ID})
public final class AnimatorCompatHelper
{
  private static final AnimatorProvider IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 12) {}
    for (IMPL = new HoneycombMr1AnimatorCompatProvider();; IMPL = new GingerbreadAnimatorCompatProvider()) {
      return;
    }
  }
  
  public static void clearInterpolator(View paramView)
  {
    IMPL.clearInterpolator(paramView);
  }
  
  public static ValueAnimatorCompat emptyValueAnimator()
  {
    return IMPL.emptyValueAnimator();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\animation\AnimatorCompatHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */