package org.apache.cordova;

import android.app.Activity;
import android.content.Intent;
import java.util.List;

@Deprecated
public class Config
{
  private static final String TAG = "Config";
  static ConfigXmlParser parser;
  
  public static String getErrorUrl()
  {
    return parser.getPreferences().getString("errorurl", null);
  }
  
  public static List<PluginEntry> getPluginEntries()
  {
    return parser.getPluginEntries();
  }
  
  public static CordovaPreferences getPreferences()
  {
    return parser.getPreferences();
  }
  
  public static String getStartUrl()
  {
    if (parser == null) {}
    for (String str = "file:///android_asset/www/index.html";; str = parser.getLaunchUrl()) {
      return str;
    }
  }
  
  public static void init()
  {
    if (parser == null) {
      parser = new ConfigXmlParser();
    }
  }
  
  public static void init(Activity paramActivity)
  {
    parser = new ConfigXmlParser();
    parser.parse(paramActivity);
    parser.getPreferences().setPreferencesBundle(paramActivity.getIntent().getExtras());
  }
  
  public static boolean isInitialized()
  {
    if (parser != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */