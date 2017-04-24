package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zze<T extends IInterface>
{
  public static final String[] DB = { "service_esmobile", "service_googleme" };
  protected AtomicInteger DA = new AtomicInteger(0);
  private int Dj;
  private long Dk;
  private long Dl;
  private int Dm;
  private long Dn;
  private final zzl Do;
  private final Object Dp = new Object();
  private zzt Dq;
  protected zzf Dr;
  private T Ds;
  private final ArrayList<zze<?>> Dt = new ArrayList();
  private zzh Du;
  private int Dv = 1;
  private final zzb Dw;
  private final zzc Dx;
  private final int Dy;
  private final String Dz;
  private final Context mContext;
  final Handler mHandler;
  private final zzc zm;
  private final Looper zzajy;
  private final Object zzako = new Object();
  
  protected zze(Context paramContext, Looper paramLooper, int paramInt, zzb paramzzb, zzc paramzzc, String paramString)
  {
    this(paramContext, paramLooper, zzl.zzcc(paramContext), zzc.zzaql(), paramInt, (zzb)zzaa.zzy(paramzzb), (zzc)zzaa.zzy(paramzzc), paramString);
  }
  
  protected zze(Context paramContext, Looper paramLooper, zzl paramzzl, zzc paramzzc, int paramInt, zzb paramzzb, zzc paramzzc1, String paramString)
  {
    this.mContext = ((Context)zzaa.zzb(paramContext, "Context must not be null"));
    this.zzajy = ((Looper)zzaa.zzb(paramLooper, "Looper must not be null"));
    this.Do = ((zzl)zzaa.zzb(paramzzl, "Supervisor must not be null"));
    this.zm = ((zzc)zzaa.zzb(paramzzc, "API availability must not be null"));
    this.mHandler = new zzd(paramLooper);
    this.Dy = paramInt;
    this.Dw = paramzzb;
    this.Dx = paramzzc1;
    this.Dz = paramString;
  }
  
  private boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.zzako)
    {
      if (this.Dv != paramInt1)
      {
        bool = false;
        return bool;
      }
      zzb(paramInt2, paramT);
      boolean bool = true;
    }
  }
  
  private void zzavb()
  {
    String str2;
    String str1;
    if (this.Du != null)
    {
      str2 = String.valueOf(zzjx());
      str1 = String.valueOf(zzauz());
      Log.e("GmsClient", String.valueOf(str2).length() + 70 + String.valueOf(str1).length() + "Calling connect() while still connected, missing disconnect() for " + str2 + " on " + str1);
      this.Do.zzb(zzjx(), zzauz(), this.Du, zzava());
      this.DA.incrementAndGet();
    }
    this.Du = new zzh(this.DA.get());
    if (!this.Do.zza(zzjx(), zzauz(), this.Du, zzava()))
    {
      str2 = String.valueOf(zzjx());
      str1 = String.valueOf(zzauz());
      Log.e("GmsClient", String.valueOf(str2).length() + 34 + String.valueOf(str1).length() + "unable to connect to service: " + str2 + " on " + str1);
      zza(16, null, this.DA.get());
    }
  }
  
  private void zzavc()
  {
    if (this.Du != null)
    {
      this.Do.zzb(zzjx(), zzauz(), this.Du, zzava());
      this.Du = null;
    }
  }
  
  private void zzb(int paramInt, T paramT)
  {
    boolean bool = true;
    int i;
    int j;
    if (paramInt == 3)
    {
      i = 1;
      if (paramT == null) {
        break label89;
      }
      j = 1;
      label17:
      if (i != j) {
        break label95;
      }
      zzaa.zzbt(bool);
    }
    for (;;)
    {
      synchronized (this.zzako)
      {
        this.Dv = paramInt;
        this.Ds = paramT;
        zzc(paramInt, paramT);
        switch (paramInt)
        {
        default: 
          return;
          i = 0;
          break;
          j = 0;
          break label17;
          bool = false;
          break;
        case 2: 
          label89:
          label95:
          zzavb();
        }
      }
      zza(paramT);
      continue;
      zzavc();
    }
  }
  
  private void zzl(ConnectionResult paramConnectionResult)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.DA.get(), paramConnectionResult.getErrorCode(), paramConnectionResult.getResolution()));
  }
  
  public void disconnect()
  {
    this.DA.incrementAndGet();
    synchronized (this.Dt)
    {
      int j = this.Dt.size();
      for (int i = 0; i < j; i++) {
        ((zze)this.Dt.get(i)).zzavm();
      }
      this.Dt.clear();
    }
    synchronized (this.Dp)
    {
      this.Dq = null;
      zzb(1, null);
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public void dump(String paramString, FileDescriptor arg2, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    for (;;)
    {
      synchronized (this.zzako)
      {
        int i = this.Dv;
        paramArrayOfString = this.Ds;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (paramArrayOfString != null) {
            break label482;
          }
          paramPrintWriter.println("null");
          ??? = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
          long l;
          String str;
          if (this.Dl > 0L)
          {
            paramArrayOfString = paramPrintWriter.append(paramString).append("lastConnectedTime=");
            l = this.Dl;
            str = String.valueOf(???.format(new Date(this.Dl)));
            paramArrayOfString.println(String.valueOf(str).length() + 21 + l + " " + str);
          }
          if (this.Dk > 0L) {
            paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          }
          switch (this.Dj)
          {
          default: 
            paramPrintWriter.append(String.valueOf(this.Dj));
            paramArrayOfString = paramPrintWriter.append(" lastSuspendedTime=");
            l = this.Dk;
            str = String.valueOf(???.format(new Date(this.Dk)));
            paramArrayOfString.println(String.valueOf(str).length() + 21 + l + " " + str);
            if (this.Dn > 0L)
            {
              paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.Dm));
              paramString = paramPrintWriter.append(" lastFailedTime=");
              l = this.Dn;
              ??? = String.valueOf(???.format(new Date(this.Dn)));
              paramString.println(String.valueOf(???).length() + 21 + l + " " + ???);
            }
            return;
          }
          break;
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
      continue;
      label482:
      paramPrintWriter.append(zzjy()).append("@").println(Integer.toHexString(System.identityHashCode(paramArrayOfString.asBinder())));
      continue;
      paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
      continue;
      paramPrintWriter.append("CAUSE_NETWORK_LOST");
    }
  }
  
  public Account getAccount()
  {
    return null;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.zzajy;
  }
  
  public boolean isConnected()
  {
    synchronized (this.zzako)
    {
      if (this.Dv == 3)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    synchronized (this.zzako)
    {
      if (this.Dv == 2)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  @CallSuper
  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.Dm = paramConnectionResult.getErrorCode();
    this.Dn = System.currentTimeMillis();
  }
  
  @CallSuper
  protected void onConnectionSuspended(int paramInt)
  {
    this.Dj = paramInt;
    this.Dk = System.currentTimeMillis();
  }
  
  protected void zza(int paramInt1, @Nullable Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(5, paramInt2, -1, new zzk(paramInt1, paramBundle)));
  }
  
  @BinderThread
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramInt2, -1, new zzj(paramInt1, paramIBinder, paramBundle)));
  }
  
  @CallSuper
  protected void zza(@NonNull T paramT)
  {
    this.Dl = System.currentTimeMillis();
  }
  
  public void zza(@NonNull zzf paramzzf)
  {
    this.Dr = ((zzf)zzaa.zzb(paramzzf, "Connection progress callbacks cannot be null."));
    zzb(2, null);
  }
  
  public void zza(zzf paramzzf, ConnectionResult paramConnectionResult)
  {
    this.Dr = ((zzf)zzaa.zzb(paramzzf, "Connection progress callbacks cannot be null."));
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.DA.get(), paramConnectionResult.getErrorCode(), paramConnectionResult.getResolution()));
  }
  
  /* Error */
  @android.support.annotation.WorkerThread
  public void zza(zzp arg1, Set<Scope> paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 466	com/google/android/gms/common/internal/zze:zzahv	()Landroid/os/Bundle;
    //   4: astore_3
    //   5: new 468	com/google/android/gms/common/internal/GetServiceRequest
    //   8: dup
    //   9: aload_0
    //   10: getfield 166	com/google/android/gms/common/internal/zze:Dy	I
    //   13: invokespecial 469	com/google/android/gms/common/internal/GetServiceRequest:<init>	(I)V
    //   16: aload_0
    //   17: getfield 145	com/google/android/gms/common/internal/zze:mContext	Landroid/content/Context;
    //   20: invokevirtual 472	android/content/Context:getPackageName	()Ljava/lang/String;
    //   23: invokevirtual 476	com/google/android/gms/common/internal/GetServiceRequest:zzhv	(Ljava/lang/String;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   26: aload_3
    //   27: invokevirtual 480	com/google/android/gms/common/internal/GetServiceRequest:zzo	(Landroid/os/Bundle;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   30: astore_3
    //   31: aload_2
    //   32: ifnull +9 -> 41
    //   35: aload_3
    //   36: aload_2
    //   37: invokevirtual 483	com/google/android/gms/common/internal/GetServiceRequest:zzf	(Ljava/util/Collection;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 486	com/google/android/gms/common/internal/zze:zzain	()Z
    //   45: ifeq +65 -> 110
    //   48: aload_3
    //   49: aload_0
    //   50: invokevirtual 489	com/google/android/gms/common/internal/zze:zzave	()Landroid/accounts/Account;
    //   53: invokevirtual 492	com/google/android/gms/common/internal/GetServiceRequest:zze	(Landroid/accounts/Account;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   56: aload_1
    //   57: invokevirtual 495	com/google/android/gms/common/internal/GetServiceRequest:zzb	(Lcom/google/android/gms/common/internal/zzp;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   60: pop
    //   61: aload_0
    //   62: getfield 122	com/google/android/gms/common/internal/zze:Dp	Ljava/lang/Object;
    //   65: astore_1
    //   66: aload_1
    //   67: monitorenter
    //   68: aload_0
    //   69: getfield 175	com/google/android/gms/common/internal/zze:Dq	Lcom/google/android/gms/common/internal/zzt;
    //   72: ifnull +57 -> 129
    //   75: aload_0
    //   76: getfield 175	com/google/android/gms/common/internal/zze:Dq	Lcom/google/android/gms/common/internal/zzt;
    //   79: astore_2
    //   80: new 25	com/google/android/gms/common/internal/zze$zzg
    //   83: astore 4
    //   85: aload 4
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 136	com/google/android/gms/common/internal/zze:DA	Ljava/util/concurrent/atomic/AtomicInteger;
    //   92: invokevirtual 243	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   95: invokespecial 496	com/google/android/gms/common/internal/zze$zzg:<init>	(Lcom/google/android/gms/common/internal/zze;I)V
    //   98: aload_2
    //   99: aload 4
    //   101: aload_3
    //   102: invokeinterface 501 3 0
    //   107: aload_1
    //   108: monitorexit
    //   109: return
    //   110: aload_0
    //   111: invokevirtual 504	com/google/android/gms/common/internal/zze:zzavh	()Z
    //   114: ifeq -53 -> 61
    //   117: aload_3
    //   118: aload_0
    //   119: invokevirtual 506	com/google/android/gms/common/internal/zze:getAccount	()Landroid/accounts/Account;
    //   122: invokevirtual 492	com/google/android/gms/common/internal/GetServiceRequest:zze	(Landroid/accounts/Account;)Lcom/google/android/gms/common/internal/GetServiceRequest;
    //   125: pop
    //   126: goto -65 -> 61
    //   129: ldc -49
    //   131: ldc_w 508
    //   134: invokestatic 511	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   137: pop
    //   138: goto -31 -> 107
    //   141: astore_2
    //   142: aload_1
    //   143: monitorexit
    //   144: aload_2
    //   145: athrow
    //   146: astore_1
    //   147: ldc -49
    //   149: ldc_w 513
    //   152: invokestatic 511	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   155: pop
    //   156: aload_0
    //   157: iconst_1
    //   158: invokevirtual 516	com/google/android/gms/common/internal/zze:zzgk	(I)V
    //   161: goto -52 -> 109
    //   164: astore_1
    //   165: ldc -49
    //   167: ldc_w 518
    //   170: aload_1
    //   171: invokestatic 521	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   174: pop
    //   175: goto -66 -> 109
    //   178: astore_1
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: ldc -49
    //   184: ldc_w 523
    //   187: aload_1
    //   188: invokestatic 521	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   191: pop
    //   192: aload_0
    //   193: new 276	com/google/android/gms/common/ConnectionResult
    //   196: dup
    //   197: bipush 8
    //   199: aconst_null
    //   200: ldc_w 525
    //   203: invokespecial 528	com/google/android/gms/common/ConnectionResult:<init>	(ILandroid/app/PendingIntent;Ljava/lang/String;)V
    //   206: invokespecial 185	com/google/android/gms/common/internal/zze:zzl	(Lcom/google/android/gms/common/ConnectionResult;)V
    //   209: goto -100 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	zze
    //   0	212	2	paramSet	Set<Scope>
    //   4	114	3	localObject	Object
    //   83	17	4	localzzg	zzg
    // Exception table:
    //   from	to	target	type
    //   68	107	141	finally
    //   107	109	141	finally
    //   129	138	141	finally
    //   142	144	141	finally
    //   61	68	146	android/os/DeadObjectException
    //   144	146	146	android/os/DeadObjectException
    //   61	68	164	android/os/RemoteException
    //   144	146	164	android/os/RemoteException
    //   61	68	178	java/lang/SecurityException
    //   144	146	178	java/lang/SecurityException
    //   61	68	181	java/lang/RuntimeException
    //   144	146	181	java/lang/RuntimeException
  }
  
  protected Bundle zzahv()
  {
    return new Bundle();
  }
  
  public boolean zzain()
  {
    return false;
  }
  
  public boolean zzajc()
  {
    return false;
  }
  
  public Intent zzajd()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  public Bundle zzapn()
  {
    return null;
  }
  
  public boolean zzaqx()
  {
    return true;
  }
  
  @Nullable
  public IBinder zzaqy()
  {
    synchronized (this.Dp)
    {
      if (this.Dq == null)
      {
        localIBinder = null;
        return localIBinder;
      }
      IBinder localIBinder = this.Dq.asBinder();
    }
  }
  
  protected String zzauz()
  {
    return "com.google.android.gms";
  }
  
  @Nullable
  protected final String zzava()
  {
    if (this.Dz == null) {}
    for (String str = this.mContext.getClass().getName();; str = this.Dz) {
      return str;
    }
  }
  
  public void zzavd()
  {
    int i = this.zm.isGooglePlayServicesAvailable(this.mContext);
    if (i != 0)
    {
      zzb(1, null);
      this.Dr = new zzi();
      this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.DA.get(), i));
    }
    for (;;)
    {
      return;
      zza(new zzi());
    }
  }
  
  public final Account zzave()
  {
    if (getAccount() != null) {}
    for (Account localAccount = getAccount();; localAccount = new Account("<<default account>>", "com.google")) {
      return localAccount;
    }
  }
  
  protected final void zzavf()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public final T zzavg()
    throws DeadObjectException
  {
    synchronized (this.zzako)
    {
      if (this.Dv == 4)
      {
        DeadObjectException localDeadObjectException = new android/os/DeadObjectException;
        localDeadObjectException.<init>();
        throw localDeadObjectException;
      }
    }
    zzavf();
    if (this.Ds != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzaa.zza(bool, "Client is connected but service is null");
      IInterface localIInterface = this.Ds;
      return localIInterface;
    }
  }
  
  public boolean zzavh()
  {
    return false;
  }
  
  protected Set<Scope> zzavi()
  {
    return Collections.EMPTY_SET;
  }
  
  void zzc(int paramInt, T paramT) {}
  
  public void zzgk(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.DA.get(), paramInt));
  }
  
  @Nullable
  protected abstract T zzh(IBinder paramIBinder);
  
  @NonNull
  protected abstract String zzjx();
  
  @NonNull
  protected abstract String zzjy();
  
  private abstract class zza
    extends zze.zze<Boolean>
  {
    public final Bundle DC;
    public final int statusCode;
    
    @BinderThread
    protected zza(int paramInt, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramInt;
      this.DC = paramBundle;
    }
    
    protected abstract boolean zzavj();
    
    protected void zzavk() {}
    
    protected void zzc(Boolean paramBoolean)
    {
      Object localObject = null;
      if (paramBoolean == null) {
        zze.zza(zze.this, 1, null);
      }
      for (;;)
      {
        return;
        switch (this.statusCode)
        {
        default: 
          zze.zza(zze.this, 1, null);
          paramBoolean = (Boolean)localObject;
          if (this.DC != null) {
            paramBoolean = (PendingIntent)this.DC.getParcelable("pendingIntent");
          }
          zzm(new ConnectionResult(this.statusCode, paramBoolean));
          break;
        case 0: 
          if (!zzavj())
          {
            zze.zza(zze.this, 1, null);
            zzm(new ConnectionResult(8, null));
          }
          break;
        }
      }
      zze.zza(zze.this, 1, null);
      throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }
    
    protected abstract void zzm(ConnectionResult paramConnectionResult);
  }
  
  public static abstract interface zzb
  {
    public abstract void onConnected(@Nullable Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface zzc
  {
    public abstract void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult);
  }
  
  final class zzd
    extends Handler
  {
    public zzd(Looper paramLooper)
    {
      super();
    }
    
    private void zza(Message paramMessage)
    {
      paramMessage = (zze.zze)paramMessage.obj;
      paramMessage.zzavk();
      paramMessage.unregister();
    }
    
    private boolean zzb(Message paramMessage)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramMessage.what != 2)
      {
        bool1 = bool2;
        if (paramMessage.what != 1) {
          if (paramMessage.what != 5) {
            break label34;
          }
        }
      }
      label34:
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      PendingIntent localPendingIntent = null;
      if (zze.this.DA.get() != paramMessage.arg1) {
        if (zzb(paramMessage)) {
          zza(paramMessage);
        }
      }
      for (;;)
      {
        return;
        if (((paramMessage.what == 1) || (paramMessage.what == 5)) && (!zze.this.isConnecting()))
        {
          zza(paramMessage);
        }
        else if (paramMessage.what == 3)
        {
          if ((paramMessage.obj instanceof PendingIntent)) {
            localPendingIntent = (PendingIntent)paramMessage.obj;
          }
          paramMessage = new ConnectionResult(paramMessage.arg2, localPendingIntent);
          zze.this.Dr.zzg(paramMessage);
          zze.this.onConnectionFailed(paramMessage);
        }
        else if (paramMessage.what == 4)
        {
          zze.zza(zze.this, 4, null);
          if (zze.zzb(zze.this) != null) {
            zze.zzb(zze.this).onConnectionSuspended(paramMessage.arg2);
          }
          zze.this.onConnectionSuspended(paramMessage.arg2);
          zze.zza(zze.this, 4, 1, null);
        }
        else if ((paramMessage.what == 2) && (!zze.this.isConnected()))
        {
          zza(paramMessage);
        }
        else if (zzb(paramMessage))
        {
          ((zze.zze)paramMessage.obj).zzavl();
        }
        else
        {
          int i = paramMessage.what;
          Log.wtf("GmsClient", 45 + "Don't know how to handle message: " + i, new Exception());
        }
      }
    }
  }
  
  protected abstract class zze<TListener>
  {
    private boolean DE;
    private TListener mListener;
    
    public zze()
    {
      Object localObject;
      this.mListener = localObject;
      this.DE = false;
    }
    
    public void unregister()
    {
      zzavm();
      synchronized (zze.zzc(zze.this))
      {
        zze.zzc(zze.this).remove(this);
        return;
      }
    }
    
    protected abstract void zzavk();
    
    public void zzavl()
    {
      for (;;)
      {
        try
        {
          Object localObject3 = this.mListener;
          if (this.DE)
          {
            String str = String.valueOf(this);
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>(String.valueOf(str).length() + 47);
            Log.w("GmsClient", "Callback proxy " + str + " being reused. This is not safe.");
          }
          if (localObject3 != null) {}
          zzavk();
        }
        finally
        {
          try
          {
            zzv(localObject3);
          }
          catch (RuntimeException localRuntimeException)
          {
            zzavk();
            throw localRuntimeException;
          }
          try
          {
            this.DE = true;
            unregister();
            return;
          }
          finally {}
          localObject1 = finally;
        }
      }
    }
    
    public void zzavm()
    {
      try
      {
        this.mListener = null;
        return;
      }
      finally {}
    }
    
    protected abstract void zzv(TListener paramTListener);
  }
  
  public static abstract interface zzf
  {
    public abstract void zzg(@NonNull ConnectionResult paramConnectionResult);
  }
  
  public static final class zzg
    extends zzs.zza
  {
    private zze DF;
    private final int DG;
    
    public zzg(@NonNull zze paramzze, int paramInt)
    {
      this.DF = paramzze;
      this.DG = paramInt;
    }
    
    private void zzavn()
    {
      this.DF = null;
    }
    
    @BinderThread
    public void zza(int paramInt, @NonNull IBinder paramIBinder, @Nullable Bundle paramBundle)
    {
      zzaa.zzb(this.DF, "onPostInitComplete can be called only once per call to getRemoteService");
      this.DF.zza(paramInt, paramIBinder, paramBundle, this.DG);
      zzavn();
    }
    
    @BinderThread
    public void zzb(int paramInt, @Nullable Bundle paramBundle)
    {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
  }
  
  public final class zzh
    implements ServiceConnection
  {
    private final int DG;
    
    public zzh(int paramInt)
    {
      this.DG = paramInt;
    }
    
    public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        zze.zza(zze.this, new ConnectionResult(8, null, "ServiceBroker IBinder is null"));
      }
      for (;;)
      {
        return;
        synchronized (zze.zza(zze.this))
        {
          zze.zza(zze.this, zzt.zza.zzdu(paramIBinder));
          zze.this.zza(0, null, this.DG);
        }
      }
    }
    
    public void onServiceDisconnected(ComponentName arg1)
    {
      synchronized (zze.zza(zze.this))
      {
        zze.zza(zze.this, null);
        zze.this.mHandler.sendMessage(zze.this.mHandler.obtainMessage(4, this.DG, 1));
        return;
      }
    }
  }
  
  protected class zzi
    implements zze.zzf
  {
    public zzi() {}
    
    public void zzg(@NonNull ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess()) {
        zze.this.zza(null, zze.this.zzavi());
      }
      for (;;)
      {
        return;
        if (zze.zzd(zze.this) != null) {
          zze.zzd(zze.this).onConnectionFailed(paramConnectionResult);
        }
      }
    }
  }
  
  protected final class zzj
    extends zze.zza
  {
    public final IBinder DH;
    
    @BinderThread
    public zzj(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      this.DH = paramIBinder;
    }
    
    protected boolean zzavj()
    {
      bool2 = false;
      try
      {
        String str1 = this.DH.getInterfaceDescriptor();
        if (zze.this.zzjy().equals(str1)) {
          break label110;
        }
        String str2 = String.valueOf(zze.this.zzjy());
        Log.e("GmsClient", String.valueOf(str2).length() + 34 + String.valueOf(str1).length() + "service descriptor mismatch: " + str2 + " vs. " + str1);
        bool1 = bool2;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          Log.w("GmsClient", "service probably died");
          boolean bool1 = bool2;
          continue;
          Object localObject = zze.this.zzh(this.DH);
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (zze.zza(zze.this, 2, 3, (IInterface)localObject))
            {
              localObject = zze.this.zzapn();
              if (zze.zzb(zze.this) != null) {
                zze.zzb(zze.this).onConnected((Bundle)localObject);
              }
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    protected void zzm(ConnectionResult paramConnectionResult)
    {
      if (zze.zzd(zze.this) != null) {
        zze.zzd(zze.this).onConnectionFailed(paramConnectionResult);
      }
      zze.this.onConnectionFailed(paramConnectionResult);
    }
  }
  
  protected final class zzk
    extends zze.zza
  {
    @BinderThread
    public zzk(int paramInt, @Nullable Bundle paramBundle)
    {
      super(paramInt, paramBundle);
    }
    
    protected boolean zzavj()
    {
      zze.this.Dr.zzg(ConnectionResult.wO);
      return true;
    }
    
    protected void zzm(ConnectionResult paramConnectionResult)
    {
      zze.this.Dr.zzg(paramConnectionResult);
      zze.this.onConnectionFailed(paramConnectionResult);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */