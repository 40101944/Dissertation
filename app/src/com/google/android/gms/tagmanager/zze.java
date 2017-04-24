package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zze
  extends zzam
{
  private static final String ID = zzag.zzik.toString();
  private static final String aDP = zzah.zznp.toString();
  private static final String aDQ = zzah.zzns.toString();
  private final Context zzahs;
  
  public zze(Context paramContext)
  {
    super(ID, new String[] { aDQ });
    this.zzahs = paramContext;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    Object localObject = (zzaj.zza)paramMap.get(aDQ);
    if (localObject == null) {
      paramMap = zzdm.zzchm();
    }
    for (;;)
    {
      return paramMap;
      localObject = zzdm.zzg((zzaj.zza)localObject);
      paramMap = (zzaj.zza)paramMap.get(aDP);
      if (paramMap != null) {}
      for (paramMap = zzdm.zzg(paramMap);; paramMap = null)
      {
        paramMap = zzbf.zzj(this.zzahs, (String)localObject, paramMap);
        if (paramMap == null) {
          break label77;
        }
        paramMap = zzdm.zzat(paramMap);
        break;
      }
      label77:
      paramMap = zzdm.zzchm();
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */