package com.google.android.gms.internal;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;

public class zzw
  implements zzy
{
  protected final HttpClient zzcd;
  
  public zzw(HttpClient paramHttpClient)
  {
    this.zzcd = paramHttpClient;
  }
  
  private static void zza(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, zzk<?> paramzzk)
    throws zza
  {
    paramzzk = paramzzk.zzo();
    if (paramzzk != null) {
      paramHttpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(paramzzk));
    }
  }
  
  private static void zza(HttpUriRequest paramHttpUriRequest, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHttpUriRequest.setHeader(str, (String)paramMap.get(str));
    }
  }
  
  static HttpUriRequest zzb(zzk<?> paramzzk, Map<String, String> paramMap)
    throws zza
  {
    switch (paramzzk.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown request method.");
    case -1: 
      byte[] arrayOfByte = paramzzk.zzl();
      if (arrayOfByte != null)
      {
        paramMap = new HttpPost(paramzzk.getUrl());
        paramMap.addHeader("Content-Type", paramzzk.zzk());
        paramMap.setEntity(new ByteArrayEntity(arrayOfByte));
        paramzzk = paramMap;
      }
      break;
    }
    for (;;)
    {
      return paramzzk;
      paramzzk = new HttpGet(paramzzk.getUrl());
      continue;
      paramzzk = new HttpGet(paramzzk.getUrl());
      continue;
      paramzzk = new HttpDelete(paramzzk.getUrl());
      continue;
      paramMap = new HttpPost(paramzzk.getUrl());
      paramMap.addHeader("Content-Type", paramzzk.zzn());
      zza(paramMap, paramzzk);
      paramzzk = paramMap;
      continue;
      paramMap = new HttpPut(paramzzk.getUrl());
      paramMap.addHeader("Content-Type", paramzzk.zzn());
      zza(paramMap, paramzzk);
      paramzzk = paramMap;
      continue;
      paramzzk = new HttpHead(paramzzk.getUrl());
      continue;
      paramzzk = new HttpOptions(paramzzk.getUrl());
      continue;
      paramzzk = new HttpTrace(paramzzk.getUrl());
      continue;
      paramMap = new zza(paramzzk.getUrl());
      paramMap.addHeader("Content-Type", paramzzk.zzn());
      zza(paramMap, paramzzk);
      paramzzk = paramMap;
    }
  }
  
  public HttpResponse zza(zzk<?> paramzzk, Map<String, String> paramMap)
    throws IOException, zza
  {
    HttpUriRequest localHttpUriRequest = zzb(paramzzk, paramMap);
    zza(localHttpUriRequest, paramMap);
    zza(localHttpUriRequest, paramzzk.getHeaders());
    zza(localHttpUriRequest);
    paramMap = localHttpUriRequest.getParams();
    int i = paramzzk.zzr();
    HttpConnectionParams.setConnectionTimeout(paramMap, 5000);
    HttpConnectionParams.setSoTimeout(paramMap, i);
    return this.zzcd.execute(localHttpUriRequest);
  }
  
  protected void zza(HttpUriRequest paramHttpUriRequest)
    throws IOException
  {}
  
  public static final class zza
    extends HttpEntityEnclosingRequestBase
  {
    public zza() {}
    
    public zza(String paramString)
    {
      setURI(URI.create(paramString));
    }
    
    public String getMethod()
    {
      return "PATCH";
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */