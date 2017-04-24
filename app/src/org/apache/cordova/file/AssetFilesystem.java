package org.apache.cordova.file;

import android.content.res.AssetManager;
import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaResourceApi.OpenForReadResult;
import org.apache.cordova.LOG;
import org.json.JSONException;
import org.json.JSONObject;

public class AssetFilesystem
  extends Filesystem
{
  private static final String LOG_TAG = "AssetFilesystem";
  private static Map<String, Long> lengthCache;
  private static Map<String, String[]> listCache;
  private static boolean listCacheFromFile;
  private static Object listCacheLock = new Object();
  private final AssetManager assetManager;
  
  public AssetFilesystem(AssetManager paramAssetManager, CordovaResourceApi paramCordovaResourceApi)
  {
    super(Uri.parse("file:///android_asset/"), "assets", paramCordovaResourceApi);
    this.assetManager = paramAssetManager;
  }
  
  private long getAssetSize(String paramString)
    throws FileNotFoundException
  {
    String str = paramString;
    if (paramString.startsWith("/")) {
      str = paramString.substring(1);
    }
    lazyInitCaches();
    long l2;
    if (lengthCache != null)
    {
      paramString = (Long)lengthCache.get(str);
      if (paramString == null) {
        throw new FileNotFoundException("Asset not found: " + str);
      }
      l2 = paramString.longValue();
    }
    Object localObject1;
    for (;;)
    {
      return l2;
      localObject1 = null;
      paramString = null;
      try
      {
        localObject2 = this.resourceApi.openForRead(nativeUriForFullPath(str));
        paramString = (String)localObject2;
        localObject1 = localObject2;
        l2 = ((CordovaResourceApi.OpenForReadResult)localObject2).length;
        long l1 = l2;
        if (l2 < 0L)
        {
          paramString = (String)localObject2;
          localObject1 = localObject2;
          int i = ((CordovaResourceApi.OpenForReadResult)localObject2).inputStream.available();
          l1 = i;
        }
        l2 = l1;
        if (localObject2 != null) {
          try
          {
            ((CordovaResourceApi.OpenForReadResult)localObject2).inputStream.close();
            l2 = l1;
          }
          catch (IOException paramString)
          {
            LOG.d("AssetFilesystem", paramString.getLocalizedMessage());
            l2 = l1;
          }
        }
      }
      catch (IOException localIOException2)
      {
        localObject1 = paramString;
        FileNotFoundException localFileNotFoundException = new java/io/FileNotFoundException;
        localObject1 = paramString;
        Object localObject2 = new java/lang/StringBuilder;
        localObject1 = paramString;
        ((StringBuilder)localObject2).<init>();
        localObject1 = paramString;
        localFileNotFoundException.<init>("File not found: " + str);
        localObject1 = paramString;
        localFileNotFoundException.initCause(localIOException2);
        localObject1 = paramString;
        throw localFileNotFoundException;
      }
      finally
      {
        if (localObject1 == null) {}
      }
    }
    try
    {
      ((CordovaResourceApi.OpenForReadResult)localObject1).inputStream.close();
      throw paramString;
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        LOG.d("AssetFilesystem", localIOException1.getLocalizedMessage());
      }
    }
  }
  
  private boolean isDirectory(String paramString)
  {
    boolean bool = false;
    try
    {
      int i = listAssets(paramString).length;
      if (i != 0) {
        bool = true;
      }
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
    return bool;
  }
  
  /* Error */
  private void lazyInitCaches()
  {
    // Byte code:
    //   0: getstatic 28	org/apache/cordova/file/AssetFilesystem:listCacheLock	Ljava/lang/Object;
    //   3: astore 6
    //   5: aload 6
    //   7: monitorenter
    //   8: getstatic 153	org/apache/cordova/file/AssetFilesystem:listCache	Ljava/util/Map;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +91 -> 104
    //   16: aconst_null
    //   17: astore_3
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 4
    //   24: aload 5
    //   26: astore_2
    //   27: new 155	java/io/ObjectInputStream
    //   30: astore_1
    //   31: aload 5
    //   33: astore_2
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 45	org/apache/cordova/file/AssetFilesystem:assetManager	Landroid/content/res/AssetManager;
    //   39: ldc -99
    //   41: invokevirtual 163	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   44: invokespecial 166	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: aload_1
    //   48: invokevirtual 170	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   51: checkcast 70	java/util/Map
    //   54: putstatic 153	org/apache/cordova/file/AssetFilesystem:listCache	Ljava/util/Map;
    //   57: aload_1
    //   58: invokevirtual 170	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   61: checkcast 70	java/util/Map
    //   64: putstatic 68	org/apache/cordova/file/AssetFilesystem:lengthCache	Ljava/util/Map;
    //   67: iconst_1
    //   68: putstatic 172	org/apache/cordova/file/AssetFilesystem:listCacheFromFile	Z
    //   71: aload_1
    //   72: ifnull +158 -> 230
    //   75: aload_1
    //   76: invokevirtual 173	java/io/ObjectInputStream:close	()V
    //   79: getstatic 153	org/apache/cordova/file/AssetFilesystem:listCache	Ljava/util/Map;
    //   82: ifnonnull +22 -> 104
    //   85: ldc 8
    //   87: ldc -81
    //   89: invokestatic 178	org/apache/cordova/LOG:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: new 180	java/util/HashMap
    //   95: astore_1
    //   96: aload_1
    //   97: invokespecial 181	java/util/HashMap:<init>	()V
    //   100: aload_1
    //   101: putstatic 153	org/apache/cordova/file/AssetFilesystem:listCache	Ljava/util/Map;
    //   104: aload 6
    //   106: monitorexit
    //   107: return
    //   108: astore_1
    //   109: ldc 8
    //   111: aload_1
    //   112: invokevirtual 131	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   115: invokestatic 137	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto -39 -> 79
    //   121: astore_3
    //   122: aload 4
    //   124: astore_1
    //   125: aload_1
    //   126: astore_2
    //   127: aload_3
    //   128: invokevirtual 184	java/lang/ClassNotFoundException:printStackTrace	()V
    //   131: aload_1
    //   132: ifnull -53 -> 79
    //   135: aload_1
    //   136: invokevirtual 173	java/io/ObjectInputStream:close	()V
    //   139: goto -60 -> 79
    //   142: astore_1
    //   143: ldc 8
    //   145: aload_1
    //   146: invokevirtual 131	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   149: invokestatic 137	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: goto -73 -> 79
    //   155: astore_1
    //   156: aload 6
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: aload_3
    //   163: astore_1
    //   164: aload_1
    //   165: ifnull -86 -> 79
    //   168: aload_1
    //   169: invokevirtual 173	java/io/ObjectInputStream:close	()V
    //   172: goto -93 -> 79
    //   175: astore_1
    //   176: ldc 8
    //   178: aload_1
    //   179: invokevirtual 131	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   182: invokestatic 137	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: goto -106 -> 79
    //   188: astore_1
    //   189: aload_2
    //   190: astore_3
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 173	java/io/ObjectInputStream:close	()V
    //   199: aload_1
    //   200: athrow
    //   201: astore_2
    //   202: ldc 8
    //   204: aload_2
    //   205: invokevirtual 131	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   208: invokestatic 137	org/apache/cordova/LOG:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: goto -12 -> 199
    //   214: astore_2
    //   215: aload_1
    //   216: astore_3
    //   217: aload_2
    //   218: astore_1
    //   219: goto -28 -> 191
    //   222: astore_2
    //   223: goto -59 -> 164
    //   226: astore_3
    //   227: goto -102 -> 125
    //   230: goto -151 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	AssetFilesystem
    //   11	90	1	localObject1	Object
    //   108	4	1	localIOException1	IOException
    //   124	12	1	localObject2	Object
    //   142	4	1	localIOException2	IOException
    //   155	5	1	localObject3	Object
    //   161	1	1	localIOException3	IOException
    //   163	6	1	localObject4	Object
    //   175	4	1	localIOException4	IOException
    //   188	28	1	localObject5	Object
    //   218	1	1	localObject6	Object
    //   26	164	2	localObject7	Object
    //   201	4	2	localIOException5	IOException
    //   214	4	2	localObject8	Object
    //   222	1	2	localIOException6	IOException
    //   17	1	3	localObject9	Object
    //   121	42	3	localClassNotFoundException1	ClassNotFoundException
    //   190	27	3	localObject10	Object
    //   226	1	3	localClassNotFoundException2	ClassNotFoundException
    //   22	101	4	localObject11	Object
    //   19	13	5	localObject12	Object
    //   3	154	6	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   75	79	108	java/io/IOException
    //   27	31	121	java/lang/ClassNotFoundException
    //   34	47	121	java/lang/ClassNotFoundException
    //   135	139	142	java/io/IOException
    //   8	12	155	finally
    //   75	79	155	finally
    //   79	104	155	finally
    //   104	107	155	finally
    //   109	118	155	finally
    //   135	139	155	finally
    //   143	152	155	finally
    //   156	159	155	finally
    //   168	172	155	finally
    //   176	185	155	finally
    //   195	199	155	finally
    //   199	201	155	finally
    //   202	211	155	finally
    //   27	31	161	java/io/IOException
    //   34	47	161	java/io/IOException
    //   168	172	175	java/io/IOException
    //   27	31	188	finally
    //   34	47	188	finally
    //   127	131	188	finally
    //   195	199	201	java/io/IOException
    //   47	71	214	finally
    //   47	71	222	java/io/IOException
    //   47	71	226	java/lang/ClassNotFoundException
  }
  
  private String[] listAssets(String paramString)
    throws IOException
  {
    Object localObject1 = paramString;
    if (paramString.startsWith("/")) {
      localObject1 = paramString.substring(1);
    }
    Object localObject2 = localObject1;
    if (((String)localObject1).endsWith("/")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    lazyInitCaches();
    localObject1 = (String[])listCache.get(localObject2);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      if (!listCacheFromFile) {
        break label76;
      }
      paramString = new String[0];
    }
    for (;;)
    {
      return paramString;
      label76:
      paramString = this.assetManager.list((String)localObject2);
      listCache.put(localObject2, paramString);
    }
  }
  
  LocalFilesystemURL URLforFilesystemPath(String paramString)
  {
    return null;
  }
  
  public boolean canRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
  {
    return false;
  }
  
  String filesystemPathForURL(LocalFilesystemURL paramLocalFilesystemURL)
  {
    return new File(this.rootUri.getPath(), paramLocalFilesystemURL.path).toString();
  }
  
  public JSONObject getFileForLocalURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, JSONObject paramJSONObject, boolean paramBoolean)
    throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("create"))) {
      throw new UnsupportedOperationException("Assets are read-only");
    }
    paramJSONObject = paramString;
    if (paramBoolean)
    {
      paramJSONObject = paramString;
      if (!paramString.endsWith("/")) {
        paramJSONObject = paramString + "/";
      }
    }
    if (paramJSONObject.startsWith("/")) {}
    boolean bool;
    for (paramLocalFilesystemURL = localUrlforFullPath(normalizePath(paramJSONObject));; paramLocalFilesystemURL = localUrlforFullPath(normalizePath(paramLocalFilesystemURL.path + "/" + paramJSONObject)))
    {
      getFileMetadataForLocalURL(paramLocalFilesystemURL);
      bool = isDirectory(paramLocalFilesystemURL.path);
      if ((!paramBoolean) || (bool)) {
        break;
      }
      throw new TypeMismatchException("path doesn't exist or is file");
    }
    if ((!paramBoolean) && (bool)) {
      throw new TypeMismatchException("path doesn't exist or is directory");
    }
    return makeEntryForURL(paramLocalFilesystemURL);
  }
  
  public JSONObject getFileMetadataForLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileNotFoundException
  {
    JSONObject localJSONObject = new JSONObject();
    long l;
    if (paramLocalFilesystemURL.isDirectory) {
      l = 0L;
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("size", l);
        if (!paramLocalFilesystemURL.isDirectory) {
          continue;
        }
        localObject = "text/directory";
        localJSONObject.put("type", localObject);
        localObject = new java/io/File;
        ((File)localObject).<init>(paramLocalFilesystemURL.path);
        localJSONObject.put("name", ((File)localObject).getName());
        localJSONObject.put("fullPath", paramLocalFilesystemURL.path);
        localJSONObject.put("lastModifiedDate", 0);
        paramLocalFilesystemURL = localJSONObject;
      }
      catch (JSONException paramLocalFilesystemURL)
      {
        Object localObject;
        paramLocalFilesystemURL = null;
        continue;
      }
      return paramLocalFilesystemURL;
      l = getAssetSize(paramLocalFilesystemURL.path);
      continue;
      localObject = this.resourceApi.getMimeType(toNativeUri(paramLocalFilesystemURL));
    }
  }
  
  public LocalFilesystemURL[] listChildren(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileNotFoundException
  {
    Object localObject2 = paramLocalFilesystemURL.path.substring(1);
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("/")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    try
    {
      localObject2 = listAssets((String)localObject1);
      localObject1 = new LocalFilesystemURL[localObject2.length];
      for (int i = 0; i < localObject2.length; i++) {
        localObject1[i] = localUrlforFullPath(new File(paramLocalFilesystemURL.path, localObject2[i]).getPath());
      }
      return localIOException;
    }
    catch (IOException localIOException)
    {
      paramLocalFilesystemURL = new FileNotFoundException();
      paramLocalFilesystemURL.initCause(localIOException);
      throw paramLocalFilesystemURL;
    }
  }
  
  boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws NoModificationAllowedException
  {
    throw new NoModificationAllowedException("Assets are read-only");
  }
  
  boolean removeFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws InvalidModificationException, NoModificationAllowedException
  {
    throw new NoModificationAllowedException("Assets are read-only");
  }
  
  public LocalFilesystemURL toLocalUri(Uri paramUri)
  {
    Object localObject1 = null;
    if (!"file".equals(paramUri.getScheme())) {}
    for (;;)
    {
      return (LocalFilesystemURL)localObject1;
      Object localObject2 = Uri.fromFile(new File(paramUri.getPath()));
      String str = this.rootUri.getEncodedPath();
      str = str.substring(0, str.length() - 1);
      if (((Uri)localObject2).getEncodedPath().startsWith(str))
      {
        localObject2 = ((Uri)localObject2).getEncodedPath().substring(str.length());
        localObject1 = localObject2;
        if (!((String)localObject2).isEmpty()) {
          localObject1 = ((String)localObject2).substring(1);
        }
        localObject2 = new Uri.Builder().scheme("cdvfile").authority("localhost").path(this.name);
        if (!((String)localObject1).isEmpty()) {
          ((Uri.Builder)localObject2).appendEncodedPath((String)localObject1);
        }
        if ((isDirectory((String)localObject1)) || (paramUri.getPath().endsWith("/"))) {
          ((Uri.Builder)localObject2).appendEncodedPath("");
        }
        localObject1 = LocalFilesystemURL.parse(((Uri.Builder)localObject2).build());
      }
    }
  }
  
  public Uri toNativeUri(LocalFilesystemURL paramLocalFilesystemURL)
  {
    return nativeUriForFullPath(paramLocalFilesystemURL.path);
  }
  
  long truncateFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, long paramLong)
    throws IOException, NoModificationAllowedException
  {
    throw new NoModificationAllowedException("Assets are read-only");
  }
  
  long writeToFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, int paramInt, boolean paramBoolean)
    throws NoModificationAllowedException, IOException
  {
    throw new NoModificationAllowedException("Assets are read-only");
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\file\AssetFilesystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */