package com.google.android.gms.internal;

public final class zzvu
{
  private static zzvu WD;
  private final zzvr WE = new zzvr();
  private final zzvs WF = new zzvs();
  
  static
  {
    zza(new zzvu());
  }
  
  protected static void zza(zzvu paramzzvu)
  {
    try
    {
      WD = paramzzvu;
      return;
    }
    finally {}
  }
  
  private static zzvu zzbhd()
  {
    try
    {
      zzvu localzzvu = WD;
      return localzzvu;
    }
    finally {}
  }
  
  public static zzvr zzbhe()
  {
    return zzbhd().WE;
  }
  
  public static zzvs zzbhf()
  {
    return zzbhd().WF;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzvu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */