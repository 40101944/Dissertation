package org.apache.cordova.file;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaResourceApi.OpenForReadResult;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentFilesystem
  extends Filesystem
{
  private final Context context;
  
  public ContentFilesystem(Context paramContext, CordovaResourceApi paramCordovaResourceApi)
  {
    super(Uri.parse("content://"), "content", paramCordovaResourceApi);
    this.context = paramContext;
  }
  
  private Long resourceSizeForCursor(Cursor paramCursor)
  {
    int i = paramCursor.getColumnIndex("_size");
    if (i != -1)
    {
      paramCursor = paramCursor.getString(i);
      if (paramCursor == null) {}
    }
    for (paramCursor = Long.valueOf(Long.parseLong(paramCursor));; paramCursor = null) {
      return paramCursor;
    }
  }
  
  public LocalFilesystemURL URLforFilesystemPath(String paramString)
  {
    return null;
  }
  
  public boolean canRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
  {
    return true;
  }
  
  public String filesystemPathForURL(LocalFilesystemURL paramLocalFilesystemURL)
  {
    paramLocalFilesystemURL = this.resourceApi.mapUriToFile(toNativeUri(paramLocalFilesystemURL));
    if (paramLocalFilesystemURL == null) {}
    for (paramLocalFilesystemURL = null;; paramLocalFilesystemURL = paramLocalFilesystemURL.getAbsolutePath()) {
      return paramLocalFilesystemURL;
    }
  }
  
  public JSONObject getFileForLocalURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, JSONObject paramJSONObject, boolean paramBoolean)
    throws IOException, TypeMismatchException, JSONException
  {
    throw new UnsupportedOperationException("getFile() not supported for content:. Use resolveLocalFileSystemURL instead.");
  }
  
  public JSONObject getFileMetadataForLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileNotFoundException
  {
    long l1 = -1L;
    long l3 = 0L;
    Object localObject3 = toNativeUri(paramLocalFilesystemURL);
    localObject2 = this.resourceApi.getMimeType((Uri)localObject3);
    localObject1 = openCursorForURL((Uri)localObject3);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        if (((Cursor)localObject1).moveToFirst())
        {
          localObject3 = resourceSizeForCursor((Cursor)localObject1);
          if (localObject3 != null) {
            l1 = ((Long)localObject3).longValue();
          }
          localObject3 = lastModifiedDateForCursor((Cursor)localObject1);
          l2 = l1;
          if (localObject3 != null)
          {
            l3 = ((Long)localObject3).longValue();
            l2 = l1;
          }
          if (localObject1 != null) {
            ((Cursor)localObject1).close();
          }
          localObject1 = new JSONObject();
        }
      }
      catch (IOException paramLocalFilesystemURL)
      {
        long l2;
        localObject2 = new java/io/FileNotFoundException;
        ((FileNotFoundException)localObject2).<init>();
        ((FileNotFoundException)localObject2).initCause(paramLocalFilesystemURL);
        throw ((Throwable)localObject2);
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
      try
      {
        ((JSONObject)localObject1).put("size", l2);
        ((JSONObject)localObject1).put("type", localObject2);
        ((JSONObject)localObject1).put("name", this.name);
        ((JSONObject)localObject1).put("fullPath", paramLocalFilesystemURL.path);
        ((JSONObject)localObject1).put("lastModifiedDate", l3);
        paramLocalFilesystemURL = (LocalFilesystemURL)localObject1;
      }
      catch (JSONException paramLocalFilesystemURL)
      {
        paramLocalFilesystemURL = null;
        continue;
      }
      return paramLocalFilesystemURL;
      l2 = this.resourceApi.openForRead((Uri)localObject3).length;
    }
  }
  
  protected Long lastModifiedDateForCursor(Cursor paramCursor)
  {
    int j = paramCursor.getColumnIndex("date_modified");
    int i = j;
    if (j == -1) {
      i = paramCursor.getColumnIndex("last_modified");
    }
    if (i != -1)
    {
      paramCursor = paramCursor.getString(i);
      if (paramCursor == null) {}
    }
    for (paramCursor = Long.valueOf(Long.parseLong(paramCursor));; paramCursor = null) {
      return paramCursor;
    }
  }
  
  public LocalFilesystemURL[] listChildren(LocalFilesystemURL paramLocalFilesystemURL)
    throws FileNotFoundException
  {
    throw new UnsupportedOperationException("readEntriesAtLocalURL() not supported for content:. Use resolveLocalFileSystemURL instead.");
  }
  
  protected Cursor openCursorForURL(Uri paramUri)
  {
    ContentResolver localContentResolver = this.context.getContentResolver();
    try
    {
      paramUri = localContentResolver.query(paramUri, null, null, null, null);
      return paramUri;
    }
    catch (UnsupportedOperationException paramUri)
    {
      for (;;)
      {
        paramUri = null;
      }
    }
  }
  
  public boolean recursiveRemoveFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws NoModificationAllowedException
  {
    throw new NoModificationAllowedException("Cannot remove content url");
  }
  
  public boolean removeFileAtLocalURL(LocalFilesystemURL paramLocalFilesystemURL)
    throws NoModificationAllowedException
  {
    Object localObject = toNativeUri(paramLocalFilesystemURL);
    try
    {
      this.context.getContentResolver().delete((Uri)localObject, null, null);
      return true;
    }
    catch (UnsupportedOperationException paramLocalFilesystemURL)
    {
      localObject = new NoModificationAllowedException("Deleting not supported for content uri: " + localObject);
      ((NoModificationAllowedException)localObject).initCause(paramLocalFilesystemURL);
      throw ((Throwable)localObject);
    }
  }
  
  public LocalFilesystemURL toLocalUri(Uri paramUri)
  {
    if (!"content".equals(paramUri.getScheme())) {}
    Object localObject2;
    for (paramUri = null;; paramUri = LocalFilesystemURL.parse(((Uri.Builder)localObject2).encodedQuery(paramUri.getEncodedQuery()).encodedFragment(paramUri.getEncodedFragment()).build()))
    {
      return paramUri;
      localObject2 = paramUri.getEncodedPath();
      Object localObject1 = localObject2;
      if (((String)localObject2).length() > 0) {
        localObject1 = ((String)localObject2).substring(1);
      }
      localObject2 = new Uri.Builder().scheme("cdvfile").authority("localhost").path(this.name).appendPath(paramUri.getAuthority());
      if (((String)localObject1).length() > 0) {
        ((Uri.Builder)localObject2).appendEncodedPath((String)localObject1);
      }
    }
  }
  
  public Uri toNativeUri(LocalFilesystemURL paramLocalFilesystemURL)
  {
    Object localObject = paramLocalFilesystemURL.uri.getEncodedPath().substring(this.name.length() + 2);
    if (((String)localObject).length() < 2) {}
    for (paramLocalFilesystemURL = null;; paramLocalFilesystemURL = Uri.parse(paramLocalFilesystemURL))
    {
      return paramLocalFilesystemURL;
      String str1 = "content://" + (String)localObject;
      String str2 = paramLocalFilesystemURL.uri.getEncodedQuery();
      localObject = str1;
      if (str2 != null) {
        localObject = str1 + '?' + str2;
      }
      str1 = paramLocalFilesystemURL.uri.getEncodedFragment();
      paramLocalFilesystemURL = (LocalFilesystemURL)localObject;
      if (str1 != null) {
        paramLocalFilesystemURL = (String)localObject + '#' + str1;
      }
    }
  }
  
  public long truncateFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, long paramLong)
    throws NoModificationAllowedException
  {
    throw new NoModificationAllowedException("Couldn't truncate file given its content URI");
  }
  
  public long writeToFileAtURL(LocalFilesystemURL paramLocalFilesystemURL, String paramString, int paramInt, boolean paramBoolean)
    throws NoModificationAllowedException
  {
    throw new NoModificationAllowedException("Couldn't write to file given its content URI");
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\file\ContentFilesystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */