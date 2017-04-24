package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzd
  extends IInterface
{
  public static abstract class zza
    extends Binder
    implements zzd
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
    }
    
    public static zzd zzfd(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        if ((localIInterface != null) && ((localIInterface instanceof zzd))) {
          paramIBinder = (zzd)localIInterface;
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
      switch (paramInt1)
      {
      }
      for (boolean bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);; bool = true)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.dynamic.IObjectWrapper");
      }
    }
    
    private static class zza
      implements zzd
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
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\dynamic\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */