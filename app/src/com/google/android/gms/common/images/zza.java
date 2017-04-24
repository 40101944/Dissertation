package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.internal.zzsj;
import com.google.android.gms.internal.zzsk;
import com.google.android.gms.internal.zzsl;
import java.lang.ref.WeakReference;

public abstract class zza
{
  final zza CD;
  protected int CE = 0;
  protected int CF = 0;
  protected boolean CG = false;
  private boolean CH = true;
  private boolean CI = false;
  private boolean CJ = true;
  
  public zza(Uri paramUri, int paramInt)
  {
    this.CD = new zza(paramUri);
    this.CF = paramInt;
  }
  
  private Drawable zza(Context paramContext, zzsl paramzzsl, int paramInt)
  {
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  protected zzsj zza(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof zzsj)) {}
    }
    for (Drawable localDrawable = ((zzsj)paramDrawable1).zzauw();; localDrawable = null) {
      return new zzsj(localDrawable, paramDrawable2);
    }
  }
  
  void zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    zzc.zzu(paramBitmap);
    zza(new BitmapDrawable(paramContext.getResources(), paramBitmap), paramBoolean, false, true);
  }
  
  void zza(Context paramContext, zzsl paramzzsl)
  {
    if (this.CJ) {
      zza(null, false, true, false);
    }
  }
  
  void zza(Context paramContext, zzsl paramzzsl, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.CF != 0) {
      localDrawable = zza(paramContext, paramzzsl, this.CF);
    }
    zza(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  protected boolean zzc(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!this.CH) || (paramBoolean2) || (paramBoolean1)) {}
    for (paramBoolean1 = false;; paramBoolean1 = true) {
      return paramBoolean1;
    }
  }
  
  public void zzgg(int paramInt)
  {
    this.CF = paramInt;
  }
  
  static final class zza
  {
    public final Uri uri;
    
    public zza(Uri paramUri)
    {
      this.uri = paramUri;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (!(paramObject instanceof zza)) {
        bool = false;
      }
      for (;;)
      {
        return bool;
        if (this == paramObject) {
          bool = true;
        } else {
          bool = zzz.equal(((zza)paramObject).uri, this.uri);
        }
      }
    }
    
    public int hashCode()
    {
      return zzz.hashCode(new Object[] { this.uri });
    }
  }
  
  public static final class zzb
    extends zza
  {
    private WeakReference<ImageView> CK;
    
    public zzb(ImageView paramImageView, int paramInt)
    {
      super(paramInt);
      zzc.zzu(paramImageView);
      this.CK = new WeakReference(paramImageView);
    }
    
    public zzb(ImageView paramImageView, Uri paramUri)
    {
      super(0);
      zzc.zzu(paramImageView);
      this.CK = new WeakReference(paramImageView);
    }
    
    private void zza(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((!paramBoolean2) && (!paramBoolean3)) {}
      for (int i = 1; (i != 0) && ((paramImageView instanceof zzsk)); i = 0)
      {
        int j = ((zzsk)paramImageView).zzauy();
        if ((this.CF == 0) || (j != this.CF)) {
          break;
        }
        return;
      }
      paramBoolean1 = zzc(paramBoolean1, paramBoolean2);
      if (paramBoolean1) {
        paramDrawable = zza(paramImageView.getDrawable(), paramDrawable);
      }
      for (;;)
      {
        paramImageView.setImageDrawable(paramDrawable);
        zzsk localzzsk;
        if ((paramImageView instanceof zzsk))
        {
          localzzsk = (zzsk)paramImageView;
          if (!paramBoolean3) {
            break label151;
          }
          paramImageView = this.CD.uri;
          label110:
          localzzsk.zzr(paramImageView);
          if (i == 0) {
            break label156;
          }
        }
        label151:
        label156:
        for (i = this.CF;; i = 0)
        {
          localzzsk.zzgi(i);
          if (!paramBoolean1) {
            break;
          }
          ((zzsj)paramDrawable).startTransition(250);
          break;
          paramImageView = null;
          break label110;
        }
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (!(paramObject instanceof zzb)) {}
      for (;;)
      {
        return bool;
        if (this != paramObject) {
          break;
        }
        bool = true;
      }
      Object localObject = (zzb)paramObject;
      paramObject = (ImageView)this.CK.get();
      localObject = (ImageView)((zzb)localObject).CK.get();
      if ((localObject != null) && (paramObject != null) && (zzz.equal(localObject, paramObject))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      ImageView localImageView = (ImageView)this.CK.get();
      if (localImageView != null) {
        zza(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
      }
    }
  }
  
  public static final class zzc
    extends zza
  {
    private WeakReference<ImageManager.OnImageLoadedListener> CL;
    
    public zzc(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
    {
      super(0);
      zzc.zzu(paramOnImageLoadedListener);
      this.CL = new WeakReference(paramOnImageLoadedListener);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = false;
      if (!(paramObject instanceof zzc)) {}
      for (;;)
      {
        return bool;
        if (this != paramObject) {
          break;
        }
        bool = true;
      }
      zzc localzzc = (zzc)paramObject;
      paramObject = (ImageManager.OnImageLoadedListener)this.CL.get();
      ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)localzzc.CL.get();
      if ((localOnImageLoadedListener != null) && (paramObject != null) && (zzz.equal(localOnImageLoadedListener, paramObject)) && (zzz.equal(localzzc.CD, this.CD))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    
    public int hashCode()
    {
      return zzz.hashCode(new Object[] { this.CD });
    }
    
    protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.CL.get();
        if (localOnImageLoadedListener != null) {
          localOnImageLoadedListener.onImageLoaded(this.CD.uri, paramDrawable, paramBoolean3);
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\images\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */