package de.appplant.cordova.plugin.notification;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class Notification
{
  static final String PREF_KEY = "LocalNotification";
  private static Class<?> defaultReceiver = TriggerReceiver.class;
  private final NotificationCompat.Builder builder;
  private final Context context;
  private final Options options;
  private Class<?> receiver = defaultReceiver;
  
  protected Notification(Context paramContext, Options paramOptions, NotificationCompat.Builder paramBuilder, Class<?> paramClass)
  {
    this.context = paramContext;
    this.options = paramOptions;
    this.builder = paramBuilder;
    if (paramClass != null) {}
    for (;;)
    {
      this.receiver = paramClass;
      return;
      paramClass = defaultReceiver;
    }
  }
  
  private AlarmManager getAlarmMgr()
  {
    return (AlarmManager)this.context.getSystemService("alarm");
  }
  
  private NotificationManager getNotMgr()
  {
    return (NotificationManager)this.context.getSystemService("notification");
  }
  
  private SharedPreferences getPrefs()
  {
    return this.context.getSharedPreferences("LocalNotification", 0);
  }
  
  private void persist()
  {
    SharedPreferences.Editor localEditor = getPrefs().edit();
    localEditor.putString(this.options.getIdStr(), this.options.toString());
    if (Build.VERSION.SDK_INT < 9) {
      localEditor.commit();
    }
    for (;;)
    {
      return;
      localEditor.apply();
    }
  }
  
  public static void setDefaultTriggerReceiver(Class<?> paramClass)
  {
    defaultReceiver = paramClass;
  }
  
  private void showNotification()
  {
    int i = getOptions().getId().intValue();
    if (Build.VERSION.SDK_INT <= 15) {
      getNotMgr().notify(i, this.builder.getNotification());
    }
    for (;;)
    {
      return;
      getNotMgr().notify(i, this.builder.build());
    }
  }
  
  private void unpersist()
  {
    SharedPreferences.Editor localEditor = getPrefs().edit();
    localEditor.remove(this.options.getIdStr());
    if (Build.VERSION.SDK_INT < 9) {
      localEditor.commit();
    }
    for (;;)
    {
      return;
      localEditor.apply();
    }
  }
  
  public void cancel()
  {
    Object localObject = new Intent(this.context, this.receiver).setAction(this.options.getIdStr());
    localObject = PendingIntent.getBroadcast(this.context, 0, (Intent)localObject, 0);
    getAlarmMgr().cancel((PendingIntent)localObject);
    getNotMgr().cancel(this.options.getId().intValue());
    unpersist();
  }
  
  public void clear()
  {
    if ((!isRepeating()) && (wasInThePast())) {
      unpersist();
    }
    if (!isRepeating()) {
      getNotMgr().cancel(getId());
    }
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public int getId()
  {
    return this.options.getId().intValue();
  }
  
  public Options getOptions()
  {
    return this.options;
  }
  
  public int getTriggerCountSinceSchedule()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.options.getTriggerTime();
    int i;
    if (!wasInThePast()) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (!isRepeating()) {
        i = 1;
      } else {
        i = (int)((l1 - l2) / this.options.getRepeatInterval());
      }
    }
  }
  
  public Type getType()
  {
    if (isScheduled()) {}
    for (Type localType = Type.SCHEDULED;; localType = Type.TRIGGERED) {
      return localType;
    }
  }
  
  public boolean isRepeating()
  {
    if (getOptions().getRepeatInterval() > 0L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isScheduled()
  {
    if ((isRepeating()) || (!wasInThePast())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isTriggered()
  {
    return wasInThePast();
  }
  
  protected boolean isUpdate(boolean paramBoolean)
  {
    boolean bool = this.options.getDict().optBoolean("updated", false);
    if (!paramBoolean) {
      this.options.getDict().remove("updated");
    }
    return bool;
  }
  
  public void schedule()
  {
    long l = this.options.getTriggerTime();
    persist();
    Object localObject = new Intent(this.context, this.receiver).setAction(this.options.getIdStr()).putExtra("NOTIFICATION_OPTIONS", this.options.toString());
    localObject = PendingIntent.getBroadcast(this.context, 0, (Intent)localObject, 268435456);
    if (isRepeating()) {
      getAlarmMgr().setRepeating(0, l, this.options.getRepeatInterval(), (PendingIntent)localObject);
    }
    for (;;)
    {
      return;
      getAlarmMgr().set(0, l, (PendingIntent)localObject);
    }
  }
  
  public void show()
  {
    showNotification();
  }
  
  public String toString()
  {
    JSONObject localJSONObject2 = this.options.getDict();
    Object localObject = new JSONObject();
    try
    {
      JSONObject localJSONObject1 = new org/json/JSONObject;
      localJSONObject1.<init>(localJSONObject2.toString());
      localObject = localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    ((JSONObject)localObject).remove("firstAt");
    ((JSONObject)localObject).remove("updated");
    ((JSONObject)localObject).remove("soundUri");
    ((JSONObject)localObject).remove("iconUri");
    return ((JSONObject)localObject).toString();
  }
  
  public boolean wasInThePast()
  {
    return new Date().after(this.options.getTriggerDate());
  }
  
  public static enum Type
  {
    ALL,  SCHEDULED,  TRIGGERED;
    
    private Type() {}
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\Notification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */