package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzaa;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzb
  extends zzd
{
  private final zzl cI;
  
  public zzb(zzf paramzzf, zzg paramzzg)
  {
    super(paramzzf);
    zzaa.zzy(paramzzg);
    this.cI = paramzzg.zzj(paramzzf);
  }
  
  void onServiceConnected()
  {
    zzzx();
    this.cI.onServiceConnected();
  }
  
  public void setLocalDispatchPeriod(final int paramInt)
  {
    zzacj();
    zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(paramInt));
    zzacc().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzw(paramInt * 1000L);
      }
    });
  }
  
  public void start()
  {
    this.cI.start();
  }
  
  public long zza(zzh paramzzh)
  {
    zzacj();
    zzaa.zzy(paramzzh);
    zzzx();
    long l = this.cI.zza(paramzzh, true);
    if (l == 0L) {
      this.cI.zzc(paramzzh);
    }
    return l;
  }
  
  public void zza(final zzab paramzzab)
  {
    zzaa.zzy(paramzzab);
    zzacj();
    zzb("Hit delivery requested", paramzzab);
    zzacc().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zza(paramzzab);
      }
    });
  }
  
  public void zza(final zzw paramzzw)
  {
    zzacj();
    zzacc().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzb(paramzzw);
      }
    });
  }
  
  public void zza(final String paramString, final Runnable paramRunnable)
  {
    zzaa.zzh(paramString, "campaign param can't be empty");
    zzacc().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzfa(paramString);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    });
  }
  
  public void zzabr()
  {
    zzacj();
    zzaby();
    zzacc().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzabr();
      }
    });
  }
  
  public void zzabs()
  {
    zzacj();
    Context localContext = getContext();
    if ((zzaj.zzat(localContext)) && (zzak.zzau(localContext)))
    {
      Intent localIntent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
      localIntent.setComponent(new ComponentName(localContext, "com.google.android.gms.analytics.AnalyticsService"));
      localContext.startService(localIntent);
    }
    for (;;)
    {
      return;
      zza(null);
    }
  }
  
  public boolean zzabt()
  {
    boolean bool = false;
    zzacj();
    Future localFuture = zzacc().zzc(new Callable()
    {
      public Void zzdo()
        throws Exception
      {
        zzb.zza(zzb.this).zzado();
        return null;
      }
    });
    try
    {
      localFuture.get(4L, TimeUnit.SECONDS);
      bool = true;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        zzd("syncDispatchLocalHits interrupted", localInterruptedException);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        zze("syncDispatchLocalHits failed", localExecutionException);
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      for (;;)
      {
        zzd("syncDispatchLocalHits timed out", localTimeoutException);
      }
    }
    return bool;
  }
  
  public void zzabu()
  {
    zzacj();
    zzi.zzzx();
    this.cI.zzabu();
  }
  
  public void zzabv()
  {
    zzes("Radio powered up");
    zzabs();
  }
  
  void zzabw()
  {
    zzzx();
    this.cI.zzabw();
  }
  
  public void zzaw(final boolean paramBoolean)
  {
    zza("Network connectivity status changed", Boolean.valueOf(paramBoolean));
    zzacc().zzg(new Runnable()
    {
      public void run()
      {
        zzb.zza(zzb.this).zzaw(paramBoolean);
      }
    });
  }
  
  protected void zzzy()
  {
    this.cI.initialize();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */