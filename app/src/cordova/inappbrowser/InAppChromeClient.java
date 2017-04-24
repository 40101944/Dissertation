package org.apache.cordova.inappbrowser;

import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;

public class InAppChromeClient
  extends WebChromeClient
{
  private String LOG_TAG = "InAppChromeClient";
  private long MAX_QUOTA = 104857600L;
  private CordovaWebView webView;
  
  public InAppChromeClient(CordovaWebView paramCordovaWebView)
  {
    this.webView = paramCordovaWebView;
  }
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    LOG.d(this.LOG_TAG, "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(paramLong3) });
    paramQuotaUpdater.updateQuota(this.MAX_QUOTA);
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    paramCallback.invoke(paramString, true, false);
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    boolean bool = true;
    if ((paramString3 != null) && (paramString3.startsWith("gap"))) {
      if (paramString3.startsWith("gap-iab://"))
      {
        paramString1 = paramString3.substring(10);
        if (!paramString1.startsWith("InAppBrowser")) {
          break label189;
        }
        if ((paramString2 == null) || (paramString2.length() == 0))
        {
          paramWebView = new PluginResult(PluginResult.Status.OK, new JSONArray());
          this.webView.sendPluginResult(paramWebView, paramString1);
          paramJsPromptResult.confirm("");
        }
      }
    }
    for (;;)
    {
      return bool;
      try
      {
        paramWebView = new org/apache/cordova/PluginResult;
        PluginResult.Status localStatus = PluginResult.Status.OK;
        paramString3 = new org/json/JSONArray;
        paramString3.<init>(paramString2);
        paramWebView.<init>(localStatus, paramString3);
      }
      catch (JSONException paramWebView)
      {
        paramWebView = new PluginResult(PluginResult.Status.JSON_EXCEPTION, paramWebView.getMessage());
      }
      break;
      LOG.w(this.LOG_TAG, "InAppBrowser does not support Cordova API calls: " + paramString1 + " " + paramString3);
      paramJsPromptResult.cancel();
      continue;
      label189:
      bool = false;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\inappbrowser\InAppChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */