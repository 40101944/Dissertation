package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzv
  implements zzb
{
  private final Map<String, zza> zzbw = new LinkedHashMap(16, 0.75F, true);
  private long zzbx = 0L;
  private final File zzby;
  private final int zzbz;
  
  public zzv(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  public zzv(File paramFile, int paramInt)
  {
    this.zzby = paramFile;
    this.zzbz = paramInt;
  }
  
  private void removeEntry(String paramString)
  {
    zza localzza = (zza)this.zzbw.get(paramString);
    if (localzza != null)
    {
      this.zzbx -= localzza.zzca;
      this.zzbw.remove(paramString);
    }
  }
  
  private static int zza(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw new EOFException();
    }
    return i;
  }
  
  static void zza(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  static void zza(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void zza(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    zza(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  private void zza(String paramString, zza paramzza)
  {
    if (!this.zzbw.containsKey(paramString)) {}
    zza localzza;
    long l;
    for (this.zzbx += paramzza.zzca;; this.zzbx = (paramzza.zzca - localzza.zzca + l))
    {
      this.zzbw.put(paramString, paramzza);
      return;
      localzza = (zza)this.zzbw.get(paramString);
      l = this.zzbx;
    }
  }
  
  static void zza(Map<String, String> paramMap, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramMap != null)
    {
      zza(paramOutputStream, paramMap.size());
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        zza(paramOutputStream, (String)paramMap.getKey());
        zza(paramOutputStream, (String)paramMap.getValue());
      }
    }
    zza(paramOutputStream, 0);
  }
  
  private static byte[] zza(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i != paramInt) {
      throw new IOException(50 + "Expected " + paramInt + " bytes, read " + i + " bytes");
    }
    return arrayOfByte;
  }
  
  static int zzb(InputStream paramInputStream)
    throws IOException
  {
    return zza(paramInputStream) << 0 | 0x0 | zza(paramInputStream) << 8 | zza(paramInputStream) << 16 | zza(paramInputStream) << 24;
  }
  
  static long zzc(InputStream paramInputStream)
    throws IOException
  {
    return 0L | (zza(paramInputStream) & 0xFF) << 0 | (zza(paramInputStream) & 0xFF) << 8 | (zza(paramInputStream) & 0xFF) << 16 | (zza(paramInputStream) & 0xFF) << 24 | (zza(paramInputStream) & 0xFF) << 32 | (zza(paramInputStream) & 0xFF) << 40 | (zza(paramInputStream) & 0xFF) << 48 | (zza(paramInputStream) & 0xFF) << 56;
  }
  
  private void zzc(int paramInt)
  {
    if (this.zzbx + paramInt < this.zzbz) {}
    label60:
    label119:
    label230:
    label234:
    for (;;)
    {
      return;
      if (zzs.DEBUG) {
        zzs.zza("Pruning old cache entries.", new Object[0]);
      }
      long l1 = this.zzbx;
      long l2 = SystemClock.elapsedRealtime();
      Iterator localIterator = this.zzbw.entrySet().iterator();
      int i = 0;
      zza localzza;
      if (localIterator.hasNext())
      {
        localzza = (zza)((Map.Entry)localIterator.next()).getValue();
        if (zzf(localzza.zzcb).delete())
        {
          this.zzbx -= localzza.zzca;
          localIterator.remove();
          i++;
          if ((float)(this.zzbx + paramInt) >= this.zzbz * 0.9F) {
            break label230;
          }
        }
      }
      for (;;)
      {
        if (!zzs.DEBUG) {
          break label234;
        }
        zzs.zza("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(this.zzbx - l1), Long.valueOf(SystemClock.elapsedRealtime() - l2) });
        break;
        zzs.zzb("Could not delete cache entry for key=%s, filename=%s", new Object[] { localzza.zzcb, zze(localzza.zzcb) });
        break label119;
        break label60;
      }
    }
  }
  
  static String zzd(InputStream paramInputStream)
    throws IOException
  {
    return new String(zza(paramInputStream, (int)zzc(paramInputStream)), "UTF-8");
  }
  
  private String zze(String paramString)
  {
    int i = paramString.length() / 2;
    String str = String.valueOf(String.valueOf(paramString.substring(0, i).hashCode()));
    paramString = String.valueOf(String.valueOf(paramString.substring(i).hashCode()));
    if (paramString.length() != 0) {}
    for (paramString = str.concat(paramString);; paramString = new String(str)) {
      return paramString;
    }
  }
  
  static Map<String, String> zze(InputStream paramInputStream)
    throws IOException
  {
    int j = zzb(paramInputStream);
    if (j == 0) {}
    for (Object localObject = Collections.emptyMap();; localObject = new HashMap(j)) {
      for (int i = 0; i < j; i++) {
        ((Map)localObject).put(zzd(paramInputStream).intern(), zzd(paramInputStream).intern());
      }
    }
    return (Map<String, String>)localObject;
  }
  
  /* Error */
  public void initialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/google/android/gms/internal/zzv:zzby	Ljava/io/File;
    //   6: invokevirtual 283	java/io/File:exists	()Z
    //   9: ifne +36 -> 45
    //   12: aload_0
    //   13: getfield 45	com/google/android/gms/internal/zzv:zzby	Ljava/io/File;
    //   16: invokevirtual 286	java/io/File:mkdirs	()Z
    //   19: ifne +23 -> 42
    //   22: ldc_w 288
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 45	com/google/android/gms/internal/zzv:zzby	Ljava/io/File;
    //   35: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: invokestatic 293	com/google/android/gms/internal/zzs:zzc	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: getfield 45	com/google/android/gms/internal/zzv:zzby	Ljava/io/File;
    //   49: invokevirtual 297	java/io/File:listFiles	()[Ljava/io/File;
    //   52: astore 6
    //   54: aload 6
    //   56: ifnull -14 -> 42
    //   59: aload 6
    //   61: arraylength
    //   62: istore_2
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: iload_2
    //   67: if_icmpge -25 -> 42
    //   70: aload 6
    //   72: iload_1
    //   73: aaload
    //   74: astore 7
    //   76: aconst_null
    //   77: astore 5
    //   79: new 299	java/io/BufferedInputStream
    //   82: astore 4
    //   84: new 301	java/io/FileInputStream
    //   87: astore_3
    //   88: aload_3
    //   89: aload 7
    //   91: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: aload 4
    //   96: aload_3
    //   97: invokespecial 306	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: aload 4
    //   102: astore_3
    //   103: aload 4
    //   105: invokestatic 309	com/google/android/gms/internal/zzv$zza:zzf	(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzv$zza;
    //   108: astore 5
    //   110: aload 4
    //   112: astore_3
    //   113: aload 5
    //   115: aload 7
    //   117: invokevirtual 311	java/io/File:length	()J
    //   120: putfield 58	com/google/android/gms/internal/zzv$zza:zzca	J
    //   123: aload 4
    //   125: astore_3
    //   126: aload_0
    //   127: aload 5
    //   129: getfield 197	com/google/android/gms/internal/zzv$zza:zzcb	Ljava/lang/String;
    //   132: aload 5
    //   134: invokespecial 313	com/google/android/gms/internal/zzv:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzv$zza;)V
    //   137: aload 4
    //   139: ifnull +8 -> 147
    //   142: aload 4
    //   144: invokevirtual 316	java/io/BufferedInputStream:close	()V
    //   147: iinc 1 1
    //   150: goto -85 -> 65
    //   153: astore_3
    //   154: aconst_null
    //   155: astore 4
    //   157: aload 7
    //   159: ifnull +12 -> 171
    //   162: aload 4
    //   164: astore_3
    //   165: aload 7
    //   167: invokevirtual 206	java/io/File:delete	()Z
    //   170: pop
    //   171: aload 4
    //   173: ifnull -26 -> 147
    //   176: aload 4
    //   178: invokevirtual 316	java/io/BufferedInputStream:close	()V
    //   181: goto -34 -> 147
    //   184: astore_3
    //   185: goto -38 -> 147
    //   188: astore_3
    //   189: aload 5
    //   191: astore 4
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 316	java/io/BufferedInputStream:close	()V
    //   203: aload_3
    //   204: athrow
    //   205: astore_3
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_3
    //   209: athrow
    //   210: astore_3
    //   211: goto -64 -> 147
    //   214: astore 4
    //   216: goto -13 -> 203
    //   219: astore 5
    //   221: aload_3
    //   222: astore 4
    //   224: aload 5
    //   226: astore_3
    //   227: goto -34 -> 193
    //   230: astore_3
    //   231: goto -74 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	zzv
    //   64	84	1	i	int
    //   62	6	2	j	int
    //   87	39	3	localObject1	Object
    //   153	1	3	localIOException1	IOException
    //   164	1	3	localObject2	Object
    //   184	1	3	localIOException2	IOException
    //   188	16	3	localObject3	Object
    //   205	4	3	localObject4	Object
    //   210	12	3	localIOException3	IOException
    //   226	1	3	localObject5	Object
    //   230	1	3	localIOException4	IOException
    //   82	117	4	localObject6	Object
    //   214	1	4	localIOException5	IOException
    //   222	1	4	localObject7	Object
    //   77	113	5	localzza	zza
    //   219	6	5	localObject8	Object
    //   52	19	6	arrayOfFile	File[]
    //   74	92	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   79	100	153	java/io/IOException
    //   176	181	184	java/io/IOException
    //   79	100	188	finally
    //   2	42	205	finally
    //   45	54	205	finally
    //   59	63	205	finally
    //   142	147	205	finally
    //   176	181	205	finally
    //   198	203	205	finally
    //   203	205	205	finally
    //   142	147	210	java/io/IOException
    //   198	203	214	java/io/IOException
    //   103	110	219	finally
    //   113	123	219	finally
    //   126	137	219	finally
    //   165	171	219	finally
    //   103	110	230	java/io/IOException
    //   113	123	230	java/io/IOException
    //   126	137	230	java/io/IOException
  }
  
  public void remove(String paramString)
  {
    try
    {
      boolean bool = zzf(paramString).delete();
      removeEntry(paramString);
      if (!bool) {
        zzs.zzb("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, zze(paramString) });
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public zzb.zza zza(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/google/android/gms/internal/zzv:zzbw	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 55 2 0
    //   12: checkcast 10	com/google/android/gms/internal/zzv$zza
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +9 -> 28
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 201	com/google/android/gms/internal/zzv:zzf	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 5
    //   35: new 13	com/google/android/gms/internal/zzv$zzb
    //   38: astore_3
    //   39: new 301	java/io/FileInputStream
    //   42: astore_2
    //   43: aload_2
    //   44: aload 5
    //   46: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: aload_3
    //   50: aload_2
    //   51: aconst_null
    //   52: invokespecial 322	com/google/android/gms/internal/zzv$zzb:<init>	(Ljava/io/InputStream;Lcom/google/android/gms/internal/zzv$1;)V
    //   55: aload_3
    //   56: astore_2
    //   57: aload_3
    //   58: invokestatic 309	com/google/android/gms/internal/zzv$zza:zzf	(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzv$zza;
    //   61: pop
    //   62: aload_3
    //   63: astore_2
    //   64: aload 4
    //   66: aload_3
    //   67: aload 5
    //   69: invokevirtual 311	java/io/File:length	()J
    //   72: aload_3
    //   73: invokestatic 325	com/google/android/gms/internal/zzv$zzb:zza	(Lcom/google/android/gms/internal/zzv$zzb;)I
    //   76: i2l
    //   77: lsub
    //   78: l2i
    //   79: invokestatic 236	com/google/android/gms/internal/zzv:zza	(Ljava/io/InputStream;I)[B
    //   82: invokevirtual 328	com/google/android/gms/internal/zzv$zza:zzb	([B)Lcom/google/android/gms/internal/zzb$zza;
    //   85: astore 4
    //   87: aload 4
    //   89: astore_2
    //   90: aload_2
    //   91: astore_1
    //   92: aload_3
    //   93: ifnull -69 -> 24
    //   96: aload_3
    //   97: invokevirtual 329	com/google/android/gms/internal/zzv$zzb:close	()V
    //   100: aload_2
    //   101: astore_1
    //   102: goto -78 -> 24
    //   105: astore_1
    //   106: aconst_null
    //   107: astore_1
    //   108: goto -84 -> 24
    //   111: astore 4
    //   113: aconst_null
    //   114: astore_3
    //   115: aload_3
    //   116: astore_2
    //   117: ldc_w 331
    //   120: iconst_2
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload 5
    //   128: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: aload 4
    //   136: invokevirtual 332	java/io/IOException:toString	()Ljava/lang/String;
    //   139: aastore
    //   140: invokestatic 230	com/google/android/gms/internal/zzs:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_3
    //   144: astore_2
    //   145: aload_0
    //   146: aload_1
    //   147: invokevirtual 334	com/google/android/gms/internal/zzv:remove	(Ljava/lang/String;)V
    //   150: aload_3
    //   151: ifnull +7 -> 158
    //   154: aload_3
    //   155: invokevirtual 329	com/google/android/gms/internal/zzv$zzb:close	()V
    //   158: aconst_null
    //   159: astore_1
    //   160: goto -136 -> 24
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_1
    //   166: goto -142 -> 24
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_2
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 329	com/google/android/gms/internal/zzv$zzb:close	()V
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    //   187: astore_1
    //   188: aconst_null
    //   189: astore_1
    //   190: goto -166 -> 24
    //   193: astore_1
    //   194: goto -22 -> 172
    //   197: astore 4
    //   199: goto -84 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	zzv
    //   0	202	1	paramString	String
    //   42	135	2	localObject1	Object
    //   38	117	3	localzzb	zzb
    //   15	73	4	localObject2	Object
    //   111	24	4	localIOException1	IOException
    //   197	1	4	localIOException2	IOException
    //   33	94	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   96	100	105	java/io/IOException
    //   35	55	111	java/io/IOException
    //   154	158	163	java/io/IOException
    //   35	55	169	finally
    //   2	17	182	finally
    //   28	35	182	finally
    //   96	100	182	finally
    //   154	158	182	finally
    //   176	180	182	finally
    //   180	182	182	finally
    //   176	180	187	java/io/IOException
    //   57	62	193	finally
    //   64	87	193	finally
    //   117	143	193	finally
    //   145	150	193	finally
    //   57	62	197	java/io/IOException
    //   64	87	197	java/io/IOException
  }
  
  /* Error */
  public void zza(String paramString, zzb.zza paramzza)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: getfield 341	com/google/android/gms/internal/zzb$zza:data	[B
    //   7: arraylength
    //   8: invokespecial 343	com/google/android/gms/internal/zzv:zzc	(I)V
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 201	com/google/android/gms/internal/zzv:zzf	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore_3
    //   17: new 345	java/io/FileOutputStream
    //   20: astore 5
    //   22: aload 5
    //   24: aload_3
    //   25: invokespecial 346	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   28: new 10	com/google/android/gms/internal/zzv$zza
    //   31: astore 4
    //   33: aload 4
    //   35: aload_1
    //   36: aload_2
    //   37: invokespecial 348	com/google/android/gms/internal/zzv$zza:<init>	(Ljava/lang/String;Lcom/google/android/gms/internal/zzb$zza;)V
    //   40: aload 4
    //   42: aload 5
    //   44: invokevirtual 351	com/google/android/gms/internal/zzv$zza:zza	(Ljava/io/OutputStream;)Z
    //   47: ifne +63 -> 110
    //   50: aload 5
    //   52: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   55: ldc_w 354
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_3
    //   65: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 230	com/google/android/gms/internal/zzs:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: new 64	java/io/IOException
    //   75: astore_1
    //   76: aload_1
    //   77: invokespecial 355	java/io/IOException:<init>	()V
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: aload_3
    //   84: invokevirtual 206	java/io/File:delete	()Z
    //   87: ifne +20 -> 107
    //   90: ldc_w 357
    //   93: iconst_1
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload_3
    //   100: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: aastore
    //   104: invokestatic 230	com/google/android/gms/internal/zzs:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: monitorexit
    //   109: return
    //   110: aload 5
    //   112: aload_2
    //   113: getfield 341	com/google/android/gms/internal/zzb$zza:data	[B
    //   116: invokevirtual 360	java/io/FileOutputStream:write	([B)V
    //   119: aload 5
    //   121: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   124: aload_0
    //   125: aload_1
    //   126: aload 4
    //   128: invokespecial 313	com/google/android/gms/internal/zzv:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzv$zza;)V
    //   131: goto -24 -> 107
    //   134: astore_1
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	zzv
    //   0	139	1	paramString	String
    //   0	139	2	paramzza	zzb.zza
    //   16	84	3	localFile	File
    //   31	96	4	localzza	zza
    //   20	100	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	82	82	java/io/IOException
    //   110	131	82	java/io/IOException
    //   2	17	134	finally
    //   17	82	134	finally
    //   83	107	134	finally
    //   110	131	134	finally
  }
  
  public File zzf(String paramString)
  {
    return new File(this.zzby, zze(paramString));
  }
  
  static class zza
  {
    public String zza;
    public long zzb;
    public long zzc;
    public long zzca;
    public String zzcb;
    public long zzd;
    public long zze;
    public Map<String, String> zzf;
    
    private zza() {}
    
    public zza(String paramString, zzb.zza paramzza)
    {
      this.zzcb = paramString;
      this.zzca = paramzza.data.length;
      this.zza = paramzza.zza;
      this.zzb = paramzza.zzb;
      this.zzc = paramzza.zzc;
      this.zzd = paramzza.zzd;
      this.zze = paramzza.zze;
      this.zzf = paramzza.zzf;
    }
    
    public static zza zzf(InputStream paramInputStream)
      throws IOException
    {
      zza localzza = new zza();
      if (zzv.zzb(paramInputStream) != 538247942) {
        throw new IOException();
      }
      localzza.zzcb = zzv.zzd(paramInputStream);
      localzza.zza = zzv.zzd(paramInputStream);
      if (localzza.zza.equals("")) {
        localzza.zza = null;
      }
      localzza.zzb = zzv.zzc(paramInputStream);
      localzza.zzc = zzv.zzc(paramInputStream);
      localzza.zzd = zzv.zzc(paramInputStream);
      localzza.zze = zzv.zzc(paramInputStream);
      localzza.zzf = zzv.zze(paramInputStream);
      return localzza;
    }
    
    public boolean zza(OutputStream paramOutputStream)
    {
      bool = true;
      for (;;)
      {
        try
        {
          zzv.zza(paramOutputStream, 538247942);
          zzv.zza(paramOutputStream, this.zzcb);
          if (this.zza != null) {
            continue;
          }
          str = "";
          zzv.zza(paramOutputStream, str);
          zzv.zza(paramOutputStream, this.zzb);
          zzv.zza(paramOutputStream, this.zzc);
          zzv.zza(paramOutputStream, this.zzd);
          zzv.zza(paramOutputStream, this.zze);
          zzv.zza(this.zzf, paramOutputStream);
          paramOutputStream.flush();
        }
        catch (IOException paramOutputStream)
        {
          String str;
          zzs.zzb("%s", new Object[] { paramOutputStream.toString() });
          bool = false;
          continue;
        }
        return bool;
        str = this.zza;
      }
    }
    
    public zzb.zza zzb(byte[] paramArrayOfByte)
    {
      zzb.zza localzza = new zzb.zza();
      localzza.data = paramArrayOfByte;
      localzza.zza = this.zza;
      localzza.zzb = this.zzb;
      localzza.zzc = this.zzc;
      localzza.zzd = this.zzd;
      localzza.zze = this.zze;
      localzza.zzf = this.zzf;
      return localzza;
    }
  }
  
  private static class zzb
    extends FilterInputStream
  {
    private int zzcc = 0;
    
    private zzb(InputStream paramInputStream)
    {
      super();
    }
    
    public int read()
      throws IOException
    {
      int i = super.read();
      if (i != -1) {
        this.zzcc += 1;
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        this.zzcc += paramInt1;
      }
      return paramInt1;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */