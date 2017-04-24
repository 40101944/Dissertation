package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Set;

public abstract class zzj<T extends IInterface>
  extends zze<T>
  implements Api.zze, zzk.zza
{
  private final Account gj;
  private final Set<Scope> jw;
  private final zzf zP;
  
  protected zzj(Context paramContext, Looper paramLooper, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, zzl.zzcc(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramzzf, (GoogleApiClient.ConnectionCallbacks)zzaa.zzy(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)zzaa.zzy(paramOnConnectionFailedListener));
  }
  
  protected zzj(Context paramContext, Looper paramLooper, zzl paramzzl, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramzzl, paramGoogleApiAvailability, paramInt, zza(paramConnectionCallbacks), zza(paramOnConnectionFailedListener), paramzzf.zzavt());
    this.zP = paramzzf;
    this.gj = paramzzf.getAccount();
    this.jw = zzb(paramzzf.zzavq());
  }
  
  @Nullable
  private static zze.zzb zza(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    if (paramConnectionCallbacks == null) {}
    for (paramConnectionCallbacks = null;; paramConnectionCallbacks = new zze.zzb()
        {
          public void onConnected(@Nullable Bundle paramAnonymousBundle)
          {
            zzj.this.onConnected(paramAnonymousBundle);
          }
          
          public void onConnectionSuspended(int paramAnonymousInt)
          {
            zzj.this.onConnectionSuspended(paramAnonymousInt);
          }
        }) {
      return paramConnectionCallbacks;
    }
  }
  
  @Nullable
  private static zze.zzc zza(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramOnConnectionFailedListener == null) {}
    for (paramOnConnectionFailedListener = null;; paramOnConnectionFailedListener = new zze.zzc()
        {
          public void onConnectionFailed(@NonNull ConnectionResult paramAnonymousConnectionResult)
          {
            zzj.this.onConnectionFailed(paramAnonymousConnectionResult);
          }
        }) {
      return paramOnConnectionFailedListener;
    }
  }
  
  private Set<Scope> zzb(@NonNull Set<Scope> paramSet)
  {
    Set localSet = zzc(paramSet);
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext()) {
      if (!paramSet.contains((Scope)localIterator.next())) {
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
    }
    return localSet;
  }
  
  public final Account getAccount()
  {
    return this.gj;
  }
  
  protected final Set<Scope> zzavi()
  {
    return this.jw;
  }
  
  protected final zzf zzawb()
  {
    return this.zP;
  }
  
  @NonNull
  protected Set<Scope> zzc(@NonNull Set<Scope> paramSet)
  {
    return paramSet;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */