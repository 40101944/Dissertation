package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class NotificationManagerCompatKitKat
{
  private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
  private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
  
  public static boolean areNotificationsEnabled(Context paramContext)
  {
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    Object localObject = paramContext.getApplicationInfo();
    paramContext = paramContext.getApplicationContext().getPackageName();
    int i = ((ApplicationInfo)localObject).uid;
    for (;;)
    {
      try
      {
        localObject = Class.forName(AppOpsManager.class.getName());
        i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), paramContext })).intValue();
        if (i != 0) {
          continue;
        }
        bool = true;
      }
      catch (ClassNotFoundException paramContext)
      {
        boolean bool = true;
        continue;
      }
      catch (RuntimeException paramContext)
      {
        continue;
      }
      catch (NoSuchFieldException paramContext)
      {
        continue;
      }
      catch (IllegalAccessException paramContext)
      {
        continue;
      }
      catch (NoSuchMethodException paramContext)
      {
        continue;
      }
      catch (InvocationTargetException paramContext)
      {
        continue;
      }
      return bool;
      bool = false;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\app\NotificationManagerCompatKitKat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */