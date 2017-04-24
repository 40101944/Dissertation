package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class zzaps
{
  private final Map<Type, zzaou<?>> bop;
  
  public zzaps(Map<Type, zzaou<?>> paramMap)
  {
    this.bop = paramMap;
  }
  
  private <T> zzapx<T> zzc(final Type paramType, Class<? super T> paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass)) {
      if (SortedSet.class.isAssignableFrom(paramClass)) {
        paramType = new zzapx()
        {
          public T bj()
          {
            return new TreeSet();
          }
        };
      }
    }
    for (;;)
    {
      return paramType;
      if (EnumSet.class.isAssignableFrom(paramClass))
      {
        paramType = new zzapx()
        {
          public T bj()
          {
            if ((paramType instanceof ParameterizedType))
            {
              localObject = ((ParameterizedType)paramType).getActualTypeArguments()[0];
              if ((localObject instanceof Class)) {
                return EnumSet.noneOf((Class)localObject);
              }
              localObject = String.valueOf(paramType.toString());
              if (((String)localObject).length() != 0) {}
              for (localObject = "Invalid EnumSet type: ".concat((String)localObject);; localObject = new String("Invalid EnumSet type: ")) {
                throw new zzaoz((String)localObject);
              }
            }
            Object localObject = String.valueOf(paramType.toString());
            if (((String)localObject).length() != 0) {}
            for (localObject = "Invalid EnumSet type: ".concat((String)localObject);; localObject = new String("Invalid EnumSet type: ")) {
              throw new zzaoz((String)localObject);
            }
          }
        };
      }
      else if (Set.class.isAssignableFrom(paramClass))
      {
        paramType = new zzapx()
        {
          public T bj()
          {
            return new LinkedHashSet();
          }
        };
      }
      else if (Queue.class.isAssignableFrom(paramClass))
      {
        paramType = new zzapx()
        {
          public T bj()
          {
            return new LinkedList();
          }
        };
      }
      else
      {
        paramType = new zzapx()
        {
          public T bj()
          {
            return new ArrayList();
          }
        };
        continue;
        if (Map.class.isAssignableFrom(paramClass))
        {
          if (SortedMap.class.isAssignableFrom(paramClass)) {
            paramType = new zzapx()
            {
              public T bj()
              {
                return new TreeMap();
              }
            };
          } else if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(zzaqo.zzl(((ParameterizedType)paramType).getActualTypeArguments()[0]).bB()))) {
            paramType = new zzapx()
            {
              public T bj()
              {
                return new LinkedHashMap();
              }
            };
          } else {
            paramType = new zzapx()
            {
              public T bj()
              {
                return new zzapw();
              }
            };
          }
        }
        else {
          paramType = null;
        }
      }
    }
  }
  
  private <T> zzapx<T> zzd(final Type paramType, final Class<? super T> paramClass)
  {
    new zzapx()
    {
      private final zzaqa boS = zzaqa.bo();
      
      public T bj()
      {
        try
        {
          localObject = this.boS.zzf(paramClass);
          return (T)localObject;
        }
        catch (Exception localException)
        {
          Object localObject = String.valueOf(paramType);
          throw new RuntimeException(String.valueOf(localObject).length() + 116 + "Unable to invoke no-args constructor for " + (String)localObject + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", localException);
        }
      }
    };
  }
  
  private <T> zzapx<T> zzl(Class<? super T> paramClass)
  {
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
      if (!localConstructor.isAccessible()) {
        localConstructor.setAccessible(true);
      }
      paramClass = new com/google/android/gms/internal/zzaps$6;
      paramClass.<init>(this, localConstructor);
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
    }
    return paramClass;
  }
  
  public String toString()
  {
    return this.bop.toString();
  }
  
  public <T> zzapx<T> zzb(final zzaqo<T> paramzzaqo)
  {
    final Type localType = paramzzaqo.bC();
    Class localClass = paramzzaqo.bB();
    paramzzaqo = (zzaou)this.bop.get(localType);
    if (paramzzaqo != null) {
      paramzzaqo = new zzapx()
      {
        public T bj()
        {
          return (T)paramzzaqo.zza(localType);
        }
      };
    }
    for (;;)
    {
      return paramzzaqo;
      paramzzaqo = (zzaou)this.bop.get(localClass);
      if (paramzzaqo != null)
      {
        paramzzaqo = new zzapx()
        {
          public T bj()
          {
            return (T)paramzzaqo.zza(localType);
          }
        };
      }
      else
      {
        zzapx localzzapx = zzl(localClass);
        paramzzaqo = localzzapx;
        if (localzzapx == null)
        {
          localzzapx = zzc(localType, localClass);
          paramzzaqo = localzzapx;
          if (localzzapx == null) {
            paramzzaqo = zzd(localType, localClass);
          }
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */