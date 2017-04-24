package org.apache.cordova;

import android.util.Pair;
import android.util.SparseArray;

public class CallbackMap
{
  private SparseArray<Pair<CordovaPlugin, Integer>> callbacks = new SparseArray();
  private int currentCallbackId = 0;
  
  public Pair<CordovaPlugin, Integer> getAndRemoveCallback(int paramInt)
  {
    try
    {
      Pair localPair = (Pair)this.callbacks.get(paramInt);
      this.callbacks.remove(paramInt);
      return localPair;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int registerCallback(CordovaPlugin paramCordovaPlugin, int paramInt)
  {
    try
    {
      int i = this.currentCallbackId;
      this.currentCallbackId = (i + 1);
      SparseArray localSparseArray = this.callbacks;
      Pair localPair = new android/util/Pair;
      localPair.<init>(paramCordovaPlugin, Integer.valueOf(paramInt));
      localSparseArray.put(i, localPair);
      return i;
    }
    finally
    {
      paramCordovaPlugin = finally;
      throw paramCordovaPlugin;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\CallbackMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */