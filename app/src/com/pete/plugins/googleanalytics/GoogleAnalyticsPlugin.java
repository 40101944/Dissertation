package com.cmackay.plugins.googleanalytics;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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

public class GoogleAnalyticsPlugin
  extends CordovaPlugin
{
  private static GoogleAnalytics ga;
  private static Tracker tracker;
  
  private void close(String paramString, final CallbackContext paramCallbackContext)
  {
    this.cordova.getThreadPool().execute(new Runnable()
    {
      public void run()
      {
        if (GoogleAnalyticsPlugin.this.hasTracker(paramCallbackContext))
        {
          GoogleAnalyticsPlugin.ga.dispatchLocalHits();
          GoogleAnalyticsPlugin.access$202(null);
          paramCallbackContext.success();
        }
      }
    });
  }
  
  private void get(String paramString, CallbackContext paramCallbackContext)
  {
    if (hasTracker(paramCallbackContext)) {}
    try
    {
      Tracker localTracker = tracker;
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>(paramString);
      paramCallbackContext.success(localTracker.get(localJSONArray.getString(0)));
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(paramString.toString());
      }
    }
  }
  
  private void getAppOptOut(CallbackContext paramCallbackContext)
  {
    paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, ga.getAppOptOut()));
  }
  
  private boolean hasTracker(CallbackContext paramCallbackContext)
  {
    if (tracker == null) {
      paramCallbackContext.error("Tracker not initialized. Call setTrackingId prior to using tracker.");
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private static Map<String, String> objectToMap(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.length() == 0) {
      localObject = Collections.emptyMap();
    }
    HashMap localHashMap;
    Iterator localIterator;
    do
    {
      return (Map<String, String>)localObject;
      localHashMap = new HashMap(paramJSONObject.length());
      localIterator = paramJSONObject.keys();
      localObject = localHashMap;
    } while (!localIterator.hasNext());
    String str = localIterator.next().toString();
    if (paramJSONObject.has(str)) {}
    for (Object localObject = paramJSONObject.get(str).toString();; localObject = null)
    {
      localHashMap.put(str, localObject);
      break;
    }
  }
  
  private void send(final String paramString, final CallbackContext paramCallbackContext)
  {
    this.cordova.getThreadPool().execute(new Runnable()
    {
      public void run()
      {
        if (GoogleAnalyticsPlugin.this.hasTracker(paramCallbackContext)) {}
        try
        {
          JSONArray localJSONArray = new org/json/JSONArray;
          localJSONArray.<init>(paramString);
          GoogleAnalyticsPlugin.tracker.send(GoogleAnalyticsPlugin.objectToMap(localJSONArray.getJSONObject(0)));
          paramCallbackContext.success();
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            paramCallbackContext.error(localJSONException.toString());
          }
        }
      }
    });
  }
  
  private void set(String paramString, CallbackContext paramCallbackContext)
  {
    if (hasTracker(paramCallbackContext)) {}
    for (;;)
    {
      try
      {
        localJSONArray = new org/json/JSONArray;
        localJSONArray.<init>(paramString);
        String str = localJSONArray.getString(0);
        if (localJSONArray.isNull(1))
        {
          paramString = null;
          tracker.set(str, paramString);
          paramCallbackContext.success();
          return;
        }
      }
      catch (JSONException paramString)
      {
        JSONArray localJSONArray;
        paramCallbackContext.error(paramString.toString());
        continue;
      }
      paramString = localJSONArray.getString(1);
    }
  }
  
  private void setAppOptOut(String paramString, CallbackContext paramCallbackContext)
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = ga;
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>(paramString);
      localGoogleAnalytics.setAppOptOut(localJSONArray.getBoolean(0));
      paramCallbackContext.success();
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(paramString.toString());
      }
    }
  }
  
  private void setDispatchInterval(String paramString, CallbackContext paramCallbackContext)
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = ga;
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>(paramString);
      localGoogleAnalytics.setLocalDispatchPeriod(localJSONArray.getInt(0));
      paramCallbackContext.success();
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(paramString.toString());
      }
    }
  }
  
  private void setIDFAEnabled(String paramString, CallbackContext paramCallbackContext)
  {
    if (hasTracker(paramCallbackContext))
    {
      tracker.enableAdvertisingIdCollection(true);
      paramCallbackContext.success();
    }
  }
  
  private void setLogLevel(String paramString, CallbackContext paramCallbackContext)
  {
    if (hasTracker(paramCallbackContext)) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new org/json/JSONArray;
        localJSONArray.<init>(paramString);
        int j = localJSONArray.getInt(0);
        i = 2;
        switch (j)
        {
        default: 
          ga.getLogger().setLogLevel(i);
          paramCallbackContext.success();
          return;
        }
      }
      catch (JSONException paramString)
      {
        int i;
        paramCallbackContext.error(paramString.toString());
        continue;
      }
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private void setTrackingId(String paramString, CallbackContext paramCallbackContext)
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = ga;
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>(paramString);
      tracker = localGoogleAnalytics.newTracker(localJSONArray.getString(0));
      tracker.enableExceptionReporting(true);
      paramCallbackContext.success();
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(paramString.toString());
      }
    }
  }
  
  public boolean execute(String paramString1, String paramString2, CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool = true;
    if ("setTrackingId".equals(paramString1)) {
      setTrackingId(paramString2, paramCallbackContext);
    }
    for (;;)
    {
      return bool;
      if ("setDispatchInterval".equals(paramString1)) {
        setDispatchInterval(paramString2, paramCallbackContext);
      } else if ("setLogLevel".equals(paramString1)) {
        setLogLevel(paramString2, paramCallbackContext);
      } else if ("setIDFAEnabled".equals(paramString1)) {
        setIDFAEnabled(paramString2, paramCallbackContext);
      } else if ("get".equals(paramString1)) {
        get(paramString2, paramCallbackContext);
      } else if ("set".equals(paramString1)) {
        set(paramString2, paramCallbackContext);
      } else if ("send".equals(paramString1)) {
        send(paramString2, paramCallbackContext);
      } else if ("close".equals(paramString1)) {
        close(paramString2, paramCallbackContext);
      } else if ("setAppOptOut".equals(paramString1)) {
        setAppOptOut(paramString2, paramCallbackContext);
      } else if ("getAppOptOut".equals(paramString1)) {
        getAppOptOut(paramCallbackContext);
      } else {
        bool = false;
      }
    }
  }
  
  public void initialize(CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    super.initialize(paramCordovaInterface, paramCordovaWebView);
    ga = GoogleAnalytics.getInstance(paramCordovaInterface.getActivity());
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\cmackay\plugins\googleanalytics\GoogleAnalyticsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */