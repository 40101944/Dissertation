package com.google.android.gms.internal;

import java.util.Map;

public class zzi
{
  public final byte[] data;
  public final int statusCode;
  public final boolean zzaa;
  public final long zzab;
  public final Map<String, String> zzz;
  
  public zzi(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    this.statusCode = paramInt;
    this.data = paramArrayOfByte;
    this.zzz = paramMap;
    this.zzaa = paramBoolean;
    this.zzab = paramLong;
  }
  
  public zzi(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */