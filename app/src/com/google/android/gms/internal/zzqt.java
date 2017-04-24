package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzqt
  implements zzrm
{
  private final Context mContext;
  private final zzrd yW;
  private final zzrf yX;
  private final zzrf yY;
  private final Map<Api.zzc<?>, zzrf> yZ;
  private final Set<zzsa> za = Collections.newSetFromMap(new WeakHashMap());
  private final Api.zze zb;
  private Bundle zc;
  private ConnectionResult zd = null;
  private ConnectionResult ze = null;
  private boolean zf = false;
  private final Lock zg;
  private int zh = 0;
  private final Looper zzajy;
  
  private zzqt(Context paramContext, zzrd paramzzrd, Lock paramLock, Looper paramLooper, zzc paramzzc, Map<Api.zzc<?>, Api.zze> paramMap1, Map<Api.zzc<?>, Api.zze> paramMap2, zzf paramzzf, Api.zza<? extends zzxp, zzxq> paramzza, Api.zze paramzze, ArrayList<zzqr> paramArrayList1, ArrayList<zzqr> paramArrayList2, Map<Api<?>, Integer> paramMap3, Map<Api<?>, Integer> paramMap4)
  {
    this.mContext = paramContext;
    this.yW = paramzzrd;
    this.zg = paramLock;
    this.zzajy = paramLooper;
    this.zb = paramzze;
    this.yX = new zzrf(paramContext, this.yW, paramLock, paramLooper, paramzzc, paramMap2, null, paramMap4, null, paramArrayList2, new zza(null));
    this.yY = new zzrf(paramContext, this.yW, paramLock, paramLooper, paramzzc, paramMap1, paramzzf, paramMap3, paramzza, paramArrayList1, new zzb(null));
    paramContext = new ArrayMap();
    paramzzrd = paramMap2.keySet().iterator();
    while (paramzzrd.hasNext()) {
      paramContext.put((Api.zzc)paramzzrd.next(), this.yX);
    }
    paramzzrd = paramMap1.keySet().iterator();
    while (paramzzrd.hasNext()) {
      paramContext.put((Api.zzc)paramzzrd.next(), this.yY);
    }
    this.yZ = Collections.unmodifiableMap(paramContext);
  }
  
  public static zzqt zza(Context paramContext, zzrd paramzzrd, Lock paramLock, Looper paramLooper, zzc paramzzc, Map<Api.zzc<?>, Api.zze> paramMap, zzf paramzzf, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzxp, zzxq> paramzza, ArrayList<zzqr> paramArrayList)
  {
    Object localObject1 = null;
    ArrayMap localArrayMap2 = new ArrayMap();
    ArrayMap localArrayMap1 = new ArrayMap();
    Object localObject2 = paramMap.entrySet().iterator();
    paramMap = (Map<Api.zzc<?>, Api.zze>)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (Api.zze)((Map.Entry)localObject3).getValue();
      if (((Api.zze)localObject1).zzajc()) {
        paramMap = (Map<Api.zzc<?>, Api.zze>)localObject1;
      }
      if (((Api.zze)localObject1).zzain()) {
        localArrayMap2.put((Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
      } else {
        localArrayMap1.put((Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
      }
    }
    boolean bool;
    if (!localArrayMap2.isEmpty())
    {
      bool = true;
      zzaa.zza(bool, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
      localObject1 = new ArrayMap();
      localObject2 = new ArrayMap();
      localObject3 = paramMap1.keySet().iterator();
    }
    Object localObject4;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        Api localApi = (Api)((Iterator)localObject3).next();
        localObject4 = localApi.zzaqv();
        if (localArrayMap2.containsKey(localObject4))
        {
          ((Map)localObject1).put(localApi, (Integer)paramMap1.get(localApi));
          continue;
          bool = false;
          break;
        }
        if (localArrayMap1.containsKey(localObject4)) {
          ((Map)localObject2).put(localApi, (Integer)paramMap1.get(localApi));
        } else {
          throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
        }
      }
    }
    paramMap1 = new ArrayList();
    Object localObject3 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject4 = (zzqr)paramArrayList.next();
      if (((Map)localObject1).containsKey(((zzqr)localObject4).vS)) {
        paramMap1.add(localObject4);
      } else if (((Map)localObject2).containsKey(((zzqr)localObject4).vS)) {
        ((ArrayList)localObject3).add(localObject4);
      } else {
        throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
      }
    }
    return new zzqt(paramContext, paramzzrd, paramLock, paramLooper, paramzzc, localArrayMap2, localArrayMap1, paramzzf, paramzza, paramMap, paramMap1, (ArrayList)localObject3, (Map)localObject1, (Map)localObject2);
  }
  
  private void zza(ConnectionResult paramConnectionResult)
  {
    switch (this.zh)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    }
    for (;;)
    {
      this.zh = 0;
      return;
      this.yW.zzc(paramConnectionResult);
      zzase();
    }
  }
  
  private void zzasb()
  {
    this.ze = null;
    this.zd = null;
    this.yX.connect();
    this.yY.connect();
  }
  
  private void zzasc()
  {
    if (zzb(this.zd)) {
      if ((zzb(this.ze)) || (zzasf())) {
        zzasd();
      }
    }
    for (;;)
    {
      return;
      if (this.ze != null) {
        if (this.zh == 1)
        {
          zzase();
        }
        else
        {
          zza(this.ze);
          this.yX.disconnect();
          continue;
          if ((this.zd != null) && (zzb(this.ze)))
          {
            this.yY.disconnect();
            zza(this.zd);
          }
          else if ((this.zd != null) && (this.ze != null))
          {
            ConnectionResult localConnectionResult = this.zd;
            if (this.yY.AB < this.yX.AB) {
              localConnectionResult = this.ze;
            }
            zza(localConnectionResult);
          }
        }
      }
    }
  }
  
  private void zzasd()
  {
    switch (this.zh)
    {
    default: 
      Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
    }
    for (;;)
    {
      this.zh = 0;
      return;
      this.yW.zzn(this.zc);
      zzase();
    }
  }
  
  private void zzase()
  {
    Iterator localIterator = this.za.iterator();
    while (localIterator.hasNext()) {
      ((zzsa)localIterator.next()).zzajb();
    }
    this.za.clear();
  }
  
  private boolean zzasf()
  {
    if ((this.ze != null) && (this.ze.getErrorCode() == 4)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  @Nullable
  private PendingIntent zzasg()
  {
    if (this.zb == null) {}
    for (PendingIntent localPendingIntent = null;; localPendingIntent = PendingIntent.getActivity(this.mContext, this.yW.getSessionId(), this.zb.zzajd(), 134217728)) {
      return localPendingIntent;
    }
  }
  
  private void zzb(int paramInt, boolean paramBoolean)
  {
    this.yW.zzc(paramInt, paramBoolean);
    this.ze = null;
    this.zd = null;
  }
  
  private static boolean zzb(ConnectionResult paramConnectionResult)
  {
    if ((paramConnectionResult != null) && (paramConnectionResult.isSuccess())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean zzc(zzqo.zza<? extends Result, ? extends Api.zzb> paramzza)
  {
    paramzza = paramzza.zzaqv();
    zzaa.zzb(this.yZ.containsKey(paramzza), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zzrf)this.yZ.get(paramzza)).equals(this.yY);
  }
  
  private void zzm(Bundle paramBundle)
  {
    if (this.zc == null) {
      this.zc = paramBundle;
    }
    for (;;)
    {
      return;
      if (paramBundle != null) {
        this.zc.putAll(paramBundle);
      }
    }
  }
  
  public ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException();
  }
  
  public ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
  
  public void connect()
  {
    this.zh = 2;
    this.zf = false;
    zzasb();
  }
  
  public void disconnect()
  {
    this.ze = null;
    this.zd = null;
    this.zh = 0;
    this.yX.disconnect();
    this.yY.disconnect();
    zzase();
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.yY.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.yX.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    if (((zzrf)this.yZ.get(paramApi.zzaqv())).equals(this.yY)) {
      if (zzasf()) {
        paramApi = new ConnectionResult(4, zzasg());
      }
    }
    for (;;)
    {
      return paramApi;
      paramApi = this.yY.getConnectionResult(paramApi);
      continue;
      paramApi = this.yX.getConnectionResult(paramApi);
    }
  }
  
  /* Error */
  public boolean isConnected()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 387 1 0
    //   11: aload_0
    //   12: getfield 86	com/google/android/gms/internal/zzqt:yX	Lcom/google/android/gms/internal/zzrf;
    //   15: invokevirtual 389	com/google/android/gms/internal/zzrf:isConnected	()Z
    //   18: ifeq +44 -> 62
    //   21: iload_3
    //   22: istore_2
    //   23: aload_0
    //   24: invokevirtual 392	com/google/android/gms/internal/zzqt:zzasa	()Z
    //   27: ifne +24 -> 51
    //   30: iload_3
    //   31: istore_2
    //   32: aload_0
    //   33: invokespecial 246	com/google/android/gms/internal/zzqt:zzasf	()Z
    //   36: ifne +15 -> 51
    //   39: aload_0
    //   40: getfield 66	com/google/android/gms/internal/zzqt:zh	I
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_1
    //   46: if_icmpne +16 -> 62
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   55: invokeinterface 395 1 0
    //   60: iload_2
    //   61: ireturn
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -13 -> 51
    //   67: astore 4
    //   69: aload_0
    //   70: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   73: invokeinterface 395 1 0
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	zzqt
    //   43	4	1	i	int
    //   22	42	2	bool1	boolean
    //   1	49	3	bool2	boolean
    //   67	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	21	67	finally
    //   23	30	67	finally
    //   32	44	67	finally
  }
  
  /* Error */
  public boolean isConnecting()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 387 1 0
    //   9: aload_0
    //   10: getfield 66	com/google/android/gms/internal/zzqt:zh	I
    //   13: istore_1
    //   14: iload_1
    //   15: iconst_2
    //   16: if_icmpne +16 -> 32
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 395 1 0
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -13 -> 21
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   42: invokeinterface 395 1 0
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	zzqt
    //   13	4	1	i	int
    //   20	14	2	bool	boolean
    //   37	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(@NonNull T paramT)
  {
    if (zzc(paramT)) {
      if (zzasf()) {
        paramT.zzaa(new Status(4, null, zzasg()));
      }
    }
    for (;;)
    {
      return paramT;
      paramT = this.yY.zza(paramT);
      continue;
      paramT = this.yX.zza(paramT);
    }
  }
  
  /* Error */
  public boolean zza(zzsa paramzzsa)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 387 1 0
    //   11: aload_0
    //   12: invokevirtual 414	com/google/android/gms/internal/zzqt:isConnecting	()Z
    //   15: ifne +10 -> 25
    //   18: aload_0
    //   19: invokevirtual 415	com/google/android/gms/internal/zzqt:isConnected	()Z
    //   22: ifeq +56 -> 78
    //   25: aload_0
    //   26: invokevirtual 392	com/google/android/gms/internal/zzqt:zzasa	()Z
    //   29: ifne +49 -> 78
    //   32: aload_0
    //   33: getfield 58	com/google/android/gms/internal/zzqt:za	Ljava/util/Set;
    //   36: aload_1
    //   37: invokeinterface 416 2 0
    //   42: pop
    //   43: aload_0
    //   44: getfield 66	com/google/android/gms/internal/zzqt:zh	I
    //   47: ifne +8 -> 55
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 66	com/google/android/gms/internal/zzqt:zh	I
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 62	com/google/android/gms/internal/zzqt:ze	Lcom/google/android/gms/common/ConnectionResult;
    //   60: aload_0
    //   61: getfield 89	com/google/android/gms/internal/zzqt:yY	Lcom/google/android/gms/internal/zzrf;
    //   64: invokevirtual 239	com/google/android/gms/internal/zzrf:connect	()V
    //   67: aload_0
    //   68: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   71: invokeinterface 395 1 0
    //   76: iload_2
    //   77: ireturn
    //   78: aload_0
    //   79: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   82: invokeinterface 395 1 0
    //   87: iconst_0
    //   88: istore_2
    //   89: goto -13 -> 76
    //   92: astore_1
    //   93: aload_0
    //   94: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   97: invokeinterface 395 1 0
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	zzqt
    //   0	104	1	paramzzsa	zzsa
    //   1	88	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   11	25	92	finally
    //   25	55	92	finally
    //   55	67	92	finally
  }
  
  /* Error */
  public void zzard()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 387 1 0
    //   9: aload_0
    //   10: invokevirtual 414	com/google/android/gms/internal/zzqt:isConnecting	()Z
    //   13: istore_1
    //   14: aload_0
    //   15: getfield 89	com/google/android/gms/internal/zzqt:yY	Lcom/google/android/gms/internal/zzrf;
    //   18: invokevirtual 254	com/google/android/gms/internal/zzrf:disconnect	()V
    //   21: new 277	com/google/android/gms/common/ConnectionResult
    //   24: astore_2
    //   25: aload_2
    //   26: iconst_4
    //   27: invokespecial 420	com/google/android/gms/common/ConnectionResult:<init>	(I)V
    //   30: aload_0
    //   31: aload_2
    //   32: putfield 62	com/google/android/gms/internal/zzqt:ze	Lcom/google/android/gms/common/ConnectionResult;
    //   35: iload_1
    //   36: ifeq +40 -> 76
    //   39: new 422	android/os/Handler
    //   42: astore_3
    //   43: aload_3
    //   44: aload_0
    //   45: getfield 74	com/google/android/gms/internal/zzqt:zzajy	Landroid/os/Looper;
    //   48: invokespecial 425	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   51: new 8	com/google/android/gms/internal/zzqt$1
    //   54: astore_2
    //   55: aload_2
    //   56: aload_0
    //   57: invokespecial 427	com/google/android/gms/internal/zzqt$1:<init>	(Lcom/google/android/gms/internal/zzqt;)V
    //   60: aload_3
    //   61: aload_2
    //   62: invokevirtual 431	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   65: pop
    //   66: aload_0
    //   67: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   70: invokeinterface 395 1 0
    //   75: return
    //   76: aload_0
    //   77: invokespecial 225	com/google/android/gms/internal/zzqt:zzase	()V
    //   80: goto -14 -> 66
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 72	com/google/android/gms/internal/zzqt:zg	Ljava/util/concurrent/locks/Lock;
    //   88: invokeinterface 395 1 0
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	zzqt
    //   13	23	1	bool	boolean
    //   24	38	2	localObject1	Object
    //   83	11	2	localObject2	Object
    //   42	19	3	localHandler	android.os.Handler
    // Exception table:
    //   from	to	target	type
    //   9	35	83	finally
    //   39	66	83	finally
    //   76	80	83	finally
  }
  
  public void zzarz()
  {
    this.yX.zzarz();
    this.yY.zzarz();
  }
  
  public boolean zzasa()
  {
    return this.yY.isConnected();
  }
  
  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    if (zzc(paramT)) {
      if (zzasf()) {
        paramT.zzaa(new Status(4, null, zzasg()));
      }
    }
    for (;;)
    {
      return paramT;
      paramT = this.yY.zzb(paramT);
      continue;
      paramT = this.yX.zzb(paramT);
    }
  }
  
  private class zza
    implements zzrm.zza
  {
    private zza() {}
    
    /* Error */
    public void zzc(int paramInt, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   4: invokestatic 27	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 32 1 0
      //   12: aload_0
      //   13: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   16: invokestatic 35	com/google/android/gms/internal/zzqt:zzc	(Lcom/google/android/gms/internal/zzqt;)Z
      //   19: ifne +26 -> 45
      //   22: aload_0
      //   23: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   26: invokestatic 39	com/google/android/gms/internal/zzqt:zzd	(Lcom/google/android/gms/internal/zzqt;)Lcom/google/android/gms/common/ConnectionResult;
      //   29: ifnull +16 -> 45
      //   32: aload_0
      //   33: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   36: invokestatic 39	com/google/android/gms/internal/zzqt:zzd	(Lcom/google/android/gms/internal/zzqt;)Lcom/google/android/gms/common/ConnectionResult;
      //   39: invokevirtual 45	com/google/android/gms/common/ConnectionResult:isSuccess	()Z
      //   42: ifne +34 -> 76
      //   45: aload_0
      //   46: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   49: iconst_0
      //   50: invokestatic 48	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;Z)Z
      //   53: pop
      //   54: aload_0
      //   55: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   58: iload_1
      //   59: iload_2
      //   60: invokestatic 51	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;IZ)V
      //   63: aload_0
      //   64: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   67: invokestatic 27	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;)Ljava/util/concurrent/locks/Lock;
      //   70: invokeinterface 54 1 0
      //   75: return
      //   76: aload_0
      //   77: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   80: iconst_1
      //   81: invokestatic 48	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;Z)Z
      //   84: pop
      //   85: aload_0
      //   86: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   89: invokestatic 58	com/google/android/gms/internal/zzqt:zze	(Lcom/google/android/gms/internal/zzqt;)Lcom/google/android/gms/internal/zzrf;
      //   92: iload_1
      //   93: invokevirtual 64	com/google/android/gms/internal/zzrf:onConnectionSuspended	(I)V
      //   96: aload_0
      //   97: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   100: invokestatic 27	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;)Ljava/util/concurrent/locks/Lock;
      //   103: invokeinterface 54 1 0
      //   108: goto -33 -> 75
      //   111: astore_3
      //   112: aload_0
      //   113: getfield 15	com/google/android/gms/internal/zzqt$zza:zi	Lcom/google/android/gms/internal/zzqt;
      //   116: invokestatic 27	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;)Ljava/util/concurrent/locks/Lock;
      //   119: invokeinterface 54 1 0
      //   124: aload_3
      //   125: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	126	0	this	zza
      //   0	126	1	paramInt	int
      //   0	126	2	paramBoolean	boolean
      //   111	14	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   12	45	111	finally
      //   45	63	111	finally
      //   76	96	111	finally
    }
    
    public void zzc(@NonNull ConnectionResult paramConnectionResult)
    {
      zzqt.zza(zzqt.this).lock();
      try
      {
        zzqt.zza(zzqt.this, paramConnectionResult);
        zzqt.zzb(zzqt.this);
        return;
      }
      finally
      {
        zzqt.zza(zzqt.this).unlock();
      }
    }
    
    public void zzn(@Nullable Bundle paramBundle)
    {
      zzqt.zza(zzqt.this).lock();
      try
      {
        zzqt.zza(zzqt.this, paramBundle);
        zzqt.zza(zzqt.this, ConnectionResult.wO);
        zzqt.zzb(zzqt.this);
        return;
      }
      finally
      {
        zzqt.zza(zzqt.this).unlock();
      }
    }
  }
  
  private class zzb
    implements zzrm.zza
  {
    private zzb() {}
    
    /* Error */
    public void zzc(int paramInt, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	com/google/android/gms/internal/zzqt$zzb:zi	Lcom/google/android/gms/internal/zzqt;
      //   4: invokestatic 28	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 33 1 0
      //   12: aload_0
      //   13: getfield 15	com/google/android/gms/internal/zzqt$zzb:zi	Lcom/google/android/gms/internal/zzqt;
      //   16: invokestatic 36	com/google/android/gms/internal/zzqt:zzc	(Lcom/google/android/gms/internal/zzqt;)Z
      //   19: ifeq +34 -> 53
      //   22: aload_0
      //   23: getfield 15	com/google/android/gms/internal/zzqt$zzb:zi	Lcom/google/android/gms/internal/zzqt;
      //   26: iconst_0
      //   27: invokestatic 39	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;Z)Z
      //   30: pop
      //   31: aload_0
      //   32: getfield 15	com/google/android/gms/internal/zzqt$zzb:zi	Lcom/google/android/gms/internal/zzqt;
      //   35: iload_1
      //   36: iload_2
      //   37: invokestatic 42	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;IZ)V
      //   40: aload_0
      //   41: getfield 15	com/google/android/gms/internal/zzqt$zzb:zi	Lcom/google/android/gms/internal/zzqt;
      //   44: invokestatic 28	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;)Ljava/util/concurrent/locks/Lock;
      //   47: invokeinterface 45 1 0
      //   52: return
      //   53: aload_0
      //   54: getfield 15	com/google/android/gms/internal/zzqt$zzb:zi	Lcom/google/android/gms/internal/zzqt;
      //   57: iconst_1
      //   58: invokestatic 39	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;Z)Z
      //   61: pop
      //   62: aload_0
      //   63: getfield 15	com/google/android/gms/internal/zzqt$zzb:zi	Lcom/google/android/gms/internal/zzqt;
      //   66: invokestatic 49	com/google/android/gms/internal/zzqt:zzf	(Lcom/google/android/gms/internal/zzqt;)Lcom/google/android/gms/internal/zzrf;
      //   69: iload_1
      //   70: invokevirtual 55	com/google/android/gms/internal/zzrf:onConnectionSuspended	(I)V
      //   73: aload_0
      //   74: getfield 15	com/google/android/gms/internal/zzqt$zzb:zi	Lcom/google/android/gms/internal/zzqt;
      //   77: invokestatic 28	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;)Ljava/util/concurrent/locks/Lock;
      //   80: invokeinterface 45 1 0
      //   85: goto -33 -> 52
      //   88: astore_3
      //   89: aload_0
      //   90: getfield 15	com/google/android/gms/internal/zzqt$zzb:zi	Lcom/google/android/gms/internal/zzqt;
      //   93: invokestatic 28	com/google/android/gms/internal/zzqt:zza	(Lcom/google/android/gms/internal/zzqt;)Ljava/util/concurrent/locks/Lock;
      //   96: invokeinterface 45 1 0
      //   101: aload_3
      //   102: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	103	0	this	zzb
      //   0	103	1	paramInt	int
      //   0	103	2	paramBoolean	boolean
      //   88	14	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   12	40	88	finally
      //   53	73	88	finally
    }
    
    public void zzc(@NonNull ConnectionResult paramConnectionResult)
    {
      zzqt.zza(zzqt.this).lock();
      try
      {
        zzqt.zzb(zzqt.this, paramConnectionResult);
        zzqt.zzb(zzqt.this);
        return;
      }
      finally
      {
        zzqt.zza(zzqt.this).unlock();
      }
    }
    
    public void zzn(@Nullable Bundle paramBundle)
    {
      zzqt.zza(zzqt.this).lock();
      try
      {
        zzqt.zzb(zzqt.this, ConnectionResult.wO);
        zzqt.zzb(zzqt.this);
        return;
      }
      finally
      {
        zzqt.zza(zzqt.this).unlock();
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */