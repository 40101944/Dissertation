package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzd<TResult>
  implements zzf<TResult>
{
  private final Executor aEQ;
  private OnFailureListener aMM;
  private final Object zzako = new Object();
  
  public zzd(@NonNull Executor paramExecutor, @NonNull OnFailureListener paramOnFailureListener)
  {
    this.aEQ = paramExecutor;
    this.aMM = paramOnFailureListener;
  }
  
  public void cancel()
  {
    synchronized (this.zzako)
    {
      this.aMM = null;
      return;
    }
  }
  
  public void onComplete(@NonNull final Task<TResult> paramTask)
  {
    if (!paramTask.isSuccessful()) {}
    synchronized (this.zzako)
    {
      if (this.aMM == null) {
        return;
      }
      this.aEQ.execute(new Runnable()
      {
        public void run()
        {
          synchronized (zzd.zza(zzd.this))
          {
            if (zzd.zzb(zzd.this) != null) {
              zzd.zzb(zzd.this).onFailure(paramTask.getException());
            }
            return;
          }
        }
      });
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tasks\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */