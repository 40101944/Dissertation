package com.google.android.gms.internal;

public abstract class zzsi<T>
{
  private static zza BL = null;
  private static int BM = 0;
  private static String READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";
  private static final Object zzaox = new Object();
  private T BN = null;
  protected final String zzbcn;
  protected final T zzbco;
  
  protected zzsi(String paramString, T paramT)
  {
    this.zzbcn = paramString;
    this.zzbco = paramT;
  }
  
  public static zzsi<Float> zza(String paramString, Float paramFloat)
  {
    new zzsi(paramString, paramFloat)
    {
      protected Float zzhm(String paramAnonymousString)
      {
        return zzsi.zzauh().zzb(this.zzbcn, (Float)this.zzbco);
      }
    };
  }
  
  public static zzsi<Integer> zza(String paramString, Integer paramInteger)
  {
    new zzsi(paramString, paramInteger)
    {
      protected Integer zzhl(String paramAnonymousString)
      {
        return zzsi.zzauh().zzb(this.zzbcn, (Integer)this.zzbco);
      }
    };
  }
  
  public static zzsi<Long> zza(String paramString, Long paramLong)
  {
    new zzsi(paramString, paramLong)
    {
      protected Long zzhk(String paramAnonymousString)
      {
        return zzsi.zzauh().getLong(this.zzbcn, (Long)this.zzbco);
      }
    };
  }
  
  public static zzsi<String> zzaa(String paramString1, String paramString2)
  {
    new zzsi(paramString1, paramString2)
    {
      protected String zzhn(String paramAnonymousString)
      {
        return zzsi.zzauh().getString(this.zzbcn, (String)this.zzbco);
      }
    };
  }
  
  public static zzsi<Boolean> zzk(String paramString, boolean paramBoolean)
  {
    new zzsi(paramString, Boolean.valueOf(paramBoolean))
    {
      protected Boolean zzhj(String paramAnonymousString)
      {
        return zzsi.zzauh().zza(this.zzbcn, (Boolean)this.zzbco);
      }
    };
  }
  
  /* Error */
  public final T get()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 51	com/google/android/gms/internal/zzsi:zzbcn	Ljava/lang/String;
    //   5: invokevirtual 98	com/google/android/gms/internal/zzsi:zzhi	(Ljava/lang/String;)Ljava/lang/Object;
    //   8: astore_3
    //   9: aload_3
    //   10: areturn
    //   11: astore_3
    //   12: invokestatic 104	android/os/Binder:clearCallingIdentity	()J
    //   15: lstore_1
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 51	com/google/android/gms/internal/zzsi:zzbcn	Ljava/lang/String;
    //   21: invokevirtual 98	com/google/android/gms/internal/zzsi:zzhi	(Ljava/lang/String;)Ljava/lang/Object;
    //   24: astore_3
    //   25: lload_1
    //   26: invokestatic 108	android/os/Binder:restoreCallingIdentity	(J)V
    //   29: goto -20 -> 9
    //   32: astore_3
    //   33: lload_1
    //   34: invokestatic 108	android/os/Binder:restoreCallingIdentity	(J)V
    //   37: aload_3
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	zzsi
    //   15	19	1	l	long
    //   8	2	3	localObject1	Object
    //   11	1	3	localSecurityException	SecurityException
    //   24	1	3	localObject2	Object
    //   32	6	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	9	11	java/lang/SecurityException
    //   16	25	32	finally
  }
  
  protected abstract T zzhi(String paramString);
  
  private static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);
    
    public abstract String getString(String paramString1, String paramString2);
    
    public abstract Boolean zza(String paramString, Boolean paramBoolean);
    
    public abstract Float zzb(String paramString, Float paramFloat);
    
    public abstract Integer zzb(String paramString, Integer paramInteger);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzsi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */