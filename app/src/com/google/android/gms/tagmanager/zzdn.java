package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzaj.zza;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzdn
  extends zzdk
{
  private static final String ID = zzag.zzkn.toString();
  private static final String aIa = zzah.zzlw.toString();
  private static final String aIb = zzah.zzmh.toString();
  private static final String aIc = zzah.zzpg.toString();
  private static final String aId = zzah.zzoz.toString();
  private static final String aIe = zzah.zzoy.toString();
  private static final String aIf = zzah.zzmg.toString();
  private static final String aIg = zzah.zzuo.toString();
  private static final String aIh = zzah.zzur.toString();
  private static final String aIi = zzah.zzut.toString();
  private static final List<String> aIj = Arrays.asList(new String[] { "detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund" });
  private static final Pattern aIk = Pattern.compile("dimension(\\d+)");
  private static final Pattern aIl = Pattern.compile("metric(\\d+)");
  private static Map<String, String> aIm;
  private static Map<String, String> aIn;
  private final DataLayer aDZ;
  private final Set<String> aIo;
  private final zzdj aIp;
  
  public zzdn(Context paramContext, DataLayer paramDataLayer)
  {
    this(paramContext, paramDataLayer, new zzdj(paramContext));
  }
  
  zzdn(Context paramContext, DataLayer paramDataLayer, zzdj paramzzdj)
  {
    super(ID, new String[0]);
    this.aDZ = paramDataLayer;
    this.aIp = paramzzdj;
    this.aIo = new HashSet();
    this.aIo.add("");
    this.aIo.add("0");
    this.aIo.add("false");
  }
  
  private void zza(Tracker paramTracker, Map<String, zzaj.zza> paramMap)
  {
    String str = zzqc("transactionId");
    if (str == null) {
      zzbo.e("Cannot find transactionId in data layer.");
    }
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = zzm((zzaj.zza)paramMap.get(aIf));
        ((Map)localObject1).put("&t", "transaction");
        localObject2 = zzbk(paramMap).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          zze((Map)localObject1, (String)((Map.Entry)localObject3).getValue(), zzqc((String)((Map.Entry)localObject3).getKey()));
        }
      }
      catch (IllegalArgumentException paramTracker)
      {
        zzbo.zzb("Unable to send transaction", paramTracker);
      }
      localLinkedList.add(localObject1);
      Object localObject1 = zzqd("transactionProducts");
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label346;
          }
          localObject3 = (Map)((Iterator)localObject1).next();
          if (((Map)localObject3).get("name") == null)
          {
            zzbo.e("Unable to send transaction item hit due to missing 'name' field.");
            break;
          }
          localObject2 = zzm((zzaj.zza)paramMap.get(aIf));
          ((Map)localObject2).put("&t", "item");
          ((Map)localObject2).put("&ti", str);
          Iterator localIterator = zzbl(paramMap).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            zze((Map)localObject2, (String)localEntry.getValue(), (String)((Map)localObject3).get(localEntry.getKey()));
          }
          localLinkedList.add(localObject2);
        }
      }
      label346:
      paramMap = localLinkedList.iterator();
      while (paramMap.hasNext()) {
        paramTracker.send((Map)paramMap.next());
      }
    }
  }
  
  private Double zzax(Object paramObject)
  {
    if ((paramObject instanceof String)) {}
    for (;;)
    {
      try
      {
        paramObject = Double.valueOf((String)paramObject);
        return (Double)paramObject;
      }
      catch (NumberFormatException paramObject)
      {
        paramObject = String.valueOf(((NumberFormatException)paramObject).getMessage());
        if (((String)paramObject).length() == 0) {}
      }
      for (paramObject = "Cannot convert the object to Double: ".concat((String)paramObject);; paramObject = new String("Cannot convert the object to Double: ")) {
        throw new RuntimeException((String)paramObject);
      }
      if ((paramObject instanceof Integer))
      {
        paramObject = Double.valueOf(((Integer)paramObject).doubleValue());
      }
      else
      {
        if (!(paramObject instanceof Double)) {
          break;
        }
        paramObject = (Double)paramObject;
      }
    }
    paramObject = String.valueOf(paramObject.toString());
    if (((String)paramObject).length() != 0) {}
    for (paramObject = "Cannot convert the object to Double: ".concat((String)paramObject);; paramObject = new String("Cannot convert the object to Double: ")) {
      throw new RuntimeException((String)paramObject);
    }
  }
  
  private Integer zzay(Object paramObject)
  {
    if ((paramObject instanceof String)) {}
    for (;;)
    {
      try
      {
        paramObject = Integer.valueOf((String)paramObject);
        return (Integer)paramObject;
      }
      catch (NumberFormatException paramObject)
      {
        paramObject = String.valueOf(((NumberFormatException)paramObject).getMessage());
        if (((String)paramObject).length() == 0) {}
      }
      for (paramObject = "Cannot convert the object to Integer: ".concat((String)paramObject);; paramObject = new String("Cannot convert the object to Integer: ")) {
        throw new RuntimeException((String)paramObject);
      }
      if ((paramObject instanceof Double))
      {
        paramObject = Integer.valueOf(((Double)paramObject).intValue());
      }
      else
      {
        if (!(paramObject instanceof Integer)) {
          break;
        }
        paramObject = (Integer)paramObject;
      }
    }
    paramObject = String.valueOf(paramObject.toString());
    if (((String)paramObject).length() != 0) {}
    for (paramObject = "Cannot convert the object to Integer: ".concat((String)paramObject);; paramObject = new String("Cannot convert the object to Integer: ")) {
      throw new RuntimeException((String)paramObject);
    }
  }
  
  private void zzb(Tracker paramTracker, Map<String, zzaj.zza> paramMap)
  {
    HitBuilders.ScreenViewBuilder localScreenViewBuilder = new HitBuilders.ScreenViewBuilder();
    Object localObject1 = zzm((zzaj.zza)paramMap.get(aIf));
    localScreenViewBuilder.setAll((Map)localObject1);
    if (zzj(paramMap, aId))
    {
      paramMap = this.aDZ.get("ecommerce");
      if (!(paramMap instanceof Map)) {
        break label800;
      }
      paramMap = (Map)paramMap;
    }
    for (;;)
    {
      Object localObject4;
      label158:
      Object localObject2;
      if (paramMap != null)
      {
        localObject4 = (String)((Map)localObject1).get("&cu");
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = (String)paramMap.get("currencyCode");
        }
        if (localObject1 != null) {
          localScreenViewBuilder.set("&cu", (String)localObject1);
        }
        localObject1 = paramMap.get("impressions");
        if ((localObject1 instanceof List))
        {
          localObject4 = ((List)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject4).hasNext()) {
              break label292;
            }
            localObject1 = (Map)((Iterator)localObject4).next();
            try
            {
              localScreenViewBuilder.addImpression(zzbj((Map)localObject1), (String)((Map)localObject1).get("list"));
            }
            catch (RuntimeException localRuntimeException1)
            {
              localObject2 = String.valueOf(localRuntimeException1.getMessage());
              if (((String)localObject2).length() == 0) {}
            }
          }
          for (localObject2 = "Failed to extract a product from DataLayer. ".concat((String)localObject2);; localObject2 = new String("Failed to extract a product from DataLayer. "))
          {
            zzbo.e((String)localObject2);
            break label158;
            paramMap = zzdm.zzl((zzaj.zza)paramMap.get(aIe));
            if (!(paramMap instanceof Map)) {
              break label795;
            }
            paramMap = (Map)paramMap;
            break;
          }
        }
        label292:
        if (paramMap.containsKey("promoClick")) {
          localObject2 = (List)((Map)paramMap.get("promoClick")).get("promotions");
        }
      }
      for (;;)
      {
        label343:
        label473:
        int i;
        if (localObject2 != null)
        {
          localObject4 = ((List)localObject2).iterator();
          for (;;)
          {
            if (!((Iterator)localObject4).hasNext()) {
              break label473;
            }
            localObject2 = (Map)((Iterator)localObject4).next();
            try
            {
              localScreenViewBuilder.addPromotion(zzbi((Map)localObject2));
            }
            catch (RuntimeException localRuntimeException2)
            {
              localObject3 = String.valueOf(localRuntimeException2.getMessage());
              if (((String)localObject3).length() == 0) {}
            }
          }
          for (localObject3 = "Failed to extract a promotion from DataLayer. ".concat((String)localObject3);; localObject3 = new String("Failed to extract a promotion from DataLayer. "))
          {
            zzbo.e((String)localObject3);
            break label343;
            if (!paramMap.containsKey("promoView")) {
              break label789;
            }
            localObject3 = (List)((Map)paramMap.get("promoView")).get("promotions");
            break;
          }
          if (paramMap.containsKey("promoClick"))
          {
            localScreenViewBuilder.set("&promoa", "click");
            i = 0;
            if (i == 0) {
              break label721;
            }
            localObject4 = aIj.iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject3 = (String)((Iterator)localObject4).next();
            } while (!paramMap.containsKey(localObject3));
            localObject4 = (Map)paramMap.get(localObject3);
            paramMap = (List)((Map)localObject4).get("products");
            if (paramMap == null) {
              break label681;
            }
            Iterator localIterator = paramMap.iterator();
            for (;;)
            {
              label584:
              if (!localIterator.hasNext()) {
                break label681;
              }
              paramMap = (Map)localIterator.next();
              try
              {
                localScreenViewBuilder.addProduct(zzbj(paramMap));
              }
              catch (RuntimeException paramMap)
              {
                paramMap = String.valueOf(paramMap.getMessage());
                if (paramMap.length() == 0) {}
              }
            }
          }
        }
        for (paramMap = "Failed to extract a product from DataLayer. ".concat(paramMap);; paramMap = new String("Failed to extract a product from DataLayer. "))
        {
          zzbo.e(paramMap);
          break label584;
          localScreenViewBuilder.set("&promoa", "view");
          i = 1;
          break;
        }
        try
        {
          label681:
          if (((Map)localObject4).containsKey("actionField")) {}
          for (paramMap = zzi((String)localObject3, (Map)((Map)localObject4).get("actionField"));; paramMap = new ProductAction((String)localObject3))
          {
            localScreenViewBuilder.setProductAction(paramMap);
            label721:
            paramTracker.send(localScreenViewBuilder.build());
            return;
          }
          paramMap = "Failed to extract a product action from DataLayer. ".concat(paramMap);
        }
        catch (RuntimeException paramMap)
        {
          paramMap = String.valueOf(paramMap.getMessage());
          if (paramMap.length() == 0) {}
        }
        for (;;)
        {
          zzbo.e(paramMap);
          break;
          paramMap = new String("Failed to extract a product action from DataLayer. ");
        }
        label789:
        Object localObject3 = null;
      }
      label795:
      paramMap = null;
      continue;
      label800:
      paramMap = null;
    }
  }
  
  private Promotion zzbi(Map<String, String> paramMap)
  {
    Promotion localPromotion = new Promotion();
    String str = (String)paramMap.get("id");
    if (str != null) {
      localPromotion.setId(String.valueOf(str));
    }
    str = (String)paramMap.get("name");
    if (str != null) {
      localPromotion.setName(String.valueOf(str));
    }
    str = (String)paramMap.get("creative");
    if (str != null) {
      localPromotion.setCreative(String.valueOf(str));
    }
    paramMap = (String)paramMap.get("position");
    if (paramMap != null) {
      localPromotion.setPosition(String.valueOf(paramMap));
    }
    return localPromotion;
  }
  
  private Product zzbj(Map<String, Object> paramMap)
  {
    Product localProduct = new Product();
    Object localObject = paramMap.get("id");
    if (localObject != null) {
      localProduct.setId(String.valueOf(localObject));
    }
    localObject = paramMap.get("name");
    if (localObject != null) {
      localProduct.setName(String.valueOf(localObject));
    }
    localObject = paramMap.get("brand");
    if (localObject != null) {
      localProduct.setBrand(String.valueOf(localObject));
    }
    localObject = paramMap.get("category");
    if (localObject != null) {
      localProduct.setCategory(String.valueOf(localObject));
    }
    localObject = paramMap.get("variant");
    if (localObject != null) {
      localProduct.setVariant(String.valueOf(localObject));
    }
    localObject = paramMap.get("coupon");
    if (localObject != null) {
      localProduct.setCouponCode(String.valueOf(localObject));
    }
    localObject = paramMap.get("position");
    if (localObject != null) {
      localProduct.setPosition(zzay(localObject).intValue());
    }
    localObject = paramMap.get("price");
    if (localObject != null) {
      localProduct.setPrice(zzax(localObject).doubleValue());
    }
    localObject = paramMap.get("quantity");
    if (localObject != null) {
      localProduct.setQuantity(zzay(localObject).intValue());
    }
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label455;
      }
      localObject = (String)localIterator.next();
      Matcher localMatcher1 = aIk.matcher((CharSequence)localObject);
      int i;
      if (localMatcher1.matches())
      {
        try
        {
          i = Integer.parseInt(localMatcher1.group(1));
          localProduct.setCustomDimension(i, String.valueOf(paramMap.get(localObject)));
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localObject = String.valueOf(localObject);
          if (((String)localObject).length() == 0) {}
        }
        for (localObject = "illegal number in custom dimension value: ".concat((String)localObject);; localObject = new String("illegal number in custom dimension value: "))
        {
          zzbo.zzdi((String)localObject);
          break;
        }
      }
      else
      {
        Matcher localMatcher2 = aIl.matcher((CharSequence)localObject);
        if (localMatcher2.matches()) {
          try
          {
            i = Integer.parseInt(localMatcher2.group(1));
            localProduct.setCustomMetric(i, zzay(paramMap.get(localObject)).intValue());
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            localObject = String.valueOf(localObject);
            if (((String)localObject).length() == 0) {}
          }
        }
      }
    }
    for (localObject = "illegal number in custom metric value: ".concat((String)localObject);; localObject = new String("illegal number in custom metric value: "))
    {
      zzbo.zzdi((String)localObject);
      break;
    }
    label455:
    return localProduct;
  }
  
  private Map<String, String> zzbk(Map<String, zzaj.zza> paramMap)
  {
    paramMap = (zzaj.zza)paramMap.get(aIh);
    if (paramMap != null) {}
    for (paramMap = zzc(paramMap);; paramMap = aIm)
    {
      return paramMap;
      if (aIm == null)
      {
        paramMap = new HashMap();
        paramMap.put("transactionId", "&ti");
        paramMap.put("transactionAffiliation", "&ta");
        paramMap.put("transactionTax", "&tt");
        paramMap.put("transactionShipping", "&ts");
        paramMap.put("transactionTotal", "&tr");
        paramMap.put("transactionCurrency", "&cu");
        aIm = paramMap;
      }
    }
  }
  
  private Map<String, String> zzbl(Map<String, zzaj.zza> paramMap)
  {
    paramMap = (zzaj.zza)paramMap.get(aIi);
    if (paramMap != null) {}
    for (paramMap = zzc(paramMap);; paramMap = aIn)
    {
      return paramMap;
      if (aIn == null)
      {
        paramMap = new HashMap();
        paramMap.put("name", "&in");
        paramMap.put("sku", "&ic");
        paramMap.put("category", "&iv");
        paramMap.put("price", "&ip");
        paramMap.put("quantity", "&iq");
        paramMap.put("currency", "&cu");
        aIn = paramMap;
      }
    }
  }
  
  private Map<String, String> zzc(zzaj.zza paramzza)
  {
    paramzza = zzdm.zzl(paramzza);
    if (!(paramzza instanceof Map)) {
      paramzza = null;
    }
    for (;;)
    {
      return paramzza;
      Object localObject = (Map)paramzza;
      paramzza = new LinkedHashMap();
      Iterator localIterator = ((Map)localObject).entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        paramzza.put(((Map.Entry)localObject).getKey().toString(), ((Map.Entry)localObject).getValue().toString());
      }
    }
  }
  
  private void zze(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private ProductAction zzi(String paramString, Map<String, Object> paramMap)
  {
    paramString = new ProductAction(paramString);
    Object localObject = paramMap.get("id");
    if (localObject != null) {
      paramString.setTransactionId(String.valueOf(localObject));
    }
    localObject = paramMap.get("affiliation");
    if (localObject != null) {
      paramString.setTransactionAffiliation(String.valueOf(localObject));
    }
    localObject = paramMap.get("coupon");
    if (localObject != null) {
      paramString.setTransactionCouponCode(String.valueOf(localObject));
    }
    localObject = paramMap.get("list");
    if (localObject != null) {
      paramString.setProductActionList(String.valueOf(localObject));
    }
    localObject = paramMap.get("option");
    if (localObject != null) {
      paramString.setCheckoutOptions(String.valueOf(localObject));
    }
    localObject = paramMap.get("revenue");
    if (localObject != null) {
      paramString.setTransactionRevenue(zzax(localObject).doubleValue());
    }
    localObject = paramMap.get("tax");
    if (localObject != null) {
      paramString.setTransactionTax(zzax(localObject).doubleValue());
    }
    localObject = paramMap.get("shipping");
    if (localObject != null) {
      paramString.setTransactionShipping(zzax(localObject).doubleValue());
    }
    paramMap = paramMap.get("step");
    if (paramMap != null) {
      paramString.setCheckoutStep(zzay(paramMap).intValue());
    }
    return paramString;
  }
  
  private boolean zzj(Map<String, zzaj.zza> paramMap, String paramString)
  {
    paramMap = (zzaj.zza)paramMap.get(paramString);
    if (paramMap == null) {}
    for (boolean bool = false;; bool = zzdm.zzk(paramMap).booleanValue()) {
      return bool;
    }
  }
  
  private Map<String, String> zzm(zzaj.zza paramzza)
  {
    if (paramzza == null) {
      paramzza = new HashMap();
    }
    for (;;)
    {
      return paramzza;
      paramzza = zzc(paramzza);
      if (paramzza == null)
      {
        paramzza = new HashMap();
      }
      else
      {
        String str = (String)paramzza.get("&aip");
        if ((str != null) && (this.aIo.contains(str.toLowerCase()))) {
          paramzza.remove("&aip");
        }
      }
    }
  }
  
  private String zzqc(String paramString)
  {
    paramString = this.aDZ.get(paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.toString()) {
      return paramString;
    }
  }
  
  private List<Map<String, String>> zzqd(String paramString)
  {
    Object localObject = this.aDZ.get(paramString);
    if (localObject == null) {}
    for (paramString = null;; paramString = (List)localObject)
    {
      return paramString;
      if (!(localObject instanceof List)) {
        throw new IllegalArgumentException("transactionProducts should be of type List.");
      }
      paramString = ((List)localObject).iterator();
      while (paramString.hasNext()) {
        if (!(paramString.next() instanceof Map)) {
          throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
        }
      }
    }
  }
  
  public void zzba(Map<String, zzaj.zza> paramMap)
  {
    Tracker localTracker = this.aIp.zzpu("_GTM_DEFAULT_TRACKER_");
    localTracker.enableAdvertisingIdCollection(zzj(paramMap, "collect_adid"));
    if (zzj(paramMap, aIc)) {
      zzb(localTracker, paramMap);
    }
    for (;;)
    {
      return;
      if (zzj(paramMap, aIb)) {
        localTracker.send(zzm((zzaj.zza)paramMap.get(aIf)));
      } else if (zzj(paramMap, aIg)) {
        zza(localTracker, paramMap);
      } else {
        zzbo.zzdi("Ignoring unknown tag.");
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */