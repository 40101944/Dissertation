package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R.string;

public class zzah
{
  private final Resources EP;
  private final String EQ;
  
  public zzah(Context paramContext)
  {
    zzaa.zzy(paramContext);
    this.EP = paramContext.getResources();
    this.EQ = this.EP.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  public String getString(String paramString)
  {
    int i = this.EP.getIdentifier(paramString, "string", this.EQ);
    if (i == 0) {}
    for (paramString = null;; paramString = this.EP.getString(i)) {
      return paramString;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */