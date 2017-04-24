package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzmx
  extends zzg<zzmx>
{
  private String bZ;
  public int ca;
  public int cb;
  public int cc;
  public int zzbzd;
  public int zzbze;
  
  public String getLanguage()
  {
    return this.bZ;
  }
  
  public void setLanguage(String paramString)
  {
    this.bZ = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("language", this.bZ);
    localHashMap.put("screenColors", Integer.valueOf(this.ca));
    localHashMap.put("screenWidth", Integer.valueOf(this.zzbzd));
    localHashMap.put("screenHeight", Integer.valueOf(this.zzbze));
    localHashMap.put("viewportWidth", Integer.valueOf(this.cb));
    localHashMap.put("viewportHeight", Integer.valueOf(this.cc));
    return zzj(localHashMap);
  }
  
  public void zza(zzmx paramzzmx)
  {
    if (this.ca != 0) {
      paramzzmx.zzby(this.ca);
    }
    if (this.zzbzd != 0) {
      paramzzmx.zzbz(this.zzbzd);
    }
    if (this.zzbze != 0) {
      paramzzmx.zzca(this.zzbze);
    }
    if (this.cb != 0) {
      paramzzmx.zzcb(this.cb);
    }
    if (this.cc != 0) {
      paramzzmx.zzcc(this.cc);
    }
    if (!TextUtils.isEmpty(this.bZ)) {
      paramzzmx.setLanguage(this.bZ);
    }
  }
  
  public int zzaaq()
  {
    return this.ca;
  }
  
  public int zzaar()
  {
    return this.zzbzd;
  }
  
  public int zzaas()
  {
    return this.zzbze;
  }
  
  public int zzaat()
  {
    return this.cb;
  }
  
  public int zzaau()
  {
    return this.cc;
  }
  
  public void zzby(int paramInt)
  {
    this.ca = paramInt;
  }
  
  public void zzbz(int paramInt)
  {
    this.zzbzd = paramInt;
  }
  
  public void zzca(int paramInt)
  {
    this.zzbze = paramInt;
  }
  
  public void zzcb(int paramInt)
  {
    this.cb = paramInt;
  }
  
  public void zzcc(int paramInt)
  {
    this.cc = paramInt;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */