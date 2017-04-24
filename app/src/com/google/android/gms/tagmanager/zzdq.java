package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaj.zza;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class zzdq
{
  private static zzce<zzaj.zza> zza(zzce<zzaj.zza> paramzzce)
  {
    try
    {
      String str = zzqe(zzdm.zzg((zzaj.zza)paramzzce.getObject()));
      zzce localzzce = new com/google/android/gms/tagmanager/zzce;
      localzzce.<init>(zzdm.zzat(str), paramzzce.zzcfu());
      paramzzce = localzzce;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        zzbo.zzb("Escape URI: unsupported encoding", localUnsupportedEncodingException);
      }
    }
    return paramzzce;
  }
  
  private static zzce<zzaj.zza> zza(zzce<zzaj.zza> paramzzce, int paramInt)
  {
    if (!zzn((zzaj.zza)paramzzce.getObject())) {
      zzbo.e("Escaping can only be applied to strings.");
    }
    for (;;)
    {
      return paramzzce;
      switch (paramInt)
      {
      default: 
        zzbo.e(39 + "Unsupported Value Escaping: " + paramInt);
        break;
      case 12: 
        paramzzce = zza(paramzzce);
      }
    }
  }
  
  static zzce<zzaj.zza> zza(zzce<zzaj.zza> paramzzce, int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      paramzzce = zza(paramzzce, paramVarArgs[i]);
    }
    return paramzzce;
  }
  
  private static boolean zzn(zzaj.zza paramzza)
  {
    return zzdm.zzl(paramzza) instanceof String;
  }
  
  static String zzqe(String paramString)
    throws UnsupportedEncodingException
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */