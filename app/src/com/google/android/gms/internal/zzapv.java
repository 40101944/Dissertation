package com.google.android.gms.internal;

import java.math.BigDecimal;

public final class zzapv
  extends Number
{
  private final String value;
  
  public zzapv(String paramString)
  {
    this.value = paramString;
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(this.value);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if ((paramObject instanceof zzapv))
      {
        paramObject = (zzapv)paramObject;
        if (this.value != ((zzapv)paramObject).value)
        {
          bool1 = bool2;
          if (!this.value.equals(((zzapv)paramObject).value)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  public float floatValue()
  {
    return Float.parseFloat(this.value);
  }
  
  public int hashCode()
  {
    return this.value.hashCode();
  }
  
  public int intValue()
  {
    try
    {
      i = Integer.parseInt(this.value);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      for (;;)
      {
        try
        {
          long l = Long.parseLong(this.value);
          i = (int)l;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          int i = new BigDecimal(this.value).intValue();
        }
      }
    }
  }
  
  public long longValue()
  {
    try
    {
      l = Long.parseLong(this.value);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l = new BigDecimal(this.value).longValue();
      }
    }
  }
  
  public String toString()
  {
    return this.value;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzapv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */