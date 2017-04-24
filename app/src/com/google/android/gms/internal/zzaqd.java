package com.google.android.gms.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class zzaqd
  extends zzapk<Date>
{
  public static final zzapl bpG = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
    {
      if (paramAnonymouszzaqo.bB() == Date.class) {}
      for (paramAnonymouszzaos = new zzaqd();; paramAnonymouszzaos = null) {
        return paramAnonymouszzaos;
      }
    }
  };
  private final DateFormat bnQ = DateFormat.getDateTimeInstance(2, 2, Locale.US);
  private final DateFormat bnR = DateFormat.getDateTimeInstance(2, 2);
  private final DateFormat bnS = bp();
  
  private static DateFormat bp()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat;
  }
  
  private Date zzur(String paramString)
  {
    try
    {
      Date localDate1 = this.bnR.parse(paramString);
      paramString = localDate1;
    }
    catch (ParseException localParseException1)
    {
      try
      {
        Date localDate2 = this.bnQ.parse(paramString);
        paramString = localDate2;
      }
      catch (ParseException localParseException2)
      {
        try
        {
          Date localDate3 = this.bnS.parse(paramString);
          paramString = localDate3;
        }
        catch (ParseException localParseException3)
        {
          zzaph localzzaph = new com/google/android/gms/internal/zzaph;
          localzzaph.<init>(paramString, localParseException3);
          throw localzzaph;
        }
      }
    }
    finally {}
    return paramString;
  }
  
  public void zza(zzaqr paramzzaqr, Date paramDate)
    throws IOException
  {
    if (paramDate == null) {}
    for (;;)
    {
      try
      {
        paramzzaqr.bA();
        return;
      }
      finally {}
      paramzzaqr.zzut(this.bnQ.format(paramDate));
    }
  }
  
  public Date zzk(zzaqp paramzzaqp)
    throws IOException
  {
    if (paramzzaqp.bq() == zzaqq.brJ) {
      paramzzaqp.nextNull();
    }
    for (paramzzaqp = null;; paramzzaqp = zzur(paramzzaqp.nextString())) {
      return paramzzaqp;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */