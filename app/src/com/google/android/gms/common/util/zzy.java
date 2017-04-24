package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zzy
{
  private static final Method GH = ;
  private static final Method GI = zzazb();
  private static final Method GJ = zzazc();
  private static final Method GK = zzazd();
  private static final Method GL = zzaze();
  
  public static int zza(WorkSource paramWorkSource)
  {
    if (GJ != null) {}
    for (;;)
    {
      try
      {
        i = ((Integer)GJ.invoke(paramWorkSource, new Object[0])).intValue();
        return i;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
      int i = 0;
    }
  }
  
  public static String zza(WorkSource paramWorkSource, int paramInt)
  {
    if (GL != null) {}
    for (;;)
    {
      try
      {
        paramWorkSource = (String)GL.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        return paramWorkSource;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
      paramWorkSource = null;
    }
  }
  
  public static void zza(WorkSource paramWorkSource, int paramInt, String paramString)
  {
    String str;
    if (GI != null)
    {
      str = paramString;
      if (paramString == null) {
        str = "";
      }
    }
    for (;;)
    {
      try
      {
        GI.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt), str });
        return;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
        continue;
      }
      if (GH != null) {
        try
        {
          GH.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        }
        catch (Exception paramWorkSource)
        {
          Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
        }
      }
    }
  }
  
  private static Method zzaza()
  {
    Object localObject = null;
    try
    {
      Method localMethod = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE });
      localObject = localMethod;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return (Method)localObject;
  }
  
  private static Method zzazb()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (zzs.zzayt()) {}
    try
    {
      localObject1 = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE, String.class });
      return (Method)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private static Method zzazc()
  {
    Object localObject = null;
    try
    {
      Method localMethod = WorkSource.class.getMethod("size", new Class[0]);
      localObject = localMethod;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return (Method)localObject;
  }
  
  private static Method zzazd()
  {
    Object localObject = null;
    try
    {
      Method localMethod = WorkSource.class.getMethod("get", new Class[] { Integer.TYPE });
      localObject = localMethod;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return (Method)localObject;
  }
  
  private static Method zzaze()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (zzs.zzayt()) {}
    try
    {
      localObject1 = WorkSource.class.getMethod("getName", new Class[] { Integer.TYPE });
      return (Method)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public static List<String> zzb(WorkSource paramWorkSource)
  {
    int j = 0;
    if (paramWorkSource == null) {}
    Object localObject;
    for (int i = 0; i == 0; i = zza(paramWorkSource))
    {
      localObject = Collections.EMPTY_LIST;
      return (List<String>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      localObject = localArrayList;
      if (j >= i) {
        break;
      }
      localObject = zza(paramWorkSource, j);
      if (!zzv.zzij((String)localObject)) {
        localArrayList.add(localObject);
      }
      j++;
    }
  }
  
  public static boolean zzcm(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramContext == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramContext.getPackageManager() != null)
      {
        bool1 = bool2;
        if (zzsz.zzco(paramContext).checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) == 0) {
          bool1 = true;
        }
      }
    }
  }
  
  public static WorkSource zzf(int paramInt, String paramString)
  {
    WorkSource localWorkSource = new WorkSource();
    zza(localWorkSource, paramInt, paramString);
    return localWorkSource;
  }
  
  public static WorkSource zzy(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramContext.getPackageManager() == null)) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = zzsz.zzco(paramContext).getApplicationInfo(paramString, 0);
        if (paramContext == null)
        {
          paramContext = String.valueOf(paramString);
          if (paramContext.length() != 0)
          {
            paramContext = "Could not get applicationInfo from package: ".concat(paramContext);
            Log.e("WorkSourceUtil", paramContext);
            paramContext = null;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext = String.valueOf(paramString);
          if (paramContext.length() != 0) {}
          for (paramContext = "Could not find package: ".concat(paramContext);; paramContext = new String("Could not find package: "))
          {
            Log.e("WorkSourceUtil", paramContext);
            paramContext = null;
            break;
          }
          paramContext = new String("Could not get applicationInfo from package: ");
        }
        paramContext = zzf(paramContext.uid, paramString);
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\util\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */