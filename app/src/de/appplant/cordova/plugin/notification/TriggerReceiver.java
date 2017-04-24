package de.appplant.cordova.plugin.notification;

public class TriggerReceiver
  extends AbstractTriggerReceiver
{
  public Notification buildNotification(Builder paramBuilder)
  {
    return paramBuilder.build();
  }
  
  public void onTrigger(Notification paramNotification, boolean paramBoolean)
  {
    paramNotification.show();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\TriggerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */