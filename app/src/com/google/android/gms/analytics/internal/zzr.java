package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import java.util.HashSet;
import java.util.Set;

public class zzr
{
  private final zzf ao;
  private volatile Boolean eb;
  private String ec;
  private Set<Integer> ed;
  
  protected zzr(zzf paramzzf)
  {
    zzaa.zzy(paramzzf);
    this.ao = paramzzf;
  }
  
  /* Error */
  public boolean zzaef()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/google/android/gms/analytics/internal/zzr:eb	Ljava/lang/Boolean;
    //   4: ifnonnull +119 -> 123
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 31	com/google/android/gms/analytics/internal/zzr:eb	Ljava/lang/Boolean;
    //   13: ifnonnull +108 -> 121
    //   16: aload_0
    //   17: getfield 26	com/google/android/gms/analytics/internal/zzr:ao	Lcom/google/android/gms/analytics/internal/zzf;
    //   20: invokevirtual 37	com/google/android/gms/analytics/internal/zzf:getContext	()Landroid/content/Context;
    //   23: invokevirtual 43	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: astore_3
    //   27: invokestatic 49	com/google/android/gms/common/util/zzt:zzayz	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_3
    //   32: ifnull +30 -> 62
    //   35: aload_3
    //   36: getfield 54	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +90 -> 131
    //   44: aload_3
    //   45: aload_2
    //   46: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +82 -> 131
    //   52: iconst_1
    //   53: istore_1
    //   54: aload_0
    //   55: iload_1
    //   56: invokestatic 66	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: putfield 31	com/google/android/gms/analytics/internal/zzr:eb	Ljava/lang/Boolean;
    //   62: aload_0
    //   63: getfield 31	com/google/android/gms/analytics/internal/zzr:eb	Ljava/lang/Boolean;
    //   66: ifnull +13 -> 79
    //   69: aload_0
    //   70: getfield 31	com/google/android/gms/analytics/internal/zzr:eb	Ljava/lang/Boolean;
    //   73: invokevirtual 69	java/lang/Boolean:booleanValue	()Z
    //   76: ifne +19 -> 95
    //   79: ldc 71
    //   81: aload_2
    //   82: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +10 -> 95
    //   88: aload_0
    //   89: getstatic 74	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   92: putfield 31	com/google/android/gms/analytics/internal/zzr:eb	Ljava/lang/Boolean;
    //   95: aload_0
    //   96: getfield 31	com/google/android/gms/analytics/internal/zzr:eb	Ljava/lang/Boolean;
    //   99: ifnonnull +22 -> 121
    //   102: aload_0
    //   103: getstatic 74	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   106: putfield 31	com/google/android/gms/analytics/internal/zzr:eb	Ljava/lang/Boolean;
    //   109: aload_0
    //   110: getfield 26	com/google/android/gms/analytics/internal/zzr:ao	Lcom/google/android/gms/analytics/internal/zzf;
    //   113: invokevirtual 78	com/google/android/gms/analytics/internal/zzf:zzaca	()Lcom/google/android/gms/analytics/internal/zzaf;
    //   116: ldc 80
    //   118: invokevirtual 86	com/google/android/gms/analytics/internal/zzaf:zzew	(Ljava/lang/String;)V
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_0
    //   124: getfield 31	com/google/android/gms/analytics/internal/zzr:eb	Ljava/lang/Boolean;
    //   127: invokevirtual 69	java/lang/Boolean:booleanValue	()Z
    //   130: ireturn
    //   131: iconst_0
    //   132: istore_1
    //   133: goto -79 -> 54
    //   136: astore_2
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_2
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	zzr
    //   53	80	1	bool	boolean
    //   30	52	2	str	String
    //   136	4	2	localObject1	Object
    //   26	19	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	31	136	finally
    //   35	40	136	finally
    //   44	52	136	finally
    //   54	62	136	finally
    //   62	79	136	finally
    //   79	95	136	finally
    //   95	121	136	finally
    //   121	123	136	finally
    //   137	139	136	finally
  }
  
  public boolean zzaeg()
  {
    return ((Boolean)zzy.em.get()).booleanValue();
  }
  
  public int zzaeh()
  {
    return ((Integer)zzy.eF.get()).intValue();
  }
  
  public int zzaei()
  {
    return ((Integer)zzy.eJ.get()).intValue();
  }
  
  public int zzaej()
  {
    return ((Integer)zzy.eK.get()).intValue();
  }
  
  public int zzaek()
  {
    return ((Integer)zzy.eL.get()).intValue();
  }
  
  public long zzael()
  {
    return ((Long)zzy.eu.get()).longValue();
  }
  
  public long zzaem()
  {
    return ((Long)zzy.et.get()).longValue();
  }
  
  public long zzaen()
  {
    return ((Long)zzy.ex.get()).longValue();
  }
  
  public long zzaeo()
  {
    return ((Long)zzy.ey.get()).longValue();
  }
  
  public int zzaep()
  {
    return ((Integer)zzy.ez.get()).intValue();
  }
  
  public int zzaeq()
  {
    return ((Integer)zzy.eA.get()).intValue();
  }
  
  public long zzaer()
  {
    return ((Integer)zzy.eN.get()).intValue();
  }
  
  public String zzaes()
  {
    return (String)zzy.eC.get();
  }
  
  public String zzaet()
  {
    return (String)zzy.eB.get();
  }
  
  public String zzaeu()
  {
    return (String)zzy.eD.get();
  }
  
  public String zzaev()
  {
    return (String)zzy.eE.get();
  }
  
  public zzm zzaew()
  {
    return zzm.zzfb((String)zzy.eG.get());
  }
  
  public zzo zzaex()
  {
    return zzo.zzfc((String)zzy.eH.get());
  }
  
  public Set<Integer> zzaey()
  {
    String str1 = (String)zzy.eM.get();
    String[] arrayOfString;
    HashSet localHashSet;
    int j;
    int i;
    if ((this.ed == null) || (this.ec == null) || (!this.ec.equals(str1)))
    {
      arrayOfString = TextUtils.split(str1, ",");
      localHashSet = new HashSet();
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      String str2;
      if (i < j) {
        str2 = arrayOfString[i];
      }
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str2)));
        i++;
        continue;
        this.ec = str1;
        this.ed = localHashSet;
        return this.ed;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
  }
  
  public long zzaez()
  {
    return ((Long)zzy.eV.get()).longValue();
  }
  
  public long zzafa()
  {
    return ((Long)zzy.eW.get()).longValue();
  }
  
  public long zzafb()
  {
    return ((Long)zzy.eZ.get()).longValue();
  }
  
  public int zzafc()
  {
    return ((Integer)zzy.eq.get()).intValue();
  }
  
  public int zzafd()
  {
    return ((Integer)zzy.es.get()).intValue();
  }
  
  public String zzafe()
  {
    return "google_analytics_v4.db";
  }
  
  public String zzaff()
  {
    return "google_analytics2_v4.db";
  }
  
  public int zzafg()
  {
    return ((Integer)zzy.eP.get()).intValue();
  }
  
  public int zzafh()
  {
    return ((Integer)zzy.eQ.get()).intValue();
  }
  
  public long zzafi()
  {
    return ((Long)zzy.eR.get()).longValue();
  }
  
  public long zzafj()
  {
    return ((Long)zzy.fa.get()).longValue();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */