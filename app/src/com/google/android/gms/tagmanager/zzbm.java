package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;

class zzbm
  implements zzcl
{
  private final long aFN;
  private final String cd;
  private final long fo;
  private final int fp;
  private double fq;
  private long fr;
  private final Object fs = new Object();
  private final zze zzaql;
  
  public zzbm(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString, zze paramzze)
  {
    this.fp = paramInt2;
    this.fq = Math.min(paramInt1, paramInt2);
    this.fo = paramLong1;
    this.aFN = paramLong2;
    this.cd = paramString;
    this.zzaql = paramzze;
  }
  
  public boolean zzagf()
  {
    boolean bool = false;
    for (;;)
    {
      synchronized (this.fs)
      {
        long l = this.zzaql.currentTimeMillis();
        if (l - this.fr < this.aFN)
        {
          str = this.cd;
          StringBuilder localStringBuilder1 = new java/lang/StringBuilder;
          localStringBuilder1.<init>(String.valueOf(str).length() + 34);
          zzbo.zzdi("Excessive " + str + " detected; call ignored.");
          return bool;
        }
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
        }
      }
      String str = this.cd;
      StringBuilder localStringBuilder2 = new java/lang/StringBuilder;
      localStringBuilder2.<init>(String.valueOf(str).length() + 34);
      zzbo.zzdi("Excessive " + str + " detected; call ignored.");
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */