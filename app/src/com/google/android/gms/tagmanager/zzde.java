package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzde<K, V>
  implements zzl<K, V>
{
  private final Map<K, V> aHA = new HashMap();
  private final int aHB;
  private final zzm.zza<K, V> aHC;
  private int aHD;
  
  zzde(int paramInt, zzm.zza<K, V> paramzza)
  {
    this.aHB = paramInt;
    this.aHC = paramzza;
  }
  
  public V get(K paramK)
  {
    try
    {
      paramK = this.aHA.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  public void zzi(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      try
      {
        paramK = new java/lang/NullPointerException;
        paramK.<init>("key == null || value == null");
        throw paramK;
      }
      finally {}
    }
    this.aHD += this.aHC.sizeOf(paramK, paramV);
    if (this.aHD > this.aHB)
    {
      Iterator localIterator = this.aHA.entrySet().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.aHD -= this.aHC.sizeOf(localEntry.getKey(), localEntry.getValue());
        localIterator.remove();
      } while (this.aHD > this.aHB);
    }
    this.aHA.put(paramK, paramV);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */