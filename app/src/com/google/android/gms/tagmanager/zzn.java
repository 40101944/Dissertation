package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzn
  extends zzam
{
  private static final String ID = zzag.zzhj.toString();
  private static final String VALUE = zzah.zzvi.toString();
  
  public zzn()
  {
    super(ID, new String[] { VALUE });
  }
  
  public static String zzcdw()
  {
    return ID;
  }
  
  public static String zzcdx()
  {
    return VALUE;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    return (zzaj.zza)paramMap.get(VALUE);
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */