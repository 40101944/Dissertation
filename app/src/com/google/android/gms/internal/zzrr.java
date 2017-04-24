package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;

public final class zzrr<L>
{
  private final zza Bl;
  private final zzb<L> Bm;
  private volatile L mListener;
  
  zzrr(@NonNull Looper paramLooper, @NonNull L paramL, @NonNull String paramString)
  {
    this.Bl = new zza(paramLooper);
    this.mListener = zzaa.zzb(paramL, "Listener must not be null");
    this.Bm = new zzb(paramL, zzaa.zzib(paramString), null);
  }
  
  public void clear()
  {
    this.mListener = null;
  }
  
  public void zza(zzc<? super L> paramzzc)
  {
    zzaa.zzb(paramzzc, "Notifier must not be null");
    paramzzc = this.Bl.obtainMessage(1, paramzzc);
    this.Bl.sendMessage(paramzzc);
  }
  
  @NonNull
  public zzb<L> zzatz()
  {
    return this.Bm;
  }
  
  void zzb(zzc<? super L> paramzzc)
  {
    Object localObject = this.mListener;
    if (localObject == null) {
      paramzzc.zzasm();
    }
    for (;;)
    {
      return;
      try
      {
        paramzzc.zzt(localObject);
      }
      catch (RuntimeException localRuntimeException)
      {
        paramzzc.zzasm();
        throw localRuntimeException;
      }
    }
  }
  
  private final class zza
    extends Handler
  {
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      if (paramMessage.what == 1) {}
      for (;;)
      {
        zzaa.zzbt(bool);
        zzrr.this.zzb((zzrr.zzc)paramMessage.obj);
        return;
        bool = false;
      }
    }
  }
  
  public static final class zzb<L>
  {
    private final String Bo;
    private final L mListener;
    
    private zzb(L paramL, String paramString)
    {
      this.mListener = paramL;
      this.Bo = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {}
      for (;;)
      {
        return bool;
        if (!(paramObject instanceof zzb))
        {
          bool = false;
        }
        else
        {
          paramObject = (zzb)paramObject;
          if ((this.mListener != ((zzb)paramObject).mListener) || (!this.Bo.equals(((zzb)paramObject).Bo))) {
            bool = false;
          }
        }
      }
    }
    
    public int hashCode()
    {
      return System.identityHashCode(this.mListener) * 31 + this.Bo.hashCode();
    }
  }
  
  public static abstract interface zzc<L>
  {
    public abstract void zzasm();
    
    public abstract void zzt(L paramL);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */