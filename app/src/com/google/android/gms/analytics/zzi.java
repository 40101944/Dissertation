package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzms;
import com.google.android.gms.internal.zzmx;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzi
{
  private static volatile zzi bj;
  private final List<zzj> bk;
  private final zzd bl;
  private final zza bm;
  private volatile zzms bn;
  private Thread.UncaughtExceptionHandler bo;
  private final Context mContext;
  
  zzi(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    zzaa.zzy(paramContext);
    this.mContext = paramContext;
    this.bm = new zza();
    this.bk = new CopyOnWriteArrayList();
    this.bl = new zzd();
  }
  
  public static zzi zzav(Context paramContext)
  {
    zzaa.zzy(paramContext);
    if (bj == null) {}
    try
    {
      if (bj == null)
      {
        zzi localzzi = new com/google/android/gms/analytics/zzi;
        localzzi.<init>(paramContext);
        bj = localzzi;
      }
      return bj;
    }
    finally {}
  }
  
  private void zzb(zze paramzze)
  {
    zzaa.zzht("deliver should be called from worker thread");
    zzaa.zzb(paramzze.zzzn(), "Measurement must be submitted");
    Object localObject = paramzze.zzzk();
    if (((List)localObject).isEmpty()) {}
    for (;;)
    {
      return;
      HashSet localHashSet = new HashSet();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        zzk localzzk = (zzk)localIterator.next();
        localObject = localzzk.zzyx();
        if (!localHashSet.contains(localObject))
        {
          localHashSet.add(localObject);
          localzzk.zzb(paramzze);
        }
      }
    }
  }
  
  public static void zzzx()
  {
    if (!(Thread.currentThread() instanceof zzc)) {
      throw new IllegalStateException("Call expected from worker thread");
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public void zza(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.bo = paramUncaughtExceptionHandler;
  }
  
  public <V> Future<V> zzc(Callable<V> paramCallable)
  {
    zzaa.zzy(paramCallable);
    if ((Thread.currentThread() instanceof zzc))
    {
      paramCallable = new FutureTask(paramCallable);
      paramCallable.run();
    }
    for (;;)
    {
      return paramCallable;
      paramCallable = this.bm.submit(paramCallable);
    }
  }
  
  void zze(final zze paramzze)
  {
    if (paramzze.zzzr()) {
      throw new IllegalStateException("Measurement prototype can't be submitted");
    }
    if (paramzze.zzzn()) {
      throw new IllegalStateException("Measurement can only be submitted once");
    }
    paramzze = paramzze.zzzi();
    paramzze.zzzo();
    this.bm.execute(new Runnable()
    {
      public void run()
      {
        paramzze.zzzp().zza(paramzze);
        Iterator localIterator = zzi.zza(zzi.this).iterator();
        while (localIterator.hasNext()) {
          ((zzj)localIterator.next()).zza(paramzze);
        }
        zzi.zza(zzi.this, paramzze);
      }
    });
  }
  
  public void zzg(Runnable paramRunnable)
  {
    zzaa.zzy(paramRunnable);
    this.bm.submit(paramRunnable);
  }
  
  public zzms zzzv()
  {
    if (this.bn == null) {}
    label205:
    for (;;)
    {
      try
      {
        zzms localzzms;
        PackageManager localPackageManager;
        String str3;
        Object localObject5;
        Object localObject3;
        if (this.bn == null)
        {
          localzzms = new com/google/android/gms/internal/zzms;
          localzzms.<init>();
          localPackageManager = this.mContext.getPackageManager();
          str3 = this.mContext.getPackageName();
          localzzms.setAppId(str3);
          localzzms.setAppInstallerId(localPackageManager.getInstallerPackageName(str3));
          localObject5 = null;
          localObject3 = str3;
        }
        try
        {
          PackageInfo localPackageInfo = localPackageManager.getPackageInfo(this.mContext.getPackageName(), 0);
          localObject4 = localObject5;
          String str1 = str3;
          if (localPackageInfo != null)
          {
            localObject3 = str3;
            localObject4 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo);
            str1 = str3;
            localObject3 = str3;
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              localObject3 = str3;
              str1 = ((CharSequence)localObject4).toString();
            }
            localObject3 = str1;
            localObject4 = localPackageInfo.versionName;
          }
          localzzms.setAppName(str1);
          localzzms.setAppVersion((String)localObject4);
          this.bn = localzzms;
          return this.bn;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localObject1 = String.valueOf(localObject3);
          if (((String)localObject1).length() == 0) {
            break label205;
          }
        }
        Object localObject1 = "Error retrieving package info: appName set to ".concat((String)localObject1);
        Log.e("GAv4", (String)localObject1);
        Object localObject4 = localObject5;
        localObject1 = localObject3;
        continue;
        String str2 = new String("Error retrieving package info: appName set to ");
      }
      finally {}
    }
  }
  
  public zzmx zzzw()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    zzmx localzzmx = new zzmx();
    localzzmx.setLanguage(zzao.zza(Locale.getDefault()));
    localzzmx.zzbz(localDisplayMetrics.widthPixels);
    localzzmx.zzca(localDisplayMetrics.heightPixels);
    return localzzmx;
  }
  
  private class zza
    extends ThreadPoolExecutor
  {
    public zza()
    {
      super(1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
      setThreadFactory(new zzi.zzb(null));
      allowCoreThreadTimeOut(true);
    }
    
    protected <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT)
    {
      new FutureTask(paramRunnable, paramT)
      {
        protected void setException(Throwable paramAnonymousThrowable)
        {
          Object localObject = zzi.zzb(zzi.this);
          if (localObject != null) {
            ((Thread.UncaughtExceptionHandler)localObject).uncaughtException(Thread.currentThread(), paramAnonymousThrowable);
          }
          for (;;)
          {
            super.setException(paramAnonymousThrowable);
            return;
            if (Log.isLoggable("GAv4", 6))
            {
              localObject = String.valueOf(paramAnonymousThrowable);
              Log.e("GAv4", String.valueOf(localObject).length() + 37 + "MeasurementExecutor: job failed with " + (String)localObject);
            }
          }
        }
      };
    }
  }
  
  private static class zzb
    implements ThreadFactory
  {
    private static final AtomicInteger bs = new AtomicInteger();
    
    public Thread newThread(Runnable paramRunnable)
    {
      int i = bs.incrementAndGet();
      return new zzi.zzc(paramRunnable, 23 + "measurement-" + i);
    }
  }
  
  private static class zzc
    extends Thread
  {
    zzc(Runnable paramRunnable, String paramString)
    {
      super(paramString);
    }
    
    public void run()
    {
      Process.setThreadPriority(10);
      super.run();
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */