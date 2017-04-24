package de.appplant.cordova.plugin.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import java.util.Random;
import org.json.JSONObject;

public class Builder
{
  private Class<?> clearReceiver = ClearReceiver.class;
  private Class<?> clickActivity = ClickActivity.class;
  private final Context context;
  private final Options options;
  private Class<?> triggerReceiver;
  
  public Builder(Context paramContext, JSONObject paramJSONObject)
  {
    this.context = paramContext;
    this.options = new Options(paramContext).parse(paramJSONObject);
  }
  
  public Builder(Options paramOptions)
  {
    this.context = paramOptions.getContext();
    this.options = paramOptions;
  }
  
  private void applyContentReceiver(NotificationCompat.Builder paramBuilder)
  {
    if (this.clickActivity == null) {}
    for (;;)
    {
      return;
      Intent localIntent = new Intent(this.context, this.clickActivity).putExtra("NOTIFICATION_OPTIONS", this.options.toString()).setFlags(1073741824);
      int i = new Random().nextInt();
      paramBuilder.setContentIntent(PendingIntent.getActivity(this.context, i, localIntent, 134217728));
    }
  }
  
  private void applyDeleteReceiver(NotificationCompat.Builder paramBuilder)
  {
    if (this.clearReceiver == null) {}
    for (;;)
    {
      return;
      Intent localIntent = new Intent(this.context, this.clearReceiver).setAction(this.options.getIdStr()).putExtra("NOTIFICATION_OPTIONS", this.options.toString());
      paramBuilder.setDeleteIntent(PendingIntent.getBroadcast(this.context, 0, localIntent, 134217728));
    }
  }
  
  public Notification build()
  {
    Uri localUri = this.options.getSoundUri();
    int i = this.options.getSmallIcon();
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.context).setDefaults(0).setContentTitle(this.options.getTitle()).setContentText(this.options.getText()).setNumber(this.options.getBadgeNumber()).setTicker(this.options.getText()).setAutoCancel(this.options.isAutoClear().booleanValue()).setOngoing(this.options.isOngoing().booleanValue()).setColor(this.options.getColor()).setLights(this.options.getLedColor(), 100, 100);
    if (localUri != null) {
      localBuilder.setSound(localUri);
    }
    if (i == 0) {
      localBuilder.setSmallIcon(this.options.getIcon());
    }
    for (;;)
    {
      applyDeleteReceiver(localBuilder);
      applyContentReceiver(localBuilder);
      return new Notification(this.context, this.options, localBuilder, this.triggerReceiver);
      localBuilder.setSmallIcon(this.options.getSmallIcon());
      localBuilder.setLargeIcon(this.options.getIconBitmap());
    }
  }
  
  public Builder setClearReceiver(Class<?> paramClass)
  {
    this.clearReceiver = paramClass;
    return this;
  }
  
  public Builder setClickActivity(Class<?> paramClass)
  {
    this.clickActivity = paramClass;
    return this;
  }
  
  public Builder setTriggerReceiver(Class<?> paramClass)
  {
    this.triggerReceiver = paramClass;
    return this;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */