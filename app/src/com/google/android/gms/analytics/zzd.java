package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class zzd
  implements zzk
{
  private static final Uri aT;
  private final LogPrinter aU = new LogPrinter(4, "GA/LogCatTransport");
  
  static
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("uri");
    localBuilder.authority("local");
    aT = localBuilder.build();
  }
  
  public void zzb(zze paramzze)
  {
    Object localObject = new ArrayList(paramzze.zzzj());
    Collections.sort((List)localObject, new Comparator()
    {
      public int zza(zzg paramAnonymouszzg1, zzg paramAnonymouszzg2)
      {
        return paramAnonymouszzg1.getClass().getCanonicalName().compareTo(paramAnonymouszzg2.getClass().getCanonicalName());
      }
    });
    paramzze = new StringBuilder();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = ((zzg)localIterator.next()).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (paramzze.length() != 0) {
          paramzze.append(", ");
        }
        paramzze.append((String)localObject);
      }
    }
    this.aU.println(paramzze.toString());
  }
  
  public Uri zzyx()
  {
    return aT;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */