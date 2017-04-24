package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zzh<T extends zzh>
{
  private final zzi bg;
  protected final zze bh;
  private final List<zzf> bi;
  
  protected zzh(zzi paramzzi, com.google.android.gms.common.util.zze paramzze)
  {
    zzaa.zzy(paramzzi);
    this.bg = paramzzi;
    this.bi = new ArrayList();
    paramzzi = new zze(this, paramzze);
    paramzzi.zzzs();
    this.bh = paramzzi;
  }
  
  protected void zza(zze paramzze) {}
  
  protected void zzd(zze paramzze)
  {
    Iterator localIterator = this.bi.iterator();
    while (localIterator.hasNext()) {
      ((zzf)localIterator.next()).zza(this, paramzze);
    }
  }
  
  public zze zzyu()
  {
    zze localzze = this.bh.zzzi();
    zzd(localzze);
    return localzze;
  }
  
  protected zzi zzzq()
  {
    return this.bg;
  }
  
  public zze zzzt()
  {
    return this.bh;
  }
  
  public List<zzk> zzzu()
  {
    return this.bh.zzzk();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */