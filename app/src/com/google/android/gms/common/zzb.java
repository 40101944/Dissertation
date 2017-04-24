package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<ConnectionResult>
{
  static void zza(ConnectionResult paramConnectionResult, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcs(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramConnectionResult.mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramConnectionResult.getErrorCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramConnectionResult.getResolution(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramConnectionResult.getErrorMessage(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, i);
  }
  
  public ConnectionResult zzcd(Parcel paramParcel)
  {
    Object localObject2 = null;
    int j = 0;
    int m = zza.zzcr(paramParcel);
    Object localObject1 = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = zza.zzcq(paramParcel);
      Object localObject3;
      switch (zza.zzgu(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        k = j;
        j = i;
        i = k;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        k = j;
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        j = i;
        i = k;
        break;
        k = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        i = j;
        j = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        k = zza.zzg(paramParcel, k);
        j = i;
        i = k;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (PendingIntent)zza.zza(paramParcel, k, PendingIntent.CREATOR);
        k = j;
        j = i;
        localObject1 = localObject2;
        localObject2 = localObject3;
        i = k;
        continue;
        localObject3 = zza.zzq(paramParcel, k);
        localObject2 = localObject1;
        k = i;
        localObject1 = localObject3;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new ConnectionResult(i, j, (PendingIntent)localObject1, (String)localObject2);
  }
  
  public ConnectionResult[] zzfo(int paramInt)
  {
    return new ConnectionResult[paramInt];
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */