package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.analytics.internal.zzae;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StandardExceptionParser
  implements ExceptionParser
{
  private final TreeSet<String> bt = new TreeSet();
  
  public StandardExceptionParser(Context paramContext, Collection<String> paramCollection)
  {
    setIncludedPackages(paramContext, paramCollection);
  }
  
  protected StackTraceElement getBestStackTraceElement(Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length == 0)) {
      paramThrowable = null;
    }
    for (;;)
    {
      return paramThrowable;
      int j = arrayOfStackTraceElement.length;
      for (int i = 0;; i++)
      {
        if (i >= j) {
          break label89;
        }
        paramThrowable = arrayOfStackTraceElement[i];
        String str = paramThrowable.getClassName();
        Iterator localIterator = this.bt.iterator();
        for (;;)
        {
          if (localIterator.hasNext()) {
            if (str.startsWith((String)localIterator.next())) {
              break;
            }
          }
        }
      }
      label89:
      paramThrowable = arrayOfStackTraceElement[0];
    }
  }
  
  protected Throwable getCause(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return paramThrowable;
  }
  
  public String getDescription(String paramString, Throwable paramThrowable)
  {
    return getDescription(getCause(paramThrowable), getBestStackTraceElement(getCause(paramThrowable)), paramString);
  }
  
  protected String getDescription(Throwable paramThrowable, StackTraceElement paramStackTraceElement, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getClass().getSimpleName());
    if (paramStackTraceElement != null)
    {
      String[] arrayOfString = paramStackTraceElement.getClassName().split("\\.");
      String str = "unknown";
      paramThrowable = str;
      if (arrayOfString != null)
      {
        paramThrowable = str;
        if (arrayOfString.length > 0) {
          paramThrowable = arrayOfString[(arrayOfString.length - 1)];
        }
      }
      localStringBuilder.append(String.format(" (@%s:%s:%s)", new Object[] { paramThrowable, paramStackTraceElement.getMethodName(), Integer.valueOf(paramStackTraceElement.getLineNumber()) }));
    }
    if (paramString != null) {
      localStringBuilder.append(String.format(" {%s}", new Object[] { paramString }));
    }
    return localStringBuilder.toString();
  }
  
  public void setIncludedPackages(Context paramContext, Collection<String> paramCollection)
  {
    this.bt.clear();
    Object localObject = new HashSet();
    if (paramCollection != null) {
      ((Set)localObject).addAll(paramCollection);
    }
    int i;
    if (paramContext != null) {
      try
      {
        paramCollection = paramContext.getApplicationContext().getPackageName();
        this.bt.add(paramCollection);
        paramContext = paramContext.getApplicationContext().getPackageManager().getPackageInfo(paramCollection, 1).activities;
        if (paramContext != null)
        {
          int j = paramContext.length;
          for (i = 0; i < j; i++) {
            ((Set)localObject).add(paramContext[i].packageName);
          }
        }
        paramContext = ((Set)localObject).iterator();
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        zzae.zzdh("No package found");
      }
    }
    if (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      paramCollection = this.bt.iterator();
      for (i = 1;; i = 0)
      {
        if (paramCollection.hasNext())
        {
          String str = (String)paramCollection.next();
          if (((String)localObject).startsWith(str)) {
            continue;
          }
          if (str.startsWith((String)localObject)) {
            this.bt.remove(str);
          }
        }
        if (i == 0) {
          break;
        }
        this.bt.add(localObject);
        break;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\StandardExceptionParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */