package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzx
{
  private final String separator;
  
  private zzx(String paramString)
  {
    this.separator = paramString;
  }
  
  public static zzx zzia(String paramString)
  {
    return new zzx(paramString);
  }
  
  public final StringBuilder zza(StringBuilder paramStringBuilder, Iterable<?> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      paramStringBuilder.append(zzw(paramIterable.next()));
      while (paramIterable.hasNext())
      {
        paramStringBuilder.append(this.separator);
        paramStringBuilder.append(zzw(paramIterable.next()));
      }
    }
    return paramStringBuilder;
  }
  
  public final String zzb(Iterable<?> paramIterable)
  {
    return zza(new StringBuilder(), paramIterable).toString();
  }
  
  CharSequence zzw(Object paramObject)
  {
    if ((paramObject instanceof CharSequence)) {}
    for (paramObject = (CharSequence)paramObject;; paramObject = paramObject.toString()) {
      return (CharSequence)paramObject;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */