package org.apache.cordova;

import android.content.Context;
import java.lang.reflect.Field;

public class BuildHelper
{
  private static String TAG = "BuildHelper";
  
  public static Object getBuildConfigValue(Context paramContext, String paramString)
  {
    Object localObject = null;
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      paramContext = Class.forName(paramContext.getPackageName() + ".BuildConfig").getField(paramString).get(null);
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        LOG.d(TAG, "Unable to get the BuildConfig, is this built with ANT?");
        paramContext.printStackTrace();
        paramContext = (Context)localObject;
      }
    }
    catch (NoSuchFieldException paramContext)
    {
      for (;;)
      {
        LOG.d(TAG, paramString + " is not a valid field. Check your build.gradle");
        paramContext = (Context)localObject;
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        LOG.d(TAG, "Illegal Access Exception: Let's print a stack trace.");
        paramContext.printStackTrace();
        paramContext = (Context)localObject;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\BuildHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */