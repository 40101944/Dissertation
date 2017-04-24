package de.appplant.cordova.plugin.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractTriggerReceiver
  extends BroadcastReceiver
{
  private Boolean isFirstAlarmInFuture(Options paramOptions)
  {
    boolean bool2 = false;
    Notification localNotification = new Builder(paramOptions).build();
    if (!localNotification.isRepeating()) {}
    boolean bool1;
    for (paramOptions = Boolean.valueOf(false);; paramOptions = Boolean.valueOf(bool1))
    {
      return paramOptions;
      paramOptions = Calendar.getInstance();
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(localNotification.getOptions().getTriggerDate());
      int k = localCalendar.get(11);
      int j = localCalendar.get(12);
      int m = paramOptions.get(11);
      int i = paramOptions.get(12);
      bool1 = bool2;
      if (m != k)
      {
        bool1 = bool2;
        if (i != j) {
          bool1 = true;
        }
      }
    }
  }
  
  public abstract Notification buildNotification(Builder paramBuilder);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    try
    {
      Object localObject = paramIntent.getString("NOTIFICATION_OPTIONS");
      paramIntent = new org/json/JSONObject;
      paramIntent.<init>((String)localObject);
      localObject = new de/appplant/cordova/plugin/notification/Options;
      ((Options)localObject).<init>(paramContext);
      paramContext = ((Options)localObject).parse(paramIntent);
      if (paramContext == null) {
        return;
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        continue;
        if (!isFirstAlarmInFuture(paramContext).booleanValue())
        {
          paramContext = buildNotification(new Builder(paramContext));
          onTrigger(paramContext, paramContext.isUpdate(false));
        }
      }
    }
  }
  
  public abstract void onTrigger(Notification paramNotification, boolean paramBoolean);
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\AbstractTriggerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */