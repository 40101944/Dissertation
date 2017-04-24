package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzaqi
  extends zzapk<Object>
{
  public static final zzapl bpG = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
    {
      if (paramAnonymouszzaqo.bB() == Object.class) {}
      for (paramAnonymouszzaos = new zzaqi(paramAnonymouszzaos, null);; paramAnonymouszzaos = null) {
        return paramAnonymouszzaos;
      }
    }
  };
  private final zzaos boC;
  
  private zzaqi(zzaos paramzzaos)
  {
    this.boC = paramzzaos;
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
      zzapk localzzapk = this.boC.zzk(paramObject.getClass());
      if ((localzzapk instanceof zzaqi))
      {
        paramzzaqr.by();
        paramzzaqr.bz();
      }
      else
      {
        localzzapk.zza(paramzzaqr, paramObject);
      }
    }
  }
  
  public Object zzb(zzaqp paramzzaqp)
    throws IOException
  {
    Object localObject = paramzzaqp.bq();
    switch (2.bpW[localObject.ordinal()])
    {
    default: 
      throw new IllegalStateException();
    case 1: 
      localObject = new ArrayList();
      paramzzaqp.beginArray();
      while (paramzzaqp.hasNext()) {
        ((List)localObject).add(zzb(paramzzaqp));
      }
      paramzzaqp.endArray();
      paramzzaqp = (zzaqp)localObject;
    }
    for (;;)
    {
      return paramzzaqp;
      localObject = new zzapw();
      paramzzaqp.beginObject();
      while (paramzzaqp.hasNext()) {
        ((Map)localObject).put(paramzzaqp.nextName(), zzb(paramzzaqp));
      }
      paramzzaqp.endObject();
      paramzzaqp = (zzaqp)localObject;
      continue;
      paramzzaqp = paramzzaqp.nextString();
      continue;
      paramzzaqp = Double.valueOf(paramzzaqp.nextDouble());
      continue;
      paramzzaqp = Boolean.valueOf(paramzzaqp.nextBoolean());
      continue;
      paramzzaqp.nextNull();
      paramzzaqp = null;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */