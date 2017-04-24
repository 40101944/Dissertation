package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzapy
{
  private static final Map<Class<?>, Class<?>> bpx;
  private static final Map<Class<?>, Class<?>> bpy;
  
  static
  {
    HashMap localHashMap1 = new HashMap(16);
    HashMap localHashMap2 = new HashMap(16);
    zza(localHashMap1, localHashMap2, Boolean.TYPE, Boolean.class);
    zza(localHashMap1, localHashMap2, Byte.TYPE, Byte.class);
    zza(localHashMap1, localHashMap2, Character.TYPE, Character.class);
    zza(localHashMap1, localHashMap2, Double.TYPE, Double.class);
    zza(localHashMap1, localHashMap2, Float.TYPE, Float.class);
    zza(localHashMap1, localHashMap2, Integer.TYPE, Integer.class);
    zza(localHashMap1, localHashMap2, Long.TYPE, Long.class);
    zza(localHashMap1, localHashMap2, Short.TYPE, Short.class);
    zza(localHashMap1, localHashMap2, Void.TYPE, Void.class);
    bpx = Collections.unmodifiableMap(localHashMap1);
    bpy = Collections.unmodifiableMap(localHashMap2);
  }
  
  private static void zza(Map<Class<?>, Class<?>> paramMap1, Map<Class<?>, Class<?>> paramMap2, Class<?> paramClass1, Class<?> paramClass2)
  {
    paramMap1.put(paramClass1, paramClass2);
    paramMap2.put(paramClass2, paramClass1);
  }
  
  public static boolean zzk(Type paramType)
  {
    return bpx.containsKey(paramType);
  }
  
  public static <T> Class<T> zzp(Class<T> paramClass)
  {
    Class localClass = (Class)bpx.get(zzapq.zzy(paramClass));
    if (localClass == null) {}
    for (;;)
    {
      return paramClass;
      paramClass = localClass;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzapy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */