package org.apache.cordova.file;

import android.net.Uri;

public class LocalFilesystemURL
{
  public static final String FILESYSTEM_PROTOCOL = "cdvfile";
  public final String fsName;
  public final boolean isDirectory;
  public final String path;
  public final Uri uri;
  
  private LocalFilesystemURL(Uri paramUri, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.uri = paramUri;
    this.fsName = paramString1;
    this.path = paramString2;
    this.isDirectory = paramBoolean;
  }
  
  public static LocalFilesystemURL parse(Uri paramUri)
  {
    String str1 = null;
    boolean bool = true;
    if (!"cdvfile".equals(paramUri.getScheme())) {
      localObject = str1;
    }
    String str2;
    int i;
    do
    {
      do
      {
        return (LocalFilesystemURL)localObject;
        str2 = paramUri.getPath();
        localObject = str1;
      } while (str2.length() < 1);
      i = str2.indexOf('/', 1);
      localObject = str1;
    } while (i < 0);
    Object localObject = str2.substring(1, i);
    str1 = str2.substring(i);
    if (str1.charAt(str1.length() - 1) == '/') {}
    for (;;)
    {
      localObject = new LocalFilesystemURL(paramUri, (String)localObject, str1, bool);
      break;
      bool = false;
    }
  }
  
  public static LocalFilesystemURL parse(String paramString)
  {
    return parse(Uri.parse(paramString));
  }
  
  public String toString()
  {
    return this.uri.toString();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\file\LocalFilesystemURL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */