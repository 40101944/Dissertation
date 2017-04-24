package de.appplant.cordova.plugin.notification;

public class ClickActivity
  extends AbstractClickActivity
{
  public Notification buildNotification(Builder paramBuilder)
  {
    return paramBuilder.build();
  }
  
  public void onClick(Notification paramNotification)
  {
    launchApp();
    if (paramNotification.isRepeating()) {
      paramNotification.clear();
    }
    for (;;)
    {
      return;
      paramNotification.cancel();
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\ClickActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */