package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract interface zzu
  extends IInterface
{
  public abstract zzd zzawi()
    throws RemoteException;
  
  public abstract zzd zzawj()
    throws RemoteException;
  
  public abstract boolean zzd(String paramString, zzd paramzzd)
    throws RemoteException;
  
  public abstract boolean zze(String paramString, zzd paramzzd)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzu
  {
    public static zzu zzdv(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if ((localIInterface != null) && ((localIInterface instanceof zzu))) {
          paramIBinder = (zzu)localIInterface;
        } else {
          paramIBinder = new zza(paramIBinder);
        }
      }
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      zzd localzzd2 = null;
      zzd localzzd1 = null;
      int i = 0;
      boolean bool1 = true;
      switch (paramInt1)
      {
      default: 
        bool1 = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      }
      for (;;)
      {
        return bool1;
        paramParcel2.writeString("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        localzzd2 = zzawi();
        paramParcel2.writeNoException();
        paramParcel1 = localzzd1;
        if (localzzd2 != null) {
          paramParcel1 = localzzd2.asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        localzzd1 = zzawj();
        paramParcel2.writeNoException();
        paramParcel1 = localzzd2;
        if (localzzd1 != null) {
          paramParcel1 = localzzd1.asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        boolean bool2 = zzd(paramParcel1.readString(), zzd.zza.zzfd(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        if (bool2) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          paramParcel2.writeInt(paramInt1);
          break;
        }
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        bool2 = zze(paramParcel1.readString(), zzd.zza.zzfd(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool2) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
      }
    }
    
    private static class zza
      implements zzu
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
      
      public zzd zzawi()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
          this.zzajq.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzd localzzd = zzd.zza.zzfd(localParcel2.readStrongBinder());
          return localzzd;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public zzd zzawj()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
          this.zzajq.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzd localzzd = zzd.zza.zzfd(localParcel2.readStrongBinder());
          return localzzd;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public boolean zzd(String paramString, zzd paramzzd)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 6
        //   15: ldc 33
        //   17: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 6
        //   22: aload_1
        //   23: invokevirtual 65	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   26: aload_2
        //   27: ifnull +63 -> 90
        //   30: aload_2
        //   31: invokeinterface 69 1 0
        //   36: astore_1
        //   37: aload 6
        //   39: aload_1
        //   40: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   43: aload_0
        //   44: getfield 18	com/google/android/gms/common/internal/zzu$zza$zza:zzajq	Landroid/os/IBinder;
        //   47: iconst_3
        //   48: aload 6
        //   50: aload 5
        //   52: iconst_0
        //   53: invokeinterface 43 5 0
        //   58: pop
        //   59: aload 5
        //   61: invokevirtual 46	android/os/Parcel:readException	()V
        //   64: aload 5
        //   66: invokevirtual 76	android/os/Parcel:readInt	()I
        //   69: istore_3
        //   70: iload_3
        //   71: ifeq +6 -> 77
        //   74: iconst_1
        //   75: istore 4
        //   77: aload 5
        //   79: invokevirtual 58	android/os/Parcel:recycle	()V
        //   82: aload 6
        //   84: invokevirtual 58	android/os/Parcel:recycle	()V
        //   87: iload 4
        //   89: ireturn
        //   90: aconst_null
        //   91: astore_1
        //   92: goto -55 -> 37
        //   95: astore_1
        //   96: aload 5
        //   98: invokevirtual 58	android/os/Parcel:recycle	()V
        //   101: aload 6
        //   103: invokevirtual 58	android/os/Parcel:recycle	()V
        //   106: aload_1
        //   107: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	108	0	this	zza
        //   0	108	1	paramString	String
        //   0	108	2	paramzzd	zzd
        //   69	2	3	i	int
        //   1	87	4	bool	boolean
        //   11	86	5	localParcel1	Parcel
        //   6	96	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	95	finally
        //   30	37	95	finally
        //   37	70	95	finally
      }
      
      /* Error */
      public boolean zze(String paramString, zzd paramzzd)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 5
        //   13: aload 6
        //   15: ldc 33
        //   17: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 6
        //   22: aload_1
        //   23: invokevirtual 65	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   26: aload_2
        //   27: ifnull +63 -> 90
        //   30: aload_2
        //   31: invokeinterface 69 1 0
        //   36: astore_1
        //   37: aload 6
        //   39: aload_1
        //   40: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   43: aload_0
        //   44: getfield 18	com/google/android/gms/common/internal/zzu$zza$zza:zzajq	Landroid/os/IBinder;
        //   47: iconst_4
        //   48: aload 6
        //   50: aload 5
        //   52: iconst_0
        //   53: invokeinterface 43 5 0
        //   58: pop
        //   59: aload 5
        //   61: invokevirtual 46	android/os/Parcel:readException	()V
        //   64: aload 5
        //   66: invokevirtual 76	android/os/Parcel:readInt	()I
        //   69: istore_3
        //   70: iload_3
        //   71: ifeq +6 -> 77
        //   74: iconst_1
        //   75: istore 4
        //   77: aload 5
        //   79: invokevirtual 58	android/os/Parcel:recycle	()V
        //   82: aload 6
        //   84: invokevirtual 58	android/os/Parcel:recycle	()V
        //   87: iload 4
        //   89: ireturn
        //   90: aconst_null
        //   91: astore_1
        //   92: goto -55 -> 37
        //   95: astore_1
        //   96: aload 5
        //   98: invokevirtual 58	android/os/Parcel:recycle	()V
        //   101: aload 6
        //   103: invokevirtual 58	android/os/Parcel:recycle	()V
        //   106: aload_1
        //   107: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	108	0	this	zza
        //   0	108	1	paramString	String
        //   0	108	2	paramzzd	zzd
        //   69	2	3	i	int
        //   1	87	4	bool	boolean
        //   11	86	5	localParcel1	Parcel
        //   6	96	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	95	finally
        //   30	37	95	finally
        //   37	70	95	finally
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */