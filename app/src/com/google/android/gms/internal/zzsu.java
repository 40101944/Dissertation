package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzo;

public class zzsu
{
  private final String ED;
  private final zzo EX;
  private final int ee;
  private final String mTag;
  
  private zzsu(String paramString1, String paramString2)
  {
    this.ED = paramString2;
    this.mTag = paramString1;
    this.EX = new zzo(paramString1);
    this.ee = getLogLevel();
  }
  
  public zzsu(String paramString, String... paramVarArgs)
  {
    this(paramString, zzd(paramVarArgs));
  }
  
  private int getLogLevel()
  {
    for (int i = 2; (7 >= i) && (!Log.isLoggable(this.mTag, i)); i++) {}
    return i;
  }
  
  private static String zzd(String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    StringBuilder localStringBuilder;
    for (paramVarArgs = "";; paramVarArgs = localStringBuilder.toString())
    {
      return paramVarArgs;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append('[');
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++)
      {
        String str = paramVarArgs[i];
        if (localStringBuilder.length() > 1) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(str);
      }
      localStringBuilder.append(']').append(' ');
    }
  }
  
  protected String format(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length > 0) {
        str = String.format(paramString, paramVarArgs);
      }
    }
    return this.ED.concat(str);
  }
  
  public void zza(String paramString, Object... paramVarArgs)
  {
    if (zzbi(2)) {
      Log.v(this.mTag, format(paramString, paramVarArgs));
    }
  }
  
  public boolean zzbi(int paramInt)
  {
    if (this.ee <= paramInt) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void zze(String paramString, Object... paramVarArgs)
  {
    Log.i(this.mTag, format(paramString, paramVarArgs));
  }
  
  public void zzf(String paramString, Object... paramVarArgs)
  {
    Log.w(this.mTag, format(paramString, paramVarArgs));
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzsu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */