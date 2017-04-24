package com.google.android.gms.internal;

import java.lang.reflect.Type;

public class zzaqo<T>
{
  final Type bqi;
  final Class<? super T> brm;
  final int brn;
  
  protected zzaqo()
  {
    this.bqi = zzq(getClass());
    this.brm = zzapr.zzf(this.bqi);
    this.brn = this.bqi.hashCode();
  }
  
  zzaqo(Type paramType)
  {
    this.bqi = zzapr.zze((Type)zzapq.zzy(paramType));
    this.brm = zzapr.zzf(this.bqi);
    this.brn = this.bqi.hashCode();
  }
  
  public static zzaqo<?> zzl(Type paramType)
  {
    return new zzaqo(paramType);
  }
  
  static Type zzq(Class<?> paramClass)
  {
    paramClass = paramClass.getGenericSuperclass();
    if ((paramClass instanceof Class)) {
      throw new RuntimeException("Missing type parameter.");
    }
    return zzapr.zze(((java.lang.reflect.ParameterizedType)paramClass).getActualTypeArguments()[0]);
  }
  
  public static <T> zzaqo<T> zzr(Class<T> paramClass)
  {
    return new zzaqo(paramClass);
  }
  
  public final Class<? super T> bB()
  {
    return this.brm;
  }
  
  public final Type bC()
  {
    return this.bqi;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (((paramObject instanceof zzaqo)) && (zzapr.zza(this.bqi, ((zzaqo)paramObject).bqi))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int hashCode()
  {
    return this.brn;
  }
  
  public final String toString()
  {
    return zzapr.zzg(this.bqi);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */