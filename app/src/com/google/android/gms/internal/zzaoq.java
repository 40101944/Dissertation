package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.util.Locale;

public enum zzaoq
  implements zzaor
{
  private zzaoq() {}
  
  private static String zza(char paramChar, String paramString, int paramInt)
  {
    if (paramInt < paramString.length()) {
      paramString = String.valueOf(paramString.substring(paramInt));
    }
    for (paramString = String.valueOf(paramString).length() + 1 + paramChar + paramString;; paramString = String.valueOf(paramChar)) {
      return paramString;
    }
  }
  
  private static String zzbz(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramString1.length(); i++)
    {
      char c = paramString1.charAt(i);
      if ((Character.isUpperCase(c)) && (localStringBuilder.length() != 0)) {
        localStringBuilder.append(paramString2);
      }
      localStringBuilder.append(c);
    }
    return localStringBuilder.toString();
  }
  
  private static String zzum(String paramString)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    char c = paramString.charAt(0);
    String str;
    if ((i >= paramString.length() - 1) || (Character.isLetter(c)))
    {
      if (i != paramString.length()) {
        break label69;
      }
      str = localStringBuilder.toString();
    }
    for (;;)
    {
      return str;
      localStringBuilder.append(c);
      i++;
      c = paramString.charAt(i);
      break;
      label69:
      str = paramString;
      if (!Character.isUpperCase(c)) {
        str = zza(Character.toUpperCase(c), paramString, i + 1);
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaoq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */