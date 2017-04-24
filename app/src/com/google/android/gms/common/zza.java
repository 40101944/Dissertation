package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzaa;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zza
  implements ServiceConnection
{
  boolean wM = false;
  private final BlockingQueue<IBinder> wN = new LinkedBlockingQueue();
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.wN.add(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public IBinder zza(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, TimeoutException
  {
    zzaa.zzht("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
    if (this.wM) {
      throw new IllegalStateException("Cannot call get on this connection more than once");
    }
    this.wM = true;
    paramTimeUnit = (IBinder)this.wN.poll(paramLong, paramTimeUnit);
    if (paramTimeUnit == null) {
      throw new TimeoutException("Timed out waiting for the service connection");
    }
    return paramTimeUnit;
  }
  
  public IBinder zzaqk()
    throws InterruptedException
  {
    zzaa.zzht("BlockingServiceConnection.getService() called on main thread");
    if (this.wM) {
      throw new IllegalStateException("Cannot call get on this connection more than once");
    }
    this.wM = true;
    return (IBinder)this.wN.take();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */