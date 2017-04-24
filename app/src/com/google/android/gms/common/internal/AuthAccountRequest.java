package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zzd();
  final IBinder Df;
  final Scope[] Dg;
  Integer Dh;
  Integer Di;
  final int mVersionCode;
  
  AuthAccountRequest(int paramInt, IBinder paramIBinder, Scope[] paramArrayOfScope, Integer paramInteger1, Integer paramInteger2)
  {
    this.mVersionCode = paramInt;
    this.Df = paramIBinder;
    this.Dg = paramArrayOfScope;
    this.Dh = paramInteger1;
    this.Di = paramInteger2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\AuthAccountRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */