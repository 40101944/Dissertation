package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzaga;
import com.google.android.gms.internal.zzai.zzj;

class zzct
  implements Runnable
{
  private final String aDY;
  private volatile String aEw;
  private final String aGA;
  private zzbn<zzai.zzj> aGB;
  private volatile zzt aGC;
  private volatile String aGD;
  private final zzaga aGz;
  private final Context mContext;
  
  zzct(Context paramContext, String paramString, zzaga paramzzaga, zzt paramzzt)
  {
    this.mContext = paramContext;
    this.aGz = paramzzaga;
    this.aDY = paramString;
    this.aGC = paramzzt;
    paramContext = String.valueOf("/r?id=");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramContext = paramContext.concat(paramString);; paramContext = new String(paramContext))
    {
      this.aGA = paramContext;
      this.aEw = this.aGA;
      this.aGD = null;
      return;
    }
  }
  
  public zzct(Context paramContext, String paramString, zzt paramzzt)
  {
    this(paramContext, paramString, new zzaga(), paramzzt);
  }
  
  private boolean zzcgc()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
      zzbo.v("...no network connectivity");
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  /* Error */
  private void zzcgd()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 102	com/google/android/gms/tagmanager/zzct:zzcgc	()Z
    //   4: ifne +16 -> 20
    //   7: aload_0
    //   8: getfield 104	com/google/android/gms/tagmanager/zzct:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   11: getstatic 110	com/google/android/gms/tagmanager/zzbn$zza:aFO	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   14: invokeinterface 116 2 0
    //   19: return
    //   20: ldc 118
    //   22: invokestatic 93	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokevirtual 122	com/google/android/gms/tagmanager/zzct:zzcge	()Ljava/lang/String;
    //   29: astore 4
    //   31: aload_0
    //   32: getfield 29	com/google/android/gms/tagmanager/zzct:aGz	Lcom/google/android/gms/internal/zzaga;
    //   35: invokevirtual 126	com/google/android/gms/internal/zzaga:zzclf	()Lcom/google/android/gms/internal/zzafz;
    //   38: astore_3
    //   39: aconst_null
    //   40: astore_2
    //   41: aload_3
    //   42: aload 4
    //   44: invokeinterface 132 2 0
    //   49: astore_1
    //   50: new 134	java/io/ByteArrayOutputStream
    //   53: astore_2
    //   54: aload_2
    //   55: invokespecial 135	java/io/ByteArrayOutputStream:<init>	()V
    //   58: aload_1
    //   59: aload_2
    //   60: invokestatic 141	com/google/android/gms/internal/zzafw:zzc	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   63: aload_2
    //   64: invokevirtual 145	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   67: invokestatic 151	com/google/android/gms/internal/zzai$zzj:zzg	([B)Lcom/google/android/gms/internal/zzai$zzj;
    //   70: astore_2
    //   71: aload_2
    //   72: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   75: astore 5
    //   77: new 153	java/lang/StringBuilder
    //   80: astore_1
    //   81: aload_1
    //   82: aload 5
    //   84: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   87: invokevirtual 45	java/lang/String:length	()I
    //   90: bipush 43
    //   92: iadd
    //   93: invokespecial 156	java/lang/StringBuilder:<init>	(I)V
    //   96: aload_1
    //   97: ldc -98
    //   99: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 5
    //   104: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 93	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   113: aload_2
    //   114: getfield 169	com/google/android/gms/internal/zzai$zzj:zzxv	Lcom/google/android/gms/internal/zzai$zzf;
    //   117: ifnonnull +37 -> 154
    //   120: aload_2
    //   121: getfield 173	com/google/android/gms/internal/zzai$zzj:zzxu	[Lcom/google/android/gms/internal/zzai$zzi;
    //   124: arraylength
    //   125: ifne +29 -> 154
    //   128: aload_0
    //   129: getfield 31	com/google/android/gms/tagmanager/zzct:aDY	Ljava/lang/String;
    //   132: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 45	java/lang/String:length	()I
    //   140: ifeq +274 -> 414
    //   143: ldc -81
    //   145: aload_1
    //   146: invokevirtual 49	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   149: astore_1
    //   150: aload_1
    //   151: invokestatic 93	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   154: aload_0
    //   155: getfield 104	com/google/android/gms/tagmanager/zzct:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   158: aload_2
    //   159: invokeinterface 179 2 0
    //   164: aload_3
    //   165: invokeinterface 182 1 0
    //   170: ldc -72
    //   172: invokestatic 93	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   175: goto -156 -> 19
    //   178: astore_1
    //   179: aload_0
    //   180: getfield 31	com/google/android/gms/tagmanager/zzct:aDY	Ljava/lang/String;
    //   183: astore_2
    //   184: new 153	java/lang/StringBuilder
    //   187: astore_1
    //   188: aload_1
    //   189: aload 4
    //   191: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokevirtual 45	java/lang/String:length	()I
    //   197: bipush 79
    //   199: iadd
    //   200: aload_2
    //   201: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokevirtual 45	java/lang/String:length	()I
    //   207: iadd
    //   208: invokespecial 156	java/lang/StringBuilder:<init>	(I)V
    //   211: aload_1
    //   212: ldc -70
    //   214: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 4
    //   219: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc -68
    //   224: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_2
    //   228: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc -66
    //   233: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 193	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   242: aload_0
    //   243: getfield 104	com/google/android/gms/tagmanager/zzct:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   246: getstatic 196	com/google/android/gms/tagmanager/zzbn$zza:aFQ	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   249: invokeinterface 116 2 0
    //   254: aload_3
    //   255: invokeinterface 182 1 0
    //   260: goto -241 -> 19
    //   263: astore_1
    //   264: aload 4
    //   266: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 45	java/lang/String:length	()I
    //   274: ifeq +40 -> 314
    //   277: ldc -58
    //   279: aload_1
    //   280: invokevirtual 49	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   283: astore_1
    //   284: aload_1
    //   285: invokestatic 193	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   288: aload_0
    //   289: getfield 104	com/google/android/gms/tagmanager/zzct:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   292: getstatic 201	com/google/android/gms/tagmanager/zzbn$zza:aFR	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   295: invokeinterface 116 2 0
    //   300: aload_2
    //   301: astore_1
    //   302: goto -252 -> 50
    //   305: astore_1
    //   306: aload_3
    //   307: invokeinterface 182 1 0
    //   312: aload_1
    //   313: athrow
    //   314: new 37	java/lang/String
    //   317: dup
    //   318: ldc -58
    //   320: invokespecial 58	java/lang/String:<init>	(Ljava/lang/String;)V
    //   323: astore_1
    //   324: goto -40 -> 284
    //   327: astore 5
    //   329: aload 5
    //   331: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   334: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   337: astore_1
    //   338: new 153	java/lang/StringBuilder
    //   341: astore_2
    //   342: aload_2
    //   343: aload 4
    //   345: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   348: invokevirtual 45	java/lang/String:length	()I
    //   351: bipush 40
    //   353: iadd
    //   354: aload_1
    //   355: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   358: invokevirtual 45	java/lang/String:length	()I
    //   361: iadd
    //   362: invokespecial 156	java/lang/StringBuilder:<init>	(I)V
    //   365: aload_2
    //   366: ldc -50
    //   368: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload 4
    //   373: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc -48
    //   378: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_1
    //   382: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: aload 5
    //   390: invokestatic 211	com/google/android/gms/tagmanager/zzbo:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   393: aload_0
    //   394: getfield 104	com/google/android/gms/tagmanager/zzct:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   397: getstatic 214	com/google/android/gms/tagmanager/zzbn$zza:aFP	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   400: invokeinterface 116 2 0
    //   405: aload_3
    //   406: invokeinterface 182 1 0
    //   411: goto -392 -> 19
    //   414: new 37	java/lang/String
    //   417: dup
    //   418: ldc -81
    //   420: invokespecial 58	java/lang/String:<init>	(Ljava/lang/String;)V
    //   423: astore_1
    //   424: goto -274 -> 150
    //   427: astore_2
    //   428: aload_2
    //   429: invokevirtual 204	java/io/IOException:getMessage	()Ljava/lang/String;
    //   432: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   435: astore_1
    //   436: new 153	java/lang/StringBuilder
    //   439: astore 5
    //   441: aload 5
    //   443: aload 4
    //   445: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   448: invokevirtual 45	java/lang/String:length	()I
    //   451: bipush 51
    //   453: iadd
    //   454: aload_1
    //   455: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   458: invokevirtual 45	java/lang/String:length	()I
    //   461: iadd
    //   462: invokespecial 156	java/lang/StringBuilder:<init>	(I)V
    //   465: aload 5
    //   467: ldc -40
    //   469: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload 4
    //   474: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: ldc -48
    //   479: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_1
    //   483: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: aload_2
    //   490: invokestatic 211	com/google/android/gms/tagmanager/zzbo:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   493: aload_0
    //   494: getfield 104	com/google/android/gms/tagmanager/zzct:aGB	Lcom/google/android/gms/tagmanager/zzbn;
    //   497: getstatic 196	com/google/android/gms/tagmanager/zzbn$zza:aFQ	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   500: invokeinterface 116 2 0
    //   505: aload_3
    //   506: invokeinterface 182 1 0
    //   511: goto -492 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	zzct
    //   49	102	1	localObject1	Object
    //   178	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   187	25	1	localStringBuilder1	StringBuilder
    //   263	1	1	localzzagb	com.google.android.gms.internal.zzagb
    //   269	33	1	localObject2	Object
    //   305	8	1	localObject3	Object
    //   323	160	1	str1	String
    //   40	326	2	localObject4	Object
    //   427	63	2	localIOException1	java.io.IOException
    //   38	468	3	localzzafz	com.google.android.gms.internal.zzafz
    //   29	444	4	str2	String
    //   75	28	5	str3	String
    //   327	62	5	localIOException2	java.io.IOException
    //   439	27	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   41	50	178	java/io/FileNotFoundException
    //   41	50	263	com/google/android/gms/internal/zzagb
    //   41	50	305	finally
    //   50	150	305	finally
    //   150	154	305	finally
    //   154	164	305	finally
    //   179	254	305	finally
    //   264	284	305	finally
    //   284	300	305	finally
    //   314	324	305	finally
    //   329	405	305	finally
    //   414	424	305	finally
    //   428	505	305	finally
    //   41	50	327	java/io/IOException
    //   50	150	427	java/io/IOException
    //   150	154	427	java/io/IOException
    //   154	164	427	java/io/IOException
    //   414	424	427	java/io/IOException
  }
  
  public void run()
  {
    if (this.aGB == null) {
      throw new IllegalStateException("callback must be set before execute");
    }
    this.aGB.zzcei();
    zzcgd();
  }
  
  void zza(zzbn<zzai.zzj> paramzzbn)
  {
    this.aGB = paramzzbn;
  }
  
  String zzcge()
  {
    Object localObject2 = String.valueOf(this.aGC.zzcep());
    String str = this.aEw;
    Object localObject1 = String.valueOf("&v=a65833898");
    localObject2 = String.valueOf(localObject2).length() + 0 + String.valueOf(str).length() + String.valueOf(localObject1).length() + (String)localObject2 + str + (String)localObject1;
    localObject1 = localObject2;
    if (this.aGD != null)
    {
      localObject1 = localObject2;
      if (!this.aGD.trim().equals(""))
      {
        str = String.valueOf(localObject2);
        localObject2 = String.valueOf("&pv=");
        localObject1 = this.aGD;
        localObject1 = String.valueOf(str).length() + 0 + String.valueOf(localObject2).length() + String.valueOf(localObject1).length() + str + (String)localObject2 + (String)localObject1;
      }
    }
    localObject2 = localObject1;
    if (zzcj.zzcfz().zzcga().equals(zzcj.zza.aGr))
    {
      localObject2 = String.valueOf(localObject1);
      localObject1 = String.valueOf("&gtm_debug=x");
      if (((String)localObject1).length() == 0) {
        break label204;
      }
    }
    label204:
    for (localObject2 = ((String)localObject2).concat((String)localObject1);; localObject2 = new String((String)localObject2)) {
      return (String)localObject2;
    }
  }
  
  void zzpa(String paramString)
  {
    if (paramString == null)
    {
      this.aEw = this.aGA;
      return;
    }
    String str = String.valueOf(paramString);
    if (str.length() != 0) {}
    for (str = "Setting CTFE URL path: ".concat(str);; str = new String("Setting CTFE URL path: "))
    {
      zzbo.zzdg(str);
      this.aEw = paramString;
      break;
    }
  }
  
  void zzpp(String paramString)
  {
    String str = String.valueOf(paramString);
    if (str.length() != 0) {}
    for (str = "Setting previous container version: ".concat(str);; str = new String("Setting previous container version: "))
    {
      zzbo.zzdg(str);
      this.aGD = paramString;
      return;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */