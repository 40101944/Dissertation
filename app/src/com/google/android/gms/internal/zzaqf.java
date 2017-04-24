package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class zzaqf
  extends zzaqp
{
  private static final Reader bpL = new Reader()
  {
    public void close()
      throws IOException
    {
      throw new AssertionError();
    }
    
    public int read(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
      throws IOException
    {
      throw new AssertionError();
    }
  };
  private static final Object bpM = new Object();
  private final List<Object> bpN = new ArrayList();
  
  public zzaqf(zzaoy paramzzaoy)
  {
    super(bpL);
    this.bpN.add(paramzzaoy);
  }
  
  private Object br()
  {
    return this.bpN.get(this.bpN.size() - 1);
  }
  
  private Object bs()
  {
    return this.bpN.remove(this.bpN.size() - 1);
  }
  
  private void zza(zzaqq paramzzaqq)
    throws IOException
  {
    if (bq() != paramzzaqq)
    {
      String str = String.valueOf(paramzzaqq);
      paramzzaqq = String.valueOf(bq());
      throw new IllegalStateException(String.valueOf(str).length() + 18 + String.valueOf(paramzzaqq).length() + "Expected " + str + " but was " + paramzzaqq);
    }
  }
  
  public void beginArray()
    throws IOException
  {
    zza(zzaqq.brB);
    zzaov localzzaov = (zzaov)br();
    this.bpN.add(localzzaov.iterator());
  }
  
  public void beginObject()
    throws IOException
  {
    zza(zzaqq.brD);
    zzapb localzzapb = (zzapb)br();
    this.bpN.add(localzzapb.entrySet().iterator());
  }
  
  public zzaqq bq()
    throws IOException
  {
    Object localObject;
    if (this.bpN.isEmpty()) {
      localObject = zzaqq.brK;
    }
    for (;;)
    {
      return (zzaqq)localObject;
      localObject = br();
      if ((localObject instanceof Iterator))
      {
        boolean bool = this.bpN.get(this.bpN.size() - 2) instanceof zzapb;
        localObject = (Iterator)localObject;
        if (((Iterator)localObject).hasNext())
        {
          if (bool)
          {
            localObject = zzaqq.brF;
          }
          else
          {
            this.bpN.add(((Iterator)localObject).next());
            localObject = bq();
          }
        }
        else if (bool) {
          localObject = zzaqq.brE;
        } else {
          localObject = zzaqq.brC;
        }
      }
      else if ((localObject instanceof zzapb))
      {
        localObject = zzaqq.brD;
      }
      else if ((localObject instanceof zzaov))
      {
        localObject = zzaqq.brB;
      }
      else if ((localObject instanceof zzape))
      {
        localObject = (zzape)localObject;
        if (((zzape)localObject).bf()) {
          localObject = zzaqq.brG;
        } else if (((zzape)localObject).bd()) {
          localObject = zzaqq.brI;
        } else if (((zzape)localObject).be()) {
          localObject = zzaqq.brH;
        } else {
          throw new AssertionError();
        }
      }
      else
      {
        if (!(localObject instanceof zzapa)) {
          break;
        }
        localObject = zzaqq.brJ;
      }
    }
    if (localObject == bpM) {
      throw new IllegalStateException("JsonReader is closed");
    }
    throw new AssertionError();
  }
  
  public void bt()
    throws IOException
  {
    zza(zzaqq.brF);
    Map.Entry localEntry = (Map.Entry)((Iterator)br()).next();
    this.bpN.add(localEntry.getValue());
    this.bpN.add(new zzape((String)localEntry.getKey()));
  }
  
  public void close()
    throws IOException
  {
    this.bpN.clear();
    this.bpN.add(bpM);
  }
  
  public void endArray()
    throws IOException
  {
    zza(zzaqq.brC);
    bs();
    bs();
  }
  
  public void endObject()
    throws IOException
  {
    zza(zzaqq.brE);
    bs();
    bs();
  }
  
  public boolean hasNext()
    throws IOException
  {
    zzaqq localzzaqq = bq();
    if ((localzzaqq != zzaqq.brE) && (localzzaqq != zzaqq.brC)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean nextBoolean()
    throws IOException
  {
    zza(zzaqq.brI);
    return ((zzape)bs()).getAsBoolean();
  }
  
  public double nextDouble()
    throws IOException
  {
    Object localObject = bq();
    if ((localObject != zzaqq.brH) && (localObject != zzaqq.brG))
    {
      String str = String.valueOf(zzaqq.brH);
      localObject = String.valueOf(localObject);
      throw new IllegalStateException(String.valueOf(str).length() + 18 + String.valueOf(localObject).length() + "Expected " + str + " but was " + (String)localObject);
    }
    double d = ((zzape)br()).getAsDouble();
    if ((!isLenient()) && ((Double.isNaN(d)) || (Double.isInfinite(d)))) {
      throw new NumberFormatException(57 + "JSON forbids NaN and infinities: " + d);
    }
    bs();
    return d;
  }
  
  public int nextInt()
    throws IOException
  {
    Object localObject = bq();
    if ((localObject != zzaqq.brH) && (localObject != zzaqq.brG))
    {
      String str = String.valueOf(zzaqq.brH);
      localObject = String.valueOf(localObject);
      throw new IllegalStateException(String.valueOf(str).length() + 18 + String.valueOf(localObject).length() + "Expected " + str + " but was " + (String)localObject);
    }
    int i = ((zzape)br()).getAsInt();
    bs();
    return i;
  }
  
  public long nextLong()
    throws IOException
  {
    Object localObject = bq();
    if ((localObject != zzaqq.brH) && (localObject != zzaqq.brG))
    {
      String str = String.valueOf(zzaqq.brH);
      localObject = String.valueOf(localObject);
      throw new IllegalStateException(String.valueOf(str).length() + 18 + String.valueOf(localObject).length() + "Expected " + str + " but was " + (String)localObject);
    }
    long l = ((zzape)br()).getAsLong();
    bs();
    return l;
  }
  
  public String nextName()
    throws IOException
  {
    zza(zzaqq.brF);
    Map.Entry localEntry = (Map.Entry)((Iterator)br()).next();
    this.bpN.add(localEntry.getValue());
    return (String)localEntry.getKey();
  }
  
  public void nextNull()
    throws IOException
  {
    zza(zzaqq.brJ);
    bs();
  }
  
  public String nextString()
    throws IOException
  {
    Object localObject = bq();
    if ((localObject != zzaqq.brG) && (localObject != zzaqq.brH))
    {
      String str = String.valueOf(zzaqq.brG);
      localObject = String.valueOf(localObject);
      throw new IllegalStateException(String.valueOf(str).length() + 18 + String.valueOf(localObject).length() + "Expected " + str + " but was " + (String)localObject);
    }
    return ((zzape)bs()).aU();
  }
  
  public void skipValue()
    throws IOException
  {
    if (bq() == zzaqq.brF) {
      nextName();
    }
    for (;;)
    {
      return;
      bs();
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */