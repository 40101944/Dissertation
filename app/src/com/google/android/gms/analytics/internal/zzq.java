package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class zzq<T extends zzp>
  extends zzc
{
  zza<T> ea;
  
  public zzq(zzf paramzzf, zza<T> paramzza)
  {
    super(paramzzf);
    this.ea = paramzza;
  }
  
  private T zza(XmlResourceParser paramXmlResourceParser)
  {
    for (;;)
    {
      try
      {
        paramXmlResourceParser.next();
        i = paramXmlResourceParser.getEventType();
        if (i == 1) {
          continue;
        }
        if (paramXmlResourceParser.getEventType() == 2)
        {
          str1 = paramXmlResourceParser.getName().toLowerCase();
          if (!str1.equals("screenname")) {
            continue;
          }
          str1 = paramXmlResourceParser.getAttributeValue(null, "name");
          str2 = paramXmlResourceParser.nextText().trim();
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            this.ea.zzo(str1, str2);
          }
        }
      }
      catch (XmlPullParserException paramXmlResourceParser)
      {
        zze("Error parsing tracker configuration file", paramXmlResourceParser);
        return this.ea.zzaee();
        if (!str1.equals("bool")) {
          continue;
        }
        String str2 = paramXmlResourceParser.getAttributeValue(null, "name");
        str1 = paramXmlResourceParser.nextText().trim();
        if (TextUtils.isEmpty(str2)) {
          continue;
        }
        bool = TextUtils.isEmpty(str1);
        if (bool) {
          continue;
        }
        try
        {
          bool = Boolean.parseBoolean(str1);
          this.ea.zze(str2, bool);
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          zzc("Error parsing bool configuration value", str1, localNumberFormatException1);
        }
        continue;
      }
      catch (IOException paramXmlResourceParser)
      {
        int i;
        zze("Error parsing tracker configuration file", paramXmlResourceParser);
        continue;
        if (!str1.equals("integer")) {
          continue;
        }
        String str3 = paramXmlResourceParser.getAttributeValue(null, "name");
        String str1 = paramXmlResourceParser.nextText().trim();
        if (TextUtils.isEmpty(str3)) {
          continue;
        }
        boolean bool = TextUtils.isEmpty(str1);
        if (bool) {
          continue;
        }
        try
        {
          i = Integer.parseInt(str1);
          this.ea.zzd(str3, i);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          zzc("Error parsing int configuration value", str1, localNumberFormatException2);
        }
        continue;
      }
      i = paramXmlResourceParser.next();
      continue;
      if (!str1.equals("string")) {
        continue;
      }
      str2 = paramXmlResourceParser.getAttributeValue(null, "name");
      str1 = paramXmlResourceParser.nextText().trim();
      if ((!TextUtils.isEmpty(str2)) && (str1 != null)) {
        this.ea.zzp(str2, str1);
      }
    }
  }
  
  public T zzcg(int paramInt)
  {
    try
    {
      zzp localzzp = zza(zzabx().zzacl().getResources().getXml(paramInt));
      return localzzp;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        zzd("inflate() called with unknown resourceId", localNotFoundException);
        Object localObject = null;
      }
    }
  }
  
  public static abstract interface zza<U extends zzp>
  {
    public abstract U zzaee();
    
    public abstract void zzd(String paramString, int paramInt);
    
    public abstract void zze(String paramString, boolean paramBoolean);
    
    public abstract void zzo(String paramString1, String paramString2);
    
    public abstract void zzp(String paramString1, String paramString2);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */