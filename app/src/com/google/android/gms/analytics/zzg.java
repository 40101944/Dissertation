package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public abstract class zzg<T extends zzg>
{
  private static String zza(Object paramObject, int paramInt)
  {
    if (paramInt > 10) {
      paramObject = "ERROR: Recursive toString calls";
    }
    for (;;)
    {
      return (String)paramObject;
      if (paramObject == null)
      {
        paramObject = "";
      }
      else if ((paramObject instanceof String))
      {
        if (TextUtils.isEmpty((String)paramObject)) {
          paramObject = "";
        } else {
          paramObject = paramObject.toString();
        }
      }
      else if ((paramObject instanceof Integer))
      {
        if (((Integer)paramObject).intValue() == 0) {
          paramObject = "";
        } else {
          paramObject = paramObject.toString();
        }
      }
      else if ((paramObject instanceof Long))
      {
        if (((Long)paramObject).longValue() == 0L) {
          paramObject = "";
        } else {
          paramObject = paramObject.toString();
        }
      }
      else if ((paramObject instanceof Double))
      {
        if (((Double)paramObject).doubleValue() == 0.0D) {
          paramObject = "";
        } else {
          paramObject = paramObject.toString();
        }
      }
      else if ((paramObject instanceof Boolean))
      {
        if (!((Boolean)paramObject).booleanValue()) {
          paramObject = "";
        } else {
          paramObject = paramObject.toString();
        }
      }
      else
      {
        StringBuffer localStringBuffer;
        int i;
        Object localObject;
        if ((paramObject instanceof List))
        {
          localStringBuffer = new StringBuffer();
          if (paramInt > 0) {
            localStringBuffer.append("[");
          }
          paramObject = (List)paramObject;
          i = localStringBuffer.length();
          localObject = ((List)paramObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            paramObject = ((Iterator)localObject).next();
            if (localStringBuffer.length() > i) {
              localStringBuffer.append(", ");
            }
            localStringBuffer.append(zza(paramObject, paramInt + 1));
          }
          if (paramInt > 0) {
            localStringBuffer.append("]");
          }
          paramObject = localStringBuffer.toString();
        }
        else if ((paramObject instanceof Map))
        {
          localStringBuffer = new StringBuffer();
          paramObject = new TreeMap((Map)paramObject).entrySet().iterator();
          int k = 0;
          int j = 0;
          while (((Iterator)paramObject).hasNext())
          {
            localObject = (Map.Entry)((Iterator)paramObject).next();
            String str = zza(((Map.Entry)localObject).getValue(), paramInt + 1);
            if (!TextUtils.isEmpty(str))
            {
              int m = k;
              i = j;
              if (paramInt > 0)
              {
                m = k;
                i = j;
                if (j == 0)
                {
                  localStringBuffer.append("{");
                  i = 1;
                  m = localStringBuffer.length();
                }
              }
              if (localStringBuffer.length() > m) {
                localStringBuffer.append(", ");
              }
              localStringBuffer.append((String)((Map.Entry)localObject).getKey());
              localStringBuffer.append('=');
              localStringBuffer.append(str);
              k = m;
              j = i;
            }
          }
          if (j != 0) {
            localStringBuffer.append("}");
          }
          paramObject = localStringBuffer.toString();
        }
        else
        {
          paramObject = paramObject.toString();
        }
      }
    }
  }
  
  public static String zzar(Map paramMap)
  {
    return zza(paramMap, 1);
  }
  
  public static String zzj(Object paramObject)
  {
    return zza(paramObject, 0);
  }
  
  public abstract void zzb(T paramT);
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */