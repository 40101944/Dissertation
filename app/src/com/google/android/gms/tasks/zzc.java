package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzc<TResult>
  implements zzf<TResult>
{
  private final Executor aEQ;
  private OnCompleteListener<TResult> aMK;
  private final Object zzako = new Object();
  
  public zzc(@NonNull Executor paramExecutor, @NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.aEQ = paramExecutor;
    this.aMK = paramOnCompleteListener;
  }
  
  public void cancel()
  {
    synchronized (this.zzako)
    {
      this.aMK = null;
      return;
    }
  }
  
  public void onComplete(@NonNull final Task<TResult> paramTask)
  {
    synchronized (this.zzako)
    {
      if (this.aMK == null) {
        return;
      }
      this.aEQ.execute(new Runnable()
      {
        public void run()
        {
          synchronized (zzc.zza(zzc.this))
          {
            if (zzc.zzb(zzc.this) != null) {
              zzc.zzb(zzc.this).onComplete(paramTask);
            }
            return;
          }
        }
      });
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tasks\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */