package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.util.zze;

public class zzad
{
  private final String cd;
  private final long fo;
  private final int fp;
  private double fq;
  private long fr;
  private final Object fs = new Object();
  private final zze zzaql;
  
  public zzad(int paramInt, long paramLong, String paramString, zze paramzze)
  {
    this.fp = paramInt;
    this.fq = this.fp;
    this.fo = paramLong;
    this.cd = paramString;
    this.zzaql = paramzze;
  }
  
  public zzad(String paramString, zze paramzze)
  {
    this(60, 2000L, paramString, paramzze);
  }
  
  public boolean zzagf()
  {
    synchronized (this.fs)
    {
      long l = this.zzaql.currentTimeMillis();
      if (this.fq < this.fp)
      {
        double d = (l - this.fr) / this.fo;
        if (d > 0.0D) {
          this.fq = Math.min(this.fp, d + this.fq);
        }
      }
      this.fr = l;
      if (this.fq >= 1.0D)
      {
        this.fq -= 1.0D;
        bool = true;
        return bool;
      }
      String str = this.cd;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>(String.valueOf(str).length() + 34);
      zzae.zzdi("Excessive " + str + " detected; call ignored.");
      boolean bool = false;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */