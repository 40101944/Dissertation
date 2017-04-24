package com.google.android.gms.common.util;

import android.os.Process;

public class zzt
{
  private static String GE = null;
  private static final int GF = Process.myPid();
  
  public static String zzayz()
  {
    if (GE == null) {
      GE = zzhi(GF);
    }
    return GE;
  }
  
  /* Error */
  static String zzhi(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iload_0
    //   3: ifgt +5 -> 8
    //   6: aload_2
    //   7: areturn
    //   8: invokestatic 35	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   11: astore_3
    //   12: new 37	java/io/BufferedReader
    //   15: astore_1
    //   16: new 39	java/io/FileReader
    //   19: astore 5
    //   21: new 41	java/lang/StringBuilder
    //   24: astore 4
    //   26: aload 4
    //   28: bipush 25
    //   30: invokespecial 45	java/lang/StringBuilder:<init>	(I)V
    //   33: aload 5
    //   35: aload 4
    //   37: ldc 47
    //   39: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_0
    //   43: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: ldc 56
    //   48: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 62	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   57: aload_1
    //   58: aload 5
    //   60: invokespecial 65	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: aload_3
    //   64: invokestatic 69	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   67: aload_1
    //   68: invokevirtual 72	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: invokevirtual 77	java/lang/String:trim	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: astore_2
    //   77: aload_1
    //   78: invokestatic 83	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   81: goto -75 -> 6
    //   84: astore_1
    //   85: aload_3
    //   86: invokestatic 69	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: invokestatic 83	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   98: goto -92 -> 6
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: invokestatic 83	com/google/android/gms/common/util/zzo:zzb	(Ljava/io/Closeable;)V
    //   108: aload_2
    //   109: athrow
    //   110: astore_2
    //   111: goto -7 -> 104
    //   114: astore_3
    //   115: goto -21 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramInt	int
    //   15	63	1	localBufferedReader	java.io.BufferedReader
    //   84	6	1	localObject1	Object
    //   91	1	1	localIOException1	java.io.IOException
    //   93	12	1	localCloseable	java.io.Closeable
    //   1	76	2	localObject2	Object
    //   101	8	2	localObject3	Object
    //   110	1	2	localObject4	Object
    //   11	75	3	localObject5	Object
    //   114	1	3	localIOException2	java.io.IOException
    //   24	12	4	localStringBuilder	StringBuilder
    //   19	40	5	localFileReader	java.io.FileReader
    // Exception table:
    //   from	to	target	type
    //   12	63	84	finally
    //   8	12	91	java/io/IOException
    //   85	91	91	java/io/IOException
    //   8	12	101	finally
    //   85	91	101	finally
    //   63	75	110	finally
    //   63	75	114	java/io/IOException
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\util\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */