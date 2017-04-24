package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;

class zzda
  implements zzcl
{
  private long aHj;
  private final long fo;
  private final int fp;
  private double fq;
  private final Object fs = new Object();
  private final zze zzaql;
  
  public zzda()
  {
    this(60, 2000L);
  }
  
  public zzda(int paramInt, long paramLong)
  {
    this.fp = paramInt;
    this.fq = this.fp;
    this.fo = paramLong;
    this.zzaql = zzh.zzayl();
  }
  
  public boolean zzagf()
  {
    synchronized (this.fs)
    {
      long l = this.zzaql.currentTimeMillis();
      if (this.fq < this.fp)
      {
        double d = (l - this.aHj) / this.fo;
        if (d > 0.0D) {
          this.fq = Math.min(this.fp, d + this.fq);
        }
      }
      this.aHj = l;
      if (this.fq >= 1.0D)
      {
        this.fq -= 1.0D;
        bool = true;
        return bool;
      }
      zzbo.zzdi("No more tokens available.");
      boolean bool = false;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */