package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;

public final class zzx
{
  @TargetApi(19)
  public static boolean zzc(Context paramContext, int paramInt, String paramString)
  {
    return zzsz.zzco(paramContext).zzg(paramInt, paramString);
  }
  
  public static boolean zzf(Context paramContext, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!zzc(paramContext, paramInt, "com.google.android.gms")) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      Object localObject = paramContext.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getPackageInfo("com.google.android.gms", 64);
        bool1 = zzf.zzbv(paramContext).zzb(paramContext.getPackageManager(), (PackageInfo)localObject);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        bool1 = bool2;
      }
      if (Log.isLoggable("UidVerifier", 3))
      {
        Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
        bool1 = bool2;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\util\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */