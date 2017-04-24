package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzaos
{
  private final ThreadLocal<Map<zzaqo<?>, zza<?>>> boa = new ThreadLocal();
  private final Map<zzaqo<?>, zzapk<?>> bob = Collections.synchronizedMap(new HashMap());
  private final List<zzapl> boc;
  private final zzaps bod;
  private final boolean boe;
  private final boolean bof;
  private final boolean bog;
  private final boolean boh;
  final zzaow boi = new zzaow() {};
  final zzapf boj = new zzapf() {};
  
  public zzaos()
  {
    this(zzapt.boW, zzaoq.bnU, Collections.emptyMap(), false, false, false, true, false, false, zzapi.box, Collections.emptyList());
  }
  
  zzaos(zzapt paramzzapt, zzaor paramzzaor, Map<Type, zzaou<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, zzapi paramzzapi, List<zzapl> paramList)
  {
    this.bod = new zzaps(paramMap);
    this.boe = paramBoolean1;
    this.bog = paramBoolean3;
    this.bof = paramBoolean4;
    this.boh = paramBoolean5;
    paramMap = new ArrayList();
    paramMap.add(zzaqn.bqZ);
    paramMap.add(zzaqi.bpG);
    paramMap.add(paramzzapt);
    paramMap.addAll(paramList);
    paramMap.add(zzaqn.bqG);
    paramMap.add(zzaqn.bqv);
    paramMap.add(zzaqn.bqp);
    paramMap.add(zzaqn.bqr);
    paramMap.add(zzaqn.bqt);
    paramMap.add(zzaqn.zza(Long.TYPE, Long.class, zza(paramzzapi)));
    paramMap.add(zzaqn.zza(Double.TYPE, Double.class, zzdf(paramBoolean6)));
    paramMap.add(zzaqn.zza(Float.TYPE, Float.class, zzdg(paramBoolean6)));
    paramMap.add(zzaqn.bqA);
    paramMap.add(zzaqn.bqC);
    paramMap.add(zzaqn.bqI);
    paramMap.add(zzaqn.bqK);
    paramMap.add(zzaqn.zza(BigDecimal.class, zzaqn.bqE));
    paramMap.add(zzaqn.zza(BigInteger.class, zzaqn.bqF));
    paramMap.add(zzaqn.bqM);
    paramMap.add(zzaqn.bqO);
    paramMap.add(zzaqn.bqS);
    paramMap.add(zzaqn.bqX);
    paramMap.add(zzaqn.bqQ);
    paramMap.add(zzaqn.bqm);
    paramMap.add(zzaqd.bpG);
    paramMap.add(zzaqn.bqV);
    paramMap.add(zzaql.bpG);
    paramMap.add(zzaqk.bpG);
    paramMap.add(zzaqn.bqT);
    paramMap.add(zzaqb.bpG);
    paramMap.add(zzaqn.bqk);
    paramMap.add(new zzaqc(this.bod));
    paramMap.add(new zzaqh(this.bod, paramBoolean2));
    paramMap.add(new zzaqe(this.bod));
    paramMap.add(zzaqn.bra);
    paramMap.add(new zzaqj(this.bod, paramzzaor, paramzzapt));
    this.boc = Collections.unmodifiableList(paramMap);
  }
  
  private zzapk<Number> zza(zzapi paramzzapi)
  {
    if (paramzzapi == zzapi.box) {}
    for (paramzzapi = zzaqn.bqw;; paramzzapi = new zzapk()
        {
          public void zza(zzaqr paramAnonymouszzaqr, Number paramAnonymousNumber)
            throws IOException
          {
            if (paramAnonymousNumber == null) {
              paramAnonymouszzaqr.bA();
            }
            for (;;)
            {
              return;
              paramAnonymouszzaqr.zzut(paramAnonymousNumber.toString());
            }
          }
          
          public Number zzg(zzaqp paramAnonymouszzaqp)
            throws IOException
          {
            if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
              paramAnonymouszzaqp.nextNull();
            }
            for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = Long.valueOf(paramAnonymouszzaqp.nextLong())) {
              return paramAnonymouszzaqp;
            }
          }
        }) {
      return paramzzapi;
    }
  }
  
  private static void zza(Object paramObject, zzaqp paramzzaqp)
  {
    if (paramObject != null) {
      try
      {
        if (paramzzaqp.bq() != zzaqq.brK)
        {
          paramObject = new com/google/android/gms/internal/zzaoz;
          ((zzaoz)paramObject).<init>("JSON document was not fully consumed.");
          throw ((Throwable)paramObject);
        }
      }
      catch (zzaqs paramObject)
      {
        throw new zzaph((Throwable)paramObject);
      }
      catch (IOException paramObject)
      {
        throw new zzaoz((Throwable)paramObject);
      }
    }
  }
  
  private zzapk<Number> zzdf(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = zzaqn.bqy;; localObject = new zzapk()
        {
          public void zza(zzaqr paramAnonymouszzaqr, Number paramAnonymousNumber)
            throws IOException
          {
            if (paramAnonymousNumber == null) {
              paramAnonymouszzaqr.bA();
            }
            for (;;)
            {
              return;
              double d = paramAnonymousNumber.doubleValue();
              zzaos.zza(zzaos.this, d);
              paramAnonymouszzaqr.zza(paramAnonymousNumber);
            }
          }
          
          public Double zze(zzaqp paramAnonymouszzaqp)
            throws IOException
          {
            if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
              paramAnonymouszzaqp.nextNull();
            }
            for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = Double.valueOf(paramAnonymouszzaqp.nextDouble())) {
              return paramAnonymouszzaqp;
            }
          }
        }) {
      return (zzapk<Number>)localObject;
    }
  }
  
  private zzapk<Number> zzdg(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = zzaqn.bqx;; localObject = new zzapk()
        {
          public void zza(zzaqr paramAnonymouszzaqr, Number paramAnonymousNumber)
            throws IOException
          {
            if (paramAnonymousNumber == null) {
              paramAnonymouszzaqr.bA();
            }
            for (;;)
            {
              return;
              float f = paramAnonymousNumber.floatValue();
              zzaos.zza(zzaos.this, f);
              paramAnonymouszzaqr.zza(paramAnonymousNumber);
            }
          }
          
          public Float zzf(zzaqp paramAnonymouszzaqp)
            throws IOException
          {
            if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
              paramAnonymouszzaqp.nextNull();
            }
            for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = Float.valueOf((float)paramAnonymouszzaqp.nextDouble())) {
              return paramAnonymouszzaqp;
            }
          }
        }) {
      return (zzapk<Number>)localObject;
    }
  }
  
  private void zzm(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      throw new IllegalArgumentException(168 + paramDouble + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }
  }
  
  public String toString()
  {
    return "{serializeNulls:" + this.boe + "factories:" + this.boc + ",instanceCreators:" + this.bod + "}";
  }
  
  public <T> zzapk<T> zza(zzapl paramzzapl, zzaqo<T> paramzzaqo)
  {
    int i = 0;
    if (!this.boc.contains(paramzzapl)) {
      i = 1;
    }
    Iterator localIterator = this.boc.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (zzapl)localIterator.next();
      if (i == 0)
      {
        if (localObject == paramzzapl) {
          i = 1;
        }
      }
      else
      {
        localObject = ((zzapl)localObject).zza(this, paramzzaqo);
        if (localObject != null) {
          return (zzapk<T>)localObject;
        }
      }
    }
    paramzzapl = String.valueOf(paramzzaqo);
    throw new IllegalArgumentException(String.valueOf(paramzzapl).length() + 22 + "GSON cannot serialize " + paramzzapl);
  }
  
  public <T> zzapk<T> zza(zzaqo<T> paramzzaqo)
  {
    Object localObject1 = (zzapk)this.bob.get(paramzzaqo);
    if (localObject1 != null) {
      return (zzapk<T>)localObject1;
    }
    Object localObject3 = (Map)this.boa.get();
    int i = 0;
    if (localObject3 == null)
    {
      localObject3 = new HashMap();
      this.boa.set(localObject3);
      i = 1;
    }
    for (;;)
    {
      Object localObject4 = (zza)((Map)localObject3).get(paramzzaqo);
      localObject1 = localObject4;
      if (localObject4 != null) {
        break;
      }
      try
      {
        Object localObject5 = new com/google/android/gms/internal/zzaos$zza;
        ((zza)localObject5).<init>();
        ((Map)localObject3).put(paramzzaqo, localObject5);
        localObject1 = this.boc.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = ((zzapl)((Iterator)localObject1).next()).zza(this, paramzzaqo);
            if (localObject4 != null)
            {
              ((zza)localObject5).zza((zzapk)localObject4);
              this.bob.put(paramzzaqo, localObject4);
              ((Map)localObject3).remove(paramzzaqo);
              localObject1 = localObject4;
              if (i == 0) {
                break;
              }
              this.boa.remove();
              localObject1 = localObject4;
              break;
            }
          }
        }
        localObject4 = new java/lang/IllegalArgumentException;
        localObject5 = String.valueOf(paramzzaqo);
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>(String.valueOf(localObject5).length() + 19);
        ((IllegalArgumentException)localObject4).<init>("GSON cannot handle " + (String)localObject5);
        throw ((Throwable)localObject4);
      }
      finally
      {
        ((Map)localObject3).remove(paramzzaqo);
        if (i != 0) {
          this.boa.remove();
        }
      }
    }
  }
  
  public zzaqr zza(Writer paramWriter)
    throws IOException
  {
    if (this.bog) {
      paramWriter.write(")]}'\n");
    }
    paramWriter = new zzaqr(paramWriter);
    if (this.boh) {
      paramWriter.setIndent("  ");
    }
    paramWriter.zzdk(this.boe);
    return paramWriter;
  }
  
  public <T> T zza(zzaoy paramzzaoy, Class<T> paramClass)
    throws zzaph
  {
    paramzzaoy = zza(paramzzaoy, paramClass);
    return (T)zzapy.zzp(paramClass).cast(paramzzaoy);
  }
  
  public <T> T zza(zzaoy paramzzaoy, Type paramType)
    throws zzaph
  {
    if (paramzzaoy == null) {}
    for (paramzzaoy = null;; paramzzaoy = zza(new zzaqf(paramzzaoy), paramType)) {
      return paramzzaoy;
    }
  }
  
  /* Error */
  public <T> T zza(zzaqp paramzzaqp, Type paramType)
    throws zzaoz, zzaph
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 484	com/google/android/gms/internal/zzaqp:isLenient	()Z
    //   6: istore 4
    //   8: aload_1
    //   9: iconst_1
    //   10: invokevirtual 487	com/google/android/gms/internal/zzaqp:setLenient	(Z)V
    //   13: aload_1
    //   14: invokevirtual 289	com/google/android/gms/internal/zzaqp:bq	()Lcom/google/android/gms/internal/zzaqq;
    //   17: pop
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 493	com/google/android/gms/internal/zzaqo:zzl	(Ljava/lang/reflect/Type;)Lcom/google/android/gms/internal/zzaqo;
    //   25: invokevirtual 495	com/google/android/gms/internal/zzaos:zza	(Lcom/google/android/gms/internal/zzaqo;)Lcom/google/android/gms/internal/zzapk;
    //   28: aload_1
    //   29: invokevirtual 499	com/google/android/gms/internal/zzapk:zzb	(Lcom/google/android/gms/internal/zzaqp;)Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_1
    //   34: iload 4
    //   36: invokevirtual 487	com/google/android/gms/internal/zzaqp:setLenient	(Z)V
    //   39: aload_2
    //   40: areturn
    //   41: astore 5
    //   43: iload_3
    //   44: ifeq +14 -> 58
    //   47: aload_1
    //   48: iload 4
    //   50: invokevirtual 487	com/google/android/gms/internal/zzaqp:setLenient	(Z)V
    //   53: aconst_null
    //   54: astore_2
    //   55: goto -16 -> 39
    //   58: new 304	com/google/android/gms/internal/zzaph
    //   61: astore_2
    //   62: aload_2
    //   63: aload 5
    //   65: invokespecial 307	com/google/android/gms/internal/zzaph:<init>	(Ljava/lang/Throwable;)V
    //   68: aload_2
    //   69: athrow
    //   70: astore_2
    //   71: aload_1
    //   72: iload 4
    //   74: invokevirtual 487	com/google/android/gms/internal/zzaqp:setLenient	(Z)V
    //   77: aload_2
    //   78: athrow
    //   79: astore 5
    //   81: new 304	com/google/android/gms/internal/zzaph
    //   84: astore_2
    //   85: aload_2
    //   86: aload 5
    //   88: invokespecial 307	com/google/android/gms/internal/zzaph:<init>	(Ljava/lang/Throwable;)V
    //   91: aload_2
    //   92: athrow
    //   93: astore_2
    //   94: new 304	com/google/android/gms/internal/zzaph
    //   97: astore 5
    //   99: aload 5
    //   101: aload_2
    //   102: invokespecial 307	com/google/android/gms/internal/zzaph:<init>	(Ljava/lang/Throwable;)V
    //   105: aload 5
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	zzaos
    //   0	108	1	paramzzaqp	zzaqp
    //   0	108	2	paramType	Type
    //   1	43	3	i	int
    //   6	67	4	bool	boolean
    //   41	23	5	localEOFException	java.io.EOFException
    //   79	8	5	localIllegalStateException	IllegalStateException
    //   97	9	5	localzzaph	zzaph
    // Exception table:
    //   from	to	target	type
    //   13	18	41	java/io/EOFException
    //   20	33	41	java/io/EOFException
    //   13	18	70	finally
    //   20	33	70	finally
    //   58	70	70	finally
    //   81	93	70	finally
    //   94	108	70	finally
    //   13	18	79	java/lang/IllegalStateException
    //   20	33	79	java/lang/IllegalStateException
    //   13	18	93	java/io/IOException
    //   20	33	93	java/io/IOException
  }
  
  public <T> T zza(Reader paramReader, Type paramType)
    throws zzaoz, zzaph
  {
    paramReader = new zzaqp(paramReader);
    paramType = zza(paramReader, paramType);
    zza(paramType, paramReader);
    return paramType;
  }
  
  public <T> T zza(String paramString, Type paramType)
    throws zzaph
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = zza(new StringReader(paramString), paramType)) {
      return paramString;
    }
  }
  
  public void zza(zzaoy paramzzaoy, zzaqr paramzzaqr)
    throws zzaoz
  {
    boolean bool1 = paramzzaqr.isLenient();
    paramzzaqr.setLenient(true);
    boolean bool2 = paramzzaqr.bM();
    paramzzaqr.zzdj(this.bof);
    boolean bool3 = paramzzaqr.bN();
    paramzzaqr.zzdk(this.boe);
    try
    {
      zzapz.zzb(paramzzaoy, paramzzaqr);
      return;
    }
    catch (IOException localIOException)
    {
      paramzzaoy = new com/google/android/gms/internal/zzaoz;
      paramzzaoy.<init>(localIOException);
      throw paramzzaoy;
    }
    finally
    {
      paramzzaqr.setLenient(bool1);
      paramzzaqr.zzdj(bool2);
      paramzzaqr.zzdk(bool3);
    }
  }
  
  public void zza(zzaoy paramzzaoy, Appendable paramAppendable)
    throws zzaoz
  {
    try
    {
      zza(paramzzaoy, zza(zzapz.zza(paramAppendable)));
      return;
    }
    catch (IOException paramzzaoy)
    {
      throw new RuntimeException(paramzzaoy);
    }
  }
  
  public void zza(Object paramObject, Type paramType, zzaqr paramzzaqr)
    throws zzaoz
  {
    paramType = zza(zzaqo.zzl(paramType));
    boolean bool3 = paramzzaqr.isLenient();
    paramzzaqr.setLenient(true);
    boolean bool2 = paramzzaqr.bM();
    paramzzaqr.zzdj(this.bof);
    boolean bool1 = paramzzaqr.bN();
    paramzzaqr.zzdk(this.boe);
    try
    {
      paramType.zza(paramzzaqr, paramObject);
      return;
    }
    catch (IOException paramType)
    {
      paramObject = new com/google/android/gms/internal/zzaoz;
      ((zzaoz)paramObject).<init>(paramType);
      throw ((Throwable)paramObject);
    }
    finally
    {
      paramzzaqr.setLenient(bool3);
      paramzzaqr.zzdj(bool2);
      paramzzaqr.zzdk(bool1);
    }
  }
  
  public void zza(Object paramObject, Type paramType, Appendable paramAppendable)
    throws zzaoz
  {
    try
    {
      zza(paramObject, paramType, zza(zzapz.zza(paramAppendable)));
      return;
    }
    catch (IOException paramObject)
    {
      throw new zzaoz((Throwable)paramObject);
    }
  }
  
  public String zzb(zzaoy paramzzaoy)
  {
    StringWriter localStringWriter = new StringWriter();
    zza(paramzzaoy, localStringWriter);
    return localStringWriter.toString();
  }
  
  public String zzc(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    zza(paramObject, paramType, localStringWriter);
    return localStringWriter.toString();
  }
  
  public String zzck(Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = zzb(zzapa.bou);; paramObject = zzc(paramObject, paramObject.getClass())) {
      return (String)paramObject;
    }
  }
  
  public <T> T zzf(String paramString, Class<T> paramClass)
    throws zzaph
  {
    paramString = zza(paramString, paramClass);
    return (T)zzapy.zzp(paramClass).cast(paramString);
  }
  
  public <T> zzapk<T> zzk(Class<T> paramClass)
  {
    return zza(zzaqo.zzr(paramClass));
  }
  
  static class zza<T>
    extends zzapk<T>
  {
    private zzapk<T> bol;
    
    public void zza(zzapk<T> paramzzapk)
    {
      if (this.bol != null) {
        throw new AssertionError();
      }
      this.bol = paramzzapk;
    }
    
    public void zza(zzaqr paramzzaqr, T paramT)
      throws IOException
    {
      if (this.bol == null) {
        throw new IllegalStateException();
      }
      this.bol.zza(paramzzaqr, paramT);
    }
    
    public T zzb(zzaqp paramzzaqp)
      throws IOException
    {
      if (this.bol == null) {
        throw new IllegalStateException();
      }
      return (T)this.bol.zzb(paramzzaqp);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */