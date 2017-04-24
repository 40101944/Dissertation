package android.support.v4.content;

import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;

public final class SharedPreferencesCompat
{
  public static final class EditorCompat
  {
    private static EditorCompat sInstance;
    private final Helper mHelper = new Helper();
    
    public static EditorCompat getInstance()
    {
      if (sInstance == null) {
        sInstance = new EditorCompat();
      }
      return sInstance;
    }
    
    public void apply(@NonNull SharedPreferences.Editor paramEditor)
    {
      this.mHelper.apply(paramEditor);
    }
    
    private static class Helper
    {
      public void apply(@NonNull SharedPreferences.Editor paramEditor)
      {
        try
        {
          paramEditor.apply();
          return;
        }
        catch (AbstractMethodError localAbstractMethodError)
        {
          for (;;)
          {
            paramEditor.commit();
          }
        }
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\content\SharedPreferencesCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */