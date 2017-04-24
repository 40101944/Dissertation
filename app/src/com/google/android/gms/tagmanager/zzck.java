package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzck
  extends zzam
{
  private static final String ID = zzag.zzic.toString();
  private static final String aGt = zzah.zzrj.toString();
  private static final String aGu = zzah.zzrh.toString();
  
  public zzck()
  {
    super(ID, new String[0]);
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    Object localObject = (zzaj.zza)paramMap.get(aGt);
    paramMap = (zzaj.zza)paramMap.get(aGu);
    double d1;
    double d2;
    if ((localObject != null) && (localObject != zzdm.zzchm()) && (paramMap != null) && (paramMap != zzdm.zzchm()))
    {
      localObject = zzdm.zzh((zzaj.zza)localObject);
      paramMap = zzdm.zzh(paramMap);
      if ((localObject != zzdm.zzchk()) && (paramMap != zzdm.zzchk()))
      {
        d1 = ((zzdl)localObject).doubleValue();
        d2 = paramMap.doubleValue();
        if (d1 > d2) {}
      }
    }
    for (;;)
    {
      return zzdm.zzat(Long.valueOf(Math.round((d2 - d1) * Math.random() + d1)));
      d2 = 2.147483647E9D;
      d1 = 0.0D;
    }
  }
  
  public boolean zzcdu()
  {
    return false;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */