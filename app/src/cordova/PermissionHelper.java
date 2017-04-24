package org.apache.cordova;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PermissionHelper
{
  private static final String LOG_TAG = "CordovaPermissionHelper";
  
  private static void deliverPermissionResult(CordovaPlugin paramCordovaPlugin, int paramInt, String[] paramArrayOfString)
  {
    int[] arrayOfInt = new int[paramArrayOfString.length];
    Arrays.fill(arrayOfInt, 0);
    try
    {
      CordovaPlugin.class.getDeclaredMethod("onRequestPermissionResult", new Class[] { Integer.TYPE, String[].class, int[].class }).invoke(paramCordovaPlugin, new Object[] { Integer.valueOf(paramInt), paramArrayOfString, arrayOfInt });
      return;
    }
    catch (NoSuchMethodException paramCordovaPlugin)
    {
      for (;;)
      {
        LOG.e("CordovaPermissionHelper", "NoSuchMethodException when delivering permissions results", paramCordovaPlugin);
      }
    }
    catch (IllegalAccessException paramCordovaPlugin)
    {
      for (;;)
      {
        LOG.e("CordovaPermissionHelper", "IllegalAccessException when delivering permissions results", paramCordovaPlugin);
      }
    }
    catch (InvocationTargetException paramCordovaPlugin)
    {
      for (;;)
      {
        LOG.e("CordovaPermissionHelper", "InvocationTargetException when delivering permissions results", paramCordovaPlugin);
      }
    }
  }
  
  public static boolean hasPermission(CordovaPlugin paramCordovaPlugin, String paramString)
  {
    try
    {
      bool = ((Boolean)CordovaInterface.class.getDeclaredMethod("hasPermission", new Class[] { String.class }).invoke(paramCordovaPlugin.cordova, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException paramCordovaPlugin)
    {
      for (;;)
      {
        LOG.d("CordovaPermissionHelper", "No need to check for permission " + paramString);
        bool = true;
      }
    }
    catch (IllegalAccessException paramCordovaPlugin)
    {
      for (;;)
      {
        LOG.e("CordovaPermissionHelper", "IllegalAccessException when checking permission " + paramString, paramCordovaPlugin);
        boolean bool = false;
      }
    }
    catch (InvocationTargetException paramCordovaPlugin)
    {
      for (;;)
      {
        LOG.e("CordovaPermissionHelper", "invocationTargetException when checking permission " + paramString, paramCordovaPlugin);
      }
    }
  }
  
  public static void requestPermission(CordovaPlugin paramCordovaPlugin, int paramInt, String paramString)
  {
    requestPermissions(paramCordovaPlugin, paramInt, new String[] { paramString });
  }
  
  public static void requestPermissions(CordovaPlugin paramCordovaPlugin, int paramInt, String[] paramArrayOfString)
  {
    try
    {
      CordovaInterface.class.getDeclaredMethod("requestPermissions", new Class[] { CordovaPlugin.class, Integer.TYPE, String[].class }).invoke(paramCordovaPlugin.cordova, new Object[] { paramCordovaPlugin, Integer.valueOf(paramInt), paramArrayOfString });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        LOG.d("CordovaPermissionHelper", "No need to request permissions " + Arrays.toString(paramArrayOfString));
        deliverPermissionResult(paramCordovaPlugin, paramInt, paramArrayOfString);
      }
    }
    catch (IllegalAccessException paramCordovaPlugin)
    {
      for (;;)
      {
        LOG.e("CordovaPermissionHelper", "IllegalAccessException when requesting permissions " + Arrays.toString(paramArrayOfString), paramCordovaPlugin);
      }
    }
    catch (InvocationTargetException paramCordovaPlugin)
    {
      for (;;)
      {
        LOG.e("CordovaPermissionHelper", "invocationTargetException when requesting permissions " + Arrays.toString(paramArrayOfString), paramCordovaPlugin);
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\PermissionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */