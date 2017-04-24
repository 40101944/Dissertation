package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzaa;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final Status hv;
  private final PendingResult<?>[] xs;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.hv = paramStatus;
    this.xs = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return this.hv;
  }
  
  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (paramBatchResultToken.mId < this.xs.length) {}
    for (boolean bool = true;; bool = false)
    {
      zzaa.zzb(bool, "The result token does not belong to this batch");
      return this.xs[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\api\BatchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */