package de.appplant.cordova.plugin.localnotification;

import de.appplant.cordova.plugin.notification.Notification;

public class ClearReceiver
  extends de.appplant.cordova.plugin.notification.ClearReceiver
{
  public void onClear(Notification paramNotification)
  {
    super.onClear(paramNotification);
    LocalNotification.fireEvent("clear", paramNotification);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\localnotification\ClearReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */