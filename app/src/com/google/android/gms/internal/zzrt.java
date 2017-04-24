package com.google.android.gms.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zzrt
  extends zzqp
{
  private TaskCompletionSource<Void> yg = new TaskCompletionSource();
  
  private zzrt(zzrp paramzzrp)
  {
    super(paramzzrp);
    this.Bf.zza("GmsAvailabilityHelper", this);
  }
  
  public static zzrt zzu(Activity paramActivity)
  {
    paramActivity = zzs(paramActivity);
    zzrt localzzrt = (zzrt)paramActivity.zza("GmsAvailabilityHelper", zzrt.class);
    if (localzzrt != null)
    {
      paramActivity = localzzrt;
      if (localzzrt.yg.getTask().isComplete()) {
        localzzrt.yg = new TaskCompletionSource();
      }
    }
    for (paramActivity = localzzrt;; paramActivity = new zzrt(paramActivity)) {
      return paramActivity;
    }
  }
  
  public Task<Void> getTask()
  {
    return this.yg.getTask();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.yg.setException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
  }
  
  protected void zza(ConnectionResult paramConnectionResult, int paramInt)
  {
    this.yg.setException(zzb.zzk(paramConnectionResult));
  }
  
  protected void zzarm()
  {
    int i = this.xP.isGooglePlayServicesAvailable(this.Bf.zzaty());
    if (i == 0) {
      this.yg.setResult(null);
    }
    for (;;)
    {
      return;
      zzj(new ConnectionResult(i, null));
    }
  }
  
  public void zzj(ConnectionResult paramConnectionResult)
  {
    zzb(paramConnectionResult, 0);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzrt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */