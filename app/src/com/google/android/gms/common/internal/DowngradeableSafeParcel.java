package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.lang.reflect.Field;

public abstract class DowngradeableSafeParcel
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  private static final Object DQ = new Object();
  private static ClassLoader DR = null;
  private static Integer DS = null;
  private boolean DT = false;
  
  protected static ClassLoader zzavy()
  {
    synchronized (DQ)
    {
      return null;
    }
  }
  
  protected static Integer zzavz()
  {
    synchronized (DQ)
    {
      return null;
    }
  }
  
  private static boolean zzd(Class<?> paramClass)
  {
    boolean bool2 = false;
    try
    {
      bool1 = "SAFE_PARCELABLE_NULL_STRING".equals(paramClass.getField("NULL").get(null));
      return bool1;
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    catch (NoSuchFieldException paramClass)
    {
      for (;;)
      {
        boolean bool1 = bool2;
      }
    }
  }
  
  protected static boolean zzhu(String paramString)
  {
    ClassLoader localClassLoader = zzavy();
    boolean bool;
    if (localClassLoader == null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      try
      {
        bool = zzd(localClassLoader.loadClass(paramString));
      }
      catch (Exception paramString)
      {
        bool = false;
      }
    }
  }
  
  protected boolean zzawa()
  {
    return false;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\DowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */