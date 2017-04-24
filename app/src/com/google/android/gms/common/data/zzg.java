package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T>
  extends zzb<T>
{
  private T Cn;
  
  public zzg(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (!hasNext())
    {
      int i = this.BS;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    this.BS += 1;
    if (this.BS == 0)
    {
      this.Cn = this.BR.get(0);
      if (!(this.Cn instanceof zzc))
      {
        String str = String.valueOf(this.Cn.getClass());
        throw new IllegalStateException(String.valueOf(str).length() + 44 + "DataBuffer reference of type " + str + " is not movable");
      }
    }
    else
    {
      ((zzc)this.Cn).zzfy(this.BS);
    }
    return (T)this.Cn;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\data\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */