package com.google.android.gms.analytics.internal;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

public class zzan
  implements zzp
{
  public String at;
  public double fQ = -1.0D;
  public int fR = -1;
  public int fS = -1;
  public int fT = -1;
  public int fU = -1;
  public Map<String, String> fV = new HashMap();
  
  public int getSessionTimeout()
  {
    return this.fR;
  }
  
  public String getTrackingId()
  {
    return this.at;
  }
  
  public boolean zzahc()
  {
    if (this.at != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean zzahd()
  {
    if (this.fQ >= 0.0D) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public double zzahe()
  {
    return this.fQ;
  }
  
  public boolean zzahf()
  {
    if (this.fR >= 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean zzahg()
  {
    if (this.fS != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean zzahh()
  {
    boolean bool = true;
    if (this.fS == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean zzahi()
  {
    if (this.fT != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean zzahj()
  {
    boolean bool = true;
    if (this.fT == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean zzahk()
  {
    boolean bool = true;
    if (this.fU == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String zzfh(String paramString)
  {
    String str = (String)this.fV.get(paramString);
    if (str != null) {
      paramString = str;
    }
    for (;;)
    {
      return paramString;
    }
  }
  
  public String zzr(Activity paramActivity)
  {
    return zzfh(paramActivity.getClass().getCanonicalName());
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */