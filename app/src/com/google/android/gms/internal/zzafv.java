package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.HashMap;
import java.util.Map;

public class zzafv
{
  private String aEC = null;
  Map<String, Object> aLk = new HashMap();
  private final Map<String, Object> aLl;
  private final zzafx aMw;
  private final Context mContext;
  private final zze zzaql;
  
  public zzafv(Context paramContext)
  {
    this(paramContext, new HashMap(), new zzafx(paramContext), zzh.zzayl());
  }
  
  zzafv(Context paramContext, Map<String, Object> paramMap, zzafx paramzzafx, zze paramzze)
  {
    this.mContext = paramContext;
    this.zzaql = paramzze;
    this.aMw = paramzzafx;
    this.aLl = paramMap;
  }
  
  public void zzqy(String paramString)
  {
    this.aEC = paramString;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzafv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */