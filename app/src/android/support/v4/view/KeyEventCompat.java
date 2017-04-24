package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.KeyEvent.DispatcherState;
import android.view.View;

public final class KeyEventCompat
{
  static final KeyEventVersionImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (IMPL = new HoneycombKeyEventVersionImpl();; IMPL = new BaseKeyEventVersionImpl()) {
      return;
    }
  }
  
  @Deprecated
  public static boolean dispatch(KeyEvent paramKeyEvent, KeyEvent.Callback paramCallback, Object paramObject1, Object paramObject2)
  {
    return paramKeyEvent.dispatch(paramCallback, (KeyEvent.DispatcherState)paramObject1, paramObject2);
  }
  
  @Deprecated
  public static Object getKeyDispatcherState(View paramView)
  {
    return paramView.getKeyDispatcherState();
  }
  
  public static boolean hasModifiers(KeyEvent paramKeyEvent, int paramInt)
  {
    return IMPL.metaStateHasModifiers(paramKeyEvent.getMetaState(), paramInt);
  }
  
  public static boolean hasNoModifiers(KeyEvent paramKeyEvent)
  {
    return IMPL.metaStateHasNoModifiers(paramKeyEvent.getMetaState());
  }
  
  public static boolean isCtrlPressed(KeyEvent paramKeyEvent)
  {
    return IMPL.isCtrlPressed(paramKeyEvent);
  }
  
  @Deprecated
  public static boolean isTracking(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.isTracking();
  }
  
  public static boolean metaStateHasModifiers(int paramInt1, int paramInt2)
  {
    return IMPL.metaStateHasModifiers(paramInt1, paramInt2);
  }
  
  public static boolean metaStateHasNoModifiers(int paramInt)
  {
    return IMPL.metaStateHasNoModifiers(paramInt);
  }
  
  public static int normalizeMetaState(int paramInt)
  {
    return IMPL.normalizeMetaState(paramInt);
  }
  
  @Deprecated
  public static void startTracking(KeyEvent paramKeyEvent)
  {
    paramKeyEvent.startTracking();
  }
  
  static class BaseKeyEventVersionImpl
    implements KeyEventCompat.KeyEventVersionImpl
  {
    private static final int META_ALL_MASK = 247;
    private static final int META_MODIFIER_MASK = 247;
    
    private static int metaStateFilterDirectionalModifiers(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      int j = 1;
      int i;
      if ((paramInt2 & paramInt3) != 0)
      {
        i = 1;
        paramInt5 = paramInt4 | paramInt5;
        if ((paramInt2 & paramInt5) == 0) {
          break label53;
        }
        paramInt4 = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          if (paramInt4 != 0)
          {
            throw new IllegalArgumentException("bad arguments");
            i = 0;
            break;
            label53:
            paramInt4 = 0;
            continue;
          }
          paramInt2 = paramInt1 & (paramInt5 ^ 0xFFFFFFFF);
        }
      }
      for (;;)
      {
        return paramInt2;
        paramInt2 = paramInt1;
        if (paramInt4 != 0) {
          paramInt2 = paramInt1 & (paramInt3 ^ 0xFFFFFFFF);
        }
      }
    }
    
    public boolean isCtrlPressed(KeyEvent paramKeyEvent)
    {
      return false;
    }
    
    public boolean metaStateHasModifiers(int paramInt1, int paramInt2)
    {
      boolean bool = true;
      if (metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(paramInt1) & 0xF7, paramInt2, 1, 64, 128), paramInt2, 2, 16, 32) == paramInt2) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    
    public boolean metaStateHasNoModifiers(int paramInt)
    {
      if ((normalizeMetaState(paramInt) & 0xF7) == 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int normalizeMetaState(int paramInt)
    {
      int i = paramInt;
      if ((paramInt & 0xC0) != 0) {
        i = paramInt | 0x1;
      }
      paramInt = i;
      if ((i & 0x30) != 0) {
        paramInt = i | 0x2;
      }
      return paramInt & 0xF7;
    }
  }
  
  static class HoneycombKeyEventVersionImpl
    extends KeyEventCompat.BaseKeyEventVersionImpl
  {
    public boolean isCtrlPressed(KeyEvent paramKeyEvent)
    {
      return KeyEventCompatHoneycomb.isCtrlPressed(paramKeyEvent);
    }
    
    public boolean metaStateHasModifiers(int paramInt1, int paramInt2)
    {
      return KeyEventCompatHoneycomb.metaStateHasModifiers(paramInt1, paramInt2);
    }
    
    public boolean metaStateHasNoModifiers(int paramInt)
    {
      return KeyEventCompatHoneycomb.metaStateHasNoModifiers(paramInt);
    }
    
    public int normalizeMetaState(int paramInt)
    {
      return KeyEventCompatHoneycomb.normalizeMetaState(paramInt);
    }
  }
  
  static abstract interface KeyEventVersionImpl
  {
    public abstract boolean isCtrlPressed(KeyEvent paramKeyEvent);
    
    public abstract boolean metaStateHasModifiers(int paramInt1, int paramInt2);
    
    public abstract boolean metaStateHasNoModifiers(int paramInt);
    
    public abstract int normalizeMetaState(int paramInt);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\view\KeyEventCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */