package org.apache.cordova.dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.widget.EditText;
import android.widget.TextView;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Notification
  extends CordovaPlugin
{
  private static final String LOG_TAG = "Notification";
  public int confirmResult = -1;
  public ProgressDialog progressDialog = null;
  public ProgressDialog spinnerDialog = null;
  
  @SuppressLint({"NewApi"})
  private void changeTextDirection(AlertDialog.Builder paramBuilder)
  {
    int i = Build.VERSION.SDK_INT;
    paramBuilder.create();
    paramBuilder = paramBuilder.show();
    if (i >= 17) {
      ((TextView)paramBuilder.findViewById(16908299)).setTextDirection(5);
    }
  }
  
  @SuppressLint({"NewApi"})
  private AlertDialog.Builder createDialog(CordovaInterface paramCordovaInterface)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (paramCordovaInterface = new AlertDialog.Builder(paramCordovaInterface.getActivity(), 5);; paramCordovaInterface = new AlertDialog.Builder(paramCordovaInterface.getActivity())) {
      return paramCordovaInterface;
    }
  }
  
  @SuppressLint({"InlinedApi"})
  private ProgressDialog createProgressDialog(CordovaInterface paramCordovaInterface)
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (paramCordovaInterface = new ProgressDialog(paramCordovaInterface.getActivity(), 5);; paramCordovaInterface = new ProgressDialog(paramCordovaInterface.getActivity())) {
      return paramCordovaInterface;
    }
  }
  
  public void activityStart(String paramString1, String paramString2)
  {
    try
    {
      if (this.spinnerDialog != null)
      {
        this.spinnerDialog.dismiss();
        this.spinnerDialog = null;
      }
      CordovaInterface localCordovaInterface = this.cordova;
      Runnable local5 = new org/apache/cordova/dialogs/Notification$5;
      local5.<init>(this, this, localCordovaInterface, paramString1, paramString2);
      this.cordova.getActivity().runOnUiThread(local5);
      return;
    }
    finally {}
  }
  
  public void activityStop()
  {
    try
    {
      if (this.spinnerDialog != null)
      {
        this.spinnerDialog.dismiss();
        this.spinnerDialog = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void alert(String paramString1, String paramString2, String paramString3, CallbackContext paramCallbackContext)
  {
    try
    {
      CordovaInterface localCordovaInterface = this.cordova;
      Runnable local2 = new org/apache/cordova/dialogs/Notification$2;
      local2.<init>(this, localCordovaInterface, paramString1, paramString2, paramString3, paramCallbackContext);
      this.cordova.getActivity().runOnUiThread(local2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void beep(final long paramLong)
  {
    this.cordova.getThreadPool().execute(new Runnable()
    {
      public void run()
      {
        Uri localUri = RingtoneManager.getDefaultUri(2);
        Ringtone localRingtone = RingtoneManager.getRingtone(Notification.this.cordova.getActivity().getBaseContext(), localUri);
        if (localRingtone != null) {
          for (long l1 = 0L; l1 < paramLong; l1 += 1L)
          {
            localRingtone.play();
            long l2 = 5000L;
            while ((localRingtone.isPlaying()) && (l2 > 0L))
            {
              l2 -= 100L;
              try
              {
                Thread.sleep(100L);
              }
              catch (InterruptedException localInterruptedException)
              {
                Thread.currentThread().interrupt();
              }
            }
          }
        }
      }
    });
  }
  
  public void confirm(String paramString1, String paramString2, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
  {
    try
    {
      CordovaInterface localCordovaInterface = this.cordova;
      Runnable local3 = new org/apache/cordova/dialogs/Notification$3;
      local3.<init>(this, localCordovaInterface, paramString1, paramString2, paramJSONArray, paramCallbackContext);
      this.cordova.getActivity().runOnUiThread(local3);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException
  {
    boolean bool = false;
    if (this.cordova.getActivity().isFinishing())
    {
      bool = true;
      return bool;
    }
    if (paramString.equals("beep")) {
      beep(paramJSONArray.getLong(0));
    }
    for (;;)
    {
      paramCallbackContext.success();
      bool = true;
      break;
      if (paramString.equals("alert"))
      {
        alert(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getString(2), paramCallbackContext);
        bool = true;
        break;
      }
      if (paramString.equals("confirm"))
      {
        confirm(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getJSONArray(2), paramCallbackContext);
        bool = true;
        break;
      }
      if (paramString.equals("prompt"))
      {
        prompt(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getJSONArray(2), paramJSONArray.getString(3), paramCallbackContext);
        bool = true;
        break;
      }
      if (paramString.equals("activityStart"))
      {
        activityStart(paramJSONArray.getString(0), paramJSONArray.getString(1));
      }
      else if (paramString.equals("activityStop"))
      {
        activityStop();
      }
      else if (paramString.equals("progressStart"))
      {
        progressStart(paramJSONArray.getString(0), paramJSONArray.getString(1));
      }
      else if (paramString.equals("progressValue"))
      {
        progressValue(paramJSONArray.getInt(0));
      }
      else
      {
        if (!paramString.equals("progressStop")) {
          break;
        }
        progressStop();
      }
    }
  }
  
  public void progressStart(String paramString1, String paramString2)
  {
    try
    {
      if (this.progressDialog != null)
      {
        this.progressDialog.dismiss();
        this.progressDialog = null;
      }
      CordovaInterface localCordovaInterface = this.cordova;
      Runnable local6 = new org/apache/cordova/dialogs/Notification$6;
      local6.<init>(this, this, localCordovaInterface, paramString1, paramString2);
      this.cordova.getActivity().runOnUiThread(local6);
      return;
    }
    finally {}
  }
  
  public void progressStop()
  {
    try
    {
      if (this.progressDialog != null)
      {
        this.progressDialog.dismiss();
        this.progressDialog = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void progressValue(int paramInt)
  {
    try
    {
      if (this.progressDialog != null) {
        this.progressDialog.setProgress(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void prompt(String paramString1, String paramString2, JSONArray paramJSONArray, String paramString3, CallbackContext paramCallbackContext)
  {
    try
    {
      CordovaInterface localCordovaInterface = this.cordova;
      Runnable local4 = new org/apache/cordova/dialogs/Notification$4;
      local4.<init>(this, localCordovaInterface, paramString3, paramString1, paramString2, paramJSONArray, paramCallbackContext);
      this.cordova.getActivity().runOnUiThread(local4);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\dialogs\Notification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */