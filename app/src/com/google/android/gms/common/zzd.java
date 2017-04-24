package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzr.zza;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.util.zzm;
import com.google.android.gms.dynamic.zze;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;

class zzd
{
  private static zzu wU;
  private static Context wV;
  
  static boolean zza(String paramString, zza paramzza)
  {
    boolean bool1 = false;
    if ((wU == null) && (!zzaqm())) {}
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = wU.zzd(paramString, paramzza.zzaqn());
        bool1 = bool2;
      }
      catch (RemoteException paramzza)
      {
        Log.e("GoogleCertificates", String.valueOf(paramString).length() + 44 + "Error checking if " + paramString + " is Google release signed.");
      }
    }
  }
  
  /* Error */
  private static boolean zzaqm()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 29	com/google/android/gms/common/zzd:wU	Lcom/google/android/gms/common/internal/zzu;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +10 -> 20
    //   13: iload_1
    //   14: istore_0
    //   15: ldc 2
    //   17: monitorexit
    //   18: iload_0
    //   19: ireturn
    //   20: getstatic 83	com/google/android/gms/common/zzd:wV	Landroid/content/Context;
    //   23: invokestatic 89	com/google/android/gms/common/internal/zzaa:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: pop
    //   27: getstatic 29	com/google/android/gms/common/zzd:wU	Lcom/google/android/gms/common/internal/zzu;
    //   30: astore_2
    //   31: iload_1
    //   32: istore_0
    //   33: aload_2
    //   34: ifnonnull -19 -> 15
    //   37: getstatic 83	com/google/android/gms/common/zzd:wV	Landroid/content/Context;
    //   40: getstatic 95	com/google/android/gms/internal/zztl:Qq	Lcom/google/android/gms/internal/zztl$zzb;
    //   43: ldc 97
    //   45: invokestatic 100	com/google/android/gms/internal/zztl:zza	(Landroid/content/Context;Lcom/google/android/gms/internal/zztl$zzb;Ljava/lang/String;)Lcom/google/android/gms/internal/zztl;
    //   48: astore_2
    //   49: ldc 44
    //   51: ldc 102
    //   53: invokestatic 105	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   56: pop
    //   57: aload_2
    //   58: ldc 107
    //   60: invokevirtual 111	com/google/android/gms/internal/zztl:zzjd	(Ljava/lang/String;)Landroid/os/IBinder;
    //   63: invokestatic 117	com/google/android/gms/common/internal/zzu$zza:zzdv	(Landroid/os/IBinder;)Lcom/google/android/gms/common/internal/zzu;
    //   66: putstatic 29	com/google/android/gms/common/zzd:wU	Lcom/google/android/gms/common/internal/zzu;
    //   69: iload_1
    //   70: istore_0
    //   71: goto -56 -> 15
    //   74: astore_3
    //   75: ldc 119
    //   77: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   80: astore_2
    //   81: aload_3
    //   82: invokevirtual 122	com/google/android/gms/internal/zztl$zza:getMessage	()Ljava/lang/String;
    //   85: invokestatic 52	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: astore_3
    //   89: aload_3
    //   90: invokevirtual 56	java/lang/String:length	()I
    //   93: ifeq +21 -> 114
    //   96: aload_2
    //   97: aload_3
    //   98: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: ldc 44
    //   104: aload_2
    //   105: invokestatic 78	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   108: pop
    //   109: iconst_0
    //   110: istore_0
    //   111: goto -96 -> 15
    //   114: new 48	java/lang/String
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 129	java/lang/String:<init>	(Ljava/lang/String;)V
    //   122: astore_2
    //   123: goto -21 -> 102
    //   126: astore_2
    //   127: ldc 2
    //   129: monitorexit
    //   130: aload_2
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	97	0	bool1	boolean
    //   1	69	1	bool2	boolean
    //   8	115	2	localObject1	Object
    //   126	5	2	localObject2	Object
    //   74	8	3	localzza	com.google.android.gms.internal.zztl.zza
    //   88	10	3	str	String
    // Exception table:
    //   from	to	target	type
    //   37	69	74	com/google/android/gms/internal/zztl$zza
    //   5	9	126	finally
    //   20	31	126	finally
    //   37	69	126	finally
    //   75	102	126	finally
    //   102	109	126	finally
    //   114	123	126	finally
  }
  
  static boolean zzb(String paramString, zza paramzza)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((wU == null) && (!zzaqm())) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        bool1 = wU.zze(paramString, paramzza.zzaqn());
      }
      catch (RemoteException paramzza)
      {
        Log.e("GoogleCertificates", String.valueOf(paramString).length() + 36 + "Error checking if " + paramString + " is Google signed.");
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  static void zzbo(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 83	com/google/android/gms/common/zzd:wV	Landroid/content/Context;
    //   6: ifnonnull +18 -> 24
    //   9: aload_0
    //   10: ifnull +10 -> 20
    //   13: aload_0
    //   14: invokevirtual 142	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: putstatic 83	com/google/android/gms/common/zzd:wV	Landroid/content/Context;
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: ldc 44
    //   26: ldc -112
    //   28: invokestatic 147	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   31: pop
    //   32: goto -12 -> 20
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	9	35	finally
    //   13	20	35	finally
    //   24	32	35	finally
  }
  
  static abstract class zza
    extends zzr.zza
  {
    private int wW;
    
    protected zza(byte[] paramArrayOfByte)
    {
      Object localObject = paramArrayOfByte;
      if (paramArrayOfByte.length != 25)
      {
        int i = paramArrayOfByte.length;
        localObject = String.valueOf(zzm.zza(paramArrayOfByte, 0, paramArrayOfByte.length, false));
        Log.wtf("GoogleCertificates", String.valueOf(localObject).length() + 51 + "Cert hash data has incorrect length (" + i + "):\n" + (String)localObject, new Exception());
        localObject = Arrays.copyOfRange(paramArrayOfByte, 0, 25);
        if (localObject.length == 25) {
          bool = true;
        }
        i = localObject.length;
        zzaa.zzb(bool, 55 + "cert hash data has incorrect length. length=" + i);
      }
      this.wW = Arrays.hashCode((byte[])localObject);
    }
    
    protected static byte[] zzhg(String paramString)
    {
      try
      {
        paramString = paramString.getBytes("ISO-8859-1");
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new AssertionError(paramString);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool;
      if ((paramObject == null) || (!(paramObject instanceof zzr))) {
        bool = false;
      }
      for (;;)
      {
        return bool;
        try
        {
          paramObject = (zzr)paramObject;
          if (((zzr)paramObject).zzaqo() != hashCode())
          {
            bool = false;
          }
          else
          {
            paramObject = ((zzr)paramObject).zzaqn();
            if (paramObject == null)
            {
              bool = false;
            }
            else
            {
              paramObject = (byte[])zze.zzae((com.google.android.gms.dynamic.zzd)paramObject);
              bool = Arrays.equals(getBytes(), (byte[])paramObject);
            }
          }
        }
        catch (RemoteException paramObject)
        {
          Log.e("GoogleCertificates", "iCertData failed to retrive data from remote");
          bool = false;
        }
      }
    }
    
    abstract byte[] getBytes();
    
    public int hashCode()
    {
      return this.wW;
    }
    
    public com.google.android.gms.dynamic.zzd zzaqn()
    {
      return zze.zzac(getBytes());
    }
    
    public int zzaqo()
    {
      return hashCode();
    }
  }
  
  static class zzb
    extends zzd.zza
  {
    private final byte[] wX;
    
    zzb(byte[] paramArrayOfByte)
    {
      super();
      this.wX = paramArrayOfByte;
    }
    
    byte[] getBytes()
    {
      return this.wX;
    }
  }
  
  static abstract class zzc
    extends zzd.zza
  {
    private static final WeakReference<byte[]> wZ = new WeakReference(null);
    private WeakReference<byte[]> wY = wZ;
    
    zzc(byte[] paramArrayOfByte)
    {
      super();
    }
    
    byte[] getBytes()
    {
      try
      {
        Object localObject3 = (byte[])this.wY.get();
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = zzaqp();
          localObject3 = new java/lang/ref/WeakReference;
          ((WeakReference)localObject3).<init>(localObject1);
          this.wY = ((WeakReference)localObject3);
        }
        return (byte[])localObject1;
      }
      finally {}
    }
    
    protected abstract byte[] zzaqp();
  }
  
  static final class zzd
  {
    static final zzd.zza[] xa = { new zzd.zzc(zzd.zza.zzhg("0\004C0\003+ \003\002\001\002\002\t\000ÂàFdJ00"))new zzd.zzc
    {
      protected byte[] zzaqp()
      {
        return zzd.zza.zzhg("0\004C0\003+ \003\002\001\002\002\t\000ÂàFdJ00\r\006\t*H÷\r\001\001\004\005\0000t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android0\036\027\r080821231334Z\027\r360107231334Z0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android0\001 0\r\006\t*H÷\r\001\001\001\005\000\003\001\r\0000\001\b\002\001\001\000«V.\000Ø;¢\b®\no\022N)Ú\021ò«VÐXâÌ©\023\003é·TÓrö@§\033\035Ë\023\tgbNFV§wj\031=²å¿·$©\036w\030\016jG¤;3Ù`w\0301EÌß{.XftÉáV[\037LjYU¿òQ¦=«ùÅ\\'\"\"Rèuäø\025Jd_qhÀ±¿Æ\022ê¿xWi»4ªyÜ~.¢vL®\007ØÁqT×î_d¥\032D¦\002ÂI\005AWÜ\002Í_\\\016Uûï\031ûã'ð±Q\026Å o\031ÑõÄÛÂÖ¹?hÌ)yÇ\016\030«k;ÕÛU*\016;LßXûíÁº5à\003Á´±\rÒD¨î$ÿý38r«R!^Ú°ü\r\013\024[j¡y\002\001\003£Ù0Ö0\035\006\003U\035\016\004\026\004\024Ç}Â!\027V%Óßkãä×¥0¦\006\003U\035#\0040\024Ç}Â!\027V%Óßkãä×¥¡x¤v0t1\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0240\022\006\003U\004\n\023\013Google Inc.1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android\t\000ÂàFdJ00\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\004\005\000\003\001\001\000mÒRÎï0,6\nªÎÏòÌ©\004»]z\026aø®F²B\004ÐÿJhÇí\032S\036ÄYZb<æ\007c±g)zzãW\022Ä\007ò\bðË\020)\022M{\020b\031ÀÊ>³ù­_¸qï&âñmDÈÙ l²ð\005»?âËD~s\020v­E³?`\tê\031Áaæ&Aª'\035ýR(ÅÅ]ÛE'XÖaöÌ\fÌ·5.BLÄ6\\R52÷2Q7Y<JãAôÛAíÚ\r\013\020q§Ä@ðþ \034¶'ÊgCiÐ½/Ù\021ÿ\006Í¿,ú\020Ü\017:ãWbHÇïÆLqD\027B÷\005ÉÞW:õ[9\r×ý¹A1]_u0\021&ÿb\024\020Ài0");
      }
    }, new zzd.zzc(zzd.zza.zzhg("0\004¨0\003 \003\002\001\002\002\t\000Õ¸l}ÓNõ0"))
    {
      protected byte[] zzaqp()
      {
        return zzd.zza.zzhg("0\004¨0\003 \003\002\001\002\002\t\000Õ¸l}ÓNõ0\r\006\t*H÷\r\001\001\004\005\00001\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\036\027\r080415233656Z\027\r350901233656Z01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com0\001 0\r\006\t*H÷\r\001\001\001\005\000\003\001\r\0000\001\b\002\001\001\000ÖÎ.\b\n¿â1MÑ³ÏÓ\030\\´=3ú\ftá½¶ÑÛ\023ö,\\9ßVøF=e¾ÀóÊBk\007Å¨íZ9ÁgçkÉ¹'K\013\"\000\031©)\025årÅm*0\033£oÅü\021:ÖËt5¡m#«}úîáeäß\037\n½§\nQlN\005\021Ê|\fU\027[ÃuùHÅj®\b¤O¦¤Ý}¿,\n5\"­\006¸Ì\030^±Uyîøm\b\013\035aÀù¯±ÂëÑ\007êE«Ûh£Ç^TÇlSÔ\013\022\035ç»Ó\016b\f\030áªaÛ¼Ý<d_/UóÔÃuì@p©?qQØ6pÁj\032¾^òÑ\030á¸®ó)ðf¿láD¬èm\034\033\017\002\001\003£ü0ù0\035\006\003U\035\016\004\026\004\024\034Å¾LC<a:\025°L¼\003òOà²0É\006\003U\035#\004Á0¾\024\034Å¾LC<a:\025°L¼\003òOà²¡¤01\0130\t\006\003U\004\006\023\002US1\0230\021\006\003U\004\b\023\nCalifornia1\0260\024\006\003U\004\007\023\rMountain View1\0200\016\006\003U\004\n\023\007Android1\0200\016\006\003U\004\013\023\007Android1\0200\016\006\003U\004\003\023\007Android1\"0 \006\t*H÷\r\001\t\001\026\023android@android.com\t\000Õ¸l}ÓNõ0\f\006\003U\035\023\004\0050\003\001\001ÿ0\r\006\t*H÷\r\001\001\004\005\000\003\001\001\000\031Ó\fñ\005ûx?L\r}Ò##=@zÏÎ\000\b\035[×ÆéÖí k\016\021 \006Al¢D\023ÒkJ àõ$ÊÒ»\\nL¡\001j\025n¡ì]ÉZ^:\001\0006ôHÕ\020¿.\036ag:;åm¯\013w±Â)ãÂUãèL]#ïº\tËñ; +NZ\"É2cHJ#Òü)ú\0319u3¯Øª\026\017BÂÐ\026>fCéÁ/ Á33[Àÿk\"ÞÑ­DB)¥9©Nï­«ÐeÎÒK>QåÝ{fx{ï\022þû¤Ä#ûOøÌIL\002ðõ\005\026\022ÿe)9>FêÅ»!òwÁQª_*¦'Ñè§\n¶\0035iÞ;¿ÿ|©Ú>\022Cö\013");
      }
    } };
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */