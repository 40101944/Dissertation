package org.apache.cordova.statusbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Method;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONException;

public class StatusBar
  extends CordovaPlugin
{
  private static final String TAG = "StatusBar";
  
  private void setStatusBarBackgroundColor(String paramString)
  {
    Window localWindow;
    if ((Build.VERSION.SDK_INT >= 21) && (paramString != null) && (!paramString.isEmpty()))
    {
      localWindow = this.cordova.getActivity().getWindow();
      localWindow.clearFlags(67108864);
      localWindow.addFlags(Integer.MIN_VALUE);
    }
    try
    {
      localWindow.getClass().getDeclaredMethod("setStatusBarColor", new Class[] { Integer.TYPE }).invoke(localWindow, new Object[] { Integer.valueOf(Color.parseColor(paramString)) });
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        LOG.e("StatusBar", "Invalid hexString argument, use f.i. '#999999'");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        LOG.w("StatusBar", "Method window.setStatusBarColor not found for SDK level " + Build.VERSION.SDK_INT);
      }
    }
  }
  
  public boolean execute(String paramString, final CordovaArgs paramCordovaArgs, CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool1 = false;
    boolean bool2 = true;
    LOG.v("StatusBar", "Executing action: " + paramString);
    final Window localWindow = this.cordova.getActivity().getWindow();
    if ("_ready".equals(paramString))
    {
      if ((localWindow.getAttributes().flags & 0x400) == 0) {
        bool1 = true;
      }
      paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, bool1));
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ("show".equals(paramString))
      {
        this.cordova.getActivity().runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (Build.VERSION.SDK_INT >= 19)
            {
              int i = localWindow.getDecorView().getSystemUiVisibility();
              localWindow.getDecorView().setSystemUiVisibility(i & 0xFBFF & 0xFFFFFFFB);
            }
            localWindow.clearFlags(1024);
          }
        });
        bool1 = bool2;
      }
      else if ("hide".equals(paramString))
      {
        this.cordova.getActivity().runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (Build.VERSION.SDK_INT >= 19)
            {
              int i = localWindow.getDecorView().getSystemUiVisibility();
              localWindow.getDecorView().setSystemUiVisibility(i | 0x400 | 0x4);
            }
            localWindow.addFlags(1024);
          }
        });
        bool1 = bool2;
      }
      else if ("backgroundColorByHexString".equals(paramString))
      {
        this.cordova.getActivity().runOnUiThread(new Runnable()
        {
          public void run()
          {
            try
            {
              StatusBar.this.setStatusBarBackgroundColor(paramCordovaArgs.getString(0));
              return;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                LOG.e("StatusBar", "Invalid hexString argument, use f.i. '#777777'");
              }
            }
          }
        });
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public void initialize(final CordovaInterface paramCordovaInterface, CordovaWebView paramCordovaWebView)
  {
    LOG.v("StatusBar", "StatusBar: initialization");
    super.initialize(paramCordovaInterface, paramCordovaWebView);
    this.cordova.getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        paramCordovaInterface.getActivity().getWindow().clearFlags(2048);
        StatusBar.this.setStatusBarBackgroundColor(StatusBar.this.preferences.getString("StatusBarBackgroundColor", "#000000"));
      }
    });
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\statusbar\StatusBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */