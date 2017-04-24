package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;

@TargetApi(12)
class zzbi<K, V>
  implements zzl<K, V>
{
  private LruCache<K, V> aFK;
  
  zzbi(int paramInt, final zzm.zza<K, V> paramzza)
  {
    this.aFK = new LruCache(paramInt)
    {
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        return paramzza.sizeOf(paramAnonymousK, paramAnonymousV);
      }
    };
  }
  
  public V get(K paramK)
  {
    return (V)this.aFK.get(paramK);
  }
  
  public void zzi(K paramK, V paramV)
  {
    this.aFK.put(paramK, paramV);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */