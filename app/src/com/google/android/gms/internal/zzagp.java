package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzagp
{
  public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  public static final Uri aVg = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  public static final Pattern aVh = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static final Pattern aVi = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  private static final AtomicBoolean aVj = new AtomicBoolean();
  static HashMap<String, String> aVk;
  private static Object aVl;
  private static boolean aVm;
  static String[] aVn = new String[0];
  
  public static long getLong(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    paramContentResolver = getString(paramContentResolver, paramString);
    long l = paramLong;
    if (paramContentResolver != null) {}
    try
    {
      l = Long.parseLong(paramContentResolver);
      return l;
    }
    catch (NumberFormatException paramContentResolver)
    {
      for (;;)
      {
        l = paramLong;
      }
    }
  }
  
  @Deprecated
  public static String getString(ContentResolver paramContentResolver, String paramString)
  {
    return zza(paramContentResolver, paramString, null);
  }
  
  public static String zza(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      int i;
      try
      {
        zza(paramContentResolver);
        localObject2 = aVl;
        if (aVk.containsKey(paramString1))
        {
          paramString1 = (String)aVk.get(paramString1);
          paramContentResolver = paramString2;
          if (paramString1 != null) {
            paramContentResolver = paramString1;
          }
          return paramContentResolver;
        }
        localObject1 = aVn;
        int j = localObject1.length;
        i = 0;
        if (i >= j) {
          break label152;
        }
        if (!paramString1.startsWith(localObject1[i])) {
          break label146;
        }
        if ((!aVm) || (aVk.isEmpty()))
        {
          zzc(paramContentResolver, aVn);
          if (aVk.containsKey(paramString1))
          {
            paramString1 = (String)aVk.get(paramString1);
            paramContentResolver = paramString2;
            if (paramString1 != null) {
              paramContentResolver = paramString1;
            }
            continue;
          }
        }
      }
      finally {}
      paramContentResolver = paramString2;
      continue;
      label146:
      i++;
      continue;
      label152:
      Cursor localCursor = paramContentResolver.query(CONTENT_URI, null, null, new String[] { paramString1 }, null);
      if (localCursor != null) {}
      try
      {
        if (!localCursor.moveToFirst())
        {
          zza(localObject2, paramString1, null);
          paramContentResolver = paramString2;
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
          paramContentResolver = paramString2;
          continue;
        }
        localObject1 = localCursor.getString(1);
        paramContentResolver = (ContentResolver)localObject1;
        if (localObject1 != null)
        {
          paramContentResolver = (ContentResolver)localObject1;
          if (((String)localObject1).equals(paramString2)) {
            paramContentResolver = paramString2;
          }
        }
        zza(localObject2, paramString1, paramContentResolver);
        if (paramContentResolver != null) {
          paramString2 = paramContentResolver;
        }
        paramContentResolver = paramString2;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        paramContentResolver = paramString2;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
  }
  
  public static Map<String, String> zza(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    paramContentResolver = paramContentResolver.query(aVg, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null) {}
    for (;;)
    {
      return paramVarArgs;
      try
      {
        while (paramContentResolver.moveToNext()) {
          paramVarArgs.put(paramContentResolver.getString(0), paramContentResolver.getString(1));
        }
      }
      finally
      {
        paramContentResolver.close();
      }
    }
  }
  
  private static void zza(ContentResolver paramContentResolver)
  {
    if (aVk == null)
    {
      aVj.set(false);
      aVk = new HashMap();
      aVl = new Object();
      aVm = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new ContentObserver(new Handler(Looper.getMainLooper()))
      {
        public void onChange(boolean paramAnonymousBoolean)
        {
          zzagp.zzcng().set(true);
        }
      });
    }
    for (;;)
    {
      return;
      if (aVj.getAndSet(false))
      {
        aVk.clear();
        aVl = new Object();
        aVm = false;
      }
    }
  }
  
  private static void zza(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == aVl) {
        aVk.put(paramString1, paramString2);
      }
      return;
    }
    finally {}
  }
  
  public static void zzb(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return;
    }
    for (;;)
    {
      try
      {
        zza(paramContentResolver);
        paramVarArgs = zzk(paramVarArgs);
        if ((!aVm) || (aVk.isEmpty()))
        {
          zzc(paramContentResolver, aVn);
          break;
        }
      }
      finally {}
      if (paramVarArgs.length != 0) {
        zzc(paramContentResolver, paramVarArgs);
      }
    }
  }
  
  private static void zzc(ContentResolver paramContentResolver, String[] paramArrayOfString)
  {
    aVk.putAll(zza(paramContentResolver, paramArrayOfString));
    aVm = true;
  }
  
  private static String[] zzk(String[] paramArrayOfString)
  {
    HashSet localHashSet = new HashSet((aVn.length + paramArrayOfString.length) * 4 / 3 + 1);
    localHashSet.addAll(Arrays.asList(aVn));
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++)
    {
      String str = paramArrayOfString[i];
      if (localHashSet.add(str)) {
        localArrayList.add(str);
      }
    }
    if (localArrayList.isEmpty()) {}
    for (paramArrayOfString = new String[0];; paramArrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]))
    {
      return paramArrayOfString;
      aVn = (String[])localHashSet.toArray(new String[localHashSet.size()]);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzagp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */