package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzms;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzmw;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzl
  extends zzd
{
  private final zzj dC;
  private final zzah dD;
  private final zzag dE;
  private final zzi dF;
  private long dG;
  private final zzt dH;
  private final zzt dI;
  private final zzal dJ;
  private long dK;
  private boolean dL;
  private boolean mStarted;
  
  protected zzl(zzf paramzzf, zzg paramzzg)
  {
    super(paramzzf);
    zzaa.zzy(paramzzg);
    this.dG = Long.MIN_VALUE;
    this.dE = paramzzg.zzk(paramzzf);
    this.dC = paramzzg.zzm(paramzzf);
    this.dD = paramzzg.zzn(paramzzf);
    this.dF = paramzzg.zzo(paramzzf);
    this.dJ = new zzal(zzabz());
    this.dH = new zzt(paramzzf)
    {
      public void run()
      {
        zzl.zza(zzl.this);
      }
    };
    this.dI = new zzt(paramzzf)
    {
      public void run()
      {
        zzl.zzb(zzl.this);
      }
    };
  }
  
  private void zza(zzh paramzzh, zzmt paramzzmt)
  {
    zzaa.zzy(paramzzh);
    zzaa.zzy(paramzzmt);
    Object localObject1 = new zza(zzabx());
    ((zza)localObject1).zzdr(paramzzh.zzacs());
    ((zza)localObject1).enableAdvertisingIdCollection(paramzzh.zzact());
    com.google.android.gms.analytics.zze localzze = ((zza)localObject1).zzyu();
    zznb localzznb = (zznb)localzze.zzb(zznb.class);
    localzznb.zzeh("data");
    localzznb.zzat(true);
    localzze.zza(paramzzmt);
    zzmw localzzmw = (zzmw)localzze.zzb(zzmw.class);
    localObject1 = (zzms)localzze.zzb(zzms.class);
    Iterator localIterator = paramzzh.zzmc().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if ("an".equals(str)) {
        ((zzms)localObject1).setAppName((String)localObject2);
      } else if ("av".equals(str)) {
        ((zzms)localObject1).setAppVersion((String)localObject2);
      } else if ("aid".equals(str)) {
        ((zzms)localObject1).setAppId((String)localObject2);
      } else if ("aiid".equals(str)) {
        ((zzms)localObject1).setAppInstallerId((String)localObject2);
      } else if ("uid".equals(str)) {
        localzznb.setUserId((String)localObject2);
      } else {
        localzzmw.set(str, (String)localObject2);
      }
    }
    zzb("Sending installation campaign to", paramzzh.zzacs(), paramzzmt);
    localzze.zzp(zzace().zzago());
    localzze.zzzm();
  }
  
  private void zzadh()
  {
    zzzx();
    Context localContext = zzabx().getContext();
    if (!zzaj.zzat(localContext)) {
      zzev("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
    }
    label73:
    for (;;)
    {
      if (!CampaignTrackingReceiver.zzat(localContext)) {
        zzev("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
      }
      for (;;)
      {
        return;
        if (zzak.zzau(localContext)) {
          break label73;
        }
        zzew("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        break;
        if (!CampaignTrackingService.zzau(localContext)) {
          zzev("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
      }
    }
  }
  
  private void zzadj()
  {
    zzb(new zzw()
    {
      public void zzf(Throwable paramAnonymousThrowable)
      {
        zzl.this.zzadp();
      }
    });
  }
  
  private void zzadk()
  {
    try
    {
      this.dC.zzadb();
      zzadp();
      zzt localzzt = this.dI;
      zzacb();
      localzzt.zzx(86400000L);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzd("Failed to delete stale hits", localSQLiteException);
      }
    }
  }
  
  private boolean zzadq()
  {
    boolean bool = false;
    if (this.dL) {}
    for (;;)
    {
      return bool;
      zzacb();
      if (zzadw() > 0L) {
        bool = true;
      }
    }
  }
  
  private void zzadr()
  {
    zzv localzzv = zzacd();
    if (!localzzv.zzafn()) {}
    for (;;)
    {
      return;
      if (!localzzv.zzfy())
      {
        long l = zzadc();
        if ((l != 0L) && (Math.abs(zzabz().currentTimeMillis() - l) <= zzacb().zzaeo()))
        {
          zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzacb().zzaen()));
          localzzv.schedule();
        }
      }
    }
  }
  
  private void zzads()
  {
    zzadr();
    long l2 = zzadw();
    long l1 = zzace().zzagq();
    if (l1 != 0L)
    {
      l1 = l2 - Math.abs(zzabz().currentTimeMillis() - l1);
      if (l1 > 0L)
      {
        zza("Dispatch scheduled (ms)", Long.valueOf(l1));
        if (!this.dH.zzfy()) {
          break label120;
        }
        l1 = Math.max(1L, l1 + this.dH.zzafk());
        this.dH.zzy(l1);
      }
    }
    for (;;)
    {
      return;
      l1 = Math.min(zzacb().zzael(), l2);
      break;
      l1 = Math.min(zzacb().zzael(), l2);
      break;
      label120:
      this.dH.zzx(l1);
    }
  }
  
  private void zzadt()
  {
    zzadu();
    zzadv();
  }
  
  private void zzadu()
  {
    if (this.dH.zzfy()) {
      zzes("All hits dispatched or no network/service. Going to power save mode");
    }
    this.dH.cancel();
  }
  
  private void zzadv()
  {
    zzv localzzv = zzacd();
    if (localzzv.zzfy()) {
      localzzv.cancel();
    }
  }
  
  private boolean zzez(String paramString)
  {
    if (zzsz.zzco(getContext()).checkCallingOrSelfPermission(paramString) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void onServiceConnected()
  {
    zzzx();
    zzacb();
    zzadm();
  }
  
  void start()
  {
    zzacj();
    if (!this.mStarted) {}
    for (boolean bool = true;; bool = false)
    {
      zzaa.zza(bool, "Analytics backend already started");
      this.mStarted = true;
      zzacc().zzg(new Runnable()
      {
        public void run()
        {
          zzl.this.zzadi();
        }
      });
      return;
    }
  }
  
  /* Error */
  public long zza(zzh paramzzh, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 42	com/google/android/gms/common/internal/zzaa:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 434	com/google/android/gms/analytics/internal/zzl:zzacj	()V
    //   9: aload_0
    //   10: invokevirtual 245	com/google/android/gms/analytics/internal/zzl:zzzx	()V
    //   13: aload_0
    //   14: getfield 60	com/google/android/gms/analytics/internal/zzl:dC	Lcom/google/android/gms/analytics/internal/zzj;
    //   17: invokevirtual 456	com/google/android/gms/analytics/internal/zzj:beginTransaction	()V
    //   20: aload_0
    //   21: getfield 60	com/google/android/gms/analytics/internal/zzl:dC	Lcom/google/android/gms/analytics/internal/zzj;
    //   24: aload_1
    //   25: invokevirtual 459	com/google/android/gms/analytics/internal/zzh:zzacr	()J
    //   28: aload_1
    //   29: invokevirtual 462	com/google/android/gms/analytics/internal/zzh:zzze	()Ljava/lang/String;
    //   32: invokevirtual 465	com/google/android/gms/analytics/internal/zzj:zza	(JLjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 60	com/google/android/gms/analytics/internal/zzl:dC	Lcom/google/android/gms/analytics/internal/zzj;
    //   39: aload_1
    //   40: invokevirtual 459	com/google/android/gms/analytics/internal/zzh:zzacr	()J
    //   43: aload_1
    //   44: invokevirtual 462	com/google/android/gms/analytics/internal/zzh:zzze	()Ljava/lang/String;
    //   47: aload_1
    //   48: invokevirtual 107	com/google/android/gms/analytics/internal/zzh:zzacs	()Ljava/lang/String;
    //   51: invokevirtual 468	com/google/android/gms/analytics/internal/zzj:zza	(JLjava/lang/String;Ljava/lang/String;)J
    //   54: lstore_3
    //   55: iload_2
    //   56: ifne +32 -> 88
    //   59: aload_1
    //   60: lload_3
    //   61: invokevirtual 471	com/google/android/gms/analytics/internal/zzh:zzr	(J)V
    //   64: aload_0
    //   65: getfield 60	com/google/android/gms/analytics/internal/zzl:dC	Lcom/google/android/gms/analytics/internal/zzj;
    //   68: aload_1
    //   69: invokevirtual 474	com/google/android/gms/analytics/internal/zzj:zzb	(Lcom/google/android/gms/analytics/internal/zzh;)V
    //   72: aload_0
    //   73: getfield 60	com/google/android/gms/analytics/internal/zzl:dC	Lcom/google/android/gms/analytics/internal/zzj;
    //   76: invokevirtual 477	com/google/android/gms/analytics/internal/zzj:setTransactionSuccessful	()V
    //   79: aload_0
    //   80: getfield 60	com/google/android/gms/analytics/internal/zzl:dC	Lcom/google/android/gms/analytics/internal/zzj;
    //   83: invokevirtual 480	com/google/android/gms/analytics/internal/zzj:endTransaction	()V
    //   86: lload_3
    //   87: lreturn
    //   88: aload_1
    //   89: lconst_1
    //   90: lload_3
    //   91: ladd
    //   92: invokevirtual 471	com/google/android/gms/analytics/internal/zzh:zzr	(J)V
    //   95: goto -31 -> 64
    //   98: astore_1
    //   99: aload_0
    //   100: ldc_w 482
    //   103: aload_1
    //   104: invokevirtual 485	com/google/android/gms/analytics/internal/zzl:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield 60	com/google/android/gms/analytics/internal/zzl:dC	Lcom/google/android/gms/analytics/internal/zzj;
    //   111: invokevirtual 480	com/google/android/gms/analytics/internal/zzj:endTransaction	()V
    //   114: ldc2_w 486
    //   117: lstore_3
    //   118: goto -32 -> 86
    //   121: astore_1
    //   122: aload_0
    //   123: ldc_w 489
    //   126: aload_1
    //   127: invokevirtual 485	com/google/android/gms/analytics/internal/zzl:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   130: goto -44 -> 86
    //   133: astore_1
    //   134: aload_0
    //   135: ldc_w 489
    //   138: aload_1
    //   139: invokevirtual 485	com/google/android/gms/analytics/internal/zzl:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   142: goto -28 -> 114
    //   145: astore_1
    //   146: aload_0
    //   147: getfield 60	com/google/android/gms/analytics/internal/zzl:dC	Lcom/google/android/gms/analytics/internal/zzj;
    //   150: invokevirtual 480	com/google/android/gms/analytics/internal/zzj:endTransaction	()V
    //   153: aload_1
    //   154: athrow
    //   155: astore 5
    //   157: aload_0
    //   158: ldc_w 489
    //   161: aload 5
    //   163: invokevirtual 485	com/google/android/gms/analytics/internal/zzl:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   166: goto -13 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	zzl
    //   0	169	1	paramzzh	zzh
    //   0	169	2	paramBoolean	boolean
    //   54	64	3	l	long
    //   155	7	5	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   13	55	98	android/database/sqlite/SQLiteException
    //   59	64	98	android/database/sqlite/SQLiteException
    //   64	79	98	android/database/sqlite/SQLiteException
    //   88	95	98	android/database/sqlite/SQLiteException
    //   79	86	121	android/database/sqlite/SQLiteException
    //   107	114	133	android/database/sqlite/SQLiteException
    //   13	55	145	finally
    //   59	64	145	finally
    //   64	79	145	finally
    //   88	95	145	finally
    //   99	107	145	finally
    //   146	153	155	android/database/sqlite/SQLiteException
  }
  
  public void zza(zzab paramzzab)
  {
    zzaa.zzy(paramzzab);
    com.google.android.gms.analytics.zzi.zzzx();
    zzacj();
    if (this.dL)
    {
      zzet("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
      paramzzab = zzf(paramzzab);
      zzadl();
      if (!this.dF.zzb(paramzzab)) {
        break label66;
      }
      zzet("Hit sent to the device AnalyticsService for delivery");
    }
    for (;;)
    {
      return;
      zza("Delivering hit", paramzzab);
      break;
      label66:
      zzacb();
      try
      {
        this.dC.zzc(paramzzab);
        zzadp();
      }
      catch (SQLiteException localSQLiteException)
      {
        zze("Delivery failed to save hit to a database", localSQLiteException);
        zzaca().zza(paramzzab, "deliver: failed to insert hit to database");
      }
    }
  }
  
  public void zza(zzw paramzzw, long paramLong)
  {
    com.google.android.gms.analytics.zzi.zzzx();
    zzacj();
    long l1 = -1L;
    long l2 = zzace().zzagq();
    if (l2 != 0L) {
      l1 = Math.abs(zzabz().currentTimeMillis() - l2);
    }
    zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(l1));
    zzacb();
    zzadl();
    try
    {
      zzadn();
      zzace().zzagr();
      zzadp();
      if (paramzzw != null) {
        paramzzw.zzf(null);
      }
      if (this.dK != paramLong) {
        this.dE.zzagj();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        zze("Local dispatch failed", localThrowable);
        zzace().zzagr();
        zzadp();
        if (paramzzw != null) {
          paramzzw.zzf(localThrowable);
        }
      }
    }
  }
  
  public void zzabr()
  {
    com.google.android.gms.analytics.zzi.zzzx();
    zzacj();
    zzacb();
    zzes("Delete all hits from local store");
    try
    {
      this.dC.zzacz();
      this.dC.zzada();
      zzadp();
      zzadl();
      if (this.dF.zzacv()) {
        zzes("Device service unavailable. Can't clear hits stored on the device service.");
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzd("Failed to delete hits from store", localSQLiteException);
      }
    }
  }
  
  public void zzabu()
  {
    com.google.android.gms.analytics.zzi.zzzx();
    zzacj();
    zzes("Service disconnected");
  }
  
  void zzabw()
  {
    zzzx();
    this.dK = zzabz().currentTimeMillis();
  }
  
  public long zzadc()
  {
    com.google.android.gms.analytics.zzi.zzzx();
    zzacj();
    try
    {
      l = this.dC.zzadc();
      return l;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zze("Failed to get min/max hit times from local store", localSQLiteException);
        long l = 0L;
      }
    }
  }
  
  protected void zzadi()
  {
    zzacj();
    zzacb();
    zzadh();
    zzace().zzago();
    if (!zzez("android.permission.ACCESS_NETWORK_STATE"))
    {
      zzew("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzadx();
    }
    if (!zzez("android.permission.INTERNET"))
    {
      zzew("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
      zzadx();
    }
    if (zzak.zzau(getContext())) {
      zzes("AnalyticsService registered in the app manifest and enabled");
    }
    for (;;)
    {
      if (!this.dL)
      {
        zzacb();
        if (!this.dC.isEmpty()) {
          zzadl();
        }
      }
      zzadp();
      return;
      zzacb();
      zzev("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
    }
  }
  
  protected void zzadl()
  {
    if (this.dL) {}
    for (;;)
    {
      return;
      if ((zzacb().zzaeg()) && (!this.dF.isConnected()))
      {
        long l = zzacb().zzafb();
        if (this.dJ.zzz(l))
        {
          this.dJ.start();
          zzes("Connecting to service");
          if (this.dF.connect())
          {
            zzes("Connected to service");
            this.dJ.clear();
            onServiceConnected();
          }
        }
      }
    }
  }
  
  public void zzadm()
  {
    com.google.android.gms.analytics.zzi.zzzx();
    zzacj();
    zzaby();
    if (!zzacb().zzaeg()) {
      zzev("Service client disabled. Can't dispatch local hits to device AnalyticsService");
    }
    if (!this.dF.isConnected()) {
      zzes("Service not connected");
    }
    for (;;)
    {
      return;
      if (!this.dC.isEmpty())
      {
        zzes("Dispatching local hits to device AnalyticsService");
        try
        {
          label63:
          List localList = this.dC.zzt(zzacb().zzaep());
          if (!localList.isEmpty()) {
            break label130;
          }
          zzadp();
        }
        catch (SQLiteException localSQLiteException1)
        {
          zze("Failed to read hits from store", localSQLiteException1);
          zzadt();
        }
        continue;
        label111:
        Object localObject;
        localSQLiteException1.remove(localObject);
        try
        {
          this.dC.zzu(((zzab)localObject).zzafz());
          label130:
          if (localSQLiteException1.isEmpty()) {
            break label63;
          }
          localObject = (zzab)localSQLiteException1.get(0);
          if (this.dF.zzb((zzab)localObject)) {
            break label111;
          }
          zzadp();
        }
        catch (SQLiteException localSQLiteException2)
        {
          zze("Failed to remove hit that was send for delivery", localSQLiteException2);
          zzadt();
        }
      }
    }
  }
  
  protected boolean zzadn()
  {
    int j = 1;
    com.google.android.gms.analytics.zzi.zzzx();
    zzacj();
    zzes("Dispatching a batch of local hits");
    int i;
    if (!this.dF.isConnected())
    {
      zzacb();
      i = 1;
      if (this.dD.zzagk()) {
        break label65;
      }
      label43:
      if ((i == 0) || (j == 0)) {
        break label70;
      }
      zzes("No network or service available. Will retry later");
    }
    label65:
    label70:
    long l1;
    for (;;)
    {
      return false;
      i = 0;
      break;
      j = 0;
      break label43;
      long l3 = Math.max(zzacb().zzaep(), zzacb().zzaeq());
      ArrayList localArrayList = new ArrayList();
      l1 = 0L;
      try
      {
        this.dC.beginTransaction();
        localArrayList.clear();
        try
        {
          localList = this.dC.zzt(l3);
          if (localList.isEmpty())
          {
            zzes("Store is empty, nothing to dispatch");
            zzadt();
            try
            {
              this.dC.setTransactionSuccessful();
              this.dC.endTransaction();
            }
            catch (SQLiteException localSQLiteException1)
            {
              zze("Failed to commit local dispatch transaction", localSQLiteException1);
              zzadt();
            }
            continue;
          }
          zza("Hits loaded from store. count", Integer.valueOf(localList.size()));
          localObject2 = localList.iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          } while (((zzab)((Iterator)localObject2).next()).zzafz() != l1);
          zzd("Database contains successfully uploaded hit", Long.valueOf(l1), Integer.valueOf(localList.size()));
          zzadt();
          try
          {
            this.dC.setTransactionSuccessful();
            this.dC.endTransaction();
          }
          catch (SQLiteException localSQLiteException2)
          {
            zze("Failed to commit local dispatch transaction", localSQLiteException2);
            zzadt();
          }
        }
        catch (SQLiteException localSQLiteException3)
        {
          zzd("Failed to read hits from persisted store", localSQLiteException3);
          zzadt();
          try
          {
            this.dC.setTransactionSuccessful();
            this.dC.endTransaction();
          }
          catch (SQLiteException localSQLiteException4)
          {
            zze("Failed to commit local dispatch transaction", localSQLiteException4);
            zzadt();
          }
        }
      }
      finally
      {
        try
        {
          List localList;
          Object localObject2;
          this.dC.setTransactionSuccessful();
          this.dC.endTransaction();
          throw ((Throwable)localObject1);
        }
        catch (SQLiteException localSQLiteException11)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException11);
          zzadt();
        }
      }
    }
    long l2 = l1;
    if (this.dF.isConnected())
    {
      zzacb();
      zzes("Service connected, sending hits to the service");
      l2 = l1;
      if (!localList.isEmpty())
      {
        localObject2 = (zzab)localList.get(0);
        if (this.dF.zzb((zzab)localObject2)) {}
      }
    }
    for (;;)
    {
      l2 = l1;
      if (this.dD.zzagk())
      {
        localList = this.dD.zzt(localList);
        localObject2 = localList.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            l1 = Math.max(l1, ((Long)((Iterator)localObject2).next()).longValue());
            continue;
            l1 = Math.max(l1, ((zzab)localObject2).zzafz());
            localList.remove(localObject2);
            zzb("Hit sent do device AnalyticsService for delivery", localObject2);
            try
            {
              this.dC.zzu(((zzab)localObject2).zzafz());
              localSQLiteException4.add(Long.valueOf(((zzab)localObject2).zzafz()));
            }
            catch (SQLiteException localSQLiteException5)
            {
              zze("Failed to remove hit that was send for delivery", localSQLiteException5);
              zzadt();
              try
              {
                this.dC.setTransactionSuccessful();
                this.dC.endTransaction();
              }
              catch (SQLiteException localSQLiteException6)
              {
                zze("Failed to commit local dispatch transaction", localSQLiteException6);
                zzadt();
              }
            }
            break;
          }
        }
      }
      try
      {
        this.dC.zzr(localList);
        localSQLiteException6.addAll(localList);
        l2 = l1;
        boolean bool = localSQLiteException6.isEmpty();
        if (!bool) {
          break label704;
        }
        try
        {
          this.dC.setTransactionSuccessful();
          this.dC.endTransaction();
        }
        catch (SQLiteException localSQLiteException7)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException7);
          zzadt();
        }
      }
      catch (SQLiteException localSQLiteException8)
      {
        zze("Failed to remove successfully uploaded hits", localSQLiteException8);
        zzadt();
        try
        {
          this.dC.setTransactionSuccessful();
          this.dC.endTransaction();
        }
        catch (SQLiteException localSQLiteException9)
        {
          zze("Failed to commit local dispatch transaction", localSQLiteException9);
          zzadt();
        }
      }
      break;
      try
      {
        label704:
        this.dC.setTransactionSuccessful();
        this.dC.endTransaction();
        l1 = l2;
      }
      catch (SQLiteException localSQLiteException10)
      {
        zze("Failed to commit local dispatch transaction", localSQLiteException10);
        zzadt();
      }
      break;
      break;
      l1 = l2;
    }
  }
  
  public void zzado()
  {
    com.google.android.gms.analytics.zzi.zzzx();
    zzacj();
    zzet("Sync dispatching local hits");
    long l = this.dK;
    zzacb();
    zzadl();
    try
    {
      zzadn();
      zzace().zzagr();
      zzadp();
      if (this.dK != l) {
        this.dE.zzagj();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        zze("Sync local dispatch failed", localThrowable);
        zzadp();
      }
    }
  }
  
  public void zzadp()
  {
    zzabx().zzzx();
    zzacj();
    if (!zzadq())
    {
      this.dE.unregister();
      zzadt();
    }
    for (;;)
    {
      return;
      if (this.dC.isEmpty())
      {
        this.dE.unregister();
        zzadt();
      }
      else
      {
        if (!((Boolean)zzy.eU.get()).booleanValue()) {
          this.dE.zzagh();
        }
        for (boolean bool = this.dE.isConnected();; bool = true)
        {
          if (!bool) {
            break label100;
          }
          zzads();
          break;
        }
        label100:
        zzadt();
        zzadr();
      }
    }
  }
  
  public long zzadw()
  {
    long l;
    if (this.dG != Long.MIN_VALUE) {
      l = this.dG;
    }
    for (;;)
    {
      return l;
      l = zzacb().zzaem();
      if (zzzh().zzafu()) {
        l = zzzh().zzahl() * 1000L;
      }
    }
  }
  
  public void zzadx()
  {
    zzacj();
    zzzx();
    this.dL = true;
    this.dF.disconnect();
    zzadp();
  }
  
  public void zzaw(boolean paramBoolean)
  {
    zzadp();
  }
  
  public void zzb(zzw paramzzw)
  {
    zza(paramzzw, this.dK);
  }
  
  protected void zzc(zzh paramzzh)
  {
    zzzx();
    zzb("Sending first hit to property", paramzzh.zzacs());
    if (zzace().zzagp().zzz(zzacb().zzafi())) {}
    for (;;)
    {
      return;
      Object localObject = zzace().zzags();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = zzao.zza(zzaca(), (String)localObject);
        zzb("Found relevant installation campaign", localObject);
        zza(paramzzh, (zzmt)localObject);
      }
    }
  }
  
  zzab zzf(zzab paramzzab)
  {
    Object localObject1;
    if (!TextUtils.isEmpty(paramzzab.zzage())) {
      localObject1 = paramzzab;
    }
    for (;;)
    {
      return (zzab)localObject1;
      Object localObject2 = zzace().zzagt().zzagw();
      localObject1 = paramzzab;
      if (localObject2 != null)
      {
        localObject1 = (Long)((Pair)localObject2).second;
        localObject2 = (String)((Pair)localObject2).first;
        localObject1 = String.valueOf(localObject1);
        localObject1 = String.valueOf(localObject1).length() + 1 + String.valueOf(localObject2).length() + (String)localObject1 + ":" + (String)localObject2;
        localObject2 = new HashMap(paramzzab.zzmc());
        ((Map)localObject2).put("_m", localObject1);
        localObject1 = zzab.zza(this, paramzzab, (Map)localObject2);
      }
    }
  }
  
  public void zzfa(String paramString)
  {
    zzaa.zzib(paramString);
    zzzx();
    zzaby();
    zzmt localzzmt = zzao.zza(zzaca(), paramString);
    if (localzzmt == null) {
      zzd("Parsing failed. Ignoring invalid campaign data", paramString);
    }
    for (;;)
    {
      return;
      String str = zzace().zzags();
      if (paramString.equals(str))
      {
        zzev("Ignoring duplicate install campaign");
      }
      else if (!TextUtils.isEmpty(str))
      {
        zzd("Ignoring multiple install campaigns. original, new", str, paramString);
      }
      else
      {
        zzace().zzff(paramString);
        if (zzace().zzagp().zzz(zzacb().zzafi()))
        {
          zzd("Campaign received too late, ignoring", localzzmt);
        }
        else
        {
          zzb("Received installation campaign", localzzmt);
          paramString = this.dC.zzv(0L).iterator();
          while (paramString.hasNext()) {
            zza((zzh)paramString.next(), localzzmt);
          }
        }
      }
    }
  }
  
  public void zzw(long paramLong)
  {
    com.google.android.gms.analytics.zzi.zzzx();
    zzacj();
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.dG = l;
    zzadp();
  }
  
  protected void zzzy()
  {
    this.dC.initialize();
    this.dD.initialize();
    this.dF.initialize();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */