package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzse<A extends Api.zzb, TResult>
{
  protected abstract void zzb(A paramA, TaskCompletionSource<TResult> paramTaskCompletionSource)
    throws RemoteException;
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */