package com.google.android.gms.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class zzaop
{
  private final Field bnT;
  
  public zzaop(Field paramField)
  {
    zzapq.zzy(paramField);
    this.bnT = paramField;
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    return this.bnT.getAnnotation(paramClass);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */