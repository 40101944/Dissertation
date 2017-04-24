package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzrf
  implements zzqs, zzrm
{
  private ConnectionResult AA = null;
  int AB;
  final zzrm.zza AC;
  final Map<Api.zzc<?>, Api.zze> Aj;
  private final Condition Aw;
  private final zzb Ax;
  final Map<Api.zzc<?>, ConnectionResult> Ay = new HashMap();
  private volatile zzre Az;
  private final Context mContext;
  final Api.zza<? extends zzxp, zzxq> xQ;
  final zzrd yW;
  final zzf zP;
  private final Lock zg;
  final Map<Api<?>, Integer> zk;
  private final zzc zm;
  
  public zzrf(Context paramContext, zzrd paramzzrd, Lock paramLock, Looper paramLooper, zzc paramzzc, Map<Api.zzc<?>, Api.zze> paramMap, zzf paramzzf, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzxp, zzxq> paramzza, ArrayList<zzqr> paramArrayList, zzrm.zza paramzza1)
  {
    this.mContext = paramContext;
    this.zg = paramLock;
    this.zm = paramzzc;
    this.Aj = paramMap;
    this.zP = paramzzf;
    this.zk = paramMap1;
    this.xQ = paramzza;
    this.yW = paramzzrd;
    this.AC = paramzza1;
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext()) {
      ((zzqr)paramContext.next()).zza(this);
    }
    this.Ax = new zzb(paramLooper);
    this.Aw = paramLock.newCondition();
    this.Az = new zzrc(this);
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
          this.Aw.await();
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
      } else if (this.AA != null) {
        localConnectionResult = this.AA;
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
        paramLong = this.Aw.awaitNanos(paramLong);
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        paramTimeUnit = new ConnectionResult(15, null);
        continue;
      }
      if (isConnected()) {
        paramTimeUnit = ConnectionResult.wO;
      } else if (this.AA != null) {
        paramTimeUnit = this.AA;
      } else {
        paramTimeUnit = new ConnectionResult(13, null);
      }
    }
  }
  
  public void connect()
  {
    this.Az.connect();
  }
  
  public void disconnect()
  {
    if (this.Az.disconnect()) {
      this.Ay.clear();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = String.valueOf(paramString).concat("  ");
    paramPrintWriter.append(paramString).append("mState=").println(this.Az);
    Iterator localIterator = this.zk.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      paramPrintWriter.append(paramString).append(localApi.getName()).println(":");
      ((Api.zze)this.Aj.get(localApi.zzaqv())).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    paramApi = paramApi.zzaqv();
    if (this.Aj.containsKey(paramApi)) {
      if (((Api.zze)this.Aj.get(paramApi)).isConnected()) {
        paramApi = ConnectionResult.wO;
      }
    }
    for (;;)
    {
      return paramApi;
      if (this.Ay.containsKey(paramApi)) {
        paramApi = (ConnectionResult)this.Ay.get(paramApi);
      } else {
        paramApi = null;
      }
    }
  }
  
  public boolean isConnected()
  {
    return this.Az instanceof zzra;
  }
  
  public boolean isConnecting()
  {
    return this.Az instanceof zzrb;
  }
  
  public void onConnected(@Nullable Bundle paramBundle)
  {
    this.zg.lock();
    try
    {
      this.Az.onConnected(paramBundle);
      return;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    this.zg.lock();
    try
    {
      this.Az.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(@NonNull T paramT)
  {
    paramT.zzarv();
    return this.Az.zza(paramT);
  }
  
  public void zza(@NonNull ConnectionResult paramConnectionResult, @NonNull Api<?> paramApi, int paramInt)
  {
    this.zg.lock();
    try
    {
      this.Az.zza(paramConnectionResult, paramApi, paramInt);
      return;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  void zza(zza paramzza)
  {
    paramzza = this.Ax.obtainMessage(1, paramzza);
    this.Ax.sendMessage(paramzza);
  }
  
  void zza(RuntimeException paramRuntimeException)
  {
    paramRuntimeException = this.Ax.obtainMessage(2, paramRuntimeException);
    this.Ax.sendMessage(paramRuntimeException);
  }
  
  public boolean zza(zzsa paramzzsa)
  {
    return false;
  }
  
  public void zzard() {}
  
  public void zzarz()
  {
    if (isConnected()) {
      ((zzra)this.Az).zzasn();
    }
  }
  
  void zzatc()
  {
    this.zg.lock();
    try
    {
      zzrb localzzrb = new com/google/android/gms/internal/zzrb;
      localzzrb.<init>(this, this.zP, this.zk, this.zm, this.xQ, this.zg, this.mContext);
      this.Az = localzzrb;
      this.Az.begin();
      this.Aw.signalAll();
      return;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  void zzatd()
  {
    this.zg.lock();
    try
    {
      this.yW.zzasz();
      zzra localzzra = new com/google/android/gms/internal/zzra;
      localzzra.<init>(this);
      this.Az = localzzra;
      this.Az.begin();
      this.Aw.signalAll();
      return;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  void zzate()
  {
    Iterator localIterator = this.Aj.values().iterator();
    while (localIterator.hasNext()) {
      ((Api.zze)localIterator.next()).disconnect();
    }
  }
  
  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    paramT.zzarv();
    return this.Az.zzb(paramT);
  }
  
  void zzh(ConnectionResult paramConnectionResult)
  {
    this.zg.lock();
    try
    {
      this.AA = paramConnectionResult;
      paramConnectionResult = new com/google/android/gms/internal/zzrc;
      paramConnectionResult.<init>(this);
      this.Az = paramConnectionResult;
      this.Az.begin();
      this.Aw.signalAll();
      return;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  static abstract class zza
  {
    private final zzre AD;
    
    protected zza(zzre paramzzre)
    {
      this.AD = paramzzre;
    }
    
    protected abstract void zzaso();
    
    /* Error */
    public final void zzc(zzrf paramzzrf)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 23	com/google/android/gms/internal/zzrf:zza	(Lcom/google/android/gms/internal/zzrf;)Ljava/util/concurrent/locks/Lock;
      //   4: invokeinterface 28 1 0
      //   9: aload_1
      //   10: invokestatic 32	com/google/android/gms/internal/zzrf:zzb	(Lcom/google/android/gms/internal/zzrf;)Lcom/google/android/gms/internal/zzre;
      //   13: astore_3
      //   14: aload_0
      //   15: getfield 16	com/google/android/gms/internal/zzrf$zza:AD	Lcom/google/android/gms/internal/zzre;
      //   18: astore_2
      //   19: aload_3
      //   20: aload_2
      //   21: if_acmpeq +13 -> 34
      //   24: aload_1
      //   25: invokestatic 23	com/google/android/gms/internal/zzrf:zza	(Lcom/google/android/gms/internal/zzrf;)Ljava/util/concurrent/locks/Lock;
      //   28: invokeinterface 35 1 0
      //   33: return
      //   34: aload_0
      //   35: invokevirtual 37	com/google/android/gms/internal/zzrf$zza:zzaso	()V
      //   38: aload_1
      //   39: invokestatic 23	com/google/android/gms/internal/zzrf:zza	(Lcom/google/android/gms/internal/zzrf;)Ljava/util/concurrent/locks/Lock;
      //   42: invokeinterface 35 1 0
      //   47: goto -14 -> 33
      //   50: astore_2
      //   51: aload_1
      //   52: invokestatic 23	com/google/android/gms/internal/zzrf:zza	(Lcom/google/android/gms/internal/zzrf;)Ljava/util/concurrent/locks/Lock;
      //   55: invokeinterface 35 1 0
      //   60: aload_2
      //   61: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	62	0	this	zza
      //   0	62	1	paramzzrf	zzrf
      //   18	3	2	localzzre1	zzre
      //   50	11	2	localObject	Object
      //   13	7	3	localzzre2	zzre
      // Exception table:
      //   from	to	target	type
      //   9	19	50	finally
      //   34	38	50	finally
    }
  }
  
  final class zzb
    extends Handler
  {
    zzb(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        int i = paramMessage.what;
        Log.w("GACStateManager", 31 + "Unknown message id: " + i);
      case 1: 
        for (;;)
        {
          return;
          ((zzrf.zza)paramMessage.obj).zzc(zzrf.this);
        }
      }
      throw ((RuntimeException)paramMessage.obj);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzrf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */