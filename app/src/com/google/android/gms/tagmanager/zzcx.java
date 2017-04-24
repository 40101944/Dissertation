package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzafw;
import com.google.android.gms.internal.zzafw.zza;
import com.google.android.gms.internal.zzafw.zzc;
import com.google.android.gms.internal.zzafw.zze;
import com.google.android.gms.internal.zzai.zzi;
import com.google.android.gms.internal.zzaj.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzcx
{
  private static final zzce<zzaj.zza> aGL = new zzce(zzdm.zzchm(), true);
  private final DataLayer aDZ;
  private final zzafw.zzc aGM;
  private final zzaj aGN;
  private final Map<String, zzam> aGO;
  private final Map<String, zzam> aGP;
  private final Map<String, zzam> aGQ;
  private final zzl<zzafw.zza, zzce<zzaj.zza>> aGR;
  private final zzl<String, zzb> aGS;
  private final Set<zzafw.zze> aGT;
  private final Map<String, zzc> aGU;
  private volatile String aGV;
  private int aGW;
  
  public zzcx(Context paramContext, zzafw.zzc paramzzc, DataLayer paramDataLayer, zzu.zza paramzza1, zzu.zza paramzza2, zzaj paramzzaj)
  {
    if (paramzzc == null) {
      throw new NullPointerException("resource cannot be null");
    }
    this.aGM = paramzzc;
    this.aGT = new HashSet(paramzzc.zzcjr());
    this.aDZ = paramDataLayer;
    this.aGN = paramzzaj;
    paramzzc = new zzm.zza()
    {
      public int zza(zzafw.zza paramAnonymouszza, zzce<zzaj.zza> paramAnonymouszzce)
      {
        return ((zzaj.zza)paramAnonymouszzce.getObject()).cy();
      }
    };
    this.aGR = new zzm().zza(1048576, paramzzc);
    paramzzc = new zzm.zza()
    {
      public int zza(String paramAnonymousString, zzcx.zzb paramAnonymouszzb)
      {
        return paramAnonymousString.length() + paramAnonymouszzb.getSize();
      }
    };
    this.aGS = new zzm().zza(1048576, paramzzc);
    this.aGO = new HashMap();
    zzb(new zzj(paramContext));
    zzb(new zzu(paramzza2));
    zzb(new zzy(paramDataLayer));
    zzb(new zzdn(paramContext, paramDataLayer));
    this.aGP = new HashMap();
    zzc(new zzs());
    zzc(new zzag());
    zzc(new zzah());
    zzc(new zzao());
    zzc(new zzap());
    zzc(new zzbk());
    zzc(new zzbl());
    zzc(new zzcn());
    zzc(new zzdg());
    this.aGQ = new HashMap();
    zza(new zzb(paramContext));
    zza(new zzc(paramContext));
    zza(new zze(paramContext));
    zza(new zzf(paramContext));
    zza(new zzg(paramContext));
    zza(new zzh(paramContext));
    zza(new zzi(paramContext));
    zza(new zzn());
    zza(new zzr(this.aGM.getVersion()));
    zza(new zzu(paramzza1));
    zza(new zzw(paramDataLayer));
    zza(new zzab(paramContext));
    zza(new zzac());
    zza(new zzaf());
    zza(new zzak(this));
    zza(new zzaq());
    zza(new zzar());
    zza(new zzbe(paramContext));
    zza(new zzbg());
    zza(new zzbj());
    zza(new zzbq());
    zza(new zzbs(paramContext));
    zza(new zzcf());
    zza(new zzch());
    zza(new zzck());
    zza(new zzcm());
    zza(new zzco(paramContext));
    zza(new zzcy());
    zza(new zzcz());
    zza(new zzdi());
    zza(new zzdo());
    this.aGU = new HashMap();
    paramContext = this.aGT.iterator();
    while (paramContext.hasNext())
    {
      paramzzc = (zzafw.zze)paramContext.next();
      for (int i = 0; i < paramzzc.zzcla().size(); i++)
      {
        paramDataLayer = (zzafw.zza)paramzzc.zzcla().get(i);
        paramzza1 = zzi(this.aGU, zza(paramDataLayer));
        paramzza1.zza(paramzzc);
        paramzza1.zza(paramzzc, paramDataLayer);
        paramzza1.zza(paramzzc, "Unknown");
      }
      for (i = 0; i < paramzzc.zzcld().size(); i++)
      {
        paramzza1 = (zzafw.zza)paramzzc.zzcld().get(i);
        paramDataLayer = zzi(this.aGU, zza(paramzza1));
        paramDataLayer.zza(paramzzc);
        paramDataLayer.zzb(paramzzc, paramzza1);
        paramDataLayer.zzb(paramzzc, "Unknown");
      }
    }
    paramzzc = this.aGM.zzckx().entrySet().iterator();
    while (paramzzc.hasNext())
    {
      paramzza1 = (Map.Entry)paramzzc.next();
      paramDataLayer = ((List)paramzza1.getValue()).iterator();
      while (paramDataLayer.hasNext())
      {
        paramContext = (zzafw.zza)paramDataLayer.next();
        if (!zzdm.zzk((zzaj.zza)paramContext.zzcjt().get(com.google.android.gms.internal.zzah.zzrr.toString())).booleanValue()) {
          zzi(this.aGU, (String)paramzza1.getKey()).zzb(paramContext);
        }
      }
    }
  }
  
  private zzce<zzaj.zza> zza(zzaj.zza paramzza, Set<String> paramSet, zzdp paramzzdp)
  {
    if (!paramzza.zzyh) {
      paramzza = new zzce(paramzza, true);
    }
    for (;;)
    {
      return paramzza;
      int i;
      Object localObject1;
      Object localObject2;
      switch (paramzza.type)
      {
      case 5: 
      case 6: 
      default: 
        i = paramzza.type;
        zzbo.e(25 + "Unknown type: " + i);
        paramzza = aGL;
        break;
      case 2: 
        localObject1 = zzafw.zzo(paramzza);
        ((zzaj.zza)localObject1).zzxy = new zzaj.zza[paramzza.zzxy.length];
        for (i = 0;; i++)
        {
          if (i >= paramzza.zzxy.length) {
            break label190;
          }
          localObject2 = zza(paramzza.zzxy[i], paramSet, paramzzdp.zzaac(i));
          if (localObject2 == aGL)
          {
            paramzza = aGL;
            break;
          }
          ((zzaj.zza)localObject1).zzxy[i] = ((zzaj.zza)((zzce)localObject2).getObject());
        }
        paramzza = new zzce(localObject1, false);
        break;
      case 3: 
        localObject1 = zzafw.zzo(paramzza);
        if (paramzza.zzxz.length != paramzza.zzya.length)
        {
          paramzza = String.valueOf(paramzza.toString());
          if (paramzza.length() != 0) {}
          for (paramzza = "Invalid serving value: ".concat(paramzza);; paramzza = new String("Invalid serving value: "))
          {
            zzbo.e(paramzza);
            paramzza = aGL;
            break;
          }
        }
        ((zzaj.zza)localObject1).zzxz = new zzaj.zza[paramzza.zzxz.length];
        ((zzaj.zza)localObject1).zzya = new zzaj.zza[paramzza.zzxz.length];
        for (i = 0;; i++)
        {
          if (i >= paramzza.zzxz.length) {
            break label415;
          }
          zzce localzzce = zza(paramzza.zzxz[i], paramSet, paramzzdp.zzaad(i));
          localObject2 = zza(paramzza.zzya[i], paramSet, paramzzdp.zzaae(i));
          if ((localzzce == aGL) || (localObject2 == aGL))
          {
            paramzza = aGL;
            break;
          }
          ((zzaj.zza)localObject1).zzxz[i] = ((zzaj.zza)localzzce.getObject());
          ((zzaj.zza)localObject1).zzya[i] = ((zzaj.zza)((zzce)localObject2).getObject());
        }
        paramzza = new zzce(localObject1, false);
        break;
      case 4: 
        if (paramSet.contains(paramzza.zzyb))
        {
          paramzza = String.valueOf(paramzza.zzyb);
          paramSet = String.valueOf(paramSet.toString());
          zzbo.e(String.valueOf(paramzza).length() + 79 + String.valueOf(paramSet).length() + "Macro cycle detected.  Current macro reference: " + paramzza + ".  Previous macro references: " + paramSet + ".");
          paramzza = aGL;
        }
        else
        {
          paramSet.add(paramzza.zzyb);
          paramzzdp = zzdq.zza(zza(paramzza.zzyb, paramSet, paramzzdp.zzcft()), paramzza.zzyg);
          paramSet.remove(paramzza.zzyb);
          paramzza = paramzzdp;
        }
        break;
      case 7: 
        label190:
        label415:
        localObject2 = zzafw.zzo(paramzza);
        ((zzaj.zza)localObject2).zzyf = new zzaj.zza[paramzza.zzyf.length];
        for (i = 0;; i++)
        {
          if (i >= paramzza.zzyf.length) {
            break label663;
          }
          localObject1 = zza(paramzza.zzyf[i], paramSet, paramzzdp.zzaaf(i));
          if (localObject1 == aGL)
          {
            paramzza = aGL;
            break;
          }
          ((zzaj.zza)localObject2).zzyf[i] = ((zzaj.zza)((zzce)localObject1).getObject());
        }
        label663:
        paramzza = new zzce(localObject2, false);
      }
    }
  }
  
  private zzce<zzaj.zza> zza(String paramString, Set<String> paramSet, zzbr paramzzbr)
  {
    this.aGW += 1;
    Object localObject = (zzb)this.aGS.get(paramString);
    if (localObject != null)
    {
      paramString = this.aGN;
      zza(((zzb)localObject).zzcgm(), paramSet);
      this.aGW -= 1;
    }
    for (paramString = ((zzb)localObject).zzcgl();; paramString = aGL)
    {
      return paramString;
      localObject = (zzc)this.aGU.get(paramString);
      if (localObject != null) {
        break;
      }
      paramSet = String.valueOf(zzcgk());
      zzbo.e(String.valueOf(paramSet).length() + 15 + String.valueOf(paramString).length() + paramSet + "Invalid macro: " + paramString);
      this.aGW -= 1;
    }
    zzce localzzce = zza(paramString, ((zzc)localObject).zzcgn(), ((zzc)localObject).zzcgo(), ((zzc)localObject).zzcgp(), ((zzc)localObject).zzcgr(), ((zzc)localObject).zzcgq(), paramSet, paramzzbr.zzcet());
    if (((Set)localzzce.getObject()).isEmpty()) {}
    for (localObject = ((zzc)localObject).zzcgs();; localObject = (zzafw.zza)((Set)localzzce.getObject()).iterator().next())
    {
      if (localObject != null) {
        break label336;
      }
      this.aGW -= 1;
      paramString = aGL;
      break;
      if (((Set)localzzce.getObject()).size() > 1)
      {
        localObject = String.valueOf(zzcgk());
        zzbo.zzdi(String.valueOf(localObject).length() + 37 + String.valueOf(paramString).length() + (String)localObject + "Multiple macros active for macroName " + paramString);
      }
    }
    label336:
    paramzzbr = zza(this.aGQ, (zzafw.zza)localObject, paramSet, paramzzbr.zzcfl());
    boolean bool;
    if ((localzzce.zzcfu()) && (paramzzbr.zzcfu()))
    {
      bool = true;
      label372:
      if (paramzzbr != aGL) {
        break label445;
      }
    }
    label445:
    for (paramzzbr = aGL;; paramzzbr = new zzce((zzaj.zza)paramzzbr.getObject(), bool))
    {
      localObject = ((zzafw.zza)localObject).zzcgm();
      if (paramzzbr.zzcfu()) {
        this.aGS.zzi(paramString, new zzb(paramzzbr, (zzaj.zza)localObject));
      }
      zza((zzaj.zza)localObject, paramSet);
      this.aGW -= 1;
      paramString = paramzzbr;
      break;
      bool = false;
      break label372;
    }
  }
  
  private zzce<zzaj.zza> zza(Map<String, zzam> paramMap, zzafw.zza paramzza, Set<String> paramSet, zzcp paramzzcp)
  {
    boolean bool = true;
    Object localObject1 = (zzaj.zza)paramzza.zzcjt().get(com.google.android.gms.internal.zzah.zzqa.toString());
    if (localObject1 == null)
    {
      zzbo.e("No function id in properties");
      paramMap = aGL;
    }
    zzam localzzam;
    int i;
    for (;;)
    {
      return paramMap;
      localObject1 = ((zzaj.zza)localObject1).zzyc;
      localzzam = (zzam)paramMap.get(localObject1);
      if (localzzam == null)
      {
        zzbo.e(String.valueOf(localObject1).concat(" has no backing implementation."));
        paramMap = aGL;
      }
      else
      {
        paramMap = (zzce)this.aGR.get(paramzza);
        if (paramMap != null)
        {
          paramzza = this.aGN;
        }
        else
        {
          paramMap = new HashMap();
          Iterator localIterator = paramzza.zzcjt().entrySet().iterator();
          i = 1;
          if (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            Object localObject2 = paramzzcp.zzpn((String)localEntry.getKey());
            localObject2 = zza((zzaj.zza)localEntry.getValue(), paramSet, ((zzcr)localObject2).zze((zzaj.zza)localEntry.getValue()));
            if (localObject2 == aGL)
            {
              paramMap = aGL;
            }
            else
            {
              if (((zzce)localObject2).zzcfu()) {
                paramzza.zza((String)localEntry.getKey(), (zzaj.zza)((zzce)localObject2).getObject());
              }
              for (;;)
              {
                paramMap.put((String)localEntry.getKey(), (zzaj.zza)((zzce)localObject2).getObject());
                break;
                i = 0;
              }
            }
          }
          else
          {
            if (localzzam.zzf(paramMap.keySet())) {
              break;
            }
            paramzza = String.valueOf(localzzam.zzcfh());
            paramMap = String.valueOf(paramMap.keySet());
            zzbo.e(String.valueOf(localObject1).length() + 43 + String.valueOf(paramzza).length() + String.valueOf(paramMap).length() + "Incorrect keys for function " + (String)localObject1 + " required " + paramzza + " had " + paramMap);
            paramMap = aGL;
          }
        }
      }
    }
    if ((i != 0) && (localzzam.zzcdu())) {}
    for (;;)
    {
      paramMap = new zzce(localzzam.zzay(paramMap), bool);
      if (bool) {
        this.aGR.zzi(paramzza, paramMap);
      }
      paramzzcp.zzd((zzaj.zza)paramMap.getObject());
      break;
      bool = false;
    }
  }
  
  private zzce<Set<zzafw.zza>> zza(Set<zzafw.zze> paramSet, Set<String> paramSet1, zza paramzza, zzcw paramzzcw)
  {
    HashSet localHashSet2 = new HashSet();
    HashSet localHashSet1 = new HashSet();
    Iterator localIterator = paramSet.iterator();
    boolean bool = true;
    if (localIterator.hasNext())
    {
      paramSet = (zzafw.zze)localIterator.next();
      zzcs localzzcs = paramzzcw.zzcfs();
      zzce localzzce = zza(paramSet, paramSet1, localzzcs);
      if (((Boolean)localzzce.getObject()).booleanValue()) {
        paramzza.zza(paramSet, localHashSet2, localHashSet1, localzzcs);
      }
      if ((bool) && (localzzce.zzcfu())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    localHashSet2.removeAll(localHashSet1);
    paramzzcw.zzg(localHashSet2);
    return new zzce(localHashSet2, bool);
  }
  
  private static String zza(zzafw.zza paramzza)
  {
    return zzdm.zzg((zzaj.zza)paramzza.zzcjt().get(com.google.android.gms.internal.zzah.zzqm.toString()));
  }
  
  private void zza(zzaj.zza paramzza, Set<String> paramSet)
  {
    if (paramzza == null) {}
    for (;;)
    {
      return;
      paramzza = zza(paramzza, paramSet, new zzcc());
      if (paramzza != aGL)
      {
        paramzza = zzdm.zzl((zzaj.zza)paramzza.getObject());
        if ((paramzza instanceof Map))
        {
          paramzza = (Map)paramzza;
          this.aDZ.push(paramzza);
        }
        else if ((paramzza instanceof List))
        {
          paramzza = ((List)paramzza).iterator();
          while (paramzza.hasNext())
          {
            paramSet = paramzza.next();
            if ((paramSet instanceof Map))
            {
              paramSet = (Map)paramSet;
              this.aDZ.push(paramSet);
            }
            else
            {
              zzbo.zzdi("pushAfterEvaluate: value not a Map");
            }
          }
        }
        else
        {
          zzbo.zzdi("pushAfterEvaluate: value not a Map or List");
        }
      }
    }
  }
  
  private static void zza(Map<String, zzam> paramMap, zzam paramzzam)
  {
    if (paramMap.containsKey(paramzzam.zzcfg()))
    {
      paramMap = String.valueOf(paramzzam.zzcfg());
      if (paramMap.length() != 0) {}
      for (paramMap = "Duplicate function type name: ".concat(paramMap);; paramMap = new String("Duplicate function type name: ")) {
        throw new IllegalArgumentException(paramMap);
      }
    }
    paramMap.put(paramzzam.zzcfg(), paramzzam);
  }
  
  private String zzcgk()
  {
    if (this.aGW <= 1) {}
    for (Object localObject = "";; localObject = ((StringBuilder)localObject).toString())
    {
      return (String)localObject;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Integer.toString(this.aGW));
      for (int i = 2; i < this.aGW; i++) {
        ((StringBuilder)localObject).append(' ');
      }
      ((StringBuilder)localObject).append(": ");
    }
  }
  
  private static zzc zzi(Map<String, zzc> paramMap, String paramString)
  {
    zzc localzzc2 = (zzc)paramMap.get(paramString);
    zzc localzzc1 = localzzc2;
    if (localzzc2 == null)
    {
      localzzc1 = new zzc();
      paramMap.put(paramString, localzzc1);
    }
    return localzzc1;
  }
  
  zzce<Boolean> zza(zzafw.zza paramzza, Set<String> paramSet, zzcp paramzzcp)
  {
    paramSet = zza(this.aGP, paramzza, paramSet, paramzzcp);
    paramzza = zzdm.zzk((zzaj.zza)paramSet.getObject());
    paramzzcp.zzd(zzdm.zzat(paramzza));
    return new zzce(paramzza, paramSet.zzcfu());
  }
  
  zzce<Boolean> zza(zzafw.zze paramzze, Set<String> paramSet, zzcs paramzzcs)
  {
    Object localObject = paramzze.zzcjw().iterator();
    boolean bool = true;
    zzce localzzce;
    if (((Iterator)localObject).hasNext())
    {
      localzzce = zza((zzafw.zza)((Iterator)localObject).next(), paramSet, paramzzcs.zzcfm());
      if (((Boolean)localzzce.getObject()).booleanValue())
      {
        paramzzcs.zzf(zzdm.zzat(Boolean.valueOf(false)));
        paramzze = new zzce(Boolean.valueOf(false), localzzce.zzcfu());
      }
    }
    for (;;)
    {
      return paramzze;
      if ((bool) && (localzzce.zzcfu())) {}
      for (bool = true;; bool = false) {
        break;
      }
      paramzze = paramzze.zzcjv().iterator();
      for (;;)
      {
        if (!paramzze.hasNext()) {
          break label231;
        }
        localObject = zza((zzafw.zza)paramzze.next(), paramSet, paramzzcs.zzcfn());
        if (!((Boolean)((zzce)localObject).getObject()).booleanValue())
        {
          paramzzcs.zzf(zzdm.zzat(Boolean.valueOf(false)));
          paramzze = new zzce(Boolean.valueOf(false), ((zzce)localObject).zzcfu());
          break;
        }
        if ((bool) && (((zzce)localObject).zzcfu())) {
          bool = true;
        } else {
          bool = false;
        }
      }
      label231:
      paramzzcs.zzf(zzdm.zzat(Boolean.valueOf(true)));
      paramzze = new zzce(Boolean.valueOf(true), bool);
    }
  }
  
  zzce<Set<zzafw.zza>> zza(String paramString, Set<zzafw.zze> paramSet, final Map<zzafw.zze, List<zzafw.zza>> paramMap1, final Map<zzafw.zze, List<String>> paramMap2, final Map<zzafw.zze, List<zzafw.zza>> paramMap3, final Map<zzafw.zze, List<String>> paramMap4, Set<String> paramSet1, zzcw paramzzcw)
  {
    zza(paramSet, paramSet1, new zza()
    {
      public void zza(zzafw.zze paramAnonymouszze, Set<zzafw.zza> paramAnonymousSet1, Set<zzafw.zza> paramAnonymousSet2, zzcs paramAnonymouszzcs)
      {
        List localList2 = (List)paramMap1.get(paramAnonymouszze);
        List localList1 = (List)paramMap2.get(paramAnonymouszze);
        if (localList2 != null)
        {
          paramAnonymousSet1.addAll(localList2);
          paramAnonymouszzcs.zzcfo().zzc(localList2, localList1);
        }
        paramAnonymousSet1 = (List)paramMap3.get(paramAnonymouszze);
        paramAnonymouszze = (List)paramMap4.get(paramAnonymouszze);
        if (paramAnonymousSet1 != null)
        {
          paramAnonymousSet2.addAll(paramAnonymousSet1);
          paramAnonymouszzcs.zzcfp().zzc(paramAnonymousSet1, paramAnonymouszze);
        }
      }
    }, paramzzcw);
  }
  
  zzce<Set<zzafw.zza>> zza(Set<zzafw.zze> paramSet, zzcw paramzzcw)
  {
    zza(paramSet, new HashSet(), new zza()
    {
      public void zza(zzafw.zze paramAnonymouszze, Set<zzafw.zza> paramAnonymousSet1, Set<zzafw.zza> paramAnonymousSet2, zzcs paramAnonymouszzcs)
      {
        paramAnonymousSet1.addAll(paramAnonymouszze.zzcjx());
        paramAnonymousSet2.addAll(paramAnonymouszze.zzcjy());
        paramAnonymouszzcs.zzcfq().zzc(paramAnonymouszze.zzcjx(), paramAnonymouszze.zzclb());
        paramAnonymouszzcs.zzcfr().zzc(paramAnonymouszze.zzcjy(), paramAnonymouszze.zzclc());
      }
    }, paramzzcw);
  }
  
  void zza(zzam paramzzam)
  {
    zza(this.aGQ, paramzzam);
  }
  
  public void zzam(List<zzai.zzi> paramList)
  {
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        Object localObject = (zzai.zzi)paramList.next();
        if ((((zzai.zzi)localObject).name == null) || (!((zzai.zzi)localObject).name.startsWith("gaExperiment:")))
        {
          localObject = String.valueOf(localObject);
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>(String.valueOf(localObject).length() + 22);
          zzbo.v("Ignored supplemental: " + (String)localObject);
        }
        else
        {
          zzal.zza(this.aDZ, (zzai.zzi)localObject);
        }
      }
      finally {}
    }
  }
  
  void zzb(zzam paramzzam)
  {
    zza(this.aGO, paramzzam);
  }
  
  void zzc(zzam paramzzam)
  {
    zza(this.aGP, paramzzam);
  }
  
  String zzcgj()
  {
    try
    {
      String str = this.aGV;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void zzov(String paramString)
  {
    try
    {
      zzps(paramString);
      zzai localzzai = this.aGN.zzpi(paramString);
      paramString = localzzai.zzcfe();
      Iterator localIterator = ((Set)zza(this.aGT, paramString.zzcet()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        zzafw.zza localzza = (zzafw.zza)localIterator.next();
        Map localMap = this.aGO;
        HashSet localHashSet = new java/util/HashSet;
        localHashSet.<init>();
        zza(localMap, localzza, localHashSet, paramString.zzces());
      }
      localzzai.zzcff();
    }
    finally {}
    zzps(null);
  }
  
  public zzce<zzaj.zza> zzpr(String paramString)
  {
    this.aGW = 0;
    zzai localzzai = this.aGN.zzph(paramString);
    paramString = zza(paramString, new HashSet(), localzzai.zzcfd());
    localzzai.zzcff();
    return paramString;
  }
  
  void zzps(String paramString)
  {
    try
    {
      this.aGV = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static abstract interface zza
  {
    public abstract void zza(zzafw.zze paramzze, Set<zzafw.zza> paramSet1, Set<zzafw.zza> paramSet2, zzcs paramzzcs);
  }
  
  private static class zzb
  {
    private zzce<zzaj.zza> aHc;
    private zzaj.zza aHd;
    
    public zzb(zzce<zzaj.zza> paramzzce, zzaj.zza paramzza)
    {
      this.aHc = paramzzce;
      this.aHd = paramzza;
    }
    
    public int getSize()
    {
      int j = ((zzaj.zza)this.aHc.getObject()).cy();
      if (this.aHd == null) {}
      for (int i = 0;; i = this.aHd.cy()) {
        return i + j;
      }
    }
    
    public zzce<zzaj.zza> zzcgl()
    {
      return this.aHc;
    }
    
    public zzaj.zza zzcgm()
    {
      return this.aHd;
    }
  }
  
  private static class zzc
  {
    private final Set<zzafw.zze> aGT = new HashSet();
    private final Map<zzafw.zze, List<zzafw.zza>> aHe = new HashMap();
    private final Map<zzafw.zze, List<zzafw.zza>> aHf = new HashMap();
    private final Map<zzafw.zze, List<String>> aHg = new HashMap();
    private final Map<zzafw.zze, List<String>> aHh = new HashMap();
    private zzafw.zza aHi;
    
    public void zza(zzafw.zze paramzze)
    {
      this.aGT.add(paramzze);
    }
    
    public void zza(zzafw.zze paramzze, zzafw.zza paramzza)
    {
      List localList = (List)this.aHe.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aHe.put(paramzze, localObject);
      }
      ((List)localObject).add(paramzza);
    }
    
    public void zza(zzafw.zze paramzze, String paramString)
    {
      List localList = (List)this.aHg.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aHg.put(paramzze, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void zzb(zzafw.zza paramzza)
    {
      this.aHi = paramzza;
    }
    
    public void zzb(zzafw.zze paramzze, zzafw.zza paramzza)
    {
      List localList = (List)this.aHf.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aHf.put(paramzze, localObject);
      }
      ((List)localObject).add(paramzza);
    }
    
    public void zzb(zzafw.zze paramzze, String paramString)
    {
      List localList = (List)this.aHh.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.aHh.put(paramzze, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public Set<zzafw.zze> zzcgn()
    {
      return this.aGT;
    }
    
    public Map<zzafw.zze, List<zzafw.zza>> zzcgo()
    {
      return this.aHe;
    }
    
    public Map<zzafw.zze, List<String>> zzcgp()
    {
      return this.aHg;
    }
    
    public Map<zzafw.zze, List<String>> zzcgq()
    {
      return this.aHh;
    }
    
    public Map<zzafw.zze, List<zzafw.zza>> zzcgr()
    {
      return this.aHf;
    }
    
    public zzafw.zza zzcgs()
    {
      return this.aHi;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\tagmanager\zzcx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */