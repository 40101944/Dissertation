package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
  extends AbstractSafeParcelable
  implements Api.ApiOptions.Optional, ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzb();
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  private static Comparator<Scope> jm = new Comparator()
  {
    public int zza(Scope paramAnonymousScope1, Scope paramAnonymousScope2)
    {
      return paramAnonymousScope1.zzari().compareTo(paramAnonymousScope2.zzari());
    }
  };
  public static final Scope jn = new Scope("profile");
  public static final Scope jo = new Scope("email");
  public static final Scope jp = new Scope("openid");
  private Account gj;
  private final ArrayList<Scope> jq;
  private boolean jr;
  private final boolean js;
  private final boolean jt;
  private String ju;
  private String jv;
  final int versionCode;
  
  static
  {
    DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
  }
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    this.versionCode = paramInt;
    this.jq = paramArrayList;
    this.gj = paramAccount;
    this.jr = paramBoolean1;
    this.js = paramBoolean2;
    this.jt = paramBoolean3;
    this.ju = paramString1;
    this.jv = paramString2;
  }
  
  private GoogleSignInOptions(Set<Scope> paramSet, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    this(2, new ArrayList(paramSet), paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2);
  }
  
  private JSONObject zzais()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>();
      Collections.sort(this.jq, jm);
      Iterator localIterator = this.jq.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Scope)localIterator.next()).zzari());
      }
      localJSONObject.put("scopes", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    if (this.gj != null) {
      localJSONObject.put("accountName", this.gj.name);
    }
    localJSONObject.put("idTokenRequested", this.jr);
    localJSONObject.put("forceCodeForRefreshToken", this.jt);
    localJSONObject.put("serverAuthRequested", this.js);
    if (!TextUtils.isEmpty(this.ju)) {
      localJSONObject.put("serverClientId", this.ju);
    }
    if (!TextUtils.isEmpty(this.jv)) {
      localJSONObject.put("hostedDomain", this.jv);
    }
    return localJSONObject;
  }
  
  @Nullable
  public static GoogleSignInOptions zzgb(@Nullable String paramString)
    throws JSONException
  {
    HashSet localHashSet = null;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = localHashSet;
      return paramString;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    localHashSet = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      localHashSet.add(new Scope(paramString.getString(i)));
    }
    paramString = localJSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = new Account(paramString, "com.google");; paramString = null)
    {
      paramString = new GoogleSignInOptions(localHashSet, paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), localJSONObject.optString("serverClientId", null), localJSONObject.optString("hostedDomain", null));
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        paramObject = (GoogleSignInOptions)paramObject;
        bool1 = bool2;
        if (this.jq.size() != ((GoogleSignInOptions)paramObject).zzait().size()) {
          continue;
        }
        bool1 = bool2;
        if (!this.jq.containsAll(((GoogleSignInOptions)paramObject).zzait())) {
          continue;
        }
        if (this.gj == null)
        {
          bool1 = bool2;
          if (((GoogleSignInOptions)paramObject).getAccount() != null) {
            continue;
          }
          label66:
          if (!TextUtils.isEmpty(this.ju)) {
            break label151;
          }
          bool1 = bool2;
          if (!TextUtils.isEmpty(((GoogleSignInOptions)paramObject).zzaix())) {
            continue;
          }
        }
        for (;;)
        {
          bool1 = bool2;
          if (this.jt != ((GoogleSignInOptions)paramObject).zzaiw()) {
            break;
          }
          bool1 = bool2;
          if (this.jr != ((GoogleSignInOptions)paramObject).zzaiu()) {
            break;
          }
          bool1 = bool2;
          if (this.js != ((GoogleSignInOptions)paramObject).zzaiv()) {
            break;
          }
          bool1 = true;
          break;
          bool1 = bool2;
          if (!this.gj.equals(((GoogleSignInOptions)paramObject).getAccount())) {
            break;
          }
          break label66;
          label151:
          boolean bool3 = this.ju.equals(((GoogleSignInOptions)paramObject).zzaix());
          bool1 = bool2;
          if (!bool3) {
            break;
          }
        }
      }
      catch (ClassCastException paramObject)
      {
        bool1 = bool2;
      }
    }
  }
  
  public Account getAccount()
  {
    return this.gj;
  }
  
  public Scope[] getScopeArray()
  {
    return (Scope[])this.jq.toArray(new Scope[this.jq.size()]);
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jq.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Scope)localIterator.next()).zzari());
    }
    Collections.sort(localArrayList);
    return new zze().zzq(localArrayList).zzq(this.gj).zzq(this.ju).zzbe(this.jt).zzbe(this.jr).zzbe(this.js).zzajf();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzaiq()
  {
    return zzais().toString();
  }
  
  public ArrayList<Scope> zzait()
  {
    return new ArrayList(this.jq);
  }
  
  public boolean zzaiu()
  {
    return this.jr;
  }
  
  public boolean zzaiv()
  {
    return this.js;
  }
  
  public boolean zzaiw()
  {
    return this.jt;
  }
  
  public String zzaix()
  {
    return this.ju;
  }
  
  public String zzaiy()
  {
    return this.jv;
  }
  
  public static final class Builder
  {
    private Account gj;
    private boolean jr;
    private boolean js;
    private boolean jt;
    private String ju;
    private String jv;
    private Set<Scope> jw = new HashSet();
    
    public Builder() {}
    
    public Builder(@NonNull GoogleSignInOptions paramGoogleSignInOptions)
    {
      zzaa.zzy(paramGoogleSignInOptions);
      this.jw = new HashSet(GoogleSignInOptions.zzb(paramGoogleSignInOptions));
      this.js = GoogleSignInOptions.zzc(paramGoogleSignInOptions);
      this.jt = GoogleSignInOptions.zzd(paramGoogleSignInOptions);
      this.jr = GoogleSignInOptions.zze(paramGoogleSignInOptions);
      this.ju = GoogleSignInOptions.zzf(paramGoogleSignInOptions);
      this.gj = GoogleSignInOptions.zzg(paramGoogleSignInOptions);
      this.jv = GoogleSignInOptions.zzh(paramGoogleSignInOptions);
    }
    
    private String zzgc(String paramString)
    {
      zzaa.zzib(paramString);
      if ((this.ju == null) || (this.ju.equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        zzaa.zzb(bool, "two different server client ids provided");
        return paramString;
      }
    }
    
    public GoogleSignInOptions build()
    {
      if ((this.jr) && ((this.gj == null) || (!this.jw.isEmpty()))) {
        requestId();
      }
      return new GoogleSignInOptions(this.jw, this.gj, this.jr, this.js, this.jt, this.ju, this.jv, null);
    }
    
    public Builder requestEmail()
    {
      this.jw.add(GoogleSignInOptions.jo);
      return this;
    }
    
    public Builder requestId()
    {
      this.jw.add(GoogleSignInOptions.jp);
      return this;
    }
    
    public Builder requestIdToken(String paramString)
    {
      this.jr = true;
      this.ju = zzgc(paramString);
      return this;
    }
    
    public Builder requestProfile()
    {
      this.jw.add(GoogleSignInOptions.jn);
      return this;
    }
    
    public Builder requestScopes(Scope paramScope, Scope... paramVarArgs)
    {
      this.jw.add(paramScope);
      this.jw.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public Builder requestServerAuthCode(String paramString)
    {
      return requestServerAuthCode(paramString, false);
    }
    
    public Builder requestServerAuthCode(String paramString, boolean paramBoolean)
    {
      this.js = true;
      this.ju = zzgc(paramString);
      this.jt = paramBoolean;
      return this;
    }
    
    public Builder setAccountName(String paramString)
    {
      this.gj = new Account(zzaa.zzib(paramString), "com.google");
      return this;
    }
    
    public Builder setHostedDomain(String paramString)
    {
      this.jv = zzaa.zzib(paramString);
      return this;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */