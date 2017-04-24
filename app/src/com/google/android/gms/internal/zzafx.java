package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzafx
{
  public static final Integer aMD = Integer.valueOf(0);
  public static final Integer aME = Integer.valueOf(1);
  private final ExecutorService aGI;
  private final Context mContext;
  
  public zzafx(Context paramContext)
  {
    this(paramContext, Executors.newSingleThreadExecutor());
  }
  
  zzafx(Context paramContext, ExecutorService paramExecutorService)
  {
    this.mContext = paramContext;
    this.aGI = paramExecutorService;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzafx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */