package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zznd
  extends zzg<zznd>
{
  public String cd;
  public String cx;
  public String cy;
  
  public String getAction()
  {
    return this.cd;
  }
  
  public String getTarget()
  {
    return this.cy;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("network", this.cx);
    localHashMap.put("action", this.cd);
    localHashMap.put("target", this.cy);
    return zzj(localHashMap);
  }
  
  public void zza(zznd paramzznd)
  {
    if (!TextUtils.isEmpty(this.cx)) {
      paramzznd.zzem(this.cx);
    }
    if (!TextUtils.isEmpty(this.cd)) {
      paramzznd.zzef(this.cd);
    }
    if (!TextUtils.isEmpty(this.cy)) {
      paramzznd.zzen(this.cy);
    }
  }
  
  public String zzabl()
  {
    return this.cx;
  }
  
  public void zzef(String paramString)
  {
    this.cd = paramString;
  }
  
  public void zzem(String paramString)
  {
    this.cx = paramString;
  }
  
  public void zzen(String paramString)
  {
    this.cy = paramString;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zznd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */