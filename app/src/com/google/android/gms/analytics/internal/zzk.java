package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.internal.zzms;

public class zzk
  extends zzd
{
  private final zzms bn = new zzms();
  
  zzk(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public zzms zzadg()
  {
    zzacj();
    return this.bn;
  }
  
  public void zzzc()
  {
    zzap localzzap = zzzh();
    String str = localzzap.zzaae();
    if (str != null) {
      this.bn.setAppName(str);
    }
    str = localzzap.zzaaf();
    if (str != null) {
      this.bn.setAppVersion(str);
    }
  }
  
  protected void zzzy()
  {
    zzacc().zzzv().zza(this.bn);
    zzzc();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */