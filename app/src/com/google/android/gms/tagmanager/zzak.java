package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzak
  extends zzam
{
  private static final String ID = zzag.zzhu.toString();
  private final zzcx aEa;
  
  public zzak(zzcx paramzzcx)
  {
    super(ID, new String[0]);
    this.aEa = paramzzcx;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    paramMap = this.aEa.zzcgj();
    if (paramMap == null) {}
    for (paramMap = zzdm.zzchm();; paramMap = zzdm.zzat(paramMap)) {
      return paramMap;
    }
  }
  
  public boolean zzcdu()
  {
    return false;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */