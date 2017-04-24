package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.common.internal.zzaa;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class zznc
  extends zzg<zznc>
{
  private String cq;
  private int cr;
  private int cs;
  private String ct;
  private String cu;
  private boolean cv;
  private boolean cw;
  
  public zznc()
  {
    this(false);
  }
  
  public zznc(boolean paramBoolean)
  {
    this(paramBoolean, zzabg());
  }
  
  public zznc(boolean paramBoolean, int paramInt)
  {
    zzaa.zzgp(paramInt);
    this.cr = paramInt;
    this.cw = paramBoolean;
  }
  
  static int zzabg()
  {
    UUID localUUID = UUID.randomUUID();
    int i = (int)(localUUID.getLeastSignificantBits() & 0x7FFFFFFF);
    if (i != 0) {}
    for (;;)
    {
      return i;
      int j = (int)(localUUID.getMostSignificantBits() & 0x7FFFFFFF);
      i = j;
      if (j == 0)
      {
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        i = Integer.MAX_VALUE;
      }
    }
  }
  
  private void zzabk() {}
  
  public void setScreenName(String paramString)
  {
    zzabk();
    this.cq = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("screenName", this.cq);
    localHashMap.put("interstitial", Boolean.valueOf(this.cv));
    localHashMap.put("automatic", Boolean.valueOf(this.cw));
    localHashMap.put("screenId", Integer.valueOf(this.cr));
    localHashMap.put("referrerScreenId", Integer.valueOf(this.cs));
    localHashMap.put("referrerScreenName", this.ct);
    localHashMap.put("referrerUri", this.cu);
    return zzj(localHashMap);
  }
  
  public void zza(zznc paramzznc)
  {
    if (!TextUtils.isEmpty(this.cq)) {
      paramzznc.setScreenName(this.cq);
    }
    if (this.cr != 0) {
      paramzznc.zzcd(this.cr);
    }
    if (this.cs != 0) {
      paramzznc.zzce(this.cs);
    }
    if (!TextUtils.isEmpty(this.ct)) {
      paramzznc.zzek(this.ct);
    }
    if (!TextUtils.isEmpty(this.cu)) {
      paramzznc.zzel(this.cu);
    }
    if (this.cv) {
      paramzznc.zzav(this.cv);
    }
    if (this.cw) {
      paramzznc.zzau(this.cw);
    }
  }
  
  public String zzabh()
  {
    return this.cq;
  }
  
  public int zzabi()
  {
    return this.cr;
  }
  
  public String zzabj()
  {
    return this.cu;
  }
  
  public void zzau(boolean paramBoolean)
  {
    zzabk();
    this.cw = paramBoolean;
  }
  
  public void zzav(boolean paramBoolean)
  {
    zzabk();
    this.cv = paramBoolean;
  }
  
  public void zzcd(int paramInt)
  {
    zzabk();
    this.cr = paramInt;
  }
  
  public void zzce(int paramInt)
  {
    zzabk();
    this.cs = paramInt;
  }
  
  public void zzek(String paramString)
  {
    zzabk();
    this.ct = paramString;
  }
  
  public void zzel(String paramString)
  {
    zzabk();
    if (TextUtils.isEmpty(paramString)) {}
    for (this.cu = null;; this.cu = paramString) {
      return;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zznc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */