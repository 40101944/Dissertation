package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HitBuilders
{
  @Deprecated
  public static class AppViewBuilder
    extends HitBuilders.HitBuilder<AppViewBuilder>
  {
    public AppViewBuilder()
    {
      set("&t", "screenview");
    }
  }
  
  public static class EventBuilder
    extends HitBuilders.HitBuilder<EventBuilder>
  {
    public EventBuilder()
    {
      set("&t", "event");
    }
    
    public EventBuilder(String paramString1, String paramString2)
    {
      this();
      setCategory(paramString1);
      setAction(paramString2);
    }
    
    public EventBuilder setAction(String paramString)
    {
      set("&ea", paramString);
      return this;
    }
    
    public EventBuilder setCategory(String paramString)
    {
      set("&ec", paramString);
      return this;
    }
    
    public EventBuilder setLabel(String paramString)
    {
      set("&el", paramString);
      return this;
    }
    
    public EventBuilder setValue(long paramLong)
    {
      set("&ev", Long.toString(paramLong));
      return this;
    }
  }
  
  public static class ExceptionBuilder
    extends HitBuilders.HitBuilder<ExceptionBuilder>
  {
    public ExceptionBuilder()
    {
      set("&t", "exception");
    }
    
    public ExceptionBuilder setDescription(String paramString)
    {
      set("&exd", paramString);
      return this;
    }
    
    public ExceptionBuilder setFatal(boolean paramBoolean)
    {
      set("&exf", zzao.zzax(paramBoolean));
      return this;
    }
  }
  
  protected static class HitBuilder<T extends HitBuilder>
  {
    private Map<String, String> aO = new HashMap();
    ProductAction aP;
    Map<String, List<Product>> aQ = new HashMap();
    List<Promotion> aR = new ArrayList();
    List<Product> aS = new ArrayList();
    
    private T zzn(String paramString1, String paramString2)
    {
      if (paramString1 != null) {
        if (paramString2 != null) {
          this.aO.put(paramString1, paramString2);
        }
      }
      for (;;)
      {
        return this;
        zzae.zzdi("HitBuilder.setIfNonNull() called with a null paramName.");
      }
    }
    
    public T addImpression(Product paramProduct, String paramString)
    {
      if (paramProduct == null) {
        zzae.zzdi("product should be non-null");
      }
      for (;;)
      {
        return this;
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
    
    public T addProduct(Product paramProduct)
    {
      if (paramProduct == null) {
        zzae.zzdi("product should be non-null");
      }
      for (;;)
      {
        return this;
        this.aS.add(paramProduct);
      }
    }
    
    public T addPromotion(Promotion paramPromotion)
    {
      if (paramPromotion == null) {
        zzae.zzdi("promotion should be non-null");
      }
      for (;;)
      {
        return this;
        this.aR.add(paramPromotion);
      }
    }
    
    public Map<String, String> build()
    {
      HashMap localHashMap = new HashMap(this.aO);
      if (this.aP != null) {
        localHashMap.putAll(this.aP.build());
      }
      Object localObject = this.aR.iterator();
      for (int i = 1; ((Iterator)localObject).hasNext(); i++) {
        localHashMap.putAll(((Promotion)((Iterator)localObject).next()).zzep(zzc.zzbr(i)));
      }
      localObject = this.aS.iterator();
      for (i = 1; ((Iterator)localObject).hasNext(); i++) {
        localHashMap.putAll(((Product)((Iterator)localObject).next()).zzep(zzc.zzbp(i)));
      }
      Iterator localIterator1 = this.aQ.entrySet().iterator();
      i = 1;
      if (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        localObject = (List)localEntry.getValue();
        String str1 = zzc.zzbu(i);
        Iterator localIterator2 = ((List)localObject).iterator();
        int j = 1;
        if (localIterator2.hasNext())
        {
          Product localProduct = (Product)localIterator2.next();
          String str2 = String.valueOf(str1);
          localObject = String.valueOf(zzc.zzbt(j));
          if (((String)localObject).length() != 0) {}
          for (localObject = str2.concat((String)localObject);; localObject = new String(str2))
          {
            localHashMap.putAll(localProduct.zzep((String)localObject));
            j++;
            break;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localEntry.getKey()))
        {
          str1 = String.valueOf(str1);
          localObject = String.valueOf("nm");
          if (((String)localObject).length() == 0) {
            break label352;
          }
        }
        label352:
        for (localObject = str1.concat((String)localObject);; localObject = new String(str1))
        {
          localHashMap.put(localObject, (String)localEntry.getKey());
          i++;
          break;
        }
      }
      return localHashMap;
    }
    
    protected String get(String paramString)
    {
      return (String)this.aO.get(paramString);
    }
    
    public final T set(String paramString1, String paramString2)
    {
      if (paramString1 != null) {
        this.aO.put(paramString1, paramString2);
      }
      for (;;)
      {
        return this;
        zzae.zzdi("HitBuilder.set() called with a null paramName.");
      }
    }
    
    public final T setAll(Map<String, String> paramMap)
    {
      if (paramMap == null) {}
      for (;;)
      {
        return this;
        this.aO.putAll(new HashMap(paramMap));
      }
    }
    
    public T setCampaignParamsFromUrl(String paramString)
    {
      paramString = zzao.zzfk(paramString);
      if (TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        return this;
        paramString = zzao.zzfi(paramString);
        zzn("&cc", (String)paramString.get("utm_content"));
        zzn("&cm", (String)paramString.get("utm_medium"));
        zzn("&cn", (String)paramString.get("utm_campaign"));
        zzn("&cs", (String)paramString.get("utm_source"));
        zzn("&ck", (String)paramString.get("utm_term"));
        zzn("&ci", (String)paramString.get("utm_id"));
        zzn("&anid", (String)paramString.get("anid"));
        zzn("&gclid", (String)paramString.get("gclid"));
        zzn("&dclid", (String)paramString.get("dclid"));
        zzn("&aclid", (String)paramString.get("aclid"));
        zzn("&gmob_t", (String)paramString.get("gmob_t"));
      }
    }
    
    public T setCustomDimension(int paramInt, String paramString)
    {
      set(zzc.zzbl(paramInt), paramString);
      return this;
    }
    
    public T setCustomMetric(int paramInt, float paramFloat)
    {
      set(zzc.zzbn(paramInt), Float.toString(paramFloat));
      return this;
    }
    
    protected T setHitType(String paramString)
    {
      set("&t", paramString);
      return this;
    }
    
    public T setNewSession()
    {
      set("&sc", "start");
      return this;
    }
    
    public T setNonInteraction(boolean paramBoolean)
    {
      set("&ni", zzao.zzax(paramBoolean));
      return this;
    }
    
    public T setProductAction(ProductAction paramProductAction)
    {
      this.aP = paramProductAction;
      return this;
    }
    
    public T setPromotionAction(String paramString)
    {
      this.aO.put("&promoa", paramString);
      return this;
    }
  }
  
  @Deprecated
  public static class ItemBuilder
    extends HitBuilders.HitBuilder<ItemBuilder>
  {
    public ItemBuilder()
    {
      set("&t", "item");
    }
    
    public ItemBuilder setCategory(String paramString)
    {
      set("&iv", paramString);
      return this;
    }
    
    public ItemBuilder setCurrencyCode(String paramString)
    {
      set("&cu", paramString);
      return this;
    }
    
    public ItemBuilder setName(String paramString)
    {
      set("&in", paramString);
      return this;
    }
    
    public ItemBuilder setPrice(double paramDouble)
    {
      set("&ip", Double.toString(paramDouble));
      return this;
    }
    
    public ItemBuilder setQuantity(long paramLong)
    {
      set("&iq", Long.toString(paramLong));
      return this;
    }
    
    public ItemBuilder setSku(String paramString)
    {
      set("&ic", paramString);
      return this;
    }
    
    public ItemBuilder setTransactionId(String paramString)
    {
      set("&ti", paramString);
      return this;
    }
  }
  
  public static class ScreenViewBuilder
    extends HitBuilders.HitBuilder<ScreenViewBuilder>
  {
    public ScreenViewBuilder()
    {
      set("&t", "screenview");
    }
  }
  
  public static class SocialBuilder
    extends HitBuilders.HitBuilder<SocialBuilder>
  {
    public SocialBuilder()
    {
      set("&t", "social");
    }
    
    public SocialBuilder setAction(String paramString)
    {
      set("&sa", paramString);
      return this;
    }
    
    public SocialBuilder setNetwork(String paramString)
    {
      set("&sn", paramString);
      return this;
    }
    
    public SocialBuilder setTarget(String paramString)
    {
      set("&st", paramString);
      return this;
    }
  }
  
  public static class TimingBuilder
    extends HitBuilders.HitBuilder<TimingBuilder>
  {
    public TimingBuilder()
    {
      set("&t", "timing");
    }
    
    public TimingBuilder(String paramString1, String paramString2, long paramLong)
    {
      this();
      setVariable(paramString2);
      setValue(paramLong);
      setCategory(paramString1);
    }
    
    public TimingBuilder setCategory(String paramString)
    {
      set("&utc", paramString);
      return this;
    }
    
    public TimingBuilder setLabel(String paramString)
    {
      set("&utl", paramString);
      return this;
    }
    
    public TimingBuilder setValue(long paramLong)
    {
      set("&utt", Long.toString(paramLong));
      return this;
    }
    
    public TimingBuilder setVariable(String paramString)
    {
      set("&utv", paramString);
      return this;
    }
  }
  
  @Deprecated
  public static class TransactionBuilder
    extends HitBuilders.HitBuilder<TransactionBuilder>
  {
    public TransactionBuilder()
    {
      set("&t", "transaction");
    }
    
    public TransactionBuilder setAffiliation(String paramString)
    {
      set("&ta", paramString);
      return this;
    }
    
    public TransactionBuilder setCurrencyCode(String paramString)
    {
      set("&cu", paramString);
      return this;
    }
    
    public TransactionBuilder setRevenue(double paramDouble)
    {
      set("&tr", Double.toString(paramDouble));
      return this;
    }
    
    public TransactionBuilder setShipping(double paramDouble)
    {
      set("&ts", Double.toString(paramDouble));
      return this;
    }
    
    public TransactionBuilder setTax(double paramDouble)
    {
      set("&tt", Double.toString(paramDouble));
      return this;
    }
    
    public TransactionBuilder setTransactionId(String paramString)
    {
      set("&ti", paramString);
      return this;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\HitBuilders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */