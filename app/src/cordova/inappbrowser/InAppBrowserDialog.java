package org.apache.cordova.inappbrowser;

import android.app.Dialog;
import android.content.Context;

public class InAppBrowserDialog
  extends Dialog
{
  Context context;
  InAppBrowser inAppBrowser = null;
  
  public InAppBrowserDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.context = paramContext;
  }
  
  public void onBackPressed()
  {
    if (this.inAppBrowser == null) {
      dismiss();
    }
    for (;;)
    {
      return;
      if ((this.inAppBrowser.hardwareBack()) && (this.inAppBrowser.canGoBack())) {
        this.inAppBrowser.goBack();
      } else {
        this.inAppBrowser.closeDialog();
      }
    }
  }
  
  public void setInAppBroswer(InAppBrowser paramInAppBrowser)
  {
    this.inAppBrowser = paramInAppBrowser;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\inappbrowser\InAppBrowserDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */