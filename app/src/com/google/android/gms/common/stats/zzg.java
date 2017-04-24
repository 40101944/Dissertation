package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.internal.zzsi;
import java.util.List;

public class zzg
{
  private static zzg Gn = new zzg();
  private static Boolean Go;
  private static String TAG = "WakeLockTracker";
  
  public static zzg zzayg()
  {
    return Gn;
  }
  
  private static boolean zzcg(Context paramContext)
  {
    if (Go == null) {
      Go = Boolean.valueOf(zzch(paramContext));
    }
    return Go.booleanValue();
  }
  
  private static boolean zzch(Context paramContext)
  {
    bool2 = false;
    for (bool1 = bool2;; bool1 = false)
    {
      try
      {
        if (zzd.zzayi())
        {
          int i = ((Integer)zzb.zzb.FJ.get()).intValue();
          int j = zzc.LOG_LEVEL_OFF;
          if (i == j) {
            continue;
          }
          bool1 = true;
        }
      }
      catch (SecurityException paramContext)
      {
        for (;;)
        {
          bool1 = bool2;
        }
      }
      return bool1;
    }
  }
  
  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList)
  {
    zza(paramContext, paramString1, paramInt1, paramString2, paramString3, paramString4, paramInt2, paramList, 0L);
  }
  
  public void zza(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, List<String> paramList, long paramLong)
  {
    if (!zzcg(paramContext)) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString1))
      {
        paramString2 = TAG;
        paramContext = String.valueOf(paramString1);
        if (paramContext.length() != 0) {}
        for (paramContext = "missing wakeLock key. ".concat(paramContext);; paramContext = new String("missing wakeLock key. "))
        {
          Log.e(paramString2, paramContext);
          break;
        }
      }
      long l = System.currentTimeMillis();
      if ((7 == paramInt1) || (8 == paramInt1) || (10 == paramInt1) || (11 == paramInt1))
      {
        paramString2 = new WakeLockEvent(l, paramInt1, paramString2, paramInt2, zze.zzz(paramList), paramString1, SystemClock.elapsedRealtime(), zzj.zzck(paramContext), paramString3, zze.zzih(paramContext.getPackageName()), zzj.zzcl(paramContext), paramLong, paramString4);
        try
        {
          paramString1 = new android/content/Intent;
          paramString1.<init>();
          paramContext.startService(paramString1.setComponent(zzc.FP).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramString2));
        }
        catch (Exception paramContext)
        {
          Log.wtf(TAG, paramContext);
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\stats\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */