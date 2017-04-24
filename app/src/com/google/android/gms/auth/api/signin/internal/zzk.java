package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzaa;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzk
{
  private static final Lock jS = new ReentrantLock();
  private static zzk jT;
  private final Lock jU = new ReentrantLock();
  private final SharedPreferences jV;
  
  zzk(Context paramContext)
  {
    this.jV = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  public static zzk zzba(Context paramContext)
  {
    zzaa.zzy(paramContext);
    jS.lock();
    try
    {
      if (jT == null)
      {
        zzk localzzk = new com/google/android/gms/auth/api/signin/internal/zzk;
        localzzk.<init>(paramContext.getApplicationContext());
        jT = localzzk;
      }
      paramContext = jT;
      return paramContext;
    }
    finally
    {
      jS.unlock();
    }
  }
  
  private String zzx(String paramString1, String paramString2)
  {
    String str = String.valueOf(":");
    return String.valueOf(paramString1).length() + 0 + String.valueOf(str).length() + String.valueOf(paramString2).length() + paramString1 + str + paramString2;
  }
  
  void zza(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzaa.zzy(paramGoogleSignInAccount);
    zzaa.zzy(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.zzaip();
    zzw(zzx("googleSignInAccount", str), paramGoogleSignInAccount.zzair());
    zzw(zzx("googleSignInOptions", str), paramGoogleSignInOptions.zzaiq());
  }
  
  public GoogleSignInAccount zzajm()
  {
    return zzgd(zzgf("defaultGoogleSignInAccount"));
  }
  
  public GoogleSignInOptions zzajn()
  {
    return zzge(zzgf("defaultGoogleSignInAccount"));
  }
  
  public void zzajo()
  {
    String str = zzgf("defaultGoogleSignInAccount");
    zzgh("defaultGoogleSignInAccount");
    zzgg(str);
  }
  
  public void zzb(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzaa.zzy(paramGoogleSignInAccount);
    zzaa.zzy(paramGoogleSignInOptions);
    zzw("defaultGoogleSignInAccount", paramGoogleSignInAccount.zzaip());
    zza(paramGoogleSignInAccount, paramGoogleSignInOptions);
  }
  
  GoogleSignInAccount zzgd(String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      String str = zzgf(zzx("googleSignInAccount", paramString));
      paramString = (String)localObject;
      if (str != null) {
        try
        {
          paramString = GoogleSignInAccount.zzfz(str);
        }
        catch (JSONException paramString)
        {
          paramString = (String)localObject;
        }
      }
    }
  }
  
  GoogleSignInOptions zzge(String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      String str = zzgf(zzx("googleSignInOptions", paramString));
      paramString = (String)localObject;
      if (str != null) {
        try
        {
          paramString = GoogleSignInOptions.zzgb(str);
        }
        catch (JSONException paramString)
        {
          paramString = (String)localObject;
        }
      }
    }
  }
  
  protected String zzgf(String paramString)
  {
    this.jU.lock();
    try
    {
      paramString = this.jV.getString(paramString, null);
      return paramString;
    }
    finally
    {
      this.jU.unlock();
    }
  }
  
  void zzgg(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      zzgh(zzx("googleSignInAccount", paramString));
      zzgh(zzx("googleSignInOptions", paramString));
    }
  }
  
  protected void zzgh(String paramString)
  {
    this.jU.lock();
    try
    {
      this.jV.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      this.jU.unlock();
    }
  }
  
  protected void zzw(String paramString1, String paramString2)
  {
    this.jU.lock();
    try
    {
      this.jV.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      this.jU.unlock();
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */