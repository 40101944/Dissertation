package de.appplant.cordova.plugin.notification;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class Options
{
  static final String EXTRA = "NOTIFICATION_OPTIONS";
  private final AssetUtil assets;
  private final Context context;
  private long interval = 0L;
  private JSONObject options = new JSONObject();
  
  public Options(Context paramContext)
  {
    this.context = paramContext;
    this.assets = AssetUtil.getInstance(paramContext);
  }
  
  private void parseAssets()
  {
    if ((this.options.has("iconUri")) && (!this.options.optBoolean("updated"))) {}
    for (;;)
    {
      return;
      Uri localUri1 = this.assets.parse(this.options.optString("icon", "icon"));
      Uri localUri2 = this.assets.parseSound(this.options.optString("sound", null));
      try
      {
        this.options.put("iconUri", localUri1.toString());
        this.options.put("soundUri", localUri2.toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void parseInterval()
  {
    String str = this.options.optString("every").toLowerCase();
    if (str.isEmpty()) {
      this.interval = 0L;
    }
    for (;;)
    {
      return;
      if (str.equals("second")) {
        this.interval = 1000L;
      } else if (str.equals("minute")) {
        this.interval = 60000L;
      } else if (str.equals("hour")) {
        this.interval = 3600000L;
      } else if (str.equals("day")) {
        this.interval = 86400000L;
      } else if (str.equals("week")) {
        this.interval = 604800000L;
      } else if (str.equals("month")) {
        this.interval = 2678400000L;
      } else if (str.equals("quarter")) {
        this.interval = 7884000000L;
      } else if (str.equals("year")) {
        this.interval = 31536000000L;
      } else {
        try
        {
          this.interval = (Integer.parseInt(str) * 60000);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public int getBadgeNumber()
  {
    return this.options.optInt("badge", 0);
  }
  
  public int getColor()
  {
    String str = this.options.optString("color", null);
    if (str == null) {}
    for (int i = 0;; i = -16777216 + Integer.parseInt(str, 16)) {
      return i;
    }
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  JSONObject getDict()
  {
    return this.options;
  }
  
  public int getIcon()
  {
    String str = this.options.optString("icon", "");
    int j = this.assets.getResIdForDrawable(str);
    int i = j;
    if (j == 0) {
      i = getSmallIcon();
    }
    j = i;
    if (i == 0) {
      j = 17301598;
    }
    return j;
  }
  
  public Bitmap getIconBitmap()
  {
    try
    {
      Object localObject = Uri.parse(this.options.optString("iconUri"));
      localObject = this.assets.getIconFromUri((Uri)localObject);
      return (Bitmap)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Bitmap localBitmap = this.assets.getIconFromDrawable("icon");
      }
    }
  }
  
  public Integer getId()
  {
    return Integer.valueOf(this.options.optInt("id", 0));
  }
  
  public String getIdStr()
  {
    return getId().toString();
  }
  
  public int getLedColor()
  {
    String str = this.options.optString("led", null);
    if (str == null) {}
    for (int i = 4;; i = -16777216 + Integer.parseInt(str, 16)) {
      return i;
    }
  }
  
  public long getRepeatInterval()
  {
    return this.interval;
  }
  
  public int getSmallIcon()
  {
    String str = this.options.optString("smallIcon", "");
    return this.assets.getResIdForDrawable(str);
  }
  
  public Uri getSoundUri()
  {
    Object localObject = null;
    try
    {
      Uri localUri = Uri.parse(this.options.optString("soundUri"));
      localObject = localUri;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return (Uri)localObject;
  }
  
  public String getText()
  {
    return this.options.optString("text", "");
  }
  
  public String getTitle()
  {
    String str2 = this.options.optString("title", "");
    String str1 = str2;
    if (str2.isEmpty()) {
      str1 = this.context.getApplicationInfo().loadLabel(this.context.getPackageManager()).toString();
    }
    return str1;
  }
  
  public Date getTriggerDate()
  {
    return new Date(getTriggerTime());
  }
  
  public long getTriggerTime()
  {
    return this.options.optLong("at", 0L) * 1000L;
  }
  
  public Boolean isAutoClear()
  {
    return Boolean.valueOf(this.options.optBoolean("autoClear", false));
  }
  
  public Boolean isOngoing()
  {
    return Boolean.valueOf(this.options.optBoolean("ongoing", false));
  }
  
  public Options parse(JSONObject paramJSONObject)
  {
    this.options = paramJSONObject;
    parseInterval();
    parseAssets();
    return this;
  }
  
  public String toString()
  {
    return this.options.toString();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\Options.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */