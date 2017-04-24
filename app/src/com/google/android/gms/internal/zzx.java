package com.google.android.gms.internal;

import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class zzx
{
  public static String zza(Map<String, String> paramMap)
  {
    return zzb(paramMap, "ISO-8859-1");
  }
  
  public static zzb.zza zzb(zzi paramzzi)
  {
    long l6 = System.currentTimeMillis();
    Map localMap = paramzzi.zzz;
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    Object localObject = (String)localMap.get("Date");
    if (localObject != null) {
      l3 = zzg((String)localObject);
    }
    localObject = (String)localMap.get("Cache-Control");
    int j;
    int i;
    String str;
    if (localObject != null)
    {
      localObject = ((String)localObject).split(",");
      j = 0;
      i = 0;
      l2 = 0L;
      l1 = 0L;
      if (j < localObject.length)
      {
        str = localObject[j].trim();
        if ((str.equals("no-cache")) || (str.equals("no-store")))
        {
          paramzzi = null;
          return paramzzi;
        }
        if (str.startsWith("max-age=")) {}
        for (;;)
        {
          try
          {
            l4 = Long.parseLong(str.substring(8));
            l5 = l2;
            label148:
            j++;
          }
          catch (Exception localException2)
          {
            long l5 = l2;
            long l4 = l1;
            continue;
            l1 = 0L;
            l2 = 0L;
            continue;
            l4 = 0L;
            continue;
            l5 = 0L;
            continue;
          }
          l2 = l5;
          l1 = l4;
          break;
          if (str.startsWith("stale-while-revalidate=")) {}
          try
          {
            l5 = Long.parseLong(str.substring(23));
            l4 = l1;
          }
          catch (Exception localException1)
          {
            l5 = l2;
            l4 = l1;
          }
          if (!str.equals("must-revalidate"))
          {
            l5 = l2;
            l4 = l1;
            if (!str.equals("proxy-revalidate")) {}
          }
          else
          {
            i = 1;
            l5 = l2;
            l4 = l1;
          }
        }
      }
      l4 = l1;
      l1 = l2;
      j = 1;
      l2 = l4;
    }
    for (;;)
    {
      localObject = (String)localMap.get("Expires");
      if (localObject != null)
      {
        l5 = zzg((String)localObject);
        localObject = (String)localMap.get("Last-Modified");
        if (localObject != null)
        {
          l4 = zzg((String)localObject);
          str = (String)localMap.get("ETag");
          if (j != 0)
          {
            l2 = l6 + 1000L * l2;
            if (i != 0) {
              l1 = l2;
            }
          }
          for (;;)
          {
            localObject = new zzb.zza();
            ((zzb.zza)localObject).data = paramzzi.data;
            ((zzb.zza)localObject).zza = str;
            ((zzb.zza)localObject).zze = l2;
            ((zzb.zza)localObject).zzd = l1;
            ((zzb.zza)localObject).zzb = l3;
            ((zzb.zza)localObject).zzc = l4;
            ((zzb.zza)localObject).zzf = localMap;
            paramzzi = (zzi)localObject;
            break;
            l1 = 1000L * l1 + l2;
            continue;
            if ((l3 <= 0L) || (l5 < l3)) {
              break label459;
            }
            l1 = l5 - l3 + l6;
            l2 = l1;
          }
          break label148;
        }
      }
      label459:
      i = 0;
      j = 0;
    }
  }
  
  public static String zzb(Map<String, String> paramMap, String paramString)
  {
    Object localObject = (String)paramMap.get("Content-Type");
    paramMap = paramString;
    if (localObject != null) {
      localObject = ((String)localObject).split(";");
    }
    for (int i = 1;; i++)
    {
      paramMap = paramString;
      if (i < localObject.length)
      {
        paramMap = localObject[i].trim().split("=");
        if ((paramMap.length == 2) && (paramMap[0].equals("charset"))) {
          paramMap = paramMap[1];
        }
      }
      else
      {
        return paramMap;
      }
    }
  }
  
  public static long zzg(String paramString)
  {
    try
    {
      l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException paramString)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */