package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzbg
  extends zzam
{
  private static final String ID = zzag.zziq.toString();
  private static final String aFC = zzah.zzqq.toString();
  private static final String aFD = zzah.zzqu.toString();
  private static final String aFE = zzah.zzpk.toString();
  private static final String aFk = zzah.zzmm.toString();
  
  public zzbg()
  {
    super(ID, new String[] { aFk });
  }
  
  private String zza(String paramString, zza paramzza, Set<Character> paramSet)
  {
    switch (1.aFF[paramzza.ordinal()])
    {
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramzza = zzdq.zzqe(paramString);
        paramString = paramzza;
      }
      catch (UnsupportedEncodingException paramzza)
      {
        zzbo.zzb("Joiner: unsupported encoding", paramzza);
      }
      continue;
      paramString = paramString.replace("\\", "\\\\");
      paramSet = paramSet.iterator();
      if (paramSet.hasNext())
      {
        String str = ((Character)paramSet.next()).toString();
        paramzza = String.valueOf(str);
        if (paramzza.length() != 0) {}
        for (paramzza = "\\".concat(paramzza);; paramzza = new String("\\"))
        {
          paramString = paramString.replace(str, paramzza);
          break;
        }
      }
    }
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString, zza paramzza, Set<Character> paramSet)
  {
    paramStringBuilder.append(zza(paramString, paramzza, paramSet));
  }
  
  private void zza(Set<Character> paramSet, String paramString)
  {
    for (int i = 0; i < paramString.length(); i++) {
      paramSet.add(Character.valueOf(paramString.charAt(i)));
    }
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    zzaj.zza localzza = (zzaj.zza)paramMap.get(aFk);
    if (localzza == null)
    {
      paramMap = zzdm.zzchm();
      return paramMap;
    }
    Object localObject1 = (zzaj.zza)paramMap.get(aFC);
    String str1;
    label51:
    Object localObject2;
    if (localObject1 != null)
    {
      str1 = zzdm.zzg((zzaj.zza)localObject1);
      localObject1 = (zzaj.zza)paramMap.get(aFD);
      if (localObject1 == null) {
        break label189;
      }
      localObject2 = zzdm.zzg((zzaj.zza)localObject1);
      label77:
      localObject1 = zza.aFG;
      paramMap = (zzaj.zza)paramMap.get(aFE);
      if (paramMap == null) {
        break label436;
      }
      paramMap = zzdm.zzg(paramMap);
      if (!"url".equals(paramMap)) {
        break label196;
      }
      localObject1 = zza.aFH;
      paramMap = null;
    }
    for (;;)
    {
      label120:
      StringBuilder localStringBuilder = new StringBuilder();
      switch (localzza.type)
      {
      default: 
        zza(localStringBuilder, zzdm.zzg(localzza), (zza)localObject1, paramMap);
      }
      for (;;)
      {
        paramMap = zzdm.zzat(localStringBuilder.toString());
        break;
        str1 = "";
        break label51;
        label189:
        localObject2 = "=";
        break label77;
        label196:
        if ("backslash".equals(paramMap))
        {
          localObject1 = zza.aFI;
          paramMap = new HashSet();
          zza(paramMap, str1);
          zza(paramMap, (String)localObject2);
          paramMap.remove(Character.valueOf('\\'));
          break label120;
        }
        paramMap = String.valueOf(paramMap);
        if (paramMap.length() != 0) {}
        for (paramMap = "Joiner: unsupported escape type: ".concat(paramMap);; paramMap = new String("Joiner: unsupported escape type: "))
        {
          zzbo.e(paramMap);
          paramMap = zzdm.zzchm();
          break;
        }
        int j = 1;
        localObject2 = localzza.zzxy;
        int k = localObject2.length;
        int i = 0;
        while (i < k)
        {
          localzza = localObject2[i];
          if (j == 0) {
            localStringBuilder.append(str1);
          }
          zza(localStringBuilder, zzdm.zzg(localzza), (zza)localObject1, paramMap);
          i++;
          j = 0;
        }
        for (i = 0; i < localzza.zzxz.length; i++)
        {
          if (i > 0) {
            localStringBuilder.append(str1);
          }
          String str3 = zzdm.zzg(localzza.zzxz[i]);
          String str2 = zzdm.zzg(localzza.zzya[i]);
          zza(localStringBuilder, str3, (zza)localObject1, paramMap);
          localStringBuilder.append((String)localObject2);
          zza(localStringBuilder, str2, (zza)localObject1, paramMap);
        }
      }
      label436:
      paramMap = null;
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
  
  private static enum zza
  {
    private zza() {}
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */