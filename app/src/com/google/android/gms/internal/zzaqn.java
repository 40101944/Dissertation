package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;

public final class zzaqn
{
  public static final zzapl bqA = zza(Number.class, bqz);
  public static final zzapk<Character> bqB = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Character paramAnonymousCharacter)
      throws IOException
    {
      if (paramAnonymousCharacter == null) {}
      for (paramAnonymousCharacter = null;; paramAnonymousCharacter = String.valueOf(paramAnonymousCharacter))
      {
        paramAnonymouszzaqr.zzut(paramAnonymousCharacter);
        return;
      }
    }
    
    public Character zzp(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
        paramAnonymouszzaqp.nextNull();
      }
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = Character.valueOf(paramAnonymouszzaqp.charAt(0)))
      {
        return paramAnonymouszzaqp;
        paramAnonymouszzaqp = paramAnonymouszzaqp.nextString();
        if (paramAnonymouszzaqp.length() != 1)
        {
          paramAnonymouszzaqp = String.valueOf(paramAnonymouszzaqp);
          if (paramAnonymouszzaqp.length() != 0) {}
          for (paramAnonymouszzaqp = "Expecting character, got: ".concat(paramAnonymouszzaqp);; paramAnonymouszzaqp = new String("Expecting character, got: ")) {
            throw new zzaph(paramAnonymouszzaqp);
          }
        }
      }
    }
  };
  public static final zzapl bqC = zza(Character.TYPE, Character.class, bqB);
  public static final zzapk<String> bqD = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, String paramAnonymousString)
      throws IOException
    {
      paramAnonymouszzaqr.zzut(paramAnonymousString);
    }
    
    public String zzq(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      zzaqq localzzaqq = paramAnonymouszzaqp.bq();
      if (localzzaqq == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = null;
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        if (localzzaqq == zzaqq.brI) {
          paramAnonymouszzaqp = Boolean.toString(paramAnonymouszzaqp.nextBoolean());
        } else {
          paramAnonymouszzaqp = paramAnonymouszzaqp.nextString();
        }
      }
    }
  };
  public static final zzapk<BigDecimal> bqE = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, BigDecimal paramAnonymousBigDecimal)
      throws IOException
    {
      paramAnonymouszzaqr.zza(paramAnonymousBigDecimal);
    }
    
    public BigDecimal zzr(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = null;
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        try
        {
          paramAnonymouszzaqp = new BigDecimal(paramAnonymouszzaqp.nextString());
        }
        catch (NumberFormatException paramAnonymouszzaqp)
        {
          throw new zzaph(paramAnonymouszzaqp);
        }
      }
    }
  };
  public static final zzapk<BigInteger> bqF = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, BigInteger paramAnonymousBigInteger)
      throws IOException
    {
      paramAnonymouszzaqr.zza(paramAnonymousBigInteger);
    }
    
    public BigInteger zzs(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = null;
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        try
        {
          paramAnonymouszzaqp = new BigInteger(paramAnonymouszzaqp.nextString());
        }
        catch (NumberFormatException paramAnonymouszzaqp)
        {
          throw new zzaph(paramAnonymouszzaqp);
        }
      }
    }
  };
  public static final zzapl bqG = zza(String.class, bqD);
  public static final zzapk<StringBuilder> bqH = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, StringBuilder paramAnonymousStringBuilder)
      throws IOException
    {
      if (paramAnonymousStringBuilder == null) {}
      for (paramAnonymousStringBuilder = null;; paramAnonymousStringBuilder = paramAnonymousStringBuilder.toString())
      {
        paramAnonymouszzaqr.zzut(paramAnonymousStringBuilder);
        return;
      }
    }
    
    public StringBuilder zzt(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
        paramAnonymouszzaqp.nextNull();
      }
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = new StringBuilder(paramAnonymouszzaqp.nextString())) {
        return paramAnonymouszzaqp;
      }
    }
  };
  public static final zzapl bqI = zza(StringBuilder.class, bqH);
  public static final zzapk<StringBuffer> bqJ = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, StringBuffer paramAnonymousStringBuffer)
      throws IOException
    {
      if (paramAnonymousStringBuffer == null) {}
      for (paramAnonymousStringBuffer = null;; paramAnonymousStringBuffer = paramAnonymousStringBuffer.toString())
      {
        paramAnonymouszzaqr.zzut(paramAnonymousStringBuffer);
        return;
      }
    }
    
    public StringBuffer zzu(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
        paramAnonymouszzaqp.nextNull();
      }
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = new StringBuffer(paramAnonymouszzaqp.nextString())) {
        return paramAnonymouszzaqp;
      }
    }
  };
  public static final zzapl bqK = zza(StringBuffer.class, bqJ);
  public static final zzapk<URL> bqL = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, URL paramAnonymousURL)
      throws IOException
    {
      if (paramAnonymousURL == null) {}
      for (paramAnonymousURL = null;; paramAnonymousURL = paramAnonymousURL.toExternalForm())
      {
        paramAnonymouszzaqr.zzut(paramAnonymousURL);
        return;
      }
    }
    
    public URL zzv(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      Object localObject = null;
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = (zzaqp)localObject;
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        String str = paramAnonymouszzaqp.nextString();
        paramAnonymouszzaqp = (zzaqp)localObject;
        if (!"null".equals(str)) {
          paramAnonymouszzaqp = new URL(str);
        }
      }
    }
  };
  public static final zzapl bqM = zza(URL.class, bqL);
  public static final zzapk<URI> bqN = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, URI paramAnonymousURI)
      throws IOException
    {
      if (paramAnonymousURI == null) {}
      for (paramAnonymousURI = null;; paramAnonymousURI = paramAnonymousURI.toASCIIString())
      {
        paramAnonymouszzaqr.zzut(paramAnonymousURI);
        return;
      }
    }
    
    public URI zzw(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      Object localObject = null;
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = (zzaqp)localObject;
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        try
        {
          String str = paramAnonymouszzaqp.nextString();
          paramAnonymouszzaqp = (zzaqp)localObject;
          if ("null".equals(str)) {
            continue;
          }
          paramAnonymouszzaqp = new URI(str);
        }
        catch (URISyntaxException paramAnonymouszzaqp)
        {
          throw new zzaoz(paramAnonymouszzaqp);
        }
      }
    }
  };
  public static final zzapl bqO = zza(URI.class, bqN);
  public static final zzapk<InetAddress> bqP = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, InetAddress paramAnonymousInetAddress)
      throws IOException
    {
      if (paramAnonymousInetAddress == null) {}
      for (paramAnonymousInetAddress = null;; paramAnonymousInetAddress = paramAnonymousInetAddress.getHostAddress())
      {
        paramAnonymouszzaqr.zzut(paramAnonymousInetAddress);
        return;
      }
    }
    
    public InetAddress zzy(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
        paramAnonymouszzaqp.nextNull();
      }
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = InetAddress.getByName(paramAnonymouszzaqp.nextString())) {
        return paramAnonymouszzaqp;
      }
    }
  };
  public static final zzapl bqQ = zzb(InetAddress.class, bqP);
  public static final zzapk<UUID> bqR = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, UUID paramAnonymousUUID)
      throws IOException
    {
      if (paramAnonymousUUID == null) {}
      for (paramAnonymousUUID = null;; paramAnonymousUUID = paramAnonymousUUID.toString())
      {
        paramAnonymouszzaqr.zzut(paramAnonymousUUID);
        return;
      }
    }
    
    public UUID zzz(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
        paramAnonymouszzaqp.nextNull();
      }
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = UUID.fromString(paramAnonymouszzaqp.nextString())) {
        return paramAnonymouszzaqp;
      }
    }
  };
  public static final zzapl bqS = zza(UUID.class, bqR);
  public static final zzapl bqT = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
    {
      if (paramAnonymouszzaqo.bB() != Timestamp.class) {}
      for (paramAnonymouszzaos = null;; paramAnonymouszzaos = new zzapk()
          {
            public void zza(zzaqr paramAnonymous2zzaqr, Timestamp paramAnonymous2Timestamp)
              throws IOException
            {
              this.brb.zza(paramAnonymous2zzaqr, paramAnonymous2Timestamp);
            }
            
            public Timestamp zzaa(zzaqp paramAnonymous2zzaqp)
              throws IOException
            {
              paramAnonymous2zzaqp = (Date)this.brb.zzb(paramAnonymous2zzaqp);
              if (paramAnonymous2zzaqp != null) {}
              for (paramAnonymous2zzaqp = new Timestamp(paramAnonymous2zzaqp.getTime());; paramAnonymous2zzaqp = null) {
                return paramAnonymous2zzaqp;
              }
            }
          }) {
        return paramAnonymouszzaos;
      }
    }
  };
  public static final zzapk<Calendar> bqU = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Calendar paramAnonymousCalendar)
      throws IOException
    {
      if (paramAnonymousCalendar == null) {
        paramAnonymouszzaqr.bA();
      }
      for (;;)
      {
        return;
        paramAnonymouszzaqr.by();
        paramAnonymouszzaqr.zzus("year");
        paramAnonymouszzaqr.zzcs(paramAnonymousCalendar.get(1));
        paramAnonymouszzaqr.zzus("month");
        paramAnonymouszzaqr.zzcs(paramAnonymousCalendar.get(2));
        paramAnonymouszzaqr.zzus("dayOfMonth");
        paramAnonymouszzaqr.zzcs(paramAnonymousCalendar.get(5));
        paramAnonymouszzaqr.zzus("hourOfDay");
        paramAnonymouszzaqr.zzcs(paramAnonymousCalendar.get(11));
        paramAnonymouszzaqr.zzus("minute");
        paramAnonymouszzaqr.zzcs(paramAnonymousCalendar.get(12));
        paramAnonymouszzaqr.zzus("second");
        paramAnonymouszzaqr.zzcs(paramAnonymousCalendar.get(13));
        paramAnonymouszzaqr.bz();
      }
    }
    
    public Calendar zzab(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      int j = 0;
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
        paramAnonymouszzaqp.nextNull();
      }
      int k;
      int m;
      int n;
      int i1;
      int i2;
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = new GregorianCalendar(i2, i1, n, m, k, j))
      {
        return paramAnonymouszzaqp;
        paramAnonymouszzaqp.beginObject();
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        while (paramAnonymouszzaqp.bq() != zzaqq.brE)
        {
          String str = paramAnonymouszzaqp.nextName();
          int i = paramAnonymouszzaqp.nextInt();
          if ("year".equals(str)) {
            i2 = i;
          } else if ("month".equals(str)) {
            i1 = i;
          } else if ("dayOfMonth".equals(str)) {
            n = i;
          } else if ("hourOfDay".equals(str)) {
            m = i;
          } else if ("minute".equals(str)) {
            k = i;
          } else if ("second".equals(str)) {
            j = i;
          }
        }
        paramAnonymouszzaqp.endObject();
      }
    }
  };
  public static final zzapl bqV = zzb(Calendar.class, GregorianCalendar.class, bqU);
  public static final zzapk<Locale> bqW = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Locale paramAnonymousLocale)
      throws IOException
    {
      if (paramAnonymousLocale == null) {}
      for (paramAnonymousLocale = null;; paramAnonymousLocale = paramAnonymousLocale.toString())
      {
        paramAnonymouszzaqr.zzut(paramAnonymousLocale);
        return;
      }
    }
    
    public Locale zzac(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      String str = null;
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = str;
        return paramAnonymouszzaqp;
      }
      Object localObject = new StringTokenizer(paramAnonymouszzaqp.nextString(), "_");
      if (((StringTokenizer)localObject).hasMoreElements()) {}
      for (paramAnonymouszzaqp = ((StringTokenizer)localObject).nextToken();; paramAnonymouszzaqp = null)
      {
        if (((StringTokenizer)localObject).hasMoreElements()) {}
        for (str = ((StringTokenizer)localObject).nextToken();; str = null)
        {
          if (((StringTokenizer)localObject).hasMoreElements()) {}
          for (localObject = ((StringTokenizer)localObject).nextToken();; localObject = null)
          {
            if ((str == null) && (localObject == null))
            {
              paramAnonymouszzaqp = new Locale(paramAnonymouszzaqp);
              break;
            }
            if (localObject == null)
            {
              paramAnonymouszzaqp = new Locale(paramAnonymouszzaqp, str);
              break;
            }
            paramAnonymouszzaqp = new Locale(paramAnonymouszzaqp, str, (String)localObject);
            break;
          }
        }
      }
    }
  };
  public static final zzapl bqX = zza(Locale.class, bqW);
  public static final zzapk<zzaoy> bqY = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, zzaoy paramAnonymouszzaoy)
      throws IOException
    {
      if ((paramAnonymouszzaoy == null) || (paramAnonymouszzaoy.aY())) {
        paramAnonymouszzaqr.bA();
      }
      for (;;)
      {
        return;
        if (paramAnonymouszzaoy.aX())
        {
          paramAnonymouszzaoy = paramAnonymouszzaoy.bb();
          if (paramAnonymouszzaoy.be()) {
            paramAnonymouszzaqr.zza(paramAnonymouszzaoy.aT());
          } else if (paramAnonymouszzaoy.bd()) {
            paramAnonymouszzaqr.zzdh(paramAnonymouszzaoy.getAsBoolean());
          } else {
            paramAnonymouszzaqr.zzut(paramAnonymouszzaoy.aU());
          }
        }
        else if (paramAnonymouszzaoy.aV())
        {
          paramAnonymouszzaqr.bw();
          paramAnonymouszzaoy = paramAnonymouszzaoy.ba().iterator();
          while (paramAnonymouszzaoy.hasNext()) {
            zza(paramAnonymouszzaqr, (zzaoy)paramAnonymouszzaoy.next());
          }
          paramAnonymouszzaqr.bx();
        }
        else
        {
          if (!paramAnonymouszzaoy.aW()) {
            break;
          }
          paramAnonymouszzaqr.by();
          paramAnonymouszzaoy = paramAnonymouszzaoy.aZ().entrySet().iterator();
          while (paramAnonymouszzaoy.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramAnonymouszzaoy.next();
            paramAnonymouszzaqr.zzus((String)localEntry.getKey());
            zza(paramAnonymouszzaqr, (zzaoy)localEntry.getValue());
          }
          paramAnonymouszzaqr.bz();
        }
      }
      paramAnonymouszzaqr = String.valueOf(paramAnonymouszzaoy.getClass());
      throw new IllegalArgumentException(String.valueOf(paramAnonymouszzaqr).length() + 15 + "Couldn't write " + paramAnonymouszzaqr);
    }
    
    public zzaoy zzad(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      switch (zzaqn.26.bpW[paramAnonymouszzaqp.bq().ordinal()])
      {
      default: 
        throw new IllegalArgumentException();
      case 3: 
        paramAnonymouszzaqp = new zzape(paramAnonymouszzaqp.nextString());
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        paramAnonymouszzaqp = new zzape(new zzapv(paramAnonymouszzaqp.nextString()));
        continue;
        paramAnonymouszzaqp = new zzape(Boolean.valueOf(paramAnonymouszzaqp.nextBoolean()));
        continue;
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = zzapa.bou;
        continue;
        Object localObject = new zzaov();
        paramAnonymouszzaqp.beginArray();
        while (paramAnonymouszzaqp.hasNext()) {
          ((zzaov)localObject).zzc((zzaoy)zzb(paramAnonymouszzaqp));
        }
        paramAnonymouszzaqp.endArray();
        paramAnonymouszzaqp = (zzaqp)localObject;
        continue;
        localObject = new zzapb();
        paramAnonymouszzaqp.beginObject();
        while (paramAnonymouszzaqp.hasNext()) {
          ((zzapb)localObject).zza(paramAnonymouszzaqp.nextName(), (zzaoy)zzb(paramAnonymouszzaqp));
        }
        paramAnonymouszzaqp.endObject();
        paramAnonymouszzaqp = (zzaqp)localObject;
      }
    }
  };
  public static final zzapl bqZ = zzb(zzaoy.class, bqY);
  public static final zzapk<Class> bqj = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Class paramAnonymousClass)
      throws IOException
    {
      if (paramAnonymousClass == null)
      {
        paramAnonymouszzaqr.bA();
        return;
      }
      paramAnonymouszzaqr = String.valueOf(paramAnonymousClass.getName());
      throw new UnsupportedOperationException(String.valueOf(paramAnonymouszzaqr).length() + 76 + "Attempted to serialize java.lang.Class: " + paramAnonymouszzaqr + ". Forgot to register a type adapter?");
    }
    
    public Class zzo(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        return null;
      }
      throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }
  };
  public static final zzapl bqk = zza(Class.class, bqj);
  public static final zzapk<BitSet> bql = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, BitSet paramAnonymousBitSet)
      throws IOException
    {
      if (paramAnonymousBitSet == null) {
        paramAnonymouszzaqr.bA();
      }
      for (;;)
      {
        return;
        paramAnonymouszzaqr.bw();
        int i = 0;
        if (i < paramAnonymousBitSet.length())
        {
          if (paramAnonymousBitSet.get(i)) {}
          for (int j = 1;; j = 0)
          {
            paramAnonymouszzaqr.zzcs(j);
            i++;
            break;
          }
        }
        paramAnonymouszzaqr.bx();
      }
    }
    
    public BitSet zzx(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
        paramAnonymouszzaqp.nextNull();
      }
      BitSet localBitSet;
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = localBitSet)
      {
        return paramAnonymouszzaqp;
        localBitSet = new BitSet();
        paramAnonymouszzaqp.beginArray();
        Object localObject = paramAnonymouszzaqp.bq();
        int i = 0;
        if (localObject != zzaqq.brC)
        {
          boolean bool;
          switch (zzaqn.26.bpW[localObject.ordinal()])
          {
          default: 
            paramAnonymouszzaqp = String.valueOf(localObject);
            throw new zzaph(String.valueOf(paramAnonymouszzaqp).length() + 27 + "Invalid bitset value type: " + paramAnonymouszzaqp);
          case 1: 
            if (paramAnonymouszzaqp.nextInt() != 0) {
              bool = true;
            }
            break;
          }
          for (;;)
          {
            if (bool) {
              localBitSet.set(i);
            }
            i++;
            localObject = paramAnonymouszzaqp.bq();
            break;
            bool = false;
            continue;
            bool = paramAnonymouszzaqp.nextBoolean();
            continue;
            localObject = paramAnonymouszzaqp.nextString();
            try
            {
              int j = Integer.parseInt((String)localObject);
              if (j != 0) {
                bool = true;
              } else {
                bool = false;
              }
            }
            catch (NumberFormatException paramAnonymouszzaqp)
            {
              paramAnonymouszzaqp = String.valueOf(localObject);
              if (paramAnonymouszzaqp.length() == 0) {}
            }
          }
          for (paramAnonymouszzaqp = "Error: Expecting: bitset number value (1, 0), Found: ".concat(paramAnonymouszzaqp);; paramAnonymouszzaqp = new String("Error: Expecting: bitset number value (1, 0), Found: ")) {
            throw new zzaph(paramAnonymouszzaqp);
          }
        }
        paramAnonymouszzaqp.endArray();
      }
    }
  };
  public static final zzapl bqm = zza(BitSet.class, bql);
  public static final zzapk<Boolean> bqn = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Boolean paramAnonymousBoolean)
      throws IOException
    {
      if (paramAnonymousBoolean == null) {
        paramAnonymouszzaqr.bA();
      }
      for (;;)
      {
        return;
        paramAnonymouszzaqr.zzdh(paramAnonymousBoolean.booleanValue());
      }
    }
    
    public Boolean zzae(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = null;
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        if (paramAnonymouszzaqp.bq() == zzaqq.brG) {
          paramAnonymouszzaqp = Boolean.valueOf(Boolean.parseBoolean(paramAnonymouszzaqp.nextString()));
        } else {
          paramAnonymouszzaqp = Boolean.valueOf(paramAnonymouszzaqp.nextBoolean());
        }
      }
    }
  };
  public static final zzapk<Boolean> bqo = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Boolean paramAnonymousBoolean)
      throws IOException
    {
      if (paramAnonymousBoolean == null) {}
      for (paramAnonymousBoolean = "null";; paramAnonymousBoolean = paramAnonymousBoolean.toString())
      {
        paramAnonymouszzaqr.zzut(paramAnonymousBoolean);
        return;
      }
    }
    
    public Boolean zzae(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
        paramAnonymouszzaqp.nextNull();
      }
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = Boolean.valueOf(paramAnonymouszzaqp.nextString())) {
        return paramAnonymouszzaqp;
      }
    }
  };
  public static final zzapl bqp = zza(Boolean.TYPE, Boolean.class, bqn);
  public static final zzapk<Number> bqq = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymouszzaqr.zza(paramAnonymousNumber);
    }
    
    public Number zzg(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = null;
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        try
        {
          byte b = (byte)paramAnonymouszzaqp.nextInt();
          paramAnonymouszzaqp = Byte.valueOf(b);
        }
        catch (NumberFormatException paramAnonymouszzaqp)
        {
          throw new zzaph(paramAnonymouszzaqp);
        }
      }
    }
  };
  public static final zzapl bqr = zza(Byte.TYPE, Byte.class, bqq);
  public static final zzapk<Number> bqs = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymouszzaqr.zza(paramAnonymousNumber);
    }
    
    public Number zzg(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = null;
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        try
        {
          short s = (short)paramAnonymouszzaqp.nextInt();
          paramAnonymouszzaqp = Short.valueOf(s);
        }
        catch (NumberFormatException paramAnonymouszzaqp)
        {
          throw new zzaph(paramAnonymouszzaqp);
        }
      }
    }
  };
  public static final zzapl bqt = zza(Short.TYPE, Short.class, bqs);
  public static final zzapk<Number> bqu = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymouszzaqr.zza(paramAnonymousNumber);
    }
    
    public Number zzg(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = null;
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        try
        {
          int i = paramAnonymouszzaqp.nextInt();
          paramAnonymouszzaqp = Integer.valueOf(i);
        }
        catch (NumberFormatException paramAnonymouszzaqp)
        {
          throw new zzaph(paramAnonymouszzaqp);
        }
      }
    }
  };
  public static final zzapl bqv = zza(Integer.TYPE, Integer.class, bqu);
  public static final zzapk<Number> bqw = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymouszzaqr.zza(paramAnonymousNumber);
    }
    
    public Number zzg(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ)
      {
        paramAnonymouszzaqp.nextNull();
        paramAnonymouszzaqp = null;
      }
      for (;;)
      {
        return paramAnonymouszzaqp;
        try
        {
          long l = paramAnonymouszzaqp.nextLong();
          paramAnonymouszzaqp = Long.valueOf(l);
        }
        catch (NumberFormatException paramAnonymouszzaqp)
        {
          throw new zzaph(paramAnonymouszzaqp);
        }
      }
    }
  };
  public static final zzapk<Number> bqx = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymouszzaqr.zza(paramAnonymousNumber);
    }
    
    public Number zzg(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
        paramAnonymouszzaqp.nextNull();
      }
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = Float.valueOf((float)paramAnonymouszzaqp.nextDouble())) {
        return paramAnonymouszzaqp;
      }
    }
  };
  public static final zzapk<Number> bqy = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymouszzaqr.zza(paramAnonymousNumber);
    }
    
    public Number zzg(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      if (paramAnonymouszzaqp.bq() == zzaqq.brJ) {
        paramAnonymouszzaqp.nextNull();
      }
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = Double.valueOf(paramAnonymouszzaqp.nextDouble())) {
        return paramAnonymouszzaqp;
      }
    }
  };
  public static final zzapk<Number> bqz = new zzapk()
  {
    public void zza(zzaqr paramAnonymouszzaqr, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymouszzaqr.zza(paramAnonymousNumber);
    }
    
    public Number zzg(zzaqp paramAnonymouszzaqp)
      throws IOException
    {
      zzaqq localzzaqq = paramAnonymouszzaqp.bq();
      switch (zzaqn.26.bpW[localzzaqq.ordinal()])
      {
      case 2: 
      case 3: 
      default: 
        paramAnonymouszzaqp = String.valueOf(localzzaqq);
        throw new zzaph(String.valueOf(paramAnonymouszzaqp).length() + 23 + "Expecting number, got: " + paramAnonymouszzaqp);
      case 4: 
        paramAnonymouszzaqp.nextNull();
      }
      for (paramAnonymouszzaqp = null;; paramAnonymouszzaqp = new zzapv(paramAnonymouszzaqp.nextString())) {
        return paramAnonymouszzaqp;
      }
    }
  };
  public static final zzapl bra = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
    {
      paramAnonymouszzaqo = paramAnonymouszzaqo.bB();
      if ((!Enum.class.isAssignableFrom(paramAnonymouszzaqo)) || (paramAnonymouszzaqo == Enum.class)) {}
      for (paramAnonymouszzaos = null;; paramAnonymouszzaos = new zzaqn.zza(paramAnonymouszzaos))
      {
        return paramAnonymouszzaos;
        paramAnonymouszzaos = paramAnonymouszzaqo;
        if (!paramAnonymouszzaqo.isEnum()) {
          paramAnonymouszzaos = paramAnonymouszzaqo.getSuperclass();
        }
      }
    }
  };
  
  public static <TT> zzapl zza(zzaqo<TT> paramzzaqo, final zzapk<TT> paramzzapk)
  {
    new zzapl()
    {
      public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
      {
        if (paramAnonymouszzaqo.equals(this.bpf)) {}
        for (paramAnonymouszzaos = paramzzapk;; paramAnonymouszzaos = null) {
          return paramAnonymouszzaos;
        }
      }
    };
  }
  
  public static <TT> zzapl zza(Class<TT> paramClass, final zzapk<TT> paramzzapk)
  {
    new zzapl()
    {
      public String toString()
      {
        String str1 = String.valueOf(this.bre.getName());
        String str2 = String.valueOf(paramzzapk);
        return String.valueOf(str1).length() + 23 + String.valueOf(str2).length() + "Factory[type=" + str1 + ",adapter=" + str2 + "]";
      }
      
      public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
      {
        if (paramAnonymouszzaqo.bB() == this.bre) {}
        for (paramAnonymouszzaos = paramzzapk;; paramAnonymouszzaos = null) {
          return paramAnonymouszzaos;
        }
      }
    };
  }
  
  public static <TT> zzapl zza(Class<TT> paramClass1, final Class<TT> paramClass2, final zzapk<? super TT> paramzzapk)
  {
    new zzapl()
    {
      public String toString()
      {
        String str2 = String.valueOf(paramClass2.getName());
        String str1 = String.valueOf(this.brf.getName());
        String str3 = String.valueOf(paramzzapk);
        return String.valueOf(str2).length() + 24 + String.valueOf(str1).length() + String.valueOf(str3).length() + "Factory[type=" + str2 + "+" + str1 + ",adapter=" + str3 + "]";
      }
      
      public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
      {
        paramAnonymouszzaos = paramAnonymouszzaqo.bB();
        if ((paramAnonymouszzaos == this.brf) || (paramAnonymouszzaos == paramClass2)) {}
        for (paramAnonymouszzaos = paramzzapk;; paramAnonymouszzaos = null) {
          return paramAnonymouszzaos;
        }
      }
    };
  }
  
  public static <TT> zzapl zzb(Class<TT> paramClass, final zzapk<TT> paramzzapk)
  {
    new zzapl()
    {
      public String toString()
      {
        String str1 = String.valueOf(this.brj.getName());
        String str2 = String.valueOf(paramzzapk);
        return String.valueOf(str1).length() + 32 + String.valueOf(str2).length() + "Factory[typeHierarchy=" + str1 + ",adapter=" + str2 + "]";
      }
      
      public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
      {
        if (this.brj.isAssignableFrom(paramAnonymouszzaqo.bB())) {}
        for (paramAnonymouszzaos = paramzzapk;; paramAnonymouszzaos = null) {
          return paramAnonymouszzaos;
        }
      }
    };
  }
  
  public static <TT> zzapl zzb(Class<TT> paramClass, final Class<? extends TT> paramClass1, final zzapk<? super TT> paramzzapk)
  {
    new zzapl()
    {
      public String toString()
      {
        String str1 = String.valueOf(this.brh.getName());
        String str2 = String.valueOf(paramClass1.getName());
        String str3 = String.valueOf(paramzzapk);
        return String.valueOf(str1).length() + 24 + String.valueOf(str2).length() + String.valueOf(str3).length() + "Factory[type=" + str1 + "+" + str2 + ",adapter=" + str3 + "]";
      }
      
      public <T> zzapk<T> zza(zzaos paramAnonymouszzaos, zzaqo<T> paramAnonymouszzaqo)
      {
        paramAnonymouszzaos = paramAnonymouszzaqo.bB();
        if ((paramAnonymouszzaos == this.brh) || (paramAnonymouszzaos == paramClass1)) {}
        for (paramAnonymouszzaos = paramzzapk;; paramAnonymouszzaos = null) {
          return paramAnonymouszzaos;
        }
      }
    };
  }
  
  private static final class zza<T extends Enum<T>>
    extends zzapk<T>
  {
    private final Map<String, T> brk = new HashMap();
    private final Map<T, String> brl = new HashMap();
    
    public zza(Class<T> paramClass)
    {
      try
      {
        for (Enum localEnum : (Enum[])paramClass.getEnumConstants())
        {
          Object localObject1 = localEnum.name();
          Object localObject2 = (zzapn)paramClass.getField((String)localObject1).getAnnotation(zzapn.class);
          if (localObject2 != null)
          {
            String str = ((zzapn)localObject2).value();
            localObject2 = ((zzapn)localObject2).bh();
            int m = localObject2.length;
            for (int j = 0;; j++)
            {
              localObject1 = str;
              if (j >= m) {
                break;
              }
              localObject1 = localObject2[j];
              this.brk.put(localObject1, localEnum);
            }
          }
          this.brk.put(localObject1, localEnum);
          this.brl.put(localEnum, localObject1);
        }
        return;
      }
      catch (NoSuchFieldException paramClass)
      {
        throw new AssertionError();
      }
    }
    
    public void zza(zzaqr paramzzaqr, T paramT)
      throws IOException
    {
      if (paramT == null) {}
      for (paramT = null;; paramT = (String)this.brl.get(paramT))
      {
        paramzzaqr.zzut(paramT);
        return;
      }
    }
    
    public T zzaf(zzaqp paramzzaqp)
      throws IOException
    {
      if (paramzzaqp.bq() == zzaqq.brJ) {
        paramzzaqp.nextNull();
      }
      for (paramzzaqp = null;; paramzzaqp = (Enum)this.brk.get(paramzzaqp.nextString())) {
        return paramzzaqp;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */