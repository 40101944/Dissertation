package com.google.android.gms.tagmanager;

import android.util.Log;

public class zzz
  implements zzbp
{
  private int ee = 5;
  
  public void e(String paramString)
  {
    if (this.ee <= 6) {
      Log.e("GoogleTagManager", paramString);
    }
  }
  
  public void setLogLevel(int paramInt)
  {
    this.ee = paramInt;
  }
  
  public void v(String paramString)
  {
    if (this.ee <= 2) {
      Log.v("GoogleTagManager", paramString);
    }
  }
  
  public void zzb(String paramString, Throwable paramThrowable)
  {
    if (this.ee <= 6) {
      Log.e("GoogleTagManager", paramString, paramThrowable);
    }
  }
  
  public void zzc(String paramString, Throwable paramThrowable)
  {
    if (this.ee <= 5) {
      Log.w("GoogleTagManager", paramString, paramThrowable);
    }
  }
  
  public void zzdg(String paramString)
  {
    if (this.ee <= 3) {
      Log.d("GoogleTagManager", paramString);
    }
  }
  
  public void zzdh(String paramString)
  {
    if (this.ee <= 4) {
      Log.i("GoogleTagManager", paramString);
    }
  }
  
  public void zzdi(String paramString)
  {
    if (this.ee <= 5) {
      Log.w("GoogleTagManager", paramString);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */