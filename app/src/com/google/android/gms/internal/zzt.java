package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;

public class zzt
  implements zzf
{
  protected static final boolean DEBUG = zzs.DEBUG;
  private static int zzbn = 3000;
  private static int zzbo = 4096;
  protected final zzy zzbp;
  protected final zzu zzbq;
  
  public zzt(zzy paramzzy)
  {
    this(paramzzy, new zzu(zzbo));
  }
  
  public zzt(zzy paramzzy, zzu paramzzu)
  {
    this.zzbp = paramzzy;
    this.zzbq = paramzzu;
  }
  
  protected static Map<String, String> zza(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < paramArrayOfHeader.length; i++) {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
    }
    return localTreeMap;
  }
  
  private void zza(long paramLong, zzk<?> paramzzk, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    if ((DEBUG) || (paramLong > zzbn)) {
      if (paramArrayOfByte == null) {
        break label82;
      }
    }
    label82:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      zzs.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramzzk, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramStatusLine.getStatusCode()), Integer.valueOf(paramzzk.zzs().zzd()) });
      return;
    }
  }
  
  private static void zza(String paramString, zzk<?> paramzzk, zzr paramzzr)
    throws zzr
  {
    zzo localzzo = paramzzk.zzs();
    int i = paramzzk.zzr();
    try
    {
      localzzo.zza(paramzzr);
      paramzzk.zzc(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (zzr paramzzr)
    {
      paramzzk.zzc(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramzzr;
    }
  }
  
  private void zza(Map<String, String> paramMap, zzb.zza paramzza)
  {
    if (paramzza == null) {}
    for (;;)
    {
      return;
      if (paramzza.zza != null) {
        paramMap.put("If-None-Match", paramzza.zza);
      }
      if (paramzza.zzc > 0L) {
        paramMap.put("If-Modified-Since", DateUtils.formatDate(new Date(paramzza.zzc)));
      }
    }
  }
  
  private byte[] zza(HttpEntity paramHttpEntity)
    throws IOException, zzp
  {
    zzaa localzzaa = new zzaa(this.zzbq, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    try
    {
      localObject4 = paramHttpEntity.getContent();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
        localObject4 = new com/google/android/gms/internal/zzp;
        localObject1 = localObject2;
        ((zzp)localObject4).<init>();
        localObject1 = localObject2;
        throw ((Throwable)localObject4);
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.zzbq.zza((byte[])localObject1);
      localzzaa.close();
      throw ((Throwable)localObject3);
      localObject1 = localObject3;
      byte[] arrayOfByte = this.zzbq.zzb(1024);
      for (;;)
      {
        localObject1 = arrayOfByte;
        int i = ((InputStream)localObject4).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localObject1 = arrayOfByte;
        localzzaa.write(arrayOfByte, 0, i);
      }
      localObject1 = arrayOfByte;
      localObject4 = localzzaa.toByteArray();
      try
      {
        paramHttpEntity.consumeContent();
        this.zzbq.zza(arrayOfByte);
        localzzaa.close();
        return (byte[])localObject4;
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          zzs.zza("Error occured when calling consumingContent", new Object[0]);
        }
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        zzs.zza("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  /* Error */
  public zzi zza(zzk<?> paramzzk)
    throws zzr
  {
    // Byte code:
    //   0: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 9
    //   7: invokestatic 228	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   10: astore 7
    //   12: new 230	java/util/HashMap
    //   15: astore 5
    //   17: aload 5
    //   19: invokespecial 231	java/util/HashMap:<init>	()V
    //   22: aload_0
    //   23: aload 5
    //   25: aload_1
    //   26: invokevirtual 235	com/google/android/gms/internal/zzk:zzh	()Lcom/google/android/gms/internal/zzb$zza;
    //   29: invokespecial 237	com/google/android/gms/internal/zzt:zza	(Ljava/util/Map;Lcom/google/android/gms/internal/zzb$zza;)V
    //   32: aload_0
    //   33: getfield 41	com/google/android/gms/internal/zzt:zzbp	Lcom/google/android/gms/internal/zzy;
    //   36: aload_1
    //   37: aload 5
    //   39: invokeinterface 242 3 0
    //   44: astore 6
    //   46: aload 7
    //   48: astore 5
    //   50: aload 6
    //   52: invokeinterface 248 1 0
    //   57: astore 8
    //   59: aload 7
    //   61: astore 5
    //   63: aload 8
    //   65: invokeinterface 93 1 0
    //   70: istore_2
    //   71: aload 7
    //   73: astore 5
    //   75: aload 6
    //   77: invokeinterface 252 1 0
    //   82: invokestatic 254	com/google/android/gms/internal/zzt:zza	([Lorg/apache/http/Header;)Ljava/util/Map;
    //   85: astore 9
    //   87: iload_2
    //   88: sipush 304
    //   91: if_icmpne +102 -> 193
    //   94: aload 9
    //   96: astore 5
    //   98: aload_1
    //   99: invokevirtual 235	com/google/android/gms/internal/zzk:zzh	()Lcom/google/android/gms/internal/zzb$zza;
    //   102: astore 7
    //   104: aload 7
    //   106: ifnonnull +33 -> 139
    //   109: aload 9
    //   111: astore 5
    //   113: new 256	com/google/android/gms/internal/zzi
    //   116: dup
    //   117: sipush 304
    //   120: aconst_null
    //   121: aload 9
    //   123: iconst_1
    //   124: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   127: lload_3
    //   128: lsub
    //   129: invokespecial 259	com/google/android/gms/internal/zzi:<init>	(I[BLjava/util/Map;ZJ)V
    //   132: astore 7
    //   134: aload 7
    //   136: astore_1
    //   137: aload_1
    //   138: areturn
    //   139: aload 9
    //   141: astore 5
    //   143: aload 7
    //   145: getfield 263	com/google/android/gms/internal/zzb$zza:zzf	Ljava/util/Map;
    //   148: aload 9
    //   150: invokeinterface 267 2 0
    //   155: aload 9
    //   157: astore 5
    //   159: new 256	com/google/android/gms/internal/zzi
    //   162: dup
    //   163: sipush 304
    //   166: aload 7
    //   168: getfield 271	com/google/android/gms/internal/zzb$zza:data	[B
    //   171: aload 7
    //   173: getfield 263	com/google/android/gms/internal/zzb$zza:zzf	Ljava/util/Map;
    //   176: iconst_1
    //   177: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   180: lload_3
    //   181: lsub
    //   182: invokespecial 259	com/google/android/gms/internal/zzi:<init>	(I[BLjava/util/Map;ZJ)V
    //   185: astore 7
    //   187: aload 7
    //   189: astore_1
    //   190: goto -53 -> 137
    //   193: aload 9
    //   195: astore 5
    //   197: aload 6
    //   199: invokeinterface 275 1 0
    //   204: ifnull +84 -> 288
    //   207: aload 9
    //   209: astore 5
    //   211: aload_0
    //   212: aload 6
    //   214: invokeinterface 275 1 0
    //   219: invokespecial 277	com/google/android/gms/internal/zzt:zza	(Lorg/apache/http/HttpEntity;)[B
    //   222: astore 7
    //   224: aload 7
    //   226: astore 5
    //   228: aload_0
    //   229: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   232: lload_3
    //   233: lsub
    //   234: aload_1
    //   235: aload 5
    //   237: aload 8
    //   239: invokespecial 279	com/google/android/gms/internal/zzt:zza	(JLcom/google/android/gms/internal/zzk;[BLorg/apache/http/StatusLine;)V
    //   242: iload_2
    //   243: sipush 200
    //   246: if_icmplt +10 -> 256
    //   249: iload_2
    //   250: sipush 299
    //   253: if_icmple +51 -> 304
    //   256: new 162	java/io/IOException
    //   259: astore 7
    //   261: aload 7
    //   263: invokespecial 280	java/io/IOException:<init>	()V
    //   266: aload 7
    //   268: athrow
    //   269: astore 5
    //   271: ldc_w 282
    //   274: aload_1
    //   275: new 284	com/google/android/gms/internal/zzq
    //   278: dup
    //   279: invokespecial 285	com/google/android/gms/internal/zzq:<init>	()V
    //   282: invokestatic 287	com/google/android/gms/internal/zzt:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzk;Lcom/google/android/gms/internal/zzr;)V
    //   285: goto -281 -> 4
    //   288: aload 9
    //   290: astore 5
    //   292: iconst_0
    //   293: newarray <illegal type>
    //   295: astore 7
    //   297: aload 7
    //   299: astore 5
    //   301: goto -73 -> 228
    //   304: new 256	com/google/android/gms/internal/zzi
    //   307: dup
    //   308: iload_2
    //   309: aload 5
    //   311: aload 9
    //   313: iconst_0
    //   314: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   317: lload_3
    //   318: lsub
    //   319: invokespecial 259	com/google/android/gms/internal/zzi:<init>	(I[BLjava/util/Map;ZJ)V
    //   322: astore 7
    //   324: aload 7
    //   326: astore_1
    //   327: goto -190 -> 137
    //   330: astore 5
    //   332: ldc_w 289
    //   335: aload_1
    //   336: new 284	com/google/android/gms/internal/zzq
    //   339: dup
    //   340: invokespecial 285	com/google/android/gms/internal/zzq:<init>	()V
    //   343: invokestatic 287	com/google/android/gms/internal/zzt:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzk;Lcom/google/android/gms/internal/zzr;)V
    //   346: goto -342 -> 4
    //   349: astore 5
    //   351: aload_1
    //   352: invokevirtual 292	com/google/android/gms/internal/zzk:getUrl	()Ljava/lang/String;
    //   355: invokestatic 295	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   358: astore_1
    //   359: aload_1
    //   360: invokevirtual 298	java/lang/String:length	()I
    //   363: ifeq +22 -> 385
    //   366: ldc_w 300
    //   369: aload_1
    //   370: invokevirtual 304	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   373: astore_1
    //   374: new 306	java/lang/RuntimeException
    //   377: dup
    //   378: aload_1
    //   379: aload 5
    //   381: invokespecial 309	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: athrow
    //   385: new 49	java/lang/String
    //   388: dup
    //   389: ldc_w 300
    //   392: invokespecial 311	java/lang/String:<init>	(Ljava/lang/String;)V
    //   395: astore_1
    //   396: goto -22 -> 374
    //   399: astore 6
    //   401: aconst_null
    //   402: astore 8
    //   404: aload 7
    //   406: astore 5
    //   408: aload 9
    //   410: astore 7
    //   412: aload 7
    //   414: ifnull +98 -> 512
    //   417: aload 7
    //   419: invokeinterface 248 1 0
    //   424: invokeinterface 93 1 0
    //   429: istore_2
    //   430: ldc_w 313
    //   433: iconst_2
    //   434: anewarray 4	java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: iload_2
    //   440: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   443: aastore
    //   444: dup
    //   445: iconst_1
    //   446: aload_1
    //   447: invokevirtual 292	com/google/android/gms/internal/zzk:getUrl	()Ljava/lang/String;
    //   450: aastore
    //   451: invokestatic 315	com/google/android/gms/internal/zzs:zzc	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   454: aload 8
    //   456: ifnull +76 -> 532
    //   459: new 256	com/google/android/gms/internal/zzi
    //   462: dup
    //   463: iload_2
    //   464: aload 8
    //   466: aload 5
    //   468: iconst_0
    //   469: invokestatic 222	android/os/SystemClock:elapsedRealtime	()J
    //   472: lload_3
    //   473: lsub
    //   474: invokespecial 259	com/google/android/gms/internal/zzi:<init>	(I[BLjava/util/Map;ZJ)V
    //   477: astore 5
    //   479: iload_2
    //   480: sipush 401
    //   483: if_icmpeq +10 -> 493
    //   486: iload_2
    //   487: sipush 403
    //   490: if_icmpne +32 -> 522
    //   493: ldc_w 317
    //   496: aload_1
    //   497: new 319	com/google/android/gms/internal/zza
    //   500: dup
    //   501: aload 5
    //   503: invokespecial 322	com/google/android/gms/internal/zza:<init>	(Lcom/google/android/gms/internal/zzi;)V
    //   506: invokestatic 287	com/google/android/gms/internal/zzt:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzk;Lcom/google/android/gms/internal/zzr;)V
    //   509: goto -505 -> 4
    //   512: new 324	com/google/android/gms/internal/zzj
    //   515: dup
    //   516: aload 6
    //   518: invokespecial 327	com/google/android/gms/internal/zzj:<init>	(Ljava/lang/Throwable;)V
    //   521: athrow
    //   522: new 164	com/google/android/gms/internal/zzp
    //   525: dup
    //   526: aload 5
    //   528: invokespecial 328	com/google/android/gms/internal/zzp:<init>	(Lcom/google/android/gms/internal/zzi;)V
    //   531: athrow
    //   532: new 330	com/google/android/gms/internal/zzh
    //   535: dup
    //   536: aconst_null
    //   537: invokespecial 331	com/google/android/gms/internal/zzh:<init>	(Lcom/google/android/gms/internal/zzi;)V
    //   540: athrow
    //   541: astore 8
    //   543: aconst_null
    //   544: astore 9
    //   546: aload 6
    //   548: astore 7
    //   550: aload 8
    //   552: astore 6
    //   554: aload 9
    //   556: astore 8
    //   558: goto -146 -> 412
    //   561: astore 7
    //   563: aload 6
    //   565: astore 8
    //   567: aload 7
    //   569: astore 6
    //   571: aload 8
    //   573: astore 7
    //   575: aload 5
    //   577: astore 8
    //   579: aload 9
    //   581: astore 5
    //   583: goto -171 -> 412
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	586	0	this	zzt
    //   0	586	1	paramzzk	zzk<?>
    //   70	421	2	i	int
    //   3	470	3	l	long
    //   15	221	5	localObject1	Object
    //   269	1	5	localSocketTimeoutException	java.net.SocketTimeoutException
    //   290	20	5	localObject2	Object
    //   330	1	5	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   349	31	5	localMalformedURLException	java.net.MalformedURLException
    //   406	176	5	localObject3	Object
    //   44	169	6	localHttpResponse	org.apache.http.HttpResponse
    //   399	148	6	localIOException1	IOException
    //   552	18	6	localObject4	Object
    //   10	539	7	localObject5	Object
    //   561	7	7	localIOException2	IOException
    //   573	1	7	localObject6	Object
    //   57	408	8	localStatusLine	StatusLine
    //   541	10	8	localIOException3	IOException
    //   556	22	8	localObject7	Object
    //   5	575	9	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   12	46	269	java/net/SocketTimeoutException
    //   50	59	269	java/net/SocketTimeoutException
    //   63	71	269	java/net/SocketTimeoutException
    //   75	87	269	java/net/SocketTimeoutException
    //   98	104	269	java/net/SocketTimeoutException
    //   113	134	269	java/net/SocketTimeoutException
    //   143	155	269	java/net/SocketTimeoutException
    //   159	187	269	java/net/SocketTimeoutException
    //   197	207	269	java/net/SocketTimeoutException
    //   211	224	269	java/net/SocketTimeoutException
    //   228	242	269	java/net/SocketTimeoutException
    //   256	269	269	java/net/SocketTimeoutException
    //   292	297	269	java/net/SocketTimeoutException
    //   304	324	269	java/net/SocketTimeoutException
    //   12	46	330	org/apache/http/conn/ConnectTimeoutException
    //   50	59	330	org/apache/http/conn/ConnectTimeoutException
    //   63	71	330	org/apache/http/conn/ConnectTimeoutException
    //   75	87	330	org/apache/http/conn/ConnectTimeoutException
    //   98	104	330	org/apache/http/conn/ConnectTimeoutException
    //   113	134	330	org/apache/http/conn/ConnectTimeoutException
    //   143	155	330	org/apache/http/conn/ConnectTimeoutException
    //   159	187	330	org/apache/http/conn/ConnectTimeoutException
    //   197	207	330	org/apache/http/conn/ConnectTimeoutException
    //   211	224	330	org/apache/http/conn/ConnectTimeoutException
    //   228	242	330	org/apache/http/conn/ConnectTimeoutException
    //   256	269	330	org/apache/http/conn/ConnectTimeoutException
    //   292	297	330	org/apache/http/conn/ConnectTimeoutException
    //   304	324	330	org/apache/http/conn/ConnectTimeoutException
    //   12	46	349	java/net/MalformedURLException
    //   50	59	349	java/net/MalformedURLException
    //   63	71	349	java/net/MalformedURLException
    //   75	87	349	java/net/MalformedURLException
    //   98	104	349	java/net/MalformedURLException
    //   113	134	349	java/net/MalformedURLException
    //   143	155	349	java/net/MalformedURLException
    //   159	187	349	java/net/MalformedURLException
    //   197	207	349	java/net/MalformedURLException
    //   211	224	349	java/net/MalformedURLException
    //   228	242	349	java/net/MalformedURLException
    //   256	269	349	java/net/MalformedURLException
    //   292	297	349	java/net/MalformedURLException
    //   304	324	349	java/net/MalformedURLException
    //   12	46	399	java/io/IOException
    //   50	59	541	java/io/IOException
    //   63	71	541	java/io/IOException
    //   75	87	541	java/io/IOException
    //   98	104	541	java/io/IOException
    //   113	134	541	java/io/IOException
    //   143	155	541	java/io/IOException
    //   159	187	541	java/io/IOException
    //   197	207	541	java/io/IOException
    //   211	224	541	java/io/IOException
    //   292	297	541	java/io/IOException
    //   228	242	561	java/io/IOException
    //   256	269	561	java/io/IOException
    //   304	324	561	java/io/IOException
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */