package de.appplant.cordova.plugin.localnotification;

import de.appplant.cordova.plugin.notification.Builder;
import de.appplant.cordova.plugin.notification.Notification;
import de.appplant.cordova.plugin.notification.Options;
import de.appplant.cordova.plugin.notification.TriggerReceiver;

public class ClickActivity
  extends de.appplant.cordova.plugin.notification.ClickActivity
{
  public Notification buildNotification(Builder paramBuilder)
  {
    return paramBuilder.setTriggerReceiver(TriggerReceiver.class).build();
  }
  
  public void onClick(Notification paramNotification)
  {
    LocalNotification.fireEvent("click", paramNotification);
    super.onClick(paramNotification);
    if (paramNotification.getOptions().isOngoing().booleanValue()) {
      return;
    }
    if (paramNotification.isRepeating()) {}
    for (String str = "clear";; str = "cancel")
    {
      LocalNotification.fireEvent(str, paramNotification);
      break;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\localnotification\ClickActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */