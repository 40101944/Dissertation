package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<SignInResponse>
{
  static void zza(SignInResponse paramSignInResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramSignInResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramSignInResponse.zzawn(), paramInt, false);
    zzb.zza(paramParcel, 3, paramSignInResponse.zzcdn(), paramInt, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public SignInResponse zzsd(Parcel paramParcel)
  {
    Object localObject2 = null;
    int j = zza.zzcr(paramParcel);
    int i = 0;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      Object localObject3;
      switch (zza.zzgu(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (ConnectionResult)zza.zza(paramParcel, k, ConnectionResult.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (ResolveAccountResponse)zza.zza(paramParcel, k, ResolveAccountResponse.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new SignInResponse(i, (ConnectionResult)localObject1, (ResolveAccountResponse)localObject2);
  }
  
  public SignInResponse[] zzzy(int paramInt)
  {
    return new SignInResponse[paramInt];
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\signin\internal\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */