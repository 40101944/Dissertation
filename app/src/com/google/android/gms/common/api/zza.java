package com.google.android.gms.common.api;

import android.support.annotation.NonNull;

public class zza
  extends Exception
{
  protected final Status hv;
  
  public zza(@NonNull Status paramStatus)
  {
    super(paramStatus.getStatusMessage());
    this.hv = paramStatus;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\api\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */