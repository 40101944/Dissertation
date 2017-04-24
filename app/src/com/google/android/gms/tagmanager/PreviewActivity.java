package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class PreviewActivity
  extends Activity
{
  private void zzl(String paramString1, String paramString2, String paramString3)
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.setTitle(paramString1);
    localAlertDialog.setMessage(paramString2);
    localAlertDialog.setButton(-1, paramString3, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localAlertDialog.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      zzbo.zzdh("Preview activity");
      paramBundle = getIntent().getData();
      if (!TagManager.getInstance(this).zzv(paramBundle))
      {
        localObject = String.valueOf(paramBundle);
        paramBundle = new java/lang/StringBuilder;
        paramBundle.<init>(String.valueOf(localObject).length() + 73);
        paramBundle = "Cannot preview the app with the uri: " + (String)localObject + ". Launching current version instead.";
        zzbo.zzdi(paramBundle);
        zzl("Preview failure", paramBundle, "Continue");
      }
      Object localObject = getPackageManager().getLaunchIntentForPackage(getPackageName());
      if (localObject != null)
      {
        paramBundle = String.valueOf(getPackageName());
        if (paramBundle.length() != 0) {}
        for (paramBundle = "Invoke the launch activity for package name: ".concat(paramBundle);; paramBundle = new String("Invoke the launch activity for package name: "))
        {
          zzbo.zzdh(paramBundle);
          startActivity((Intent)localObject);
          return;
        }
        paramBundle = "Calling preview threw an exception: ".concat(paramBundle);
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle = String.valueOf(paramBundle.getMessage());
      if (paramBundle.length() == 0) {}
    }
    for (;;)
    {
      zzbo.e(paramBundle);
      break;
      paramBundle = String.valueOf(getPackageName());
      if (paramBundle.length() != 0) {}
      for (paramBundle = "No launch activity found for package name: ".concat(paramBundle);; paramBundle = new String("No launch activity found for package name: "))
      {
        zzbo.zzdh(paramBundle);
        break;
      }
      paramBundle = new String("Calling preview threw an exception: ");
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\PreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */