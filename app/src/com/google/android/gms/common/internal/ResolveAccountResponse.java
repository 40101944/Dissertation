package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountResponse
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzac();
  IBinder Df;
  private ConnectionResult EJ;
  private boolean EK;
  final int mVersionCode;
  private boolean zN;
  
  ResolveAccountResponse(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.Df = paramIBinder;
    this.EJ = paramConnectionResult;
    this.zN = paramBoolean1;
    this.EK = paramBoolean2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof ResolveAccountResponse))
      {
        bool = false;
      }
      else
      {
        paramObject = (ResolveAccountResponse)paramObject;
        if ((!this.EJ.equals(((ResolveAccountResponse)paramObject).EJ)) || (!zzawm().equals(((ResolveAccountResponse)paramObject).zzawm()))) {
          bool = false;
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzac.zza(this, paramParcel, paramInt);
  }
  
  public zzp zzawm()
  {
    return zzp.zza.zzdr(this.Df);
  }
  
  public ConnectionResult zzawn()
  {
    return this.EJ;
  }
  
  public boolean zzawo()
  {
    return this.zN;
  }
  
  public boolean zzawp()
  {
    return this.EK;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\ResolveAccountResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */