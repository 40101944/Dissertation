package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzcz
  extends zzam
{
  private static final String ID = zzag.zzig.toString();
  
  public zzcz()
  {
    super(ID, new String[0]);
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    return zzdm.zzat(Integer.valueOf(Build.VERSION.SDK_INT));
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */