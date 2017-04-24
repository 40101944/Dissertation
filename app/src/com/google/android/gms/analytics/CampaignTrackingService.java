package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.common.internal.zzaa;

public class CampaignTrackingService
  extends Service
{
  private static Boolean az;
  private Handler mHandler;
  
  private Handler getHandler()
  {
    Handler localHandler2 = this.mHandler;
    Handler localHandler1 = localHandler2;
    if (localHandler2 == null)
    {
      localHandler1 = new Handler(getMainLooper());
      this.mHandler = localHandler1;
    }
    return localHandler1;
  }
  
  public static boolean zzau(Context paramContext)
  {
    zzaa.zzy(paramContext);
    boolean bool;
    if (az != null) {
      bool = az.booleanValue();
    }
    for (;;)
    {
      return bool;
      bool = zzao.zzr(paramContext, "com.google.android.gms.analytics.CampaignTrackingService");
      az = Boolean.valueOf(bool);
    }
  }
  
  /* Error */
  private void zzyz()
  {
    // Byte code:
    //   0: getstatic 69	com/google/android/gms/analytics/CampaignTrackingReceiver:zzaox	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: getstatic 73	com/google/android/gms/analytics/CampaignTrackingReceiver:ax	Lcom/google/android/gms/internal/zzxr;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +14 -> 25
    //   14: aload_2
    //   15: invokevirtual 78	com/google/android/gms/internal/zzxr:isHeld	()Z
    //   18: ifeq +7 -> 25
    //   21: aload_2
    //   22: invokevirtual 81	com/google/android/gms/internal/zzxr:release	()V
    //   25: aload_1
    //   26: monitorexit
    //   27: return
    //   28: astore_2
    //   29: aload_1
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    //   33: astore_1
    //   34: goto -7 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	CampaignTrackingService
    //   33	1	1	localSecurityException	SecurityException
    //   9	13	2	localzzxr	com.google.android.gms.internal.zzxr
    //   28	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	10	28	finally
    //   14	25	28	finally
    //   25	27	28	finally
    //   29	31	28	finally
    //   0	6	33	java/lang/SecurityException
    //   31	33	33	java/lang/SecurityException
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onCreate()
  {
    super.onCreate();
    zzf.zzaw(this).zzaca().zzes("CampaignTrackingService is starting up");
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onDestroy()
  {
    zzf.zzaw(this).zzaca().zzes("CampaignTrackingService is shutting down");
    super.onDestroy();
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    zzyz();
    zzf localzzf = zzf.zzaw(this);
    final zzaf localzzaf = localzzf.zzaca();
    localzzf.zzacb();
    paramIntent = paramIntent.getStringExtra("referrer");
    final Handler localHandler = getHandler();
    if (TextUtils.isEmpty(paramIntent))
    {
      localzzf.zzacb();
      localzzaf.zzev("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
      localzzf.zzacc().zzg(new Runnable()
      {
        public void run()
        {
          CampaignTrackingService.this.zza(localzzaf, localHandler, paramInt2);
        }
      });
      return 2;
    }
    paramInt1 = localzzf.zzacb().zzaei();
    if (paramIntent.length() <= paramInt1) {}
    for (;;)
    {
      localzzaf.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(paramInt2), paramIntent);
      localzzf.zzzg().zza(paramIntent, new Runnable()
      {
        public void run()
        {
          CampaignTrackingService.this.zza(localzzaf, localHandler, paramInt2);
        }
      });
      break;
      localzzaf.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(paramIntent.length()), Integer.valueOf(paramInt1));
      paramIntent = paramIntent.substring(0, paramInt1);
    }
  }
  
  protected void zza(final zzaf paramzzaf, Handler paramHandler, final int paramInt)
  {
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        boolean bool = CampaignTrackingService.this.stopSelfResult(paramInt);
        if (bool) {
          paramzzaf.zza("Install campaign broadcast processed", Boolean.valueOf(bool));
        }
      }
    });
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\CampaignTrackingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */