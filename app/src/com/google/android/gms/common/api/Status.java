package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.internal.zzz.zza;

public final class Status
  extends AbstractSafeParcelable
  implements Result, ReflectedParcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new zzg();
  public static final Status xZ = new Status(0);
  public static final Status ya = new Status(14);
  public static final Status yb = new Status(8);
  public static final Status yc = new Status(15);
  public static final Status yd = new Status(16);
  public static final Status ye = new Status(17);
  public static final Status yf = new Status(18);
  private final PendingIntent mPendingIntent;
  final int mVersionCode;
  private final int uo;
  private final String wP;
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.mVersionCode = paramInt1;
    this.uo = paramInt2;
    this.wP = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramObject instanceof Status)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramObject = (Status)paramObject;
      bool1 = bool2;
      if (this.mVersionCode == ((Status)paramObject).mVersionCode)
      {
        bool1 = bool2;
        if (this.uo == ((Status)paramObject).uo)
        {
          bool1 = bool2;
          if (zzz.equal(this.wP, ((Status)paramObject).wP))
          {
            bool1 = bool2;
            if (zzz.equal(this.mPendingIntent, ((Status)paramObject).mPendingIntent)) {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return this.uo;
  }
  
  @Nullable
  public String getStatusMessage()
  {
    return this.wP;
  }
  
  public boolean hasResolution()
  {
    if (this.mPendingIntent != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return zzz.hashCode(new Object[] { Integer.valueOf(this.mVersionCode), Integer.valueOf(this.uo), this.wP, this.mPendingIntent });
  }
  
  public boolean isCanceled()
  {
    if (this.uo == 16) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isInterrupted()
  {
    if (this.uo == 14) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isSuccess()
  {
    if (this.uo <= 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {}
    for (;;)
    {
      return;
      paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
    }
  }
  
  public String toString()
  {
    return zzz.zzx(this).zzg("statusCode", zzark()).zzg("resolution", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  PendingIntent zzarj()
  {
    return this.mPendingIntent;
  }
  
  public String zzark()
  {
    if (this.wP != null) {}
    for (String str = this.wP;; str = CommonStatusCodes.getStatusCodeString(this.uo)) {
      return str;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\api\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */