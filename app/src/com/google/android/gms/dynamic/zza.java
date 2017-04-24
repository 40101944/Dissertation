package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzg;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate>
{
  private T PT;
  private Bundle PU;
  private LinkedList<zza> PV;
  private final zzf<T> PW = new zzf()
  {
    public void zza(T paramAnonymousT)
    {
      zza.zza(zza.this, paramAnonymousT);
      paramAnonymousT = zza.zza(zza.this).iterator();
      while (paramAnonymousT.hasNext()) {
        ((zza.zza)paramAnonymousT.next()).zzb(zza.zzb(zza.this));
      }
      zza.zza(zza.this).clear();
      zza.zza(zza.this, null);
    }
  };
  
  private void zza(Bundle paramBundle, zza paramzza)
  {
    if (this.PT != null)
    {
      paramzza.zzb(this.PT);
      return;
    }
    if (this.PV == null) {
      this.PV = new LinkedList();
    }
    this.PV.add(paramzza);
    if (paramBundle != null)
    {
      if (this.PU != null) {
        break label78;
      }
      this.PU = ((Bundle)paramBundle.clone());
    }
    for (;;)
    {
      zza(this.PW);
      break;
      label78:
      this.PU.putAll(paramBundle);
    }
  }
  
  @VisibleForTesting
  static void zza(FrameLayout paramFrameLayout, final GoogleApiAvailability paramGoogleApiAvailability)
  {
    Context localContext = paramFrameLayout.getContext();
    int i = paramGoogleApiAvailability.isGooglePlayServicesAvailable(localContext);
    String str2 = zzg.zzi(localContext, i);
    String str1 = zzg.zzk(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText(str2);
    localLinearLayout.addView(paramFrameLayout);
    paramGoogleApiAvailability = paramGoogleApiAvailability.zzb(localContext, i, null);
    if (paramGoogleApiAvailability != null)
    {
      paramFrameLayout = new Button(localContext);
      paramFrameLayout.setId(16908313);
      paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      paramFrameLayout.setText(str1);
      localLinearLayout.addView(paramFrameLayout);
      paramFrameLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          try
          {
            zza.this.startActivity(paramGoogleApiAvailability);
            return;
          }
          catch (ActivityNotFoundException paramAnonymousView)
          {
            for (;;)
            {
              Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", paramAnonymousView);
            }
          }
        }
      });
    }
  }
  
  public static void zzb(FrameLayout paramFrameLayout)
  {
    zza(paramFrameLayout, GoogleApiAvailability.getInstance());
  }
  
  private void zznj(int paramInt)
  {
    while ((!this.PV.isEmpty()) && (((zza)this.PV.getLast()).getState() >= paramInt)) {
      this.PV.removeLast();
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    zza(paramBundle, new zza()
    {
      public int getState()
      {
        return 1;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onCreate(paramBundle);
      }
    });
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, final Bundle paramBundle)
  {
    final FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zza(paramBundle, new zza()
    {
      public int getState()
      {
        return 2;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        localFrameLayout.removeAllViews();
        localFrameLayout.addView(zza.zzb(zza.this).onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
      }
    });
    if (this.PT == null) {
      zza(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    if (this.PT != null) {
      this.PT.onDestroy();
    }
    for (;;)
    {
      return;
      zznj(1);
    }
  }
  
  public void onDestroyView()
  {
    if (this.PT != null) {
      this.PT.onDestroyView();
    }
    for (;;)
    {
      return;
      zznj(2);
    }
  }
  
  public void onInflate(final Activity paramActivity, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    zza(paramBundle2, new zza()
    {
      public int getState()
      {
        return 0;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onInflate(paramActivity, paramBundle1, paramBundle2);
      }
    });
  }
  
  public void onLowMemory()
  {
    if (this.PT != null) {
      this.PT.onLowMemory();
    }
  }
  
  public void onPause()
  {
    if (this.PT != null) {
      this.PT.onPause();
    }
    for (;;)
    {
      return;
      zznj(5);
    }
  }
  
  public void onResume()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 5;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onResume();
      }
    });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.PT != null) {
      this.PT.onSaveInstanceState(paramBundle);
    }
    for (;;)
    {
      return;
      if (this.PU != null) {
        paramBundle.putAll(this.PU);
      }
    }
  }
  
  public void onStart()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 4;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onStart();
      }
    });
  }
  
  public void onStop()
  {
    if (this.PT != null) {
      this.PT.onStop();
    }
    for (;;)
    {
      return;
      zznj(4);
    }
  }
  
  protected void zza(FrameLayout paramFrameLayout)
  {
    zzb(paramFrameLayout);
  }
  
  protected abstract void zza(zzf<T> paramzzf);
  
  public T zzbdo()
  {
    return this.PT;
  }
  
  private static abstract interface zza
  {
    public abstract int getState();
    
    public abstract void zzb(LifecycleDelegate paramLifecycleDelegate);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\dynamic\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */