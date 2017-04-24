package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzaqj
  implements zzapl
{
  private final zzaps bod;
  private final zzapt bom;
  private final zzaor boo;
  
  public zzaqj(zzaps paramzzaps, zzaor paramzzaor, zzapt paramzzapt)
  {
    this.bod = paramzzaps;
    this.boo = paramzzaor;
    this.bom = paramzzapt;
  }
  
  private zzapk<?> zza(zzaos paramzzaos, Field paramField, zzaqo<?> paramzzaqo)
  {
    paramField = (zzapm)paramField.getAnnotation(zzapm.class);
    if (paramField != null)
    {
      paramField = zzaqe.zza(this.bod, paramzzaos, paramzzaqo, paramField);
      if (paramField == null) {}
    }
    for (paramzzaos = paramField;; paramzzaos = paramzzaos.zza(paramzzaqo)) {
      return paramzzaos;
    }
  }
  
  private zzb zza(final zzaos paramzzaos, final Field paramField, String paramString, final zzaqo<?> paramzzaqo, boolean paramBoolean1, boolean paramBoolean2)
  {
    new zzb(paramString, paramBoolean1, paramBoolean2)
    {
      final zzapk<?> bpX = zzaqj.zza(zzaqj.this, paramzzaos, paramField, paramzzaqo);
      
      void zza(zzaqp paramAnonymouszzaqp, Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        paramAnonymouszzaqp = this.bpX.zzb(paramAnonymouszzaqp);
        if ((paramAnonymouszzaqp != null) || (!this.bqb)) {
          paramField.set(paramAnonymousObject, paramAnonymouszzaqp);
        }
      }
      
      void zza(zzaqr paramAnonymouszzaqr, Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        paramAnonymousObject = paramField.get(paramAnonymousObject);
        new zzaqm(paramzzaos, this.bpX, paramzzaqo.bC()).zza(paramAnonymouszzaqr, paramAnonymousObject);
      }
      
      public boolean zzcs(Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        boolean bool = false;
        if (!this.bqe) {}
        for (;;)
        {
          return bool;
          if (paramField.get(paramAnonymousObject) != paramAnonymousObject) {
            bool = true;
          }
        }
      }
    };
  }
  
  static List<String> zza(zzaor paramzzaor, Field paramField)
  {
    zzapn localzzapn = (zzapn)paramField.getAnnotation(zzapn.class);
    LinkedList localLinkedList = new LinkedList();
    if (localzzapn == null) {
      localLinkedList.add(paramzzaor.zzc(paramField));
    }
    for (;;)
    {
      return localLinkedList;
      localLinkedList.add(localzzapn.value());
      paramzzaor = localzzapn.bh();
      int j = paramzzaor.length;
      for (int i = 0; i < j; i++) {
        localLinkedList.add(paramzzaor[i]);
      }
    }
  }
  
  private Map<String, zzb> zza(zzaos paramzzaos, zzaqo<?> paramzzaqo, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface()) {
      return localLinkedHashMap;
    }
    Type localType1 = paramzzaqo.bC();
    Object localObject1 = paramzzaqo;
    label28:
    label90:
    int j;
    if (paramClass != Object.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int k = arrayOfField.length;
      int i = 0;
      for (;;)
      {
        if (i < k)
        {
          Field localField = arrayOfField[i];
          boolean bool1 = zza(localField, true);
          boolean bool2 = zza(localField, false);
          if ((!bool1) && (!bool2))
          {
            i++;
          }
          else
          {
            localField.setAccessible(true);
            Type localType2 = zzapr.zza(((zzaqo)localObject1).bC(), paramClass, localField.getGenericType());
            List localList = zzd(localField);
            paramzzaqo = null;
            j = 0;
            label131:
            if (j < localList.size())
            {
              Object localObject2 = (String)localList.get(j);
              if (j != 0) {
                bool1 = false;
              }
              localObject2 = (zzb)localLinkedHashMap.put(localObject2, zza(paramzzaos, localField, (String)localObject2, zzaqo.zzl(localType2), bool1, bool2));
              if (paramzzaqo != null) {
                break label304;
              }
              paramzzaqo = (zzaqo<?>)localObject2;
            }
          }
        }
      }
    }
    label304:
    for (;;)
    {
      j++;
      break label131;
      if (paramzzaqo == null) {
        break label90;
      }
      paramzzaos = String.valueOf(localType1);
      paramzzaqo = paramzzaqo.name;
      throw new IllegalArgumentException(String.valueOf(paramzzaos).length() + 37 + String.valueOf(paramzzaqo).length() + paramzzaos + " declares multiple JSON fields named " + paramzzaqo);
      localObject1 = zzaqo.zzl(zzapr.zza(((zzaqo)localObject1).bC(), paramClass, paramClass.getGenericSuperclass()));
      paramClass = ((zzaqo)localObject1).bB();
      break label28;
      break;
    }
  }
  
  static boolean zza(Field paramField, boolean paramBoolean, zzapt paramzzapt)
  {
    if ((!paramzzapt.zza(paramField.getType(), paramBoolean)) && (!paramzzapt.zza(paramField, paramBoolean))) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  private List<String> zzd(Field paramField)
  {
    return zza(this.boo, paramField);
  }
  
  public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
  {
    Object localObject = null;
    Class localClass = paramzzaqo.bB();
    if (!Object.class.isAssignableFrom(localClass)) {}
    for (paramzzaos = (zzaos)localObject;; paramzzaos = new zza(this.bod.zzb(paramzzaqo), zza(paramzzaos, paramzzaqo, localClass), null)) {
      return paramzzaos;
    }
  }
  
  public boolean zza(Field paramField, boolean paramBoolean)
  {
    return zza(paramField, paramBoolean, this.bom);
  }
  
  public static final class zza<T>
    extends zzapk<T>
  {
    private final zzapx<T> bpK;
    private final Map<String, zzaqj.zzb> bqd;
    
    private zza(zzapx<T> paramzzapx, Map<String, zzaqj.zzb> paramMap)
    {
      this.bpK = paramzzapx;
      this.bqd = paramMap;
    }
    
    public void zza(zzaqr paramzzaqr, T paramT)
      throws IOException
    {
      if (paramT == null) {
        paramzzaqr.bA();
      }
      for (;;)
      {
        return;
        paramzzaqr.by();
        try
        {
          Iterator localIterator = this.bqd.values().iterator();
          while (localIterator.hasNext())
          {
            zzaqj.zzb localzzb = (zzaqj.zzb)localIterator.next();
            if (localzzb.zzcs(paramT))
            {
              paramzzaqr.zzus(localzzb.name);
              localzzb.zza(paramzzaqr, paramT);
            }
          }
          paramzzaqr.bz();
        }
        catch (IllegalAccessException paramzzaqr)
        {
          throw new AssertionError();
        }
      }
    }
    
    public T zzb(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ) {
        paramzzaqp.nextNull();
      }
      Object localObject1;
      for (paramzzaqp = null;; paramzzaqp = (zzaqp)localObject1)
      {
        return paramzzaqp;
        localObject1 = this.bpK.bj();
        try
        {
          paramzzaqp.beginObject();
          for (;;)
          {
            if (!paramzzaqp.hasNext()) {
              break label105;
            }
            localObject2 = paramzzaqp.nextName();
            localObject2 = (zzaqj.zzb)this.bqd.get(localObject2);
            if ((localObject2 != null) && (((zzaqj.zzb)localObject2).bqf)) {
              break;
            }
            paramzzaqp.skipValue();
          }
        }
        catch (IllegalStateException paramzzaqp)
        {
          for (;;)
          {
            Object localObject2;
            throw new zzaph(paramzzaqp);
            ((zzaqj.zzb)localObject2).zza(paramzzaqp, localObject1);
          }
        }
        catch (IllegalAccessException paramzzaqp)
        {
          throw new AssertionError(paramzzaqp);
        }
        label105:
        paramzzaqp.endObject();
      }
    }
  }
  
  static abstract class zzb
  {
    final boolean bqe;
    final boolean bqf;
    final String name;
    
    protected zzb(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.name = paramString;
      this.bqe = paramBoolean1;
      this.bqf = paramBoolean2;
    }
    
    abstract void zza(zzaqp paramzzaqp, Object paramObject)
      throws IOException, IllegalAccessException;
    
    abstract void zza(zzaqr paramzzaqr, Object paramObject)
      throws IOException, IllegalAccessException;
    
    abstract boolean zzcs(Object paramObject)
      throws IOException, IllegalAccessException;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */