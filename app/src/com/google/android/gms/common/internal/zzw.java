package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract interface zzw
  extends IInterface
{
  public abstract zzd zza(zzd paramzzd, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract zzd zza(zzd paramzzd, SignInButtonConfig paramSignInButtonConfig)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzw
  {
    public static zzw zzdx(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        paramIBinder = null;
      }
      for (;;)
      {
        return paramIBinder;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if ((localIInterface != null) && ((localIInterface instanceof zzw))) {
          paramIBinder = (zzw)localIInterface;
        } else {
          paramIBinder = new zza(paramIBinder);
        }
      }
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject = null;
      boolean bool;
      switch (paramInt1)
      {
      default: 
      case 1598968902: 
        for (bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);; bool = true)
        {
          return bool;
          paramParcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
        }
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        paramParcel1 = zza(zzd.zza.zzfd(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null) {}
        for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          bool = true;
          break;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      zzd localzzd = zzd.zza.zzfd(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (SignInButtonConfig)SignInButtonConfig.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        localzzd = zza(localzzd, paramParcel1);
        paramParcel2.writeNoException();
        paramParcel1 = (Parcel)localObject;
        if (localzzd != null) {
          paramParcel1 = localzzd.asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        bool = true;
        break;
      }
    }
    
    private static class zza
      implements zzw
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
      public zzd zza(zzd paramzzd, int paramInt1, int paramInt2)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 32
        //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +70 -> 88
        //   21: aload_1
        //   22: invokeinterface 40 1 0
        //   27: astore_1
        //   28: aload 4
        //   30: aload_1
        //   31: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   34: aload 4
        //   36: iload_2
        //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   40: aload 4
        //   42: iload_3
        //   43: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/common/internal/zzw$zza$zza:zzajq	Landroid/os/IBinder;
        //   50: iconst_1
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 53 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 56	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 59	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   72: invokestatic 65	com/google/android/gms/dynamic/zzd$zza:zzfd	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
        //   75: astore_1
        //   76: aload 5
        //   78: invokevirtual 68	android/os/Parcel:recycle	()V
        //   81: aload 4
        //   83: invokevirtual 68	android/os/Parcel:recycle	()V
        //   86: aload_1
        //   87: areturn
        //   88: aconst_null
        //   89: astore_1
        //   90: goto -62 -> 28
        //   93: astore_1
        //   94: aload 5
        //   96: invokevirtual 68	android/os/Parcel:recycle	()V
        //   99: aload 4
        //   101: invokevirtual 68	android/os/Parcel:recycle	()V
        //   104: aload_1
        //   105: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	106	0	this	zza
        //   0	106	1	paramzzd	zzd
        //   0	106	2	paramInt1	int
        //   0	106	3	paramInt2	int
        //   3	97	4	localParcel1	Parcel
        //   8	87	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	17	93	finally
        //   21	28	93	finally
        //   28	76	93	finally
      }
      
      /* Error */
      public zzd zza(zzd paramzzd, SignInButtonConfig paramSignInButtonConfig)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: aload 4
        //   11: ldc 32
        //   13: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: ifnull +71 -> 88
        //   20: aload_1
        //   21: invokeinterface 40 1 0
        //   26: astore_1
        //   27: aload 4
        //   29: aload_1
        //   30: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_2
        //   34: ifnull +59 -> 93
        //   37: aload 4
        //   39: iconst_1
        //   40: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   43: aload_2
        //   44: aload 4
        //   46: iconst_0
        //   47: invokevirtual 76	com/google/android/gms/common/internal/SignInButtonConfig:writeToParcel	(Landroid/os/Parcel;I)V
        //   50: aload_0
        //   51: getfield 18	com/google/android/gms/common/internal/zzw$zza$zza:zzajq	Landroid/os/IBinder;
        //   54: iconst_2
        //   55: aload 4
        //   57: aload_3
        //   58: iconst_0
        //   59: invokeinterface 53 5 0
        //   64: pop
        //   65: aload_3
        //   66: invokevirtual 56	android/os/Parcel:readException	()V
        //   69: aload_3
        //   70: invokevirtual 59	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   73: invokestatic 65	com/google/android/gms/dynamic/zzd$zza:zzfd	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
        //   76: astore_1
        //   77: aload_3
        //   78: invokevirtual 68	android/os/Parcel:recycle	()V
        //   81: aload 4
        //   83: invokevirtual 68	android/os/Parcel:recycle	()V
        //   86: aload_1
        //   87: areturn
        //   88: aconst_null
        //   89: astore_1
        //   90: goto -63 -> 27
        //   93: aload 4
        //   95: iconst_0
        //   96: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   99: goto -49 -> 50
        //   102: astore_1
        //   103: aload_3
        //   104: invokevirtual 68	android/os/Parcel:recycle	()V
        //   107: aload 4
        //   109: invokevirtual 68	android/os/Parcel:recycle	()V
        //   112: aload_1
        //   113: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	114	0	this	zza
        //   0	114	1	paramzzd	zzd
        //   0	114	2	paramSignInButtonConfig	SignInButtonConfig
        //   8	96	3	localParcel1	Parcel
        //   3	105	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	16	102	finally
        //   20	27	102	finally
        //   27	33	102	finally
        //   37	50	102	finally
        //   50	77	102	finally
        //   93	99	102	finally
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */