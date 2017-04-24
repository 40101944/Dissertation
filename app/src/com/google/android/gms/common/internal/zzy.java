package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;

public class zzy
{
  private static String EE;
  private static int EF;
  private static Object zzaox = new Object();
  private static boolean zzchk;
  
  public static String zzcd(Context paramContext)
  {
    zzcf(paramContext);
    return EE;
  }
  
  public static int zzce(Context paramContext)
  {
    zzcf(paramContext);
    return EF;
  }
  
  private static void zzcf(Context paramContext)
  {
    for (;;)
    {
      String str;
      synchronized (zzaox)
      {
        if (zzchk) {
          return;
        }
        zzchk = true;
        str = paramContext.getPackageName();
        paramContext = zzsz.zzco(paramContext);
      }
      try
      {
        paramContext = paramContext.getApplicationInfo(str, 128).metaData;
        if (paramContext == null)
        {
          continue;
          paramContext = finally;
          throw paramContext;
        }
        EE = paramContext.getString("com.google.app.id");
        EF = paramContext.getInt("com.google.android.gms.version");
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          Log.wtf("MetadataValueReader", "This should never happen.", paramContext);
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */