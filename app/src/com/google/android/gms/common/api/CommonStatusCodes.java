package com.google.android.gms.common.api;

import android.support.annotation.NonNull;

public class CommonStatusCodes
{
  public static final int API_NOT_CONNECTED = 17;
  public static final int CANCELED = 16;
  public static final int DEAD_CLIENT = 18;
  public static final int DEVELOPER_ERROR = 10;
  public static final int ERROR = 13;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 14;
  public static final int INVALID_ACCOUNT = 5;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_REQUIRED = 6;
  @Deprecated
  public static final int SERVICE_DISABLED = 3;
  @Deprecated
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int SUCCESS_CACHE = -1;
  public static final int TIMEOUT = 15;
  
  @NonNull
  public static String getStatusCodeString(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 1: 
    case 9: 
    case 11: 
    case 12: 
    default: 
      str = 32 + "unknown status code: " + paramInt;
    }
    for (;;)
    {
      return str;
      str = "SUCCESS_CACHE";
      continue;
      str = "SUCCESS";
      continue;
      str = "SERVICE_VERSION_UPDATE_REQUIRED";
      continue;
      str = "SERVICE_DISABLED";
      continue;
      str = "SIGN_IN_REQUIRED";
      continue;
      str = "INVALID_ACCOUNT";
      continue;
      str = "RESOLUTION_REQUIRED";
      continue;
      str = "NETWORK_ERROR";
      continue;
      str = "INTERNAL_ERROR";
      continue;
      str = "DEVELOPER_ERROR";
      continue;
      str = "ERROR";
      continue;
      str = "INTERRUPTED";
      continue;
      str = "TIMEOUT";
      continue;
      str = "CANCELED";
      continue;
      str = "API_NOT_CONNECTED";
      continue;
      str = "DEAD_CLIENT";
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\api\CommonStatusCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */