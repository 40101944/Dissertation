package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

class zzbt
  extends BroadcastReceiver
{
  static final String fx = zzbt.class.getName();
  private final zzdb aFV;
  
  zzbt(zzdb paramzzdb)
  {
    this.aFV = paramzzdb;
  }
  
  public static void zzeg(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.putExtra(fx, true);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    boolean bool;
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      Bundle localBundle = paramIntent.getExtras();
      paramContext = Boolean.FALSE;
      if (localBundle != null) {
        paramContext = Boolean.valueOf(paramIntent.getExtras().getBoolean("noConnectivity"));
      }
      paramIntent = this.aFV;
      if (!paramContext.booleanValue())
      {
        bool = true;
        paramIntent.zzco(bool);
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      if (("com.google.analytics.RADIO_POWERED".equals(paramContext)) && (!paramIntent.hasExtra(fx))) {
        this.aFV.zzabv();
      }
    }
  }
  
  public void zzef(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.google.analytics.RADIO_POWERED");
    localIntentFilter.addCategory(paramContext.getPackageName());
    paramContext.registerReceiver(this, localIntentFilter);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */