package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzb<TResult, TContinuationResult>
  implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult>
{
  private final Executor aEQ;
  private final Continuation<TResult, Task<TContinuationResult>> aMF;
  private final zzh<TContinuationResult> aMG;
  
  public zzb(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation, @NonNull zzh<TContinuationResult> paramzzh)
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
          Task localTask = (Task)zzb.zza(zzb.this).then(paramTask);
          if (localTask == null)
          {
            zzb.this.onFailure(new NullPointerException("Continuation returned null"));
            return;
          }
        }
        catch (RuntimeExecutionException localRuntimeExecutionException)
        {
          for (;;)
          {
            if ((localRuntimeExecutionException.getCause() instanceof Exception)) {
              zzb.zzb(zzb.this).setException((Exception)localRuntimeExecutionException.getCause());
            } else {
              zzb.zzb(zzb.this).setException(localRuntimeExecutionException);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            zzb.zzb(zzb.this).setException(localException);
            continue;
            localException.addOnSuccessListener(TaskExecutors.aMT, zzb.this);
            localException.addOnFailureListener(TaskExecutors.aMT, zzb.this);
          }
        }
      }
    });
  }
  
  public void onFailure(@NonNull Exception paramException)
  {
    this.aMG.setException(paramException);
  }
  
  public void onSuccess(TContinuationResult paramTContinuationResult)
  {
    this.aMG.setResult(paramTContinuationResult);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tasks\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */