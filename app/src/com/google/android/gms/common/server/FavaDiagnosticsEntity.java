package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class FavaDiagnosticsEntity
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zza();
  public final String EY;
  public final int EZ;
  final int mVersionCode;
  
  public FavaDiagnosticsEntity(int paramInt1, String paramString, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.EY = paramString;
    this.EZ = paramInt2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\server\FavaDiagnosticsEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */