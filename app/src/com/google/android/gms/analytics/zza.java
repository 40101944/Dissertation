package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zznb;
import java.util.List;
import java.util.ListIterator;

public class zza
  extends zzh<zza>
{
  private final zzf ao;
  private boolean ap;
  
  public zza(zzf paramzzf)
  {
    super(paramzzf.zzacc(), paramzzf.zzabz());
    this.ao = paramzzf;
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    this.ap = paramBoolean;
  }
  
  protected void zza(zze paramzze)
  {
    zznb localzznb = (zznb)paramzze.zzb(zznb.class);
    if (TextUtils.isEmpty(localzznb.zzze())) {
      localzznb.setClientId(this.ao.zzacq().zzady());
    }
    if ((this.ap) && (TextUtils.isEmpty(localzznb.zzabb())))
    {
      paramzze = this.ao.zzacp();
      localzznb.zzei(paramzze.zzabn());
      localzznb.zzas(paramzze.zzabc());
    }
  }
  
  public void zzdr(String paramString)
  {
    zzaa.zzib(paramString);
    zzds(paramString);
    zzzu().add(new zzb(this.ao, paramString));
  }
  
  public void zzds(String paramString)
  {
    Uri localUri = zzb.zzdt(paramString);
    paramString = zzzu().listIterator();
    while (paramString.hasNext()) {
      if (localUri.equals(((zzk)paramString.next()).zzyx())) {
        paramString.remove();
      }
    }
  }
  
  zzf zzyt()
  {
    return this.ao;
  }
  
  public zze zzyu()
  {
    zze localzze = zzzt().zzzi();
    localzze.zza(this.ao.zzach().zzadg());
    localzze.zza(this.ao.zzaci().zzafl());
    zzd(localzze);
    return localzze;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */