package de.appplant.cordova.plugin.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class Manager
{
  private Context context;
  
  private Manager(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static Manager getInstance(Context paramContext)
  {
    return new Manager(paramContext);
  }
  
  private NotificationManager getNotMgr()
  {
    return (NotificationManager)this.context.getSystemService("notification");
  }
  
  private SharedPreferences getPrefs()
  {
    return this.context.getSharedPreferences("LocalNotification", 0);
  }
  
  private JSONObject mergeJSONObjects(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    Iterator localIterator = paramJSONObject2.keys();
    while (localIterator.hasNext()) {
      try
      {
        String str = (String)localIterator.next();
        paramJSONObject1.put(str, paramJSONObject2.opt(str));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return paramJSONObject1;
  }
  
  public Notification cancel(int paramInt)
  {
    Notification localNotification = get(paramInt);
    if (localNotification != null) {
      localNotification.cancel();
    }
    return localNotification;
  }
  
  public void cancelAll()
  {
    Iterator localIterator = getAll().iterator();
    while (localIterator.hasNext()) {
      ((Notification)localIterator.next()).cancel();
    }
    getNotMgr().cancelAll();
  }
  
  public Notification clear(int paramInt)
  {
    Notification localNotification = get(paramInt);
    if (localNotification != null) {
      localNotification.clear();
    }
    return localNotification;
  }
  
  public void clearAll()
  {
    Iterator localIterator = getAll().iterator();
    while (localIterator.hasNext()) {
      ((Notification)localIterator.next()).clear();
    }
    getNotMgr().cancelAll();
  }
  
  public boolean exist(int paramInt)
  {
    if (get(paramInt) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean exist(int paramInt, Notification.Type paramType)
  {
    Notification localNotification = get(paramInt);
    if ((localNotification != null) && (localNotification.getType() == paramType)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Notification get(int paramInt)
  {
    Notification localNotification = null;
    Object localObject = getPrefs().getAll();
    String str = Integer.toString(paramInt);
    if (!((Map)localObject).containsKey(str)) {}
    for (;;)
    {
      return localNotification;
      try
      {
        str = ((Map)localObject).get(str).toString();
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(str);
        localNotification = new Builder(this.context, (JSONObject)localObject).build();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public List<Notification> getAll()
  {
    return getByIds(getIds());
  }
  
  public List<Notification> getBy(Notification.Type paramType, List<Integer> paramList)
  {
    paramType = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = get(((Integer)localIterator.next()).intValue());
      if ((paramList != null) && (paramList.isScheduled())) {
        paramType.add(paramList);
      }
    }
    return paramType;
  }
  
  public List<Notification> getByIds(List<Integer> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Notification localNotification = get(((Integer)paramList.next()).intValue());
      if (localNotification != null) {
        localArrayList.add(localNotification);
      }
    }
    return localArrayList;
  }
  
  public List<Notification> getByType(Notification.Type paramType)
  {
    Object localObject = getAll();
    ArrayList localArrayList = new ArrayList();
    if (paramType == Notification.Type.ALL) {}
    for (paramType = (Notification.Type)localObject;; paramType = localArrayList)
    {
      return paramType;
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (Notification)localIterator.next();
        if (((Notification)localObject).getType() == paramType) {
          localArrayList.add(localObject);
        }
      }
    }
  }
  
  public List<Integer> getIds()
  {
    Object localObject = getPrefs().getAll().keySet();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      try
      {
        localArrayList.add(Integer.valueOf(Integer.parseInt(str)));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public List<Integer> getIdsByType(Notification.Type paramType)
  {
    Object localObject = getAll();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Notification localNotification = (Notification)((Iterator)localObject).next();
      if (localNotification.getType() == paramType) {
        localArrayList.add(Integer.valueOf(localNotification.getId()));
      }
    }
    return localArrayList;
  }
  
  public List<JSONObject> getOptions()
  {
    return getOptionsById(getIds());
  }
  
  public List<JSONObject> getOptionsBy(Notification.Type paramType, List<Integer> paramList)
  {
    if (paramType == Notification.Type.ALL)
    {
      paramList = getOptionsById(paramList);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getByIds(paramList).iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (Notification)localIterator.next();
      if (paramList.getType() == paramType) {
        localArrayList.add(paramList.getOptions().getDict());
      }
    }
  }
  
  public List<JSONObject> getOptionsById(List<Integer> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Notification localNotification = get(((Integer)paramList.next()).intValue());
      if (localNotification != null) {
        localArrayList.add(localNotification.getOptions().getDict());
      }
    }
    return localArrayList;
  }
  
  public List<JSONObject> getOptionsByType(Notification.Type paramType)
  {
    ArrayList localArrayList = new ArrayList();
    paramType = getByType(paramType).iterator();
    while (paramType.hasNext()) {
      localArrayList.add(((Notification)paramType.next()).getOptions().getDict());
    }
    return localArrayList;
  }
  
  public Notification schedule(Options paramOptions, Class<?> paramClass)
  {
    paramOptions = new Builder(paramOptions).setTriggerReceiver(paramClass).build();
    paramOptions.schedule();
    return paramOptions;
  }
  
  public Notification schedule(JSONObject paramJSONObject, Class<?> paramClass)
  {
    return schedule(new Options(this.context).parse(paramJSONObject), paramClass);
  }
  
  public Notification update(int paramInt, JSONObject paramJSONObject, Class<?> paramClass)
  {
    Notification localNotification = get(paramInt);
    if (localNotification == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      localNotification.cancel();
      paramJSONObject = mergeJSONObjects(localNotification.getOptions().getDict(), paramJSONObject);
      try
      {
        paramJSONObject.put("updated", true);
        paramJSONObject = schedule(paramJSONObject, paramClass);
      }
      catch (JSONException localJSONException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\de\appplant\cordova\plugin\notification\Manager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */