package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.os.Bundle;

class MediaSessionCompatApi14
{
  private static final long ACTION_FAST_FORWARD = 64L;
  private static final long ACTION_PAUSE = 2L;
  private static final long ACTION_PLAY = 4L;
  private static final long ACTION_PLAY_PAUSE = 512L;
  private static final long ACTION_REWIND = 8L;
  private static final long ACTION_SKIP_TO_NEXT = 32L;
  private static final long ACTION_SKIP_TO_PREVIOUS = 16L;
  private static final long ACTION_STOP = 1L;
  private static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
  private static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
  private static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
  private static final String METADATA_KEY_ART = "android.media.metadata.ART";
  private static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
  private static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
  private static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
  private static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
  private static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
  private static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
  private static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
  private static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
  private static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
  private static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
  private static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
  static final int RCC_PLAYSTATE_NONE = 0;
  static final int STATE_BUFFERING = 6;
  static final int STATE_CONNECTING = 8;
  static final int STATE_ERROR = 7;
  static final int STATE_FAST_FORWARDING = 4;
  static final int STATE_NONE = 0;
  static final int STATE_PAUSED = 2;
  static final int STATE_PLAYING = 3;
  static final int STATE_REWINDING = 5;
  static final int STATE_SKIPPING_TO_NEXT = 10;
  static final int STATE_SKIPPING_TO_PREVIOUS = 9;
  static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
  static final int STATE_STOPPED = 1;
  
  static void buildOldMetadata(Bundle paramBundle, RemoteControlClient.MetadataEditor paramMetadataEditor)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.containsKey("android.media.metadata.ART")) {
      paramMetadataEditor.putBitmap(100, (Bitmap)paramBundle.getParcelable("android.media.metadata.ART"));
    }
    for (;;)
    {
      if (paramBundle.containsKey("android.media.metadata.ALBUM")) {
        paramMetadataEditor.putString(1, paramBundle.getString("android.media.metadata.ALBUM"));
      }
      if (paramBundle.containsKey("android.media.metadata.ALBUM_ARTIST")) {
        paramMetadataEditor.putString(13, paramBundle.getString("android.media.metadata.ALBUM_ARTIST"));
      }
      if (paramBundle.containsKey("android.media.metadata.ARTIST")) {
        paramMetadataEditor.putString(2, paramBundle.getString("android.media.metadata.ARTIST"));
      }
      if (paramBundle.containsKey("android.media.metadata.AUTHOR")) {
        paramMetadataEditor.putString(3, paramBundle.getString("android.media.metadata.AUTHOR"));
      }
      if (paramBundle.containsKey("android.media.metadata.COMPILATION")) {
        paramMetadataEditor.putString(15, paramBundle.getString("android.media.metadata.COMPILATION"));
      }
      if (paramBundle.containsKey("android.media.metadata.COMPOSER")) {
        paramMetadataEditor.putString(4, paramBundle.getString("android.media.metadata.COMPOSER"));
      }
      if (paramBundle.containsKey("android.media.metadata.DATE")) {
        paramMetadataEditor.putString(5, paramBundle.getString("android.media.metadata.DATE"));
      }
      if (paramBundle.containsKey("android.media.metadata.DISC_NUMBER")) {
        paramMetadataEditor.putLong(14, paramBundle.getLong("android.media.metadata.DISC_NUMBER"));
      }
      if (paramBundle.containsKey("android.media.metadata.DURATION")) {
        paramMetadataEditor.putLong(9, paramBundle.getLong("android.media.metadata.DURATION"));
      }
      if (paramBundle.containsKey("android.media.metadata.GENRE")) {
        paramMetadataEditor.putString(6, paramBundle.getString("android.media.metadata.GENRE"));
      }
      if (paramBundle.containsKey("android.media.metadata.TITLE")) {
        paramMetadataEditor.putString(7, paramBundle.getString("android.media.metadata.TITLE"));
      }
      if (paramBundle.containsKey("android.media.metadata.TRACK_NUMBER")) {
        paramMetadataEditor.putLong(0, paramBundle.getLong("android.media.metadata.TRACK_NUMBER"));
      }
      if (!paramBundle.containsKey("android.media.metadata.WRITER")) {
        break;
      }
      paramMetadataEditor.putString(11, paramBundle.getString("android.media.metadata.WRITER"));
      break;
      if (paramBundle.containsKey("android.media.metadata.ALBUM_ART")) {
        paramMetadataEditor.putBitmap(100, (Bitmap)paramBundle.getParcelable("android.media.metadata.ALBUM_ART"));
      }
    }
  }
  
  public static Object createRemoteControlClient(PendingIntent paramPendingIntent)
  {
    return new RemoteControlClient(paramPendingIntent);
  }
  
  static int getRccStateFromState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      return paramInt;
      paramInt = 8;
      continue;
      paramInt = 9;
      continue;
      paramInt = 4;
      continue;
      paramInt = 0;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 5;
      continue;
      paramInt = 7;
      continue;
      paramInt = 6;
      continue;
      paramInt = 1;
    }
  }
  
  static int getRccTransportControlFlagsFromActions(long paramLong)
  {
    int i = 0;
    if ((1L & paramLong) != 0L) {
      i = 0x0 | 0x20;
    }
    int j = i;
    if ((0x2 & paramLong) != 0L) {
      j = i | 0x10;
    }
    i = j;
    if ((0x4 & paramLong) != 0L) {
      i = j | 0x4;
    }
    j = i;
    if ((0x8 & paramLong) != 0L) {
      j = i | 0x2;
    }
    i = j;
    if ((0x10 & paramLong) != 0L) {
      i = j | 0x1;
    }
    j = i;
    if ((0x20 & paramLong) != 0L) {
      j = i | 0x80;
    }
    i = j;
    if ((0x40 & paramLong) != 0L) {
      i = j | 0x40;
    }
    j = i;
    if ((0x200 & paramLong) != 0L) {
      j = i | 0x8;
    }
    return j;
  }
  
  public static void registerRemoteControlClient(Context paramContext, Object paramObject)
  {
    ((AudioManager)paramContext.getSystemService("audio")).registerRemoteControlClient((RemoteControlClient)paramObject);
  }
  
  public static void setMetadata(Object paramObject, Bundle paramBundle)
  {
    paramObject = ((RemoteControlClient)paramObject).editMetadata(true);
    buildOldMetadata(paramBundle, (RemoteControlClient.MetadataEditor)paramObject);
    ((RemoteControlClient.MetadataEditor)paramObject).apply();
  }
  
  public static void setState(Object paramObject, int paramInt)
  {
    ((RemoteControlClient)paramObject).setPlaybackState(getRccStateFromState(paramInt));
  }
  
  public static void setTransportControlFlags(Object paramObject, long paramLong)
  {
    ((RemoteControlClient)paramObject).setTransportControlFlags(getRccTransportControlFlagsFromActions(paramLong));
  }
  
  public static void unregisterRemoteControlClient(Context paramContext, Object paramObject)
  {
    ((AudioManager)paramContext.getSystemService("audio")).unregisterRemoteControlClient((RemoteControlClient)paramObject);
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\media\session\MediaSessionCompatApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */