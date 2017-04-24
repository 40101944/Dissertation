package com.google.android.gms.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class zzafy
  implements zzafz
{
  private HttpURLConnection aLF;
  
  private InputStream zzd(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200) {
      return paramHttpURLConnection.getInputStream();
    }
    paramHttpURLConnection = 25 + "Bad response: " + i;
    if (i == 404) {
      throw new FileNotFoundException(paramHttpURLConnection);
    }
    if (i == 503) {
      throw new zzagb(paramHttpURLConnection);
    }
    throw new IOException(paramHttpURLConnection);
  }
  
  private void zze(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.disconnect();
    }
  }
  
  public void close()
  {
    zze(this.aLF);
  }
  
  public InputStream zzqz(String paramString)
    throws IOException
  {
    this.aLF = zzra(paramString);
    return zzd(this.aLF);
  }
  
  HttpURLConnection zzra(String paramString)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setReadTimeout(20000);
    paramString.setConnectTimeout(20000);
    return paramString;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzafy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */