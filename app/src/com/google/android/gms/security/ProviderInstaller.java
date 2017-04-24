package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static final zzc aDf = ;
  private static Method aDg = null;
  private static final Object zzaox = new Object();
  
  public static void installIfNeeded(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    zzaa.zzb(paramContext, "Context must not be null");
    aDf.zzbm(paramContext);
    paramContext = zze.getRemoteContext(paramContext);
    if (paramContext == null)
    {
      Log.e("ProviderInstaller", "Failed to get remote context");
      throw new GooglePlayServicesNotAvailableException(8);
    }
    for (;;)
    {
      synchronized (zzaox)
      {
        try
        {
          if (aDg == null) {
            zzdv(paramContext);
          }
          aDg.invoke(null, new Object[] { paramContext });
          return;
        }
        catch (Exception paramContext)
        {
          paramContext = String.valueOf(paramContext.getMessage());
          if (paramContext.length() == 0) {
            break label123;
          }
        }
        paramContext = "Failed to install provider: ".concat(paramContext);
        Log.e("ProviderInstaller", paramContext);
        paramContext = new com/google/android/gms/common/GooglePlayServicesNotAvailableException;
        paramContext.<init>(8);
        throw paramContext;
      }
      label123:
      paramContext = new String("Failed to install provider: ");
    }
  }
  
  public static void installIfNeededAsync(Context paramContext, final ProviderInstallListener paramProviderInstallListener)
  {
    zzaa.zzb(paramContext, "Context must not be null");
    zzaa.zzb(paramProviderInstallListener, "Listener must not be null");
    zzaa.zzhs("Must be called on the UI thread");
    new AsyncTask()
    {
      protected Integer zzc(Void... paramAnonymousVarArgs)
      {
        try
        {
          ProviderInstaller.installIfNeeded(ProviderInstaller.this);
          paramAnonymousVarArgs = Integer.valueOf(0);
        }
        catch (GooglePlayServicesRepairableException paramAnonymousVarArgs)
        {
          for (;;)
          {
            paramAnonymousVarArgs = Integer.valueOf(paramAnonymousVarArgs.getConnectionStatusCode());
          }
        }
        catch (GooglePlayServicesNotAvailableException paramAnonymousVarArgs)
        {
          for (;;)
          {
            paramAnonymousVarArgs = Integer.valueOf(paramAnonymousVarArgs.errorCode);
          }
        }
        return paramAnonymousVarArgs;
      }
      
      protected void zzg(Integer paramAnonymousInteger)
      {
        if (paramAnonymousInteger.intValue() == 0) {
          paramProviderInstallListener.onProviderInstalled();
        }
        for (;;)
        {
          return;
          Intent localIntent = ProviderInstaller.zzcda().zzb(ProviderInstaller.this, paramAnonymousInteger.intValue(), "pi");
          paramProviderInstallListener.onProviderInstallFailed(paramAnonymousInteger.intValue(), localIntent);
        }
      }
    }.execute(new Void[0]);
  }
  
  private static void zzdv(Context paramContext)
    throws ClassNotFoundException, NoSuchMethodException
  {
    aDg = paramContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class });
  }
  
  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);
    
    public abstract void onProviderInstalled();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\security\ProviderInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */