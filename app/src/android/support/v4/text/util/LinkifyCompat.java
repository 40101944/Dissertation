package android.support.v4.text.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.PatternsCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.webkit.WebView;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat
{
  private static final Comparator<LinkSpec> COMPARATOR = new Comparator()
  {
    public final int compare(LinkifyCompat.LinkSpec paramAnonymousLinkSpec1, LinkifyCompat.LinkSpec paramAnonymousLinkSpec2)
    {
      int i = -1;
      if (paramAnonymousLinkSpec1.start < paramAnonymousLinkSpec2.start) {}
      for (;;)
      {
        return i;
        if (paramAnonymousLinkSpec1.start > paramAnonymousLinkSpec2.start) {
          i = 1;
        } else if (paramAnonymousLinkSpec1.end < paramAnonymousLinkSpec2.end) {
          i = 1;
        } else if (paramAnonymousLinkSpec1.end <= paramAnonymousLinkSpec2.end) {
          i = 0;
        }
      }
    }
  };
  private static final String[] EMPTY_STRING = new String[0];
  
  private static void addLinkMovementMethod(@NonNull TextView paramTextView)
  {
    MovementMethod localMovementMethod = paramTextView.getMovementMethod();
    if (((localMovementMethod == null) || (!(localMovementMethod instanceof LinkMovementMethod))) && (paramTextView.getLinksClickable())) {
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public static final void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString)
  {
    addLinks(paramTextView, paramPattern, paramString, null, null, null);
  }
  
  public static final void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    addLinks(paramTextView, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }
  
  public static final void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    SpannableString localSpannableString = SpannableString.valueOf(paramTextView.getText());
    if (addLinks(localSpannableString, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter))
    {
      paramTextView.setText(localSpannableString);
      addLinkMovementMethod(paramTextView);
    }
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject1 = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
      for (int i = localObject1.length - 1; i >= 0; i--) {
        paramSpannable.removeSpan(localObject1[i]);
      }
      if ((paramInt & 0x4) != 0) {
        Linkify.addLinks(paramSpannable, 4);
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      if ((paramInt & 0x1) != 0)
      {
        localObject1 = PatternsCompat.AUTOLINK_WEB_URL;
        localObject2 = Linkify.sUrlMatchFilter;
        gatherLinks(localArrayList, paramSpannable, (Pattern)localObject1, new String[] { "http://", "https://", "rtsp://" }, (Linkify.MatchFilter)localObject2, null);
      }
      if ((paramInt & 0x2) != 0) {
        gatherLinks(localArrayList, paramSpannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[] { "mailto:" }, null, null);
      }
      if ((paramInt & 0x8) != 0) {
        gatherMapLinks(localArrayList, paramSpannable);
      }
      pruneOverlaps(localArrayList, paramSpannable);
      if (localArrayList.size() == 0)
      {
        bool = false;
      }
      else
      {
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (LinkSpec)((Iterator)localObject2).next();
          if (((LinkSpec)localObject1).frameworkAddedSpan == null) {
            applyLink(((LinkSpec)localObject1).url, ((LinkSpec)localObject1).start, ((LinkSpec)localObject1).end, paramSpannable);
          }
        }
        bool = true;
      }
    }
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString)
  {
    return addLinks(paramSpannable, paramPattern, paramString, null, null, null);
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    return addLinks(paramSpannable, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }
  
  public static final boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramArrayOfString != null)
    {
      paramString = paramArrayOfString;
      if (paramArrayOfString.length >= 1) {}
    }
    else
    {
      paramString = EMPTY_STRING;
    }
    String[] arrayOfString = new String[paramString.length + 1];
    arrayOfString[0] = str.toLowerCase(Locale.ROOT);
    int i = 0;
    if (i < paramString.length)
    {
      paramArrayOfString = paramString[i];
      if (paramArrayOfString == null) {}
      for (paramArrayOfString = "";; paramArrayOfString = paramArrayOfString.toLowerCase(Locale.ROOT))
      {
        arrayOfString[(i + 1)] = paramArrayOfString;
        i++;
        break;
      }
    }
    boolean bool1 = false;
    paramPattern = paramPattern.matcher(paramSpannable);
    while (paramPattern.find())
    {
      i = paramPattern.start();
      int j = paramPattern.end();
      boolean bool2 = true;
      if (paramMatchFilter != null) {
        bool2 = paramMatchFilter.acceptMatch(paramSpannable, i, j);
      }
      if (bool2)
      {
        applyLink(makeUrl(paramPattern.group(0), arrayOfString, paramPattern, paramTransformFilter), i, j, paramSpannable);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final boolean addLinks(@NonNull TextView paramTextView, int paramInt)
  {
    boolean bool = false;
    if (paramInt == 0) {}
    for (;;)
    {
      return bool;
      Object localObject = paramTextView.getText();
      if ((localObject instanceof Spannable))
      {
        if (addLinks((Spannable)localObject, paramInt))
        {
          addLinkMovementMethod(paramTextView);
          bool = true;
        }
      }
      else
      {
        localObject = SpannableString.valueOf((CharSequence)localObject);
        if (addLinks((Spannable)localObject, paramInt))
        {
          addLinkMovementMethod(paramTextView);
          paramTextView.setText((CharSequence)localObject);
          bool = true;
        }
      }
    }
  }
  
  private static void applyLink(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable)
  {
    paramSpannable.setSpan(new URLSpan(paramString), paramInt1, paramInt2, 33);
  }
  
  private static void gatherLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable, Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    Matcher localMatcher = paramPattern.matcher(paramSpannable);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((paramMatchFilter == null) || (paramMatchFilter.acceptMatch(paramSpannable, i, j)))
      {
        paramPattern = new LinkSpec();
        paramPattern.url = makeUrl(localMatcher.group(0), paramArrayOfString, localMatcher, paramTransformFilter);
        paramPattern.start = i;
        paramPattern.end = j;
        paramArrayList.add(paramPattern);
      }
    }
  }
  
  private static final void gatherMapLinks(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    paramSpannable = paramSpannable.toString();
    int i = 0;
    for (;;)
    {
      try
      {
        localObject = WebView.findAddress(paramSpannable);
        int j;
        if (localObject != null)
        {
          j = paramSpannable.indexOf((String)localObject);
          if (j >= 0) {}
        }
        else
        {
          return;
        }
        localLinkSpec = new android/support/v4/text/util/LinkifyCompat$LinkSpec;
        localLinkSpec.<init>();
        int k = j + ((String)localObject).length();
        localLinkSpec.start = (i + j);
        localLinkSpec.end = (i + k);
        paramSpannable = paramSpannable.substring(k);
        i += k;
      }
      catch (UnsupportedOperationException paramArrayList)
      {
        try
        {
          LinkSpec localLinkSpec;
          String str = URLEncoder.encode((String)localObject, "UTF-8");
          Object localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          localLinkSpec.url = ("geo:0,0?q=" + str);
          paramArrayList.add(localLinkSpec);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
        paramArrayList = paramArrayList;
      }
    }
  }
  
  private static String makeUrl(@NonNull String paramString, @NonNull String[] paramArrayOfString, Matcher paramMatcher, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    String str = paramString;
    if (paramTransformFilter != null) {
      str = paramTransformFilter.transformUrl(paramMatcher, paramString);
    }
    int k = 0;
    for (int i = 0;; i++)
    {
      int j = k;
      paramString = str;
      if (i < paramArrayOfString.length)
      {
        if (!str.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
          continue;
        }
        k = 1;
        j = k;
        paramString = str;
        if (!str.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
        {
          paramString = paramArrayOfString[i] + str.substring(paramArrayOfString[i].length());
          j = k;
        }
      }
      paramMatcher = paramString;
      if (j == 0)
      {
        paramMatcher = paramString;
        if (paramArrayOfString.length > 0) {
          paramMatcher = paramArrayOfString[0] + paramString;
        }
      }
      return paramMatcher;
    }
  }
  
  private static final void pruneOverlaps(ArrayList<LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    Object localObject2 = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    Object localObject1;
    for (int i = 0; i < localObject2.length; i++)
    {
      localObject1 = new LinkSpec();
      ((LinkSpec)localObject1).frameworkAddedSpan = localObject2[i];
      ((LinkSpec)localObject1).start = paramSpannable.getSpanStart(localObject2[i]);
      ((LinkSpec)localObject1).end = paramSpannable.getSpanEnd(localObject2[i]);
      paramArrayList.add(localObject1);
    }
    Collections.sort(paramArrayList, COMPARATOR);
    int k = paramArrayList.size();
    int j = 0;
    while (j < k - 1)
    {
      localObject2 = (LinkSpec)paramArrayList.get(j);
      localObject1 = (LinkSpec)paramArrayList.get(j + 1);
      i = -1;
      if ((((LinkSpec)localObject2).start <= ((LinkSpec)localObject1).start) && (((LinkSpec)localObject2).end > ((LinkSpec)localObject1).start))
      {
        if (((LinkSpec)localObject1).end <= ((LinkSpec)localObject2).end) {
          i = j + 1;
        }
        for (;;)
        {
          if (i == -1) {
            break label285;
          }
          localObject1 = ((LinkSpec)paramArrayList.get(i)).frameworkAddedSpan;
          if (localObject1 != null) {
            paramSpannable.removeSpan(localObject1);
          }
          paramArrayList.remove(i);
          k--;
          break;
          if (((LinkSpec)localObject2).end - ((LinkSpec)localObject2).start > ((LinkSpec)localObject1).end - ((LinkSpec)localObject1).start) {
            i = j + 1;
          } else if (((LinkSpec)localObject2).end - ((LinkSpec)localObject2).start < ((LinkSpec)localObject1).end - ((LinkSpec)localObject1).start) {
            i = j;
          }
        }
      }
      label285:
      j++;
    }
  }
  
  private static class LinkSpec
  {
    int end;
    URLSpan frameworkAddedSpan;
    int start;
    String url;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LinkifyMask {}
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\text\util\LinkifyCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */