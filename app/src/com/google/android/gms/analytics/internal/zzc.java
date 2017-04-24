package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;

public class zzc
{
  private final zzf cQ;
  
  protected zzc(zzf paramzzf)
  {
    zzaa.zzy(paramzzf);
    this.cQ = paramzzf;
  }
  
  private void zza(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject = null;
    if (this.cQ != null) {
      localObject = this.cQ.zzacm();
    }
    if (localObject != null) {
      ((zzaf)localObject).zza(paramInt, paramString, paramObject1, paramObject2, paramObject3);
    }
    for (;;)
    {
      return;
      localObject = (String)zzy.en.get();
      if (Log.isLoggable((String)localObject, paramInt)) {
        Log.println(paramInt, (String)localObject, zzc(paramString, paramObject1, paramObject2, paramObject3));
      }
    }
  }
  
  protected static String zzc(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str3 = zzk(paramObject1);
    String str2 = zzk(paramObject2);
    paramObject2 = zzk(paramObject3);
    paramObject3 = new StringBuilder();
    paramObject1 = "";
    if (!TextUtils.isEmpty(str1))
    {
      ((StringBuilder)paramObject3).append(str1);
      paramObject1 = ": ";
    }
    paramString = (String)paramObject1;
    if (!TextUtils.isEmpty(str3))
    {
      ((StringBuilder)paramObject3).append((String)paramObject1);
      ((StringBuilder)paramObject3).append(str3);
      paramString = ", ";
    }
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str2))
    {
      ((StringBuilder)paramObject3).append(paramString);
      ((StringBuilder)paramObject3).append(str2);
      paramObject1 = ", ";
    }
    if (!TextUtils.isEmpty((CharSequence)paramObject2))
    {
      ((StringBuilder)paramObject3).append((String)paramObject1);
      ((StringBuilder)paramObject3).append((String)paramObject2);
    }
    return ((StringBuilder)paramObject3).toString();
  }
  
  private static String zzk(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = "";
    }
    for (;;)
    {
      return (String)paramObject;
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
      }
      else
      {
        if ((paramObject instanceof Boolean))
        {
          if (paramObject == Boolean.TRUE) {}
          for (paramObject = "true";; paramObject = "false") {
            break;
          }
        }
        if ((paramObject instanceof Throwable)) {
          paramObject = ((Throwable)paramObject).toString();
        } else {
          paramObject = paramObject.toString();
        }
      }
    }
  }
  
  protected Context getContext()
  {
    return this.cQ.getContext();
  }
  
  public void zza(String paramString, Object paramObject)
  {
    zza(2, paramString, paramObject, null, null);
  }
  
  public void zza(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(2, paramString, paramObject1, paramObject2, null);
  }
  
  public void zza(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zza(3, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public zzf zzabx()
  {
    return this.cQ;
  }
  
  protected void zzaby()
  {
    zzacb();
  }
  
  protected zze zzabz()
  {
    return this.cQ.zzabz();
  }
  
  protected zzaf zzaca()
  {
    return this.cQ.zzaca();
  }
  
  protected zzr zzacb()
  {
    return this.cQ.zzacb();
  }
  
  protected zzi zzacc()
  {
    return this.cQ.zzacc();
  }
  
  protected zzv zzacd()
  {
    return this.cQ.zzacd();
  }
  
  protected zzai zzace()
  {
    return this.cQ.zzace();
  }
  
  protected zzn zzacf()
  {
    return this.cQ.zzacq();
  }
  
  protected zza zzacg()
  {
    return this.cQ.zzacp();
  }
  
  protected zzk zzach()
  {
    return this.cQ.zzach();
  }
  
  protected zzu zzaci()
  {
    return this.cQ.zzaci();
  }
  
  public void zzb(String paramString, Object paramObject)
  {
    zza(3, paramString, paramObject, null, null);
  }
  
  public void zzb(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(3, paramString, paramObject1, paramObject2, null);
  }
  
  public void zzb(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zza(5, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public void zzc(String paramString, Object paramObject)
  {
    zza(4, paramString, paramObject, null, null);
  }
  
  public void zzc(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(5, paramString, paramObject1, paramObject2, null);
  }
  
  public void zzd(String paramString, Object paramObject)
  {
    zza(5, paramString, paramObject, null, null);
  }
  
  public void zzd(String paramString, Object paramObject1, Object paramObject2)
  {
    zza(6, paramString, paramObject1, paramObject2, null);
  }
  
  public void zze(String paramString, Object paramObject)
  {
    zza(6, paramString, paramObject, null, null);
  }
  
  public void zzes(String paramString)
  {
    zza(2, paramString, null, null, null);
  }
  
  public void zzet(String paramString)
  {
    zza(3, paramString, null, null, null);
  }
  
  public void zzeu(String paramString)
  {
    zza(4, paramString, null, null, null);
  }
  
  public void zzev(String paramString)
  {
    zza(5, paramString, null, null, null);
  }
  
  public void zzew(String paramString)
  {
    zza(6, paramString, null, null, null);
  }
  
  public boolean zzvo()
  {
    return Log.isLoggable((String)zzy.en.get(), 2);
  }
  
  public GoogleAnalytics zzza()
  {
    return this.cQ.zzacn();
  }
  
  protected zzb zzzg()
  {
    return this.cQ.zzzg();
  }
  
  protected zzap zzzh()
  {
    return this.cQ.zzzh();
  }
  
  protected void zzzx()
  {
    this.cQ.zzzx();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */