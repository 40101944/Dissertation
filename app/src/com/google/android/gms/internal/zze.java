package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zze
  implements zzn
{
  private final Executor zzr;
  
  public zze(final Handler paramHandler)
  {
    this.zzr = new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }
  
  public void zza(zzk<?> paramzzk, zzm<?> paramzzm)
  {
    zza(paramzzk, paramzzm, null);
  }
  
  public void zza(zzk<?> paramzzk, zzm<?> paramzzm, Runnable paramRunnable)
  {
    paramzzk.zzt();
    paramzzk.zzc("post-response");
    this.zzr.execute(new zza(paramzzk, paramzzm, paramRunnable));
  }
  
  public void zza(zzk<?> paramzzk, zzr paramzzr)
  {
    paramzzk.zzc("post-error");
    paramzzr = zzm.zzd(paramzzr);
    this.zzr.execute(new zza(paramzzk, paramzzr, null));
  }
  
  private class zza
    implements Runnable
  {
    private final zzk zzu;
    private final zzm zzv;
    private final Runnable zzw;
    
    public zza(zzk paramzzk, zzm paramzzm, Runnable paramRunnable)
    {
      this.zzu = paramzzk;
      this.zzv = paramzzm;
      this.zzw = paramRunnable;
    }
    
    public void run()
    {
      if (this.zzu.isCanceled()) {
        this.zzu.zzd("canceled-at-delivery");
      }
      label44:
      label99:
      label109:
      for (;;)
      {
        return;
        if (this.zzv.isSuccess())
        {
          this.zzu.zza(this.zzv.result);
          if (!this.zzv.zzbh) {
            break label99;
          }
          this.zzu.zzc("intermediate-response");
        }
        for (;;)
        {
          if (this.zzw == null) {
            break label109;
          }
          this.zzw.run();
          break;
          this.zzu.zzc(this.zzv.zzbg);
          break label44;
          this.zzu.zzd("done");
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */