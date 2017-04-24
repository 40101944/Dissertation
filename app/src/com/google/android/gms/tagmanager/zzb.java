package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzb
  extends zzam
{
  private static final String ID = zzag.zzhd.toString();
  private final zza aDO;
  
  public zzb(Context paramContext)
  {
    this(zza.zzdw(paramContext));
  }
  
  zzb(zza paramzza)
  {
    super(ID, new String[0]);
    this.aDO = paramzza;
    this.aDO.zzcdo();
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    paramMap = this.aDO.zzcdo();
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


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */