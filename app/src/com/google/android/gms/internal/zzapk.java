package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzapk<T>
{
  public abstract void zza(zzaqr paramzzaqr, T paramT)
    throws IOException;
  
  public abstract T zzb(zzaqp paramzzaqp)
    throws IOException;
  
  public final zzaoy zzcn(T paramT)
  {
    try
    {
      zzaqg localzzaqg = new com/google/android/gms/internal/zzaqg;
      localzzaqg.<init>();
      zza(localzzaqg, paramT);
      paramT = localzzaqg.bu();
      return paramT;
    }
    catch (IOException paramT)
    {
      throw new zzaoz(paramT);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzapk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */