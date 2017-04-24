package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zza<TResult, TContinuationResult>
  implements zzf<TResult>
{
  private final Executor aEQ;
  private final Continuation<TResult, TContinuationResult> aMF;
  private final zzh<TContinuationResult> aMG;
  
  public zza(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, TContinuationResult> paramContinuation, @NonNull zzh<TContinuationResult> paramzzh)
  {
    this.aEQ = paramExecutor;
    this.aMF = paramContinuation;
    this.aMG = paramzzh;
  }
  
  public void cancel()
  {
    throw new UnsupportedOperationException();
  }
  
  public void onComplete(@NonNull final Task<TResult> paramTask)
  {
    this.aEQ.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          Object localObject = zza.zza(zza.this).then(paramTask);
          zza.zzb(zza.this).setResult(localObject);
          return;
        }
        catch (RuntimeExecutionException localRuntimeExecutionException)
        {
          for (;;)
          {
            if ((localRuntimeExecutionException.getCause() instanceof Exception)) {
              zza.zzb(zza.this).setException((Exception)localRuntimeExecutionException.getCause());
            } else {
              zza.zzb(zza.this).setException(localRuntimeExecutionException);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            zza.zzb(zza.this).setException(localException);
          }
        }
      }
    });
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tasks\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */