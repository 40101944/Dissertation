package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzmv
  extends zzg<zzmv>
{
  private Map<Integer, Double> bY = new HashMap(4);
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.bY.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = String.valueOf(localEntry.getKey());
      localHashMap.put(String.valueOf(str).length() + 6 + "metric" + str, localEntry.getValue());
    }
    return zzj(localHashMap);
  }
  
  public void zza(zzmv paramzzmv)
  {
    paramzzmv.bY.putAll(this.bY);
  }
  
  public Map<Integer, Double> zzaao()
  {
    return Collections.unmodifiableMap(this.bY);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzmv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */