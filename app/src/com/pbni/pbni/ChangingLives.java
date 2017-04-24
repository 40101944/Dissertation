package com.pbni.pbni;

import android.os.Bundle;
import org.apache.cordova.CordovaActivity;

public class ChangingLives
  extends CordovaActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    loadUrl(this.launchUrl);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\sugarrushcreative\pbni\ChangingLives.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */