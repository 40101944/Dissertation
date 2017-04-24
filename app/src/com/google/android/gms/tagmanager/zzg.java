package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzg
  extends zzam
{
  private static final String ID = zzag.zzhg.toString();
  private final Context mContext;
  
  public zzg(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    try
    {
      paramMap = this.mContext.getPackageManager();
      paramMap = zzdm.zzat(paramMap.getApplicationLabel(paramMap.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
      return paramMap;
    }
    catch (PackageManager.NameNotFoundException paramMap)
    {
      for (;;)
      {
        zzbo.zzb("App name is not found.", paramMap);
        paramMap = zzdm.zzchm();
      }
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */