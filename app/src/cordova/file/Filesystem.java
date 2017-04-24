package org.apache.cordova.file;

import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaResourceApi.OpenForReadResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Filesystem
{
  public final String name;
  protected final CordovaResourceApi resourceApi;
  private JSONObject rootEntry;
  protected final Uri rootUri;
  
  public Filesystem(Uri paramUri, String paramString, CordovaResourceApi paramCordovaResourceApi)
  {
    this.rootUri = paramUri;
    this.name = paramString;
    this.resourceApi = paramCordovaResourceApi;
  }
  
  /* Error */
  public static JSONObject makeEntryForURL(LocalFilesystemURL paramLocalFilesystemURL, Uri paramUri)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 39	org/apache/cordova/file/LocalFilesystemURL:path	Ljava/lang/String;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc 41
    //   12: invokevirtual 47	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   15: ifeq +196 -> 211
    //   18: iconst_1
    //   19: istore_2
    //   20: aload 5
    //   22: iconst_0
    //   23: aload 5
    //   25: invokevirtual 51	java/lang/String:length	()I
    //   28: iload_2
    //   29: isub
    //   30: invokevirtual 55	java/lang/String:substring	(II)Ljava/lang/String;
    //   33: ldc 57
    //   35: invokevirtual 61	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   38: astore 6
    //   40: aload 6
    //   42: aload 6
    //   44: arraylength
    //   45: iconst_1
    //   46: isub
    //   47: aaload
    //   48: astore 7
    //   50: new 63	org/json/JSONObject
    //   53: astore 6
    //   55: aload 6
    //   57: invokespecial 64	org/json/JSONObject:<init>	()V
    //   60: aload_0
    //   61: getfield 68	org/apache/cordova/file/LocalFilesystemURL:isDirectory	Z
    //   64: ifne +152 -> 216
    //   67: iconst_1
    //   68: istore 4
    //   70: aload 6
    //   72: ldc 70
    //   74: iload 4
    //   76: invokevirtual 74	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload 6
    //   82: ldc 75
    //   84: aload_0
    //   85: getfield 68	org/apache/cordova/file/LocalFilesystemURL:isDirectory	Z
    //   88: invokevirtual 74	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   91: pop
    //   92: aload 6
    //   94: ldc 76
    //   96: aload 7
    //   98: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   101: pop
    //   102: aload 6
    //   104: ldc 81
    //   106: aload 5
    //   108: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   111: pop
    //   112: aload 6
    //   114: ldc 83
    //   116: aload_0
    //   117: getfield 86	org/apache/cordova/file/LocalFilesystemURL:fsName	Ljava/lang/String;
    //   120: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   123: pop
    //   124: ldc 88
    //   126: aload_0
    //   127: getfield 86	org/apache/cordova/file/LocalFilesystemURL:fsName	Ljava/lang/String;
    //   130: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifeq +89 -> 222
    //   136: iload_3
    //   137: istore_2
    //   138: aload 6
    //   140: ldc 94
    //   142: iload_2
    //   143: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   146: pop
    //   147: aload_1
    //   148: invokevirtual 103	android/net/Uri:toString	()Ljava/lang/String;
    //   151: astore 5
    //   153: aload 5
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 68	org/apache/cordova/file/LocalFilesystemURL:isDirectory	Z
    //   160: ifeq +39 -> 199
    //   163: aload 5
    //   165: astore_1
    //   166: aload 5
    //   168: ldc 41
    //   170: invokevirtual 47	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   173: ifne +26 -> 199
    //   176: new 105	java/lang/StringBuilder
    //   179: astore_0
    //   180: aload_0
    //   181: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   184: aload_0
    //   185: aload 5
    //   187: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 41
    //   192: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore_1
    //   199: aload 6
    //   201: ldc 113
    //   203: aload_1
    //   204: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 6
    //   210: areturn
    //   211: iconst_0
    //   212: istore_2
    //   213: goto -193 -> 20
    //   216: iconst_0
    //   217: istore 4
    //   219: goto -149 -> 70
    //   222: iconst_1
    //   223: istore_2
    //   224: goto -86 -> 138
    //   227: astore_0
    //   228: aload_0
    //   229: invokevirtual 116	org/json/JSONException:printStackTrace	()V
    //   232: new 118	java/lang/RuntimeException
    //   235: dup
    //   236: aload_0
    //   237: invokespecial 121	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramLocalFilesystemURL	LocalFilesystemURL
    //   0	241	1	paramUri	Uri
    //   19	205	2	i	int
    //   1	136	3	j	int
    //   68	150	4	bool	boolean
    //   6	180	5	str	String
    //   38	171	6	localObject1	Object
    //   48	49	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	227	org/json/JSONException
    //   20	67	227	org/json/JSONException
    //   70	136	227	org/json/JSONException
    //   138	153	227	org/json/JSONException
    //   156	163	227	org/json/JSONException
    //   166	199	227	org/json/JSONException
    //   199	208	227	org/json/JSONException
  }
  
  protected static String normalizePath(String paramString)
  {
    boolean bool = paramString.startsWith("/");
    Object localObject = paramString;
    if (bool) {
      localObject = paramString.replaceFirst("/+", "");
    }
    localObject = new ArrayList(Arrays.asList(((String)localObject).split("/+")));
    int j;
    for (int i = 0; i < ((ArrayList)localObject).size(); i = j + 1)
    {
      j = i;
      if (((String)((ArrayList)localObject).get(i)).equals(".."))
      {
        ((ArrayList)localObject).remove(i);
        j = i;
        if (i > 0)
        {
          ((ArrayList)localObject).remove(i - 1);
          j = i - 1;
        }
      }
    }
    paramString = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      paramString.append("/");
      paramString.append(str);
    }
    if (bool) {}
    for (paramString = paramString.toString();; paramString = paramString.toString().substring(1)) {
      return paramString;
    }
  }
  
  abstract LocalFilesystemURL URLforFilesystemPath(String paramString);
  
  abstract boolean canRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL);
  
  public JSONObject copyFileToURL(LocalFilesystemURL paramLocalFilesystemURL1, String paramString, Filesystem paramFilesystem, LocalFilesystemURL paramLocalFilesystemURL2, boolean paramBoolean)
    throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException
  {
    if ((paramBoolean) && (!paramFilesystem.canRemoveFileAtLocalURL(paramLocalFilesystemURL2))) {
      throw new NoModificationAllowedException("Cannot move file at source URL");
    }
    paramLocalFilesystemURL1 = makeDestinationURL(paramString, paramLocalFilesystemURL2, paramLocalFilesystemURL1, paramLocalFilesystemURL2.isDirectory);
    paramString = paramFilesystem.toNativeUri(paramLocalFilesystemURL2);
    paramString = this.resourceApi.openForRead(paramString);
    try
    {
      OutputStream localOutputStream = getOutputStreamForURL(paramLocalFilesystemURL1);
      this.resourceApi.copyResource(paramString, localOutputStream);
      if (paramBoolean) {
        paramFilesystem.removeFileAtLocalURL(paramLocalFilesystemURL2);
      }
      return getEntryForLocalURL(paramLocalFilesystemURL1);
    }
    catch (IOException paramLocalFilesystemURL1)
    {
      paramString.inputStream.close();
      throw paramLocalFilesystemURL1;
    }
  }
  
  public boolean exists(LocalFilesystemURL paramLocalFilesystemURL)
  {
    try
    {
      getFileMetadataForLocalURL(paramLocalFilesystemURL);
      bool = true;
    }
    catch (FileNotFoundException paramLocalFilesystemURL)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
  
  abstract String filesystemPathForURL(LocalFilesystemURL paramLocalFilesystemURL);
  
  public JSONObject getEntryForLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws IOException
  {
    return makeEntryForURL(paramLocalFilesystemURL);
  }
  
  abstract JSONObject getFileForLocalURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, JSONObject paramJSONObject, boolean paramBoolean)
    throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException;
  
  abstract JSONObject getFileMetadataForLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileNotFoundException;
  
  public long getFreeSpaceInBytes()
  {
    return 0L;
  }
  
  public OutputStream getOutputStreamForURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws IOException
  {
    return this.resourceApi.openOutputStream(toNativeUri(paramLocalFilesystemURL));
  }
  
  public JSONObject getParentForLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws IOException
  {
    Uri localUri = paramLocalFilesystemURL.uri;
    String str = new File(paramLocalFilesystemURL.uri.getPath()).getParent();
    if (!"/".equals(str)) {
      localUri = paramLocalFilesystemURL.uri.buildUpon().path(str + '/').build();
    }
    return getEntryForLocalURL(LocalFilesystemURL.parse(localUri));
  }
  
  public JSONObject getRootEntry()
  {
    if (this.rootEntry == null) {
      this.rootEntry = makeEntryForNativeUri(this.rootUri);
    }
    return this.rootEntry;
  }
  
  public Uri getRootUri()
  {
    return this.rootUri;
  }
  
  abstract LocalFilesystemURL[] listChildren(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileNotFoundException;
  
  public LocalFilesystemURL localUrlforFullPath(String paramString)
  {
    paramString = nativeUriForFullPath(paramString);
    if (paramString != null) {}
    for (paramString = toLocalUri(paramString);; paramString = null) {
      return paramString;
    }
  }
  
  protected LocalFilesystemURL makeDestinationURL(String paramString, LocalFilesystemURL paramLocalFilesystemURL1, LocalFilesystemURL paramLocalFilesystemURL2, boolean paramBoolean)
  {
    String str;
    if (!"null".equals(paramString))
    {
      str = paramString;
      if (!"".equals(paramString)) {}
    }
    else
    {
      str = paramLocalFilesystemURL1.uri.getLastPathSegment();
    }
    paramString = paramLocalFilesystemURL2.uri.toString();
    if (paramString.endsWith("/")) {}
    for (paramString = paramString + str;; paramString = paramString + "/" + str)
    {
      paramLocalFilesystemURL1 = paramString;
      if (paramBoolean) {
        paramLocalFilesystemURL1 = paramString + '/';
      }
      return LocalFilesystemURL.parse(paramLocalFilesystemURL1);
    }
  }
  
  public JSONObject makeEntryForFile(File paramFile)
  {
    return makeEntryForNativeUri(Uri.fromFile(paramFile));
  }
  
  public JSONObject makeEntryForNativeUri(Uri paramUri)
  {
    LocalFilesystemURL localLocalFilesystemURL = toLocalUri(paramUri);
    if (localLocalFilesystemURL == null) {}
    for (paramUri = null;; paramUri = makeEntryForURL(localLocalFilesystemURL, paramUri)) {
      return paramUri;
    }
  }
  
  public JSONObject makeEntryForURL(LocalFilesystemURL paramLocalFilesystemURL)
  {
    Uri localUri = toNativeUri(paramLocalFilesystemURL);
    if (localUri == null) {}
    for (paramLocalFilesystemURL = null;; paramLocalFilesystemURL = makeEntryForURL(paramLocalFilesystemURL, localUri)) {
      return paramLocalFilesystemURL;
    }
  }
  
  public Uri nativeUriForFullPath(String paramString)
  {
    Object localObject = null;
    if (paramString != null)
    {
      localObject = Uri.fromFile(new File(paramString)).getEncodedPath();
      paramString = (String)localObject;
      if (((String)localObject).startsWith("/")) {
        paramString = ((String)localObject).substring(1);
      }
      localObject = this.rootUri.buildUpon().appendEncodedPath(paramString).build();
    }
    return (Uri)localObject;
  }
  
  public final JSONArray readEntriesAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileNotFoundException
  {
    LocalFilesystemURL[] arrayOfLocalFilesystemURL = listChildren(paramLocalFilesystemURL);
    paramLocalFilesystemURL = new JSONArray();
    if (arrayOfLocalFilesystemURL != null)
    {
      int j = arrayOfLocalFilesystemURL.length;
      for (int i = 0; i < j; i++) {
        paramLocalFilesystemURL.put(makeEntryForURL(arrayOfLocalFilesystemURL[i]));
      }
    }
    return paramLocalFilesystemURL;
  }
  
  public void readFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, long paramLong1, long paramLong2, ReadFileCallback paramReadFileCallback)
    throws IOException
  {
    CordovaResourceApi.OpenForReadResult localOpenForReadResult = this.resourceApi.openForRead(toNativeUri(paramLocalFilesystemURL));
    long l = paramLong2;
    if (paramLong2 < 0L) {
      l = localOpenForReadResult.length;
    }
    if (paramLong1 > 0L) {}
    try
    {
      localOpenForReadResult.inputStream.skip(paramLong1);
      InputStream localInputStream = localOpenForReadResult.inputStream;
      paramLocalFilesystemURL = localInputStream;
      if (l < localOpenForReadResult.length)
      {
        paramLocalFilesystemURL = new org/apache/cordova/file/Filesystem$LimitedInputStream;
        paramLocalFilesystemURL.<init>(this, localInputStream, l - paramLong1);
      }
      paramReadFileCallback.handleData(paramLocalFilesystemURL, localOpenForReadResult.mimeType);
      return;
    }
    finally
    {
      localOpenForReadResult.inputStream.close();
    }
  }
  
  abstract boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileExistsException, NoModificationAllowedException;
  
  abstract boolean removeFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws InvalidModificationException, NoModificationAllowedException;
  
  public abstract LocalFilesystemURL toLocalUri(Uri paramUri);
  
  public abstract Uri toNativeUri(LocalFilesystemURL paramLocalFilesystemURL);
  
  abstract long truncateFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, long paramLong)
    throws IOException, NoModificationAllowedException;
  
  abstract long writeToFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, int paramInt, boolean paramBoolean)
    throws NoModificationAllowedException, IOException;
  
  protected class LimitedInputStream
    extends FilterInputStream
  {
    long numBytesToRead;
    
    public LimitedInputStream(InputStream paramInputStream, long paramLong)
    {
      super();
      this.numBytesToRead = paramLong;
    }
    
    public int read()
      throws IOException
    {
      if (this.numBytesToRead <= 0L) {}
      for (int i = -1;; i = this.in.read())
      {
        return i;
        this.numBytesToRead -= 1L;
      }
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.numBytesToRead <= 0L) {
        paramInt1 = -1;
      }
      for (;;)
      {
        return paramInt1;
        int i = paramInt2;
        if (paramInt2 > this.numBytesToRead) {
          i = (int)this.numBytesToRead;
        }
        paramInt1 = this.in.read(paramArrayOfByte, paramInt1, i);
        this.numBytesToRead -= paramInt1;
      }
    }
  }
  
  public static abstract interface ReadFileCallback
  {
    public abstract void handleData(InputStream paramInputStream, String paramString)
      throws IOException;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\file\Filesystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */