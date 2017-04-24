package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzl;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzx;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class zze
{
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = ;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  public static boolean xb = false;
  public static boolean xc = false;
  static boolean xd = false;
  private static boolean xe = false;
  static final AtomicBoolean xf = new AtomicBoolean();
  private static final AtomicBoolean xg = new AtomicBoolean();
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return zzc.zzaql().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.getStatusString(paramInt);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    Object localObject = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build();
    for (;;)
    {
      try
      {
        localInputStream = paramContext.getContentResolver().openInputStream((Uri)localObject);
      }
      catch (Exception paramContext)
      {
        InputStream localInputStream;
        paramContext = null;
        continue;
      }
      try
      {
        paramContext = new java/util/Scanner;
        paramContext.<init>(localInputStream);
        localObject = paramContext.useDelimiter("\\A").next();
        paramContext = (Context)localObject;
        if (localInputStream != null)
        {
          localInputStream.close();
          paramContext = (Context)localObject;
        }
      }
      catch (NoSuchElementException paramContext)
      {
        paramContext = paramContext;
        if (localInputStream == null) {
          continue;
        }
        localInputStream.close();
        paramContext = null;
      }
      finally
      {
        paramContext = finally;
        if (localInputStream == null) {
          continue;
        }
        localInputStream.close();
        throw paramContext;
      }
    }
    return paramContext;
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    j = 9;
    localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
      if (!"com.google.android.gms".equals(paramContext.getPackageName())) {
        zzbp(paramContext);
      }
      Object localObject;
      if (!zzi.zzci(paramContext))
      {
        i = 1;
        localObject = null;
        if (i == 0) {}
      }
      try
      {
        localObject = localPackageManager.getPackageInfo("com.android.vending", 8256);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          label105:
          Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
          i = j;
        }
      }
      try
      {
        localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
        paramContext = zzf.zzbv(paramContext);
        if (i == 0) {
          break label182;
        }
        localObject = paramContext.zza((PackageInfo)localObject, zzd.zzd.xa);
        if (localObject != null) {
          break label152;
        }
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        i = j;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
        i = 1;
        break label105;
        if (paramContext.zza(localPackageInfo, new zzd.zza[] { localThrowable }) != null) {
          break label207;
        }
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        i = j;
        break label105;
        if (paramContext.zza(localPackageInfo, zzd.zzd.xa) != null) {
          break label207;
        }
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        i = j;
        break label105;
        i = zzl.zzhh(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        if (zzl.zzhh(localPackageInfo.versionCode) >= i) {
          break label278;
        }
        i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        j = localPackageInfo.versionCode;
        Log.w("GooglePlayServicesUtil", 77 + "Google Play services out of date.  Requires " + i + " but found " + j);
        i = 2;
        break label105;
        ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
        paramContext = localApplicationInfo;
        if (localApplicationInfo != null) {
          break label299;
        }
        try
        {
          paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
          if (paramContext.enabled) {
            break label327;
          }
          i = 3;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", paramContext);
          i = 1;
        }
        break label105;
        i = 0;
        break label105;
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        continue;
        i = 0;
      }
    }
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private static int zzaqq()
  {
    return 9877000;
  }
  
  @Deprecated
  public static boolean zzaqr()
  {
    return zzi.zzaym();
  }
  
  @Deprecated
  public static void zzaz(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = zzc.zzaql().isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      paramContext = zzc.zzaql().zzb(paramContext, i, "e");
      Log.e("GooglePlayServicesUtil", 57 + "GooglePlayServices not available due to error " + i);
      if (paramContext == null) {
        throw new GooglePlayServicesNotAvailableException(i);
      }
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", paramContext);
    }
  }
  
  @Deprecated
  public static int zzbk(Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      i = paramContext.versionCode;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
      }
    }
    return i;
  }
  
  @Deprecated
  public static void zzbn(Context paramContext)
  {
    if (xf.getAndSet(true)) {}
    for (;;)
    {
      return;
      try
      {
        paramContext = (NotificationManager)paramContext.getSystemService("notification");
        if (paramContext != null) {
          paramContext.cancel(10436);
        }
      }
      catch (SecurityException paramContext) {}
    }
  }
  
  private static void zzbp(Context paramContext)
  {
    if (xg.get()) {}
    int j;
    do
    {
      return;
      j = zzy.zzce(paramContext);
      if (j == 0) {
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      }
    } while (j == GOOGLE_PLAY_SERVICES_VERSION_CODE);
    int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    paramContext = String.valueOf("com.google.android.gms.version");
    throw new IllegalStateException(String.valueOf(paramContext).length() + 290 + "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + i + " but found " + j + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"" + paramContext + "\" android:value=\"@integer/google_play_services_version\" />");
  }
  
  public static boolean zzbq(Context paramContext)
  {
    zzbt(paramContext);
    return xd;
  }
  
  public static boolean zzbr(Context paramContext)
  {
    if ((zzbq(paramContext)) || (!zzaqr())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  @TargetApi(18)
  public static boolean zzbs(Context paramContext)
  {
    if (zzs.zzayt())
    {
      paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext == null) || (!"true".equals(paramContext.getString("restricted_profile")))) {}
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static void zzbt(Context paramContext)
  {
    if (!xe) {
      zzbu(paramContext);
    }
  }
  
  private static void zzbu(Context paramContext)
  {
    for (;;)
    {
      try
      {
        PackageInfo localPackageInfo = zzsz.zzco(paramContext).getPackageInfo("com.google.android.gms", 64);
        if (localPackageInfo != null) {
          if (zzf.zzbv(paramContext).zza(localPackageInfo, new zzd.zza[] { zzd.zzd.xa[1] }) != null)
          {
            xd = true;
            return;
          }
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", paramContext);
        xe = true;
        continue;
      }
      finally
      {
        xe = true;
      }
      xd = false;
    }
  }
  
  @Deprecated
  @TargetApi(19)
  public static boolean zzc(Context paramContext, int paramInt, String paramString)
  {
    return zzx.zzc(paramContext, paramInt, paramString);
  }
  
  @Deprecated
  public static boolean zzd(Context paramContext, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 18) {}
    for (;;)
    {
      return bool;
      if (paramInt == 1) {
        bool = zzs(paramContext, "com.google.android.gms");
      } else {
        bool = false;
      }
    }
  }
  
  @Deprecated
  public static boolean zze(Context paramContext, int paramInt)
  {
    if (paramInt == 9) {}
    for (boolean bool = zzs(paramContext, "com.android.vending");; bool = false) {
      return bool;
    }
  }
  
  @Deprecated
  public static boolean zzf(Context paramContext, int paramInt)
  {
    return zzx.zzf(paramContext, paramInt);
  }
  
  @TargetApi(21)
  static boolean zzs(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = paramString.equals("com.google.android.gms");
    if ((bool2) && (zzd.zzayi())) {}
    for (;;)
    {
      return bool1;
      if (zzs.zzayx())
      {
        localObject = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext()) {
            if (paramString.equals(((PackageInstaller.SessionInfo)((Iterator)localObject).next()).getAppPackageName()))
            {
              bool1 = true;
              break;
            }
          }
        }
      }
      Object localObject = paramContext.getPackageManager();
      try
      {
        paramString = ((PackageManager)localObject).getApplicationInfo(paramString, 8192);
        if (bool2)
        {
          bool2 = paramString.enabled;
          bool1 = bool2;
          continue;
        }
        if (paramString.enabled)
        {
          bool2 = zzbs(paramContext);
          if (bool2) {}
        }
        for (bool1 = true;; bool1 = false) {
          break;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */