package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzaa;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> BR;
  protected int BS;
  
  public zzb(DataBuffer<T> paramDataBuffer)
  {
    this.BR = ((DataBuffer)zzaa.zzy(paramDataBuffer));
    this.BS = -1;
  }
  
  public boolean hasNext()
  {
    if (this.BS < this.BR.getCount() - 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public T next()
  {
    if (!hasNext())
    {
      i = this.BS;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    DataBuffer localDataBuffer = this.BR;
    int i = this.BS + 1;
    this.BS = i;
    return (T)localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\data\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */