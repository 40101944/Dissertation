package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzbq
  extends zzam
{
  private static final String ID = zzag.zziu.toString();
  private static final String aFk = zzah.zzmm.toString();
  
  public zzbq()
  {
    super(ID, new String[] { aFk });
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    return zzdm.zzat(zzdm.zzg((zzaj.zza)paramMap.get(aFk)).toLowerCase());
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */