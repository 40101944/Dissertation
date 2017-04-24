package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T>
  extends AbstractDataBuffer<T>
{
  private boolean Cl = false;
  private ArrayList<Integer> Cm;
  
  protected zzf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void zzaur()
  {
    int i;
    Object localObject4;
    try
    {
      if (this.Cl) {
        break label222;
      }
      int j = this.zy.getCount();
      Object localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>();
      this.Cm = ((ArrayList)localObject1);
      if (j <= 0) {
        break label217;
      }
      this.Cm.add(Integer.valueOf(0));
      String str = zzauq();
      i = this.zy.zzga(0);
      localObject1 = this.zy.zzd(str, 0, i);
      i = 1;
      if (i >= j) {
        break label217;
      }
      int k = this.zy.zzga(i);
      localObject4 = this.zy.zzd(str, i, k);
      if (localObject4 == null)
      {
        localObject1 = new java/lang/NullPointerException;
        localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>(String.valueOf(str).length() + 78);
        ((NullPointerException)localObject1).<init>("Missing value for markerColumn: " + str + ", at row: " + i + ", for window: " + k);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    if (!((String)localObject4).equals(localObject2))
    {
      this.Cm.add(Integer.valueOf(i));
      Object localObject3 = localObject4;
    }
    for (;;)
    {
      i++;
      break;
      label217:
      this.Cl = true;
      label222:
      return;
    }
  }
  
  public final T get(int paramInt)
  {
    zzaur();
    return (T)zzn(zzge(paramInt), zzgf(paramInt));
  }
  
  public int getCount()
  {
    zzaur();
    return this.Cm.size();
  }
  
  protected abstract String zzauq();
  
  protected String zzaus()
  {
    return null;
  }
  
  int zzge(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Cm.size())) {
      throw new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.Cm.get(paramInt)).intValue();
  }
  
  protected int zzgf(int paramInt)
  {
    int i;
    if ((paramInt < 0) || (paramInt == this.Cm.size()))
    {
      i = 0;
      return i;
    }
    if (paramInt == this.Cm.size() - 1) {}
    for (int j = this.zy.getCount() - ((Integer)this.Cm.get(paramInt)).intValue();; j = ((Integer)this.Cm.get(paramInt + 1)).intValue() - ((Integer)this.Cm.get(paramInt)).intValue())
    {
      i = j;
      if (j != 1) {
        break;
      }
      int k = zzge(paramInt);
      paramInt = this.zy.zzga(k);
      String str = zzaus();
      i = j;
      if (str == null) {
        break;
      }
      i = j;
      if (this.zy.zzd(str, k, paramInt) != null) {
        break;
      }
      i = 0;
      break;
    }
  }
  
  protected abstract T zzn(int paramInt1, int paramInt2);
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\data\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */