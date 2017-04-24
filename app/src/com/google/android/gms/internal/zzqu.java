package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzqu
  implements zzrm
{
  private final zzrh xy;
  private final Lock zg;
  private final Map<Api.zzc<?>, com.google.android.gms.common.api.zzc<?>> zj = new HashMap();
  private final Map<Api<?>, Integer> zk;
  private final zzrd zl;
  private final com.google.android.gms.common.zzc zm;
  private final Condition zn;
  private boolean zo;
  private Map<zzql<?>, ConnectionResult> zp;
  private ConnectionResult zq;
  private final Looper zzajy;
  
  public zzqu(Context paramContext, Lock paramLock, Looper paramLooper, com.google.android.gms.common.zzc paramzzc, Map<Api.zzc<?>, Api.zze> paramMap, Map<Api<?>, Integer> paramMap1, ArrayList<zzqr> paramArrayList, zzrd paramzzrd)
  {
    this.zg = paramLock;
    this.zzajy = paramLooper;
    this.zn = paramLock.newCondition();
    this.zm = paramzzc;
    this.zl = paramzzrd;
    this.zk = paramMap1;
    paramLock = new HashMap();
    paramMap1 = paramMap1.keySet().iterator();
    while (paramMap1.hasNext())
    {
      paramzzc = (Api)paramMap1.next();
      paramLock.put(paramzzc.zzaqv(), paramzzc);
    }
    paramzzc = new HashMap();
    paramMap1 = paramArrayList.iterator();
    while (paramMap1.hasNext())
    {
      paramArrayList = (zzqr)paramMap1.next();
      paramzzc.put(paramArrayList.vS, paramArrayList);
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      paramMap1 = (Map.Entry)paramMap.next();
      paramArrayList = (Api)paramLock.get(paramMap1.getKey());
      paramArrayList = new com.google.android.gms.common.api.zzc(paramContext, paramArrayList, paramLooper, (Api.zze)paramMap1.getValue(), (zzqr)paramzzc.get(paramArrayList)) {};
      this.zj.put((Api.zzc)paramMap1.getKey(), paramArrayList);
    }
    this.xy = zzrh.zzatg();
  }
  
  public ConnectionResult blockingConnect()
  {
    connect();
    ConnectionResult localConnectionResult;
    for (;;)
    {
      if (isConnecting()) {
        try
        {
          this.zn.await();
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
          localConnectionResult = new ConnectionResult(15, null);
        }
      }
    }
    for (;;)
    {
      return localConnectionResult;
      if (isConnected()) {
        localConnectionResult = ConnectionResult.wO;
      } else if (this.zq != null) {
        localConnectionResult = this.zq;
      } else {
        localConnectionResult = new ConnectionResult(13, null);
      }
    }
  }
  
  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    paramLong = paramTimeUnit.toNanos(paramLong);
    if (isConnecting()) {
      if (paramLong > 0L) {}
    }
    for (;;)
    {
      try
      {
        disconnect();
        paramTimeUnit = new com/google/android/gms/common/ConnectionResult;
        paramTimeUnit.<init>(14, null);
        return paramTimeUnit;
        paramLong = this.zn.awaitNanos(paramLong);
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        paramTimeUnit = new ConnectionResult(15, null);
        continue;
      }
      if (isConnected()) {
        paramTimeUnit = ConnectionResult.wO;
      } else if (this.zq != null) {
        paramTimeUnit = this.zq;
      } else {
        paramTimeUnit = new ConnectionResult(13, null);
      }
    }
  }
  
  /* Error */
  public void connect()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 209 1 0
    //   9: aload_0
    //   10: getfield 146	com/google/android/gms/internal/zzqu:zo	Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +13 -> 28
    //   18: aload_0
    //   19: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   22: invokeinterface 212 1 0
    //   27: return
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 146	com/google/android/gms/internal/zzqu:zo	Z
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 142	com/google/android/gms/internal/zzqu:zp	Ljava/util/Map;
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 139	com/google/android/gms/internal/zzqu:zq	Lcom/google/android/gms/common/ConnectionResult;
    //   43: new 10	com/google/android/gms/internal/zzqu$zza
    //   46: astore_2
    //   47: aload_2
    //   48: aload_0
    //   49: aconst_null
    //   50: invokespecial 215	com/google/android/gms/internal/zzqu$zza:<init>	(Lcom/google/android/gms/internal/zzqu;Lcom/google/android/gms/internal/zzqu$1;)V
    //   53: new 217	com/google/android/gms/internal/zzsv
    //   56: astore_3
    //   57: aload_3
    //   58: aload_0
    //   59: getfield 48	com/google/android/gms/internal/zzqu:zzajy	Landroid/os/Looper;
    //   62: invokespecial 220	com/google/android/gms/internal/zzsv:<init>	(Landroid/os/Looper;)V
    //   65: aload_0
    //   66: getfield 133	com/google/android/gms/internal/zzqu:xy	Lcom/google/android/gms/internal/zzrh;
    //   69: aload_0
    //   70: getfield 44	com/google/android/gms/internal/zzqu:zj	Ljava/util/Map;
    //   73: invokeinterface 224 1 0
    //   78: invokevirtual 227	com/google/android/gms/internal/zzrh:zza	(Ljava/lang/Iterable;)Lcom/google/android/gms/tasks/Task;
    //   81: aload_3
    //   82: aload_2
    //   83: invokevirtual 233	com/google/android/gms/tasks/Task:addOnSuccessListener	(Ljava/util/concurrent/Executor;Lcom/google/android/gms/tasks/OnSuccessListener;)Lcom/google/android/gms/tasks/Task;
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 237	com/google/android/gms/tasks/Task:addOnFailureListener	(Ljava/util/concurrent/Executor;Lcom/google/android/gms/tasks/OnFailureListener;)Lcom/google/android/gms/tasks/Task;
    //   91: pop
    //   92: aload_0
    //   93: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   96: invokeinterface 212 1 0
    //   101: goto -74 -> 27
    //   104: astore_2
    //   105: aload_0
    //   106: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   109: invokeinterface 212 1 0
    //   114: aload_2
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	zzqu
    //   13	2	1	bool	boolean
    //   46	42	2	localzza	zza
    //   104	11	2	localObject	Object
    //   56	31	3	localzzsv	zzsv
    // Exception table:
    //   from	to	target	type
    //   9	14	104	finally
    //   28	92	104	finally
  }
  
  public void disconnect()
  {
    this.zg.lock();
    try
    {
      this.zo = false;
      this.zp = null;
      this.zq = null;
      this.zn.signalAll();
      return;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  /* Error */
  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 209 1 0
    //   9: aload_0
    //   10: getfield 44	com/google/android/gms/internal/zzqu:zj	Ljava/util/Map;
    //   13: aload_1
    //   14: invokevirtual 90	com/google/android/gms/common/api/Api:zzaqv	()Lcom/google/android/gms/common/api/Api$zzc;
    //   17: invokeinterface 115 2 0
    //   22: checkcast 248	com/google/android/gms/common/api/zzc
    //   25: invokevirtual 252	com/google/android/gms/common/api/zzc:getClient	()Lcom/google/android/gms/common/api/Api$zze;
    //   28: invokeinterface 253 1 0
    //   33: ifeq +18 -> 51
    //   36: getstatic 193	com/google/android/gms/common/ConnectionResult:wO	Lcom/google/android/gms/common/ConnectionResult;
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   44: invokeinterface 212 1 0
    //   49: aload_1
    //   50: areturn
    //   51: aload_0
    //   52: getfield 142	com/google/android/gms/internal/zzqu:zp	Ljava/util/Map;
    //   55: ifnull +47 -> 102
    //   58: aload_0
    //   59: getfield 142	com/google/android/gms/internal/zzqu:zp	Ljava/util/Map;
    //   62: aload_0
    //   63: getfield 44	com/google/android/gms/internal/zzqu:zj	Ljava/util/Map;
    //   66: aload_1
    //   67: invokevirtual 90	com/google/android/gms/common/api/Api:zzaqv	()Lcom/google/android/gms/common/api/Api$zzc;
    //   70: invokeinterface 115 2 0
    //   75: checkcast 248	com/google/android/gms/common/api/zzc
    //   78: invokevirtual 257	com/google/android/gms/common/api/zzc:getApiKey	()Lcom/google/android/gms/internal/zzql;
    //   81: invokeinterface 115 2 0
    //   86: checkcast 184	com/google/android/gms/common/ConnectionResult
    //   89: astore_1
    //   90: aload_0
    //   91: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   94: invokeinterface 212 1 0
    //   99: goto -50 -> 49
    //   102: aload_0
    //   103: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   106: invokeinterface 212 1 0
    //   111: aconst_null
    //   112: astore_1
    //   113: goto -64 -> 49
    //   116: astore_1
    //   117: aload_0
    //   118: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   121: invokeinterface 212 1 0
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	zzqu
    //   0	128	1	paramApi	Api<?>
    // Exception table:
    //   from	to	target	type
    //   9	40	116	finally
    //   51	90	116	finally
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 209 1 0
    //   9: aload_0
    //   10: getfield 142	com/google/android/gms/internal/zzqu:zp	Ljava/util/Map;
    //   13: ifnull +25 -> 38
    //   16: aload_0
    //   17: getfield 139	com/google/android/gms/internal/zzqu:zq	Lcom/google/android/gms/common/ConnectionResult;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 212 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 212 1 0
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	zzqu
    //   26	14	1	bool	boolean
    //   20	2	2	localConnectionResult	ConnectionResult
    //   43	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	43	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 209 1 0
    //   9: aload_0
    //   10: getfield 142	com/google/android/gms/internal/zzqu:zp	Ljava/util/Map;
    //   13: ifnonnull +25 -> 38
    //   16: aload_0
    //   17: getfield 146	com/google/android/gms/internal/zzqu:zo	Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +16 -> 38
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   31: invokeinterface 212 1 0
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_0
    //   39: istore_1
    //   40: goto -13 -> 27
    //   43: astore_2
    //   44: aload_0
    //   45: getfield 46	com/google/android/gms/internal/zzqu:zg	Ljava/util/concurrent/locks/Lock;
    //   48: invokeinterface 212 1 0
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	zzqu
    //   20	20	1	bool	boolean
    //   43	11	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	43	finally
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(@NonNull T paramT)
  {
    this.zl.Ap.zzb(paramT);
    return ((com.google.android.gms.common.api.zzc)this.zj.get(paramT.zzaqv())).doRead(paramT);
  }
  
  public boolean zza(zzsa paramzzsa)
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzard()
  {
    throw new UnsupportedOperationException();
  }
  
  public void zzarz() {}
  
  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    this.zl.Ap.zzb(paramT);
    return ((com.google.android.gms.common.api.zzc)this.zj.get(paramT.zzaqv())).doWrite(paramT);
  }
  
  private class zza
    implements OnFailureListener, OnSuccessListener<Void>
  {
    private zza() {}
    
    @Nullable
    private ConnectionResult zzash()
    {
      Object localObject1 = null;
      int i = 0;
      Iterator localIterator = zzqu.zzg(zzqu.this).keySet().iterator();
      Object localObject2;
      int j;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (Api)localIterator.next();
          ConnectionResult localConnectionResult = (ConnectionResult)zzqu.zzc(zzqu.this).get(((com.google.android.gms.common.api.zzc)zzqu.zzb(zzqu.this).get(((Api)localObject2).zzaqv())).getApiKey());
          if (!localConnectionResult.isSuccess())
          {
            j = ((Integer)zzqu.zzg(zzqu.this).get(localObject2)).intValue();
            if ((j != 2) && ((j != 1) || (localConnectionResult.hasResolution()) || (zzqu.zzh(zzqu.this).isUserResolvableError(localConnectionResult.getErrorCode()))))
            {
              int k = ((Api)localObject2).zzaqs().getPriority();
              j = k;
              localObject2 = localConnectionResult;
              if (localObject1 != null)
              {
                if (i <= k) {
                  break label194;
                }
                localObject2 = localConnectionResult;
                j = k;
              }
            }
          }
        }
      }
      for (;;)
      {
        i = j;
        localObject1 = localObject2;
        break;
        return (ConnectionResult)localObject1;
        label194:
        j = i;
        localObject2 = localObject1;
      }
    }
    
    /* Error */
    public void onFailure(@NonNull Exception paramException)
    {
      // Byte code:
      //   0: aload_1
      //   1: checkcast 118	com/google/android/gms/common/api/zzb
      //   4: astore_1
      //   5: aload_0
      //   6: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   9: invokestatic 121	com/google/android/gms/internal/zzqu:zza	(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Lock;
      //   12: invokeinterface 126 1 0
      //   17: aload_0
      //   18: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   21: aload_1
      //   22: invokevirtual 130	com/google/android/gms/common/api/zzb:zzara	()Landroid/support/v4/util/ArrayMap;
      //   25: invokestatic 133	com/google/android/gms/internal/zzqu:zza	(Lcom/google/android/gms/internal/zzqu;Ljava/util/Map;)Ljava/util/Map;
      //   28: pop
      //   29: aload_0
      //   30: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   33: aload_0
      //   34: invokespecial 135	com/google/android/gms/internal/zzqu$zza:zzash	()Lcom/google/android/gms/common/ConnectionResult;
      //   37: invokestatic 138	com/google/android/gms/internal/zzqu:zza	(Lcom/google/android/gms/internal/zzqu;Lcom/google/android/gms/common/ConnectionResult;)Lcom/google/android/gms/common/ConnectionResult;
      //   40: pop
      //   41: aload_0
      //   42: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   45: invokestatic 142	com/google/android/gms/internal/zzqu:zzf	(Lcom/google/android/gms/internal/zzqu;)Lcom/google/android/gms/common/ConnectionResult;
      //   48: ifnonnull +39 -> 87
      //   51: aload_0
      //   52: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   55: invokestatic 146	com/google/android/gms/internal/zzqu:zzd	(Lcom/google/android/gms/internal/zzqu;)Lcom/google/android/gms/internal/zzrd;
      //   58: aconst_null
      //   59: invokevirtual 152	com/google/android/gms/internal/zzrd:zzn	(Landroid/os/Bundle;)V
      //   62: aload_0
      //   63: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   66: invokestatic 156	com/google/android/gms/internal/zzqu:zze	(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Condition;
      //   69: invokeinterface 161 1 0
      //   74: aload_0
      //   75: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   78: invokestatic 121	com/google/android/gms/internal/zzqu:zza	(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Lock;
      //   81: invokeinterface 164 1 0
      //   86: return
      //   87: aload_0
      //   88: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   91: iconst_0
      //   92: invokestatic 167	com/google/android/gms/internal/zzqu:zza	(Lcom/google/android/gms/internal/zzqu;Z)Z
      //   95: pop
      //   96: aload_0
      //   97: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   100: invokestatic 146	com/google/android/gms/internal/zzqu:zzd	(Lcom/google/android/gms/internal/zzqu;)Lcom/google/android/gms/internal/zzrd;
      //   103: aload_0
      //   104: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   107: invokestatic 142	com/google/android/gms/internal/zzqu:zzf	(Lcom/google/android/gms/internal/zzqu;)Lcom/google/android/gms/common/ConnectionResult;
      //   110: invokevirtual 170	com/google/android/gms/internal/zzrd:zzc	(Lcom/google/android/gms/common/ConnectionResult;)V
      //   113: goto -51 -> 62
      //   116: astore_1
      //   117: aload_0
      //   118: getfield 18	com/google/android/gms/internal/zzqu$zza:zr	Lcom/google/android/gms/internal/zzqu;
      //   121: invokestatic 121	com/google/android/gms/internal/zzqu:zza	(Lcom/google/android/gms/internal/zzqu;)Ljava/util/concurrent/locks/Lock;
      //   124: invokeinterface 164 1 0
      //   129: aload_1
      //   130: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	131	0	this	zza
      //   0	131	1	paramException	Exception
      // Exception table:
      //   from	to	target	type
      //   17	62	116	finally
      //   62	74	116	finally
      //   87	113	116	finally
    }
    
    public void zza(Void paramVoid)
    {
      zzqu.zza(zzqu.this).lock();
      try
      {
        paramVoid = zzqu.this;
        Object localObject = new android/support/v4/util/ArrayMap;
        ((ArrayMap)localObject).<init>(zzqu.zzb(zzqu.this).size());
        zzqu.zza(paramVoid, (Map)localObject);
        localObject = zzqu.zzb(zzqu.this).keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramVoid = (Api.zzc)((Iterator)localObject).next();
          zzqu.zzc(zzqu.this).put(((com.google.android.gms.common.api.zzc)zzqu.zzb(zzqu.this).get(paramVoid)).getApiKey(), ConnectionResult.wO);
        }
        zzqu.zzd(zzqu.this).zzn(null);
      }
      finally
      {
        zzqu.zza(zzqu.this).unlock();
      }
      zzqu.zze(zzqu.this).signalAll();
      zzqu.zza(zzqu.this).unlock();
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */