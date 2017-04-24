package com.google.android.gms.internal;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.concurrent.Callable;

public class zzvv
{
  public static <T> T zzb(Callable<T> paramCallable)
  {
    localThreadPolicy = StrictMode.getThreadPolicy();
    try
    {
      StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
      paramCallable = paramCallable.call();
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
    catch (Throwable paramCallable)
    {
      for (;;)
      {
        paramCallable = paramCallable;
        StrictMode.setThreadPolicy(localThreadPolicy);
        paramCallable = null;
      }
    }
    finally
    {
      paramCallable = finally;
      StrictMode.setThreadPolicy(localThreadPolicy);
      throw paramCallable;
    }
    return paramCallable;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzvv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */