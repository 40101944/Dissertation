package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Map;

class zzco
  extends zzam
{
  private static final String ID = zzag.zzie.toString();
  private final Context mContext;
  
  public zzco(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public zzaj.zza zzay(Map<String, zzaj.zza> paramMap)
  {
    paramMap = new DisplayMetrics();
    ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramMap);
    int j = paramMap.widthPixels;
    int i = paramMap.heightPixels;
    return zzdm.zzat(23 + j + "x" + i);
  }
  
  public boolean zzcdu()
  {
    return true;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */