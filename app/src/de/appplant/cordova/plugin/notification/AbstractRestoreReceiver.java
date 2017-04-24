package de.appplant.cordova.plugin.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public abstract class AbstractRestoreReceiver
  extends BroadcastReceiver
{
  public abstract Notification buildNotification(Builder paramBuilder);
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = Manager.getInstance(paramContext).getOptions().iterator();
    while (paramIntent.hasNext()) {
      onRestore(buildNotification(new Builder(paramContext, (JSONObject)paramIntent.next())));
    }
  }
  
  public abstract void onRestore(Notification paramNotification);
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\AbstractRestoreReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */