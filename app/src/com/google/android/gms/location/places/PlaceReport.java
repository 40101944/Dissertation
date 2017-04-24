package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.internal.zzz.zza;

public class PlaceReport
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zzi();
  private final String alV;
  private final String bQ;
  private final String mTag;
  final int mVersionCode;
  
  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.alV = paramString1;
    this.mTag = paramString2;
    this.bQ = paramString3;
  }
  
  public static PlaceReport create(String paramString1, String paramString2)
  {
    return zzj(paramString1, paramString2, "unknown");
  }
  
  public static PlaceReport zzj(String paramString1, String paramString2, String paramString3)
  {
    zzaa.zzy(paramString1);
    zzaa.zzib(paramString2);
    zzaa.zzib(paramString3);
    zzaa.zzb(zzla(paramString3), "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, paramString3);
  }
  
  private static boolean zzla(String paramString)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        bool = false;
      }
      return bool;
      if (paramString.equals("unknown"))
      {
        i = 0;
        continue;
        if (paramString.equals("userReported"))
        {
          i = 1;
          continue;
          if (paramString.equals("inferredGeofencing"))
          {
            i = 2;
            continue;
            if (paramString.equals("inferredRadioSignals"))
            {
              i = 3;
              continue;
              if (paramString.equals("inferredReverseGeocoding"))
              {
                i = 4;
                continue;
                if (paramString.equals("inferredSnappedToRoad")) {
                  i = 5;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramObject instanceof PlaceReport)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramObject = (PlaceReport)paramObject;
      bool1 = bool2;
      if (zzz.equal(this.alV, ((PlaceReport)paramObject).alV))
      {
        bool1 = bool2;
        if (zzz.equal(this.mTag, ((PlaceReport)paramObject).mTag))
        {
          bool1 = bool2;
          if (zzz.equal(this.bQ, ((PlaceReport)paramObject).bQ)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public String getPlaceId()
  {
    return this.alV;
  }
  
  public String getSource()
  {
    return this.bQ;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    return zzz.hashCode(new Object[] { this.alV, this.mTag, this.bQ });
  }
  
  public String toString()
  {
    zzz.zza localzza = zzz.zzx(this);
    localzza.zzg("placeId", this.alV);
    localzza.zzg("tag", this.mTag);
    if (!"unknown".equals(this.bQ)) {
      localzza.zzg("source", this.bQ);
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\location\places\PlaceReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */