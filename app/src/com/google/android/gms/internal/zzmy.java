package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzmy
  extends zzg<zzmy>
{
  private ProductAction aP;
  private final Map<String, List<Product>> aQ = new HashMap();
  private final List<Promotion> aR = new ArrayList();
  private final List<Product> aS = new ArrayList();
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    if (!this.aS.isEmpty()) {
      localHashMap.put("products", this.aS);
    }
    if (!this.aR.isEmpty()) {
      localHashMap.put("promotions", this.aR);
    }
    if (!this.aQ.isEmpty()) {
      localHashMap.put("impressions", this.aQ);
    }
    localHashMap.put("productAction", this.aP);
    return zzj(localHashMap);
  }
  
  public void zza(Product paramProduct, String paramString)
  {
    if (paramProduct == null) {}
    for (;;)
    {
      return;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      if (!this.aQ.containsKey(str)) {
        this.aQ.put(str, new ArrayList());
      }
      ((List)this.aQ.get(str)).add(paramProduct);
    }
  }
  
  public void zza(zzmy paramzzmy)
  {
    paramzzmy.aS.addAll(this.aS);
    paramzzmy.aR.addAll(this.aR);
    Iterator localIterator = this.aQ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramzzmy.zza((Product)((Iterator)localObject).next(), str);
      }
    }
    if (this.aP != null) {
      paramzzmy.aP = this.aP;
    }
  }
  
  public ProductAction zzaav()
  {
    return this.aP;
  }
  
  public List<Product> zzaaw()
  {
    return Collections.unmodifiableList(this.aS);
  }
  
  public Map<String, List<Product>> zzaax()
  {
    return this.aQ;
  }
  
  public List<Promotion> zzaay()
  {
    return Collections.unmodifiableList(this.aR);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzmy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */