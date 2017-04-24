package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj
  extends zzdk
{
  private static final String ID = zzag.zzjx.toString();
  private static final String URL = zzah.zzva.toString();
  private static final String aDR = zzah.zzlz.toString();
  private static final String aDS = zzah.zzuz.toString();
  static final String aDT;
  private static final Set<String> aDU = new HashSet();
  private final zza aDV;
  private final Context mContext;
  
  static
  {
    String str = ID;
    aDT = String.valueOf(str).length() + 17 + "gtm_" + str + "_unrepeatable";
  }
  
  public zzj(Context paramContext)
  {
    this(paramContext, new zza()
    {
      public zzat zzcdv()
      {
        return zzaa.zzdx(zzj.this);
      }
    });
  }
  
  zzj(Context paramContext, zza paramzza)
  {
    super(ID, new String[] { URL });
    this.aDV = paramzza;
    this.mContext = paramContext;
  }
  
  private boolean zzop(String paramString)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = zzor(paramString);
        if (bool2) {
          return bool1;
        }
        if (zzoq(paramString)) {
          aDU.add(paramString);
        } else {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  public void zzba(Map<String, zzaj.zza> paramMap)
  {
    if (paramMap.get(aDS) != null) {}
    for (String str = zzdm.zzg((zzaj.zza)paramMap.get(aDS)); (str != null) && (zzop(str)); str = null) {
      return;
    }
    Uri.Builder localBuilder = Uri.parse(zzdm.zzg((zzaj.zza)paramMap.get(URL))).buildUpon();
    paramMap = (zzaj.zza)paramMap.get(aDR);
    if (paramMap != null)
    {
      paramMap = zzdm.zzl(paramMap);
      if (!(paramMap instanceof List))
      {
        paramMap = String.valueOf(localBuilder.build().toString());
        if (paramMap.length() != 0) {}
        for (paramMap = "ArbitraryPixel: additional params not a list: not sending partial hit: ".concat(paramMap);; paramMap = new String("ArbitraryPixel: additional params not a list: not sending partial hit: "))
        {
          zzbo.e(paramMap);
          break;
        }
      }
      paramMap = ((List)paramMap).iterator();
      for (;;)
      {
        if (!paramMap.hasNext()) {
          break label289;
        }
        Object localObject = paramMap.next();
        if (!(localObject instanceof Map))
        {
          paramMap = String.valueOf(localBuilder.build().toString());
          if (paramMap.length() != 0) {}
          for (paramMap = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ".concat(paramMap);; paramMap = new String("ArbitraryPixel: additional params contains non-map: not sending partial hit: "))
          {
            zzbo.e(paramMap);
            break;
          }
        }
        Iterator localIterator = ((Map)localObject).entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (Map.Entry)localIterator.next();
          localBuilder.appendQueryParameter(((Map.Entry)localObject).getKey().toString(), ((Map.Entry)localObject).getValue().toString());
        }
      }
    }
    label289:
    paramMap = localBuilder.build().toString();
    this.aDV.zzcdv().zzpg(paramMap);
    paramMap = String.valueOf(paramMap);
    if (paramMap.length() != 0) {}
    for (paramMap = "ArbitraryPixel: url = ".concat(paramMap);; paramMap = new String("ArbitraryPixel: url = "))
    {
      zzbo.v(paramMap);
      if (str == null) {
        break;
      }
      try
      {
        aDU.add(str);
        zzdd.zzc(this.mContext, aDT, str, "true");
        break;
      }
      finally {}
    }
  }
  
  boolean zzoq(String paramString)
  {
    return this.mContext.getSharedPreferences(aDT, 0).contains(paramString);
  }
  
  boolean zzor(String paramString)
  {
    return aDU.contains(paramString);
  }
  
  public static abstract interface zza
  {
    public abstract zzat zzcdv();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */