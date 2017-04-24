package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class zzs
  implements Logger
{
  private boolean aM;
  private int ee = 2;
  
  public void error(Exception paramException) {}
  
  public void error(String paramString) {}
  
  public int getLogLevel()
  {
    return this.ee;
  }
  
  public void info(String paramString) {}
  
  public void setLogLevel(int paramInt)
  {
    this.ee = paramInt;
    if (!this.aM)
    {
      String str1 = (String)zzy.en.get();
      String str2 = (String)zzy.en.get();
      Log.i(str1, String.valueOf(str2).length() + 91 + "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + str2 + " DEBUG");
      this.aM = true;
    }
  }
  
  public void verbose(String paramString) {}
  
  public void warn(String paramString) {}
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */