package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.GROUP_ID})
public class MediaBrowserCompatUtils
{
  public static boolean areSameOptions(Bundle paramBundle1, Bundle paramBundle2)
  {
    boolean bool = true;
    if (paramBundle1 == paramBundle2) {}
    for (;;)
    {
      return bool;
      if (paramBundle1 == null)
      {
        if ((paramBundle2.getInt("android.media.browse.extra.PAGE", -1) != -1) || (paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1)) {
          bool = false;
        }
      }
      else if (paramBundle2 == null)
      {
        if ((paramBundle1.getInt("android.media.browse.extra.PAGE", -1) != -1) || (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1)) {
          bool = false;
        }
      }
      else if ((paramBundle1.getInt("android.media.browse.extra.PAGE", -1) != paramBundle2.getInt("android.media.browse.extra.PAGE", -1)) || (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) != paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1))) {
        bool = false;
      }
    }
  }
  
  public static boolean hasDuplicatedItems(Bundle paramBundle1, Bundle paramBundle2)
  {
    boolean bool = true;
    int k;
    int i;
    label16:
    int m;
    label23:
    int j;
    if (paramBundle1 == null)
    {
      k = -1;
      if (paramBundle2 != null) {
        break label90;
      }
      i = -1;
      if (paramBundle1 != null) {
        break label101;
      }
      m = -1;
      if (paramBundle2 != null) {
        break label113;
      }
      j = -1;
      label29:
      if ((k != -1) && (m != -1)) {
        break label124;
      }
      m = 0;
      k = Integer.MAX_VALUE;
      label48:
      if ((i != -1) && (j != -1)) {
        break label147;
      }
      i = 0;
      j = Integer.MAX_VALUE;
      label63:
      if ((m > i) || (i > k)) {
        break label160;
      }
    }
    for (;;)
    {
      return bool;
      k = paramBundle1.getInt("android.media.browse.extra.PAGE", -1);
      break;
      label90:
      i = paramBundle2.getInt("android.media.browse.extra.PAGE", -1);
      break label16;
      label101:
      m = paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      break label23;
      label113:
      j = paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      break label29;
      label124:
      int n = m * k;
      k = n + m - 1;
      m = n;
      break label48;
      label147:
      i = j * i;
      j = i + j - 1;
      break label63;
      label160:
      if ((m > j) || (j > k)) {
        bool = false;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserCompatUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */