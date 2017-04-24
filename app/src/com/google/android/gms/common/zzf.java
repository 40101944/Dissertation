package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;

public class zzf
{
  private static zzf xh;
  private final Context mContext;
  
  private zzf(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static zzf zzbv(Context paramContext)
  {
    zzaa.zzy(paramContext);
    try
    {
      if (xh == null)
      {
        zzd.zzbo(paramContext);
        zzf localzzf = new com/google/android/gms/common/zzf;
        localzzf.<init>(paramContext);
        xh = localzzf;
      }
      return xh;
    }
    finally {}
  }
  
  zzd.zza zza(PackageInfo paramPackageInfo, zzd.zza... paramVarArgs)
  {
    int i = 0;
    if (paramPackageInfo.signatures == null) {
      paramPackageInfo = null;
    }
    for (;;)
    {
      return paramPackageInfo;
      if (paramPackageInfo.signatures.length != 1)
      {
        Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
        paramPackageInfo = null;
      }
      else
      {
        paramPackageInfo = new zzd.zzb(paramPackageInfo.signatures[0].toByteArray());
        for (;;)
        {
          if (i >= paramVarArgs.length) {
            break label81;
          }
          if (paramVarArgs[i].equals(paramPackageInfo))
          {
            paramPackageInfo = paramVarArgs[i];
            break;
          }
          i++;
        }
        label81:
        paramPackageInfo = null;
      }
    }
  }
  
  public boolean zza(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramPackageInfo != null) && (paramPackageInfo.signatures != null)) {
      if (paramBoolean)
      {
        paramPackageInfo = zza(paramPackageInfo, zzd.zzd.xa);
        if (paramPackageInfo == null) {
          break label55;
        }
      }
    }
    label55:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      paramPackageInfo = zza(paramPackageInfo, new zzd.zza[] { zzd.zzd.xa[0] });
      break;
    }
  }
  
  public boolean zza(PackageManager paramPackageManager, int paramInt)
  {
    boolean bool2 = false;
    String[] arrayOfString = zzsz.zzco(this.mContext).getPackagesForUid(paramInt);
    boolean bool1 = bool2;
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        bool1 = bool2;
      }
    }
    else {
      return bool1;
    }
    int i = arrayOfString.length;
    for (paramInt = 0;; paramInt++)
    {
      bool1 = bool2;
      if (paramInt >= i) {
        break;
      }
      if (zzb(paramPackageManager, arrayOfString[paramInt]))
      {
        bool1 = true;
        break;
      }
    }
  }
  
  public boolean zza(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    boolean bool1 = false;
    if (paramPackageInfo == null) {}
    for (;;)
    {
      return bool1;
      if (zze.zzbr(this.mContext))
      {
        bool1 = zzb(paramPackageInfo, true);
      }
      else
      {
        boolean bool2 = zzb(paramPackageInfo, false);
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          if (zzb(paramPackageInfo, true))
          {
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  boolean zzb(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramPackageInfo.signatures.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return bool;
    }
    zzd.zzb localzzb = new zzd.zzb(paramPackageInfo.signatures[0].toByteArray());
    paramPackageInfo = paramPackageInfo.packageName;
    if (paramBoolean) {}
    for (paramBoolean = zzd.zzb(paramPackageInfo, localzzb);; paramBoolean = zzd.zza(paramPackageInfo, localzzb))
    {
      bool = paramBoolean;
      if (paramBoolean) {
        break;
      }
      bool = paramBoolean;
      break;
    }
  }
  
  public boolean zzb(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramPackageInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (zza(paramPackageInfo, false))
      {
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (zza(paramPackageInfo, true)) {
          if (zze.zzbr(this.mContext))
          {
            bool1 = true;
          }
          else
          {
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public boolean zzb(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      paramString = zzsz.zzco(this.mContext).getPackageInfo(paramString, 64);
      bool = zza(paramPackageManager, paramString);
    }
    catch (PackageManager.NameNotFoundException paramPackageManager)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */