package org.apache.cordova.file;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class DirectoryManager
{
  private static final String LOG_TAG = "DirectoryManager";
  
  private static File constructFilePaths(String paramString1, String paramString2)
  {
    if (paramString2.startsWith(paramString1)) {}
    for (paramString1 = new File(paramString2);; paramString1 = new File(paramString1 + "/" + paramString2)) {
      return paramString1;
    }
  }
  
  public static long getFreeExternalStorageSpace()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (long l = getFreeSpaceInBytes(Environment.getExternalStorageDirectory().getPath()) / 1024L;; l = -1L) {
      return l;
    }
  }
  
  public static long getFreeSpaceInBytes(String paramString)
  {
    try
    {
      StatFs localStatFs = new android/os/StatFs;
      localStatFs.<init>(paramString);
      l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      l = i * l;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
    return l;
  }
  
  public static boolean testFileExists(String paramString)
  {
    if ((testSaveLocationExists()) && (!paramString.equals(""))) {}
    for (boolean bool = constructFilePaths(Environment.getExternalStorageDirectory().toString(), paramString).exists();; bool = false) {
      return bool;
    }
  }
  
  public static boolean testSaveLocationExists()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\file\DirectoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */