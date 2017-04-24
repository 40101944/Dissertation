package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzav
  extends Thread
  implements zzau
{
  private static zzav aFv;
  private final LinkedBlockingQueue<Runnable> aFu = new LinkedBlockingQueue();
  private volatile zzaw aFw;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private volatile boolean zzcbf = false;
  
  private zzav(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (this.mContext = paramContext.getApplicationContext();; this.mContext = paramContext)
    {
      start();
      return;
    }
  }
  
  static zzav zzee(Context paramContext)
  {
    if (aFv == null) {
      aFv = new zzav(paramContext);
    }
    return aFv;
  }
  
  private String zzg(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  public void run()
  {
    for (;;)
    {
      if (!this.mClosed) {
        try
        {
          Runnable localRunnable = (Runnable)this.aFu.take();
          if (!this.zzcbf) {
            localRunnable.run();
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          zzbo.zzdh(localInterruptedException.toString());
        }
        catch (Throwable localThrowable)
        {
          String str = String.valueOf(zzg(localThrowable));
          if (str.length() != 0) {}
          for (str = "Error on Google TagManager Thread: ".concat(str);; str = new String("Error on Google TagManager Thread: "))
          {
            zzbo.e(str);
            zzbo.e("Google TagManager is shutting down.");
            this.zzcbf = true;
            break;
          }
        }
      }
    }
  }
  
  void zzl(String paramString, final long paramLong)
  {
    zzp(new Runnable()
    {
      public void run()
      {
        if (zzav.zza(zzav.this) == null)
        {
          zzdc localzzdc = zzdc.zzcgt();
          localzzdc.zza(zzav.zzb(zzav.this), jdField_this);
          zzav.zza(zzav.this, localzzdc.zzcgw());
        }
        zzav.zza(zzav.this).zzg(paramLong, this.zzall);
      }
    });
  }
  
  public void zzp(Runnable paramRunnable)
  {
    this.aFu.add(paramRunnable);
  }
  
  public void zzpk(String paramString)
  {
    zzl(paramString, System.currentTimeMillis());
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */