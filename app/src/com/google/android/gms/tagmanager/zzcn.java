package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcn
  extends zzdh
{
  private static final String ID = zzag.zzjm.toString();
  private static final String aGx = zzah.zzqj.toString();
  
  public zzcn()
  {
    super(ID);
  }
  
  protected boolean zza(String paramString1, String paramString2, Map<String, zzaj.zza> paramMap)
  {
    if (zzdm.zzk((zzaj.zza)paramMap.get(aGx)).booleanValue()) {}
    for (int i = 66;; i = 64) {
      try
      {
        bool = Pattern.compile(paramString2, i).matcher(paramString1).find();
        return bool;
      }
      catch (PatternSyntaxException paramString1)
      {
        for (;;)
        {
          boolean bool = false;
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzcn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */