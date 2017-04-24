package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzab
{
  private final List<Command> fi;
  private final long fj;
  private final long fk;
  private final int fl;
  private final boolean fm;
  private final String fn;
  private final Map<String, String> zzbly;
  
  public zzab(zzc paramzzc, Map<String, String> paramMap, long paramLong, boolean paramBoolean)
  {
    this(paramzzc, paramMap, paramLong, paramBoolean, 0L, 0, null);
  }
  
  public zzab(zzc paramzzc, Map<String, String> paramMap, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt)
  {
    this(paramzzc, paramMap, paramLong1, paramBoolean, paramLong2, paramInt, null);
  }
  
  public zzab(zzc paramzzc, Map<String, String> paramMap, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt, List<Command> paramList)
  {
    zzaa.zzy(paramzzc);
    zzaa.zzy(paramMap);
    this.fk = paramLong1;
    this.fm = paramBoolean;
    this.fj = paramLong2;
    this.fl = paramInt;
    if (paramList != null) {}
    Object localObject2;
    for (Object localObject1 = paramList;; localObject1 = Collections.emptyList())
    {
      this.fi = ((List)localObject1);
      this.fn = zzs(paramList);
      paramList = new HashMap();
      localObject2 = paramMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
        if (zzl(((Map.Entry)localObject1).getKey()))
        {
          String str = zza(paramzzc, ((Map.Entry)localObject1).getKey());
          if (str != null) {
            paramList.put(str, zzb(paramzzc, ((Map.Entry)localObject1).getValue()));
          }
        }
      }
    }
    localObject1 = paramMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramMap = (Map.Entry)((Iterator)localObject1).next();
      if (!zzl(paramMap.getKey()))
      {
        localObject2 = zza(paramzzc, paramMap.getKey());
        if (localObject2 != null) {
          paramList.put(localObject2, zzb(paramzzc, paramMap.getValue()));
        }
      }
    }
    if (!TextUtils.isEmpty(this.fn))
    {
      zzao.zzc(paramList, "_v", this.fn);
      if ((this.fn.equals("ma4.0.0")) || (this.fn.equals("ma4.0.1"))) {
        paramList.remove("adid");
      }
    }
    this.zzbly = Collections.unmodifiableMap(paramList);
  }
  
  public static zzab zza(zzc paramzzc, zzab paramzzab, Map<String, String> paramMap)
  {
    return new zzab(paramzzc, paramMap, paramzzab.zzaga(), paramzzab.zzagc(), paramzzab.zzafz(), paramzzab.zzafy(), paramzzab.zzagb());
  }
  
  private static String zza(zzc paramzzc, Object paramObject)
  {
    if (paramObject == null) {
      paramzzc = null;
    }
    for (;;)
    {
      return paramzzc;
      paramObject = paramObject.toString();
      Object localObject = paramObject;
      if (((String)paramObject).startsWith("&")) {
        localObject = ((String)paramObject).substring(1);
      }
      int i = ((String)localObject).length();
      paramObject = localObject;
      if (i > 256)
      {
        paramObject = ((String)localObject).substring(0, 256);
        paramzzc.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(i), paramObject);
      }
      paramzzc = (zzc)paramObject;
      if (TextUtils.isEmpty((CharSequence)paramObject)) {
        paramzzc = null;
      }
    }
  }
  
  private static String zzb(zzc paramzzc, Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = "";; paramObject = paramObject.toString())
    {
      int i = ((String)paramObject).length();
      Object localObject = paramObject;
      if (i > 8192)
      {
        localObject = ((String)paramObject).substring(0, 8192);
        paramzzc.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(i), localObject);
      }
      return (String)localObject;
    }
  }
  
  private static boolean zzl(Object paramObject)
  {
    if (paramObject == null) {}
    for (boolean bool = false;; bool = paramObject.toString().startsWith("&")) {
      return bool;
    }
  }
  
  private String zzr(String paramString1, String paramString2)
  {
    zzaa.zzib(paramString1);
    boolean bool;
    if (!paramString1.startsWith("&"))
    {
      bool = true;
      zzaa.zzb(bool, "Short param name required");
      paramString1 = (String)this.zzbly.get(paramString1);
      if (paramString1 == null) {
        break label49;
      }
      paramString2 = paramString1;
    }
    label49:
    for (;;)
    {
      return paramString2;
      bool = false;
      break;
    }
  }
  
  private static String zzs(List<Command> paramList)
  {
    Object localObject = null;
    Command localCommand;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localCommand = (Command)paramList.next();
      } while (!"appendVersion".equals(localCommand.getId()));
    }
    for (paramList = localCommand.getValue();; paramList = null)
    {
      if (TextUtils.isEmpty(paramList)) {
        paramList = (List<Command>)localObject;
      }
      for (;;)
      {
        return paramList;
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ht=").append(this.fk);
    if (this.fj != 0L) {
      localStringBuffer.append(", dbId=").append(this.fj);
    }
    if (this.fl != 0) {
      localStringBuffer.append(", appUID=").append(this.fl);
    }
    Object localObject = new ArrayList(this.zzbly.keySet());
    Collections.sort((List)localObject);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuffer.append(", ");
      localStringBuffer.append(str);
      localStringBuffer.append("=");
      localStringBuffer.append((String)this.zzbly.get(str));
    }
    return localStringBuffer.toString();
  }
  
  public int zzafy()
  {
    return this.fl;
  }
  
  public long zzafz()
  {
    return this.fj;
  }
  
  public long zzaga()
  {
    return this.fk;
  }
  
  public List<Command> zzagb()
  {
    return this.fi;
  }
  
  public boolean zzagc()
  {
    return this.fm;
  }
  
  public long zzagd()
  {
    return zzao.zzfj(zzr("_s", "0"));
  }
  
  public String zzage()
  {
    return zzr("_m", "");
  }
  
  public Map<String, String> zzmc()
  {
    return this.zzbly;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */