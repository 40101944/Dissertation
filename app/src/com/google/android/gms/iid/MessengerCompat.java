package com.google.android.gms.iid;

import android.annotation.TargetApi;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class MessengerCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MessengerCompat> CREATOR = new Parcelable.Creator()
  {
    public MessengerCompat zznf(Parcel paramAnonymousParcel)
    {
      paramAnonymousParcel = paramAnonymousParcel.readStrongBinder();
      if (paramAnonymousParcel != null) {}
      for (paramAnonymousParcel = new MessengerCompat(paramAnonymousParcel);; paramAnonymousParcel = null) {
        return paramAnonymousParcel;
      }
    }
    
    public MessengerCompat[] zztv(int paramAnonymousInt)
    {
      return new MessengerCompat[paramAnonymousInt];
    }
  };
  Messenger aiq;
  zzb air;
  
  public MessengerCompat(Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.aiq = new Messenger(paramHandler);
    }
    for (;;)
    {
      return;
      this.air = new zza(paramHandler);
    }
  }
  
  public MessengerCompat(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      this.aiq = new Messenger(paramIBinder);
    }
    for (;;)
    {
      return;
      this.air = zzb.zza.zzgx(paramIBinder);
    }
  }
  
  public static int zzc(Message paramMessage)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (int i = zzd(paramMessage);; i = paramMessage.arg2) {
      return i;
    }
  }
  
  @TargetApi(21)
  private static int zzd(Message paramMessage)
  {
    return paramMessage.sendingUid;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    if (paramObject == null) {}
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = getBinder().equals(((MessengerCompat)paramObject).getBinder());
        bool1 = bool2;
      }
      catch (ClassCastException paramObject) {}
    }
  }
  
  public IBinder getBinder()
  {
    if (this.aiq != null) {}
    for (IBinder localIBinder = this.aiq.getBinder();; localIBinder = this.air.asBinder()) {
      return localIBinder;
    }
  }
  
  public int hashCode()
  {
    return getBinder().hashCode();
  }
  
  public void send(Message paramMessage)
    throws RemoteException
  {
    if (this.aiq != null) {
      this.aiq.send(paramMessage);
    }
    for (;;)
    {
      return;
      this.air.send(paramMessage);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.aiq != null) {
      paramParcel.writeStrongBinder(this.aiq.getBinder());
    }
    for (;;)
    {
      return;
      paramParcel.writeStrongBinder(this.air.asBinder());
    }
  }
  
  private final class zza
    extends zzb.zza
  {
    Handler handler;
    
    zza(Handler paramHandler)
    {
      this.handler = paramHandler;
    }
    
    public void send(Message paramMessage)
      throws RemoteException
    {
      paramMessage.arg2 = Binder.getCallingUid();
      this.handler.dispatchMessage(paramMessage);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\iid\MessengerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */