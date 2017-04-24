package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public final class zzaqc
  implements zzapl
{
  private final zzaps bod;
  
  public zzaqc(zzaps paramzzaps)
  {
    this.bod = paramzzaps;
  }
  
  public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
  {
    Type localType = paramzzaqo.bC();
    Class localClass = paramzzaqo.bB();
    if (!Collection.class.isAssignableFrom(localClass)) {}
    for (paramzzaos = null;; paramzzaos = new zza(paramzzaos, localType, paramzzaos.zza(zzaqo.zzl(localType)), this.bod.zzb(paramzzaqo)))
    {
      return paramzzaos;
      localType = zzapr.zza(localType, localClass);
    }
  }
  
  private static final class zza<E>
    extends zzapk<Collection<E>>
  {
    private final zzapk<E> bpJ;
    private final zzapx<? extends Collection<E>> bpK;
    
    public zza(zzaos paramzzaos, Type paramType, zzapk<E> paramzzapk, zzapx<? extends Collection<E>> paramzzapx)
    {
      this.bpJ = new zzaqm(paramzzaos, paramzzapk, paramType);
      this.bpK = paramzzapx;
    }
    
    public void zza(zzaqr paramzzaqr, Collection<E> paramCollection)
      throws IOException
    {
      if (paramCollection == null) {
        paramzzaqr.bA();
      }
      for (;;)
      {
        return;
        paramzzaqr.bw();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext())
        {
          Object localObject = paramCollection.next();
          this.bpJ.zza(paramzzaqr, localObject);
        }
        paramzzaqr.bx();
      }
    }
    
    public Collection<E> zzj(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ) {
        paramzzaqp.nextNull();
      }
      Collection localCollection;
      for (paramzzaqp = null;; paramzzaqp = localCollection)
      {
        return paramzzaqp;
        localCollection = (Collection)this.bpK.bj();
        paramzzaqp.beginArray();
        while (paramzzaqp.hasNext()) {
          localCollection.add(this.bpJ.zzb(paramzzaqp));
        }
        paramzzaqp.endArray();
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */