package com.google.android.gms.analytics.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

public abstract interface zzac
  extends IInterface
{
  public abstract String getVersion()
    throws RemoteException;
  
  public abstract void zza(Map paramMap, long paramLong, String paramString, List<Command> paramList)
    throws RemoteException;
  
  public abstract void zzabr()
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzac
  {
    public static zzac zzbm(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        if ((localIInterface != null) && ((localIInterface instanceof zzac))) {
          paramIBinder = (zzac)localIInterface;
        } else {
          paramIBinder = new zza(paramIBinder);
        }
      }
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
        paramParcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        zza(paramParcel1.readHashMap(getClass().getClassLoader()), paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.createTypedArrayList(Command.CREATOR));
        paramParcel2.writeNoException();
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        zzabr();
        paramParcel2.writeNoException();
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        paramParcel1 = getVersion();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        bool = true;
      }
    }
    
    private static class zza
      implements zzac
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
      
      public String getVersion()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          this.zzajq.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void zza(Map paramMap, long paramLong, String paramString, List<Command> paramList)
        throws RemoteException
      {
        Parcel localParcel2 = Parcel.obtain();
        Parcel localParcel1 = Parcel.obtain();
        try
        {
          localParcel2.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          localParcel2.writeMap(paramMap);
          localParcel2.writeLong(paramLong);
          localParcel2.writeString(paramString);
          localParcel2.writeTypedList(paramList);
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
      
      public void zzabr()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          this.zzajq.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */