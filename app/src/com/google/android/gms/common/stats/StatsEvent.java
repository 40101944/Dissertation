package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public abstract int getEventType();
  
  public abstract long getTimeMillis();
  
  public String toString()
  {
    long l2 = getTimeMillis();
    String str3 = String.valueOf("\t");
    int i = getEventType();
    String str1 = String.valueOf("\t");
    long l1 = zzaxt();
    String str2 = String.valueOf(zzaxu());
    return String.valueOf(str3).length() + 51 + String.valueOf(str1).length() + String.valueOf(str2).length() + l2 + str3 + i + str1 + l1 + str2;
  }
  
  public abstract long zzaxt();
  
  public abstract String zzaxu();
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\stats\StatsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */