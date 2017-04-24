package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

public class TaskCompletionSource<TResult>
{
  private final zzh<TResult> aMS = new zzh();
  
  @NonNull
  public Task<TResult> getTask()
  {
    return this.aMS;
  }
  
  public void setException(@NonNull Exception paramException)
  {
    this.aMS.setException(paramException);
  }
  
  public void setResult(TResult paramTResult)
  {
    this.aMS.setResult(paramTResult);
  }
  
  public boolean trySetException(@NonNull Exception paramException)
  {
    return this.aMS.trySetException(paramException);
  }
  
  public boolean trySetResult(TResult paramTResult)
  {
    return this.aMS.trySetResult(paramTResult);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tasks\TaskCompletionSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */