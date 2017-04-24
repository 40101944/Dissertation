package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzafw.zza;
import com.google.android.gms.internal.zzafw.zzb;
import com.google.android.gms.internal.zzafw.zzc;
import com.google.android.gms.internal.zzafw.zzd;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zzbh
{
  private static zzaj.zza zzam(Object paramObject)
    throws JSONException
  {
    return zzdm.zzat(zzan(paramObject));
  }
  
  static Object zzan(Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof JSONArray)) {
      throw new RuntimeException("JSONArrays are not supported");
    }
    if (JSONObject.NULL.equals(paramObject)) {
      throw new RuntimeException("JSON nulls are not supported");
    }
    Object localObject = paramObject;
    if ((paramObject instanceof JSONObject))
    {
      JSONObject localJSONObject = (JSONObject)paramObject;
      localObject = new HashMap();
      paramObject = localJSONObject.keys();
      while (((Iterator)paramObject).hasNext())
      {
        String str = (String)((Iterator)paramObject).next();
        ((Map)localObject).put(str, zzan(localJSONObject.get(str)));
      }
    }
    return localObject;
  }
  
  public static zzafw.zzc zzpm(String paramString)
    throws JSONException
  {
    zzaj.zza localzza = zzam(new JSONObject(paramString));
    paramString = zzafw.zzc.zzckw();
    for (int i = 0; i < localzza.zzxz.length; i++) {
      paramString.zzc(zzafw.zza.zzcku().zzb(zzah.zzqm.toString(), localzza.zzxz[i]).zzb(zzah.zzqa.toString(), zzdm.zzpx(zzn.zzcdw())).zzb(zzn.zzcdx(), localzza.zzya[i]).zzckv());
    }
    return paramString.zzcky();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */