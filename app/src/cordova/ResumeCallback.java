package org.apache.cordova;

public class ResumeCallback
  extends CallbackContext
{
  private final String TAG = "CordovaResumeCallback";
  private PluginManager pluginManager;
  private String serviceName;
  
  public ResumeCallback(String paramString, PluginManager paramPluginManager)
  {
    super("resumecallback", null);
    this.serviceName = paramString;
    this.pluginManager = paramPluginManager;
  }
  
  /* Error */
  public void sendPluginResult(PluginResult paramPluginResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	org/apache/cordova/ResumeCallback:finished	Z
    //   6: ifeq +42 -> 48
    //   9: new 35	java/lang/StringBuilder
    //   12: astore_2
    //   13: aload_2
    //   14: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   17: ldc 18
    //   19: aload_2
    //   20: aload_0
    //   21: getfield 22	org/apache/cordova/ResumeCallback:serviceName	Ljava/lang/String;
    //   24: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 44
    //   29: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 50	org/apache/cordova/PluginResult:getMessage	()Ljava/lang/String;
    //   36: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 59	org/apache/cordova/LOG:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: iconst_1
    //   50: putfield 33	org/apache/cordova/ResumeCallback:finished	Z
    //   53: aload_0
    //   54: monitorexit
    //   55: new 61	org/json/JSONObject
    //   58: dup
    //   59: invokespecial 62	org/json/JSONObject:<init>	()V
    //   62: astore_2
    //   63: new 61	org/json/JSONObject
    //   66: dup
    //   67: invokespecial 62	org/json/JSONObject:<init>	()V
    //   70: astore_3
    //   71: aload_3
    //   72: ldc 64
    //   74: aload_0
    //   75: getfield 22	org/apache/cordova/ResumeCallback:serviceName	Ljava/lang/String;
    //   78: invokevirtual 68	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload_3
    //   83: ldc 70
    //   85: getstatic 74	org/apache/cordova/PluginResult:StatusMessages	[Ljava/lang/String;
    //   88: aload_1
    //   89: invokevirtual 78	org/apache/cordova/PluginResult:getStatus	()I
    //   92: aaload
    //   93: invokevirtual 68	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload_2
    //   98: ldc 80
    //   100: ldc 82
    //   102: invokevirtual 68	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload_2
    //   107: ldc 84
    //   109: aload_3
    //   110: invokevirtual 68	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: new 46	org/apache/cordova/PluginResult
    //   117: dup
    //   118: getstatic 90	org/apache/cordova/PluginResult$Status:OK	Lorg/apache/cordova/PluginResult$Status;
    //   121: aload_2
    //   122: invokespecial 93	org/apache/cordova/PluginResult:<init>	(Lorg/apache/cordova/PluginResult$Status;Lorg/json/JSONObject;)V
    //   125: astore_3
    //   126: new 95	java/util/ArrayList
    //   129: dup
    //   130: invokespecial 96	java/util/ArrayList:<init>	()V
    //   133: astore_2
    //   134: aload_2
    //   135: aload_3
    //   136: invokeinterface 102 2 0
    //   141: pop
    //   142: aload_2
    //   143: aload_1
    //   144: invokeinterface 102 2 0
    //   149: pop
    //   150: aload_0
    //   151: getfield 24	org/apache/cordova/ResumeCallback:pluginManager	Lorg/apache/cordova/PluginManager;
    //   154: ldc 104
    //   156: invokevirtual 110	org/apache/cordova/PluginManager:getPlugin	(Ljava/lang/String;)Lorg/apache/cordova/CordovaPlugin;
    //   159: checkcast 112	org/apache/cordova/CoreAndroid
    //   162: new 46	org/apache/cordova/PluginResult
    //   165: dup
    //   166: getstatic 90	org/apache/cordova/PluginResult$Status:OK	Lorg/apache/cordova/PluginResult$Status;
    //   169: aload_2
    //   170: invokespecial 115	org/apache/cordova/PluginResult:<init>	(Lorg/apache/cordova/PluginResult$Status;Ljava/util/List;)V
    //   173: invokevirtual 118	org/apache/cordova/CoreAndroid:sendResumeEvent	(Lorg/apache/cordova/PluginResult;)V
    //   176: goto -129 -> 47
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    //   184: astore_3
    //   185: ldc 18
    //   187: ldc 120
    //   189: invokestatic 123	org/apache/cordova/LOG:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -78 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	ResumeCallback
    //   0	195	1	paramPluginResult	PluginResult
    //   12	158	2	localObject1	Object
    //   70	66	3	localObject2	Object
    //   184	1	3	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   2	47	179	finally
    //   48	55	179	finally
    //   180	182	179	finally
    //   71	114	184	org/json/JSONException
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\ResumeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */