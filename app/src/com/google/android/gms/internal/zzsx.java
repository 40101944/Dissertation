package com.google.android.gms.internal;

import android.os.Process;

class zzsx
  implements Runnable
{
  private final int mPriority;
  private final Runnable zzw;
  
  public zzsx(Runnable paramRunnable, int paramInt)
  {
    this.zzw = paramRunnable;
    this.mPriority = paramInt;
  }
  
  public void run()
  {
    Process.setThreadPriority(this.mPriority);
    this.zzw.run();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzsx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */