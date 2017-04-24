package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzxr;

public class CampaignTrackingReceiver
  extends BroadcastReceiver
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
      bool = zzao.zza(paramContext, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
      ay = Boolean.valueOf(bool);
    }
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onReceive(Context paramContext, Intent arg2)
  {
    Object localObject2 = zzf.zzaw(paramContext);
    localzzaf = ((zzf)localObject2).zzaca();
    if (??? == null) {
      localzzaf.zzev("CampaignTrackingReceiver received null intent");
    }
    for (;;)
    {
      return;
      Object localObject1 = ???.getStringExtra("referrer");
      ??? = ???.getAction();
      localzzaf.zza("CampaignTrackingReceiver received", ???);
      if ((!"com.android.vending.INSTALL_REFERRER".equals(???)) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localzzaf.zzev("CampaignTrackingReceiver received unexpected intent without referrer extra");
      }
      else
      {
        boolean bool = CampaignTrackingService.zzau(paramContext);
        if (!bool) {
          localzzaf.zzev("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzp(paramContext, (String)localObject1);
        ((zzf)localObject2).zzacb();
        ??? = zzyy();
        zzaa.zzy(???);
        localObject2 = new Intent(paramContext, ???);
        ((Intent)localObject2).putExtra("referrer", (String)localObject1);
        synchronized (zzaox)
        {
          paramContext.startService((Intent)localObject2);
          if (bool) {}
        }
      }
      try
      {
        if (ax == null)
        {
          localObject1 = new com/google/android/gms/internal/zzxr;
          ((zzxr)localObject1).<init>(paramContext, 1, "Analytics campaign WakeLock");
          ax = (zzxr)localObject1;
          ax.setReferenceCounted(false);
        }
        ax.acquire(1000L);
      }
      catch (SecurityException paramContext)
      {
        for (;;)
        {
          localzzaf.zzev("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
        }
      }
    }
  }
  
  protected void zzp(Context paramContext, String paramString) {}
  
  protected Class<? extends CampaignTrackingService> zzyy()
  {
    return CampaignTrackingService.class;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\CampaignTrackingReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */