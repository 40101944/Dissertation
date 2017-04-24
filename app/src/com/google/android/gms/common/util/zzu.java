package com.google.android.gms.common.util;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzaa;
import java.util.Set;

public final class zzu
{
  public static String[] zza(Scope[] paramArrayOfScope)
  {
    zzaa.zzb(paramArrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[paramArrayOfScope.length];
    for (int i = 0; i < paramArrayOfScope.length; i++) {
      arrayOfString[i] = paramArrayOfScope[i].zzari();
    }
    return arrayOfString;
  }
  
  public static String[] zzd(Set<Scope> paramSet)
  {
    zzaa.zzb(paramSet, "scopes can't be null.");
    return zza((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\util\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */