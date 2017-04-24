package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzaa;

class zzag
  extends BroadcastReceiver
{
  static final String fx = zzag.class.getName();
  private final zzf cQ;
  private boolean fy;
  private boolean fz;
  
  zzag(zzf paramzzf)
  {
    zzaa.zzy(paramzzf);
    this.cQ = paramzzf;
  }
  
  private Context getContext()
  {
    return this.cQ.getContext();
  }
  
  private zzaf zzaca()
  {
    return this.cQ.zzaca();
  }
  
  private void zzagi()
  {
    zzaca();
    zzzg();
  }
  
  private zzb zzzg()
  {
    return this.cQ.zzzg();
  }
  
  public boolean isConnected()
  {
    if (!this.fy) {
      this.cQ.zzaca().zzev("Connectivity unknown. Receiver not registered");
    }
    return this.fz;
  }
  
  public boolean isRegistered()
  {
    return this.fy;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    zzagi();
    paramContext = paramIntent.getAction();
    this.cQ.zzaca().zza("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = zzagk();
      if (this.fz != bool)
      {
        this.fz = bool;
        zzzg().zzaw(bool);
      }
    }
    for (;;)
    {
      return;
      if ("com.google.analytics.RADIO_POWERED".equals(paramContext))
      {
        if (!paramIntent.hasExtra(fx)) {
          zzzg().zzabv();
        }
      }
      else {
        this.cQ.zzaca().zzd("NetworkBroadcastReceiver received unknown action", paramContext);
      }
    }
  }
  
  public void unregister()
  {
    if (!isRegistered()) {}
    for (;;)
    {
      return;
      this.cQ.zzaca().zzes("Unregistering connectivity change receiver");
      this.fy = false;
      this.fz = false;
      Context localContext = getContext();
      try
      {
        localContext.unregisterReceiver(this);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        zzaca().zze("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
      }
    }
  }
  
  public void zzagh()
  {
    zzagi();
    if (this.fy) {}
    for (;;)
    {
      return;
      Context localContext = getContext();
      localContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      IntentFilter localIntentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
      localIntentFilter.addCategory(localContext.getPackageName());
      localContext.registerReceiver(this, localIntentFilter);
      this.fz = zzagk();
      this.cQ.zzaca().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.fz));
      this.fy = true;
    }
  }
  
  public void zzagj()
  {
    if (Build.VERSION.SDK_INT <= 10) {}
    for (;;)
    {
      return;
      Context localContext = getContext();
      Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
      localIntent.addCategory(localContext.getPackageName());
      localIntent.putExtra(fx, true);
      localContext.sendOrderedBroadcast(localIntent, null);
    }
  }
  
  protected boolean zzagk()
  {
    Object localObject = (ConnectivityManager)getContext().getSystemService("connectivity");
    for (;;)
    {
      try
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject == null) {
          continue;
        }
        bool = ((NetworkInfo)localObject).isConnected();
        if (!bool) {
          continue;
        }
        bool = true;
      }
      catch (SecurityException localSecurityException)
      {
        boolean bool = false;
        continue;
      }
      return bool;
      bool = false;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */