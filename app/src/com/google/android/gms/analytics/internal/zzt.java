package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;

abstract class zzt
{
  private static volatile Handler ef;
  private final zzf cQ;
  private volatile long eg;
  private final Runnable zzw;
  
  zzt(zzf paramzzf)
  {
    zzaa.zzy(paramzzf);
    this.cQ = paramzzf;
    this.zzw = new Runnable()
    {
      public void run()
      {
        if (Looper.myLooper() == Looper.getMainLooper()) {
          zzt.zza(zzt.this).zzacc().zzg(this);
        }
        for (;;)
        {
          return;
          boolean bool = zzt.this.zzfy();
          zzt.zza(zzt.this, 0L);
          if ((bool) && (!zzt.zzb(zzt.this))) {
            zzt.this.run();
          }
        }
      }
    };
  }
  
  private Handler getHandler()
  {
    Handler localHandler;
    if (ef != null) {
      localHandler = ef;
    }
    for (;;)
    {
      return localHandler;
      try
      {
        if (ef == null)
        {
          localHandler = new android/os/Handler;
          localHandler.<init>(this.cQ.getContext().getMainLooper());
          ef = localHandler;
        }
        localHandler = ef;
      }
      finally {}
    }
  }
  
  public void cancel()
  {
    this.eg = 0L;
    getHandler().removeCallbacks(this.zzw);
  }
  
  public abstract void run();
  
  public long zzafk()
  {
    long l = 0L;
    if (this.eg == 0L) {}
    for (;;)
    {
      return l;
      l = Math.abs(this.cQ.zzabz().currentTimeMillis() - this.eg);
    }
  }
  
  public boolean zzfy()
  {
    if (this.eg != 0L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void zzx(long paramLong)
  {
    cancel();
    if (paramLong >= 0L)
    {
      this.eg = this.cQ.zzabz().currentTimeMillis();
      if (!getHandler().postDelayed(this.zzw, paramLong)) {
        this.cQ.zzaca().zze("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
  
  public void zzy(long paramLong)
  {
    long l = 0L;
    if (!zzfy()) {}
    for (;;)
    {
      return;
      if (paramLong >= 0L) {
        break;
      }
      cancel();
    }
    paramLong -= Math.abs(this.cQ.zzabz().currentTimeMillis() - this.eg);
    if (paramLong < 0L) {
      paramLong = l;
    }
    for (;;)
    {
      getHandler().removeCallbacks(this.zzw);
      if (getHandler().postDelayed(this.zzw, paramLong)) {
        break;
      }
      this.cQ.zzaca().zze("Failed to adjust delayed post. time", Long.valueOf(paramLong));
      break;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */