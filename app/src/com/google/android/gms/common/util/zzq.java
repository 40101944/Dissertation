package com.google.android.gms.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class zzq
{
  public static void zza(StringBuilder paramStringBuilder, HashMap<String, String> paramHashMap)
  {
    paramStringBuilder.append("{");
    Iterator localIterator = paramHashMap.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      label50:
      String str1;
      if (i == 0)
      {
        paramStringBuilder.append(",");
        str1 = (String)paramHashMap.get(str2);
        paramStringBuilder.append("\"").append(str2).append("\":");
        if (str1 != null) {
          break label98;
        }
        paramStringBuilder.append("null");
      }
      for (;;)
      {
        break;
        i = 0;
        break label50;
        label98:
        paramStringBuilder.append("\"").append(str1).append("\"");
      }
    }
    paramStringBuilder.append("}");
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\util\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */