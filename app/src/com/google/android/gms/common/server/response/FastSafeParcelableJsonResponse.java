package com.google.android.gms.common.server.response;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class FastSafeParcelableJsonResponse
  extends FastJsonResponse
  implements SafeParcelable
{
  public final int describeContents()
  {
    return 0;
  }
  
  public Object zzic(String paramString)
  {
    return null;
  }
  
  public boolean zzid(String paramString)
  {
    return false;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\server\response\FastSafeParcelableJsonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */