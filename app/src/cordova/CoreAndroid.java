package org.apache.cordova;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class CoreAndroid
  extends CordovaPlugin
{
  public static final String PLUGIN_NAME = "CoreAndroid";
  protected static final String TAG = "CordovaApp";
  private CallbackContext messageChannel;
  private final Object messageChannelLock = new Object();
  private PluginResult pendingResume;
  private BroadcastReceiver telephonyReceiver;
  
  private void initTelephonyReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    this.telephonyReceiver = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if ((paramAnonymousIntent != null) && (paramAnonymousIntent.getAction().equals("android.intent.action.PHONE_STATE")) && (paramAnonymousIntent.hasExtra("state")))
        {
          paramAnonymousContext = paramAnonymousIntent.getStringExtra("state");
          if (!paramAnonymousContext.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            break label70;
          }
          LOG.i("CordovaApp", "Telephone RINGING");
          CoreAndroid.this.webView.getPluginManager().postMessage("telephone", "ringing");
        }
        for (;;)
        {
          return;
          label70:
          if (paramAnonymousContext.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
          {
            LOG.i("CordovaApp", "Telephone OFFHOOK");
            CoreAndroid.this.webView.getPluginManager().postMessage("telephone", "offhook");
          }
          else if (paramAnonymousContext.equals(TelephonyManager.EXTRA_STATE_IDLE))
          {
            LOG.i("CordovaApp", "Telephone IDLE");
            CoreAndroid.this.webView.getPluginManager().postMessage("telephone", "idle");
          }
        }
      }
    };
    this.webView.getContext().registerReceiver(this.telephonyReceiver, localIntentFilter);
  }
  
  private void sendEventMessage(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString);
      sendEventMessage(new PluginResult(PluginResult.Status.OK, localJSONObject));
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        LOG.e("CordovaApp", "Failed to create event message", paramString);
      }
    }
  }
  
  private void sendEventMessage(PluginResult paramPluginResult)
  {
    paramPluginResult.setKeepCallback(true);
    if (this.messageChannel != null) {
      this.messageChannel.sendPluginResult(paramPluginResult);
    }
  }
  
  public void backHistory()
  {
    this.cordova.getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        CoreAndroid.this.webView.backHistory();
      }
    });
  }
  
  public void clearCache()
  {
    this.cordova.getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        CoreAndroid.this.webView.clearCache(true);
      }
    });
  }
  
  public void clearHistory()
  {
    this.cordova.getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        CoreAndroid.this.webView.clearHistory();
      }
    });
  }
  
  public boolean execute(String paramString, JSONArray arg2, CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool = true;
    PluginResult.Status localStatus = PluginResult.Status.OK;
    try
    {
      if (paramString.equals("clearCache")) {
        clearCache();
      }
      for (;;)
      {
        paramString = new org/apache/cordova/PluginResult;
        paramString.<init>(localStatus, "");
        paramCallbackContext.sendPluginResult(paramString);
        return bool;
        if (!paramString.equals("show")) {
          break;
        }
        paramString = this.cordova.getActivity();
        ??? = new org/apache/cordova/CoreAndroid$1;
        ???.<init>(this);
        paramString.runOnUiThread(???);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
        bool = false;
        continue;
        if (paramString.equals("loadUrl"))
        {
          loadUrl(???.getString(0), ???.optJSONObject(1));
          continue;
        }
        if (paramString.equals("cancelLoadUrl")) {
          continue;
        }
        if (paramString.equals("clearHistory"))
        {
          clearHistory();
          continue;
        }
        if (paramString.equals("backHistory"))
        {
          backHistory();
          continue;
        }
        if (paramString.equals("overrideButton"))
        {
          overrideButton(???.getString(0), ???.getBoolean(1));
          continue;
        }
        if (paramString.equals("overrideBackbutton"))
        {
          overrideBackbutton(???.getBoolean(0));
          continue;
        }
        if (paramString.equals("exitApp"))
        {
          exitApp();
          continue;
        }
        if (!paramString.equals("messageChannel")) {
          continue;
        }
        synchronized (this.messageChannelLock)
        {
          this.messageChannel = paramCallbackContext;
          if (this.pendingResume != null)
          {
            sendEventMessage(this.pendingResume);
            this.pendingResume = null;
          }
        }
      }
    }
  }
  
  public void exitApp()
  {
    this.webView.getPluginManager().postMessage("exit", null);
  }
  
  public void fireJavascriptEvent(String paramString)
  {
    sendEventMessage(paramString);
  }
  
  public boolean isBackbuttonOverridden()
  {
    return this.webView.isButtonPlumbedToJs(4);
  }
  
  public void loadUrl(String paramString, JSONObject paramJSONObject)
    throws JSONException
  {
    LOG.d("App", "App.loadUrl(" + paramString + "," + paramJSONObject + ")");
    int k = 0;
    int i = 0;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      JSONArray localJSONArray = paramJSONObject.names();
      int j = 0;
      bool3 = bool2;
      bool4 = bool1;
      k = i;
      if (j < localJSONArray.length())
      {
        String str = localJSONArray.getString(j);
        if (str.equals("wait"))
        {
          k = paramJSONObject.getInt(str);
          bool4 = bool1;
          bool3 = bool2;
        }
        for (;;)
        {
          j++;
          bool2 = bool3;
          bool1 = bool4;
          i = k;
          break;
          if (str.equalsIgnoreCase("openexternal"))
          {
            bool4 = paramJSONObject.getBoolean(str);
            bool3 = bool2;
            k = i;
          }
          else if (str.equalsIgnoreCase("clearhistory"))
          {
            bool3 = paramJSONObject.getBoolean(str);
            bool4 = bool1;
            k = i;
          }
          else
          {
            Object localObject = paramJSONObject.get(str);
            bool3 = bool2;
            bool4 = bool1;
            k = i;
            if (localObject != null) {
              if (localObject.getClass().equals(String.class))
              {
                localHashMap.put(str, (String)localObject);
                bool3 = bool2;
                bool4 = bool1;
                k = i;
              }
              else if (localObject.getClass().equals(Boolean.class))
              {
                localHashMap.put(str, (Boolean)localObject);
                bool3 = bool2;
                bool4 = bool1;
                k = i;
              }
              else
              {
                bool3 = bool2;
                bool4 = bool1;
                k = i;
                if (localObject.getClass().equals(Integer.class))
                {
                  localHashMap.put(str, (Integer)localObject);
                  bool3 = bool2;
                  bool4 = bool1;
                  k = i;
                }
              }
            }
          }
        }
      }
    }
    if (k > 0) {}
    for (;;)
    {
      try
      {
        l = k;
      }
      catch (InterruptedException paramJSONObject)
      {
        long l;
        paramJSONObject.printStackTrace();
        continue;
      }
      try
      {
        wait(l);
        this.webView.showWebPage(paramString, bool4, bool3, localHashMap);
        return;
      }
      finally {}
    }
  }
  
  public void onDestroy()
  {
    this.webView.getContext().unregisterReceiver(this.telephonyReceiver);
  }
  
  public void overrideBackbutton(boolean paramBoolean)
  {
    LOG.i("App", "WARNING: Back Button Default Behavior will be overridden.  The backbutton event will be fired!");
    this.webView.setButtonPlumbedToJs(4, paramBoolean);
  }
  
  public void overrideButton(String paramString, boolean paramBoolean)
  {
    LOG.i("App", "WARNING: Volume Button Default Behavior will be overridden.  The volume event will be fired!");
    if (paramString.equals("volumeup")) {
      this.webView.setButtonPlumbedToJs(24, paramBoolean);
    }
    for (;;)
    {
      return;
      if (paramString.equals("volumedown")) {
        this.webView.setButtonPlumbedToJs(25, paramBoolean);
      } else if (paramString.equals("menubutton")) {
        this.webView.setButtonPlumbedToJs(82, paramBoolean);
      }
    }
  }
  
  public void pluginInitialize()
  {
    initTelephonyReceiver();
  }
  
  public void sendResumeEvent(PluginResult paramPluginResult)
  {
    synchronized (this.messageChannelLock)
    {
      if (this.messageChannel != null)
      {
        sendEventMessage(paramPluginResult);
        return;
      }
      this.pendingResume = paramPluginResult;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\CoreAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */