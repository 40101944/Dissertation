package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.view.View;

public class ActivityOptionsCompat
{
  public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
  public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";
  
  public static ActivityOptionsCompat makeBasic()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24) {
      localObject = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeBasic());
    }
    for (;;)
    {
      return (ActivityOptionsCompat)localObject;
      if (Build.VERSION.SDK_INT >= 23) {
        localObject = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeBasic());
      } else {
        localObject = new ActivityOptionsCompat();
      }
    }
  }
  
  public static ActivityOptionsCompat makeClipRevealAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramView = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    for (;;)
    {
      return paramView;
      if (Build.VERSION.SDK_INT >= 23) {
        paramView = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeClipRevealAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
      } else {
        paramView = new ActivityOptionsCompat();
      }
    }
  }
  
  public static ActivityOptionsCompat makeCustomAnimation(Context paramContext, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramContext = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeCustomAnimation(paramContext, paramInt1, paramInt2));
    }
    for (;;)
    {
      return paramContext;
      if (Build.VERSION.SDK_INT >= 23) {
        paramContext = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeCustomAnimation(paramContext, paramInt1, paramInt2));
      } else if (Build.VERSION.SDK_INT >= 21) {
        paramContext = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeCustomAnimation(paramContext, paramInt1, paramInt2));
      } else if (Build.VERSION.SDK_INT >= 16) {
        paramContext = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(paramContext, paramInt1, paramInt2));
      } else {
        paramContext = new ActivityOptionsCompat();
      }
    }
  }
  
  public static ActivityOptionsCompat makeScaleUpAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramView = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    for (;;)
    {
      return paramView;
      if (Build.VERSION.SDK_INT >= 23) {
        paramView = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
      } else if (Build.VERSION.SDK_INT >= 21) {
        paramView = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
      } else if (Build.VERSION.SDK_INT >= 16) {
        paramView = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
      } else {
        paramView = new ActivityOptionsCompat();
      }
    }
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramActivity = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
    }
    for (;;)
    {
      return paramActivity;
      if (Build.VERSION.SDK_INT >= 23) {
        paramActivity = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
      } else if (Build.VERSION.SDK_INT >= 21) {
        paramActivity = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
      } else {
        paramActivity = new ActivityOptionsCompat();
      }
    }
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, Pair<View, String>... paramVarArgs)
  {
    Object localObject2;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject2 = null;
      localObject1 = null;
      if (paramVarArgs != null)
      {
        View[] arrayOfView = new View[paramVarArgs.length];
        String[] arrayOfString = new String[paramVarArgs.length];
        for (int i = 0;; i++)
        {
          localObject1 = arrayOfString;
          localObject2 = arrayOfView;
          if (i >= paramVarArgs.length) {
            break;
          }
          arrayOfView[i] = ((View)paramVarArgs[i].first);
          arrayOfString[i] = ((String)paramVarArgs[i].second);
        }
      }
      if (Build.VERSION.SDK_INT >= 24) {
        paramActivity = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeSceneTransitionAnimation(paramActivity, (View[])localObject2, (String[])localObject1));
      }
    }
    for (;;)
    {
      return paramActivity;
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramActivity = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeSceneTransitionAnimation(paramActivity, (View[])localObject2, (String[])localObject1));
      }
      else
      {
        paramActivity = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, (View[])localObject2, (String[])localObject1));
        continue;
        paramActivity = new ActivityOptionsCompat();
      }
    }
  }
  
  public static ActivityOptionsCompat makeTaskLaunchBehind()
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24) {
      localObject = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeTaskLaunchBehind());
    }
    for (;;)
    {
      return (ActivityOptionsCompat)localObject;
      if (Build.VERSION.SDK_INT >= 23) {
        localObject = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeTaskLaunchBehind());
      } else if (Build.VERSION.SDK_INT >= 21) {
        localObject = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeTaskLaunchBehind());
      } else {
        localObject = new ActivityOptionsCompat();
      }
    }
  }
  
  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View paramView, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramView = new ActivityOptionsImpl24(ActivityOptionsCompat24.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
    }
    for (;;)
    {
      return paramView;
      if (Build.VERSION.SDK_INT >= 23) {
        paramView = new ActivityOptionsImpl23(ActivityOptionsCompat23.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
      } else if (Build.VERSION.SDK_INT >= 21) {
        paramView = new ActivityOptionsImpl21(ActivityOptionsCompat21.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
      } else if (Build.VERSION.SDK_INT >= 16) {
        paramView = new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
      } else {
        paramView = new ActivityOptionsCompat();
      }
    }
  }
  
  @Nullable
  public Rect getLaunchBounds()
  {
    return null;
  }
  
  public void requestUsageTimeReport(PendingIntent paramPendingIntent) {}
  
  public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect)
  {
    return null;
  }
  
  public Bundle toBundle()
  {
    return null;
  }
  
  public void update(ActivityOptionsCompat paramActivityOptionsCompat) {}
  
  private static class ActivityOptionsImpl21
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompat21 mImpl;
    
    ActivityOptionsImpl21(ActivityOptionsCompat21 paramActivityOptionsCompat21)
    {
      this.mImpl = paramActivityOptionsCompat21;
    }
    
    public Bundle toBundle()
    {
      return this.mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImpl21))
      {
        paramActivityOptionsCompat = (ActivityOptionsImpl21)paramActivityOptionsCompat;
        this.mImpl.update(paramActivityOptionsCompat.mImpl);
      }
    }
  }
  
  private static class ActivityOptionsImpl23
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompat23 mImpl;
    
    ActivityOptionsImpl23(ActivityOptionsCompat23 paramActivityOptionsCompat23)
    {
      this.mImpl = paramActivityOptionsCompat23;
    }
    
    public void requestUsageTimeReport(PendingIntent paramPendingIntent)
    {
      this.mImpl.requestUsageTimeReport(paramPendingIntent);
    }
    
    public Bundle toBundle()
    {
      return this.mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImpl23))
      {
        paramActivityOptionsCompat = (ActivityOptionsImpl23)paramActivityOptionsCompat;
        this.mImpl.update(paramActivityOptionsCompat.mImpl);
      }
    }
  }
  
  private static class ActivityOptionsImpl24
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompat24 mImpl;
    
    ActivityOptionsImpl24(ActivityOptionsCompat24 paramActivityOptionsCompat24)
    {
      this.mImpl = paramActivityOptionsCompat24;
    }
    
    public Rect getLaunchBounds()
    {
      return this.mImpl.getLaunchBounds();
    }
    
    public void requestUsageTimeReport(PendingIntent paramPendingIntent)
    {
      this.mImpl.requestUsageTimeReport(paramPendingIntent);
    }
    
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect paramRect)
    {
      return new ActivityOptionsImpl24(this.mImpl.setLaunchBounds(paramRect));
    }
    
    public Bundle toBundle()
    {
      return this.mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImpl24))
      {
        paramActivityOptionsCompat = (ActivityOptionsImpl24)paramActivityOptionsCompat;
        this.mImpl.update(paramActivityOptionsCompat.mImpl);
      }
    }
  }
  
  private static class ActivityOptionsImplJB
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompatJB mImpl;
    
    ActivityOptionsImplJB(ActivityOptionsCompatJB paramActivityOptionsCompatJB)
    {
      this.mImpl = paramActivityOptionsCompatJB;
    }
    
    public Bundle toBundle()
    {
      return this.mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImplJB))
      {
        paramActivityOptionsCompat = (ActivityOptionsImplJB)paramActivityOptionsCompat;
        this.mImpl.update(paramActivityOptionsCompat.mImpl);
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\app\ActivityOptionsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */