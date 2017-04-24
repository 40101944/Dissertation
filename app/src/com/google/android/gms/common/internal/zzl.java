package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzl
{
  private static final Object El = new Object();
  private static zzl Em;
  
  public static zzl zzcc(Context paramContext)
  {
    synchronized (El)
    {
      if (Em == null)
      {
        zzm localzzm = new com/google/android/gms/common/internal/zzm;
        localzzm.<init>(paramContext.getApplicationContext());
        Em = localzzm;
      }
      return Em;
    }
  }
  
  public abstract boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract boolean zza(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3);
  
  public abstract void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract void zzb(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3);
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */