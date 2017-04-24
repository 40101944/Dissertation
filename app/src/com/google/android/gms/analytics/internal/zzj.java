package com.google.android.gms.analytics.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzn;
import java.io.Closeable;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj
  extends zzd
  implements Closeable
{
  private static final String dw = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] { "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id" });
  private static final String dx = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[] { "hit_time", "hits2" });
  private final zzal dA = new zzal(zzabz());
  private final zza dy;
  private final zzal dz = new zzal(zzabz());
  
  zzj(zzf paramzzf)
  {
    super(paramzzf);
    String str = zzade();
    this.dy = new zza(paramzzf.getContext(), str);
  }
  
  /* Error */
  private long zza(String paramString, String[] paramArrayOfString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 87	com/google/android/gms/analytics/internal/zzj:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: aload 9
    //   14: aload_1
    //   15: aload_2
    //   16: invokevirtual 93	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_2
    //   20: aload_2
    //   21: astore 7
    //   23: aload_2
    //   24: astore 8
    //   26: aload_2
    //   27: invokeinterface 99 1 0
    //   32: ifeq +36 -> 68
    //   35: aload_2
    //   36: astore 7
    //   38: aload_2
    //   39: astore 8
    //   41: aload_2
    //   42: iconst_0
    //   43: invokeinterface 103 2 0
    //   48: lstore_3
    //   49: lload_3
    //   50: lstore 5
    //   52: aload_2
    //   53: ifnull +12 -> 65
    //   56: aload_2
    //   57: invokeinterface 106 1 0
    //   62: lload_3
    //   63: lstore 5
    //   65: lload 5
    //   67: lreturn
    //   68: lload_3
    //   69: lstore 5
    //   71: aload_2
    //   72: ifnull -7 -> 65
    //   75: aload_2
    //   76: invokeinterface 106 1 0
    //   81: lload_3
    //   82: lstore 5
    //   84: goto -19 -> 65
    //   87: astore_2
    //   88: aload 7
    //   90: astore 8
    //   92: aload_0
    //   93: ldc 108
    //   95: aload_1
    //   96: aload_2
    //   97: invokevirtual 112	com/google/android/gms/analytics/internal/zzj:zzd	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   100: aload 7
    //   102: astore 8
    //   104: aload_2
    //   105: athrow
    //   106: astore_1
    //   107: aload 8
    //   109: ifnull +10 -> 119
    //   112: aload 8
    //   114: invokeinterface 106 1 0
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	zzj
    //   0	121	1	paramString	String
    //   0	121	2	paramArrayOfString	String[]
    //   0	121	3	paramLong	long
    //   50	33	5	l	long
    //   10	91	7	arrayOfString	String[]
    //   7	106	8	localObject	Object
    //   4	9	9	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   12	20	87	android/database/sqlite/SQLiteException
    //   26	35	87	android/database/sqlite/SQLiteException
    //   41	49	87	android/database/sqlite/SQLiteException
    //   12	20	106	finally
    //   26	35	106	finally
    //   41	49	106	finally
    //   92	100	106	finally
    //   104	106	106	finally
  }
  
  private void zzadd()
  {
    int i = zzacb().zzafc();
    long l = zzacu();
    if (l > i - 1)
    {
      List localList = zzs(l - i + 1L);
      zzd("Store full, deleting hits to make room, count", Integer.valueOf(localList.size()));
      zzr(localList);
    }
  }
  
  private String zzade()
  {
    zzacb();
    return zzacb().zzafe();
  }
  
  private static String zzas(Map<String, String> paramMap)
  {
    zzaa.zzy(paramMap);
    Object localObject = new Uri.Builder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      ((Uri.Builder)localObject).appendQueryParameter((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localObject = ((Uri.Builder)localObject).build().getEncodedQuery();
    paramMap = (Map<String, String>)localObject;
    if (localObject == null) {
      paramMap = "";
    }
    return paramMap;
  }
  
  private long zzb(String paramString, String[] paramArrayOfString)
  {
    Object localObject2 = getWritableDatabase();
    Object localObject1 = null;
    String[] arrayOfString = null;
    try
    {
      paramArrayOfString = ((SQLiteDatabase)localObject2).rawQuery(paramString, paramArrayOfString);
      arrayOfString = paramArrayOfString;
      localObject1 = paramArrayOfString;
      if (paramArrayOfString.moveToFirst())
      {
        arrayOfString = paramArrayOfString;
        localObject1 = paramArrayOfString;
        long l = paramArrayOfString.getLong(0);
        if (paramArrayOfString != null) {
          paramArrayOfString.close();
        }
        return l;
      }
      arrayOfString = paramArrayOfString;
      localObject1 = paramArrayOfString;
      localObject2 = new android/database/sqlite/SQLiteException;
      arrayOfString = paramArrayOfString;
      localObject1 = paramArrayOfString;
      ((SQLiteException)localObject2).<init>("Database returned empty set");
      arrayOfString = paramArrayOfString;
      localObject1 = paramArrayOfString;
      throw ((Throwable)localObject2);
    }
    catch (SQLiteException paramArrayOfString)
    {
      localObject1 = arrayOfString;
      zzd("Database error", paramString, paramArrayOfString);
      localObject1 = arrayOfString;
      throw paramArrayOfString;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
  }
  
  private String zzd(zzab paramzzab)
  {
    if (paramzzab.zzagc()) {}
    for (paramzzab = zzacb().zzaes();; paramzzab = zzacb().zzaet()) {
      return paramzzab;
    }
  }
  
  private static String zze(zzab paramzzab)
  {
    zzaa.zzy(paramzzab);
    Object localObject = new Uri.Builder();
    Iterator localIterator = paramzzab.zzmc().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramzzab = (String)localEntry.getKey();
      if ((!"ht".equals(paramzzab)) && (!"qt".equals(paramzzab)) && (!"AppUID".equals(paramzzab))) {
        ((Uri.Builder)localObject).appendQueryParameter(paramzzab, (String)localEntry.getValue());
      }
    }
    localObject = ((Uri.Builder)localObject).build().getEncodedQuery();
    paramzzab = (zzab)localObject;
    if (localObject == null) {
      paramzzab = "";
    }
    return paramzzab;
  }
  
  public void beginTransaction()
  {
    zzacj();
    getWritableDatabase().beginTransaction();
  }
  
  public void close()
  {
    try
    {
      this.dy.close();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zze("Sql error closing database", localSQLiteException);
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        zze("Error closing database", localIllegalStateException);
      }
    }
  }
  
  public void endTransaction()
  {
    zzacj();
    getWritableDatabase().endTransaction();
  }
  
  SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.dy.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzd("Error opening database", localSQLiteException);
      throw localSQLiteException;
    }
  }
  
  boolean isEmpty()
  {
    if (zzacu() == 0L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void setTransactionSuccessful()
  {
    zzacj();
    getWritableDatabase().setTransactionSuccessful();
  }
  
  public long zza(long paramLong, String paramString1, String paramString2)
  {
    zzaa.zzib(paramString1);
    zzaa.zzib(paramString2);
    zzacj();
    zzzx();
    return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[] { String.valueOf(paramLong), paramString1, paramString2 }, 0L);
  }
  
  public void zza(long paramLong, String paramString)
  {
    zzaa.zzib(paramString);
    zzacj();
    zzzx();
    int i = getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[] { String.valueOf(paramLong), paramString });
    if (i > 0) {
      zza("Deleted property records", Integer.valueOf(i));
    }
  }
  
  public long zzacu()
  {
    zzzx();
    zzacj();
    return zzb("SELECT COUNT(*) FROM hits2", null);
  }
  
  public void zzacz()
  {
    zzzx();
    zzacj();
    getWritableDatabase().delete("hits2", null, null);
  }
  
  public void zzada()
  {
    zzzx();
    zzacj();
    getWritableDatabase().delete("properties", null, null);
  }
  
  public int zzadb()
  {
    int i = 0;
    zzzx();
    zzacj();
    if (!this.dz.zzz(86400000L)) {}
    for (;;)
    {
      return i;
      this.dz.start();
      zzes("Deleting stale hits (if any)");
      i = getWritableDatabase().delete("hits2", "hit_time < ?", new String[] { Long.toString(zzabz().currentTimeMillis() - 2592000000L) });
      zza("Deleted stale hits, count", Integer.valueOf(i));
    }
  }
  
  public long zzadc()
  {
    zzzx();
    zzacj();
    return zza(dx, null, 0L);
  }
  
  public void zzb(zzh paramzzh)
  {
    zzaa.zzy(paramzzh);
    zzacj();
    zzzx();
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    String str = zzas(paramzzh.zzmc());
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("app_uid", Long.valueOf(paramzzh.zzacr()));
    localContentValues.put("cid", paramzzh.zzze());
    localContentValues.put("tid", paramzzh.zzacs());
    int i;
    if (paramzzh.zzact()) {
      i = 1;
    }
    for (;;)
    {
      localContentValues.put("adid", Integer.valueOf(i));
      localContentValues.put("hits_count", Long.valueOf(paramzzh.zzacu()));
      localContentValues.put("params", str);
      try
      {
        if (localSQLiteDatabase.insertWithOnConflict("properties", null, localContentValues, 5) == -1L) {
          zzew("Failed to insert/update a property (got -1)");
        }
        return;
        i = 0;
      }
      catch (SQLiteException paramzzh)
      {
        for (;;)
        {
          zze("Error storing a property", paramzzh);
        }
      }
    }
  }
  
  public void zzc(zzab paramzzab)
  {
    zzaa.zzy(paramzzab);
    zzzx();
    zzacj();
    String str = zze(paramzzab);
    if (str.length() > 8192) {
      zzaca().zza(paramzzab, "Hit length exceeds the maximum allowed size");
    }
    for (;;)
    {
      return;
      zzadd();
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("hit_string", str);
      localContentValues.put("hit_time", Long.valueOf(paramzzab.zzaga()));
      localContentValues.put("hit_app_id", Integer.valueOf(paramzzab.zzafy()));
      localContentValues.put("hit_url", zzd(paramzzab));
      long l;
      try
      {
        l = localSQLiteDatabase.insert("hits2", null, localContentValues);
        if (l != -1L) {
          break label151;
        }
        zzew("Failed to insert a hit (got -1)");
      }
      catch (SQLiteException paramzzab)
      {
        zze("Error storing a hit", paramzzab);
      }
      continue;
      label151:
      zzb("Hit saved to database. db-id, hit", Long.valueOf(l), paramzzab);
    }
  }
  
  Map<String, String> zzex(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = new HashMap(0);
    }
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.startsWith("?")) {}
        for (;;)
        {
          URI localURI = new java/net/URI;
          localURI.<init>(paramString);
          paramString = zzn.zza(localURI, "UTF-8");
          break;
          paramString = String.valueOf(paramString);
          if (paramString.length() != 0) {
            paramString = "?".concat(paramString);
          } else {
            paramString = new String("?");
          }
        }
      }
      catch (URISyntaxException paramString)
      {
        zze("Error parsing hit parameters", paramString);
        paramString = new HashMap(0);
      }
    }
  }
  
  Map<String, String> zzey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = new HashMap(0);
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {}
        for (paramString = "?".concat(paramString);; paramString = new String("?"))
        {
          URI localURI = new java/net/URI;
          localURI.<init>(paramString);
          paramString = zzn.zza(localURI, "UTF-8");
          break;
        }
      }
      catch (URISyntaxException paramString)
      {
        zze("Error parsing property parameters", paramString);
        paramString = new HashMap(0);
      }
    }
  }
  
  public void zzr(List<Long> paramList)
  {
    zzaa.zzy(paramList);
    zzzx();
    zzacj();
    if (paramList.isEmpty()) {}
    for (;;)
    {
      return;
      Object localObject2 = new StringBuilder("hit_id");
      ((StringBuilder)localObject2).append(" in (");
      Object localObject1;
      for (int i = 0; i < paramList.size(); i++)
      {
        localObject1 = (Long)paramList.get(i);
        if ((localObject1 == null) || (((Long)localObject1).longValue() == 0L)) {
          throw new SQLiteException("Invalid hit id");
        }
        if (i > 0) {
          ((StringBuilder)localObject2).append(",");
        }
        ((StringBuilder)localObject2).append(localObject1);
      }
      ((StringBuilder)localObject2).append(")");
      localObject2 = ((StringBuilder)localObject2).toString();
      try
      {
        localObject1 = getWritableDatabase();
        zza("Deleting dispatched hits. count", Integer.valueOf(paramList.size()));
        i = ((SQLiteDatabase)localObject1).delete("hits2", (String)localObject2, null);
        if (i == paramList.size()) {
          continue;
        }
        zzb("Deleted fewer hits then expected", Integer.valueOf(paramList.size()), Integer.valueOf(i), localObject2);
      }
      catch (SQLiteException paramList)
      {
        zze("Error deleting hits", paramList);
        throw paramList;
      }
    }
  }
  
  /* Error */
  public List<Long> zzs(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 282	com/google/android/gms/analytics/internal/zzj:zzzx	()V
    //   7: aload_0
    //   8: invokevirtual 253	com/google/android/gms/analytics/internal/zzj:zzacj	()V
    //   11: lload_1
    //   12: lconst_0
    //   13: lcmp
    //   14: ifgt +11 -> 25
    //   17: invokestatic 528	java/util/Collections:emptyList	()Ljava/util/List;
    //   20: astore 4
    //   22: aload 4
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 87	com/google/android/gms/analytics/internal/zzj:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 5
    //   31: new 530	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 531	java/util/ArrayList:<init>	()V
    //   38: astore 7
    //   40: ldc_w 533
    //   43: iconst_1
    //   44: anewarray 23	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: ldc 27
    //   51: aastore
    //   52: invokestatic 41	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   55: astore 4
    //   57: lload_1
    //   58: invokestatic 337	java/lang/Long:toString	(J)Ljava/lang/String;
    //   61: astore 8
    //   63: aload 5
    //   65: ldc 25
    //   67: iconst_1
    //   68: anewarray 37	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: ldc 27
    //   75: aastore
    //   76: aconst_null
    //   77: aconst_null
    //   78: aconst_null
    //   79: aconst_null
    //   80: aload 4
    //   82: aload 8
    //   84: invokevirtual 537	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore 5
    //   89: aload 5
    //   91: astore 4
    //   93: aload 5
    //   95: invokeinterface 99 1 0
    //   100: ifeq +42 -> 142
    //   103: aload 5
    //   105: astore 4
    //   107: aload 7
    //   109: aload 5
    //   111: iconst_0
    //   112: invokeinterface 103 2 0
    //   117: invokestatic 357	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: invokeinterface 540 2 0
    //   125: pop
    //   126: aload 5
    //   128: astore 4
    //   130: aload 5
    //   132: invokeinterface 543 1 0
    //   137: istore_3
    //   138: iload_3
    //   139: ifne -36 -> 103
    //   142: aload 5
    //   144: ifnull +10 -> 154
    //   147: aload 5
    //   149: invokeinterface 106 1 0
    //   154: aload 7
    //   156: astore 4
    //   158: goto -136 -> 22
    //   161: astore 6
    //   163: aconst_null
    //   164: astore 5
    //   166: aload 5
    //   168: astore 4
    //   170: aload_0
    //   171: ldc_w 545
    //   174: aload 6
    //   176: invokevirtual 148	com/google/android/gms/analytics/internal/zzj:zzd	(Ljava/lang/String;Ljava/lang/Object;)V
    //   179: aload 5
    //   181: ifnull -27 -> 154
    //   184: aload 5
    //   186: invokeinterface 106 1 0
    //   191: goto -37 -> 154
    //   194: astore 4
    //   196: aload 6
    //   198: ifnull +10 -> 208
    //   201: aload 6
    //   203: invokeinterface 106 1 0
    //   208: aload 4
    //   210: athrow
    //   211: astore 5
    //   213: aload 4
    //   215: astore 6
    //   217: aload 5
    //   219: astore 4
    //   221: goto -25 -> 196
    //   224: astore 6
    //   226: goto -60 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	zzj
    //   0	229	1	paramLong	long
    //   137	2	3	bool	boolean
    //   20	149	4	localObject1	Object
    //   194	20	4	localObject2	Object
    //   219	1	4	localObject3	Object
    //   29	156	5	localObject4	Object
    //   211	7	5	localObject5	Object
    //   1	1	6	localObject6	Object
    //   161	41	6	localSQLiteException1	SQLiteException
    //   215	1	6	localObject7	Object
    //   224	1	6	localSQLiteException2	SQLiteException
    //   38	117	7	localArrayList	ArrayList
    //   61	22	8	str	String
    // Exception table:
    //   from	to	target	type
    //   40	89	161	android/database/sqlite/SQLiteException
    //   40	89	194	finally
    //   93	103	211	finally
    //   107	126	211	finally
    //   130	138	211	finally
    //   170	179	211	finally
    //   93	103	224	android/database/sqlite/SQLiteException
    //   107	126	224	android/database/sqlite/SQLiteException
    //   130	138	224	android/database/sqlite/SQLiteException
  }
  
  public List<zzab> zzt(long paramLong)
  {
    boolean bool = true;
    Cursor localCursor2 = null;
    if (paramLong >= 0L) {}
    for (;;)
    {
      zzaa.zzbt(bool);
      zzzx();
      zzacj();
      Object localObject7 = getWritableDatabase();
      localCursor1 = localCursor2;
      for (;;)
      {
        Object localObject5;
        try
        {
          localObject6 = String.format("%s ASC", new Object[] { "hit_id" });
          localCursor1 = localCursor2;
          localObject5 = Long.toString(paramLong);
          localCursor1 = localCursor2;
          localCursor2 = ((SQLiteDatabase)localObject7).query("hits2", new String[] { "hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id" }, null, null, null, null, (String)localObject6, (String)localObject5);
          localCursor1 = localCursor2;
        }
        catch (SQLiteException localSQLiteException2)
        {
          Object localObject6;
          localCursor1 = null;
          try
          {
            zze("Error loading hits from the database", localSQLiteException2);
            throw localSQLiteException2;
          }
          finally
          {
            if (localCursor1 != null) {
              localCursor1.close();
            }
          }
        }
        finally
        {
          continue;
        }
        try
        {
          localObject5 = new java/util/ArrayList;
          localCursor1 = localCursor2;
          ((ArrayList)localObject5).<init>();
          localCursor1 = localCursor2;
          if (localCursor2.moveToFirst())
          {
            localCursor1 = localCursor2;
            long l = localCursor2.getLong(0);
            localCursor1 = localCursor2;
            paramLong = localCursor2.getLong(1);
            localCursor1 = localCursor2;
            localObject6 = localCursor2.getString(2);
            localCursor1 = localCursor2;
            localObject7 = localCursor2.getString(3);
            localCursor1 = localCursor2;
            int i = localCursor2.getInt(4);
            localCursor1 = localCursor2;
            localObject6 = zzex((String)localObject6);
            localCursor1 = localCursor2;
            bool = zzao.zzfn((String)localObject7);
            localCursor1 = localCursor2;
            localObject7 = new com/google/android/gms/analytics/internal/zzab;
            localCursor1 = localCursor2;
            ((zzab)localObject7).<init>(this, (Map)localObject6, paramLong, bool, l, i);
            localCursor1 = localCursor2;
            ((List)localObject5).add(localObject7);
            localCursor1 = localCursor2;
            bool = localCursor2.moveToNext();
            if (bool) {
              continue;
            }
          }
          if (localCursor2 != null) {
            localCursor2.close();
          }
          return (List<zzab>)localObject5;
        }
        catch (SQLiteException localSQLiteException1)
        {
          localObject5 = localObject3;
          Object localObject4 = localSQLiteException1;
          Object localObject1 = localObject5;
        }
      }
      bool = false;
    }
  }
  
  public void zzu(long paramLong)
  {
    zzzx();
    zzacj();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Long.valueOf(paramLong));
    zza("Deleting hit, id", Long.valueOf(paramLong));
    zzr(localArrayList);
  }
  
  /* Error */
  public List<zzh> zzv(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 253	com/google/android/gms/analytics/internal/zzj:zzacj	()V
    //   4: aload_0
    //   5: invokevirtual 282	com/google/android/gms/analytics/internal/zzj:zzzx	()V
    //   8: aload_0
    //   9: invokevirtual 87	com/google/android/gms/analytics/internal/zzj:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 9
    //   14: aconst_null
    //   15: astore 8
    //   17: aload 8
    //   19: astore 7
    //   21: aload_0
    //   22: invokevirtual 118	com/google/android/gms/analytics/internal/zzj:zzacb	()Lcom/google/android/gms/analytics/internal/zzr;
    //   25: invokevirtual 581	com/google/android/gms/analytics/internal/zzr:zzafd	()I
    //   28: istore_3
    //   29: aload 8
    //   31: astore 7
    //   33: aload 9
    //   35: ldc_w 292
    //   38: iconst_5
    //   39: anewarray 37	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc_w 363
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: ldc_w 371
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: ldc_w 379
    //   59: aastore
    //   60: dup
    //   61: iconst_3
    //   62: ldc_w 384
    //   65: aastore
    //   66: dup
    //   67: iconst_4
    //   68: ldc_w 387
    //   71: aastore
    //   72: ldc_w 583
    //   75: iconst_1
    //   76: anewarray 37	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: lload_1
    //   82: invokestatic 287	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: iload_3
    //   90: invokestatic 585	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   93: invokevirtual 537	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore 8
    //   98: aload 8
    //   100: astore 7
    //   102: new 530	java/util/ArrayList
    //   105: astore 10
    //   107: aload 8
    //   109: astore 7
    //   111: aload 10
    //   113: invokespecial 531	java/util/ArrayList:<init>	()V
    //   116: aload 8
    //   118: astore 7
    //   120: aload 8
    //   122: invokeinterface 99 1 0
    //   127: ifeq +135 -> 262
    //   130: aload 8
    //   132: astore 7
    //   134: aload 8
    //   136: iconst_0
    //   137: invokeinterface 555 2 0
    //   142: astore 13
    //   144: aload 8
    //   146: astore 7
    //   148: aload 8
    //   150: iconst_1
    //   151: invokeinterface 555 2 0
    //   156: astore 12
    //   158: aload 8
    //   160: astore 7
    //   162: aload 8
    //   164: iconst_2
    //   165: invokeinterface 559 2 0
    //   170: ifeq +133 -> 303
    //   173: iconst_1
    //   174: istore 6
    //   176: aload 8
    //   178: astore 7
    //   180: aload 8
    //   182: iconst_3
    //   183: invokeinterface 559 2 0
    //   188: i2l
    //   189: lstore 4
    //   191: aload 8
    //   193: astore 7
    //   195: aload_0
    //   196: aload 8
    //   198: iconst_4
    //   199: invokeinterface 555 2 0
    //   204: invokevirtual 587	com/google/android/gms/analytics/internal/zzj:zzey	(Ljava/lang/String;)Ljava/util/Map;
    //   207: astore 11
    //   209: aload 8
    //   211: astore 7
    //   213: aload 13
    //   215: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: ifne +15 -> 233
    //   221: aload 8
    //   223: astore 7
    //   225: aload 12
    //   227: invokestatic 449	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: ifeq +79 -> 309
    //   233: aload 8
    //   235: astore 7
    //   237: aload_0
    //   238: ldc_w 589
    //   241: aload 13
    //   243: aload 12
    //   245: invokevirtual 591	com/google/android/gms/analytics/internal/zzj:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   248: aload 8
    //   250: astore 7
    //   252: aload 8
    //   254: invokeinterface 543 1 0
    //   259: ifne -129 -> 130
    //   262: aload 8
    //   264: astore 7
    //   266: aload 10
    //   268: invokeinterface 139 1 0
    //   273: iload_3
    //   274: if_icmplt +14 -> 288
    //   277: aload 8
    //   279: astore 7
    //   281: aload_0
    //   282: ldc_w 593
    //   285: invokevirtual 596	com/google/android/gms/analytics/internal/zzj:zzev	(Ljava/lang/String;)V
    //   288: aload 8
    //   290: ifnull +10 -> 300
    //   293: aload 8
    //   295: invokeinterface 106 1 0
    //   300: aload 10
    //   302: areturn
    //   303: iconst_0
    //   304: istore 6
    //   306: goto -130 -> 176
    //   309: aload 8
    //   311: astore 7
    //   313: new 343	com/google/android/gms/analytics/internal/zzh
    //   316: astore 9
    //   318: aload 8
    //   320: astore 7
    //   322: aload 9
    //   324: lload_1
    //   325: aload 13
    //   327: aload 12
    //   329: iload 6
    //   331: lload 4
    //   333: aload 11
    //   335: invokespecial 599	com/google/android/gms/analytics/internal/zzh:<init>	(JLjava/lang/String;Ljava/lang/String;ZJLjava/util/Map;)V
    //   338: aload 8
    //   340: astore 7
    //   342: aload 10
    //   344: aload 9
    //   346: invokeinterface 540 2 0
    //   351: pop
    //   352: goto -104 -> 248
    //   355: astore 9
    //   357: aload 8
    //   359: astore 7
    //   361: aload_0
    //   362: ldc_w 571
    //   365: aload 9
    //   367: invokevirtual 262	com/google/android/gms/analytics/internal/zzj:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   370: aload 9
    //   372: athrow
    //   373: astore 8
    //   375: aload 7
    //   377: ifnull +10 -> 387
    //   380: aload 7
    //   382: invokeinterface 106 1 0
    //   387: aload 8
    //   389: athrow
    //   390: astore 8
    //   392: goto -17 -> 375
    //   395: astore 9
    //   397: aconst_null
    //   398: astore 7
    //   400: goto -39 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	zzj
    //   0	403	1	paramLong	long
    //   28	247	3	i	int
    //   189	143	4	l	long
    //   174	156	6	bool	boolean
    //   19	380	7	localCursor1	Cursor
    //   15	343	8	localCursor2	Cursor
    //   373	15	8	localObject1	Object
    //   390	1	8	localObject2	Object
    //   12	333	9	localObject3	Object
    //   355	16	9	localSQLiteException1	SQLiteException
    //   395	1	9	localSQLiteException2	SQLiteException
    //   105	238	10	localArrayList	ArrayList
    //   207	127	11	localMap	Map
    //   156	172	12	str1	String
    //   142	184	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   102	107	355	android/database/sqlite/SQLiteException
    //   111	116	355	android/database/sqlite/SQLiteException
    //   120	130	355	android/database/sqlite/SQLiteException
    //   134	144	355	android/database/sqlite/SQLiteException
    //   148	158	355	android/database/sqlite/SQLiteException
    //   162	173	355	android/database/sqlite/SQLiteException
    //   180	191	355	android/database/sqlite/SQLiteException
    //   195	209	355	android/database/sqlite/SQLiteException
    //   213	221	355	android/database/sqlite/SQLiteException
    //   225	233	355	android/database/sqlite/SQLiteException
    //   237	248	355	android/database/sqlite/SQLiteException
    //   252	262	355	android/database/sqlite/SQLiteException
    //   266	277	355	android/database/sqlite/SQLiteException
    //   281	288	355	android/database/sqlite/SQLiteException
    //   313	318	355	android/database/sqlite/SQLiteException
    //   322	338	355	android/database/sqlite/SQLiteException
    //   342	352	355	android/database/sqlite/SQLiteException
    //   361	373	373	finally
    //   21	29	390	finally
    //   33	98	390	finally
    //   102	107	390	finally
    //   111	116	390	finally
    //   120	130	390	finally
    //   134	144	390	finally
    //   148	158	390	finally
    //   162	173	390	finally
    //   180	191	390	finally
    //   195	209	390	finally
    //   213	221	390	finally
    //   225	233	390	finally
    //   237	248	390	finally
    //   252	262	390	finally
    //   266	277	390	finally
    //   281	288	390	finally
    //   313	318	390	finally
    //   322	338	390	finally
    //   342	352	390	finally
    //   21	29	395	android/database/sqlite/SQLiteException
    //   33	98	395	android/database/sqlite/SQLiteException
  }
  
  protected void zzzy() {}
  
  class zza
    extends SQLiteOpenHelper
  {
    zza(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void zza(SQLiteDatabase paramSQLiteDatabase)
    {
      int j = 1;
      Set localSet = zzb(paramSQLiteDatabase, "hits2");
      for (int i = 0; i < 4; i++)
      {
        String str = new String[] { "hit_id", "hit_string", "hit_time", "hit_url" }[i];
        if (!localSet.remove(str))
        {
          paramSQLiteDatabase = String.valueOf(str);
          if (paramSQLiteDatabase.length() != 0) {}
          for (paramSQLiteDatabase = "Database hits2 is missing required column: ".concat(paramSQLiteDatabase);; paramSQLiteDatabase = new String("Database hits2 is missing required column: ")) {
            throw new SQLiteException(paramSQLiteDatabase);
          }
        }
      }
      if (!localSet.remove("hit_app_id")) {}
      for (i = j; !localSet.isEmpty(); i = 0) {
        throw new SQLiteException("Database hits2 has extra columns");
      }
      if (i != 0) {
        paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
      }
    }
    
    /* Error */
    private boolean zza(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aload_1
      //   4: ldc 78
      //   6: iconst_1
      //   7: anewarray 26	java/lang/String
      //   10: dup
      //   11: iconst_0
      //   12: ldc 80
      //   14: aastore
      //   15: ldc 82
      //   17: iconst_1
      //   18: anewarray 26	java/lang/String
      //   21: dup
      //   22: iconst_0
      //   23: aload_2
      //   24: aastore
      //   25: aconst_null
      //   26: aconst_null
      //   27: aconst_null
      //   28: invokevirtual 86	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   31: astore_1
      //   32: aload_1
      //   33: astore 5
      //   35: aload 5
      //   37: astore_1
      //   38: aload 5
      //   40: invokeinterface 91 1 0
      //   45: istore_3
      //   46: iload_3
      //   47: istore 4
      //   49: aload 5
      //   51: ifnull +13 -> 64
      //   54: aload 5
      //   56: invokeinterface 95 1 0
      //   61: iload_3
      //   62: istore 4
      //   64: iload 4
      //   66: ireturn
      //   67: astore 6
      //   69: aconst_null
      //   70: astore 5
      //   72: aload 5
      //   74: astore_1
      //   75: aload_0
      //   76: getfield 13	com/google/android/gms/analytics/internal/zzj$zza:dB	Lcom/google/android/gms/analytics/internal/zzj;
      //   79: ldc 97
      //   81: aload_2
      //   82: aload 6
      //   84: invokevirtual 101	com/google/android/gms/analytics/internal/zzj:zzc	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
      //   87: aload 5
      //   89: ifnull +10 -> 99
      //   92: aload 5
      //   94: invokeinterface 95 1 0
      //   99: iconst_0
      //   100: istore 4
      //   102: goto -38 -> 64
      //   105: astore_2
      //   106: aload 5
      //   108: astore_1
      //   109: aload_1
      //   110: ifnull +9 -> 119
      //   113: aload_1
      //   114: invokeinterface 95 1 0
      //   119: aload_2
      //   120: athrow
      //   121: astore_2
      //   122: goto -13 -> 109
      //   125: astore 6
      //   127: goto -55 -> 72
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	130	0	this	zza
      //   0	130	1	paramSQLiteDatabase	SQLiteDatabase
      //   0	130	2	paramString	String
      //   45	17	3	bool1	boolean
      //   47	54	4	bool2	boolean
      //   1	106	5	localSQLiteDatabase	SQLiteDatabase
      //   67	16	6	localSQLiteException1	SQLiteException
      //   125	1	6	localSQLiteException2	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   3	32	67	android/database/sqlite/SQLiteException
      //   3	32	105	finally
      //   38	46	121	finally
      //   75	87	121	finally
      //   38	46	125	android/database/sqlite/SQLiteException
    }
    
    private Set<String> zzb(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      HashSet localHashSet = new HashSet();
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(String.valueOf(paramString).length() + 22 + "SELECT * FROM " + paramString + " LIMIT 0", null);
      try
      {
        paramString = paramSQLiteDatabase.getColumnNames();
        for (int i = 0; i < paramString.length; i++) {
          localHashSet.add(paramString[i]);
        }
        return localHashSet;
      }
      finally
      {
        paramSQLiteDatabase.close();
      }
    }
    
    private void zzb(SQLiteDatabase paramSQLiteDatabase)
    {
      int i = 0;
      paramSQLiteDatabase = zzb(paramSQLiteDatabase, "properties");
      while (i < 6)
      {
        String str = new String[] { "app_uid", "cid", "tid", "params", "adid", "hits_count" }[i];
        if (!paramSQLiteDatabase.remove(str))
        {
          paramSQLiteDatabase = String.valueOf(str);
          if (paramSQLiteDatabase.length() != 0) {}
          for (paramSQLiteDatabase = "Database properties is missing required column: ".concat(paramSQLiteDatabase);; paramSQLiteDatabase = new String("Database properties is missing required column: ")) {
            throw new SQLiteException(paramSQLiteDatabase);
          }
        }
        i++;
      }
      if (!paramSQLiteDatabase.isEmpty()) {
        throw new SQLiteException("Database properties table has extra columns");
      }
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      if (!zzj.zza(zzj.this).zzz(3600000L)) {
        throw new SQLiteException("Database open failed");
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
        return localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException1)
      {
        for (;;)
        {
          zzj.zza(zzj.this).start();
          zzj.this.zzew("Opening the database failed, dropping the table and recreating it");
          Object localObject = zzj.zzb(zzj.this);
          zzj.this.getContext().getDatabasePath((String)localObject).delete();
          try
          {
            localObject = super.getWritableDatabase();
            zzj.zza(zzj.this).clear();
          }
          catch (SQLiteException localSQLiteException2)
          {
            zzj.this.zze("Failed to open freshly created database", localSQLiteException2);
            throw localSQLiteException2;
          }
        }
      }
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      zzx.zzfd(paramSQLiteDatabase.getPath());
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
          if (!zza(paramSQLiteDatabase, "hits2"))
          {
            paramSQLiteDatabase.execSQL(zzj.zzadf());
            if (zza(paramSQLiteDatabase, "properties")) {
              break label80;
            }
            paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
            return;
          }
        }
        finally
        {
          localCursor.close();
        }
        zza(paramSQLiteDatabase);
        continue;
        label80:
        zzb(paramSQLiteDatabase);
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */