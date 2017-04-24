package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzafu
{
  public static final class zza
    extends zzaru<zza>
  {
    public long aMu;
    public zzai.zzj aMv;
    public zzai.zzf zzxv;
    
    public zza()
    {
      zzckt();
    }
    
    public static zza zzap(byte[] paramArrayOfByte)
      throws zzarz
    {
      return (zza)zzasa.zza(new zza(), paramArrayOfByte);
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
          if (this.aMu == ((zza)paramObject).aMu)
          {
            if (this.zzxv == null)
            {
              bool1 = bool2;
              if (((zza)paramObject).zzxv != null) {
                continue;
              }
              label55:
              if (this.aMv != null) {
                break label131;
              }
              bool1 = bool2;
              if (((zza)paramObject).aMv != null) {
                continue;
              }
            }
            for (;;)
            {
              if ((this.btG == null) || (this.btG.isEmpty()))
              {
                if (((zza)paramObject).btG != null)
                {
                  bool1 = bool2;
                  if (!((zza)paramObject).btG.isEmpty()) {
                    break;
                  }
                }
                bool1 = true;
                break;
                if (this.zzxv.equals(((zza)paramObject).zzxv)) {
                  break label55;
                }
                bool1 = bool2;
                break;
                label131:
                if (!this.aMv.equals(((zza)paramObject).aMv))
                {
                  bool1 = bool2;
                  break;
                }
              }
            }
            bool1 = this.btG.equals(((zza)paramObject).btG);
          }
        }
      }
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = (int)(this.aMu ^ this.aMu >>> 32);
      int i;
      int j;
      if (this.zzxv == null)
      {
        i = 0;
        if (this.aMv != null) {
          break label110;
        }
        j = 0;
        label48:
        k = m;
        if (this.btG != null) {
          if (!this.btG.isEmpty()) {
            break label121;
          }
        }
      }
      label110:
      label121:
      for (int k = m;; k = this.btG.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = this.zzxv.hashCode();
        break;
        j = this.aMv.hashCode();
        break label48;
      }
    }
    
    public void zza(zzart paramzzart)
      throws IOException
    {
      paramzzart.zzb(1, this.aMu);
      if (this.zzxv != null) {
        paramzzart.zza(2, this.zzxv);
      }
      if (this.aMv != null) {
        paramzzart.zza(3, this.aMv);
      }
      super.zza(paramzzart);
    }
    
    public zza zzaw(zzars paramzzars)
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
          this.aMu = paramzzars.bX();
          break;
        case 18: 
          if (this.zzxv == null) {
            this.zzxv = new zzai.zzf();
          }
          paramzzars.zza(this.zzxv);
          break;
        case 26: 
          if (this.aMv == null) {
            this.aMv = new zzai.zzj();
          }
          paramzzars.zza(this.aMv);
        }
      }
    }
    
    public zza zzckt()
    {
      this.aMu = 0L;
      this.zzxv = null;
      this.aMv = null;
      this.btG = null;
      this.btP = -1;
      return this;
    }
    
    protected int zzx()
    {
      int j = super.zzx() + zzart.zzf(1, this.aMu);
      int i = j;
      if (this.zzxv != null) {
        i = j + zzart.zzc(2, this.zzxv);
      }
      j = i;
      if (this.aMv != null) {
        j = i + zzart.zzc(3, this.aMv);
      }
      return j;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzafu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */