package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class zza<E>
  extends AbstractSet<E>
{
  private final ArrayMap<E, E> Gp;
  
  public zza()
  {
    this.Gp = new ArrayMap();
  }
  
  public zza(int paramInt)
  {
    this.Gp = new ArrayMap(paramInt);
  }
  
  public zza(Collection<E> paramCollection)
  {
    this(paramCollection.size());
    addAll(paramCollection);
  }
  
  public boolean add(E paramE)
  {
    if (this.Gp.containsKey(paramE)) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      this.Gp.put(paramE, paramE);
    }
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof zza)) {}
    for (boolean bool = zza((zza)paramCollection);; bool = super.addAll(paramCollection)) {
      return bool;
    }
  }
  
  public void clear()
  {
    this.Gp.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.Gp.containsKey(paramObject);
  }
  
  public Iterator<E> iterator()
  {
    return this.Gp.keySet().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    if (!this.Gp.containsKey(paramObject)) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      this.Gp.remove(paramObject);
    }
  }
  
  public int size()
  {
    return this.Gp.size();
  }
  
  public boolean zza(zza<? extends E> paramzza)
  {
    int i = size();
    this.Gp.putAll(paramzza.Gp);
    if (size() > i) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\util\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */