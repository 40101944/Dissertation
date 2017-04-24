package org.apache.cordova.inappbrowser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.io.File;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
public class InAppBrowser
  extends CordovaPlugin
{
  private static final String CLEAR_ALL_CACHE = "clearcache";
  private static final String CLEAR_SESSION_CACHE = "clearsessioncache";
  private static final String EXIT_EVENT = "exit";
  private static final String HARDWARE_BACK_BUTTON = "hardwareback";
  private static final String HIDDEN = "hidden";
  private static final String LOAD_ERROR_EVENT = "loaderror";
  private static final String LOAD_START_EVENT = "loadstart";
  private static final String LOAD_STOP_EVENT = "loadstop";
  private static final String LOCATION = "location";
  protected static final String LOG_TAG = "InAppBrowser";
  private static final String MEDIA_PLAYBACK_REQUIRES_USER_ACTION = "mediaPlaybackRequiresUserAction";
  private static final String NULL = "null";
  private static final String SELF = "_self";
  private static final String SHOULD_PAUSE = "shouldPauseOnSuspend";
  private static final String SYSTEM = "_system";
  private static final String ZOOM = "zoom";
  private CallbackContext callbackContext;
  private boolean clearAllCache = false;
  private boolean clearSessionCache = false;
  private InAppBrowserDialog dialog;
  private EditText edittext;
  private boolean hadwareBackButton = true;
  private WebView inAppWebView;
  private boolean mediaPlaybackRequiresUserGesture = false;
  private boolean openWindowHidden = false;
  private boolean shouldPauseInAppBrowser = false;
  private boolean showLocationBar = true;
  private boolean showZoomControls = true;
  
  private InAppBrowser getInAppBrowser()
  {
    return this;
  }
  
  private boolean getShowLocationBar()
  {
    return this.showLocationBar;
  }
  
  private void goForward()
  {
    if (this.inAppWebView.canGoForward()) {
      this.inAppWebView.goForward();
    }
  }
  
  private void injectDeferredObject(final String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString1);
      paramString1 = localJSONArray.toString();
      paramString1 = String.format(paramString2, new Object[] { paramString1.substring(1, paramString1.length() - 1) });
    }
    for (;;)
    {
      this.cordova.getActivity().runOnUiThread(new Runnable()
      {
        @SuppressLint({"NewApi"})
        public void run()
        {
          if (Build.VERSION.SDK_INT < 19) {
            InAppBrowser.this.inAppWebView.loadUrl("javascript:" + paramString1);
          }
          for (;;)
          {
            return;
            InAppBrowser.this.inAppWebView.evaluateJavascript(paramString1, null);
          }
        }
      });
      return;
    }
  }
  
  private void navigate(String paramString)
  {
    ((InputMethodManager)this.cordova.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.edittext.getWindowToken(), 0);
    if ((!paramString.startsWith("http")) && (!paramString.startsWith("file:"))) {
      this.inAppWebView.loadUrl("http://" + paramString);
    }
    for (;;)
    {
      this.inAppWebView.requestFocus();
      return;
      this.inAppWebView.loadUrl(paramString);
    }
  }
  
  private HashMap<String, Boolean> parseFeature(String paramString)
  {
    if (paramString.equals("null"))
    {
      paramString = null;
      return paramString;
    }
    HashMap localHashMap = new HashMap();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    do
    {
      paramString = localHashMap;
      if (!localStringTokenizer.hasMoreElements()) {
        break;
      }
      paramString = new StringTokenizer(localStringTokenizer.nextToken(), "=");
    } while (!paramString.hasMoreElements());
    String str = paramString.nextToken();
    if (paramString.nextToken().equals("no")) {}
    for (paramString = Boolean.FALSE;; paramString = Boolean.TRUE)
    {
      localHashMap.put(str, paramString);
      break;
    }
  }
  
  private void sendUpdate(JSONObject paramJSONObject, boolean paramBoolean)
  {
    sendUpdate(paramJSONObject, paramBoolean, PluginResult.Status.OK);
  }
  
  private void sendUpdate(JSONObject paramJSONObject, boolean paramBoolean, PluginResult.Status paramStatus)
  {
    if (this.callbackContext != null)
    {
      paramJSONObject = new PluginResult(paramStatus, paramJSONObject);
      paramJSONObject.setKeepCallback(paramBoolean);
      this.callbackContext.sendPluginResult(paramJSONObject);
      if (!paramBoolean) {
        this.callbackContext = null;
      }
    }
  }
  
  public boolean canGoBack()
  {
    return this.inAppWebView.canGoBack();
  }
  
  public void closeDialog()
  {
    this.cordova.getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Object localObject = InAppBrowser.this.inAppWebView;
        if (localObject == null) {}
        for (;;)
        {
          return;
          ((WebView)localObject).setWebViewClient(new WebViewClient()
          {
            public void onPageFinished(WebView paramAnonymous2WebView, String paramAnonymous2String)
            {
              if (InAppBrowser.this.dialog != null)
              {
                InAppBrowser.this.dialog.dismiss();
                InAppBrowser.access$002(InAppBrowser.this, null);
              }
            }
          });
          ((WebView)localObject).loadUrl("about:blank");
          try
          {
            localObject = new org/json/JSONObject;
            ((JSONObject)localObject).<init>();
            ((JSONObject)localObject).put("type", "exit");
            InAppBrowser.this.sendUpdate((JSONObject)localObject, false);
          }
          catch (JSONException localJSONException)
          {
            LOG.d("InAppBrowser", "Should never happen");
          }
        }
      }
    });
  }
  
  public boolean execute(final String paramString, final CordovaArgs paramCordovaArgs, final CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool = false;
    if (paramString.equals("open"))
    {
      this.callbackContext = paramCallbackContext;
      final String str2 = paramCordovaArgs.getString(0);
      String str1 = paramCordovaArgs.optString(1);
      if ((str1 != null) && (!str1.equals("")))
      {
        paramString = str1;
        if (!str1.equals("null")) {}
      }
      else
      {
        paramString = "_self";
      }
      paramCordovaArgs = parseFeature(paramCordovaArgs.optString(2));
      LOG.d("InAppBrowser", "target = " + paramString);
      this.cordova.getActivity().runOnUiThread(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: ldc 47
          //   2: astore_3
          //   3: ldc 49
          //   5: aload_0
          //   6: getfield 26	org/apache/cordova/inappbrowser/InAppBrowser$1:val$target	Ljava/lang/String;
          //   9: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   12: ifeq +434 -> 446
          //   15: ldc 57
          //   17: ldc 59
          //   19: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   22: aconst_null
          //   23: astore_2
          //   24: aload_0
          //   25: getfield 28	org/apache/cordova/inappbrowser/InAppBrowser$1:val$url	Ljava/lang/String;
          //   28: ldc 67
          //   30: invokevirtual 71	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   33: ifeq +8 -> 41
          //   36: iconst_1
          //   37: invokestatic 77	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
          //   40: astore_2
          //   41: aload_2
          //   42: astore_1
          //   43: aload_2
          //   44: ifnonnull +38 -> 82
          //   47: ldc 79
          //   49: ldc 81
          //   51: iconst_1
          //   52: anewarray 83	java/lang/Class
          //   55: dup
          //   56: iconst_0
          //   57: ldc 51
          //   59: aastore
          //   60: invokevirtual 87	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
          //   63: aconst_null
          //   64: iconst_1
          //   65: anewarray 4	java/lang/Object
          //   68: dup
          //   69: iconst_0
          //   70: aload_0
          //   71: getfield 28	org/apache/cordova/inappbrowser/InAppBrowser$1:val$url	Ljava/lang/String;
          //   74: aastore
          //   75: invokevirtual 93	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
          //   78: checkcast 73	java/lang/Boolean
          //   81: astore_1
          //   82: aload_1
          //   83: astore_2
          //   84: aload_1
          //   85: ifnonnull +77 -> 162
          //   88: aload_0
          //   89: getfield 24	org/apache/cordova/inappbrowser/InAppBrowser$1:this$0	Lorg/apache/cordova/inappbrowser/InAppBrowser;
          //   92: getfield 97	org/apache/cordova/inappbrowser/InAppBrowser:webView	Lorg/apache/cordova/CordovaWebView;
          //   95: invokevirtual 101	java/lang/Object:getClass	()Ljava/lang/Class;
          //   98: ldc 103
          //   100: iconst_0
          //   101: anewarray 83	java/lang/Class
          //   104: invokevirtual 87	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
          //   107: aload_0
          //   108: getfield 24	org/apache/cordova/inappbrowser/InAppBrowser$1:this$0	Lorg/apache/cordova/inappbrowser/InAppBrowser;
          //   111: getfield 97	org/apache/cordova/inappbrowser/InAppBrowser:webView	Lorg/apache/cordova/CordovaWebView;
          //   114: iconst_0
          //   115: anewarray 4	java/lang/Object
          //   118: invokevirtual 93	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
          //   121: checkcast 105	org/apache/cordova/PluginManager
          //   124: astore_2
          //   125: aload_2
          //   126: invokevirtual 101	java/lang/Object:getClass	()Ljava/lang/Class;
          //   129: ldc 107
          //   131: iconst_1
          //   132: anewarray 83	java/lang/Class
          //   135: dup
          //   136: iconst_0
          //   137: ldc 51
          //   139: aastore
          //   140: invokevirtual 87	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
          //   143: aload_2
          //   144: iconst_1
          //   145: anewarray 4	java/lang/Object
          //   148: dup
          //   149: iconst_0
          //   150: aload_0
          //   151: getfield 28	org/apache/cordova/inappbrowser/InAppBrowser$1:val$url	Ljava/lang/String;
          //   154: aastore
          //   155: invokevirtual 93	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
          //   158: checkcast 73	java/lang/Boolean
          //   161: astore_2
          //   162: getstatic 111	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
          //   165: aload_2
          //   166: invokevirtual 112	java/lang/Boolean:equals	(Ljava/lang/Object;)Z
          //   169: ifeq +144 -> 313
          //   172: ldc 57
          //   174: ldc 114
          //   176: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   179: aload_0
          //   180: getfield 24	org/apache/cordova/inappbrowser/InAppBrowser$1:this$0	Lorg/apache/cordova/inappbrowser/InAppBrowser;
          //   183: getfield 97	org/apache/cordova/inappbrowser/InAppBrowser:webView	Lorg/apache/cordova/CordovaWebView;
          //   186: aload_0
          //   187: getfield 28	org/apache/cordova/inappbrowser/InAppBrowser$1:val$url	Ljava/lang/String;
          //   190: invokeinterface 120 2 0
          //   195: aload_3
          //   196: astore_1
          //   197: new 122	org/apache/cordova/PluginResult
          //   200: dup
          //   201: getstatic 128	org/apache/cordova/PluginResult$Status:OK	Lorg/apache/cordova/PluginResult$Status;
          //   204: aload_1
          //   205: invokespecial 131	org/apache/cordova/PluginResult:<init>	(Lorg/apache/cordova/PluginResult$Status;Ljava/lang/String;)V
          //   208: astore_1
          //   209: aload_1
          //   210: iconst_1
          //   211: invokevirtual 135	org/apache/cordova/PluginResult:setKeepCallback	(Z)V
          //   214: aload_0
          //   215: getfield 32	org/apache/cordova/inappbrowser/InAppBrowser$1:val$callbackContext	Lorg/apache/cordova/CallbackContext;
          //   218: aload_1
          //   219: invokevirtual 141	org/apache/cordova/CallbackContext:sendPluginResult	(Lorg/apache/cordova/PluginResult;)V
          //   222: return
          //   223: astore_1
          //   224: ldc 57
          //   226: aload_1
          //   227: invokevirtual 145	java/lang/NoSuchMethodException:getLocalizedMessage	()Ljava/lang/String;
          //   230: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   233: aload_2
          //   234: astore_1
          //   235: goto -153 -> 82
          //   238: astore_1
          //   239: ldc 57
          //   241: aload_1
          //   242: invokevirtual 146	java/lang/IllegalAccessException:getLocalizedMessage	()Ljava/lang/String;
          //   245: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   248: aload_2
          //   249: astore_1
          //   250: goto -168 -> 82
          //   253: astore_1
          //   254: ldc 57
          //   256: aload_1
          //   257: invokevirtual 147	java/lang/reflect/InvocationTargetException:getLocalizedMessage	()Ljava/lang/String;
          //   260: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   263: aload_2
          //   264: astore_1
          //   265: goto -183 -> 82
          //   268: astore_2
          //   269: ldc 57
          //   271: aload_2
          //   272: invokevirtual 145	java/lang/NoSuchMethodException:getLocalizedMessage	()Ljava/lang/String;
          //   275: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   278: aload_1
          //   279: astore_2
          //   280: goto -118 -> 162
          //   283: astore_2
          //   284: ldc 57
          //   286: aload_2
          //   287: invokevirtual 146	java/lang/IllegalAccessException:getLocalizedMessage	()Ljava/lang/String;
          //   290: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   293: aload_1
          //   294: astore_2
          //   295: goto -133 -> 162
          //   298: astore_2
          //   299: ldc 57
          //   301: aload_2
          //   302: invokevirtual 147	java/lang/reflect/InvocationTargetException:getLocalizedMessage	()Ljava/lang/String;
          //   305: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   308: aload_1
          //   309: astore_2
          //   310: goto -148 -> 162
          //   313: aload_0
          //   314: getfield 28	org/apache/cordova/inappbrowser/InAppBrowser$1:val$url	Ljava/lang/String;
          //   317: ldc -107
          //   319: invokevirtual 71	java/lang/String:startsWith	(Ljava/lang/String;)Z
          //   322: ifeq +98 -> 420
          //   325: ldc 57
          //   327: ldc -105
          //   329: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   332: new 153	android/content/Intent
          //   335: astore_1
          //   336: aload_1
          //   337: ldc -101
          //   339: invokespecial 157	android/content/Intent:<init>	(Ljava/lang/String;)V
          //   342: aload_1
          //   343: aload_0
          //   344: getfield 28	org/apache/cordova/inappbrowser/InAppBrowser$1:val$url	Ljava/lang/String;
          //   347: invokestatic 163	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
          //   350: invokevirtual 167	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
          //   353: pop
          //   354: aload_0
          //   355: getfield 24	org/apache/cordova/inappbrowser/InAppBrowser$1:this$0	Lorg/apache/cordova/inappbrowser/InAppBrowser;
          //   358: getfield 171	org/apache/cordova/inappbrowser/InAppBrowser:cordova	Lorg/apache/cordova/CordovaInterface;
          //   361: invokeinterface 177 1 0
          //   366: aload_1
          //   367: invokevirtual 183	android/app/Activity:startActivity	(Landroid/content/Intent;)V
          //   370: aload_3
          //   371: astore_1
          //   372: goto -175 -> 197
          //   375: astore_1
          //   376: ldc 57
          //   378: new 185	java/lang/StringBuilder
          //   381: dup
          //   382: invokespecial 186	java/lang/StringBuilder:<init>	()V
          //   385: ldc -68
          //   387: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   390: aload_0
          //   391: getfield 28	org/apache/cordova/inappbrowser/InAppBrowser$1:val$url	Ljava/lang/String;
          //   394: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   397: ldc -62
          //   399: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   402: aload_1
          //   403: invokevirtual 197	android/content/ActivityNotFoundException:toString	()Ljava/lang/String;
          //   406: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   409: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   412: invokestatic 201	org/apache/cordova/LOG:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   415: aload_3
          //   416: astore_1
          //   417: goto -220 -> 197
          //   420: ldc 57
          //   422: ldc -53
          //   424: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   427: aload_0
          //   428: getfield 24	org/apache/cordova/inappbrowser/InAppBrowser$1:this$0	Lorg/apache/cordova/inappbrowser/InAppBrowser;
          //   431: aload_0
          //   432: getfield 28	org/apache/cordova/inappbrowser/InAppBrowser$1:val$url	Ljava/lang/String;
          //   435: aload_0
          //   436: getfield 30	org/apache/cordova/inappbrowser/InAppBrowser$1:val$features	Ljava/util/HashMap;
          //   439: invokevirtual 207	org/apache/cordova/inappbrowser/InAppBrowser:showWebPage	(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;
          //   442: astore_1
          //   443: goto -246 -> 197
          //   446: ldc -47
          //   448: aload_0
          //   449: getfield 26	org/apache/cordova/inappbrowser/InAppBrowser$1:val$target	Ljava/lang/String;
          //   452: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   455: ifeq +25 -> 480
          //   458: ldc 57
          //   460: ldc -45
          //   462: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   465: aload_0
          //   466: getfield 24	org/apache/cordova/inappbrowser/InAppBrowser$1:this$0	Lorg/apache/cordova/inappbrowser/InAppBrowser;
          //   469: aload_0
          //   470: getfield 28	org/apache/cordova/inappbrowser/InAppBrowser$1:val$url	Ljava/lang/String;
          //   473: invokevirtual 215	org/apache/cordova/inappbrowser/InAppBrowser:openExternal	(Ljava/lang/String;)Ljava/lang/String;
          //   476: astore_1
          //   477: goto -280 -> 197
          //   480: ldc 57
          //   482: ldc -39
          //   484: invokestatic 65	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
          //   487: aload_0
          //   488: getfield 24	org/apache/cordova/inappbrowser/InAppBrowser$1:this$0	Lorg/apache/cordova/inappbrowser/InAppBrowser;
          //   491: aload_0
          //   492: getfield 28	org/apache/cordova/inappbrowser/InAppBrowser$1:val$url	Ljava/lang/String;
          //   495: aload_0
          //   496: getfield 30	org/apache/cordova/inappbrowser/InAppBrowser$1:val$features	Ljava/util/HashMap;
          //   499: invokevirtual 207	org/apache/cordova/inappbrowser/InAppBrowser:showWebPage	(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;
          //   502: astore_1
          //   503: goto -306 -> 197
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	506	0	this	1
          //   42	177	1	localObject1	Object
          //   223	4	1	localNoSuchMethodException1	NoSuchMethodException
          //   234	1	1	localObject2	Object
          //   238	4	1	localIllegalAccessException1	IllegalAccessException
          //   249	1	1	localObject3	Object
          //   253	4	1	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
          //   264	108	1	localObject4	Object
          //   375	28	1	localActivityNotFoundException	ActivityNotFoundException
          //   416	87	1	str1	String
          //   23	241	2	localObject5	Object
          //   268	4	2	localNoSuchMethodException2	NoSuchMethodException
          //   279	1	2	localObject6	Object
          //   283	4	2	localIllegalAccessException2	IllegalAccessException
          //   294	1	2	localObject7	Object
          //   298	4	2	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
          //   309	1	2	localObject8	Object
          //   2	414	3	str2	String
          // Exception table:
          //   from	to	target	type
          //   47	82	223	java/lang/NoSuchMethodException
          //   47	82	238	java/lang/IllegalAccessException
          //   47	82	253	java/lang/reflect/InvocationTargetException
          //   88	162	268	java/lang/NoSuchMethodException
          //   88	162	283	java/lang/IllegalAccessException
          //   88	162	298	java/lang/reflect/InvocationTargetException
          //   325	370	375	android/content/ActivityNotFoundException
        }
      });
    }
    for (;;)
    {
      bool = true;
      do
      {
        return bool;
        if (paramString.equals("close"))
        {
          closeDialog();
          break;
        }
        if (paramString.equals("injectScriptCode"))
        {
          paramString = null;
          if (paramCordovaArgs.getBoolean(1)) {
            paramString = String.format("(function(){prompt(JSON.stringify([eval(%%s)]), 'gap-iab://%s')})()", new Object[] { paramCallbackContext.getCallbackId() });
          }
          injectDeferredObject(paramCordovaArgs.getString(0), paramString);
          break;
        }
        if (paramString.equals("injectScriptFile"))
        {
          if (paramCordovaArgs.getBoolean(1)) {}
          for (paramString = String.format("(function(d) { var c = d.createElement('script'); c.src = %%s; c.onload = function() { prompt('', 'gap-iab://%s'); }; d.body.appendChild(c); })(document)", new Object[] { paramCallbackContext.getCallbackId() });; paramString = "(function(d) { var c = d.createElement('script'); c.src = %s; d.body.appendChild(c); })(document)")
          {
            injectDeferredObject(paramCordovaArgs.getString(0), paramString);
            break;
          }
        }
        if (paramString.equals("injectStyleCode"))
        {
          if (paramCordovaArgs.getBoolean(1)) {}
          for (paramString = String.format("(function(d) { var c = d.createElement('style'); c.innerHTML = %%s; d.body.appendChild(c); prompt('', 'gap-iab://%s');})(document)", new Object[] { paramCallbackContext.getCallbackId() });; paramString = "(function(d) { var c = d.createElement('style'); c.innerHTML = %s; d.body.appendChild(c); })(document)")
          {
            injectDeferredObject(paramCordovaArgs.getString(0), paramString);
            break;
          }
        }
        if (paramString.equals("injectStyleFile"))
        {
          if (paramCordovaArgs.getBoolean(1)) {}
          for (paramString = String.format("(function(d) { var c = d.createElement('link'); c.rel='stylesheet'; c.type='text/css'; c.href = %%s; d.head.appendChild(c); prompt('', 'gap-iab://%s');})(document)", new Object[] { paramCallbackContext.getCallbackId() });; paramString = "(function(d) { var c = d.createElement('link'); c.rel='stylesheet'; c.type='text/css'; c.href = %s; d.head.appendChild(c); })(document)")
          {
            injectDeferredObject(paramCordovaArgs.getString(0), paramString);
            break;
          }
        }
      } while (!paramString.equals("show"));
      this.cordova.getActivity().runOnUiThread(new Runnable()
      {
        public void run()
        {
          InAppBrowser.this.dialog.show();
        }
      });
      paramString = new PluginResult(PluginResult.Status.OK);
      paramString.setKeepCallback(true);
      this.callbackContext.sendPluginResult(paramString);
    }
  }
  
  public void goBack()
  {
    if (this.inAppWebView.canGoBack()) {
      this.inAppWebView.goBack();
    }
  }
  
  public boolean hardwareBack()
  {
    return this.hadwareBackButton;
  }
  
  public void onDestroy()
  {
    closeDialog();
  }
  
  public void onPause(boolean paramBoolean)
  {
    if (this.shouldPauseInAppBrowser) {
      this.inAppWebView.onPause();
    }
  }
  
  public void onReset()
  {
    closeDialog();
  }
  
  public void onResume(boolean paramBoolean)
  {
    if (this.shouldPauseInAppBrowser) {
      this.inAppWebView.onResume();
    }
  }
  
  public String openExternal(String paramString)
  {
    for (;;)
    {
      try
      {
        Intent localIntent = new android/content/Intent;
        localIntent.<init>("android.intent.action.VIEW");
        try
        {
          Uri localUri = Uri.parse(paramString);
          if ("file".equals(localUri.getScheme()))
          {
            localIntent.setDataAndType(localUri, this.webView.getResourceApi().getMimeType(localUri));
            localIntent.putExtra("com.android.browser.application_id", this.cordova.getActivity().getPackageName());
            this.cordova.getActivity().startActivity(localIntent);
            paramString = "";
            return paramString;
          }
          localIntent.setData(localUri);
          continue;
          LOG.d("InAppBrowser", "InAppBrowser: Error loading url " + paramString + ":" + localActivityNotFoundException1.toString());
        }
        catch (ActivityNotFoundException localActivityNotFoundException1) {}
      }
      catch (ActivityNotFoundException localActivityNotFoundException2)
      {
        continue;
      }
      paramString = localActivityNotFoundException1.toString();
    }
  }
  
  public String showWebPage(final String paramString, HashMap<String, Boolean> paramHashMap)
  {
    this.showLocationBar = true;
    this.showZoomControls = true;
    this.openWindowHidden = false;
    this.mediaPlaybackRequiresUserGesture = false;
    Boolean localBoolean;
    if (paramHashMap != null)
    {
      localBoolean = (Boolean)paramHashMap.get("location");
      if (localBoolean != null) {
        this.showLocationBar = localBoolean.booleanValue();
      }
      localBoolean = (Boolean)paramHashMap.get("zoom");
      if (localBoolean != null) {
        this.showZoomControls = localBoolean.booleanValue();
      }
      localBoolean = (Boolean)paramHashMap.get("hidden");
      if (localBoolean != null) {
        this.openWindowHidden = localBoolean.booleanValue();
      }
      localBoolean = (Boolean)paramHashMap.get("hardwareback");
      if (localBoolean != null) {
        this.hadwareBackButton = localBoolean.booleanValue();
      }
      localBoolean = (Boolean)paramHashMap.get("mediaPlaybackRequiresUserAction");
      if (localBoolean != null) {
        this.mediaPlaybackRequiresUserGesture = localBoolean.booleanValue();
      }
      localBoolean = (Boolean)paramHashMap.get("clearcache");
      if (localBoolean == null) {
        break label209;
      }
      this.clearAllCache = localBoolean.booleanValue();
    }
    for (;;)
    {
      paramHashMap = (Boolean)paramHashMap.get("shouldPauseOnSuspend");
      if (paramHashMap != null) {
        this.shouldPauseInAppBrowser = paramHashMap.booleanValue();
      }
      paramString = new Runnable()
      {
        private int dpToPixels(int paramAnonymousInt)
        {
          return (int)TypedValue.applyDimension(1, paramAnonymousInt, InAppBrowser.this.cordova.getActivity().getResources().getDisplayMetrics());
        }
        
        @SuppressLint({"NewApi"})
        public void run()
        {
          if (InAppBrowser.this.dialog != null) {
            InAppBrowser.this.dialog.dismiss();
          }
          InAppBrowser.access$002(InAppBrowser.this, new InAppBrowserDialog(InAppBrowser.this.cordova.getActivity(), 16973830));
          InAppBrowser.this.dialog.getWindow().getAttributes().windowAnimations = 16973826;
          InAppBrowser.this.dialog.requestWindowFeature(1);
          InAppBrowser.this.dialog.setCancelable(true);
          InAppBrowser.this.dialog.setInAppBroswer(InAppBrowser.this.getInAppBrowser());
          LinearLayout localLinearLayout = new LinearLayout(InAppBrowser.this.cordova.getActivity());
          localLinearLayout.setOrientation(1);
          RelativeLayout localRelativeLayout = new RelativeLayout(InAppBrowser.this.cordova.getActivity());
          localRelativeLayout.setBackgroundColor(-3355444);
          localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, dpToPixels(44)));
          localRelativeLayout.setPadding(dpToPixels(2), dpToPixels(2), dpToPixels(2), dpToPixels(2));
          localRelativeLayout.setHorizontalGravity(3);
          localRelativeLayout.setVerticalGravity(48);
          Object localObject1 = new RelativeLayout(InAppBrowser.this.cordova.getActivity());
          ((RelativeLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          ((RelativeLayout)localObject1).setHorizontalGravity(3);
          ((RelativeLayout)localObject1).setVerticalGravity(16);
          ((RelativeLayout)localObject1).setId(Integer.valueOf(1).intValue());
          ImageButton localImageButton = new ImageButton(InAppBrowser.this.cordova.getActivity());
          Object localObject2 = new RelativeLayout.LayoutParams(-2, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(5);
          localImageButton.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localImageButton.setContentDescription("Back Button");
          localImageButton.setId(Integer.valueOf(2).intValue());
          Object localObject4 = InAppBrowser.this.cordova.getActivity().getResources();
          localObject2 = ((Resources)localObject4).getDrawable(((Resources)localObject4).getIdentifier("ic_action_previous_item", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
          Object localObject3;
          label573:
          Object localObject5;
          label905:
          boolean bool;
          if (Build.VERSION.SDK_INT >= 16)
          {
            localImageButton.setBackground(null);
            localImageButton.setImageDrawable((Drawable)localObject2);
            localImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            localImageButton.setPadding(0, dpToPixels(10), 0, dpToPixels(10));
            if (Build.VERSION.SDK_INT >= 16) {
              localImageButton.getAdjustViewBounds();
            }
            localImageButton.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                InAppBrowser.this.goBack();
              }
            });
            localObject2 = new ImageButton(InAppBrowser.this.cordova.getActivity());
            localObject3 = new RelativeLayout.LayoutParams(-2, -1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2);
            ((ImageButton)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            ((ImageButton)localObject2).setContentDescription("Forward Button");
            ((ImageButton)localObject2).setId(Integer.valueOf(3).intValue());
            localObject3 = ((Resources)localObject4).getDrawable(((Resources)localObject4).getIdentifier("ic_action_next_item", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
            if (Build.VERSION.SDK_INT < 16) {
              break label1564;
            }
            ((ImageButton)localObject2).setBackground(null);
            ((ImageButton)localObject2).setImageDrawable((Drawable)localObject3);
            ((ImageButton)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
            ((ImageButton)localObject2).setPadding(0, dpToPixels(10), 0, dpToPixels(10));
            if (Build.VERSION.SDK_INT >= 16) {
              ((ImageButton)localObject2).getAdjustViewBounds();
            }
            ((ImageButton)localObject2).setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                InAppBrowser.this.goForward();
              }
            });
            InAppBrowser.access$502(InAppBrowser.this, new EditText(InAppBrowser.this.cordova.getActivity()));
            localObject3 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(1, 1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(0, 5);
            InAppBrowser.this.edittext.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            InAppBrowser.this.edittext.setId(Integer.valueOf(4).intValue());
            InAppBrowser.this.edittext.setSingleLine(true);
            InAppBrowser.this.edittext.setText(paramString);
            InAppBrowser.this.edittext.setInputType(16);
            InAppBrowser.this.edittext.setImeOptions(2);
            InAppBrowser.this.edittext.setInputType(0);
            InAppBrowser.this.edittext.setOnKeyListener(new View.OnKeyListener()
            {
              public boolean onKey(View paramAnonymous2View, int paramAnonymous2Int, KeyEvent paramAnonymous2KeyEvent)
              {
                if ((paramAnonymous2KeyEvent.getAction() == 0) && (paramAnonymous2Int == 66)) {
                  InAppBrowser.this.navigate(InAppBrowser.this.edittext.getText().toString());
                }
                for (boolean bool = true;; bool = false) {
                  return bool;
                }
              }
            });
            localObject3 = new ImageButton(InAppBrowser.this.cordova.getActivity());
            localObject5 = new RelativeLayout.LayoutParams(-2, -1);
            ((RelativeLayout.LayoutParams)localObject5).addRule(11);
            ((ImageButton)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject5);
            ((ImageButton)localObject2).setContentDescription("Close Button");
            ((ImageButton)localObject3).setId(Integer.valueOf(5).intValue());
            localObject4 = ((Resources)localObject4).getDrawable(((Resources)localObject4).getIdentifier("ic_action_remove", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
            if (Build.VERSION.SDK_INT < 16) {
              break label1573;
            }
            ((ImageButton)localObject3).setBackground(null);
            ((ImageButton)localObject3).setImageDrawable((Drawable)localObject4);
            ((ImageButton)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
            localImageButton.setPadding(0, dpToPixels(10), 0, dpToPixels(10));
            if (Build.VERSION.SDK_INT >= 16) {
              ((ImageButton)localObject3).getAdjustViewBounds();
            }
            ((ImageButton)localObject3).setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                InAppBrowser.this.closeDialog();
              }
            });
            InAppBrowser.access$102(InAppBrowser.this, new WebView(InAppBrowser.this.cordova.getActivity()));
            InAppBrowser.this.inAppWebView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            InAppBrowser.this.inAppWebView.setId(Integer.valueOf(6).intValue());
            InAppBrowser.this.inAppWebView.setWebChromeClient(new InAppChromeClient(this.val$thatWebView));
            localObject4 = new InAppBrowser.InAppBrowserClient(InAppBrowser.this, this.val$thatWebView, InAppBrowser.this.edittext);
            InAppBrowser.this.inAppWebView.setWebViewClient((WebViewClient)localObject4);
            localObject4 = InAppBrowser.this.inAppWebView.getSettings();
            ((WebSettings)localObject4).setJavaScriptEnabled(true);
            ((WebSettings)localObject4).setJavaScriptCanOpenWindowsAutomatically(true);
            ((WebSettings)localObject4).setBuiltInZoomControls(InAppBrowser.this.showZoomControls);
            ((WebSettings)localObject4).setPluginState(WebSettings.PluginState.ON);
            if (Build.VERSION.SDK_INT >= 17) {
              ((WebSettings)localObject4).setMediaPlaybackRequiresUserGesture(InAppBrowser.this.mediaPlaybackRequiresUserGesture);
            }
            String str = InAppBrowser.this.preferences.getString("OverrideUserAgent", null);
            localObject5 = InAppBrowser.this.preferences.getString("AppendUserAgent", null);
            if (str != null) {
              ((WebSettings)localObject4).setUserAgentString(str);
            }
            if (localObject5 != null) {
              ((WebSettings)localObject4).setUserAgentString(((WebSettings)localObject4).getUserAgentString() + (String)localObject5);
            }
            localObject5 = InAppBrowser.this.cordova.getActivity().getIntent().getExtras();
            if (localObject5 != null) {
              break label1582;
            }
            bool = true;
            label1255:
            if (bool)
            {
              ((WebSettings)localObject4).setDatabasePath(InAppBrowser.this.cordova.getActivity().getApplicationContext().getDir("inAppBrowserDB", 0).getPath());
              ((WebSettings)localObject4).setDatabaseEnabled(true);
            }
            ((WebSettings)localObject4).setDomStorageEnabled(true);
            if (!InAppBrowser.this.clearAllCache) {
              break label1595;
            }
            CookieManager.getInstance().removeAllCookie();
          }
          for (;;)
          {
            InAppBrowser.this.inAppWebView.loadUrl(paramString);
            InAppBrowser.this.inAppWebView.setId(Integer.valueOf(6).intValue());
            InAppBrowser.this.inAppWebView.getSettings().setLoadWithOverviewMode(true);
            InAppBrowser.this.inAppWebView.getSettings().setUseWideViewPort(true);
            InAppBrowser.this.inAppWebView.requestFocus();
            InAppBrowser.this.inAppWebView.requestFocusFromTouch();
            ((RelativeLayout)localObject1).addView(localImageButton);
            ((RelativeLayout)localObject1).addView((View)localObject2);
            localRelativeLayout.addView((View)localObject1);
            localRelativeLayout.addView(InAppBrowser.this.edittext);
            localRelativeLayout.addView((View)localObject3);
            if (InAppBrowser.this.getShowLocationBar()) {
              localLinearLayout.addView(localRelativeLayout);
            }
            localLinearLayout.addView(InAppBrowser.this.inAppWebView);
            localObject1 = new WindowManager.LayoutParams();
            ((WindowManager.LayoutParams)localObject1).copyFrom(InAppBrowser.this.dialog.getWindow().getAttributes());
            ((WindowManager.LayoutParams)localObject1).width = -1;
            ((WindowManager.LayoutParams)localObject1).height = -1;
            InAppBrowser.this.dialog.setContentView(localLinearLayout);
            InAppBrowser.this.dialog.show();
            InAppBrowser.this.dialog.getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
            if (InAppBrowser.this.openWindowHidden) {
              InAppBrowser.this.dialog.hide();
            }
            return;
            localImageButton.setBackgroundDrawable(null);
            break;
            label1564:
            ((ImageButton)localObject2).setBackgroundDrawable(null);
            break label573;
            label1573:
            ((ImageButton)localObject3).setBackgroundDrawable(null);
            break label905;
            label1582:
            bool = ((Bundle)localObject5).getBoolean("InAppBrowserStorageEnabled", true);
            break label1255;
            label1595:
            if (InAppBrowser.this.clearSessionCache) {
              CookieManager.getInstance().removeSessionCookie();
            }
          }
        }
      };
      this.cordova.getActivity().runOnUiThread(paramString);
      return "";
      label209:
      localBoolean = (Boolean)paramHashMap.get("clearsessioncache");
      if (localBoolean != null) {
        this.clearSessionCache = localBoolean.booleanValue();
      }
    }
  }
  
  public class InAppBrowserClient
    extends WebViewClient
  {
    EditText edittext;
    CordovaWebView webView;
    
    public InAppBrowserClient(CordovaWebView paramCordovaWebView, EditText paramEditText)
    {
      this.webView = paramCordovaWebView;
      this.edittext = paramEditText;
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (Build.VERSION.SDK_INT >= 21) {
        CookieManager.getInstance().flush();
      }
      try
      {
        for (;;)
        {
          paramWebView = new org/json/JSONObject;
          paramWebView.<init>();
          paramWebView.put("type", "loadstop");
          paramWebView.put("url", paramString);
          InAppBrowser.this.sendUpdate(paramWebView, true);
          return;
          CookieSyncManager.getInstance().sync();
        }
      }
      catch (JSONException paramWebView)
      {
        for (;;)
        {
          LOG.d("InAppBrowser", "Should never happen");
        }
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if ((paramString.startsWith("http:")) || (paramString.startsWith("https:")) || (paramString.startsWith("file:"))) {
        paramWebView = paramString;
      }
      for (;;)
      {
        if (!paramWebView.equals(this.edittext.getText().toString())) {
          this.edittext.setText(paramWebView);
        }
        try
        {
          paramString = new org/json/JSONObject;
          paramString.<init>();
          paramString.put("type", "loadstart");
          paramString.put("url", paramWebView);
          InAppBrowser.this.sendUpdate(paramString, true);
          return;
          LOG.e("InAppBrowser", "Possible Uncaught/Unknown URI");
          paramWebView = "http://" + paramString;
        }
        catch (JSONException paramWebView)
        {
          for (;;)
          {
            LOG.e("InAppBrowser", "URI passed in has caused a JSON error.");
          }
        }
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      try
      {
        paramWebView = new org/json/JSONObject;
        paramWebView.<init>();
        paramWebView.put("type", "loaderror");
        paramWebView.put("url", paramString2);
        paramWebView.put("code", paramInt);
        paramWebView.put("message", paramString1);
        InAppBrowser.this.sendUpdate(paramWebView, true, PluginResult.Status.ERROR);
        return;
      }
      catch (JSONException paramWebView)
      {
        for (;;)
        {
          LOG.d("InAppBrowser", "Should never happen");
        }
      }
    }
    
    /* Error */
    public void onReceivedHttpAuthRequest(WebView paramWebView, android.webkit.HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aload_0
      //   4: getfield 22	org/apache/cordova/inappbrowser/InAppBrowser$InAppBrowserClient:webView	Lorg/apache/cordova/CordovaWebView;
      //   7: invokevirtual 173	java/lang/Object:getClass	()Ljava/lang/Class;
      //   10: ldc -81
      //   12: iconst_0
      //   13: anewarray 177	java/lang/Class
      //   16: invokevirtual 181	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   19: aload_0
      //   20: getfield 22	org/apache/cordova/inappbrowser/InAppBrowser$InAppBrowserClient:webView	Lorg/apache/cordova/CordovaWebView;
      //   23: iconst_0
      //   24: anewarray 105	java/lang/Object
      //   27: invokevirtual 187	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   30: checkcast 189	org/apache/cordova/PluginManager
      //   33: astore 6
      //   35: aload 6
      //   37: astore 5
      //   39: aload 5
      //   41: astore 6
      //   43: aload 5
      //   45: ifnonnull +27 -> 72
      //   48: aload_0
      //   49: getfield 22	org/apache/cordova/inappbrowser/InAppBrowser$InAppBrowserClient:webView	Lorg/apache/cordova/CordovaWebView;
      //   52: invokevirtual 173	java/lang/Object:getClass	()Ljava/lang/Class;
      //   55: ldc -65
      //   57: invokevirtual 195	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   60: aload_0
      //   61: getfield 22	org/apache/cordova/inappbrowser/InAppBrowser$InAppBrowserClient:webView	Lorg/apache/cordova/CordovaWebView;
      //   64: invokevirtual 201	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   67: checkcast 189	org/apache/cordova/PluginManager
      //   70: astore 6
      //   72: aload 6
      //   74: ifnull +110 -> 184
      //   77: aload 6
      //   79: aload_0
      //   80: getfield 22	org/apache/cordova/inappbrowser/InAppBrowser$InAppBrowserClient:webView	Lorg/apache/cordova/CordovaWebView;
      //   83: new 203	org/apache/cordova/CordovaHttpAuthHandler
      //   86: dup
      //   87: aload_2
      //   88: invokespecial 206	org/apache/cordova/CordovaHttpAuthHandler:<init>	(Landroid/webkit/HttpAuthHandler;)V
      //   91: aload_3
      //   92: aload 4
      //   94: invokevirtual 209	org/apache/cordova/PluginManager:onReceivedHttpAuthRequest	(Lorg/apache/cordova/CordovaWebView;Lorg/apache/cordova/ICordovaHttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)Z
      //   97: ifeq +87 -> 184
      //   100: return
      //   101: astore 6
      //   103: ldc 73
      //   105: aload 6
      //   107: invokevirtual 212	java/lang/NoSuchMethodException:getLocalizedMessage	()Ljava/lang/String;
      //   110: invokestatic 81	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   113: goto -74 -> 39
      //   116: astore 6
      //   118: ldc 73
      //   120: aload 6
      //   122: invokevirtual 213	java/lang/IllegalAccessException:getLocalizedMessage	()Ljava/lang/String;
      //   125: invokestatic 81	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   128: goto -89 -> 39
      //   131: astore 6
      //   133: ldc 73
      //   135: aload 6
      //   137: invokevirtual 214	java/lang/reflect/InvocationTargetException:getLocalizedMessage	()Ljava/lang/String;
      //   140: invokestatic 81	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   143: goto -104 -> 39
      //   146: astore 6
      //   148: ldc 73
      //   150: aload 6
      //   152: invokevirtual 215	java/lang/NoSuchFieldException:getLocalizedMessage	()Ljava/lang/String;
      //   155: invokestatic 81	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   158: aload 5
      //   160: astore 6
      //   162: goto -90 -> 72
      //   165: astore 6
      //   167: ldc 73
      //   169: aload 6
      //   171: invokevirtual 213	java/lang/IllegalAccessException:getLocalizedMessage	()Ljava/lang/String;
      //   174: invokestatic 81	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   177: aload 5
      //   179: astore 6
      //   181: goto -109 -> 72
      //   184: aload_0
      //   185: aload_1
      //   186: aload_2
      //   187: aload_3
      //   188: aload 4
      //   190: invokespecial 217	android/webkit/WebViewClient:onReceivedHttpAuthRequest	(Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V
      //   193: goto -93 -> 100
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	196	0	this	InAppBrowserClient
      //   0	196	1	paramWebView	WebView
      //   0	196	2	paramHttpAuthHandler	android.webkit.HttpAuthHandler
      //   0	196	3	paramString1	String
      //   0	196	4	paramString2	String
      //   1	177	5	localObject1	Object
      //   33	45	6	localObject2	Object
      //   101	5	6	localNoSuchMethodException	NoSuchMethodException
      //   116	5	6	localIllegalAccessException1	IllegalAccessException
      //   131	5	6	localInvocationTargetException	java.lang.reflect.InvocationTargetException
      //   146	5	6	localNoSuchFieldException	NoSuchFieldException
      //   160	1	6	localObject3	Object
      //   165	5	6	localIllegalAccessException2	IllegalAccessException
      //   179	1	6	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   3	35	101	java/lang/NoSuchMethodException
      //   3	35	116	java/lang/IllegalAccessException
      //   3	35	131	java/lang/reflect/InvocationTargetException
      //   48	72	146	java/lang/NoSuchFieldException
      //   48	72	165	java/lang/IllegalAccessException
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      boolean bool = true;
      if (paramString.startsWith("tel:")) {
        try
        {
          paramWebView = new android/content/Intent;
          paramWebView.<init>("android.intent.action.DIAL");
          paramWebView.setData(Uri.parse(paramString));
          InAppBrowser.this.cordova.getActivity().startActivity(paramWebView);
          return bool;
        }
        catch (ActivityNotFoundException paramWebView)
        {
          LOG.e("InAppBrowser", "Error dialing " + paramString + ": " + paramWebView.toString());
        }
      }
      label89:
      label216:
      do
      {
        for (;;)
        {
          bool = false;
          break;
          if ((!paramString.startsWith("geo:")) && (!paramString.startsWith("mailto:")) && (!paramString.startsWith("market:")) && (!paramString.startsWith("intent:"))) {
            break label216;
          }
          try
          {
            paramWebView = new android/content/Intent;
            paramWebView.<init>("android.intent.action.VIEW");
            paramWebView.setData(Uri.parse(paramString));
            InAppBrowser.this.cordova.getActivity().startActivity(paramWebView);
          }
          catch (ActivityNotFoundException paramWebView)
          {
            LOG.e("InAppBrowser", "Error with " + paramString + ": " + paramWebView.toString());
          }
        }
      } while (!paramString.startsWith("sms:"));
      for (;;)
      {
        Intent localIntent;
        int i;
        try
        {
          localIntent = new android/content/Intent;
          localIntent.<init>("android.intent.action.VIEW");
          i = paramString.indexOf('?');
          if (i != -1) {
            break label372;
          }
          paramWebView = paramString.substring(4);
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          localIntent.setData(Uri.parse("sms:" + paramWebView));
          localIntent.putExtra("address", paramWebView);
          localIntent.setType("vnd.android-dir/mms-sms");
          InAppBrowser.this.cordova.getActivity().startActivity(localIntent);
        }
        catch (ActivityNotFoundException paramWebView)
        {
          LOG.e("InAppBrowser", "Error sending sms " + paramString + ":" + paramWebView.toString());
        }
        break label89;
        label372:
        Object localObject = paramString.substring(4, i);
        String str = Uri.parse(paramString).getQuery();
        paramWebView = (WebView)localObject;
        if (str != null)
        {
          paramWebView = (WebView)localObject;
          if (str.startsWith("body="))
          {
            localIntent.putExtra("sms_body", str.substring(5));
            paramWebView = (WebView)localObject;
          }
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\inappbrowser\InAppBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */