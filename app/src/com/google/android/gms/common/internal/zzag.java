package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzg;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzag<T extends IInterface>
  extends zzj<T>
{
  private final Api.zzg<T> EO;
  
  public zzag(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf, Api.zzg<T> paramzzg)
  {
    super(paramContext, paramLooper, paramInt, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.EO = paramzzg;
  }
  
  public Api.zzg<T> zzawt()
  {
    return this.EO;
  }
  
  protected void zzc(int paramInt, T paramT)
  {
    this.EO.zza(paramInt, paramT);
  }
  
  protected T zzh(IBinder paramIBinder)
  {
    return this.EO.zzh(paramIBinder);
  }
  
  protected String zzjx()
  {
    return this.EO.zzjx();
  }
  
  protected String zzjy()
  {
    return this.EO.zzjy();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */