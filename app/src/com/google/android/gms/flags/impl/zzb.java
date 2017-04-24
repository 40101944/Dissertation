package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzvv;
import java.util.concurrent.Callable;

public class zzb
{
  private static SharedPreferences WM = null;
  
  public static SharedPreferences zzm(Context paramContext)
  {
    try
    {
      if (WM == null)
      {
        Callable local1 = new com/google/android/gms/flags/impl/zzb$1;
        local1.<init>(paramContext);
        WM = (SharedPreferences)zzvv.zzb(local1);
      }
      paramContext = WM;
      return paramContext;
    }
    finally {}
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\flags\impl\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */