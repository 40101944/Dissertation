package de.appplant.cordova.plugin.notification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractClickActivity
  extends Activity
{
  public abstract Notification buildNotification(Builder paramBuilder);
  
  public void launchApp()
  {
    Context localContext = getApplicationContext();
    Object localObject = localContext.getPackageName();
    localObject = localContext.getPackageManager().getLaunchIntentForPackage((String)localObject);
    ((Intent)localObject).addFlags(537001984);
    localContext.startActivity((Intent)localObject);
  }
  
  public abstract void onClick(Notification paramNotification);
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject1 = getIntent().getExtras();
    paramBundle = getApplicationContext();
    try
    {
      Object localObject2 = ((Bundle)localObject1).getString("NOTIFICATION_OPTIONS");
      localObject1 = new org/json/JSONObject;
      ((JSONObject)localObject1).<init>((String)localObject2);
      localObject2 = new de/appplant/cordova/plugin/notification/Builder;
      ((Builder)localObject2).<init>(paramBundle, (JSONObject)localObject1);
      onClick(buildNotification((Builder)localObject2));
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    finish();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\AbstractClickActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */