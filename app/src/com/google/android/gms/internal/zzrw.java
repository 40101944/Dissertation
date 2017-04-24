package com.google.android.gms.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzrw<A extends Api.zzb>
{
  private final zzrr<?> Bt;
  
  protected abstract void zza(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource)
    throws DeadObjectException;
  
  public zzrr.zzb<?> zzatz()
  {
    return this.Bt.zzatz();
  }
  
  public void zzaua()
  {
    this.Bt.clear();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzrw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */