package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class zzcj
{
  private static zzcj aGl;
  private volatile String aDY;
  private volatile zza aGm;
  private volatile String aGn;
  private volatile String aGo;
  
  zzcj()
  {
    clear();
  }
  
  static zzcj zzcfz()
  {
    try
    {
      if (aGl == null)
      {
        localzzcj = new com/google/android/gms/tagmanager/zzcj;
        localzzcj.<init>();
        aGl = localzzcj;
      }
      zzcj localzzcj = aGl;
      return localzzcj;
    }
    finally {}
  }
  
  private String zzpo(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String zzw(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  void clear()
  {
    this.aGm = zza.aGp;
    this.aGn = null;
    this.aDY = null;
    this.aGo = null;
  }
  
  String getContainerId()
  {
    return this.aDY;
  }
  
  zza zzcga()
  {
    return this.aGm;
  }
  
  String zzcgb()
  {
    return this.aGn;
  }
  
  boolean zzv(Uri paramUri)
  {
    boolean bool = true;
    String str2;
    String str1;
    try
    {
      str2 = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str2.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label177;
      }
      str1 = String.valueOf(str2);
      if (str1.length() == 0) {
        break label149;
      }
      str1 = "Container preview url: ".concat(str1);
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;)
      {
        bool = false;
        continue;
        label149:
        str1 = new String("Container preview url: ");
      }
    }
    finally {}
    zzbo.v(str1);
    if (str2.matches(".*?&gtm_debug=x$"))
    {
      this.aGm = zza.aGr;
      this.aGo = zzw(paramUri);
      if ((this.aGm == zza.aGq) || (this.aGm == zza.aGr))
      {
        str1 = String.valueOf("/r?");
        paramUri = String.valueOf(this.aGo);
        if (paramUri.length() == 0) {
          break label306;
        }
      }
    }
    label177:
    label264:
    label306:
    for (paramUri = str1.concat(paramUri);; paramUri = new String(str1))
    {
      this.aGn = paramUri;
      this.aDY = zzpo(this.aGo);
      for (;;)
      {
        return bool;
        this.aGm = zza.aGq;
        break;
        if (!str2.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
          break label264;
        }
        if (zzpo(paramUri.getQuery()).equals(this.aDY))
        {
          paramUri = String.valueOf(this.aDY);
          if (paramUri.length() != 0) {}
          for (paramUri = "Exit preview mode for container: ".concat(paramUri);; paramUri = new String("Exit preview mode for container: "))
          {
            zzbo.v(paramUri);
            this.aGm = zza.aGp;
            this.aGn = null;
            break;
          }
        }
        bool = false;
      }
      paramUri = String.valueOf(str2);
      if (paramUri.length() != 0) {}
      for (paramUri = "Invalid preview uri: ".concat(paramUri);; paramUri = new String("Invalid preview uri: "))
      {
        zzbo.zzdi(paramUri);
        bool = false;
        break;
      }
    }
  }
  
  static enum zza
  {
    private zza() {}
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzcj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */