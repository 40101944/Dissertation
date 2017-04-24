package org.apache.cordova.file;

import android.util.SparseArray;
import org.apache.cordova.CallbackContext;

class PendingRequests
{
  private int currentReqId = 0;
  private SparseArray<Request> requests = new SparseArray();
  
  public int createRequest(String paramString, int paramInt, CallbackContext paramCallbackContext)
  {
    try
    {
      Request localRequest = new org/apache/cordova/file/PendingRequests$Request;
      localRequest.<init>(this, paramString, paramInt, paramCallbackContext, null);
      this.requests.put(localRequest.requestCode, localRequest);
      paramInt = localRequest.requestCode;
      return paramInt;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Request getAndRemove(int paramInt)
  {
    try
    {
      Request localRequest = (Request)this.requests.get(paramInt);
      this.requests.remove(paramInt);
      return localRequest;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public class Request
  {
    private int action;
    private CallbackContext callbackContext;
    private String rawArgs;
    private int requestCode;
    
    private Request(String paramString, int paramInt, CallbackContext paramCallbackContext)
    {
      this.rawArgs = paramString;
      this.action = paramInt;
      this.callbackContext = paramCallbackContext;
      this.requestCode = PendingRequests.access$208(PendingRequests.this);
    }
    
    public int getAction()
    {
      return this.action;
    }
    
    public CallbackContext getCallbackContext()
    {
      return this.callbackContext;
    }
    
    public String getRawArgs()
    {
      return this.rawArgs;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\org\apache\cordova\file\PendingRequests.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */