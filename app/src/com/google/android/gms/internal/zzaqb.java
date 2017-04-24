package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public final class zzaqb<E>
  extends zzapk<Object>
{
  public static final zzapl bpG = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
    {
      paramAnonymouszzaqo = paramAnonymouszzaqo.bC();
      if ((!(paramAnonymouszzaqo instanceof GenericArrayType)) && ((!(paramAnonymouszzaqo instanceof Class)) || (!((Class)paramAnonymouszzaqo).isArray()))) {}
      for (paramAnonymouszzaos = null;; paramAnonymouszzaos = new zzaqb(paramAnonymouszzaos, paramAnonymouszzaos.zza(zzaqo.zzl(paramAnonymouszzaqo)), zzapr.zzf(paramAnonymouszzaqo)))
      {
        return paramAnonymouszzaos;
        paramAnonymouszzaqo = zzapr.zzh(paramAnonymouszzaqo);
      }
    }
  };
  private final Class<E> bpH;
  private final zzapk<E> bpI;
  
  public zzaqb(zzaos paramzzaos, zzapk<E> paramzzapk, Class<E> paramClass)
  {
    this.bpI = new zzaqm(paramzzaos, paramzzapk, paramClass);
    this.bpH = paramClass;
  }
  
  public void zza(zzaqr paramzzaqr, Object paramObject)
    throws IOException
  {
    if (paramObject == null) {
      paramzzaqr.bA();
    }
    for (;;)
    {
      return;
      paramzzaqr.bw();
      int i = 0;
      int j = Array.getLength(paramObject);
      while (i < j)
      {
        Object localObject = Array.get(paramObject, i);
        this.bpI.zza(paramzzaqr, localObject);
        i++;
      }
      paramzzaqr.bx();
    }
  }
  
  public Object zzb(zzaqp paramzzaqp)
    throws IOException
  {
    if (paramzzaqp.bq() == zzaqq.brJ)
    {
      paramzzaqp.nextNull();
      paramzzaqp = null;
    }
    for (;;)
    {
      return paramzzaqp;
      ArrayList localArrayList = new ArrayList();
      paramzzaqp.beginArray();
      while (paramzzaqp.hasNext()) {
        localArrayList.add(this.bpI.zzb(paramzzaqp));
      }
      paramzzaqp.endArray();
      paramzzaqp = Array.newInstance(this.bpH, localArrayList.size());
      for (int i = 0; i < localArrayList.size(); i++) {
        Array.set(paramzzaqp, i, localArrayList.get(i));
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */