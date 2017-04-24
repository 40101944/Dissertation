package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzai
{
  public static final class zza
    extends zzaru<zza>
  {
    public int level;
    public int zzvr;
    public int zzvs;
    
    public zza()
    {
      zzac();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if ((paramObject instanceof zza))
        {
          paramObject = (zza)paramObject;
          bool1 = bool2;
          if (this.level == ((zza)paramObject).level)
          {
            bool1 = bool2;
            if (this.zzvr == ((zza)paramObject).zzvr)
            {
              bool1 = bool2;
              if (this.zzvs == ((zza)paramObject).zzvs) {
                if ((this.btG == null) || (this.btG.isEmpty()))
                {
                  if (((zza)paramObject).btG != null)
                  {
                    bool1 = bool2;
                    if (!((zza)paramObject).btG.isEmpty()) {}
                  }
                  else
                  {
                    bool1 = true;
                  }
                }
                else {
                  bool1 = this.btG.equals(((zza)paramObject).btG);
                }
              }
            }
          }
        }
      }
    }
    
    public int hashCode()
    {
      int m = getClass().getName().hashCode();
      int k = this.level;
      int j = this.zzvr;
      int n = this.zzvs;
      if ((this.btG == null) || (this.btG.isEmpty())) {}
      for (int i = 0;; i = this.btG.hashCode()) {
        return i + ((((m + 527) * 31 + k) * 31 + j) * 31 + n) * 31;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      if (this.level != 1) {
        paramzzart.zzaf(1, this.level);
      }
      if (this.zzvr != 0) {
        paramzzart.zzaf(2, this.zzvr);
      }
      if (this.zzvs != 0) {
        paramzzart.zzaf(3, this.zzvs);
      }
      super.zza(paramzzart);
    }
    
    public zza zzac()
    {
      this.level = 1;
      this.zzvr = 0;
      this.zzvs = 0;
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    public zza zzn(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        switch (i)
        {
        default: 
          if (super.zza(paramzzars, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          i = paramzzars.bY();
          switch (i)
          {
          default: 
            break;
          case 1: 
          case 2: 
          case 3: 
            this.level = i;
          }
          break;
        case 16: 
          this.zzvr = paramzzars.bY();
          break;
        case 24: 
          this.zzvs = paramzzars.bY();
        }
      }
    }
    
    protected int zzx()
    {
      int j = super.zzx();
      int i = j;
      if (this.level != 1) {
        i = j + zzart.zzah(1, this.level);
      }
      j = i;
      if (this.zzvr != 0) {
        j = i + zzart.zzah(2, this.zzvr);
      }
      i = j;
      if (this.zzvs != 0) {
        i = j + zzart.zzah(3, this.zzvs);
      }
      return i;
    }
  }
  
  public static final class zzb
    extends zzaru<zzb>
  {
    private static volatile zzb[] zzvt;
    public int name;
    public int[] zzvu;
    public int zzvv;
    public boolean zzvw;
    public boolean zzvx;
    
    public zzb()
    {
      zzae();
    }
    
    public static zzb[] zzad()
    {
      if (zzvt == null) {}
      synchronized (zzary.btO)
      {
        if (zzvt == null) {
          zzvt = new zzb[0];
        }
        return zzvt;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if ((paramObject instanceof zzb))
        {
          paramObject = (zzb)paramObject;
          bool1 = bool2;
          if (zzary.equals(this.zzvu, ((zzb)paramObject).zzvu))
          {
            bool1 = bool2;
            if (this.zzvv == ((zzb)paramObject).zzvv)
            {
              bool1 = bool2;
              if (this.name == ((zzb)paramObject).name)
              {
                bool1 = bool2;
                if (this.zzvw == ((zzb)paramObject).zzvw)
                {
                  bool1 = bool2;
                  if (this.zzvx == ((zzb)paramObject).zzvx) {
                    if ((this.btG == null) || (this.btG.isEmpty()))
                    {
                      if (((zzb)paramObject).btG != null)
                      {
                        bool1 = bool2;
                        if (!((zzb)paramObject).btG.isEmpty()) {}
                      }
                      else
                      {
                        bool1 = true;
                      }
                    }
                    else {
                      bool1 = this.btG.equals(((zzb)paramObject).btG);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public int hashCode()
    {
      int j = 1231;
      int m = getClass().getName().hashCode();
      int n = zzary.hashCode(this.zzvu);
      int i2 = this.zzvv;
      int i1 = this.name;
      int i;
      if (this.zzvw)
      {
        i = 1231;
        if (!this.zzvx) {
          break label121;
        }
        label55:
        if ((this.btG != null) && (!this.btG.isEmpty())) {
          break label128;
        }
      }
      label121:
      label128:
      for (int k = 0;; k = this.btG.hashCode())
      {
        return k + ((i + ((((m + 527) * 31 + n) * 31 + i2) * 31 + i1) * 31) * 31 + j) * 31;
        i = 1237;
        break;
        j = 1237;
        break label55;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      if (this.zzvx) {
        paramzzart.zzg(1, this.zzvx);
      }
      paramzzart.zzaf(2, this.zzvv);
      if ((this.zzvu != null) && (this.zzvu.length > 0)) {
        for (int i = 0; i < this.zzvu.length; i++) {
          paramzzart.zzaf(3, this.zzvu[i]);
        }
      }
      if (this.name != 0) {
        paramzzart.zzaf(4, this.name);
      }
      if (this.zzvw) {
        paramzzart.zzg(6, this.zzvw);
      }
      super.zza(paramzzart);
    }
    
    public zzb zzae()
    {
      this.zzvu = zzasd.btR;
      this.zzvv = 0;
      this.name = 0;
      this.zzvw = false;
      this.zzvx = false;
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    public zzb zzo(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        int j;
        int[] arrayOfInt;
        switch (i)
        {
        default: 
          if (super.zza(paramzzars, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.zzvx = paramzzars.ca();
          break;
        case 16: 
          this.zzvv = paramzzars.bY();
          break;
        case 24: 
          j = zzasd.zzc(paramzzars, 24);
          if (this.zzvu == null) {}
          for (i = 0;; i = this.zzvu.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzvu, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzvu = arrayOfInt;
          break;
        case 26: 
          int k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzvu == null) {}
          for (i = 0;; i = this.zzvu.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzvu, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzvu = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 32: 
          this.name = paramzzars.bY();
          break;
        case 48: 
          this.zzvw = paramzzars.ca();
        }
      }
    }
    
    protected int zzx()
    {
      int j = 0;
      int k = super.zzx();
      int i = k;
      if (this.zzvx) {
        i = k + zzart.zzh(1, this.zzvx);
      }
      k = zzart.zzah(2, this.zzvv) + i;
      if ((this.zzvu != null) && (this.zzvu.length > 0))
      {
        int m = 0;
        i = j;
        for (j = m; j < this.zzvu.length; j++) {
          i += zzart.zzagz(this.zzvu[j]);
        }
      }
      for (j = k + i + this.zzvu.length * 1;; j = k)
      {
        i = j;
        if (this.name != 0) {
          i = j + zzart.zzah(4, this.name);
        }
        j = i;
        if (this.zzvw) {
          j = i + zzart.zzh(6, this.zzvw);
        }
        return j;
      }
    }
  }
  
  public static final class zzc
    extends zzaru<zzc>
  {
    private static volatile zzc[] zzvy;
    public String zzcb;
    public long zzvz;
    public long zzwa;
    public boolean zzwb;
    public long zzwc;
    
    public zzc()
    {
      zzag();
    }
    
    public static zzc[] zzaf()
    {
      if (zzvy == null) {}
      synchronized (zzary.btO)
      {
        if (zzvy == null) {
          zzvy = new zzc[0];
        }
        return zzvy;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if ((paramObject instanceof zzc))
        {
          paramObject = (zzc)paramObject;
          if (this.zzcb == null)
          {
            bool1 = bool2;
            if (((zzc)paramObject).zzcb != null) {}
          }
          else
          {
            while (this.zzcb.equals(((zzc)paramObject).zzcb))
            {
              bool1 = bool2;
              if (this.zzvz != ((zzc)paramObject).zzvz) {
                break;
              }
              bool1 = bool2;
              if (this.zzwa != ((zzc)paramObject).zzwa) {
                break;
              }
              bool1 = bool2;
              if (this.zzwb != ((zzc)paramObject).zzwb) {
                break;
              }
              bool1 = bool2;
              if (this.zzwc != ((zzc)paramObject).zzwc) {
                break;
              }
              if ((this.btG != null) && (!this.btG.isEmpty())) {
                break label156;
              }
              if (((zzc)paramObject).btG != null)
              {
                bool1 = bool2;
                if (!((zzc)paramObject).btG.isEmpty()) {
                  break;
                }
              }
              bool1 = true;
              break;
            }
            bool1 = bool2;
            continue;
            label156:
            bool1 = this.btG.equals(((zzc)paramObject).btG);
          }
        }
      }
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int i1;
      int i2;
      int j;
      label65:
      int i3;
      if (this.zzcb == null)
      {
        i = 0;
        i1 = (int)(this.zzvz ^ this.zzvz >>> 32);
        i2 = (int)(this.zzwa ^ this.zzwa >>> 32);
        if (!this.zzwb) {
          break label154;
        }
        j = 1231;
        i3 = (int)(this.zzwc ^ this.zzwc >>> 32);
        k = m;
        if (this.btG != null) {
          if (!this.btG.isEmpty()) {
            break label161;
          }
        }
      }
      label154:
      label161:
      for (int k = m;; k = this.btG.hashCode())
      {
        return ((j + (((i + (n + 527) * 31) * 31 + i1) * 31 + i2) * 31) * 31 + i3) * 31 + k;
        i = this.zzcb.hashCode();
        break;
        j = 1237;
        break label65;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      if ((this.zzcb != null) && (!this.zzcb.equals(""))) {
        paramzzart.zzq(1, this.zzcb);
      }
      if (this.zzvz != 0L) {
        paramzzart.zzb(2, this.zzvz);
      }
      if (this.zzwa != 2147483647L) {
        paramzzart.zzb(3, this.zzwa);
      }
      if (this.zzwb) {
        paramzzart.zzg(4, this.zzwb);
      }
      if (this.zzwc != 0L) {
        paramzzart.zzb(5, this.zzwc);
      }
      super.zza(paramzzart);
    }
    
    public zzc zzag()
    {
      this.zzcb = "";
      this.zzvz = 0L;
      this.zzwa = 2147483647L;
      this.zzwb = false;
      this.zzwc = 0L;
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    public zzc zzp(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        switch (i)
        {
        default: 
          if (super.zza(paramzzars, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.zzcb = paramzzars.readString();
          break;
        case 16: 
          this.zzvz = paramzzars.bX();
          break;
        case 24: 
          this.zzwa = paramzzars.bX();
          break;
        case 32: 
          this.zzwb = paramzzars.ca();
          break;
        case 40: 
          this.zzwc = paramzzars.bX();
        }
      }
    }
    
    protected int zzx()
    {
      int i = super.zzx();
      int j = i;
      if (this.zzcb != null)
      {
        j = i;
        if (!this.zzcb.equals("")) {
          j = i + zzart.zzr(1, this.zzcb);
        }
      }
      i = j;
      if (this.zzvz != 0L) {
        i = j + zzart.zzf(2, this.zzvz);
      }
      j = i;
      if (this.zzwa != 2147483647L) {
        j = i + zzart.zzf(3, this.zzwa);
      }
      i = j;
      if (this.zzwb) {
        i = j + zzart.zzh(4, this.zzwb);
      }
      j = i;
      if (this.zzwc != 0L) {
        j = i + zzart.zzf(5, this.zzwc);
      }
      return j;
    }
  }
  
  public static final class zzd
    extends zzaru<zzd>
  {
    public zzaj.zza[] zzwd;
    public zzaj.zza[] zzwe;
    public zzai.zzc[] zzwf;
    
    public zzd()
    {
      zzah();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if ((paramObject instanceof zzd))
        {
          paramObject = (zzd)paramObject;
          bool1 = bool2;
          if (zzary.equals(this.zzwd, ((zzd)paramObject).zzwd))
          {
            bool1 = bool2;
            if (zzary.equals(this.zzwe, ((zzd)paramObject).zzwe))
            {
              bool1 = bool2;
              if (zzary.equals(this.zzwf, ((zzd)paramObject).zzwf)) {
                if ((this.btG == null) || (this.btG.isEmpty()))
                {
                  if (((zzd)paramObject).btG != null)
                  {
                    bool1 = bool2;
                    if (!((zzd)paramObject).btG.isEmpty()) {}
                  }
                  else
                  {
                    bool1 = true;
                  }
                }
                else {
                  bool1 = this.btG.equals(((zzd)paramObject).btG);
                }
              }
            }
          }
        }
      }
    }
    
    public int hashCode()
    {
      int m = getClass().getName().hashCode();
      int k = zzary.hashCode(this.zzwd);
      int j = zzary.hashCode(this.zzwe);
      int n = zzary.hashCode(this.zzwf);
      if ((this.btG == null) || (this.btG.isEmpty())) {}
      for (int i = 0;; i = this.btG.hashCode()) {
        return i + ((((m + 527) * 31 + k) * 31 + j) * 31 + n) * 31;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.zzwd != null) && (this.zzwd.length > 0)) {
        for (i = 0; i < this.zzwd.length; i++)
        {
          localObject = this.zzwd[i];
          if (localObject != null) {
            paramzzart.zza(1, (zzasa)localObject);
          }
        }
      }
      if ((this.zzwe != null) && (this.zzwe.length > 0)) {
        for (i = 0; i < this.zzwe.length; i++)
        {
          localObject = this.zzwe[i];
          if (localObject != null) {
            paramzzart.zza(2, (zzasa)localObject);
          }
        }
      }
      if ((this.zzwf != null) && (this.zzwf.length > 0)) {
        for (i = j; i < this.zzwf.length; i++)
        {
          localObject = this.zzwf[i];
          if (localObject != null) {
            paramzzart.zza(3, (zzasa)localObject);
          }
        }
      }
      super.zza(paramzzart);
    }
    
    public zzd zzah()
    {
      this.zzwd = zzaj.zza.zzar();
      this.zzwe = zzaj.zza.zzar();
      this.zzwf = zzai.zzc.zzaf();
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    public zzd zzq(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (super.zza(paramzzars, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = zzasd.zzc(paramzzars, 10);
          if (this.zzwd == null) {}
          for (i = 0;; i = this.zzwd.length)
          {
            localObject = new zzaj.zza[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwd, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zzaj.zza();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zzaj.zza();
          paramzzars.zza(localObject[j]);
          this.zzwd = ((zzaj.zza[])localObject);
          break;
        case 18: 
          j = zzasd.zzc(paramzzars, 18);
          if (this.zzwe == null) {}
          for (i = 0;; i = this.zzwe.length)
          {
            localObject = new zzaj.zza[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwe, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zzaj.zza();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zzaj.zza();
          paramzzars.zza(localObject[j]);
          this.zzwe = ((zzaj.zza[])localObject);
          break;
        case 26: 
          j = zzasd.zzc(paramzzars, 26);
          if (this.zzwf == null) {}
          for (i = 0;; i = this.zzwf.length)
          {
            localObject = new zzai.zzc[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwf, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zzai.zzc();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zzai.zzc();
          paramzzars.zza(localObject[j]);
          this.zzwf = ((zzai.zzc[])localObject);
        }
      }
    }
    
    protected int zzx()
    {
      int m = 0;
      int i = super.zzx();
      int j = i;
      Object localObject;
      if (this.zzwd != null)
      {
        j = i;
        if (this.zzwd.length > 0)
        {
          k = 0;
          while (k < this.zzwd.length)
          {
            localObject = this.zzwd[k];
            j = i;
            if (localObject != null) {
              j = i + zzart.zzc(1, (zzasa)localObject);
            }
            k++;
            i = j;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzwe != null)
      {
        i = j;
        if (this.zzwe.length > 0)
        {
          i = j;
          k = 0;
          while (k < this.zzwe.length)
          {
            localObject = this.zzwe[k];
            j = i;
            if (localObject != null) {
              j = i + zzart.zzc(2, (zzasa)localObject);
            }
            k++;
            i = j;
          }
        }
      }
      int k = i;
      if (this.zzwf != null)
      {
        k = i;
        if (this.zzwf.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= this.zzwf.length) {
              break;
            }
            localObject = this.zzwf[j];
            k = i;
            if (localObject != null) {
              k = i + zzart.zzc(3, (zzasa)localObject);
            }
            j++;
            i = k;
          }
        }
      }
      return k;
    }
  }
  
  public static final class zze
    extends zzaru<zze>
  {
    private static volatile zze[] zzwg;
    public int key;
    public int value;
    
    public zze()
    {
      zzaj();
    }
    
    public static zze[] zzai()
    {
      if (zzwg == null) {}
      synchronized (zzary.btO)
      {
        if (zzwg == null) {
          zzwg = new zze[0];
        }
        return zzwg;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if ((paramObject instanceof zze))
        {
          paramObject = (zze)paramObject;
          bool1 = bool2;
          if (this.key == ((zze)paramObject).key)
          {
            bool1 = bool2;
            if (this.value == ((zze)paramObject).value) {
              if ((this.btG == null) || (this.btG.isEmpty()))
              {
                if (((zze)paramObject).btG != null)
                {
                  bool1 = bool2;
                  if (!((zze)paramObject).btG.isEmpty()) {}
                }
                else
                {
                  bool1 = true;
                }
              }
              else {
                bool1 = this.btG.equals(((zze)paramObject).btG);
              }
            }
          }
        }
      }
    }
    
    public int hashCode()
    {
      int k = getClass().getName().hashCode();
      int j = this.key;
      int m = this.value;
      if ((this.btG == null) || (this.btG.isEmpty())) {}
      for (int i = 0;; i = this.btG.hashCode()) {
        return i + (((k + 527) * 31 + j) * 31 + m) * 31;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      paramzzart.zzaf(1, this.key);
      paramzzart.zzaf(2, this.value);
      super.zza(paramzzart);
    }
    
    public zze zzaj()
    {
      this.key = 0;
      this.value = 0;
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    public zze zzr(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        switch (i)
        {
        default: 
          if (super.zza(paramzzars, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.key = paramzzars.bY();
          break;
        case 16: 
          this.value = paramzzars.bY();
        }
      }
    }
    
    protected int zzx()
    {
      return super.zzx() + zzart.zzah(1, this.key) + zzart.zzah(2, this.value);
    }
  }
  
  public static final class zzf
    extends zzaru<zzf>
  {
    public String version;
    public String[] zzwh;
    public String[] zzwi;
    public zzaj.zza[] zzwj;
    public zzai.zze[] zzwk;
    public zzai.zzb[] zzwl;
    public zzai.zzb[] zzwm;
    public zzai.zzb[] zzwn;
    public zzai.zzg[] zzwo;
    public String zzwp;
    public String zzwq;
    public String zzwr;
    public zzai.zza zzws;
    public float zzwt;
    public boolean zzwu;
    public String[] zzwv;
    public int zzww;
    
    public zzf()
    {
      zzak();
    }
    
    public static zzf zzf(byte[] paramArrayOfByte)
      throws zzarz
    {
      return (zzf)zzasa.zza(new zzf(), paramArrayOfByte);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if ((paramObject instanceof zzf))
        {
          paramObject = (zzf)paramObject;
          bool1 = bool2;
          if (zzary.equals(this.zzwh, ((zzf)paramObject).zzwh))
          {
            bool1 = bool2;
            if (zzary.equals(this.zzwi, ((zzf)paramObject).zzwi))
            {
              bool1 = bool2;
              if (zzary.equals(this.zzwj, ((zzf)paramObject).zzwj))
              {
                bool1 = bool2;
                if (zzary.equals(this.zzwk, ((zzf)paramObject).zzwk))
                {
                  bool1 = bool2;
                  if (zzary.equals(this.zzwl, ((zzf)paramObject).zzwl))
                  {
                    bool1 = bool2;
                    if (zzary.equals(this.zzwm, ((zzf)paramObject).zzwm))
                    {
                      bool1 = bool2;
                      if (zzary.equals(this.zzwn, ((zzf)paramObject).zzwn))
                      {
                        bool1 = bool2;
                        if (zzary.equals(this.zzwo, ((zzf)paramObject).zzwo))
                        {
                          if (this.zzwp == null)
                          {
                            bool1 = bool2;
                            if (((zzf)paramObject).zzwp != null) {
                              continue;
                            }
                            label169:
                            if (this.zzwq != null) {
                              break label354;
                            }
                            bool1 = bool2;
                            if (((zzf)paramObject).zzwq != null) {
                              continue;
                            }
                            label185:
                            if (this.zzwr != null) {
                              break label373;
                            }
                            bool1 = bool2;
                            if (((zzf)paramObject).zzwr != null) {
                              continue;
                            }
                            label201:
                            if (this.version != null) {
                              break label392;
                            }
                            bool1 = bool2;
                            if (((zzf)paramObject).version != null) {
                              continue;
                            }
                            label217:
                            if (this.zzws != null) {
                              break label411;
                            }
                            bool1 = bool2;
                            if (((zzf)paramObject).zzws != null) {
                              continue;
                            }
                          }
                          label354:
                          label373:
                          label392:
                          label411:
                          while (this.zzws.equals(((zzf)paramObject).zzws))
                          {
                            bool1 = bool2;
                            if (Float.floatToIntBits(this.zzwt) != Float.floatToIntBits(((zzf)paramObject).zzwt)) {
                              break;
                            }
                            bool1 = bool2;
                            if (this.zzwu != ((zzf)paramObject).zzwu) {
                              break;
                            }
                            bool1 = bool2;
                            if (!zzary.equals(this.zzwv, ((zzf)paramObject).zzwv)) {
                              break;
                            }
                            bool1 = bool2;
                            if (this.zzww != ((zzf)paramObject).zzww) {
                              break;
                            }
                            if ((this.btG != null) && (!this.btG.isEmpty())) {
                              break label430;
                            }
                            if (((zzf)paramObject).btG != null)
                            {
                              bool1 = bool2;
                              if (!((zzf)paramObject).btG.isEmpty()) {
                                break;
                              }
                            }
                            bool1 = true;
                            break;
                            if (this.zzwp.equals(((zzf)paramObject).zzwp)) {
                              break label169;
                            }
                            bool1 = bool2;
                            break;
                            if (this.zzwq.equals(((zzf)paramObject).zzwq)) {
                              break label185;
                            }
                            bool1 = bool2;
                            break;
                            if (this.zzwr.equals(((zzf)paramObject).zzwr)) {
                              break label201;
                            }
                            bool1 = bool2;
                            break;
                            if (this.version.equals(((zzf)paramObject).version)) {
                              break label217;
                            }
                            bool1 = bool2;
                            break;
                          }
                          bool1 = bool2;
                          continue;
                          label430:
                          bool1 = this.btG.equals(((zzf)paramObject).btG);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public int hashCode()
    {
      int i3 = 0;
      int i4 = getClass().getName().hashCode();
      int i12 = zzary.hashCode(this.zzwh);
      int i10 = zzary.hashCode(this.zzwi);
      int i9 = zzary.hashCode(this.zzwj);
      int i8 = zzary.hashCode(this.zzwk);
      int i7 = zzary.hashCode(this.zzwl);
      int i6 = zzary.hashCode(this.zzwm);
      int i5 = zzary.hashCode(this.zzwn);
      int i11 = zzary.hashCode(this.zzwo);
      int i;
      int j;
      label105:
      int k;
      label114:
      int m;
      label124:
      int n;
      label134:
      int i13;
      int i1;
      label155:
      int i14;
      int i15;
      if (this.zzwp == null)
      {
        i = 0;
        if (this.zzwq != null) {
          break label318;
        }
        j = 0;
        if (this.zzwr != null) {
          break label329;
        }
        k = 0;
        if (this.version != null) {
          break label340;
        }
        m = 0;
        if (this.zzws != null) {
          break label352;
        }
        n = 0;
        i13 = Float.floatToIntBits(this.zzwt);
        if (!this.zzwu) {
          break label364;
        }
        i1 = 1231;
        i14 = zzary.hashCode(this.zzwv);
        i15 = this.zzww;
        i2 = i3;
        if (this.btG != null) {
          if (!this.btG.isEmpty()) {
            break label372;
          }
        }
      }
      label318:
      label329:
      label340:
      label352:
      label364:
      label372:
      for (int i2 = i3;; i2 = this.btG.hashCode())
      {
        return (((i1 + ((n + (m + (k + (j + (i + (((((((((i4 + 527) * 31 + i12) * 31 + i10) * 31 + i9) * 31 + i8) * 31 + i7) * 31 + i6) * 31 + i5) * 31 + i11) * 31) * 31) * 31) * 31) * 31) * 31 + i13) * 31) * 31 + i14) * 31 + i15) * 31 + i2;
        i = this.zzwp.hashCode();
        break;
        j = this.zzwq.hashCode();
        break label105;
        k = this.zzwr.hashCode();
        break label114;
        m = this.version.hashCode();
        break label124;
        n = this.zzws.hashCode();
        break label134;
        i1 = 1237;
        break label155;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.zzwi != null) && (this.zzwi.length > 0)) {
        for (i = 0; i < this.zzwi.length; i++)
        {
          localObject = this.zzwi[i];
          if (localObject != null) {
            paramzzart.zzq(1, (String)localObject);
          }
        }
      }
      if ((this.zzwj != null) && (this.zzwj.length > 0)) {
        for (i = 0; i < this.zzwj.length; i++)
        {
          localObject = this.zzwj[i];
          if (localObject != null) {
            paramzzart.zza(2, (zzasa)localObject);
          }
        }
      }
      if ((this.zzwk != null) && (this.zzwk.length > 0)) {
        for (i = 0; i < this.zzwk.length; i++)
        {
          localObject = this.zzwk[i];
          if (localObject != null) {
            paramzzart.zza(3, (zzasa)localObject);
          }
        }
      }
      if ((this.zzwl != null) && (this.zzwl.length > 0)) {
        for (i = 0; i < this.zzwl.length; i++)
        {
          localObject = this.zzwl[i];
          if (localObject != null) {
            paramzzart.zza(4, (zzasa)localObject);
          }
        }
      }
      if ((this.zzwm != null) && (this.zzwm.length > 0)) {
        for (i = 0; i < this.zzwm.length; i++)
        {
          localObject = this.zzwm[i];
          if (localObject != null) {
            paramzzart.zza(5, (zzasa)localObject);
          }
        }
      }
      if ((this.zzwn != null) && (this.zzwn.length > 0)) {
        for (i = 0; i < this.zzwn.length; i++)
        {
          localObject = this.zzwn[i];
          if (localObject != null) {
            paramzzart.zza(6, (zzasa)localObject);
          }
        }
      }
      if ((this.zzwo != null) && (this.zzwo.length > 0)) {
        for (i = 0; i < this.zzwo.length; i++)
        {
          localObject = this.zzwo[i];
          if (localObject != null) {
            paramzzart.zza(7, (zzasa)localObject);
          }
        }
      }
      if ((this.zzwp != null) && (!this.zzwp.equals(""))) {
        paramzzart.zzq(9, this.zzwp);
      }
      if ((this.zzwq != null) && (!this.zzwq.equals(""))) {
        paramzzart.zzq(10, this.zzwq);
      }
      if ((this.zzwr != null) && (!this.zzwr.equals("0"))) {
        paramzzart.zzq(12, this.zzwr);
      }
      if ((this.version != null) && (!this.version.equals(""))) {
        paramzzart.zzq(13, this.version);
      }
      if (this.zzws != null) {
        paramzzart.zza(14, this.zzws);
      }
      if (Float.floatToIntBits(this.zzwt) != Float.floatToIntBits(0.0F)) {
        paramzzart.zzc(15, this.zzwt);
      }
      if ((this.zzwv != null) && (this.zzwv.length > 0)) {
        for (i = 0; i < this.zzwv.length; i++)
        {
          localObject = this.zzwv[i];
          if (localObject != null) {
            paramzzart.zzq(16, (String)localObject);
          }
        }
      }
      if (this.zzww != 0) {
        paramzzart.zzaf(17, this.zzww);
      }
      if (this.zzwu) {
        paramzzart.zzg(18, this.zzwu);
      }
      if ((this.zzwh != null) && (this.zzwh.length > 0)) {
        for (i = j; i < this.zzwh.length; i++)
        {
          localObject = this.zzwh[i];
          if (localObject != null) {
            paramzzart.zzq(19, (String)localObject);
          }
        }
      }
      super.zza(paramzzart);
    }
    
    public zzf zzak()
    {
      this.zzwh = zzasd.btW;
      this.zzwi = zzasd.btW;
      this.zzwj = zzaj.zza.zzar();
      this.zzwk = zzai.zze.zzai();
      this.zzwl = zzai.zzb.zzad();
      this.zzwm = zzai.zzb.zzad();
      this.zzwn = zzai.zzb.zzad();
      this.zzwo = zzai.zzg.zzal();
      this.zzwp = "";
      this.zzwq = "";
      this.zzwr = "0";
      this.version = "";
      this.zzws = null;
      this.zzwt = 0.0F;
      this.zzwu = false;
      this.zzwv = zzasd.btW;
      this.zzww = 0;
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    public zzf zzs(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (super.zza(paramzzars, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = zzasd.zzc(paramzzars, 10);
          if (this.zzwi == null) {}
          for (i = 0;; i = this.zzwi.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwi, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = paramzzars.readString();
              paramzzars.bU();
            }
          }
          localObject[j] = paramzzars.readString();
          this.zzwi = ((String[])localObject);
          break;
        case 18: 
          j = zzasd.zzc(paramzzars, 18);
          if (this.zzwj == null) {}
          for (i = 0;; i = this.zzwj.length)
          {
            localObject = new zzaj.zza[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwj, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zzaj.zza();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zzaj.zza();
          paramzzars.zza(localObject[j]);
          this.zzwj = ((zzaj.zza[])localObject);
          break;
        case 26: 
          j = zzasd.zzc(paramzzars, 26);
          if (this.zzwk == null) {}
          for (i = 0;; i = this.zzwk.length)
          {
            localObject = new zzai.zze[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwk, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zzai.zze();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zzai.zze();
          paramzzars.zza(localObject[j]);
          this.zzwk = ((zzai.zze[])localObject);
          break;
        case 34: 
          j = zzasd.zzc(paramzzars, 34);
          if (this.zzwl == null) {}
          for (i = 0;; i = this.zzwl.length)
          {
            localObject = new zzai.zzb[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwl, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zzai.zzb();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zzai.zzb();
          paramzzars.zza(localObject[j]);
          this.zzwl = ((zzai.zzb[])localObject);
          break;
        case 42: 
          j = zzasd.zzc(paramzzars, 42);
          if (this.zzwm == null) {}
          for (i = 0;; i = this.zzwm.length)
          {
            localObject = new zzai.zzb[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwm, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zzai.zzb();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zzai.zzb();
          paramzzars.zza(localObject[j]);
          this.zzwm = ((zzai.zzb[])localObject);
          break;
        case 50: 
          j = zzasd.zzc(paramzzars, 50);
          if (this.zzwn == null) {}
          for (i = 0;; i = this.zzwn.length)
          {
            localObject = new zzai.zzb[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwn, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zzai.zzb();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zzai.zzb();
          paramzzars.zza(localObject[j]);
          this.zzwn = ((zzai.zzb[])localObject);
          break;
        case 58: 
          j = zzasd.zzc(paramzzars, 58);
          if (this.zzwo == null) {}
          for (i = 0;; i = this.zzwo.length)
          {
            localObject = new zzai.zzg[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwo, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zzai.zzg();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zzai.zzg();
          paramzzars.zza(localObject[j]);
          this.zzwo = ((zzai.zzg[])localObject);
          break;
        case 74: 
          this.zzwp = paramzzars.readString();
          break;
        case 82: 
          this.zzwq = paramzzars.readString();
          break;
        case 98: 
          this.zzwr = paramzzars.readString();
          break;
        case 106: 
          this.version = paramzzars.readString();
          break;
        case 114: 
          if (this.zzws == null) {
            this.zzws = new zzai.zza();
          }
          paramzzars.zza(this.zzws);
          break;
        case 125: 
          this.zzwt = paramzzars.readFloat();
          break;
        case 130: 
          j = zzasd.zzc(paramzzars, 130);
          if (this.zzwv == null) {}
          for (i = 0;; i = this.zzwv.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwv, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = paramzzars.readString();
              paramzzars.bU();
            }
          }
          localObject[j] = paramzzars.readString();
          this.zzwv = ((String[])localObject);
          break;
        case 136: 
          this.zzww = paramzzars.bY();
          break;
        case 144: 
          this.zzwu = paramzzars.ca();
          break;
        case 154: 
          j = zzasd.zzc(paramzzars, 154);
          if (this.zzwh == null) {}
          for (i = 0;; i = this.zzwh.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwh, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = paramzzars.readString();
              paramzzars.bU();
            }
          }
          localObject[j] = paramzzars.readString();
          this.zzwh = ((String[])localObject);
        }
      }
    }
    
    protected int zzx()
    {
      int i2 = 0;
      int i1 = super.zzx();
      int k;
      int m;
      Object localObject;
      int n;
      int i;
      if ((this.zzwi != null) && (this.zzwi.length > 0))
      {
        k = 0;
        m = 0;
        for (j = 0; k < this.zzwi.length; j = i)
        {
          localObject = this.zzwi[k];
          n = m;
          i = j;
          if (localObject != null)
          {
            i = j + 1;
            n = m + zzart.zzuy((String)localObject);
          }
          k++;
          m = n;
        }
      }
      for (int j = i1 + m + j * 1;; j = i1)
      {
        i = j;
        if (this.zzwj != null)
        {
          i = j;
          if (this.zzwj.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zzwj.length)
            {
              localObject = this.zzwj[j];
              k = i;
              if (localObject != null) {
                k = i + zzart.zzc(2, (zzasa)localObject);
              }
              j++;
              i = k;
            }
          }
        }
        j = i;
        if (this.zzwk != null)
        {
          j = i;
          if (this.zzwk.length > 0)
          {
            k = 0;
            while (k < this.zzwk.length)
            {
              localObject = this.zzwk[k];
              j = i;
              if (localObject != null) {
                j = i + zzart.zzc(3, (zzasa)localObject);
              }
              k++;
              i = j;
            }
            j = i;
          }
        }
        i = j;
        if (this.zzwl != null)
        {
          i = j;
          if (this.zzwl.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zzwl.length)
            {
              localObject = this.zzwl[j];
              k = i;
              if (localObject != null) {
                k = i + zzart.zzc(4, (zzasa)localObject);
              }
              j++;
              i = k;
            }
          }
        }
        j = i;
        if (this.zzwm != null)
        {
          j = i;
          if (this.zzwm.length > 0)
          {
            j = 0;
            while (j < this.zzwm.length)
            {
              localObject = this.zzwm[j];
              k = i;
              if (localObject != null) {
                k = i + zzart.zzc(5, (zzasa)localObject);
              }
              j++;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.zzwn != null)
        {
          i = j;
          if (this.zzwn.length > 0)
          {
            i = j;
            k = 0;
            while (k < this.zzwn.length)
            {
              localObject = this.zzwn[k];
              j = i;
              if (localObject != null) {
                j = i + zzart.zzc(6, (zzasa)localObject);
              }
              k++;
              i = j;
            }
          }
        }
        j = i;
        if (this.zzwo != null)
        {
          j = i;
          if (this.zzwo.length > 0)
          {
            j = 0;
            while (j < this.zzwo.length)
            {
              localObject = this.zzwo[j];
              k = i;
              if (localObject != null) {
                k = i + zzart.zzc(7, (zzasa)localObject);
              }
              j++;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.zzwp != null)
        {
          i = j;
          if (!this.zzwp.equals("")) {
            i = j + zzart.zzr(9, this.zzwp);
          }
        }
        k = i;
        if (this.zzwq != null)
        {
          k = i;
          if (!this.zzwq.equals("")) {
            k = i + zzart.zzr(10, this.zzwq);
          }
        }
        j = k;
        if (this.zzwr != null)
        {
          j = k;
          if (!this.zzwr.equals("0")) {
            j = k + zzart.zzr(12, this.zzwr);
          }
        }
        i = j;
        if (this.version != null)
        {
          i = j;
          if (!this.version.equals("")) {
            i = j + zzart.zzr(13, this.version);
          }
        }
        j = i;
        if (this.zzws != null) {
          j = i + zzart.zzc(14, this.zzws);
        }
        i = j;
        if (Float.floatToIntBits(this.zzwt) != Float.floatToIntBits(0.0F)) {
          i = j + zzart.zzd(15, this.zzwt);
        }
        k = i;
        if (this.zzwv != null)
        {
          k = i;
          if (this.zzwv.length > 0)
          {
            m = 0;
            n = 0;
            for (k = 0; m < this.zzwv.length; k = j)
            {
              localObject = this.zzwv[m];
              i1 = n;
              j = k;
              if (localObject != null)
              {
                j = k + 1;
                i1 = n + zzart.zzuy((String)localObject);
              }
              m++;
              n = i1;
            }
            k = i + n + k * 2;
          }
        }
        j = k;
        if (this.zzww != 0) {
          j = k + zzart.zzah(17, this.zzww);
        }
        i = j;
        if (this.zzwu) {
          i = j + zzart.zzh(18, this.zzwu);
        }
        j = i;
        if (this.zzwh != null)
        {
          j = i;
          if (this.zzwh.length > 0)
          {
            j = 0;
            n = 0;
            k = i2;
            while (k < this.zzwh.length)
            {
              localObject = this.zzwh[k];
              i1 = j;
              m = n;
              if (localObject != null)
              {
                m = n + 1;
                i1 = j + zzart.zzuy((String)localObject);
              }
              k++;
              j = i1;
              n = m;
            }
            j = i + j + n * 2;
          }
        }
        return j;
      }
    }
  }
  
  public static final class zzg
    extends zzaru<zzg>
  {
    private static volatile zzg[] zzwx;
    public int[] zzwy;
    public int[] zzwz;
    public int[] zzxa;
    public int[] zzxb;
    public int[] zzxc;
    public int[] zzxd;
    public int[] zzxe;
    public int[] zzxf;
    public int[] zzxg;
    public int[] zzxh;
    
    public zzg()
    {
      zzam();
    }
    
    public static zzg[] zzal()
    {
      if (zzwx == null) {}
      synchronized (zzary.btO)
      {
        if (zzwx == null) {
          zzwx = new zzg[0];
        }
        return zzwx;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if ((paramObject instanceof zzg))
        {
          paramObject = (zzg)paramObject;
          bool1 = bool2;
          if (zzary.equals(this.zzwy, ((zzg)paramObject).zzwy))
          {
            bool1 = bool2;
            if (zzary.equals(this.zzwz, ((zzg)paramObject).zzwz))
            {
              bool1 = bool2;
              if (zzary.equals(this.zzxa, ((zzg)paramObject).zzxa))
              {
                bool1 = bool2;
                if (zzary.equals(this.zzxb, ((zzg)paramObject).zzxb))
                {
                  bool1 = bool2;
                  if (zzary.equals(this.zzxc, ((zzg)paramObject).zzxc))
                  {
                    bool1 = bool2;
                    if (zzary.equals(this.zzxd, ((zzg)paramObject).zzxd))
                    {
                      bool1 = bool2;
                      if (zzary.equals(this.zzxe, ((zzg)paramObject).zzxe))
                      {
                        bool1 = bool2;
                        if (zzary.equals(this.zzxf, ((zzg)paramObject).zzxf))
                        {
                          bool1 = bool2;
                          if (zzary.equals(this.zzxg, ((zzg)paramObject).zzxg))
                          {
                            bool1 = bool2;
                            if (zzary.equals(this.zzxh, ((zzg)paramObject).zzxh)) {
                              if ((this.btG == null) || (this.btG.isEmpty()))
                              {
                                if (((zzg)paramObject).btG != null)
                                {
                                  bool1 = bool2;
                                  if (!((zzg)paramObject).btG.isEmpty()) {}
                                }
                                else
                                {
                                  bool1 = true;
                                }
                              }
                              else {
                                bool1 = this.btG.equals(((zzg)paramObject).btG);
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public int hashCode()
    {
      int i6 = getClass().getName().hashCode();
      int i4 = zzary.hashCode(this.zzwy);
      int i1 = zzary.hashCode(this.zzwz);
      int i7 = zzary.hashCode(this.zzxa);
      int j = zzary.hashCode(this.zzxb);
      int i2 = zzary.hashCode(this.zzxc);
      int k = zzary.hashCode(this.zzxd);
      int i5 = zzary.hashCode(this.zzxe);
      int n = zzary.hashCode(this.zzxf);
      int m = zzary.hashCode(this.zzxg);
      int i3 = zzary.hashCode(this.zzxh);
      if ((this.btG == null) || (this.btG.isEmpty())) {}
      for (int i = 0;; i = this.btG.hashCode()) {
        return i + (((((((((((i6 + 527) * 31 + i4) * 31 + i1) * 31 + i7) * 31 + j) * 31 + i2) * 31 + k) * 31 + i5) * 31 + n) * 31 + m) * 31 + i3) * 31;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.zzwy != null) && (this.zzwy.length > 0)) {
        for (i = 0; i < this.zzwy.length; i++) {
          paramzzart.zzaf(1, this.zzwy[i]);
        }
      }
      if ((this.zzwz != null) && (this.zzwz.length > 0)) {
        for (i = 0; i < this.zzwz.length; i++) {
          paramzzart.zzaf(2, this.zzwz[i]);
        }
      }
      if ((this.zzxa != null) && (this.zzxa.length > 0)) {
        for (i = 0; i < this.zzxa.length; i++) {
          paramzzart.zzaf(3, this.zzxa[i]);
        }
      }
      if ((this.zzxb != null) && (this.zzxb.length > 0)) {
        for (i = 0; i < this.zzxb.length; i++) {
          paramzzart.zzaf(4, this.zzxb[i]);
        }
      }
      if ((this.zzxc != null) && (this.zzxc.length > 0)) {
        for (i = 0; i < this.zzxc.length; i++) {
          paramzzart.zzaf(5, this.zzxc[i]);
        }
      }
      if ((this.zzxd != null) && (this.zzxd.length > 0)) {
        for (i = 0; i < this.zzxd.length; i++) {
          paramzzart.zzaf(6, this.zzxd[i]);
        }
      }
      if ((this.zzxe != null) && (this.zzxe.length > 0)) {
        for (i = 0; i < this.zzxe.length; i++) {
          paramzzart.zzaf(7, this.zzxe[i]);
        }
      }
      if ((this.zzxf != null) && (this.zzxf.length > 0)) {
        for (i = 0; i < this.zzxf.length; i++) {
          paramzzart.zzaf(8, this.zzxf[i]);
        }
      }
      if ((this.zzxg != null) && (this.zzxg.length > 0)) {
        for (i = 0; i < this.zzxg.length; i++) {
          paramzzart.zzaf(9, this.zzxg[i]);
        }
      }
      if ((this.zzxh != null) && (this.zzxh.length > 0)) {
        for (i = j; i < this.zzxh.length; i++) {
          paramzzart.zzaf(10, this.zzxh[i]);
        }
      }
      super.zza(paramzzart);
    }
    
    public zzg zzam()
    {
      this.zzwy = zzasd.btR;
      this.zzwz = zzasd.btR;
      this.zzxa = zzasd.btR;
      this.zzxb = zzasd.btR;
      this.zzxc = zzasd.btR;
      this.zzxd = zzasd.btR;
      this.zzxe = zzasd.btR;
      this.zzxf = zzasd.btR;
      this.zzxg = zzasd.btR;
      this.zzxh = zzasd.btR;
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    public zzg zzt(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        int j;
        int[] arrayOfInt;
        int k;
        switch (i)
        {
        default: 
          if (super.zza(paramzzars, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = zzasd.zzc(paramzzars, 8);
          if (this.zzwy == null) {}
          for (i = 0;; i = this.zzwy.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwy, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzwy = arrayOfInt;
          break;
        case 10: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzwy == null) {}
          for (i = 0;; i = this.zzwy.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwy, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzwy = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 16: 
          j = zzasd.zzc(paramzzars, 16);
          if (this.zzwz == null) {}
          for (i = 0;; i = this.zzwz.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwz, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzwz = arrayOfInt;
          break;
        case 18: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzwz == null) {}
          for (i = 0;; i = this.zzwz.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzwz, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzwz = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 24: 
          j = zzasd.zzc(paramzzars, 24);
          if (this.zzxa == null) {}
          for (i = 0;; i = this.zzxa.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxa, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxa = arrayOfInt;
          break;
        case 26: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxa == null) {}
          for (i = 0;; i = this.zzxa.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxa, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxa = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 32: 
          j = zzasd.zzc(paramzzars, 32);
          if (this.zzxb == null) {}
          for (i = 0;; i = this.zzxb.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxb, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxb = arrayOfInt;
          break;
        case 34: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxb == null) {}
          for (i = 0;; i = this.zzxb.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxb, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxb = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 40: 
          j = zzasd.zzc(paramzzars, 40);
          if (this.zzxc == null) {}
          for (i = 0;; i = this.zzxc.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxc, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxc = arrayOfInt;
          break;
        case 42: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxc == null) {}
          for (i = 0;; i = this.zzxc.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxc, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxc = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 48: 
          j = zzasd.zzc(paramzzars, 48);
          if (this.zzxd == null) {}
          for (i = 0;; i = this.zzxd.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxd, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxd = arrayOfInt;
          break;
        case 50: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxd == null) {}
          for (i = 0;; i = this.zzxd.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxd, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxd = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 56: 
          j = zzasd.zzc(paramzzars, 56);
          if (this.zzxe == null) {}
          for (i = 0;; i = this.zzxe.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxe, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxe = arrayOfInt;
          break;
        case 58: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxe == null) {}
          for (i = 0;; i = this.zzxe.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxe, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxe = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 64: 
          j = zzasd.zzc(paramzzars, 64);
          if (this.zzxf == null) {}
          for (i = 0;; i = this.zzxf.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxf, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxf = arrayOfInt;
          break;
        case 66: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxf == null) {}
          for (i = 0;; i = this.zzxf.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxf, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxf = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 72: 
          j = zzasd.zzc(paramzzars, 72);
          if (this.zzxg == null) {}
          for (i = 0;; i = this.zzxg.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxg, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxg = arrayOfInt;
          break;
        case 74: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxg == null) {}
          for (i = 0;; i = this.zzxg.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxg, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxg = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 80: 
          j = zzasd.zzc(paramzzars, 80);
          if (this.zzxh == null) {}
          for (i = 0;; i = this.zzxh.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxh, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxh = arrayOfInt;
          break;
        case 82: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxh == null) {}
          for (i = 0;; i = this.zzxh.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxh, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxh = arrayOfInt;
          paramzzars.zzagu(k);
        }
      }
    }
    
    protected int zzx()
    {
      int m = 0;
      int k = super.zzx();
      int i;
      if ((this.zzwy != null) && (this.zzwy.length > 0))
      {
        j = 0;
        i = 0;
        while (j < this.zzwy.length)
        {
          i += zzart.zzagz(this.zzwy[j]);
          j++;
        }
      }
      for (int j = k + i + this.zzwy.length * 1;; j = k)
      {
        i = j;
        if (this.zzwz != null)
        {
          i = j;
          if (this.zzwz.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zzwz.length)
            {
              k += zzart.zzagz(this.zzwz[i]);
              i++;
            }
            i = j + k + this.zzwz.length * 1;
          }
        }
        k = i;
        if (this.zzxa != null)
        {
          k = i;
          if (this.zzxa.length > 0)
          {
            k = 0;
            j = 0;
            while (k < this.zzxa.length)
            {
              j += zzart.zzagz(this.zzxa[k]);
              k++;
            }
            k = i + j + this.zzxa.length * 1;
          }
        }
        j = k;
        if (this.zzxb != null)
        {
          j = k;
          if (this.zzxb.length > 0)
          {
            i = 0;
            j = 0;
            while (i < this.zzxb.length)
            {
              j += zzart.zzagz(this.zzxb[i]);
              i++;
            }
            j = k + j + this.zzxb.length * 1;
          }
        }
        i = j;
        if (this.zzxc != null)
        {
          i = j;
          if (this.zzxc.length > 0)
          {
            k = 0;
            i = 0;
            while (k < this.zzxc.length)
            {
              i += zzart.zzagz(this.zzxc[k]);
              k++;
            }
            i = j + i + this.zzxc.length * 1;
          }
        }
        k = i;
        if (this.zzxd != null)
        {
          k = i;
          if (this.zzxd.length > 0)
          {
            k = 0;
            j = 0;
            while (k < this.zzxd.length)
            {
              j += zzart.zzagz(this.zzxd[k]);
              k++;
            }
            k = i + j + this.zzxd.length * 1;
          }
        }
        j = k;
        if (this.zzxe != null)
        {
          j = k;
          if (this.zzxe.length > 0)
          {
            i = 0;
            j = 0;
            while (i < this.zzxe.length)
            {
              j += zzart.zzagz(this.zzxe[i]);
              i++;
            }
            j = k + j + this.zzxe.length * 1;
          }
        }
        i = j;
        if (this.zzxf != null)
        {
          i = j;
          if (this.zzxf.length > 0)
          {
            k = 0;
            i = 0;
            while (k < this.zzxf.length)
            {
              i += zzart.zzagz(this.zzxf[k]);
              k++;
            }
            i = j + i + this.zzxf.length * 1;
          }
        }
        j = i;
        if (this.zzxg != null)
        {
          j = i;
          if (this.zzxg.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zzxg.length)
            {
              k += zzart.zzagz(this.zzxg[j]);
              j++;
            }
            j = i + k + this.zzxg.length * 1;
          }
        }
        i = j;
        if (this.zzxh != null)
        {
          i = j;
          if (this.zzxh.length > 0)
          {
            i = 0;
            for (k = m; k < this.zzxh.length; k++) {
              i += zzart.zzagz(this.zzxh[k]);
            }
            i = j + i + this.zzxh.length * 1;
          }
        }
        return i;
      }
    }
  }
  
  public static final class zzh
    extends zzaru<zzh>
  {
    public static final zzarv<zzaj.zza, zzh> zzxi = zzarv.zza(11, zzh.class, 810L);
    private static final zzh[] zzxj = new zzh[0];
    public int[] zzxk;
    public int[] zzxl;
    public int[] zzxm;
    public int zzxn;
    public int[] zzxo;
    public int zzxp;
    public int zzxq;
    
    public zzh()
    {
      zzan();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if ((paramObject instanceof zzh))
        {
          paramObject = (zzh)paramObject;
          bool1 = bool2;
          if (zzary.equals(this.zzxk, ((zzh)paramObject).zzxk))
          {
            bool1 = bool2;
            if (zzary.equals(this.zzxl, ((zzh)paramObject).zzxl))
            {
              bool1 = bool2;
              if (zzary.equals(this.zzxm, ((zzh)paramObject).zzxm))
              {
                bool1 = bool2;
                if (this.zzxn == ((zzh)paramObject).zzxn)
                {
                  bool1 = bool2;
                  if (zzary.equals(this.zzxo, ((zzh)paramObject).zzxo))
                  {
                    bool1 = bool2;
                    if (this.zzxp == ((zzh)paramObject).zzxp)
                    {
                      bool1 = bool2;
                      if (this.zzxq == ((zzh)paramObject).zzxq) {
                        if ((this.btG == null) || (this.btG.isEmpty()))
                        {
                          if (((zzh)paramObject).btG != null)
                          {
                            bool1 = bool2;
                            if (!((zzh)paramObject).btG.isEmpty()) {}
                          }
                          else
                          {
                            bool1 = true;
                          }
                        }
                        else {
                          bool1 = this.btG.equals(((zzh)paramObject).btG);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public int hashCode()
    {
      int m = getClass().getName().hashCode();
      int k = zzary.hashCode(this.zzxk);
      int n = zzary.hashCode(this.zzxl);
      int i2 = zzary.hashCode(this.zzxm);
      int i4 = this.zzxn;
      int j = zzary.hashCode(this.zzxo);
      int i3 = this.zzxp;
      int i1 = this.zzxq;
      if ((this.btG == null) || (this.btG.isEmpty())) {}
      for (int i = 0;; i = this.btG.hashCode()) {
        return i + ((((((((m + 527) * 31 + k) * 31 + n) * 31 + i2) * 31 + i4) * 31 + j) * 31 + i3) * 31 + i1) * 31;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.zzxk != null) && (this.zzxk.length > 0)) {
        for (i = 0; i < this.zzxk.length; i++) {
          paramzzart.zzaf(1, this.zzxk[i]);
        }
      }
      if ((this.zzxl != null) && (this.zzxl.length > 0)) {
        for (i = 0; i < this.zzxl.length; i++) {
          paramzzart.zzaf(2, this.zzxl[i]);
        }
      }
      if ((this.zzxm != null) && (this.zzxm.length > 0)) {
        for (i = 0; i < this.zzxm.length; i++) {
          paramzzart.zzaf(3, this.zzxm[i]);
        }
      }
      if (this.zzxn != 0) {
        paramzzart.zzaf(4, this.zzxn);
      }
      if ((this.zzxo != null) && (this.zzxo.length > 0)) {
        for (i = j; i < this.zzxo.length; i++) {
          paramzzart.zzaf(5, this.zzxo[i]);
        }
      }
      if (this.zzxp != 0) {
        paramzzart.zzaf(6, this.zzxp);
      }
      if (this.zzxq != 0) {
        paramzzart.zzaf(7, this.zzxq);
      }
      super.zza(paramzzart);
    }
    
    public zzh zzan()
    {
      this.zzxk = zzasd.btR;
      this.zzxl = zzasd.btR;
      this.zzxm = zzasd.btR;
      this.zzxn = 0;
      this.zzxo = zzasd.btR;
      this.zzxp = 0;
      this.zzxq = 0;
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    public zzh zzu(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        int j;
        int[] arrayOfInt;
        int k;
        switch (i)
        {
        default: 
          if (super.zza(paramzzars, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = zzasd.zzc(paramzzars, 8);
          if (this.zzxk == null) {}
          for (i = 0;; i = this.zzxk.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxk, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxk = arrayOfInt;
          break;
        case 10: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxk == null) {}
          for (i = 0;; i = this.zzxk.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxk, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxk = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 16: 
          j = zzasd.zzc(paramzzars, 16);
          if (this.zzxl == null) {}
          for (i = 0;; i = this.zzxl.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxl, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxl = arrayOfInt;
          break;
        case 18: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxl == null) {}
          for (i = 0;; i = this.zzxl.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxl, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxl = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 24: 
          j = zzasd.zzc(paramzzars, 24);
          if (this.zzxm == null) {}
          for (i = 0;; i = this.zzxm.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxm, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxm = arrayOfInt;
          break;
        case 26: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxm == null) {}
          for (i = 0;; i = this.zzxm.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxm, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxm = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 32: 
          this.zzxn = paramzzars.bY();
          break;
        case 40: 
          j = zzasd.zzc(paramzzars, 40);
          if (this.zzxo == null) {}
          for (i = 0;; i = this.zzxo.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxo, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length - 1; j++)
            {
              arrayOfInt[j] = paramzzars.bY();
              paramzzars.bU();
            }
          }
          arrayOfInt[j] = paramzzars.bY();
          this.zzxo = arrayOfInt;
          break;
        case 42: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          for (j = 0; paramzzars.ci() > 0; j++) {
            paramzzars.bY();
          }
          paramzzars.zzagv(i);
          if (this.zzxo == null) {}
          for (i = 0;; i = this.zzxo.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxo, 0, arrayOfInt, 0, i);
            }
            for (j = i; j < arrayOfInt.length; j++) {
              arrayOfInt[j] = paramzzars.bY();
            }
          }
          this.zzxo = arrayOfInt;
          paramzzars.zzagu(k);
          break;
        case 48: 
          this.zzxp = paramzzars.bY();
          break;
        case 56: 
          this.zzxq = paramzzars.bY();
        }
      }
    }
    
    protected int zzx()
    {
      int m = 0;
      int k = super.zzx();
      int i;
      if ((this.zzxk != null) && (this.zzxk.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.zzxk.length)
        {
          j += zzart.zzagz(this.zzxk[i]);
          i++;
        }
      }
      for (int j = k + j + this.zzxk.length * 1;; j = k)
      {
        i = j;
        if (this.zzxl != null)
        {
          i = j;
          if (this.zzxl.length > 0)
          {
            k = 0;
            i = 0;
            while (k < this.zzxl.length)
            {
              i += zzart.zzagz(this.zzxl[k]);
              k++;
            }
            i = j + i + this.zzxl.length * 1;
          }
        }
        j = i;
        if (this.zzxm != null)
        {
          j = i;
          if (this.zzxm.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zzxm.length)
            {
              k += zzart.zzagz(this.zzxm[j]);
              j++;
            }
            j = i + k + this.zzxm.length * 1;
          }
        }
        i = j;
        if (this.zzxn != 0) {
          i = j + zzart.zzah(4, this.zzxn);
        }
        j = i;
        if (this.zzxo != null)
        {
          j = i;
          if (this.zzxo.length > 0)
          {
            j = 0;
            for (k = m; k < this.zzxo.length; k++) {
              j += zzart.zzagz(this.zzxo[k]);
            }
            j = i + j + this.zzxo.length * 1;
          }
        }
        i = j;
        if (this.zzxp != 0) {
          i = j + zzart.zzah(6, this.zzxp);
        }
        j = i;
        if (this.zzxq != 0) {
          j = i + zzart.zzah(7, this.zzxq);
        }
        return j;
      }
    }
  }
  
  public static final class zzi
    extends zzaru<zzi>
  {
    private static volatile zzi[] zzxr;
    public String name;
    public zzaj.zza zzxs;
    public zzai.zzd zzxt;
    
    public zzi()
    {
      zzap();
    }
    
    public static zzi[] zzao()
    {
      if (zzxr == null) {}
      synchronized (zzary.btO)
      {
        if (zzxr == null) {
          zzxr = new zzi[0];
        }
        return zzxr;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if ((paramObject instanceof zzi))
        {
          paramObject = (zzi)paramObject;
          if (this.name == null)
          {
            bool1 = bool2;
            if (((zzi)paramObject).name != null) {
              continue;
            }
            label41:
            if (this.zzxs != null) {
              break label133;
            }
            bool1 = bool2;
            if (((zzi)paramObject).zzxs != null) {
              continue;
            }
            label57:
            if (this.zzxt != null) {
              break label152;
            }
            bool1 = bool2;
            if (((zzi)paramObject).zzxt != null) {
              continue;
            }
          }
          for (;;)
          {
            if ((this.btG == null) || (this.btG.isEmpty()))
            {
              if (((zzi)paramObject).btG != null)
              {
                bool1 = bool2;
                if (!((zzi)paramObject).btG.isEmpty()) {
                  break;
                }
              }
              bool1 = true;
              break;
              if (this.name.equals(((zzi)paramObject).name)) {
                break label41;
              }
              bool1 = bool2;
              break;
              label133:
              if (this.zzxs.equals(((zzi)paramObject).zzxs)) {
                break label57;
              }
              bool1 = bool2;
              break;
              label152:
              if (!this.zzxt.equals(((zzi)paramObject).zzxt))
              {
                bool1 = bool2;
                break;
              }
            }
          }
          bool1 = this.btG.equals(((zzi)paramObject).btG);
        }
      }
    }
    
    public int hashCode()
    {
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      if (this.name == null)
      {
        i = 0;
        if (this.zzxs != null) {
          break label106;
        }
        j = 0;
        if (this.zzxt != null) {
          break label117;
        }
        k = 0;
        label42:
        m = n;
        if (this.btG != null) {
          if (!this.btG.isEmpty()) {
            break label128;
          }
        }
      }
      label106:
      label117:
      label128:
      for (int m = n;; m = this.btG.hashCode())
      {
        return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + m;
        i = this.name.hashCode();
        break;
        j = this.zzxs.hashCode();
        break label33;
        k = this.zzxt.hashCode();
        break label42;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      if ((this.name != null) && (!this.name.equals(""))) {
        paramzzart.zzq(1, this.name);
      }
      if (this.zzxs != null) {
        paramzzart.zza(2, this.zzxs);
      }
      if (this.zzxt != null) {
        paramzzart.zza(3, this.zzxt);
      }
      super.zza(paramzzart);
    }
    
    public zzi zzap()
    {
      this.name = "";
      this.zzxs = null;
      this.zzxt = null;
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    public zzi zzv(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        switch (i)
        {
        default: 
          if (super.zza(paramzzars, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.name = paramzzars.readString();
          break;
        case 18: 
          if (this.zzxs == null) {
            this.zzxs = new zzaj.zza();
          }
          paramzzars.zza(this.zzxs);
          break;
        case 26: 
          if (this.zzxt == null) {
            this.zzxt = new zzai.zzd();
          }
          paramzzars.zza(this.zzxt);
        }
      }
    }
    
    protected int zzx()
    {
      int i = super.zzx();
      int j = i;
      if (this.name != null)
      {
        j = i;
        if (!this.name.equals("")) {
          j = i + zzart.zzr(1, this.name);
        }
      }
      i = j;
      if (this.zzxs != null) {
        i = j + zzart.zzc(2, this.zzxs);
      }
      j = i;
      if (this.zzxt != null) {
        j = i + zzart.zzc(3, this.zzxt);
      }
      return j;
    }
  }
  
  public static final class zzj
    extends zzaru<zzj>
  {
    public zzai.zzi[] zzxu;
    public zzai.zzf zzxv;
    public String zzxw;
    
    public zzj()
    {
      zzaq();
    }
    
    public static zzj zzg(byte[] paramArrayOfByte)
      throws zzarz
    {
      return (zzj)zzasa.zza(new zzj(), paramArrayOfByte);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
        if ((paramObject instanceof zzj))
        {
          paramObject = (zzj)paramObject;
          bool1 = bool2;
          if (zzary.equals(this.zzxu, ((zzj)paramObject).zzxu))
          {
            if (this.zzxv == null)
            {
              bool1 = bool2;
              if (((zzj)paramObject).zzxv != null) {
                continue;
              }
              label57:
              if (this.zzxw != null) {
                break label133;
              }
              bool1 = bool2;
              if (((zzj)paramObject).zzxw != null) {
                continue;
              }
            }
            for (;;)
            {
              if ((this.btG == null) || (this.btG.isEmpty()))
              {
                if (((zzj)paramObject).btG != null)
                {
                  bool1 = bool2;
                  if (!((zzj)paramObject).btG.isEmpty()) {
                    break;
                  }
                }
                bool1 = true;
                break;
                if (this.zzxv.equals(((zzj)paramObject).zzxv)) {
                  break label57;
                }
                bool1 = bool2;
                break;
                label133:
                if (!this.zzxw.equals(((zzj)paramObject).zzxw))
                {
                  bool1 = bool2;
                  break;
                }
              }
            }
            bool1 = this.btG.equals(((zzj)paramObject).btG);
          }
        }
      }
    }
    
    public int hashCode()
    {
      int m = 0;
      int i1 = getClass().getName().hashCode();
      int n = zzary.hashCode(this.zzxu);
      int i;
      int j;
      if (this.zzxv == null)
      {
        i = 0;
        if (this.zzxw != null) {
          break label104;
        }
        j = 0;
        label42:
        k = m;
        if (this.btG != null) {
          if (!this.btG.isEmpty()) {
            break label115;
          }
        }
      }
      label104:
      label115:
      for (int k = m;; k = this.btG.hashCode())
      {
        return (j + (i + ((i1 + 527) * 31 + n) * 31) * 31) * 31 + k;
        i = this.zzxv.hashCode();
        break;
        j = this.zzxw.hashCode();
        break label42;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      if ((this.zzxu != null) && (this.zzxu.length > 0)) {
        for (int i = 0; i < this.zzxu.length; i++)
        {
          zzai.zzi localzzi = this.zzxu[i];
          if (localzzi != null) {
            paramzzart.zza(1, localzzi);
          }
        }
      }
      if (this.zzxv != null) {
        paramzzart.zza(2, this.zzxv);
      }
      if ((this.zzxw != null) && (!this.zzxw.equals(""))) {
        paramzzart.zzq(3, this.zzxw);
      }
      super.zza(paramzzart);
    }
    
    public zzj zzaq()
    {
      this.zzxu = zzai.zzi.zzao();
      this.zzxv = null;
      this.zzxw = "";
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    public zzj zzw(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        switch (i)
        {
        default: 
          if (super.zza(paramzzars, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          int j = zzasd.zzc(paramzzars, 10);
          if (this.zzxu == null) {}
          zzai.zzi[] arrayOfzzi;
          for (i = 0;; i = this.zzxu.length)
          {
            arrayOfzzi = new zzai.zzi[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxu, 0, arrayOfzzi, 0, i);
            }
            for (j = i; j < arrayOfzzi.length - 1; j++)
            {
              arrayOfzzi[j] = new zzai.zzi();
              paramzzars.zza(arrayOfzzi[j]);
              paramzzars.bU();
            }
          }
          arrayOfzzi[j] = new zzai.zzi();
          paramzzars.zza(arrayOfzzi[j]);
          this.zzxu = arrayOfzzi;
          break;
        case 18: 
          if (this.zzxv == null) {
            this.zzxv = new zzai.zzf();
          }
          paramzzars.zza(this.zzxv);
          break;
        case 26: 
          this.zzxw = paramzzars.readString();
        }
      }
    }
    
    protected int zzx()
    {
      int j = super.zzx();
      int i = j;
      if (this.zzxu != null)
      {
        i = j;
        if (this.zzxu.length > 0)
        {
          int k = 0;
          for (;;)
          {
            i = j;
            if (k >= this.zzxu.length) {
              break;
            }
            zzai.zzi localzzi = this.zzxu[k];
            i = j;
            if (localzzi != null) {
              i = j + zzart.zzc(1, localzzi);
            }
            k++;
            j = i;
          }
        }
      }
      j = i;
      if (this.zzxv != null) {
        j = i + zzart.zzc(2, this.zzxv);
      }
      i = j;
      if (this.zzxw != null)
      {
        i = j;
        if (!this.zzxw.equals("")) {
          i = j + zzart.zzr(3, this.zzxw);
        }
      }
      return i;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */