package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Iterator;

public final class zzc
{
  public static <T extends SafeParcelable> T zza(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator)
  {
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = zza(paramIntent, paramCreator)) {
      return paramIntent;
    }
  }
  
  public static <T extends SafeParcelable> T zza(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    zzaa.zzy(paramCreator);
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (SafeParcelable)paramCreator.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public static <T extends SafeParcelable> void zza(T paramT, Intent paramIntent, String paramString)
  {
    paramIntent.putExtra(paramString, zza(paramT));
  }
  
  public static <T extends SafeParcelable> byte[] zza(T paramT)
  {
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    paramT = localParcel.marshall();
    localParcel.recycle();
    return paramT;
  }
  
  public static <T extends SafeParcelable> ArrayList<T> zzb(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator)
  {
    paramString = (ArrayList)paramIntent.getSerializableExtra(paramString);
    if (paramString == null) {
      paramIntent = null;
    }
    for (;;)
    {
      return paramIntent;
      paramIntent = new ArrayList(paramString.size());
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        paramIntent.add(zza((byte[])paramString.next(), paramCreator));
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\safeparcel\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */