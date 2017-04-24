package com.google.android.gms.common.internal;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzz
{
  public static boolean equal(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static zza zzx(Object paramObject)
  {
    return new zza(paramObject, null);
  }
  
  public static final class zza
  {
    private final List<String> EG;
    private final Object zzcxk;
    
    private zza(Object paramObject)
    {
      this.zzcxk = zzaa.zzy(paramObject);
      this.EG = new ArrayList();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100).append(this.zzcxk.getClass().getSimpleName()).append('{');
      int j = this.EG.size();
      for (int i = 0; i < j; i++)
      {
        localStringBuilder.append((String)this.EG.get(i));
        if (i < j - 1) {
          localStringBuilder.append(", ");
        }
      }
      return '}';
    }
    
    public zza zzg(String paramString, Object paramObject)
    {
      List localList = this.EG;
      paramString = (String)zzaa.zzy(paramString);
      paramObject = String.valueOf(String.valueOf(paramObject));
      localList.add(String.valueOf(paramString).length() + 1 + String.valueOf(paramObject).length() + paramString + "=" + (String)paramObject);
      return this;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */