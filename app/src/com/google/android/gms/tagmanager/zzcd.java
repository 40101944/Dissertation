package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

abstract class zzcd
  extends zzci
{
  public zzcd(String paramString)
  {
    super(paramString);
  }
  
  protected boolean zza(zzaj.zza paramzza1, zzaj.zza paramzza2, Map<String, zzaj.zza> paramMap)
  {
    paramzza1 = zzdm.zzh(paramzza1);
    paramzza2 = zzdm.zzh(paramzza2);
    if ((paramzza1 == zzdm.zzchk()) || (paramzza2 == zzdm.zzchk())) {}
    for (boolean bool = false;; bool = zza(paramzza1, paramzza2, paramMap)) {
      return bool;
    }
  }
  
  protected abstract boolean zza(zzdl paramzzdl1, zzdl paramzzdl2, Map<String, zzaj.zza> paramMap);
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzcd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */