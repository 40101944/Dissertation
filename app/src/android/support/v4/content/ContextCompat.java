package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.BuildCompat;
import android.util.TypedValue;
import java.io.File;

public class ContextCompat
{
  private static final String DIR_ANDROID = "Android";
  private static final String DIR_OBB = "obb";
  private static final String TAG = "ContextCompat";
  private static final Object sLock = new Object();
  private static TypedValue sTempValue;
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    String str;
    if (i < j)
    {
      str = paramVarArgs[i];
      if (paramFile == null) {
        paramFile = new File(str);
      }
    }
    for (;;)
    {
      i++;
      break;
      if (str != null)
      {
        paramFile = new File(paramFile, str);
        continue;
        return paramFile;
      }
    }
  }
  
  public static int checkSelfPermission(@NonNull Context paramContext, @NonNull String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("permission is null");
    }
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
  }
  
  public static Context createDeviceProtectedStorageContext(Context paramContext)
  {
    if (BuildCompat.isAtLeastN()) {}
    for (paramContext = ContextCompatApi24.createDeviceProtectedStorageContext(paramContext);; paramContext = null) {
      return paramContext;
    }
  }
  
  /* Error */
  private static File createFilesDir(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual 77	java/io/File:exists	()Z
    //   9: ifne +23 -> 32
    //   12: aload_0
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 80	java/io/File:mkdirs	()Z
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokevirtual 77	java/io/File:exists	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifeq +10 -> 37
    //   30: aload_0
    //   31: astore_2
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_2
    //   36: areturn
    //   37: new 82	java/lang/StringBuilder
    //   40: astore_2
    //   41: aload_2
    //   42: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   45: ldc 14
    //   47: aload_2
    //   48: ldc 85
    //   50: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_0
    //   54: invokevirtual 93	java/io/File:getPath	()Ljava/lang/String;
    //   57: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 102	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   66: pop
    //   67: aconst_null
    //   68: astore_2
    //   69: goto -37 -> 32
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramFile	File
    //   25	2	1	bool	boolean
    //   4	65	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	12	72	finally
    //   14	26	72	finally
    //   37	67	72	finally
  }
  
  public static File getCodeCacheDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramContext = ContextCompatApi21.getCodeCacheDir(paramContext);; paramContext = createFilesDir(new File(paramContext.getApplicationInfo().dataDir, "code_cache"))) {
      return paramContext;
    }
  }
  
  @ColorInt
  public static final int getColor(Context paramContext, @ColorRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (paramInt = ContextCompatApi23.getColor(paramContext, paramInt);; paramInt = paramContext.getResources().getColor(paramInt)) {
      return paramInt;
    }
  }
  
  public static final ColorStateList getColorStateList(Context paramContext, @ColorRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (paramContext = ContextCompatApi23.getColorStateList(paramContext, paramInt);; paramContext = paramContext.getResources().getColorStateList(paramInt)) {
      return paramContext;
    }
  }
  
  public static File getDataDir(Context paramContext)
  {
    if (BuildCompat.isAtLeastN()) {
      paramContext = ContextCompatApi24.getDataDir(paramContext);
    }
    for (;;)
    {
      return paramContext;
      paramContext = paramContext.getApplicationInfo().dataDir;
      if (paramContext != null) {
        paramContext = new File(paramContext);
      } else {
        paramContext = null;
      }
    }
  }
  
  public static final Drawable getDrawable(Context paramContext, @DrawableRes int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      paramContext = ContextCompatApi21.getDrawable(paramContext, paramInt);
    }
    for (;;)
    {
      return paramContext;
      if (i >= 16)
      {
        paramContext = paramContext.getResources().getDrawable(paramInt);
        continue;
      }
      synchronized (sLock)
      {
        if (sTempValue == null)
        {
          TypedValue localTypedValue = new android/util/TypedValue;
          localTypedValue.<init>();
          sTempValue = localTypedValue;
        }
        paramContext.getResources().getValue(paramInt, sTempValue, true);
        paramInt = sTempValue.resourceId;
        paramContext = paramContext.getResources().getDrawable(paramInt);
      }
    }
  }
  
  public static File[] getExternalCacheDirs(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    File[] arrayOfFile;
    for (paramContext = ContextCompatKitKat.getExternalCacheDirs(paramContext);; paramContext = arrayOfFile)
    {
      return paramContext;
      arrayOfFile = new File[1];
      arrayOfFile[0] = paramContext.getExternalCacheDir();
    }
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    File[] arrayOfFile;
    for (paramContext = ContextCompatKitKat.getExternalFilesDirs(paramContext, paramString);; paramContext = arrayOfFile)
    {
      return paramContext;
      arrayOfFile = new File[1];
      arrayOfFile[0] = paramContext.getExternalFilesDir(paramString);
    }
  }
  
  public static final File getNoBackupFilesDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramContext = ContextCompatApi21.getNoBackupFilesDir(paramContext);; paramContext = createFilesDir(new File(paramContext.getApplicationInfo().dataDir, "no_backup"))) {
      return paramContext;
    }
  }
  
  public static File[] getObbDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      paramContext = ContextCompatKitKat.getObbDirs(paramContext);
      return paramContext;
    }
    if (i >= 11) {}
    for (paramContext = ContextCompatHoneycomb.getObbDir(paramContext);; paramContext = buildPath(Environment.getExternalStorageDirectory(), new String[] { "Android", "obb", paramContext.getPackageName() }))
    {
      File[] arrayOfFile = new File[1];
      arrayOfFile[0] = paramContext;
      paramContext = arrayOfFile;
      break;
    }
  }
  
  public static boolean isDeviceProtectedStorage(Context paramContext)
  {
    if (BuildCompat.isAtLeastN()) {}
    for (boolean bool = ContextCompatApi24.isDeviceProtectedStorage(paramContext);; bool = false) {
      return bool;
    }
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    boolean bool = true;
    int i = Build.VERSION.SDK_INT;
    if (i >= 16) {
      ContextCompatJellybean.startActivities(paramContext, paramArrayOfIntent, paramBundle);
    }
    for (;;)
    {
      return bool;
      if (i >= 11) {
        ContextCompatHoneycomb.startActivities(paramContext, paramArrayOfIntent);
      } else {
        bool = false;
      }
    }
  }
  
  public static void startActivity(Context paramContext, Intent paramIntent, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ContextCompatJellybean.startActivity(paramContext, paramIntent, paramBundle);
    }
    for (;;)
    {
      return;
      paramContext.startActivity(paramIntent);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\content\ContextCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */