package com.google.android.gms.internal;

import java.math.BigInteger;

public final class zzape
  extends zzaoy
{
  private static final Class<?>[] bow = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  private Object value;
  
  public zzape(Boolean paramBoolean)
  {
    setValue(paramBoolean);
  }
  
  public zzape(Number paramNumber)
  {
    setValue(paramNumber);
  }
  
  zzape(Object paramObject)
  {
    setValue(paramObject);
  }
  
  public zzape(String paramString)
  {
    setValue(paramString);
  }
  
  private static boolean zza(zzape paramzzape)
  {
    boolean bool;
    if ((paramzzape.value instanceof Number))
    {
      paramzzape = (Number)paramzzape.value;
      if (((paramzzape instanceof BigInteger)) || ((paramzzape instanceof Long)) || ((paramzzape instanceof Integer)) || ((paramzzape instanceof Short)) || ((paramzzape instanceof Byte))) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private static boolean zzcm(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject instanceof String)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      Class localClass = paramObject.getClass();
      paramObject = bow;
      int j = paramObject.length;
      for (int i = 0;; i++)
      {
        if (i >= j) {
          break label55;
        }
        bool1 = bool2;
        if (paramObject[i].isAssignableFrom(localClass)) {
          break;
        }
      }
      label55:
      bool1 = false;
    }
  }
  
  public Number aT()
  {
    if ((this.value instanceof String)) {}
    for (Object localObject = new zzapv((String)this.value);; localObject = (Number)this.value) {
      return (Number)localObject;
    }
  }
  
  public String aU()
  {
    String str;
    if (be()) {
      str = aT().toString();
    }
    for (;;)
    {
      return str;
      if (bd()) {
        str = bc().toString();
      } else {
        str = (String)this.value;
      }
    }
  }
  
  Boolean bc()
  {
    return (Boolean)this.value;
  }
  
  public boolean bd()
  {
    return this.value instanceof Boolean;
  }
  
  public boolean be()
  {
    return this.value instanceof Number;
  }
  
  public boolean bf()
  {
    return this.value instanceof String;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this == paramObject) {}
    for (;;)
    {
      return bool1;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        bool1 = false;
      }
      else
      {
        paramObject = (zzape)paramObject;
        if (this.value == null)
        {
          if (((zzape)paramObject).value != null) {
            bool1 = false;
          }
        }
        else if ((zza(this)) && (zza((zzape)paramObject)))
        {
          if (aT().longValue() != ((zzape)paramObject).aT().longValue()) {
            bool1 = false;
          }
        }
        else if (((this.value instanceof Number)) && ((((zzape)paramObject).value instanceof Number)))
        {
          double d1 = aT().doubleValue();
          double d2 = ((zzape)paramObject).aT().doubleValue();
          if (d1 != d2)
          {
            bool1 = bool2;
            if (Double.isNaN(d1))
            {
              bool1 = bool2;
              if (!Double.isNaN(d2)) {}
            }
          }
          else
          {
            bool1 = true;
          }
        }
        else
        {
          bool1 = this.value.equals(((zzape)paramObject).value);
        }
      }
    }
  }
  
  public boolean getAsBoolean()
  {
    if (bd()) {}
    for (boolean bool = bc().booleanValue();; bool = Boolean.parseBoolean(aU())) {
      return bool;
    }
  }
  
  public double getAsDouble()
  {
    if (be()) {}
    for (double d = aT().doubleValue();; d = Double.parseDouble(aU())) {
      return d;
    }
  }
  
  public int getAsInt()
  {
    if (be()) {}
    for (int i = aT().intValue();; i = Integer.parseInt(aU())) {
      return i;
    }
  }
  
  public long getAsLong()
  {
    if (be()) {}
    for (long l = aT().longValue();; l = Long.parseLong(aU())) {
      return l;
    }
  }
  
  public int hashCode()
  {
    int i;
    if (this.value == null) {
      i = 31;
    }
    for (;;)
    {
      return i;
      long l;
      if (zza(this))
      {
        l = aT().longValue();
        i = (int)(l ^ l >>> 32);
      }
      else if ((this.value instanceof Number))
      {
        l = Double.doubleToLongBits(aT().doubleValue());
        i = (int)(l ^ l >>> 32);
      }
      else
      {
        i = this.value.hashCode();
      }
    }
  }
  
  void setValue(Object paramObject)
  {
    if ((paramObject instanceof Character))
    {
      this.value = String.valueOf(((Character)paramObject).charValue());
      return;
    }
    if (((paramObject instanceof Number)) || (zzcm(paramObject))) {}
    for (boolean bool = true;; bool = false)
    {
      zzapq.zzbt(bool);
      this.value = paramObject;
      break;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */