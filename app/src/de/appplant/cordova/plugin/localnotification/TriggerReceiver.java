package de.appplant.cordova.plugin.localnotification;

import de.appplant.cordova.plugin.notification.Builder;
import de.appplant.cordova.plugin.notification.Notification;

public class TriggerReceiver
  extends de.appplant.cordova.plugin.notification.TriggerReceiver
{
  public Notification buildNotification(Builder paramBuilder)
  {
    return paramBuilder.setTriggerReceiver(TriggerReceiver.class).setClickActivity(ClickActivity.class).setClearReceiver(ClearReceiver.class).build();
  }
  
  public void onTrigger(Notification paramNotification, boolean paramBoolean)
  {
    super.onTrigger(paramNotification, paramBoolean);
    if (!paramBoolean) {
      LocalNotification.fireEvent("trigger", paramNotification);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\localnotification\TriggerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */