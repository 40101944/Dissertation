package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzai.zzc;
import com.google.android.gms.internal.zzai.zzd;
import com.google.android.gms.internal.zzai.zzi;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzal
{
  private static void zza(DataLayer paramDataLayer, zzai.zzd paramzzd)
  {
    paramzzd = paramzzd.zzwe;
    int j = paramzzd.length;
    for (int i = 0; i < j; i++) {
      paramDataLayer.zzpb(zzdm.zzg(paramzzd[i]));
    }
  }
  
  public static void zza(DataLayer paramDataLayer, zzai.zzi paramzzi)
  {
    if (paramzzi.zzxt == null) {
      zzbo.zzdi("supplemental missing experimentSupplemental");
    }
    for (;;)
    {
      return;
      zza(paramDataLayer, paramzzi.zzxt);
      zzb(paramDataLayer, paramzzi.zzxt);
      zzc(paramDataLayer, paramzzi.zzxt);
    }
  }
  
  private static void zzb(DataLayer paramDataLayer, zzai.zzd paramzzd)
  {
    zzaj.zza[] arrayOfzza = paramzzd.zzwd;
    int j = arrayOfzza.length;
    for (int i = 0; i < j; i++)
    {
      paramzzd = zzc(arrayOfzza[i]);
      if (paramzzd != null) {
        paramDataLayer.push(paramzzd);
      }
    }
  }
  
  private static Map<String, Object> zzc(zzaj.zza paramzza)
  {
    paramzza = zzdm.zzl(paramzza);
    if (!(paramzza instanceof Map))
    {
      paramzza = String.valueOf(paramzza);
      zzbo.zzdi(String.valueOf(paramzza).length() + 36 + "value: " + paramzza + " is not a map value, ignored.");
    }
    for (paramzza = null;; paramzza = (Map)paramzza) {
      return paramzza;
    }
  }
  
  private static void zzc(DataLayer paramDataLayer, zzai.zzd paramzzd)
  {
    zzai.zzc[] arrayOfzzc = paramzzd.zzwf;
    int j = arrayOfzzc.length;
    int i = 0;
    while (i < j)
    {
      zzai.zzc localzzc = arrayOfzzc[i];
      if (localzzc.zzcb == null)
      {
        zzbo.zzdi("GaExperimentRandom: No key");
        i++;
      }
      else
      {
        Object localObject = paramDataLayer.get(localzzc.zzcb);
        if (!(localObject instanceof Number))
        {
          paramzzd = null;
          label63:
          long l1 = localzzc.zzvz;
          long l2 = localzzc.zzwa;
          if ((!localzzc.zzwb) || (paramzzd == null) || (paramzzd.longValue() < l1) || (paramzzd.longValue() > l2))
          {
            if (l1 > l2) {
              break label240;
            }
            localObject = Long.valueOf(Math.round(Math.random() * (l2 - l1) + l1));
          }
          paramDataLayer.zzpb(localzzc.zzcb);
          localObject = paramDataLayer.zzo(localzzc.zzcb, localObject);
          if (localzzc.zzwc > 0L)
          {
            if (((Map)localObject).containsKey("gtm")) {
              break label248;
            }
            ((Map)localObject).put("gtm", DataLayer.mapOf(new Object[] { "lifetime", Long.valueOf(localzzc.zzwc) }));
          }
        }
        for (;;)
        {
          paramDataLayer.push((Map)localObject);
          break;
          paramzzd = Long.valueOf(((Number)localObject).longValue());
          break label63;
          label240:
          zzbo.zzdi("GaExperimentRandom: random range invalid");
          break;
          label248:
          paramzzd = ((Map)localObject).get("gtm");
          if ((paramzzd instanceof Map)) {
            ((Map)paramzzd).put("lifetime", Long.valueOf(localzzc.zzwc));
          } else {
            zzbo.zzdi("GaExperimentRandom: gtm not a map");
          }
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */