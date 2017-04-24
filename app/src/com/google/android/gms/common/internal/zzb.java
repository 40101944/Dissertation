package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzd;

public class zzb
{
  @NonNull
  public static zza zzaf(@NonNull Status paramStatus)
  {
    if (paramStatus.hasResolution()) {}
    for (paramStatus = new zzd(paramStatus);; paramStatus = new zza(paramStatus)) {
      return paramStatus;
    }
  }
  
  @NonNull
  public static zza zzk(@NonNull ConnectionResult paramConnectionResult)
  {
    return zzaf(new Status(paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution()));
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */