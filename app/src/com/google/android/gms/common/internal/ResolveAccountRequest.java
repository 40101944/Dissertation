package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zzab();
  private final int EH;
  private final GoogleSignInAccount EI;
  private final Account gj;
  final int mVersionCode;
  
  ResolveAccountRequest(int paramInt1, Account paramAccount, int paramInt2, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this.mVersionCode = paramInt1;
    this.gj = paramAccount;
    this.EH = paramInt2;
    this.EI = paramGoogleSignInAccount;
  }
  
  public ResolveAccountRequest(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }
  
  public Account getAccount()
  {
    return this.gj;
  }
  
  public int getSessionId()
  {
    return this.EH;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzab.zza(this, paramParcel, paramInt);
  }
  
  @Nullable
  public GoogleSignInAccount zzawl()
  {
    return this.EI;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\internal\ResolveAccountRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */