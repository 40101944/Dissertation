package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback
{
  private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
  private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
  private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
  private static int MAX_IMAGE_SIZE = 1048576;
  private Matrix mTempMatrix;
  
  private static Bitmap createDrawableBitmap(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i <= 0) || (j <= 0)) {
      paramDrawable = null;
    }
    for (;;)
    {
      return paramDrawable;
      float f = Math.min(1.0F, MAX_IMAGE_SIZE / (i * j));
      if (((paramDrawable instanceof BitmapDrawable)) && (f == 1.0F))
      {
        paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      else
      {
        i = (int)(i * f);
        int m = (int)(j * f);
        Bitmap localBitmap = Bitmap.createBitmap(i, m, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Rect localRect = paramDrawable.getBounds();
        int i1 = localRect.left;
        int k = localRect.top;
        j = localRect.right;
        int n = localRect.bottom;
        paramDrawable.setBounds(0, 0, i, m);
        paramDrawable.draw(localCanvas);
        paramDrawable.setBounds(i1, k, j, n);
        paramDrawable = localBitmap;
      }
    }
  }
  
  public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
  {
    Object localObject1;
    Object localObject2;
    if ((paramView instanceof ImageView))
    {
      localObject1 = (ImageView)paramView;
      localObject2 = ((ImageView)localObject1).getDrawable();
      Drawable localDrawable = ((ImageView)localObject1).getBackground();
      if ((localObject2 != null) && (localDrawable == null))
      {
        localObject2 = createDrawableBitmap((Drawable)localObject2);
        if (localObject2 != null)
        {
          paramMatrix = new Bundle();
          paramMatrix.putParcelable("sharedElement:snapshot:bitmap", (Parcelable)localObject2);
          paramMatrix.putString("sharedElement:snapshot:imageScaleType", ((ImageView)localObject1).getScaleType().toString());
          paramView = paramMatrix;
          if (((ImageView)localObject1).getScaleType() == ImageView.ScaleType.MATRIX)
          {
            paramView = ((ImageView)localObject1).getImageMatrix();
            paramRectF = new float[9];
            paramView.getValues(paramRectF);
            paramMatrix.putFloatArray("sharedElement:snapshot:imageMatrix", paramRectF);
          }
        }
      }
    }
    for (paramView = paramMatrix;; paramView = (View)localObject1)
    {
      return paramView;
      int j = Math.round(paramRectF.width());
      int i = Math.round(paramRectF.height());
      localObject2 = null;
      localObject1 = localObject2;
      if (j > 0)
      {
        localObject1 = localObject2;
        if (i > 0)
        {
          float f = Math.min(1.0F, MAX_IMAGE_SIZE / (j * i));
          j = (int)(j * f);
          i = (int)(i * f);
          if (this.mTempMatrix == null) {
            this.mTempMatrix = new Matrix();
          }
          this.mTempMatrix.set(paramMatrix);
          this.mTempMatrix.postTranslate(-paramRectF.left, -paramRectF.top);
          this.mTempMatrix.postScale(f, f);
          localObject1 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
          paramMatrix = new Canvas((Bitmap)localObject1);
          paramMatrix.concat(this.mTempMatrix);
          paramView.draw(paramMatrix);
        }
      }
    }
  }
  
  public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
  {
    Object localObject1 = null;
    if ((paramParcelable instanceof Bundle))
    {
      Object localObject2 = (Bundle)paramParcelable;
      localObject1 = (Bitmap)((Bundle)localObject2).getParcelable("sharedElement:snapshot:bitmap");
      if (localObject1 == null)
      {
        localObject1 = null;
        return (View)localObject1;
      }
      paramParcelable = new ImageView(paramContext);
      paramContext = paramParcelable;
      paramParcelable.setImageBitmap((Bitmap)localObject1);
      paramParcelable.setScaleType(ImageView.ScaleType.valueOf(((Bundle)localObject2).getString("sharedElement:snapshot:imageScaleType")));
      localObject1 = paramContext;
      if (paramParcelable.getScaleType() == ImageView.ScaleType.MATRIX)
      {
        localObject1 = ((Bundle)localObject2).getFloatArray("sharedElement:snapshot:imageMatrix");
        localObject2 = new Matrix();
        ((Matrix)localObject2).setValues((float[])localObject1);
        paramParcelable.setImageMatrix((Matrix)localObject2);
        localObject1 = paramContext;
      }
    }
    for (;;)
    {
      break;
      if ((paramParcelable instanceof Bitmap))
      {
        paramParcelable = (Bitmap)paramParcelable;
        localObject1 = new ImageView(paramContext);
        ((ImageView)localObject1).setImageBitmap(paramParcelable);
      }
    }
  }
  
  public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {}
  
  public void onRejectSharedElements(List<View> paramList) {}
  
  public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public void onSharedElementsArrived(List<String> paramList, List<View> paramList1, OnSharedElementsReadyListener paramOnSharedElementsReadyListener)
  {
    paramOnSharedElementsReadyListener.onSharedElementsReady();
  }
  
  public static abstract interface OnSharedElementsReadyListener
  {
    public abstract void onSharedElementsReady();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\app\SharedElementCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */