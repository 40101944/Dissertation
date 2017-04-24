package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzne
  extends zzg<zzne>
{
  public long cA;
  public String ce;
  public String cz;
  public String mCategory;
  
  public String getCategory()
  {
    return this.mCategory;
  }
  
  public String getLabel()
  {
    return this.ce;
  }
  
  public long getTimeInMillis()
  {
    return this.cA;
  }
  
  public void setTimeInMillis(long paramLong)
  {
    this.cA = paramLong;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("variableName", this.cz);
    localHashMap.put("timeInMillis", Long.valueOf(this.cA));
    localHashMap.put("category", this.mCategory);
    localHashMap.put("label", this.ce);
    return zzj(localHashMap);
  }
  
  public void zza(zzne paramzzne)
  {
    if (!TextUtils.isEmpty(this.cz)) {
      paramzzne.zzeo(this.cz);
    }
    if (this.cA != 0L) {
      paramzzne.setTimeInMillis(this.cA);
    }
    if (!TextUtils.isEmpty(this.mCategory)) {
      paramzzne.zzee(this.mCategory);
    }
    if (!TextUtils.isEmpty(this.ce)) {
      paramzzne.zzeg(this.ce);
    }
  }
  
  public String zzabm()
  {
    return this.cz;
  }
  
  public void zzee(String paramString)
  {
    this.mCategory = paramString;
  }
  
  public void zzeg(String paramString)
  {
    this.ce = paramString;
  }
  
  public void zzeo(String paramString)
  {
    this.cz = paramString;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */