package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

class zzd
  implements DataLayer.zzb
{
  private final Context zzahs;
  
  public zzd(Context paramContext)
  {
    this.zzahs = paramContext;
  }
  
  public void zzaz(Map<String, Object> paramMap)
  {
    Object localObject = paramMap.get("gtm.url");
    if (localObject == null)
    {
      paramMap = paramMap.get("gtm");
      if ((paramMap == null) || (!(paramMap instanceof Map))) {}
    }
    for (paramMap = ((Map)paramMap).get("url");; paramMap = (Map<String, Object>)localObject)
    {
      if ((paramMap == null) || (!(paramMap instanceof String))) {}
      for (;;)
      {
        return;
        paramMap = Uri.parse((String)paramMap).getQueryParameter("referrer");
        if (paramMap != null) {
          zzbf.zzah(this.zzahs, paramMap);
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */