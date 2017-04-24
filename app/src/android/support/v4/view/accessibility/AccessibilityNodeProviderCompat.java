package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat
{
  public static final int HOST_VIEW_ID = -1;
  private static final AccessibilityNodeProviderImpl IMPL;
  private final Object mProvider;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {
      IMPL = new AccessibilityNodeProviderKitKatImpl();
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        IMPL = new AccessibilityNodeProviderJellyBeanImpl();
      } else {
        IMPL = new AccessibilityNodeProviderStubImpl();
      }
    }
  }
  
  public AccessibilityNodeProviderCompat()
  {
    this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
  }
  
  public AccessibilityNodeProviderCompat(Object paramObject)
  {
    this.mProvider = paramObject;
  }
  
  @Nullable
  public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
  {
    return null;
  }
  
  @Nullable
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return null;
  }
  
  @Nullable
  public AccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return null;
  }
  
  public Object getProvider()
  {
    return this.mProvider;
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  static abstract interface AccessibilityNodeProviderImpl
  {
    public abstract Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat);
  }
  
  private static class AccessibilityNodeProviderJellyBeanImpl
    extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl
  {
    public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
    {
      AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge()
      {
        public Object createAccessibilityNodeInfo(int paramAnonymousInt)
        {
          Object localObject = paramAccessibilityNodeProviderCompat.createAccessibilityNodeInfo(paramAnonymousInt);
          if (localObject == null) {}
          for (localObject = null;; localObject = ((AccessibilityNodeInfoCompat)localObject).getInfo()) {
            return localObject;
          }
        }
        
        public List<Object> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
        {
          List localList = paramAccessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
          if (localList == null)
          {
            paramAnonymousString = null;
            return paramAnonymousString;
          }
          ArrayList localArrayList = new ArrayList();
          int i = localList.size();
          for (paramAnonymousInt = 0;; paramAnonymousInt++)
          {
            paramAnonymousString = localArrayList;
            if (paramAnonymousInt >= i) {
              break;
            }
            localArrayList.add(((AccessibilityNodeInfoCompat)localList.get(paramAnonymousInt)).getInfo());
          }
        }
        
        public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
        {
          return paramAccessibilityNodeProviderCompat.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
        }
      });
    }
  }
  
  private static class AccessibilityNodeProviderKitKatImpl
    extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl
  {
    public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
    {
      AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge()
      {
        public Object createAccessibilityNodeInfo(int paramAnonymousInt)
        {
          Object localObject = paramAccessibilityNodeProviderCompat.createAccessibilityNodeInfo(paramAnonymousInt);
          if (localObject == null) {}
          for (localObject = null;; localObject = ((AccessibilityNodeInfoCompat)localObject).getInfo()) {
            return localObject;
          }
        }
        
        public List<Object> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
        {
          List localList = paramAccessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
          if (localList == null)
          {
            paramAnonymousString = null;
            return paramAnonymousString;
          }
          ArrayList localArrayList = new ArrayList();
          int i = localList.size();
          for (paramAnonymousInt = 0;; paramAnonymousInt++)
          {
            paramAnonymousString = localArrayList;
            if (paramAnonymousInt >= i) {
              break;
            }
            localArrayList.add(((AccessibilityNodeInfoCompat)localList.get(paramAnonymousInt)).getInfo());
          }
        }
        
        public Object findFocus(int paramAnonymousInt)
        {
          Object localObject = paramAccessibilityNodeProviderCompat.findFocus(paramAnonymousInt);
          if (localObject == null) {}
          for (localObject = null;; localObject = ((AccessibilityNodeInfoCompat)localObject).getInfo()) {
            return localObject;
          }
        }
        
        public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
        {
          return paramAccessibilityNodeProviderCompat.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
        }
      });
    }
  }
  
  static class AccessibilityNodeProviderStubImpl
    implements AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
  {
    public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
    {
      return null;
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\view\accessibility\AccessibilityNodeProviderCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */