package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzcl.zza;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient
{
  private final Context mContext;
  com.google.android.gms.common.zza zzalf;
  zzcl zzalg;
  boolean zzalh;
  Object zzali = new Object();
  zza zzalj;
  final long zzalk;
  
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false);
  }
  
  public AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean)
  {
    zzaa.zzy(paramContext);
    Context localContext;
    if (paramBoolean)
    {
      localContext = paramContext.getApplicationContext();
      if (localContext != null) {}
    }
    for (this.mContext = paramContext;; this.mContext = paramContext)
    {
      this.zzalh = false;
      this.zzalk = paramLong;
      return;
      paramContext = localContext;
      break;
    }
  }
  
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    f2 = 0.0F;
    boolean bool2 = false;
    boolean bool3 = false;
    bool1 = bool2;
    try
    {
      localObject = zze.getRemoteContext(paramContext);
      f1 = f2;
      bool1 = bool3;
      if (localObject != null)
      {
        bool1 = bool2;
        localObject = ((Context)localObject).getSharedPreferences("google_ads_flags", 1);
        bool1 = bool2;
        bool2 = ((SharedPreferences)localObject).getBoolean("gads:ad_id_app_context:enabled", false);
        bool1 = bool2;
        f1 = ((SharedPreferences)localObject).getFloat("gads:ad_id_app_context:ping_ratio", 0.0F);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        Log.w("AdvertisingIdClient", "Error while reading from SharedPreferences ", localException);
        f1 = f2;
      }
    }
    localObject = new AdvertisingIdClient(paramContext, -1L, bool1);
    try
    {
      ((AdvertisingIdClient)localObject).zze(false);
      paramContext = ((AdvertisingIdClient)localObject).getInfo();
      ((AdvertisingIdClient)localObject).zza(paramContext, bool1, f1, null);
      ((AdvertisingIdClient)localObject).finish();
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        localException.zza(null, bool1, f1, paramContext);
        localException.finish();
        paramContext = null;
      }
    }
    finally
    {
      localException.finish();
    }
    return paramContext;
  }
  
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean) {}
  
  static zzcl zza(Context paramContext, com.google.android.gms.common.zza paramzza)
    throws IOException
  {
    try
    {
      paramContext = zzcl.zza.zzf(paramzza.zza(10000L, TimeUnit.MILLISECONDS));
      return paramContext;
    }
    catch (InterruptedException paramContext)
    {
      throw new IOException("Interrupted exception");
    }
    catch (Throwable paramContext)
    {
      throw new IOException(paramContext);
    }
  }
  
  private void zza(Info paramInfo, boolean paramBoolean, float paramFloat, Throwable paramThrowable)
  {
    if (Math.random() > paramFloat) {}
    for (;;)
    {
      return;
      new Thread()
      {
        public void run()
        {
          new zza().zzv(this.zzall);
        }
      }.start();
    }
  }
  
  private void zzea()
  {
    synchronized (this.zzali)
    {
      if (this.zzalj != null) {
        this.zzalj.cancel();
      }
    }
    try
    {
      this.zzalj.join();
      if (this.zzalk > 0L)
      {
        zza localzza = new com/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
        localzza.<init>(this, this.zzalk);
        this.zzalj = localzza;
      }
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  static com.google.android.gms.common.zza zzf(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      switch (zzc.zzaql().isGooglePlayServicesAvailable(paramContext))
      {
      case 1: 
      default: 
        throw new IOException("Google Play services not available");
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new GooglePlayServicesNotAvailableException(9);
    }
    com.google.android.gms.common.zza localzza = new com.google.android.gms.common.zza();
    Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
    localIntent.setPackage("com.google.android.gms");
    try
    {
      boolean bool = com.google.android.gms.common.stats.zza.zzaxr().zza(paramContext, localIntent, localzza, 1);
      if (bool) {
        return localzza;
      }
    }
    catch (Throwable paramContext)
    {
      throw new IOException(paramContext);
    }
    throw new IOException("Connection failure");
  }
  
  protected void finalize()
    throws Throwable
  {
    finish();
    super.finalize();
  }
  
  /* Error */
  public void finish()
  {
    // Byte code:
    //   0: ldc -8
    //   2: invokestatic 251	com/google/android/gms/common/internal/zzaa:zzht	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 53	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalf	Lcom/google/android/gms/common/zza;
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalh	Z
    //   28: ifeq +17 -> 45
    //   31: invokestatic 236	com/google/android/gms/common/stats/zza:zzaxr	()Lcom/google/android/gms/common/stats/zza;
    //   34: aload_0
    //   35: getfield 53	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   38: aload_0
    //   39: getfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalf	Lcom/google/android/gms/common/zza;
    //   42: invokevirtual 256	com/google/android/gms/common/stats/zza:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 55	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalh	Z
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 258	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalg	Lcom/google/android/gms/internal/zzcl;
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 253	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzalf	Lcom/google/android/gms/common/zza;
    //   60: aload_0
    //   61: monitorexit
    //   62: goto -39 -> 23
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: ldc 115
    //   73: ldc_w 260
    //   76: aload_1
    //   77: invokestatic 263	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   80: pop
    //   81: goto -36 -> 45
    //   84: astore_1
    //   85: ldc 115
    //   87: ldc_w 260
    //   90: aload_1
    //   91: invokestatic 263	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   94: pop
    //   95: goto -50 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	AdvertisingIdClient
    //   65	4	1	localObject	Object
    //   70	7	1	localIllegalArgumentException	IllegalArgumentException
    //   84	7	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   7	21	65	finally
    //   21	23	65	finally
    //   24	45	65	finally
    //   45	62	65	finally
    //   66	68	65	finally
    //   71	81	65	finally
    //   85	95	65	finally
    //   24	45	70	java/lang/IllegalArgumentException
    //   24	45	84	java/lang/Throwable
  }
  
  public Info getInfo()
    throws IOException
  {
    zzaa.zzht("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzalh) {
        break label103;
      }
      synchronized (this.zzali)
      {
        if ((this.zzalj == null) || (!this.zzalj.zzeb()))
        {
          IOException localIOException2 = new java/io/IOException;
          localIOException2.<init>("AdvertisingIdClient is not connected.");
          throw localIOException2;
        }
      }
    }
    finally {}
    Object localObject3;
    try
    {
      zze(false);
      if (!this.zzalh)
      {
        localObject3 = new java/io/IOException;
        ((IOException)localObject3).<init>("AdvertisingIdClient cannot reconnect.");
        throw ((Throwable)localObject3);
      }
    }
    catch (Exception localException)
    {
      localObject3 = new java/io/IOException;
      ((IOException)localObject3).<init>("AdvertisingIdClient cannot reconnect.", localException);
      throw ((Throwable)localObject3);
    }
    label103:
    zzaa.zzy(this.zzalf);
    zzaa.zzy(this.zzalg);
    try
    {
      localObject3 = new com/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
      ((Info)localObject3).<init>(this.zzalg.getId(), this.zzalg.zzf(true));
      zzea();
      return (Info)localObject3;
    }
    catch (RemoteException localRemoteException)
    {
      Log.i("AdvertisingIdClient", "GMS remote exception ", localRemoteException);
      IOException localIOException1 = new java/io/IOException;
      localIOException1.<init>("Remote exception");
      throw localIOException1;
    }
  }
  
  public void start()
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zze(true);
  }
  
  Uri zza(Info paramInfo, boolean paramBoolean, Throwable paramThrowable)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      localObject = "1";
      localBundle.putString("app_context", (String)localObject);
      if (paramInfo != null) {
        if (!paramInfo.isLimitAdTrackingEnabled()) {
          break label168;
        }
      }
    }
    label168:
    for (Object localObject = "1";; localObject = "0")
    {
      localBundle.putString("limit_ad_tracking", (String)localObject);
      if ((paramInfo != null) && (paramInfo.getId() != null)) {
        localBundle.putString("ad_id_size", Integer.toString(paramInfo.getId().length()));
      }
      if (paramThrowable != null) {
        localBundle.putString("error", paramThrowable.getClass().getName());
      }
      paramInfo = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
      localObject = localBundle.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramThrowable = (String)((Iterator)localObject).next();
        paramInfo.appendQueryParameter(paramThrowable, localBundle.getString(paramThrowable));
      }
      localObject = "0";
      break;
    }
    return paramInfo.build();
  }
  
  protected void zze(boolean paramBoolean)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzaa.zzht("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzalh) {
        finish();
      }
      this.zzalf = zzf(this.mContext);
      this.zzalg = zza(this.mContext, this.zzalf);
      this.zzalh = true;
      if (paramBoolean) {
        zzea();
      }
      return;
    }
    finally {}
  }
  
  public static final class Info
  {
    private final String zzalr;
    private final boolean zzals;
    
    public Info(String paramString, boolean paramBoolean)
    {
      this.zzalr = paramString;
      this.zzals = paramBoolean;
    }
    
    public String getId()
    {
      return this.zzalr;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return this.zzals;
    }
    
    public String toString()
    {
      String str = this.zzalr;
      boolean bool = this.zzals;
      return String.valueOf(str).length() + 7 + "{" + str + "}" + bool;
    }
  }
  
  static class zza
    extends Thread
  {
    private WeakReference<AdvertisingIdClient> zzaln;
    private long zzalo;
    CountDownLatch zzalp;
    boolean zzalq;
    
    public zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
    {
      this.zzaln = new WeakReference(paramAdvertisingIdClient);
      this.zzalo = paramLong;
      this.zzalp = new CountDownLatch(1);
      this.zzalq = false;
      start();
    }
    
    private void disconnect()
    {
      AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.zzaln.get();
      if (localAdvertisingIdClient != null)
      {
        localAdvertisingIdClient.finish();
        this.zzalq = true;
      }
    }
    
    public void cancel()
    {
      this.zzalp.countDown();
    }
    
    public void run()
    {
      try
      {
        if (!this.zzalp.await(this.zzalo, TimeUnit.MILLISECONDS)) {
          disconnect();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          disconnect();
        }
      }
    }
    
    public boolean zzeb()
    {
      return this.zzalq;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\ads\identifier\AdvertisingIdClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */