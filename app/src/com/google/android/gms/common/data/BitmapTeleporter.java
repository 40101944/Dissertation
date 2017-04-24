package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BitmapTeleporter
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zza();
  private Bitmap BO;
  private boolean BP;
  private File BQ;
  final int mVersionCode;
  final int nV;
  ParcelFileDescriptor zzcme;
  
  BitmapTeleporter(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzcme = paramParcelFileDescriptor;
    this.nV = paramInt2;
    this.BO = null;
    this.BP = false;
  }
  
  public BitmapTeleporter(Bitmap paramBitmap)
  {
    this.mVersionCode = 1;
    this.zzcme = null;
    this.nV = 0;
    this.BO = paramBitmap;
    this.BP = true;
  }
  
  private void zza(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      for (;;)
      {
        Log.w("BitmapTeleporter", "Could not close stream", paramCloseable);
      }
    }
  }
  
  /* Error */
  private java.io.FileOutputStream zzauk()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/google/android/gms/common/data/BitmapTeleporter:BQ	Ljava/io/File;
    //   4: ifnonnull +13 -> 17
    //   7: new 70	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 72
    //   13: invokespecial 75	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 77
    //   19: ldc 79
    //   21: aload_0
    //   22: getfield 68	com/google/android/gms/common/data/BitmapTeleporter:BQ	Ljava/io/File;
    //   25: invokestatic 85	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   28: astore_1
    //   29: new 87	java/io/FileOutputStream
    //   32: astore_2
    //   33: aload_2
    //   34: aload_1
    //   35: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   38: aload_0
    //   39: aload_1
    //   40: ldc 91
    //   42: invokestatic 97	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   45: putfield 36	com/google/android/gms/common/data/BitmapTeleporter:zzcme	Landroid/os/ParcelFileDescriptor;
    //   48: aload_1
    //   49: invokevirtual 101	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_2
    //   54: areturn
    //   55: astore_1
    //   56: new 70	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 103
    //   62: aload_1
    //   63: invokespecial 106	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore_1
    //   68: new 70	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc 108
    //   74: invokespecial 75	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	BitmapTeleporter
    //   28	21	1	localFile	File
    //   55	8	1	localIOException	IOException
    //   67	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   32	22	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	29	55	java/io/IOException
    //   29	48	67	java/io/FileNotFoundException
  }
  
  public void release()
  {
    if (!this.BP) {}
    try
    {
      this.zzcme.close();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.w("BitmapTeleporter", "Could not close PFD", localIOException);
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bitmap localBitmap;
    Object localObject;
    byte[] arrayOfByte;
    if (this.zzcme == null)
    {
      localBitmap = this.BO;
      localObject = ByteBuffer.allocate(localBitmap.getRowBytes() * localBitmap.getHeight());
      localBitmap.copyPixelsToBuffer((Buffer)localObject);
      arrayOfByte = ((ByteBuffer)localObject).array();
      localObject = new DataOutputStream(zzauk());
    }
    try
    {
      ((DataOutputStream)localObject).writeInt(arrayOfByte.length);
      ((DataOutputStream)localObject).writeInt(localBitmap.getWidth());
      ((DataOutputStream)localObject).writeInt(localBitmap.getHeight());
      ((DataOutputStream)localObject).writeUTF(localBitmap.getConfig().toString());
      ((DataOutputStream)localObject).write(arrayOfByte);
      zza((Closeable)localObject);
      zza.zza(this, paramParcel, paramInt | 0x1);
      this.zzcme = null;
      return;
    }
    catch (IOException localIOException)
    {
      paramParcel = new java/lang/IllegalStateException;
      paramParcel.<init>("Could not write into unlinked file", localIOException);
      throw paramParcel;
    }
    finally
    {
      zza((Closeable)localObject);
    }
  }
  
  public Bitmap zzauj()
  {
    Object localObject1;
    if (!this.BP) {
      localObject1 = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzcme));
    }
    try
    {
      localObject4 = new byte[((DataInputStream)localObject1).readInt()];
      int i = ((DataInputStream)localObject1).readInt();
      int j = ((DataInputStream)localObject1).readInt();
      Object localObject2 = Bitmap.Config.valueOf(((DataInputStream)localObject1).readUTF());
      ((DataInputStream)localObject1).read((byte[])localObject4);
      zza((Closeable)localObject1);
      localObject1 = ByteBuffer.wrap((byte[])localObject4);
      localObject2 = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject2);
      ((Bitmap)localObject2).copyPixelsFromBuffer((Buffer)localObject1);
      this.BO = ((Bitmap)localObject2);
      this.BP = true;
      return this.BO;
    }
    catch (IOException localIOException)
    {
      Object localObject4 = new java/lang/IllegalStateException;
      ((IllegalStateException)localObject4).<init>("Could not read from parcel file descriptor", localIOException);
      throw ((Throwable)localObject4);
    }
    finally
    {
      zza((Closeable)localObject1);
    }
  }
  
  public void zzd(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("Cannot set null temp directory");
    }
    this.BQ = paramFile;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\data\BitmapTeleporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */