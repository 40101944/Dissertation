package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<Configuration>
{
  static void zza(Configuration paramConfiguration, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramConfiguration.mVersionCode);
    zzb.zzc(paramParcel, 2, paramConfiguration.aAs);
    zzb.zza(paramParcel, 3, paramConfiguration.aAt, paramInt, false);
    zzb.zza(paramParcel, 4, paramConfiguration.aAu, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public Configuration zzrf(Parcel paramParcel)
  {
    Object localObject2 = null;
    int j = 0;
    int m = com.google.android.gms.common.internal.safeparcel.zza.zzcr(paramParcel);
    Object localObject1 = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcq(paramParcel);
      Object localObject3;
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgu(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
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
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        i = j;
        j = k;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        j = i;
        i = k;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Flag[])com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k, Flag.CREATOR);
        k = i;
        localObject1 = localObject2;
        localObject2 = localObject3;
        i = j;
        j = k;
        continue;
        localObject3 = com.google.android.gms.common.internal.safeparcel.zza.zzac(paramParcel, k);
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
    return new Configuration(i, j, (Flag[])localObject1, (String[])localObject2);
  }
  
  public Configuration[] zzyx(int paramInt)
  {
    return new Configuration[paramInt];
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\phenotype\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */