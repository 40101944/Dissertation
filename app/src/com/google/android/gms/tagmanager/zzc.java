package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzc
  extends zzam
{
  private static final String ID = zzag.zzhe.toString();
  private final zza aDO;
  
  public zzc(Context paramContext)
  {
    this(zza.zzdw(paramContext));
  }
  
  zzc(zza paramzza)
  {
    super(ID, new String[0]);
    this.aDO = paramzza;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    if (!this.aDO.isLimitAdTrackingEnabled()) {}
    for (boolean bool = true;; bool = false) {
      return zzdm.zzat(Boolean.valueOf(bool));
    }
  }
  
  public boolean zzcdu()
  {
    return false;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */