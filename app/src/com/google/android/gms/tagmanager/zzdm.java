package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaj.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzdm
{
  private static final Object aHR = null;
  private static Long aHS = new Long(0L);
  private static Double aHT = new Double(0.0D);
  private static zzdl aHU = zzdl.zzbv(0L);
  private static String aHV = new String("");
  private static Boolean aHW = new Boolean(false);
  private static List<Object> aHX = new ArrayList(0);
  private static Map<Object, Object> aHY = new HashMap();
  private static zzaj.zza aHZ = zzat(aHV);
  
  private static double getDouble(Object paramObject)
  {
    if ((paramObject instanceof Number)) {}
    for (double d = ((Number)paramObject).doubleValue();; d = 0.0D)
    {
      return d;
      zzbo.e("getDouble received non-Number");
    }
  }
  
  public static String zzao(Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = aHV;; paramObject = paramObject.toString()) {
      return (String)paramObject;
    }
  }
  
  public static zzdl zzap(Object paramObject)
  {
    if ((paramObject instanceof zzdl)) {
      paramObject = (zzdl)paramObject;
    }
    for (;;)
    {
      return (zzdl)paramObject;
      if (zzav(paramObject)) {
        paramObject = zzdl.zzbv(zzaw(paramObject));
      } else if (zzau(paramObject)) {
        paramObject = zzdl.zza(Double.valueOf(getDouble(paramObject)));
      } else {
        paramObject = zzpy(zzao(paramObject));
      }
    }
  }
  
  public static Long zzaq(Object paramObject)
  {
    if (zzav(paramObject)) {}
    for (paramObject = Long.valueOf(zzaw(paramObject));; paramObject = zzpz(zzao(paramObject))) {
      return (Long)paramObject;
    }
  }
  
  public static Double zzar(Object paramObject)
  {
    if (zzau(paramObject)) {}
    for (paramObject = Double.valueOf(getDouble(paramObject));; paramObject = zzqa(zzao(paramObject))) {
      return (Double)paramObject;
    }
  }
  
  public static Boolean zzas(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {}
    for (paramObject = (Boolean)paramObject;; paramObject = zzqb(zzao(paramObject))) {
      return (Boolean)paramObject;
    }
  }
  
  public static zzaj.zza zzat(Object paramObject)
  {
    boolean bool = false;
    zzaj.zza localzza = new zzaj.zza();
    if ((paramObject instanceof zzaj.zza))
    {
      paramObject = (zzaj.zza)paramObject;
      return (zzaj.zza)paramObject;
    }
    if ((paramObject instanceof String))
    {
      localzza.type = 1;
      localzza.string = ((String)paramObject);
    }
    for (;;)
    {
      localzza.zzyh = bool;
      paramObject = localzza;
      break;
      Object localObject1;
      Object localObject2;
      if ((paramObject instanceof List))
      {
        localzza.type = 2;
        localObject1 = (List)paramObject;
        paramObject = new ArrayList(((List)localObject1).size());
        localObject2 = ((List)localObject1).iterator();
        bool = false;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = zzat(((Iterator)localObject2).next());
          if (localObject1 == aHZ)
          {
            paramObject = aHZ;
            break;
          }
          if ((bool) || (((zzaj.zza)localObject1).zzyh)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(localObject1);
            break;
          }
        }
        localzza.zzxy = ((zzaj.zza[])((List)paramObject).toArray(new zzaj.zza[0]));
        continue;
      }
      if ((paramObject instanceof Map))
      {
        localzza.type = 3;
        localObject2 = ((Map)paramObject).entrySet();
        localObject1 = new ArrayList(((Set)localObject2).size());
        paramObject = new ArrayList(((Set)localObject2).size());
        Iterator localIterator = ((Set)localObject2).iterator();
        bool = false;
        if (localIterator.hasNext())
        {
          Object localObject3 = (Map.Entry)localIterator.next();
          localObject2 = zzat(((Map.Entry)localObject3).getKey());
          localObject3 = zzat(((Map.Entry)localObject3).getValue());
          if ((localObject2 == aHZ) || (localObject3 == aHZ))
          {
            paramObject = aHZ;
            break;
          }
          if ((bool) || (((zzaj.zza)localObject2).zzyh) || (((zzaj.zza)localObject3).zzyh)) {}
          for (bool = true;; bool = false)
          {
            ((List)localObject1).add(localObject2);
            ((List)paramObject).add(localObject3);
            break;
          }
        }
        localzza.zzxz = ((zzaj.zza[])((List)localObject1).toArray(new zzaj.zza[0]));
        localzza.zzya = ((zzaj.zza[])((List)paramObject).toArray(new zzaj.zza[0]));
        continue;
      }
      if (zzau(paramObject))
      {
        localzza.type = 1;
        localzza.string = paramObject.toString();
      }
      else if (zzav(paramObject))
      {
        localzza.type = 6;
        localzza.zzyd = zzaw(paramObject);
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break label471;
        }
        localzza.type = 8;
        localzza.zzye = ((Boolean)paramObject).booleanValue();
      }
    }
    label471:
    if (paramObject == null)
    {
      paramObject = "null";
      label478:
      paramObject = String.valueOf(paramObject);
      if (((String)paramObject).length() == 0) {
        break label519;
      }
    }
    label519:
    for (paramObject = "Converting to Value from unknown object type: ".concat((String)paramObject);; paramObject = new String("Converting to Value from unknown object type: "))
    {
      zzbo.e((String)paramObject);
      paramObject = aHZ;
      break;
      paramObject = paramObject.getClass().toString();
      break label478;
    }
  }
  
  private static boolean zzau(Object paramObject)
  {
    if (((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof zzdl)) && (((zzdl)paramObject).zzchb()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean zzav(Object paramObject)
  {
    if (((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof zzdl)) && (((zzdl)paramObject).zzchc()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static long zzaw(Object paramObject)
  {
    if ((paramObject instanceof Number)) {}
    for (long l = ((Number)paramObject).longValue();; l = 0L)
    {
      return l;
      zzbo.e("getInt64 received non-Number");
    }
  }
  
  public static Object zzchg()
  {
    return null;
  }
  
  public static Long zzchh()
  {
    return aHS;
  }
  
  public static Double zzchi()
  {
    return aHT;
  }
  
  public static Boolean zzchj()
  {
    return aHW;
  }
  
  public static zzdl zzchk()
  {
    return aHU;
  }
  
  public static String zzchl()
  {
    return aHV;
  }
  
  public static zzaj.zza zzchm()
  {
    return aHZ;
  }
  
  public static String zzg(zzaj.zza paramzza)
  {
    return zzao(zzl(paramzza));
  }
  
  public static zzdl zzh(zzaj.zza paramzza)
  {
    return zzap(zzl(paramzza));
  }
  
  public static Long zzi(zzaj.zza paramzza)
  {
    return zzaq(zzl(paramzza));
  }
  
  public static Double zzj(zzaj.zza paramzza)
  {
    return zzar(zzl(paramzza));
  }
  
  public static Boolean zzk(zzaj.zza paramzza)
  {
    return zzas(zzl(paramzza));
  }
  
  public static Object zzl(zzaj.zza paramzza)
  {
    int k = 0;
    int j = 0;
    int i = 0;
    if (paramzza == null) {
      paramzza = null;
    }
    for (;;)
    {
      return paramzza;
      Object localObject1;
      Object localObject2;
      switch (paramzza.type)
      {
      default: 
        i = paramzza.type;
        zzbo.e(46 + "Failed to convert a value of type: " + i);
        paramzza = null;
        break;
      case 1: 
        paramzza = paramzza.string;
        break;
      case 2: 
        localObject1 = new ArrayList(paramzza.zzxy.length);
        localObject2 = paramzza.zzxy;
        j = localObject2.length;
        for (;;)
        {
          if (i >= j) {
            break label166;
          }
          paramzza = zzl(localObject2[i]);
          if (paramzza == null)
          {
            paramzza = null;
            break;
          }
          ((ArrayList)localObject1).add(paramzza);
          i++;
        }
        paramzza = (zzaj.zza)localObject1;
        break;
      case 3: 
        if (paramzza.zzxz.length != paramzza.zzya.length)
        {
          paramzza = String.valueOf(paramzza.toString());
          if (paramzza.length() != 0) {}
          for (paramzza = "Converting an invalid value to object: ".concat(paramzza);; paramzza = new String("Converting an invalid value to object: "))
          {
            zzbo.e(paramzza);
            paramzza = null;
            break;
          }
        }
        localObject1 = new HashMap(paramzza.zzya.length);
        for (i = k;; i++)
        {
          if (i >= paramzza.zzxz.length) {
            break label311;
          }
          Object localObject3 = zzl(paramzza.zzxz[i]);
          localObject2 = zzl(paramzza.zzya[i]);
          if ((localObject3 == null) || (localObject2 == null))
          {
            paramzza = null;
            break;
          }
          ((Map)localObject1).put(localObject3, localObject2);
        }
        paramzza = (zzaj.zza)localObject1;
        break;
      case 4: 
        zzbo.e("Trying to convert a macro reference to object");
        paramzza = null;
        break;
      case 5: 
        zzbo.e("Trying to convert a function id to object");
        paramzza = null;
        break;
      case 6: 
        paramzza = Long.valueOf(paramzza.zzyd);
        break;
      case 7: 
        localObject1 = new StringBuffer();
        paramzza = paramzza.zzyf;
        k = paramzza.length;
        for (i = j;; i++)
        {
          if (i >= k) {
            break label409;
          }
          localObject2 = zzg(paramzza[i]);
          if (localObject2 == aHV)
          {
            paramzza = null;
            break;
          }
          ((StringBuffer)localObject1).append((String)localObject2);
        }
        paramzza = ((StringBuffer)localObject1).toString();
        break;
      case 8: 
        label166:
        label311:
        label409:
        paramzza = Boolean.valueOf(paramzza.zzye);
      }
    }
  }
  
  public static zzaj.zza zzpx(String paramString)
  {
    zzaj.zza localzza = new zzaj.zza();
    localzza.type = 5;
    localzza.zzyc = paramString;
    return localzza;
  }
  
  private static zzdl zzpy(String paramString)
  {
    try
    {
      zzdl localzzdl = zzdl.zzpw(paramString);
      paramString = localzzdl;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        zzbo.e(String.valueOf(paramString).length() + 33 + "Failed to convert '" + paramString + "' to a number.");
        paramString = aHU;
      }
    }
    return paramString;
  }
  
  private static Long zzpz(String paramString)
  {
    paramString = zzpy(paramString);
    if (paramString == aHU) {}
    for (paramString = aHS;; paramString = Long.valueOf(paramString.longValue())) {
      return paramString;
    }
  }
  
  private static Double zzqa(String paramString)
  {
    paramString = zzpy(paramString);
    if (paramString == aHU) {}
    for (paramString = aHT;; paramString = Double.valueOf(paramString.doubleValue())) {
      return paramString;
    }
  }
  
  private static Boolean zzqb(String paramString)
  {
    if ("true".equalsIgnoreCase(paramString)) {
      paramString = Boolean.TRUE;
    }
    for (;;)
    {
      return paramString;
      if ("false".equalsIgnoreCase(paramString)) {
        paramString = Boolean.FALSE;
      } else {
        paramString = aHW;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */