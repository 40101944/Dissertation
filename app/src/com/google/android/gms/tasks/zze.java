package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zze<TResult>
  implements zzf<TResult>
{
  private final Executor aEQ;
  private OnSuccessListener<? super TResult> aMO;
  private final Object zzako = new Object();
  
  public zze(@NonNull Executor paramExecutor, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    this.aEQ = paramExecutor;
    this.aMO = paramOnSuccessListener;
  }
  
  public void cancel()
  {
    synchronized (this.zzako)
    {
      this.aMO = null;
      return;
    }
  }
  
  public void onComplete(@NonNull final Task<TResult> paramTask)
  {
    if (paramTask.isSuccessful()) {}
    synchronized (this.zzako)
    {
      if (this.aMO == null) {
        return;
      }
      this.aEQ.execute(new Runnable()
      {
        public void run()
        {
          synchronized (zze.zza(zze.this))
          {
            if (zze.zzb(zze.this) != null) {
              zze.zzb(zze.this).onSuccess(paramTask.getResult());
            }
            return;
          }
        }
      });
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tasks\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */