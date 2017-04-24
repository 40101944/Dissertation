package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;

public final class zzg
{
  private static final SimpleArrayMap<String, String> DO = new SimpleArrayMap();
  
  public static String zzcb(Context paramContext)
  {
    String str = paramContext.getApplicationInfo().name;
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = paramContext.getPackageName();
    }
    try
    {
      paramContext = zzsz.zzco(paramContext).zzik(paramContext.getPackageName()).toString();
      localObject = paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    return (String)localObject;
  }
  
  @Nullable
  public static String zzg(Context paramContext, int paramInt)
  {
    Object localObject2 = null;
    Resources localResources = paramContext.getResources();
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
    default: 
      Log.e("GoogleApiAvailability", 33 + "Unexpected error code " + paramInt);
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (String)localObject1;
      localObject1 = localResources.getString(R.string.common_google_play_services_install_title);
      continue;
      localObject1 = localResources.getString(R.string.common_google_play_services_enable_title);
      continue;
      localObject1 = localResources.getString(R.string.common_google_play_services_update_title);
      continue;
      Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
      localObject1 = localObject2;
      continue;
      Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
      localObject1 = zzu(paramContext, "common_google_play_services_network_error_title");
      continue;
      Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
      localObject1 = localObject2;
      continue;
      Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
      localObject1 = localObject2;
      continue;
      Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
      localObject1 = zzu(paramContext, "common_google_play_services_invalid_account_title");
      continue;
      Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
      localObject1 = localObject2;
      continue;
      Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
      localObject1 = localObject2;
      continue;
      Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
      localObject1 = zzu(paramContext, "common_google_play_services_sign_in_failed_title");
      continue;
      Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
      localObject1 = zzu(paramContext, "common_google_play_services_restricted_profile_title");
    }
  }
  
  private static String zzg(Context paramContext, String paramString1, String paramString2)
  {
    Resources localResources = paramContext.getResources();
    paramString1 = zzu(paramContext, paramString1);
    paramContext = paramString1;
    if (paramString1 == null) {
      paramContext = localResources.getString(R.string.common_google_play_services_unknown_issue);
    }
    return String.format(localResources.getConfiguration().locale, paramContext, new Object[] { paramString2 });
  }
  
  @NonNull
  public static String zzh(Context paramContext, int paramInt)
  {
    if (paramInt == 6) {}
    for (String str1 = zzu(paramContext, "common_google_play_services_resolution_required_title");; str1 = zzg(paramContext, paramInt))
    {
      String str2 = str1;
      if (str1 == null) {
        str2 = paramContext.getResources().getString(R.string.common_google_play_services_notification_ticker);
      }
      return str2;
    }
  }
  
  @NonNull
  public static String zzi(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    String str = zzcb(paramContext);
    switch (paramInt)
    {
    case 4: 
    case 6: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
    default: 
      paramContext = localResources.getString(R.string.common_google_play_services_unknown_issue, new Object[] { str });
    }
    for (;;)
    {
      return paramContext;
      paramContext = localResources.getString(R.string.common_google_play_services_install_text, new Object[] { str });
      continue;
      paramContext = localResources.getString(R.string.common_google_play_services_enable_text, new Object[] { str });
      continue;
      paramContext = localResources.getString(R.string.common_google_play_services_updating_text, new Object[] { str });
      continue;
      if (zzi.zzci(paramContext))
      {
        paramContext = localResources.getString(R.string.common_google_play_services_wear_update_text);
      }
      else
      {
        paramContext = localResources.getString(R.string.common_google_play_services_update_text, new Object[] { str });
        continue;
        paramContext = localResources.getString(R.string.common_google_play_services_unsupported_text, new Object[] { str });
        continue;
        paramContext = zzg(paramContext, "common_google_play_services_network_error_text", str);
        continue;
        paramContext = zzg(paramContext, "common_google_play_services_invalid_account_text", str);
        continue;
        paramContext = zzg(paramContext, "common_google_play_services_api_unavailable_text", str);
        continue;
        paramContext = zzg(paramContext, "common_google_play_services_sign_in_failed_text", str);
        continue;
        paramContext = zzg(paramContext, "common_google_play_services_restricted_profile_text", str);
      }
    }
  }
  
  @NonNull
  public static String zzj(Context paramContext, int paramInt)
  {
    if (paramInt == 6) {}
    for (paramContext = zzg(paramContext, "common_google_play_services_resolution_required_text", zzcb(paramContext));; paramContext = zzi(paramContext, paramInt)) {
      return paramContext;
    }
  }
  
  @NonNull
  public static String zzk(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    switch (paramInt)
    {
    default: 
      paramContext = paramContext.getString(17039370);
    }
    for (;;)
    {
      return paramContext;
      paramContext = paramContext.getString(R.string.common_google_play_services_install_button);
      continue;
      paramContext = paramContext.getString(R.string.common_google_play_services_enable_button);
      continue;
      paramContext = paramContext.getString(R.string.common_google_play_services_update_button);
    }
  }
  
  @Nullable
  private static String zzu(Context paramContext, String paramString)
  {
    for (;;)
    {
      int i;
      synchronized (DO)
      {
        String str = (String)DO.get(paramString);
        if (str != null)
        {
          paramContext = str;
          return paramContext;
        }
        paramContext = GooglePlayServicesUtil.getRemoteResource(paramContext);
        if (paramContext == null)
        {
          paramContext = null;
          continue;
        }
        i = paramContext.getIdentifier(paramString, "string", "com.google.android.gms");
        if (i == 0)
        {
          paramContext = String.valueOf(paramString);
          if (paramContext.length() != 0)
          {
            paramContext = "Missing resource: ".concat(paramContext);
            Log.w("GoogleApiAvailability", paramContext);
            paramContext = null;
            continue;
          }
          paramContext = new String("Missing resource: ");
        }
      }
      paramContext = paramContext.getString(i);
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {}
        for (paramContext = "Got empty resource: ".concat(paramContext);; paramContext = new String("Got empty resource: "))
        {
          Log.w("GoogleApiAvailability", paramContext);
          paramContext = null;
          break;
        }
      }
      DO.put(paramString, paramContext);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */