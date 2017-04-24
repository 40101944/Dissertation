package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk
  implements Handler.Callback
{
  private final zza Ee;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> Ef = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> Eg = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> Eh = new ArrayList();
  private volatile boolean Ei = false;
  private final AtomicInteger Ej = new AtomicInteger(0);
  private boolean Ek = false;
  private final Handler mHandler;
  private final Object zzako = new Object();
  
  public zzk(Looper paramLooper, zza paramzza)
  {
    this.Ee = paramzza;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public boolean handleMessage(Message arg1)
  {
    GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
    if (???.what == 1) {
      localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)???.obj;
    }
    for (;;)
    {
      synchronized (this.zzako)
      {
        if ((this.Ei) && (this.Ee.isConnected()) && (this.Ef.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(this.Ee.zzapn());
        }
        bool = true;
        return bool;
      }
      int i = ???.what;
      Log.wtf("GmsClientEvents", 45 + "Don't know how to handle message: " + i, new Exception());
      boolean bool = false;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzaa.zzy(paramConnectionCallbacks);
    synchronized (this.zzako)
    {
      boolean bool = this.Ef.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzaa.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzako)
    {
      boolean bool = this.Eh.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzaa.zzy(paramConnectionCallbacks);
    synchronized (this.zzako)
    {
      if (this.Ef.contains(paramConnectionCallbacks))
      {
        String str = String.valueOf(paramConnectionCallbacks);
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(String.valueOf(str).length() + 62);
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + str + " is already registered");
        if (this.Ee.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.Ef.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzaa.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzako)
    {
      if (this.Eh.contains(paramOnConnectionFailedListener))
      {
        paramOnConnectionFailedListener = String.valueOf(paramOnConnectionFailedListener);
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(String.valueOf(paramOnConnectionFailedListener).length() + 67);
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.Eh.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzaa.zzy(paramConnectionCallbacks);
    synchronized (this.zzako)
    {
      if (!this.Ef.remove(paramConnectionCallbacks))
      {
        str = String.valueOf(paramConnectionCallbacks);
        paramConnectionCallbacks = new java/lang/StringBuilder;
        paramConnectionCallbacks.<init>(String.valueOf(str).length() + 52);
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + str + " not found");
      }
      while (!this.Ek)
      {
        String str;
        return;
      }
      this.Eg.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzaa.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzako)
    {
      if (!this.Eh.remove(paramOnConnectionFailedListener))
      {
        String str = String.valueOf(paramOnConnectionFailedListener);
        paramOnConnectionFailedListener = new java/lang/StringBuilder;
        paramOnConnectionFailedListener.<init>(String.valueOf(str).length() + 57);
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + str + " not found");
      }
      return;
    }
  }
  
  public void zzawc()
  {
    this.Ei = false;
    this.Ej.incrementAndGet();
  }
  
  public void zzawd()
  {
    this.Ei = true;
  }
  
  public void zzgn(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      bool = true;
    }
    zzaa.zza(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.zzako)
    {
      this.Ek = true;
      Object localObject2 = new java/util/ArrayList;
      ((ArrayList)localObject2).<init>(this.Ef);
      int i = this.Ej.get();
      Iterator localIterator = ((ArrayList)localObject2).iterator();
      do
      {
        if (localIterator.hasNext())
        {
          localObject2 = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
          if ((this.Ei) && (this.Ej.get() == i)) {}
        }
        else
        {
          this.Eg.clear();
          this.Ek = false;
          return;
        }
      } while (!this.Ef.contains(localObject2));
      ((GoogleApiClient.ConnectionCallbacks)localObject2).onConnectionSuspended(paramInt);
    }
  }
  
  public void zzn(ConnectionResult paramConnectionResult)
  {
    boolean bool;
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      bool = true;
      zzaa.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
    }
    for (;;)
    {
      synchronized (this.zzako)
      {
        Object localObject2 = new java/util/ArrayList;
        ((ArrayList)localObject2).<init>(this.Eh);
        int i = this.Ej.get();
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (GoogleApiClient.OnConnectionFailedListener)localIterator.next();
          if ((!this.Ei) || (this.Ej.get() != i))
          {
            return;
            bool = false;
            break;
          }
          if (!this.Eh.contains(localObject2)) {
            continue;
          }
          ((GoogleApiClient.OnConnectionFailedListener)localObject2).onConnectionFailed(paramConnectionResult);
        }
      }
    }
  }
  
  public void zzp(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzaa.zza(bool1, "onConnectionSuccess must only be called on the Handler thread");
      synchronized (this.zzako)
      {
        label42:
        label72:
        Object localObject2;
        int i;
        if (!this.Ek)
        {
          bool1 = true;
          zzaa.zzbs(bool1);
          this.mHandler.removeMessages(1);
          this.Ek = true;
          if (this.Eg.size() != 0) {
            break label183;
          }
          bool1 = bool2;
          zzaa.zzbs(bool1);
          localObject2 = new java/util/ArrayList;
          ((ArrayList)localObject2).<init>(this.Ef);
          i = this.Ej.get();
          localObject2 = ((ArrayList)localObject2).iterator();
        }
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
        label183:
        do
        {
          if (((Iterator)localObject2).hasNext())
          {
            localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
            if ((this.Ei) && (this.Ee.isConnected()) && (this.Ej.get() == i)) {}
          }
          else
          {
            this.Eg.clear();
            this.Ek = false;
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label42;
            bool1 = false;
            break label72;
          }
        } while (this.Eg.contains(localConnectionCallbacks));
        localConnectionCallbacks.onConnected(paramBundle);
      }
    }
  }
  
  public static abstract interface zza
  {
    public abstract boolean isConnected();
    
    public abstract Bundle zzapn();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */