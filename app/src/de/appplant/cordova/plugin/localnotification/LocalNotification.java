package de.appplant.cordova.plugin.localnotification;

import de.appplant.cordova.plugin.notification.Manager;
import de.appplant.cordova.plugin.notification.Notification;
import de.appplant.cordova.plugin.notification.Notification.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalNotification
  extends CordovaPlugin
{
  private static Boolean deviceready;
  private static ArrayList<String> eventQueue = new ArrayList();
  protected static Boolean isInBackground;
  private static CordovaWebView webView = null;
  
  static
  {
    deviceready = Boolean.valueOf(false);
    isInBackground = Boolean.valueOf(true);
  }
  
  private void cancel(JSONArray paramJSONArray)
  {
    int i = 0;
    if (i < paramJSONArray.length())
    {
      int j = paramJSONArray.optInt(i, 0);
      Notification localNotification = getNotificationMgr().cancel(j);
      if (localNotification == null) {}
      for (;;)
      {
        i++;
        break;
        fireEvent("cancel", localNotification);
      }
    }
  }
  
  private void cancelAll()
  {
    getNotificationMgr().cancelAll();
    fireEvent("cancelall");
  }
  
  private void clear(JSONArray paramJSONArray)
  {
    int i = 0;
    if (i < paramJSONArray.length())
    {
      int j = paramJSONArray.optInt(i, 0);
      Notification localNotification = getNotificationMgr().clear(j);
      if (localNotification == null) {}
      for (;;)
      {
        i++;
        break;
        fireEvent("clear", localNotification);
      }
    }
  }
  
  private void clearAll()
  {
    getNotificationMgr().clearAll();
    fireEvent("clearall");
  }
  
  private static void deviceready()
  {
    try
    {
      isInBackground = Boolean.valueOf(false);
      deviceready = Boolean.valueOf(true);
      Iterator localIterator = eventQueue.iterator();
      while (localIterator.hasNext()) {
        sendJavascript((String)localIterator.next());
      }
      eventQueue.clear();
    }
    finally {}
  }
  
  private void fireEvent(String paramString)
  {
    fireEvent(paramString, null);
  }
  
  static void fireEvent(String paramString, Notification paramNotification)
  {
    Object localObject = getApplicationState();
    String str = "\"" + (String)localObject + "\"";
    localObject = str;
    if (paramNotification != null) {
      localObject = paramNotification.toString() + "," + str;
    }
    sendJavascript("cordova.plugins.notification.local.core.fireEvent(\"" + paramString + "\"," + (String)localObject + ")");
  }
  
  private void getAll(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    getOptions(paramJSONArray, Notification.Type.ALL, paramCallbackContext);
  }
  
  private void getAllIds(CallbackContext paramCallbackContext)
  {
    paramCallbackContext.success(new JSONArray(getNotificationMgr().getIds()));
  }
  
  static String getApplicationState()
  {
    if (isInBackground.booleanValue()) {}
    for (String str = "background";; str = "foreground") {
      return str;
    }
  }
  
  private Manager getNotificationMgr()
  {
    return Manager.getInstance(this.cordova.getActivity());
  }
  
  private void getOptions(String paramString, Notification.Type paramType, CallbackContext paramCallbackContext)
  {
    paramString = new JSONArray().put(paramString);
    paramString = getNotificationMgr().getOptionsBy(paramType, toList(paramString));
    if (paramString.isEmpty()) {}
    for (paramString = new PluginResult(PluginResult.Status.NO_RESULT);; paramString = new PluginResult(PluginResult.Status.OK, (JSONObject)paramString.get(0)))
    {
      paramCallbackContext.sendPluginResult(paramString);
      return;
    }
  }
  
  private void getOptions(JSONArray paramJSONArray, Notification.Type paramType, CallbackContext paramCallbackContext)
  {
    if (paramJSONArray.length() == 0) {}
    for (paramJSONArray = getNotificationMgr().getOptionsByType(paramType);; paramJSONArray = getNotificationMgr().getOptionsBy(paramType, toList(paramJSONArray)))
    {
      paramCallbackContext.success(new JSONArray(paramJSONArray));
      return;
    }
  }
  
  private void getScheduled(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    getOptions(paramJSONArray, Notification.Type.SCHEDULED, paramCallbackContext);
  }
  
  private void getScheduledIds(CallbackContext paramCallbackContext)
  {
    paramCallbackContext.success(new JSONArray(getNotificationMgr().getIdsByType(Notification.Type.SCHEDULED)));
  }
  
  private void getSingle(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    getOptions(paramJSONArray.optString(0), Notification.Type.ALL, paramCallbackContext);
  }
  
  private void getSingleScheduled(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    getOptions(paramJSONArray.optString(0), Notification.Type.SCHEDULED, paramCallbackContext);
  }
  
  private void getSingleTriggered(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    getOptions(paramJSONArray.optString(0), Notification.Type.TRIGGERED, paramCallbackContext);
  }
  
  private void getTriggered(JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    getOptions(paramJSONArray, Notification.Type.TRIGGERED, paramCallbackContext);
  }
  
  private void getTriggeredIds(CallbackContext paramCallbackContext)
  {
    paramCallbackContext.success(new JSONArray(getNotificationMgr().getIdsByType(Notification.Type.TRIGGERED)));
  }
  
  private void isPresent(int paramInt, CallbackContext paramCallbackContext)
  {
    boolean bool = getNotificationMgr().exist(paramInt);
    paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, bool));
  }
  
  private void isScheduled(int paramInt, CallbackContext paramCallbackContext)
  {
    boolean bool = getNotificationMgr().exist(paramInt, Notification.Type.SCHEDULED);
    paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, bool));
  }
  
  private void isTriggered(int paramInt, CallbackContext paramCallbackContext)
  {
    boolean bool = getNotificationMgr().exist(paramInt, Notification.Type.TRIGGERED);
    paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, bool));
  }
  
  private void schedule(JSONArray paramJSONArray)
  {
    for (int i = 0; i < paramJSONArray.length(); i++)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      fireEvent("schedule", getNotificationMgr().schedule(localJSONObject, TriggerReceiver.class));
    }
  }
  
  /* Error */
  private static void sendJavascript(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	de/appplant/cordova/plugin/localnotification/LocalNotification:deviceready	Ljava/lang/Boolean;
    //   6: invokevirtual 234	java/lang/Boolean:booleanValue	()Z
    //   9: ifne +15 -> 24
    //   12: getstatic 37	de/appplant/cordova/plugin/localnotification/LocalNotification:eventQueue	Ljava/util/ArrayList;
    //   15: aload_0
    //   16: invokevirtual 343	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   19: pop
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: new 8	de/appplant/cordova/plugin/localnotification/LocalNotification$2
    //   27: astore_1
    //   28: aload_1
    //   29: aload_0
    //   30: invokespecial 345	de/appplant/cordova/plugin/localnotification/LocalNotification$2:<init>	(Ljava/lang/String;)V
    //   33: getstatic 20	de/appplant/cordova/plugin/localnotification/LocalNotification:webView	Lorg/apache/cordova/CordovaWebView;
    //   36: invokevirtual 351	java/lang/Object:getClass	()Ljava/lang/Class;
    //   39: ldc_w 353
    //   42: iconst_1
    //   43: anewarray 355	java/lang/Class
    //   46: dup
    //   47: iconst_0
    //   48: ldc_w 357
    //   51: aastore
    //   52: invokevirtual 361	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   55: getstatic 20	de/appplant/cordova/plugin/localnotification/LocalNotification:webView	Lorg/apache/cordova/CordovaWebView;
    //   58: iconst_1
    //   59: anewarray 347	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: aastore
    //   66: invokevirtual 367	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: goto -50 -> 20
    //   73: astore_0
    //   74: getstatic 20	de/appplant/cordova/plugin/localnotification/LocalNotification:webView	Lorg/apache/cordova/CordovaWebView;
    //   77: invokeinterface 373 1 0
    //   82: checkcast 375	android/app/Activity
    //   85: checkcast 375	android/app/Activity
    //   88: aload_1
    //   89: invokevirtual 379	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   92: goto -72 -> 20
    //   95: astore_0
    //   96: ldc 2
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramString	String
    //   27	62	1	local2	2
    // Exception table:
    //   from	to	target	type
    //   33	70	73	java/lang/Exception
    //   3	20	95	finally
    //   24	33	95	finally
    //   33	70	95	finally
    //   74	92	95	finally
  }
  
  private List<Integer> toList(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++) {
      localArrayList.add(Integer.valueOf(paramJSONArray.optInt(i)));
    }
    return localArrayList;
  }
  
  private void update(JSONArray paramJSONArray)
  {
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      int j = ((JSONObject)localObject).optInt("id", 0);
      localObject = getNotificationMgr().update(j, (JSONObject)localObject, TriggerReceiver.class);
      if (localObject == null) {}
      for (;;)
      {
        i++;
        break;
        fireEvent("update", (Notification)localObject);
      }
    }
  }
  
  public boolean execute(final String paramString, final JSONArray paramJSONArray, final CallbackContext paramCallbackContext)
    throws JSONException
  {
    Notification.setDefaultTriggerReceiver(TriggerReceiver.class);
    this.cordova.getThreadPool().execute(new Runnable()
    {
      public void run()
      {
        if (paramString.equals("schedule"))
        {
          LocalNotification.this.schedule(paramJSONArray);
          paramCallbackContext.success();
        }
        for (;;)
        {
          return;
          if (paramString.equals("update"))
          {
            LocalNotification.this.update(paramJSONArray);
            paramCallbackContext.success();
          }
          else if (paramString.equals("cancel"))
          {
            LocalNotification.this.cancel(paramJSONArray);
            paramCallbackContext.success();
          }
          else if (paramString.equals("cancelAll"))
          {
            LocalNotification.this.cancelAll();
            paramCallbackContext.success();
          }
          else if (paramString.equals("clear"))
          {
            LocalNotification.this.clear(paramJSONArray);
            paramCallbackContext.success();
          }
          else if (paramString.equals("clearAll"))
          {
            LocalNotification.this.clearAll();
            paramCallbackContext.success();
          }
          else if (paramString.equals("isPresent"))
          {
            LocalNotification.this.isPresent(paramJSONArray.optInt(0), paramCallbackContext);
          }
          else if (paramString.equals("isScheduled"))
          {
            LocalNotification.this.isScheduled(paramJSONArray.optInt(0), paramCallbackContext);
          }
          else if (paramString.equals("isTriggered"))
          {
            LocalNotification.this.isTriggered(paramJSONArray.optInt(0), paramCallbackContext);
          }
          else if (paramString.equals("getAllIds"))
          {
            LocalNotification.this.getAllIds(paramCallbackContext);
          }
          else if (paramString.equals("getScheduledIds"))
          {
            LocalNotification.this.getScheduledIds(paramCallbackContext);
          }
          else if (paramString.equals("getTriggeredIds"))
          {
            LocalNotification.this.getTriggeredIds(paramCallbackContext);
          }
          else if (paramString.equals("getSingle"))
          {
            LocalNotification.this.getSingle(paramJSONArray, paramCallbackContext);
          }
          else if (paramString.equals("getSingleScheduled"))
          {
            LocalNotification.this.getSingleScheduled(paramJSONArray, paramCallbackContext);
          }
          else if (paramString.equals("getSingleTriggered"))
          {
            LocalNotification.this.getSingleTriggered(paramJSONArray, paramCallbackContext);
          }
          else if (paramString.equals("getAll"))
          {
            LocalNotification.this.getAll(paramJSONArray, paramCallbackContext);
          }
          else if (paramString.equals("getScheduled"))
          {
            LocalNotification.this.getScheduled(paramJSONArray, paramCallbackContext);
          }
          else if (paramString.equals("getTriggered"))
          {
            LocalNotification.this.getTriggered(paramJSONArray, paramCallbackContext);
          }
          else if (paramString.equals("deviceready"))
          {
            LocalNotification.access$1800();
          }
        }
      }
    });
    return true;
  }
  
  public void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    webView = this.webView;
  }
  
  public void onDestroy()
  {
    deviceready = Boolean.valueOf(false);
    isInBackground = Boolean.valueOf(true);
  }
  
  public void onPause(boolean paramBoolean)
  {
    super.onPause(paramBoolean);
    isInBackground = Boolean.valueOf(true);
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
    isInBackground = Boolean.valueOf(false);
    deviceready();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\localnotification\LocalNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */