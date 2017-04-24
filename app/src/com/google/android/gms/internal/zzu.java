package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class zzu
{
  protected static final Comparator<byte[]> zzbv = new Comparator()
  {
    public int zza(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
    {
      return paramAnonymousArrayOfByte1.length - paramAnonymousArrayOfByte2.length;
    }
  };
  private List<byte[]> zzbr = new LinkedList();
  private List<byte[]> zzbs = new ArrayList(64);
  private int zzbt = 0;
  private final int zzbu;
  
  public zzu(int paramInt)
  {
    this.zzbu = paramInt;
  }
  
  /* Error */
  private void zzv()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/google/android/gms/internal/zzu:zzbt	I
    //   6: aload_0
    //   7: getfield 41	com/google/android/gms/internal/zzu:zzbu	I
    //   10: if_icmple +47 -> 57
    //   13: aload_0
    //   14: getfield 31	com/google/android/gms/internal/zzu:zzbr	Ljava/util/List;
    //   17: iconst_0
    //   18: invokeinterface 48 2 0
    //   23: checkcast 50	[B
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 37	com/google/android/gms/internal/zzu:zzbs	Ljava/util/List;
    //   31: aload_1
    //   32: invokeinterface 53 2 0
    //   37: pop
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 39	com/google/android/gms/internal/zzu:zzbt	I
    //   43: aload_1
    //   44: arraylength
    //   45: isub
    //   46: putfield 39	com/google/android/gms/internal/zzu:zzbt	I
    //   49: goto -47 -> 2
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	zzu
    //   26	18	1	arrayOfByte	byte[]
    //   52	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	49	52	finally
  }
  
  /* Error */
  public void zza(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: arraylength
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 41	com/google/android/gms/internal/zzu:zzbu	I
    //   13: istore_3
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmple +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 31	com/google/android/gms/internal/zzu:zzbr	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 58 2 0
    //   32: pop
    //   33: aload_0
    //   34: getfield 37	com/google/android/gms/internal/zzu:zzbs	Ljava/util/List;
    //   37: aload_1
    //   38: getstatic 23	com/google/android/gms/internal/zzu:zzbv	Ljava/util/Comparator;
    //   41: invokestatic 64	java/util/Collections:binarySearch	(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   44: istore_3
    //   45: iload_3
    //   46: istore_2
    //   47: iload_3
    //   48: ifge +8 -> 56
    //   51: iload_3
    //   52: ineg
    //   53: iconst_1
    //   54: isub
    //   55: istore_2
    //   56: aload_0
    //   57: getfield 37	com/google/android/gms/internal/zzu:zzbs	Ljava/util/List;
    //   60: iload_2
    //   61: aload_1
    //   62: invokeinterface 67 3 0
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 39	com/google/android/gms/internal/zzu:zzbt	I
    //   72: aload_1
    //   73: arraylength
    //   74: iadd
    //   75: putfield 39	com/google/android/gms/internal/zzu:zzbt	I
    //   78: aload_0
    //   79: invokespecial 69	com/google/android/gms/internal/zzu:zzv	()V
    //   82: goto -63 -> 19
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	zzu
    //   0	90	1	paramArrayOfByte	byte[]
    //   8	53	2	i	int
    //   13	39	3	j	int
    // Exception table:
    //   from	to	target	type
    //   6	14	85	finally
    //   22	45	85	finally
    //   56	82	85	finally
  }
  
  /* Error */
  public byte[] zzb(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 37	com/google/android/gms/internal/zzu:zzbs	Ljava/util/List;
    //   9: invokeinterface 75 1 0
    //   14: if_icmpge +66 -> 80
    //   17: aload_0
    //   18: getfield 37	com/google/android/gms/internal/zzu:zzbs	Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface 78 2 0
    //   27: checkcast 50	[B
    //   30: astore_3
    //   31: aload_3
    //   32: arraylength
    //   33: iload_1
    //   34: if_icmplt +40 -> 74
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 39	com/google/android/gms/internal/zzu:zzbt	I
    //   42: aload_3
    //   43: arraylength
    //   44: isub
    //   45: putfield 39	com/google/android/gms/internal/zzu:zzbt	I
    //   48: aload_0
    //   49: getfield 37	com/google/android/gms/internal/zzu:zzbs	Ljava/util/List;
    //   52: iload_2
    //   53: invokeinterface 48 2 0
    //   58: pop
    //   59: aload_0
    //   60: getfield 31	com/google/android/gms/internal/zzu:zzbr	Ljava/util/List;
    //   63: aload_3
    //   64: invokeinterface 53 2 0
    //   69: pop
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: areturn
    //   74: iinc 2 1
    //   77: goto -73 -> 4
    //   80: iload_1
    //   81: newarray <illegal type>
    //   83: astore_3
    //   84: goto -14 -> 70
    //   87: astore_3
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_3
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	zzu
    //   0	92	1	paramInt	int
    //   3	72	2	i	int
    //   30	54	3	arrayOfByte	byte[]
    //   87	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	70	87	finally
    //   80	84	87	finally
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */