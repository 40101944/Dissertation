package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzw
  extends zzam
{
  private static final String ID = zzag.zzhl.toString();
  private static final String NAME = zzah.zzrl.toString();
  private static final String aEO = zzah.zzoq.toString();
  private final DataLayer aDZ;
  
  public zzw(DataLayer paramDataLayer)
  {
    super(ID, new String[] { NAME });
    this.aDZ = paramDataLayer;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    Object localObject = this.aDZ.get(zzdm.zzg((zzaj.zza)paramMap.get(NAME)));
    if (localObject == null)
    {
      paramMap = (zzaj.zza)paramMap.get(aEO);
      if (paramMap == null) {}
    }
    for (;;)
    {
      return paramMap;
      paramMap = zzdm.zzchm();
      continue;
      paramMap = zzdm.zzat(localObject);
    }
  }
  
  public boolean zzcdu()
  {
    return false;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */