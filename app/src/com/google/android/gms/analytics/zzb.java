package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzms;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmv;
import com.google.android.gms.internal.zzmw;
import com.google.android.gms.internal.zzmx;
import com.google.android.gms.internal.zzmy;
import com.google.android.gms.internal.zzmz;
import com.google.android.gms.internal.zzna;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzne;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzb
  extends com.google.android.gms.analytics.internal.zzc
  implements zzk
{
  private static DecimalFormat as;
  private final zzf ao;
  private final String at;
  private final Uri au;
  private final boolean av;
  private final boolean aw;
  
  public zzb(zzf paramzzf, String paramString)
  {
    this(paramzzf, paramString, true, false);
  }
  
  public zzb(zzf paramzzf, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramzzf);
    zzaa.zzib(paramString);
    this.ao = paramzzf;
    this.at = paramString;
    this.av = paramBoolean1;
    this.aw = paramBoolean2;
    this.au = zzdt(this.at);
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, double paramDouble)
  {
    if (paramDouble != 0.0D) {
      paramMap.put(paramString, zzb(paramDouble));
    }
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      paramMap.put(paramString, 23 + paramInt1 + "x" + paramInt2);
    }
  }
  
  private static void zza(Map<String, String> paramMap, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramMap.put(paramString, "1");
    }
  }
  
  private static String zzaq(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
  
  static String zzb(double paramDouble)
  {
    if (as == null) {
      as = new DecimalFormat("0.######");
    }
    return as.format(paramDouble);
  }
  
  private static void zzb(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static Map<String, String> zzc(zze paramzze)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = (zzmw)paramzze.zza(zzmw.class);
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((zzmw)localObject1).zzaap().entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = zzi(((Map.Entry)localObject1).getValue());
        if (localObject3 != null) {
          localHashMap.put((String)((Map.Entry)localObject1).getKey(), localObject3);
        }
      }
    }
    localObject1 = (zznb)paramzze.zza(zznb.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "t", ((zznb)localObject1).zzaba());
      zzb(localHashMap, "cid", ((zznb)localObject1).zzze());
      zzb(localHashMap, "uid", ((zznb)localObject1).getUserId());
      zzb(localHashMap, "sc", ((zznb)localObject1).zzabd());
      zza(localHashMap, "sf", ((zznb)localObject1).zzabf());
      zza(localHashMap, "ni", ((zznb)localObject1).zzabe());
      zzb(localHashMap, "adid", ((zznb)localObject1).zzabb());
      zza(localHashMap, "ate", ((zznb)localObject1).zzabc());
    }
    localObject1 = (zznc)paramzze.zza(zznc.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "cd", ((zznc)localObject1).zzabh());
      zza(localHashMap, "a", ((zznc)localObject1).zzabi());
      zzb(localHashMap, "dr", ((zznc)localObject1).zzabj());
    }
    localObject1 = (zzmz)paramzze.zza(zzmz.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "ec", ((zzmz)localObject1).getCategory());
      zzb(localHashMap, "ea", ((zzmz)localObject1).getAction());
      zzb(localHashMap, "el", ((zzmz)localObject1).getLabel());
      zza(localHashMap, "ev", ((zzmz)localObject1).getValue());
    }
    localObject1 = (zzmt)paramzze.zza(zzmt.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "cn", ((zzmt)localObject1).getName());
      zzb(localHashMap, "cs", ((zzmt)localObject1).getSource());
      zzb(localHashMap, "cm", ((zzmt)localObject1).zzaah());
      zzb(localHashMap, "ck", ((zzmt)localObject1).zzaai());
      zzb(localHashMap, "cc", ((zzmt)localObject1).getContent());
      zzb(localHashMap, "ci", ((zzmt)localObject1).getId());
      zzb(localHashMap, "anid", ((zzmt)localObject1).zzaaj());
      zzb(localHashMap, "gclid", ((zzmt)localObject1).zzaak());
      zzb(localHashMap, "dclid", ((zzmt)localObject1).zzaal());
      zzb(localHashMap, "aclid", ((zzmt)localObject1).zzaam());
    }
    localObject1 = (zzna)paramzze.zza(zzna.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "exd", ((zzna)localObject1).getDescription());
      zza(localHashMap, "exf", ((zzna)localObject1).zzaaz());
    }
    localObject1 = (zznd)paramzze.zza(zznd.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "sn", ((zznd)localObject1).zzabl());
      zzb(localHashMap, "sa", ((zznd)localObject1).getAction());
      zzb(localHashMap, "st", ((zznd)localObject1).getTarget());
    }
    localObject1 = (zzne)paramzze.zza(zzne.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "utv", ((zzne)localObject1).zzabm());
      zza(localHashMap, "utt", ((zzne)localObject1).getTimeInMillis());
      zzb(localHashMap, "utc", ((zzne)localObject1).getCategory());
      zzb(localHashMap, "utl", ((zzne)localObject1).getLabel());
    }
    localObject1 = (zzmu)paramzze.zza(zzmu.class);
    if (localObject1 != null)
    {
      localObject1 = ((zzmu)localObject1).zzaan().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = zzc.zzbm(((Integer)((Map.Entry)localObject3).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localHashMap.put(localObject2, (String)((Map.Entry)localObject3).getValue());
        }
      }
    }
    localObject1 = (zzmv)paramzze.zza(zzmv.class);
    if (localObject1 != null)
    {
      localObject3 = ((zzmv)localObject1).zzaao().entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject3).next();
        localObject1 = zzc.zzbo(((Integer)((Map.Entry)localObject2).getKey()).intValue());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localHashMap.put(localObject1, zzb(((Double)((Map.Entry)localObject2).getValue()).doubleValue()));
        }
      }
    }
    localObject1 = (zzmy)paramzze.zza(zzmy.class);
    if (localObject1 != null)
    {
      localObject2 = ((zzmy)localObject1).zzaav();
      if (localObject2 != null)
      {
        localObject2 = ((ProductAction)localObject2).build().entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (((String)((Map.Entry)localObject3).getKey()).startsWith("&")) {
            localHashMap.put(((String)((Map.Entry)localObject3).getKey()).substring(1), (String)((Map.Entry)localObject3).getValue());
          } else {
            localHashMap.put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          }
        }
      }
      localObject2 = ((zzmy)localObject1).zzaay().iterator();
      for (int i = 1; ((Iterator)localObject2).hasNext(); i++) {
        localHashMap.putAll(((Promotion)((Iterator)localObject2).next()).zzep(zzc.zzbs(i)));
      }
      localObject2 = ((zzmy)localObject1).zzaaw().iterator();
      for (i = 1; ((Iterator)localObject2).hasNext(); i++) {
        localHashMap.putAll(((Product)((Iterator)localObject2).next()).zzep(zzc.zzbq(i)));
      }
      localObject3 = ((zzmy)localObject1).zzaax().entrySet().iterator();
      i = 1;
      if (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject3).next();
        localObject1 = (List)((Map.Entry)localObject2).getValue();
        String str1 = zzc.zzbv(i);
        Iterator localIterator = ((List)localObject1).iterator();
        int j = 1;
        if (localIterator.hasNext())
        {
          Product localProduct = (Product)localIterator.next();
          localObject1 = String.valueOf(str1);
          String str2 = String.valueOf(zzc.zzbt(j));
          if (str2.length() != 0) {}
          for (localObject1 = ((String)localObject1).concat(str2);; localObject1 = new String((String)localObject1))
          {
            localHashMap.putAll(localProduct.zzep((String)localObject1));
            j++;
            break;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject2).getKey()))
        {
          str1 = String.valueOf(str1);
          localObject1 = String.valueOf("nm");
          if (((String)localObject1).length() == 0) {
            break label1275;
          }
        }
        label1275:
        for (localObject1 = str1.concat((String)localObject1);; localObject1 = new String(str1))
        {
          localHashMap.put(localObject1, (String)((Map.Entry)localObject2).getKey());
          i++;
          break;
        }
      }
    }
    localObject1 = (zzmx)paramzze.zza(zzmx.class);
    if (localObject1 != null)
    {
      zzb(localHashMap, "ul", ((zzmx)localObject1).getLanguage());
      zza(localHashMap, "sd", ((zzmx)localObject1).zzaaq());
      zza(localHashMap, "sr", ((zzmx)localObject1).zzaar(), ((zzmx)localObject1).zzaas());
      zza(localHashMap, "vp", ((zzmx)localObject1).zzaat(), ((zzmx)localObject1).zzaau());
    }
    paramzze = (zzms)paramzze.zza(zzms.class);
    if (paramzze != null)
    {
      zzb(localHashMap, "an", paramzze.zzaae());
      zzb(localHashMap, "aid", paramzze.zzup());
      zzb(localHashMap, "aiid", paramzze.zzaag());
      zzb(localHashMap, "av", paramzze.zzaaf());
    }
    return localHashMap;
  }
  
  static Uri zzdt(String paramString)
  {
    zzaa.zzib(paramString);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("google-analytics.com");
    localBuilder.path(paramString);
    return localBuilder.build();
  }
  
  private static String zzi(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return (String)paramObject;
      if ((paramObject instanceof String))
      {
        String str = (String)paramObject;
        paramObject = str;
        if (TextUtils.isEmpty(str)) {
          paramObject = null;
        }
      }
      else if ((paramObject instanceof Double))
      {
        paramObject = (Double)paramObject;
        if (((Double)paramObject).doubleValue() != 0.0D) {
          paramObject = zzb(((Double)paramObject).doubleValue());
        } else {
          paramObject = null;
        }
      }
      else if ((paramObject instanceof Boolean))
      {
        if (paramObject != Boolean.FALSE) {
          paramObject = "1";
        } else {
          paramObject = null;
        }
      }
      else
      {
        paramObject = String.valueOf(paramObject);
      }
    }
  }
  
  public void zzb(zze paramzze)
  {
    zzaa.zzy(paramzze);
    zzaa.zzb(paramzze.zzzn(), "Can't deliver not submitted measurement");
    zzaa.zzht("deliver should be called on worker thread");
    Object localObject2 = paramzze.zzzi();
    Object localObject1 = (zznb)((zze)localObject2).zzb(zznb.class);
    if (TextUtils.isEmpty(((zznb)localObject1).zzaba())) {
      zzaca().zzh(zzc((zze)localObject2), "Ignoring measurement without type");
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(((zznb)localObject1).zzze()))
      {
        zzaca().zzh(zzc((zze)localObject2), "Ignoring measurement without client id");
      }
      else if (!this.ao.zzacn().getAppOptOut())
      {
        double d = ((zznb)localObject1).zzabf();
        if (zzao.zza(d, ((zznb)localObject1).zzze()))
        {
          zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(d));
        }
        else
        {
          localObject2 = zzc((zze)localObject2);
          ((Map)localObject2).put("v", "1");
          ((Map)localObject2).put("_v", com.google.android.gms.analytics.internal.zze.cS);
          ((Map)localObject2).put("tid", this.at);
          if (!this.ao.zzacn().isDryRunEnabled()) {
            break;
          }
          zzc("Dry run is enabled. GoogleAnalytics would have sent", zzaq((Map)localObject2));
        }
      }
    }
    HashMap localHashMap = new HashMap();
    zzao.zzc(localHashMap, "uid", ((zznb)localObject1).getUserId());
    Object localObject3 = (zzms)paramzze.zza(zzms.class);
    if (localObject3 != null)
    {
      zzao.zzc(localHashMap, "an", ((zzms)localObject3).zzaae());
      zzao.zzc(localHashMap, "aid", ((zzms)localObject3).zzup());
      zzao.zzc(localHashMap, "av", ((zzms)localObject3).zzaaf());
      zzao.zzc(localHashMap, "aiid", ((zzms)localObject3).zzaag());
    }
    localObject3 = ((zznb)localObject1).zzze();
    String str = this.at;
    if (!TextUtils.isEmpty(((zznb)localObject1).zzabb())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new zzh(0L, (String)localObject3, str, bool, 0L, localHashMap);
      ((Map)localObject2).put("_s", String.valueOf(zzzg().zza((zzh)localObject1)));
      paramzze = new zzab(zzaca(), (Map)localObject2, paramzze.zzzl(), true);
      zzzg().zza(paramzze);
      break;
    }
  }
  
  public Uri zzyx()
  {
    return this.au;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */