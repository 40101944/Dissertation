package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzai.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcu
  implements zzp.zze
{
  private final String aDY;
  private String aEw;
  private zzbn<zzai.zzj> aGB;
  private zzt aGC;
  private final ScheduledExecutorService aGE;
  private final zza aGF;
  private ScheduledFuture<?> aGG;
  private boolean mClosed;
  private final Context mContext;
  
  public zzcu(Context paramContext, String paramString, zzt paramzzt)
  {
    this(paramContext, paramString, paramzzt, null, null);
  }
  
  zzcu(Context paramContext, String paramString, zzt paramzzt, zzb paramzzb, zza paramzza)
  {
    this.aGC = paramzzt;
    this.mContext = paramContext;
    this.aDY = paramString;
    paramContext = paramzzb;
    if (paramzzb == null) {
      paramContext = new zzb()
      {
        public ScheduledExecutorService zzcgg()
        {
          return Executors.newSingleThreadScheduledExecutor();
        }
      };
    }
    this.aGE = paramContext.zzcgg();
    if (paramzza == null) {}
    for (this.aGF = new zza()
        {
          public zzct zza(zzt paramAnonymouszzt)
          {
            return new zzct(zzcu.zza(zzcu.this), zzcu.zzb(zzcu.this), paramAnonymouszzt);
          }
        };; this.aGF = paramzza) {
      return;
    }
  }
  
  private void zzcgf()
  {
    try
    {
      if (this.mClosed)
      {
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        localIllegalStateException.<init>("called method after closed");
        throw localIllegalStateException;
      }
    }
    finally {}
  }
  
  private zzct zzpq(String paramString)
  {
    zzct localzzct = this.aGF.zza(this.aGC);
    localzzct.zza(this.aGB);
    localzzct.zzpa(this.aEw);
    localzzct.zzpp(paramString);
    return localzzct;
  }
  
  public void release()
  {
    try
    {
      zzcgf();
      if (this.aGG != null) {
        this.aGG.cancel(false);
      }
      this.aGE.shutdown();
      this.mClosed = true;
      return;
    }
    finally {}
  }
  
  public void zza(zzbn<zzai.zzj> paramzzbn)
  {
    try
    {
      zzcgf();
      this.aGB = paramzzbn;
      return;
    }
    finally
    {
      paramzzbn = finally;
      throw paramzzbn;
    }
  }
  
  public void zzf(long paramLong, String paramString)
  {
    try
    {
      String str = this.aDY;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>(String.valueOf(str).length() + 55);
      zzbo.v("loadAfterDelay: containerId=" + str + " delay=" + paramLong);
      zzcgf();
      if (this.aGB == null)
      {
        paramString = new java/lang/IllegalStateException;
        paramString.<init>("callback must be set before loadAfterDelay() is called.");
        throw paramString;
      }
    }
    finally {}
    if (this.aGG != null) {
      this.aGG.cancel(false);
    }
    this.aGG = this.aGE.schedule(zzpq(paramString), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void zzpa(String paramString)
  {
    try
    {
      zzcgf();
      this.aEw = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static abstract interface zza
  {
    public abstract zzct zza(zzt paramzzt);
  }
  
  static abstract interface zzb
  {
    public abstract ScheduledExecutorService zzcgg();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */