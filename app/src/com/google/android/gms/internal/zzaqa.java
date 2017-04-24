package com.google.android.gms.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class zzaqa
{
  public static zzaqa bo()
  {
    try
    {
      Object localObject1 = Class.forName("sun.misc.Unsafe");
      localObject3 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject3).setAccessible(true);
      localObject3 = ((Field)localObject3).get(null);
      Method localMethod = ((Class)localObject1).getMethod("allocateInstance", new Class[] { Class.class });
      localObject1 = new com/google/android/gms/internal/zzaqa$1;
      ((1)localObject1).<init>(localMethod, localObject3);
      return (zzaqa)localObject1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
          ((Method)localObject2).setAccessible(true);
          int i = ((Integer)((Method)localObject2).invoke(null, new Object[] { Object.class })).intValue();
          localObject3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
          ((Method)localObject3).setAccessible(true);
          localObject2 = new com/google/android/gms/internal/zzaqa$2;
          ((2)localObject2).<init>((Method)localObject3, i);
        }
        catch (Exception localException2)
        {
          try
          {
            Object localObject3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
            ((Method)localObject3).setAccessible(true);
            zzaqa local3 = new com/google/android/gms/internal/zzaqa$3;
            local3.<init>((Method)localObject3);
          }
          catch (Exception localException3)
          {
            zzaqa local4 = new zzaqa()
            {
              public <T> T zzf(Class<T> paramAnonymousClass)
              {
                paramAnonymousClass = String.valueOf(paramAnonymousClass);
                throw new UnsupportedOperationException(String.valueOf(paramAnonymousClass).length() + 16 + "Cannot allocate " + paramAnonymousClass);
              }
            };
          }
        }
      }
    }
  }
  
  public abstract <T> T zzf(Class<T> paramClass)
    throws Exception;
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */