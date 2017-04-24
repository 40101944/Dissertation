package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.common.internal.zzaa;
import java.util.HashMap;
import java.util.Map;

public final class zznb
  extends zzg<zznb>
{
  private String ci;
  private String cj;
  private String ck;
  private String cl;
  private boolean cm;
  private String cn;
  private boolean co;
  private double cp;
  
  public String getUserId()
  {
    return this.ck;
  }
  
  public void setClientId(String paramString)
  {
    this.cj = paramString;
  }
  
  public void setSampleRate(double paramDouble)
  {
    if ((paramDouble >= 0.0D) && (paramDouble <= 100.0D)) {}
    for (boolean bool = true;; bool = false)
    {
      zzaa.zzb(bool, "Sample rate must be between 0% and 100%");
      this.cp = paramDouble;
      return;
    }
  }
  
  public void setUserId(String paramString)
  {
    this.ck = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("hitType", this.ci);
    localHashMap.put("clientId", this.cj);
    localHashMap.put("userId", this.ck);
    localHashMap.put("androidAdId", this.cl);
    localHashMap.put("AdTargetingEnabled", Boolean.valueOf(this.cm));
    localHashMap.put("sessionControl", this.cn);
    localHashMap.put("nonInteraction", Boolean.valueOf(this.co));
    localHashMap.put("sampleRate", Double.valueOf(this.cp));
    return zzj(localHashMap);
  }
  
  public void zza(zznb paramzznb)
  {
    if (!TextUtils.isEmpty(this.ci)) {
      paramzznb.zzeh(this.ci);
    }
    if (!TextUtils.isEmpty(this.cj)) {
      paramzznb.setClientId(this.cj);
    }
    if (!TextUtils.isEmpty(this.ck)) {
      paramzznb.setUserId(this.ck);
    }
    if (!TextUtils.isEmpty(this.cl)) {
      paramzznb.zzei(this.cl);
    }
    if (this.cm) {
      paramzznb.zzas(true);
    }
    if (!TextUtils.isEmpty(this.cn)) {
      paramzznb.zzej(this.cn);
    }
    if (this.co) {
      paramzznb.zzat(this.co);
    }
    if (this.cp != 0.0D) {
      paramzznb.setSampleRate(this.cp);
    }
  }
  
  public String zzaba()
  {
    return this.ci;
  }
  
  public String zzabb()
  {
    return this.cl;
  }
  
  public boolean zzabc()
  {
    return this.cm;
  }
  
  public String zzabd()
  {
    return this.cn;
  }
  
  public boolean zzabe()
  {
    return this.co;
  }
  
  public double zzabf()
  {
    return this.cp;
  }
  
  public void zzas(boolean paramBoolean)
  {
    this.cm = paramBoolean;
  }
  
  public void zzat(boolean paramBoolean)
  {
    this.co = paramBoolean;
  }
  
  public void zzeh(String paramString)
  {
    this.ci = paramString;
  }
  
  public void zzei(String paramString)
  {
    this.cl = paramString;
  }
  
  public void zzej(String paramString)
  {
    this.cn = paramString;
  }
  
  public String zzze()
  {
    return this.cj;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zznb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */