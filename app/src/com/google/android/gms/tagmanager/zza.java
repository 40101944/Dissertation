package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.io.IOException;

public class zza
{
  private static Object aDL = new Object();
  private static zza aDM;
  private volatile long aDF = 900000L;
  private volatile long aDG = 30000L;
  private volatile long aDH;
  private volatile long aDI;
  private final Object aDJ = new Object();
  private zza aDK = new zza()
  {
    public AdvertisingIdClient.Info zzcdt()
    {
      Object localObject = null;
      try
      {
        AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza.zza(zza.this));
        localObject = localInfo;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          zzbo.zzc("IllegalStateException getting Advertising Id Info", localIllegalStateException);
        }
      }
      catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
      {
        for (;;)
        {
          zzbo.zzc("GooglePlayServicesRepairableException getting Advertising Id Info", localGooglePlayServicesRepairableException);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          zzbo.zzc("IOException getting Ad Id Info", localIOException);
        }
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
      {
        for (;;)
        {
          zzbo.zzc("GooglePlayServicesNotAvailableException getting Advertising Id Info", localGooglePlayServicesNotAvailableException);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          zzbo.zzc("Unknown exception. Could not get the Advertising Id Info.", localException);
        }
      }
      return (AdvertisingIdClient.Info)localObject;
    }
  };
  private volatile AdvertisingIdClient.Info cD;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final zze zzaql;
  private final Thread zzcur;
  
  private zza(Context paramContext)
  {
    this(paramContext, null, zzh.zzayl());
  }
  
  public zza(Context paramContext, zza paramzza, zze paramzze)
  {
    this.zzaql = paramzze;
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      if (paramzza != null) {
        this.aDK = paramzza;
      }
      this.aDH = this.zzaql.currentTimeMillis();
      this.zzcur = new Thread(new Runnable()
      {
        public void run()
        {
          zza.zzb(zza.this);
        }
      });
      return;
    }
  }
  
  /* Error */
  private void zzcdp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 105	com/google/android/gms/tagmanager/zza:zzcdq	()V
    //   6: aload_0
    //   7: ldc2_w 106
    //   10: invokevirtual 111	java/lang/Object:wait	(J)V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    //   21: astore_1
    //   22: goto -9 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	zza
    //   16	4	1	localObject	Object
    //   21	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
    //   13	15	16	finally
    //   17	19	16	finally
    //   2	13	21	java/lang/InterruptedException
  }
  
  private void zzcdq()
  {
    if (this.zzaql.currentTimeMillis() - this.aDH > this.aDG) {}
    synchronized (this.aDJ)
    {
      this.aDJ.notify();
      this.aDH = this.zzaql.currentTimeMillis();
      return;
    }
  }
  
  private void zzcdr()
  {
    if (this.zzaql.currentTimeMillis() - this.aDI > 3600000L) {
      this.cD = null;
    }
  }
  
  private void zzcds()
  {
    Process.setThreadPriority(10);
    while (!this.mClosed)
    {
      ??? = this.aDK.zzcdt();
      if (??? != null)
      {
        this.cD = ((AdvertisingIdClient.Info)???);
        this.aDI = this.zzaql.currentTimeMillis();
        zzbo.zzdh("Obtained fresh AdvertisingId info from GmsCore.");
      }
      try
      {
        notifyAll();
        try
        {
          synchronized (this.aDJ)
          {
            this.aDJ.wait(this.aDF);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          zzbo.zzdh("sleep interrupted in AdvertiserDataPoller thread; continuing");
        }
        return;
      }
      finally {}
    }
  }
  
  public static zza zzdw(Context paramContext)
  {
    if (aDM == null) {}
    synchronized (aDL)
    {
      if (aDM == null)
      {
        zza localzza = new com/google/android/gms/tagmanager/zza;
        localzza.<init>(paramContext);
        aDM = localzza;
        aDM.start();
      }
      return aDM;
    }
  }
  
  public boolean isLimitAdTrackingEnabled()
  {
    if (this.cD == null)
    {
      zzcdp();
      zzcdr();
      if (this.cD != null) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = this.cD.isLimitAdTrackingEnabled())
    {
      return bool;
      zzcdq();
      break;
    }
  }
  
  public void start()
  {
    this.zzcur.start();
  }
  
  public String zzcdo()
  {
    if (this.cD == null)
    {
      zzcdp();
      zzcdr();
      if (this.cD != null) {
        break label33;
      }
    }
    label33:
    for (String str = null;; str = this.cD.getId())
    {
      return str;
      zzcdq();
      break;
    }
  }
  
  public static abstract interface zza
  {
    public abstract AdvertisingIdClient.Info zzcdt();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */