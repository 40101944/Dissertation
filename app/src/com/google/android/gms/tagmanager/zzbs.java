package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzbs
  extends zzam
{
  private static final String ID = zzag.zzir.toString();
  private final Context mContext;
  
  public zzbs(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    paramMap = zzdy(this.mContext);
    if (paramMap == null) {}
    for (paramMap = zzdm.zzchm();; paramMap = zzdm.zzat(paramMap)) {
      return paramMap;
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
  
  protected String zzdy(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */