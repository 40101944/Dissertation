package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzna
  extends zzg<zzna>
{
  public String cg;
  public boolean ch;
  
  public String getDescription()
  {
    return this.cg;
  }
  
  public void setDescription(String paramString)
  {
    this.cg = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("description", this.cg);
    localHashMap.put("fatal", Boolean.valueOf(this.ch));
    return zzj(localHashMap);
  }
  
  public void zza(zzna paramzzna)
  {
    if (!TextUtils.isEmpty(this.cg)) {
      paramzzna.setDescription(this.cg);
    }
    if (this.ch) {
      paramzzna.zzar(this.ch);
    }
  }
  
  public boolean zzaaz()
  {
    return this.ch;
  }
  
  public void zzar(boolean paramBoolean)
  {
    this.ch = paramBoolean;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */