package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzxr;

public final class zzaj
{
  static zzxr ax;
  static Boolean ay;
  static Object zzaox = new Object();
  
  public static boolean zzat(Context paramContext)
  {
    zzaa.zzy(paramContext);
    boolean bool;
    if (ay != null) {
      bool = ay.booleanValue();
    }
    for (;;)
    {
      return bool;
      bool = zzao.zza(paramContext, "com.google.android.gms.analytics.AnalyticsReceiver", false);
      ay = Boolean.valueOf(bool);
    }
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onReceive(Context paramContext, Intent arg2)
  {
    Object localObject = zzf.zzaw(paramContext);
    localzzaf = ((zzf)localObject).zzaca();
    if (??? == null) {
      localzzaf.zzev("AnalyticsReceiver called with null intent");
    }
    for (;;)
    {
      return;
      ??? = ???.getAction();
      ((zzf)localObject).zzacb();
      localzzaf.zza("Local AnalyticsReceiver got", ???);
      if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(???))
      {
        boolean bool = zzak.zzau(paramContext);
        localObject = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        ((Intent)localObject).setComponent(new ComponentName(paramContext, "com.google.android.gms.analytics.AnalyticsService"));
        ((Intent)localObject).setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        synchronized (zzaox)
        {
          paramContext.startService((Intent)localObject);
          if (bool) {}
        }
      }
      try
      {
        if (ax == null)
        {
          localObject = new com/google/android/gms/internal/zzxr;
          ((zzxr)localObject).<init>(paramContext, 1, "Analytics WakeLock");
          ax = (zzxr)localObject;
          ax.setReferenceCounted(false);
        }
        ax.acquire(1000L);
      }
      catch (SecurityException paramContext)
      {
        for (;;)
        {
          localzzaf.zzev("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */