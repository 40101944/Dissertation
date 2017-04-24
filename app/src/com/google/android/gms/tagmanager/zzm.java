package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class zzm<K, V>
{
  final zza<K, V> aDW = new zza()
  {
    public int sizeOf(K paramAnonymousK, V paramAnonymousV)
    {
      return 1;
    }
  };
  
  public zzl<K, V> zza(int paramInt, zza<K, V> paramzza)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (zzazh() < 12) {}
    for (paramzza = new zzde(paramInt, paramzza);; paramzza = new zzbi(paramInt, paramzza)) {
      return paramzza;
    }
  }
  
  int zzazh()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static abstract interface zza<K, V>
  {
    public abstract int sizeOf(K paramK, V paramV);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */