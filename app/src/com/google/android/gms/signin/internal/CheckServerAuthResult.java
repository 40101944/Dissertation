package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class CheckServerAuthResult
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<CheckServerAuthResult> CREATOR = new zzc();
  final boolean aDs;
  final List<Scope> aDt;
  final int mVersionCode;
  
  CheckServerAuthResult(int paramInt, boolean paramBoolean, List<Scope> paramList)
  {
    this.mVersionCode = paramInt;
    this.aDs = paramBoolean;
    this.aDt = paramList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\signin\internal\CheckServerAuthResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */