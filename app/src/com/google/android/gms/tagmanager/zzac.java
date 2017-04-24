package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzac
  extends zzam
{
  private static final String ID = zzag.zzho.toString();
  
  public zzac()
  {
    super(ID, new String[0]);
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    String str2 = Build.MANUFACTURER;
    String str1 = Build.MODEL;
    paramMap = str1;
    if (!str1.startsWith(str2))
    {
      paramMap = str1;
      if (!str2.equals("unknown")) {
        paramMap = String.valueOf(str2).length() + 1 + String.valueOf(str1).length() + str2 + " " + str1;
      }
    }
    return zzdm.zzat(paramMap);
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */