package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class zzapd
{
  public zzaoy zza(Reader paramReader)
    throws zzaoz, zzaph
  {
    try
    {
      zzaqp localzzaqp = new com/google/android/gms/internal/zzaqp;
      localzzaqp.<init>(paramReader);
      paramReader = zzh(localzzaqp);
      if ((!paramReader.aY()) && (localzzaqp.bq() != zzaqq.brK))
      {
        paramReader = new com/google/android/gms/internal/zzaph;
        paramReader.<init>("Did not consume the entire document.");
        throw paramReader;
      }
    }
    catch (zzaqs paramReader)
    {
      throw new zzaph(paramReader);
    }
    catch (IOException paramReader)
    {
      throw new zzaoz(paramReader);
    }
    catch (NumberFormatException paramReader)
    {
      throw new zzaph(paramReader);
    }
    return paramReader;
  }
  
  /* Error */
  public zzaoy zzh(zzaqp paramzzaqp)
    throws zzaoz, zzaph
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 63	com/google/android/gms/internal/zzaqp:isLenient	()Z
    //   4: istore_2
    //   5: aload_1
    //   6: iconst_1
    //   7: invokevirtual 67	com/google/android/gms/internal/zzaqp:setLenient	(Z)V
    //   10: aload_1
    //   11: invokestatic 70	com/google/android/gms/internal/zzapz:zzh	(Lcom/google/android/gms/internal/zzaqp;)Lcom/google/android/gms/internal/zzaoy;
    //   14: astore_3
    //   15: aload_1
    //   16: iload_2
    //   17: invokevirtual 67	com/google/android/gms/internal/zzaqp:setLenient	(Z)V
    //   20: aload_3
    //   21: areturn
    //   22: astore_3
    //   23: new 72	com/google/android/gms/internal/zzapc
    //   26: astore 6
    //   28: aload_1
    //   29: invokestatic 78	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   32: astore 4
    //   34: new 80	java/lang/StringBuilder
    //   37: astore 5
    //   39: aload 5
    //   41: aload 4
    //   43: invokestatic 78	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   46: invokevirtual 84	java/lang/String:length	()I
    //   49: bipush 36
    //   51: iadd
    //   52: invokespecial 87	java/lang/StringBuilder:<init>	(I)V
    //   55: aload 6
    //   57: aload 5
    //   59: ldc 89
    //   61: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 4
    //   66: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 95
    //   71: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: aload_3
    //   78: invokespecial 102	com/google/android/gms/internal/zzapc:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: aload 6
    //   83: athrow
    //   84: astore_3
    //   85: aload_1
    //   86: iload_2
    //   87: invokevirtual 67	com/google/android/gms/internal/zzaqp:setLenient	(Z)V
    //   90: aload_3
    //   91: athrow
    //   92: astore 4
    //   94: new 72	com/google/android/gms/internal/zzapc
    //   97: astore 6
    //   99: aload_1
    //   100: invokestatic 78	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   103: astore 5
    //   105: new 80	java/lang/StringBuilder
    //   108: astore_3
    //   109: aload_3
    //   110: aload 5
    //   112: invokestatic 78	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   115: invokevirtual 84	java/lang/String:length	()I
    //   118: bipush 36
    //   120: iadd
    //   121: invokespecial 87	java/lang/StringBuilder:<init>	(I)V
    //   124: aload 6
    //   126: aload_3
    //   127: ldc 89
    //   129: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 5
    //   134: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 95
    //   139: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: aload 4
    //   147: invokespecial 102	com/google/android/gms/internal/zzapc:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload 6
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	zzapd
    //   0	153	1	paramzzaqp	zzaqp
    //   4	83	2	bool	boolean
    //   14	7	3	localzzaoy	zzaoy
    //   22	56	3	localStackOverflowError	StackOverflowError
    //   84	7	3	localObject1	Object
    //   108	19	3	localStringBuilder	StringBuilder
    //   32	33	4	str	String
    //   92	54	4	localOutOfMemoryError	OutOfMemoryError
    //   37	96	5	localObject2	Object
    //   26	125	6	localzzapc	zzapc
    // Exception table:
    //   from	to	target	type
    //   10	15	22	java/lang/StackOverflowError
    //   10	15	84	finally
    //   23	84	84	finally
    //   94	153	84	finally
    //   10	15	92	java/lang/OutOfMemoryError
  }
  
  public zzaoy zzuq(String paramString)
    throws zzaph
  {
    return zza(new StringReader(paramString));
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzapd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */