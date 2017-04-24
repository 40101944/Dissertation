package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public class zzn
{
  private static final Uri Ey = Uri.parse("http://plus.google.com/");
  private static final Uri Ez = Ey.buildUpon().appendPath("circles").appendPath("find").build();
  
  private static Uri zzab(String paramString1, @Nullable String paramString2)
  {
    paramString1 = Uri.parse("market://details").buildUpon().appendQueryParameter("id", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.appendQueryParameter("pcampaignid", paramString2);
    }
    return paramString1.build();
  }
  
  public static Intent zzac(String paramString1, @Nullable String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(zzab(paramString1, paramString2));
    localIntent.setPackage("com.android.vending");
    localIntent.addFlags(524288);
    return localIntent;
  }
  
  public static Intent zzawg()
  {
    Intent localIntent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
    localIntent.setPackage("com.google.android.wearable.app");
    return localIntent;
  }
  
  public static Intent zzhy(String paramString)
  {
    Uri localUri = Uri.fromParts("package", paramString, null);
    paramString = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    paramString.setData(localUri);
    return paramString;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */