package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.internal.zzae;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private final Thread.UncaughtExceptionHandler aD;
  private final Tracker aE;
  private ExceptionParser aF;
  private GoogleAnalytics aG;
  private final Context mContext;
  
  public ExceptionReporter(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.aD = paramUncaughtExceptionHandler;
    this.aE = paramTracker;
    this.aF = new StandardExceptionParser(paramContext, new ArrayList());
    this.mContext = paramContext.getApplicationContext();
    if (paramUncaughtExceptionHandler == null)
    {
      paramTracker = "null";
      paramTracker = String.valueOf(paramTracker);
      if (paramTracker.length() == 0) {
        break label111;
      }
    }
    label111:
    for (paramTracker = "ExceptionReporter created, original handler is ".concat(paramTracker);; paramTracker = new String("ExceptionReporter created, original handler is "))
    {
      zzae.v(paramTracker);
      return;
      paramTracker = paramUncaughtExceptionHandler.getClass().getName();
      break;
    }
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.aF;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.aF = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject = "UncaughtException";
    if (this.aF != null)
    {
      if (paramThread != null)
      {
        localObject = paramThread.getName();
        localObject = this.aF.getDescription((String)localObject, paramThrowable);
      }
    }
    else
    {
      str = String.valueOf(localObject);
      if (str.length() == 0) {
        break label126;
      }
    }
    label126:
    for (String str = "Reporting uncaught exception: ".concat(str);; str = new String("Reporting uncaught exception: "))
    {
      zzae.v(str);
      this.aE.send(new HitBuilders.ExceptionBuilder().setDescription((String)localObject).setFatal(true).build());
      localObject = zzza();
      ((GoogleAnalytics)localObject).dispatchLocalHits();
      ((GoogleAnalytics)localObject).zzzf();
      if (this.aD != null)
      {
        zzae.v("Passing exception to the original handler");
        this.aD.uncaughtException(paramThread, paramThrowable);
      }
      return;
      localObject = null;
      break;
    }
  }
  
  GoogleAnalytics zzza()
  {
    if (this.aG == null) {
      this.aG = GoogleAnalytics.getInstance(this.mContext);
    }
    return this.aG;
  }
  
  Thread.UncaughtExceptionHandler zzzb()
  {
    return this.aD;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\ExceptionReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */