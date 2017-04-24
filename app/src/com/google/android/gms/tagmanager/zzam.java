package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaj.zza;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzam
{
  private final Set<String> aFo;
  private final String aFp;
  
  public zzam(String paramString, String... paramVarArgs)
  {
    this.aFp = paramString;
    this.aFo = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++)
    {
      paramString = paramVarArgs[i];
      this.aFo.add(paramString);
    }
  }
  
  public abstract zzaj.zza zzay(Map<String, zzaj.zza> paramMap);
  
  public abstract boolean zzcdu();
  
  public String zzcfg()
  {
    return this.aFp;
  }
  
  public Set<String> zzcfh()
  {
    return this.aFo;
  }
  
  boolean zzf(Set<String> paramSet)
  {
    return paramSet.containsAll(this.aFo);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */