package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class FragmentTransitionCompat21
{
  public static void addTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    paramObject = (Transition)paramObject;
    int j;
    int i;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = ((TransitionSet)paramObject).getTransitionCount();
      for (i = 0; i < j; i++) {
        addTargets(((TransitionSet)paramObject).getTransitionAt(i), paramArrayList);
      }
    }
    if ((!hasSimpleTarget((Transition)paramObject)) && (isNullOrEmpty(((Transition)paramObject).getTargets())))
    {
      j = paramArrayList.size();
      for (i = 0; i < j; i++) {
        ((Transition)paramObject).addTarget((View)paramArrayList.get(i));
      }
    }
  }
  
  public static void addTransitionTargets(Object paramObject1, Object paramObject2, Object paramObject3, View paramView1, final ViewRetriever paramViewRetriever, final View paramView2, EpicenterView paramEpicenterView, final Map<String, String> paramMap, final ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Map<String, View> paramMap1, final Map<String, View> paramMap2, ArrayList<View> paramArrayList3)
  {
    final Transition localTransition1 = (Transition)paramObject1;
    final Transition localTransition2 = (Transition)paramObject3;
    paramObject3 = (Transition)paramObject2;
    excludeViews(localTransition1, localTransition2, paramArrayList2, true);
    if ((paramObject1 != null) || (paramObject2 != null))
    {
      if (localTransition1 != null) {
        localTransition1.addTarget(paramView2);
      }
      if (paramObject2 != null)
      {
        setSharedElementTargets(paramObject3, paramView2, paramMap1, paramArrayList3);
        excludeViews(localTransition1, (Transition)paramObject3, paramArrayList3, true);
        excludeViews(localTransition2, (Transition)paramObject3, paramArrayList3, true);
      }
      paramView1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          this.val$container.getViewTreeObserver().removeOnPreDrawListener(this);
          if (localTransition1 != null) {
            localTransition1.removeTarget(paramView2);
          }
          if (paramViewRetriever != null)
          {
            View localView = paramViewRetriever.getView();
            if (localView != null)
            {
              if (!paramMap.isEmpty())
              {
                FragmentTransitionCompat21.findNamedViews(paramMap2, localView);
                paramMap2.keySet().retainAll(paramMap.values());
                Iterator localIterator = paramMap.entrySet().iterator();
                while (localIterator.hasNext())
                {
                  Map.Entry localEntry = (Map.Entry)localIterator.next();
                  Object localObject = (String)localEntry.getValue();
                  localObject = (View)paramMap2.get(localObject);
                  if (localObject != null) {
                    ((View)localObject).setTransitionName((String)localEntry.getKey());
                  }
                }
              }
              if (localTransition1 != null)
              {
                FragmentTransitionCompat21.captureTransitioningViews(paramArrayList1, localView);
                paramArrayList1.removeAll(paramMap2.values());
                paramArrayList1.add(paramView2);
                FragmentTransitionCompat21.addTargets(localTransition1, paramArrayList1);
              }
            }
          }
          FragmentTransitionCompat21.excludeViews(localTransition2, localTransition1, paramArrayList1, true);
          return true;
        }
      });
      setSharedElementEpicenter(localTransition1, paramEpicenterView);
    }
  }
  
  public static void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  private static void bfsAddViewChildren(List<View> paramList, View paramView)
  {
    int k = paramList.size();
    if (containedBeforeIndex(paramList, paramView, k)) {}
    for (;;)
    {
      return;
      paramList.add(paramView);
      for (int i = k; i < paramList.size(); i++)
      {
        paramView = (View)paramList.get(i);
        if ((paramView instanceof ViewGroup))
        {
          ViewGroup localViewGroup = (ViewGroup)paramView;
          int m = localViewGroup.getChildCount();
          for (int j = 0; j < m; j++)
          {
            paramView = localViewGroup.getChildAt(j);
            if (!containedBeforeIndex(paramList, paramView, k)) {
              paramList.add(paramView);
            }
          }
        }
      }
    }
  }
  
  public static Object captureExitingViews(Object paramObject, View paramView1, ArrayList<View> paramArrayList, Map<String, View> paramMap, View paramView2)
  {
    Object localObject = paramObject;
    if (paramObject != null)
    {
      captureTransitioningViews(paramArrayList, paramView1);
      if (paramMap != null) {
        paramArrayList.removeAll(paramMap.values());
      }
      if (!paramArrayList.isEmpty()) {
        break label40;
      }
    }
    for (localObject = null;; localObject = paramObject)
    {
      return localObject;
      label40:
      paramArrayList.add(paramView2);
      addTargets((Transition)paramObject, paramArrayList);
    }
  }
  
  private static void captureTransitioningViews(ArrayList<View> paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup)) {
        break label60;
      }
      paramView = (ViewGroup)paramView;
      if (!paramView.isTransitionGroup()) {
        break label33;
      }
      paramArrayList.add(paramView);
    }
    for (;;)
    {
      return;
      label33:
      int j = paramView.getChildCount();
      for (int i = 0; i < j; i++) {
        captureTransitioningViews(paramArrayList, paramView.getChildAt(i));
      }
      continue;
      label60:
      paramArrayList.add(paramView);
    }
  }
  
  public static void cleanupTransitions(View paramView1, final View paramView2, final Object paramObject1, final ArrayList<View> paramArrayList1, final Object paramObject2, final ArrayList<View> paramArrayList2, final Object paramObject3, final ArrayList<View> paramArrayList3, final Object paramObject4, final ArrayList<View> paramArrayList4, final Map<String, View> paramMap)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    paramObject4 = (Transition)paramObject4;
    if (paramObject4 != null) {
      paramView1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
          if (paramObject1 != null)
          {
            FragmentTransitionCompat21.removeTargets(paramObject1, paramArrayList1);
            FragmentTransitionCompat21.excludeViews(paramObject1, paramObject2, paramArrayList2, false);
            FragmentTransitionCompat21.excludeViews(paramObject1, paramObject3, paramArrayList3, false);
          }
          if (paramObject2 != null)
          {
            FragmentTransitionCompat21.removeTargets(paramObject2, paramArrayList2);
            FragmentTransitionCompat21.excludeViews(paramObject2, paramObject1, paramArrayList1, false);
            FragmentTransitionCompat21.excludeViews(paramObject2, paramObject3, paramArrayList3, false);
          }
          if (paramObject3 != null) {
            FragmentTransitionCompat21.removeTargets(paramObject3, paramArrayList3);
          }
          Iterator localIterator = paramMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            ((View)localEntry.getValue()).setTransitionName((String)localEntry.getKey());
          }
          int j = paramArrayList4.size();
          for (int i = 0; i < j; i++) {
            paramObject4.excludeTarget((View)paramArrayList4.get(i), false);
          }
          paramObject4.excludeTarget(paramView2, false);
          return true;
        }
      });
    }
  }
  
  public static Object cloneTransition(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject != null) {
      localObject = ((Transition)paramObject).clone();
    }
    return localObject;
  }
  
  private static boolean containedBeforeIndex(List<View> paramList, View paramView, int paramInt)
  {
    int i = 0;
    if (i < paramInt) {
      if (paramList.get(i) != paramView) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i++;
      break;
    }
  }
  
  public static void excludeSharedElementViews(Object paramObject1, Object paramObject2, Object paramObject3, ArrayList<View> paramArrayList, boolean paramBoolean)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    excludeViews((Transition)paramObject1, (Transition)paramObject3, paramArrayList, paramBoolean);
    excludeViews((Transition)paramObject2, (Transition)paramObject3, paramArrayList, paramBoolean);
  }
  
  public static void excludeTarget(Object paramObject, View paramView, boolean paramBoolean)
  {
    ((Transition)paramObject).excludeTarget(paramView, paramBoolean);
  }
  
  private static void excludeViews(Transition paramTransition1, Transition paramTransition2, ArrayList<View> paramArrayList, boolean paramBoolean)
  {
    if (paramTransition1 != null)
    {
      if (paramTransition2 == null) {}
      for (int i = 0;; i = paramArrayList.size()) {
        for (int j = 0; j < i; j++) {
          paramTransition1.excludeTarget((View)paramArrayList.get(j), paramBoolean);
        }
      }
    }
  }
  
  public static void findNamedViews(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = paramView.getTransitionName();
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        for (int i = 0; i < j; i++) {
          findNamedViews(paramMap, paramView.getChildAt(i));
        }
      }
    }
  }
  
  private static Rect getBoundsOnScreen(View paramView)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    localRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    return localRect;
  }
  
  public static String getTransitionName(View paramView)
  {
    return paramView.getTransitionName();
  }
  
  private static boolean hasSimpleTarget(Transition paramTransition)
  {
    if ((!isNullOrEmpty(paramTransition.getTargetIds())) || (!isNullOrEmpty(paramTransition.getTargetNames())) || (!isNullOrEmpty(paramTransition.getTargetTypes()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean isNullOrEmpty(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static Object mergeTransitions(Object paramObject1, Object paramObject2, Object paramObject3, boolean paramBoolean)
  {
    boolean bool2 = true;
    Transition localTransition = (Transition)paramObject1;
    paramObject1 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    boolean bool1 = bool2;
    if (localTransition != null)
    {
      bool1 = bool2;
      if (paramObject1 != null) {
        bool1 = paramBoolean;
      }
    }
    if (bool1)
    {
      paramObject2 = new TransitionSet();
      if (localTransition != null) {
        ((TransitionSet)paramObject2).addTransition(localTransition);
      }
      if (paramObject1 != null) {
        ((TransitionSet)paramObject2).addTransition((Transition)paramObject1);
      }
      if (paramObject3 != null) {
        ((TransitionSet)paramObject2).addTransition((Transition)paramObject3);
      }
      paramObject1 = paramObject2;
    }
    label173:
    for (;;)
    {
      return paramObject1;
      paramObject2 = null;
      if ((paramObject1 != null) && (localTransition != null)) {
        paramObject1 = new TransitionSet().addTransition((Transition)paramObject1).addTransition(localTransition).setOrdering(1);
      }
      for (;;)
      {
        if (paramObject3 == null) {
          break label173;
        }
        paramObject2 = new TransitionSet();
        if (paramObject1 != null) {
          ((TransitionSet)paramObject2).addTransition((Transition)paramObject1);
        }
        ((TransitionSet)paramObject2).addTransition((Transition)paramObject3);
        paramObject1 = paramObject2;
        break;
        if (paramObject1 == null)
        {
          paramObject1 = paramObject2;
          if (localTransition != null) {
            paramObject1 = localTransition;
          }
        }
      }
    }
  }
  
  public static void removeTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    paramObject = (Transition)paramObject;
    int i;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      int j = ((TransitionSet)paramObject).getTransitionCount();
      for (i = 0; i < j; i++) {
        removeTargets(((TransitionSet)paramObject).getTransitionAt(i), paramArrayList);
      }
    }
    if (!hasSimpleTarget((Transition)paramObject))
    {
      List localList = ((Transition)paramObject).getTargets();
      if ((localList != null) && (localList.size() == paramArrayList.size()) && (localList.containsAll(paramArrayList))) {
        for (i = paramArrayList.size() - 1; i >= 0; i--) {
          ((Transition)paramObject).removeTarget((View)paramArrayList.get(i));
        }
      }
    }
  }
  
  public static void setEpicenter(Object paramObject, View paramView)
  {
    ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback()
    {
      public Rect onGetEpicenter(Transition paramAnonymousTransition)
      {
        return this.val$epicenter;
      }
    });
  }
  
  private static void setSharedElementEpicenter(Transition paramTransition, EpicenterView paramEpicenterView)
  {
    if (paramTransition != null) {
      paramTransition.setEpicenterCallback(new Transition.EpicenterCallback()
      {
        private Rect mEpicenter;
        
        public Rect onGetEpicenter(Transition paramAnonymousTransition)
        {
          if ((this.mEpicenter == null) && (this.val$epicenterView.epicenter != null)) {
            this.mEpicenter = FragmentTransitionCompat21.getBoundsOnScreen(this.val$epicenterView.epicenter);
          }
          return this.mEpicenter;
        }
      });
    }
  }
  
  public static void setSharedElementTargets(Object paramObject, View paramView, Map<String, View> paramMap, ArrayList<View> paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    paramArrayList.clear();
    paramArrayList.addAll(paramMap.values());
    paramMap = ((TransitionSet)paramObject).getTargets();
    paramMap.clear();
    int j = paramArrayList.size();
    for (int i = 0; i < j; i++) {
      bfsAddViewChildren(paramMap, (View)paramArrayList.get(i));
    }
    paramArrayList.add(paramView);
    addTargets(paramObject, paramArrayList);
  }
  
  public static Object wrapSharedElementTransition(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      paramObject = localObject;
    }
    for (;;)
    {
      return paramObject;
      Transition localTransition = (Transition)paramObject;
      paramObject = localObject;
      if (localTransition != null)
      {
        paramObject = new TransitionSet();
        ((TransitionSet)paramObject).addTransition(localTransition);
      }
    }
  }
  
  public static class EpicenterView
  {
    public View epicenter;
  }
  
  public static abstract interface ViewRetriever
  {
    public abstract View getView();
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\app\FragmentTransitionCompat21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */