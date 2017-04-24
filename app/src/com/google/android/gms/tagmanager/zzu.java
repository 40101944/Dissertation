package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzu
  extends zzam
{
  private static final String ID = zzag.zzhv.toString();
  private static final String aDR = zzah.zzlz.toString();
  private static final String aED = zzah.zzqb.toString();
  private final zza aEE;
  
  public zzu(zza paramzza)
  {
    super(ID, new String[] { aED });
    this.aEE = paramzza;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    String str = zzdm.zzg((zzaj.zza)paramMap.get(aED));
    HashMap localHashMap = new HashMap();
    paramMap = (zzaj.zza)paramMap.get(aDR);
    if (paramMap != null)
    {
      paramMap = zzdm.zzl(paramMap);
      if (!(paramMap instanceof Map))
      {
        zzbo.zzdi("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
        paramMap = zzdm.zzchm();
      }
    }
    for (;;)
    {
      return paramMap;
      Iterator localIterator = ((Map)paramMap).entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        localHashMap.put(paramMap.getKey().toString(), paramMap.getValue());
      }
      try
      {
        paramMap = zzdm.zzat(this.aEE.zzf(str, localHashMap));
      }
      catch (Exception paramMap)
      {
        paramMap = String.valueOf(paramMap.getMessage());
        zzbo.zzdi(String.valueOf(str).length() + 34 + String.valueOf(paramMap).length() + "Custom macro/tag " + str + " threw exception " + paramMap);
        paramMap = zzdm.zzchm();
      }
    }
  }
  
  public boolean zzcdu()
  {
    return false;
  }
  
  public static abstract interface zza
  {
    public abstract Object zzf(String paramString, Map<String, Object> paramMap);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */