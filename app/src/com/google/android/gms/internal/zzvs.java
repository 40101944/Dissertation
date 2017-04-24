package com.google.android.gms.internal;

public class zzvs
{
  private zzvt WC = null;
  private boolean zzaoz = false;
  
  /* Error */
  public void initialize(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 14	com/google/android/gms/internal/zzvs:zzaoz	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: aload_1
    //   14: getstatic 29	com/google/android/gms/internal/zztl:Qm	Lcom/google/android/gms/internal/zztl$zzb;
    //   17: ldc 31
    //   19: invokestatic 35	com/google/android/gms/internal/zztl:zza	(Landroid/content/Context;Lcom/google/android/gms/internal/zztl$zzb;Ljava/lang/String;)Lcom/google/android/gms/internal/zztl;
    //   22: ldc 37
    //   24: invokevirtual 41	com/google/android/gms/internal/zztl:zzjd	(Ljava/lang/String;)Landroid/os/IBinder;
    //   27: invokestatic 47	com/google/android/gms/internal/zzvt$zza:asInterface	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzvt;
    //   30: putfield 16	com/google/android/gms/internal/zzvs:WC	Lcom/google/android/gms/internal/zzvt;
    //   33: aload_0
    //   34: getfield 16	com/google/android/gms/internal/zzvs:WC	Lcom/google/android/gms/internal/zzvt;
    //   37: aload_1
    //   38: invokestatic 53	com/google/android/gms/dynamic/zze:zzac	(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/zzd;
    //   41: invokeinterface 59 2 0
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 14	com/google/android/gms/internal/zzvs:zzaoz	Z
    //   51: aload_0
    //   52: monitorexit
    //   53: goto -42 -> 11
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: ldc 61
    //   64: ldc 63
    //   66: aload_1
    //   67: invokestatic 69	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   70: pop
    //   71: goto -20 -> 51
    //   74: astore_1
    //   75: goto -13 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	zzvs
    //   0	78	1	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   2	11	56	finally
    //   12	51	56	finally
    //   51	53	56	finally
    //   57	59	56	finally
    //   62	71	56	finally
    //   12	51	61	android/os/RemoteException
    //   12	51	74	com/google/android/gms/internal/zztl$zza
  }
  
  /* Error */
  public <T> T zzb(zzvq<T> paramzzvq)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 14	com/google/android/gms/internal/zzvs:zzaoz	Z
    //   6: ifne +12 -> 18
    //   9: aload_1
    //   10: invokevirtual 77	com/google/android/gms/internal/zzvq:zzlp	()Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: aload_0
    //   22: getfield 16	com/google/android/gms/internal/zzvs:WC	Lcom/google/android/gms/internal/zzvt;
    //   25: invokevirtual 80	com/google/android/gms/internal/zzvq:zza	(Lcom/google/android/gms/internal/zzvt;)Ljava/lang/Object;
    //   28: astore_1
    //   29: goto -13 -> 16
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	zzvs
    //   0	37	1	paramzzvq	zzvq<T>
    // Exception table:
    //   from	to	target	type
    //   2	16	32	finally
    //   18	20	32	finally
    //   33	35	32	finally
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */