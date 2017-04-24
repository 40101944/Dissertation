package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

public class Flag
  extends AbstractSafeParcelable
  implements Comparable<Flag>
{
  public static final Parcelable.Creator<Flag> CREATOR = new zzb();
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final zza aAA = new zza();
  final String Fe;
  final long aAw;
  final byte[] aAx;
  public final int aAy;
  public final int aAz;
  final boolean ahI;
  final double ahK;
  final int mVersionCode;
  public final String name;
  
  Flag(int paramInt1, String paramString1, long paramLong, boolean paramBoolean, double paramDouble, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.name = paramString1;
    this.aAw = paramLong;
    this.ahI = paramBoolean;
    this.ahK = paramDouble;
    this.Fe = paramString2;
    this.aAx = paramArrayOfByte;
    this.aAy = paramInt2;
    this.aAz = paramInt3;
  }
  
  private static int compare(byte paramByte1, byte paramByte2)
  {
    return paramByte1 - paramByte2;
  }
  
  private static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      paramInt1 = -1;
    }
    for (;;)
    {
      return paramInt1;
      if (paramInt1 == paramInt2) {
        paramInt1 = 0;
      } else {
        paramInt1 = 1;
      }
    }
  }
  
  private static int compare(long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong1 < paramLong2) {
      i = -1;
    }
    for (;;)
    {
      return i;
      if (paramLong1 == paramLong2) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private static int compare(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 == paramString2) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (paramString1 == null) {
        i = -1;
      } else if (paramString2 == null) {
        i = 1;
      } else {
        i = paramString1.compareTo(paramString2);
      }
    }
  }
  
  private static int compare(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1 == paramBoolean2) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (paramBoolean1) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if ((paramObject != null) && ((paramObject instanceof Flag)))
    {
      paramObject = (Flag)paramObject;
      if ((this.mVersionCode != ((Flag)paramObject).mVersionCode) || (!zzz.equal(this.name, ((Flag)paramObject).name)) || (this.aAy != ((Flag)paramObject).aAy) || (this.aAz != ((Flag)paramObject).aAz)) {
        bool = false;
      }
    }
    for (;;)
    {
      return bool;
      switch (this.aAy)
      {
      default: 
        int i = this.aAy;
        throw new AssertionError(31 + "Invalid enum value: " + i);
      case 1: 
        if (this.aAw != ((Flag)paramObject).aAw) {
          bool = false;
        }
        break;
      case 2: 
        if (this.ahI != ((Flag)paramObject).ahI) {
          bool = false;
        }
        break;
      case 3: 
        if (this.ahK != ((Flag)paramObject).ahK) {
          bool = false;
        }
        break;
      case 4: 
        bool = zzz.equal(this.Fe, ((Flag)paramObject).Fe);
        break;
      case 5: 
        bool = Arrays.equals(this.aAx, ((Flag)paramObject).aAx);
        continue;
        bool = false;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    zza(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public int zza(Flag paramFlag)
  {
    int j = 0;
    int i = 0;
    int k = this.name.compareTo(paramFlag.name);
    if (k != 0) {
      i = k;
    }
    for (;;)
    {
      return i;
      k = compare(this.aAy, paramFlag.aAy);
      if (k != 0) {
        i = k;
      } else {
        switch (this.aAy)
        {
        default: 
          i = this.aAy;
          throw new AssertionError(31 + "Invalid enum value: " + i);
        case 1: 
          i = compare(this.aAw, paramFlag.aAw);
          break;
        case 2: 
          i = compare(this.ahI, paramFlag.ahI);
          break;
        case 3: 
          i = Double.compare(this.ahK, paramFlag.ahK);
          break;
        case 4: 
          i = compare(this.Fe, paramFlag.Fe);
          break;
        case 5: 
          if (this.aAx != paramFlag.aAx) {
            if (this.aAx == null)
            {
              i = -1;
            }
            else
            {
              i = j;
              if (paramFlag.aAx == null)
              {
                i = 1;
              }
              else
              {
                do
                {
                  i++;
                  if (i >= Math.min(this.aAx.length, paramFlag.aAx.length)) {
                    break;
                  }
                  j = compare(this.aAx[i], paramFlag.aAx[i]);
                } while (j == 0);
                i = j;
                continue;
                i = compare(this.aAx.length, paramFlag.aAx.length);
              }
            }
          }
          break;
        }
      }
    }
  }
  
  public String zza(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("Flag(");
    paramStringBuilder.append(this.mVersionCode);
    paramStringBuilder.append(", ");
    paramStringBuilder.append(this.name);
    paramStringBuilder.append(", ");
    switch (this.aAy)
    {
    default: 
      paramStringBuilder = this.name;
      int i = this.aAy;
      throw new AssertionError(String.valueOf(paramStringBuilder).length() + 27 + "Invalid type: " + paramStringBuilder + ", " + i);
    case 1: 
      paramStringBuilder.append(this.aAw);
    }
    for (;;)
    {
      paramStringBuilder.append(", ");
      paramStringBuilder.append(this.aAy);
      paramStringBuilder.append(", ");
      paramStringBuilder.append(this.aAz);
      paramStringBuilder.append(")");
      return paramStringBuilder.toString();
      paramStringBuilder.append(this.ahI);
      continue;
      paramStringBuilder.append(this.ahK);
      continue;
      paramStringBuilder.append("'");
      paramStringBuilder.append(this.Fe);
      paramStringBuilder.append("'");
      continue;
      if (this.aAx == null)
      {
        paramStringBuilder.append("null");
      }
      else
      {
        paramStringBuilder.append("'");
        paramStringBuilder.append(new String(this.aAx, UTF_8));
        paramStringBuilder.append("'");
      }
    }
  }
  
  public static class zza
    implements Comparator<Flag>
  {
    public int zza(Flag paramFlag1, Flag paramFlag2)
    {
      if (paramFlag1.aAz == paramFlag2.aAz) {}
      for (int i = paramFlag1.name.compareTo(paramFlag2.name);; i = paramFlag1.aAz - paramFlag2.aAz) {
        return i;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\phenotype\Flag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */