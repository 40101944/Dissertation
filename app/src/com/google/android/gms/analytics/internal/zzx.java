package com.google.android.gms.analytics.internal;

import android.os.Build.VERSION;
import java.io.File;

public class zzx
{
  public static int version()
  {
    try
    {
      i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        zzae.zzf("Invalid version number", Build.VERSION.SDK);
        int i = 0;
      }
    }
  }
  
  public static boolean zzfd(String paramString)
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


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */