package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzasb
{
  private static void zza(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
    throws IllegalAccessException, InvocationTargetException
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      if (!(paramObject instanceof zzasa)) {
        break;
      }
      int m = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(zzuz(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      Class localClass = paramObject.getClass();
      Object localObject1 = localClass.getFields();
      int n = localObject1.length;
      int i = 0;
      String str;
      if (i < n)
      {
        Object localObject4 = localObject1[i];
        j = ((Field)localObject4).getModifiers();
        str = ((Field)localObject4).getName();
        if ("cachedSize".equals(str)) {}
        for (;;)
        {
          i++;
          break;
          if (((j & 0x1) == 1) && ((j & 0x8) != 8) && (!str.startsWith("_")) && (!str.endsWith("_")))
          {
            localObject3 = ((Field)localObject4).getType();
            localObject4 = ((Field)localObject4).get(paramObject);
            if (((Class)localObject3).isArray())
            {
              if (((Class)localObject3).getComponentType() == Byte.TYPE)
              {
                zza(str, localObject4, paramStringBuffer1, paramStringBuffer2);
              }
              else
              {
                if (localObject4 == null) {}
                for (j = 0;; j = Array.getLength(localObject4))
                {
                  for (int k = 0; k < j; k++) {
                    zza(str, Array.get(localObject4, k), paramStringBuffer1, paramStringBuffer2);
                  }
                  break;
                }
              }
            }
            else {
              zza(str, localObject4, paramStringBuffer1, paramStringBuffer2);
            }
          }
        }
      }
      Object localObject3 = localClass.getMethods();
      int j = localObject3.length;
      i = 0;
      if (i < j)
      {
        localObject1 = localObject3[i].getName();
        if (((String)localObject1).startsWith("set")) {
          str = ((String)localObject1).substring(3);
        }
        for (;;)
        {
          try
          {
            localObject1 = String.valueOf(str);
            if (((String)localObject1).length() == 0) {
              continue;
            }
            localObject1 = "has".concat((String)localObject1);
            localObject1 = localClass.getMethod((String)localObject1, new Class[0]);
            if (((Boolean)((Method)localObject1).invoke(paramObject, new Object[0])).booleanValue()) {
              continue;
            }
            i++;
          }
          catch (NoSuchMethodException localNoSuchMethodException1)
          {
            continue;
            try
            {
              Object localObject2 = String.valueOf(str);
              if (((String)localObject2).length() == 0) {
                continue;
              }
              localObject2 = "get".concat((String)localObject2);
              localObject2 = localClass.getMethod((String)localObject2, new Class[0]);
              zza(str, ((Method)localObject2).invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
              continue;
              localObject2 = new String("get");
              continue;
            }
            catch (NoSuchMethodException localNoSuchMethodException2) {}
          }
          break;
          localObject1 = new String("has");
        }
      }
      if (paramString != null)
      {
        paramStringBuffer1.setLength(m);
        paramStringBuffer2.append(paramStringBuffer1).append(">\n");
      }
    }
    paramString = zzuz(paramString);
    paramStringBuffer2.append(paramStringBuffer1).append(paramString).append(": ");
    if ((paramObject instanceof String))
    {
      paramString = zzgj((String)paramObject);
      paramStringBuffer2.append("\"").append(paramString).append("\"");
    }
    for (;;)
    {
      paramStringBuffer2.append("\n");
      break;
      if ((paramObject instanceof byte[])) {
        zza((byte[])paramObject, paramStringBuffer2);
      } else {
        paramStringBuffer2.append(paramObject);
      }
    }
  }
  
  private static void zza(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte == null) {
      paramStringBuffer.append("\"\"");
    }
    for (;;)
    {
      return;
      paramStringBuffer.append('"');
      int i = 0;
      if (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i] & 0xFF;
        if ((j == 92) || (j == 34)) {
          paramStringBuffer.append('\\').append((char)j);
        }
        for (;;)
        {
          i++;
          break;
          if ((j >= 32) && (j < 127)) {
            paramStringBuffer.append((char)j);
          } else {
            paramStringBuffer.append(String.format("\\%03o", new Object[] { Integer.valueOf(j) }));
          }
        }
      }
      paramStringBuffer.append('"');
    }
  }
  
  public static <T extends zzasa> String zzg(T paramT)
  {
    if (paramT == null) {
      paramT = "";
    }
    for (;;)
    {
      return paramT;
      StringBuffer localStringBuffer2 = new StringBuffer();
      try
      {
        StringBuffer localStringBuffer1 = new java/lang/StringBuffer;
        localStringBuffer1.<init>();
        zza(null, paramT, localStringBuffer1, localStringBuffer2);
        paramT = localStringBuffer2.toString();
      }
      catch (IllegalAccessException paramT)
      {
        paramT = String.valueOf(paramT.getMessage());
        if (paramT.length() != 0) {
          paramT = "Error printing proto: ".concat(paramT);
        } else {
          paramT = new String("Error printing proto: ");
        }
      }
      catch (InvocationTargetException paramT)
      {
        paramT = String.valueOf(paramT.getMessage());
        if (paramT.length() != 0) {
          paramT = "Error printing proto: ".concat(paramT);
        } else {
          paramT = new String("Error printing proto: ");
        }
      }
    }
  }
  
  private static String zzgj(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (paramString.length() > 200) {
        str = String.valueOf(paramString.substring(0, 200)).concat("[...]");
      }
    }
    return zzii(str);
  }
  
  private static String zzii(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\'')) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i++;
        break;
        localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String zzuz(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i == 0) {
        localStringBuffer.append(Character.toLowerCase(c));
      }
      for (;;)
      {
        i++;
        break;
        if (Character.isUpperCase(c)) {
          localStringBuffer.append('_').append(Character.toLowerCase(c));
        } else {
          localStringBuffer.append(c);
        }
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzasb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */