package org.apache.cordova;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.engine.SystemWebViewEngine;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaWebViewImpl
  implements CordovaWebView
{
  public static final String TAG = "CordovaWebViewImpl";
  private CoreAndroid appPlugin;
  private Set<Integer> boundKeyCodes = new HashSet();
  private CordovaInterface cordova;
  protected final CordovaWebViewEngine engine;
  private EngineClient engineClient = new EngineClient();
  private boolean hasPausedEver;
  private int loadUrlTimeout = 0;
  String loadedUrl;
  private View mCustomView;
  private WebChromeClient.CustomViewCallback mCustomViewCallback;
  private NativeToJsMessageQueue nativeToJsMessageQueue;
  private PluginManager pluginManager;
  private CordovaPreferences preferences;
  private CordovaResourceApi resourceApi;
  
  static
  {
    if (!CordovaWebViewImpl.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public CordovaWebViewImpl(CordovaWebViewEngine paramCordovaWebViewEngine)
  {
    this.engine = paramCordovaWebViewEngine;
  }
  
  public static CordovaWebViewEngine createEngine(Context paramContext, CordovaPreferences paramCordovaPreferences)
  {
    String str = paramCordovaPreferences.getString("webview", SystemWebViewEngine.class.getCanonicalName());
    try
    {
      paramContext = (CordovaWebViewEngine)Class.forName(str).getConstructor(new Class[] { Context.class, CordovaPreferences.class }).newInstance(new Object[] { paramContext, paramCordovaPreferences });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new RuntimeException("Failed to create webview. ", paramContext);
    }
  }
  
  private void sendJavascriptEvent(String paramString)
  {
    if (this.appPlugin == null) {
      this.appPlugin = ((CoreAndroid)this.pluginManager.getPlugin("CoreAndroid"));
    }
    if (this.appPlugin == null) {
      LOG.w("CordovaWebViewImpl", "Unable to fire event without existing plugin");
    }
    for (;;)
    {
      return;
      this.appPlugin.fireJavascriptEvent(paramString);
    }
  }
  
  public boolean backHistory()
  {
    return this.engine.goBack();
  }
  
  public boolean canGoBack()
  {
    return this.engine.canGoBack();
  }
  
  public void clearCache()
  {
    this.engine.clearCache();
  }
  
  @Deprecated
  public void clearCache(boolean paramBoolean)
  {
    this.engine.clearCache();
  }
  
  public void clearHistory()
  {
    this.engine.clearHistory();
  }
  
  public Context getContext()
  {
    return this.engine.getView().getContext();
  }
  
  public ICordovaCookieManager getCookieManager()
  {
    return this.engine.getCookieManager();
  }
  
  public CordovaWebViewEngine getEngine()
  {
    return this.engine;
  }
  
  public PluginManager getPluginManager()
  {
    return this.pluginManager;
  }
  
  public CordovaPreferences getPreferences()
  {
    return this.preferences;
  }
  
  public CordovaResourceApi getResourceApi()
  {
    return this.resourceApi;
  }
  
  public String getUrl()
  {
    return this.engine.getUrl();
  }
  
  public View getView()
  {
    return this.engine.getView();
  }
  
  public void handleDestroy()
  {
    if (!isInitialized()) {}
    for (;;)
    {
      return;
      this.loadUrlTimeout += 1;
      this.pluginManager.onDestroy();
      loadUrl("about:blank");
      this.engine.destroy();
      hideCustomView();
    }
  }
  
  public void handlePause(boolean paramBoolean)
  {
    if (!isInitialized()) {}
    for (;;)
    {
      return;
      this.hasPausedEver = true;
      this.pluginManager.onPause(paramBoolean);
      sendJavascriptEvent("pause");
      if (!paramBoolean) {
        this.engine.setPaused(true);
      }
    }
  }
  
  public void handleResume(boolean paramBoolean)
  {
    if (!isInitialized()) {}
    for (;;)
    {
      return;
      this.engine.setPaused(false);
      this.pluginManager.onResume(paramBoolean);
      if (this.hasPausedEver) {
        sendJavascriptEvent("resume");
      }
    }
  }
  
  public void handleStart()
  {
    if (!isInitialized()) {}
    for (;;)
    {
      return;
      this.pluginManager.onStart();
    }
  }
  
  public void handleStop()
  {
    if (!isInitialized()) {}
    for (;;)
    {
      return;
      this.pluginManager.onStop();
    }
  }
  
  @Deprecated
  public void hideCustomView()
  {
    if (this.mCustomView == null) {}
    for (;;)
    {
      return;
      Log.d("CordovaWebViewImpl", "Hiding Custom View");
      this.mCustomView.setVisibility(8);
      ((ViewGroup)this.engine.getView().getParent()).removeView(this.mCustomView);
      this.mCustomView = null;
      this.mCustomViewCallback.onCustomViewHidden();
      this.engine.getView().setVisibility(0);
    }
  }
  
  public void init(CordovaInterface paramCordovaInterface)
  {
    init(paramCordovaInterface, new ArrayList(), new CordovaPreferences());
  }
  
  public void init(CordovaInterface paramCordovaInterface, List<PluginEntry> paramList, CordovaPreferences paramCordovaPreferences)
  {
    if (this.cordova != null) {
      throw new IllegalStateException();
    }
    this.cordova = paramCordovaInterface;
    this.preferences = paramCordovaPreferences;
    this.pluginManager = new PluginManager(this, this.cordova, paramList);
    this.resourceApi = new CordovaResourceApi(this.engine.getView().getContext(), this.pluginManager);
    this.nativeToJsMessageQueue = new NativeToJsMessageQueue();
    this.nativeToJsMessageQueue.addBridgeMode(new NativeToJsMessageQueue.NoOpBridgeMode());
    this.nativeToJsMessageQueue.addBridgeMode(new NativeToJsMessageQueue.LoadUrlBridgeMode(this.engine, paramCordovaInterface));
    if (paramCordovaPreferences.getBoolean("DisallowOverscroll", false)) {
      this.engine.getView().setOverScrollMode(2);
    }
    this.engine.init(this, paramCordovaInterface, this.engineClient, this.resourceApi, this.pluginManager, this.nativeToJsMessageQueue);
    assert ((this.engine.getView() instanceof CordovaWebViewEngine.EngineView));
    this.pluginManager.addService("CoreAndroid", "org.apache.cordova.CoreAndroid");
    this.pluginManager.init();
  }
  
  public boolean isButtonPlumbedToJs(int paramInt)
  {
    return this.boundKeyCodes.contains(Integer.valueOf(paramInt));
  }
  
  @Deprecated
  public boolean isCustomViewShowing()
  {
    if (this.mCustomView != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isInitialized()
  {
    if (this.cordova != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void loadUrl(String paramString)
  {
    loadUrlIntoView(paramString, true);
  }
  
  public void loadUrlIntoView(final String paramString, final boolean paramBoolean)
  {
    LOG.d("CordovaWebViewImpl", ">>> loadUrl(" + paramString + ")");
    if ((paramString.equals("about:blank")) || (paramString.startsWith("javascript:")))
    {
      this.engine.loadUrl(paramString, false);
      return;
    }
    if ((paramBoolean) || (this.loadedUrl == null)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean)
      {
        if (this.loadedUrl != null)
        {
          this.appPlugin = null;
          this.pluginManager.init();
        }
        this.loadedUrl = paramString;
      }
      final int i = this.loadUrlTimeout;
      final int j = this.preferences.getInteger("LoadUrlTimeoutValue", 20000);
      final Runnable local2 = new Runnable()
      {
        public void run()
        {
          CordovaWebViewImpl.this.stopLoading();
          LOG.e("CordovaWebViewImpl", "CordovaWebView: TIMEOUT ERROR!");
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("errorCode", -6);
            localJSONObject.put("description", "The connection to the server was unsuccessful.");
            localJSONObject.put("url", paramString);
            CordovaWebViewImpl.this.pluginManager.postMessage("onReceivedError", localJSONObject);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;) {}
          }
        }
      }
      {
        public void run()
        {
          for (;;)
          {
            try {}catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
              continue;
            }
            try
            {
              wait(j);
              if (CordovaWebViewImpl.this.loadUrlTimeout == i) {
                CordovaWebViewImpl.this.cordova.getActivity().runOnUiThread(this.val$loadError);
              }
              return;
            }
            finally {}
          }
        }
      };
      this.cordova.getActivity().runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (j > 0) {
            CordovaWebViewImpl.this.cordova.getThreadPool().execute(local2);
          }
          CordovaWebViewImpl.this.engine.loadUrl(paramString, paramBoolean);
        }
      });
      break;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (this.pluginManager != null) {
      this.pluginManager.onNewIntent(paramIntent);
    }
  }
  
  public Object postMessage(String paramString, Object paramObject)
  {
    return this.pluginManager.postMessage(paramString, paramObject);
  }
  
  @Deprecated
  public void sendJavascript(String paramString)
  {
    this.nativeToJsMessageQueue.addJavaScript(paramString);
  }
  
  public void sendPluginResult(PluginResult paramPluginResult, String paramString)
  {
    this.nativeToJsMessageQueue.addPluginResult(paramPluginResult, paramString);
  }
  
  public void setButtonPlumbedToJs(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unsupported keycode: " + paramInt);
    }
    if (paramBoolean) {
      this.boundKeyCodes.add(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      return;
      this.boundKeyCodes.remove(Integer.valueOf(paramInt));
    }
  }
  
  @Deprecated
  public void showCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    Log.d("CordovaWebViewImpl", "showing Custom View");
    if (this.mCustomView != null) {
      paramCustomViewCallback.onCustomViewHidden();
    }
    for (;;)
    {
      return;
      this.mCustomView = paramView;
      this.mCustomViewCallback = paramCustomViewCallback;
      paramCustomViewCallback = (ViewGroup)this.engine.getView().getParent();
      paramCustomViewCallback.addView(paramView, new FrameLayout.LayoutParams(-1, -1, 17));
      this.engine.getView().setVisibility(8);
      paramCustomViewCallback.setVisibility(0);
      paramCustomViewCallback.bringToFront();
    }
  }
  
  public void showWebPage(String paramString, boolean paramBoolean1, boolean paramBoolean2, Map<String, Object> paramMap)
  {
    LOG.d("CordovaWebViewImpl", "showWebPage(%s, %b, %b, HashMap)", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean2) {
      this.engine.clearHistory();
    }
    if (!paramBoolean1)
    {
      if (!this.pluginManager.shouldAllowNavigation(paramString)) {
        break label104;
      }
      loadUrlIntoView(paramString, true);
    }
    while (!this.pluginManager.shouldOpenExternalUrl(paramString).booleanValue())
    {
      LOG.w("CordovaWebViewImpl", "showWebPage: Refusing to send intent for URL since it is not in the <allow-intent> whitelist. URL=" + paramString);
      return;
      label104:
      LOG.w("CordovaWebViewImpl", "showWebPage: Refusing to load URL into webview since it is not in the <allow-navigation> whitelist. URL=" + paramString);
    }
    for (;;)
    {
      Intent localIntent;
      try
      {
        localIntent = new android/content/Intent;
        localIntent.<init>("android.intent.action.VIEW");
        localIntent.addCategory("android.intent.category.BROWSABLE");
        paramMap = Uri.parse(paramString);
        if (!"file".equals(paramMap.getScheme())) {
          break label240;
        }
        localIntent.setDataAndType(paramMap, this.resourceApi.getMimeType(paramMap));
        this.cordova.getActivity().startActivity(localIntent);
      }
      catch (ActivityNotFoundException paramMap)
      {
        LOG.e("CordovaWebViewImpl", "Error loading url " + paramString, paramMap);
      }
      break;
      label240:
      localIntent.setData(paramMap);
    }
  }
  
  public void stopLoading()
  {
    this.loadUrlTimeout += 1;
  }
  
  protected class EngineClient
    implements CordovaWebViewEngine.Client
  {
    protected EngineClient() {}
    
    public void clearLoadTimeoutTimer()
    {
      CordovaWebViewImpl.access$108(CordovaWebViewImpl.this);
    }
    
    public Boolean onDispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      int j = paramKeyEvent.getKeyCode();
      int i;
      if (j == 4)
      {
        i = 1;
        if (paramKeyEvent.getAction() != 0) {
          break label95;
        }
        if ((i == 0) || (CordovaWebViewImpl.this.mCustomView == null)) {
          break label45;
        }
        paramKeyEvent = Boolean.valueOf(true);
      }
      for (;;)
      {
        return paramKeyEvent;
        i = 0;
        break;
        label45:
        if (CordovaWebViewImpl.this.boundKeyCodes.contains(Integer.valueOf(j)))
        {
          paramKeyEvent = Boolean.valueOf(true);
        }
        else
        {
          if (i != 0)
          {
            paramKeyEvent = Boolean.valueOf(CordovaWebViewImpl.this.engine.canGoBack());
            continue;
            label95:
            if (paramKeyEvent.getAction() == 1)
            {
              if ((i != 0) && (CordovaWebViewImpl.this.mCustomView != null))
              {
                CordovaWebViewImpl.this.hideCustomView();
                paramKeyEvent = Boolean.valueOf(true);
                continue;
              }
              if (CordovaWebViewImpl.this.boundKeyCodes.contains(Integer.valueOf(j)))
              {
                paramKeyEvent = null;
                switch (j)
                {
                }
                for (;;)
                {
                  if (paramKeyEvent == null) {
                    break label277;
                  }
                  CordovaWebViewImpl.this.sendJavascriptEvent(paramKeyEvent);
                  paramKeyEvent = Boolean.valueOf(true);
                  break;
                  paramKeyEvent = "volumedownbutton";
                  continue;
                  paramKeyEvent = "volumeupbutton";
                  continue;
                  paramKeyEvent = "searchbutton";
                  continue;
                  paramKeyEvent = "menubutton";
                  continue;
                  paramKeyEvent = "backbutton";
                }
              }
              if (i != 0)
              {
                paramKeyEvent = Boolean.valueOf(CordovaWebViewImpl.this.engine.goBack());
                continue;
              }
            }
          }
          label277:
          paramKeyEvent = null;
        }
      }
    }
    
    public boolean onNavigationAttempt(String paramString)
    {
      boolean bool = true;
      if (CordovaWebViewImpl.this.pluginManager.onOverrideUrlLoading(paramString)) {}
      for (;;)
      {
        return bool;
        if (CordovaWebViewImpl.this.pluginManager.shouldAllowNavigation(paramString)) {
          bool = false;
        } else if (CordovaWebViewImpl.this.pluginManager.shouldOpenExternalUrl(paramString).booleanValue()) {
          CordovaWebViewImpl.this.showWebPage(paramString, true, false, null);
        } else {
          LOG.w("CordovaWebViewImpl", "Blocked (possibly sub-frame) navigation to non-allowed URL: " + paramString);
        }
      }
    }
    
    public void onPageFinishedLoading(String paramString)
    {
      LOG.d("CordovaWebViewImpl", "onPageFinished(" + paramString + ")");
      clearLoadTimeoutTimer();
      CordovaWebViewImpl.this.pluginManager.postMessage("onPageFinished", paramString);
      if (CordovaWebViewImpl.this.engine.getView().getVisibility() != 0) {
        new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              Thread.sleep(2000L);
              Activity localActivity = CordovaWebViewImpl.this.cordova.getActivity();
              Runnable local1 = new org/apache/cordova/CordovaWebViewImpl$EngineClient$1$1;
              local1.<init>(this);
              localActivity.runOnUiThread(local1);
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;) {}
            }
          }
        }).start();
      }
      if (paramString.equals("about:blank")) {
        CordovaWebViewImpl.this.pluginManager.postMessage("exit", null);
      }
    }
    
    public void onPageStarted(String paramString)
    {
      LOG.d("CordovaWebViewImpl", "onPageDidNavigate(" + paramString + ")");
      CordovaWebViewImpl.this.boundKeyCodes.clear();
      CordovaWebViewImpl.this.pluginManager.onReset();
      CordovaWebViewImpl.this.pluginManager.postMessage("onPageStarted", paramString);
    }
    
    public void onReceivedError(int paramInt, String paramString1, String paramString2)
    {
      clearLoadTimeoutTimer();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("errorCode", paramInt);
        localJSONObject.put("description", paramString1);
        localJSONObject.put("url", paramString2);
        CordovaWebViewImpl.this.pluginManager.postMessage("onReceivedError", localJSONObject);
        return;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\CordovaWebViewImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */