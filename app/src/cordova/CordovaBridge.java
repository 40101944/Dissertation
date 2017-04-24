package org.apache.cordova;

import android.util.Log;
import java.security.SecureRandom;
import org.json.JSONArray;
import org.json.JSONException;

public class CordovaBridge
{
  private static final String LOG_TAG = "CordovaBridge";
  private volatile int expectedBridgeSecret = -1;
  private NativeToJsMessageQueue jsMessageQueue;
  private PluginManager pluginManager;
  
  public CordovaBridge(PluginManager paramPluginManager, NativeToJsMessageQueue paramNativeToJsMessageQueue)
  {
    this.pluginManager = paramPluginManager;
    this.jsMessageQueue = paramNativeToJsMessageQueue;
  }
  
  private boolean verifySecret(String paramString, int paramInt)
    throws IllegalAccessException
  {
    if (!this.jsMessageQueue.isBridgeEnabled()) {
      if (paramInt == -1) {
        Log.d("CordovaBridge", paramString + " call made before bridge was enabled.");
      }
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      Log.d("CordovaBridge", "Ignoring " + paramString + " from previous page load.");
      break;
      if ((this.expectedBridgeSecret < 0) || (paramInt != this.expectedBridgeSecret))
      {
        Log.e("CordovaBridge", "Bridge access attempt with wrong secret token, possibly from malicious code. Disabling exec() bridge!");
        clearBridgeSecret();
        throw new IllegalAccessException();
      }
    }
  }
  
  void clearBridgeSecret()
  {
    this.expectedBridgeSecret = -1;
  }
  
  int generateBridgeSecret()
  {
    this.expectedBridgeSecret = new SecureRandom().nextInt(Integer.MAX_VALUE);
    return this.expectedBridgeSecret;
  }
  
  public boolean isSecretEstablished()
  {
    if (this.expectedBridgeSecret != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String jsExec(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws JSONException, IllegalAccessException
  {
    if (!verifySecret("exec()", paramInt)) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      if (paramString4 == null)
      {
        paramString1 = "@Null arguments.";
        continue;
      }
      this.jsMessageQueue.setPaused(true);
      try
      {
        CordovaResourceApi.jsThread = Thread.currentThread();
        this.pluginManager.exec(paramString1, paramString2, paramString3, paramString4);
        paramString1 = this.jsMessageQueue.popAndEncode(false);
        this.jsMessageQueue.setPaused(false);
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = "";
        this.jsMessageQueue.setPaused(false);
      }
      finally
      {
        this.jsMessageQueue.setPaused(false);
      }
    }
  }
  
  public String jsRetrieveJsMessages(int paramInt, boolean paramBoolean)
    throws IllegalAccessException
  {
    if (!verifySecret("retrieveJsMessages()", paramInt)) {}
    for (String str = null;; str = this.jsMessageQueue.popAndEncode(paramBoolean)) {
      return str;
    }
  }
  
  public void jsSetNativeToJsBridgeMode(int paramInt1, int paramInt2)
    throws IllegalAccessException
  {
    if (!verifySecret("setNativeToJsBridgeMode()", paramInt1)) {}
    for (;;)
    {
      return;
      this.jsMessageQueue.setBridgeMode(paramInt2);
    }
  }
  
  public String promptOnJsPrompt(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 != null) && (paramString3.length() > 3) && (paramString3.startsWith("gap:"))) {}
    for (;;)
    {
      try
      {
        paramString1 = new org/json/JSONArray;
        paramString1.<init>(paramString3.substring(4));
        paramString2 = jsExec(paramString1.getInt(0), paramString1.getString(1), paramString1.getString(2), paramString1.getString(3), paramString2);
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = "";
        continue;
      }
      catch (IllegalAccessException paramString1)
      {
        paramString1.printStackTrace();
        continue;
      }
      return paramString1;
      if ((paramString3 != null) && (paramString3.startsWith("gap_bridge_mode:")))
      {
        try
        {
          jsSetNativeToJsBridgeMode(Integer.parseInt(paramString3.substring(16)), Integer.parseInt(paramString2));
          paramString1 = "";
        }
        catch (NumberFormatException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
        catch (IllegalAccessException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
      else
      {
        int i;
        if ((paramString3 != null) && (paramString3.startsWith("gap_poll:")))
        {
          i = Integer.parseInt(paramString3.substring(9));
          try
          {
            paramString2 = jsRetrieveJsMessages(i, "1".equals(paramString2));
            paramString1 = paramString2;
            if (paramString2 != null) {
              continue;
            }
            paramString1 = "";
          }
          catch (IllegalAccessException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = "";
          }
        }
        else if ((paramString3 != null) && (paramString3.startsWith("gap_init:")))
        {
          if (this.pluginManager.shouldAllowBridgeAccess(paramString1))
          {
            i = Integer.parseInt(paramString3.substring(9));
            this.jsMessageQueue.setBridgeMode(i);
            i = generateBridgeSecret();
            paramString1 = "" + i;
          }
          else
          {
            Log.e("CordovaBridge", "gap_init called from restricted origin: " + paramString1);
            paramString1 = "";
          }
        }
        else
        {
          paramString1 = null;
        }
      }
    }
  }
  
  public void reset()
  {
    this.jsMessageQueue.reset();
    clearBridgeSecret();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\CordovaBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */