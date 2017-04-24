package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract interface zztn
  extends IInterface
{
  public abstract zzd zza(zzd paramzzd, String paramString, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zztn
  {
    public static zztn zzff(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        if ((localIInterface != null) && ((localIInterface instanceof zztn))) {
          paramIBinder = (zztn)localIInterface;
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
      case 1598968902: 
        for (bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);; bool = true)
        {
          return bool;
          paramParcel2.writeString("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
      paramParcel1 = zza(zzd.zza.zzfd(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        bool = true;
        break;
      }
    }
    
    private static class zza
      implements zztn
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
      
      /* Error */
      public zzd zza(zzd paramzzd, String paramString, byte[] paramArrayOfByte)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 5
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 4
        //   10: aload 5
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +70 -> 88
        //   21: aload_1
        //   22: invokeinterface 40 1 0
        //   27: astore_1
        //   28: aload 5
        //   30: aload_1
        //   31: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   34: aload 5
        //   36: aload_2
        //   37: invokevirtual 46	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   40: aload 5
        //   42: aload_3
        //   43: invokevirtual 50	android/os/Parcel:writeByteArray	([B)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/internal/zztn$zza$zza:zzajq	Landroid/os/IBinder;
        //   50: iconst_1
        //   51: aload 5
        //   53: aload 4
        //   55: iconst_0
        //   56: invokeinterface 56 5 0
        //   61: pop
        //   62: aload 4
        //   64: invokevirtual 59	android/os/Parcel:readException	()V
        //   67: aload 4
        //   69: invokevirtual 62	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   72: invokestatic 68	com/google/android/gms/dynamic/zzd$zza:zzfd	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
        //   75: astore_1
        //   76: aload 4
        //   78: invokevirtual 71	android/os/Parcel:recycle	()V
        //   81: aload 5
        //   83: invokevirtual 71	android/os/Parcel:recycle	()V
        //   86: aload_1
        //   87: areturn
        //   88: aconst_null
        //   89: astore_1
        //   90: goto -62 -> 28
        //   93: astore_1
        //   94: aload 4
        //   96: invokevirtual 71	android/os/Parcel:recycle	()V
        //   99: aload 5
        //   101: invokevirtual 71	android/os/Parcel:recycle	()V
        //   104: aload_1
        //   105: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	106	0	this	zza
        //   0	106	1	paramzzd	zzd
        //   0	106	2	paramString	String
        //   0	106	3	paramArrayOfByte	byte[]
        //   8	87	4	localParcel1	Parcel
        //   3	97	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	17	93	finally
        //   21	28	93	finally
        //   28	76	93	finally
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zztn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */