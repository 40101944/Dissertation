package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class zzs
{
  public static boolean DEBUG = Log.isLoggable(TAG, 2);
  public static String TAG = "Volley";
  
  public static void zza(String paramString, Object... paramVarArgs)
  {
    if (DEBUG) {
      Log.v(TAG, zzd(paramString, paramVarArgs));
    }
  }
  
  public static void zza(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.e(TAG, zzd(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void zzb(String paramString, Object... paramVarArgs)
  {
    Log.d(TAG, zzd(paramString, paramVarArgs));
  }
  
  public static void zzc(String paramString, Object... paramVarArgs)
  {
    Log.e(TAG, zzd(paramString, paramVarArgs));
  }
  
  private static String zzd(String paramString, Object... paramVarArgs)
  {
    int i;
    label20:
    String str;
    if (paramVarArgs == null)
    {
      paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= paramVarArgs.length) {
        break label175;
      }
      if (paramVarArgs[i].getClass().equals(zzs.class)) {
        break label169;
      }
      str = paramVarArgs[i].getClassName();
      str = str.substring(str.lastIndexOf('.') + 1);
      str = str.substring(str.lastIndexOf('$') + 1);
      paramVarArgs = String.valueOf(paramVarArgs[i].getMethodName());
    }
    label169:
    label175:
    for (paramVarArgs = String.valueOf(str).length() + 1 + String.valueOf(paramVarArgs).length() + str + "." + paramVarArgs;; paramVarArgs = "<unknown>")
    {
      return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
      paramString = String.format(Locale.US, paramString, paramVarArgs);
      break;
      i++;
      break label20;
    }
  }
  
  static class zza
  {
    public static final boolean zzbj = zzs.DEBUG;
    private final List<zza> zzbk = new ArrayList();
    private boolean zzbl = false;
    
    private long getTotalDuration()
    {
      if (this.zzbk.size() == 0) {}
      for (long l = 0L;; l = ((zza)this.zzbk.get(this.zzbk.size() - 1)).time - l)
      {
        return l;
        l = ((zza)this.zzbk.get(0)).time;
      }
    }
    
    protected void finalize()
      throws Throwable
    {
      if (!this.zzbl)
      {
        zzd("Request on the loose");
        zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }
    
    public void zza(String paramString, long paramLong)
    {
      try
      {
        if (this.zzbl)
        {
          paramString = new java/lang/IllegalStateException;
          paramString.<init>("Marker added to finished log");
          throw paramString;
        }
      }
      finally {}
      List localList = this.zzbk;
      zza localzza = new com/google/android/gms/internal/zzs$zza$zza;
      localzza.<init>(paramString, paramLong, SystemClock.elapsedRealtime());
      localList.add(localzza);
    }
    
    /* Error */
    public void zzd(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield 33	com/google/android/gms/internal/zzs$zza:zzbl	Z
      //   7: aload_0
      //   8: invokespecial 86	com/google/android/gms/internal/zzs$zza:getTotalDuration	()J
      //   11: lstore 4
      //   13: lload 4
      //   15: lconst_0
      //   16: lcmp
      //   17: ifgt +6 -> 23
      //   20: aload_0
      //   21: monitorexit
      //   22: return
      //   23: aload_0
      //   24: getfield 31	com/google/android/gms/internal/zzs$zza:zzbk	Ljava/util/List;
      //   27: iconst_0
      //   28: invokeinterface 45 2 0
      //   33: checkcast 9	com/google/android/gms/internal/zzs$zza$zza
      //   36: getfield 49	com/google/android/gms/internal/zzs$zza$zza:time	J
      //   39: lstore_2
      //   40: ldc 88
      //   42: iconst_2
      //   43: anewarray 4	java/lang/Object
      //   46: dup
      //   47: iconst_0
      //   48: lload 4
      //   50: invokestatic 94	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   53: aastore
      //   54: dup
      //   55: iconst_1
      //   56: aload_1
      //   57: aastore
      //   58: invokestatic 97	com/google/android/gms/internal/zzs:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   61: aload_0
      //   62: getfield 31	com/google/android/gms/internal/zzs$zza:zzbk	Ljava/util/List;
      //   65: invokeinterface 101 1 0
      //   70: astore 6
      //   72: aload 6
      //   74: invokeinterface 107 1 0
      //   79: ifeq -59 -> 20
      //   82: aload 6
      //   84: invokeinterface 111 1 0
      //   89: checkcast 9	com/google/android/gms/internal/zzs$zza$zza
      //   92: astore_1
      //   93: aload_1
      //   94: getfield 49	com/google/android/gms/internal/zzs$zza$zza:time	J
      //   97: lstore 4
      //   99: ldc 113
      //   101: iconst_3
      //   102: anewarray 4	java/lang/Object
      //   105: dup
      //   106: iconst_0
      //   107: lload 4
      //   109: lload_2
      //   110: lsub
      //   111: invokestatic 94	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   114: aastore
      //   115: dup
      //   116: iconst_1
      //   117: aload_1
      //   118: getfield 116	com/google/android/gms/internal/zzs$zza$zza:zzbm	J
      //   121: invokestatic 94	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   124: aastore
      //   125: dup
      //   126: iconst_2
      //   127: aload_1
      //   128: getfield 120	com/google/android/gms/internal/zzs$zza$zza:name	Ljava/lang/String;
      //   131: aastore
      //   132: invokestatic 97	com/google/android/gms/internal/zzs:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   135: lload 4
      //   137: lstore_2
      //   138: goto -66 -> 72
      //   141: astore_1
      //   142: aload_0
      //   143: monitorexit
      //   144: aload_1
      //   145: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	146	0	this	zza
      //   0	146	1	paramString	String
      //   39	99	2	l1	long
      //   11	125	4	l2	long
      //   70	13	6	localIterator	java.util.Iterator
      // Exception table:
      //   from	to	target	type
      //   2	13	141	finally
      //   23	72	141	finally
      //   72	135	141	finally
    }
    
    private static class zza
    {
      public final String name;
      public final long time;
      public final long zzbm;
      
      public zza(String paramString, long paramLong1, long paramLong2)
      {
        this.name = paramString;
        this.zzbm = paramLong1;
        this.time = paramLong2;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */