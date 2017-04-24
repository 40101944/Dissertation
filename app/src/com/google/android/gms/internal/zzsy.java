package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.zzs;

public class zzsy
{
  protected final Context mContext;
  
  public zzsy(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    return this.mContext.checkCallingOrSelfPermission(paramString);
  }
  
  public int checkPermission(String paramString1, String paramString2)
  {
    return this.mContext.getPackageManager().checkPermission(paramString1, paramString2);
  }
  
  public ApplicationInfo getApplicationInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return this.mContext.getPackageManager().getApplicationInfo(paramString, paramInt);
  }
  
  public PackageInfo getPackageInfo(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return this.mContext.getPackageManager().getPackageInfo(paramString, paramInt);
  }
  
  public String[] getPackagesForUid(int paramInt)
  {
    return this.mContext.getPackageManager().getPackagesForUid(paramInt);
  }
  
  @TargetApi(19)
  public boolean zzg(int paramInt, String paramString)
  {
    bool2 = false;
    if (zzs.zzayu()) {}
    do
    {
      do
      {
        try
        {
          ((AppOpsManager)this.mContext.getSystemService("appops")).checkPackage(paramInt, paramString);
          bool1 = true;
        }
        catch (SecurityException paramString)
        {
          for (;;)
          {
            String[] arrayOfString;
            boolean bool1 = bool2;
          }
        }
        return bool1;
        arrayOfString = this.mContext.getPackageManager().getPackagesForUid(paramInt);
        bool1 = bool2;
      } while (paramString == null);
      bool1 = bool2;
    } while (arrayOfString == null);
    for (paramInt = 0;; paramInt++)
    {
      bool1 = bool2;
      if (paramInt >= arrayOfString.length) {
        break;
      }
      if (paramString.equals(arrayOfString[paramInt]))
      {
        bool1 = true;
        break;
      }
    }
  }
  
  public CharSequence zzik(String paramString)
    throws PackageManager.NameNotFoundException
  {
    return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getPackageManager().getApplicationInfo(paramString, 0));
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzsy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */