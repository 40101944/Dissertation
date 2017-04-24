package com.google.android.gms.ads.identifier;

import android.support.annotation.WorkerThread;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class zza
{
  @WorkerThread
  public void zzv(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject1 = new java/net/URL;
        ((URL)localObject1).<init>(paramString);
        localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Object localObject1;
        int i;
        str = String.valueOf(localIndexOutOfBoundsException.getMessage());
        Log.w("HttpUrlPinger", String.valueOf(paramString).length() + 32 + String.valueOf(str).length() + "Error while parsing ping URL: " + paramString + ". " + str, localIndexOutOfBoundsException);
        continue;
      }
      catch (RuntimeException localRuntimeException)
      {
        String str = String.valueOf(localRuntimeException.getMessage());
        Log.w("HttpUrlPinger", String.valueOf(paramString).length() + 27 + String.valueOf(str).length() + "Error while pinging URL: " + paramString + ". " + str, localRuntimeException);
        continue;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      try
      {
        i = ((HttpURLConnection)localObject1).getResponseCode();
        if ((i < 200) || (i >= 300))
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>(String.valueOf(paramString).length() + 65);
          Log.w("HttpUrlPinger", "Received non-success response code " + i + " from pinging URL: " + paramString);
        }
        return;
      }
      finally
      {
        ((HttpURLConnection)localObject1).disconnect();
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\ads\identifier\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */