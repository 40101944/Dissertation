package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzarx
  implements Cloneable
{
  private zzarv<?, ?> btM;
  private List<zzasc> btN = new ArrayList();
  private Object value;
  
  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzx()];
    zza(zzart.zzbe(arrayOfByte));
    return arrayOfByte;
  }
  
  public final zzarx cq()
  {
    zzarx localzzarx = new zzarx();
    for (;;)
    {
      try
      {
        localzzarx.btM = this.btM;
        if (this.btN == null)
        {
          localzzarx.btN = null;
          if (this.value == null) {
            return localzzarx;
          }
        }
        else
        {
          localzzarx.btN.addAll(this.btN);
          continue;
        }
        if (!(this.value instanceof zzasa)) {
          break label94;
        }
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
      localCloneNotSupportedException.value = ((zzasa)((zzasa)this.value).clone());
      continue;
      label94:
      if ((this.value instanceof byte[]))
      {
        localCloneNotSupportedException.value = ((byte[])this.value).clone();
      }
      else
      {
        Object localObject2;
        Object localObject1;
        int i;
        if ((this.value instanceof byte[][]))
        {
          localObject2 = (byte[][])this.value;
          localObject1 = new byte[localObject2.length][];
          localCloneNotSupportedException.value = localObject1;
          for (i = 0; i < localObject2.length; i++) {
            localObject1[i] = ((byte[])localObject2[i].clone());
          }
        }
        else if ((this.value instanceof boolean[]))
        {
          localCloneNotSupportedException.value = ((boolean[])this.value).clone();
        }
        else if ((this.value instanceof int[]))
        {
          localCloneNotSupportedException.value = ((int[])this.value).clone();
        }
        else if ((this.value instanceof long[]))
        {
          localCloneNotSupportedException.value = ((long[])this.value).clone();
        }
        else if ((this.value instanceof float[]))
        {
          localCloneNotSupportedException.value = ((float[])this.value).clone();
        }
        else if ((this.value instanceof double[]))
        {
          localCloneNotSupportedException.value = ((double[])this.value).clone();
        }
        else if ((this.value instanceof zzasa[]))
        {
          localObject1 = (zzasa[])this.value;
          localObject2 = new zzasa[localObject1.length];
          localCloneNotSupportedException.value = localObject2;
          for (i = 0; i < localObject1.length; i++) {
            localObject2[i] = ((zzasa)localObject1[i].clone());
          }
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (!(paramObject instanceof zzarx)) {
        continue;
      }
      paramObject = (zzarx)paramObject;
      if ((this.value != null) && (((zzarx)paramObject).value != null))
      {
        bool1 = bool2;
        if (this.btM != ((zzarx)paramObject).btM) {
          continue;
        }
        if (!this.btM.bkp.isArray())
        {
          bool1 = this.value.equals(((zzarx)paramObject).value);
          continue;
        }
        if ((this.value instanceof byte[]))
        {
          bool1 = Arrays.equals((byte[])this.value, (byte[])((zzarx)paramObject).value);
          continue;
        }
        if ((this.value instanceof int[]))
        {
          bool1 = Arrays.equals((int[])this.value, (int[])((zzarx)paramObject).value);
          continue;
        }
        if ((this.value instanceof long[]))
        {
          bool1 = Arrays.equals((long[])this.value, (long[])((zzarx)paramObject).value);
          continue;
        }
        if ((this.value instanceof float[]))
        {
          bool1 = Arrays.equals((float[])this.value, (float[])((zzarx)paramObject).value);
          continue;
        }
        if ((this.value instanceof double[]))
        {
          bool1 = Arrays.equals((double[])this.value, (double[])((zzarx)paramObject).value);
          continue;
        }
        if ((this.value instanceof boolean[]))
        {
          bool1 = Arrays.equals((boolean[])this.value, (boolean[])((zzarx)paramObject).value);
          continue;
        }
        bool1 = Arrays.deepEquals((Object[])this.value, (Object[])((zzarx)paramObject).value);
        continue;
      }
      if ((this.btN != null) && (((zzarx)paramObject).btN != null))
      {
        bool1 = this.btN.equals(((zzarx)paramObject).btN);
        continue;
      }
      try
      {
        bool1 = Arrays.equals(toByteArray(), ((zzarx)paramObject).toByteArray());
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  void zza(zzart paramzzart)
    throws IOException
  {
    if (this.value != null) {
      this.btM.zza(this.value, paramzzart);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.btN.iterator();
      while (localIterator.hasNext()) {
        ((zzasc)localIterator.next()).zza(paramzzart);
      }
    }
  }
  
  void zza(zzasc paramzzasc)
  {
    this.btN.add(paramzzasc);
  }
  
  <T> T zzb(zzarv<?, T> paramzzarv)
  {
    if (this.value != null)
    {
      if (!this.btM.equals(paramzzarv)) {
        throw new IllegalStateException("Tried to getExtension with a different Extension.");
      }
    }
    else
    {
      this.btM = paramzzarv;
      this.value = paramzzarv.zzay(this.btN);
      this.btN = null;
    }
    return (T)this.value;
  }
  
  int zzx()
  {
    int j;
    if (this.value != null)
    {
      j = this.btM.zzct(this.value);
      return j;
    }
    Iterator localIterator = this.btN.iterator();
    for (int i = 0;; i = ((zzasc)localIterator.next()).zzx() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzarx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */