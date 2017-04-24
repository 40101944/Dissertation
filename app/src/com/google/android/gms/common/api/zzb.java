package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzql;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zzb
  extends Exception
{
  private final ArrayMap<zzql<?>, ConnectionResult> xo;
  
  public zzb(ArrayMap<zzql<?>, ConnectionResult> paramArrayMap)
  {
    this.xo = paramArrayMap;
  }
  
  public String getMessage()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.xo.keySet().iterator();
    int i = 1;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (zzql)((Iterator)localObject1).next();
      Object localObject3 = (ConnectionResult)this.xo.get(localObject2);
      if (((ConnectionResult)localObject3).isSuccess()) {
        i = 0;
      }
      localObject2 = String.valueOf(((zzql)localObject2).zzarl());
      localObject3 = String.valueOf(localObject3);
      localArrayList.add(String.valueOf(localObject2).length() + 2 + String.valueOf(localObject3).length() + (String)localObject2 + ": " + (String)localObject3);
    }
    localObject1 = new StringBuilder();
    if (i != 0) {
      ((StringBuilder)localObject1).append("None of the queried APIs are available. ");
    }
    for (;;)
    {
      zzx.zzia("; ").zza((StringBuilder)localObject1, localArrayList);
      return ((StringBuilder)localObject1).toString();
      ((StringBuilder)localObject1).append("Some of the queried APIs are unavailable. ");
    }
  }
  
  public ArrayMap<zzql<?>, ConnectionResult> zzara()
  {
    return this.xo;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\api\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */