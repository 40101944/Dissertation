package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

public class zzdj
{
  private Tracker aE;
  private GoogleAnalytics aG;
  private Context mContext;
  
  public zzdj(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void zzpv(String paramString)
  {
    try
    {
      if (this.aG == null)
      {
        this.aG = GoogleAnalytics.getInstance(this.mContext);
        GoogleAnalytics localGoogleAnalytics = this.aG;
        zza localzza = new com/google/android/gms/tagmanager/zzdj$zza;
        localzza.<init>();
        localGoogleAnalytics.setLogger(localzza);
        this.aE = this.aG.newTracker(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Tracker zzpu(String paramString)
  {
    zzpv(paramString);
    return this.aE;
  }
  
  static class zza
    implements Logger
  {
    private static int zzaai(int paramInt)
    {
      int j = 3;
      int i = j;
      switch (paramInt)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        return i;
        i = 2;
        continue;
        i = 1;
        continue;
        i = 0;
      }
    }
    
    public void error(Exception paramException)
    {
      zzbo.zzb("", paramException);
    }
    
    public void error(String paramString)
    {
      zzbo.e(paramString);
    }
    
    public int getLogLevel()
    {
      return zzaai(zzbo.getLogLevel());
    }
    
    public void info(String paramString)
    {
      zzbo.zzdh(paramString);
    }
    
    public void setLogLevel(int paramInt)
    {
      zzbo.zzdi("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }
    
    public void verbose(String paramString)
    {
      zzbo.v(paramString);
    }
    
    public void warn(String paramString)
    {
      zzbo.zzdi(paramString);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */