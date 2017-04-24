package com.google.android.gms.internal;

public final class zzaqe
  implements zzapl
{
  private final zzaps bod;
  
  public zzaqe(zzaps paramzzaps)
  {
    this.bod = paramzzaps;
  }
  
  static zzapk<?> zza(zzaps paramzzaps, zzaos paramzzaos, zzaqo<?> paramzzaqo, zzapm paramzzapm)
  {
    paramzzapm = paramzzapm.value();
    if (zzapk.class.isAssignableFrom(paramzzapm)) {}
    for (paramzzaps = (zzapk)paramzzaps.zzb(zzaqo.zzr(paramzzapm)).bj();; paramzzaps = ((zzapl)paramzzaps.zzb(zzaqo.zzr(paramzzapm)).bj()).zza(paramzzaos, paramzzaqo))
    {
      return paramzzaps;
      if (!zzapl.class.isAssignableFrom(paramzzapm)) {
        break;
      }
    }
    throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
  }
  
  public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
  {
    zzapm localzzapm = (zzapm)paramzzaqo.bB().getAnnotation(zzapm.class);
    if (localzzapm == null) {}
    for (paramzzaos = null;; paramzzaos = zza(this.bod, paramzzaos, paramzzaqo, localzzapm)) {
      return paramzzaos;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */