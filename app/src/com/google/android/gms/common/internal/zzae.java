package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

public final class zzae
  extends zzg<zzw>
{
  private static final zzae EN = new zzae();
  
  private zzae()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View zzb(Context paramContext, int paramInt1, int paramInt2)
    throws zzg.zza
  {
    return EN.zzc(paramContext, paramInt1, paramInt2);
  }
  
  private View zzc(Context paramContext, int paramInt1, int paramInt2)
    throws zzg.zza
  {
    try
    {
      SignInButtonConfig localSignInButtonConfig = new com/google/android/gms/common/internal/SignInButtonConfig;
      localSignInButtonConfig.<init>(paramInt1, paramInt2, null);
      zzd localzzd = zze.zzac(paramContext);
      paramContext = (View)zze.zzae(((zzw)zzcr(paramContext)).zza(localzzd, localSignInButtonConfig));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new zzg.zza(64 + "Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
    }
  }
  
  public zzw zzdy(IBinder paramIBinder)
  {
    return zzw.zza.zzdx(paramIBinder);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */