package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.PendingResult;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
  private static TagManager aHJ;
  private final DataLayer aDZ;
  private final zzt aGC;
  private final zza aHG;
  private final zzdb aHH;
  private final ConcurrentMap<String, zzo> aHI;
  private final Context mContext;
  
  TagManager(Context paramContext, zza paramzza, DataLayer paramDataLayer, zzdb paramzzdb)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.aHH = paramzzdb;
    this.aHG = paramzza;
    this.aHI = new ConcurrentHashMap();
    this.aDZ = paramDataLayer;
    this.aDZ.zza(new DataLayer.zzb()
    {
      public void zzaz(Map<String, Object> paramAnonymousMap)
      {
        paramAnonymousMap = paramAnonymousMap.get("event");
        if (paramAnonymousMap != null) {
          TagManager.zza(TagManager.this, paramAnonymousMap.toString());
        }
      }
    });
    this.aDZ.zza(new zzd(this.mContext));
    this.aGC = new zzt();
    zzcgz();
    zzcha();
  }
  
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (aHJ != null) {
        break label81;
      }
      if (paramContext == null)
      {
        zzbo.e("TagManager.getInstance requires non-null context.");
        paramContext = new java/lang/NullPointerException;
        paramContext.<init>();
        throw paramContext;
      }
    }
    finally {}
    zza local2 = new com/google/android/gms/tagmanager/TagManager$2;
    local2.<init>();
    zzx localzzx = new com/google/android/gms/tagmanager/zzx;
    localzzx.<init>(paramContext);
    TagManager localTagManager = new com/google/android/gms/tagmanager/TagManager;
    DataLayer localDataLayer = new com/google/android/gms/tagmanager/DataLayer;
    localDataLayer.<init>(localzzx);
    localTagManager.<init>(paramContext, local2, localDataLayer, zzdc.zzcgt());
    aHJ = localTagManager;
    label81:
    paramContext = aHJ;
    return paramContext;
  }
  
  @TargetApi(14)
  private void zzcgz()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.mContext.registerComponentCallbacks(new ComponentCallbacks2()
      {
        public void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
        
        public void onLowMemory() {}
        
        public void onTrimMemory(int paramAnonymousInt)
        {
          if (paramAnonymousInt == 20) {
            TagManager.this.dispatch();
          }
        }
      });
    }
  }
  
  private void zzcha()
  {
    zza.zzdw(this.mContext);
  }
  
  private void zzpt(String paramString)
  {
    Iterator localIterator = this.aHI.values().iterator();
    while (localIterator.hasNext()) {
      ((zzo)localIterator.next()).zzov(paramString);
    }
  }
  
  public void dispatch()
  {
    this.aHH.dispatch();
  }
  
  public DataLayer getDataLayer()
  {
    return this.aDZ;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, @RawRes int paramInt)
  {
    paramString = this.aHG.zza(this.mContext, this, null, paramString, paramInt, this.aGC);
    paramString.zzced();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, @RawRes int paramInt, Handler paramHandler)
  {
    paramString = this.aHG.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.aGC);
    paramString.zzced();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, @RawRes int paramInt)
  {
    paramString = this.aHG.zza(this.mContext, this, null, paramString, paramInt, this.aGC);
    paramString.zzcef();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, @RawRes int paramInt, Handler paramHandler)
  {
    paramString = this.aHG.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.aGC);
    paramString.zzcef();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, @RawRes int paramInt)
  {
    paramString = this.aHG.zza(this.mContext, this, null, paramString, paramInt, this.aGC);
    paramString.zzcee();
    return paramString;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, @RawRes int paramInt, Handler paramHandler)
  {
    paramString = this.aHG.zza(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.aGC);
    paramString.zzcee();
    return paramString;
  }
  
  public void setVerboseLoggingEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 5)
    {
      zzbo.setLogLevel(i);
      return;
    }
  }
  
  public int zza(zzo paramzzo)
  {
    this.aHI.put(paramzzo.getContainerId(), paramzzo);
    return this.aHI.size();
  }
  
  public boolean zzb(zzo paramzzo)
  {
    if (this.aHI.remove(paramzzo.getContainerId()) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean zzv(Uri paramUri)
  {
    for (;;)
    {
      zzcj localzzcj;
      String str2;
      boolean bool;
      try
      {
        localzzcj = zzcj.zzcfz();
        if (!localzzcj.zzv(paramUri)) {
          break label204;
        }
        str2 = localzzcj.getContainerId();
        int i = 4.aHL[localzzcj.zzcga().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      paramUri = (zzo)this.aHI.get(str2);
      if (paramUri != null)
      {
        paramUri.zzox(null);
        paramUri.refresh();
        continue;
        Iterator localIterator = this.aHI.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          paramUri = (zzo)this.aHI.get(str1);
          if (str1.equals(str2))
          {
            paramUri.zzox(localzzcj.zzcgb());
            paramUri.refresh();
          }
          else if (paramUri.zzcea() != null)
          {
            paramUri.zzox(null);
            paramUri.refresh();
          }
        }
        continue;
        label204:
        bool = false;
      }
    }
  }
  
  public static abstract interface zza
  {
    public abstract zzp zza(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzt paramzzt);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\TagManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */