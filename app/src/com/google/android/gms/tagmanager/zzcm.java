package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcm
  extends zzam
{
  private static final String ID = zzag.zzis.toString();
  private static final String aGv = zzah.zzmm.toString();
  private static final String aGw = zzah.zzmn.toString();
  private static final String aGx = zzah.zzqj.toString();
  private static final String aGy = zzah.zzqc.toString();
  
  public zzcm()
  {
    super(ID, new String[] { aGv, aGw });
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    Object localObject = (zzaj.zza)paramMap.get(aGv);
    zzaj.zza localzza = (zzaj.zza)paramMap.get(aGw);
    if ((localObject == null) || (localObject == zzdm.zzchm()) || (localzza == null) || (localzza == zzdm.zzchm())) {
      paramMap = zzdm.zzchm();
    }
    for (;;)
    {
      return paramMap;
      int i = 64;
      if (zzdm.zzk((zzaj.zza)paramMap.get(aGx)).booleanValue()) {
        i = 66;
      }
      paramMap = (zzaj.zza)paramMap.get(aGy);
      int j;
      if (paramMap != null)
      {
        paramMap = zzdm.zzi(paramMap);
        if (paramMap == zzdm.zzchh())
        {
          paramMap = zzdm.zzchm();
          continue;
        }
        int k = paramMap.intValue();
        j = k;
        if (k < 0) {
          paramMap = zzdm.zzchm();
        }
      }
      else
      {
        j = 1;
      }
      try
      {
        paramMap = zzdm.zzg((zzaj.zza)localObject);
        localObject = zzdm.zzg(localzza);
        localzza = null;
        localObject = Pattern.compile((String)localObject, i).matcher(paramMap);
        paramMap = localzza;
        if (((Matcher)localObject).find())
        {
          paramMap = localzza;
          if (((Matcher)localObject).groupCount() >= j) {
            paramMap = ((Matcher)localObject).group(j);
          }
        }
        if (paramMap == null) {
          paramMap = zzdm.zzchm();
        } else {
          paramMap = zzdm.zzat(paramMap);
        }
      }
      catch (PatternSyntaxException paramMap)
      {
        paramMap = zzdm.zzchm();
      }
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */