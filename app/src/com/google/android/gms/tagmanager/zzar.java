package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzar
  extends zzam
{
  private static final String ID = zzag.zzio.toString();
  private static final String aFk = zzah.zzmm.toString();
  private static final String aFm = zzah.zzql.toString();
  private static final String aFq = zzah.zzmc.toString();
  
  public zzar()
  {
    super(ID, new String[] { aFk });
  }
  
  private byte[] zzf(String paramString, byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte);
    return paramString.digest();
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    Object localObject = (zzaj.zza)paramMap.get(aFk);
    if ((localObject == null) || (localObject == zzdm.zzchm()))
    {
      paramMap = zzdm.zzchm();
      return paramMap;
    }
    String str = zzdm.zzg((zzaj.zza)localObject);
    localObject = (zzaj.zza)paramMap.get(aFq);
    if (localObject == null)
    {
      localObject = "MD5";
      label55:
      paramMap = (zzaj.zza)paramMap.get(aFm);
      if (paramMap != null) {
        break label113;
      }
      paramMap = "text";
      label75:
      if (!"text".equals(paramMap)) {
        break label121;
      }
    }
    for (paramMap = str.getBytes();; paramMap = zzk.zzos(str))
    {
      try
      {
        paramMap = zzdm.zzat(zzk.zzq(zzf((String)localObject, paramMap)));
      }
      catch (NoSuchAlgorithmException paramMap)
      {
        label113:
        label121:
        paramMap = String.valueOf(localObject);
        if (paramMap.length() == 0) {
          break label212;
        }
      }
      localObject = zzdm.zzg((zzaj.zza)localObject);
      break label55;
      paramMap = zzdm.zzg(paramMap);
      break label75;
      if (!"base16".equals(paramMap)) {
        break label138;
      }
    }
    label138:
    paramMap = String.valueOf(paramMap);
    if (paramMap.length() != 0) {}
    for (paramMap = "Hash: unknown input format: ".concat(paramMap);; paramMap = new String("Hash: unknown input format: "))
    {
      zzbo.e(paramMap);
      paramMap = zzdm.zzchm();
      break;
    }
    label212:
    for (paramMap = "Hash: unknown algorithm: ".concat(paramMap);; paramMap = new String("Hash: unknown algorithm: "))
    {
      zzbo.e(paramMap);
      paramMap = zzdm.zzchm();
      break;
    }
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */