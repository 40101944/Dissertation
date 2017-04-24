package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.zzafu.zza;
import com.google.android.gms.internal.zzafw;
import com.google.android.gms.internal.zzafw.zzc;
import com.google.android.gms.internal.zzafw.zzg;
import com.google.android.gms.internal.zzai.zzf;
import com.google.android.gms.internal.zzarz;
import com.google.android.gms.internal.zzasa;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class zzcv
  implements zzp.zzf
{
  private final String aDY;
  private zzbn<zzafu.zza> aGB;
  private final ExecutorService aGI;
  private final Context mContext;
  
  zzcv(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.aDY = paramString;
    this.aGI = Executors.newSingleThreadExecutor();
  }
  
  private zzafw.zzc zza(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    Object localObject = null;
    try
    {
      paramByteArrayOutputStream = zzbh.zzpm(paramByteArrayOutputStream.toString("UTF-8"));
      return paramByteArrayOutputStream;
    }
    catch (UnsupportedEncodingException paramByteArrayOutputStream)
    {
      for (;;)
      {
        zzbo.zzdg("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
        paramByteArrayOutputStream = (ByteArrayOutputStream)localObject;
      }
    }
    catch (JSONException paramByteArrayOutputStream)
    {
      for (;;)
      {
        zzbo.zzdi("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
        paramByteArrayOutputStream = (ByteArrayOutputStream)localObject;
      }
    }
  }
  
  private zzafw.zzc zzal(byte[] paramArrayOfByte)
  {
    try
    {
      zzafw.zzc localzzc = zzafw.zzb(zzai.zzf.zzf(paramArrayOfByte));
      paramArrayOfByte = localzzc;
      if (localzzc != null)
      {
        zzbo.v("The container was successfully loaded from the resource (using binary file)");
        paramArrayOfByte = localzzc;
      }
    }
    catch (zzarz paramArrayOfByte)
    {
      for (;;)
      {
        zzbo.e("The resource file is corrupted. The container cannot be extracted from the binary file");
        paramArrayOfByte = null;
      }
    }
    catch (zzafw.zzg paramArrayOfByte)
    {
      for (;;)
      {
        zzbo.zzdi("The resource file is invalid. The container from the binary file is invalid");
        paramArrayOfByte = null;
      }
    }
    return paramArrayOfByte;
  }
  
  private void zzd(zzafu.zza paramzza)
    throws IllegalArgumentException
  {
    if ((paramzza.zzxv == null) && (paramzza.aMv == null)) {
      throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
    }
  }
  
  public void release()
  {
    try
    {
      this.aGI.shutdown();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void zza(zzbn<zzafu.zza> paramzzbn)
  {
    this.aGB = paramzzbn;
  }
  
  public void zzb(final zzafu.zza paramzza)
  {
    this.aGI.execute(new Runnable()
    {
      public void run()
      {
        zzcv.this.zzc(paramzza);
      }
    });
  }
  
  boolean zzc(zzafu.zza paramzza)
  {
    boolean bool = false;
    localFile = zzcgi();
    try
    {
      FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
      localFileOutputStream.<init>(localFile);
      try
      {
        localFileOutputStream.close();
        throw paramzza;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          zzbo.zzdi("error closing stream for writing resource to disk");
        }
      }
    }
    catch (FileNotFoundException paramzza)
    {
      for (;;)
      {
        try
        {
          localFileOutputStream.write(zzasa.zzf(paramzza));
        }
        catch (IOException paramzza)
        {
          paramzza = paramzza;
          zzbo.zzdi("Error writing resource to disk. Removing resource from disk.");
          localFile.delete();
          try
          {
            localFileOutputStream.close();
          }
          catch (IOException paramzza)
          {
            zzbo.zzdi("error closing stream for writing resource to disk");
          }
          continue;
        }
        finally {}
        try
        {
          localFileOutputStream.close();
          bool = true;
          return bool;
          paramzza = paramzza;
          zzbo.e("Error opening resource file for writing");
        }
        catch (IOException paramzza)
        {
          zzbo.zzdi("error closing stream for writing resource to disk");
        }
      }
    }
  }
  
  public void zzcej()
  {
    this.aGI.execute(new Runnable()
    {
      public void run()
      {
        zzcv.this.zzcgh();
      }
    });
  }
  
  /* Error */
  void zzcgh()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 128	com/google/android/gms/tagmanager/zzcv:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   4: ifnonnull +13 -> 17
    //   7: new 183	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc -71
    //   13: invokespecial 186	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: getfield 128	com/google/android/gms/tagmanager/zzcv:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   21: invokeinterface 191 1 0
    //   26: ldc -63
    //   28: invokestatic 93	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   31: invokestatic 199	com/google/android/gms/tagmanager/zzcj:zzcfz	()Lcom/google/android/gms/tagmanager/zzcj;
    //   34: invokevirtual 203	com/google/android/gms/tagmanager/zzcj:zzcga	()Lcom/google/android/gms/tagmanager/zzcj$zza;
    //   37: getstatic 209	com/google/android/gms/tagmanager/zzcj$zza:aGq	Lcom/google/android/gms/tagmanager/zzcj$zza;
    //   40: if_acmpeq +15 -> 55
    //   43: invokestatic 199	com/google/android/gms/tagmanager/zzcj:zzcfz	()Lcom/google/android/gms/tagmanager/zzcj;
    //   46: invokevirtual 203	com/google/android/gms/tagmanager/zzcj:zzcga	()Lcom/google/android/gms/tagmanager/zzcj$zza;
    //   49: getstatic 212	com/google/android/gms/tagmanager/zzcj$zza:aGr	Lcom/google/android/gms/tagmanager/zzcj$zza;
    //   52: if_acmpne +32 -> 84
    //   55: aload_0
    //   56: getfield 28	com/google/android/gms/tagmanager/zzcv:aDY	Ljava/lang/String;
    //   59: invokestatic 199	com/google/android/gms/tagmanager/zzcj:zzcfz	()Lcom/google/android/gms/tagmanager/zzcj;
    //   62: invokevirtual 216	com/google/android/gms/tagmanager/zzcj:getContainerId	()Ljava/lang/String;
    //   65: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +16 -> 84
    //   71: aload_0
    //   72: getfield 128	com/google/android/gms/tagmanager/zzcv:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   75: getstatic 228	com/google/android/gms/tagmanager/zzbn$zza:aFO	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   78: invokeinterface 231 2 0
    //   83: return
    //   84: new 233	java/io/FileInputStream
    //   87: astore_1
    //   88: aload_1
    //   89: aload_0
    //   90: invokevirtual 147	com/google/android/gms/tagmanager/zzcv:zzcgi	()Ljava/io/File;
    //   93: invokespecial 234	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: new 47	java/io/ByteArrayOutputStream
    //   99: astore_2
    //   100: aload_2
    //   101: invokespecial 235	java/io/ByteArrayOutputStream:<init>	()V
    //   104: aload_1
    //   105: aload_2
    //   106: invokestatic 238	com/google/android/gms/internal/zzafw:zzc	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   109: aload_2
    //   110: invokevirtual 242	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   113: invokestatic 246	com/google/android/gms/internal/zzafu$zza:zzap	([B)Lcom/google/android/gms/internal/zzafu$zza;
    //   116: astore_2
    //   117: aload_0
    //   118: aload_2
    //   119: invokespecial 248	com/google/android/gms/tagmanager/zzcv:zzd	(Lcom/google/android/gms/internal/zzafu$zza;)V
    //   122: aload_0
    //   123: getfield 128	com/google/android/gms/tagmanager/zzcv:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   126: aload_2
    //   127: invokeinterface 252 2 0
    //   132: aload_1
    //   133: invokevirtual 253	java/io/FileInputStream:close	()V
    //   136: ldc -1
    //   138: invokestatic 93	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   141: goto -58 -> 83
    //   144: astore_1
    //   145: ldc_w 257
    //   148: invokestatic 65	com/google/android/gms/tagmanager/zzbo:zzdg	(Ljava/lang/String;)V
    //   151: aload_0
    //   152: getfield 128	com/google/android/gms/tagmanager/zzcv:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   155: getstatic 228	com/google/android/gms/tagmanager/zzbn$zza:aFO	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   158: invokeinterface 231 2 0
    //   163: goto -80 -> 83
    //   166: astore_1
    //   167: ldc_w 259
    //   170: invokestatic 70	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   173: goto -37 -> 136
    //   176: astore_2
    //   177: aload_0
    //   178: getfield 128	com/google/android/gms/tagmanager/zzcv:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   181: getstatic 262	com/google/android/gms/tagmanager/zzbn$zza:aFP	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   184: invokeinterface 231 2 0
    //   189: ldc_w 264
    //   192: invokestatic 70	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: invokevirtual 253	java/io/FileInputStream:close	()V
    //   199: goto -63 -> 136
    //   202: astore_1
    //   203: ldc_w 259
    //   206: invokestatic 70	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   209: goto -73 -> 136
    //   212: astore_2
    //   213: aload_0
    //   214: getfield 128	com/google/android/gms/tagmanager/zzcv:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   217: getstatic 262	com/google/android/gms/tagmanager/zzbn$zza:aFP	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   220: invokeinterface 231 2 0
    //   225: ldc_w 266
    //   228: invokestatic 70	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   231: aload_1
    //   232: invokevirtual 253	java/io/FileInputStream:close	()V
    //   235: goto -99 -> 136
    //   238: astore_1
    //   239: ldc_w 259
    //   242: invokestatic 70	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   245: goto -109 -> 136
    //   248: astore_2
    //   249: aload_1
    //   250: invokevirtual 253	java/io/FileInputStream:close	()V
    //   253: aload_2
    //   254: athrow
    //   255: astore_1
    //   256: ldc_w 259
    //   259: invokestatic 70	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   262: goto -9 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	zzcv
    //   87	46	1	localFileInputStream	java.io.FileInputStream
    //   144	1	1	localFileNotFoundException	FileNotFoundException
    //   166	30	1	localIOException1	IOException
    //   202	30	1	localIOException2	IOException
    //   238	12	1	localIOException3	IOException
    //   255	1	1	localIOException4	IOException
    //   99	28	2	localObject1	Object
    //   176	1	2	localIOException5	IOException
    //   212	1	2	localIllegalArgumentException	IllegalArgumentException
    //   248	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   84	96	144	java/io/FileNotFoundException
    //   132	136	166	java/io/IOException
    //   96	132	176	java/io/IOException
    //   195	199	202	java/io/IOException
    //   96	132	212	java/lang/IllegalArgumentException
    //   231	235	238	java/io/IOException
    //   96	132	248	finally
    //   177	195	248	finally
    //   213	231	248	finally
    //   249	253	255	java/io/IOException
  }
  
  File zzcgi()
  {
    String str2 = String.valueOf("resource_");
    String str1 = String.valueOf(this.aDY);
    if (str1.length() != 0) {}
    for (str1 = str2.concat(str1);; str1 = new String(str2)) {
      return new File(this.mContext.getDir("google_tagmanager", 0), str1);
    }
  }
  
  public zzafw.zzc zzzz(int paramInt)
  {
    for (;;)
    {
      try
      {
        localObject1 = this.mContext.getResources().openRawResource(paramInt);
        localObject2 = String.valueOf(this.mContext.getResources().getResourceName(paramInt));
        zzbo.v(String.valueOf(localObject2).length() + 66 + "Attempting to load a container from the resource ID " + paramInt + " (" + (String)localObject2 + ")");
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        Object localObject1;
        Object localObject2;
        zzbo.zzdi(98 + "Failed to load the container. No default container resource found with the resource ID " + paramInt);
        zzafw.zzc localzzc = null;
        continue;
        localzzc = zzal(((ByteArrayOutputStream)localObject2).toByteArray());
        continue;
      }
      try
      {
        localObject2 = new java/io/ByteArrayOutputStream;
        ((ByteArrayOutputStream)localObject2).<init>();
        zzafw.zzc((InputStream)localObject1, (OutputStream)localObject2);
        localObject1 = zza((ByteArrayOutputStream)localObject2);
        if (localObject1 == null) {
          continue;
        }
        zzbo.v("The container was successfully loaded from the resource (using JSON file format)");
      }
      catch (IOException localIOException)
      {
        String str = String.valueOf(this.mContext.getResources().getResourceName(paramInt));
        zzbo.zzdi(String.valueOf(str).length() + 67 + "Error reading the default container with resource ID " + paramInt + " (" + str + ")");
        str = null;
      }
    }
    return (zzafw.zzc)localObject1;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */