package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer
{
  public static final String EVENT_KEY = "event";
  public static final Object OBJECT_NOT_PRESENT = new Object();
  static final String[] aEF = "gtm.lifetime".toString().split("\\.");
  private static final Pattern aEG = Pattern.compile("(\\d+)\\s*([smhd]?)");
  private final ConcurrentHashMap<zzb, Integer> aEH;
  private final Map<String, Object> aEI;
  private final ReentrantLock aEJ;
  private final LinkedList<Map<String, Object>> aEK;
  private final zzc aEL;
  private final CountDownLatch aEM;
  
  DataLayer()
  {
    this(new zzc()
    {
      public void zza(DataLayer.zzc.zza paramAnonymouszza)
      {
        paramAnonymouszza.zzai(new ArrayList());
      }
      
      public void zza(List<DataLayer.zza> paramAnonymousList, long paramAnonymousLong) {}
      
      public void zzpd(String paramAnonymousString) {}
    });
  }
  
  DataLayer(zzc paramzzc)
  {
    this.aEL = paramzzc;
    this.aEH = new ConcurrentHashMap();
    this.aEI = new HashMap();
    this.aEJ = new ReentrantLock();
    this.aEK = new LinkedList();
    this.aEM = new CountDownLatch(1);
    zzceq();
  }
  
  public static List<Object> listOf(Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramVarArgs.length; i++) {
      localArrayList.add(paramVarArgs[i]);
    }
    return localArrayList;
  }
  
  public static Map<String, Object> mapOf(Object... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0) {
      throw new IllegalArgumentException("expected even number of key-value pairs");
    }
    HashMap localHashMap = new HashMap();
    for (int i = 0; i < paramVarArgs.length; i += 2)
    {
      if (!(paramVarArgs[i] instanceof String))
      {
        paramVarArgs = String.valueOf(paramVarArgs[i]);
        throw new IllegalArgumentException(String.valueOf(paramVarArgs).length() + 21 + "key is not a string: " + paramVarArgs);
      }
      localHashMap.put((String)paramVarArgs[i], paramVarArgs[(i + 1)]);
    }
    return localHashMap;
  }
  
  private void zza(Map<String, Object> paramMap, String paramString, Collection<zza> paramCollection)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramString.length() == 0) {}
      for (paramMap = "";; paramMap = ".")
      {
        String str = (String)localEntry.getKey();
        paramMap = String.valueOf(paramString).length() + 0 + String.valueOf(paramMap).length() + String.valueOf(str).length() + paramString + paramMap + str;
        if (!(localEntry.getValue() instanceof Map)) {
          break label145;
        }
        zza((Map)localEntry.getValue(), paramMap, paramCollection);
        break;
      }
      label145:
      if (!paramMap.equals("gtm.lifetime")) {
        paramCollection.add(new zza(paramMap, localEntry.getValue()));
      }
    }
  }
  
  private void zzbb(Map<String, Object> paramMap)
  {
    this.aEJ.lock();
    try
    {
      this.aEK.offer(paramMap);
      if (this.aEJ.getHoldCount() == 1) {
        zzcer();
      }
      zzbc(paramMap);
      return;
    }
    finally
    {
      this.aEJ.unlock();
    }
  }
  
  private void zzbc(Map<String, Object> paramMap)
  {
    Long localLong = zzbd(paramMap);
    if (localLong == null) {}
    for (;;)
    {
      return;
      paramMap = zzbf(paramMap);
      paramMap.remove("gtm.lifetime");
      this.aEL.zza(paramMap, localLong.longValue());
    }
  }
  
  private Long zzbd(Map<String, Object> paramMap)
  {
    paramMap = zzbe(paramMap);
    if (paramMap == null) {}
    for (paramMap = null;; paramMap = zzpc(paramMap.toString())) {
      return paramMap;
    }
  }
  
  private Object zzbe(Map<String, Object> paramMap)
  {
    String[] arrayOfString = aEF;
    int j = arrayOfString.length;
    for (int i = 0;; i++)
    {
      Object localObject = paramMap;
      if (i < j)
      {
        localObject = arrayOfString[i];
        if (!(paramMap instanceof Map)) {
          localObject = null;
        }
      }
      else
      {
        return localObject;
      }
      paramMap = ((Map)paramMap).get(localObject);
    }
  }
  
  private List<zza> zzbf(Map<String, Object> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    zza(paramMap, "", localArrayList);
    return localArrayList;
  }
  
  private void zzbg(Map<String, Object> paramMap)
  {
    synchronized (this.aEI)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        zzd(zzo(str, paramMap.get(str)), this.aEI);
      }
    }
    zzbh(paramMap);
  }
  
  private void zzbh(Map<String, Object> paramMap)
  {
    Iterator localIterator = this.aEH.keySet().iterator();
    while (localIterator.hasNext()) {
      ((zzb)localIterator.next()).zzaz(paramMap);
    }
  }
  
  private void zzceq()
  {
    this.aEL.zza(new DataLayer.zzc.zza()
    {
      public void zzai(List<DataLayer.zza> paramAnonymousList)
      {
        Iterator localIterator = paramAnonymousList.iterator();
        while (localIterator.hasNext())
        {
          paramAnonymousList = (DataLayer.zza)localIterator.next();
          DataLayer.zza(DataLayer.this, DataLayer.this.zzo(paramAnonymousList.zzbcn, paramAnonymousList.zzcyd));
        }
        DataLayer.zza(DataLayer.this).countDown();
      }
    });
  }
  
  private void zzcer()
  {
    int i = 0;
    for (;;)
    {
      Map localMap = (Map)this.aEK.poll();
      if (localMap != null)
      {
        zzbg(localMap);
        i++;
        if (i > 500)
        {
          this.aEK.clear();
          throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
        }
      }
      else
      {
        return;
      }
    }
  }
  
  static Long zzpc(String paramString)
  {
    Matcher localMatcher = aEG.matcher(paramString);
    if (!localMatcher.matches())
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0)
      {
        paramString = "unknown _lifetime: ".concat(paramString);
        zzbo.zzdh(paramString);
        paramString = null;
      }
    }
    long l;
    for (;;)
    {
      return paramString;
      paramString = new String("unknown _lifetime: ");
      break;
      try
      {
        l = Long.parseLong(localMatcher.group(1));
        if (l <= 0L)
        {
          paramString = String.valueOf(paramString);
          if (paramString.length() != 0)
          {
            paramString = "non-positive _lifetime: ".concat(paramString);
            zzbo.zzdh(paramString);
            paramString = null;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          str = String.valueOf(paramString);
          if (str.length() != 0) {}
          for (str = "illegal number in _lifetime value: ".concat(str);; str = new String("illegal number in _lifetime value: "))
          {
            zzbo.zzdi(str);
            l = 0L;
            break;
          }
          paramString = new String("non-positive _lifetime: ");
        }
        String str = localMatcher.group(2);
        if (str.length() == 0) {
          paramString = Long.valueOf(l);
        } else {
          switch (str.charAt(0))
          {
          default: 
            paramString = String.valueOf(paramString);
            if (paramString.length() == 0) {}
            break;
          }
        }
      }
    }
    for (paramString = "unknown units in _lifetime: ".concat(paramString);; paramString = new String("unknown units in _lifetime: "))
    {
      zzbo.zzdi(paramString);
      paramString = null;
      break;
      paramString = Long.valueOf(l * 1000L);
      break;
      paramString = Long.valueOf(l * 1000L * 60L);
      break;
      paramString = Long.valueOf(l * 1000L * 60L * 60L);
      break;
      paramString = Long.valueOf(l * 1000L * 60L * 60L * 24L);
      break;
    }
  }
  
  public Object get(String paramString)
  {
    synchronized (this.aEI)
    {
      Map localMap1 = this.aEI;
      String[] arrayOfString = paramString.split("\\.");
      int j = arrayOfString.length;
      paramString = localMap1;
      for (int i = 0; i < j; i++)
      {
        localMap1 = arrayOfString[i];
        if (!(paramString instanceof Map)) {}
        for (paramString = null;; paramString = null)
        {
          return paramString;
          paramString = ((Map)paramString).get(localMap1);
          if (paramString != null) {
            break;
          }
        }
      }
    }
  }
  
  public void push(String paramString, Object paramObject)
  {
    push(zzo(paramString, paramObject));
  }
  
  public void push(Map<String, Object> paramMap)
  {
    try
    {
      this.aEM.await();
      zzbb(paramMap);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        zzbo.zzdi("DataLayer.push: unexpected InterruptedException");
      }
    }
  }
  
  public void pushEvent(String paramString, Map<String, Object> paramMap)
  {
    paramMap = new HashMap(paramMap);
    paramMap.put("event", paramString);
    push(paramMap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder;
    synchronized (this.aEI)
    {
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      Iterator localIterator = this.aEI.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
      }
    }
    String str = localStringBuilder.toString();
    return str;
  }
  
  void zza(zzb paramzzb)
  {
    this.aEH.put(paramzzb, Integer.valueOf(0));
  }
  
  void zzb(List<Object> paramList1, List<Object> paramList2)
  {
    while (paramList2.size() < paramList1.size()) {
      paramList2.add(null);
    }
    int i = 0;
    if (i < paramList1.size())
    {
      Object localObject = paramList1.get(i);
      if ((localObject instanceof List))
      {
        if (!(paramList2.get(i) instanceof List)) {
          paramList2.set(i, new ArrayList());
        }
        zzb((List)localObject, (List)paramList2.get(i));
      }
      for (;;)
      {
        i++;
        break;
        if ((localObject instanceof Map))
        {
          if (!(paramList2.get(i) instanceof Map)) {
            paramList2.set(i, new HashMap());
          }
          zzd((Map)localObject, (Map)paramList2.get(i));
        }
        else if (localObject != OBJECT_NOT_PRESENT)
        {
          paramList2.set(i, localObject);
        }
      }
    }
  }
  
  void zzd(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    Iterator localIterator = paramMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap1.get(str);
      if ((localObject instanceof List))
      {
        if (!(paramMap2.get(str) instanceof List)) {
          paramMap2.put(str, new ArrayList());
        }
        zzb((List)localObject, (List)paramMap2.get(str));
      }
      else if ((localObject instanceof Map))
      {
        if (!(paramMap2.get(str) instanceof Map)) {
          paramMap2.put(str, new HashMap());
        }
        zzd((Map)localObject, (Map)paramMap2.get(str));
      }
      else
      {
        paramMap2.put(str, localObject);
      }
    }
  }
  
  Map<String, Object> zzo(String paramString, Object paramObject)
  {
    HashMap localHashMap1 = new HashMap();
    String[] arrayOfString = paramString.toString().split("\\.");
    int i = 0;
    HashMap localHashMap2;
    for (paramString = localHashMap1; i < arrayOfString.length - 1; paramString = localHashMap2)
    {
      localHashMap2 = new HashMap();
      paramString.put(arrayOfString[i], localHashMap2);
      i++;
    }
    paramString.put(arrayOfString[(arrayOfString.length - 1)], paramObject);
    return localHashMap1;
  }
  
  void zzpb(String paramString)
  {
    push(paramString, null);
    this.aEL.zzpd(paramString);
  }
  
  static final class zza
  {
    public final String zzbcn;
    public final Object zzcyd;
    
    zza(String paramString, Object paramObject)
    {
      this.zzbcn = paramString;
      this.zzcyd = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (!(paramObject instanceof zza)) {
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        paramObject = (zza)paramObject;
        bool1 = bool2;
        if (this.zzbcn.equals(((zza)paramObject).zzbcn))
        {
          bool1 = bool2;
          if (this.zzcyd.equals(((zza)paramObject).zzcyd)) {
            bool1 = true;
          }
        }
      }
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(new Integer[] { Integer.valueOf(this.zzbcn.hashCode()), Integer.valueOf(this.zzcyd.hashCode()) });
    }
    
    public String toString()
    {
      String str2 = this.zzbcn;
      String str1 = String.valueOf(this.zzcyd.toString());
      return String.valueOf(str2).length() + 13 + String.valueOf(str1).length() + "Key: " + str2 + " value: " + str1;
    }
  }
  
  static abstract interface zzb
  {
    public abstract void zzaz(Map<String, Object> paramMap);
  }
  
  static abstract interface zzc
  {
    public abstract void zza(zza paramzza);
    
    public abstract void zza(List<DataLayer.zza> paramList, long paramLong);
    
    public abstract void zzpd(String paramString);
    
    public static abstract interface zza
    {
      public abstract void zzai(List<DataLayer.zza> paramList);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\DataLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */