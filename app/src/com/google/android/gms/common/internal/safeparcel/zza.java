package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class zza
{
  public static int zza(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536) {}
    for (paramInt = paramInt >> 16 & 0xFFFF;; paramInt = paramParcel.readInt()) {
      return paramInt;
    }
  }
  
  public static <T extends Parcelable> T zza(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    for (paramParcel = null;; paramParcel = paramCreator)
    {
      return paramParcel;
      paramCreator = (Parcelable)paramCreator.createFromParcel(paramParcel);
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    paramInt1 = zza(paramParcel, paramInt1);
    if (paramInt1 != paramInt2)
    {
      String str = String.valueOf(Integer.toHexString(paramInt1));
      throw new zza(String.valueOf(str).length() + 46 + "Expected size " + paramInt2 + " got " + paramInt1 + " (0x" + str + ")", paramParcel);
    }
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != paramInt3)
    {
      String str = String.valueOf(Integer.toHexString(paramInt2));
      throw new zza(String.valueOf(str).length() + 46 + "Expected size " + paramInt3 + " got " + paramInt2 + " (0x" + str + ")", paramParcel);
    }
  }
  
  public static void zza(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      paramParcel.readList(paramList, paramClassLoader);
      paramParcel.setDataPosition(paramInt + i);
    }
  }
  
  public static double[] zzaa(Parcel paramParcel, int paramInt)
  {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {}
    double[] arrayOfDouble;
    for (paramParcel = null;; paramParcel = arrayOfDouble)
    {
      return paramParcel;
      arrayOfDouble = paramParcel.createDoubleArray();
      paramParcel.setDataPosition(paramInt + i);
    }
  }
  
  public static BigDecimal[] zzab(Parcel paramParcel, int paramInt)
  {
    int k = zza(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (k == 0) {}
    BigDecimal[] arrayOfBigDecimal;
    for (paramParcel = null;; paramParcel = arrayOfBigDecimal)
    {
      return paramParcel;
      int i = paramParcel.readInt();
      arrayOfBigDecimal = new BigDecimal[i];
      for (paramInt = 0; paramInt < i; paramInt++)
      {
        byte[] arrayOfByte = paramParcel.createByteArray();
        int m = paramParcel.readInt();
        arrayOfBigDecimal[paramInt] = new BigDecimal(new BigInteger(arrayOfByte), m);
      }
      paramParcel.setDataPosition(j + k);
    }
  }
  
  public static String[] zzac(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    String[] arrayOfString;
    for (paramParcel = null;; paramParcel = arrayOfString)
    {
      return paramParcel;
      arrayOfString = paramParcel.createStringArray();
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static ArrayList<Integer> zzad(Parcel paramParcel, int paramInt)
  {
    int j = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (j == 0) {}
    ArrayList localArrayList;
    for (paramParcel = null;; paramParcel = localArrayList)
    {
      return paramParcel;
      localArrayList = new ArrayList();
      int k = paramParcel.readInt();
      for (paramInt = 0; paramInt < k; paramInt++) {
        localArrayList.add(Integer.valueOf(paramParcel.readInt()));
      }
      paramParcel.setDataPosition(i + j);
    }
  }
  
  public static ArrayList<String> zzae(Parcel paramParcel, int paramInt)
  {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {}
    ArrayList localArrayList;
    for (paramParcel = null;; paramParcel = localArrayList)
    {
      return paramParcel;
      localArrayList = paramParcel.createStringArrayList();
      paramParcel.setDataPosition(paramInt + i);
    }
  }
  
  public static Parcel zzaf(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    Parcel localParcel;
    for (paramParcel = null;; paramParcel = localParcel)
    {
      return paramParcel;
      localParcel = Parcel.obtain();
      localParcel.appendFrom(paramParcel, paramInt, i);
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static Parcel[] zzag(Parcel paramParcel, int paramInt)
  {
    Parcel[] arrayOfParcel = null;
    int i = zza(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {}
    for (paramParcel = arrayOfParcel;; paramParcel = arrayOfParcel)
    {
      return paramParcel;
      int k = paramParcel.readInt();
      arrayOfParcel = new Parcel[k];
      paramInt = 0;
      if (paramInt < k)
      {
        int m = paramParcel.readInt();
        if (m != 0)
        {
          int n = paramParcel.dataPosition();
          Parcel localParcel = Parcel.obtain();
          localParcel.appendFrom(paramParcel, n, m);
          arrayOfParcel[paramInt] = localParcel;
          paramParcel.setDataPosition(m + n);
        }
        for (;;)
        {
          paramInt++;
          break;
          arrayOfParcel[paramInt] = null;
        }
      }
      paramParcel.setDataPosition(j + i);
    }
  }
  
  public static void zzb(Parcel paramParcel, int paramInt)
  {
    paramParcel.setDataPosition(zza(paramParcel, paramInt) + paramParcel.dataPosition());
  }
  
  public static <T> T[] zzb(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    for (paramParcel = null;; paramParcel = paramCreator)
    {
      return paramParcel;
      paramCreator = paramParcel.createTypedArray(paramCreator);
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static <T> ArrayList<T> zzc(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    for (paramParcel = null;; paramParcel = paramCreator)
    {
      return paramParcel;
      paramCreator = paramParcel.createTypedArrayList(paramCreator);
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static boolean zzc(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int zzcq(Parcel paramParcel)
  {
    return paramParcel.readInt();
  }
  
  public static int zzcr(Parcel paramParcel)
  {
    int j = zzcq(paramParcel);
    int k = zza(paramParcel, j);
    int i = paramParcel.dataPosition();
    if (zzgu(j) != 20293)
    {
      String str = String.valueOf(Integer.toHexString(j));
      if (str.length() != 0) {}
      for (str = "Expected object header. Got 0x".concat(str);; str = new String("Expected object header. Got 0x")) {
        throw new zza(str, paramParcel);
      }
    }
    j = i + k;
    if ((j < i) || (j > paramParcel.dataSize())) {
      throw new zza(54 + "Size read is invalid start=" + i + " end=" + j, paramParcel);
    }
    return j;
  }
  
  public static Boolean zzd(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    if (i == 0)
    {
      paramParcel = null;
      return paramParcel;
    }
    zza(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramParcel = Boolean.valueOf(bool);
      break;
    }
  }
  
  public static byte zze(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }
  
  public static short zzf(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }
  
  public static int zzg(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static int zzgu(int paramInt)
  {
    return 0xFFFF & paramInt;
  }
  
  public static Integer zzh(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    if (i == 0) {}
    for (paramParcel = null;; paramParcel = Integer.valueOf(paramParcel.readInt()))
    {
      return paramParcel;
      zza(paramParcel, paramInt, i, 4);
    }
  }
  
  public static long zzi(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static Long zzj(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    if (i == 0) {}
    for (paramParcel = null;; paramParcel = Long.valueOf(paramParcel.readLong()))
    {
      return paramParcel;
      zza(paramParcel, paramInt, i, 8);
    }
  }
  
  public static BigInteger zzk(Parcel paramParcel, int paramInt)
  {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {}
    byte[] arrayOfByte;
    for (paramParcel = null;; paramParcel = new BigInteger(arrayOfByte))
    {
      return paramParcel;
      arrayOfByte = paramParcel.createByteArray();
      paramParcel.setDataPosition(paramInt + i);
    }
  }
  
  public static float zzl(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }
  
  public static Float zzm(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    if (i == 0) {}
    for (paramParcel = null;; paramParcel = Float.valueOf(paramParcel.readFloat()))
    {
      return paramParcel;
      zza(paramParcel, paramInt, i, 4);
    }
  }
  
  public static double zzn(Parcel paramParcel, int paramInt)
  {
    zza(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }
  
  public static Double zzo(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    if (i == 0) {}
    for (paramParcel = null;; paramParcel = Double.valueOf(paramParcel.readDouble()))
    {
      return paramParcel;
      zza(paramParcel, paramInt, i, 8);
    }
  }
  
  public static BigDecimal zzp(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    byte[] arrayOfByte;
    int j;
    for (paramParcel = null;; paramParcel = new BigDecimal(new BigInteger(arrayOfByte), j))
    {
      return paramParcel;
      arrayOfByte = paramParcel.createByteArray();
      j = paramParcel.readInt();
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static String zzq(Parcel paramParcel, int paramInt)
  {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {}
    String str;
    for (paramParcel = null;; paramParcel = str)
    {
      return paramParcel;
      str = paramParcel.readString();
      paramParcel.setDataPosition(paramInt + i);
    }
  }
  
  public static IBinder zzr(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    IBinder localIBinder;
    for (paramParcel = null;; paramParcel = localIBinder)
    {
      return paramParcel;
      localIBinder = paramParcel.readStrongBinder();
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static Bundle zzs(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    Bundle localBundle;
    for (paramParcel = null;; paramParcel = localBundle)
    {
      return paramParcel;
      localBundle = paramParcel.readBundle();
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static byte[] zzt(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    byte[] arrayOfByte;
    for (paramParcel = null;; paramParcel = arrayOfByte)
    {
      return paramParcel;
      arrayOfByte = paramParcel.createByteArray();
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static byte[][] zzu(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    int k = paramParcel.dataPosition();
    if (i == 0) {}
    byte[][] arrayOfByte;
    for (paramParcel = null;; paramParcel = arrayOfByte)
    {
      return paramParcel;
      int j = paramParcel.readInt();
      arrayOfByte = new byte[j][];
      for (paramInt = 0; paramInt < j; paramInt++) {
        arrayOfByte[paramInt] = paramParcel.createByteArray();
      }
      paramParcel.setDataPosition(k + i);
    }
  }
  
  public static boolean[] zzv(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    boolean[] arrayOfBoolean;
    for (paramParcel = null;; paramParcel = arrayOfBoolean)
    {
      return paramParcel;
      arrayOfBoolean = paramParcel.createBooleanArray();
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static int[] zzw(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    int[] arrayOfInt;
    for (paramParcel = null;; paramParcel = arrayOfInt)
    {
      return paramParcel;
      arrayOfInt = paramParcel.createIntArray();
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static long[] zzx(Parcel paramParcel, int paramInt)
  {
    int i = zza(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    if (i == 0) {}
    long[] arrayOfLong;
    for (paramParcel = null;; paramParcel = arrayOfLong)
    {
      return paramParcel;
      arrayOfLong = paramParcel.createLongArray();
      paramParcel.setDataPosition(i + paramInt);
    }
  }
  
  public static BigInteger[] zzy(Parcel paramParcel, int paramInt)
  {
    int j = zza(paramParcel, paramInt);
    int k = paramParcel.dataPosition();
    if (j == 0) {}
    BigInteger[] arrayOfBigInteger;
    for (paramParcel = null;; paramParcel = arrayOfBigInteger)
    {
      return paramParcel;
      int i = paramParcel.readInt();
      arrayOfBigInteger = new BigInteger[i];
      for (paramInt = 0; paramInt < i; paramInt++) {
        arrayOfBigInteger[paramInt] = new BigInteger(paramParcel.createByteArray());
      }
      paramParcel.setDataPosition(k + j);
    }
  }
  
  public static float[] zzz(Parcel paramParcel, int paramInt)
  {
    paramInt = zza(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {}
    float[] arrayOfFloat;
    for (paramParcel = null;; paramParcel = arrayOfFloat)
    {
      return paramParcel;
      arrayOfFloat = paramParcel.createFloatArray();
      paramParcel.setDataPosition(paramInt + i);
    }
  }
  
  public static class zza
    extends RuntimeException
  {
    public zza(String paramString, Parcel paramParcel)
    {
      super();
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\safeparcel\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */