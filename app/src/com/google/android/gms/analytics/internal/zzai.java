package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;
import java.util.UUID;

public class zzai
  extends zzd
{
  private SharedPreferences fF;
  private long fG;
  private long fH = -1L;
  private final zza fI = new zza("monitoring", zzacb().zzafj(), null);
  
  protected zzai(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public long zzago()
  {
    zzzx();
    zzacj();
    long l;
    if (this.fG == 0L)
    {
      l = this.fF.getLong("first_run", 0L);
      if (l == 0L) {
        break label46;
      }
    }
    for (this.fG = l;; this.fG = l)
    {
      return this.fG;
      label46:
      l = zzabz().currentTimeMillis();
      SharedPreferences.Editor localEditor = this.fF.edit();
      localEditor.putLong("first_run", l);
      if (!localEditor.commit()) {
        zzev("Failed to commit first run time");
      }
    }
  }
  
  public zzal zzagp()
  {
    return new zzal(zzabz(), zzago());
  }
  
  public long zzagq()
  {
    zzzx();
    zzacj();
    if (this.fH == -1L) {
      this.fH = this.fF.getLong("last_dispatch", 0L);
    }
    return this.fH;
  }
  
  public void zzagr()
  {
    zzzx();
    zzacj();
    long l = zzabz().currentTimeMillis();
    SharedPreferences.Editor localEditor = this.fF.edit();
    localEditor.putLong("last_dispatch", l);
    localEditor.apply();
    this.fH = l;
  }
  
  public String zzags()
  {
    Object localObject = null;
    zzzx();
    zzacj();
    String str = this.fF.getString("installation_campaign", null);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return (String)localObject;
      localObject = str;
    }
  }
  
  public zza zzagt()
  {
    return this.fI;
  }
  
  public void zzff(String paramString)
  {
    zzzx();
    zzacj();
    SharedPreferences.Editor localEditor = this.fF.edit();
    if (TextUtils.isEmpty(paramString)) {
      localEditor.remove("installation_campaign");
    }
    for (;;)
    {
      if (!localEditor.commit()) {
        zzev("Failed to commit campaign data");
      }
      return;
      localEditor.putString("installation_campaign", paramString);
    }
  }
  
  protected void zzzy()
  {
    this.fF = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
  }
  
  public final class zza
  {
    private final long fJ;
    private final String mName;
    
    private zza(String paramString, long paramLong)
    {
      zzaa.zzib(paramString);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzaa.zzbt(bool);
        this.mName = paramString;
        this.fJ = paramLong;
        return;
      }
    }
    
    private void zzagu()
    {
      long l = zzai.this.zzabz().currentTimeMillis();
      SharedPreferences.Editor localEditor = zzai.zza(zzai.this).edit();
      localEditor.remove(zzagz());
      localEditor.remove(zzaha());
      localEditor.putLong(zzagy(), l);
      localEditor.commit();
    }
    
    private long zzagv()
    {
      long l1 = 0L;
      long l2 = zzagx();
      if (l2 == 0L) {}
      for (;;)
      {
        return l1;
        l1 = Math.abs(l2 - zzai.this.zzabz().currentTimeMillis());
      }
    }
    
    private long zzagx()
    {
      return zzai.zza(zzai.this).getLong(zzagy(), 0L);
    }
    
    private String zzagy()
    {
      return String.valueOf(this.mName).concat(":start");
    }
    
    private String zzagz()
    {
      return String.valueOf(this.mName).concat(":count");
    }
    
    public Pair<String, Long> zzagw()
    {
      Object localObject2 = null;
      long l = zzagv();
      Object localObject1;
      if (l < this.fJ) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        return (Pair<String, Long>)localObject1;
        if (l > this.fJ * 2L)
        {
          zzagu();
          localObject1 = localObject2;
        }
        else
        {
          String str = zzai.zza(zzai.this).getString(zzaha(), null);
          l = zzai.zza(zzai.this).getLong(zzagz(), 0L);
          zzagu();
          localObject1 = localObject2;
          if (str != null)
          {
            localObject1 = localObject2;
            if (l > 0L) {
              localObject1 = new Pair(str, Long.valueOf(l));
            }
          }
        }
      }
    }
    
    protected String zzaha()
    {
      return String.valueOf(this.mName).concat(":value");
    }
    
    public void zzfg(String paramString)
    {
      if (zzagx() == 0L) {
        zzagu();
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      for (;;)
      {
        try
        {
          long l = zzai.zza(zzai.this).getLong(zzagz(), 0L);
          if (l <= 0L)
          {
            paramString = zzai.zza(zzai.this).edit();
            paramString.putString(zzaha(), str);
            paramString.putLong(zzagz(), 1L);
            paramString.apply();
            return;
          }
          int i;
          if ((UUID.randomUUID().getLeastSignificantBits() & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / (l + 1L))
          {
            i = 1;
            paramString = zzai.zza(zzai.this).edit();
            if (i != 0) {
              paramString.putString(zzaha(), str);
            }
            paramString.putLong(zzagz(), l + 1L);
            paramString.apply();
          }
          else
          {
            i = 0;
          }
        }
        finally {}
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */