package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzmz
  extends zzg<zzmz>
{
  private String cd;
  private String ce;
  private long cf;
  private String mCategory;
  
  public String getAction()
  {
    return this.cd;
  }
  
  public String getCategory()
  {
    return this.mCategory;
  }
  
  public String getLabel()
  {
    return this.ce;
  }
  
  public long getValue()
  {
    return this.cf;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("category", this.mCategory);
    localHashMap.put("action", this.cd);
    localHashMap.put("label", this.ce);
    localHashMap.put("value", Long.valueOf(this.cf));
    return zzj(localHashMap);
  }
  
  public void zza(zzmz paramzzmz)
  {
    if (!TextUtils.isEmpty(this.mCategory)) {
      paramzzmz.zzee(this.mCategory);
    }
    if (!TextUtils.isEmpty(this.cd)) {
      paramzzmz.zzef(this.cd);
    }
    if (!TextUtils.isEmpty(this.ce)) {
      paramzzmz.zzeg(this.ce);
    }
    if (this.cf != 0L) {
      paramzzmz.zzq(this.cf);
    }
  }
  
  public void zzee(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public void zzef(String paramString)
  {
    this.cd = paramString;
  }
  
  public void zzeg(String paramString)
  {
    this.ce = paramString;
  }
  
  public void zzq(long paramLong)
  {
    this.cf = paramLong;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzmz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */