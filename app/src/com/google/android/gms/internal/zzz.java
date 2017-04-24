package com.google.android.gms.internal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class zzz
  implements zzy
{
  private final zza zzce;
  private final SSLSocketFactory zzcf;
  
  public zzz()
  {
    this(null);
  }
  
  public zzz(zza paramzza)
  {
    this(paramzza, null);
  }
  
  public zzz(zza paramzza, SSLSocketFactory paramSSLSocketFactory)
  {
    this.zzce = paramzza;
    this.zzcf = paramSSLSocketFactory;
  }
  
  private HttpURLConnection zza(URL paramURL, zzk<?> paramzzk)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = zza(paramURL);
    int i = paramzzk.zzr();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if (("https".equals(paramURL.getProtocol())) && (this.zzcf != null)) {
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(this.zzcf);
    }
    return localHttpURLConnection;
  }
  
  private static HttpEntity zza(HttpURLConnection paramHttpURLConnection)
  {
    BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
    try
    {
      InputStream localInputStream1 = paramHttpURLConnection.getInputStream();
      localBasicHttpEntity.setContent(localInputStream1);
      localBasicHttpEntity.setContentLength(paramHttpURLConnection.getContentLength());
      localBasicHttpEntity.setContentEncoding(paramHttpURLConnection.getContentEncoding());
      localBasicHttpEntity.setContentType(paramHttpURLConnection.getContentType());
      return localBasicHttpEntity;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        InputStream localInputStream2 = paramHttpURLConnection.getErrorStream();
      }
    }
  }
  
  static void zza(HttpURLConnection paramHttpURLConnection, zzk<?> paramzzk)
    throws IOException, zza
  {
    switch (paramzzk.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case -1: 
      byte[] arrayOfByte = paramzzk.zzl();
      if (arrayOfByte != null)
      {
        paramHttpURLConnection.setDoOutput(true);
        paramHttpURLConnection.setRequestMethod("POST");
        paramHttpURLConnection.addRequestProperty("Content-Type", paramzzk.zzk());
        paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
        paramHttpURLConnection.write(arrayOfByte);
        paramHttpURLConnection.close();
      }
      break;
    }
    for (;;)
    {
      return;
      paramHttpURLConnection.setRequestMethod("GET");
      continue;
      paramHttpURLConnection.setRequestMethod("DELETE");
      continue;
      paramHttpURLConnection.setRequestMethod("POST");
      zzb(paramHttpURLConnection, paramzzk);
      continue;
      paramHttpURLConnection.setRequestMethod("PUT");
      zzb(paramHttpURLConnection, paramzzk);
      continue;
      paramHttpURLConnection.setRequestMethod("HEAD");
      continue;
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      continue;
      paramHttpURLConnection.setRequestMethod("TRACE");
      continue;
      paramHttpURLConnection.setRequestMethod("PATCH");
      zzb(paramHttpURLConnection, paramzzk);
    }
  }
  
  private static void zzb(HttpURLConnection paramHttpURLConnection, zzk<?> paramzzk)
    throws IOException, zza
  {
    byte[] arrayOfByte = paramzzk.zzo();
    if (arrayOfByte != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.addRequestProperty("Content-Type", paramzzk.zzn());
      paramHttpURLConnection = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      paramHttpURLConnection.write(arrayOfByte);
      paramHttpURLConnection.close();
    }
  }
  
  protected HttpURLConnection zza(URL paramURL)
    throws IOException
  {
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  public HttpResponse zza(zzk<?> paramzzk, Map<String, String> paramMap)
    throws IOException, zza
  {
    Object localObject = paramzzk.getUrl();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramzzk.getHeaders());
    localHashMap.putAll(paramMap);
    String str;
    if (this.zzce != null)
    {
      str = this.zzce.zzh((String)localObject);
      paramMap = str;
      if (str == null)
      {
        paramzzk = String.valueOf(localObject);
        if (paramzzk.length() != 0) {}
        for (paramzzk = "URL blocked by rewriter: ".concat(paramzzk);; paramzzk = new String("URL blocked by rewriter: ")) {
          throw new IOException(paramzzk);
        }
      }
    }
    else
    {
      paramMap = (Map<String, String>)localObject;
    }
    paramMap = zza(new URL(paramMap), paramzzk);
    localObject = localHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      paramMap.addRequestProperty(str, (String)localHashMap.get(str));
    }
    zza(paramMap, paramzzk);
    paramzzk = new ProtocolVersion("HTTP", 1, 1);
    if (paramMap.getResponseCode() == -1) {
      throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }
    paramzzk = new BasicHttpResponse(new BasicStatusLine(paramzzk, paramMap.getResponseCode(), paramMap.getResponseMessage()));
    paramzzk.setEntity(zza(paramMap));
    localObject = paramMap.getHeaderFields().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramMap = (Map.Entry)((Iterator)localObject).next();
      if (paramMap.getKey() != null) {
        paramzzk.addHeader(new BasicHeader((String)paramMap.getKey(), (String)((List)paramMap.getValue()).get(0)));
      }
    }
    return paramzzk;
  }
  
  public static abstract interface zza
  {
    public abstract String zzh(String paramString);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */