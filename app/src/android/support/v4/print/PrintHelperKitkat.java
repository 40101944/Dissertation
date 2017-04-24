package android.support.v4.print;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument.Page;
import android.graphics.pdf.PdfDocument.PageInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class PrintHelperKitkat
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  private static final String LOG_TAG = "PrintHelperKitkat";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  BitmapFactory.Options mDecodeOptions = null;
  protected boolean mIsMinMarginsHandlingCorrect = true;
  private final Object mLock = new Object();
  int mOrientation;
  protected boolean mPrintActivityRespectsOrientation = true;
  int mScaleMode = 2;
  
  PrintHelperKitkat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Bitmap convertBitmapForColorMode(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt != 1) {}
    for (;;)
    {
      return paramBitmap;
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      ColorMatrix localColorMatrix = new ColorMatrix();
      localColorMatrix.setSaturation(0.0F);
      localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localCanvas.setBitmap(null);
      paramBitmap = localBitmap;
    }
  }
  
  private Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f = paramRectF.width() / paramInt1;
    if (paramInt3 == 2) {}
    for (f = Math.max(f, paramRectF.height() / paramInt2);; f = Math.min(f, paramRectF.height() / paramInt2))
    {
      localMatrix.postScale(f, f);
      localMatrix.postTranslate((paramRectF.width() - paramInt1 * f) / 2.0F, (paramRectF.height() - paramInt2 * f) / 2.0F);
      return localMatrix;
    }
  }
  
  private static boolean isPortrait(Bitmap paramBitmap)
  {
    if (paramBitmap.getWidth() <= paramBitmap.getHeight()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    if ((paramUri == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to loadBitmap");
    }
    localUri = null;
    try
    {
      paramUri = this.mContext.getContentResolver().openInputStream(paramUri);
      localUri = paramUri;
      paramOptions = BitmapFactory.decodeStream(paramUri, null, paramOptions);
      if (paramUri != null) {}
      try
      {
        paramUri.close();
        return paramOptions;
      }
      catch (IOException paramUri)
      {
        for (;;)
        {
          Log.w("PrintHelperKitkat", "close fail ", paramUri);
        }
      }
      try
      {
        localUri.close();
        throw paramUri;
      }
      catch (IOException paramOptions)
      {
        for (;;)
        {
          Log.w("PrintHelperKitkat", "close fail ", paramOptions);
        }
      }
    }
    finally
    {
      if (localUri == null) {}
    }
  }
  
  private Bitmap loadConstrainedBitmap(Uri arg1, int paramInt)
    throws FileNotFoundException
  {
    BitmapFactory.Options localOptions = null;
    if ((paramInt <= 0) || (??? == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }
    ??? = new BitmapFactory.Options();
    ((BitmapFactory.Options)???).inJustDecodeBounds = true;
    loadBitmap(???, (BitmapFactory.Options)???);
    int m = ((BitmapFactory.Options)???).outWidth;
    int k = ((BitmapFactory.Options)???).outHeight;
    ??? = localOptions;
    if (m > 0)
    {
      if (k > 0) {
        break label86;
      }
      ??? = localOptions;
    }
    label86:
    int i;
    do
    {
      do
      {
        return (Bitmap)???;
        int j = Math.max(m, k);
        i = 1;
        while (j > paramInt)
        {
          j >>>= 1;
          i <<= 1;
        }
        ??? = localOptions;
      } while (i <= 0);
      ??? = localOptions;
    } while (Math.min(m, k) / i <= 0);
    synchronized (this.mLock)
    {
      localOptions = new android/graphics/BitmapFactory$Options;
      localOptions.<init>();
      this.mDecodeOptions = localOptions;
      this.mDecodeOptions.inMutable = true;
      this.mDecodeOptions.inSampleSize = i;
      localOptions = this.mDecodeOptions;
    }
    try
    {
      ??? = loadBitmap(???, localOptions);
      synchronized (this.mLock)
      {
        this.mDecodeOptions = null;
      }
      ??? = finally;
      throw ???;
    }
    finally {}
  }
  
  private void writeBitmap(final PrintAttributes paramPrintAttributes, final int paramInt, final Bitmap paramBitmap, final ParcelFileDescriptor paramParcelFileDescriptor, final CancellationSignal paramCancellationSignal, final PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    if (this.mIsMinMarginsHandlingCorrect) {}
    for (final PrintAttributes localPrintAttributes = paramPrintAttributes;; localPrintAttributes = copyAttributes(paramPrintAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build())
    {
      new AsyncTask()
      {
        protected Throwable doInBackground(Void... paramAnonymousVarArgs)
        {
          localParcelFileDescriptor = null;
          label16:
          do
          {
            try
            {
              if (!paramCancellationSignal.isCanceled()) {
                break label16;
              }
              paramAnonymousVarArgs = localParcelFileDescriptor;
            }
            catch (Throwable localIOException)
            {
              try
              {
                localPage = localPrintedPdfDocument1.startPage(1);
                if (!PrintHelperKitkat.this.mIsMinMarginsHandlingCorrect) {
                  break label217;
                }
                paramAnonymousVarArgs = new android/graphics/RectF;
                paramAnonymousVarArgs.<init>(localPage.getInfo().getContentRect());
                localObject = PrintHelperKitkat.this.getMatrix(localBitmap.getWidth(), localBitmap.getHeight(), paramAnonymousVarArgs, paramInt);
                if (!PrintHelperKitkat.this.mIsMinMarginsHandlingCorrect) {
                  break label315;
                }
                localPage.getCanvas().drawBitmap(localBitmap, (Matrix)localObject, null);
                localPrintedPdfDocument1.finishPage(localPage);
                boolean bool = paramCancellationSignal.isCanceled();
                if (!bool) {
                  break label342;
                }
                localPrintedPdfDocument1.close();
                paramAnonymousVarArgs = paramParcelFileDescriptor;
                if (paramAnonymousVarArgs == null) {
                  break label192;
                }
              }
              finally
              {
                try
                {
                  for (;;)
                  {
                    PrintedPdfDocument localPrintedPdfDocument1;
                    Bitmap localBitmap;
                    PdfDocument.Page localPage;
                    paramParcelFileDescriptor.close();
                    paramAnonymousVarArgs = localParcelFileDescriptor;
                    if (localBitmap == paramBitmap) {
                      continue;
                    }
                    localBitmap.recycle();
                    paramAnonymousVarArgs = localParcelFileDescriptor;
                    continue;
                    paramAnonymousVarArgs = paramAnonymousVarArgs;
                    continue;
                    PrintedPdfDocument localPrintedPdfDocument2 = new android/print/pdf/PrintedPdfDocument;
                    localPrintedPdfDocument2.<init>(PrintHelperKitkat.this.mContext, paramPrintAttributes);
                    Object localObject = localPrintedPdfDocument2.startPage(1);
                    paramAnonymousVarArgs = new android/graphics/RectF;
                    paramAnonymousVarArgs.<init>(((PdfDocument.Page)localObject).getInfo().getContentRect());
                    localPrintedPdfDocument2.finishPage((PdfDocument.Page)localObject);
                    localPrintedPdfDocument2.close();
                    continue;
                    paramAnonymousVarArgs = finally;
                    localPrintedPdfDocument1.close();
                    localParcelFileDescriptor = paramParcelFileDescriptor;
                    if (localParcelFileDescriptor == null) {
                      break label299;
                    }
                    try
                    {
                      paramParcelFileDescriptor.close();
                      if (localBitmap == paramBitmap) {
                        break label313;
                      }
                      localBitmap.recycle();
                      throw paramAnonymousVarArgs;
                      ((Matrix)localObject).postTranslate(paramAnonymousVarArgs.left, paramAnonymousVarArgs.top);
                      localPage.getCanvas().clipRect(paramAnonymousVarArgs);
                      continue;
                      paramAnonymousVarArgs = new java/io/FileOutputStream;
                      paramAnonymousVarArgs.<init>(paramParcelFileDescriptor.getFileDescriptor());
                      localPrintedPdfDocument1.writeTo(paramAnonymousVarArgs);
                      localPrintedPdfDocument1.close();
                      paramAnonymousVarArgs = paramParcelFileDescriptor;
                      if (paramAnonymousVarArgs == null) {
                        break label384;
                      }
                    }
                    catch (IOException localIOException)
                    {
                      try
                      {
                        paramParcelFileDescriptor.close();
                        paramAnonymousVarArgs = localParcelFileDescriptor;
                        if (localBitmap == paramBitmap) {
                          continue;
                        }
                        localBitmap.recycle();
                        paramAnonymousVarArgs = localParcelFileDescriptor;
                        continue;
                        localIOException = localIOException;
                      }
                      catch (IOException paramAnonymousVarArgs)
                      {
                        for (;;) {}
                      }
                    }
                  }
                }
                catch (IOException paramAnonymousVarArgs)
                {
                  for (;;) {}
                }
              }
            }
            return paramAnonymousVarArgs;
            localPrintedPdfDocument1 = new android/print/pdf/PrintedPdfDocument;
            localPrintedPdfDocument1.<init>(PrintHelperKitkat.this.mContext, localPrintAttributes);
            localBitmap = PrintHelperKitkat.this.convertBitmapForColorMode(paramBitmap, localPrintAttributes.getColorMode());
            bool = paramCancellationSignal.isCanceled();
            paramAnonymousVarArgs = localParcelFileDescriptor;
          } while (bool);
        }
        
        protected void onPostExecute(Throwable paramAnonymousThrowable)
        {
          if (paramCancellationSignal.isCanceled()) {
            paramWriteResultCallback.onWriteCancelled();
          }
          for (;;)
          {
            return;
            if (paramAnonymousThrowable == null)
            {
              paramWriteResultCallback.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
            }
            else
            {
              Log.e("PrintHelperKitkat", "Error writing printed content", paramAnonymousThrowable);
              paramWriteResultCallback.onWriteFailed(null);
            }
          }
        }
      }.execute(new Void[0]);
      return;
    }
  }
  
  protected PrintAttributes.Builder copyAttributes(PrintAttributes paramPrintAttributes)
  {
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder().setMediaSize(paramPrintAttributes.getMediaSize()).setResolution(paramPrintAttributes.getResolution()).setMinMargins(paramPrintAttributes.getMinMargins());
    if (paramPrintAttributes.getColorMode() != 0) {
      localBuilder.setColorMode(paramPrintAttributes.getColorMode());
    }
    return localBuilder;
  }
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getOrientation()
  {
    if (this.mOrientation == 0) {}
    for (int i = 1;; i = this.mOrientation) {
      return i;
    }
  }
  
  public int getScaleMode()
  {
    return this.mScaleMode;
  }
  
  public void printBitmap(final String paramString, final Bitmap paramBitmap, final OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    if (paramBitmap == null) {
      return;
    }
    final int i = this.mScaleMode;
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    if (isPortrait(paramBitmap)) {}
    for (Object localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;; localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE)
    {
      localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(this.mColorMode).build();
      localPrintManager.print(paramString, new PrintDocumentAdapter()
      {
        private PrintAttributes mAttributes;
        
        public void onFinish()
        {
          if (paramOnPrintFinishCallback != null) {
            paramOnPrintFinishCallback.onFinish();
          }
        }
        
        public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
        {
          boolean bool = true;
          this.mAttributes = paramAnonymousPrintAttributes2;
          paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
          if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
          for (;;)
          {
            paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
            return;
            bool = false;
          }
        }
        
        public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
        {
          PrintHelperKitkat.this.writeBitmap(this.mAttributes, i, paramBitmap, paramAnonymousParcelFileDescriptor, paramAnonymousCancellationSignal, paramAnonymousWriteResultCallback);
        }
      }, (PrintAttributes)localObject);
      break;
    }
  }
  
  public void printBitmap(final String paramString, final Uri paramUri, final OnPrintFinishCallback paramOnPrintFinishCallback)
    throws FileNotFoundException
  {
    paramOnPrintFinishCallback = new PrintDocumentAdapter()
    {
      private PrintAttributes mAttributes;
      Bitmap mBitmap = null;
      AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
      
      private void cancelLoad()
      {
        synchronized (PrintHelperKitkat.this.mLock)
        {
          if (PrintHelperKitkat.this.mDecodeOptions != null)
          {
            PrintHelperKitkat.this.mDecodeOptions.requestCancelDecode();
            PrintHelperKitkat.this.mDecodeOptions = null;
          }
          return;
        }
      }
      
      public void onFinish()
      {
        super.onFinish();
        cancelLoad();
        if (this.mLoadBitmap != null) {
          this.mLoadBitmap.cancel(true);
        }
        if (paramOnPrintFinishCallback != null) {
          paramOnPrintFinishCallback.onFinish();
        }
        if (this.mBitmap != null)
        {
          this.mBitmap.recycle();
          this.mBitmap = null;
        }
      }
      
      public void onLayout(final PrintAttributes paramAnonymousPrintAttributes1, final PrintAttributes paramAnonymousPrintAttributes2, final CancellationSignal paramAnonymousCancellationSignal, final PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        boolean bool = true;
        for (;;)
        {
          try
          {
            this.mAttributes = paramAnonymousPrintAttributes2;
            if (paramAnonymousCancellationSignal.isCanceled())
            {
              paramAnonymousLayoutResultCallback.onLayoutCancelled();
              return;
            }
          }
          finally {}
          if (this.mBitmap != null)
          {
            paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
            if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
            for (;;)
            {
              paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
              break;
              bool = false;
            }
          }
          this.mLoadBitmap = new AsyncTask()
          {
            protected Bitmap doInBackground(Uri... paramAnonymous2VarArgs)
            {
              try
              {
                paramAnonymous2VarArgs = PrintHelperKitkat.this.loadConstrainedBitmap(PrintHelperKitkat.3.this.val$imageFile, 3500);
                return paramAnonymous2VarArgs;
              }
              catch (FileNotFoundException paramAnonymous2VarArgs)
              {
                for (;;)
                {
                  paramAnonymous2VarArgs = null;
                }
              }
            }
            
            protected void onCancelled(Bitmap paramAnonymous2Bitmap)
            {
              paramAnonymousLayoutResultCallback.onLayoutCancelled();
              PrintHelperKitkat.3.this.mLoadBitmap = null;
            }
            
            protected void onPostExecute(Bitmap paramAnonymous2Bitmap)
            {
              super.onPostExecute(paramAnonymous2Bitmap);
              Object localObject = paramAnonymous2Bitmap;
              if (paramAnonymous2Bitmap != null) {
                if (PrintHelperKitkat.this.mPrintActivityRespectsOrientation)
                {
                  localObject = paramAnonymous2Bitmap;
                  if (PrintHelperKitkat.this.mOrientation != 0) {
                    break label108;
                  }
                }
              }
              for (;;)
              {
                try
                {
                  PrintAttributes.MediaSize localMediaSize = PrintHelperKitkat.3.this.mAttributes.getMediaSize();
                  localObject = paramAnonymous2Bitmap;
                  if (localMediaSize != null)
                  {
                    localObject = paramAnonymous2Bitmap;
                    if (localMediaSize.isPortrait() != PrintHelperKitkat.isPortrait(paramAnonymous2Bitmap))
                    {
                      localObject = new Matrix();
                      ((Matrix)localObject).postRotate(90.0F);
                      localObject = Bitmap.createBitmap(paramAnonymous2Bitmap, 0, 0, paramAnonymous2Bitmap.getWidth(), paramAnonymous2Bitmap.getHeight(), (Matrix)localObject, true);
                    }
                  }
                  label108:
                  PrintHelperKitkat.3.this.mBitmap = ((Bitmap)localObject);
                  if (localObject == null) {
                    break label190;
                  }
                  paramAnonymous2Bitmap = new PrintDocumentInfo.Builder(PrintHelperKitkat.3.this.val$jobName).setContentType(1).setPageCount(1).build();
                  if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1))
                  {
                    bool = true;
                    paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymous2Bitmap, bool);
                    PrintHelperKitkat.3.this.mLoadBitmap = null;
                    return;
                  }
                }
                finally {}
                boolean bool = false;
                continue;
                label190:
                paramAnonymousLayoutResultCallback.onLayoutFailed(null);
              }
            }
            
            protected void onPreExecute()
            {
              paramAnonymousCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
              {
                public void onCancel()
                {
                  PrintHelperKitkat.3.this.cancelLoad();
                  PrintHelperKitkat.3.1.this.cancel(false);
                }
              });
            }
          }.execute(new Uri[0]);
        }
      }
      
      public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        PrintHelperKitkat.this.writeBitmap(this.mAttributes, this.val$fittingMode, this.mBitmap, paramAnonymousParcelFileDescriptor, paramAnonymousCancellationSignal, paramAnonymousWriteResultCallback);
      }
    };
    paramUri = (PrintManager)this.mContext.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(this.mColorMode);
    if ((this.mOrientation == 1) || (this.mOrientation == 0)) {
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    }
    for (;;)
    {
      paramUri.print(paramString, paramOnPrintFinishCallback, localBuilder.build());
      return;
      if (this.mOrientation == 2) {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
      }
    }
  }
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
  
  public static abstract interface OnPrintFinishCallback
  {
    public abstract void onFinish();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\print\PrintHelperKitkat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */