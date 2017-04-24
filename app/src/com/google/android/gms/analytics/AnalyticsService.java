package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzak.zza;

public final class AnalyticsService
  extends Service
  implements zzak.zza
{
  private zzak ar;
  
  private zzak zzyw()
  {
    if (this.ar == null) {
      this.ar = new zzak(this);
    }
    return this.ar;
  }
  
  public boolean callServiceStopSelfResult(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    zzyw();
    return null;
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onCreate()
  {
    super.onCreate();
    zzyw().onCreate();
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public void onDestroy()
  {
    zzyw().onDestroy();
    super.onDestroy();
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return zzyw().onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\AnalyticsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */