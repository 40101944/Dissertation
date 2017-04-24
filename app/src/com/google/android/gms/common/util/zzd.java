package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;

public class zzd
{
  public static int zza(PackageInfo paramPackageInfo)
  {
    int j = -1;
    int i = j;
    if (paramPackageInfo != null)
    {
      if (paramPackageInfo.applicationInfo != null) {
        break label19;
      }
      i = j;
    }
    for (;;)
    {
      return i;
      label19:
      paramPackageInfo = paramPackageInfo.applicationInfo.metaData;
      i = j;
      if (paramPackageInfo != null) {
        i = paramPackageInfo.getInt("com.google.android.gms.version", -1);
      }
    }
  }
  
  public static boolean zzayi()
  {
    return false;
  }
  
  public static int zzv(Context paramContext, String paramString)
  {
    return zza(zzw(paramContext, paramString));
  }
  
  @Nullable
  public static PackageInfo zzw(Context paramContext, String paramString)
  {
    try
    {
      paramContext = zzsz.zzco(paramContext).getPackageInfo(paramString, 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  @TargetApi(12)
  public static boolean zzx(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!zzs.zzayo()) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ("com.google.android.gms".equals(paramString))
      {
        bool1 = bool2;
        if (zzayi()) {}
      }
      else
      {
        try
        {
          int i = zzsz.zzco(paramContext).getApplicationInfo(paramString, 0).flags;
          bool1 = bool2;
          if ((i & 0x200000) != 0) {
            bool1 = true;
          }
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          bool1 = bool2;
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\util\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */