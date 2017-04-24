package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzafw;
import com.google.android.gms.internal.zzafw.zzc;
import com.google.android.gms.internal.zzafw.zzg;
import com.google.android.gms.internal.zzai.zzf;
import com.google.android.gms.internal.zzai.zzi;
import com.google.android.gms.internal.zzai.zzj;
import com.google.android.gms.internal.zzaj.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container
{
  private final String aDY;
  private final DataLayer aDZ;
  private zzcx aEa;
  private Map<String, FunctionCallMacroCallback> aEb = new HashMap();
  private Map<String, FunctionCallTagCallback> aEc = new HashMap();
  private volatile long aEd;
  private volatile String aEe = "";
  private final Context mContext;
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzafw.zzc paramzzc)
  {
    this.mContext = paramContext;
    this.aDZ = paramDataLayer;
    this.aDY = paramString;
    this.aEd = paramLong;
    zza(paramzzc);
  }
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzai.zzj paramzzj)
  {
    this.mContext = paramContext;
    this.aDZ = paramDataLayer;
    this.aDY = paramString;
    this.aEd = paramLong;
    zza(paramzzj.zzxv);
    if (paramzzj.zzxu != null) {
      zza(paramzzj.zzxu);
    }
  }
  
  private void zza(zzafw.zzc paramzzc)
  {
    this.aEe = paramzzc.getVersion();
    zzaj localzzaj = zzow(this.aEe);
    zza(new zzcx(this.mContext, paramzzc, this.aDZ, new zza(null), new zzb(null), localzzaj));
    if (getBoolean("_gtm.loadEventEnabled")) {
      this.aDZ.pushEvent("gtm.load", DataLayer.mapOf(new Object[] { "gtm.id", this.aDY }));
    }
  }
  
  private void zza(zzai.zzf paramzzf)
  {
    if (paramzzf == null) {
      throw new NullPointerException();
    }
    try
    {
      zzafw.zzc localzzc = zzafw.zzb(paramzzf);
      zza(localzzc);
      return;
    }
    catch (zzafw.zzg localzzg)
    {
      for (;;)
      {
        paramzzf = String.valueOf(paramzzf);
        String str = String.valueOf(localzzg.toString());
        zzbo.e(String.valueOf(paramzzf).length() + 46 + String.valueOf(str).length() + "Not loading resource: " + paramzzf + " because it is invalid: " + str);
      }
    }
  }
  
  private void zza(zzcx paramzzcx)
  {
    try
    {
      this.aEa = paramzzcx;
      return;
    }
    finally
    {
      paramzzcx = finally;
      throw paramzzcx;
    }
  }
  
  private void zza(zzai.zzi[] paramArrayOfzzi)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfzzi.length;
    for (int i = 0; i < j; i++) {
      localArrayList.add(paramArrayOfzzi[i]);
    }
    zzcdz().zzam(localArrayList);
  }
  
  private zzcx zzcdz()
  {
    try
    {
      zzcx localzzcx = this.aEa;
      return localzzcx;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean getBoolean(String paramString)
  {
    zzcx localzzcx = zzcdz();
    boolean bool;
    if (localzzcx == null)
    {
      zzbo.e("getBoolean called for closed container.");
      bool = zzdm.zzchj().booleanValue();
    }
    for (;;)
    {
      return bool;
      try
      {
        bool = zzdm.zzk((zzaj.zza)localzzcx.zzpr(paramString).getObject()).booleanValue();
      }
      catch (Exception paramString)
      {
        paramString = String.valueOf(paramString.getMessage());
        zzbo.e(String.valueOf(paramString).length() + 66 + "Calling getBoolean() threw an exception: " + paramString + " Returning default value.");
        bool = zzdm.zzchj().booleanValue();
      }
    }
  }
  
  public String getContainerId()
  {
    return this.aDY;
  }
  
  public double getDouble(String paramString)
  {
    zzcx localzzcx = zzcdz();
    double d;
    if (localzzcx == null)
    {
      zzbo.e("getDouble called for closed container.");
      d = zzdm.zzchi().doubleValue();
    }
    for (;;)
    {
      return d;
      try
      {
        d = zzdm.zzj((zzaj.zza)localzzcx.zzpr(paramString).getObject()).doubleValue();
      }
      catch (Exception paramString)
      {
        paramString = String.valueOf(paramString.getMessage());
        zzbo.e(String.valueOf(paramString).length() + 65 + "Calling getDouble() threw an exception: " + paramString + " Returning default value.");
        d = zzdm.zzchi().doubleValue();
      }
    }
  }
  
  public long getLastRefreshTime()
  {
    return this.aEd;
  }
  
  public long getLong(String paramString)
  {
    zzcx localzzcx = zzcdz();
    long l;
    if (localzzcx == null)
    {
      zzbo.e("getLong called for closed container.");
      l = zzdm.zzchh().longValue();
    }
    for (;;)
    {
      return l;
      try
      {
        l = zzdm.zzi((zzaj.zza)localzzcx.zzpr(paramString).getObject()).longValue();
      }
      catch (Exception paramString)
      {
        paramString = String.valueOf(paramString.getMessage());
        zzbo.e(String.valueOf(paramString).length() + 63 + "Calling getLong() threw an exception: " + paramString + " Returning default value.");
        l = zzdm.zzchh().longValue();
      }
    }
  }
  
  public String getString(String paramString)
  {
    zzcx localzzcx = zzcdz();
    if (localzzcx == null)
    {
      zzbo.e("getString called for closed container.");
      paramString = zzdm.zzchl();
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = zzdm.zzg((zzaj.zza)localzzcx.zzpr(paramString).getObject());
      }
      catch (Exception paramString)
      {
        paramString = String.valueOf(paramString.getMessage());
        zzbo.e(String.valueOf(paramString).length() + 65 + "Calling getString() threw an exception: " + paramString + " Returning default value.");
        paramString = zzdm.zzchl();
      }
    }
  }
  
  public boolean isDefault()
  {
    if (getLastRefreshTime() == 0L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void registerFunctionCallMacroCallback(String paramString, FunctionCallMacroCallback paramFunctionCallMacroCallback)
  {
    if (paramFunctionCallMacroCallback == null) {
      throw new NullPointerException("Macro handler must be non-null");
    }
    synchronized (this.aEb)
    {
      this.aEb.put(paramString, paramFunctionCallMacroCallback);
      return;
    }
  }
  
  public void registerFunctionCallTagCallback(String paramString, FunctionCallTagCallback paramFunctionCallTagCallback)
  {
    if (paramFunctionCallTagCallback == null) {
      throw new NullPointerException("Tag callback must be non-null");
    }
    synchronized (this.aEc)
    {
      this.aEc.put(paramString, paramFunctionCallTagCallback);
      return;
    }
  }
  
  void release()
  {
    this.aEa = null;
  }
  
  public void unregisterFunctionCallMacroCallback(String paramString)
  {
    synchronized (this.aEb)
    {
      this.aEb.remove(paramString);
      return;
    }
  }
  
  public void unregisterFunctionCallTagCallback(String paramString)
  {
    synchronized (this.aEc)
    {
      this.aEc.remove(paramString);
      return;
    }
  }
  
  public String zzcdy()
  {
    return this.aEe;
  }
  
  FunctionCallMacroCallback zzot(String paramString)
  {
    synchronized (this.aEb)
    {
      paramString = (FunctionCallMacroCallback)this.aEb.get(paramString);
      return paramString;
    }
  }
  
  public FunctionCallTagCallback zzou(String paramString)
  {
    synchronized (this.aEc)
    {
      paramString = (FunctionCallTagCallback)this.aEc.get(paramString);
      return paramString;
    }
  }
  
  public void zzov(String paramString)
  {
    zzcdz().zzov(paramString);
  }
  
  zzaj zzow(String paramString)
  {
    if (zzcj.zzcfz().zzcga().equals(zzcj.zza.aGr)) {}
    return new zzbw();
  }
  
  public static abstract interface FunctionCallMacroCallback
  {
    public abstract Object getValue(String paramString, Map<String, Object> paramMap);
  }
  
  public static abstract interface FunctionCallTagCallback
  {
    public abstract void execute(String paramString, Map<String, Object> paramMap);
  }
  
  private class zza
    implements zzu.zza
  {
    private zza() {}
    
    public Object zzf(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallMacroCallback localFunctionCallMacroCallback = Container.this.zzot(paramString);
      if (localFunctionCallMacroCallback == null) {}
      for (paramString = null;; paramString = localFunctionCallMacroCallback.getValue(paramString, paramMap)) {
        return paramString;
      }
    }
  }
  
  private class zzb
    implements zzu.zza
  {
    private zzb() {}
    
    public Object zzf(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallTagCallback localFunctionCallTagCallback = Container.this.zzou(paramString);
      if (localFunctionCallTagCallback != null) {
        localFunctionCallTagCallback.execute(paramString, paramMap);
      }
      return zzdm.zzchl();
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\Container.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */