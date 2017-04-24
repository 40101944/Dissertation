package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzc;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.common.internal.zzaa;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Product
{
  Map<String, String> cB = new HashMap();
  
  void put(String paramString1, String paramString2)
  {
    zzaa.zzb(paramString1, "Name should be non-null");
    this.cB.put(paramString1, paramString2);
  }
  
  public Product setBrand(String paramString)
  {
    put("br", paramString);
    return this;
  }
  
  public Product setCategory(String paramString)
  {
    put("ca", paramString);
    return this;
  }
  
  public Product setCouponCode(String paramString)
  {
    put("cc", paramString);
    return this;
  }
  
  public Product setCustomDimension(int paramInt, String paramString)
  {
    put(zzc.zzbw(paramInt), paramString);
    return this;
  }
  
  public Product setCustomMetric(int paramInt1, int paramInt2)
  {
    put(zzc.zzbx(paramInt1), Integer.toString(paramInt2));
    return this;
  }
  
  public Product setId(String paramString)
  {
    put("id", paramString);
    return this;
  }
  
  public Product setName(String paramString)
  {
    put("nm", paramString);
    return this;
  }
  
  public Product setPosition(int paramInt)
  {
    put("ps", Integer.toString(paramInt));
    return this;
  }
  
  public Product setPrice(double paramDouble)
  {
    put("pr", Double.toString(paramDouble));
    return this;
  }
  
  public Product setQuantity(int paramInt)
  {
    put("qt", Integer.toString(paramInt));
    return this;
  }
  
  public Product setVariant(String paramString)
  {
    put("va", paramString);
    return this;
  }
  
  public String toString()
  {
    return zzg.zzar(this.cB);
  }
  
  public Map<String, String> zzep(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.cB.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = String.valueOf(paramString);
      String str2 = String.valueOf((String)localEntry.getKey());
      if (str2.length() != 0) {}
      for (str1 = str1.concat(str2);; str1 = new String(str1))
      {
        localHashMap.put(str1, (String)localEntry.getValue());
        break;
      }
    }
    return localHashMap;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\ecommerce\Product.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */