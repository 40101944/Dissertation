package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.zzrp;

public abstract class zzh
  implements DialogInterface.OnClickListener
{
  public static zzh zza(final Activity paramActivity, Intent paramIntent, final int paramInt)
  {
    new zzh()
    {
      public void zzavx()
      {
        if (zzh.this != null) {
          paramActivity.startActivityForResult(zzh.this, paramInt);
        }
      }
    };
  }
  
  public static zzh zza(@NonNull final Fragment paramFragment, Intent paramIntent, final int paramInt)
  {
    new zzh()
    {
      public void zzavx()
      {
        if (zzh.this != null) {
          paramFragment.startActivityForResult(zzh.this, paramInt);
        }
      }
    };
  }
  
  public static zzh zza(@NonNull final zzrp paramzzrp, Intent paramIntent, final int paramInt)
  {
    new zzh()
    {
      @TargetApi(11)
      public void zzavx()
      {
        if (zzh.this != null) {
          paramzzrp.startActivityForResult(zzh.this, paramInt);
        }
      }
    };
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      zzavx();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        Log.e("DialogRedirect", "Failed to start resolution intent", localActivityNotFoundException);
        paramDialogInterface.dismiss();
      }
    }
    finally
    {
      paramDialogInterface.dismiss();
    }
  }
  
  protected abstract void zzavx();
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */