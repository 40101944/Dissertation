package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzaa;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzqm
  extends zzqp
{
  private final SparseArray<zza> yq = new SparseArray();
  
  private zzqm(zzrp paramzzrp)
  {
    super(paramzzrp);
    this.Bf.zza("AutoManageHelper", this);
  }
  
  public static zzqm zza(zzrn paramzzrn)
  {
    zzrp localzzrp = zzc(paramzzrn);
    paramzzrn = (zzqm)localzzrp.zza("AutoManageHelper", zzqm.class);
    if (paramzzrn != null) {}
    for (;;)
    {
      return paramzzrn;
      paramzzrn = new zzqm(localzzrp);
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    for (int i = 0; i < this.yq.size(); i++) {
      ((zza)this.yq.valueAt(i)).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    boolean bool = this.mStarted;
    String str = String.valueOf(this.yq);
    Log.d("AutoManageHelper", String.valueOf(str).length() + 14 + "onStart " + bool + " " + str);
    if (!this.yz) {
      for (int i = 0; i < this.yq.size(); i++) {
        ((zza)this.yq.valueAt(i)).ys.connect();
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    for (int i = 0; i < this.yq.size(); i++) {
      ((zza)this.yq.valueAt(i)).ys.disconnect();
    }
  }
  
  public void zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzaa.zzb(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (this.yq.indexOfKey(paramInt) < 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzaa.zza(bool1, 54 + "Already managing a GoogleApiClient with id " + paramInt);
      bool1 = this.mStarted;
      boolean bool2 = this.yz;
      Log.d("AutoManageHelper", 54 + "starting AutoManage for client " + paramInt + " " + bool1 + " " + bool2);
      paramOnConnectionFailedListener = new zza(paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
      this.yq.put(paramInt, paramOnConnectionFailedListener);
      if ((this.mStarted) && (!this.yz))
      {
        paramOnConnectionFailedListener = String.valueOf(paramGoogleApiClient);
        Log.d("AutoManageHelper", String.valueOf(paramOnConnectionFailedListener).length() + 11 + "connecting " + paramOnConnectionFailedListener);
        paramGoogleApiClient.connect();
      }
      return;
    }
  }
  
  protected void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
    if (paramInt < 0) {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
    }
    for (;;)
    {
      return;
      Object localObject = (zza)this.yq.get(paramInt);
      if (localObject != null)
      {
        zzfs(paramInt);
        localObject = ((zza)localObject).yt;
        if (localObject != null) {
          ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
        }
      }
    }
  }
  
  protected void zzarm()
  {
    for (int i = 0; i < this.yq.size(); i++) {
      ((zza)this.yq.valueAt(i)).ys.connect();
    }
  }
  
  public void zzfs(int paramInt)
  {
    zza localzza = (zza)this.yq.get(paramInt);
    this.yq.remove(paramInt);
    if (localzza != null) {
      localzza.zzarn();
    }
  }
  
  private class zza
    implements GoogleApiClient.OnConnectionFailedListener
  {
    public final int yr;
    public final GoogleApiClient ys;
    public final GoogleApiClient.OnConnectionFailedListener yt;
    
    public zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.yr = paramInt;
      this.ys = paramGoogleApiClient;
      this.yt = paramOnConnectionFailedListener;
      paramGoogleApiClient.registerConnectionFailedListener(this);
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.append(paramString).append("GoogleApiClient #").print(this.yr);
      paramPrintWriter.println(":");
      this.ys.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    
    public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
    {
      String str = String.valueOf(paramConnectionResult);
      Log.d("AutoManageHelper", String.valueOf(str).length() + 27 + "beginFailureResolution for " + str);
      zzqm.this.zzb(paramConnectionResult, this.yr);
    }
    
    public void zzarn()
    {
      this.ys.unregisterConnectionFailedListener(this);
      this.ys.disconnect();
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */