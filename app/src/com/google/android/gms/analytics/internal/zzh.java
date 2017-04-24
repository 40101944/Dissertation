package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzaa;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzh
{
  private final String cj;
  private final long dj;
  private final String dk;
  private final boolean dl;
  private long dm;
  private final Map<String, String> zzbly;
  
  public zzh(long paramLong1, String paramString1, String paramString2, boolean paramBoolean, long paramLong2, Map<String, String> paramMap)
  {
    zzaa.zzib(paramString1);
    zzaa.zzib(paramString2);
    this.dj = paramLong1;
    this.cj = paramString1;
    this.dk = paramString2;
    this.dl = paramBoolean;
    this.dm = paramLong2;
    if (paramMap != null) {}
    for (this.zzbly = new HashMap(paramMap);; this.zzbly = Collections.emptyMap()) {
      return;
    }
  }
  
  public long zzacr()
  {
    return this.dj;
  }
  
  public String zzacs()
  {
    return this.dk;
  }
  
  public boolean zzact()
  {
    return this.dl;
  }
  
  public long zzacu()
  {
    return this.dm;
  }
  
  public Map<String, String> zzmc()
  {
    return this.zzbly;
  }
  
  public void zzr(long paramLong)
  {
    this.dm = paramLong;
  }
  
  public String zzze()
  {
    return this.cj;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */