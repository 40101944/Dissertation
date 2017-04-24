package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzdc
  extends zzdb
{
  private static final Object aHk = new Object();
  private static zzdc aHw;
  private Context aHl;
  private zzaw aHm;
  private volatile zzau aHn;
  private int aHo = 1800000;
  private boolean aHp = true;
  private boolean aHq = false;
  private boolean aHr = true;
  private zzax aHs = new zzax()
  {
    public void zzcn(boolean paramAnonymousBoolean)
    {
      zzdc.this.zze(paramAnonymousBoolean, zzdc.zzd(zzdc.this));
    }
  };
  private zza aHt;
  private zzbt aHu;
  private boolean aHv = false;
  private boolean connected = true;
  
  private boolean isPowerSaveMode()
  {
    if ((this.aHv) || (!this.connected) || (this.aHo <= 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void zzadp()
  {
    if (isPowerSaveMode())
    {
      this.aHt.cancel();
      zzbo.v("PowerSaveMode initiated.");
    }
    for (;;)
    {
      return;
      this.aHt.zzx(this.aHo);
      zzbo.v("PowerSaveMode terminated.");
    }
  }
  
  public static zzdc zzcgt()
  {
    if (aHw == null) {
      aHw = new zzdc();
    }
    return aHw;
  }
  
  private void zzcgu()
  {
    this.aHu = new zzbt(this);
    this.aHu.zzef(this.aHl);
  }
  
  private void zzcgv()
  {
    this.aHt = new zzb(null);
    if (this.aHo > 0) {
      this.aHt.zzx(this.aHo);
    }
  }
  
  /* Error */
  public void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/google/android/gms/tagmanager/zzdc:aHq	Z
    //   6: ifne +16 -> 22
    //   9: ldc -126
    //   11: invokestatic 90	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 56	com/google/android/gms/tagmanager/zzdc:aHp	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 132	com/google/android/gms/tagmanager/zzdc:aHn	Lcom/google/android/gms/tagmanager/zzau;
    //   26: astore_1
    //   27: new 8	com/google/android/gms/tagmanager/zzdc$2
    //   30: astore_2
    //   31: aload_2
    //   32: aload_0
    //   33: invokespecial 133	com/google/android/gms/tagmanager/zzdc$2:<init>	(Lcom/google/android/gms/tagmanager/zzdc;)V
    //   36: aload_1
    //   37: aload_2
    //   38: invokeinterface 139 2 0
    //   43: goto -24 -> 19
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	zzdc
    //   26	11	1	localzzau	zzau
    //   46	4	1	localObject	Object
    //   30	8	2	local2	2
    // Exception table:
    //   from	to	target	type
    //   2	19	46	finally
    //   22	43	46	finally
  }
  
  /* Error */
  void zza(Context paramContext, zzau paramzzau)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	com/google/android/gms/tagmanager/zzdc:aHl	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 146	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 74	com/google/android/gms/tagmanager/zzdc:aHl	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 132	com/google/android/gms/tagmanager/zzdc:aHn	Lcom/google/android/gms/tagmanager/zzau;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 132	com/google/android/gms/tagmanager/zzdc:aHn	Lcom/google/android/gms/tagmanager/zzau;
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	zzdc
    //   0	42	1	paramContext	Context
    //   0	42	2	paramzzau	zzau
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   14	34	37	finally
  }
  
  public void zzabv()
  {
    try
    {
      if (!isPowerSaveMode()) {
        this.aHt.zzcgy();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  zzaw zzcgw()
  {
    try
    {
      if (this.aHm != null) {
        break label54;
      }
      if (this.aHl == null)
      {
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        localIllegalStateException.<init>("Cant get a store unless we have a context");
        throw localIllegalStateException;
      }
    }
    finally {}
    Object localObject2 = new com/google/android/gms/tagmanager/zzcg;
    ((zzcg)localObject2).<init>(this.aHs, this.aHl);
    this.aHm = ((zzaw)localObject2);
    label54:
    if (this.aHt == null) {
      zzcgv();
    }
    this.aHq = true;
    if (this.aHp)
    {
      dispatch();
      this.aHp = false;
    }
    if ((this.aHu == null) && (this.aHr)) {
      zzcgu();
    }
    localObject2 = this.aHm;
    return (zzaw)localObject2;
  }
  
  public void zzco(boolean paramBoolean)
  {
    try
    {
      zze(this.aHv, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  void zze(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 77	com/google/android/gms/tagmanager/zzdc:isPowerSaveMode	()Z
    //   6: istore_3
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 69	com/google/android/gms/tagmanager/zzdc:aHv	Z
    //   12: aload_0
    //   13: iload_2
    //   14: putfield 60	com/google/android/gms/tagmanager/zzdc:connected	Z
    //   17: aload_0
    //   18: invokespecial 77	com/google/android/gms/tagmanager/zzdc:isPowerSaveMode	()Z
    //   21: istore_1
    //   22: iload_1
    //   23: iload_3
    //   24: if_icmpne +6 -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: invokespecial 176	com/google/android/gms/tagmanager/zzdc:zzadp	()V
    //   34: goto -7 -> 27
    //   37: astore 4
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 4
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	zzdc
    //   0	44	1	paramBoolean1	boolean
    //   0	44	2	paramBoolean2	boolean
    //   6	19	3	bool	boolean
    //   37	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	37	finally
    //   30	34	37	finally
  }
  
  public static abstract interface zza
  {
    public abstract void cancel();
    
    public abstract void zzcgy();
    
    public abstract void zzx(long paramLong);
  }
  
  private class zzb
    implements zzdc.zza
  {
    private Handler handler = new Handler(zzdc.zza(zzdc.this).getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (zzdc.zzcgx().equals(paramAnonymousMessage.obj)))
        {
          zzdc.this.dispatch();
          if (!zzdc.zzb(zzdc.this)) {
            zzdc.zzb.this.zzx(zzdc.zzc(zzdc.this));
          }
        }
        return true;
      }
    });
    
    private zzb() {}
    
    private Message obtainMessage()
    {
      return this.handler.obtainMessage(1, zzdc.zzcgx());
    }
    
    public void cancel()
    {
      this.handler.removeMessages(1, zzdc.zzcgx());
    }
    
    public void zzcgy()
    {
      this.handler.removeMessages(1, zzdc.zzcgx());
      this.handler.sendMessage(obtainMessage());
    }
    
    public void zzx(long paramLong)
    {
      this.handler.removeMessages(1, zzdc.zzcgx());
      this.handler.sendMessageDelayed(obtainMessage(), paramLong);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */