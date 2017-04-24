package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.zzaa;

public final class zzak
{
  private static Boolean az;
  private final zza fL;
  private final Context mContext;
  private final Handler mHandler;
  
  public zzak(zza paramzza)
  {
    this.mContext = paramzza.getContext();
    zzaa.zzy(this.mContext);
    this.fL = paramzza;
    this.mHandler = new Handler();
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
      bool = zzao.zzr(paramContext, "com.google.android.gms.analytics.AnalyticsService");
      az = Boolean.valueOf(bool);
    }
  }
  
  /* Error */
  private void zzyz()
  {
    // Byte code:
    //   0: getstatic 78	com/google/android/gms/analytics/internal/zzaj:zzaox	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: getstatic 82	com/google/android/gms/analytics/internal/zzaj:ax	Lcom/google/android/gms/internal/zzxr;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +14 -> 25
    //   14: aload_2
    //   15: invokevirtual 87	com/google/android/gms/internal/zzxr:isHeld	()Z
    //   18: ifeq +7 -> 25
    //   21: aload_2
    //   22: invokevirtual 90	com/google/android/gms/internal/zzxr:release	()V
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
    //   0	37	0	this	zzak
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
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onCreate()
  {
    zzf localzzf = zzf.zzaw(this.mContext);
    zzaf localzzaf = localzzf.zzaca();
    localzzf.zzacb();
    localzzaf.zzes("Local AnalyticsService is starting up");
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onDestroy()
  {
    zzf localzzf = zzf.zzaw(this.mContext);
    zzaf localzzaf = localzzf.zzaca();
    localzzf.zzacb();
    localzzaf.zzes("Local AnalyticsService is shutting down");
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    zzyz();
    final zzf localzzf = zzf.zzaw(this.mContext);
    final zzaf localzzaf = localzzf.zzaca();
    if (paramIntent == null) {
      localzzaf.zzev("AnalyticsService started with null intent");
    }
    for (;;)
    {
      return 2;
      paramIntent = paramIntent.getAction();
      localzzf.zzacb();
      localzzaf.zza("Local AnalyticsService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
      if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(paramIntent)) {
        localzzf.zzzg().zza(new zzw()
        {
          public void zzf(Throwable paramAnonymousThrowable)
          {
            zzak.zzb(zzak.this).post(new Runnable()
            {
              public void run()
              {
                if (zzak.zza(zzak.this).callServiceStopSelfResult(zzak.1.this.aB))
                {
                  zzak.1.this.fM.zzacb();
                  zzak.1.this.aA.zzes("Local AnalyticsService processed last dispatch request");
                }
              }
            });
          }
        });
      }
    }
  }
  
  public static abstract interface zza
  {
    public abstract boolean callServiceStopSelfResult(int paramInt);
    
    public abstract Context getContext();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */