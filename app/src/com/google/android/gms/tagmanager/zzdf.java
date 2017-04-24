package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

class zzdf
  implements zzad
{
  private final zzb aHE;
  private final zza aHF;
  private final Context mContext;
  private final String zzbre;
  
  zzdf(Context paramContext, zza paramzza)
  {
    this(new zzb()
    {
      public HttpURLConnection zzd(URL paramAnonymousURL)
        throws IOException
      {
        return (HttpURLConnection)paramAnonymousURL.openConnection();
      }
    }, paramContext, paramzza);
  }
  
  zzdf(zzb paramzzb, Context paramContext, zza paramzza)
  {
    this.aHE = paramzzb;
    this.mContext = paramContext.getApplicationContext();
    this.aHF = paramzza;
    this.zzbre = zza("GoogleTagManager", "4.00", Build.VERSION.RELEASE, zzc(Locale.getDefault()), Build.MODEL, Build.ID);
  }
  
  static String zzc(Locale paramLocale)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramLocale == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (String)localObject1;
      localObject1 = localObject2;
      if (paramLocale.getLanguage() != null)
      {
        localObject1 = localObject2;
        if (paramLocale.getLanguage().length() != 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramLocale.getLanguage().toLowerCase());
          if ((paramLocale.getCountry() != null) && (paramLocale.getCountry().length() != 0)) {
            ((StringBuilder)localObject1).append("-").append(paramLocale.getCountry().toLowerCase());
          }
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
  }
  
  String zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  public void zzal(List<zzas> paramList)
  {
    int n = Math.min(paramList.size(), 40);
    j = 1;
    int m = 0;
    zzas localzzas;
    Object localObject1;
    if (m < n)
    {
      localzzas = (zzas)paramList.get(m);
      localObject1 = zzd(localzzas);
      if (localObject1 == null)
      {
        zzbo.zzdi("No destination: discarding hit.");
        this.aHF.zzb(localzzas);
        i = j;
      }
    }
    for (;;)
    {
      m++;
      j = i;
      break;
      int k = j;
      label188:
      Object localObject4;
      try
      {
        localHttpURLConnection = this.aHE.zzd((URL)localObject1);
        i = j;
        if (j == 0) {}
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          HttpURLConnection localHttpURLConnection;
          label236:
          String str;
          i = k;
        }
      }
      try
      {
        zzbt.zzeg(this.mContext);
        i = 0;
        j = i;
        localHttpURLConnection.setRequestProperty("User-Agent", this.zzbre);
        j = i;
        k = localHttpURLConnection.getResponseCode();
        j = i;
        localObject1 = localHttpURLConnection.getInputStream();
        if (k != 200) {}
        try
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>(25);
          zzbo.zzdi("Bad response: " + k);
          this.aHF.zzc(localzzas);
          if (localObject1 != null)
          {
            k = i;
            ((InputStream)localObject1).close();
          }
          k = i;
          localHttpURLConnection.disconnect();
          continue;
        }
        finally
        {
          localObject4 = localObject1;
          localObject1 = localObject3;
        }
        this.aHF.zza(localzzas);
        break label188;
      }
      finally
      {
        localObject4 = null;
        i = j;
        break label236;
      }
    }
    if (localObject4 != null) {}
    try
    {
      ((InputStream)localObject4).close();
      localHttpURLConnection.disconnect();
      throw ((Throwable)localObject1);
    }
    catch (IOException localIOException1) {}
    str = String.valueOf(localIOException1.getClass().getSimpleName());
    if (str.length() != 0) {}
    for (str = "Exception sending hit: ".concat(str);; str = new String("Exception sending hit: "))
    {
      zzbo.zzdi(str);
      zzbo.zzdi(localIOException1.getMessage());
      this.aHF.zzc(localzzas);
      break;
    }
  }
  
  public boolean zzcez()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
      zzbo.v("...no network connectivity");
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  URL zzd(zzas paramzzas)
  {
    String str = paramzzas.zzcfk();
    try
    {
      paramzzas = new java/net/URL;
      paramzzas.<init>(str);
      return paramzzas;
    }
    catch (MalformedURLException paramzzas)
    {
      for (;;)
      {
        zzbo.e("Error trying to parse the GTM url.");
        paramzzas = null;
      }
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzas paramzzas);
    
    public abstract void zzb(zzas paramzzas);
    
    public abstract void zzc(zzas paramzzas);
  }
  
  static abstract interface zzb
  {
    public abstract HttpURLConnection zzd(URL paramURL)
      throws IOException;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */