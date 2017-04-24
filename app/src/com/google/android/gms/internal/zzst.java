package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzst
  extends IInterface
{
  public abstract void zza(zzss paramzzss)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzst
  {
    public static zzst zzeb(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        if ((localIInterface != null) && ((localIInterface instanceof zzst))) {
          paramIBinder = (zzst)localIInterface;
        } else {
          paramIBinder = new zza(paramIBinder);
        }
      }
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
        paramParcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
        zza(zzss.zza.zzea(paramParcel1.readStrongBinder()));
      }
    }
    
    private static class zza
      implements zzst
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
      
      public void zza(zzss paramzzss)
        throws RemoteException
      {
        IBinder localIBinder = null;
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
          if (paramzzss != null) {
            localIBinder = paramzzss.asBinder();
          }
          localParcel.writeStrongBinder(localIBinder);
          this.zzajq.transact(1, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */