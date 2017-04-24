package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzaj
{
  public static final class zza
    extends zzaru<zza>
  {
    private static volatile zza[] zzxx;
    public String string;
    public int type;
    public zza[] zzxy;
    public zza[] zzxz;
    public zza[] zzya;
    public String zzyb;
    public String zzyc;
    public long zzyd;
    public boolean zzye;
    public zza[] zzyf;
    public int[] zzyg;
    public boolean zzyh;
    
    public zza()
    {
      zzas();
    }
    
    public static zza[] zzar()
    {
      if (zzxx == null) {}
      synchronized (zzary.btO)
      {
        if (zzxx == null) {
          zzxx = new zza[0];
        }
        return zzxx;
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
        if ((paramObject instanceof zza))
        {
          paramObject = (zza)paramObject;
          bool1 = bool2;
          if (this.type == ((zza)paramObject).type)
          {
            if (this.string == null)
            {
              bool1 = bool2;
              if (((zza)paramObject).string != null) {
                continue;
              }
              label54:
              bool1 = bool2;
              if (!zzary.equals(this.zzxy, ((zza)paramObject).zzxy)) {
                continue;
              }
              bool1 = bool2;
              if (!zzary.equals(this.zzxz, ((zza)paramObject).zzxz)) {
                continue;
              }
              bool1 = bool2;
              if (!zzary.equals(this.zzya, ((zza)paramObject).zzya)) {
                continue;
              }
              if (this.zzyb != null) {
                break label266;
              }
              bool1 = bool2;
              if (((zza)paramObject).zzyb != null) {
                continue;
              }
              label118:
              if (this.zzyc != null) {
                break label285;
              }
              bool1 = bool2;
              if (((zza)paramObject).zzyc != null) {
                continue;
              }
            }
            label266:
            label285:
            while (this.zzyc.equals(((zza)paramObject).zzyc))
            {
              bool1 = bool2;
              if (this.zzyd != ((zza)paramObject).zzyd) {
                break;
              }
              bool1 = bool2;
              if (this.zzye != ((zza)paramObject).zzye) {
                break;
              }
              bool1 = bool2;
              if (!zzary.equals(this.zzyf, ((zza)paramObject).zzyf)) {
                break;
              }
              bool1 = bool2;
              if (!zzary.equals(this.zzyg, ((zza)paramObject).zzyg)) {
                break;
              }
              bool1 = bool2;
              if (this.zzyh != ((zza)paramObject).zzyh) {
                break;
              }
              if ((this.btG != null) && (!this.btG.isEmpty())) {
                break label304;
              }
              if (((zza)paramObject).btG != null)
              {
                bool1 = bool2;
                if (!((zza)paramObject).btG.isEmpty()) {
                  break;
                }
              }
              bool1 = true;
              break;
              if (this.string.equals(((zza)paramObject).string)) {
                break label54;
              }
              bool1 = bool2;
              break;
              if (this.zzyb.equals(((zza)paramObject).zzyb)) {
                break label118;
              }
              bool1 = bool2;
              break;
            }
            bool1 = bool2;
            continue;
            label304:
            bool1 = this.btG.equals(((zza)paramObject).btG);
          }
        }
      }
    }
    
    public int hashCode()
    {
      int n = 1231;
      int i2 = 0;
      int i4 = getClass().getName().hashCode();
      int i3 = this.type;
      int i;
      int i7;
      int i6;
      int i5;
      int j;
      label71:
      int k;
      label80:
      int i8;
      int m;
      label107:
      int i9;
      int i10;
      if (this.string == null)
      {
        i = 0;
        i7 = zzary.hashCode(this.zzxy);
        i6 = zzary.hashCode(this.zzxz);
        i5 = zzary.hashCode(this.zzya);
        if (this.zzyb != null) {
          break label250;
        }
        j = 0;
        if (this.zzyc != null) {
          break label261;
        }
        k = 0;
        i8 = (int)(this.zzyd ^ this.zzyd >>> 32);
        if (!this.zzye) {
          break label272;
        }
        m = 1231;
        i9 = zzary.hashCode(this.zzyf);
        i10 = zzary.hashCode(this.zzyg);
        if (!this.zzyh) {
          break label280;
        }
        label132:
        i1 = i2;
        if (this.btG != null) {
          if (!this.btG.isEmpty()) {
            break label288;
          }
        }
      }
      label250:
      label261:
      label272:
      label280:
      label288:
      for (int i1 = i2;; i1 = this.btG.hashCode())
      {
        return ((((m + ((k + (j + ((((i + ((i4 + 527) * 31 + i3) * 31) * 31 + i7) * 31 + i6) * 31 + i5) * 31) * 31) * 31 + i8) * 31) * 31 + i9) * 31 + i10) * 31 + n) * 31 + i1;
        i = this.string.hashCode();
        break;
        j = this.zzyb.hashCode();
        break label71;
        k = this.zzyc.hashCode();
        break label80;
        m = 1237;
        break label107;
        n = 1237;
        break label132;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      int j = 0;
      paramzzart.zzaf(1, this.type);
      if ((this.string != null) && (!this.string.equals(""))) {
        paramzzart.zzq(2, this.string);
      }
      int i;
      zza localzza;
      if ((this.zzxy != null) && (this.zzxy.length > 0)) {
        for (i = 0; i < this.zzxy.length; i++)
        {
          localzza = this.zzxy[i];
          if (localzza != null) {
            paramzzart.zza(3, localzza);
          }
        }
      }
      if ((this.zzxz != null) && (this.zzxz.length > 0)) {
        for (i = 0; i < this.zzxz.length; i++)
        {
          localzza = this.zzxz[i];
          if (localzza != null) {
            paramzzart.zza(4, localzza);
          }
        }
      }
      if ((this.zzya != null) && (this.zzya.length > 0)) {
        for (i = 0; i < this.zzya.length; i++)
        {
          localzza = this.zzya[i];
          if (localzza != null) {
            paramzzart.zza(5, localzza);
          }
        }
      }
      if ((this.zzyb != null) && (!this.zzyb.equals(""))) {
        paramzzart.zzq(6, this.zzyb);
      }
      if ((this.zzyc != null) && (!this.zzyc.equals(""))) {
        paramzzart.zzq(7, this.zzyc);
      }
      if (this.zzyd != 0L) {
        paramzzart.zzb(8, this.zzyd);
      }
      if (this.zzyh) {
        paramzzart.zzg(9, this.zzyh);
      }
      if ((this.zzyg != null) && (this.zzyg.length > 0)) {
        for (i = 0; i < this.zzyg.length; i++) {
          paramzzart.zzaf(10, this.zzyg[i]);
        }
      }
      if ((this.zzyf != null) && (this.zzyf.length > 0)) {
        for (i = j; i < this.zzyf.length; i++)
        {
          localzza = this.zzyf[i];
          if (localzza != null) {
            paramzzart.zza(11, localzza);
          }
        }
      }
      if (this.zzye) {
        paramzzart.zzg(12, this.zzye);
      }
      super.zza(paramzzart);
    }
    
    public zza zzas()
    {
      this.type = 1;
      this.string = "";
      this.zzxy = zzar();
      this.zzxz = zzar();
      this.zzya = zzar();
      this.zzyb = "";
      this.zzyc = "";
      this.zzyd = 0L;
      this.zzye = false;
      this.zzyf = zzar();
      this.zzyg = zzasd.btR;
      this.zzyh = false;
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    protected int zzx()
    {
      int m = 0;
      int j = super.zzx() + zzart.zzah(1, this.type);
      int i = j;
      if (this.string != null)
      {
        i = j;
        if (!this.string.equals("")) {
          i = j + zzart.zzr(2, this.string);
        }
      }
      j = i;
      int k;
      zza localzza;
      if (this.zzxy != null)
      {
        j = i;
        if (this.zzxy.length > 0)
        {
          k = 0;
          while (k < this.zzxy.length)
          {
            localzza = this.zzxy[k];
            j = i;
            if (localzza != null) {
              j = i + zzart.zzc(3, localzza);
            }
            k++;
            i = j;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzxz != null)
      {
        i = j;
        if (this.zzxz.length > 0)
        {
          i = j;
          k = 0;
          while (k < this.zzxz.length)
          {
            localzza = this.zzxz[k];
            j = i;
            if (localzza != null) {
              j = i + zzart.zzc(4, localzza);
            }
            k++;
            i = j;
          }
        }
      }
      j = i;
      if (this.zzya != null)
      {
        j = i;
        if (this.zzya.length > 0)
        {
          k = 0;
          while (k < this.zzya.length)
          {
            localzza = this.zzya[k];
            j = i;
            if (localzza != null) {
              j = i + zzart.zzc(5, localzza);
            }
            k++;
            i = j;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzyb != null)
      {
        i = j;
        if (!this.zzyb.equals("")) {
          i = j + zzart.zzr(6, this.zzyb);
        }
      }
      j = i;
      if (this.zzyc != null)
      {
        j = i;
        if (!this.zzyc.equals("")) {
          j = i + zzart.zzr(7, this.zzyc);
        }
      }
      i = j;
      if (this.zzyd != 0L) {
        i = j + zzart.zzf(8, this.zzyd);
      }
      j = i;
      if (this.zzyh) {
        j = i + zzart.zzh(9, this.zzyh);
      }
      i = j;
      if (this.zzyg != null)
      {
        i = j;
        if (this.zzyg.length > 0)
        {
          i = 0;
          k = 0;
          while (i < this.zzyg.length)
          {
            k += zzart.zzagz(this.zzyg[i]);
            i++;
          }
          i = j + k + this.zzyg.length * 1;
        }
      }
      j = i;
      if (this.zzyf != null)
      {
        j = i;
        if (this.zzyf.length > 0)
        {
          k = m;
          for (;;)
          {
            j = i;
            if (k >= this.zzyf.length) {
              break;
            }
            localzza = this.zzyf[k];
            j = i;
            if (localzza != null) {
              j = i + zzart.zzc(11, localzza);
            }
            k++;
            i = j;
          }
        }
      }
      i = j;
      if (this.zzye) {
        i = j + zzart.zzh(12, this.zzye);
      }
      return i;
    }
    
    public zza zzx(zzars paramzzars)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzars.bU();
        int j;
        Object localObject;
        int k;
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
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
            this.type = i;
          }
          break;
        case 18: 
          this.string = paramzzars.readString();
          break;
        case 26: 
          j = zzasd.zzc(paramzzars, 26);
          if (this.zzxy == null) {}
          for (i = 0;; i = this.zzxy.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxy, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zza();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zza();
          paramzzars.zza(localObject[j]);
          this.zzxy = ((zza[])localObject);
          break;
        case 34: 
          j = zzasd.zzc(paramzzars, 34);
          if (this.zzxz == null) {}
          for (i = 0;; i = this.zzxz.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzxz, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zza();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zza();
          paramzzars.zza(localObject[j]);
          this.zzxz = ((zza[])localObject);
          break;
        case 42: 
          j = zzasd.zzc(paramzzars, 42);
          if (this.zzya == null) {}
          for (i = 0;; i = this.zzya.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzya, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zza();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zza();
          paramzzars.zza(localObject[j]);
          this.zzya = ((zza[])localObject);
          break;
        case 50: 
          this.zzyb = paramzzars.readString();
          break;
        case 58: 
          this.zzyc = paramzzars.readString();
          break;
        case 64: 
          this.zzyd = paramzzars.bX();
          break;
        case 72: 
          this.zzyh = paramzzars.ca();
          break;
        case 80: 
          int m = zzasd.zzc(paramzzars, 80);
          int[] arrayOfInt = new int[m];
          j = 0;
          i = 0;
          if (j < m)
          {
            if (j != 0) {
              paramzzars.bU();
            }
            int n = paramzzars.bY();
            switch (n)
            {
            }
            for (;;)
            {
              j++;
              break;
              k = i + 1;
              arrayOfInt[i] = n;
              i = k;
            }
          }
          if (i != 0)
          {
            if (this.zzyg == null) {}
            for (j = 0;; j = this.zzyg.length)
            {
              if ((j != 0) || (i != arrayOfInt.length)) {
                break label805;
              }
              this.zzyg = arrayOfInt;
              break;
            }
            localObject = new int[j + i];
            if (j != 0) {
              System.arraycopy(this.zzyg, 0, localObject, 0, j);
            }
            System.arraycopy(arrayOfInt, 0, localObject, j, i);
            this.zzyg = ((int[])localObject);
          }
          break;
        case 82: 
          k = paramzzars.zzagt(paramzzars.cd());
          i = paramzzars.getPosition();
          j = 0;
          while (paramzzars.ci() > 0) {
            switch (paramzzars.bY())
            {
            default: 
              break;
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
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
              j++;
            }
          }
          if (j != 0)
          {
            paramzzars.zzagv(i);
            if (this.zzyg == null) {}
            for (i = 0;; i = this.zzyg.length)
            {
              localObject = new int[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.zzyg, 0, localObject, 0, i);
                j = i;
              }
              while (paramzzars.ci() > 0)
              {
                i = paramzzars.bY();
                switch (i)
                {
                default: 
                  break;
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
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                  localObject[j] = i;
                  j++;
                }
              }
            }
            this.zzyg = ((int[])localObject);
          }
          paramzzars.zzagu(k);
          break;
        case 90: 
          j = zzasd.zzc(paramzzars, 90);
          if (this.zzyf == null) {}
          for (i = 0;; i = this.zzyf.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0) {
              System.arraycopy(this.zzyf, 0, localObject, 0, i);
            }
            for (j = i; j < localObject.length - 1; j++)
            {
              localObject[j] = new zza();
              paramzzars.zza(localObject[j]);
              paramzzars.bU();
            }
          }
          localObject[j] = new zza();
          paramzzars.zza(localObject[j]);
          this.zzyf = ((zza[])localObject);
          break;
        case 96: 
          label805:
          this.zzye = paramzzars.ca();
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */