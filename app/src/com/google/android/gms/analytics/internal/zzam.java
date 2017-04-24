package com.google.android.gms.analytics.internal;

import java.util.Map;

public class zzam
  extends zzq<zzan>
{
  public zzam(zzf paramzzf)
  {
    super(paramzzf, new zza(paramzzf));
  }
  
  private static class zza
    extends zzc
    implements zzq.zza<zzan>
  {
    private final zzan fP = new zzan();
    
    public zza(zzf paramzzf)
    {
      super();
    }
    
    public zzan zzahb()
    {
      return this.fP;
    }
    
    public void zzd(String paramString, int paramInt)
    {
      if ("ga_sessionTimeout".equals(paramString)) {
        this.fP.fR = paramInt;
      }
      for (;;)
      {
        return;
        zzd("int configuration name not recognized", paramString);
      }
    }
    
    public void zze(String paramString, boolean paramBoolean)
    {
      int j = 1;
      int k = 1;
      int i = 1;
      if ("ga_autoActivityTracking".equals(paramString))
      {
        paramString = this.fP;
        if (paramBoolean) {
          paramString.fS = i;
        }
      }
      for (;;)
      {
        return;
        i = 0;
        break;
        if ("ga_anonymizeIp".equals(paramString))
        {
          paramString = this.fP;
          if (paramBoolean) {}
          for (i = j;; i = 0)
          {
            paramString.fT = i;
            break;
          }
        }
        if ("ga_reportUncaughtExceptions".equals(paramString))
        {
          paramString = this.fP;
          if (paramBoolean) {}
          for (i = k;; i = 0)
          {
            paramString.fU = i;
            break;
          }
        }
        zzd("bool configuration name not recognized", paramString);
      }
    }
    
    public void zzo(String paramString1, String paramString2)
    {
      this.fP.fV.put(paramString1, paramString2);
    }
    
    public void zzp(String paramString1, String paramString2)
    {
      if ("ga_trackingId".equals(paramString1)) {
        this.fP.at = paramString2;
      }
      for (;;)
      {
        return;
        if ("ga_sampleFrequency".equals(paramString1)) {
          try
          {
            this.fP.fQ = Double.parseDouble(paramString2);
          }
          catch (NumberFormatException paramString1)
          {
            zzc("Error parsing ga_sampleFrequency value", paramString2, paramString1);
          }
        } else {
          zzd("string configuration name not recognized", paramString1);
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */