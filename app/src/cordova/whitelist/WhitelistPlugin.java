package org.apache.cordova.whitelist;

import android.content.Context;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.Whitelist;
import org.xmlpull.v1.XmlPullParser;

public class WhitelistPlugin
  extends CordovaPlugin
{
  private static final String LOG_TAG = "WhitelistPlugin";
  private Whitelist allowedIntents;
  private Whitelist allowedNavigations;
  private Whitelist allowedRequests;
  
  public WhitelistPlugin() {}
  
  public WhitelistPlugin(Context paramContext)
  {
    this(new Whitelist(), new Whitelist(), null);
    new CustomConfigXmlParser(null).parse(paramContext);
  }
  
  public WhitelistPlugin(Whitelist paramWhitelist1, Whitelist paramWhitelist2, Whitelist paramWhitelist3)
  {
    Whitelist localWhitelist = paramWhitelist3;
    if (paramWhitelist3 == null)
    {
      localWhitelist = new Whitelist();
      localWhitelist.addWhiteListEntry("file:///*", false);
      localWhitelist.addWhiteListEntry("data:*", false);
    }
    this.allowedNavigations = paramWhitelist1;
    this.allowedIntents = paramWhitelist2;
    this.allowedRequests = localWhitelist;
  }
  
  public WhitelistPlugin(XmlPullParser paramXmlPullParser)
  {
    this(new Whitelist(), new Whitelist(), null);
    new CustomConfigXmlParser(null).parse(paramXmlPullParser);
  }
  
  public Whitelist getAllowedIntents()
  {
    return this.allowedIntents;
  }
  
  public Whitelist getAllowedNavigations()
  {
    return this.allowedNavigations;
  }
  
  public Whitelist getAllowedRequests()
  {
    return this.allowedRequests;
  }
  
  public void pluginInitialize()
  {
    if (this.allowedNavigations == null)
    {
      this.allowedNavigations = new Whitelist();
      this.allowedIntents = new Whitelist();
      this.allowedRequests = new Whitelist();
      new CustomConfigXmlParser(null).parse(this.webView.getContext());
    }
  }
  
  public void setAllowedIntents(Whitelist paramWhitelist)
  {
    this.allowedIntents = paramWhitelist;
  }
  
  public void setAllowedNavigations(Whitelist paramWhitelist)
  {
    this.allowedNavigations = paramWhitelist;
  }
  
  public void setAllowedRequests(Whitelist paramWhitelist)
  {
    this.allowedRequests = paramWhitelist;
  }
  
  public Boolean shouldAllowNavigation(String paramString)
  {
    if (this.allowedNavigations.isUrlWhiteListed(paramString)) {}
    for (paramString = Boolean.valueOf(true);; paramString = null) {
      return paramString;
    }
  }
  
  public Boolean shouldAllowRequest(String paramString)
  {
    if (Boolean.TRUE == shouldAllowNavigation(paramString)) {
      paramString = Boolean.valueOf(true);
    }
    for (;;)
    {
      return paramString;
      if (this.allowedRequests.isUrlWhiteListed(paramString)) {
        paramString = Boolean.valueOf(true);
      } else {
        paramString = null;
      }
    }
  }
  
  public Boolean shouldOpenExternalUrl(String paramString)
  {
    if (this.allowedIntents.isUrlWhiteListed(paramString)) {}
    for (paramString = Boolean.valueOf(true);; paramString = null) {
      return paramString;
    }
  }
  
  private class CustomConfigXmlParser
    extends ConfigXmlParser
  {
    private CustomConfigXmlParser() {}
    
    public void handleEndTag(XmlPullParser paramXmlPullParser) {}
    
    public void handleStartTag(XmlPullParser paramXmlPullParser)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      String str1 = paramXmlPullParser.getName();
      if (str1.equals("content"))
      {
        paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "src");
        WhitelistPlugin.this.allowedNavigations.addWhiteListEntry(paramXmlPullParser, false);
      }
      String str2;
      for (;;)
      {
        return;
        if (str1.equals("allow-navigation"))
        {
          paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "href");
          if ("*".equals(paramXmlPullParser))
          {
            WhitelistPlugin.this.allowedNavigations.addWhiteListEntry("http://*/*", false);
            WhitelistPlugin.this.allowedNavigations.addWhiteListEntry("https://*/*", false);
            WhitelistPlugin.this.allowedNavigations.addWhiteListEntry("data:*", false);
          }
          else
          {
            WhitelistPlugin.this.allowedNavigations.addWhiteListEntry(paramXmlPullParser, false);
          }
        }
        else if (str1.equals("allow-intent"))
        {
          paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "href");
          WhitelistPlugin.this.allowedIntents.addWhiteListEntry(paramXmlPullParser, false);
        }
        else if (str1.equals("access"))
        {
          str1 = paramXmlPullParser.getAttributeValue(null, "origin");
          str2 = paramXmlPullParser.getAttributeValue(null, "subdomains");
          int i;
          if (paramXmlPullParser.getAttributeValue(null, "launch-external") != null)
          {
            i = 1;
            label213:
            if (str1 == null) {
              break label265;
            }
            if (i == 0) {
              break label272;
            }
            LOG.w("WhitelistPlugin", "Found <access launch-external> within config.xml. Please use <allow-intent> instead.");
            paramXmlPullParser = WhitelistPlugin.this.allowedIntents;
            if ((str2 == null) || (str2.compareToIgnoreCase("true") != 0)) {
              break label267;
            }
          }
          for (;;)
          {
            paramXmlPullParser.addWhiteListEntry(str1, bool1);
            break;
            i = 0;
            break label213;
            label265:
            break;
            label267:
            bool1 = false;
          }
          label272:
          if (!"*".equals(str1)) {
            break;
          }
          WhitelistPlugin.this.allowedRequests.addWhiteListEntry("http://*/*", false);
          WhitelistPlugin.this.allowedRequests.addWhiteListEntry("https://*/*", false);
        }
      }
      paramXmlPullParser = WhitelistPlugin.this.allowedRequests;
      if ((str2 != null) && (str2.compareToIgnoreCase("true") == 0)) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramXmlPullParser.addWhiteListEntry(str1, bool1);
        break;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\whitelist\WhitelistPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */