package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.zzae;

public final class zzc
{
  public static String zzbl(int paramInt)
  {
    return zzc("&cd", paramInt);
  }
  
  public static String zzbm(int paramInt)
  {
    return zzc("cd", paramInt);
  }
  
  public static String zzbn(int paramInt)
  {
    return zzc("&cm", paramInt);
  }
  
  public static String zzbo(int paramInt)
  {
    return zzc("cm", paramInt);
  }
  
  public static String zzbp(int paramInt)
  {
    return zzc("&pr", paramInt);
  }
  
  public static String zzbq(int paramInt)
  {
    return zzc("pr", paramInt);
  }
  
  public static String zzbr(int paramInt)
  {
    return zzc("&promo", paramInt);
  }
  
  public static String zzbs(int paramInt)
  {
    return zzc("promo", paramInt);
  }
  
  public static String zzbt(int paramInt)
  {
    return zzc("pi", paramInt);
  }
  
  public static String zzbu(int paramInt)
  {
    return zzc("&il", paramInt);
  }
  
  public static String zzbv(int paramInt)
  {
    return zzc("il", paramInt);
  }
  
  public static String zzbw(int paramInt)
  {
    return zzc("cd", paramInt);
  }
  
  public static String zzbx(int paramInt)
  {
    return zzc("cm", paramInt);
  }
  
  private static String zzc(String paramString, int paramInt)
  {
    if (paramInt < 1) {
      zzae.zzf("index out of range for prefix", paramString);
    }
    for (paramString = "";; paramString = String.valueOf(paramString).length() + 11 + paramString + paramInt) {
      return paramString;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */