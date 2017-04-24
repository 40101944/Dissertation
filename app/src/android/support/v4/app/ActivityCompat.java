package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

public class ActivityCompat
  extends ContextCompat
{
  private static ActivityCompatApi21.SharedElementCallback21 createCallback(SharedElementCallback paramSharedElementCallback)
  {
    SharedElementCallback21Impl localSharedElementCallback21Impl = null;
    if (paramSharedElementCallback != null) {
      localSharedElementCallback21Impl = new SharedElementCallback21Impl(paramSharedElementCallback);
    }
    return localSharedElementCallback21Impl;
  }
  
  private static ActivityCompatApi23.SharedElementCallback23 createCallback23(SharedElementCallback paramSharedElementCallback)
  {
    SharedElementCallback23Impl localSharedElementCallback23Impl = null;
    if (paramSharedElementCallback != null) {
      localSharedElementCallback23Impl = new SharedElementCallback23Impl(paramSharedElementCallback);
    }
    return localSharedElementCallback23Impl;
  }
  
  public static void finishAffinity(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.finishAffinity(paramActivity);
    }
    for (;;)
    {
      return;
      paramActivity.finish();
    }
  }
  
  public static void finishAfterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompatApi21.finishAfterTransition(paramActivity);
    }
    for (;;)
    {
      return;
      paramActivity.finish();
    }
  }
  
  @Nullable
  public static Uri getReferrer(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      paramActivity = ActivityCompatApi22.getReferrer(paramActivity);
    }
    for (;;)
    {
      return paramActivity;
      Intent localIntent = paramActivity.getIntent();
      Uri localUri = (Uri)localIntent.getParcelableExtra("android.intent.extra.REFERRER");
      paramActivity = localUri;
      if (localUri == null)
      {
        paramActivity = localIntent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (paramActivity != null) {
          paramActivity = Uri.parse(paramActivity);
        } else {
          paramActivity = null;
        }
      }
    }
  }
  
  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      ActivityCompatHoneycomb.invalidateOptionsMenu(paramActivity);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void postponeEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompatApi21.postponeEnterTransition(paramActivity);
    }
  }
  
  public static void requestPermissions(@NonNull final Activity paramActivity, @NonNull String[] paramArrayOfString, @IntRange(from=0L) final int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      ActivityCompatApi23.requestPermissions(paramActivity, paramArrayOfString, paramInt);
    }
    for (;;)
    {
      return;
      if ((paramActivity instanceof OnRequestPermissionsResultCallback)) {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            int[] arrayOfInt = new int[this.val$permissions.length];
            PackageManager localPackageManager = paramActivity.getPackageManager();
            String str = paramActivity.getPackageName();
            int j = this.val$permissions.length;
            for (int i = 0; i < j; i++) {
              arrayOfInt[i] = localPackageManager.checkPermission(this.val$permissions[i], str);
            }
            ((ActivityCompat.OnRequestPermissionsResultCallback)paramActivity).onRequestPermissionsResult(paramInt, this.val$permissions, arrayOfInt);
          }
        });
      }
    }
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      ActivityCompatApi23.setEnterSharedElementCallback(paramActivity, createCallback23(paramSharedElementCallback));
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        ActivityCompatApi21.setEnterSharedElementCallback(paramActivity, createCallback(paramSharedElementCallback));
      }
    }
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      ActivityCompatApi23.setExitSharedElementCallback(paramActivity, createCallback23(paramSharedElementCallback));
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        ActivityCompatApi21.setExitSharedElementCallback(paramActivity, createCallback(paramSharedElementCallback));
      }
    }
  }
  
  public static boolean shouldShowRequestPermissionRationale(@NonNull Activity paramActivity, @NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = ActivityCompatApi23.shouldShowRequestPermissionRationale(paramActivity, paramString);; bool = false) {
      return bool;
    }
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.startActivityForResult(paramActivity, paramIntent, paramInt, paramBundle);
    }
    for (;;)
    {
      return;
      paramActivity.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  public static void startIntentSenderForResult(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
    throws IntentSender.SendIntentException
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.startIntentSenderForResult(paramActivity, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    }
    for (;;)
    {
      return;
      paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ActivityCompatApi21.startPostponedEnterTransition(paramActivity);
    }
  }
  
  public static abstract interface OnRequestPermissionsResultCallback
  {
    public abstract void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt);
  }
  
  private static class SharedElementCallback21Impl
    extends ActivityCompatApi21.SharedElementCallback21
  {
    private SharedElementCallback mCallback;
    
    public SharedElementCallback21Impl(SharedElementCallback paramSharedElementCallback)
    {
      this.mCallback = paramSharedElementCallback;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      return this.mCallback.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
    }
    
    public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return this.mCallback.onCreateSnapshotView(paramContext, paramParcelable);
    }
    
    public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap)
    {
      this.mCallback.onMapSharedElements(paramList, paramMap);
    }
    
    public void onRejectSharedElements(List<View> paramList)
    {
      this.mCallback.onRejectSharedElements(paramList);
    }
    
    public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.mCallback.onSharedElementEnd(paramList, paramList1, paramList2);
    }
    
    public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.mCallback.onSharedElementStart(paramList, paramList1, paramList2);
    }
  }
  
  private static class SharedElementCallback23Impl
    extends ActivityCompatApi23.SharedElementCallback23
  {
    private SharedElementCallback mCallback;
    
    public SharedElementCallback23Impl(SharedElementCallback paramSharedElementCallback)
    {
      this.mCallback = paramSharedElementCallback;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      return this.mCallback.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
    }
    
    public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return this.mCallback.onCreateSnapshotView(paramContext, paramParcelable);
    }
    
    public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap)
    {
      this.mCallback.onMapSharedElements(paramList, paramMap);
    }
    
    public void onRejectSharedElements(List<View> paramList)
    {
      this.mCallback.onRejectSharedElements(paramList);
    }
    
    public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.mCallback.onSharedElementEnd(paramList, paramList1, paramList2);
    }
    
    public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      this.mCallback.onSharedElementStart(paramList, paramList1, paramList2);
    }
    
    public void onSharedElementsArrived(List<String> paramList, List<View> paramList1, final ActivityCompatApi23.OnSharedElementsReadyListenerBridge paramOnSharedElementsReadyListenerBridge)
    {
      this.mCallback.onSharedElementsArrived(paramList, paramList1, new SharedElementCallback.OnSharedElementsReadyListener()
      {
        public void onSharedElementsReady()
        {
          paramOnSharedElementsReadyListenerBridge.onSharedElementsReady();
        }
      });
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\app\ActivityCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */