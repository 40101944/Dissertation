package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzm
  extends zzl
  implements Handler.Callback
{
  private final HashMap<zza, zzb> En = new HashMap();
  private final zza Eo;
  private final long Ep;
  private final Handler mHandler;
  private final Context zzatc;
  
  zzm(Context paramContext)
  {
    this.zzatc = paramContext.getApplicationContext();
    this.mHandler = new Handler(paramContext.getMainLooper(), this);
    this.Eo = zza.zzaxr();
    this.Ep = 5000L;
  }
  
  private boolean zza(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzaa.zzb(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      zzb localzzb;
      synchronized (this.En)
      {
        localzzb = (zzb)this.En.get(paramzza);
        if (localzzb == null)
        {
          localzzb = new com/google/android/gms/common/internal/zzm$zzb;
          localzzb.<init>(this, paramzza);
          localzzb.zza(paramServiceConnection, paramString);
          localzzb.zzhw(paramString);
          this.En.put(paramzza, localzzb);
          paramzza = localzzb;
          boolean bool = paramzza.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, paramzza);
        if (localzzb.zza(paramServiceConnection))
        {
          paramServiceConnection = new java/lang/IllegalStateException;
          paramString = String.valueOf(paramzza);
          paramzza = new java/lang/StringBuilder;
          paramzza.<init>(String.valueOf(paramString).length() + 81);
          paramServiceConnection.<init>("Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramString);
          throw paramServiceConnection;
        }
      }
      localzzb.zza(paramServiceConnection, paramString);
      switch (localzzb.getState())
      {
      default: 
        paramzza = localzzb;
        break;
      case 1: 
        paramServiceConnection.onServiceConnected(localzzb.getComponentName(), localzzb.getBinder());
        paramzza = localzzb;
        break;
      case 2: 
        localzzb.zzhw(paramString);
        paramzza = localzzb;
      }
    }
  }
  
  private void zzb(zza paramzza, ServiceConnection paramServiceConnection, String paramString)
  {
    zzaa.zzb(paramServiceConnection, "ServiceConnection must not be null");
    zzb localzzb;
    synchronized (this.En)
    {
      localzzb = (zzb)this.En.get(paramzza);
      if (localzzb == null)
      {
        paramServiceConnection = new java/lang/IllegalStateException;
        paramString = String.valueOf(paramzza);
        paramzza = new java/lang/StringBuilder;
        paramzza.<init>(String.valueOf(paramString).length() + 50);
        paramServiceConnection.<init>("Nonexistent connection status for service config: " + paramString);
        throw paramServiceConnection;
      }
    }
    if (!localzzb.zza(paramServiceConnection))
    {
      paramServiceConnection = new java/lang/IllegalStateException;
      paramzza = String.valueOf(paramzza);
      paramString = new java/lang/StringBuilder;
      paramString.<init>(String.valueOf(paramzza).length() + 76);
      paramServiceConnection.<init>("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramzza);
      throw paramServiceConnection;
    }
    localzzb.zzb(paramServiceConnection, paramString);
    if (localzzb.zzawf())
    {
      paramzza = this.mHandler.obtainMessage(0, paramzza);
      this.mHandler.sendMessageDelayed(paramzza, this.Ep);
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    boolean bool;
    switch (???.what)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      zza localzza = (zza)???.obj;
      synchronized (this.En)
      {
        zzb localzzb = (zzb)this.En.get(localzza);
        if ((localzzb != null) && (localzzb.zzawf()))
        {
          if (localzzb.isBound()) {
            localzzb.zzhx("GmsClientSupervisor");
          }
          this.En.remove(localzza);
        }
        bool = true;
      }
    }
  }
  
  public boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return zza(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  public boolean zza(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    return zza(new zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  public void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    zzb(new zza(paramComponentName), paramServiceConnection, paramString);
  }
  
  public void zzb(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3)
  {
    zzb(new zza(paramString1, paramString2), paramServiceConnection, paramString3);
  }
  
  private static final class zza
  {
    private final String Eq;
    private final ComponentName Er;
    private final String cd;
    
    public zza(ComponentName paramComponentName)
    {
      this.cd = null;
      this.Eq = null;
      this.Er = ((ComponentName)zzaa.zzy(paramComponentName));
    }
    
    public zza(String paramString1, String paramString2)
    {
      this.cd = zzaa.zzib(paramString1);
      this.Eq = zzaa.zzib(paramString2);
      this.Er = null;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {}
      for (;;)
      {
        return bool;
        if (!(paramObject instanceof zza))
        {
          bool = false;
        }
        else
        {
          paramObject = (zza)paramObject;
          if ((!zzz.equal(this.cd, ((zza)paramObject).cd)) || (!zzz.equal(this.Er, ((zza)paramObject).Er))) {
            bool = false;
          }
        }
      }
    }
    
    public int hashCode()
    {
      return zzz.hashCode(new Object[] { this.cd, this.Er });
    }
    
    public String toString()
    {
      if (this.cd == null) {}
      for (String str = this.Er.flattenToString();; str = this.cd) {
        return str;
      }
    }
    
    public Intent zzawe()
    {
      if (this.cd != null) {}
      for (Intent localIntent = new Intent(this.cd).setPackage(this.Eq);; localIntent = new Intent().setComponent(this.Er)) {
        return localIntent;
      }
    }
  }
  
  private final class zzb
  {
    private IBinder DI;
    private ComponentName Er;
    private final zza Es;
    private final Set<ServiceConnection> Et;
    private boolean Eu;
    private final zzm.zza Ev;
    private int mState;
    
    public zzb(zzm.zza paramzza)
    {
      this.Ev = paramzza;
      this.Es = new zza();
      this.Et = new HashSet();
      this.mState = 2;
    }
    
    public IBinder getBinder()
    {
      return this.DI;
    }
    
    public ComponentName getComponentName()
    {
      return this.Er;
    }
    
    public int getState()
    {
      return this.mState;
    }
    
    public boolean isBound()
    {
      return this.Eu;
    }
    
    public void zza(ServiceConnection paramServiceConnection, String paramString)
    {
      zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramServiceConnection, paramString, this.Ev.zzawe());
      this.Et.add(paramServiceConnection);
    }
    
    public boolean zza(ServiceConnection paramServiceConnection)
    {
      return this.Et.contains(paramServiceConnection);
    }
    
    public boolean zzawf()
    {
      return this.Et.isEmpty();
    }
    
    public void zzb(ServiceConnection paramServiceConnection, String paramString)
    {
      zzm.zzc(zzm.this).zzb(zzm.zzb(zzm.this), paramServiceConnection);
      this.Et.remove(paramServiceConnection);
    }
    
    @TargetApi(14)
    public void zzhw(String paramString)
    {
      this.mState = 3;
      this.Eu = zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), paramString, this.Ev.zzawe(), this.Es, 129);
      if (!this.Eu) {
        this.mState = 2;
      }
      try
      {
        zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), this.Es);
        return;
      }
      catch (IllegalArgumentException paramString)
      {
        for (;;) {}
      }
    }
    
    public void zzhx(String paramString)
    {
      zzm.zzc(zzm.this).zza(zzm.zzb(zzm.this), this.Es);
      this.Eu = false;
      this.mState = 2;
    }
    
    public class zza
      implements ServiceConnection
    {
      public zza() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (zzm.zza(zzm.this))
        {
          zzm.zzb.zza(zzm.zzb.this, paramIBinder);
          zzm.zzb.zza(zzm.zzb.this, paramComponentName);
          Iterator localIterator = zzm.zzb.zza(zzm.zzb.this).iterator();
          if (localIterator.hasNext()) {
            ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        zzm.zzb.zza(zzm.zzb.this, 1);
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (zzm.zza(zzm.this))
        {
          zzm.zzb.zza(zzm.zzb.this, null);
          zzm.zzb.zza(zzm.zzb.this, paramComponentName);
          Iterator localIterator = zzm.zzb.zza(zzm.zzb.this).iterator();
          if (localIterator.hasNext()) {
            ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        zzm.zzb.zza(zzm.zzb.this, 2);
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */