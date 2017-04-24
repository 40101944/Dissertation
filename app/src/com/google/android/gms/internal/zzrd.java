package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api<*>;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk.zza;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzrd
  extends GoogleApiClient
  implements zzrm.zza
{
  private final com.google.android.gms.common.internal.zzk Ab;
  private zzrm Ac = null;
  final Queue<zzqo.zza<?, ?>> Ad = new LinkedList();
  private volatile boolean Ae;
  private long Af = 120000L;
  private long Ag = 5000L;
  private final zza Ah;
  zzrj Ai;
  final Map<Api.zzc<?>, Api.zze> Aj;
  Set<Scope> Ak = new HashSet();
  private final zzrs Al = new zzrs();
  private final ArrayList<zzqr> Am;
  private Integer An = null;
  Set<zzsf> Ao = null;
  final zzsg Ap;
  private final zzk.zza Aq = new zzk.zza()
  {
    public boolean isConnected()
    {
      return zzrd.this.isConnected();
    }
    
    public Bundle zzapn()
    {
      return null;
    }
  };
  private final Context mContext;
  private final int xN;
  private final GoogleApiAvailability xP;
  final Api.zza<? extends zzxp, zzxq> xQ;
  private boolean xT;
  final zzf zP;
  private final Lock zg;
  final Map<Api<?>, Integer> zk;
  private final Looper zzajy;
  
  public zzrd(Context paramContext, Lock paramLock, Looper paramLooper, zzf paramzzf, GoogleApiAvailability paramGoogleApiAvailability, Api.zza<? extends zzxp, zzxq> paramzza, Map<Api<?>, Integer> paramMap, List<GoogleApiClient.ConnectionCallbacks> paramList, List<GoogleApiClient.OnConnectionFailedListener> paramList1, Map<Api.zzc<?>, Api.zze> paramMap1, int paramInt1, int paramInt2, ArrayList<zzqr> paramArrayList, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.zg = paramLock;
    this.xT = paramBoolean;
    this.Ab = new com.google.android.gms.common.internal.zzk(paramLooper, this.Aq);
    this.zzajy = paramLooper;
    this.Ah = new zza(paramLooper);
    this.xP = paramGoogleApiAvailability;
    this.xN = paramInt1;
    if (this.xN >= 0) {
      this.An = Integer.valueOf(paramInt2);
    }
    this.zk = paramMap;
    this.Aj = paramMap1;
    this.Am = paramArrayList;
    this.Ap = new zzsg(this.Aj);
    paramContext = paramList.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.ConnectionCallbacks)paramContext.next();
      this.Ab.registerConnectionCallbacks(paramLock);
    }
    paramLock = paramList1.iterator();
    while (paramLock.hasNext())
    {
      paramContext = (GoogleApiClient.OnConnectionFailedListener)paramLock.next();
      this.Ab.registerConnectionFailedListener(paramContext);
    }
    this.zP = paramzzf;
    this.xQ = paramzza;
  }
  
  private void resume()
  {
    this.zg.lock();
    try
    {
      if (isResuming()) {
        zzasw();
      }
      return;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  public static int zza(Iterable<Api.zze> paramIterable, boolean paramBoolean)
  {
    int k = 1;
    paramIterable = paramIterable.iterator();
    int i = 0;
    int j = 0;
    if (paramIterable.hasNext())
    {
      Api.zze localzze = (Api.zze)paramIterable.next();
      if (localzze.zzain()) {
        j = 1;
      }
      if (!localzze.zzajc()) {
        break label88;
      }
      i = 1;
    }
    label88:
    for (;;)
    {
      break;
      if (j != 0)
      {
        j = k;
        if (i != 0)
        {
          j = k;
          if (!paramBoolean) {}
        }
      }
      for (j = 2;; j = 3) {
        return j;
      }
    }
  }
  
  private void zza(final GoogleApiClient paramGoogleApiClient, final zzsc paramzzsc, final boolean paramBoolean)
  {
    zzsn.EU.zzg(paramGoogleApiClient).setResultCallback(new ResultCallback()
    {
      public void zzp(@NonNull Status paramAnonymousStatus)
      {
        com.google.android.gms.auth.api.signin.internal.zzk.zzba(zzrd.zzc(zzrd.this)).zzajo();
        if ((paramAnonymousStatus.isSuccess()) && (zzrd.this.isConnected())) {
          zzrd.this.reconnect();
        }
        paramzzsc.zzc(paramAnonymousStatus);
        if (paramBoolean) {
          paramGoogleApiClient.disconnect();
        }
      }
    });
  }
  
  private void zzasw()
  {
    this.Ab.zzawd();
    this.Ac.connect();
  }
  
  private void zzasx()
  {
    this.zg.lock();
    try
    {
      if (zzasz()) {
        zzasw();
      }
      return;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  private void zzb(@NonNull zzrn paramzzrn)
  {
    if (this.xN >= 0)
    {
      zzqm.zza(paramzzrn).zzfs(this.xN);
      return;
    }
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  private void zzfv(int paramInt)
  {
    label22:
    Object localObject2;
    if (this.An == null)
    {
      this.An = Integer.valueOf(paramInt);
      if (this.Ac == null) {}
    }
    else
    {
      if (this.An.intValue() == paramInt) {
        break label405;
      }
      localObject1 = String.valueOf(zzfw(paramInt));
      localObject2 = String.valueOf(zzfw(this.An.intValue()));
      throw new IllegalStateException(String.valueOf(localObject1).length() + 51 + String.valueOf(localObject2).length() + "Cannot use sign-in mode: " + (String)localObject1 + ". Mode was already set to " + (String)localObject2);
    }
    Object localObject1 = this.Aj.values().iterator();
    paramInt = 0;
    int i = 0;
    label134:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Api.zze)((Iterator)localObject1).next();
      if (((Api.zze)localObject2).zzain()) {
        i = 1;
      }
      if (!((Api.zze)localObject2).zzajc()) {
        break label407;
      }
      paramInt = 1;
    }
    label405:
    label407:
    for (;;)
    {
      break label134;
      switch (this.An.intValue())
      {
      }
      for (;;)
      {
        if ((this.xT) && (i == 0) && (paramInt == 0))
        {
          this.Ac = new zzqu(this.mContext, this.zg, this.zzajy, this.xP, this.Aj, this.zk, this.Am, this);
          break;
          if (i == 0) {
            throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
          }
          if (paramInt != 0)
          {
            throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            if (i != 0)
            {
              this.Ac = zzqt.zza(this.mContext, this, this.zg, this.zzajy, this.xP, this.Aj, this.zP, this.zk, this.xQ, this.Am);
              break;
            }
          }
        }
      }
      this.Ac = new zzrf(this.mContext, this, this.zg, this.zzajy, this.xP, this.Aj, this.zP, this.zk, this.xQ, this.Am, this);
      break label22;
      break;
    }
  }
  
  static String zzfw(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "UNKNOWN";
    }
    for (;;)
    {
      return str;
      str = "SIGN_IN_MODE_NONE";
      continue;
      str = "SIGN_IN_MODE_REQUIRED";
      continue;
      str = "SIGN_IN_MODE_OPTIONAL";
    }
  }
  
  public ConnectionResult blockingConnect()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzaa.zza(bool1, "blockingConnect must not be called on the UI thread");
      this.zg.lock();
      try
      {
        if (this.xN >= 0) {
          if (this.An != null)
          {
            bool1 = bool2;
            label45:
            zzaa.zza(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
          }
        }
        do
        {
          for (;;)
          {
            zzfv(this.An.intValue());
            this.Ab.zzawd();
            ConnectionResult localConnectionResult = this.Ac.blockingConnect();
            return localConnectionResult;
            bool1 = false;
            break;
            bool1 = false;
            break label45;
            if (this.An != null) {
              break label143;
            }
            this.An = Integer.valueOf(zza(this.Aj.values(), false));
          }
        } while (this.An.intValue() != 2);
      }
      finally
      {
        this.zg.unlock();
      }
    }
    label143:
    IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
    localIllegalStateException.<init>("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    throw localIllegalStateException;
  }
  
  public ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    boolean bool = false;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    zzaa.zza(bool, "blockingConnect must not be called on the UI thread");
    zzaa.zzb(paramTimeUnit, "TimeUnit must not be null");
    this.zg.lock();
    try
    {
      if (this.An == null) {
        this.An = Integer.valueOf(zza(this.Aj.values(), false));
      }
      while (this.An.intValue() != 2)
      {
        zzfv(this.An.intValue());
        this.Ab.zzawd();
        paramTimeUnit = this.Ac.blockingConnect(paramLong, paramTimeUnit);
        return paramTimeUnit;
      }
      paramTimeUnit = new java/lang/IllegalStateException;
      paramTimeUnit.<init>("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
      throw paramTimeUnit;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  public PendingResult<Status> clearDefaultAccountAndReconnect()
  {
    zzaa.zza(isConnected(), "GoogleApiClient is not connected yet.");
    boolean bool;
    final zzsc localzzsc;
    if (this.An.intValue() != 2)
    {
      bool = true;
      zzaa.zza(bool, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
      localzzsc = new zzsc(this);
      if (!this.Aj.containsKey(zzsn.hg)) {
        break label68;
      }
      zza(this, localzzsc, false);
    }
    for (;;)
    {
      return localzzsc;
      bool = false;
      break;
      label68:
      final AtomicReference localAtomicReference = new AtomicReference();
      GoogleApiClient.ConnectionCallbacks local2 = new GoogleApiClient.ConnectionCallbacks()
      {
        public void onConnected(Bundle paramAnonymousBundle)
        {
          zzrd.zza(zzrd.this, (GoogleApiClient)localAtomicReference.get(), localzzsc, true);
        }
        
        public void onConnectionSuspended(int paramAnonymousInt) {}
      };
      Object localObject = new GoogleApiClient.OnConnectionFailedListener()
      {
        public void onConnectionFailed(@NonNull ConnectionResult paramAnonymousConnectionResult)
        {
          localzzsc.zzc(new Status(8));
        }
      };
      localObject = new GoogleApiClient.Builder(this.mContext).addApi(zzsn.API).addConnectionCallbacks(local2).addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)localObject).setHandler(this.Ah).build();
      localAtomicReference.set(localObject);
      ((GoogleApiClient)localObject).connect();
    }
  }
  
  public void connect()
  {
    boolean bool = false;
    this.zg.lock();
    try
    {
      if (this.xN >= 0)
      {
        if (this.An != null) {
          bool = true;
        }
        zzaa.zza(bool, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      do
      {
        for (;;)
        {
          connect(this.An.intValue());
          return;
          if (this.An != null) {
            break;
          }
          this.An = Integer.valueOf(zza(this.Aj.values(), false));
        }
      } while (this.An.intValue() != 2);
    }
    finally
    {
      this.zg.unlock();
    }
    IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
    localIllegalStateException.<init>("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    throw localIllegalStateException;
  }
  
  /* Error */
  public void connect(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 196 1 0
    //   11: iload_3
    //   12: istore_2
    //   13: iload_1
    //   14: iconst_3
    //   15: if_icmpeq +17 -> 32
    //   18: iload_3
    //   19: istore_2
    //   20: iload_1
    //   21: iconst_1
    //   22: if_icmpeq +10 -> 32
    //   25: iload_1
    //   26: iconst_2
    //   27: if_icmpne +55 -> 82
    //   30: iload_3
    //   31: istore_2
    //   32: new 296	java/lang/StringBuilder
    //   35: astore 4
    //   37: aload 4
    //   39: bipush 33
    //   41: invokespecial 301	java/lang/StringBuilder:<init>	(I)V
    //   44: iload_2
    //   45: aload 4
    //   47: ldc_w 457
    //   50: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: iload_1
    //   54: invokevirtual 460	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 462	com/google/android/gms/common/internal/zzaa:zzb	(ZLjava/lang/Object;)V
    //   63: aload_0
    //   64: iload_1
    //   65: invokespecial 371	com/google/android/gms/internal/zzrd:zzfv	(I)V
    //   68: aload_0
    //   69: invokespecial 202	com/google/android/gms/internal/zzrd:zzasw	()V
    //   72: aload_0
    //   73: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   76: invokeinterface 205 1 0
    //   81: return
    //   82: iconst_0
    //   83: istore_2
    //   84: goto -52 -> 32
    //   87: astore 4
    //   89: aload_0
    //   90: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   93: invokeinterface 205 1 0
    //   98: aload 4
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	zzrd
    //   0	101	1	paramInt	int
    //   12	72	2	bool1	boolean
    //   1	30	3	bool2	boolean
    //   35	11	4	localStringBuilder	StringBuilder
    //   87	12	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	72	87	finally
  }
  
  public void disconnect()
  {
    this.zg.lock();
    try
    {
      this.Ap.release();
      if (this.Ac != null) {
        this.Ac.disconnect();
      }
      this.Al.release();
      Iterator localIterator = this.Ad.iterator();
      while (localIterator.hasNext())
      {
        zzqo.zza localzza = (zzqo.zza)localIterator.next();
        localzza.zza(null);
        localzza.cancel();
      }
      this.Ad.clear();
    }
    finally
    {
      this.zg.unlock();
    }
    zzrm localzzrm = this.Ac;
    if (localzzrm == null) {
      this.zg.unlock();
    }
    for (;;)
    {
      return;
      zzasz();
      this.Ab.zzawc();
      this.zg.unlock();
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(this.mContext);
    paramPrintWriter.append(paramString).append("mResuming=").print(this.Ae);
    paramPrintWriter.append(" mWorkQueue.size()=").print(this.Ad.size());
    this.Ap.dump(paramPrintWriter);
    if (this.Ac != null) {
      this.Ac.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  @NonNull
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    this.zg.lock();
    try
    {
      if ((!isConnected()) && (!isResuming()))
      {
        paramApi = new java/lang/IllegalStateException;
        paramApi.<init>("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
        throw paramApi;
      }
    }
    finally
    {
      this.zg.unlock();
    }
    if (this.Aj.containsKey(paramApi.zzaqv()))
    {
      localObject = this.Ac.getConnectionResult(paramApi);
      if (localObject == null) {
        if (isResuming())
        {
          paramApi = ConnectionResult.wO;
          this.zg.unlock();
        }
      }
      for (;;)
      {
        return paramApi;
        Log.w("GoogleApiClientImpl", zzatb());
        localObject = String.valueOf(paramApi.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map");
        paramApi = new java/lang/Exception;
        paramApi.<init>();
        Log.wtf("GoogleApiClientImpl", (String)localObject, paramApi);
        paramApi = new ConnectionResult(8, null);
        this.zg.unlock();
        continue;
        this.zg.unlock();
        paramApi = (Api<?>)localObject;
      }
    }
    Object localObject = new java/lang/IllegalArgumentException;
    ((IllegalArgumentException)localObject).<init>(String.valueOf(paramApi.getName()).concat(" was never registered with GoogleApiClient"));
    throw ((Throwable)localObject);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public Looper getLooper()
  {
    return this.zzajy;
  }
  
  public int getSessionId()
  {
    return System.identityHashCode(this);
  }
  
  public boolean hasConnectedApi(@NonNull Api<?> paramApi)
  {
    boolean bool = false;
    if (!isConnected()) {
      return bool;
    }
    paramApi = (Api.zze)this.Aj.get(paramApi.zzaqv());
    if ((paramApi != null) && (paramApi.isConnected())) {}
    for (bool = true;; bool = false) {
      break;
    }
  }
  
  public boolean isConnected()
  {
    if ((this.Ac != null) && (this.Ac.isConnected())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isConnecting()
  {
    if ((this.Ac != null) && (this.Ac.isConnecting())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.Ab.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.Ab.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  boolean isResuming()
  {
    return this.Ae;
  }
  
  public void reconnect()
  {
    disconnect();
    connect();
  }
  
  public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.Ab.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Ab.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity)
  {
    zzb(new zzrn(paramFragmentActivity));
  }
  
  public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.Ab.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Ab.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @NonNull
  public <C extends Api.zze> C zza(@NonNull Api.zzc<C> paramzzc)
  {
    paramzzc = (Api.zze)this.Aj.get(paramzzc);
    zzaa.zzb(paramzzc, "Appropriate Api was not requested.");
    return paramzzc;
  }
  
  /* Error */
  public <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(@NonNull T paramT)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 627	com/google/android/gms/internal/zzqo$zza:zzaqv	()Lcom/google/android/gms/common/api/Api$zzc;
    //   4: ifnull +119 -> 123
    //   7: iconst_1
    //   8: istore_2
    //   9: iload_2
    //   10: ldc_w 629
    //   13: invokestatic 462	com/google/android/gms/common/internal/zzaa:zzb	(ZLjava/lang/Object;)V
    //   16: aload_0
    //   17: getfield 146	com/google/android/gms/internal/zzrd:Aj	Ljava/util/Map;
    //   20: aload_1
    //   21: invokevirtual 627	com/google/android/gms/internal/zzqo$zza:zzaqv	()Lcom/google/android/gms/common/api/Api$zzc;
    //   24: invokeinterface 407 2 0
    //   29: istore_2
    //   30: aload_1
    //   31: invokevirtual 633	com/google/android/gms/internal/zzqo$zza:getApi	()Lcom/google/android/gms/common/api/Api;
    //   34: ifnull +94 -> 128
    //   37: aload_1
    //   38: invokevirtual 633	com/google/android/gms/internal/zzqo$zza:getApi	()Lcom/google/android/gms/common/api/Api;
    //   41: invokevirtual 550	com/google/android/gms/common/api/Api:getName	()Ljava/lang/String;
    //   44: astore_3
    //   45: iload_2
    //   46: new 296	java/lang/StringBuilder
    //   49: dup
    //   50: aload_3
    //   51: invokestatic 294	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokevirtual 299	java/lang/String:length	()I
    //   57: bipush 65
    //   59: iadd
    //   60: invokespecial 301	java/lang/StringBuilder:<init>	(I)V
    //   63: ldc_w 635
    //   66: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_3
    //   70: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 637
    //   76: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 313	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 462	com/google/android/gms/common/internal/zzaa:zzb	(ZLjava/lang/Object;)V
    //   85: aload_0
    //   86: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   89: invokeinterface 196 1 0
    //   94: aload_0
    //   95: getfield 80	com/google/android/gms/internal/zzrd:Ac	Lcom/google/android/gms/internal/zzrm;
    //   98: ifnonnull +37 -> 135
    //   101: aload_0
    //   102: getfield 85	com/google/android/gms/internal/zzrd:Ad	Ljava/util/Queue;
    //   105: aload_1
    //   106: invokeinterface 640 2 0
    //   111: pop
    //   112: aload_0
    //   113: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   116: invokeinterface 205 1 0
    //   121: aload_1
    //   122: areturn
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -116 -> 9
    //   128: ldc_w 642
    //   131: astore_3
    //   132: goto -87 -> 45
    //   135: aload_0
    //   136: getfield 80	com/google/android/gms/internal/zzrd:Ac	Lcom/google/android/gms/internal/zzrm;
    //   139: aload_1
    //   140: invokeinterface 644 2 0
    //   145: astore_1
    //   146: aload_0
    //   147: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   150: invokeinterface 205 1 0
    //   155: goto -34 -> 121
    //   158: astore_1
    //   159: aload_0
    //   160: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   163: invokeinterface 205 1 0
    //   168: aload_1
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	zzrd
    //   0	170	1	paramT	T
    //   8	117	2	bool	boolean
    //   44	88	3	str	String
    // Exception table:
    //   from	to	target	type
    //   94	112	158	finally
    //   135	146	158	finally
  }
  
  public void zza(zzsf paramzzsf)
  {
    this.zg.lock();
    try
    {
      if (this.Ao == null)
      {
        HashSet localHashSet = new java/util/HashSet;
        localHashSet.<init>();
        this.Ao = localHashSet;
      }
      this.Ao.add(paramzzsf);
      return;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  public boolean zza(@NonNull Api<?> paramApi)
  {
    return this.Aj.containsKey(paramApi.zzaqv());
  }
  
  public boolean zza(zzsa paramzzsa)
  {
    if ((this.Ac != null) && (this.Ac.zza(paramzzsa))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void zzard()
  {
    if (this.Ac != null) {
      this.Ac.zzard();
    }
  }
  
  void zzasy()
  {
    if (isResuming()) {}
    for (;;)
    {
      return;
      this.Ae = true;
      if (this.Ai == null) {
        this.Ai = this.xP.zza(this.mContext.getApplicationContext(), new zzb(this));
      }
      this.Ah.sendMessageDelayed(this.Ah.obtainMessage(1), this.Af);
      this.Ah.sendMessageDelayed(this.Ah.obtainMessage(2), this.Ag);
    }
  }
  
  boolean zzasz()
  {
    boolean bool = false;
    if (!isResuming()) {}
    for (;;)
    {
      return bool;
      this.Ae = false;
      this.Ah.removeMessages(2);
      this.Ah.removeMessages(1);
      if (this.Ai != null)
      {
        this.Ai.unregister();
        this.Ai = null;
      }
      bool = true;
    }
  }
  
  /* Error */
  boolean zzata()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   8: invokeinterface 196 1 0
    //   13: aload_0
    //   14: getfield 107	com/google/android/gms/internal/zzrd:Ao	Ljava/util/Set;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnonnull +16 -> 35
    //   22: aload_0
    //   23: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   26: invokeinterface 205 1 0
    //   31: iload_2
    //   32: istore_1
    //   33: iload_1
    //   34: ireturn
    //   35: aload_0
    //   36: getfield 107	com/google/android/gms/internal/zzrd:Ao	Ljava/util/Set;
    //   39: invokeinterface 689 1 0
    //   44: istore_2
    //   45: iload_2
    //   46: ifne +5 -> 51
    //   49: iconst_1
    //   50: istore_1
    //   51: aload_0
    //   52: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   55: invokeinterface 205 1 0
    //   60: goto -27 -> 33
    //   63: astore_3
    //   64: aload_0
    //   65: getfield 116	com/google/android/gms/internal/zzrd:zg	Ljava/util/concurrent/locks/Lock;
    //   68: invokeinterface 205 1 0
    //   73: aload_3
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	zzrd
    //   1	50	1	bool1	boolean
    //   3	43	2	bool2	boolean
    //   17	2	3	localSet	Set
    //   63	11	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	18	63	finally
    //   35	45	63	finally
  }
  
  String zzatb()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  <C extends Api.zze> C zzb(Api.zzc<?> paramzzc)
  {
    paramzzc = (Api.zze)this.Aj.get(paramzzc);
    zzaa.zzb(paramzzc, "Appropriate Api was not requested.");
    return paramzzc;
  }
  
  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    boolean bool;
    if (paramT.zzaqv() != null)
    {
      bool = true;
      zzaa.zzb(bool, "This task can not be executed (it's probably a Batch or malformed)");
      bool = this.Aj.containsKey(paramT.zzaqv());
      if (paramT.getApi() == null) {
        break label131;
      }
    }
    label131:
    for (Object localObject = paramT.getApi().getName();; localObject = "the API")
    {
      zzaa.zzb(bool, String.valueOf(localObject).length() + 65 + "GoogleApiClient is not configured to use " + (String)localObject + " required for this call.");
      this.zg.lock();
      try
      {
        if (this.Ac != null) {
          break label138;
        }
        paramT = new java/lang/IllegalStateException;
        paramT.<init>("GoogleApiClient is not connected yet.");
        throw paramT;
      }
      finally
      {
        this.zg.unlock();
      }
      bool = false;
      break;
    }
    label138:
    if (isResuming())
    {
      this.Ad.add(paramT);
      while (!this.Ad.isEmpty())
      {
        localObject = (zzqo.zza)this.Ad.remove();
        this.Ap.zzb((zzqq)localObject);
        ((zzqo.zza)localObject).zzaa(Status.yb);
      }
      this.zg.unlock();
    }
    for (;;)
    {
      return paramT;
      paramT = this.Ac.zzb(paramT);
      this.zg.unlock();
    }
  }
  
  public void zzb(zzsf paramzzsf)
  {
    this.zg.lock();
    for (;;)
    {
      try
      {
        if (this.Ao == null)
        {
          paramzzsf = new java/lang/Exception;
          paramzzsf.<init>();
          Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", paramzzsf);
          return;
        }
        if (!this.Ao.remove(paramzzsf))
        {
          paramzzsf = new java/lang/Exception;
          paramzzsf.<init>();
          Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", paramzzsf);
          continue;
        }
        if (zzata()) {
          continue;
        }
      }
      finally
      {
        this.zg.unlock();
      }
      this.Ac.zzarz();
    }
  }
  
  public void zzc(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 1) && (!paramBoolean)) {
      zzasy();
    }
    this.Ap.zzauf();
    this.Ab.zzgn(paramInt);
    this.Ab.zzawc();
    if (paramInt == 2) {
      zzasw();
    }
  }
  
  public void zzc(ConnectionResult paramConnectionResult)
  {
    if (!this.xP.zzd(this.mContext, paramConnectionResult.getErrorCode())) {
      zzasz();
    }
    if (!isResuming())
    {
      this.Ab.zzn(paramConnectionResult);
      this.Ab.zzawc();
    }
  }
  
  public void zzn(Bundle paramBundle)
  {
    while (!this.Ad.isEmpty()) {
      zzb((zzqo.zza)this.Ad.remove());
    }
    this.Ab.zzp(paramBundle);
  }
  
  public <L> zzrr<L> zzs(@NonNull L paramL)
  {
    this.zg.lock();
    try
    {
      paramL = this.Al.zzb(paramL, this.zzajy);
      return paramL;
    }
    finally
    {
      this.zg.unlock();
    }
  }
  
  final class zza
    extends Handler
  {
    zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        int i = paramMessage.what;
        Log.w("GoogleApiClientImpl", 31 + "Unknown message id: " + i);
      }
      for (;;)
      {
        return;
        zzrd.zzb(zzrd.this);
        continue;
        zzrd.zza(zzrd.this);
      }
    }
  }
  
  static class zzb
    extends zzrj.zza
  {
    private WeakReference<zzrd> Av;
    
    zzb(zzrd paramzzrd)
    {
      this.Av = new WeakReference(paramzzrd);
    }
    
    public void zzarr()
    {
      zzrd localzzrd = (zzrd)this.Av.get();
      if (localzzrd == null) {}
      for (;;)
      {
        return;
        zzrd.zza(localzzrd);
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */