package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.stats.zza;
import java.util.Collections;
import java.util.List;

public class zzi
  extends zzd
{
  private final zza dn;
  private zzac jdField_do;
  private final zzt dp;
  private zzal dq;
  
  protected zzi(zzf paramzzf)
  {
    super(paramzzf);
    this.dq = new zzal(paramzzf.zzabz());
    this.dn = new zza();
    this.dp = new zzt(paramzzf)
    {
      public void run()
      {
        zzi.zzb(zzi.this);
      }
    };
  }
  
  private void onDisconnect()
  {
    zzzg().zzabu();
  }
  
  private void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzzx();
    if (this.jdField_do != null)
    {
      this.jdField_do = null;
      zza("Disconnected from device AnalyticsService", paramComponentName);
      onDisconnect();
    }
  }
  
  private void zza(zzac paramzzac)
  {
    zzzx();
    this.jdField_do = paramzzac;
    zzacw();
    zzzg().onServiceConnected();
  }
  
  private void zzacw()
  {
    this.dq.start();
    this.dp.zzx(zzacb().zzaez());
  }
  
  private void zzacx()
  {
    zzzx();
    if (!isConnected()) {}
    for (;;)
    {
      return;
      zzes("Inactivity, disconnecting from device AnalyticsService");
      disconnect();
    }
  }
  
  public boolean connect()
  {
    boolean bool = true;
    zzzx();
    zzacj();
    if (this.jdField_do != null) {}
    for (;;)
    {
      return bool;
      zzac localzzac = this.dn.zzacy();
      if (localzzac != null)
      {
        this.jdField_do = localzzac;
        zzacw();
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void disconnect()
  {
    zzzx();
    zzacj();
    try
    {
      zza.zzaxr().zza(getContext(), this.dn);
      if (this.jdField_do != null)
      {
        this.jdField_do = null;
        onDisconnect();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
  
  public boolean isConnected()
  {
    zzzx();
    zzacj();
    if (this.jdField_do != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean zzacv()
  {
    boolean bool = false;
    zzzx();
    zzacj();
    zzac localzzac = this.jdField_do;
    if (localzzac == null) {}
    for (;;)
    {
      return bool;
      try
      {
        localzzac.zzabr();
        zzacw();
        bool = true;
      }
      catch (RemoteException localRemoteException)
      {
        zzes("Failed to clear hits from AnalyticsService");
      }
    }
  }
  
  public boolean zzb(zzab paramzzab)
  {
    zzaa.zzy(paramzzab);
    zzzx();
    zzacj();
    zzac localzzac = this.jdField_do;
    boolean bool;
    if (localzzac == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (paramzzab.zzagc()) {}
      for (String str = zzacb().zzaes();; str = zzacb().zzaet())
      {
        List localList = Collections.emptyList();
        try
        {
          localzzac.zza(paramzzab.zzmc(), paramzzab.zzaga(), str, localList);
          zzacw();
          bool = true;
        }
        catch (RemoteException paramzzab)
        {
          zzes("Failed to send hits to AnalyticsService");
          bool = false;
        }
      }
    }
  }
  
  protected void zzzy() {}
  
  protected class zza
    implements ServiceConnection
  {
    private volatile zzac ds;
    private volatile boolean dt;
    
    protected zza() {}
    
    /* Error */
    public void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
    {
      // Byte code:
      //   0: ldc 35
      //   2: invokestatic 41	com/google/android/gms/common/internal/zzaa:zzhs	(Ljava/lang/String;)V
      //   5: aload_0
      //   6: monitorenter
      //   7: aload_2
      //   8: ifnonnull +19 -> 27
      //   11: aload_0
      //   12: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   15: ldc 43
      //   17: invokevirtual 46	com/google/android/gms/analytics/internal/zzi:zzew	(Ljava/lang/String;)V
      //   20: aload_0
      //   21: invokevirtual 49	java/lang/Object:notifyAll	()V
      //   24: aload_0
      //   25: monitorexit
      //   26: return
      //   27: aconst_null
      //   28: astore 4
      //   30: aconst_null
      //   31: astore_3
      //   32: aload 4
      //   34: astore_1
      //   35: aload_2
      //   36: invokeinterface 55 1 0
      //   41: astore 5
      //   43: aload 4
      //   45: astore_1
      //   46: ldc 57
      //   48: aload 5
      //   50: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   53: ifeq +62 -> 115
      //   56: aload 4
      //   58: astore_1
      //   59: aload_2
      //   60: invokestatic 69	com/google/android/gms/analytics/internal/zzac$zza:zzbm	(Landroid/os/IBinder;)Lcom/google/android/gms/analytics/internal/zzac;
      //   63: astore_2
      //   64: aload_2
      //   65: astore_1
      //   66: aload_0
      //   67: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   70: ldc 71
      //   72: invokevirtual 74	com/google/android/gms/analytics/internal/zzi:zzes	(Ljava/lang/String;)V
      //   75: aload_2
      //   76: astore_1
      //   77: aload_1
      //   78: ifnonnull +76 -> 154
      //   81: invokestatic 80	com/google/android/gms/common/stats/zza:zzaxr	()Lcom/google/android/gms/common/stats/zza;
      //   84: aload_0
      //   85: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   88: invokevirtual 84	com/google/android/gms/analytics/internal/zzi:getContext	()Landroid/content/Context;
      //   91: aload_0
      //   92: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   95: invokestatic 87	com/google/android/gms/analytics/internal/zzi:zza	(Lcom/google/android/gms/analytics/internal/zzi;)Lcom/google/android/gms/analytics/internal/zzi$zza;
      //   98: invokevirtual 90	com/google/android/gms/common/stats/zza:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
      //   101: aload_0
      //   102: invokevirtual 49	java/lang/Object:notifyAll	()V
      //   105: aload_0
      //   106: monitorexit
      //   107: goto -81 -> 26
      //   110: astore_1
      //   111: aload_0
      //   112: monitorexit
      //   113: aload_1
      //   114: athrow
      //   115: aload 4
      //   117: astore_1
      //   118: aload_0
      //   119: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   122: ldc 92
      //   124: aload 5
      //   126: invokevirtual 96	com/google/android/gms/analytics/internal/zzi:zze	(Ljava/lang/String;Ljava/lang/Object;)V
      //   129: aload_3
      //   130: astore_1
      //   131: goto -54 -> 77
      //   134: astore_2
      //   135: aload_0
      //   136: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   139: ldc 98
      //   141: invokevirtual 46	com/google/android/gms/analytics/internal/zzi:zzew	(Ljava/lang/String;)V
      //   144: goto -67 -> 77
      //   147: astore_1
      //   148: aload_0
      //   149: invokevirtual 49	java/lang/Object:notifyAll	()V
      //   152: aload_1
      //   153: athrow
      //   154: aload_0
      //   155: getfield 100	com/google/android/gms/analytics/internal/zzi$zza:dt	Z
      //   158: ifne +38 -> 196
      //   161: aload_0
      //   162: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   165: ldc 102
      //   167: invokevirtual 105	com/google/android/gms/analytics/internal/zzi:zzev	(Ljava/lang/String;)V
      //   170: aload_0
      //   171: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   174: invokevirtual 109	com/google/android/gms/analytics/internal/zzi:zzacc	()Lcom/google/android/gms/analytics/zzi;
      //   177: astore_2
      //   178: new 11	com/google/android/gms/analytics/internal/zzi$zza$1
      //   181: astore_3
      //   182: aload_3
      //   183: aload_0
      //   184: aload_1
      //   185: invokespecial 112	com/google/android/gms/analytics/internal/zzi$zza$1:<init>	(Lcom/google/android/gms/analytics/internal/zzi$zza;Lcom/google/android/gms/analytics/internal/zzac;)V
      //   188: aload_2
      //   189: aload_3
      //   190: invokevirtual 118	com/google/android/gms/analytics/zzi:zzg	(Ljava/lang/Runnable;)V
      //   193: goto -92 -> 101
      //   196: aload_0
      //   197: aload_1
      //   198: putfield 120	com/google/android/gms/analytics/internal/zzi$zza:ds	Lcom/google/android/gms/analytics/internal/zzac;
      //   201: goto -100 -> 101
      //   204: astore_1
      //   205: goto -104 -> 101
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	208	0	this	zza
      //   0	208	1	paramComponentName	ComponentName
      //   0	208	2	paramIBinder	android.os.IBinder
      //   31	159	3	local1	1
      //   28	88	4	localObject	Object
      //   41	84	5	str	String
      // Exception table:
      //   from	to	target	type
      //   20	26	110	finally
      //   101	107	110	finally
      //   111	113	110	finally
      //   148	154	110	finally
      //   35	43	134	android/os/RemoteException
      //   46	56	134	android/os/RemoteException
      //   59	64	134	android/os/RemoteException
      //   66	75	134	android/os/RemoteException
      //   118	129	134	android/os/RemoteException
      //   11	20	147	finally
      //   35	43	147	finally
      //   46	56	147	finally
      //   59	64	147	finally
      //   66	75	147	finally
      //   81	101	147	finally
      //   118	129	147	finally
      //   135	144	147	finally
      //   154	193	147	finally
      //   196	201	147	finally
      //   81	101	204	java/lang/IllegalArgumentException
    }
    
    public void onServiceDisconnected(final ComponentName paramComponentName)
    {
      zzaa.zzhs("AnalyticsServiceConnection.onServiceDisconnected");
      zzi.this.zzacc().zzg(new Runnable()
      {
        public void run()
        {
          zzi.zza(zzi.this, paramComponentName);
        }
      });
    }
    
    /* Error */
    public zzac zzacy()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aload_0
      //   3: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   6: invokevirtual 134	com/google/android/gms/analytics/internal/zzi:zzzx	()V
      //   9: new 136	android/content/Intent
      //   12: dup
      //   13: ldc -118
      //   15: invokespecial 140	android/content/Intent:<init>	(Ljava/lang/String;)V
      //   18: astore 5
      //   20: aload 5
      //   22: new 142	android/content/ComponentName
      //   25: dup
      //   26: ldc -112
      //   28: ldc -110
      //   30: invokespecial 149	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   33: invokevirtual 153	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
      //   36: pop
      //   37: aload_0
      //   38: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   41: invokevirtual 84	com/google/android/gms/analytics/internal/zzi:getContext	()Landroid/content/Context;
      //   44: astore 4
      //   46: aload 5
      //   48: ldc -101
      //   50: aload 4
      //   52: invokevirtual 160	android/content/Context:getPackageName	()Ljava/lang/String;
      //   55: invokevirtual 164	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   58: pop
      //   59: invokestatic 80	com/google/android/gms/common/stats/zza:zzaxr	()Lcom/google/android/gms/common/stats/zza;
      //   62: astore_3
      //   63: aload_0
      //   64: monitorenter
      //   65: aload_0
      //   66: aconst_null
      //   67: putfield 120	com/google/android/gms/analytics/internal/zzi$zza:ds	Lcom/google/android/gms/analytics/internal/zzac;
      //   70: aload_0
      //   71: iconst_1
      //   72: putfield 100	com/google/android/gms/analytics/internal/zzi$zza:dt	Z
      //   75: aload_3
      //   76: aload 4
      //   78: aload 5
      //   80: aload_0
      //   81: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   84: invokestatic 87	com/google/android/gms/analytics/internal/zzi:zza	(Lcom/google/android/gms/analytics/internal/zzi;)Lcom/google/android/gms/analytics/internal/zzi$zza;
      //   87: sipush 129
      //   90: invokevirtual 167	com/google/android/gms/common/stats/zza:zza	(Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   93: istore_1
      //   94: aload_0
      //   95: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   98: ldc -87
      //   100: iload_1
      //   101: invokestatic 175	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   104: invokevirtual 177	com/google/android/gms/analytics/internal/zzi:zza	(Ljava/lang/String;Ljava/lang/Object;)V
      //   107: iload_1
      //   108: ifne +12 -> 120
      //   111: aload_0
      //   112: iconst_0
      //   113: putfield 100	com/google/android/gms/analytics/internal/zzi$zza:dt	Z
      //   116: aload_0
      //   117: monitorexit
      //   118: aload_2
      //   119: areturn
      //   120: aload_0
      //   121: aload_0
      //   122: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   125: invokevirtual 181	com/google/android/gms/analytics/internal/zzi:zzacb	()Lcom/google/android/gms/analytics/internal/zzr;
      //   128: invokevirtual 187	com/google/android/gms/analytics/internal/zzr:zzafa	()J
      //   131: invokevirtual 191	java/lang/Object:wait	(J)V
      //   134: aload_0
      //   135: iconst_0
      //   136: putfield 100	com/google/android/gms/analytics/internal/zzi$zza:dt	Z
      //   139: aload_0
      //   140: getfield 120	com/google/android/gms/analytics/internal/zzi$zza:ds	Lcom/google/android/gms/analytics/internal/zzac;
      //   143: astore_2
      //   144: aload_0
      //   145: aconst_null
      //   146: putfield 120	com/google/android/gms/analytics/internal/zzi$zza:ds	Lcom/google/android/gms/analytics/internal/zzac;
      //   149: aload_2
      //   150: ifnonnull +12 -> 162
      //   153: aload_0
      //   154: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   157: ldc -63
      //   159: invokevirtual 46	com/google/android/gms/analytics/internal/zzi:zzew	(Ljava/lang/String;)V
      //   162: aload_0
      //   163: monitorexit
      //   164: goto -46 -> 118
      //   167: astore_2
      //   168: aload_0
      //   169: monitorexit
      //   170: aload_2
      //   171: athrow
      //   172: astore_2
      //   173: aload_0
      //   174: getfield 23	com/google/android/gms/analytics/internal/zzi$zza:dr	Lcom/google/android/gms/analytics/internal/zzi;
      //   177: ldc -61
      //   179: invokevirtual 105	com/google/android/gms/analytics/internal/zzi:zzev	(Ljava/lang/String;)V
      //   182: goto -48 -> 134
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	185	0	this	zza
      //   93	15	1	bool	boolean
      //   1	149	2	localzzac	zzac
      //   167	4	2	localObject	Object
      //   172	1	2	localInterruptedException	InterruptedException
      //   62	14	3	localzza	zza
      //   44	33	4	localContext	android.content.Context
      //   18	61	5	localIntent	android.content.Intent
      // Exception table:
      //   from	to	target	type
      //   65	107	167	finally
      //   111	118	167	finally
      //   120	134	167	finally
      //   134	149	167	finally
      //   153	162	167	finally
      //   162	164	167	finally
      //   168	170	167	finally
      //   173	182	167	finally
      //   120	134	172	java/lang/InterruptedException
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */