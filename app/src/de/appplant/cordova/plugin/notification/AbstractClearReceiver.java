package de.appplant.cordova.plugin.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractClearReceiver
  extends BroadcastReceiver
{
  public abstract void onClear(Notification paramNotification);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    try
    {
      String str = paramIntent.getString("NOTIFICATION_OPTIONS");
      paramIntent = new org/json/JSONObject;
      paramIntent.<init>(str);
      onClear(new Builder(paramContext, paramIntent).build());
      return;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\AbstractClearReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */