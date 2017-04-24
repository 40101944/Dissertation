package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
public class zzae
{
  private static volatile Logger ft;
  
  static
  {
    setLogger(new zzs());
  }
  
  public static Logger getLogger()
  {
    return ft;
  }
  
  public static void setLogger(Logger paramLogger)
  {
    ft = paramLogger;
  }
  
  public static void v(String paramString)
  {
    Object localObject = zzaf.zzagg();
    if (localObject != null) {
      ((zzaf)localObject).zzes(paramString);
    }
    for (;;)
    {
      localObject = ft;
      if (localObject != null) {
        ((Logger)localObject).verbose(paramString);
      }
      return;
      if (zzbi(0)) {
        Log.v((String)zzy.en.get(), paramString);
      }
    }
  }
  
  public static boolean zzbi(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getLogger() != null)
    {
      bool1 = bool2;
      if (getLogger().getLogLevel() <= paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void zzdh(String paramString)
  {
    Object localObject = zzaf.zzagg();
    if (localObject != null) {
      ((zzaf)localObject).zzeu(paramString);
    }
    for (;;)
    {
      localObject = ft;
      if (localObject != null) {
        ((Logger)localObject).info(paramString);
      }
      return;
      if (zzbi(1)) {
        Log.i((String)zzy.en.get(), paramString);
      }
    }
  }
  
  public static void zzdi(String paramString)
  {
    Object localObject = zzaf.zzagg();
    if (localObject != null) {
      ((zzaf)localObject).zzev(paramString);
    }
    for (;;)
    {
      localObject = ft;
      if (localObject != null) {
        ((Logger)localObject).warn(paramString);
      }
      return;
      if (zzbi(2)) {
        Log.w((String)zzy.en.get(), paramString);
      }
    }
  }
  
  public static void zzf(String paramString, Object paramObject)
  {
    zzaf localzzaf = zzaf.zzagg();
    if (localzzaf != null) {
      localzzaf.zze(paramString, paramObject);
    }
    while (!zzbi(3))
    {
      paramObject = ft;
      if (paramObject != null) {
        ((Logger)paramObject).error(paramString);
      }
      return;
    }
    if (paramObject != null) {
      paramObject = String.valueOf(paramObject);
    }
    for (paramObject = String.valueOf(paramString).length() + 1 + String.valueOf(paramObject).length() + paramString + ":" + (String)paramObject;; paramObject = paramString)
    {
      Log.e((String)zzy.en.get(), (String)paramObject);
      break;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */