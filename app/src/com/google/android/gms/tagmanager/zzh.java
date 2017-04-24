package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzh
  extends zzam
{
  private static final String ID = zzag.zzhh.toString();
  private final Context mContext;
  
  public zzh(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    try
    {
      paramMap = zzdm.zzat(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        paramMap = String.valueOf(this.mContext.getPackageName());
        String str = String.valueOf(localNameNotFoundException.getMessage());
        zzbo.e(String.valueOf(paramMap).length() + 25 + String.valueOf(str).length() + "Package name " + paramMap + " not found. " + str);
        paramMap = zzdm.zzchm();
      }
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */