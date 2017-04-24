package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class zzci
  extends zzam
{
  private static final String aFk = zzah.zzmm.toString();
  private static final String aGj = zzah.zzmn.toString();
  
  public zzci(String paramString)
  {
    super(paramString, new String[] { aFk, aGj });
  }
  
  protected abstract boolean zza(zzaj.zza paramzza1, zzaj.zza paramzza2, Map<String, zzaj.zza> paramMap);
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    Object localObject = paramMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((zzaj.zza)((Iterator)localObject).next() == zzdm.zzchm())
      {
        paramMap = zzdm.zzat(Boolean.valueOf(false));
        return paramMap;
      }
    }
    zzaj.zza localzza = (zzaj.zza)paramMap.get(aFk);
    localObject = (zzaj.zza)paramMap.get(aGj);
    if ((localzza == null) || (localObject == null)) {}
    for (boolean bool = false;; bool = zza(localzza, (zzaj.zza)localObject, paramMap))
    {
      paramMap = zzdm.zzat(Boolean.valueOf(bool));
      break;
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */