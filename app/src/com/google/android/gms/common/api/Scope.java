package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public final class Scope
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new zzf();
  final int mVersionCode;
  private final String xY;
  
  Scope(int paramInt, String paramString)
  {
    zzaa.zzh(paramString, "scopeUri must not be null or empty");
    this.mVersionCode = paramInt;
    this.xY = paramString;
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof Scope)) {
        bool = false;
      } else {
        bool = this.xY.equals(((Scope)paramObject).xY);
      }
    }
  }
  
  public int hashCode()
  {
    return this.xY.hashCode();
  }
  
  public String toString()
  {
    return this.xY;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public String zzari()
  {
    return this.xY;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\api\Scope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */