package android.support.v4.widget;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FocusStrategy
{
  private static boolean beamBeats(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2, @NonNull Rect paramRect3)
  {
    boolean bool2 = true;
    boolean bool1 = beamsOverlap(paramInt, paramRect1, paramRect2);
    if ((beamsOverlap(paramInt, paramRect1, paramRect3)) || (!bool1)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (isToDirectionOf(paramInt, paramRect1, paramRect3))
      {
        bool1 = bool2;
        if (paramInt != 17)
        {
          bool1 = bool2;
          if (paramInt != 66)
          {
            bool1 = bool2;
            if (majorAxisDistance(paramInt, paramRect1, paramRect2) >= majorAxisDistanceToFarEdge(paramInt, paramRect1, paramRect3)) {
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  private static boolean beamsOverlap(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
    case 66: 
      if ((paramRect2.bottom < paramRect1.top) || (paramRect2.top > paramRect1.bottom)) {
        break;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if ((paramRect2.right < paramRect1.left) || (paramRect2.left > paramRect1.right)) {
        bool = false;
      }
    }
  }
  
  public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L paramL, @NonNull CollectionAdapter<L, T> paramCollectionAdapter, @NonNull BoundsAdapter<T> paramBoundsAdapter, @Nullable T paramT, @NonNull Rect paramRect, int paramInt)
  {
    Rect localRect2 = new Rect(paramRect);
    Object localObject1;
    Rect localRect1;
    int i;
    label103:
    Object localObject2;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      localRect2.offset(paramRect.width() + 1, 0);
      localObject1 = null;
      int j = paramCollectionAdapter.size(paramL);
      localRect1 = new Rect();
      i = 0;
      if (i >= j) {
        break label221;
      }
      localObject2 = paramCollectionAdapter.get(paramL, i);
      if (localObject2 != paramT) {
        break;
      }
    }
    for (;;)
    {
      i++;
      break label103;
      localRect2.offset(-(paramRect.width() + 1), 0);
      break;
      localRect2.offset(0, paramRect.height() + 1);
      break;
      localRect2.offset(0, -(paramRect.height() + 1));
      break;
      paramBoundsAdapter.obtainBounds(localObject2, localRect1);
      if (isBetterCandidate(paramInt, paramRect, localRect1, localRect2))
      {
        localRect2.set(localRect1);
        localObject1 = localObject2;
      }
    }
    label221:
    return (T)localObject1;
  }
  
  public static <L, T> T findNextFocusInRelativeDirection(@NonNull L paramL, @NonNull CollectionAdapter<L, T> paramCollectionAdapter, @NonNull BoundsAdapter<T> paramBoundsAdapter, @Nullable T paramT, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = paramCollectionAdapter.size(paramL);
    ArrayList localArrayList = new ArrayList(j);
    for (int i = 0; i < j; i++) {
      localArrayList.add(paramCollectionAdapter.get(paramL, i));
    }
    Collections.sort(localArrayList, new SequentialComparator(paramBoolean1, paramBoundsAdapter));
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }
    for (paramL = getNextFocusable(paramT, localArrayList, paramBoolean2);; paramL = getPreviousFocusable(paramT, localArrayList, paramBoolean2)) {
      return paramL;
    }
  }
  
  private static <T> T getNextFocusable(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i;
    if (paramT == null)
    {
      i = -1;
      i++;
      if (i >= j) {
        break label38;
      }
      paramT = paramArrayList.get(i);
    }
    for (;;)
    {
      return paramT;
      i = paramArrayList.lastIndexOf(paramT);
      break;
      label38:
      if ((paramBoolean) && (j > 0)) {
        paramT = paramArrayList.get(0);
      } else {
        paramT = null;
      }
    }
  }
  
  private static <T> T getPreviousFocusable(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i;
    if (paramT == null)
    {
      i = j;
      i--;
      if (i < 0) {
        break label37;
      }
      paramT = paramArrayList.get(i);
    }
    for (;;)
    {
      return paramT;
      i = paramArrayList.indexOf(paramT);
      break;
      label37:
      if ((paramBoolean) && (j > 0)) {
        paramT = paramArrayList.get(j - 1);
      } else {
        paramT = null;
      }
    }
  }
  
  private static int getWeightedDistanceFor(int paramInt1, int paramInt2)
  {
    return paramInt1 * 13 * paramInt1 + paramInt2 * paramInt2;
  }
  
  private static boolean isBetterCandidate(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2, @NonNull Rect paramRect3)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!isCandidate(paramRect1, paramRect2, paramInt)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (isCandidate(paramRect1, paramRect3, paramInt))
      {
        bool1 = bool2;
        if (!beamBeats(paramInt, paramRect1, paramRect2, paramRect3)) {
          if (beamBeats(paramInt, paramRect1, paramRect3, paramRect2))
          {
            bool1 = false;
          }
          else
          {
            bool1 = bool2;
            if (getWeightedDistanceFor(majorAxisDistance(paramInt, paramRect1, paramRect2), minorAxisDistance(paramInt, paramRect1, paramRect2)) >= getWeightedDistanceFor(majorAxisDistance(paramInt, paramRect1, paramRect3), minorAxisDistance(paramInt, paramRect1, paramRect3))) {
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  private static boolean isCandidate(@NonNull Rect paramRect1, @NonNull Rect paramRect2, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      if (((paramRect1.right <= paramRect2.right) && (paramRect1.left < paramRect2.right)) || (paramRect1.left <= paramRect2.left)) {
        break;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if (((paramRect1.left >= paramRect2.left) && (paramRect1.right > paramRect2.left)) || (paramRect1.right >= paramRect2.right))
      {
        bool = false;
        continue;
        if (((paramRect1.bottom <= paramRect2.bottom) && (paramRect1.top < paramRect2.bottom)) || (paramRect1.top <= paramRect2.top))
        {
          bool = false;
          continue;
          if (((paramRect1.top >= paramRect2.top) && (paramRect1.bottom > paramRect2.top)) || (paramRect1.bottom >= paramRect2.bottom)) {
            bool = false;
          }
        }
      }
    }
  }
  
  private static boolean isToDirectionOf(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      if (paramRect1.left < paramRect2.right) {
        break;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if (paramRect1.right > paramRect2.left)
      {
        bool = false;
        continue;
        if (paramRect1.top < paramRect2.bottom)
        {
          bool = false;
          continue;
          if (paramRect1.bottom > paramRect2.top) {
            bool = false;
          }
        }
      }
    }
  }
  
  private static int majorAxisDistance(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    return Math.max(0, majorAxisDistanceRaw(paramInt, paramRect1, paramRect2));
  }
  
  private static int majorAxisDistanceRaw(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      paramInt = paramRect1.left - paramRect2.right;
    }
    for (;;)
    {
      return paramInt;
      paramInt = paramRect2.left - paramRect1.right;
      continue;
      paramInt = paramRect1.top - paramRect2.bottom;
      continue;
      paramInt = paramRect2.top - paramRect1.bottom;
    }
  }
  
  private static int majorAxisDistanceToFarEdge(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    return Math.max(1, majorAxisDistanceToFarEdgeRaw(paramInt, paramRect1, paramRect2));
  }
  
  private static int majorAxisDistanceToFarEdgeRaw(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      paramInt = paramRect1.left - paramRect2.left;
    }
    for (;;)
    {
      return paramInt;
      paramInt = paramRect2.right - paramRect1.right;
      continue;
      paramInt = paramRect1.top - paramRect2.top;
      continue;
      paramInt = paramRect2.bottom - paramRect1.bottom;
    }
  }
  
  private static int minorAxisDistance(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }
    for (paramInt = Math.abs(paramRect1.top + paramRect1.height() / 2 - (paramRect2.top + paramRect2.height() / 2));; paramInt = Math.abs(paramRect1.left + paramRect1.width() / 2 - (paramRect2.left + paramRect2.width() / 2))) {
      return paramInt;
    }
  }
  
  public static abstract interface BoundsAdapter<T>
  {
    public abstract void obtainBounds(T paramT, Rect paramRect);
  }
  
  public static abstract interface CollectionAdapter<T, V>
  {
    public abstract V get(T paramT, int paramInt);
    
    public abstract int size(T paramT);
  }
  
  private static class SequentialComparator<T>
    implements Comparator<T>
  {
    private final FocusStrategy.BoundsAdapter<T> mAdapter;
    private final boolean mIsLayoutRtl;
    private final Rect mTemp1 = new Rect();
    private final Rect mTemp2 = new Rect();
    
    SequentialComparator(boolean paramBoolean, FocusStrategy.BoundsAdapter<T> paramBoundsAdapter)
    {
      this.mIsLayoutRtl = paramBoolean;
      this.mAdapter = paramBoundsAdapter;
    }
    
    public int compare(T paramT1, T paramT2)
    {
      int k = 1;
      int i = 1;
      int j = -1;
      Rect localRect2 = this.mTemp1;
      Rect localRect1 = this.mTemp2;
      this.mAdapter.obtainBounds(paramT1, localRect2);
      this.mAdapter.obtainBounds(paramT2, localRect1);
      if (localRect2.top < localRect1.top) {
        i = j;
      }
      for (;;)
      {
        return i;
        if (localRect2.top > localRect1.top)
        {
          i = 1;
        }
        else if (localRect2.left < localRect1.left)
        {
          if (!this.mIsLayoutRtl) {
            for (;;)
            {
              i = -1;
            }
          }
        }
        else if (localRect2.left > localRect1.left)
        {
          i = j;
          if (!this.mIsLayoutRtl) {
            i = 1;
          }
        }
        else
        {
          i = j;
          if (localRect2.bottom >= localRect1.bottom) {
            if (localRect2.bottom > localRect1.bottom)
            {
              i = 1;
            }
            else
            {
              if (localRect2.right < localRect1.right)
              {
                if (this.mIsLayoutRtl) {}
                for (i = k;; i = -1) {
                  break;
                }
              }
              if (localRect2.right > localRect1.right)
              {
                i = j;
                if (!this.mIsLayoutRtl) {
                  i = 1;
                }
              }
              else
              {
                i = 0;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\widget\FocusStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */