package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzvt.zza;

@DynamiteApi
public class FlagProviderImpl
  extends zzvt.zza
{
  private boolean zzaoz = false;
  private SharedPreferences zzbct;
  
  public boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
  {
    if (!this.zzaoz) {}
    for (;;)
    {
      return paramBoolean;
      paramBoolean = zza.zza.zza(this.zzbct, paramString, Boolean.valueOf(paramBoolean)).booleanValue();
    }
  }
  
  public int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.zzaoz) {}
    for (;;)
    {
      return paramInt1;
      paramInt1 = zza.zzb.zza(this.zzbct, paramString, Integer.valueOf(paramInt1)).intValue();
    }
  }
  
  public long getLongFlagValue(String paramString, long paramLong, int paramInt)
  {
    if (!this.zzaoz) {}
    for (;;)
    {
      return paramLong;
      paramLong = zza.zzc.zza(this.zzbct, paramString, Long.valueOf(paramLong)).longValue();
    }
  }
  
  public String getStringFlagValue(String paramString1, String paramString2, int paramInt)
  {
    if (!this.zzaoz) {}
    for (;;)
    {
      return paramString2;
      paramString2 = zza.zzd.zza(this.zzbct, paramString1, paramString2);
    }
  }
  
  public void init(zzd paramzzd)
  {
    paramzzd = (Context)zze.zzae(paramzzd);
    if (this.zzaoz) {}
    for (;;)
    {
      return;
      try
      {
        this.zzbct = zzb.zzm(paramzzd.createPackageContext("com.google.android.gms", 0));
        this.zzaoz = true;
      }
      catch (PackageManager.NameNotFoundException paramzzd) {}
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\flags\impl\FlagProviderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */