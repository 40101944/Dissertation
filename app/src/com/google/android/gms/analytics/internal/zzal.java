package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;

class zzal
{
  private final zze zzaql;
  private long zzbwt;
  
  public zzal(zze paramzze)
  {
    zzaa.zzy(paramzze);
    this.zzaql = paramzze;
  }
  
  public zzal(zze paramzze, long paramLong)
  {
    zzaa.zzy(paramzze);
    this.zzaql = paramzze;
    this.zzbwt = paramLong;
  }
  
  public void clear()
  {
    this.zzbwt = 0L;
  }
  
  public void start()
  {
    this.zzbwt = this.zzaql.elapsedRealtime();
  }
  
  public boolean zzz(long paramLong)
  {
    boolean bool = true;
    if (this.zzbwt == 0L) {}
    for (;;)
    {
      return bool;
      if (this.zzaql.elapsedRealtime() - this.zzbwt <= paramLong) {
        bool = false;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */