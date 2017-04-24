package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzr
  extends zzam
{
  private static final String ID = zzag.zzhm.toString();
  private final String um;
  
  public zzr(String paramString)
  {
    super(ID, new String[0]);
    this.um = paramString;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    if (this.um == null) {}
    for (paramMap = zzdm.zzchm();; paramMap = zzdm.zzat(this.um)) {
      return paramMap;
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */