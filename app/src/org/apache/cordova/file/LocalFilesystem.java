package org.apache.cordova.file;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.cordova.CordovaResourceApi;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalFilesystem
  extends Filesystem
{
  private final Context context;
  
  public LocalFilesystem(String paramString, Context paramContext, CordovaResourceApi paramCordovaResourceApi, File paramFile)
  {
    super(Uri.fromFile(paramFile).buildUpon().appendEncodedPath("").build(), paramString, paramCordovaResourceApi);
    this.context = paramContext;
  }
  
  private void broadcastNewFile(Uri paramUri)
  {
    paramUri = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", paramUri);
    this.context.sendBroadcast(paramUri);
  }
  
  private void copyDirectory(Filesystem paramFilesystem, LocalFilesystemURL paramLocalFilesystemURL, File paramFile, boolean paramBoolean)
    throws IOException, NoModificationAllowedException, InvalidModificationException, FileExistsException
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramFilesystem.filesystemPathForURL(paramLocalFilesystemURL);
      if (localObject != null)
      {
        localObject = new File((String)localObject);
        if (paramFile.exists())
        {
          if (paramFile.list().length > 0) {
            throw new InvalidModificationException("directory is not empty");
          }
          paramFile.delete();
        }
        if (!((File)localObject).renameTo(paramFile)) {}
      }
    }
    for (;;)
    {
      return;
      if (paramFile.exists())
      {
        if (paramFile.list().length > 0) {
          throw new InvalidModificationException("directory is not empty");
        }
      }
      else if (!paramFile.mkdir()) {
        throw new NoModificationAllowedException("Couldn't create the destination directory");
      }
      LocalFilesystemURL[] arrayOfLocalFilesystemURL = paramFilesystem.listChildren(paramLocalFilesystemURL);
      int j = arrayOfLocalFilesystemURL.length;
      int i = 0;
      if (i < j)
      {
        localObject = arrayOfLocalFilesystemURL[i];
        File localFile = new File(paramFile, new File(((LocalFilesystemURL)localObject).path).getName());
        if (((LocalFilesystemURL)localObject).isDirectory) {
          copyDirectory(paramFilesystem, (LocalFilesystemURL)localObject, localFile, false);
        }
        for (;;)
        {
          i++;
          break;
          copyFile(paramFilesystem, (LocalFilesystemURL)localObject, localFile, false);
        }
      }
      if (paramBoolean) {
        paramFilesystem.recursiveRemoveFileAtLocalURL(paramLocalFilesystemURL);
      }
    }
  }
  
  private void copyFile(Filesystem paramFilesystem, LocalFilesystemURL paramLocalFilesystemURL, File paramFile, boolean paramBoolean)
    throws IOException, InvalidModificationException, NoModificationAllowedException
  {
    if (paramBoolean)
    {
      String str = paramFilesystem.filesystemPathForURL(paramLocalFilesystemURL);
      if ((str == null) || (!new File(str).renameTo(paramFile))) {}
    }
    for (;;)
    {
      return;
      copyResource(this.resourceApi.openForRead(paramFilesystem.toNativeUri(paramLocalFilesystemURL)), new FileOutputStream(paramFile));
      if (paramBoolean) {
        paramFilesystem.removeFileAtLocalURL(paramLocalFilesystemURL);
      }
    }
  }
  
  /* Error */
  private static void copyResource(org.apache.cordova.CordovaResourceApi.OpenForReadResult paramOpenForReadResult, java.io.OutputStream paramOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 157	org/apache/cordova/CordovaResourceApi$OpenForReadResult:inputStream	Ljava/io/InputStream;
    //   4: astore 8
    //   6: aload 8
    //   8: instanceof 159
    //   11: ifeq +88 -> 99
    //   14: aload_1
    //   15: instanceof 141
    //   18: ifeq +81 -> 99
    //   21: aload_0
    //   22: getfield 157	org/apache/cordova/CordovaResourceApi$OpenForReadResult:inputStream	Ljava/io/InputStream;
    //   25: checkcast 159	java/io/FileInputStream
    //   28: invokevirtual 163	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   31: astore 8
    //   33: aload_1
    //   34: checkcast 141	java/io/FileOutputStream
    //   37: invokevirtual 164	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   40: astore 7
    //   42: lconst_0
    //   43: lstore_3
    //   44: aload_0
    //   45: getfield 168	org/apache/cordova/CordovaResourceApi$OpenForReadResult:length	J
    //   48: lstore 5
    //   50: aload_0
    //   51: getfield 172	org/apache/cordova/CordovaResourceApi$OpenForReadResult:assetFd	Landroid/content/res/AssetFileDescriptor;
    //   54: ifnull +11 -> 65
    //   57: aload_0
    //   58: getfield 172	org/apache/cordova/CordovaResourceApi$OpenForReadResult:assetFd	Landroid/content/res/AssetFileDescriptor;
    //   61: invokevirtual 178	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   64: lstore_3
    //   65: aload 8
    //   67: lload_3
    //   68: invokevirtual 184	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   71: pop
    //   72: aload 7
    //   74: aload 8
    //   76: lconst_0
    //   77: lload 5
    //   79: invokevirtual 188	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   82: pop2
    //   83: aload_0
    //   84: getfield 157	org/apache/cordova/CordovaResourceApi$OpenForReadResult:inputStream	Ljava/io/InputStream;
    //   87: invokevirtual 194	java/io/InputStream:close	()V
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 197	java/io/OutputStream:close	()V
    //   98: return
    //   99: sipush 8192
    //   102: newarray <illegal type>
    //   104: astore 7
    //   106: aload 8
    //   108: aload 7
    //   110: iconst_0
    //   111: sipush 8192
    //   114: invokevirtual 201	java/io/InputStream:read	([BII)I
    //   117: istore_2
    //   118: iload_2
    //   119: ifle -36 -> 83
    //   122: aload_1
    //   123: aload 7
    //   125: iconst_0
    //   126: iload_2
    //   127: invokevirtual 205	java/io/OutputStream:write	([BII)V
    //   130: goto -24 -> 106
    //   133: astore 7
    //   135: aload_0
    //   136: getfield 157	org/apache/cordova/CordovaResourceApi$OpenForReadResult:inputStream	Ljava/io/InputStream;
    //   139: invokevirtual 194	java/io/InputStream:close	()V
    //   142: aload_1
    //   143: ifnull +7 -> 150
    //   146: aload_1
    //   147: invokevirtual 197	java/io/OutputStream:close	()V
    //   150: aload 7
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramOpenForReadResult	org.apache.cordova.CordovaResourceApi.OpenForReadResult
    //   0	153	1	paramOutputStream	java.io.OutputStream
    //   117	10	2	i	int
    //   43	25	3	l1	long
    //   48	30	5	l2	long
    //   40	84	7	localObject1	Object
    //   133	18	7	localObject2	Object
    //   4	103	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	42	133	finally
    //   44	50	133	finally
    //   50	65	133	finally
    //   65	83	133	finally
    //   99	106	133	finally
    //   106	118	133	finally
    //   122	130	133	finally
  }
  
  private String fullPathForFilesystemPath(String paramString)
  {
    if ((paramString != null) && (paramString.startsWith(this.rootUri.getPath()))) {}
    for (paramString = paramString.substring(this.rootUri.getPath().length() - 1);; paramString = null) {
      return paramString;
    }
  }
  
  private boolean isPublicDirectory(String paramString)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 21)
    {
      File[] arrayOfFile = this.context.getExternalMediaDirs();
      int j = arrayOfFile.length;
      i = 0;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if ((localFile == null) || (!paramString.startsWith(localFile.getAbsolutePath()))) {}
      }
    }
    for (boolean bool = true;; bool = paramString.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath()))
    {
      return bool;
      i++;
      break;
    }
  }
  
  public LocalFilesystemURL URLforFilesystemPath(String paramString)
  {
    return localUrlforFullPath(fullPathForFilesystemPath(paramString));
  }
  
  public boolean canRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
  {
    return new File(filesystemPathForURL(paramLocalFilesystemURL)).exists();
  }
  
  public JSONObject copyFileToURL(LocalFilesystemURL paramLocalFilesystemURL1, String paramString, Filesystem paramFilesystem, LocalFilesystemURL paramLocalFilesystemURL2, boolean paramBoolean)
    throws IOException, InvalidModificationException, JSONException, NoModificationAllowedException, FileExistsException
  {
    if (!new File(filesystemPathForURL(paramLocalFilesystemURL1)).exists()) {
      throw new FileNotFoundException("The source does not exist");
    }
    paramString = makeDestinationURL(paramString, paramLocalFilesystemURL2, paramLocalFilesystemURL1, paramLocalFilesystemURL2.isDirectory);
    paramLocalFilesystemURL1 = toNativeUri(paramString);
    Uri localUri = paramFilesystem.toNativeUri(paramLocalFilesystemURL2);
    if (paramLocalFilesystemURL1.equals(localUri)) {
      throw new InvalidModificationException("Can't copy onto itself");
    }
    if ((paramBoolean) && (!paramFilesystem.canRemoveFileAtLocalURL(paramLocalFilesystemURL2))) {
      throw new InvalidModificationException("Source URL is read-only (cannot move)");
    }
    File localFile = new File(paramLocalFilesystemURL1.getPath());
    if (localFile.exists())
    {
      if ((!paramLocalFilesystemURL2.isDirectory) && (localFile.isDirectory())) {
        throw new InvalidModificationException("Can't copy/move a file to an existing directory");
      }
      if ((paramLocalFilesystemURL2.isDirectory) && (localFile.isFile())) {
        throw new InvalidModificationException("Can't copy/move a directory to an existing file");
      }
    }
    if (paramLocalFilesystemURL2.isDirectory)
    {
      if (paramLocalFilesystemURL1.toString().startsWith(localUri.toString() + '/')) {
        throw new InvalidModificationException("Can't copy directory into itself");
      }
      copyDirectory(paramFilesystem, paramLocalFilesystemURL2, localFile, paramBoolean);
    }
    for (;;)
    {
      return makeEntryForURL(paramString);
      copyFile(paramFilesystem, paramLocalFilesystemURL2, localFile, paramBoolean);
    }
  }
  
  public boolean exists(LocalFilesystemURL paramLocalFilesystemURL)
  {
    return new File(filesystemPathForURL(paramLocalFilesystemURL)).exists();
  }
  
  public String filesystemPathForFullPath(String paramString)
  {
    return new File(this.rootUri.getPath(), paramString).toString();
  }
  
  public String filesystemPathForURL(LocalFilesystemURL paramLocalFilesystemURL)
  {
    return filesystemPathForFullPath(paramLocalFilesystemURL.path);
  }
  
  public JSONObject getFileForLocalURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, JSONObject paramJSONObject, boolean paramBoolean)
    throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException
  {
    int i = 0;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (paramJSONObject != null)
    {
      boolean bool2 = paramJSONObject.optBoolean("create");
      i = bool2;
      bool1 = bool3;
      if (bool2)
      {
        bool1 = paramJSONObject.optBoolean("exclusive");
        i = bool2;
      }
    }
    if (paramString.contains(":")) {
      throw new EncodingException("This path has an invalid \":\" in it.");
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
    for (paramLocalFilesystemURL = localUrlforFullPath(normalizePath(paramJSONObject));; paramLocalFilesystemURL = localUrlforFullPath(normalizePath(paramLocalFilesystemURL.path + "/" + paramJSONObject)))
    {
      paramString = new File(filesystemPathForURL(paramLocalFilesystemURL));
      if (i == 0) {
        break label244;
      }
      if ((!bool1) || (!paramString.exists())) {
        break;
      }
      throw new FileExistsException("create/exclusive fails");
    }
    if (paramBoolean) {
      paramString.mkdir();
    }
    while (!paramString.exists())
    {
      throw new FileExistsException("create fails");
      paramString.createNewFile();
    }
    label244:
    if (!paramString.exists()) {
      throw new FileNotFoundException("path does not exist");
    }
    if (paramBoolean)
    {
      if (paramString.isFile()) {
        throw new TypeMismatchException("path doesn't exist or is file");
      }
    }
    else if (paramString.isDirectory()) {
      throw new TypeMismatchException("path doesn't exist or is directory");
    }
    return makeEntryForURL(paramLocalFilesystemURL);
  }
  
  public JSONObject getFileMetadataForLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileNotFoundException
  {
    File localFile = new File(filesystemPathForURL(paramLocalFilesystemURL));
    if (!localFile.exists()) {
      throw new FileNotFoundException("File at " + paramLocalFilesystemURL.uri + " does not exist.");
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!localFile.isDirectory()) {
          continue;
        }
        l = 0L;
        localJSONObject.put("size", l);
        localJSONObject.put("type", this.resourceApi.getMimeType(Uri.fromFile(localFile)));
        localJSONObject.put("name", localFile.getName());
        localJSONObject.put("fullPath", paramLocalFilesystemURL.path);
        localJSONObject.put("lastModifiedDate", localFile.lastModified());
        paramLocalFilesystemURL = localJSONObject;
      }
      catch (JSONException paramLocalFilesystemURL)
      {
        long l;
        paramLocalFilesystemURL = null;
        continue;
      }
      return paramLocalFilesystemURL;
      l = localFile.length();
    }
  }
  
  public long getFreeSpaceInBytes()
  {
    return DirectoryManager.getFreeSpaceInBytes(this.rootUri.getPath());
  }
  
  public LocalFilesystemURL[] listChildren(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileNotFoundException
  {
    paramLocalFilesystemURL = new File(filesystemPathForURL(paramLocalFilesystemURL));
    if (!paramLocalFilesystemURL.exists()) {
      throw new FileNotFoundException();
    }
    File[] arrayOfFile = paramLocalFilesystemURL.listFiles();
    if (arrayOfFile == null)
    {
      paramLocalFilesystemURL = null;
      return paramLocalFilesystemURL;
    }
    LocalFilesystemURL[] arrayOfLocalFilesystemURL = new LocalFilesystemURL[arrayOfFile.length];
    for (int i = 0;; i++)
    {
      paramLocalFilesystemURL = arrayOfLocalFilesystemURL;
      if (i >= arrayOfFile.length) {
        break;
      }
      arrayOfLocalFilesystemURL[i] = URLforFilesystemPath(arrayOfFile[i].getPath());
    }
  }
  
  public boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileExistsException
  {
    return removeDirRecursively(new File(filesystemPathForURL(paramLocalFilesystemURL)));
  }
  
  protected boolean removeDirRecursively(File paramFile)
    throws FileExistsException
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++) {
        removeDirRecursively(arrayOfFile[i]);
      }
    }
    if (!paramFile.delete()) {
      throw new FileExistsException("could not delete: " + paramFile.getName());
    }
    return true;
  }
  
  public boolean removeFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws InvalidModificationException
  {
    paramLocalFilesystemURL = new File(filesystemPathForURL(paramLocalFilesystemURL));
    if ((paramLocalFilesystemURL.isDirectory()) && (paramLocalFilesystemURL.list().length > 0)) {
      throw new InvalidModificationException("You can't delete a directory that is not empty.");
    }
    return paramLocalFilesystemURL.delete();
  }
  
  public LocalFilesystemURL toLocalUri(Uri paramUri)
  {
    Object localObject = null;
    if (!"file".equals(paramUri.getScheme())) {
      paramUri = (Uri)localObject;
    }
    for (;;)
    {
      return paramUri;
      File localFile = new File(paramUri.getPath());
      Uri localUri = Uri.fromFile(localFile);
      paramUri = this.rootUri.getEncodedPath();
      String str = paramUri.substring(0, paramUri.length() - 1);
      paramUri = (Uri)localObject;
      if (localUri.getEncodedPath().startsWith(str))
      {
        localObject = localUri.getEncodedPath().substring(str.length());
        paramUri = (Uri)localObject;
        if (!((String)localObject).isEmpty()) {
          paramUri = ((String)localObject).substring(1);
        }
        localObject = new Uri.Builder().scheme("cdvfile").authority("localhost").path(this.name);
        if (!paramUri.isEmpty()) {
          ((Uri.Builder)localObject).appendEncodedPath(paramUri);
        }
        if (localFile.isDirectory()) {
          ((Uri.Builder)localObject).appendEncodedPath("");
        }
        paramUri = LocalFilesystemURL.parse(((Uri.Builder)localObject).build());
      }
    }
  }
  
  public Uri toNativeUri(LocalFilesystemURL paramLocalFilesystemURL)
  {
    return nativeUriForFullPath(paramLocalFilesystemURL.path);
  }
  
  /* Error */
  public long truncateFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: new 67	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 256	org/apache/cordova/file/LocalFilesystem:filesystemPathForURL	(Lorg/apache/cordova/file/LocalFilesystemURL;)Ljava/lang/String;
    //   9: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokevirtual 74	java/io/File:exists	()Z
    //   15: ifne +40 -> 55
    //   18: new 262	java/io/FileNotFoundException
    //   21: dup
    //   22: new 294	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 367
    //   32: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: getfield 370	org/apache/cordova/file/LocalFilesystemURL:uri	Landroid/net/Uri;
    //   39: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   42: ldc_w 375
    //   45: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 265	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   54: athrow
    //   55: new 465	java/io/RandomAccessFile
    //   58: dup
    //   59: aload_0
    //   60: aload_1
    //   61: invokevirtual 256	org/apache/cordova/file/LocalFilesystem:filesystemPathForURL	(Lorg/apache/cordova/file/LocalFilesystemURL;)Ljava/lang/String;
    //   64: ldc_w 467
    //   67: invokespecial 468	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 469	java/io/RandomAccessFile:length	()J
    //   75: lload_2
    //   76: lcmp
    //   77: iflt +18 -> 95
    //   80: aload_1
    //   81: invokevirtual 470	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   84: lload_2
    //   85: invokevirtual 473	java/nio/channels/FileChannel:truncate	(J)Ljava/nio/channels/FileChannel;
    //   88: pop
    //   89: aload_1
    //   90: invokevirtual 474	java/io/RandomAccessFile:close	()V
    //   93: lload_2
    //   94: lreturn
    //   95: aload_1
    //   96: invokevirtual 469	java/io/RandomAccessFile:length	()J
    //   99: lstore_2
    //   100: aload_1
    //   101: invokevirtual 474	java/io/RandomAccessFile:close	()V
    //   104: goto -11 -> 93
    //   107: astore 4
    //   109: aload_1
    //   110: invokevirtual 474	java/io/RandomAccessFile:close	()V
    //   113: aload 4
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	LocalFilesystem
    //   0	116	1	paramLocalFilesystemURL	LocalFilesystemURL
    //   0	116	2	paramLong	long
    //   107	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   71	89	107	finally
    //   95	100	107	finally
  }
  
  /* Error */
  public long writeToFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, NoModificationAllowedException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iload_3
    //   4: ifle +14 -> 18
    //   7: aload_0
    //   8: aload_1
    //   9: iload_3
    //   10: i2l
    //   11: invokevirtual 480	org/apache/cordova/file/LocalFilesystem:truncateFileAtURL	(Lorg/apache/cordova/file/LocalFilesystemURL;J)J
    //   14: pop2
    //   15: iconst_1
    //   16: istore 5
    //   18: iload 4
    //   20: ifeq +112 -> 132
    //   23: aload_2
    //   24: iconst_0
    //   25: invokestatic 486	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   28: astore_2
    //   29: new 488	java/io/ByteArrayInputStream
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 491	java/io/ByteArrayInputStream:<init>	([B)V
    //   37: astore 9
    //   39: aload_2
    //   40: arraylength
    //   41: newarray <illegal type>
    //   43: astore 8
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 256	org/apache/cordova/file/LocalFilesystem:filesystemPathForURL	(Lorg/apache/cordova/file/LocalFilesystemURL;)Ljava/lang/String;
    //   50: astore 7
    //   52: new 141	java/io/FileOutputStream
    //   55: astore 6
    //   57: aload 6
    //   59: aload 7
    //   61: iload 5
    //   63: invokespecial 494	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   66: aload 9
    //   68: aload 8
    //   70: iconst_0
    //   71: aload 8
    //   73: arraylength
    //   74: invokevirtual 495	java/io/ByteArrayInputStream:read	([BII)I
    //   77: pop
    //   78: aload 6
    //   80: aload 8
    //   82: iconst_0
    //   83: aload_2
    //   84: arraylength
    //   85: invokevirtual 496	java/io/FileOutputStream:write	([BII)V
    //   88: aload 6
    //   90: invokevirtual 499	java/io/FileOutputStream:flush	()V
    //   93: aload 6
    //   95: invokevirtual 500	java/io/FileOutputStream:close	()V
    //   98: aload_0
    //   99: aload 7
    //   101: invokespecial 502	org/apache/cordova/file/LocalFilesystem:isPublicDirectory	(Ljava/lang/String;)Z
    //   104: ifeq +24 -> 128
    //   107: new 67	java/io/File
    //   110: astore 6
    //   112: aload 6
    //   114: aload 7
    //   116: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: aload_0
    //   120: aload 6
    //   122: invokestatic 14	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   125: invokespecial 504	org/apache/cordova/file/LocalFilesystem:broadcastNewFile	(Landroid/net/Uri;)V
    //   128: aload_2
    //   129: arraylength
    //   130: i2l
    //   131: lreturn
    //   132: aload_2
    //   133: invokestatic 510	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   136: invokevirtual 514	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   139: astore_2
    //   140: goto -111 -> 29
    //   143: astore_2
    //   144: aload 6
    //   146: invokevirtual 500	java/io/FileOutputStream:close	()V
    //   149: aload_2
    //   150: athrow
    //   151: astore_2
    //   152: new 57	org/apache/cordova/file/NoModificationAllowedException
    //   155: dup
    //   156: aload_1
    //   157: invokevirtual 515	org/apache/cordova/file/LocalFilesystemURL:toString	()Ljava/lang/String;
    //   160: invokespecial 94	org/apache/cordova/file/NoModificationAllowedException:<init>	(Ljava/lang/String;)V
    //   163: astore_1
    //   164: aload_1
    //   165: aload_2
    //   166: invokevirtual 519	org/apache/cordova/file/NoModificationAllowedException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   169: pop
    //   170: aload_1
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	LocalFilesystem
    //   0	172	1	paramLocalFilesystemURL	LocalFilesystemURL
    //   0	172	2	paramString	String
    //   0	172	3	paramInt	int
    //   0	172	4	paramBoolean	boolean
    //   1	61	5	bool	boolean
    //   55	90	6	localObject	Object
    //   50	65	7	str	String
    //   43	38	8	arrayOfByte	byte[]
    //   37	30	9	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   66	93	143	finally
    //   39	66	151	java/lang/NullPointerException
    //   93	128	151	java/lang/NullPointerException
    //   144	151	151	java/lang/NullPointerException
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\file\LocalFilesystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */