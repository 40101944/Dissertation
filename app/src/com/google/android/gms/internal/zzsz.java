package com.google.android.gms.internal;

import android.content.Context;

public class zzsz
{
  private static zzsz GQ = new zzsz();
  private zzsy GP = null;
  
  public static zzsy zzco(Context paramContext)
  {
    return GQ.zzcn(paramContext);
  }
  
  /* Error */
  public zzsy zzcn(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/google/android/gms/internal/zzsz:GP	Lcom/google/android/gms/internal/zzsy;
    //   6: ifnonnull +24 -> 30
    //   9: aload_1
    //   10: invokevirtual 30	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   13: ifnonnull +26 -> 39
    //   16: new 32	com/google/android/gms/internal/zzsy
    //   19: astore_2
    //   20: aload_2
    //   21: aload_1
    //   22: invokespecial 35	com/google/android/gms/internal/zzsy:<init>	(Landroid/content/Context;)V
    //   25: aload_0
    //   26: aload_2
    //   27: putfield 19	com/google/android/gms/internal/zzsz:GP	Lcom/google/android/gms/internal/zzsy;
    //   30: aload_0
    //   31: getfield 19	com/google/android/gms/internal/zzsz:GP	Lcom/google/android/gms/internal/zzsy;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aload_1
    //   40: invokevirtual 30	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   43: astore_1
    //   44: goto -28 -> 16
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	zzsz
    //   0	52	1	paramContext	Context
    //   19	8	2	localzzsy	zzsy
    // Exception table:
    //   from	to	target	type
    //   2	16	47	finally
    //   16	30	47	finally
    //   30	35	47	finally
    //   39	44	47	finally
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzsz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */