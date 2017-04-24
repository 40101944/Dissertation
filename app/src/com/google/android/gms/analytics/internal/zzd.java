package com.google.android.gms.analytics.internal;

public abstract class zzd
  extends zzc
{
  private boolean cR;
  
  protected zzd(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public void initialize()
  {
    zzzy();
    this.cR = true;
  }
  
  public boolean isInitialized()
  {
    if (this.cR) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void zzacj()
  {
    if (!isInitialized()) {
      throw new IllegalStateException("Not initialized");
    }
  }
  
  protected abstract void zzzy();
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */