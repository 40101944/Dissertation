package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzmu
  extends zzg<zzmu>
{
  private Map<Integer, String> bX = new HashMap(4);
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.bX.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = String.valueOf(localEntry.getKey());
      localHashMap.put(String.valueOf(str).length() + 9 + "dimension" + str, localEntry.getValue());
    }
    return zzj(localHashMap);
  }
  
  public void zza(zzmu paramzzmu)
  {
    paramzzmu.bX.putAll(this.bX);
  }
  
  public Map<Integer, String> zzaan()
  {
    return Collections.unmodifiableMap(this.bX);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzmu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */