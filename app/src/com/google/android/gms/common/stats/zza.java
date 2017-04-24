package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.internal.zzsi;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zza
{
  private static final Object El = new Object();
  private static Integer FF;
  private static zza Fz;
  private final List<String> FA;
  private final List<String> FB;
  private final List<String> FC;
  private final List<String> FD;
  private zzd FE;
  private zzd FG;
  
  private zza()
  {
    if (zzaxs())
    {
      this.FA = Collections.EMPTY_LIST;
      this.FB = Collections.EMPTY_LIST;
      this.FC = Collections.EMPTY_LIST;
      this.FD = Collections.EMPTY_LIST;
      return;
    }
    Object localObject = (String)zzb.zza.FK.get();
    if (localObject == null)
    {
      localObject = Collections.EMPTY_LIST;
      label58:
      this.FA = ((List)localObject);
      localObject = (String)zzb.zza.FL.get();
      if (localObject != null) {
        break label200;
      }
      localObject = Collections.EMPTY_LIST;
      label81:
      this.FB = ((List)localObject);
      localObject = (String)zzb.zza.FM.get();
      if (localObject != null) {
        break label213;
      }
      localObject = Collections.EMPTY_LIST;
      label104:
      this.FC = ((List)localObject);
      localObject = (String)zzb.zza.FN.get();
      if (localObject != null) {
        break label226;
      }
    }
    label200:
    label213:
    label226:
    for (localObject = Collections.EMPTY_LIST;; localObject = Arrays.asList(((String)localObject).split(",")))
    {
      this.FD = ((List)localObject);
      this.FE = new zzd(1024, ((Long)zzb.zza.FO.get()).longValue());
      this.FG = new zzd(1024, ((Long)zzb.zza.FO.get()).longValue());
      break;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label58;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label81;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label104;
    }
  }
  
  private static int getLogLevel()
  {
    if (FF == null) {}
    for (;;)
    {
      try
      {
        if (!com.google.android.gms.common.util.zzd.zzayi()) {
          continue;
        }
        i = ((Integer)zzb.zza.FJ.get()).intValue();
        FF = Integer.valueOf(i);
      }
      catch (SecurityException localSecurityException)
      {
        int i;
        FF = Integer.valueOf(zzc.LOG_LEVEL_OFF);
        continue;
      }
      return FF.intValue();
      i = zzc.LOG_LEVEL_OFF;
    }
  }
  
  public static zza zzaxr()
  {
    synchronized (El)
    {
      if (Fz == null)
      {
        zza localzza = new com/google/android/gms/common/stats/zza;
        localzza.<init>();
        Fz = localzza;
      }
      return Fz;
    }
  }
  
  private boolean zzaxs()
  {
    if (getLogLevel() == zzc.LOG_LEVEL_OFF) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean zzc(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getComponent();
    if (paramIntent == null) {}
    for (boolean bool = false;; bool = com.google.android.gms.common.util.zzd.zzx(paramContext, paramIntent.getPackageName())) {
      return bool;
    }
  }
  
  @SuppressLint({"UntrackedBindService"})
  public void zza(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
  }
  
  public void zza(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent) {}
  
  public boolean zza(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return zza(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }
  
  @SuppressLint({"UntrackedBindService"})
  public boolean zza(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (zzc(paramContext, paramIntent)) {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
    }
    for (boolean bool = false;; bool = paramContext.bindService(paramIntent, paramServiceConnection, paramInt)) {
      return bool;
    }
  }
  
  public void zzb(Context paramContext, ServiceConnection paramServiceConnection) {}
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\stats\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */