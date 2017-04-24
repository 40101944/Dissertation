package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzms
  extends zzg<zzms>
{
  private String bN;
  private String bO;
  private String bP;
  private String zzctj;
  
  public void setAppId(String paramString)
  {
    this.zzctj = paramString;
  }
  
  public void setAppInstallerId(String paramString)
  {
    this.bP = paramString;
  }
  
  public void setAppName(String paramString)
  {
    this.bN = paramString;
  }
  
  public void setAppVersion(String paramString)
  {
    this.bO = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appName", this.bN);
    localHashMap.put("appVersion", this.bO);
    localHashMap.put("appId", this.zzctj);
    localHashMap.put("appInstallerId", this.bP);
    return zzj(localHashMap);
  }
  
  public void zza(zzms paramzzms)
  {
    if (!TextUtils.isEmpty(this.bN)) {
      paramzzms.setAppName(this.bN);
    }
    if (!TextUtils.isEmpty(this.bO)) {
      paramzzms.setAppVersion(this.bO);
    }
    if (!TextUtils.isEmpty(this.zzctj)) {
      paramzzms.setAppId(this.zzctj);
    }
    if (!TextUtils.isEmpty(this.bP)) {
      paramzzms.setAppInstallerId(this.bP);
    }
  }
  
  public String zzaae()
  {
    return this.bN;
  }
  
  public String zzaaf()
  {
    return this.bO;
  }
  
  public String zzaag()
  {
    return this.bP;
  }
  
  public String zzup()
  {
    return this.zzctj;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */