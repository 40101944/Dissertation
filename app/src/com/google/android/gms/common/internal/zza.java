package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.zze;

public class zza
  extends zzp.zza
{
  int De;
  
  public static Account zza(zzp paramzzp)
  {
    localObject2 = null;
    localObject1 = localObject2;
    if (paramzzp != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      localObject1 = paramzzp.getAccount();
    }
    catch (RemoteException paramzzp)
    {
      for (;;)
      {
        Log.w("AccountAccessor", "Remote account accessor probably died");
        Binder.restoreCallingIdentity(l);
        localObject1 = localObject2;
      }
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
    return (Account)localObject1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if ((paramObject instanceof zza)) {
        break;
      }
    }
    paramObject = (zza)paramObject;
    throw new NullPointerException();
  }
  
  public Account getAccount()
  {
    int i = Binder.getCallingUid();
    if (i == this.De) {}
    for (;;)
    {
      return null;
      if (!zze.zzf(null, i)) {
        break;
      }
      this.De = i;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */