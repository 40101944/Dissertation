package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

public class zza
  extends zzd
{
  public static boolean cC;
  private AdvertisingIdClient.Info cD;
  private final zzal cE;
  private String cF;
  private boolean cG = false;
  private Object cH = new Object();
  
  zza(zzf paramzzf)
  {
    super(paramzzf);
    this.cE = new zzal(paramzzf.zzabz());
  }
  
  private boolean zza(AdvertisingIdClient.Info paramInfo1, AdvertisingIdClient.Info paramInfo2)
  {
    String str2 = null;
    boolean bool;
    if (paramInfo2 == null)
    {
      paramInfo2 = null;
      if (!TextUtils.isEmpty(paramInfo2)) {
        break label28;
      }
      bool = true;
    }
    label28:
    String str1;
    for (;;)
    {
      return bool;
      paramInfo2 = paramInfo2.getId();
      break;
      str1 = zzacf().zzady();
      for (;;)
      {
        synchronized (this.cH)
        {
          if (!this.cG)
          {
            this.cF = zzabq();
            this.cG = true;
            paramInfo1 = String.valueOf(paramInfo2);
            str2 = String.valueOf(str1);
            if (str2.length() == 0) {
              break label246;
            }
            paramInfo1 = paramInfo1.concat(str2);
            paramInfo1 = zzeq(paramInfo1);
            if (!TextUtils.isEmpty(paramInfo1)) {
              break label258;
            }
            bool = false;
          }
        }
        if (TextUtils.isEmpty(this.cF))
        {
          if (paramInfo1 == null)
          {
            paramInfo1 = str2;
            label136:
            if (paramInfo1 != null) {
              break label196;
            }
            paramInfo1 = String.valueOf(paramInfo2);
            paramInfo2 = String.valueOf(str1);
            if (paramInfo2.length() == 0) {
              break label184;
            }
          }
          label184:
          for (paramInfo1 = paramInfo1.concat(paramInfo2);; paramInfo1 = new String(paramInfo1))
          {
            bool = zzer(paramInfo1);
            break;
            paramInfo1 = paramInfo1.getId();
            break label136;
          }
          label196:
          paramInfo1 = String.valueOf(paramInfo1);
          str2 = String.valueOf(str1);
          if (str2.length() != 0) {}
          for (paramInfo1 = paramInfo1.concat(str2);; paramInfo1 = new String(paramInfo1))
          {
            this.cF = zzeq(paramInfo1);
            break;
          }
          label246:
          paramInfo1 = new String(paramInfo1);
        }
      }
      label258:
      if (!paramInfo1.equals(this.cF)) {
        break label277;
      }
      bool = true;
    }
    label277:
    if (!TextUtils.isEmpty(this.cF))
    {
      zzes("Resetting the client id because Advertising Id changed.");
      paramInfo1 = zzacf().zzadz();
      zza("New client Id", paramInfo1);
    }
    for (;;)
    {
      paramInfo2 = String.valueOf(paramInfo2);
      paramInfo1 = String.valueOf(paramInfo1);
      if (paramInfo1.length() != 0) {}
      for (paramInfo1 = paramInfo2.concat(paramInfo1);; paramInfo1 = new String(paramInfo2))
      {
        bool = zzer(paramInfo1);
        break;
      }
      paramInfo1 = str1;
    }
  }
  
  /* Error */
  private AdvertisingIdClient.Info zzabo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/google/android/gms/analytics/internal/zza:cE	Lcom/google/android/gms/analytics/internal/zzal;
    //   6: ldc2_w 114
    //   9: invokevirtual 119	com/google/android/gms/analytics/internal/zzal:zzz	(J)Z
    //   12: ifeq +32 -> 44
    //   15: aload_0
    //   16: getfield 41	com/google/android/gms/analytics/internal/zza:cE	Lcom/google/android/gms/analytics/internal/zzal;
    //   19: invokevirtual 122	com/google/android/gms/analytics/internal/zzal:start	()V
    //   22: aload_0
    //   23: invokevirtual 125	com/google/android/gms/analytics/internal/zza:zzabp	()Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   26: astore_1
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 127	com/google/android/gms/analytics/internal/zza:cD	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   32: aload_1
    //   33: invokespecial 129	com/google/android/gms/analytics/internal/zza:zza	(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;)Z
    //   36: ifeq +17 -> 53
    //   39: aload_0
    //   40: aload_1
    //   41: putfield 127	com/google/android/gms/analytics/internal/zza:cD	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   44: aload_0
    //   45: getfield 127	com/google/android/gms/analytics/internal/zza:cD	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aload_0
    //   54: ldc -125
    //   56: invokevirtual 134	com/google/android/gms/analytics/internal/zza:zzew	(Ljava/lang/String;)V
    //   59: new 52	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   62: astore_1
    //   63: aload_1
    //   64: ldc -120
    //   66: iconst_0
    //   67: invokespecial 139	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   70: aload_0
    //   71: aload_1
    //   72: putfield 127	com/google/android/gms/analytics/internal/zza:cD	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    //   75: goto -31 -> 44
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	zza
    //   26	46	1	localInfo	AdvertisingIdClient.Info
    //   78	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	78	finally
    //   44	49	78	finally
    //   53	75	78	finally
  }
  
  private static String zzeq(String paramString)
  {
    MessageDigest localMessageDigest = zzao.zzfl("MD5");
    if (localMessageDigest == null) {}
    for (paramString = null;; paramString = String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) })) {
      return paramString;
    }
  }
  
  private boolean zzer(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = zzeq(paramString);
      zzes("Storing hashed adid.");
      FileOutputStream localFileOutputStream = getContext().openFileOutput("gaClientIdData", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      this.cF = paramString;
      bool = true;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        zze("Error creating hash file", paramString);
      }
    }
    return bool;
  }
  
  public boolean zzabc()
  {
    boolean bool2 = false;
    zzacj();
    AdvertisingIdClient.Info localInfo = zzabo();
    boolean bool1 = bool2;
    if (localInfo != null)
    {
      bool1 = bool2;
      if (!localInfo.isLimitAdTrackingEnabled()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String zzabn()
  {
    Object localObject2 = null;
    zzacj();
    Object localObject1 = zzabo();
    if (localObject1 != null) {}
    for (localObject1 = ((AdvertisingIdClient.Info)localObject1).getId();; localObject1 = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        return (String)localObject1;
      }
    }
  }
  
  protected AdvertisingIdClient.Info zzabp()
  {
    Object localObject2 = null;
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      return localInfo;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        zzev("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        localObject1 = localObject2;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (!cC)
        {
          cC = true;
          zzd("Error getting advertiser id", localThrowable);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  protected String zzabq()
  {
    localObject4 = null;
    localObject3 = null;
    for (;;)
    {
      try
      {
        localFileInputStream = getContext().openFileInput("gaClientIdData");
        localObject1 = new byte[''];
        i = localFileInputStream.read((byte[])localObject1, 0, 128);
        if (localFileInputStream.available() <= 0) {
          continue;
        }
        zzev("Hash file seems corrupted, deleting it.");
        localFileInputStream.close();
        getContext().deleteFile("gaClientIdData");
        localObject1 = localObject3;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        Object localObject1;
        int i;
        localObject2 = localObject3;
        continue;
        localObject2 = new String((byte[])localObject2, 0, i);
      }
      catch (IOException localIOException1)
      {
        try
        {
          FileInputStream localFileInputStream;
          localFileInputStream.close();
        }
        catch (IOException localIOException2)
        {
          Object localObject2;
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException2) {}
        localIOException1 = localIOException1;
        localObject2 = localObject4;
        zzd("Error reading Hash file, deleting it", localIOException1);
        getContext().deleteFile("gaClientIdData");
        continue;
        continue;
      }
      return (String)localObject1;
      if (i > 0) {
        continue;
      }
      zzes("Hash file is empty.");
      localFileInputStream.close();
      localObject1 = localObject3;
    }
  }
  
  protected void zzzy() {}
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */