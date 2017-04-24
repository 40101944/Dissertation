package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class zzc
  extends Thread
{
  private static final boolean DEBUG = zzs.DEBUG;
  private final BlockingQueue<zzk<?>> zzg;
  private final BlockingQueue<zzk<?>> zzh;
  private final zzb zzi;
  private final zzn zzj;
  private volatile boolean zzk = false;
  
  public zzc(BlockingQueue<zzk<?>> paramBlockingQueue1, BlockingQueue<zzk<?>> paramBlockingQueue2, zzb paramzzb, zzn paramzzn)
  {
    super("VolleyCacheDispatcher");
    this.zzg = paramBlockingQueue1;
    this.zzh = paramBlockingQueue2;
    this.zzi = paramzzb;
    this.zzj = paramzzn;
  }
  
  public void quit()
  {
    this.zzk = true;
    interrupt();
  }
  
  public void run()
  {
    if (DEBUG) {
      zzs.zza("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    this.zzi.initialize();
    for (;;)
    {
      try
      {
        zzk localzzk = (zzk)this.zzg.take();
        localzzk.zzc("cache-queue-take");
        if (!localzzk.isCanceled()) {
          break label73;
        }
        localzzk.zzd("cache-discard-canceled");
        continue;
        if (!this.zzk) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException) {}
      return;
      label73:
      Object localObject2 = this.zzi.zza(localInterruptedException.zzg());
      if (localObject2 == null)
      {
        localInterruptedException.zzc("cache-miss");
        this.zzh.put(localInterruptedException);
      }
      else if (((zzb.zza)localObject2).zza())
      {
        localInterruptedException.zzc("cache-hit-expired");
        localInterruptedException.zza((zzb.zza)localObject2);
        this.zzh.put(localInterruptedException);
      }
      else
      {
        localInterruptedException.zzc("cache-hit");
        Object localObject1 = new com/google/android/gms/internal/zzi;
        ((zzi)localObject1).<init>(((zzb.zza)localObject2).data, ((zzb.zza)localObject2).zzf);
        localObject1 = localInterruptedException.zza((zzi)localObject1);
        localInterruptedException.zzc("cache-hit-parsed");
        if (!((zzb.zza)localObject2).zzb())
        {
          this.zzj.zza(localInterruptedException, (zzm)localObject1);
        }
        else
        {
          localInterruptedException.zzc("cache-hit-refresh-needed");
          localInterruptedException.zza((zzb.zza)localObject2);
          ((zzm)localObject1).zzbh = true;
          zzn localzzn = this.zzj;
          localObject2 = new com/google/android/gms/internal/zzc$1;
          ((1)localObject2).<init>(this, localInterruptedException);
          localzzn.zza(localInterruptedException, (zzm)localObject1, (Runnable)localObject2);
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */