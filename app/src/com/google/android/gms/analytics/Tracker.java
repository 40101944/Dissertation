package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zza;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzap;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzms;
import com.google.android.gms.internal.zzmx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Tracker
  extends zzd
{
  private boolean bu;
  private final Map<String, String> bv = new HashMap();
  private final zzad bw;
  private final zza bx;
  private ExceptionReporter by;
  private zzan bz;
  private final Map<String, String> zzbly = new HashMap();
  
  Tracker(zzf paramzzf, String paramString, zzad paramzzad)
  {
    super(paramzzf);
    if (paramString != null) {
      this.zzbly.put("&tid", paramString);
    }
    this.zzbly.put("useSecure", "1");
    this.zzbly.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
    if (paramzzad == null) {}
    for (this.bw = new zzad("tracking", zzabz());; this.bw = paramzzad)
    {
      this.bx = new zza(paramzzf);
      return;
    }
  }
  
  private static boolean zza(Map.Entry<String, String> paramEntry)
  {
    String str = (String)paramEntry.getKey();
    paramEntry = (String)paramEntry.getValue();
    if ((!str.startsWith("&")) || (str.length() < 2)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private static String zzb(Map.Entry<String, String> paramEntry)
  {
    if (!zza(paramEntry)) {}
    for (paramEntry = null;; paramEntry = ((String)paramEntry.getKey()).substring(1)) {
      return paramEntry;
    }
  }
  
  private static void zzb(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    zzaa.zzy(paramMap2);
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramMap1.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramMap1 = zzb(localEntry);
        if (paramMap1 != null) {
          paramMap2.put(paramMap1, (String)localEntry.getValue());
        }
      }
    }
  }
  
  private static void zzc(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    zzaa.zzy(paramMap2);
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap1.next();
        String str = zzb(localEntry);
        if ((str != null) && (!paramMap2.containsKey(str))) {
          paramMap2.put(str, (String)localEntry.getValue());
        }
      }
    }
  }
  
  static String zzq(Activity paramActivity)
  {
    Object localObject = null;
    zzaa.zzy(paramActivity);
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {
      paramActivity = (Activity)localObject;
    }
    for (;;)
    {
      return paramActivity;
      String str = paramActivity.getStringExtra("android.intent.extra.REFERRER_NAME");
      paramActivity = (Activity)localObject;
      if (!TextUtils.isEmpty(str)) {
        paramActivity = str;
      }
    }
  }
  
  private boolean zzzz()
  {
    if (this.by != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    this.bu = paramBoolean;
  }
  
  public void enableAutoActivityTracking(boolean paramBoolean)
  {
    this.bx.enableAutoActivityTracking(paramBoolean);
  }
  
  public void enableExceptionReporting(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (zzzz() == paramBoolean) {
          return;
        }
        if (paramBoolean)
        {
          Context localContext = getContext();
          Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
          ExceptionReporter localExceptionReporter = new com/google/android/gms/analytics/ExceptionReporter;
          localExceptionReporter.<init>(this, localUncaughtExceptionHandler, localContext);
          this.by = localExceptionReporter;
          Thread.setDefaultUncaughtExceptionHandler(this.by);
          zzes("Uncaught exceptions will be reported to Google Analytics");
          continue;
        }
        Thread.setDefaultUncaughtExceptionHandler(this.by.zzzb());
      }
      finally {}
      zzes("Uncaught exceptions will not be reported to Google Analytics");
    }
  }
  
  public String get(String paramString)
  {
    String str = null;
    zzacj();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return str;
      if (this.zzbly.containsKey(paramString)) {
        str = (String)this.zzbly.get(paramString);
      } else if (paramString.equals("&ul")) {
        str = zzao.zza(Locale.getDefault());
      } else if (paramString.equals("&cid")) {
        str = zzacf().zzady();
      } else if (paramString.equals("&sr")) {
        str = zzaci().zzafm();
      } else if (paramString.equals("&aid")) {
        str = zzach().zzadg().zzup();
      } else if (paramString.equals("&an")) {
        str = zzach().zzadg().zzaae();
      } else if (paramString.equals("&av")) {
        str = zzach().zzadg().zzaaf();
      } else if (paramString.equals("&aiid")) {
        str = zzach().zzadg().zzaag();
      }
    }
  }
  
  public void send(final Map<String, String> paramMap)
  {
    final long l = zzabz().currentTimeMillis();
    if (zzza().getAppOptOut()) {
      zzet("AppOptOut is set to true. Not sending Google Analytics hit");
    }
    for (;;)
    {
      return;
      boolean bool2 = zzza().isDryRunEnabled();
      final HashMap localHashMap = new HashMap();
      zzb(this.zzbly, localHashMap);
      zzb(paramMap, localHashMap);
      final boolean bool1 = zzao.zzg((String)this.zzbly.get("useSecure"), true);
      zzc(this.bv, localHashMap);
      this.bv.clear();
      final String str = (String)localHashMap.get("t");
      if (TextUtils.isEmpty(str))
      {
        zzaca().zzh(localHashMap, "Missing hit type parameter");
        continue;
      }
      paramMap = (String)localHashMap.get("tid");
      if (TextUtils.isEmpty(paramMap))
      {
        zzaca().zzh(localHashMap, "Missing tracking id parameter");
        continue;
      }
      final boolean bool3 = zzaaa();
      try
      {
        if (("screenview".equalsIgnoreCase(str)) || ("pageview".equalsIgnoreCase(str)) || ("appview".equalsIgnoreCase(str)) || (TextUtils.isEmpty(str)))
        {
          int j = Integer.parseInt((String)this.zzbly.get("&a")) + 1;
          int i = j;
          if (j >= Integer.MAX_VALUE) {
            i = 1;
          }
          this.zzbly.put("&a", Integer.toString(i));
        }
        zzacc().zzg(new Runnable()
        {
          public void run()
          {
            boolean bool = true;
            if (Tracker.zza(Tracker.this).zzaab()) {
              localHashMap.put("sc", "start");
            }
            zzao.zzd(localHashMap, "cid", Tracker.this.zzza().zzze());
            Object localObject = (String)localHashMap.get("sf");
            if (localObject != null)
            {
              double d = zzao.zza((String)localObject, 100.0D);
              if (zzao.zza(d, (String)localHashMap.get("cid"))) {
                Tracker.this.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d));
              }
            }
            label158:
            label385:
            label390:
            long l2;
            long l1;
            for (;;)
            {
              return;
              localObject = Tracker.zzb(Tracker.this);
              if (bool3)
              {
                zzao.zzb(localHashMap, "ate", ((zza)localObject).zzabc());
                zzao.zzc(localHashMap, "adid", ((zza)localObject).zzabn());
                localObject = Tracker.zzc(Tracker.this).zzadg();
                zzao.zzc(localHashMap, "an", ((zzms)localObject).zzaae());
                zzao.zzc(localHashMap, "av", ((zzms)localObject).zzaaf());
                zzao.zzc(localHashMap, "aid", ((zzms)localObject).zzup());
                zzao.zzc(localHashMap, "aiid", ((zzms)localObject).zzaag());
                localHashMap.put("v", "1");
                localHashMap.put("_v", com.google.android.gms.analytics.internal.zze.cS);
                zzao.zzc(localHashMap, "ul", Tracker.zzd(Tracker.this).zzafl().getLanguage());
                zzao.zzc(localHashMap, "sr", Tracker.zze(Tracker.this).zzafm());
                if ((!str.equals("transaction")) && (!str.equals("item"))) {
                  break label385;
                }
              }
              for (int i = 1;; i = 0)
              {
                if ((i != 0) || (Tracker.zzf(Tracker.this).zzagf())) {
                  break label390;
                }
                Tracker.zzg(Tracker.this).zzh(localHashMap, "Too many hits sent too quickly, rate limiting invoked");
                break;
                localHashMap.remove("ate");
                localHashMap.remove("adid");
                break label158;
              }
              l2 = zzao.zzfj((String)localHashMap.get("ht"));
              l1 = l2;
              if (l2 == 0L) {
                l1 = l;
              }
              if (!bool1) {
                break;
              }
              localObject = new zzab(Tracker.this, localHashMap, l1, paramMap);
              Tracker.zzh(Tracker.this).zzc("Dry run enabled. Would have sent hit", localObject);
            }
            localObject = (String)localHashMap.get("cid");
            HashMap localHashMap = new HashMap();
            zzao.zza(localHashMap, "uid", localHashMap);
            zzao.zza(localHashMap, "an", localHashMap);
            zzao.zza(localHashMap, "aid", localHashMap);
            zzao.zza(localHashMap, "av", localHashMap);
            zzao.zza(localHashMap, "aiid", localHashMap);
            String str = this.bG;
            if (!TextUtils.isEmpty((CharSequence)localHashMap.get("adid"))) {}
            for (;;)
            {
              localObject = new zzh(0L, (String)localObject, str, bool, 0L, localHashMap);
              l2 = Tracker.zzi(Tracker.this).zza((zzh)localObject);
              localHashMap.put("_s", String.valueOf(l2));
              localObject = new zzab(Tracker.this, localHashMap, l1, paramMap);
              Tracker.zzj(Tracker.this).zza((zzab)localObject);
              break;
              bool = false;
            }
          }
        });
      }
      finally {}
    }
  }
  
  public void set(String paramString1, String paramString2)
  {
    zzaa.zzb(paramString1, "Key should be non-null");
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      this.zzbly.put(paramString1, paramString2);
    }
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    set("&aip", zzao.zzax(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    set("&aid", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    set("&aiid", paramString);
  }
  
  public void setAppName(String paramString)
  {
    set("&an", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    set("&av", paramString);
  }
  
  public void setCampaignParamsOnNextHit(Uri paramUri)
  {
    if ((paramUri == null) || (paramUri.isOpaque())) {}
    do
    {
      return;
      paramUri = paramUri.getQueryParameter("referrer");
    } while (TextUtils.isEmpty(paramUri));
    paramUri = String.valueOf(paramUri);
    if (paramUri.length() != 0) {}
    for (paramUri = "http://hostname/?".concat(paramUri);; paramUri = new String("http://hostname/?"))
    {
      paramUri = Uri.parse(paramUri);
      String str = paramUri.getQueryParameter("utm_id");
      if (str != null) {
        this.bv.put("&ci", str);
      }
      str = paramUri.getQueryParameter("anid");
      if (str != null) {
        this.bv.put("&anid", str);
      }
      str = paramUri.getQueryParameter("utm_campaign");
      if (str != null) {
        this.bv.put("&cn", str);
      }
      str = paramUri.getQueryParameter("utm_content");
      if (str != null) {
        this.bv.put("&cc", str);
      }
      str = paramUri.getQueryParameter("utm_medium");
      if (str != null) {
        this.bv.put("&cm", str);
      }
      str = paramUri.getQueryParameter("utm_source");
      if (str != null) {
        this.bv.put("&cs", str);
      }
      str = paramUri.getQueryParameter("utm_term");
      if (str != null) {
        this.bv.put("&ck", str);
      }
      str = paramUri.getQueryParameter("dclid");
      if (str != null) {
        this.bv.put("&dclid", str);
      }
      str = paramUri.getQueryParameter("gclid");
      if (str != null) {
        this.bv.put("&gclid", str);
      }
      paramUri = paramUri.getQueryParameter("aclid");
      if (paramUri == null) {
        break;
      }
      this.bv.put("&aclid", paramUri);
      break;
    }
  }
  
  public void setClientId(String paramString)
  {
    set("&cid", paramString);
  }
  
  public void setEncoding(String paramString)
  {
    set("&de", paramString);
  }
  
  public void setHostname(String paramString)
  {
    set("&dh", paramString);
  }
  
  public void setLanguage(String paramString)
  {
    set("&ul", paramString);
  }
  
  public void setLocation(String paramString)
  {
    set("&dl", paramString);
  }
  
  public void setPage(String paramString)
  {
    set("&dp", paramString);
  }
  
  public void setReferrer(String paramString)
  {
    set("&dr", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    set("&sf", Double.toString(paramDouble));
  }
  
  public void setScreenColors(String paramString)
  {
    set("&sd", paramString);
  }
  
  public void setScreenName(String paramString)
  {
    set("&cd", paramString);
  }
  
  public void setScreenResolution(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) && (paramInt2 < 0)) {
      zzev("Invalid width or height. The values should be non-negative.");
    }
    for (;;)
    {
      return;
      set("&sr", 23 + paramInt1 + "x" + paramInt2);
    }
  }
  
  public void setSessionTimeout(long paramLong)
  {
    this.bx.setSessionTimeout(1000L * paramLong);
  }
  
  public void setTitle(String paramString)
  {
    set("&dt", paramString);
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    set("useSecure", zzao.zzax(paramBoolean));
  }
  
  public void setViewportSize(String paramString)
  {
    set("&vp", paramString);
  }
  
  void zza(zzan paramzzan)
  {
    zzes("Loading Tracker config values");
    this.bz = paramzzan;
    if (this.bz.zzahc())
    {
      paramzzan = this.bz.getTrackingId();
      set("&tid", paramzzan);
      zza("trackingId loaded", paramzzan);
    }
    if (this.bz.zzahd())
    {
      paramzzan = Double.toString(this.bz.zzahe());
      set("&sf", paramzzan);
      zza("Sample frequency loaded", paramzzan);
    }
    if (this.bz.zzahf())
    {
      int i = this.bz.getSessionTimeout();
      setSessionTimeout(i);
      zza("Session timeout loaded", Integer.valueOf(i));
    }
    boolean bool;
    if (this.bz.zzahg())
    {
      bool = this.bz.zzahh();
      enableAutoActivityTracking(bool);
      zza("Auto activity tracking loaded", Boolean.valueOf(bool));
    }
    if (this.bz.zzahi())
    {
      bool = this.bz.zzahj();
      if (bool) {
        set("&aip", "1");
      }
      zza("Anonymize ip loaded", Boolean.valueOf(bool));
    }
    enableExceptionReporting(this.bz.zzahk());
  }
  
  boolean zzaaa()
  {
    return this.bu;
  }
  
  protected void zzzy()
  {
    this.bx.initialize();
    String str = zzzh().zzaae();
    if (str != null) {
      set("&an", str);
    }
    str = zzzh().zzaaf();
    if (str != null) {
      set("&av", str);
    }
  }
  
  private class zza
    extends zzd
    implements GoogleAnalytics.zza
  {
    private boolean bI;
    private int bJ;
    private long bK = -1L;
    private boolean bL;
    private long bM;
    
    protected zza(zzf paramzzf)
    {
      super();
    }
    
    private void zzaac()
    {
      if ((this.bK >= 0L) || (this.bI)) {
        zzza().zza(Tracker.zza(Tracker.this));
      }
      for (;;)
      {
        return;
        zzza().zzb(Tracker.zza(Tracker.this));
      }
    }
    
    public void enableAutoActivityTracking(boolean paramBoolean)
    {
      this.bI = paramBoolean;
      zzaac();
    }
    
    public void setSessionTimeout(long paramLong)
    {
      this.bK = paramLong;
      zzaac();
    }
    
    public boolean zzaab()
    {
      try
      {
        boolean bool = this.bL;
        this.bL = false;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    boolean zzaad()
    {
      if (zzabz().elapsedRealtime() >= this.bM + Math.max(1000L, this.bK)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public void zzo(Activity paramActivity)
    {
      if ((this.bJ == 0) && (zzaad())) {
        this.bL = true;
      }
      this.bJ += 1;
      HashMap localHashMap;
      Tracker localTracker;
      if (this.bI)
      {
        localObject = paramActivity.getIntent();
        if (localObject != null) {
          Tracker.this.setCampaignParamsOnNextHit(((Intent)localObject).getData());
        }
        localHashMap = new HashMap();
        localHashMap.put("&t", "screenview");
        localTracker = Tracker.this;
        if (Tracker.zzk(Tracker.this) == null) {
          break label159;
        }
      }
      label159:
      for (Object localObject = Tracker.zzk(Tracker.this).zzr(paramActivity);; localObject = paramActivity.getClass().getCanonicalName())
      {
        localTracker.set("&cd", (String)localObject);
        if (TextUtils.isEmpty((CharSequence)localHashMap.get("&dr")))
        {
          paramActivity = Tracker.zzq(paramActivity);
          if (!TextUtils.isEmpty(paramActivity)) {
            localHashMap.put("&dr", paramActivity);
          }
        }
        Tracker.this.send(localHashMap);
        return;
      }
    }
    
    public void zzp(Activity paramActivity)
    {
      this.bJ -= 1;
      this.bJ = Math.max(0, this.bJ);
      if (this.bJ == 0) {
        this.bM = zzabz().elapsedRealtime();
      }
    }
    
    protected void zzzy() {}
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */