package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzaa;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class zzn
  extends zzd
{
  private volatile String cj;
  private Future<String> dU;
  
  protected zzn(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  private String zzaeb()
  {
    String str3 = zzaec();
    String str1 = str3;
    try
    {
      if (!zzq(zzacc().getContext(), str3)) {
        str1 = "0";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zze("Error saving clientId file", localException);
        String str2 = "0";
      }
    }
    return str1;
  }
  
  private boolean zzq(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    zzaa.zzib(paramString);
    zzaa.zzht("ClientId should be saved from worker thread");
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    Object localObject1 = localObject6;
    for (;;)
    {
      try
      {
        zza("Storing clientId", paramString);
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = localObject6;
        paramContext = paramContext.openFileOutput("gaClientId", 0);
        localObject2 = paramContext;
        localObject3 = paramContext;
        localObject1 = paramContext;
        paramContext.write(paramString.getBytes());
      }
      catch (FileNotFoundException paramContext)
      {
        localObject1 = localObject2;
        zze("Error creating clientId file", paramContext);
        bool1 = bool2;
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((FileOutputStream)localObject2).close();
          bool1 = bool2;
        }
        catch (IOException paramContext)
        {
          zze("Failed to close clientId writing stream", paramContext);
          bool1 = bool2;
        }
        continue;
      }
      catch (IOException paramContext)
      {
        localObject1 = localObject3;
        zze("Error writing to clientId file", paramContext);
        boolean bool1 = bool2;
        if (localObject3 == null) {
          continue;
        }
        try
        {
          ((FileOutputStream)localObject3).close();
          bool1 = bool2;
        }
        catch (IOException paramContext)
        {
          zze("Failed to close clientId writing stream", paramContext);
          bool1 = bool2;
        }
        continue;
      }
      finally
      {
        if (localObject1 == null) {
          break label202;
        }
      }
      try
      {
        paramContext.close();
        bool1 = true;
        return bool1;
      }
      catch (IOException paramContext)
      {
        zze("Failed to close clientId writing stream", paramContext);
      }
    }
    try
    {
      ((FileOutputStream)localObject1).close();
      label202:
      throw paramContext;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        zze("Failed to close clientId writing stream", paramString);
      }
    }
  }
  
  /* Error */
  public String zzady()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 109	com/google/android/gms/analytics/internal/zzn:zzacj	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 111	com/google/android/gms/analytics/internal/zzn:cj	Ljava/lang/String;
    //   10: ifnonnull +26 -> 36
    //   13: aload_0
    //   14: invokevirtual 33	com/google/android/gms/analytics/internal/zzn:zzacc	()Lcom/google/android/gms/analytics/zzi;
    //   17: astore_2
    //   18: new 6	com/google/android/gms/analytics/internal/zzn$1
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: invokespecial 114	com/google/android/gms/analytics/internal/zzn$1:<init>	(Lcom/google/android/gms/analytics/internal/zzn;)V
    //   27: aload_0
    //   28: aload_2
    //   29: aload_1
    //   30: invokevirtual 118	com/google/android/gms/analytics/zzi:zzc	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   33: putfield 120	com/google/android/gms/analytics/internal/zzn:dU	Ljava/util/concurrent/Future;
    //   36: aload_0
    //   37: getfield 120	com/google/android/gms/analytics/internal/zzn:dU	Ljava/util/concurrent/Future;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +47 -> 89
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 120	com/google/android/gms/analytics/internal/zzn:dU	Ljava/util/concurrent/Future;
    //   50: invokeinterface 126 1 0
    //   55: checkcast 81	java/lang/String
    //   58: putfield 111	com/google/android/gms/analytics/internal/zzn:cj	Ljava/lang/String;
    //   61: aload_0
    //   62: getfield 111	com/google/android/gms/analytics/internal/zzn:cj	Ljava/lang/String;
    //   65: ifnonnull +9 -> 74
    //   68: aload_0
    //   69: ldc 45
    //   71: putfield 111	com/google/android/gms/analytics/internal/zzn:cj	Ljava/lang/String;
    //   74: aload_0
    //   75: ldc -128
    //   77: aload_0
    //   78: getfield 111	com/google/android/gms/analytics/internal/zzn:cj	Ljava/lang/String;
    //   81: invokevirtual 71	com/google/android/gms/analytics/internal/zzn:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 120	com/google/android/gms/analytics/internal/zzn:dU	Ljava/util/concurrent/Future;
    //   89: aload_0
    //   90: getfield 111	com/google/android/gms/analytics/internal/zzn:cj	Ljava/lang/String;
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: areturn
    //   98: astore_1
    //   99: aload_0
    //   100: ldc -126
    //   102: aload_1
    //   103: invokevirtual 133	com/google/android/gms/analytics/internal/zzn:zzd	(Ljava/lang/String;Ljava/lang/Object;)V
    //   106: aload_0
    //   107: ldc 45
    //   109: putfield 111	com/google/android/gms/analytics/internal/zzn:cj	Ljava/lang/String;
    //   112: goto -51 -> 61
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: aload_0
    //   122: ldc -121
    //   124: aload_1
    //   125: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   128: aload_0
    //   129: ldc 45
    //   131: putfield 111	com/google/android/gms/analytics/internal/zzn:cj	Ljava/lang/String;
    //   134: goto -73 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	zzn
    //   21	76	1	localObject1	Object
    //   98	5	1	localInterruptedException	InterruptedException
    //   115	4	1	localObject2	Object
    //   120	5	1	localExecutionException	java.util.concurrent.ExecutionException
    //   17	12	2	localzzi	zzi
    // Exception table:
    //   from	to	target	type
    //   45	61	98	java/lang/InterruptedException
    //   6	36	115	finally
    //   36	41	115	finally
    //   45	61	115	finally
    //   61	74	115	finally
    //   74	89	115	finally
    //   89	96	115	finally
    //   99	112	115	finally
    //   116	118	115	finally
    //   121	134	115	finally
    //   45	61	120	java/util/concurrent/ExecutionException
  }
  
  String zzadz()
  {
    try
    {
      this.cj = null;
      zzi localzzi = zzacc();
      Callable local2 = new com/google/android/gms/analytics/internal/zzn$2;
      local2.<init>(this);
      this.dU = localzzi.zzc(local2);
      return zzady();
    }
    finally {}
  }
  
  String zzaea()
  {
    String str2 = zzay(zzacc().getContext());
    String str1 = str2;
    if (str2 == null) {
      str1 = zzaeb();
    }
    return str1;
  }
  
  protected String zzaec()
  {
    return UUID.randomUUID().toString().toLowerCase();
  }
  
  /* Error */
  protected String zzay(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc -98
    //   5: invokestatic 67	com/google/android/gms/common/internal/zzaa:zzht	(Ljava/lang/String;)V
    //   8: aload_1
    //   9: ldc 73
    //   11: invokevirtual 162	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   14: astore_3
    //   15: aload_3
    //   16: astore 4
    //   18: bipush 36
    //   20: newarray <illegal type>
    //   22: astore 7
    //   24: aload_3
    //   25: astore 4
    //   27: aload_3
    //   28: aload 7
    //   30: iconst_0
    //   31: bipush 36
    //   33: invokevirtual 168	java/io/FileInputStream:read	([BII)I
    //   36: istore_2
    //   37: aload_3
    //   38: astore 4
    //   40: aload_3
    //   41: invokevirtual 172	java/io/FileInputStream:available	()I
    //   44: ifle +59 -> 103
    //   47: aload_3
    //   48: astore 4
    //   50: aload_0
    //   51: ldc -82
    //   53: invokevirtual 177	com/google/android/gms/analytics/internal/zzn:zzev	(Ljava/lang/String;)V
    //   56: aload_3
    //   57: astore 4
    //   59: aload_3
    //   60: invokevirtual 178	java/io/FileInputStream:close	()V
    //   63: aload_3
    //   64: astore 4
    //   66: aload_1
    //   67: ldc 73
    //   69: invokevirtual 182	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   72: pop
    //   73: aload 6
    //   75: astore_1
    //   76: aload_3
    //   77: ifnull +10 -> 87
    //   80: aload_3
    //   81: invokevirtual 178	java/io/FileInputStream:close	()V
    //   84: aload 6
    //   86: astore_1
    //   87: aload_1
    //   88: areturn
    //   89: astore_1
    //   90: aload_0
    //   91: ldc -72
    //   93: aload_1
    //   94: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   97: aload 6
    //   99: astore_1
    //   100: goto -13 -> 87
    //   103: iload_2
    //   104: bipush 14
    //   106: if_icmpge +60 -> 166
    //   109: aload_3
    //   110: astore 4
    //   112: aload_0
    //   113: ldc -70
    //   115: invokevirtual 177	com/google/android/gms/analytics/internal/zzn:zzev	(Ljava/lang/String;)V
    //   118: aload_3
    //   119: astore 4
    //   121: aload_3
    //   122: invokevirtual 178	java/io/FileInputStream:close	()V
    //   125: aload_3
    //   126: astore 4
    //   128: aload_1
    //   129: ldc 73
    //   131: invokevirtual 182	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   134: pop
    //   135: aload 6
    //   137: astore_1
    //   138: aload_3
    //   139: ifnull -52 -> 87
    //   142: aload_3
    //   143: invokevirtual 178	java/io/FileInputStream:close	()V
    //   146: aload 6
    //   148: astore_1
    //   149: goto -62 -> 87
    //   152: astore_1
    //   153: aload_0
    //   154: ldc -72
    //   156: aload_1
    //   157: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   160: aload 6
    //   162: astore_1
    //   163: goto -76 -> 87
    //   166: aload_3
    //   167: astore 4
    //   169: aload_3
    //   170: invokevirtual 178	java/io/FileInputStream:close	()V
    //   173: aload_3
    //   174: astore 4
    //   176: new 81	java/lang/String
    //   179: astore 5
    //   181: aload_3
    //   182: astore 4
    //   184: aload 5
    //   186: aload 7
    //   188: iconst_0
    //   189: iload_2
    //   190: invokespecial 189	java/lang/String:<init>	([BII)V
    //   193: aload_3
    //   194: astore 4
    //   196: aload_0
    //   197: ldc -65
    //   199: aload 5
    //   201: invokevirtual 71	com/google/android/gms/analytics/internal/zzn:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   204: aload_3
    //   205: ifnull +7 -> 212
    //   208: aload_3
    //   209: invokevirtual 178	java/io/FileInputStream:close	()V
    //   212: aload 5
    //   214: astore_1
    //   215: goto -128 -> 87
    //   218: astore_1
    //   219: aload_0
    //   220: ldc -72
    //   222: aload_1
    //   223: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   226: goto -14 -> 212
    //   229: astore_1
    //   230: aconst_null
    //   231: astore_3
    //   232: aload 6
    //   234: astore_1
    //   235: aload_3
    //   236: ifnull -149 -> 87
    //   239: aload_3
    //   240: invokevirtual 178	java/io/FileInputStream:close	()V
    //   243: aload 6
    //   245: astore_1
    //   246: goto -159 -> 87
    //   249: astore_1
    //   250: aload_0
    //   251: ldc -72
    //   253: aload_1
    //   254: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   257: aload 6
    //   259: astore_1
    //   260: goto -173 -> 87
    //   263: astore 5
    //   265: aconst_null
    //   266: astore_3
    //   267: aload_3
    //   268: astore 4
    //   270: aload_0
    //   271: ldc -63
    //   273: aload 5
    //   275: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   278: aload_3
    //   279: astore 4
    //   281: aload_1
    //   282: ldc 73
    //   284: invokevirtual 182	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   287: pop
    //   288: aload 6
    //   290: astore_1
    //   291: aload_3
    //   292: ifnull -205 -> 87
    //   295: aload_3
    //   296: invokevirtual 178	java/io/FileInputStream:close	()V
    //   299: aload 6
    //   301: astore_1
    //   302: goto -215 -> 87
    //   305: astore_1
    //   306: aload_0
    //   307: ldc -72
    //   309: aload_1
    //   310: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   313: aload 6
    //   315: astore_1
    //   316: goto -229 -> 87
    //   319: astore_1
    //   320: aconst_null
    //   321: astore 4
    //   323: aload 4
    //   325: ifnull +8 -> 333
    //   328: aload 4
    //   330: invokevirtual 178	java/io/FileInputStream:close	()V
    //   333: aload_1
    //   334: athrow
    //   335: astore_3
    //   336: aload_0
    //   337: ldc -72
    //   339: aload_3
    //   340: invokevirtual 51	com/google/android/gms/analytics/internal/zzn:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   343: goto -10 -> 333
    //   346: astore_1
    //   347: goto -24 -> 323
    //   350: astore 5
    //   352: goto -85 -> 267
    //   355: astore_1
    //   356: goto -124 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	zzn
    //   0	359	1	paramContext	Context
    //   36	154	2	i	int
    //   14	282	3	localFileInputStream1	java.io.FileInputStream
    //   335	5	3	localIOException1	IOException
    //   16	313	4	localFileInputStream2	java.io.FileInputStream
    //   179	34	5	str	String
    //   263	11	5	localIOException2	IOException
    //   350	1	5	localIOException3	IOException
    //   1	313	6	localObject	Object
    //   22	165	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   80	84	89	java/io/IOException
    //   142	146	152	java/io/IOException
    //   208	212	218	java/io/IOException
    //   8	15	229	java/io/FileNotFoundException
    //   239	243	249	java/io/IOException
    //   8	15	263	java/io/IOException
    //   295	299	305	java/io/IOException
    //   8	15	319	finally
    //   328	333	335	java/io/IOException
    //   18	24	346	finally
    //   27	37	346	finally
    //   40	47	346	finally
    //   50	56	346	finally
    //   59	63	346	finally
    //   66	73	346	finally
    //   112	118	346	finally
    //   121	125	346	finally
    //   128	135	346	finally
    //   169	173	346	finally
    //   176	181	346	finally
    //   184	193	346	finally
    //   196	204	346	finally
    //   270	278	346	finally
    //   281	288	346	finally
    //   18	24	350	java/io/IOException
    //   27	37	350	java/io/IOException
    //   40	47	350	java/io/IOException
    //   50	56	350	java/io/IOException
    //   59	63	350	java/io/IOException
    //   66	73	350	java/io/IOException
    //   112	118	350	java/io/IOException
    //   121	125	350	java/io/IOException
    //   128	135	350	java/io/IOException
    //   169	173	350	java/io/IOException
    //   176	181	350	java/io/IOException
    //   184	193	350	java/io/IOException
    //   196	204	350	java/io/IOException
    //   18	24	355	java/io/FileNotFoundException
    //   27	37	355	java/io/FileNotFoundException
    //   40	47	355	java/io/FileNotFoundException
    //   50	56	355	java/io/FileNotFoundException
    //   59	63	355	java/io/FileNotFoundException
    //   66	73	355	java/io/FileNotFoundException
    //   112	118	355	java/io/FileNotFoundException
    //   121	125	355	java/io/FileNotFoundException
    //   128	135	355	java/io/FileNotFoundException
    //   169	173	355	java/io/FileNotFoundException
    //   176	181	355	java/io/FileNotFoundException
    //   184	193	355	java/io/FileNotFoundException
    //   196	204	355	java/io/FileNotFoundException
  }
  
  protected void zzzy() {}
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */