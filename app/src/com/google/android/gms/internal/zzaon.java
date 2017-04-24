package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

final class zzaon
  implements zzaox<java.util.Date>, zzapg<java.util.Date>
{
  private final DateFormat bnQ;
  private final DateFormat bnR;
  private final DateFormat bnS;
  
  zzaon()
  {
    this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
  }
  
  public zzaon(int paramInt1, int paramInt2)
  {
    this(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US), DateFormat.getDateTimeInstance(paramInt1, paramInt2));
  }
  
  zzaon(String paramString)
  {
    this(new SimpleDateFormat(paramString, Locale.US), new SimpleDateFormat(paramString));
  }
  
  zzaon(DateFormat paramDateFormat1, DateFormat paramDateFormat2)
  {
    this.bnQ = paramDateFormat1;
    this.bnR = paramDateFormat2;
    this.bnS = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    this.bnS.setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  
  private java.util.Date zza(zzaoy paramzzaoy)
  {
    for (;;)
    {
      synchronized (this.bnR)
      {
        try
        {
          java.util.Date localDate1 = this.bnR.parse(paramzzaoy.aU());
          paramzzaoy = localDate1;
          return paramzzaoy;
        }
        catch (ParseException localParseException1) {}
      }
      try
      {
        java.util.Date localDate2 = this.bnQ.parse(paramzzaoy.aU());
        paramzzaoy = localDate2;
        continue;
        paramzzaoy = finally;
        throw paramzzaoy;
      }
      catch (ParseException localParseException2)
      {
        try
        {
          java.util.Date localDate3 = this.bnS.parse(paramzzaoy.aU());
          paramzzaoy = localDate3;
        }
        catch (ParseException localParseException3)
        {
          zzaph localzzaph = new com/google/android/gms/internal/zzaph;
          localzzaph.<init>(paramzzaoy.aU(), localParseException3);
          throw localzzaph;
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(zzaon.class.getSimpleName());
    localStringBuilder.append('(').append(this.bnR.getClass().getSimpleName()).append(')');
    return localStringBuilder.toString();
  }
  
  public zzaoy zza(java.util.Date paramDate, Type arg2, zzapf paramzzapf)
  {
    synchronized (this.bnR)
    {
      paramzzapf = this.bnQ.format(paramDate);
      paramDate = new com/google/android/gms/internal/zzape;
      paramDate.<init>(paramzzapf);
      return paramDate;
    }
  }
  
  public java.util.Date zza(zzaoy paramzzaoy, Type paramType, zzaow paramzzaow)
    throws zzapc
  {
    if (!(paramzzaoy instanceof zzape)) {
      throw new zzapc("The date should be a string value");
    }
    paramzzaoy = zza(paramzzaoy);
    if (paramType == java.util.Date.class) {}
    for (;;)
    {
      return paramzzaoy;
      if (paramType == Timestamp.class)
      {
        paramzzaoy = new Timestamp(paramzzaoy.getTime());
      }
      else
      {
        if (paramType != java.sql.Date.class) {
          break;
        }
        paramzzaoy = new java.sql.Date(paramzzaoy.getTime());
      }
    }
    paramzzaoy = String.valueOf(getClass());
    paramType = String.valueOf(paramType);
    throw new IllegalArgumentException(String.valueOf(paramzzaoy).length() + 23 + String.valueOf(paramType).length() + paramzzaoy + " cannot deserialize to " + paramType);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */