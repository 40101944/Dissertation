package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzbo;
import com.google.android.gms.tagmanager.zzdm;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzafw
{
  private static zza zza(zzai.zzb paramzzb, zzai.zzf paramzzf, zzaj.zza[] paramArrayOfzza, int paramInt)
    throws zzafw.zzg
  {
    zzb localzzb = zza.zzcku();
    int[] arrayOfInt = paramzzb.zzvu;
    int i = arrayOfInt.length;
    paramInt = 0;
    if (paramInt < i)
    {
      int j = arrayOfInt[paramInt];
      Object localObject = (zzai.zze)zza(paramzzf.zzwk, Integer.valueOf(j).intValue(), "properties");
      paramzzb = (String)zza(paramzzf.zzwi, ((zzai.zze)localObject).key, "keys");
      localObject = (zzaj.zza)zza(paramArrayOfzza, ((zzai.zze)localObject).value, "values");
      if (zzah.zzst.toString().equals(paramzzb)) {
        localzzb.zzq((zzaj.zza)localObject);
      }
      for (;;)
      {
        paramInt++;
        break;
        localzzb.zzb(paramzzb, (zzaj.zza)localObject);
      }
    }
    return localzzb.zzckv();
  }
  
  private static zze zza(zzai.zzg paramzzg, List<zza> paramList1, List<zza> paramList2, List<zza> paramList3, zzai.zzf paramzzf)
  {
    zzf localzzf = zze.zzckz();
    int[] arrayOfInt = paramzzg.zzwy;
    int j = arrayOfInt.length;
    for (int i = 0; i < j; i++) {
      localzzf.zzd((zza)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
    }
    arrayOfInt = paramzzg.zzwz;
    j = arrayOfInt.length;
    for (i = 0; i < j; i++) {
      localzzf.zze((zza)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
    }
    paramList3 = paramzzg.zzxa;
    j = paramList3.length;
    for (i = 0; i < j; i++) {
      localzzf.zzf((zza)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
    }
    int k;
    for (k : paramzzg.zzxc) {
      localzzf.zzrj(paramzzf.zzwj[Integer.valueOf(k).intValue()].string);
    }
    paramList3 = paramzzg.zzxb;
    j = paramList3.length;
    for (i = 0; i < j; i++) {
      localzzf.zzg((zza)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
    }
    for (k : paramzzg.zzxd) {
      localzzf.zzrk(paramzzf.zzwj[Integer.valueOf(k).intValue()].string);
    }
    paramList1 = paramzzg.zzxe;
    j = paramList1.length;
    for (i = 0; i < j; i++) {
      localzzf.zzh((zza)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
    }
    for (k : paramzzg.zzxg) {
      localzzf.zzrl(paramzzf.zzwj[Integer.valueOf(k).intValue()].string);
    }
    paramList1 = paramzzg.zzxf;
    j = paramList1.length;
    for (i = 0; i < j; i++) {
      localzzf.zzi((zza)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
    }
    for (k : paramzzg.zzxh) {
      localzzf.zzrm(paramzzf.zzwj[Integer.valueOf(k).intValue()].string);
    }
    return localzzf.zzcle();
  }
  
  private static zzaj.zza zza(int paramInt, zzai.zzf paramzzf, zzaj.zza[] paramArrayOfzza, Set<Integer> paramSet)
    throws zzafw.zzg
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if (paramSet.contains(Integer.valueOf(paramInt)))
    {
      localObject1 = String.valueOf(paramSet);
      zzqt(String.valueOf(localObject1).length() + 90 + "Value cycle detected.  Current value reference: " + paramInt + ".  Previous value references: " + (String)localObject1 + ".");
    }
    zzaj.zza localzza1 = (zzaj.zza)zza(paramzzf.zzwj, paramInt, "values");
    if (paramArrayOfzza[paramInt] != null)
    {
      localObject1 = paramArrayOfzza[paramInt];
      return (zzaj.zza)localObject1;
    }
    Object localObject1 = null;
    paramSet.add(Integer.valueOf(paramInt));
    switch (localzza1.type)
    {
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        paramzzf = String.valueOf(localzza1);
        zzqt(String.valueOf(paramzzf).length() + 15 + "Invalid value: " + paramzzf);
      }
      paramArrayOfzza[paramInt] = localObject1;
      paramSet.remove(Integer.valueOf(paramInt));
      break;
      localObject1 = zzp(localzza1);
      zzaj.zza localzza2 = zzo(localzza1);
      localzza2.zzxy = new zzaj.zza[((zzai.zzh)localObject1).zzxk.length];
      Object localObject2 = ((zzai.zzh)localObject1).zzxk;
      k = localObject2.length;
      for (int i = 0;; i++)
      {
        localObject1 = localzza2;
        if (j >= k) {
          break;
        }
        m = localObject2[j];
        localzza2.zzxy[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j++;
      }
      localzza2 = zzo(localzza1);
      localObject2 = zzp(localzza1);
      if (((zzai.zzh)localObject2).zzxl.length != ((zzai.zzh)localObject2).zzxm.length)
      {
        j = ((zzai.zzh)localObject2).zzxl.length;
        i = ((zzai.zzh)localObject2).zzxm.length;
        zzqt(58 + "Uneven map keys (" + j + ") and map values (" + i + ")");
      }
      localzza2.zzxz = new zzaj.zza[((zzai.zzh)localObject2).zzxl.length];
      localzza2.zzya = new zzaj.zza[((zzai.zzh)localObject2).zzxl.length];
      localObject1 = ((zzai.zzh)localObject2).zzxl;
      m = localObject1.length;
      j = 0;
      for (i = 0; j < m; i++)
      {
        int n = localObject1[j];
        localzza2.zzxz[i] = zza(n, paramzzf, paramArrayOfzza, paramSet);
        j++;
      }
      localObject2 = ((zzai.zzh)localObject2).zzxm;
      m = localObject2.length;
      i = 0;
      j = k;
      for (;;)
      {
        localObject1 = localzza2;
        if (j >= m) {
          break;
        }
        k = localObject2[j];
        localzza2.zzya[i] = zza(k, paramzzf, paramArrayOfzza, paramSet);
        j++;
        i++;
      }
      localObject1 = zzo(localzza1);
      ((zzaj.zza)localObject1).zzyb = zzdm.zzg(zza(zzp(localzza1).zzxp, paramzzf, paramArrayOfzza, paramSet));
      continue;
      localzza2 = zzo(localzza1);
      localObject1 = zzp(localzza1);
      localzza2.zzyf = new zzaj.zza[((zzai.zzh)localObject1).zzxo.length];
      localObject2 = ((zzai.zzh)localObject1).zzxo;
      k = localObject2.length;
      i = 0;
      j = m;
      for (;;)
      {
        localObject1 = localzza2;
        if (j >= k) {
          break;
        }
        m = localObject2[j];
        localzza2.zzyf[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j++;
        i++;
      }
      localObject1 = localzza1;
    }
  }
  
  private static <T> T zza(T[] paramArrayOfT, int paramInt, String paramString)
    throws zzafw.zzg
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      zzqt(String.valueOf(paramString).length() + 45 + "Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  public static zzc zzb(zzai.zzf paramzzf)
    throws zzafw.zzg
  {
    int j = 0;
    Object localObject = new zzaj.zza[paramzzf.zzwj.length];
    for (int i = 0; i < paramzzf.zzwj.length; i++) {
      zza(i, paramzzf, (zzaj.zza[])localObject, new HashSet(0));
    }
    zzd localzzd = zzc.zzckw();
    ArrayList localArrayList1 = new ArrayList();
    for (i = 0; i < paramzzf.zzwm.length; i++) {
      localArrayList1.add(zza(paramzzf.zzwm[i], paramzzf, (zzaj.zza[])localObject, i));
    }
    ArrayList localArrayList3 = new ArrayList();
    for (i = 0; i < paramzzf.zzwn.length; i++) {
      localArrayList3.add(zza(paramzzf.zzwn[i], paramzzf, (zzaj.zza[])localObject, i));
    }
    ArrayList localArrayList2 = new ArrayList();
    for (i = 0; i < paramzzf.zzwl.length; i++)
    {
      zza localzza = zza(paramzzf.zzwl[i], paramzzf, (zzaj.zza[])localObject, i);
      localzzd.zzc(localzza);
      localArrayList2.add(localzza);
    }
    localObject = paramzzf.zzwo;
    int k = localObject.length;
    for (i = j; i < k; i++) {
      localzzd.zzb(zza(localObject[i], localArrayList1, localArrayList2, localArrayList3, paramzzf));
    }
    localzzd.zzri(paramzzf.version);
    localzzd.zzaao(paramzzf.zzww);
    return localzzd.zzcky();
  }
  
  public static void zzc(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static zzaj.zza zzo(zzaj.zza paramzza)
  {
    zzaj.zza localzza = new zzaj.zza();
    localzza.type = paramzza.type;
    localzza.zzyg = ((int[])paramzza.zzyg.clone());
    if (paramzza.zzyh) {
      localzza.zzyh = paramzza.zzyh;
    }
    return localzza;
  }
  
  private static zzai.zzh zzp(zzaj.zza paramzza)
    throws zzafw.zzg
  {
    if ((zzai.zzh)paramzza.zza(zzai.zzh.zzxi) == null)
    {
      String str = String.valueOf(paramzza);
      zzqt(String.valueOf(str).length() + 54 + "Expected a ServingValue and didn't get one. Value is: " + str);
    }
    return (zzai.zzh)paramzza.zza(zzai.zzh.zzxi);
  }
  
  private static void zzqt(String paramString)
    throws zzafw.zzg
  {
    zzbo.e(paramString);
    throw new zzg(paramString);
  }
  
  public static class zza
  {
    private final zzaj.zza aHd;
    private final Map<String, zzaj.zza> aLM;
    
    private zza(Map<String, zzaj.zza> paramMap, zzaj.zza paramzza)
    {
      this.aLM = paramMap;
      this.aHd = paramzza;
    }
    
    public static zzafw.zzb zzcku()
    {
      return new zzafw.zzb(null);
    }
    
    public String toString()
    {
      String str1 = String.valueOf(zzcjt());
      String str2 = String.valueOf(this.aHd);
      return String.valueOf(str1).length() + 32 + String.valueOf(str2).length() + "Properties: " + str1 + " pushAfterEvaluate: " + str2;
    }
    
    public void zza(String paramString, zzaj.zza paramzza)
    {
      this.aLM.put(paramString, paramzza);
    }
    
    public zzaj.zza zzcgm()
    {
      return this.aHd;
    }
    
    public Map<String, zzaj.zza> zzcjt()
    {
      return Collections.unmodifiableMap(this.aLM);
    }
  }
  
  public static class zzb
  {
    private zzaj.zza aHd;
    private final Map<String, zzaj.zza> aLM = new HashMap();
    
    public zzb zzb(String paramString, zzaj.zza paramzza)
    {
      this.aLM.put(paramString, paramzza);
      return this;
    }
    
    public zzafw.zza zzckv()
    {
      return new zzafw.zza(this.aLM, this.aHd, null);
    }
    
    public zzb zzq(zzaj.zza paramzza)
    {
      this.aHd = paramzza;
      return this;
    }
  }
  
  public static class zzc
  {
    private final List<zzafw.zze> aLJ;
    private final Map<String, List<zzafw.zza>> aLK;
    private final int aLL;
    private final String um;
    
    private zzc(List<zzafw.zze> paramList, Map<String, List<zzafw.zza>> paramMap, String paramString, int paramInt)
    {
      this.aLJ = Collections.unmodifiableList(paramList);
      this.aLK = Collections.unmodifiableMap(paramMap);
      this.um = paramString;
      this.aLL = paramInt;
    }
    
    public static zzafw.zzd zzckw()
    {
      return new zzafw.zzd(null);
    }
    
    public String getVersion()
    {
      return this.um;
    }
    
    public String toString()
    {
      String str2 = String.valueOf(zzcjr());
      String str1 = String.valueOf(this.aLK);
      return String.valueOf(str2).length() + 17 + String.valueOf(str1).length() + "Rules: " + str2 + "  Macros: " + str1;
    }
    
    public List<zzafw.zze> zzcjr()
    {
      return this.aLJ;
    }
    
    public Map<String, List<zzafw.zza>> zzckx()
    {
      return this.aLK;
    }
  }
  
  public static class zzd
  {
    private final List<zzafw.zze> aLJ = new ArrayList();
    private final Map<String, List<zzafw.zza>> aLK = new HashMap();
    private int aLL = 0;
    private String um = "";
    
    public zzd zzaao(int paramInt)
    {
      this.aLL = paramInt;
      return this;
    }
    
    public zzd zzb(zzafw.zze paramzze)
    {
      this.aLJ.add(paramzze);
      return this;
    }
    
    public zzd zzc(zzafw.zza paramzza)
    {
      String str = zzdm.zzg((zzaj.zza)paramzza.zzcjt().get(zzah.zzqm.toString()));
      List localList = (List)this.aLK.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aLK.put(str, localObject);
      }
      ((List)localObject).add(paramzza);
      return this;
    }
    
    public zzafw.zzc zzcky()
    {
      return new zzafw.zzc(this.aLJ, this.aLK, this.um, this.aLL, null);
    }
    
    public zzd zzri(String paramString)
    {
      this.um = paramString;
      return this;
    }
  }
  
  public static class zze
  {
    private final List<zzafw.zza> aLO;
    private final List<zzafw.zza> aLP;
    private final List<zzafw.zza> aLQ;
    private final List<zzafw.zza> aLR;
    private final List<String> aMA;
    private final List<String> aMB;
    private final List<String> aMC;
    private final List<zzafw.zza> aMx;
    private final List<zzafw.zza> aMy;
    private final List<String> aMz;
    
    private zze(List<zzafw.zza> paramList1, List<zzafw.zza> paramList2, List<zzafw.zza> paramList3, List<zzafw.zza> paramList4, List<zzafw.zza> paramList5, List<zzafw.zza> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
    {
      this.aLO = Collections.unmodifiableList(paramList1);
      this.aLP = Collections.unmodifiableList(paramList2);
      this.aLQ = Collections.unmodifiableList(paramList3);
      this.aLR = Collections.unmodifiableList(paramList4);
      this.aMx = Collections.unmodifiableList(paramList5);
      this.aMy = Collections.unmodifiableList(paramList6);
      this.aMz = Collections.unmodifiableList(paramList7);
      this.aMA = Collections.unmodifiableList(paramList8);
      this.aMB = Collections.unmodifiableList(paramList9);
      this.aMC = Collections.unmodifiableList(paramList10);
    }
    
    public static zzafw.zzf zzckz()
    {
      return new zzafw.zzf(null);
    }
    
    public String toString()
    {
      String str3 = String.valueOf(zzcjv());
      String str6 = String.valueOf(zzcjw());
      String str4 = String.valueOf(zzcjx());
      String str2 = String.valueOf(zzcjy());
      String str5 = String.valueOf(zzcla());
      String str1 = String.valueOf(zzcld());
      return String.valueOf(str3).length() + 102 + String.valueOf(str6).length() + String.valueOf(str4).length() + String.valueOf(str2).length() + String.valueOf(str5).length() + String.valueOf(str1).length() + "Positive predicates: " + str3 + "  Negative predicates: " + str6 + "  Add tags: " + str4 + "  Remove tags: " + str2 + "  Add macros: " + str5 + "  Remove macros: " + str1;
    }
    
    public List<zzafw.zza> zzcjv()
    {
      return this.aLO;
    }
    
    public List<zzafw.zza> zzcjw()
    {
      return this.aLP;
    }
    
    public List<zzafw.zza> zzcjx()
    {
      return this.aLQ;
    }
    
    public List<zzafw.zza> zzcjy()
    {
      return this.aLR;
    }
    
    public List<zzafw.zza> zzcla()
    {
      return this.aMx;
    }
    
    public List<String> zzclb()
    {
      return this.aMB;
    }
    
    public List<String> zzclc()
    {
      return this.aMC;
    }
    
    public List<zzafw.zza> zzcld()
    {
      return this.aMy;
    }
  }
  
  public static class zzf
  {
    private final List<zzafw.zza> aLO = new ArrayList();
    private final List<zzafw.zza> aLP = new ArrayList();
    private final List<zzafw.zza> aLQ = new ArrayList();
    private final List<zzafw.zza> aLR = new ArrayList();
    private final List<String> aMA = new ArrayList();
    private final List<String> aMB = new ArrayList();
    private final List<String> aMC = new ArrayList();
    private final List<zzafw.zza> aMx = new ArrayList();
    private final List<zzafw.zza> aMy = new ArrayList();
    private final List<String> aMz = new ArrayList();
    
    public zzafw.zze zzcle()
    {
      return new zzafw.zze(this.aLO, this.aLP, this.aLQ, this.aLR, this.aMx, this.aMy, this.aMz, this.aMA, this.aMB, this.aMC, null);
    }
    
    public zzf zzd(zzafw.zza paramzza)
    {
      this.aLO.add(paramzza);
      return this;
    }
    
    public zzf zze(zzafw.zza paramzza)
    {
      this.aLP.add(paramzza);
      return this;
    }
    
    public zzf zzf(zzafw.zza paramzza)
    {
      this.aLQ.add(paramzza);
      return this;
    }
    
    public zzf zzg(zzafw.zza paramzza)
    {
      this.aLR.add(paramzza);
      return this;
    }
    
    public zzf zzh(zzafw.zza paramzza)
    {
      this.aMx.add(paramzza);
      return this;
    }
    
    public zzf zzi(zzafw.zza paramzza)
    {
      this.aMy.add(paramzza);
      return this;
    }
    
    public zzf zzrj(String paramString)
    {
      this.aMB.add(paramString);
      return this;
    }
    
    public zzf zzrk(String paramString)
    {
      this.aMC.add(paramString);
      return this;
    }
    
    public zzf zzrl(String paramString)
    {
      this.aMz.add(paramString);
      return this;
    }
    
    public zzf zzrm(String paramString)
    {
      this.aMA.add(paramString);
      return this;
    }
  }
  
  public static class zzg
    extends Exception
  {
    public zzg(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzafw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */