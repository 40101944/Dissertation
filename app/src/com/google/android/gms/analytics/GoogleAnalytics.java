package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzap;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.analytics.internal.zzy.zza;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics
  extends zza
{
  private static List<Runnable> aH = new ArrayList();
  private Set<zza> aI = new HashSet();
  private boolean aJ;
  private boolean aK;
  private volatile boolean aL;
  private boolean aM;
  private boolean zzaoz;
  
  public GoogleAnalytics(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    return zzf.zzaw(paramContext).zzacn();
  }
  
  public static void zzzd()
  {
    try
    {
      if (aH != null)
      {
        Iterator localIterator = aH.iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
        aH = null;
      }
    }
    finally {}
  }
  
  private zzb zzzg()
  {
    return zzyt().zzzg();
  }
  
  private zzap zzzh()
  {
    return zzyt().zzzh();
  }
  
  public void dispatchLocalHits()
  {
    zzzg().zzabs();
  }
  
  @TargetApi(14)
  public void enableAutoActivityReports(Application paramApplication)
  {
    if ((Build.VERSION.SDK_INT >= 14) && (!this.aJ))
    {
      paramApplication.registerActivityLifecycleCallbacks(new zzb());
      this.aJ = true;
    }
  }
  
  public boolean getAppOptOut()
  {
    return this.aL;
  }
  
  @Deprecated
  public Logger getLogger()
  {
    return zzae.getLogger();
  }
  
  public void initialize()
  {
    zzzc();
    this.zzaoz = true;
  }
  
  public boolean isDryRunEnabled()
  {
    return this.aK;
  }
  
  public boolean isInitialized()
  {
    if (this.zzaoz) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Tracker newTracker(int paramInt)
  {
    try
    {
      Tracker localTracker = new com/google/android/gms/analytics/Tracker;
      localTracker.<init>(zzyt(), null, null);
      if (paramInt > 0)
      {
        Object localObject2 = new com/google/android/gms/analytics/internal/zzam;
        ((zzam)localObject2).<init>(zzyt());
        localObject2 = (zzan)((zzam)localObject2).zzcg(paramInt);
        if (localObject2 != null) {
          localTracker.zza((zzan)localObject2);
        }
      }
      localTracker.initialize();
      return localTracker;
    }
    finally {}
  }
  
  public Tracker newTracker(String paramString)
  {
    try
    {
      Tracker localTracker = new com/google/android/gms/analytics/Tracker;
      localTracker.<init>(zzyt(), paramString, null);
      localTracker.initialize();
      return localTracker;
    }
    finally {}
  }
  
  public void reportActivityStart(Activity paramActivity)
  {
    if (!this.aJ) {
      zzm(paramActivity);
    }
  }
  
  public void reportActivityStop(Activity paramActivity)
  {
    if (!this.aJ) {
      zzn(paramActivity);
    }
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    this.aL = paramBoolean;
    if (this.aL) {
      zzzg().zzabr();
    }
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    this.aK = paramBoolean;
  }
  
  public void setLocalDispatchPeriod(int paramInt)
  {
    zzzg().setLocalDispatchPeriod(paramInt);
  }
  
  @Deprecated
  public void setLogger(Logger paramLogger)
  {
    zzae.setLogger(paramLogger);
    if (!this.aM)
    {
      String str = (String)zzy.en.get();
      paramLogger = (String)zzy.en.get();
      Log.i(str, String.valueOf(paramLogger).length() + 112 + "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + paramLogger + " DEBUG");
      this.aM = true;
    }
  }
  
  void zza(zza paramzza)
  {
    this.aI.add(paramzza);
    paramzza = zzyt().getContext();
    if ((paramzza instanceof Application)) {
      enableAutoActivityReports((Application)paramzza);
    }
  }
  
  void zzb(zza paramzza)
  {
    this.aI.remove(paramzza);
  }
  
  void zzm(Activity paramActivity)
  {
    Iterator localIterator = this.aI.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzo(paramActivity);
    }
  }
  
  void zzn(Activity paramActivity)
  {
    Iterator localIterator = this.aI.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzp(paramActivity);
    }
  }
  
  void zzzc()
  {
    zzap localzzap = zzzh();
    if (localzzap.zzafs()) {
      getLogger().setLogLevel(localzzap.getLogLevel());
    }
    if (localzzap.zzafw()) {
      setDryRun(localzzap.zzafx());
    }
    if (localzzap.zzafs())
    {
      Logger localLogger = zzae.getLogger();
      if (localLogger != null) {
        localLogger.setLogLevel(localzzap.getLogLevel());
      }
    }
  }
  
  public String zzze()
  {
    zzaa.zzht("getClientId can not be called from the main thread");
    return zzyt().zzacq().zzady();
  }
  
  void zzzf()
  {
    zzzg().zzabt();
  }
  
  static abstract interface zza
  {
    public abstract void zzo(Activity paramActivity);
    
    public abstract void zzp(Activity paramActivity);
  }
  
  @TargetApi(14)
  class zzb
    implements Application.ActivityLifecycleCallbacks
  {
    zzb() {}
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity) {}
    
    public void onActivityPaused(Activity paramActivity) {}
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      GoogleAnalytics.this.zzm(paramActivity);
    }
    
    public void onActivityStopped(Activity paramActivity)
    {
      GoogleAnalytics.this.zzn(paramActivity);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\GoogleAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */