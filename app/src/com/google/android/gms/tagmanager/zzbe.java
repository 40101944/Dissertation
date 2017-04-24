package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzbe
  extends zzam
{
  private static final String ID = zzag.zzip.toString();
  private static final String aDP = zzah.zznp.toString();
  private final Context zzahs;
  
  public zzbe(Context paramContext)
  {
    super(ID, new String[0]);
    this.zzahs = paramContext;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    if ((zzaj.zza)paramMap.get(aDP) != null)
    {
      paramMap = zzdm.zzg((zzaj.zza)paramMap.get(aDP));
      paramMap = zzbf.zzag(this.zzahs, paramMap);
      if (paramMap == null) {
        break label56;
      }
    }
    label56:
    for (paramMap = zzdm.zzat(paramMap);; paramMap = zzdm.zzchm())
    {
      return paramMap;
      paramMap = null;
      break;
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */