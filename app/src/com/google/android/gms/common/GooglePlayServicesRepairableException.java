package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException
  extends UserRecoverableException
{
  private final int hM;
  
  GooglePlayServicesRepairableException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    this.hM = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return this.hM;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\GooglePlayServicesRepairableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */