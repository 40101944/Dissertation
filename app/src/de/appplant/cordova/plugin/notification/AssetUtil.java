package de.appplant.cordova.plugin.notification;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

class AssetUtil
{
  private static final String DEFAULT_SOUND = "res://platform_default";
  private static final String STORAGE_FOLDER = "/localnotification";
  private final Context context;
  
  private AssetUtil(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private String getBaseName(String paramString)
  {
    Object localObject2 = paramString;
    Object localObject1 = localObject2;
    if (((String)localObject2).contains("/")) {
      localObject1 = ((String)localObject2).substring(((String)localObject2).lastIndexOf('/') + 1);
    }
    localObject2 = localObject1;
    if (paramString.contains(".")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf('.'));
    }
    return (String)localObject2;
  }
  
  static AssetUtil getInstance(Context paramContext)
  {
    return new AssetUtil(paramContext);
  }
  
  private String getPkgName()
  {
    return this.context.getPackageName();
  }
  
  private File getTmpFile()
  {
    return getTmpFile(UUID.randomUUID().toString());
  }
  
  private File getTmpFile(String paramString)
  {
    Object localObject = this.context.getExternalCacheDir();
    if (localObject == null) {
      Log.e("Asset", "Missing external cache dir");
    }
    for (paramString = null;; paramString = new File((String)localObject, paramString))
    {
      return paramString;
      localObject = ((File)localObject).toString() + "/localnotification";
      new File((String)localObject).mkdir();
    }
  }
  
  private Uri getUriForResourcePath(String paramString)
  {
    Object localObject = paramString.replaceFirst("res://", "");
    int i = getResIdForDrawable((String)localObject);
    paramString = getTmpFile();
    if (i == 0)
    {
      Log.e("Asset", "File not found: " + (String)localObject);
      paramString = Uri.EMPTY;
    }
    for (;;)
    {
      return paramString;
      if (paramString == null)
      {
        Log.e("Asset", "Missing external cache dir");
        paramString = Uri.EMPTY;
      }
      else
      {
        try
        {
          Resources localResources = this.context.getResources();
          localObject = new java/io/FileOutputStream;
          ((FileOutputStream)localObject).<init>(paramString);
          copyFile(localResources.openRawResource(i), (OutputStream)localObject);
          ((FileOutputStream)localObject).flush();
          ((FileOutputStream)localObject).close();
          paramString = Uri.fromFile(paramString);
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          paramString = Uri.EMPTY;
        }
      }
    }
  }
  
  private Uri getUriFromAsset(String paramString)
  {
    String str = paramString.replaceFirst("file:/", "www");
    File localFile = getTmpFile(str.substring(str.lastIndexOf('/') + 1));
    if (localFile == null)
    {
      Log.e("Asset", "Missing external cache dir");
      paramString = Uri.EMPTY;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = this.context.getAssets();
        FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
        localFileOutputStream.<init>(localFile);
        copyFile(paramString.open(str), localFileOutputStream);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        paramString = Uri.fromFile(localFile);
      }
      catch (Exception paramString)
      {
        Log.e("Asset", "File not found: assets/" + str);
        paramString.printStackTrace();
        paramString = Uri.EMPTY;
      }
    }
  }
  
  private Uri getUriFromPath(String paramString)
  {
    paramString = new File(paramString.replaceFirst("file://", ""));
    if (!paramString.exists()) {
      Log.e("Asset", "File not found: " + paramString.getAbsolutePath());
    }
    for (paramString = Uri.EMPTY;; paramString = Uri.fromFile(paramString)) {
      return paramString;
    }
  }
  
  private Uri getUriFromRemote(String paramString)
  {
    File localFile = getTmpFile();
    if (localFile == null)
    {
      Log.e("Asset", "Missing external cache dir");
      paramString = Uri.EMPTY;
    }
    for (;;)
    {
      return paramString;
      try
      {
        Object localObject = new java/net/URL;
        ((URL)localObject).<init>(paramString);
        paramString = (HttpURLConnection)((URL)localObject).openConnection();
        localObject = new android/os/StrictMode$ThreadPolicy$Builder;
        ((StrictMode.ThreadPolicy.Builder)localObject).<init>();
        StrictMode.setThreadPolicy(((StrictMode.ThreadPolicy.Builder)localObject).permitAll().build());
        paramString.setRequestProperty("Connection", "close");
        paramString.setConnectTimeout(5000);
        paramString.connect();
        paramString = paramString.getInputStream();
        localObject = new java/io/FileOutputStream;
        ((FileOutputStream)localObject).<init>(localFile);
        copyFile(paramString, (OutputStream)localObject);
        ((FileOutputStream)localObject).flush();
        ((FileOutputStream)localObject).close();
        paramString = Uri.fromFile(localFile);
      }
      catch (MalformedURLException paramString)
      {
        Log.e("Asset", "Incorrect URL");
        paramString.printStackTrace();
        paramString = Uri.EMPTY;
      }
      catch (FileNotFoundException paramString)
      {
        for (;;)
        {
          Log.e("Asset", "Failed to create new File from HTTP Content");
          paramString.printStackTrace();
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          Log.e("Asset", "No Input can be created from http Stream");
          paramString.printStackTrace();
        }
      }
    }
  }
  
  Bitmap getIconFromDrawable(String paramString)
  {
    Resources localResources = this.context.getResources();
    int j = getResIdForDrawable(getPkgName(), paramString);
    int i = j;
    if (j == 0) {
      i = getResIdForDrawable("android", paramString);
    }
    j = i;
    if (i == 0) {
      j = 17301673;
    }
    return BitmapFactory.decodeResource(localResources, j);
  }
  
  Bitmap getIconFromUri(Uri paramUri)
    throws IOException
  {
    return BitmapFactory.decodeStream(this.context.getContentResolver().openInputStream(paramUri));
  }
  
  int getResIdForDrawable(String paramString)
  {
    int j = getResIdForDrawable(getPkgName(), paramString);
    int i = j;
    if (j == 0) {
      i = getResIdForDrawable("android", paramString);
    }
    return i;
  }
  
  int getResIdForDrawable(String paramString1, String paramString2)
  {
    String str = getBaseName(paramString2);
    int j = 0;
    try
    {
      paramString2 = new java/lang/StringBuilder;
      paramString2.<init>();
      i = ((Integer)Class.forName(paramString1 + ".R$drawable").getDeclaredField(str).get(Integer.class)).intValue();
      return i;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int i = j;
      }
    }
  }
  
  Uri parse(String paramString)
  {
    if (paramString.startsWith("res:")) {
      paramString = getUriForResourcePath(paramString);
    }
    for (;;)
    {
      return paramString;
      if (paramString.startsWith("file:///")) {
        paramString = getUriFromPath(paramString);
      } else if (paramString.startsWith("file://")) {
        paramString = getUriFromAsset(paramString);
      } else if (paramString.startsWith("http")) {
        paramString = getUriFromRemote(paramString);
      } else {
        paramString = Uri.EMPTY;
      }
    }
  }
  
  Uri parseSound(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      paramString = Uri.EMPTY;
    }
    for (;;)
    {
      return paramString;
      if (paramString.equalsIgnoreCase("res://platform_default")) {
        paramString = RingtoneManager.getDefaultUri(2);
      } else {
        paramString = parse(paramString);
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\AssetUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */