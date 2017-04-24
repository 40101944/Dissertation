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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class zzx
  implements DataLayer.zzc
{
  private static final String aEP = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[] { "datalayer", "ID", "key", "value", "expires" });
  private final Executor aEQ;
  private zza aER;
  private int aES;
  private final Context mContext;
  private zze zzaql;
  
  public zzx(Context paramContext)
  {
    this(paramContext, zzh.zzayl(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
  }
  
  zzx(Context paramContext, zze paramzze, String paramString, int paramInt, Executor paramExecutor)
  {
    this.mContext = paramContext;
    this.zzaql = paramzze;
    this.aES = paramInt;
    this.aEQ = paramExecutor;
    this.aER = new zza(this.mContext, paramString);
  }
  
  private void zzaaa(int paramInt)
  {
    paramInt = zzcew() - this.aES + paramInt;
    if (paramInt > 0)
    {
      List localList = zzaab(paramInt);
      paramInt = localList.size();
      zzbo.zzdh(64 + "DataLayer store full, deleting " + paramInt + " entries to make room.");
      zzg((String[])localList.toArray(new String[0]));
    }
  }
  
  /* Error */
  private List<String> zzaab(int paramInt)
  {
    // Byte code:
    //   0: new 154	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 155	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: iload_1
    //   10: ifgt +11 -> 21
    //   13: ldc -99
    //   15: invokestatic 160	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   18: aload 6
    //   20: areturn
    //   21: aload_0
    //   22: ldc -94
    //   24: invokespecial 166	com/google/android/gms/tagmanager/zzx:zzpf	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +6 -> 35
    //   32: goto -14 -> 18
    //   35: ldc -88
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: ldc 38
    //   45: aastore
    //   46: invokestatic 50	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   49: astore 5
    //   51: iload_1
    //   52: invokestatic 173	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   55: astore 4
    //   57: aload_3
    //   58: ldc 36
    //   60: iconst_1
    //   61: anewarray 46	java/lang/String
    //   64: dup
    //   65: iconst_0
    //   66: ldc 38
    //   68: aastore
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: aload 5
    //   75: aload 4
    //   77: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 4
    //   82: aload 4
    //   84: astore_3
    //   85: aload 4
    //   87: invokeinterface 185 1 0
    //   92: ifeq +40 -> 132
    //   95: aload 4
    //   97: astore_3
    //   98: aload 6
    //   100: aload 4
    //   102: iconst_0
    //   103: invokeinterface 189 2 0
    //   108: invokestatic 193	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   111: invokeinterface 197 2 0
    //   116: pop
    //   117: aload 4
    //   119: astore_3
    //   120: aload 4
    //   122: invokeinterface 200 1 0
    //   127: istore_2
    //   128: iload_2
    //   129: ifne -34 -> 95
    //   132: aload 4
    //   134: ifnull +10 -> 144
    //   137: aload 4
    //   139: invokeinterface 203 1 0
    //   144: goto -126 -> 18
    //   147: astore 5
    //   149: aconst_null
    //   150: astore 4
    //   152: aload 4
    //   154: astore_3
    //   155: aload 5
    //   157: invokevirtual 206	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   160: invokestatic 209	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   163: astore 5
    //   165: aload 4
    //   167: astore_3
    //   168: aload 5
    //   170: invokevirtual 212	java/lang/String:length	()I
    //   173: ifeq +38 -> 211
    //   176: aload 4
    //   178: astore_3
    //   179: ldc -42
    //   181: aload 5
    //   183: invokevirtual 218	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 5
    //   188: aload 4
    //   190: astore_3
    //   191: aload 5
    //   193: invokestatic 160	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
    //   196: aload 4
    //   198: ifnull -54 -> 144
    //   201: aload 4
    //   203: invokeinterface 203 1 0
    //   208: goto -64 -> 144
    //   211: aload 4
    //   213: astore_3
    //   214: new 46	java/lang/String
    //   217: dup
    //   218: ldc -42
    //   220: invokespecial 220	java/lang/String:<init>	(Ljava/lang/String;)V
    //   223: astore 5
    //   225: goto -37 -> 188
    //   228: astore 5
    //   230: aload_3
    //   231: astore 4
    //   233: aload 5
    //   235: astore_3
    //   236: aload 4
    //   238: ifnull +10 -> 248
    //   241: aload 4
    //   243: invokeinterface 203 1 0
    //   248: aload_3
    //   249: athrow
    //   250: astore_3
    //   251: aconst_null
    //   252: astore 4
    //   254: goto -18 -> 236
    //   257: astore 5
    //   259: goto -107 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	zzx
    //   0	262	1	paramInt	int
    //   127	2	2	bool	boolean
    //   27	222	3	localObject1	Object
    //   250	1	3	localObject2	Object
    //   55	198	4	localObject3	Object
    //   49	25	5	str1	String
    //   147	9	5	localSQLiteException1	SQLiteException
    //   163	61	5	str2	String
    //   228	6	5	localObject4	Object
    //   257	1	5	localSQLiteException2	SQLiteException
    //   7	92	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   35	82	147	android/database/sqlite/SQLiteException
    //   85	95	228	finally
    //   98	117	228	finally
    //   120	128	228	finally
    //   155	165	228	finally
    //   168	176	228	finally
    //   179	188	228	finally
    //   191	196	228	finally
    //   214	225	228	finally
    //   35	82	250	finally
    //   85	95	257	android/database/sqlite/SQLiteException
    //   98	117	257	android/database/sqlite/SQLiteException
    //   120	128	257	android/database/sqlite/SQLiteException
  }
  
  private List<DataLayer.zza> zzaj(List<zzb> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (zzb)localIterator.next();
      localArrayList.add(new DataLayer.zza(paramList.zzbcn, zzak(paramList.aEY)));
    }
    return localArrayList;
  }
  
  /* Error */
  private Object zzak(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 260	java/io/ByteArrayInputStream
    //   5: dup
    //   6: aload_1
    //   7: invokespecial 263	java/io/ByteArrayInputStream:<init>	([B)V
    //   10: astore 4
    //   12: new 265	java/io/ObjectInputStream
    //   15: astore_1
    //   16: aload_1
    //   17: aload 4
    //   19: invokespecial 268	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: aload_1
    //   23: invokevirtual 271	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   26: astore_3
    //   27: aload_3
    //   28: astore_2
    //   29: aload_1
    //   30: ifnull +7 -> 37
    //   33: aload_1
    //   34: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   37: aload 4
    //   39: invokevirtual 273	java/io/ByteArrayInputStream:close	()V
    //   42: aload_2
    //   43: areturn
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +7 -> 55
    //   51: aload_1
    //   52: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   55: aload 4
    //   57: invokevirtual 273	java/io/ByteArrayInputStream:close	()V
    //   60: goto -18 -> 42
    //   63: astore_1
    //   64: goto -22 -> 42
    //   67: astore_1
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   78: aload 4
    //   80: invokevirtual 273	java/io/ByteArrayInputStream:close	()V
    //   83: goto -41 -> 42
    //   86: astore_1
    //   87: goto -45 -> 42
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   101: aload 4
    //   103: invokevirtual 273	java/io/ByteArrayInputStream:close	()V
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: goto -3 -> 106
    //   112: astore_2
    //   113: goto -20 -> 93
    //   116: astore_3
    //   117: goto -47 -> 70
    //   120: astore_3
    //   121: goto -74 -> 47
    //   124: astore_1
    //   125: goto -83 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	zzx
    //   0	128	1	paramArrayOfByte	byte[]
    //   1	42	2	localObject1	Object
    //   90	17	2	localObject2	Object
    //   112	1	2	localObject3	Object
    //   26	2	3	localObject4	Object
    //   116	1	3	localClassNotFoundException	ClassNotFoundException
    //   120	1	3	localIOException	java.io.IOException
    //   10	92	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   12	22	44	java/io/IOException
    //   51	55	63	java/io/IOException
    //   55	60	63	java/io/IOException
    //   12	22	67	java/lang/ClassNotFoundException
    //   74	78	86	java/io/IOException
    //   78	83	86	java/io/IOException
    //   12	22	90	finally
    //   97	101	108	java/io/IOException
    //   101	106	108	java/io/IOException
    //   22	27	112	finally
    //   22	27	116	java/lang/ClassNotFoundException
    //   22	27	120	java/io/IOException
    //   33	37	124	java/io/IOException
    //   37	42	124	java/io/IOException
  }
  
  private List<zzb> zzak(List<DataLayer.zza> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DataLayer.zza localzza = (DataLayer.zza)paramList.next();
      localArrayList.add(new zzb(localzza.zzbcn, zzal(localzza.zzcyd)));
    }
    return localArrayList;
  }
  
  /* Error */
  private byte[] zzal(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 288	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 289	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 4
    //   11: new 291	java/io/ObjectOutputStream
    //   14: astore_2
    //   15: aload_2
    //   16: aload 4
    //   18: invokespecial 294	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: aload_2
    //   22: aload_1
    //   23: invokevirtual 298	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   26: aload 4
    //   28: invokevirtual 302	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   31: astore_1
    //   32: aload_2
    //   33: ifnull +7 -> 40
    //   36: aload_2
    //   37: invokevirtual 303	java/io/ObjectOutputStream:close	()V
    //   40: aload 4
    //   42: invokevirtual 304	java/io/ByteArrayOutputStream:close	()V
    //   45: aload_1
    //   46: areturn
    //   47: astore_1
    //   48: aconst_null
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +7 -> 58
    //   54: aload_2
    //   55: invokevirtual 303	java/io/ObjectOutputStream:close	()V
    //   58: aload 4
    //   60: invokevirtual 304	java/io/ByteArrayOutputStream:close	()V
    //   63: aload_3
    //   64: astore_1
    //   65: goto -20 -> 45
    //   68: astore_1
    //   69: aload_3
    //   70: astore_1
    //   71: goto -26 -> 45
    //   74: astore_1
    //   75: aconst_null
    //   76: astore_2
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 303	java/io/ObjectOutputStream:close	()V
    //   85: aload 4
    //   87: invokevirtual 304	java/io/ByteArrayOutputStream:close	()V
    //   90: aload_1
    //   91: athrow
    //   92: astore_2
    //   93: goto -3 -> 90
    //   96: astore_1
    //   97: goto -20 -> 77
    //   100: astore_1
    //   101: goto -51 -> 50
    //   104: astore_2
    //   105: goto -60 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	zzx
    //   0	108	1	paramObject	Object
    //   14	68	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   92	1	2	localIOException1	java.io.IOException
    //   104	1	2	localIOException2	java.io.IOException
    //   1	69	3	localObject	Object
    //   9	77	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   11	21	47	java/io/IOException
    //   54	58	68	java/io/IOException
    //   58	63	68	java/io/IOException
    //   11	21	74	finally
    //   81	85	92	java/io/IOException
    //   85	90	92	java/io/IOException
    //   21	32	96	finally
    //   21	32	100	java/io/IOException
    //   36	40	104	java/io/IOException
    //   40	45	104	java/io/IOException
  }
  
  /* Error */
  private void zzb(List<zzb> paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/google/android/gms/tagmanager/zzx:zzaql	Lcom/google/android/gms/common/util/zze;
    //   6: invokeinterface 311 1 0
    //   11: lstore 4
    //   13: aload_0
    //   14: lload 4
    //   16: invokespecial 315	com/google/android/gms/tagmanager/zzx:zzbu	(J)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 116 1 0
    //   26: invokespecial 317	com/google/android/gms/tagmanager/zzx:zzaaa	(I)V
    //   29: aload_0
    //   30: aload_1
    //   31: lload 4
    //   33: lload_2
    //   34: ladd
    //   35: invokespecial 320	com/google/android/gms/tagmanager/zzx:zzc	(Ljava/util/List;J)V
    //   38: aload_0
    //   39: invokespecial 323	com/google/android/gms/tagmanager/zzx:zzcex	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: invokespecial 323	com/google/android/gms/tagmanager/zzx:zzcex	()V
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	zzx
    //   0	57	1	paramList	List<zzb>
    //   0	57	2	paramLong	long
    //   11	21	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	38	45	finally
    //   38	42	52	finally
    //   46	52	52	finally
  }
  
  private void zzbu(long paramLong)
  {
    Object localObject = zzpf("Error opening database for deleteOlderThan.");
    if (localObject == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = ((SQLiteDatabase)localObject).delete("datalayer", "expires <= ?", new String[] { Long.toString(paramLong) });
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>(33);
        zzbo.v("Deleted " + i + " expired items");
      }
      catch (SQLiteException localSQLiteException)
      {
        zzbo.zzdi("Error deleting old entries.");
      }
    }
  }
  
  private void zzc(List<zzb> paramList, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = zzpf("Error opening database for writeEntryToDatabase.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (zzb)localIterator.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("expires", Long.valueOf(paramLong));
        localContentValues.put("key", paramList.zzbcn);
        localContentValues.put("value", paramList.aEY);
        localSQLiteDatabase.insert("datalayer", null, localContentValues);
      }
    }
  }
  
  private List<DataLayer.zza> zzceu()
  {
    try
    {
      zzbu(this.zzaql.currentTimeMillis());
      List localList = zzaj(zzcev());
      return localList;
    }
    finally
    {
      zzcex();
    }
  }
  
  /* Error */
  private List<zzb> zzcev()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 374
    //   4: invokespecial 166	com/google/android/gms/tagmanager/zzx:zzpf	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_2
    //   8: new 154	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 155	java/util/ArrayList:<init>	()V
    //   15: astore_1
    //   16: aload_2
    //   17: ifnonnull +5 -> 22
    //   20: aload_1
    //   21: areturn
    //   22: aload_2
    //   23: ldc 36
    //   25: iconst_2
    //   26: anewarray 46	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc 40
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: ldc 42
    //   38: aastore
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: ldc 38
    //   45: aconst_null
    //   46: invokevirtual 179	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_2
    //   50: aload_2
    //   51: invokeinterface 200 1 0
    //   56: ifeq +45 -> 101
    //   59: new 17	com/google/android/gms/tagmanager/zzx$zzb
    //   62: astore_3
    //   63: aload_3
    //   64: aload_2
    //   65: iconst_0
    //   66: invokeinterface 377 2 0
    //   71: aload_2
    //   72: iconst_1
    //   73: invokeinterface 381 2 0
    //   78: invokespecial 285	com/google/android/gms/tagmanager/zzx$zzb:<init>	(Ljava/lang/String;[B)V
    //   81: aload_1
    //   82: aload_3
    //   83: invokeinterface 197 2 0
    //   88: pop
    //   89: goto -39 -> 50
    //   92: astore_1
    //   93: aload_2
    //   94: invokeinterface 203 1 0
    //   99: aload_1
    //   100: athrow
    //   101: aload_2
    //   102: invokeinterface 203 1 0
    //   107: goto -87 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	zzx
    //   15	67	1	localArrayList	ArrayList
    //   92	8	1	localObject1	Object
    //   7	95	2	localObject2	Object
    //   62	21	3	localzzb	zzb
    // Exception table:
    //   from	to	target	type
    //   50	89	92	finally
  }
  
  private int zzcew()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    int k = 0;
    Object localObject5 = zzpf("Error opening database for getNumStoredEntries.");
    int j;
    if (localObject5 == null) {
      j = k;
    }
    for (;;)
    {
      return j;
      try
      {
        localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT COUNT(*) from datalayer", null);
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
        zzbo.zzdi("Error getting numStoredEntries");
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
  
  private void zzcex()
  {
    try
    {
      this.aER.close();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;) {}
    }
  }
  
  private void zzg(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    for (;;)
    {
      return;
      SQLiteDatabase localSQLiteDatabase = zzpf("Error opening database for deleteEntries.");
      if (localSQLiteDatabase != null)
      {
        String str = String.format("%s in (%s)", new Object[] { "ID", TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?")) });
        try
        {
          localSQLiteDatabase.delete("datalayer", str, paramArrayOfString);
        }
        catch (SQLiteException localSQLiteException)
        {
          paramArrayOfString = String.valueOf(Arrays.toString(paramArrayOfString));
          if (paramArrayOfString.length() == 0) {}
        }
      }
    }
    for (paramArrayOfString = "Error deleting entries ".concat(paramArrayOfString);; paramArrayOfString = new String("Error deleting entries "))
    {
      zzbo.zzdi(paramArrayOfString);
      break;
    }
  }
  
  private void zzpe(String paramString)
  {
    Object localObject = zzpf("Error opening database for clearKeysWithPrefix.");
    if (localObject == null) {}
    for (;;)
    {
      return;
      try
      {
        int i = ((SQLiteDatabase)localObject).delete("datalayer", "key = ? OR key LIKE ?", new String[] { paramString, String.valueOf(paramString).concat(".%") });
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>(25);
        zzbo.v("Cleared " + i + " items");
        zzcex();
      }
      catch (SQLiteException localSQLiteException)
      {
        String str = String.valueOf(localSQLiteException);
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(String.valueOf(paramString).length() + 44 + String.valueOf(str).length());
        zzbo.zzdi("Error deleting entries with key prefix: " + paramString + " (" + str + ").");
        zzcex();
      }
      finally
      {
        zzcex();
      }
    }
  }
  
  private SQLiteDatabase zzpf(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.aER.getWritableDatabase();
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
  
  public void zza(final DataLayer.zzc.zza paramzza)
  {
    this.aEQ.execute(new Runnable()
    {
      public void run()
      {
        paramzza.zzai(zzx.zza(zzx.this));
      }
    });
  }
  
  public void zza(final List<DataLayer.zza> paramList, final long paramLong)
  {
    paramList = zzak(paramList);
    this.aEQ.execute(new Runnable()
    {
      public void run()
      {
        zzx.zza(zzx.this, paramList, paramLong);
      }
    });
  }
  
  public void zzpd(final String paramString)
  {
    this.aEQ.execute(new Runnable()
    {
      public void run()
      {
        zzx.zza(zzx.this, paramString);
      }
    });
  }
  
  class zza
    extends SQLiteOpenHelper
  {
    zza(Context paramContext, String paramString)
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
      //   4: ldc 22
      //   6: iconst_1
      //   7: anewarray 24	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 26
      //   14: aastore
      //   15: ldc 28
      //   17: iconst_1
      //   18: anewarray 24	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 34	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface 40 1 0
      //   38: istore 4
      //   40: iload 4
      //   42: istore_3
      //   43: aload_2
      //   44: ifnull +12 -> 56
      //   47: aload_2
      //   48: invokeinterface 44 1 0
      //   53: iload 4
      //   55: istore_3
      //   56: iload_3
      //   57: ireturn
      //   58: astore_2
      //   59: aconst_null
      //   60: astore_2
      //   61: aload_1
      //   62: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   65: astore_1
      //   66: aload_1
      //   67: invokevirtual 52	java/lang/String:length	()I
      //   70: ifeq +29 -> 99
      //   73: ldc 54
      //   75: aload_1
      //   76: invokevirtual 58	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   79: astore_1
      //   80: aload_1
      //   81: invokestatic 64	com/google/android/gms/tagmanager/zzbo:zzdi	(Ljava/lang/String;)V
      //   84: aload_2
      //   85: ifnull +9 -> 94
      //   88: aload_2
      //   89: invokeinterface 44 1 0
      //   94: iconst_0
      //   95: istore_3
      //   96: goto -40 -> 56
      //   99: new 24	java/lang/String
      //   102: dup
      //   103: ldc 54
      //   105: invokespecial 66	java/lang/String:<init>	(Ljava/lang/String;)V
      //   108: astore_1
      //   109: goto -29 -> 80
      //   112: astore_1
      //   113: aload_2
      //   114: ifnull +9 -> 123
      //   117: aload_2
      //   118: invokeinterface 44 1 0
      //   123: aload_1
      //   124: athrow
      //   125: astore_1
      //   126: aload 5
      //   128: astore_2
      //   129: goto -16 -> 113
      //   132: astore_1
      //   133: goto -20 -> 113
      //   136: astore 5
      //   138: goto -77 -> 61
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	141	0	this	zza
      //   0	141	1	paramString	String
      //   0	141	2	paramSQLiteDatabase	SQLiteDatabase
      //   42	54	3	bool1	boolean
      //   38	16	4	bool2	boolean
      //   1	126	5	localObject	Object
      //   136	1	5	localSQLiteException	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   3	32	58	android/database/sqlite/SQLiteException
      //   61	80	112	finally
      //   80	84	112	finally
      //   99	109	112	finally
      //   3	32	125	finally
      //   32	40	132	finally
      //   32	40	136	android/database/sqlite/SQLiteException
    }
    
    private void zzc(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = paramSQLiteDatabase.getColumnNames();
        for (int i = 0; i < arrayOfString.length; i++) {
          localHashSet.add(arrayOfString[i]);
        }
        paramSQLiteDatabase.close();
        if ((!localHashSet.remove("key")) || (!localHashSet.remove("value")) || (!localHashSet.remove("ID")) || (!localHashSet.remove("expires"))) {
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
      Object localObject1 = null;
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
          zzx.zzb(zzx.this).getDatabasePath("google_tagmanager.db").delete();
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getWritableDatabase();
      }
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
          if (!zza("datalayer", paramSQLiteDatabase))
          {
            paramSQLiteDatabase.execSQL(zzx.zzcey());
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
  
  private static class zzb
  {
    final byte[] aEY;
    final String zzbcn;
    
    zzb(String paramString, byte[] paramArrayOfByte)
    {
      this.zzbcn = paramString;
      this.aEY = paramArrayOfByte;
    }
    
    public String toString()
    {
      String str = this.zzbcn;
      int i = Arrays.hashCode(this.aEY);
      return String.valueOf(str).length() + 54 + "KeyAndSerialized: key = " + str + " serialized hash = " + i;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */