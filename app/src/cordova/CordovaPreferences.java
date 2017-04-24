package org.apache.cordova;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CordovaPreferences
{
  private Bundle preferencesBundleExtras;
  private HashMap<String, String> prefs = new HashMap(20);
  
  public boolean contains(String paramString)
  {
    if (getString(paramString, null) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Map<String, String> getAll()
  {
    return this.prefs;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    paramString = paramString.toLowerCase(Locale.ENGLISH);
    paramString = (String)this.prefs.get(paramString);
    if (paramString != null) {
      paramBoolean = Boolean.parseBoolean(paramString);
    }
    return paramBoolean;
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    paramString = paramString.toLowerCase(Locale.ENGLISH);
    paramString = (String)this.prefs.get(paramString);
    if (paramString != null) {
      paramDouble = Double.valueOf(paramString).doubleValue();
    }
    return paramDouble;
  }
  
  public int getInteger(String paramString, int paramInt)
  {
    paramString = paramString.toLowerCase(Locale.ENGLISH);
    paramString = (String)this.prefs.get(paramString);
    if (paramString != null) {
      paramInt = (int)Long.decode(paramString).longValue();
    }
    return paramInt;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = paramString1.toLowerCase(Locale.ENGLISH);
    paramString1 = (String)this.prefs.get(paramString1);
    if (paramString1 != null) {}
    for (;;)
    {
      return paramString1;
      paramString1 = paramString2;
    }
  }
  
  public void set(String paramString, double paramDouble)
  {
    set(paramString, "" + paramDouble);
  }
  
  public void set(String paramString, int paramInt)
  {
    set(paramString, "" + paramInt);
  }
  
  public void set(String paramString1, String paramString2)
  {
    this.prefs.put(paramString1.toLowerCase(Locale.ENGLISH), paramString2);
  }
  
  public void set(String paramString, boolean paramBoolean)
  {
    set(paramString, "" + paramBoolean);
  }
  
  public void setPreferencesBundle(Bundle paramBundle)
  {
    this.preferencesBundleExtras = paramBundle;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\CordovaPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */