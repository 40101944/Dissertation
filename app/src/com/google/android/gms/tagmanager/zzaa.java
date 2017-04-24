package com.google.android.gms.tagmanager;

import android.content.Context;

public class zzaa
  implements zzat
{
  private static final Object aDL = new Object();
  private static zzaa aFa;
  private zzcl aEo;
  private zzau aFb;
  
  private zzaa(Context paramContext)
  {
    this(zzav.zzee(paramContext), new zzda());
  }
  
  zzaa(zzau paramzzau, zzcl paramzzcl)
  {
    this.aFb = paramzzau;
    this.aEo = paramzzcl;
  }
  
  public static zzat zzdx(Context paramContext)
  {
    synchronized (aDL)
    {
      if (aFa == null)
      {
        zzaa localzzaa = new com/google/android/gms/tagmanager/zzaa;
        localzzaa.<init>(paramContext);
        aFa = localzzaa;
      }
      paramContext = aFa;
      return paramContext;
    }
  }
  
  public boolean zzpg(String paramString)
  {
    if (!this.aEo.zzagf()) {
      zzbo.zzdi("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      this.aFb.zzpk(paramString);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */