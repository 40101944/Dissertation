package org.apache.cordova;

import android.app.Activity;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class NativeToJsMessageQueue
{
  static final boolean DISABLE_EXEC_CHAINING = false;
  private static final boolean FORCE_ENCODE_USING_EVAL = false;
  private static final String LOG_TAG = "JsMessageQueue";
  private static int MAX_PAYLOAD_SIZE = 524288000;
  private BridgeMode activeBridgeMode;
  private ArrayList<BridgeMode> bridgeModes = new ArrayList();
  private boolean paused;
  private final LinkedList<JsMessage> queue = new LinkedList();
  
  private int calculatePackedMessageLength(JsMessage paramJsMessage)
  {
    int i = paramJsMessage.calculateEncodedLength();
    return String.valueOf(i).length() + i + 1;
  }
  
  /* Error */
  private void enqueueMessage(JsMessage paramJsMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 85	org/apache/cordova/NativeToJsMessageQueue:activeBridgeMode	Lorg/apache/cordova/NativeToJsMessageQueue$BridgeMode;
    //   6: ifnonnull +14 -> 20
    //   9: ldc 36
    //   11: ldc 87
    //   13: invokestatic 93	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 61	org/apache/cordova/NativeToJsMessageQueue:queue	Ljava/util/LinkedList;
    //   24: aload_1
    //   25: invokevirtual 97	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   28: pop
    //   29: aload_0
    //   30: getfield 99	org/apache/cordova/NativeToJsMessageQueue:paused	Z
    //   33: ifne +11 -> 44
    //   36: aload_0
    //   37: getfield 85	org/apache/cordova/NativeToJsMessageQueue:activeBridgeMode	Lorg/apache/cordova/NativeToJsMessageQueue$BridgeMode;
    //   40: aload_0
    //   41: invokevirtual 103	org/apache/cordova/NativeToJsMessageQueue$BridgeMode:onNativeToJsMessageAvailable	(Lorg/apache/cordova/NativeToJsMessageQueue;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: goto -27 -> 19
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	NativeToJsMessageQueue
    //   0	54	1	paramJsMessage	JsMessage
    // Exception table:
    //   from	to	target	type
    //   2	19	49	finally
    //   20	44	49	finally
    //   44	46	49	finally
    //   50	52	49	finally
  }
  
  private void packMessage(JsMessage paramJsMessage, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramJsMessage.calculateEncodedLength()).append(' ');
    paramJsMessage.encodeAsMessage(paramStringBuilder);
  }
  
  public void addBridgeMode(BridgeMode paramBridgeMode)
  {
    this.bridgeModes.add(paramBridgeMode);
  }
  
  public void addJavaScript(String paramString)
  {
    enqueueMessage(new JsMessage(paramString));
  }
  
  public void addPluginResult(PluginResult paramPluginResult, String paramString)
  {
    if (paramString == null)
    {
      Log.e("JsMessageQueue", "Got plugin result with no callbackId", new Throwable());
      return;
    }
    if (paramPluginResult.getStatus() == PluginResult.Status.NO_RESULT.ordinal()) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = paramPluginResult.getKeepCallback();
      if ((i != 0) && (bool)) {
        break;
      }
      enqueueMessage(new JsMessage(paramPluginResult, paramString));
      break;
    }
  }
  
  public boolean isBridgeEnabled()
  {
    if (this.activeBridgeMode != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isEmpty()
  {
    return this.queue.isEmpty();
  }
  
  public String popAndEncode(boolean paramBoolean)
  {
    String str = null;
    for (;;)
    {
      try
      {
        if (this.activeBridgeMode == null) {
          return str;
        }
        this.activeBridgeMode.notifyOfFlush(this, paramBoolean);
        if (this.queue.isEmpty()) {
          continue;
        }
        j = 0;
      }
      finally {}
      int j;
      int i = 0;
      Object localObject2 = this.queue.iterator();
      for (;;)
      {
        int k;
        if (((Iterator)localObject2).hasNext())
        {
          k = calculatePackedMessageLength((JsMessage)((Iterator)localObject2).next());
          if ((i <= 0) || (j + k <= MAX_PAYLOAD_SIZE) || (MAX_PAYLOAD_SIZE <= 0)) {}
        }
        else
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>(j);
          for (j = 0; j < i; j++) {
            packMessage((JsMessage)this.queue.removeFirst(), (StringBuilder)localObject2);
          }
        }
        j += k;
        i++;
      }
      if (!this.queue.isEmpty()) {
        ((StringBuilder)localObject2).append('*');
      }
      localObject2 = ((StringBuilder)localObject2).toString();
    }
  }
  
  public String popAndEncodeAsJs()
  {
    for (;;)
    {
      int i;
      int j;
      int k;
      try
      {
        if (this.queue.size() == 0)
        {
          localObject1 = null;
          return (String)localObject1;
        }
        i = 0;
        j = 0;
        Object localObject1 = this.queue.iterator();
        JsMessage localJsMessage;
        if (((Iterator)localObject1).hasNext())
        {
          k = ((JsMessage)((Iterator)localObject1).next()).calculateEncodedLength() + 50;
          if ((j <= 0) || (i + k <= MAX_PAYLOAD_SIZE) || (MAX_PAYLOAD_SIZE <= 0)) {}
        }
        else
        {
          if (j != this.queue.size()) {
            continue;
          }
          k = 1;
          localObject1 = new java/lang/StringBuilder;
          if (k == 0) {
            continue;
          }
          m = 0;
          ((StringBuilder)localObject1).<init>(m + i);
          i = 0;
          if (i >= j) {
            break label211;
          }
          localJsMessage = (JsMessage)this.queue.removeFirst();
          if ((k == 0) || (i + 1 != j)) {
            continue;
          }
          localJsMessage.encodeAsJsMessage((StringBuilder)localObject1);
          i++;
          continue;
        }
        i += k;
        j++;
        continue;
        k = 0;
        continue;
        int m = 100;
        continue;
        ((StringBuilder)localObject1).append("try{");
        localJsMessage.encodeAsJsMessage((StringBuilder)localObject1);
        ((StringBuilder)localObject1).append("}finally{");
        continue;
        if (k != 0) {
          break label223;
        }
      }
      finally {}
      label211:
      ((StringBuilder)localObject2).append("window.setTimeout(function(){cordova.require('cordova/plugin/android/polling').pollOnce();},0);");
      label223:
      if (k != 0) {
        i = 1;
      }
      while (i < j)
      {
        ((StringBuilder)localObject2).append('}');
        i++;
        continue;
        i = 0;
      }
      String str = ((StringBuilder)localObject2).toString();
    }
  }
  
  public void reset()
  {
    try
    {
      this.queue.clear();
      setBridgeMode(-1);
      return;
    }
    finally {}
  }
  
  public void setBridgeMode(int paramInt)
  {
    if ((paramInt < -1) || (paramInt >= this.bridgeModes.size()))
    {
      Log.d("JsMessageQueue", "Invalid NativeToJsBridgeMode: " + paramInt);
      return;
    }
    BridgeMode localBridgeMode1;
    label48:
    StringBuilder localStringBuilder;
    if (paramInt < 0)
    {
      localBridgeMode1 = null;
      if (localBridgeMode1 == this.activeBridgeMode) {
        break label152;
      }
      localStringBuilder = new StringBuilder().append("Set native->JS mode to ");
      if (localBridgeMode1 != null) {
        break label154;
      }
    }
    BridgeMode localBridgeMode2;
    label152:
    label154:
    for (String str = "null";; str = localBridgeMode2.getClass().getSimpleName())
    {
      Log.d("JsMessageQueue", str);
      try
      {
        this.activeBridgeMode = localBridgeMode1;
        if (localBridgeMode1 != null)
        {
          localBridgeMode1.reset();
          if ((!this.paused) && (!this.queue.isEmpty())) {
            localBridgeMode1.onNativeToJsMessageAvailable(this);
          }
        }
        break;
      }
      finally {}
      localBridgeMode2 = (BridgeMode)this.bridgeModes.get(paramInt);
      break label48;
      break;
    }
  }
  
  public void setPaused(boolean paramBoolean)
  {
    if ((this.paused) && (paramBoolean)) {
      Log.e("JsMessageQueue", "nested call to setPaused detected.", new Throwable());
    }
    this.paused = paramBoolean;
    if (!paramBoolean) {}
    try
    {
      if ((!this.queue.isEmpty()) && (this.activeBridgeMode != null)) {
        this.activeBridgeMode.onNativeToJsMessageAvailable(this);
      }
      return;
    }
    finally {}
  }
  
  public static abstract class BridgeMode
  {
    public void notifyOfFlush(NativeToJsMessageQueue paramNativeToJsMessageQueue, boolean paramBoolean) {}
    
    public abstract void onNativeToJsMessageAvailable(NativeToJsMessageQueue paramNativeToJsMessageQueue);
    
    public void reset() {}
  }
  
  private static class JsMessage
  {
    final String jsPayloadOrCallbackId;
    final PluginResult pluginResult;
    
    JsMessage(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.jsPayloadOrCallbackId = paramString;
      this.pluginResult = null;
    }
    
    JsMessage(PluginResult paramPluginResult, String paramString)
    {
      if ((paramString == null) || (paramPluginResult == null)) {
        throw new NullPointerException();
      }
      this.jsPayloadOrCallbackId = paramString;
      this.pluginResult = paramPluginResult;
    }
    
    static int calculateEncodedLengthHelper(PluginResult paramPluginResult)
    {
      int i;
      switch (paramPluginResult.getMessageType())
      {
      case 2: 
      default: 
        i = paramPluginResult.getMessage().length();
      case 4: 
      case 5: 
      case 3: 
      case 1: 
      case 7: 
      case 6: 
        for (;;)
        {
          return i;
          i = 1;
          continue;
          i = paramPluginResult.getMessage().length() + 1;
          continue;
          i = paramPluginResult.getStrMessage().length() + 1;
          continue;
          i = paramPluginResult.getMessage().length() + 1;
          continue;
          i = paramPluginResult.getMessage().length() + 1;
        }
      }
      int j = 1;
      for (int k = 0;; k++)
      {
        i = j;
        if (k >= paramPluginResult.getMultipartMessagesSize()) {
          break;
        }
        i = calculateEncodedLengthHelper(paramPluginResult.getMultipartMessage(k));
        j += String.valueOf(i).length() + 1 + i;
      }
    }
    
    static void encodeAsMessageHelper(StringBuilder paramStringBuilder, PluginResult paramPluginResult)
    {
      switch (paramPluginResult.getMessageType())
      {
      case 2: 
      default: 
        paramStringBuilder.append(paramPluginResult.getMessage());
      }
      for (;;)
      {
        return;
        paramStringBuilder.append(paramPluginResult.getMessage().charAt(0));
        continue;
        paramStringBuilder.append('N');
        continue;
        paramStringBuilder.append('n').append(paramPluginResult.getMessage());
        continue;
        paramStringBuilder.append('s');
        paramStringBuilder.append(paramPluginResult.getStrMessage());
        continue;
        paramStringBuilder.append('S');
        paramStringBuilder.append(paramPluginResult.getMessage());
        continue;
        paramStringBuilder.append('A');
        paramStringBuilder.append(paramPluginResult.getMessage());
        continue;
        paramStringBuilder.append('M');
        for (int i = 0; i < paramPluginResult.getMultipartMessagesSize(); i++)
        {
          PluginResult localPluginResult = paramPluginResult.getMultipartMessage(i);
          paramStringBuilder.append(String.valueOf(calculateEncodedLengthHelper(localPluginResult)));
          paramStringBuilder.append(' ');
          encodeAsMessageHelper(paramStringBuilder, localPluginResult);
        }
      }
    }
    
    int calculateEncodedLength()
    {
      if (this.pluginResult == null) {}
      int j;
      for (int i = this.jsPayloadOrCallbackId.length() + 1;; i = calculateEncodedLengthHelper(this.pluginResult) + (j + 2 + 1 + i + 1))
      {
        return i;
        j = String.valueOf(this.pluginResult.getStatus()).length();
        i = this.jsPayloadOrCallbackId.length();
      }
    }
    
    void encodeAsJsMessage(StringBuilder paramStringBuilder)
    {
      if (this.pluginResult == null)
      {
        paramStringBuilder.append(this.jsPayloadOrCallbackId);
        return;
      }
      int i = this.pluginResult.getStatus();
      boolean bool;
      if ((i == PluginResult.Status.OK.ordinal()) || (i == PluginResult.Status.NO_RESULT.ordinal()))
      {
        bool = true;
        label47:
        paramStringBuilder.append("cordova.callbackFromNative('").append(this.jsPayloadOrCallbackId).append("',").append(bool).append(",").append(i).append(",[");
        switch (this.pluginResult.getMessageType())
        {
        default: 
          paramStringBuilder.append(this.pluginResult.getMessage());
        }
      }
      for (;;)
      {
        paramStringBuilder.append("],").append(this.pluginResult.getKeepCallback()).append(");");
        break;
        bool = false;
        break label47;
        paramStringBuilder.append("atob('").append(this.pluginResult.getMessage()).append("')");
        continue;
        paramStringBuilder.append("cordova.require('cordova/base64').toArrayBuffer('").append(this.pluginResult.getMessage()).append("')");
      }
    }
    
    void encodeAsMessage(StringBuilder paramStringBuilder)
    {
      if (this.pluginResult == null)
      {
        paramStringBuilder.append('J').append(this.jsPayloadOrCallbackId);
        return;
      }
      int k = this.pluginResult.getStatus();
      int i;
      label44:
      int j;
      label58:
      label79:
      StringBuilder localStringBuilder;
      if (k == PluginResult.Status.NO_RESULT.ordinal())
      {
        i = 1;
        if (k != PluginResult.Status.OK.ordinal()) {
          break label139;
        }
        j = 1;
        boolean bool = this.pluginResult.getKeepCallback();
        if ((i == 0) && (j == 0)) {
          break label145;
        }
        c = 'S';
        localStringBuilder = paramStringBuilder.append(c);
        if (!bool) {
          break label151;
        }
      }
      label139:
      label145:
      label151:
      for (char c = '1';; c = '0')
      {
        localStringBuilder.append(c).append(k).append(' ').append(this.jsPayloadOrCallbackId).append(' ');
        encodeAsMessageHelper(paramStringBuilder, this.pluginResult);
        break;
        i = 0;
        break label44;
        j = 0;
        break label58;
        c = 'F';
        break label79;
      }
    }
  }
  
  public static class LoadUrlBridgeMode
    extends NativeToJsMessageQueue.BridgeMode
  {
    private final CordovaInterface cordova;
    private final CordovaWebViewEngine engine;
    
    public LoadUrlBridgeMode(CordovaWebViewEngine paramCordovaWebViewEngine, CordovaInterface paramCordovaInterface)
    {
      this.engine = paramCordovaWebViewEngine;
      this.cordova = paramCordovaInterface;
    }
    
    public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue paramNativeToJsMessageQueue)
    {
      this.cordova.getActivity().runOnUiThread(new Runnable()
      {
        public void run()
        {
          String str = paramNativeToJsMessageQueue.popAndEncodeAsJs();
          if (str != null) {
            NativeToJsMessageQueue.LoadUrlBridgeMode.this.engine.loadUrl("javascript:" + str, false);
          }
        }
      });
    }
  }
  
  public static class NoOpBridgeMode
    extends NativeToJsMessageQueue.BridgeMode
  {
    public void onNativeToJsMessageAvailable(NativeToJsMessageQueue paramNativeToJsMessageQueue) {}
  }
  
  public static class OnlineEventsBridgeMode
    extends NativeToJsMessageQueue.BridgeMode
  {
    private final OnlineEventsBridgeModeDelegate delegate;
    private boolean ignoreNextFlush;
    private boolean online;
    
    public OnlineEventsBridgeMode(OnlineEventsBridgeModeDelegate paramOnlineEventsBridgeModeDelegate)
    {
      this.delegate = paramOnlineEventsBridgeModeDelegate;
    }
    
    public void notifyOfFlush(NativeToJsMessageQueue paramNativeToJsMessageQueue, boolean paramBoolean)
    {
      if ((paramBoolean) && (!this.ignoreNextFlush)) {
        if (this.online) {
          break label26;
        }
      }
      label26:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.online = paramBoolean;
        return;
      }
    }
    
    public void onNativeToJsMessageAvailable(final NativeToJsMessageQueue paramNativeToJsMessageQueue)
    {
      this.delegate.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (!paramNativeToJsMessageQueue.isEmpty())
          {
            NativeToJsMessageQueue.OnlineEventsBridgeMode.access$202(NativeToJsMessageQueue.OnlineEventsBridgeMode.this, false);
            NativeToJsMessageQueue.OnlineEventsBridgeMode.this.delegate.setNetworkAvailable(NativeToJsMessageQueue.OnlineEventsBridgeMode.this.online);
          }
        }
      });
    }
    
    public void reset()
    {
      this.delegate.runOnUiThread(new Runnable()
      {
        public void run()
        {
          NativeToJsMessageQueue.OnlineEventsBridgeMode.access$102(NativeToJsMessageQueue.OnlineEventsBridgeMode.this, false);
          NativeToJsMessageQueue.OnlineEventsBridgeMode.access$202(NativeToJsMessageQueue.OnlineEventsBridgeMode.this, true);
          NativeToJsMessageQueue.OnlineEventsBridgeMode.this.delegate.setNetworkAvailable(true);
        }
      });
    }
    
    public static abstract interface OnlineEventsBridgeModeDelegate
    {
      public abstract void runOnUiThread(Runnable paramRunnable);
      
      public abstract void setNetworkAvailable(boolean paramBoolean);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\NativeToJsMessageQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */