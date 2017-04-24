package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzf
  extends zzam
{
  private static final String ID = zzag.zzhf.toString();
  private final Context mContext;
  
  public zzf(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    return zzdm.zzat(this.mContext.getPackageName());
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */