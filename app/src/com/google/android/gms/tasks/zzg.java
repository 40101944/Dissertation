package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

class zzg<TResult>
{
  private Queue<zzf<TResult>> aMQ;
  private boolean aMR;
  private final Object zzako = new Object();
  
  public void zza(@NonNull Task<TResult> paramTask)
  {
    for (;;)
    {
      zzf localzzf;
      synchronized (this.zzako)
      {
        if ((this.aMQ == null) || (this.aMR)) {
          return;
        }
        this.aMR = true;
        synchronized (this.zzako)
        {
          localzzf = (zzf)this.aMQ.poll();
          if (localzzf == null) {
            this.aMR = false;
          }
        }
      }
      localzzf.onComplete(paramTask);
    }
  }
  
  public void zza(@NonNull zzf<TResult> paramzzf)
  {
    synchronized (this.zzako)
    {
      if (this.aMQ == null)
      {
        ArrayDeque localArrayDeque = new java/util/ArrayDeque;
        localArrayDeque.<init>();
        this.aMQ = localArrayDeque;
      }
      this.aMQ.add(paramzzf);
      return;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tasks\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */