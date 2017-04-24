package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzafu.zza;
import com.google.android.gms.internal.zzafv;
import com.google.android.gms.internal.zzafw.zzc;
import com.google.android.gms.internal.zzai.zzf;
import com.google.android.gms.internal.zzai.zzj;
import com.google.android.gms.internal.zzqq;

public class zzp
  extends zzqq<ContainerHolder>
{
  private final String aDY;
  private long aEd;
  private final TagManager aEk;
  private final zzd aEn;
  private final zzcl aEo;
  private final int aEp;
  private final zzq aEq;
  private zzf aEr;
  private zzafv aEs;
  private volatile zzo aEt;
  private volatile boolean aEu;
  private zzai.zzj aEv;
  private String aEw;
  private zze aEx;
  private zza aEy;
  private final Context mContext;
  private final Looper zzajy;
  private final zze zzaql;
  
  zzp(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzf paramzzf, zze paramzze, zzafv paramzzafv, zze paramzze1, zzcl paramzzcl, zzq paramzzq) {}
  
  public zzp(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzt paramzzt)
  {
    this(paramContext, paramTagManager, paramLooper, paramString, paramInt, new zzcv(paramContext, paramString), new zzcu(paramContext, paramString, paramzzt), new zzafv(paramContext), zzh.zzayl(), new zzbm(1, 5, 900000L, 5000L, "refreshing", zzh.zzayl()), new zzq(paramContext, paramString));
    this.aEs.zzqy(paramzzt.zzcep());
  }
  
  private void zza(zzai.zzj paramzzj)
  {
    try
    {
      if (this.aEr != null)
      {
        zzafu.zza localzza = new com/google/android/gms/internal/zzafu$zza;
        localzza.<init>();
        localzza.aMu = this.aEd;
        zzai.zzf localzzf = new com/google/android/gms/internal/zzai$zzf;
        localzzf.<init>();
        localzza.zzxv = localzzf;
        localzza.aMv = paramzzj;
        this.aEr.zzb(localzza);
      }
      return;
    }
    finally
    {
      paramzzj = finally;
      throw paramzzj;
    }
  }
  
  private void zza(zzai.zzj paramzzj, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBoolean = this.aEu;
        if (isReady())
        {
          localObject = this.aEt;
          if (localObject == null) {
            return;
          }
        }
        this.aEv = paramzzj;
        this.aEd = paramLong;
        long l = this.aEq.zzcek();
        zzbt(Math.max(0L, Math.min(l, this.aEd + l - this.zzaql.currentTimeMillis())));
        Object localObject = new com/google/android/gms/tagmanager/Container;
        ((Container)localObject).<init>(this.mContext, this.aEk.getDataLayer(), this.aDY, paramLong, paramzzj);
        if (this.aEt == null)
        {
          paramzzj = new com/google/android/gms/tagmanager/zzo;
          paramzzj.<init>(this.aEk, this.zzajy, (Container)localObject, this.aEn);
          this.aEt = paramzzj;
          if ((!isReady()) && (this.aEy.zzb((Container)localObject))) {
            zzc(this.aEt);
          }
        }
        else
        {
          this.aEt.zza((Container)localObject);
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private void zzbt(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/google/android/gms/tagmanager/zzp:aEx	Lcom/google/android/gms/tagmanager/zzp$zze;
    //   6: ifnonnull +12 -> 18
    //   9: ldc_w 264
    //   12: invokestatic 269	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 89	com/google/android/gms/tagmanager/zzp:aEx	Lcom/google/android/gms/tagmanager/zzp$zze;
    //   22: lload_1
    //   23: aload_0
    //   24: getfield 103	com/google/android/gms/tagmanager/zzp:aEv	Lcom/google/android/gms/internal/zzai$zzj;
    //   27: getfield 272	com/google/android/gms/internal/zzai$zzj:zzxw	Ljava/lang/String;
    //   30: invokeinterface 275 4 0
    //   35: goto -20 -> 15
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	zzp
    //   0	43	1	paramLong	long
    //   38	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	38	finally
    //   18	35	38	finally
  }
  
  private boolean zzceg()
  {
    zzcj localzzcj = zzcj.zzcfz();
    if (((localzzcj.zzcga() == zzcj.zza.aGq) || (localzzcj.zzcga() == zzcj.zza.aGr)) && (this.aDY.equals(localzzcj.getContainerId()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void zzcm(final boolean paramBoolean)
  {
    this.aEr.zza(new zzb(null));
    this.aEx.zza(new zzc(null));
    zzafw.zzc localzzc = this.aEr.zzzz(this.aEp);
    if (localzzc != null) {
      this.aEt = new zzo(this.aEk, this.zzajy, new Container(this.mContext, this.aEk.getDataLayer(), this.aDY, 0L, localzzc), this.aEn);
    }
    this.aEy = new zza()
    {
      private Long aEA;
      
      private long zzceh()
      {
        if (this.aEA == null) {
          this.aEA = Long.valueOf(zzp.zzc(zzp.this).zzcek());
        }
        return this.aEA.longValue();
      }
      
      public boolean zzb(Container paramAnonymousContainer)
      {
        boolean bool = true;
        if (paramBoolean) {
          if (paramAnonymousContainer.getLastRefreshTime() + zzceh() < zzp.zzd(zzp.this).currentTimeMillis()) {}
        }
        for (;;)
        {
          return bool;
          bool = false;
          continue;
          if (paramAnonymousContainer.isDefault()) {
            bool = false;
          }
        }
      }
    };
    if (zzceg()) {
      this.aEx.zzf(0L, "");
    }
    for (;;)
    {
      return;
      this.aEr.zzcej();
    }
  }
  
  String zzcea()
  {
    try
    {
      String str = this.aEw;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void zzced()
  {
    Object localObject = this.aEr.zzzz(this.aEp);
    if (localObject != null)
    {
      localObject = new Container(this.mContext, this.aEk.getDataLayer(), this.aDY, 0L, (zzafw.zzc)localObject);
      zzc(new zzo(this.aEk, this.zzajy, (Container)localObject, new zzo.zza()
      {
        public String zzcea()
        {
          return zzp.this.zzcea();
        }
        
        public void zzcec()
        {
          zzbo.zzdi("Refresh ignored: container loaded as default only.");
        }
        
        public void zzox(String paramAnonymousString)
        {
          zzp.this.zzox(paramAnonymousString);
        }
      }));
    }
    for (;;)
    {
      this.aEx = null;
      this.aEr = null;
      return;
      zzbo.e("Default was requested, but no default container was found");
      zzc(zzel(new Status(10, "Default was requested, but no default container was found", null)));
    }
  }
  
  public void zzcee()
  {
    zzcm(false);
  }
  
  public void zzcef()
  {
    zzcm(true);
  }
  
  protected ContainerHolder zzel(Status paramStatus)
  {
    if (this.aEt != null) {}
    for (paramStatus = this.aEt;; paramStatus = new zzo(paramStatus))
    {
      return paramStatus;
      if (paramStatus == Status.yc) {
        zzbo.e("timer expired: setting result to failure");
      }
    }
  }
  
  void zzox(String paramString)
  {
    try
    {
      this.aEw = paramString;
      if (this.aEx != null) {
        this.aEx.zzpa(paramString);
      }
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
    public abstract boolean zzb(Container paramContainer);
  }
  
  private class zzb
    implements zzbn<zzafu.zza>
  {
    private zzb() {}
    
    public void zza(zzafu.zza paramzza)
    {
      zzai.zzj localzzj;
      if (paramzza.aMv != null) {
        localzzj = paramzza.aMv;
      }
      for (;;)
      {
        zzp.zza(zzp.this, localzzj, paramzza.aMu, true);
        return;
        zzai.zzf localzzf = paramzza.zzxv;
        localzzj = new zzai.zzj();
        localzzj.zzxv = localzzf;
        localzzj.zzxu = null;
        localzzj.zzxw = localzzf.version;
      }
    }
    
    public void zza(zzbn.zza paramzza)
    {
      if (!zzp.zze(zzp.this)) {
        zzp.zza(zzp.this, 0L);
      }
    }
    
    public void zzcei() {}
  }
  
  private class zzc
    implements zzbn<zzai.zzj>
  {
    private zzc() {}
    
    public void zza(zzbn.zza paramzza)
    {
      if (paramzza == zzbn.zza.aFR) {
        zzp.zzc(zzp.this).zzcem();
      }
      synchronized (zzp.this)
      {
        if (!zzp.this.isReady())
        {
          if (zzp.zzb(zzp.this) != null) {
            zzp.this.zzc(zzp.zzb(zzp.this));
          }
        }
        else
        {
          long l = zzp.zzc(zzp.this).zzcel();
          zzp.zza(zzp.this, l);
          return;
        }
        zzp.this.zzc(zzp.this.zzel(Status.yc));
      }
    }
    
    public void zzb(zzai.zzj paramzzj)
    {
      zzp.zzc(zzp.this).zzcen();
      synchronized (zzp.this)
      {
        if (paramzzj.zzxv == null)
        {
          if (zzp.zzf(zzp.this).zzxv == null)
          {
            zzbo.e("Current resource is null; network resource is also null");
            l = zzp.zzc(zzp.this).zzcel();
            zzp.zza(zzp.this, l);
            return;
          }
          paramzzj.zzxv = zzp.zzf(zzp.this).zzxv;
        }
        zzp.zza(zzp.this, paramzzj, zzp.zzd(zzp.this).currentTimeMillis(), false);
        long l = zzp.zzg(zzp.this);
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(58);
        zzbo.v("setting refresh time to current time: " + l);
        if (!zzp.zzh(zzp.this)) {
          zzp.zza(zzp.this, paramzzj);
        }
      }
    }
    
    public void zzcei() {}
  }
  
  private class zzd
    implements zzo.zza
  {
    private zzd() {}
    
    public String zzcea()
    {
      return zzp.this.zzcea();
    }
    
    public void zzcec()
    {
      if (zzp.zza(zzp.this).zzagf()) {
        zzp.zza(zzp.this, 0L);
      }
    }
    
    public void zzox(String paramString)
    {
      zzp.this.zzox(paramString);
    }
  }
  
  static abstract interface zze
    extends Releasable
  {
    public abstract void zza(zzbn<zzai.zzj> paramzzbn);
    
    public abstract void zzf(long paramLong, String paramString);
    
    public abstract void zzpa(String paramString);
  }
  
  static abstract interface zzf
    extends Releasable
  {
    public abstract void zza(zzbn<zzafu.zza> paramzzbn);
    
    public abstract void zzb(zzafu.zza paramzza);
    
    public abstract void zzcej();
    
    public abstract zzafw.zzc zzzz(int paramInt);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */