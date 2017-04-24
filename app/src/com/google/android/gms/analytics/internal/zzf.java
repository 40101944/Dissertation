package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzh;

public class zzf
{
  private static volatile zzf cT;
  private final Context cU;
  private final zzr cV;
  private final zzaf cW;
  private final zzi cX;
  private final zzb cY;
  private final zzv cZ;
  private final zzap da;
  private final zzai db;
  private final GoogleAnalytics dc;
  private final zzn dd;
  private final zza de;
  private final zzk df;
  private final zzu dg;
  private final Context mContext;
  private final com.google.android.gms.common.util.zze zzaql;
  
  protected zzf(zzg paramzzg)
  {
    Object localObject1 = paramzzg.getApplicationContext();
    zzaa.zzb(localObject1, "Application context can't be null");
    Object localObject2 = paramzzg.zzacl();
    zzaa.zzy(localObject2);
    this.mContext = ((Context)localObject1);
    this.cU = ((Context)localObject2);
    this.zzaql = paramzzg.zzh(this);
    this.cV = paramzzg.zzg(this);
    localObject2 = paramzzg.zzf(this);
    ((zzaf)localObject2).initialize();
    this.cW = ((zzaf)localObject2);
    zzacb();
    localObject2 = zzaca();
    Object localObject3 = zze.VERSION;
    ((zzaf)localObject2).zzeu(String.valueOf(localObject3).length() + 134 + "Google Analytics " + (String)localObject3 + " is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
    localObject2 = paramzzg.zzq(this);
    ((zzai)localObject2).initialize();
    this.db = ((zzai)localObject2);
    localObject2 = paramzzg.zze(this);
    ((zzap)localObject2).initialize();
    this.da = ((zzap)localObject2);
    localObject2 = paramzzg.zzl(this);
    localObject3 = paramzzg.zzd(this);
    zza localzza = paramzzg.zzc(this);
    zzk localzzk = paramzzg.zzb(this);
    zzu localzzu = paramzzg.zza(this);
    localObject1 = paramzzg.zzax((Context)localObject1);
    ((zzi)localObject1).zza(zzack());
    this.cX = ((zzi)localObject1);
    localObject1 = paramzzg.zzi(this);
    ((zzn)localObject3).initialize();
    this.dd = ((zzn)localObject3);
    localzza.initialize();
    this.de = localzza;
    localzzk.initialize();
    this.df = localzzk;
    localzzu.initialize();
    this.dg = localzzu;
    paramzzg = paramzzg.zzp(this);
    paramzzg.initialize();
    this.cZ = paramzzg;
    ((zzb)localObject2).initialize();
    this.cY = ((zzb)localObject2);
    zzacb();
    ((GoogleAnalytics)localObject1).initialize();
    this.dc = ((GoogleAnalytics)localObject1);
    ((zzb)localObject2).start();
  }
  
  private void zza(zzd paramzzd)
  {
    zzaa.zzb(paramzzd, "Analytics service not created/initialized");
    zzaa.zzb(paramzzd.isInitialized(), "Analytics service not initialized");
  }
  
  public static zzf zzaw(Context paramContext)
  {
    zzaa.zzy(paramContext);
    if (cT == null) {}
    try
    {
      if (cT == null)
      {
        com.google.android.gms.common.util.zze localzze = zzh.zzayl();
        long l1 = localzze.elapsedRealtime();
        zzg localzzg = new com/google/android/gms/analytics/internal/zzg;
        localzzg.<init>(paramContext);
        paramContext = new com/google/android/gms/analytics/internal/zzf;
        paramContext.<init>(localzzg);
        cT = paramContext;
        GoogleAnalytics.zzzd();
        long l2 = localzze.elapsedRealtime() - l1;
        l1 = ((Long)zzy.fb.get()).longValue();
        if (l2 > l1) {
          paramContext.zzaca().zzc("Slow initialization (ms)", Long.valueOf(l2), Long.valueOf(l1));
        }
      }
      return cT;
    }
    finally {}
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public com.google.android.gms.common.util.zze zzabz()
  {
    return this.zzaql;
  }
  
  public zzaf zzaca()
  {
    zza(this.cW);
    return this.cW;
  }
  
  public zzr zzacb()
  {
    return this.cV;
  }
  
  public zzi zzacc()
  {
    zzaa.zzy(this.cX);
    return this.cX;
  }
  
  public zzv zzacd()
  {
    zza(this.cZ);
    return this.cZ;
  }
  
  public zzai zzace()
  {
    zza(this.db);
    return this.db;
  }
  
  public zzk zzach()
  {
    zza(this.df);
    return this.df;
  }
  
  public zzu zzaci()
  {
    return this.dg;
  }
  
  protected Thread.UncaughtExceptionHandler zzack()
  {
    new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        paramAnonymousThread = zzf.this.zzacm();
        if (paramAnonymousThread != null) {
          paramAnonymousThread.zze("Job execution failed", paramAnonymousThrowable);
        }
      }
    };
  }
  
  public Context zzacl()
  {
    return this.cU;
  }
  
  public zzaf zzacm()
  {
    return this.cW;
  }
  
  public GoogleAnalytics zzacn()
  {
    zzaa.zzy(this.dc);
    zzaa.zzb(this.dc.isInitialized(), "Analytics instance not initialized");
    return this.dc;
  }
  
  public zzai zzaco()
  {
    if ((this.db == null) || (!this.db.isInitialized())) {}
    for (zzai localzzai = null;; localzzai = this.db) {
      return localzzai;
    }
  }
  
  public zza zzacp()
  {
    zza(this.de);
    return this.de;
  }
  
  public zzn zzacq()
  {
    zza(this.dd);
    return this.dd;
  }
  
  public zzb zzzg()
  {
    zza(this.cY);
    return this.cY;
  }
  
  public zzap zzzh()
  {
    zza(this.da);
    return this.da;
  }
  
  public void zzzx() {}
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */