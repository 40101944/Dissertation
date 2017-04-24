package de.appplant.cordova.plugin.localnotification;

import de.appplant.cordova.plugin.notification.AbstractRestoreReceiver;
import de.appplant.cordova.plugin.notification.Builder;
import de.appplant.cordova.plugin.notification.Notification;

public class RestoreReceiver
  extends AbstractRestoreReceiver
{
  public Notification buildNotification(Builder paramBuilder)
  {
    return paramBuilder.setTriggerReceiver(TriggerReceiver.class).setClearReceiver(ClearReceiver.class).setClickActivity(ClickActivity.class).build();
  }
  
  public void onRestore(Notification paramNotification)
  {
    if (paramNotification.isScheduled()) {
      paramNotification.schedule();
    }
    for (;;)
    {
      return;
      paramNotification.cancel();
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\localnotification\RestoreReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */