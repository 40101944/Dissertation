package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzaa;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

class zzah
  extends zzd
{
  private static final byte[] fB = "\n".getBytes();
  private final zzal fA;
  private final String zzbre = zza("GoogleAnalytics", zze.VERSION, Build.VERSION.RELEASE, zzao.zza(Locale.getDefault()), Build.MODEL, Build.ID);
  
  zzah(zzf paramzzf)
  {
    super(paramzzf);
    this.fA = new zzal(paramzzf.zzabz());
  }
  
  /* Error */
  private int zza(URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_1
    //   13: invokestatic 88	com/google/android/gms/common/internal/zzaa:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_2
    //   18: invokestatic 88	com/google/android/gms/common/internal/zzaa:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: pop
    //   22: aload_0
    //   23: ldc 90
    //   25: aload_2
    //   26: arraylength
    //   27: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aload_1
    //   31: invokevirtual 100	com/google/android/gms/analytics/internal/zzah:zzb	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   34: aload_0
    //   35: invokevirtual 104	com/google/android/gms/analytics/internal/zzah:zzvo	()Z
    //   38: ifeq +17 -> 55
    //   41: aload_0
    //   42: ldc 106
    //   44: new 19	java/lang/String
    //   47: dup
    //   48: aload_2
    //   49: invokespecial 109	java/lang/String:<init>	([B)V
    //   52: invokevirtual 112	com/google/android/gms/analytics/internal/zzah:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   55: aload_0
    //   56: aload_0
    //   57: invokevirtual 116	com/google/android/gms/analytics/internal/zzah:getContext	()Landroid/content/Context;
    //   60: invokevirtual 122	android/content/Context:getPackageName	()Ljava/lang/String;
    //   63: invokevirtual 126	com/google/android/gms/analytics/internal/zzah:zzfe	(Ljava/lang/String;)V
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 130	com/google/android/gms/analytics/internal/zzah:zzc	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   71: astore_1
    //   72: aload_1
    //   73: astore 5
    //   75: aload 7
    //   77: astore_1
    //   78: aload 5
    //   80: astore 4
    //   82: aload 8
    //   84: astore 6
    //   86: aload 5
    //   88: iconst_1
    //   89: invokevirtual 136	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   92: aload 7
    //   94: astore_1
    //   95: aload 5
    //   97: astore 4
    //   99: aload 8
    //   101: astore 6
    //   103: aload 5
    //   105: aload_2
    //   106: arraylength
    //   107: invokevirtual 140	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   110: aload 7
    //   112: astore_1
    //   113: aload 5
    //   115: astore 4
    //   117: aload 8
    //   119: astore 6
    //   121: aload 5
    //   123: invokevirtual 143	java/net/HttpURLConnection:connect	()V
    //   126: aload 7
    //   128: astore_1
    //   129: aload 5
    //   131: astore 4
    //   133: aload 8
    //   135: astore 6
    //   137: aload 5
    //   139: invokevirtual 147	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   142: astore 7
    //   144: aload 7
    //   146: astore_1
    //   147: aload 5
    //   149: astore 4
    //   151: aload 7
    //   153: astore 6
    //   155: aload 7
    //   157: aload_2
    //   158: invokevirtual 152	java/io/OutputStream:write	([B)V
    //   161: aload 7
    //   163: astore_1
    //   164: aload 5
    //   166: astore 4
    //   168: aload 7
    //   170: astore 6
    //   172: aload_0
    //   173: aload 5
    //   175: invokespecial 155	com/google/android/gms/analytics/internal/zzah:zzb	(Ljava/net/HttpURLConnection;)V
    //   178: aload 7
    //   180: astore_1
    //   181: aload 5
    //   183: astore 4
    //   185: aload 7
    //   187: astore 6
    //   189: aload 5
    //   191: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
    //   194: istore_3
    //   195: iload_3
    //   196: sipush 200
    //   199: if_icmpne +21 -> 220
    //   202: aload 7
    //   204: astore_1
    //   205: aload 5
    //   207: astore 4
    //   209: aload 7
    //   211: astore 6
    //   213: aload_0
    //   214: invokevirtual 163	com/google/android/gms/analytics/internal/zzah:zzzg	()Lcom/google/android/gms/analytics/internal/zzb;
    //   217: invokevirtual 168	com/google/android/gms/analytics/internal/zzb:zzabw	()V
    //   220: aload 7
    //   222: astore_1
    //   223: aload 5
    //   225: astore 4
    //   227: aload 7
    //   229: astore 6
    //   231: aload_0
    //   232: ldc -86
    //   234: iload_3
    //   235: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: invokevirtual 172	com/google/android/gms/analytics/internal/zzah:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   241: aload 7
    //   243: ifnull +8 -> 251
    //   246: aload 7
    //   248: invokevirtual 175	java/io/OutputStream:close	()V
    //   251: aload 5
    //   253: ifnull +8 -> 261
    //   256: aload 5
    //   258: invokevirtual 178	java/net/HttpURLConnection:disconnect	()V
    //   261: aload_0
    //   262: invokevirtual 181	com/google/android/gms/analytics/internal/zzah:zztt	()V
    //   265: iload_3
    //   266: ireturn
    //   267: astore_1
    //   268: aload_0
    //   269: ldc -73
    //   271: aload_1
    //   272: invokevirtual 186	com/google/android/gms/analytics/internal/zzah:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   275: goto -24 -> 251
    //   278: astore_2
    //   279: aconst_null
    //   280: astore 5
    //   282: aload 6
    //   284: astore_1
    //   285: aload 5
    //   287: astore 4
    //   289: aload_0
    //   290: ldc -68
    //   292: aload_2
    //   293: invokevirtual 191	com/google/android/gms/analytics/internal/zzah:zzd	(Ljava/lang/String;Ljava/lang/Object;)V
    //   296: aload 6
    //   298: ifnull +8 -> 306
    //   301: aload 6
    //   303: invokevirtual 175	java/io/OutputStream:close	()V
    //   306: aload 5
    //   308: ifnull +8 -> 316
    //   311: aload 5
    //   313: invokevirtual 178	java/net/HttpURLConnection:disconnect	()V
    //   316: aload_0
    //   317: invokevirtual 181	com/google/android/gms/analytics/internal/zzah:zztt	()V
    //   320: iconst_0
    //   321: istore_3
    //   322: goto -57 -> 265
    //   325: astore_1
    //   326: aload_0
    //   327: ldc -73
    //   329: aload_1
    //   330: invokevirtual 186	com/google/android/gms/analytics/internal/zzah:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   333: goto -27 -> 306
    //   336: astore_2
    //   337: aconst_null
    //   338: astore 4
    //   340: aload 5
    //   342: astore_1
    //   343: aload_1
    //   344: ifnull +7 -> 351
    //   347: aload_1
    //   348: invokevirtual 175	java/io/OutputStream:close	()V
    //   351: aload 4
    //   353: ifnull +8 -> 361
    //   356: aload 4
    //   358: invokevirtual 178	java/net/HttpURLConnection:disconnect	()V
    //   361: aload_0
    //   362: invokevirtual 181	com/google/android/gms/analytics/internal/zzah:zztt	()V
    //   365: aload_2
    //   366: athrow
    //   367: astore_1
    //   368: aload_0
    //   369: ldc -73
    //   371: aload_1
    //   372: invokevirtual 186	com/google/android/gms/analytics/internal/zzah:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   375: goto -24 -> 351
    //   378: astore_2
    //   379: goto -36 -> 343
    //   382: astore_2
    //   383: goto -101 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	zzah
    //   0	386	1	paramURL	URL
    //   0	386	2	paramArrayOfByte	byte[]
    //   194	128	3	i	int
    //   80	277	4	localURL1	URL
    //   1	340	5	localURL2	URL
    //   10	292	6	localObject1	Object
    //   4	243	7	localOutputStream	java.io.OutputStream
    //   7	127	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   246	251	267	java/io/IOException
    //   55	72	278	java/io/IOException
    //   301	306	325	java/io/IOException
    //   55	72	336	finally
    //   347	351	367	java/io/IOException
    //   86	92	378	finally
    //   103	110	378	finally
    //   121	126	378	finally
    //   137	144	378	finally
    //   155	161	378	finally
    //   172	178	378	finally
    //   189	195	378	finally
    //   213	220	378	finally
    //   231	241	378	finally
    //   289	296	378	finally
    //   86	92	382	java/io/IOException
    //   103	110	382	java/io/IOException
    //   121	126	382	java/io/IOException
    //   137	144	382	java/io/IOException
    //   155	161	382	java/io/IOException
    //   172	178	382	java/io/IOException
    //   189	195	382	java/io/IOException
    //   213	220	382	java/io/IOException
    //   231	241	382	java/io/IOException
  }
  
  private static String zza(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    if (paramStringBuilder.length() != 0) {
      paramStringBuilder.append('&');
    }
    paramStringBuilder.append(URLEncoder.encode(paramString1, "UTF-8"));
    paramStringBuilder.append('=');
    paramStringBuilder.append(URLEncoder.encode(paramString2, "UTF-8"));
  }
  
  private URL zzagl()
  {
    Object localObject3 = String.valueOf(zzacb().zzaes());
    Object localObject1 = String.valueOf(zzacb().zzaev());
    if (((String)localObject1).length() != 0) {}
    for (localObject1 = ((String)localObject3).concat((String)localObject1);; localObject1 = new String((String)localObject3))
    {
      try
      {
        localObject3 = new java/net/URL;
        ((URL)localObject3).<init>((String)localObject1);
        localObject1 = localObject3;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          zze("Error trying to parse the hardcoded host url", localMalformedURLException);
          Object localObject2 = null;
        }
      }
      return (URL)localObject1;
    }
  }
  
  private int zzb(URL paramURL)
  {
    zzaa.zzy(paramURL);
    zzb("GET request", paramURL);
    localObject = null;
    localURL = null;
    try
    {
      paramURL = zzc(paramURL);
      localURL = paramURL;
      localObject = paramURL;
      paramURL.connect();
      localURL = paramURL;
      localObject = paramURL;
      zzb(paramURL);
      localURL = paramURL;
      localObject = paramURL;
      int j = paramURL.getResponseCode();
      if (j == 200)
      {
        localURL = paramURL;
        localObject = paramURL;
        zzzg().zzabw();
      }
      localURL = paramURL;
      localObject = paramURL;
      zzb("GET status", Integer.valueOf(j));
      i = j;
      if (paramURL != null)
      {
        paramURL.disconnect();
        i = j;
      }
    }
    catch (IOException paramURL)
    {
      for (;;)
      {
        localObject = localURL;
        zzd("Network GET connection error", paramURL);
        if (localURL != null) {
          localURL.disconnect();
        }
        int i = 0;
      }
    }
    finally
    {
      if (localObject == null) {
        break label147;
      }
      ((HttpURLConnection)localObject).disconnect();
    }
    return i;
  }
  
  /* Error */
  private int zzb(URL paramURL, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: invokestatic 88	com/google/android/gms/common/internal/zzaa:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_2
    //   12: invokestatic 88	com/google/android/gms/common/internal/zzaa:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_0
    //   17: aload_0
    //   18: invokevirtual 116	com/google/android/gms/analytics/internal/zzah:getContext	()Landroid/content/Context;
    //   21: invokevirtual 122	android/content/Context:getPackageName	()Ljava/lang/String;
    //   24: invokevirtual 126	com/google/android/gms/analytics/internal/zzah:zzfe	(Ljava/lang/String;)V
    //   27: aload_2
    //   28: invokestatic 266	com/google/android/gms/analytics/internal/zzah:zzk	([B)[B
    //   31: astore 6
    //   33: aload_0
    //   34: ldc_w 268
    //   37: aload 6
    //   39: arraylength
    //   40: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: ldc2_w 269
    //   46: aload 6
    //   48: arraylength
    //   49: i2l
    //   50: lmul
    //   51: aload_2
    //   52: arraylength
    //   53: i2l
    //   54: ldiv
    //   55: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   58: aload_1
    //   59: invokevirtual 278	com/google/android/gms/analytics/internal/zzah:zza	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   62: aload 6
    //   64: arraylength
    //   65: aload_2
    //   66: arraylength
    //   67: if_icmple +21 -> 88
    //   70: aload_0
    //   71: ldc_w 280
    //   74: aload 6
    //   76: arraylength
    //   77: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: aload_2
    //   81: arraylength
    //   82: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: invokevirtual 282	com/google/android/gms/analytics/internal/zzah:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   88: aload_0
    //   89: invokevirtual 104	com/google/android/gms/analytics/internal/zzah:zzvo	()Z
    //   92: ifeq +42 -> 134
    //   95: new 19	java/lang/String
    //   98: astore 7
    //   100: aload 7
    //   102: aload_2
    //   103: invokespecial 109	java/lang/String:<init>	([B)V
    //   106: aload 7
    //   108: invokestatic 239	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   111: astore_2
    //   112: aload_2
    //   113: invokevirtual 243	java/lang/String:length	()I
    //   116: ifeq +113 -> 229
    //   119: ldc 17
    //   121: aload_2
    //   122: invokevirtual 247	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore_2
    //   126: aload_0
    //   127: ldc_w 284
    //   130: aload_2
    //   131: invokevirtual 112	com/google/android/gms/analytics/internal/zzah:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   134: aload_0
    //   135: aload_1
    //   136: invokevirtual 130	com/google/android/gms/analytics/internal/zzah:zzc	(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   139: astore_1
    //   140: aload_1
    //   141: iconst_1
    //   142: invokevirtual 136	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   145: aload_1
    //   146: ldc_w 286
    //   149: ldc_w 288
    //   152: invokevirtual 292	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_1
    //   156: aload 6
    //   158: arraylength
    //   159: invokevirtual 140	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   162: aload_1
    //   163: invokevirtual 143	java/net/HttpURLConnection:connect	()V
    //   166: aload_1
    //   167: invokevirtual 147	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   170: astore_2
    //   171: aload_2
    //   172: aload 6
    //   174: invokevirtual 152	java/io/OutputStream:write	([B)V
    //   177: aload_2
    //   178: invokevirtual 175	java/io/OutputStream:close	()V
    //   181: aload_0
    //   182: aload_1
    //   183: invokespecial 155	com/google/android/gms/analytics/internal/zzah:zzb	(Ljava/net/HttpURLConnection;)V
    //   186: aload_1
    //   187: invokevirtual 159	java/net/HttpURLConnection:getResponseCode	()I
    //   190: istore_3
    //   191: iload_3
    //   192: sipush 200
    //   195: if_icmpne +10 -> 205
    //   198: aload_0
    //   199: invokevirtual 163	com/google/android/gms/analytics/internal/zzah:zzzg	()Lcom/google/android/gms/analytics/internal/zzb;
    //   202: invokevirtual 168	com/google/android/gms/analytics/internal/zzb:zzabw	()V
    //   205: aload_0
    //   206: ldc -86
    //   208: iload_3
    //   209: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: invokevirtual 172	com/google/android/gms/analytics/internal/zzah:zzb	(Ljava/lang/String;Ljava/lang/Object;)V
    //   215: aload_1
    //   216: ifnull +7 -> 223
    //   219: aload_1
    //   220: invokevirtual 178	java/net/HttpURLConnection:disconnect	()V
    //   223: aload_0
    //   224: invokevirtual 181	com/google/android/gms/analytics/internal/zzah:zztt	()V
    //   227: iload_3
    //   228: ireturn
    //   229: new 19	java/lang/String
    //   232: dup
    //   233: ldc 17
    //   235: invokespecial 252	java/lang/String:<init>	(Ljava/lang/String;)V
    //   238: astore_2
    //   239: goto -113 -> 126
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_1
    //   245: aload_0
    //   246: ldc_w 294
    //   249: aload_2
    //   250: invokevirtual 191	com/google/android/gms/analytics/internal/zzah:zzd	(Ljava/lang/String;Ljava/lang/Object;)V
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 175	java/io/OutputStream:close	()V
    //   263: aload_1
    //   264: ifnull +7 -> 271
    //   267: aload_1
    //   268: invokevirtual 178	java/net/HttpURLConnection:disconnect	()V
    //   271: aload_0
    //   272: invokevirtual 181	com/google/android/gms/analytics/internal/zzah:zztt	()V
    //   275: iconst_0
    //   276: istore_3
    //   277: goto -50 -> 227
    //   280: astore_2
    //   281: aload_0
    //   282: ldc_w 296
    //   285: aload_2
    //   286: invokevirtual 186	com/google/android/gms/analytics/internal/zzah:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   289: goto -26 -> 263
    //   292: astore_2
    //   293: aconst_null
    //   294: astore_1
    //   295: aload 5
    //   297: astore 4
    //   299: aload 4
    //   301: ifnull +8 -> 309
    //   304: aload 4
    //   306: invokevirtual 175	java/io/OutputStream:close	()V
    //   309: aload_1
    //   310: ifnull +7 -> 317
    //   313: aload_1
    //   314: invokevirtual 178	java/net/HttpURLConnection:disconnect	()V
    //   317: aload_0
    //   318: invokevirtual 181	com/google/android/gms/analytics/internal/zzah:zztt	()V
    //   321: aload_2
    //   322: athrow
    //   323: astore 4
    //   325: aload_0
    //   326: ldc_w 296
    //   329: aload 4
    //   331: invokevirtual 186	com/google/android/gms/analytics/internal/zzah:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   334: goto -25 -> 309
    //   337: astore_2
    //   338: aload 5
    //   340: astore 4
    //   342: goto -43 -> 299
    //   345: astore 4
    //   347: aload_2
    //   348: astore 5
    //   350: aload 4
    //   352: astore_2
    //   353: aload 5
    //   355: astore 4
    //   357: goto -58 -> 299
    //   360: astore_2
    //   361: goto -62 -> 299
    //   364: astore_2
    //   365: goto -120 -> 245
    //   368: astore 5
    //   370: aload_2
    //   371: astore 4
    //   373: aload 5
    //   375: astore_2
    //   376: goto -131 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	zzah
    //   0	379	1	paramURL	URL
    //   0	379	2	paramArrayOfByte	byte[]
    //   190	87	3	i	int
    //   4	301	4	arrayOfByte1	byte[]
    //   323	7	4	localIOException1	IOException
    //   340	1	4	arrayOfByte2	byte[]
    //   345	6	4	localObject	Object
    //   355	17	4	arrayOfByte3	byte[]
    //   1	353	5	arrayOfByte4	byte[]
    //   368	6	5	localIOException2	IOException
    //   31	142	6	arrayOfByte5	byte[]
    //   98	9	7	str	String
    // Exception table:
    //   from	to	target	type
    //   16	88	242	java/io/IOException
    //   88	126	242	java/io/IOException
    //   126	134	242	java/io/IOException
    //   134	140	242	java/io/IOException
    //   229	239	242	java/io/IOException
    //   258	263	280	java/io/IOException
    //   16	88	292	finally
    //   88	126	292	finally
    //   126	134	292	finally
    //   134	140	292	finally
    //   229	239	292	finally
    //   304	309	323	java/io/IOException
    //   140	171	337	finally
    //   181	191	337	finally
    //   198	205	337	finally
    //   205	215	337	finally
    //   171	181	345	finally
    //   245	253	360	finally
    //   140	171	364	java/io/IOException
    //   181	191	364	java/io/IOException
    //   198	205	364	java/io/IOException
    //   205	215	364	java/io/IOException
    //   171	181	368	java/io/IOException
  }
  
  private URL zzb(zzab paramzzab, String paramString)
  {
    String str;
    if (paramzzab.zzagc())
    {
      str = String.valueOf(zzacb().zzaes());
      paramzzab = String.valueOf(zzacb().zzaeu());
    }
    for (paramzzab = String.valueOf(str).length() + 1 + String.valueOf(paramzzab).length() + String.valueOf(paramString).length() + str + paramzzab + "?" + paramString;; paramzzab = String.valueOf(paramzzab).length() + 1 + String.valueOf(str).length() + String.valueOf(paramString).length() + paramzzab + str + "?" + paramString)
    {
      try
      {
        paramString = new java/net/URL;
        paramString.<init>(paramzzab);
        paramzzab = paramString;
      }
      catch (MalformedURLException paramzzab)
      {
        for (;;)
        {
          zze("Error trying to parse the hardcoded host url", paramzzab);
          paramzzab = null;
        }
      }
      return paramzzab;
      paramzzab = String.valueOf(zzacb().zzaet());
      str = String.valueOf(zzacb().zzaeu());
    }
  }
  
  private void zzb(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    localHttpURLConnection = null;
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      localHttpURLConnection = paramHttpURLConnection;
      byte[] arrayOfByte = new byte['Ѐ'];
      int i;
      do
      {
        localHttpURLConnection = paramHttpURLConnection;
        i = paramHttpURLConnection.read(arrayOfByte);
      } while (i > 0);
      if (paramHttpURLConnection != null) {}
      try
      {
        paramHttpURLConnection.close();
        return;
      }
      catch (IOException paramHttpURLConnection)
      {
        for (;;)
        {
          zze("Error closing http connection input stream", paramHttpURLConnection);
        }
      }
      try
      {
        localHttpURLConnection.close();
        throw paramHttpURLConnection;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          zze("Error closing http connection input stream", localIOException);
        }
      }
    }
    finally
    {
      if (localHttpURLConnection == null) {}
    }
  }
  
  private boolean zzg(zzab paramzzab)
  {
    boolean bool2 = true;
    zzaa.zzy(paramzzab);
    boolean bool1;
    Object localObject;
    if (!paramzzab.zzagc())
    {
      bool1 = true;
      localObject = zza(paramzzab, bool1);
      if (localObject != null) {
        break label49;
      }
      zzaca().zza(paramzzab, "Error formatting hit for upload");
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = false;
      break;
      label49:
      if (((String)localObject).length() <= zzacb().zzaeh())
      {
        paramzzab = zzb(paramzzab, (String)localObject);
        if (paramzzab == null)
        {
          zzew("Failed to build collect GET endpoint url");
          bool1 = false;
        }
        else
        {
          bool1 = bool2;
          if (zzb(paramzzab) != 200) {
            bool1 = false;
          }
        }
      }
      else
      {
        localObject = zza(paramzzab, false);
        if (localObject == null)
        {
          zzaca().zza(paramzzab, "Error formatting hit for POST upload");
          bool1 = bool2;
        }
        else
        {
          localObject = ((String)localObject).getBytes();
          if (localObject.length > zzacb().zzaej())
          {
            zzaca().zza(paramzzab, "Hit payload exceeds size limit");
            bool1 = bool2;
          }
          else
          {
            paramzzab = zzh(paramzzab);
            if (paramzzab == null)
            {
              zzew("Failed to build collect POST endpoint url");
              bool1 = false;
            }
            else
            {
              bool1 = bool2;
              if (zza(paramzzab, (byte[])localObject) != 200) {
                bool1 = false;
              }
            }
          }
        }
      }
    }
  }
  
  private URL zzh(zzab paramzzab)
  {
    Object localObject;
    if (paramzzab.zzagc())
    {
      localObject = String.valueOf(zzacb().zzaes());
      paramzzab = String.valueOf(zzacb().zzaeu());
      if (paramzzab.length() != 0) {}
      for (paramzzab = ((String)localObject).concat(paramzzab);; paramzzab = new String((String)localObject))
      {
        try
        {
          localObject = new java/net/URL;
          ((URL)localObject).<init>(paramzzab);
          paramzzab = (zzab)localObject;
        }
        catch (MalformedURLException paramzzab)
        {
          for (;;)
          {
            zze("Error trying to parse the hardcoded host url", paramzzab);
            paramzzab = null;
          }
        }
        return paramzzab;
      }
    }
    else
    {
      localObject = String.valueOf(zzacb().zzaet());
      paramzzab = String.valueOf(zzacb().zzaeu());
      if (paramzzab.length() != 0) {}
      for (paramzzab = ((String)localObject).concat(paramzzab);; paramzzab = new String((String)localObject)) {
        break;
      }
    }
  }
  
  private String zzi(zzab paramzzab)
  {
    return String.valueOf(paramzzab.zzafz());
  }
  
  private static byte[] zzk(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramArrayOfByte);
    localGZIPOutputStream.close();
    localByteArrayOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  String zza(zzab paramzzab, boolean paramBoolean)
  {
    zzaa.zzy(paramzzab);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      Iterator localIterator = paramzzab.zzmc().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        if ((!"ht".equals(str)) && (!"qt".equals(str)) && (!"AppUID".equals(str)) && (!"z".equals(str)) && (!"_gmsv".equals(str)))
        {
          zza(localStringBuilder, str, (String)localEntry.getValue());
          continue;
          return paramzzab;
        }
      }
    }
    catch (UnsupportedEncodingException paramzzab)
    {
      zze("Failed to encode name or value", paramzzab);
      paramzzab = null;
    }
    zza(localStringBuilder, "ht", String.valueOf(paramzzab.zzaga()));
    zza(localStringBuilder, "qt", String.valueOf(zzabz().currentTimeMillis() - paramzzab.zzaga()));
    zzacb();
    long l;
    if (paramBoolean)
    {
      l = paramzzab.zzagd();
      if (l == 0L) {
        break label239;
      }
    }
    label239:
    for (paramzzab = String.valueOf(l);; paramzzab = zzi(paramzzab))
    {
      zza(localStringBuilder, "z", paramzzab);
      paramzzab = localStringBuilder.toString();
      break;
    }
  }
  
  List<Long> zza(List<zzab> paramList, boolean paramBoolean)
  {
    boolean bool;
    zza localzza;
    ArrayList localArrayList;
    label63:
    zzab localzzab;
    if (!paramList.isEmpty())
    {
      bool = true;
      zzaa.zzbt(bool);
      zza("Uploading batched hits. compression, count", Boolean.valueOf(paramBoolean), Integer.valueOf(paramList.size()));
      localzza = new zza();
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localzzab = (zzab)paramList.next();
        if (localzza.zzj(localzzab)) {
          break label112;
        }
      }
      if (localzza.zzagn() != 0) {
        break label131;
      }
      paramList = localArrayList;
    }
    for (;;)
    {
      return paramList;
      bool = false;
      break;
      label112:
      localArrayList.add(Long.valueOf(localzzab.zzafz()));
      break label63;
      label131:
      paramList = zzagl();
      if (paramList == null)
      {
        zzew("Failed to build batching endpoint url");
        paramList = Collections.emptyList();
      }
      else
      {
        if (paramBoolean) {}
        for (int i = zzb(paramList, localzza.getPayload());; i = zza(paramList, localzza.getPayload()))
        {
          if (200 != i) {
            break label211;
          }
          zza("Batched upload completed. Hits batched", Integer.valueOf(localzza.zzagn()));
          paramList = localArrayList;
          break;
        }
        label211:
        zza("Network error uploading hits. status code", Integer.valueOf(i));
        if (zzacb().zzaey().contains(Integer.valueOf(i)))
        {
          zzev("Server instructed the client to stop batching");
          this.fA.start();
        }
        paramList = Collections.emptyList();
      }
    }
  }
  
  public boolean zzagk()
  {
    zzzx();
    zzacj();
    Object localObject1 = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if ((localObject1 == null) || (!((NetworkInfo)localObject1).isConnected()))
      {
        zzes("No network connectivity");
        bool = false;
        return bool;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Object localObject2 = null;
        continue;
        boolean bool = true;
      }
    }
  }
  
  HttpURLConnection zzc(URL paramURL)
    throws IOException
  {
    paramURL = paramURL.openConnection();
    if (!(paramURL instanceof HttpURLConnection)) {
      throw new IOException("Failed to obtain http connection");
    }
    paramURL = (HttpURLConnection)paramURL;
    paramURL.setDefaultUseCaches(false);
    paramURL.setConnectTimeout(zzacb().zzafg());
    paramURL.setReadTimeout(zzacb().zzafh());
    paramURL.setInstanceFollowRedirects(false);
    paramURL.setRequestProperty("User-Agent", this.zzbre);
    paramURL.setDoInput(true);
    return paramURL;
  }
  
  protected void zzfe(String paramString) {}
  
  public List<Long> zzt(List<zzab> paramList)
  {
    boolean bool = true;
    zzzx();
    zzacj();
    zzaa.zzy(paramList);
    int j;
    if ((zzacb().zzaey().isEmpty()) || (!this.fA.zzz(zzacb().zzaer() * 1000L)))
    {
      bool = false;
      j = 0;
      if (j == 0) {
        break label114;
      }
    }
    label114:
    for (paramList = zza(paramList, bool);; paramList = zzu(paramList))
    {
      return paramList;
      if (zzacb().zzaew() != zzm.dN) {}
      for (int i = 1;; i = 0)
      {
        j = i;
        if (zzacb().zzaex() == zzo.dY) {
          break;
        }
        bool = false;
        j = i;
        break;
      }
    }
  }
  
  protected void zztt() {}
  
  List<Long> zzu(List<zzab> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (zzab)localIterator.next();
      if (zzg(paramList)) {
        break label50;
      }
    }
    for (;;)
    {
      return localArrayList;
      label50:
      localArrayList.add(Long.valueOf(paramList.zzafz()));
      if (localArrayList.size() < zzacb().zzaep()) {
        break;
      }
    }
  }
  
  protected void zzzy()
  {
    zza("Network initialized. User agent", this.zzbre);
  }
  
  private class zza
  {
    private int fC;
    private ByteArrayOutputStream fD = new ByteArrayOutputStream();
    
    public zza() {}
    
    public byte[] getPayload()
    {
      return this.fD.toByteArray();
    }
    
    public int zzagn()
    {
      return this.fC;
    }
    
    public boolean zzj(zzab paramzzab)
    {
      zzaa.zzy(paramzzab);
      boolean bool;
      if (this.fC + 1 > zzah.this.zzacb().zzaeq()) {
        bool = false;
      }
      for (;;)
      {
        return bool;
        Object localObject = zzah.this.zza(paramzzab, false);
        if (localObject == null)
        {
          zzah.this.zzaca().zza(paramzzab, "Error formatting hit");
          bool = true;
        }
        else
        {
          localObject = ((String)localObject).getBytes();
          int j = localObject.length;
          if (j > zzah.this.zzacb().zzaei())
          {
            zzah.this.zzaca().zza(paramzzab, "Hit size exceeds the maximum size limit");
            bool = true;
          }
          else
          {
            int i = j;
            if (this.fD.size() > 0) {
              i = j + 1;
            }
            if (i + this.fD.size() > zzah.this.zzacb().zzaek()) {
              bool = false;
            } else {
              try
              {
                if (this.fD.size() > 0) {
                  this.fD.write(zzah.zzagm());
                }
                this.fD.write((byte[])localObject);
                this.fC += 1;
                bool = true;
              }
              catch (IOException paramzzab)
              {
                zzah.this.zze("Failed to write payload when batching hits", paramzzab);
                bool = true;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */