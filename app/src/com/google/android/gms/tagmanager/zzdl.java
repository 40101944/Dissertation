package com.google.android.gms.tagmanager;

class zzdl
  extends Number
  implements Comparable<zzdl>
{
  private double aHO;
  private long aHP;
  private boolean aHQ;
  
  private zzdl(double paramDouble)
  {
    this.aHO = paramDouble;
    this.aHQ = false;
  }
  
  private zzdl(long paramLong)
  {
    this.aHP = paramLong;
    this.aHQ = true;
  }
  
  public static zzdl zza(Double paramDouble)
  {
    return new zzdl(paramDouble.doubleValue());
  }
  
  public static zzdl zzbv(long paramLong)
  {
    return new zzdl(paramLong);
  }
  
  public static zzdl zzpw(String paramString)
    throws NumberFormatException
  {
    try
    {
      zzdl localzzdl1 = new com/google/android/gms/tagmanager/zzdl;
      localzzdl1.<init>(Long.parseLong(paramString));
      paramString = localzzdl1;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        zzdl localzzdl2 = new zzdl(Double.parseDouble(paramString));
        paramString = localzzdl2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        throw new NumberFormatException(String.valueOf(paramString).concat(" is not a valid TypedNumber"));
      }
    }
    return paramString;
  }
  
  public byte byteValue()
  {
    return (byte)(int)longValue();
  }
  
  public double doubleValue()
  {
    if (zzchc()) {}
    for (double d = this.aHP;; d = this.aHO) {
      return d;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof zzdl)) && (zza((zzdl)paramObject) == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public float floatValue()
  {
    return (float)doubleValue();
  }
  
  public int hashCode()
  {
    return new Long(longValue()).hashCode();
  }
  
  public int intValue()
  {
    return zzche();
  }
  
  public long longValue()
  {
    return zzchd();
  }
  
  public short shortValue()
  {
    return zzchf();
  }
  
  public String toString()
  {
    if (zzchc()) {}
    for (String str = Long.toString(this.aHP);; str = Double.toString(this.aHO)) {
      return str;
    }
  }
  
  public int zza(zzdl paramzzdl)
  {
    if ((zzchc()) && (paramzzdl.zzchc())) {}
    for (int i = new Long(this.aHP).compareTo(Long.valueOf(paramzzdl.aHP));; i = Double.compare(doubleValue(), paramzzdl.doubleValue())) {
      return i;
    }
  }
  
  public boolean zzchb()
  {
    if (!zzchc()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean zzchc()
  {
    return this.aHQ;
  }
  
  public long zzchd()
  {
    if (zzchc()) {}
    for (long l = this.aHP;; l = this.aHO) {
      return l;
    }
  }
  
  public int zzche()
  {
    return (int)longValue();
  }
  
  public short zzchf()
  {
    return (short)(int)longValue();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */