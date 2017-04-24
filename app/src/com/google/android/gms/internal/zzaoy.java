package com.google.android.gms.internal;

import java.io.IOException;
import java.io.StringWriter;

public abstract class zzaoy
{
  public Number aT()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String aU()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean aV()
  {
    return this instanceof zzaov;
  }
  
  public boolean aW()
  {
    return this instanceof zzapb;
  }
  
  public boolean aX()
  {
    return this instanceof zzape;
  }
  
  public boolean aY()
  {
    return this instanceof zzapa;
  }
  
  public zzapb aZ()
  {
    if (aW()) {
      return (zzapb)this;
    }
    String str = String.valueOf(this);
    throw new IllegalStateException(String.valueOf(str).length() + 19 + "Not a JSON Object: " + str);
  }
  
  public zzaov ba()
  {
    if (aV()) {
      return (zzaov)this;
    }
    throw new IllegalStateException("This is not a JSON Array.");
  }
  
  public zzape bb()
  {
    if (aX()) {
      return (zzape)this;
    }
    throw new IllegalStateException("This is not a JSON Primitive.");
  }
  
  Boolean bc()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean getAsBoolean()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public double getAsDouble()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public int getAsInt()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public long getAsLong()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String toString()
  {
    try
    {
      StringWriter localStringWriter = new java/io/StringWriter;
      localStringWriter.<init>();
      Object localObject = new com/google/android/gms/internal/zzaqr;
      ((zzaqr)localObject).<init>(localStringWriter);
      ((zzaqr)localObject).setLenient(true);
      zzapz.zzb(this, (zzaqr)localObject);
      localObject = localStringWriter.toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaoy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */