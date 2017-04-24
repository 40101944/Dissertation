package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.File;

class zzan
{
  public static int version()
  {
    int i;
    try
    {
      i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      str = String.valueOf(Build.VERSION.SDK);
      if (str.length() == 0) {}
    }
    for (String str = "Invalid version number: ".concat(str);; str = new String("Invalid version number: "))
    {
      zzbo.e(str);
      i = 0;
      break;
    }
  }
  
  @TargetApi(9)
  static boolean zzfd(String paramString)
  {
    boolean bool = false;
    if (version() < 9) {}
    for (;;)
    {
      return bool;
      paramString = new File(paramString);
      paramString.setReadable(false, false);
      paramString.setWritable(false, false);
      paramString.setReadable(true, true);
      paramString.setWritable(true, true);
      bool = true;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */