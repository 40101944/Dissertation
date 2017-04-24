package com.google.android.gms.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class zzapr
{
  static final Type[] boI = new Type[0];
  
  static boolean equal(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static int zza(Object[] paramArrayOfObject, Object paramObject)
  {
    for (int i = 0; i < paramArrayOfObject.length; i++) {
      if (paramObject.equals(paramArrayOfObject[i])) {
        return i;
      }
    }
    throw new NoSuchElementException();
  }
  
  private static Class<?> zza(TypeVariable<?> paramTypeVariable)
  {
    paramTypeVariable = paramTypeVariable.getGenericDeclaration();
    if ((paramTypeVariable instanceof Class)) {}
    for (paramTypeVariable = (Class)paramTypeVariable;; paramTypeVariable = null) {
      return paramTypeVariable;
    }
  }
  
  public static ParameterizedType zza(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    return new zzb(paramType1, paramType2, paramVarArgs);
  }
  
  public static Type zza(Type paramType, Class<?> paramClass)
  {
    paramClass = zzb(paramType, paramClass, Collection.class);
    paramType = paramClass;
    if ((paramClass instanceof WildcardType)) {
      paramType = ((WildcardType)paramClass).getUpperBounds()[0];
    }
    if ((paramType instanceof ParameterizedType)) {}
    for (paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];; paramType = Object.class) {
      return paramType;
    }
  }
  
  static Type zza(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1) {}
    for (;;)
    {
      return paramType;
      if (paramClass2.isInterface())
      {
        paramType = paramClass1.getInterfaces();
        int i = 0;
        int j = paramType.length;
        for (;;)
        {
          if (i >= j) {
            break label81;
          }
          if (paramType[i] == paramClass2)
          {
            paramType = paramClass1.getGenericInterfaces()[i];
            break;
          }
          if (paramClass2.isAssignableFrom(paramType[i]))
          {
            paramType = zza(paramClass1.getGenericInterfaces()[i], paramType[i], paramClass2);
            break;
          }
          i++;
        }
      }
      label81:
      if (!paramClass1.isInterface()) {
        for (;;)
        {
          if (paramClass1 == Object.class) {
            break label138;
          }
          paramType = paramClass1.getSuperclass();
          if (paramType == paramClass2)
          {
            paramType = paramClass1.getGenericSuperclass();
            break;
          }
          if (paramClass2.isAssignableFrom(paramType))
          {
            paramType = zza(paramClass1.getGenericSuperclass(), paramType, paramClass2);
            break;
          }
          paramClass1 = paramType;
        }
      }
      label138:
      paramType = paramClass2;
    }
  }
  
  public static Type zza(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    Object localObject1 = paramType2;
    if ((localObject1 instanceof TypeVariable))
    {
      localObject1 = (TypeVariable)localObject1;
      paramType2 = zza(paramType1, paramClass, (TypeVariable)localObject1);
      if (paramType2 != localObject1) {}
    }
    for (;;)
    {
      return paramType2;
      localObject1 = paramType2;
      break;
      if (((localObject1 instanceof Class)) && (((Class)localObject1).isArray()))
      {
        paramType2 = (Class)localObject1;
        localObject1 = paramType2.getComponentType();
        paramType1 = zza(paramType1, paramClass, (Type)localObject1);
        if (localObject1 != paramType1) {
          paramType2 = zzb(paramType1);
        }
      }
      else if ((localObject1 instanceof GenericArrayType))
      {
        paramType2 = (GenericArrayType)localObject1;
        localObject1 = paramType2.getGenericComponentType();
        paramType1 = zza(paramType1, paramClass, (Type)localObject1);
        if (localObject1 != paramType1) {
          paramType2 = zzb(paramType1);
        }
      }
      else
      {
        Object localObject2;
        Object localObject3;
        if ((localObject1 instanceof ParameterizedType))
        {
          localObject2 = (ParameterizedType)localObject1;
          paramType2 = ((ParameterizedType)localObject2).getOwnerType();
          localObject3 = zza(paramType1, paramClass, paramType2);
          if (localObject3 != paramType2) {}
          for (int i = 1;; i = 0)
          {
            localObject1 = ((ParameterizedType)localObject2).getActualTypeArguments();
            int m = localObject1.length;
            int k = 0;
            while (k < m)
            {
              Type localType = zza(paramType1, paramClass, localObject1[k]);
              paramType2 = (Type)localObject1;
              int j = i;
              if (localType != localObject1[k])
              {
                paramType2 = (Type)localObject1;
                j = i;
                if (i == 0)
                {
                  paramType2 = (Type[])((Type[])localObject1).clone();
                  j = 1;
                }
                paramType2[k] = localType;
              }
              k++;
              localObject1 = paramType2;
              i = j;
            }
          }
          paramType2 = (Type)localObject2;
          if (i != 0) {
            paramType2 = zza((Type)localObject3, ((ParameterizedType)localObject2).getRawType(), (Type[])localObject1);
          }
        }
        else
        {
          paramType2 = (Type)localObject1;
          if ((localObject1 instanceof WildcardType))
          {
            localObject1 = (WildcardType)localObject1;
            localObject2 = ((WildcardType)localObject1).getLowerBounds();
            localObject3 = ((WildcardType)localObject1).getUpperBounds();
            if (localObject2.length == 1)
            {
              paramType1 = zza(paramType1, paramClass, localObject2[0]);
              paramType2 = (Type)localObject1;
              if (paramType1 != localObject2[0]) {
                paramType2 = zzd(paramType1);
              }
            }
            else
            {
              paramType2 = (Type)localObject1;
              if (localObject3.length == 1)
              {
                paramType1 = zza(paramType1, paramClass, localObject3[0]);
                paramType2 = (Type)localObject1;
                if (paramType1 != localObject3[0]) {
                  paramType2 = zzc(paramType1);
                }
              }
            }
          }
        }
      }
    }
  }
  
  static Type zza(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = zza(paramTypeVariable);
    if (localClass == null) {
      paramType = paramTypeVariable;
    }
    for (;;)
    {
      return paramType;
      paramClass = zza(paramType, paramClass, localClass);
      paramType = paramTypeVariable;
      if ((paramClass instanceof ParameterizedType))
      {
        int i = zza(localClass.getTypeParameters(), paramTypeVariable);
        paramType = ((ParameterizedType)paramClass).getActualTypeArguments()[i];
      }
    }
  }
  
  public static boolean zza(Type paramType1, Type paramType2)
  {
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool3 = true;
    boolean bool2 = false;
    if (paramType1 == paramType2) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return bool1;
            if ((paramType1 instanceof Class))
            {
              bool1 = paramType1.equals(paramType2);
            }
            else if ((paramType1 instanceof ParameterizedType))
            {
              bool1 = bool2;
              if ((paramType2 instanceof ParameterizedType))
              {
                paramType1 = (ParameterizedType)paramType1;
                paramType2 = (ParameterizedType)paramType2;
                if ((equal(paramType1.getOwnerType(), paramType2.getOwnerType())) && (paramType1.getRawType().equals(paramType2.getRawType())) && (Arrays.equals(paramType1.getActualTypeArguments(), paramType2.getActualTypeArguments()))) {}
                for (bool1 = bool3;; bool1 = false) {
                  break;
                }
              }
            }
            else
            {
              if (!(paramType1 instanceof GenericArrayType)) {
                break;
              }
              bool1 = bool2;
              if ((paramType2 instanceof GenericArrayType))
              {
                paramType1 = (GenericArrayType)paramType1;
                paramType2 = (GenericArrayType)paramType2;
                bool1 = zza(paramType1.getGenericComponentType(), paramType2.getGenericComponentType());
              }
            }
          }
          if (!(paramType1 instanceof WildcardType)) {
            break;
          }
          bool1 = bool2;
        } while (!(paramType2 instanceof WildcardType));
        paramType1 = (WildcardType)paramType1;
        paramType2 = (WildcardType)paramType2;
        if ((Arrays.equals(paramType1.getUpperBounds(), paramType2.getUpperBounds())) && (Arrays.equals(paramType1.getLowerBounds(), paramType2.getLowerBounds()))) {}
        for (bool1 = bool4;; bool1 = false) {
          break;
        }
        bool1 = bool2;
      } while (!(paramType1 instanceof TypeVariable));
      bool1 = bool2;
    } while (!(paramType2 instanceof TypeVariable));
    paramType1 = (TypeVariable)paramType1;
    paramType2 = (TypeVariable)paramType2;
    if ((paramType1.getGenericDeclaration() == paramType2.getGenericDeclaration()) && (paramType1.getName().equals(paramType2.getName()))) {}
    for (boolean bool1 = bool5;; bool1 = false) {
      break;
    }
  }
  
  public static GenericArrayType zzb(Type paramType)
  {
    return new zza(paramType);
  }
  
  static Type zzb(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    zzapq.zzbt(paramClass2.isAssignableFrom(paramClass1));
    return zza(paramType, paramClass1, zza(paramType, paramClass1, paramClass2));
  }
  
  public static Type[] zzb(Type paramType, Class<?> paramClass)
  {
    if (paramType == Properties.class)
    {
      paramType = new Type[2];
      paramType[0] = String.class;
      paramType[1] = String.class;
    }
    for (;;)
    {
      return paramType;
      paramType = zzb(paramType, paramClass, Map.class);
      if ((paramType instanceof ParameterizedType))
      {
        paramType = ((ParameterizedType)paramType).getActualTypeArguments();
      }
      else
      {
        paramType = new Type[2];
        paramType[0] = Object.class;
        paramType[1] = Object.class;
      }
    }
  }
  
  public static WildcardType zzc(Type paramType)
  {
    Type[] arrayOfType = boI;
    return new zzc(new Type[] { paramType }, arrayOfType);
  }
  
  private static int zzco(Object paramObject)
  {
    if (paramObject != null) {}
    for (int i = paramObject.hashCode();; i = 0) {
      return i;
    }
  }
  
  public static WildcardType zzd(Type paramType)
  {
    return new zzc(new Type[] { Object.class }, new Type[] { paramType });
  }
  
  public static Type zze(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      paramType = (Class)paramType;
      if (paramType.isArray())
      {
        paramType = new zza(zze(paramType.getComponentType()));
        paramType = (Type)paramType;
      }
    }
    for (;;)
    {
      return paramType;
      break;
      if ((paramType instanceof ParameterizedType))
      {
        paramType = (ParameterizedType)paramType;
        paramType = new zzb(paramType.getOwnerType(), paramType.getRawType(), paramType.getActualTypeArguments());
      }
      else if ((paramType instanceof GenericArrayType))
      {
        paramType = new zza(((GenericArrayType)paramType).getGenericComponentType());
      }
      else if ((paramType instanceof WildcardType))
      {
        paramType = (WildcardType)paramType;
        paramType = new zzc(paramType.getUpperBounds(), paramType.getLowerBounds());
      }
    }
  }
  
  public static Class<?> zzf(Type paramType)
  {
    if ((paramType instanceof Class)) {
      paramType = (Class)paramType;
    }
    for (;;)
    {
      return paramType;
      if ((paramType instanceof ParameterizedType))
      {
        paramType = ((ParameterizedType)paramType).getRawType();
        zzapq.zzbt(paramType instanceof Class);
        paramType = (Class)paramType;
      }
      else if ((paramType instanceof GenericArrayType))
      {
        paramType = Array.newInstance(zzf(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
      }
      else if ((paramType instanceof TypeVariable))
      {
        paramType = Object.class;
      }
      else
      {
        if (!(paramType instanceof WildcardType)) {
          break;
        }
        paramType = zzf(((WildcardType)paramType).getUpperBounds()[0]);
      }
    }
    if (paramType == null) {}
    for (String str1 = "null";; str1 = paramType.getClass().getName())
    {
      String str2 = String.valueOf("Expected a Class, ParameterizedType, or GenericArrayType, but <");
      paramType = String.valueOf(paramType);
      throw new IllegalArgumentException(String.valueOf(str2).length() + 13 + String.valueOf(paramType).length() + String.valueOf(str1).length() + str2 + paramType + "> is of type " + str1);
    }
  }
  
  public static String zzg(Type paramType)
  {
    if ((paramType instanceof Class)) {}
    for (paramType = ((Class)paramType).getName();; paramType = paramType.toString()) {
      return paramType;
    }
  }
  
  public static Type zzh(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {}
    for (paramType = ((GenericArrayType)paramType).getGenericComponentType();; paramType = ((Class)paramType).getComponentType()) {
      return paramType;
    }
  }
  
  private static void zzi(Type paramType)
  {
    if ((!(paramType instanceof Class)) || (!((Class)paramType).isPrimitive())) {}
    for (boolean bool = true;; bool = false)
    {
      zzapq.zzbt(bool);
      return;
    }
  }
  
  private static final class zza
    implements Serializable, GenericArrayType
  {
    private final Type boJ;
    
    public zza(Type paramType)
    {
      this.boJ = zzapr.zze(paramType);
    }
    
    public boolean equals(Object paramObject)
    {
      if (((paramObject instanceof GenericArrayType)) && (zzapr.zza(this, (GenericArrayType)paramObject))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public Type getGenericComponentType()
    {
      return this.boJ;
    }
    
    public int hashCode()
    {
      return this.boJ.hashCode();
    }
    
    public String toString()
    {
      return String.valueOf(zzapr.zzg(this.boJ)).concat("[]");
    }
  }
  
  private static final class zzb
    implements Serializable, ParameterizedType
  {
    private final Type boK;
    private final Type boL;
    private final Type[] boM;
    
    public zzb(Type paramType1, Type paramType2, Type... paramVarArgs)
    {
      int i;
      boolean bool;
      if ((paramType2 instanceof Class))
      {
        Class localClass = (Class)paramType2;
        if ((Modifier.isStatic(localClass.getModifiers())) || (localClass.getEnclosingClass() == null))
        {
          i = 1;
          if ((paramType1 == null) && (i == 0)) {
            break label153;
          }
          bool = true;
          label54:
          zzapq.zzbt(bool);
        }
      }
      else
      {
        if (paramType1 != null) {
          break label159;
        }
      }
      label153:
      label159:
      for (paramType1 = null;; paramType1 = zzapr.zze(paramType1))
      {
        this.boK = paramType1;
        this.boL = zzapr.zze(paramType2);
        this.boM = ((Type[])paramVarArgs.clone());
        for (i = j; i < this.boM.length; i++)
        {
          zzapq.zzy(this.boM[i]);
          zzapr.zzj(this.boM[i]);
          this.boM[i] = zzapr.zze(this.boM[i]);
        }
        i = 0;
        break;
        bool = false;
        break label54;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (((paramObject instanceof ParameterizedType)) && (zzapr.zza(this, (ParameterizedType)paramObject))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public Type[] getActualTypeArguments()
    {
      return (Type[])this.boM.clone();
    }
    
    public Type getOwnerType()
    {
      return this.boK;
    }
    
    public Type getRawType()
    {
      return this.boL;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(this.boM) ^ this.boL.hashCode() ^ zzapr.zzcp(this.boK);
    }
    
    public String toString()
    {
      Object localObject = new StringBuilder((this.boM.length + 1) * 30);
      ((StringBuilder)localObject).append(zzapr.zzg(this.boL));
      if (this.boM.length == 0) {}
      for (localObject = ((StringBuilder)localObject).toString();; localObject = ">")
      {
        return (String)localObject;
        ((StringBuilder)localObject).append("<").append(zzapr.zzg(this.boM[0]));
        for (int i = 1; i < this.boM.length; i++) {
          ((StringBuilder)localObject).append(", ").append(zzapr.zzg(this.boM[i]));
        }
      }
    }
  }
  
  private static final class zzc
    implements Serializable, WildcardType
  {
    private final Type boN;
    private final Type boO;
    
    public zzc(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      boolean bool1;
      if (paramArrayOfType2.length <= 1)
      {
        bool1 = true;
        zzapq.zzbt(bool1);
        if (paramArrayOfType1.length != 1) {
          break label87;
        }
        bool1 = true;
        label27:
        zzapq.zzbt(bool1);
        if (paramArrayOfType2.length != 1) {
          break label97;
        }
        zzapq.zzy(paramArrayOfType2[0]);
        zzapr.zzj(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] != Object.class) {
          break label92;
        }
        bool1 = bool2;
        label61:
        zzapq.zzbt(bool1);
        this.boO = zzapr.zze(paramArrayOfType2[0]);
      }
      for (this.boN = Object.class;; this.boN = zzapr.zze(paramArrayOfType1[0]))
      {
        return;
        bool1 = false;
        break;
        label87:
        bool1 = false;
        break label27;
        label92:
        bool1 = false;
        break label61;
        label97:
        zzapq.zzy(paramArrayOfType1[0]);
        zzapr.zzj(paramArrayOfType1[0]);
        this.boO = null;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (((paramObject instanceof WildcardType)) && (zzapr.zza(this, (WildcardType)paramObject))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public Type[] getLowerBounds()
    {
      Type[] arrayOfType;
      if (this.boO != null)
      {
        arrayOfType = new Type[1];
        arrayOfType[0] = this.boO;
      }
      for (;;)
      {
        return arrayOfType;
        arrayOfType = zzapr.boI;
      }
    }
    
    public Type[] getUpperBounds()
    {
      return new Type[] { this.boN };
    }
    
    public int hashCode()
    {
      if (this.boO != null) {}
      for (int i = this.boO.hashCode() + 31;; i = 1) {
        return i ^ this.boN.hashCode() + 31;
      }
    }
    
    public String toString()
    {
      String str;
      if (this.boO != null)
      {
        str = String.valueOf(zzapr.zzg(this.boO));
        if (str.length() != 0) {
          str = "? super ".concat(str);
        }
      }
      for (;;)
      {
        return str;
        str = new String("? super ");
        continue;
        if (this.boN == Object.class)
        {
          str = "?";
        }
        else
        {
          str = String.valueOf(zzapr.zzg(this.boN));
          if (str.length() != 0) {
            str = "? extends ".concat(str);
          } else {
            str = new String("? extends ");
          }
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzapr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */