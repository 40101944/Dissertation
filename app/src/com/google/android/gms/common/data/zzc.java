package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;

public abstract class zzc
{
  protected int BU;
  private int BV;
  protected final DataHolder zy;
  
  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    this.zy = ((DataHolder)zzaa.zzy(paramDataHolder));
    zzfy(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      bool1 = bool2;
      if (zzz.equal(Integer.valueOf(((zzc)paramObject).BU), Integer.valueOf(this.BU)))
      {
        bool1 = bool2;
        if (zzz.equal(Integer.valueOf(((zzc)paramObject).BV), Integer.valueOf(this.BV)))
        {
          bool1 = bool2;
          if (((zzc)paramObject).zy == this.zy) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.zy.zze(paramString, this.BU, this.BV);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.zy.zzg(paramString, this.BU, this.BV);
  }
  
  protected float getFloat(String paramString)
  {
    return this.zy.zzf(paramString, this.BU, this.BV);
  }
  
  protected int getInteger(String paramString)
  {
    return this.zy.zzc(paramString, this.BU, this.BV);
  }
  
  protected long getLong(String paramString)
  {
    return this.zy.zzb(paramString, this.BU, this.BV);
  }
  
  protected String getString(String paramString)
  {
    return this.zy.zzd(paramString, this.BU, this.BV);
  }
  
  public int hashCode()
  {
    return zzz.hashCode(new Object[] { Integer.valueOf(this.BU), Integer.valueOf(this.BV), this.zy });
  }
  
  public boolean isDataValid()
  {
    if (!this.zy.isClosed()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void zza(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.zy.zza(paramString, this.BU, this.BV, paramCharArrayBuffer);
  }
  
  protected int zzaul()
  {
    return this.BU;
  }
  
  protected void zzfy(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zy.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      zzaa.zzbs(bool);
      this.BU = paramInt;
      this.BV = this.zy.zzga(this.BU);
      return;
    }
  }
  
  public boolean zzho(String paramString)
  {
    return this.zy.zzho(paramString);
  }
  
  protected Uri zzhp(String paramString)
  {
    return this.zy.zzh(paramString, this.BU, this.BV);
  }
  
  protected boolean zzhq(String paramString)
  {
    return this.zy.zzi(paramString, this.BU, this.BV);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\data\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */