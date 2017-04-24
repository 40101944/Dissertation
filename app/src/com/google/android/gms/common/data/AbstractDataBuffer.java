package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataHolder zy;
  
  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    this.zy = paramDataHolder;
    if (this.zy != null) {}
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.zy == null) {}
    for (int i = 0;; i = this.zy.getCount()) {
      return i;
    }
  }
  
  @Deprecated
  public boolean isClosed()
  {
    if ((this.zy == null) || (this.zy.isClosed())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Iterator<T> iterator()
  {
    return new zzb(this);
  }
  
  public void release()
  {
    if (this.zy != null) {
      this.zy.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new zzg(this);
  }
  
  public Bundle zzaui()
  {
    return this.zy.zzaui();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\data\AbstractDataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */