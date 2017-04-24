package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzz;

public final class zzql<O extends Api.ApiOptions>
{
  private final Api<O> vS;
  private final O xw;
  private final boolean yo;
  private final int yp;
  
  private zzql(Api<O> paramApi)
  {
    this.yo = true;
    this.vS = paramApi;
    this.xw = null;
    this.yp = System.identityHashCode(this);
  }
  
  private zzql(Api<O> paramApi, O paramO)
  {
    this.yo = false;
    this.vS = paramApi;
    this.xw = paramO;
    this.yp = zzz.hashCode(new Object[] { this.vS, this.xw });
  }
  
  public static <O extends Api.ApiOptions> zzql<O> zza(Api<O> paramApi, O paramO)
  {
    return new zzql(paramApi, paramO);
  }
  
  public static <O extends Api.ApiOptions> zzql<O> zzb(Api<O> paramApi)
  {
    return new zzql(paramApi);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof zzql))
      {
        bool = false;
      }
      else
      {
        paramObject = (zzql)paramObject;
        if ((this.yo) || (((zzql)paramObject).yo) || (!zzz.equal(this.vS, ((zzql)paramObject).vS)) || (!zzz.equal(this.xw, ((zzql)paramObject).xw))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    return this.yp;
  }
  
  public String zzarl()
  {
    return this.vS.getName();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */