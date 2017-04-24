package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzaa;

public class BooleanResult
  implements Result
{
  private final Status hv;
  private final boolean xv;
  
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    this.hv = ((Status)zzaa.zzb(paramStatus, "Status must not be null"));
    this.xv = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof BooleanResult))
      {
        bool = false;
      }
      else
      {
        paramObject = (BooleanResult)paramObject;
        if ((!this.hv.equals(((BooleanResult)paramObject).hv)) || (this.xv != ((BooleanResult)paramObject).xv)) {
          bool = false;
        }
      }
    }
  }
  
  public Status getStatus()
  {
    return this.hv;
  }
  
  public boolean getValue()
  {
    return this.xv;
  }
  
  public final int hashCode()
  {
    int j = this.hv.hashCode();
    if (this.xv) {}
    for (int i = 1;; i = 0) {
      return i + (j + 527) * 31;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\api\BooleanResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */