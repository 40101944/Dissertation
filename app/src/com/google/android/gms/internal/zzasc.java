package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzasc
{
  final byte[] btQ;
  final int tag;
  
  zzasc(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.btQ = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof zzasc))
      {
        bool = false;
      }
      else
      {
        paramObject = (zzasc)paramObject;
        if ((this.tag != ((zzasc)paramObject).tag) || (!Arrays.equals(this.btQ, ((zzasc)paramObject).btQ))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.btQ);
  }
  
  void zza(zzart paramzzart)
    throws IOException
  {
    paramzzart.zzahd(this.tag);
    paramzzart.zzbh(this.btQ);
  }
  
  int zzx()
  {
    return zzart.zzahe(this.tag) + 0 + this.btQ.length;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzasc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */