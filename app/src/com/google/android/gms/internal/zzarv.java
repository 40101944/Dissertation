package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzarv<M extends zzaru<M>, T>
{
  protected final Class<T> bkp;
  protected final boolean btH;
  public final int tag;
  protected final int type;
  
  private zzarv(int paramInt1, Class<T> paramClass, int paramInt2, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.bkp = paramClass;
    this.tag = paramInt2;
    this.btH = paramBoolean;
  }
  
  public static <M extends zzaru<M>, T extends zzasa> zzarv<M, T> zza(int paramInt, Class<T> paramClass, long paramLong)
  {
    return new zzarv(paramInt, paramClass, (int)paramLong, false);
  }
  
  private T zzaz(List<zzasc> paramList)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramList.size(); i++)
    {
      localObject = (zzasc)paramList.get(i);
      if (((zzasc)localObject).btQ.length != 0) {
        zza((zzasc)localObject, localArrayList);
      }
    }
    int k = localArrayList.size();
    if (k == 0)
    {
      paramList = null;
      return paramList;
    }
    Object localObject = this.bkp.cast(Array.newInstance(this.bkp.getComponentType(), k));
    for (i = j;; i++)
    {
      paramList = (List<zzasc>)localObject;
      if (i >= k) {
        break;
      }
      Array.set(localObject, i, localArrayList.get(i));
    }
  }
  
  private T zzba(List<zzasc> paramList)
  {
    if (paramList.isEmpty()) {}
    for (paramList = null;; paramList = this.bkp.cast(zzcm(zzars.zzbd(paramList.btQ))))
    {
      return paramList;
      paramList = (zzasc)paramList.get(paramList.size() - 1);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof zzarv))
      {
        bool = false;
      }
      else
      {
        paramObject = (zzarv)paramObject;
        if ((this.type != ((zzarv)paramObject).type) || (this.bkp != ((zzarv)paramObject).bkp) || (this.tag != ((zzarv)paramObject).tag) || (this.btH != ((zzarv)paramObject).btH)) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    int m = this.type;
    int j = this.bkp.hashCode();
    int k = this.tag;
    if (this.btH) {}
    for (int i = 1;; i = 0) {
      return i + (((m + 1147) * 31 + j) * 31 + k) * 31;
    }
  }
  
  protected void zza(zzasc paramzzasc, List<Object> paramList)
  {
    paramList.add(zzcm(zzars.zzbd(paramzzasc.btQ)));
  }
  
  void zza(Object paramObject, zzart paramzzart)
    throws IOException
  {
    if (this.btH) {
      zzc(paramObject, paramzzart);
    }
    for (;;)
    {
      return;
      zzb(paramObject, paramzzart);
    }
  }
  
  final T zzay(List<zzasc> paramList)
  {
    if (paramList == null) {
      paramList = null;
    }
    for (;;)
    {
      return paramList;
      if (this.btH) {
        paramList = zzaz(paramList);
      } else {
        paramList = zzba(paramList);
      }
    }
  }
  
  protected void zzb(Object paramObject, zzart paramzzart)
  {
    try
    {
      paramzzart.zzahd(this.tag);
      switch (this.type)
      {
      default: 
        paramObject = new java/lang/IllegalArgumentException;
        i = this.type;
        paramzzart = new java/lang/StringBuilder;
        paramzzart.<init>(24);
        ((IllegalArgumentException)paramObject).<init>("Unknown type " + i);
        throw ((Throwable)paramObject);
      }
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
    paramObject = (zzasa)paramObject;
    int i = zzasd.zzahl(this.tag);
    paramzzart.zzb((zzasa)paramObject);
    paramzzart.zzaj(i, 4);
    for (;;)
    {
      return;
      paramzzart.zzc((zzasa)paramObject);
    }
  }
  
  protected void zzc(Object paramObject, zzart paramzzart)
  {
    int j = Array.getLength(paramObject);
    for (int i = 0; i < j; i++)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null) {
        zzb(localObject, paramzzart);
      }
    }
  }
  
  protected Object zzcm(zzars paramzzars)
  {
    Object localObject1;
    if (this.btH) {
      localObject1 = this.bkp.getComponentType();
    }
    try
    {
      switch (this.type)
      {
      default: 
        localObject2 = new java/lang/IllegalArgumentException;
        int i = this.type;
        paramzzars = new java/lang/StringBuilder;
        paramzzars.<init>(24);
        ((IllegalArgumentException)localObject2).<init>("Unknown type " + i);
        throw ((Throwable)localObject2);
      }
    }
    catch (InstantiationException paramzzars)
    {
      for (;;)
      {
        localObject1 = String.valueOf(localObject1);
        throw new IllegalArgumentException(String.valueOf(localObject1).length() + 33 + "Error creating instance of class " + (String)localObject1, paramzzars);
        localObject1 = this.bkp;
      }
      Object localObject2 = (zzasa)((Class)localObject1).newInstance();
      paramzzars.zza((zzasa)localObject2, zzasd.zzahl(this.tag));
      for (paramzzars = (zzars)localObject2;; paramzzars = (zzars)localObject2)
      {
        return paramzzars;
        localObject2 = (zzasa)((Class)localObject1).newInstance();
        paramzzars.zza((zzasa)localObject2);
      }
    }
    catch (IllegalAccessException paramzzars)
    {
      localObject1 = String.valueOf(localObject1);
      throw new IllegalArgumentException(String.valueOf(localObject1).length() + 33 + "Error creating instance of class " + (String)localObject1, paramzzars);
    }
    catch (IOException paramzzars)
    {
      throw new IllegalArgumentException("Error reading extension field", paramzzars);
    }
  }
  
  int zzct(Object paramObject)
  {
    if (this.btH) {}
    for (int i = zzcu(paramObject);; i = zzcv(paramObject)) {
      return i;
    }
  }
  
  protected int zzcu(Object paramObject)
  {
    int k = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int j = k;
      if (Array.get(paramObject, i) != null) {
        j = k + zzcv(Array.get(paramObject, i));
      }
      i++;
      k = j;
    }
    return k;
  }
  
  protected int zzcv(Object paramObject)
  {
    int i = zzasd.zzahl(this.tag);
    switch (this.type)
    {
    default: 
      i = this.type;
      throw new IllegalArgumentException(24 + "Unknown type " + i);
    }
    for (i = zzart.zzb(i, (zzasa)paramObject);; i = zzart.zzc(i, (zzasa)paramObject)) {
      return i;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzarv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */