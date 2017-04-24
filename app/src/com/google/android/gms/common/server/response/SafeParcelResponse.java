package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse
  extends FastSafeParcelableJsonResponse
{
  public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zze();
  private final FieldMappingDictionary Fo;
  private final Parcel Fv;
  private final int Fw;
  private int Fx;
  private int Fy;
  private final String mClassName;
  private final int mVersionCode;
  
  SafeParcelResponse(int paramInt, Parcel paramParcel, FieldMappingDictionary paramFieldMappingDictionary)
  {
    this.mVersionCode = paramInt;
    this.Fv = ((Parcel)zzaa.zzy(paramParcel));
    this.Fw = 2;
    this.Fo = paramFieldMappingDictionary;
    if (this.Fo == null) {}
    for (this.mClassName = null;; this.mClassName = this.Fo.zzaxn())
    {
      this.Fx = 2;
      return;
    }
  }
  
  private void zza(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(26 + "Unknown type = " + paramInt);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      for (;;)
      {
        return;
        paramStringBuilder.append("\"").append(zzp.zzii(paramObject.toString())).append("\"");
        continue;
        paramStringBuilder.append("\"").append(zzc.zzq((byte[])paramObject)).append("\"");
        continue;
        paramStringBuilder.append("\"").append(zzc.zzr((byte[])paramObject));
        paramStringBuilder.append("\"");
        continue;
        zzq.zza(paramStringBuilder, (HashMap)paramObject);
      }
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void zza(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Parcel paramParcel, int paramInt)
  {
    switch (paramField.zzaxc())
    {
    default: 
      paramInt = paramField.zzaxc();
      throw new IllegalArgumentException(36 + "Unknown field out type = " + paramInt);
    case 0: 
      zzb(paramStringBuilder, paramField, zza(paramField, Integer.valueOf(zza.zzg(paramParcel, paramInt))));
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      for (;;)
      {
        return;
        zzb(paramStringBuilder, paramField, zza(paramField, zza.zzk(paramParcel, paramInt)));
        continue;
        zzb(paramStringBuilder, paramField, zza(paramField, Long.valueOf(zza.zzi(paramParcel, paramInt))));
        continue;
        zzb(paramStringBuilder, paramField, zza(paramField, Float.valueOf(zza.zzl(paramParcel, paramInt))));
        continue;
        zzb(paramStringBuilder, paramField, zza(paramField, Double.valueOf(zza.zzn(paramParcel, paramInt))));
        continue;
        zzb(paramStringBuilder, paramField, zza(paramField, zza.zzp(paramParcel, paramInt)));
        continue;
        zzb(paramStringBuilder, paramField, zza(paramField, Boolean.valueOf(zza.zzc(paramParcel, paramInt))));
        continue;
        zzb(paramStringBuilder, paramField, zza(paramField, zza.zzq(paramParcel, paramInt)));
        continue;
        zzb(paramStringBuilder, paramField, zza(paramField, zza.zzt(paramParcel, paramInt)));
        continue;
        zzb(paramStringBuilder, paramField, zza(paramField, zzq(zza.zzs(paramParcel, paramInt))));
      }
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString, FastJsonResponse.Field<?, ?> paramField, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (paramField.zzaxi()) {
      zza(paramStringBuilder, paramField, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      zzb(paramStringBuilder, paramField, paramParcel, paramInt);
    }
  }
  
  private void zza(StringBuilder paramStringBuilder, Map<String, FastJsonResponse.Field<?, ?>> paramMap, Parcel paramParcel)
  {
    SparseArray localSparseArray = zzax(paramMap);
    paramStringBuilder.append('{');
    int j = zza.zzcr(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      paramMap = (Map.Entry)localSparseArray.get(zza.zzgu(k));
      if (paramMap != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        zza(paramStringBuilder, (String)paramMap.getKey(), (FastJsonResponse.Field)paramMap.getValue(), paramParcel, k);
        i = 1;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private static SparseArray<Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzax(Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    SparseArray localSparseArray = new SparseArray();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      localSparseArray.put(((FastJsonResponse.Field)paramMap.getValue()).zzaxf(), paramMap);
    }
    return localSparseArray;
  }
  
  private void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Parcel paramParcel, int paramInt)
  {
    if (paramField.zzaxd())
    {
      paramStringBuilder.append("[");
      switch (paramField.zzaxc())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, zza.zzw(paramParcel, paramInt));
        paramStringBuilder.append("]");
      }
    }
    for (;;)
    {
      return;
      com.google.android.gms.common.util.zzb.zza(paramStringBuilder, zza.zzy(paramParcel, paramInt));
      break;
      com.google.android.gms.common.util.zzb.zza(paramStringBuilder, zza.zzx(paramParcel, paramInt));
      break;
      com.google.android.gms.common.util.zzb.zza(paramStringBuilder, zza.zzz(paramParcel, paramInt));
      break;
      com.google.android.gms.common.util.zzb.zza(paramStringBuilder, zza.zzaa(paramParcel, paramInt));
      break;
      com.google.android.gms.common.util.zzb.zza(paramStringBuilder, zza.zzab(paramParcel, paramInt));
      break;
      com.google.android.gms.common.util.zzb.zza(paramStringBuilder, zza.zzv(paramParcel, paramInt));
      break;
      com.google.android.gms.common.util.zzb.zza(paramStringBuilder, zza.zzac(paramParcel, paramInt));
      break;
      throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
      paramParcel = zza.zzag(paramParcel, paramInt);
      int i = paramParcel.length;
      for (paramInt = 0; paramInt < i; paramInt++)
      {
        if (paramInt > 0) {
          paramStringBuilder.append(",");
        }
        paramParcel[paramInt].setDataPosition(0);
        zza(paramStringBuilder, paramField.zzaxk(), paramParcel[paramInt]);
      }
      break;
      switch (paramField.zzaxc())
      {
      default: 
        throw new IllegalStateException("Unknown field type out");
      case 0: 
        paramStringBuilder.append(zza.zzg(paramParcel, paramInt));
        break;
      case 1: 
        paramStringBuilder.append(zza.zzk(paramParcel, paramInt));
        break;
      case 2: 
        paramStringBuilder.append(zza.zzi(paramParcel, paramInt));
        break;
      case 3: 
        paramStringBuilder.append(zza.zzl(paramParcel, paramInt));
        break;
      case 4: 
        paramStringBuilder.append(zza.zzn(paramParcel, paramInt));
        break;
      case 5: 
        paramStringBuilder.append(zza.zzp(paramParcel, paramInt));
        break;
      case 6: 
        paramStringBuilder.append(zza.zzc(paramParcel, paramInt));
        break;
      case 7: 
        paramField = zza.zzq(paramParcel, paramInt);
        paramStringBuilder.append("\"").append(zzp.zzii(paramField)).append("\"");
        break;
      case 8: 
        paramField = zza.zzt(paramParcel, paramInt);
        paramStringBuilder.append("\"").append(zzc.zzq(paramField)).append("\"");
        break;
      case 9: 
        paramField = zza.zzt(paramParcel, paramInt);
        paramStringBuilder.append("\"").append(zzc.zzr(paramField));
        paramStringBuilder.append("\"");
        break;
      case 10: 
        paramField = zza.zzs(paramParcel, paramInt);
        paramParcel = paramField.keySet();
        paramParcel.size();
        paramStringBuilder.append("{");
        paramParcel = paramParcel.iterator();
        for (paramInt = 1; paramParcel.hasNext(); paramInt = 0)
        {
          String str = (String)paramParcel.next();
          if (paramInt == 0) {
            paramStringBuilder.append(",");
          }
          paramStringBuilder.append("\"").append(str).append("\"");
          paramStringBuilder.append(":");
          paramStringBuilder.append("\"").append(zzp.zzii(paramField.getString(str))).append("\"");
        }
        paramStringBuilder.append("}");
        break;
      case 11: 
        paramParcel = zza.zzaf(paramParcel, paramInt);
        paramParcel.setDataPosition(0);
        zza(paramStringBuilder, paramField.zzaxk(), paramParcel);
      }
    }
  }
  
  private void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Object paramObject)
  {
    if (paramField.zzaxb()) {
      zzb(paramStringBuilder, paramField, (ArrayList)paramObject);
    }
    for (;;)
    {
      return;
      zza(paramStringBuilder, paramField.zzaxa(), paramObject);
    }
  }
  
  private void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    for (int i = 0; i < j; i++)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      zza(paramStringBuilder, paramField.zzaxa(), paramArrayList.get(i));
    }
    paramStringBuilder.append("]");
  }
  
  public static HashMap<String, String> zzq(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    zzaa.zzb(this.Fo, "Cannot convert to JSON on client side.");
    Parcel localParcel = zzaxp();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    zza(localStringBuilder, this.Fo.zzig(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> zzawz()
  {
    if (this.Fo == null) {}
    for (Object localObject = null;; localObject = this.Fo.zzig(this.mClassName)) {
      return (Map<String, FastJsonResponse.Field<?, ?>>)localObject;
    }
  }
  
  public Parcel zzaxp()
  {
    switch (this.Fx)
    {
    }
    for (;;)
    {
      return this.Fv;
      this.Fy = com.google.android.gms.common.internal.safeparcel.zzb.zzcs(this.Fv);
      com.google.android.gms.common.internal.safeparcel.zzb.zzaj(this.Fv, this.Fy);
      this.Fx = 2;
      continue;
      com.google.android.gms.common.internal.safeparcel.zzb.zzaj(this.Fv, this.Fy);
      this.Fx = 2;
    }
  }
  
  FieldMappingDictionary zzaxq()
  {
    FieldMappingDictionary localFieldMappingDictionary;
    switch (this.Fw)
    {
    default: 
      int i = this.Fw;
      throw new IllegalStateException(34 + "Invalid creation type: " + i);
    case 0: 
      localFieldMappingDictionary = null;
    }
    for (;;)
    {
      return localFieldMappingDictionary;
      localFieldMappingDictionary = this.Fo;
      continue;
      localFieldMappingDictionary = this.Fo;
    }
  }
  
  public Object zzic(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public boolean zzid(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\common\server\response\SafeParcelResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */