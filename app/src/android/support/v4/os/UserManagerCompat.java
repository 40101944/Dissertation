package android.support.v4.os;

import android.content.Context;

public class UserManagerCompat
{
  @Deprecated
  public static boolean isUserRunningAndLocked(Context paramContext)
  {
    if (!isUserUnlocked(paramContext)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  @Deprecated
  public static boolean isUserRunningAndUnlocked(Context paramContext)
  {
    return isUserUnlocked(paramContext);
  }
  
  public static boolean isUserUnlocked(Context paramContext)
  {
    if (BuildCompat.isAtLeastN()) {}
    for (boolean bool = UserManagerCompatApi24.isUserUnlocked(paramContext);; bool = true) {
      return bool;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\os\UserManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */