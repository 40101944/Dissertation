package com.google.android.gms.common.data;

import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet
  implements DataBufferObserver, DataBufferObserver.Observable
{
  private HashSet<DataBufferObserver> BT = new HashSet();
  
  public void addObserver(DataBufferObserver paramDataBufferObserver)
  {
    this.BT.add(paramDataBufferObserver);
  }
  
  public void clear()
  {
    this.BT.clear();
  }
  
  public boolean hasObservers()
  {
    if (!this.BT.isEmpty()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onDataChanged()
  {
    Iterator localIterator = this.BT.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataChanged();
    }
  }
  
  public void onDataRangeChanged(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.BT.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onDataRangeInserted(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.BT.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeInserted(paramInt1, paramInt2);
    }
  }
  
  public void onDataRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.BT.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeMoved(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onDataRangeRemoved(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.BT.iterator();
    while (localIterator.hasNext()) {
      ((DataBufferObserver)localIterator.next()).onDataRangeRemoved(paramInt1, paramInt2);
    }
  }
  
  public void removeObserver(DataBufferObserver paramDataBufferObserver)
  {
    this.BT.remove(paramDataBufferObserver);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\data\DataBufferObserverSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */