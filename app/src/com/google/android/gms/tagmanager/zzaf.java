package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzaf
  extends zzam
{
  private static final String ID = zzag.zzim.toString();
  private static final String aFk = zzah.zzmm.toString();
  private static final String aFl = zzah.zzrs.toString();
  private static final String aFm = zzah.zzql.toString();
  private static final String aFn = zzah.zzsc.toString();
  
  public zzaf()
  {
    super(ID, new String[] { aFk });
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    Object localObject = (zzaj.zza)paramMap.get(aFk);
    if ((localObject == null) || (localObject == zzdm.zzchm()))
    {
      paramMap = zzdm.zzchm();
      return paramMap;
    }
    String str2 = zzdm.zzg((zzaj.zza)localObject);
    localObject = (zzaj.zza)paramMap.get(aFm);
    String str1;
    if (localObject == null)
    {
      str1 = "text";
      label57:
      localObject = (zzaj.zza)paramMap.get(aFn);
      if (localObject != null) {
        break label153;
      }
      localObject = "base16";
      label77:
      paramMap = (zzaj.zza)paramMap.get(aFl);
      if ((paramMap == null) || (!zzdm.zzk(paramMap).booleanValue())) {
        break label362;
      }
    }
    label153:
    label280:
    label319:
    label362:
    for (int i = 3;; i = 2)
    {
      for (;;)
      {
        try
        {
          if ("text".equals(str1))
          {
            paramMap = str2.getBytes();
            if (!"base16".equals(localObject)) {
              break label280;
            }
            paramMap = zzk.zzq(paramMap);
            paramMap = zzdm.zzat(paramMap);
            break;
            str1 = zzdm.zzg((zzaj.zza)localObject);
            break label57;
            localObject = zzdm.zzg((zzaj.zza)localObject);
            break label77;
          }
          if ("base16".equals(str1))
          {
            paramMap = zzk.zzos(str2);
            continue;
          }
          if ("base64".equals(str1))
          {
            paramMap = Base64.decode(str2, i);
            continue;
          }
          if ("base64url".equals(str1))
          {
            paramMap = Base64.decode(str2, i | 0x8);
            continue;
          }
          paramMap = String.valueOf(str1);
          if (paramMap.length() != 0)
          {
            paramMap = "Encode: unknown input format: ".concat(paramMap);
            zzbo.e(paramMap);
            paramMap = zzdm.zzchm();
            break;
          }
          paramMap = new String("Encode: unknown input format: ");
          continue;
        }
        catch (IllegalArgumentException paramMap)
        {
          zzbo.e("Encode: invalid input:");
          paramMap = zzdm.zzchm();
        }
        if ("base64".equals(localObject))
        {
          paramMap = Base64.encodeToString(paramMap, i);
        }
        else
        {
          if (!"base64url".equals(localObject)) {
            break label319;
          }
          paramMap = Base64.encodeToString(paramMap, i | 0x8);
        }
      }
      paramMap = String.valueOf(localObject);
      if (paramMap.length() != 0) {}
      for (paramMap = "Encode: unknown output format: ".concat(paramMap);; paramMap = new String("Encode: unknown output format: "))
      {
        zzbo.e(paramMap);
        paramMap = zzdm.zzchm();
        break;
      }
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */