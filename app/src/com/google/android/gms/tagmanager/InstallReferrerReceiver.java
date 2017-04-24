package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerReceiver
  extends CampaignTrackingReceiver
{
  protected void zzp(Context paramContext, String paramString)
  {
    zzbf.zzpl(paramString);
    zzbf.zzaf(paramContext, paramString);
  }
  
  protected Class<? extends CampaignTrackingService> zzyy()
  {
    return InstallReferrerService.class;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\InstallReferrerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */