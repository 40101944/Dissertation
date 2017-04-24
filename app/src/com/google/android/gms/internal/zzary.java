package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzary
{
  protected static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  protected static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final Object btO = new Object();
  
  public static boolean equals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    boolean bool;
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length == 0)) {
      if ((paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length == 0)) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = Arrays.equals(paramArrayOfFloat1, paramArrayOfFloat2);
    }
  }
  
  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool;
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length == 0)) {
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length == 0)) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
    }
  }
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    boolean bool;
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong1.length == 0)) {
      if ((paramArrayOfLong2 == null) || (paramArrayOfLong2.length == 0)) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
    }
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    boolean bool2 = false;
    int k;
    if (paramArrayOfObject1 == null)
    {
      k = 0;
      if (paramArrayOfObject2 != null) {
        break label46;
      }
    }
    int j;
    int i;
    label46:
    for (int m = 0;; m = paramArrayOfObject2.length)
    {
      j = 0;
      for (i = 0; (i < k) && (paramArrayOfObject1[i] == null); i++) {}
      k = paramArrayOfObject1.length;
      break;
    }
    for (;;)
    {
      if ((j < m) && (paramArrayOfObject2[j] == null))
      {
        j++;
      }
      else
      {
        int n;
        int i1;
        label89:
        boolean bool1;
        if (i >= k)
        {
          n = 1;
          if (j < m) {
            break label111;
          }
          i1 = 1;
          if ((n == 0) || (i1 == 0)) {
            break label117;
          }
          bool1 = true;
        }
        label111:
        label117:
        do
        {
          do
          {
            return bool1;
            n = 0;
            break;
            i1 = 0;
            break label89;
            bool1 = bool2;
          } while (n != i1);
          bool1 = bool2;
        } while (!paramArrayOfObject1[i].equals(paramArrayOfObject2[j]));
        j++;
        i++;
        break;
      }
    }
  }
  
  public static int hashCode(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0)) {}
    for (int i = 0;; i = Arrays.hashCode(paramArrayOfFloat)) {
      return i;
    }
  }
  
  public static int hashCode(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {}
    for (int i = 0;; i = Arrays.hashCode(paramArrayOfInt)) {
      return i;
    }
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {}
    for (int i = 0;; i = Arrays.hashCode(paramArrayOfLong)) {
      return i;
    }
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    int k = 0;
    if (paramArrayOfObject == null) {}
    for (int i = 0;; i = paramArrayOfObject.length)
    {
      int j = 0;
      while (j < i)
      {
        Object localObject = paramArrayOfObject[j];
        int m = k;
        if (localObject != null) {
          m = k * 31 + localObject.hashCode();
        }
        j++;
        k = m;
      }
    }
    return k;
  }
  
  public static void zza(zzaru paramzzaru1, zzaru paramzzaru2)
  {
    if (paramzzaru1.btG != null) {
      paramzzaru2.btG = ((zzarw)paramzzaru1.btG.clone());
    }
  }
  
  public static boolean zza(byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    boolean bool2 = false;
    int k;
    if (paramArrayOfByte1 == null)
    {
      k = 0;
      if (paramArrayOfByte2 != null) {
        break label46;
      }
    }
    int j;
    int i;
    label46:
    for (int m = 0;; m = paramArrayOfByte2.length)
    {
      j = 0;
      for (i = 0; (i < k) && (paramArrayOfByte1[i] == null); i++) {}
      k = paramArrayOfByte1.length;
      break;
    }
    for (;;)
    {
      if ((j < m) && (paramArrayOfByte2[j] == null))
      {
        j++;
      }
      else
      {
        int n;
        int i1;
        label89:
        boolean bool1;
        if (i >= k)
        {
          n = 1;
          if (j < m) {
            break label111;
          }
          i1 = 1;
          if ((n == 0) || (i1 == 0)) {
            break label117;
          }
          bool1 = true;
        }
        label111:
        label117:
        do
        {
          do
          {
            return bool1;
            n = 0;
            break;
            i1 = 0;
            break label89;
            bool1 = bool2;
          } while (n != i1);
          bool1 = bool2;
        } while (!Arrays.equals(paramArrayOfByte1[i], paramArrayOfByte2[j]));
        j++;
        i++;
        break;
      }
    }
  }
  
  public static int zzb(byte[][] paramArrayOfByte)
  {
    int m = 0;
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      int j = 0;
      while (j < i)
      {
        byte[] arrayOfByte = paramArrayOfByte[j];
        int k = m;
        if (arrayOfByte != null) {
          k = m * 31 + Arrays.hashCode(arrayOfByte);
        }
        j++;
        m = k;
      }
    }
    return m;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */