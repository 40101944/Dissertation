package android.support.v4.os;

import android.os.Build.VERSION;

public class BuildCompat
{
  public static boolean isAtLeastN()
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isAtLeastNMR1()
  {
    if (Build.VERSION.SDK_INT >= 25) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\os\BuildCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */