package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public abstract interface zzr
  extends IInterface
{
  public abstract zzd zzaqn()
    throws RemoteException;
  
  public abstract int zzaqo()
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzr
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.common.internal.ICertData");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      for (;;)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.common.internal.ICertData");
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.ICertData");
        paramParcel1 = zzaqn();
        paramParcel2.writeNoException();
        if (paramParcel1 != null) {}
        for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          bool = true;
          break;
        }
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.ICertData");
        paramInt1 = zzaqo();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        bool = true;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */