package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command
  implements Parcelable
{
  @Deprecated
  public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator()
  {
    @Deprecated
    public Command[] zzcf(int paramAnonymousInt)
    {
      return new Command[paramAnonymousInt];
    }
    
    @Deprecated
    public Command zzw(Parcel paramAnonymousParcel)
    {
      return new Command(paramAnonymousParcel);
    }
  };
  private String dW;
  private String mValue;
  private String zzboa;
  
  @Deprecated
  public Command() {}
  
  @Deprecated
  Command(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  @Deprecated
  private void readFromParcel(Parcel paramParcel)
  {
    this.zzboa = paramParcel.readString();
    this.dW = paramParcel.readString();
    this.mValue = paramParcel.readString();
  }
  
  @Deprecated
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.zzboa;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.zzboa);
    paramParcel.writeString(this.dW);
    paramParcel.writeString(this.mValue);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\analytics\internal\Command.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */