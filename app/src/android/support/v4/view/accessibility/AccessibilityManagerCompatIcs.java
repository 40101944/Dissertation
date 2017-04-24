package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import java.util.List;

class AccessibilityManagerCompatIcs
{
  public static boolean addAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityStateChangeListenerWrapper paramAccessibilityStateChangeListenerWrapper)
  {
    return paramAccessibilityManager.addAccessibilityStateChangeListener(paramAccessibilityStateChangeListenerWrapper);
  }
  
  public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager, int paramInt)
  {
    return paramAccessibilityManager.getEnabledAccessibilityServiceList(paramInt);
  }
  
  public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager)
  {
    return paramAccessibilityManager.getInstalledAccessibilityServiceList();
  }
  
  public static boolean isTouchExplorationEnabled(AccessibilityManager paramAccessibilityManager)
  {
    return paramAccessibilityManager.isTouchExplorationEnabled();
  }
  
  public static boolean removeAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityStateChangeListenerWrapper paramAccessibilityStateChangeListenerWrapper)
  {
    return paramAccessibilityManager.removeAccessibilityStateChangeListener(paramAccessibilityStateChangeListenerWrapper);
  }
  
  static abstract interface AccessibilityStateChangeListenerBridge
  {
    public abstract void onAccessibilityStateChanged(boolean paramBoolean);
  }
  
  public static class AccessibilityStateChangeListenerWrapper
    implements AccessibilityManager.AccessibilityStateChangeListener
  {
    Object mListener;
    AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge mListenerBridge;
    
    public AccessibilityStateChangeListenerWrapper(Object paramObject, AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge paramAccessibilityStateChangeListenerBridge)
    {
      this.mListener = paramObject;
      this.mListenerBridge = paramAccessibilityStateChangeListenerBridge;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {}
      for (;;)
      {
        return bool;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
        {
          bool = false;
        }
        else
        {
          paramObject = (AccessibilityStateChangeListenerWrapper)paramObject;
          if (this.mListener == null)
          {
            if (((AccessibilityStateChangeListenerWrapper)paramObject).mListener != null) {
              bool = false;
            }
          }
          else {
            bool = this.mListener.equals(((AccessibilityStateChangeListenerWrapper)paramObject).mListener);
          }
        }
      }
    }
    
    public int hashCode()
    {
      if (this.mListener == null) {}
      for (int i = 0;; i = this.mListener.hashCode()) {
        return i;
      }
    }
    
    public void onAccessibilityStateChanged(boolean paramBoolean)
    {
      this.mListenerBridge.onAccessibilityStateChanged(paramBoolean);
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityManagerCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */