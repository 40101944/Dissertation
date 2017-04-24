package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzapt
  implements zzapl, Cloneable
{
  public static final zzapt boW = new zzapt();
  private double boX = -1.0D;
  private int boY = 136;
  private boolean boZ = true;
  private List<zzaoo> bpa = Collections.emptyList();
  private List<zzaoo> bpb = Collections.emptyList();
  
  private boolean zza(zzapo paramzzapo)
  {
    if ((paramzzapo != null) && (paramzzapo.bi() > this.boX)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private boolean zza(zzapo paramzzapo, zzapp paramzzapp)
  {
    if ((zza(paramzzapo)) && (zza(paramzzapp))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean zza(zzapp paramzzapp)
  {
    if ((paramzzapp != null) && (paramzzapp.bi() <= this.boX)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private boolean zzm(Class<?> paramClass)
  {
    if ((!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean zzn(Class<?> paramClass)
  {
    if ((paramClass.isMemberClass()) && (!zzo(paramClass))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean zzo(Class<?> paramClass)
  {
    if ((paramClass.getModifiers() & 0x8) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected zzapt bk()
  {
    try
    {
      zzapt localzzapt = (zzapt)super.clone();
      return localzzapt;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public <T> zzapk<T> zza(final zzaos paramzzaos, final zzaqo<T> paramzzaqo)
  {
    Class localClass = paramzzaqo.bB();
    final boolean bool2 = zza(localClass, true);
    final boolean bool1 = zza(localClass, false);
    if ((!bool2) && (!bool1)) {}
    for (paramzzaos = null;; paramzzaos = new zzapk()
        {
          private zzapk<T> bol;
          
          private zzapk<T> bg()
          {
            zzapk localzzapk = this.bol;
            if (localzzapk != null) {}
            for (;;)
            {
              return localzzapk;
              localzzapk = paramzzaos.zza(zzapt.this, paramzzaqo);
              this.bol = localzzapk;
            }
          }
          
          public void zza(zzaqr paramAnonymouszzaqr, T paramAnonymousT)
            throws IOException
          {
            if (bool2) {
              paramAnonymouszzaqr.bA();
            }
            for (;;)
            {
              return;
              bg().zza(paramAnonymouszzaqr, paramAnonymousT);
            }
          }
          
          public T zzb(zzaqp paramAnonymouszzaqp)
            throws IOException
          {
            if (bool1) {
              paramAnonymouszzaqp.skipValue();
            }
            for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = bg().zzb(paramAnonymouszzaqp)) {
              return paramAnonymouszzaqp;
            }
          }
        }) {
      return paramzzaos;
    }
  }
  
  public zzapt zza(zzaoo paramzzaoo, boolean paramBoolean1, boolean paramBoolean2)
  {
    zzapt localzzapt = bk();
    if (paramBoolean1)
    {
      localzzapt.bpa = new ArrayList(this.bpa);
      localzzapt.bpa.add(paramzzaoo);
    }
    if (paramBoolean2)
    {
      localzzapt.bpb = new ArrayList(this.bpb);
      localzzapt.bpb.add(paramzzaoo);
    }
    return localzzapt;
  }
  
  public boolean zza(Class<?> paramClass, boolean paramBoolean)
  {
    if ((this.boX != -1.0D) && (!zza((zzapo)paramClass.getAnnotation(zzapo.class), (zzapp)paramClass.getAnnotation(zzapp.class)))) {
      paramBoolean = true;
    }
    for (;;)
    {
      return paramBoolean;
      if ((!this.boZ) && (zzn(paramClass)))
      {
        paramBoolean = true;
      }
      else if (zzm(paramClass))
      {
        paramBoolean = true;
      }
      else
      {
        if (paramBoolean) {}
        for (Object localObject = this.bpa;; localObject = this.bpb)
        {
          localObject = ((List)localObject).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!((zzaoo)((Iterator)localObject).next()).zzh(paramClass));
          paramBoolean = true;
          break;
        }
        paramBoolean = false;
      }
    }
  }
  
  public boolean zza(Field paramField, boolean paramBoolean)
  {
    if ((this.boY & paramField.getModifiers()) != 0) {
      paramBoolean = true;
    }
    for (;;)
    {
      return paramBoolean;
      if ((this.boX != -1.0D) && (!zza((zzapo)paramField.getAnnotation(zzapo.class), (zzapp)paramField.getAnnotation(zzapp.class))))
      {
        paramBoolean = true;
      }
      else if (paramField.isSynthetic())
      {
        paramBoolean = true;
      }
      else if ((!this.boZ) && (zzn(paramField.getType())))
      {
        paramBoolean = true;
      }
      else if (zzm(paramField.getType()))
      {
        paramBoolean = true;
      }
      else
      {
        if (paramBoolean) {}
        for (Object localObject = this.bpa;; localObject = this.bpb)
        {
          if (((List)localObject).isEmpty()) {
            break label182;
          }
          paramField = new zzaop(paramField);
          localObject = ((List)localObject).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!((zzaoo)((Iterator)localObject).next()).zza(paramField));
          paramBoolean = true;
          break;
        }
        label182:
        paramBoolean = false;
      }
    }
  }
  
  public zzapt zzg(int... paramVarArgs)
  {
    int i = 0;
    zzapt localzzapt = bk();
    localzzapt.boY = 0;
    int j = paramVarArgs.length;
    while (i < j)
    {
      localzzapt.boY = (paramVarArgs[i] | localzzapt.boY);
      i++;
    }
    return localzzapt;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzapt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */