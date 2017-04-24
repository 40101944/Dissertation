package com.google.android.gms.internal;

public final class zzarw
  implements Cloneable
{
  private static final zzarx btI = new zzarx();
  private boolean btJ = false;
  private int[] btK;
  private zzarx[] btL;
  private int mSize;
  
  zzarw()
  {
    this(10);
  }
  
  zzarw(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    this.btK = new int[paramInt];
    this.btL = new zzarx[paramInt];
    this.mSize = 0;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    for (int j = 4;; j++)
    {
      int i = paramInt;
      if (j < 32)
      {
        if (paramInt <= (1 << j) - 12) {
          i = (1 << j) - 12;
        }
      }
      else {
        return i;
      }
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  private boolean zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    boolean bool = false;
    int i = 0;
    if (i < paramInt) {
      if (paramArrayOfInt1[i] == paramArrayOfInt2[i]) {}
    }
    for (;;)
    {
      return bool;
      i++;
      break;
      bool = true;
    }
  }
  
  private boolean zza(zzarx[] paramArrayOfzzarx1, zzarx[] paramArrayOfzzarx2, int paramInt)
  {
    boolean bool = false;
    int i = 0;
    if (i < paramInt) {
      if (paramArrayOfzzarx1[i].equals(paramArrayOfzzarx2[i])) {}
    }
    for (;;)
    {
      return bool;
      i++;
      break;
      bool = true;
    }
  }
  
  private int zzahj(int paramInt)
  {
    int i = 0;
    int j = this.mSize - 1;
    int k;
    for (;;)
    {
      if (i > j) {
        break label63;
      }
      k = i + j >>> 1;
      int m = this.btK[k];
      if (m < paramInt)
      {
        i = k + 1;
      }
      else
      {
        if (m <= paramInt) {
          break;
        }
        j = k - 1;
      }
    }
    label63:
    for (paramInt = k;; paramInt = i ^ 0xFFFFFFFF) {
      return paramInt;
    }
  }
  
  public final zzarw cp()
  {
    int j = size();
    zzarw localzzarw = new zzarw(j);
    System.arraycopy(this.btK, 0, localzzarw.btK, 0, j);
    for (int i = 0; i < j; i++) {
      if (this.btL[i] != null) {
        localzzarw.btL[i] = ((zzarx)this.btL[i].clone());
      }
    }
    localzzarw.mSize = j;
    return localzzarw;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof zzarw))
      {
        bool = false;
      }
      else
      {
        paramObject = (zzarw)paramObject;
        if (size() != ((zzarw)paramObject).size()) {
          bool = false;
        } else if ((!zza(this.btK, ((zzarw)paramObject).btK, this.mSize)) || (!zza(this.btL, ((zzarw)paramObject).btL, this.mSize))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    int j = 17;
    for (int i = 0; i < this.mSize; i++) {
      j = (j * 31 + this.btK[i]) * 31 + this.btL[i].hashCode();
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    if (size() == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  int size()
  {
    return this.mSize;
  }
  
  void zza(int paramInt, zzarx paramzzarx)
  {
    int i = zzahj(paramInt);
    if (i >= 0) {
      this.btL[i] = paramzzarx;
    }
    for (;;)
    {
      return;
      int j = i ^ 0xFFFFFFFF;
      if ((j < this.mSize) && (this.btL[j] == btI))
      {
        this.btK[j] = paramInt;
        this.btL[j] = paramzzarx;
      }
      else
      {
        if (this.mSize >= this.btK.length)
        {
          i = idealIntArraySize(this.mSize + 1);
          int[] arrayOfInt = new int[i];
          zzarx[] arrayOfzzarx = new zzarx[i];
          System.arraycopy(this.btK, 0, arrayOfInt, 0, this.btK.length);
          System.arraycopy(this.btL, 0, arrayOfzzarx, 0, this.btL.length);
          this.btK = arrayOfInt;
          this.btL = arrayOfzzarx;
        }
        if (this.mSize - j != 0)
        {
          System.arraycopy(this.btK, j, this.btK, j + 1, this.mSize - j);
          System.arraycopy(this.btL, j, this.btL, j + 1, this.mSize - j);
        }
        this.btK[j] = paramInt;
        this.btL[j] = paramzzarx;
        this.mSize += 1;
      }
    }
  }
  
  zzarx zzahh(int paramInt)
  {
    paramInt = zzahj(paramInt);
    if ((paramInt < 0) || (this.btL[paramInt] == btI)) {}
    for (zzarx localzzarx = null;; localzzarx = this.btL[paramInt]) {
      return localzzarx;
    }
  }
  
  zzarx zzahi(int paramInt)
  {
    return this.btL[paramInt];
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzarw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */