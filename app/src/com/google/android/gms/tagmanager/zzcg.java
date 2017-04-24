package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class zzcg
  implements zzaw
{
  private static final String dw = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[] { "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time" });
  private final zzb aFZ;
  private volatile zzad aGa;
  private final zzax aGb;
  private final String aGc;
  private long aGd;
  private final int aGe;
  private final Context mContext;
  private zze zzaql;
  
  zzcg(zzax paramzzax, Context paramContext)
  {
    this(paramzzax, paramContext, "gtm_urls.db", 2000);
  }
  
  zzcg(zzax paramzzax, Context paramContext, String paramString, int paramInt)
  {
    this.mContext = paramContext.getApplicationContext();
    this.aGc = paramString;
    this.aGb = paramzzax;
    this.zzaql = zzh.zzayl();
    this.aFZ = new zzb(this.mContext, this.aGc);
    this.aGa = new zzdf(this.mContext, new zza());
    this.aGd = 0L;
    this.aGe = paramInt;
  }
  
  private void zzcfv()
  {
    int i = zzcfw() - this.aGe + 1;
    if (i > 0)
    {
      List localList = zzaag(i);
      i = localList.size();
      zzbo.v(51 + "Store full, deleting " + i + " hits to make room.");
      zzh((String[])localList.toArray(new String[0]));
    }
  }
  
  private void zzh(long paramLong1, long paramLong2)
  {
    SQLiteDatabase localSQLiteDatabase = zzpf("Error opening database for getNumStoredHits.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("hit_first_send_time", Long.valueOf(paramLong2));
      try
      {
        localSQLiteDatabase.update("gtm_hits", localContentValues, "hit_id=?", new String[] { String.valueOf(paramLong1) });
      }
      catch (SQLiteException localSQLiteException)
      {
        zzbo.zzdi(69 + "Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + paramLong1);
        zzu(paramLong1);
      }
    }
  }
  
  private void zzh(long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = zzpf("Error opening database for putHit");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("hit_time", Long.valueOf(paramLong));
      localContentValues.put("hit_url", paramString);
      localContentValues.put("hit_first_send_time", Integer.valueOf(0));
      try
      {
        localSQLiteDatabase.insert("gtm_hits", null, localContentValues);
        this.aGb.zzcn(false);
      }
      catch (SQLiteException paramString)
      {
        zzbo.zzdi("Error storing hit");
      }
    }
  }
  
  private SQLiteDatabase zzpf(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.aFZ.getWritableDatabase();
      paramString = localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzbo.zzdi(paramString);
        paramString = null;
      }
    }
    return paramString;
  }
  
  private void zzu(long paramLong)
  {
    zzh(new String[] { String.valueOf(paramLong) });
  }
  
  public void dispatch()
  {
    zzbo.v("GTM Dispatch running...");
    if (!this.aGa.zzcez()) {}
    for (;;)
    {
      return;
      List localList = zzaah(40);
      if (localList.isEmpty())
      {
        zzbo.v("...nothing to dispatch");
        this.aGb.zzcn(true);
      }
      else
      {
        this.aGa.zzal(localList);
        if (zzcfx() > 0) {
          zzdc.zzcgt().dispatch();
        }
      }
    }
  }
  
  /* Error */
  List<String> zzaag(int paramInt)
  {
    // Byte code:
    //   0: new 268	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 269	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: iload_1
    //   10: ifgt +12 -> 22
    //   13: ldc_w 271
    //   16: invokestatic 204	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   19: aload 6
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 273
    //   26: invokespecial 172	com/google/android/gms/tagmanager/zzcg:zzpf	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 4
    //   31: aload 4
    //   33: ifnonnull +6 -> 39
    //   36: goto -17 -> 19
    //   39: ldc_w 275
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: ldc 37
    //   50: aastore
    //   51: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   54: astore_3
    //   55: iload_1
    //   56: invokestatic 278	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   59: astore 5
    //   61: aload 4
    //   63: ldc 35
    //   65: iconst_1
    //   66: anewarray 45	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: ldc 37
    //   73: aastore
    //   74: aconst_null
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: aload_3
    //   79: aload 5
    //   81: invokevirtual 282	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore 4
    //   86: aload 4
    //   88: astore_3
    //   89: aload 4
    //   91: invokeinterface 287 1 0
    //   96: ifeq +40 -> 136
    //   99: aload 4
    //   101: astore_3
    //   102: aload 6
    //   104: aload 4
    //   106: iconst_0
    //   107: invokeinterface 291 2 0
    //   112: invokestatic 190	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   115: invokeinterface 295 2 0
    //   120: pop
    //   121: aload 4
    //   123: astore_3
    //   124: aload 4
    //   126: invokeinterface 298 1 0
    //   131: istore_2
    //   132: iload_2
    //   133: ifne -34 -> 99
    //   136: aload 4
    //   138: ifnull +10 -> 148
    //   141: aload 4
    //   143: invokeinterface 301 1 0
    //   148: goto -129 -> 19
    //   151: astore 5
    //   153: aconst_null
    //   154: astore 4
    //   156: aload 4
    //   158: astore_3
    //   159: aload 5
    //   161: invokevirtual 304	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   164: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   167: astore 5
    //   169: aload 4
    //   171: astore_3
    //   172: aload 5
    //   174: invokevirtual 310	java/lang/String:length	()I
    //   177: ifeq +39 -> 216
    //   180: aload 4
    //   182: astore_3
    //   183: ldc_w 312
    //   186: aload 5
    //   188: invokevirtual 316	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   191: astore 5
    //   193: aload 4
    //   195: astore_3
    //   196: aload 5
    //   198: invokestatic 204	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   201: aload 4
    //   203: ifnull -55 -> 148
    //   206: aload 4
    //   208: invokeinterface 301 1 0
    //   213: goto -65 -> 148
    //   216: aload 4
    //   218: astore_3
    //   219: new 45	java/lang/String
    //   222: dup
    //   223: ldc_w 312
    //   226: invokespecial 318	java/lang/String:<init>	(Ljava/lang/String;)V
    //   229: astore 5
    //   231: goto -38 -> 193
    //   234: astore 4
    //   236: aload_3
    //   237: astore 5
    //   239: aload 4
    //   241: astore_3
    //   242: aload 5
    //   244: ifnull +10 -> 254
    //   247: aload 5
    //   249: invokeinterface 301 1 0
    //   254: aload_3
    //   255: athrow
    //   256: astore_3
    //   257: aconst_null
    //   258: astore 5
    //   260: goto -18 -> 242
    //   263: astore 5
    //   265: goto -109 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	zzcg
    //   0	268	1	paramInt	int
    //   131	2	2	bool	boolean
    //   54	201	3	localObject1	Object
    //   256	1	3	localObject2	Object
    //   29	188	4	localObject3	Object
    //   234	6	4	localObject4	Object
    //   59	21	5	str	String
    //   151	9	5	localSQLiteException1	SQLiteException
    //   167	92	5	localObject5	Object
    //   263	1	5	localSQLiteException2	SQLiteException
    //   7	96	6	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   39	86	151	android/database/sqlite/SQLiteException
    //   89	99	234	finally
    //   102	121	234	finally
    //   124	132	234	finally
    //   159	169	234	finally
    //   172	180	234	finally
    //   183	193	234	finally
    //   196	201	234	finally
    //   219	231	234	finally
    //   39	86	256	finally
    //   89	99	263	android/database/sqlite/SQLiteException
    //   102	121	263	android/database/sqlite/SQLiteException
    //   124	132	263	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public List<zzas> zzaah(int paramInt)
  {
    // Byte code:
    //   0: new 268	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 269	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: ldc_w 322
    //   13: invokespecial 172	com/google/android/gms/tagmanager/zzcg:zzpf	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 7
    //   18: aload 7
    //   20: ifnonnull +10 -> 30
    //   23: aload 5
    //   25: astore 6
    //   27: aload 6
    //   29: areturn
    //   30: aconst_null
    //   31: astore 6
    //   33: ldc_w 275
    //   36: iconst_1
    //   37: anewarray 4	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: ldc 37
    //   44: aastore
    //   45: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   48: astore 8
    //   50: iload_1
    //   51: invokestatic 278	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   54: astore 4
    //   56: aload 7
    //   58: ldc 35
    //   60: iconst_3
    //   61: anewarray 45	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc 37
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: ldc 39
    //   73: aastore
    //   74: dup
    //   75: iconst_2
    //   76: ldc 43
    //   78: aastore
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: aload 8
    //   85: aload 4
    //   87: invokevirtual 282	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 4
    //   92: new 268	java/util/ArrayList
    //   95: astore 6
    //   97: aload 6
    //   99: invokespecial 269	java/util/ArrayList:<init>	()V
    //   102: aload 4
    //   104: invokeinterface 287 1 0
    //   109: ifeq +59 -> 168
    //   112: new 324	com/google/android/gms/tagmanager/zzas
    //   115: astore 5
    //   117: aload 5
    //   119: aload 4
    //   121: iconst_0
    //   122: invokeinterface 291 2 0
    //   127: aload 4
    //   129: iconst_1
    //   130: invokeinterface 291 2 0
    //   135: aload 4
    //   137: iconst_2
    //   138: invokeinterface 291 2 0
    //   143: invokespecial 327	com/google/android/gms/tagmanager/zzas:<init>	(JJJ)V
    //   146: aload 6
    //   148: aload 5
    //   150: invokeinterface 295 2 0
    //   155: pop
    //   156: aload 4
    //   158: invokeinterface 298 1 0
    //   163: istore_3
    //   164: iload_3
    //   165: ifne -53 -> 112
    //   168: aload 4
    //   170: ifnull +10 -> 180
    //   173: aload 4
    //   175: invokeinterface 301 1 0
    //   180: aload 4
    //   182: astore 5
    //   184: ldc_w 275
    //   187: iconst_1
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: ldc 37
    //   195: aastore
    //   196: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   199: astore 8
    //   201: aload 4
    //   203: astore 5
    //   205: iload_1
    //   206: invokestatic 278	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   209: astore 9
    //   211: aload 4
    //   213: astore 5
    //   215: aload 7
    //   217: ldc 35
    //   219: iconst_2
    //   220: anewarray 45	java/lang/String
    //   223: dup
    //   224: iconst_0
    //   225: ldc 37
    //   227: aastore
    //   228: dup
    //   229: iconst_1
    //   230: ldc 41
    //   232: aastore
    //   233: aconst_null
    //   234: aconst_null
    //   235: aconst_null
    //   236: aconst_null
    //   237: aload 8
    //   239: aload 9
    //   241: invokevirtual 282	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   244: astore 7
    //   246: aload 7
    //   248: invokeinterface 287 1 0
    //   253: ifeq +53 -> 306
    //   256: iconst_0
    //   257: istore_1
    //   258: aload 7
    //   260: checkcast 329	android/database/sqlite/SQLiteCursor
    //   263: invokevirtual 333	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   266: invokevirtual 338	android/database/CursorWindow:getNumRows	()I
    //   269: ifle +153 -> 422
    //   272: aload 6
    //   274: iload_1
    //   275: invokeinterface 342 2 0
    //   280: checkcast 324	com/google/android/gms/tagmanager/zzas
    //   283: aload 7
    //   285: iconst_1
    //   286: invokeinterface 345 2 0
    //   291: invokevirtual 348	com/google/android/gms/tagmanager/zzas:zzpj	(Ljava/lang/String;)V
    //   294: aload 7
    //   296: invokeinterface 298 1 0
    //   301: istore_3
    //   302: iload_3
    //   303: ifne +454 -> 757
    //   306: aload 7
    //   308: ifnull +10 -> 318
    //   311: aload 7
    //   313: invokeinterface 301 1 0
    //   318: goto -291 -> 27
    //   321: astore 6
    //   323: aconst_null
    //   324: astore 7
    //   326: aload 5
    //   328: astore 4
    //   330: aload 7
    //   332: astore 5
    //   334: aload 6
    //   336: invokevirtual 304	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   339: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   342: astore 6
    //   344: aload 6
    //   346: invokevirtual 310	java/lang/String:length	()I
    //   349: ifeq +41 -> 390
    //   352: ldc_w 312
    //   355: aload 6
    //   357: invokevirtual 316	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   360: astore 6
    //   362: aload 6
    //   364: invokestatic 204	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   367: aload 4
    //   369: astore 6
    //   371: aload 5
    //   373: ifnull -346 -> 27
    //   376: aload 5
    //   378: invokeinterface 301 1 0
    //   383: aload 4
    //   385: astore 6
    //   387: goto -360 -> 27
    //   390: new 45	java/lang/String
    //   393: dup
    //   394: ldc_w 312
    //   397: invokespecial 318	java/lang/String:<init>	(Ljava/lang/String;)V
    //   400: astore 6
    //   402: goto -40 -> 362
    //   405: astore 4
    //   407: aload 5
    //   409: ifnull +10 -> 419
    //   412: aload 5
    //   414: invokeinterface 301 1 0
    //   419: aload 4
    //   421: athrow
    //   422: ldc_w 350
    //   425: iconst_1
    //   426: anewarray 4	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: aload 6
    //   433: iload_1
    //   434: invokeinterface 342 2 0
    //   439: checkcast 324	com/google/android/gms/tagmanager/zzas
    //   442: invokevirtual 354	com/google/android/gms/tagmanager/zzas:zzcfi	()J
    //   445: invokestatic 181	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   448: aastore
    //   449: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   452: invokestatic 204	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   455: goto -161 -> 294
    //   458: astore 5
    //   460: aload 7
    //   462: astore 4
    //   464: aload 5
    //   466: astore 7
    //   468: aload 4
    //   470: astore 5
    //   472: aload 7
    //   474: invokevirtual 304	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   477: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   480: astore 7
    //   482: aload 4
    //   484: astore 5
    //   486: aload 7
    //   488: invokevirtual 310	java/lang/String:length	()I
    //   491: ifeq +131 -> 622
    //   494: aload 4
    //   496: astore 5
    //   498: ldc_w 356
    //   501: aload 7
    //   503: invokevirtual 316	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   506: astore 7
    //   508: aload 4
    //   510: astore 5
    //   512: aload 7
    //   514: invokestatic 204	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   517: aload 4
    //   519: astore 5
    //   521: new 268	java/util/ArrayList
    //   524: astore 7
    //   526: aload 4
    //   528: astore 5
    //   530: aload 7
    //   532: invokespecial 269	java/util/ArrayList:<init>	()V
    //   535: iconst_0
    //   536: istore_1
    //   537: aload 4
    //   539: astore 5
    //   541: aload 6
    //   543: invokeinterface 360 1 0
    //   548: astore 8
    //   550: aload 4
    //   552: astore 5
    //   554: aload 8
    //   556: invokeinterface 365 1 0
    //   561: ifeq +42 -> 603
    //   564: aload 4
    //   566: astore 5
    //   568: aload 8
    //   570: invokeinterface 369 1 0
    //   575: checkcast 324	com/google/android/gms/tagmanager/zzas
    //   578: astore 6
    //   580: aload 4
    //   582: astore 5
    //   584: aload 6
    //   586: invokevirtual 372	com/google/android/gms/tagmanager/zzas:zzcfk	()Ljava/lang/String;
    //   589: invokestatic 377	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   592: istore_3
    //   593: iload_1
    //   594: istore_2
    //   595: iload_3
    //   596: ifeq +64 -> 660
    //   599: iload_1
    //   600: ifeq +58 -> 658
    //   603: aload 4
    //   605: ifnull +10 -> 615
    //   608: aload 4
    //   610: invokeinterface 301 1 0
    //   615: aload 7
    //   617: astore 6
    //   619: goto -592 -> 27
    //   622: aload 4
    //   624: astore 5
    //   626: new 45	java/lang/String
    //   629: dup
    //   630: ldc_w 356
    //   633: invokespecial 318	java/lang/String:<init>	(Ljava/lang/String;)V
    //   636: astore 7
    //   638: goto -130 -> 508
    //   641: astore 4
    //   643: aload 5
    //   645: ifnull +10 -> 655
    //   648: aload 5
    //   650: invokeinterface 301 1 0
    //   655: aload 4
    //   657: athrow
    //   658: iconst_1
    //   659: istore_2
    //   660: aload 4
    //   662: astore 5
    //   664: aload 7
    //   666: aload 6
    //   668: invokeinterface 295 2 0
    //   673: pop
    //   674: iload_2
    //   675: istore_1
    //   676: goto -126 -> 550
    //   679: astore 4
    //   681: aload 7
    //   683: astore 5
    //   685: goto -42 -> 643
    //   688: astore 7
    //   690: goto -222 -> 468
    //   693: astore 4
    //   695: aload 6
    //   697: astore 5
    //   699: goto -292 -> 407
    //   702: astore 5
    //   704: aload 4
    //   706: astore 6
    //   708: aload 5
    //   710: astore 4
    //   712: aload 6
    //   714: astore 5
    //   716: goto -309 -> 407
    //   719: astore 6
    //   721: aload 4
    //   723: astore 7
    //   725: aload 5
    //   727: astore 4
    //   729: aload 7
    //   731: astore 5
    //   733: goto -399 -> 334
    //   736: astore 5
    //   738: aload 4
    //   740: astore 7
    //   742: aload 6
    //   744: astore 4
    //   746: aload 5
    //   748: astore 6
    //   750: aload 7
    //   752: astore 5
    //   754: goto -420 -> 334
    //   757: iinc 1 1
    //   760: goto -502 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	763	0	this	zzcg
    //   0	763	1	paramInt	int
    //   594	81	2	i	int
    //   163	433	3	bool	boolean
    //   54	330	4	localObject1	Object
    //   405	15	4	localObject2	Object
    //   462	161	4	localObject3	Object
    //   641	20	4	localObject4	Object
    //   679	1	4	localObject5	Object
    //   693	12	4	localObject6	Object
    //   710	35	4	localObject7	Object
    //   7	406	5	localObject8	Object
    //   458	7	5	localSQLiteException1	SQLiteException
    //   470	228	5	localObject9	Object
    //   702	7	5	localObject10	Object
    //   714	18	5	localObject11	Object
    //   736	11	5	localSQLiteException2	SQLiteException
    //   752	1	5	localObject12	Object
    //   25	248	6	localObject13	Object
    //   321	14	6	localSQLiteException3	SQLiteException
    //   342	371	6	localObject14	Object
    //   719	24	6	localSQLiteException4	SQLiteException
    //   748	1	6	localSQLiteException5	SQLiteException
    //   16	666	7	localObject15	Object
    //   688	1	7	localSQLiteException6	SQLiteException
    //   723	28	7	localObject16	Object
    //   48	521	8	localObject17	Object
    //   209	31	9	str	String
    // Exception table:
    //   from	to	target	type
    //   33	92	321	android/database/sqlite/SQLiteException
    //   334	362	405	finally
    //   362	367	405	finally
    //   390	402	405	finally
    //   246	256	458	android/database/sqlite/SQLiteException
    //   258	294	458	android/database/sqlite/SQLiteException
    //   294	302	458	android/database/sqlite/SQLiteException
    //   422	455	458	android/database/sqlite/SQLiteException
    //   184	201	641	finally
    //   205	211	641	finally
    //   215	246	641	finally
    //   472	482	641	finally
    //   486	494	641	finally
    //   498	508	641	finally
    //   512	517	641	finally
    //   521	526	641	finally
    //   530	535	641	finally
    //   541	550	641	finally
    //   554	564	641	finally
    //   568	580	641	finally
    //   584	593	641	finally
    //   626	638	641	finally
    //   664	674	641	finally
    //   246	256	679	finally
    //   258	294	679	finally
    //   294	302	679	finally
    //   422	455	679	finally
    //   184	201	688	android/database/sqlite/SQLiteException
    //   205	211	688	android/database/sqlite/SQLiteException
    //   215	246	688	android/database/sqlite/SQLiteException
    //   33	92	693	finally
    //   92	102	702	finally
    //   102	112	702	finally
    //   112	164	702	finally
    //   92	102	719	android/database/sqlite/SQLiteException
    //   102	112	736	android/database/sqlite/SQLiteException
    //   112	164	736	android/database/sqlite/SQLiteException
  }
  
  int zzadb()
  {
    boolean bool = true;
    int i = 0;
    long l = this.zzaql.currentTimeMillis();
    if (l <= this.aGd + 86400000L) {}
    do
    {
      return i;
      this.aGd = l;
      localObject = zzpf("Error opening database for deleteStaleHits.");
    } while (localObject == null);
    i = ((SQLiteDatabase)localObject).delete("gtm_hits", "HIT_TIME < ?", new String[] { Long.toString(this.zzaql.currentTimeMillis() - 2592000000L) });
    Object localObject = this.aGb;
    if (zzcfw() == 0) {}
    for (;;)
    {
      ((zzax)localObject).zzcn(bool);
      break;
      bool = false;
    }
  }
  
  int zzcfw()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int k = 0;
    Object localObject5 = zzpf("Error opening database for getNumStoredHits.");
    int j;
    if (localObject5 == null) {
      j = k;
    }
    for (;;)
    {
      return j;
      try
      {
        localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from gtm_hits", null);
        localObject1 = localObject5;
        localObject3 = localObject5;
        if (((Cursor)localObject5).moveToFirst())
        {
          localObject1 = localObject5;
          localObject3 = localObject5;
          long l = ((Cursor)localObject5).getLong(0);
          i = (int)l;
        }
        j = i;
        if (localObject5 == null) {
          continue;
        }
        ((Cursor)localObject5).close();
        j = i;
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject4 = localObject1;
        zzbo.zzdi("Error getting numStoredHits");
        j = k;
        if (localObject1 == null) {
          continue;
        }
        ((Cursor)localObject1).close();
        j = k;
      }
      finally
      {
        Object localObject4;
        if (localObject4 != null) {
          ((Cursor)localObject4).close();
        }
      }
    }
  }
  
  /* Error */
  int zzcfx()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ldc -88
    //   8: invokespecial 172	com/google/android/gms/tagmanager/zzcg:zzpf	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +5 -> 18
    //   16: iload_1
    //   17: ireturn
    //   18: aload_3
    //   19: ldc 35
    //   21: iconst_2
    //   22: anewarray 45	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 37
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: ldc 43
    //   34: aastore
    //   35: ldc_w 408
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 411	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_3
    //   46: aload_3
    //   47: invokeinterface 414 1 0
    //   52: istore_2
    //   53: iload_2
    //   54: istore_1
    //   55: aload_3
    //   56: ifnull +11 -> 67
    //   59: aload_3
    //   60: invokeinterface 301 1 0
    //   65: iload_2
    //   66: istore_1
    //   67: goto -51 -> 16
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_3
    //   73: ldc_w 416
    //   76: invokestatic 204	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   79: aload_3
    //   80: ifnull +56 -> 136
    //   83: aload_3
    //   84: invokeinterface 301 1 0
    //   89: iconst_0
    //   90: istore_1
    //   91: goto -24 -> 67
    //   94: astore_3
    //   95: aload 4
    //   97: ifnull +10 -> 107
    //   100: aload 4
    //   102: invokeinterface 301 1 0
    //   107: aload_3
    //   108: athrow
    //   109: astore 5
    //   111: aload_3
    //   112: astore 4
    //   114: aload 5
    //   116: astore_3
    //   117: goto -22 -> 95
    //   120: astore 5
    //   122: aload_3
    //   123: astore 4
    //   125: aload 5
    //   127: astore_3
    //   128: goto -33 -> 95
    //   131: astore 4
    //   133: goto -60 -> 73
    //   136: iconst_0
    //   137: istore_1
    //   138: goto -71 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	zzcg
    //   1	137	1	i	int
    //   52	14	2	j	int
    //   11	49	3	localObject1	Object
    //   70	1	3	localSQLiteException1	SQLiteException
    //   72	12	3	localObject2	Object
    //   94	18	3	localObject3	Object
    //   116	12	3	localObject4	Object
    //   3	121	4	localObject5	Object
    //   131	1	4	localSQLiteException2	SQLiteException
    //   109	6	5	localObject6	Object
    //   120	6	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   18	46	70	android/database/sqlite/SQLiteException
    //   18	46	94	finally
    //   46	53	109	finally
    //   73	79	120	finally
    //   46	53	131	android/database/sqlite/SQLiteException
  }
  
  public void zzg(long paramLong, String paramString)
  {
    zzadb();
    zzcfv();
    zzh(paramLong, paramString);
  }
  
  void zzh(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = zzpf("Error opening database for deleteHits.");
    } while (localSQLiteDatabase == null);
    String str = String.format("HIT_ID in (%s)", new Object[] { TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
    for (;;)
    {
      try
      {
        localSQLiteDatabase.delete("gtm_hits", str, paramArrayOfString);
        paramArrayOfString = this.aGb;
        if (zzcfw() != 0) {
          break label95;
        }
        paramArrayOfString.zzcn(bool);
      }
      catch (SQLiteException paramArrayOfString)
      {
        zzbo.zzdi("Error deleting hits");
      }
      break;
      label95:
      bool = false;
    }
  }
  
  class zza
    implements zzdf.zza
  {
    zza() {}
    
    public void zza(zzas paramzzas)
    {
      zzcg.zza(zzcg.this, paramzzas.zzcfi());
    }
    
    public void zzb(zzas paramzzas)
    {
      zzcg.zza(zzcg.this, paramzzas.zzcfi());
      long l = paramzzas.zzcfi();
      zzbo.v(57 + "Permanent failure dispatching hitId: " + l);
    }
    
    public void zzc(zzas paramzzas)
    {
      long l = paramzzas.zzcfj();
      if (l == 0L) {
        zzcg.zza(zzcg.this, paramzzas.zzcfi(), zzcg.zza(zzcg.this).currentTimeMillis());
      }
      for (;;)
      {
        return;
        if (l + 14400000L < zzcg.zza(zzcg.this).currentTimeMillis())
        {
          zzcg.zza(zzcg.this, paramzzas.zzcfi());
          l = paramzzas.zzcfi();
          zzbo.v(47 + "Giving up on failed hitId: " + l);
        }
      }
    }
  }
  
  class zzb
    extends SQLiteOpenHelper
  {
    private boolean aGg;
    private long aGh = 0L;
    
    zzb(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    /* Error */
    private boolean zza(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aload_2
      //   4: ldc 29
      //   6: iconst_1
      //   7: anewarray 31	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 33
      //   14: aastore
      //   15: ldc 35
      //   17: iconst_1
      //   18: anewarray 31	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 41	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface 47 1 0
      //   38: istore_3
      //   39: iload_3
      //   40: istore 4
      //   42: aload_2
      //   43: ifnull +12 -> 55
      //   46: aload_2
      //   47: invokeinterface 51 1 0
      //   52: iload_3
      //   53: istore 4
      //   55: iload 4
      //   57: ireturn
      //   58: astore_2
      //   59: aconst_null
      //   60: astore_2
      //   61: aload_1
      //   62: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   65: astore_1
      //   66: aload_1
      //   67: invokevirtual 59	java/lang/String:length	()I
      //   70: ifeq +30 -> 100
      //   73: ldc 61
      //   75: aload_1
      //   76: invokevirtual 65	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   79: astore_1
      //   80: aload_1
      //   81: invokestatic 71	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
      //   84: aload_2
      //   85: ifnull +9 -> 94
      //   88: aload_2
      //   89: invokeinterface 51 1 0
      //   94: iconst_0
      //   95: istore 4
      //   97: goto -42 -> 55
      //   100: new 31	java/lang/String
      //   103: dup
      //   104: ldc 61
      //   106: invokespecial 73	java/lang/String:<init>	(Ljava/lang/String;)V
      //   109: astore_1
      //   110: goto -30 -> 80
      //   113: astore_1
      //   114: aload_2
      //   115: ifnull +9 -> 124
      //   118: aload_2
      //   119: invokeinterface 51 1 0
      //   124: aload_1
      //   125: athrow
      //   126: astore_1
      //   127: aload 5
      //   129: astore_2
      //   130: goto -16 -> 114
      //   133: astore_1
      //   134: goto -20 -> 114
      //   137: astore 5
      //   139: goto -78 -> 61
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	142	0	this	zzb
      //   0	142	1	paramString	String
      //   0	142	2	paramSQLiteDatabase	SQLiteDatabase
      //   38	15	3	bool1	boolean
      //   40	56	4	bool2	boolean
      //   1	127	5	localObject	Object
      //   137	1	5	localSQLiteException	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   3	32	58	android/database/sqlite/SQLiteException
      //   61	80	113	finally
      //   80	84	113	finally
      //   100	110	113	finally
      //   3	32	126	finally
      //   32	39	133	finally
      //   32	39	137	android/database/sqlite/SQLiteException
    }
    
    private void zzc(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = paramSQLiteDatabase.getColumnNames();
        for (int i = 0; i < arrayOfString.length; i++) {
          localHashSet.add(arrayOfString[i]);
        }
        paramSQLiteDatabase.close();
        if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_time")) || (!localHashSet.remove("hit_first_send_time"))) {
          throw new SQLiteException("Database column missing");
        }
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
      if (!((Set)localObject).isEmpty()) {
        throw new SQLiteException("Database has extra columns");
      }
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      if ((this.aGg) && (this.aGh + 3600000L > zzcg.zza(zzcg.this).currentTimeMillis())) {
        throw new SQLiteException("Database creation failed");
      }
      Object localObject1 = null;
      this.aGg = true;
      this.aGh = zzcg.zza(zzcg.this).currentTimeMillis();
      try
      {
        localObject2 = super.getWritableDatabase();
        localObject1 = localObject2;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          Object localObject2;
          zzcg.zzc(zzcg.this).getDatabasePath(zzcg.zzb(zzcg.this)).delete();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getWritableDatabase();
      }
      this.aGg = false;
      return (SQLiteDatabase)localObject2;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      zzan.zzfd(paramSQLiteDatabase.getPath());
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15) {
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      }
      for (;;)
      {
        try
        {
          localCursor.moveToFirst();
          localCursor.close();
          if (!zza("gtm_hits", paramSQLiteDatabase))
          {
            paramSQLiteDatabase.execSQL(zzcg.zzcfy());
            return;
          }
        }
        finally
        {
          localCursor.close();
        }
        zzc(paramSQLiteDatabase);
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */