package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.zzaa;
import java.util.Random;

public class zzq
{
  private final String aDY;
  private final Context mContext;
  private final Random zzbao;
  
  public zzq(Context paramContext, String paramString)
  {
    this(paramContext, paramString, new Random());
  }
  
  @VisibleForTesting
  zzq(Context paramContext, String paramString, Random paramRandom)
  {
    this.mContext = ((Context)zzaa.zzy(paramContext));
    this.aDY = ((String)zzaa.zzy(paramString));
    this.zzbao = paramRandom;
  }
  
  private SharedPreferences zzceo()
  {
    Context localContext = this.mContext;
    String str1 = String.valueOf("_gtmContainerRefreshPolicy_");
    String str2 = String.valueOf(this.aDY);
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1)) {
      return localContext.getSharedPreferences(str1, 0);
    }
  }
  
  private long zzg(long paramLong1, long paramLong2)
  {
    SharedPreferences localSharedPreferences = zzceo();
    long l1 = Math.max(0L, localSharedPreferences.getLong("FORBIDDEN_COUNT", 0L));
    long l2 = Math.max(0L, localSharedPreferences.getLong("SUCCESSFUL_COUNT", 0L));
    paramLong2 = ((float)l1 / (float)(l2 + l1 + 1L) * (float)(paramLong2 - paramLong1));
    float f = this.zzbao.nextFloat();
    return ((float)(paramLong2 + paramLong1) * f);
  }
  
  public long zzcek()
  {
    return 43200000L + zzg(7200000L, 259200000L);
  }
  
  public long zzcel()
  {
    return 3600000L + zzg(600000L, 86400000L);
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void zzcem()
  {
    Object localObject = zzceo();
    long l1 = ((SharedPreferences)localObject).getLong("FORBIDDEN_COUNT", 0L);
    long l2 = ((SharedPreferences)localObject).getLong("SUCCESSFUL_COUNT", 0L);
    localObject = ((SharedPreferences)localObject).edit();
    if (l1 == 0L) {}
    for (l1 = 3L;; l1 = Math.min(10L, 1L + l1))
    {
      l2 = Math.max(0L, Math.min(l2, 10L - l1));
      ((SharedPreferences.Editor)localObject).putLong("FORBIDDEN_COUNT", l1);
      ((SharedPreferences.Editor)localObject).putLong("SUCCESSFUL_COUNT", l2);
      zzdd.zza((SharedPreferences.Editor)localObject);
      return;
    }
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void zzcen()
  {
    Object localObject = zzceo();
    long l1 = ((SharedPreferences)localObject).getLong("SUCCESSFUL_COUNT", 0L);
    long l2 = ((SharedPreferences)localObject).getLong("FORBIDDEN_COUNT", 0L);
    l1 = Math.min(10L, l1 + 1L);
    l2 = Math.max(0L, Math.min(l2, 10L - l1));
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("SUCCESSFUL_COUNT", l1);
    ((SharedPreferences.Editor)localObject).putLong("FORBIDDEN_COUNT", l2);
    zzdd.zza((SharedPreferences.Editor)localObject);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */