package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.dynamic.zze;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public final class zztl
{
  private static zztm Qh;
  private static final HashMap<String, byte[]> Qi = new HashMap();
  private static String Qj;
  private static final zztl.zzb.zza Qk = new zztl.zzb.zza()
  {
    public zztl zza(Context paramAnonymousContext, String paramAnonymousString, int paramAnonymousInt)
      throws zztl.zza
    {
      return zztl.zzc(paramAnonymousContext, paramAnonymousString, paramAnonymousInt);
    }
    
    public int zzaa(Context paramAnonymousContext, String paramAnonymousString)
    {
      return zztl.zzaa(paramAnonymousContext, paramAnonymousString);
    }
    
    public int zzb(Context paramAnonymousContext, String paramAnonymousString, boolean paramAnonymousBoolean)
      throws zztl.zza
    {
      return zztl.zzb(paramAnonymousContext, paramAnonymousString, paramAnonymousBoolean);
    }
  };
  private static final zztl.zzb.zza Ql = new zztl.zzb.zza()
  {
    public zztl zza(Context paramAnonymousContext, String paramAnonymousString, int paramAnonymousInt)
      throws zztl.zza
    {
      return zztl.zzd(paramAnonymousContext, paramAnonymousString, paramAnonymousInt);
    }
    
    public int zzaa(Context paramAnonymousContext, String paramAnonymousString)
    {
      return zztl.zzaa(paramAnonymousContext, paramAnonymousString);
    }
    
    public int zzb(Context paramAnonymousContext, String paramAnonymousString, boolean paramAnonymousBoolean)
      throws zztl.zza
    {
      return zztl.zzc(paramAnonymousContext, paramAnonymousString, paramAnonymousBoolean);
    }
  };
  public static final zzb Qm = new zzb()
  {
    public zztl.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, zztl.zzb.zza paramAnonymouszza)
      throws zztl.zza
    {
      zztl.zzb.zzb localzzb = new zztl.zzb.zzb();
      localzzb.Qu = paramAnonymouszza.zzb(paramAnonymousContext, paramAnonymousString, true);
      if (localzzb.Qu != 0) {
        localzzb.Qv = 1;
      }
      for (;;)
      {
        return localzzb;
        localzzb.Qt = paramAnonymouszza.zzaa(paramAnonymousContext, paramAnonymousString);
        if (localzzb.Qt != 0) {
          localzzb.Qv = -1;
        }
      }
    }
  };
  public static final zzb Qn = new zzb()
  {
    public zztl.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, zztl.zzb.zza paramAnonymouszza)
      throws zztl.zza
    {
      zztl.zzb.zzb localzzb = new zztl.zzb.zzb();
      localzzb.Qt = paramAnonymouszza.zzaa(paramAnonymousContext, paramAnonymousString);
      if (localzzb.Qt != 0) {
        localzzb.Qv = -1;
      }
      for (;;)
      {
        return localzzb;
        localzzb.Qu = paramAnonymouszza.zzb(paramAnonymousContext, paramAnonymousString, true);
        if (localzzb.Qu != 0) {
          localzzb.Qv = 1;
        }
      }
    }
  };
  public static final zzb Qo = new zzb()
  {
    public zztl.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, zztl.zzb.zza paramAnonymouszza)
      throws zztl.zza
    {
      zztl.zzb.zzb localzzb = new zztl.zzb.zzb();
      localzzb.Qt = paramAnonymouszza.zzaa(paramAnonymousContext, paramAnonymousString);
      localzzb.Qu = paramAnonymouszza.zzb(paramAnonymousContext, paramAnonymousString, true);
      if ((localzzb.Qt == 0) && (localzzb.Qu == 0)) {
        localzzb.Qv = 0;
      }
      for (;;)
      {
        return localzzb;
        if (localzzb.Qt >= localzzb.Qu) {
          localzzb.Qv = -1;
        } else {
          localzzb.Qv = 1;
        }
      }
    }
  };
  public static final zzb Qp = new zzb()
  {
    public zztl.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, zztl.zzb.zza paramAnonymouszza)
      throws zztl.zza
    {
      zztl.zzb.zzb localzzb = new zztl.zzb.zzb();
      localzzb.Qt = paramAnonymouszza.zzaa(paramAnonymousContext, paramAnonymousString);
      localzzb.Qu = paramAnonymouszza.zzb(paramAnonymousContext, paramAnonymousString, true);
      if ((localzzb.Qt == 0) && (localzzb.Qu == 0)) {
        localzzb.Qv = 0;
      }
      for (;;)
      {
        return localzzb;
        if (localzzb.Qu >= localzzb.Qt) {
          localzzb.Qv = 1;
        } else {
          localzzb.Qv = -1;
        }
      }
    }
  };
  public static final zzb Qq = new zzb()
  {
    public zztl.zzb.zzb zza(Context paramAnonymousContext, String paramAnonymousString, zztl.zzb.zza paramAnonymouszza)
      throws zztl.zza
    {
      zztl.zzb.zzb localzzb = new zztl.zzb.zzb();
      localzzb.Qt = paramAnonymouszza.zzaa(paramAnonymousContext, paramAnonymousString);
      if (localzzb.Qt != 0)
      {
        localzzb.Qu = paramAnonymouszza.zzb(paramAnonymousContext, paramAnonymousString, false);
        if ((localzzb.Qt != 0) || (localzzb.Qu != 0)) {
          break label86;
        }
        localzzb.Qv = 0;
      }
      for (;;)
      {
        return localzzb;
        localzzb.Qu = paramAnonymouszza.zzb(paramAnonymousContext, paramAnonymousString, true);
        break;
        label86:
        if (localzzb.Qu >= localzzb.Qt) {
          localzzb.Qv = 1;
        } else {
          localzzb.Qv = -1;
        }
      }
    }
  };
  private final Context Qr;
  
  private zztl(Context paramContext)
  {
    this.Qr = ((Context)zzaa.zzy(paramContext));
  }
  
  private static Context zza(Context paramContext, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      Log.e("DynamiteModule", "No valid DynamiteLoader APK path");
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      paramString2 = new PathClassLoader(paramString2, paramContext.getClassLoader())
      {
        protected Class<?> loadClass(String paramAnonymousString, boolean paramAnonymousBoolean)
          throws ClassNotFoundException
        {
          if ((!paramAnonymousString.startsWith("java.")) && (!paramAnonymousString.startsWith("android."))) {}
          for (;;)
          {
            try
            {
              Class localClass = findClass(paramAnonymousString);
              paramAnonymousString = localClass;
              return paramAnonymousString;
            }
            catch (ClassNotFoundException localClassNotFoundException) {}
            paramAnonymousString = super.loadClass(paramAnonymousString, paramAnonymousBoolean);
          }
        }
      };
      try
      {
        paramContext = (Context)zze.zzae(zztn.zza.zzff((IBinder)paramString2.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0])).zza(zze.zzac(paramContext), paramString1, paramArrayOfByte));
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext = String.valueOf(paramContext.toString());
        if (paramContext.length() != 0) {}
        for (paramContext = "Failed to load DynamiteLoader: ".concat(paramContext);; paramContext = new String("Failed to load DynamiteLoader: "))
        {
          Log.e("DynamiteModule", paramContext);
          paramContext = null;
          break;
        }
      }
      catch (InstantiationException paramContext)
      {
        for (;;) {}
      }
      catch (RemoteException paramContext)
      {
        for (;;) {}
      }
      catch (IllegalAccessException paramContext)
      {
        for (;;) {}
      }
      catch (NoSuchMethodException paramContext)
      {
        for (;;) {}
      }
      catch (InvocationTargetException paramContext)
      {
        for (;;) {}
      }
    }
  }
  
  public static zztl zza(Context paramContext, zzb paramzzb, String paramString)
    throws zztl.zza
  {
    return zza(paramContext, paramzzb, paramString, Qk);
  }
  
  public static zztl zza(Context paramContext, zzb paramzzb, String paramString, zztl.zzb.zza paramzza)
    throws zztl.zza
  {
    zztl.zzb.zzb localzzb = paramzzb.zza(paramContext, paramString, paramzza);
    int i = localzzb.Qt;
    int j = localzzb.Qu;
    Log.i("DynamiteModule", String.valueOf(paramString).length() + 68 + String.valueOf(paramString).length() + "Considering local module " + paramString + ":" + i + " and remote module " + paramString + ":" + j);
    if ((localzzb.Qv == 0) || ((localzzb.Qv == -1) && (localzzb.Qt == 0)) || ((localzzb.Qv == 1) && (localzzb.Qu == 0)))
    {
      i = localzzb.Qt;
      j = localzzb.Qu;
      throw new zza(91 + "No acceptable module found. Local version is " + i + " and remote version is " + j + ".", null);
    }
    if (localzzb.Qv == -1) {
      paramContext = zzac(paramContext, paramString);
    }
    for (;;)
    {
      return paramContext;
      if (localzzb.Qv == 1) {
        try
        {
          paramzza = paramzza.zza(paramContext, paramString, localzzb.Qu);
          paramContext = paramzza;
        }
        catch (zza localzza)
        {
          paramzza = String.valueOf(localzza.getMessage());
          if (paramzza.length() != 0) {}
          for (paramzza = "Failed to load remote module: ".concat(paramzza);; paramzza = new String("Failed to load remote module: "))
          {
            Log.w("DynamiteModule", paramzza);
            if ((localzzb.Qt == 0) || (
            {
              public zztl zza(Context paramAnonymousContext, String paramAnonymousString, int paramAnonymousInt)
                throws zztl.zza
              {
                throw new zztl.zza("local only VersionPolicy should not load from remote", null);
              }
              
              public int zzaa(Context paramAnonymousContext, String paramAnonymousString)
              {
                return this.Qs;
              }
              
              public int zzb(Context paramAnonymousContext, String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                return 0;
              }
            } != -1)) {
              break label333;
            }
            paramContext = zzac(paramContext, paramString);
            break;
          }
          label333:
          throw new zza("Remote load failed. No local fallback found.", localzza, null);
        }
      }
    }
    i = localzzb.Qv;
    throw new zza(47 + "VersionPolicy returned invalid code:" + i, null);
  }
  
  private static zztl zza(Context paramContext, String paramString, int paramInt)
    throws zztl.zza
  {
    Log.i("DynamiteModule", String.valueOf(paramString).length() + 51 + "Selected remote version of " + paramString + ", version >= " + paramInt);
    zztm localzztm = zzcs(paramContext);
    if (localzztm == null) {
      throw new zza("Failed to create IDynamiteLoader.", null);
    }
    try
    {
      paramContext = localzztm.zza(zze.zzac(paramContext), paramString, paramInt);
      if (zze.zzae(paramContext) == null) {
        throw new zza("Failed to load remote module.", null);
      }
    }
    catch (RemoteException paramContext)
    {
      throw new zza("Failed to load remote module.", paramContext, null);
    }
    return new zztl((Context)zze.zzae(paramContext));
  }
  
  public static int zzaa(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        ClassLoader localClassLoader = paramContext.getApplicationContext().getClassLoader();
        String str = String.valueOf("com.google.android.gms.dynamite.descriptors.");
        localObject = String.valueOf("ModuleDescriptor");
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>(String.valueOf(str).length() + 1 + String.valueOf(paramString).length() + String.valueOf(localObject).length());
        localObject = localClassLoader.loadClass(str + paramString + "." + (String)localObject);
        paramContext = ((Class)localObject).getDeclaredField("MODULE_ID");
        localObject = ((Class)localObject).getDeclaredField("MODULE_VERSION");
        if (paramContext.get(null).equals(paramString)) {
          continue;
        }
        localObject = String.valueOf(paramContext.get(null));
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>(String.valueOf(localObject).length() + 51 + String.valueOf(paramString).length());
        Log.e("DynamiteModule", "Module descriptor id '" + (String)localObject + "' didn't match expected id '" + paramString + "'");
        i = 0;
      }
      catch (ClassNotFoundException paramContext)
      {
        Object localObject;
        Log.w("DynamiteModule", String.valueOf(paramString).length() + 45 + "Local module descriptor class for " + paramString + " not found.");
        int i = 0;
        continue;
      }
      catch (Exception paramContext)
      {
        paramContext = String.valueOf(paramContext.getMessage());
        if (paramContext.length() == 0) {
          break;
        }
      }
      return i;
      i = ((Field)localObject).getInt(null);
    }
    for (paramContext = "Failed to load module descriptor class: ".concat(paramContext);; paramContext = new String("Failed to load module descriptor class: "))
    {
      Log.e("DynamiteModule", paramContext);
      break;
    }
  }
  
  public static int zzab(Context paramContext, String paramString)
  {
    return zzb(paramContext, paramString, false);
  }
  
  private static zztl zzac(Context paramContext, String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "Selected local version of ".concat(paramString);; paramString = new String("Selected local version of "))
    {
      Log.i("DynamiteModule", paramString);
      return new zztl(paramContext.getApplicationContext());
    }
  }
  
  public static int zzb(Context paramContext, String paramString, boolean paramBoolean)
  {
    zztm localzztm = zzcs(paramContext);
    int i;
    if (localzztm == null) {
      i = 0;
    }
    for (;;)
    {
      return i;
      try
      {
        i = localzztm.zza(zze.zzac(paramContext), paramString, paramBoolean);
      }
      catch (RemoteException paramContext)
      {
        paramContext = String.valueOf(paramContext.getMessage());
        if (paramContext.length() == 0) {}
      }
    }
    for (paramContext = "Failed to retrieve remote module version: ".concat(paramContext);; paramContext = new String("Failed to retrieve remote module version: "))
    {
      Log.w("DynamiteModule", paramContext);
      i = 0;
      break;
    }
  }
  
  private static zztl zzb(Context paramContext, String paramString, int paramInt)
    throws zztl.zza
  {
    Log.i("DynamiteModule", String.valueOf(paramString).length() + 51 + "Selected remote version of " + paramString + ", version >= " + paramInt);
    Object localObject2;
    Object localObject1;
    try
    {
      localObject2 = Qi;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>(String.valueOf(paramString).length() + 12);
      localObject2 = (byte[])((HashMap)localObject2).get(paramString + ":" + paramInt);
      localObject1 = Qj;
      if (localObject2 == null) {
        throw new zza("Module implementation could not be found.", null);
      }
    }
    finally {}
    paramContext = zza(paramContext.getApplicationContext(), paramString, (byte[])localObject2, (String)localObject1);
    if (paramContext == null) {
      throw new zza("Failed to get module context", null);
    }
    return new zztl(paramContext);
  }
  
  public static int zzc(Context paramContext, String paramString, boolean paramBoolean)
    throws zztl.zza
  {
    if (paramBoolean) {}
    Object localObject2;
    for (Object localObject1 = "api_force_staging";; localObject1 = "api")
    {
      localObject2 = String.valueOf("content://com.google.android.gms.chimera/");
      localObject1 = Uri.parse(String.valueOf(localObject2).length() + 1 + String.valueOf(localObject1).length() + String.valueOf(paramString).length() + (String)localObject2 + (String)localObject1 + "/" + paramString);
      if (paramContext != null)
      {
        paramContext = paramContext.getContentResolver();
        if (paramContext != null) {
          break;
        }
      }
      throw new zza("Failed to get dynamite module ContentResolver.", null);
    }
    paramContext = paramContext.query((Uri)localObject1, null, null, null, null);
    if (paramContext != null) {}
    try
    {
      if (!paramContext.moveToFirst())
      {
        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
        paramString = new com/google/android/gms/internal/zztl$zza;
        paramString.<init>("Failed to connect to dynamite module ContentResolver.", null);
        throw paramString;
      }
    }
    finally
    {
      if (paramContext != null) {
        paramContext.close();
      }
    }
    int i = paramContext.getInt(0);
    if (i > 0) {}
    try
    {
      localObject1 = Qi;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>(String.valueOf(paramString).length() + 12);
      ((HashMap)localObject1).put(paramString + ":" + i, paramContext.getBlob(1));
      Qj = paramContext.getString(2);
      if (paramContext != null) {
        paramContext.close();
      }
      return i;
    }
    finally {}
  }
  
  /* Error */
  private static zztm zzcs(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 409	com/google/android/gms/internal/zztl:Qh	Lcom/google/android/gms/internal/zztm;
    //   6: ifnull +12 -> 18
    //   9: getstatic 409	com/google/android/gms/internal/zztl:Qh	Lcom/google/android/gms/internal/zztm;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: invokestatic 415	com/google/android/gms/common/zzc:zzaql	()Lcom/google/android/gms/common/zzc;
    //   21: aload_0
    //   22: invokevirtual 419	com/google/android/gms/common/zzc:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   25: ifeq +11 -> 36
    //   28: ldc 2
    //   30: monitorexit
    //   31: aconst_null
    //   32: astore_0
    //   33: goto -17 -> 16
    //   36: aload_0
    //   37: ldc_w 421
    //   40: iconst_3
    //   41: invokevirtual 425	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   44: invokevirtual 126	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   47: ldc_w 427
    //   50: invokevirtual 137	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   53: invokevirtual 430	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   56: checkcast 151	android/os/IBinder
    //   59: invokestatic 436	com/google/android/gms/internal/zztm$zza:zzfe	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zztm;
    //   62: astore_0
    //   63: aload_0
    //   64: ifnull +50 -> 114
    //   67: aload_0
    //   68: putstatic 409	com/google/android/gms/internal/zztl:Qh	Lcom/google/android/gms/internal/zztm;
    //   71: ldc 2
    //   73: monitorexit
    //   74: goto -58 -> 16
    //   77: astore_0
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: aload_0
    //   85: invokevirtual 327	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   88: invokestatic 182	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 186	java/lang/String:length	()I
    //   96: ifeq +26 -> 122
    //   99: ldc_w 438
    //   102: aload_0
    //   103: invokevirtual 192	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   106: astore_0
    //   107: ldc 114
    //   109: aload_0
    //   110: invokestatic 122	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   113: pop
    //   114: ldc 2
    //   116: monitorexit
    //   117: aconst_null
    //   118: astore_0
    //   119: goto -103 -> 16
    //   122: new 108	java/lang/String
    //   125: dup
    //   126: ldc_w 438
    //   129: invokespecial 195	java/lang/String:<init>	(Ljava/lang/String;)V
    //   132: astore_0
    //   133: goto -26 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	16	77	finally
    //   18	31	77	finally
    //   36	63	77	finally
    //   67	71	77	finally
    //   71	74	77	finally
    //   78	81	77	finally
    //   84	107	77	finally
    //   107	114	77	finally
    //   114	117	77	finally
    //   122	133	77	finally
    //   36	63	83	java/lang/Exception
    //   67	71	83	java/lang/Exception
  }
  
  public Context zzbdt()
  {
    return this.Qr;
  }
  
  public IBinder zzjd(String paramString)
    throws zztl.zza
  {
    try
    {
      IBinder localIBinder = (IBinder)this.Qr.getClassLoader().loadClass(paramString).newInstance();
      return localIBinder;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = "Failed to instantiate module class: ".concat(paramString);; paramString = new String("Failed to instantiate module class: ")) {
        throw new zza(paramString, localClassNotFoundException, null);
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
  }
  
  public static class zza
    extends Exception
  {
    private zza(String paramString)
    {
      super();
    }
    
    private zza(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static abstract interface zzb
  {
    public abstract zzb zza(Context paramContext, String paramString, zza paramzza)
      throws zztl.zza;
    
    public static abstract interface zza
    {
      public abstract zztl zza(Context paramContext, String paramString, int paramInt)
        throws zztl.zza;
      
      public abstract int zzaa(Context paramContext, String paramString);
      
      public abstract int zzb(Context paramContext, String paramString, boolean paramBoolean)
        throws zztl.zza;
    }
    
    public static class zzb
    {
      public int Qt = 0;
      public int Qu = 0;
      public int Qv = 0;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zztl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */