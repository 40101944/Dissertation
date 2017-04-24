package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzg;
import com.google.android.gms.common.internal.zzaa;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzmw
  extends zzg<zzmw>
{
  private final Map<String, Object> zzbly = new HashMap();
  
  private String zzed(String paramString)
  {
    zzaa.zzib(paramString);
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("&")) {
        str = paramString.substring(1);
      }
    }
    zzaa.zzh(str, "Name can not be empty or \"&\"");
    return str;
  }
  
  public void set(String paramString1, String paramString2)
  {
    paramString1 = zzed(paramString1);
    this.zzbly.put(paramString1, paramString2);
  }
  
  public String toString()
  {
    return zzj(this.zzbly);
  }
  
  public void zza(zzmw paramzzmw)
  {
    zzaa.zzy(paramzzmw);
    paramzzmw.zzbly.putAll(this.zzbly);
  }
  
  public Map<String, Object> zzaap()
  {
    return Collections.unmodifiableMap(this.zzbly);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzmw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */