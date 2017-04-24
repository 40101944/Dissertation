package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzqq;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends zzqq<BatchResult>
{
  private int xp;
  private boolean xq;
  private boolean xr;
  private final PendingResult<?>[] xs;
  private final Object zzako = new Object();
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    this.xp = paramList.size();
    this.xs = new PendingResult[this.xp];
    if (paramList.isEmpty()) {
      zzc(new BatchResult(Status.xZ, this.xs));
    }
    for (;;)
    {
      return;
      for (int i = 0; i < paramList.size(); i++)
      {
        paramGoogleApiClient = (PendingResult)paramList.get(i);
        this.xs[i] = paramGoogleApiClient;
        paramGoogleApiClient.zza(new PendingResult.zza()
        {
          public void zzx(Status paramAnonymousStatus)
          {
            for (;;)
            {
              synchronized (Batch.zza(Batch.this))
              {
                if (Batch.this.isCanceled()) {
                  return;
                }
                if (paramAnonymousStatus.isCanceled())
                {
                  Batch.zza(Batch.this, true);
                  Batch.zzb(Batch.this);
                  if (Batch.zzc(Batch.this) == 0)
                  {
                    if (!Batch.zzd(Batch.this)) {
                      break;
                    }
                    Batch.zze(Batch.this);
                  }
                }
              }
              if (!paramAnonymousStatus.isSuccess()) {
                Batch.zzb(Batch.this, true);
              }
            }
            if (Batch.zzf(Batch.this))
            {
              paramAnonymousStatus = new com/google/android/gms/common/api/Status;
              paramAnonymousStatus.<init>(13);
            }
            for (;;)
            {
              Batch localBatch = Batch.this;
              BatchResult localBatchResult = new com/google/android/gms/common/api/BatchResult;
              localBatchResult.<init>(paramAnonymousStatus, Batch.zzg(Batch.this));
              localBatch.zzc(localBatchResult);
              break;
              paramAnonymousStatus = Status.xZ;
            }
          }
        });
      }
    }
  }
  
  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.xs;
    int j = arrayOfPendingResult.length;
    for (int i = 0; i < j; i++) {
      arrayOfPendingResult[i].cancel();
    }
  }
  
  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.xs);
  }
  
  public static final class Builder
  {
    private GoogleApiClient mD;
    private List<PendingResult<?>> xu = new ArrayList();
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.mD = paramGoogleApiClient;
    }
    
    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.xu.size());
      this.xu.add(paramPendingResult);
      return localBatchResultToken;
    }
    
    public Batch build()
    {
      return new Batch(this.xu, this.mD, null);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\api\Batch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */