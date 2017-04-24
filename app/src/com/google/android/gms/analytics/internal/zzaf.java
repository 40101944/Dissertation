package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzaf
  extends zzd
{
  private static String fu = "3";
  private static String fv = "01VDIWEA?";
  private static zzaf fw;
  
  public zzaf(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public static zzaf zzagg()
  {
    return fw;
  }
  
  public void zza(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str = (String)zzy.en.get();
    if (Log.isLoggable(str, paramInt)) {
      Log.println(paramInt, str, zzc(paramString, paramObject1, paramObject2, paramObject3));
    }
    if (paramInt >= 5) {
      zzb(paramInt, paramString, paramObject1, paramObject2, paramObject3);
    }
  }
  
  public void zza(zzab paramzzab, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "no reason provided";
    }
    if (paramzzab != null)
    {
      paramzzab = paramzzab.toString();
      paramString = String.valueOf(str);
      if (paramString.length() == 0) {
        break label50;
      }
    }
    label50:
    for (paramString = "Discarding hit. ".concat(paramString);; paramString = new String("Discarding hit. "))
    {
      zzd(paramString, paramzzab);
      return;
      paramzzab = "no hit data";
      break;
    }
  }
  
  public void zzb(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        zzaa.zzy(paramString);
        if (paramInt < 0)
        {
          paramInt = i;
          if (paramInt >= fv.length())
          {
            paramInt = fv.length() - 1;
            if (zzacb().zzaef())
            {
              zzacb();
              c1 = 'C';
              String str1 = fu;
              char c2 = fv.charAt(paramInt);
              String str2 = zze.VERSION;
              paramString = String.valueOf(zzc(paramString, zzm(paramObject1), zzm(paramObject2), zzm(paramObject3)));
              paramObject1 = new java/lang/StringBuilder;
              ((StringBuilder)paramObject1).<init>(String.valueOf(str1).length() + 3 + String.valueOf(str2).length() + String.valueOf(paramString).length());
              paramObject1 = str1 + c2 + c1 + str2 + ":" + paramString;
              paramString = (String)paramObject1;
              if (((String)paramObject1).length() > 1024) {
                paramString = ((String)paramObject1).substring(0, 1024);
              }
              paramObject1 = zzabx().zzaco();
              if (paramObject1 != null) {
                ((zzai)paramObject1).zzagt().zzfg(paramString);
              }
              return;
            }
            zzacb();
            char c1 = 'c';
            continue;
          }
        }
      }
      finally {}
    }
  }
  
  public void zzh(Map<String, String> paramMap, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "no reason provided";
    }
    if (paramMap != null)
    {
      paramString = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (paramString.length() > 0) {
          paramString.append(',');
        }
        paramString.append((String)localEntry.getKey());
        paramString.append('=');
        paramString.append((String)localEntry.getValue());
      }
      paramMap = paramString.toString();
      paramString = String.valueOf(str);
      if (paramString.length() == 0) {
        break label144;
      }
    }
    label144:
    for (paramString = "Discarding hit. ".concat(paramString);; paramString = new String("Discarding hit. "))
    {
      zzd(paramString, paramMap);
      return;
      paramMap = "no hit data";
      break;
    }
  }
  
  protected String zzm(Object paramObject)
  {
    if (paramObject == null)
    {
      paramObject = null;
      return (String)paramObject;
    }
    if ((paramObject instanceof Integer)) {
      paramObject = new Long(((Integer)paramObject).intValue());
    }
    for (;;)
    {
      if ((paramObject instanceof Long))
      {
        if (Math.abs(((Long)paramObject).longValue()) < 100L)
        {
          paramObject = String.valueOf(paramObject);
          break;
        }
        if (String.valueOf(paramObject).charAt(0) == '-') {}
        for (String str = "-";; str = "")
        {
          paramObject = String.valueOf(Math.abs(((Long)paramObject).longValue()));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(Math.round(Math.pow(10.0D, ((String)paramObject).length() - 1)));
          localStringBuilder.append("...");
          localStringBuilder.append(str);
          localStringBuilder.append(Math.round(Math.pow(10.0D, ((String)paramObject).length()) - 1.0D));
          paramObject = localStringBuilder.toString();
          break;
        }
      }
      if ((paramObject instanceof Boolean))
      {
        paramObject = String.valueOf(paramObject);
        break;
      }
      if ((paramObject instanceof Throwable))
      {
        paramObject = paramObject.getClass().getCanonicalName();
        break;
      }
      paramObject = "-";
      break;
    }
  }
  
  protected void zzzy()
  {
    try
    {
      fw = this;
      return;
    }
    finally {}
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */