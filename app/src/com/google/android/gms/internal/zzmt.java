package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzmt
  extends zzg<zzmt>
{
  private String bQ;
  private String bR;
  private String bS;
  private String bT;
  private String bU;
  private String bV;
  private String bW;
  private String mName;
  private String zzbme;
  private String zzboa;
  
  public String getContent()
  {
    return this.zzbme;
  }
  
  public String getId()
  {
    return this.zzboa;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSource()
  {
    return this.bQ;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", this.mName);
    localHashMap.put("source", this.bQ);
    localHashMap.put("medium", this.bR);
    localHashMap.put("keyword", this.bS);
    localHashMap.put("content", this.zzbme);
    localHashMap.put("id", this.zzboa);
    localHashMap.put("adNetworkId", this.bT);
    localHashMap.put("gclid", this.bU);
    localHashMap.put("dclid", this.bV);
    localHashMap.put("aclid", this.bW);
    return zzj(localHashMap);
  }
  
  public void zza(zzmt paramzzmt)
  {
    if (!TextUtils.isEmpty(this.mName)) {
      paramzzmt.setName(this.mName);
    }
    if (!TextUtils.isEmpty(this.bQ)) {
      paramzzmt.zzdu(this.bQ);
    }
    if (!TextUtils.isEmpty(this.bR)) {
      paramzzmt.zzdv(this.bR);
    }
    if (!TextUtils.isEmpty(this.bS)) {
      paramzzmt.zzdw(this.bS);
    }
    if (!TextUtils.isEmpty(this.zzbme)) {
      paramzzmt.zzdx(this.zzbme);
    }
    if (!TextUtils.isEmpty(this.zzboa)) {
      paramzzmt.zzdy(this.zzboa);
    }
    if (!TextUtils.isEmpty(this.bT)) {
      paramzzmt.zzdz(this.bT);
    }
    if (!TextUtils.isEmpty(this.bU)) {
      paramzzmt.zzea(this.bU);
    }
    if (!TextUtils.isEmpty(this.bV)) {
      paramzzmt.zzeb(this.bV);
    }
    if (!TextUtils.isEmpty(this.bW)) {
      paramzzmt.zzec(this.bW);
    }
  }
  
  public String zzaah()
  {
    return this.bR;
  }
  
  public String zzaai()
  {
    return this.bS;
  }
  
  public String zzaaj()
  {
    return this.bT;
  }
  
  public String zzaak()
  {
    return this.bU;
  }
  
  public String zzaal()
  {
    return this.bV;
  }
  
  public String zzaam()
  {
    return this.bW;
  }
  
  public void zzdu(String paramString)
  {
    this.bQ = paramString;
  }
  
  public void zzdv(String paramString)
  {
    this.bR = paramString;
  }
  
  public void zzdw(String paramString)
  {
    this.bS = paramString;
  }
  
  public void zzdx(String paramString)
  {
    this.zzbme = paramString;
  }
  
  public void zzdy(String paramString)
  {
    this.zzboa = paramString;
  }
  
  public void zzdz(String paramString)
  {
    this.bT = paramString;
  }
  
  public void zzea(String paramString)
  {
    this.bU = paramString;
  }
  
  public void zzeb(String paramString)
  {
    this.bV = paramString;
  }
  
  public void zzec(String paramString)
  {
    this.bW = paramString;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzmt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */