package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class zzaql
  extends zzapk<Time>
{
  public static final zzapl bpG = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
    {
      if (paramAnonymouszzaqo.bB() == Time.class) {}
      for (paramAnonymouszzaos = new zzaql();; paramAnonymouszzaos = null) {
        return paramAnonymouszzaos;
      }
    }
  };
  private final DateFormat bqg = new SimpleDateFormat("hh:mm:ss a");
  
  public void zza(zzaqr paramzzaqr, Time paramTime)
    throws IOException
  {
    if (paramTime == null) {}
    for (paramTime = null;; paramTime = this.bqg.format(paramTime)) {
      try
      {
        paramzzaqr.zzut(paramTime);
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  public Time zzn(zzaqp paramzzaqp)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 65	com/google/android/gms/internal/zzaqp:bq	()Lcom/google/android/gms/internal/zzaqq;
    //   6: getstatic 71	com/google/android/gms/internal/zzaqq:brJ	Lcom/google/android/gms/internal/zzaqq;
    //   9: if_acmpne +13 -> 22
    //   12: aload_1
    //   13: invokevirtual 74	com/google/android/gms/internal/zzaqp:nextNull	()V
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: new 35	java/sql/Time
    //   25: dup
    //   26: aload_0
    //   27: getfield 29	com/google/android/gms/internal/zzaql:bqg	Ljava/text/DateFormat;
    //   30: aload_1
    //   31: invokevirtual 78	com/google/android/gms/internal/zzaqp:nextString	()Ljava/lang/String;
    //   34: invokevirtual 82	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   37: invokevirtual 88	java/util/Date:getTime	()J
    //   40: invokespecial 91	java/sql/Time:<init>	(J)V
    //   43: astore_1
    //   44: goto -26 -> 18
    //   47: astore_2
    //   48: new 93	com/google/android/gms/internal/zzaph
    //   51: astore_1
    //   52: aload_1
    //   53: aload_2
    //   54: invokespecial 96	com/google/android/gms/internal/zzaph:<init>	(Ljava/lang/Throwable;)V
    //   57: aload_1
    //   58: athrow
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	zzaql
    //   0	64	1	paramzzaqp	zzaqp
    //   47	7	2	localParseException	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   22	44	47	java/text/ParseException
    //   2	16	59	finally
    //   22	44	59	finally
    //   48	59	59	finally
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */