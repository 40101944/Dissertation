package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;

public class zzv
  extends zzd
{
  private boolean ei;
  private boolean ej;
  private AlarmManager ek = (AlarmManager)getContext().getSystemService("alarm");
  
  protected zzv(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  private PendingIntent zzafo()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
    localIntent.setComponent(new ComponentName(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver"));
    return PendingIntent.getBroadcast(getContext(), 0, localIntent, 0);
  }
  
  public void cancel()
  {
    zzacj();
    this.ej = false;
    this.ek.cancel(zzafo());
  }
  
  public void schedule()
  {
    zzacj();
    zzaa.zza(zzafn(), "Receiver not registered");
    long l2 = zzacb().zzaen();
    if (l2 > 0L)
    {
      cancel();
      long l1 = zzabz().elapsedRealtime();
      this.ej = true;
      this.ek.setInexactRepeating(2, l1 + l2, 0L, zzafo());
    }
  }
  
  public boolean zzafn()
  {
    return this.ei;
  }
  
  public boolean zzfy()
  {
    return this.ej;
  }
  
  protected void zzzy()
  {
    try
    {
      this.ek.cancel(zzafo());
      if (zzacb().zzaen() > 0L)
      {
        Object localObject = getContext().getPackageManager();
        ComponentName localComponentName = new android/content/ComponentName;
        localComponentName.<init>(getContext(), "com.google.android.gms.analytics.AnalyticsReceiver");
        localObject = ((PackageManager)localObject).getReceiverInfo(localComponentName, 2);
        if ((localObject != null) && (((ActivityInfo)localObject).enabled))
        {
          zzes("Receiver registered. Using alarm for local dispatch.");
          this.ei = true;
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */