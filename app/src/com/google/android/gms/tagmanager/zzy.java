package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class zzy
  extends zzdk
{
  private static final String ID = zzag.zzit.toString();
  private static final String VALUE = zzah.zzvi.toString();
  private static final String aEZ = zzah.zznk.toString();
  private final DataLayer aDZ;
  
  public zzy(DataLayer paramDataLayer)
  {
    super(ID, new String[] { VALUE });
    this.aDZ = paramDataLayer;
  }
  
  private void zza(zzaj.zza paramzza)
  {
    if ((paramzza == null) || (paramzza == zzdm.zzchg())) {}
    for (;;)
    {
      return;
      paramzza = zzdm.zzg(paramzza);
      if (paramzza != zzdm.zzchl()) {
        this.aDZ.zzpb(paramzza);
      }
    }
  }
  
  private void zzb(zzaj.zza paramzza)
  {
    if ((paramzza == null) || (paramzza == zzdm.zzchg())) {}
    for (;;)
    {
      return;
      paramzza = zzdm.zzl(paramzza);
      if ((paramzza instanceof List))
      {
        paramzza = ((List)paramzza).iterator();
        while (paramzza.hasNext())
        {
          Object localObject = paramzza.next();
          if ((localObject instanceof Map))
          {
            localObject = (Map)localObject;
            this.aDZ.push((Map)localObject);
          }
        }
      }
    }
  }
  
  public void zzba(Map<String, zzaj.zza> paramMap)
  {
    zzb((zzaj.zza)paramMap.get(VALUE));
    zza((zzaj.zza)paramMap.get(aEZ));
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */