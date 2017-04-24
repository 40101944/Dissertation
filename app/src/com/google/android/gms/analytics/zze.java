package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zze
{
  private final zzh aW;
  private boolean aX;
  private long aY;
  private long aZ;
  private long ba;
  private long bb;
  private long bc;
  private boolean bd;
  private final Map<Class<? extends zzg>, zzg> be;
  private final List<zzk> bf;
  private final com.google.android.gms.common.util.zze zzaql;
  
  zze(zze paramzze)
  {
    this.aW = paramzze.aW;
    this.zzaql = paramzze.zzaql;
    this.aY = paramzze.aY;
    this.aZ = paramzze.aZ;
    this.ba = paramzze.ba;
    this.bb = paramzze.bb;
    this.bc = paramzze.bc;
    this.bf = new ArrayList(paramzze.bf);
    this.be = new HashMap(paramzze.be.size());
    paramzze = paramzze.be.entrySet().iterator();
    while (paramzze.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramzze.next();
      zzg localzzg = zzc((Class)localEntry.getKey());
      ((zzg)localEntry.getValue()).zzb(localzzg);
      this.be.put((Class)localEntry.getKey(), localzzg);
    }
  }
  
  zze(zzh paramzzh, com.google.android.gms.common.util.zze paramzze)
  {
    zzaa.zzy(paramzzh);
    zzaa.zzy(paramzze);
    this.aW = paramzzh;
    this.zzaql = paramzze;
    this.bb = 1800000L;
    this.bc = 3024000000L;
    this.be = new HashMap();
    this.bf = new ArrayList();
  }
  
  private static <T extends zzg> T zzc(Class<T> paramClass)
  {
    try
    {
      paramClass = (zzg)paramClass.newInstance();
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalArgumentException("dataType doesn't have default constructor", paramClass);
    }
    catch (IllegalAccessException paramClass)
    {
      throw new IllegalArgumentException("dataType default constructor is not accessible", paramClass);
    }
  }
  
  public <T extends zzg> T zza(Class<T> paramClass)
  {
    return (zzg)this.be.get(paramClass);
  }
  
  public void zza(zzg paramzzg)
  {
    zzaa.zzy(paramzzg);
    Class localClass = paramzzg.getClass();
    if (localClass.getSuperclass() != zzg.class) {
      throw new IllegalArgumentException();
    }
    paramzzg.zzb(zzb(localClass));
  }
  
  public <T extends zzg> T zzb(Class<T> paramClass)
  {
    zzg localzzg2 = (zzg)this.be.get(paramClass);
    zzg localzzg1 = localzzg2;
    if (localzzg2 == null)
    {
      localzzg1 = zzc(paramClass);
      this.be.put(paramClass, localzzg1);
    }
    return localzzg1;
  }
  
  public void zzp(long paramLong)
  {
    this.aZ = paramLong;
  }
  
  public zze zzzi()
  {
    return new zze(this);
  }
  
  public Collection<zzg> zzzj()
  {
    return this.be.values();
  }
  
  public List<zzk> zzzk()
  {
    return this.bf;
  }
  
  public long zzzl()
  {
    return this.aY;
  }
  
  public void zzzm()
  {
    zzzq().zze(this);
  }
  
  public boolean zzzn()
  {
    return this.aX;
  }
  
  void zzzo()
  {
    this.ba = this.zzaql.elapsedRealtime();
    if (this.aZ != 0L) {}
    for (this.aY = this.aZ;; this.aY = this.zzaql.currentTimeMillis())
    {
      this.aX = true;
      return;
    }
  }
  
  zzh zzzp()
  {
    return this.aW;
  }
  
  zzi zzzq()
  {
    return this.aW.zzzq();
  }
  
  boolean zzzr()
  {
    return this.bd;
  }
  
  void zzzs()
  {
    this.bd = true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */