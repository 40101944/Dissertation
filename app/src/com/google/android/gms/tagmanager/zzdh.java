package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

abstract class zzdh
  extends zzci
{
  public zzdh(String paramString)
  {
    super(paramString);
  }
  
  protected boolean zza(zzaj.zza paramzza1, zzaj.zza paramzza2, Map<String, zzaj.zza> paramMap)
  {
    paramzza1 = zzdm.zzg(paramzza1);
    paramzza2 = zzdm.zzg(paramzza2);
    if ((paramzza1 == zzdm.zzchl()) || (paramzza2 == zzdm.zzchl())) {}
    for (boolean bool = false;; bool = zza(paramzza1, paramzza2, paramMap)) {
      return bool;
    }
  }
  
  protected abstract boolean zza(String paramString1, String paramString2, Map<String, zzaj.zza> paramMap);
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */