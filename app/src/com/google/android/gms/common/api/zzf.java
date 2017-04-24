package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<Scope>
{
  static void zza(Scope paramScope, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramScope.mVersionCode);
    zzb.zza(paramParcel, 2, paramScope.zzari(), false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public Scope zzce(Parcel paramParcel)
  {
    int j = zza.zzcr(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      switch (zza.zzgu(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new Scope(i, str);
  }
  
  public Scope[] zzfq(int paramInt)
  {
    return new Scope[paramInt];
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\api\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */