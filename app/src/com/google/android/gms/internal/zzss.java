package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzss
  extends IInterface
{
  public abstract void zzgv(int paramInt)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzss
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
    }
    
    public static zzss zzea(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
        if ((localIInterface != null) && ((localIInterface instanceof zzss))) {
          paramIBinder = (zzss)localIInterface;
        } else {
          paramIBinder = new zza(paramIBinder);
        }
      }
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool = true;
      switch (paramInt1)
      {
      default: 
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      for (;;)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.common.internal.service.ICommonCallbacks");
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
        zzgv(paramParcel1.readInt());
        paramParcel2.writeNoException();
      }
    }
    
    private static class zza
      implements zzss
    {
      private IBinder zzajq;
      
      zza(IBinder paramIBinder)
      {
        this.zzajq = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.zzajq;
      }
      
      public void zzgv(int paramInt)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonCallbacks");
          localParcel2.writeInt(paramInt);
          this.zzajq.transact(1, localParcel2, localParcel1, 0);
          localParcel1.readException();
          return;
        }
        finally
        {
          localParcel1.recycle();
          localParcel2.recycle();
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */