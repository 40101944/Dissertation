package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzsl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object Co = new Object();
  private static HashSet<Uri> Cp = new HashSet();
  private static ImageManager Cq;
  private static ImageManager Cr;
  private final ExecutorService Cs;
  private final zzb Ct;
  private final zzsl Cu;
  private final Map<zza, ImageReceiver> Cv;
  private final Map<Uri, ImageReceiver> Cw;
  private final Map<Uri, Long> Cx;
  private final Context mContext;
  private final Handler mHandler;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.Cs = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.Ct = new zzb(this.mContext);
      if (zzs.zzayq()) {
        zzaut();
      }
    }
    for (;;)
    {
      this.Cu = new zzsl();
      this.Cv = new HashMap();
      this.Cw = new HashMap();
      this.Cx = new HashMap();
      return;
      this.Ct = null;
    }
  }
  
  public static ImageManager create(Context paramContext)
  {
    return zzg(paramContext, false);
  }
  
  private Bitmap zza(zza.zza paramzza)
  {
    if (this.Ct == null) {}
    for (paramzza = null;; paramzza = (Bitmap)this.Ct.get(paramzza)) {
      return paramzza;
    }
  }
  
  @TargetApi(14)
  private void zzaut()
  {
    this.mContext.registerComponentCallbacks(new zze(this.Ct));
  }
  
  public static ImageManager zzg(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (Cr == null) {
        Cr = new ImageManager(paramContext, true);
      }
    }
    for (paramContext = Cr;; paramContext = Cq)
    {
      return paramContext;
      if (Cq == null) {
        Cq = new ImageManager(paramContext, false);
      }
    }
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    zza(new zza.zzb(paramImageView, paramInt));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    zza(new zza.zzb(paramImageView, paramUri));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramImageView = new zza.zzb(paramImageView, paramUri);
    paramImageView.zzgg(paramInt);
    zza(paramImageView);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    zza(new zza.zzc(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new zza.zzc(paramOnImageLoadedListener, paramUri);
    paramOnImageLoadedListener.zzgg(paramInt);
    zza(paramOnImageLoadedListener);
  }
  
  public void zza(zza paramzza)
  {
    zzc.zzhs("ImageManager.loadImage() must be called in the main thread");
    new zzd(paramzza).run();
  }
  
  @KeepName
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final ArrayList<zza> Cy;
    private final Uri mUri;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      this.mUri = paramUri;
      this.Cy = new ArrayList();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.zzf(ImageManager.this).execute(new ImageManager.zzc(ImageManager.this, this.mUri, paramBundle));
    }
    
    public void zzauv()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.zzb(ImageManager.this).sendBroadcast(localIntent);
    }
    
    public void zzb(zza paramzza)
    {
      zzc.zzhs("ImageReceiver.addImageRequest() must be called in the main thread");
      this.Cy.add(paramzza);
    }
    
    public void zzc(zza paramzza)
    {
      zzc.zzhs("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.Cy.remove(paramzza);
    }
  }
  
  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
  
  @TargetApi(11)
  private static final class zza
  {
    static int zza(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }
  
  private static final class zzb
    extends LruCache<zza.zza, Bitmap>
  {
    public zzb(Context paramContext)
    {
      super();
    }
    
    @TargetApi(11)
    private static int zzbz(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      if ((paramContext.getApplicationInfo().flags & 0x100000) != 0)
      {
        i = 1;
        if ((i == 0) || (!zzs.zzayn())) {
          break label55;
        }
      }
      label55:
      for (int i = ImageManager.zza.zza(localActivityManager);; i = localActivityManager.getMemoryClass())
      {
        return (int)(i * 1048576 * 0.33F);
        i = 0;
        break;
      }
    }
    
    protected int zza(zza.zza paramzza, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }
    
    protected void zza(boolean paramBoolean, zza.zza paramzza, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, paramzza, paramBitmap1, paramBitmap2);
    }
  }
  
  private final class zzc
    implements Runnable
  {
    private final ParcelFileDescriptor CA;
    private final Uri mUri;
    
    public zzc(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.mUri = paramUri;
      this.CA = paramParcelFileDescriptor;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 36
      //   2: invokestatic 42	com/google/android/gms/common/internal/zzc:zzht	(Ljava/lang/String;)V
      //   5: iconst_0
      //   6: istore_1
      //   7: iconst_0
      //   8: istore_2
      //   9: aconst_null
      //   10: astore_3
      //   11: aconst_null
      //   12: astore 4
      //   14: aload_0
      //   15: getfield 26	com/google/android/gms/common/images/ImageManager$zzc:CA	Landroid/os/ParcelFileDescriptor;
      //   18: ifnull +23 -> 41
      //   21: aload_0
      //   22: getfield 26	com/google/android/gms/common/images/ImageManager$zzc:CA	Landroid/os/ParcelFileDescriptor;
      //   25: invokevirtual 48	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
      //   28: invokestatic 54	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;
      //   31: astore_3
      //   32: iload_2
      //   33: istore_1
      //   34: aload_0
      //   35: getfield 26	com/google/android/gms/common/images/ImageManager$zzc:CA	Landroid/os/ParcelFileDescriptor;
      //   38: invokevirtual 57	android/os/ParcelFileDescriptor:close	()V
      //   41: new 59	java/util/concurrent/CountDownLatch
      //   44: dup
      //   45: iconst_1
      //   46: invokespecial 62	java/util/concurrent/CountDownLatch:<init>	(I)V
      //   49: astore 4
      //   51: aload_0
      //   52: getfield 19	com/google/android/gms/common/images/ImageManager$zzc:Cz	Lcom/google/android/gms/common/images/ImageManager;
      //   55: invokestatic 66	com/google/android/gms/common/images/ImageManager:zzg	(Lcom/google/android/gms/common/images/ImageManager;)Landroid/os/Handler;
      //   58: new 68	com/google/android/gms/common/images/ImageManager$zzf
      //   61: dup
      //   62: aload_0
      //   63: getfield 19	com/google/android/gms/common/images/ImageManager$zzc:Cz	Lcom/google/android/gms/common/images/ImageManager;
      //   66: aload_0
      //   67: getfield 24	com/google/android/gms/common/images/ImageManager$zzc:mUri	Landroid/net/Uri;
      //   70: aload_3
      //   71: iload_1
      //   72: aload 4
      //   74: invokespecial 71	com/google/android/gms/common/images/ImageManager$zzf:<init>	(Lcom/google/android/gms/common/images/ImageManager;Landroid/net/Uri;Landroid/graphics/Bitmap;ZLjava/util/concurrent/CountDownLatch;)V
      //   77: invokevirtual 77	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   80: pop
      //   81: aload 4
      //   83: invokevirtual 80	java/util/concurrent/CountDownLatch:await	()V
      //   86: return
      //   87: astore_3
      //   88: aload_0
      //   89: getfield 24	com/google/android/gms/common/images/ImageManager$zzc:mUri	Landroid/net/Uri;
      //   92: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   95: astore 5
      //   97: ldc 88
      //   99: new 90	java/lang/StringBuilder
      //   102: dup
      //   103: aload 5
      //   105: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   108: invokevirtual 94	java/lang/String:length	()I
      //   111: bipush 34
      //   113: iadd
      //   114: invokespecial 95	java/lang/StringBuilder:<init>	(I)V
      //   117: ldc 97
      //   119: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   122: aload 5
      //   124: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   127: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   130: aload_3
      //   131: invokestatic 111	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   134: pop
      //   135: iconst_1
      //   136: istore_1
      //   137: aload 4
      //   139: astore_3
      //   140: goto -106 -> 34
      //   143: astore 4
      //   145: ldc 88
      //   147: ldc 113
      //   149: aload 4
      //   151: invokestatic 111	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   154: pop
      //   155: goto -114 -> 41
      //   158: astore_3
      //   159: aload_0
      //   160: getfield 24	com/google/android/gms/common/images/ImageManager$zzc:mUri	Landroid/net/Uri;
      //   163: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   166: astore_3
      //   167: ldc 88
      //   169: new 90	java/lang/StringBuilder
      //   172: dup
      //   173: aload_3
      //   174: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   177: invokevirtual 94	java/lang/String:length	()I
      //   180: bipush 32
      //   182: iadd
      //   183: invokespecial 95	java/lang/StringBuilder:<init>	(I)V
      //   186: ldc 115
      //   188: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: aload_3
      //   192: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   195: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   198: invokestatic 119	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   201: pop
      //   202: goto -116 -> 86
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	205	0	this	zzc
      //   6	131	1	bool1	boolean
      //   8	25	2	bool2	boolean
      //   10	61	3	localBitmap	Bitmap
      //   87	44	3	localOutOfMemoryError	OutOfMemoryError
      //   139	1	3	localObject	Object
      //   158	1	3	localInterruptedException	InterruptedException
      //   166	26	3	str1	String
      //   12	126	4	localCountDownLatch	CountDownLatch
      //   143	7	4	localIOException	java.io.IOException
      //   95	28	5	str2	String
      // Exception table:
      //   from	to	target	type
      //   21	32	87	java/lang/OutOfMemoryError
      //   34	41	143	java/io/IOException
      //   81	86	158	java/lang/InterruptedException
    }
  }
  
  private final class zzd
    implements Runnable
  {
    private final zza CB;
    
    public zzd(zza paramzza)
    {
      this.CB = paramzza;
    }
    
    public void run()
    {
      zzc.zzhs("LoadImageRunnable must be executed on the main thread");
      Object localObject1 = (ImageManager.ImageReceiver)ImageManager.zza(ImageManager.this).get(this.CB);
      if (localObject1 != null)
      {
        ImageManager.zza(ImageManager.this).remove(this.CB);
        ((ImageManager.ImageReceiver)localObject1).zzc(this.CB);
      }
      zza.zza localzza = this.CB.CD;
      if (localzza.uri == null) {
        this.CB.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
      }
      for (;;)
      {
        return;
        localObject1 = ImageManager.zza(ImageManager.this, localzza);
        if (localObject1 != null)
        {
          this.CB.zza(ImageManager.zzb(ImageManager.this), (Bitmap)localObject1, true);
          continue;
        }
        localObject1 = (Long)ImageManager.zzd(ImageManager.this).get(localzza.uri);
        if (localObject1 != null)
        {
          if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
          {
            this.CB.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), true);
            continue;
          }
          ImageManager.zzd(ImageManager.this).remove(localzza.uri);
        }
        this.CB.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this));
        ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).get(localzza.uri);
        localObject1 = ???;
        if (??? == null)
        {
          localObject1 = new ImageManager.ImageReceiver(ImageManager.this, localzza.uri);
          ImageManager.zze(ImageManager.this).put(localzza.uri, localObject1);
        }
        ((ImageManager.ImageReceiver)localObject1).zzb(this.CB);
        if (!(this.CB instanceof zza.zzc)) {
          ImageManager.zza(ImageManager.this).put(this.CB, localObject1);
        }
        synchronized (ImageManager.zzaps())
        {
          if (!ImageManager.zzauu().contains(localzza.uri))
          {
            ImageManager.zzauu().add(localzza.uri);
            ((ImageManager.ImageReceiver)localObject1).zzauv();
          }
        }
      }
    }
  }
  
  @TargetApi(14)
  private static final class zze
    implements ComponentCallbacks2
  {
    private final ImageManager.zzb Ct;
    
    public zze(ImageManager.zzb paramzzb)
    {
      this.Ct = paramzzb;
    }
    
    public void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public void onLowMemory()
    {
      this.Ct.evictAll();
    }
    
    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60) {
        this.Ct.evictAll();
      }
      for (;;)
      {
        return;
        if (paramInt >= 20) {
          this.Ct.trimToSize(this.Ct.size() / 2);
        }
      }
    }
  }
  
  private final class zzf
    implements Runnable
  {
    private boolean CC;
    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch zzank;
    
    public zzf(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
    {
      this.mUri = paramUri;
      this.mBitmap = paramBitmap;
      this.CC = paramBoolean;
      this.zzank = paramCountDownLatch;
    }
    
    private void zza(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      ArrayList localArrayList = ImageManager.ImageReceiver.zza(paramImageReceiver);
      int j = localArrayList.size();
      int i = 0;
      if (i < j)
      {
        paramImageReceiver = (zza)localArrayList.get(i);
        if (paramBoolean) {
          paramImageReceiver.zza(ImageManager.zzb(ImageManager.this), this.mBitmap, false);
        }
        for (;;)
        {
          if (!(paramImageReceiver instanceof zza.zzc)) {
            ImageManager.zza(ImageManager.this).remove(paramImageReceiver);
          }
          i++;
          break;
          ImageManager.zzd(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          paramImageReceiver.zza(ImageManager.zzb(ImageManager.this), ImageManager.zzc(ImageManager.this), false);
        }
      }
    }
    
    public void run()
    {
      zzc.zzhs("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.mBitmap != null)
      {
        bool = true;
        if (ImageManager.zzh(ImageManager.this) == null) {
          break label97;
        }
        if (!this.CC) {
          break label67;
        }
        ImageManager.zzh(ImageManager.this).evictAll();
        System.gc();
        this.CC = false;
        ImageManager.zzg(ImageManager.this).post(this);
      }
      for (;;)
      {
        return;
        bool = false;
        break;
        label67:
        if (bool) {
          ImageManager.zzh(ImageManager.this).put(new zza.zza(this.mUri), this.mBitmap);
        }
        label97:
        ??? = (ImageManager.ImageReceiver)ImageManager.zze(ImageManager.this).remove(this.mUri);
        if (??? != null) {
          zza((ImageManager.ImageReceiver)???, bool);
        }
        this.zzank.countDown();
        synchronized (ImageManager.zzaps())
        {
          ImageManager.zzauu().remove(this.mUri);
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\images\ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */