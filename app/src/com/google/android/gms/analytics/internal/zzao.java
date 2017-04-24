package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.internal.zzmt;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class zzao
{
  private static final char[] fW = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static double zza(String paramString, double paramDouble)
  {
    if (paramString == null) {}
    for (;;)
    {
      return paramDouble;
      try
      {
        double d = Double.parseDouble(paramString);
        paramDouble = d;
      }
      catch (NumberFormatException paramString) {}
    }
  }
  
  public static zzmt zza(zzaf paramzzaf, String paramString)
  {
    Object localObject = null;
    zzaa.zzy(paramzzaf);
    if (TextUtils.isEmpty(paramString)) {
      paramzzaf = (zzaf)localObject;
    }
    for (;;)
    {
      return paramzzaf;
      new HashMap();
      try
      {
        URI localURI = new java/net/URI;
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {}
        for (paramString = "?".concat(paramString);; paramString = new String("?"))
        {
          localURI.<init>(paramString);
          paramString = zzn.zza(localURI, "UTF-8");
          paramzzaf = new zzmt();
          paramzzaf.zzdx((String)paramString.get("utm_content"));
          paramzzaf.zzdv((String)paramString.get("utm_medium"));
          paramzzaf.setName((String)paramString.get("utm_campaign"));
          paramzzaf.zzdu((String)paramString.get("utm_source"));
          paramzzaf.zzdw((String)paramString.get("utm_term"));
          paramzzaf.zzdy((String)paramString.get("utm_id"));
          paramzzaf.zzdz((String)paramString.get("anid"));
          paramzzaf.zzea((String)paramString.get("gclid"));
          paramzzaf.zzeb((String)paramString.get("dclid"));
          paramzzaf.zzec((String)paramString.get("aclid"));
          break;
        }
      }
      catch (URISyntaxException paramString)
      {
        paramzzaf.zzd("No valid campaign data found", paramString);
        paramzzaf = (zzaf)localObject;
      }
    }
  }
  
  public static String zza(Locale paramLocale)
  {
    Object localObject = null;
    if (paramLocale == null) {}
    for (;;)
    {
      return (String)localObject;
      String str = paramLocale.getLanguage();
      if (!TextUtils.isEmpty(str))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str.toLowerCase());
        if (!TextUtils.isEmpty(paramLocale.getCountry())) {
          ((StringBuilder)localObject).append("-").append(paramLocale.getCountry().toLowerCase());
        }
        localObject = ((StringBuilder)localObject).toString();
      }
    }
  }
  
  public static void zza(Map<String, String> paramMap1, String paramString, Map<String, String> paramMap2)
  {
    zzc(paramMap1, paramString, (String)paramMap2.get(paramString));
  }
  
  public static boolean zza(double paramDouble, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramDouble > 0.0D)
    {
      if (paramDouble < 100.0D) {
        break label25;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label25:
      bool1 = bool2;
      if (zzfm(paramString) % 10000 >= 100.0D * paramDouble) {
        bool1 = true;
      }
    }
  }
  
  public static boolean zza(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      ComponentName localComponentName = new android/content/ComponentName;
      localComponentName.<init>(paramContext, paramString);
      paramContext = localPackageManager.getReceiverInfo(localComponentName, 2);
      if ((paramContext == null) || (!paramContext.enabled)) {
        break label53;
      }
      if (paramBoolean)
      {
        paramBoolean = paramContext.exported;
        if (!paramBoolean) {
          break label53;
        }
      }
      paramBoolean = true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        label53:
        paramBoolean = false;
      }
    }
    return paramBoolean;
  }
  
  public static String zzax(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0") {
      return str;
    }
  }
  
  public static void zzb(Map<String, String> paramMap, String paramString, boolean paramBoolean)
  {
    if (!paramMap.containsKey(paramString)) {
      if (!paramBoolean) {
        break label27;
      }
    }
    label27:
    for (String str = "1";; str = "0")
    {
      paramMap.put(paramString, str);
      return;
    }
  }
  
  public static void zzc(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!paramMap.containsKey(paramString1))) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static void zzd(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (TextUtils.isEmpty((CharSequence)paramMap.get(paramString1)))) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  public static Map<String, String> zzfi(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramString.split("&");
    int j = arrayOfString1.length;
    int i = 0;
    if (i < j)
    {
      String[] arrayOfString2 = arrayOfString1[i].split("=", 3);
      if (arrayOfString2.length > 1)
      {
        String str = arrayOfString2[0];
        if (TextUtils.isEmpty(arrayOfString2[1]))
        {
          paramString = null;
          label64:
          localHashMap.put(str, paramString);
          if ((arrayOfString2.length == 3) && (!TextUtils.isEmpty(arrayOfString2[1])) && (!localHashMap.containsKey(arrayOfString2[1])))
          {
            str = arrayOfString2[1];
            if (!TextUtils.isEmpty(arrayOfString2[2])) {
              break label146;
            }
            paramString = null;
            label122:
            localHashMap.put(str, paramString);
          }
        }
      }
      for (;;)
      {
        i++;
        break;
        paramString = arrayOfString2[1];
        break label64;
        label146:
        paramString = arrayOfString2[2];
        break label122;
        if ((arrayOfString2.length == 1) && (arrayOfString2[0].length() != 0)) {
          localHashMap.put(arrayOfString2[0], null);
        }
      }
    }
    return localHashMap;
  }
  
  public static long zzfj(String paramString)
  {
    long l2 = 0L;
    long l1;
    if (paramString == null) {
      l1 = l2;
    }
    for (;;)
    {
      return l1;
      try
      {
        l1 = Long.parseLong(paramString);
      }
      catch (NumberFormatException paramString)
      {
        l1 = l2;
      }
    }
  }
  
  public static String zzfk(String paramString)
  {
    int i = 0;
    String[] arrayOfString1 = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = arrayOfString1;
    }
    for (;;)
    {
      return paramString;
      Object localObject = paramString;
      if (paramString.contains("?"))
      {
        String[] arrayOfString2 = paramString.split("[\\?]");
        localObject = paramString;
        if (arrayOfString2.length > 1) {
          localObject = arrayOfString2[1];
        }
      }
      if (((String)localObject).contains("%3D")) {}
      try
      {
        paramString = URLDecoder.decode((String)localObject, "UTF-8");
        do
        {
          localObject = zzfi(paramString);
          arrayOfString1 = new String[11];
          arrayOfString1[0] = "dclid";
          arrayOfString1[1] = "utm_source";
          arrayOfString1[2] = "gclid";
          arrayOfString1[3] = "aclid";
          arrayOfString1[4] = "utm_campaign";
          arrayOfString1[5] = "utm_medium";
          arrayOfString1[6] = "utm_term";
          arrayOfString1[7] = "utm_content";
          arrayOfString1[8] = "utm_id";
          arrayOfString1[9] = "anid";
          arrayOfString1[10] = "gmob_t";
          paramString = new StringBuilder();
          while (i < 11)
          {
            if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(arrayOfString1[i])))
            {
              if (paramString.length() > 0) {
                paramString.append("&");
              }
              paramString.append(arrayOfString1[i]).append("=").append((String)((Map)localObject).get(arrayOfString1[i]));
            }
            i++;
          }
          paramString = (String)localObject;
        } while (((String)localObject).contains("="));
        paramString = arrayOfString1;
        continue;
        paramString = paramString.toString();
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString = arrayOfString1;
      }
    }
  }
  
  public static MessageDigest zzfl(String paramString)
  {
    int i = 0;
    if (i < 2) {}
    for (;;)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i++;
      }
      break;
      Object localObject = null;
    }
  }
  
  public static int zzfm(String paramString)
  {
    int k = 1;
    if (!TextUtils.isEmpty(paramString))
    {
      int j = paramString.length();
      int i = 0;
      j--;
      for (;;)
      {
        k = i;
        if (j < 0) {
          break;
        }
        k = paramString.charAt(j);
        k = (i << 6 & 0xFFFFFFF) + k + (k << 14);
        int m = 0xFE00000 & k;
        i = k;
        if (m != 0) {
          i = k ^ m >> 21;
        }
        j--;
      }
    }
    return k;
  }
  
  public static boolean zzfn(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return bool;
      if (paramString.startsWith("http:")) {
        bool = false;
      }
    }
  }
  
  public static boolean zzg(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      if ((!paramString.equalsIgnoreCase("true")) && (!paramString.equalsIgnoreCase("yes")) && (!paramString.equalsIgnoreCase("1"))) {
        break label39;
      }
      bool = true;
    }
    for (;;)
    {
      return bool;
      label39:
      if ((!paramString.equalsIgnoreCase("false")) && (!paramString.equalsIgnoreCase("no")))
      {
        bool = paramBoolean;
        if (!paramString.equalsIgnoreCase("0")) {}
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public static boolean zzr(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      ComponentName localComponentName = new android/content/ComponentName;
      localComponentName.<init>(paramContext, paramString);
      paramContext = localPackageManager.getServiceInfo(localComponentName, 4);
      if (paramContext == null) {
        break label42;
      }
      bool = paramContext.enabled;
      if (!bool) {
        break label42;
      }
      bool = true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        label42:
        boolean bool = false;
      }
    }
    return bool;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */