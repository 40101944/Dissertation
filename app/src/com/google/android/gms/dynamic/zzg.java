package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.zze;

public abstract class zzg<T>
{
  private final String Qe;
  private T Qf;
  
  protected zzg(String paramString)
  {
    this.Qe = paramString;
  }
  
  protected abstract T zzc(IBinder paramIBinder);
  
  protected final T zzcr(Context paramContext)
    throws zzg.zza
  {
    if (this.Qf == null)
    {
      zzaa.zzy(paramContext);
      paramContext = zze.getRemoteContext(paramContext);
      if (paramContext == null) {
        throw new zza("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.Qf = zzc((IBinder)paramContext.loadClass(this.Qe).newInstance());
      return (T)this.Qf;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new zza("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new zza("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new zza("Could not access creator.", paramContext);
    }
  }
  
  public static class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
    
    public zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\dynamic\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */