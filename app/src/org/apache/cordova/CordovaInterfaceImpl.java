package org.apache.cordova;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaInterfaceImpl
  implements CordovaInterface
{
  private static final String TAG = "CordovaInterfaceImpl";
  protected Activity activity;
  protected CordovaPlugin activityResultCallback;
  protected int activityResultRequestCode;
  protected boolean activityWasDestroyed = false;
  protected String initCallbackService;
  protected CallbackMap permissionResultCallbacks;
  protected PluginManager pluginManager;
  protected Bundle savedPluginState;
  protected ActivityResultHolder savedResult;
  protected ExecutorService threadPool;
  
  public CordovaInterfaceImpl(Activity paramActivity)
  {
    this(paramActivity, Executors.newCachedThreadPool());
  }
  
  public CordovaInterfaceImpl(Activity paramActivity, ExecutorService paramExecutorService)
  {
    this.activity = paramActivity;
    this.threadPool = paramExecutorService;
    this.permissionResultCallbacks = new CallbackMap();
  }
  
  public Activity getActivity()
  {
    return this.activity;
  }
  
  public ExecutorService getThreadPool()
  {
    return this.threadPool;
  }
  
  public boolean hasPermission(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23) {
      if (this.activity.checkSelfPermission(paramString) != 0) {
        break label27;
      }
    }
    label27:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    CordovaPlugin localCordovaPlugin = this.activityResultCallback;
    Object localObject = localCordovaPlugin;
    if (localCordovaPlugin == null)
    {
      localObject = localCordovaPlugin;
      if (this.initCallbackService != null)
      {
        this.savedResult = new ActivityResultHolder(paramInt1, paramInt2, paramIntent);
        localObject = localCordovaPlugin;
        if (this.pluginManager != null)
        {
          localCordovaPlugin = this.pluginManager.getPlugin(this.initCallbackService);
          localObject = localCordovaPlugin;
          if (localCordovaPlugin != null)
          {
            localCordovaPlugin.onRestoreStateForActivityResult(this.savedPluginState.getBundle(localCordovaPlugin.getServiceName()), new ResumeCallback(localCordovaPlugin.getServiceName(), this.pluginManager));
            localObject = localCordovaPlugin;
          }
        }
      }
    }
    this.activityResultCallback = null;
    boolean bool;
    if (localObject != null)
    {
      Log.d("CordovaInterfaceImpl", "Sending activity result to plugin");
      this.initCallbackService = null;
      this.savedResult = null;
      ((CordovaPlugin)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      bool = true;
      return bool;
    }
    localObject = new StringBuilder().append("Got an activity result, but no plugin was registered to receive it");
    if (this.savedResult != null) {}
    for (paramIntent = " yet!";; paramIntent = ".")
    {
      Log.w("CordovaInterfaceImpl", paramIntent);
      bool = false;
      break;
    }
  }
  
  public void onCordovaInit(PluginManager paramPluginManager)
  {
    this.pluginManager = paramPluginManager;
    if (this.savedResult != null)
    {
      onActivityResult(this.savedResult.requestCode, this.savedResult.resultCode, this.savedResult.intent);
      break label38;
    }
    for (;;)
    {
      label38:
      return;
      if (!this.activityWasDestroyed) {
        continue;
      }
      this.activityWasDestroyed = false;
      if (paramPluginManager == null) {
        break;
      }
      CoreAndroid localCoreAndroid = (CoreAndroid)paramPluginManager.getPlugin("CoreAndroid");
      if (localCoreAndroid == null) {
        break;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("action", "resume");
        localCoreAndroid.sendResumeEvent(new PluginResult(PluginResult.Status.OK, localJSONObject));
      }
      catch (JSONException paramPluginManager)
      {
        for (;;)
        {
          LOG.e("CordovaInterfaceImpl", "Failed to create event message", paramPluginManager);
        }
      }
    }
  }
  
  public Object onMessage(String paramString, Object paramObject)
  {
    if ("exit".equals(paramString)) {
      this.activity.finish();
    }
    return null;
  }
  
  public void onRequestPermissionResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    throws JSONException
  {
    Pair localPair = this.permissionResultCallbacks.getAndRemoveCallback(paramInt);
    if (localPair != null) {
      ((CordovaPlugin)localPair.first).onRequestPermissionResult(((Integer)localPair.second).intValue(), paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.activityResultCallback != null) {
      paramBundle.putString("callbackService", this.activityResultCallback.getServiceName());
    }
    if (this.pluginManager != null) {
      paramBundle.putBundle("plugin", this.pluginManager.onSaveInstanceState());
    }
  }
  
  public void requestPermission(CordovaPlugin paramCordovaPlugin, int paramInt, String paramString)
  {
    requestPermissions(paramCordovaPlugin, paramInt, new String[] { paramString });
  }
  
  public void requestPermissions(CordovaPlugin paramCordovaPlugin, int paramInt, String[] paramArrayOfString)
  {
    paramInt = this.permissionResultCallbacks.registerCallback(paramCordovaPlugin, paramInt);
    getActivity().requestPermissions(paramArrayOfString, paramInt);
  }
  
  public void restoreInstanceState(Bundle paramBundle)
  {
    this.initCallbackService = paramBundle.getString("callbackService");
    this.savedPluginState = paramBundle.getBundle("plugin");
    this.activityWasDestroyed = true;
  }
  
  public void setActivityResultCallback(CordovaPlugin paramCordovaPlugin)
  {
    if (this.activityResultCallback != null) {
      this.activityResultCallback.onActivityResult(this.activityResultRequestCode, 0, null);
    }
    this.activityResultCallback = paramCordovaPlugin;
  }
  
  public void setActivityResultRequestCode(int paramInt)
  {
    this.activityResultRequestCode = paramInt;
  }
  
  public void startActivityForResult(CordovaPlugin paramCordovaPlugin, Intent paramIntent, int paramInt)
  {
    setActivityResultCallback(paramCordovaPlugin);
    try
    {
      this.activity.startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (RuntimeException paramCordovaPlugin)
    {
      this.activityResultCallback = null;
      throw paramCordovaPlugin;
    }
  }
  
  private static class ActivityResultHolder
  {
    private Intent intent;
    private int requestCode;
    private int resultCode;
    
    public ActivityResultHolder(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.requestCode = paramInt1;
      this.resultCode = paramInt2;
      this.intent = paramIntent;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\CordovaInterfaceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */