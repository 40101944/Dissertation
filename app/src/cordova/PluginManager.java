package org.apache.cordova;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;

public class PluginManager
{
  private static final int SLOW_EXEC_WARNING_THRESHOLD;
  private static String TAG = "PluginManager";
  private final CordovaWebView app;
  private final CordovaInterface ctx;
  private final LinkedHashMap<String, PluginEntry> entryMap = new LinkedHashMap();
  private boolean isInitialized;
  private CordovaPlugin permissionRequester;
  private final LinkedHashMap<String, CordovaPlugin> pluginMap = new LinkedHashMap();
  
  static
  {
    if (Debug.isDebuggerConnected()) {}
    for (int i = 60;; i = 16)
    {
      SLOW_EXEC_WARNING_THRESHOLD = i;
      return;
    }
  }
  
  public PluginManager(CordovaWebView paramCordovaWebView, CordovaInterface paramCordovaInterface, Collection<PluginEntry> paramCollection)
  {
    this.ctx = paramCordovaInterface;
    this.app = paramCordovaWebView;
    setPluginEntries(paramCollection);
  }
  
  private CordovaPlugin instantiatePlugin(String paramString)
  {
    localObject3 = null;
    localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (!"".equals(paramString)) {
          localObject1 = Class.forName(paramString);
        }
        if (localObject1 == null) {
          continue;
        }
        i = 1;
        localObject2 = localObject3;
        if ((i & CordovaPlugin.class.isAssignableFrom((Class)localObject1)) != 0) {
          localObject2 = (CordovaPlugin)((Class)localObject1).newInstance();
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        System.out.println("Error adding plugin " + paramString + ".");
        localObject2 = localObject3;
        continue;
      }
      return (CordovaPlugin)localObject2;
      i = 0;
    }
  }
  
  private void startupPlugins()
  {
    Iterator localIterator = this.entryMap.values().iterator();
    while (localIterator.hasNext())
    {
      PluginEntry localPluginEntry = (PluginEntry)localIterator.next();
      if (localPluginEntry.onload) {
        getPlugin(localPluginEntry.service);
      } else {
        this.pluginMap.put(localPluginEntry.service, null);
      }
    }
  }
  
  public void addService(String paramString1, String paramString2)
  {
    addService(new PluginEntry(paramString1, paramString2, false));
  }
  
  public void addService(PluginEntry paramPluginEntry)
  {
    this.entryMap.put(paramPluginEntry.service, paramPluginEntry);
    if (paramPluginEntry.plugin != null)
    {
      paramPluginEntry.plugin.privateInitialize(paramPluginEntry.service, this.ctx, this.app, this.app.getPreferences());
      this.pluginMap.put(paramPluginEntry.service, paramPluginEntry.plugin);
    }
  }
  
  public void exec(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = getPlugin(paramString1);
    if (localObject == null)
    {
      Log.d(TAG, "exec() call to unknown plugin: " + paramString1);
      paramString1 = new PluginResult(PluginResult.Status.CLASS_NOT_FOUND_EXCEPTION);
      this.app.sendPluginResult(paramString1, paramString3);
    }
    for (;;)
    {
      return;
      paramString3 = new CallbackContext(paramString3, this.app);
      try
      {
        long l = System.currentTimeMillis();
        boolean bool = ((CordovaPlugin)localObject).execute(paramString2, paramString4, paramString3);
        l = System.currentTimeMillis() - l;
        if (l > SLOW_EXEC_WARNING_THRESHOLD)
        {
          localObject = TAG;
          paramString4 = new java/lang/StringBuilder;
          paramString4.<init>();
          Log.w((String)localObject, "THREAD WARNING: exec() call to " + paramString1 + "." + paramString2 + " blocked the main thread for " + l + "ms. Plugin should use CordovaInterface.getThreadPool().");
        }
        if (!bool)
        {
          paramString1 = new org/apache/cordova/PluginResult;
          paramString1.<init>(PluginResult.Status.INVALID_ACTION);
          paramString3.sendPluginResult(paramString1);
        }
      }
      catch (JSONException paramString1)
      {
        paramString3.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
      }
      catch (Exception paramString1)
      {
        Log.e(TAG, "Uncaught exception from plugin", paramString1);
        paramString3.error(paramString1.getMessage());
      }
    }
  }
  
  public CordovaPlugin getPlugin(String paramString)
  {
    CordovaPlugin localCordovaPlugin = (CordovaPlugin)this.pluginMap.get(paramString);
    Object localObject = localCordovaPlugin;
    if (localCordovaPlugin == null)
    {
      localObject = (PluginEntry)this.entryMap.get(paramString);
      if (localObject == null)
      {
        paramString = null;
        return paramString;
      }
      if (((PluginEntry)localObject).plugin == null) {
        break label87;
      }
    }
    label87:
    for (localObject = ((PluginEntry)localObject).plugin;; localObject = instantiatePlugin(((PluginEntry)localObject).pluginClass))
    {
      ((CordovaPlugin)localObject).privateInitialize(paramString, this.ctx, this.app, this.app.getPreferences());
      this.pluginMap.put(paramString, localObject);
      paramString = (String)localObject;
      break;
    }
  }
  
  public Collection<PluginEntry> getPluginEntries()
  {
    return this.entryMap.values();
  }
  
  public void init()
  {
    LOG.d(TAG, "init()");
    this.isInitialized = true;
    onPause(false);
    onDestroy();
    this.pluginMap.clear();
    startupPlugins();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    while (localIterator.hasNext())
    {
      CordovaPlugin localCordovaPlugin = (CordovaPlugin)localIterator.next();
      if (localCordovaPlugin != null) {
        localCordovaPlugin.onConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    while (localIterator.hasNext())
    {
      CordovaPlugin localCordovaPlugin = (CordovaPlugin)localIterator.next();
      if (localCordovaPlugin != null) {
        localCordovaPlugin.onDestroy();
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    while (localIterator.hasNext())
    {
      CordovaPlugin localCordovaPlugin = (CordovaPlugin)localIterator.next();
      if (localCordovaPlugin != null) {
        localCordovaPlugin.onNewIntent(paramIntent);
      }
    }
  }
  
  public boolean onOverrideUrlLoading(String paramString)
  {
    Iterator localIterator = this.entryMap.values().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (PluginEntry)localIterator.next();
      localObject = (CordovaPlugin)this.pluginMap.get(((PluginEntry)localObject).service);
    } while ((localObject == null) || (!((CordovaPlugin)localObject).onOverrideUrlLoading(paramString)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onPause(boolean paramBoolean)
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    while (localIterator.hasNext())
    {
      CordovaPlugin localCordovaPlugin = (CordovaPlugin)localIterator.next();
      if (localCordovaPlugin != null) {
        localCordovaPlugin.onPause(paramBoolean);
      }
    }
  }
  
  public boolean onReceivedClientCertRequest(CordovaWebView paramCordovaWebView, ICordovaClientCertRequest paramICordovaClientCertRequest)
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramCordovaWebView = (CordovaPlugin)localIterator.next();
    } while ((paramCordovaWebView == null) || (!paramCordovaWebView.onReceivedClientCertRequest(this.app, paramICordovaClientCertRequest)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean onReceivedHttpAuthRequest(CordovaWebView paramCordovaWebView, ICordovaHttpAuthHandler paramICordovaHttpAuthHandler, String paramString1, String paramString2)
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramCordovaWebView = (CordovaPlugin)localIterator.next();
    } while ((paramCordovaWebView == null) || (!paramCordovaWebView.onReceivedHttpAuthRequest(this.app, paramICordovaHttpAuthHandler, paramString1, paramString2)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void onReset()
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    while (localIterator.hasNext())
    {
      CordovaPlugin localCordovaPlugin = (CordovaPlugin)localIterator.next();
      if (localCordovaPlugin != null) {
        localCordovaPlugin.onReset();
      }
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    while (localIterator.hasNext())
    {
      CordovaPlugin localCordovaPlugin = (CordovaPlugin)localIterator.next();
      if (localCordovaPlugin != null) {
        localCordovaPlugin.onResume(paramBoolean);
      }
    }
  }
  
  public Bundle onSaveInstanceState()
  {
    Bundle localBundle2 = new Bundle();
    Iterator localIterator = this.pluginMap.values().iterator();
    while (localIterator.hasNext())
    {
      CordovaPlugin localCordovaPlugin = (CordovaPlugin)localIterator.next();
      if (localCordovaPlugin != null)
      {
        Bundle localBundle1 = localCordovaPlugin.onSaveInstanceState();
        if (localBundle1 != null) {
          localBundle2.putBundle(localCordovaPlugin.getServiceName(), localBundle1);
        }
      }
    }
    return localBundle2;
  }
  
  public void onStart()
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    while (localIterator.hasNext())
    {
      CordovaPlugin localCordovaPlugin = (CordovaPlugin)localIterator.next();
      if (localCordovaPlugin != null) {
        localCordovaPlugin.onStart();
      }
    }
  }
  
  public void onStop()
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    while (localIterator.hasNext())
    {
      CordovaPlugin localCordovaPlugin = (CordovaPlugin)localIterator.next();
      if (localCordovaPlugin != null) {
        localCordovaPlugin.onStop();
      }
    }
  }
  
  public Object postMessage(String paramString, Object paramObject)
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    Object localObject;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (CordovaPlugin)localIterator.next();
      } while (localObject == null);
      localObject = ((CordovaPlugin)localObject).onMessage(paramString, paramObject);
    } while (localObject == null);
    for (paramString = (String)localObject;; paramString = this.ctx.onMessage(paramString, paramObject)) {
      return paramString;
    }
  }
  
  Uri remapUri(Uri paramUri)
  {
    Iterator localIterator = this.pluginMap.values().iterator();
    Object localObject;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (CordovaPlugin)localIterator.next();
      } while (localObject == null);
      localObject = ((CordovaPlugin)localObject).remapUri(paramUri);
    } while (localObject == null);
    for (paramUri = (Uri)localObject;; paramUri = null) {
      return paramUri;
    }
  }
  
  public void setPluginEntries(Collection<PluginEntry> paramCollection)
  {
    if (this.isInitialized)
    {
      onPause(false);
      onDestroy();
      this.pluginMap.clear();
      this.entryMap.clear();
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      addService((PluginEntry)paramCollection.next());
    }
    if (this.isInitialized) {
      startupPlugins();
    }
  }
  
  public boolean shouldAllowBridgeAccess(String paramString)
  {
    Iterator localIterator = this.entryMap.values().iterator();
    Object localObject;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PluginEntry)localIterator.next();
        localObject = (CordovaPlugin)this.pluginMap.get(((PluginEntry)localObject).service);
      } while (localObject == null);
      localObject = ((CordovaPlugin)localObject).shouldAllowBridgeAccess(paramString);
    } while (localObject == null);
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = paramString.startsWith("file://")) {
      return bool;
    }
  }
  
  public boolean shouldAllowNavigation(String paramString)
  {
    Iterator localIterator = this.entryMap.values().iterator();
    boolean bool;
    while (localIterator.hasNext())
    {
      Object localObject = (PluginEntry)localIterator.next();
      localObject = (CordovaPlugin)this.pluginMap.get(((PluginEntry)localObject).service);
      if (localObject != null)
      {
        localObject = ((CordovaPlugin)localObject).shouldAllowNavigation(paramString);
        if (localObject != null) {
          bool = ((Boolean)localObject).booleanValue();
        }
      }
    }
    for (;;)
    {
      return bool;
      if ((paramString.startsWith("file://")) || (paramString.startsWith("about:blank"))) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public boolean shouldAllowRequest(String paramString)
  {
    boolean bool2 = true;
    Iterator localIterator = this.entryMap.values().iterator();
    boolean bool1;
    while (localIterator.hasNext())
    {
      Object localObject = (PluginEntry)localIterator.next();
      localObject = (CordovaPlugin)this.pluginMap.get(((PluginEntry)localObject).service);
      if (localObject != null)
      {
        localObject = ((CordovaPlugin)localObject).shouldAllowRequest(paramString);
        if (localObject != null) {
          bool1 = ((Boolean)localObject).booleanValue();
        }
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (!paramString.startsWith("blob:"))
      {
        bool1 = bool2;
        if (!paramString.startsWith("data:"))
        {
          bool1 = bool2;
          if (!paramString.startsWith("about:blank"))
          {
            bool1 = bool2;
            if (!paramString.startsWith("https://ssl.gstatic.com/accessibility/javascript/android/")) {
              if (paramString.startsWith("file://"))
              {
                bool1 = bool2;
                if (paramString.contains("/app_webview/")) {
                  bool1 = false;
                }
              }
              else
              {
                bool1 = false;
              }
            }
          }
        }
      }
    }
  }
  
  public Boolean shouldOpenExternalUrl(String paramString)
  {
    Iterator localIterator = this.entryMap.values().iterator();
    Object localObject;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (PluginEntry)localIterator.next();
        localObject = (CordovaPlugin)this.pluginMap.get(((PluginEntry)localObject).service);
      } while (localObject == null);
      localObject = ((CordovaPlugin)localObject).shouldOpenExternalUrl(paramString);
    } while (localObject == null);
    for (paramString = (String)localObject;; paramString = Boolean.valueOf(false)) {
      return paramString;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\PluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */