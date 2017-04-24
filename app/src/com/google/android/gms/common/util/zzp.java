package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzp
{
  private static final Pattern GC = Pattern.compile("\\\\.");
  private static final Pattern GD = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
  
  public static boolean zzf(Object paramObject1, Object paramObject2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramObject1 == null) && (paramObject2 == null)) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject1 != null)
      {
        bool1 = bool2;
        if (paramObject2 != null)
        {
          JSONObject localJSONObject;
          label74:
          String str;
          if (((paramObject1 instanceof JSONObject)) && ((paramObject2 instanceof JSONObject)))
          {
            paramObject1 = (JSONObject)paramObject1;
            localJSONObject = (JSONObject)paramObject2;
            bool1 = bool2;
            if (((JSONObject)paramObject1).length() != localJSONObject.length()) {
              continue;
            }
            paramObject2 = ((JSONObject)paramObject1).keys();
            if (((Iterator)paramObject2).hasNext())
            {
              str = (String)((Iterator)paramObject2).next();
              bool1 = bool2;
              if (!localJSONObject.has(str)) {
                continue;
              }
            }
          }
          try
          {
            bool1 = zzf(((JSONObject)paramObject1).get(str), localJSONObject.get(str));
            if (bool1) {
              break label74;
            }
            bool1 = bool2;
          }
          catch (JSONException paramObject1)
          {
            int i;
            bool1 = bool2;
          }
          bool1 = true;
          continue;
          if (((paramObject1 instanceof JSONArray)) && ((paramObject2 instanceof JSONArray)))
          {
            paramObject1 = (JSONArray)paramObject1;
            paramObject2 = (JSONArray)paramObject2;
            bool1 = bool2;
            if (((JSONArray)paramObject1).length() != ((JSONArray)paramObject2).length()) {
              continue;
            }
            i = 0;
            if (i >= ((JSONArray)paramObject1).length()) {}
          }
          try
          {
            boolean bool3 = zzf(((JSONArray)paramObject1).get(i), ((JSONArray)paramObject2).get(i));
            bool1 = bool2;
            if (!bool3) {
              continue;
            }
            i++;
          }
          catch (JSONException paramObject1)
          {
            bool1 = bool2;
          }
          bool1 = true;
          continue;
          bool1 = paramObject1.equals(paramObject2);
          continue;
        }
      }
    }
  }
  
  public static String zzii(String paramString)
  {
    Object localObject1 = paramString;
    Matcher localMatcher;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localMatcher = GD.matcher(paramString);
      localObject2 = null;
      while (localMatcher.find())
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new StringBuffer();
        }
        switch (localMatcher.group().charAt(0))
        {
        default: 
          localObject2 = localObject1;
          break;
        case '\b': 
          localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\b");
          localObject2 = localObject1;
          break;
        case '"': 
          localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\\\\"");
          localObject2 = localObject1;
          break;
        case '\\': 
          localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\\\\\");
          localObject2 = localObject1;
          break;
        case '/': 
          localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\/");
          localObject2 = localObject1;
          break;
        case '\f': 
          localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\f");
          localObject2 = localObject1;
          break;
        case '\n': 
          localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\n");
          localObject2 = localObject1;
          break;
        case '\r': 
          localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\r");
          localObject2 = localObject1;
          break;
        case '\t': 
          localMatcher.appendReplacement((StringBuffer)localObject1, "\\\\t");
          localObject2 = localObject1;
        }
      }
      if (localObject2 != null) {
        break label241;
      }
    }
    for (localObject1 = paramString;; localObject1 = ((StringBuffer)localObject2).toString())
    {
      return (String)localObject1;
      label241:
      localMatcher.appendTail((StringBuffer)localObject2);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\util\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */