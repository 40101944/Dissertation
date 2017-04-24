package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class zzap
  extends zzd
{
  protected boolean aK;
  protected String bN;
  protected String bO;
  protected int ee;
  protected boolean fX;
  protected boolean fY;
  protected int fg;
  
  public zzap(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  private static int zzfo(String paramString)
  {
    paramString = paramString.toLowerCase();
    int i;
    if ("verbose".equals(paramString)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if ("info".equals(paramString)) {
        i = 1;
      } else if ("warning".equals(paramString)) {
        i = 2;
      } else if ("error".equals(paramString)) {
        i = 3;
      } else {
        i = -1;
      }
    }
  }
  
  public int getLogLevel()
  {
    zzacj();
    return this.ee;
  }
  
  void zza(zzaa paramzzaa)
  {
    zzes("Loading global XML config values");
    String str;
    if (paramzzaa.zzafq())
    {
      str = paramzzaa.zzaae();
      this.bN = str;
      zzb("XML config - app name", str);
    }
    if (paramzzaa.zzafr())
    {
      str = paramzzaa.zzaaf();
      this.bO = str;
      zzb("XML config - app version", str);
    }
    int i;
    if (paramzzaa.zzafs())
    {
      i = zzfo(paramzzaa.zzaft());
      if (i >= 0)
      {
        this.ee = i;
        zza("XML config - log level", Integer.valueOf(i));
      }
    }
    if (paramzzaa.zzafu())
    {
      i = paramzzaa.zzafv();
      this.fg = i;
      this.fX = true;
      zzb("XML config - dispatch period (sec)", Integer.valueOf(i));
    }
    if (paramzzaa.zzafw())
    {
      boolean bool = paramzzaa.zzafx();
      this.aK = bool;
      this.fY = true;
      zzb("XML config - dry run", Boolean.valueOf(bool));
    }
  }
  
  public String zzaae()
  {
    zzacj();
    return this.bN;
  }
  
  public String zzaaf()
  {
    zzacj();
    return this.bO;
  }
  
  public boolean zzafs()
  {
    zzacj();
    return false;
  }
  
  public boolean zzafu()
  {
    zzacj();
    return this.fX;
  }
  
  public boolean zzafw()
  {
    zzacj();
    return this.fY;
  }
  
  public boolean zzafx()
  {
    zzacj();
    return this.aK;
  }
  
  public int zzahl()
  {
    zzacj();
    return this.fg;
  }
  
  protected void zzahm()
  {
    Object localObject1 = getContext();
    try
    {
      localObject1 = ((Context)localObject1).getPackageManager().getApplicationInfo(((Context)localObject1).getPackageName(), 129);
      if (localObject1 == null)
      {
        zzev("Couldn't get ApplicationInfo to load global config");
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        zzd("PackageManager doesn't know about the app package", localNameNotFoundException);
        Object localObject2 = null;
        continue;
        localObject2 = ((ApplicationInfo)localObject2).metaData;
        if (localObject2 != null)
        {
          int i = ((Bundle)localObject2).getInt("com.google.android.gms.analytics.globalConfigResource");
          if (i > 0)
          {
            localObject2 = (zzaa)new zzz(zzabx()).zzcg(i);
            if (localObject2 != null) {
              zza((zzaa)localObject2);
            }
          }
        }
      }
    }
  }
  
  protected void zzzy()
  {
    zzahm();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */