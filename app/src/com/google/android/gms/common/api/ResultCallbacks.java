package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.util.Log;

public abstract class ResultCallbacks<R extends Result>
  implements ResultCallback<R>
{
  public abstract void onFailure(@NonNull Status paramStatus);
  
  public final void onResult(@NonNull R paramR)
  {
    Status localStatus = paramR.getStatus();
    if (localStatus.isSuccess()) {
      onSuccess(paramR);
    }
    for (;;)
    {
      return;
      onFailure(localStatus);
      if ((paramR instanceof Releasable)) {
        try
        {
          ((Releasable)paramR).release();
        }
        catch (RuntimeException localRuntimeException)
        {
          paramR = String.valueOf(paramR);
          Log.w("ResultCallbacks", String.valueOf(paramR).length() + 18 + "Unable to release " + paramR, localRuntimeException);
        }
      }
    }
  }
  
  public abstract void onSuccess(@NonNull R paramR);
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\api\ResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */