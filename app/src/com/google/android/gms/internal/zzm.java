package com.google.android.gms.internal;

public class zzm<T>
{
  public final T result;
  public final zzb.zza zzbf;
  public final zzr zzbg;
  public boolean zzbh = false;
  
  private zzm(zzr paramzzr)
  {
    this.result = null;
    this.zzbf = null;
    this.zzbg = paramzzr;
  }
  
  private zzm(T paramT, zzb.zza paramzza)
  {
    this.result = paramT;
    this.zzbf = paramzza;
    this.zzbg = null;
  }
  
  public static <T> zzm<T> zza(T paramT, zzb.zza paramzza)
  {
    return new zzm(paramT, paramzza);
  }
  
  public static <T> zzm<T> zzd(zzr paramzzr)
  {
    return new zzm(paramzzr);
  }
  
  public boolean isSuccess()
  {
    if (this.zzbg == null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zze(zzr paramzzr);
  }
  
  public static abstract interface zzb<T>
  {
    public abstract void zzb(T paramT);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */