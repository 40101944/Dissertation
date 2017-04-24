package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class zzaqk
  extends zzapk<Date>
{
  public static final zzapl bpG = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
    {
      if (paramAnonymouszzaqo.bB() == Date.class) {}
      for (paramAnonymouszzaos = new zzaqk();; paramAnonymouszzaos = null) {
        return paramAnonymouszzaos;
      }
    }
  };
  private final DateFormat bqg = new SimpleDateFormat("MMM d, yyyy");
  
  public void zza(zzaqr paramzzaqr, Date paramDate)
    throws IOException
  {
    if (paramDate == null) {}
    for (paramDate = null;; paramDate = this.bqg.format(paramDate)) {
      try
      {
        paramzzaqr.zzut(paramDate);
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  public Date zzm(zzaqp paramzzaqp)
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
    //   22: new 35	java/sql/Date
    //   25: dup
    //   26: aload_0
    //   27: getfield 29	com/google/android/gms/internal/zzaqk:bqg	Ljava/text/DateFormat;
    //   30: aload_1
    //   31: invokevirtual 78	com/google/android/gms/internal/zzaqp:nextString	()Ljava/lang/String;
    //   34: invokevirtual 82	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   37: invokevirtual 88	java/util/Date:getTime	()J
    //   40: invokespecial 91	java/sql/Date:<init>	(J)V
    //   43: astore_1
    //   44: goto -26 -> 18
    //   47: astore_1
    //   48: new 93	com/google/android/gms/internal/zzaph
    //   51: astore_2
    //   52: aload_2
    //   53: aload_1
    //   54: invokespecial 96	com/google/android/gms/internal/zzaph:<init>	(Ljava/lang/Throwable;)V
    //   57: aload_2
    //   58: athrow
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	zzaqk
    //   0	64	1	paramzzaqp	zzaqp
    //   51	7	2	localzzaph	zzaph
    // Exception table:
    //   from	to	target	type
    //   22	44	47	java/text/ParseException
    //   2	16	59	finally
    //   22	44	59	finally
    //   48	59	59	finally
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */