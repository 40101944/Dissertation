package com.google.android.gms.analytics.internal;

public class zzz
  extends zzq<zzaa>
{
  public zzz(zzf paramzzf)
  {
    super(paramzzf, new zza(paramzzf));
  }
  
  private static class zza
    implements zzq.zza<zzaa>
  {
    private final zzf cQ;
    private final zzaa fe;
    
    public zza(zzf paramzzf)
    {
      this.cQ = paramzzf;
      this.fe = new zzaa();
    }
    
    public zzaa zzafp()
    {
      return this.fe;
    }
    
    public void zzd(String paramString, int paramInt)
    {
      if ("ga_dispatchPeriod".equals(paramString)) {
        this.fe.fg = paramInt;
      }
      for (;;)
      {
        return;
        this.cQ.zzaca().zzd("Int xml configuration name not recognized", paramString);
      }
    }
    
    public void zze(String paramString, boolean paramBoolean)
    {
      int i;
      if ("ga_dryRun".equals(paramString))
      {
        paramString = this.fe;
        if (paramBoolean)
        {
          i = 1;
          paramString.fh = i;
        }
      }
      for (;;)
      {
        return;
        i = 0;
        break;
        this.cQ.zzaca().zzd("Bool xml configuration name not recognized", paramString);
      }
    }
    
    public void zzo(String paramString1, String paramString2) {}
    
    public void zzp(String paramString1, String paramString2)
    {
      if ("ga_appName".equals(paramString1)) {
        this.fe.bN = paramString2;
      }
      for (;;)
      {
        return;
        if ("ga_appVersion".equals(paramString1)) {
          this.fe.bO = paramString2;
        } else if ("ga_logLevel".equals(paramString1)) {
          this.fe.ff = paramString2;
        } else {
          this.cQ.zzaca().zzd("String xml configuration name not recognized", paramString1);
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */