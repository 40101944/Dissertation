package com.google.firebase;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;

public class FirebaseException
  extends Exception
{
  @Deprecated
  protected FirebaseException() {}
  
  public FirebaseException(@NonNull String paramString)
  {
    super(zzaa.zzh(paramString, "Detail message must not be empty"));
  }
  
  public FirebaseException(@NonNull String paramString, Throwable paramThrowable)
  {
    super(zzaa.zzh(paramString, "Detail message must not be empty"), paramThrowable);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\firebase\FirebaseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */