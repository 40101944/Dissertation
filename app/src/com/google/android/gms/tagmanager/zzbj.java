package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Locale;
import java.util.Map;

public class zzbj
  extends zzam
{
  private static final String ID = zzag.zzhy.toString();
  
  public zzbj()
  {
    super(ID, new String[0]);
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    paramMap = Locale.getDefault();
    if (paramMap == null) {
      paramMap = zzdm.zzchm();
    }
    for (;;)
    {
      return paramMap;
      paramMap = paramMap.getLanguage();
      if (paramMap == null) {
        paramMap = zzdm.zzchm();
      } else {
        paramMap = zzdm.zzat(paramMap.toLowerCase());
      }
    }
  }
  
  public boolean zzcdu()
  {
    return false;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */