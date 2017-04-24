package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzz;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzb
{
  public static <T> int zza(T[] paramArrayOfT, T paramT)
  {
    int i = 0;
    int j;
    if (paramArrayOfT != null)
    {
      j = paramArrayOfT.length;
      if (i >= j) {
        break label37;
      }
      if (!zzz.equal(paramArrayOfT[i], paramT)) {
        break label31;
      }
    }
    for (;;)
    {
      return i;
      j = 0;
      break;
      label31:
      i++;
      break;
      label37:
      i = -1;
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    int j = paramArrayOfDouble.length;
    for (int i = 0; i < j; i++)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[i]));
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    int j = paramArrayOfFloat.length;
    for (int i = 0; i < j; i++)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[i]));
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    for (int i = 0; i < j; i++)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Integer.toString(paramArrayOfInt[i]));
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    for (int i = 0; i < j; i++)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Long.toString(paramArrayOfLong[i]));
    }
  }
  
  public static <T> void zza(StringBuilder paramStringBuilder, T[] paramArrayOfT)
  {
    int j = paramArrayOfT.length;
    for (int i = 0; i < j; i++)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(paramArrayOfT[i].toString());
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append("\"").append(paramArrayOfString[i]).append("\"");
    }
  }
  
  public static void zza(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    int j = paramArrayOfBoolean.length;
    for (int i = 0; i < j; i++)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[i]));
    }
  }
  
  public static byte[] zza(byte[]... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    byte[] arrayOfByte1;
    for (paramVarArgs = new byte[0];; paramVarArgs = arrayOfByte1)
    {
      return paramVarArgs;
      int j = 0;
      int i = 0;
      while (j < paramVarArgs.length)
      {
        i += paramVarArgs[j].length;
        j++;
      }
      arrayOfByte1 = Arrays.copyOf(paramVarArgs[0], i);
      i = paramVarArgs[0].length;
      for (j = 1; j < paramVarArgs.length; j++)
      {
        byte[] arrayOfByte2 = paramVarArgs[j];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
        i += arrayOfByte2.length;
      }
    }
  }
  
  public static Integer[] zza(int[] paramArrayOfInt)
  {
    Object localObject;
    if (paramArrayOfInt == null)
    {
      localObject = null;
      return (Integer[])localObject;
    }
    int j = paramArrayOfInt.length;
    Integer[] arrayOfInteger = new Integer[j];
    for (int i = 0;; i++)
    {
      localObject = arrayOfInteger;
      if (i >= j) {
        break;
      }
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
    }
  }
  
  public static <T> ArrayList<T> zzayh()
  {
    return new ArrayList();
  }
  
  public static <T> ArrayList<T> zzb(T[] paramArrayOfT)
  {
    int j = paramArrayOfT.length;
    ArrayList localArrayList = new ArrayList(j);
    for (int i = 0; i < j; i++) {
      localArrayList.add(paramArrayOfT[i]);
    }
    return localArrayList;
  }
  
  public static <T> boolean zzb(T[] paramArrayOfT, T paramT)
  {
    if (zza(paramArrayOfT, paramT) >= 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\util\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */