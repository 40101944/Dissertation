package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class zzaqp
  implements Closeable
{
  private static final char[] bro = ")]}'\n".toCharArray();
  private int[] brA;
  private boolean brp = false;
  private final char[] brq = new char['Ѐ'];
  private int brr = 0;
  private int brs = 0;
  private int brt = 0;
  private long bru;
  private int brv;
  private String brw;
  private int[] brx = new int[32];
  private int bry = 0;
  private String[] brz;
  private final Reader in;
  private int limit = 0;
  private int pos = 0;
  
  static
  {
    zzapu.bph = new zzapu()
    {
      public void zzi(zzaqp paramAnonymouszzaqp)
        throws IOException
      {
        if ((paramAnonymouszzaqp instanceof zzaqf)) {
          ((zzaqf)paramAnonymouszzaqp).bt();
        }
        for (;;)
        {
          return;
          j = zzaqp.zzag(paramAnonymouszzaqp);
          i = j;
          if (j == 0) {
            i = zzaqp.zzah(paramAnonymouszzaqp);
          }
          if (i == 13)
          {
            zzaqp.zza(paramAnonymouszzaqp, 9);
          }
          else if (i == 12)
          {
            zzaqp.zza(paramAnonymouszzaqp, 8);
          }
          else
          {
            if (i != 14) {
              break;
            }
            zzaqp.zza(paramAnonymouszzaqp, 10);
          }
        }
        String str = String.valueOf(paramAnonymouszzaqp.bq());
        int j = zzaqp.zzai(paramAnonymouszzaqp);
        int i = zzaqp.zzaj(paramAnonymouszzaqp);
        paramAnonymouszzaqp = paramAnonymouszzaqp.getPath();
        throw new IllegalStateException(String.valueOf(str).length() + 70 + String.valueOf(paramAnonymouszzaqp).length() + "Expected a name but was " + str + " " + " at line " + j + " column " + i + " path " + paramAnonymouszzaqp);
      }
    };
  }
  
  public zzaqp(Reader paramReader)
  {
    int[] arrayOfInt = this.brx;
    int i = this.bry;
    this.bry = (i + 1);
    arrayOfInt[i] = 6;
    this.brz = new String[32];
    this.brA = new int[32];
    if (paramReader == null) {
      throw new NullPointerException("in == null");
    }
    this.in = paramReader;
  }
  
  private int bD()
    throws IOException
  {
    int i = 4;
    int j = this.brx[(this.bry - 1)];
    if (j == 1)
    {
      this.brx[(this.bry - 1)] = 2;
      label31:
      switch (zzdi(true))
      {
      default: 
        this.pos -= 1;
        if (this.bry == 1) {
          bI();
        }
        i = bE();
        if (i == 0) {
          break;
        }
      }
    }
    for (;;)
    {
      return i;
      if (j == 2)
      {
        switch (zzdi(true))
        {
        case 44: 
        default: 
          throw zzuv("Unterminated array");
        case 93: 
          this.brt = 4;
          break;
        case 59: 
          bI();
          break;
        }
      }
      else if ((j == 3) || (j == 5))
      {
        this.brx[(this.bry - 1)] = 4;
        if (j == 5) {
          switch (zzdi(true))
          {
          default: 
            throw zzuv("Unterminated object");
          case 125: 
            this.brt = 2;
            i = 2;
            break;
          case 59: 
            bI();
          }
        } else {
          i = zzdi(true);
        }
      }
      else
      {
        switch (i)
        {
        default: 
          bI();
          this.pos -= 1;
          if (zzc((char)i))
          {
            i = 14;
            this.brt = 14;
          }
          break;
        case 34: 
          i = 13;
          this.brt = 13;
          break;
        case 39: 
          bI();
          i = 12;
          this.brt = 12;
          break;
        case 125: 
          if (j != 5)
          {
            this.brt = 2;
            i = 2;
          }
          else
          {
            throw zzuv("Expected name");
            throw zzuv("Expected name");
            if (j == 4)
            {
              this.brx[(this.bry - 1)] = 5;
              switch (zzdi(true))
              {
              case 58: 
              case 59: 
              case 60: 
              default: 
                throw zzuv("Expected ':'");
              }
              bI();
              if (((this.pos >= this.limit) && (!zzago(1))) || (this.brq[this.pos] != '>')) {
                break label31;
              }
              this.pos += 1;
              break label31;
            }
            if (j == 6)
            {
              if (this.brp) {
                bL();
              }
              this.brx[(this.bry - 1)] = 7;
              break label31;
            }
            if (j == 7)
            {
              if (zzdi(false) == -1)
              {
                i = 17;
                this.brt = 17;
                continue;
              }
              bI();
              this.pos -= 1;
              break label31;
            }
            if (j != 8) {
              break label31;
            }
            throw new IllegalStateException("JsonReader is closed");
            if (j == 1)
            {
              this.brt = 4;
            }
            else if ((j == 1) || (j == 2))
            {
              bI();
              this.pos -= 1;
              this.brt = 7;
              i = 7;
            }
            else
            {
              throw zzuv("Unexpected value");
              bI();
              i = 8;
              this.brt = 8;
              continue;
              if (this.bry == 1) {
                bI();
              }
              i = 9;
              this.brt = 9;
              continue;
              i = 3;
              this.brt = 3;
              continue;
              this.brt = 1;
              i = 1;
              continue;
              j = bF();
              i = j;
              if (j == 0)
              {
                if (!zzc(this.brq[this.pos])) {
                  throw zzuv("Expected value");
                }
                bI();
                i = 10;
                this.brt = 10;
              }
            }
          }
          break;
        }
      }
    }
  }
  
  private int bE()
    throws IOException
  {
    int i = this.brq[this.pos];
    String str2;
    String str1;
    int k;
    int j;
    if ((i == 116) || (i == 84))
    {
      str2 = "true";
      str1 = "TRUE";
      i = 5;
      k = str2.length();
      j = 1;
      label40:
      if (j >= k) {
        break label175;
      }
      if ((this.pos + j < this.limit) || (zzago(j + 1))) {
        break label129;
      }
      i = 0;
    }
    for (;;)
    {
      return i;
      if ((i == 102) || (i == 70))
      {
        str2 = "false";
        str1 = "FALSE";
        i = 6;
        break;
      }
      if ((i == 110) || (i == 78))
      {
        str2 = "null";
        str1 = "NULL";
        i = 7;
        break;
      }
      i = 0;
      continue;
      label129:
      int m = this.brq[(this.pos + j)];
      if ((m != str2.charAt(j)) && (m != str1.charAt(j)))
      {
        i = 0;
      }
      else
      {
        j++;
        break label40;
        label175:
        if (((this.pos + k < this.limit) || (zzago(k + 1))) && (zzc(this.brq[(this.pos + k)])))
        {
          i = 0;
        }
        else
        {
          this.pos += k;
          this.brt = i;
        }
      }
    }
  }
  
  private int bF()
    throws IOException
  {
    char[] arrayOfChar = this.brq;
    int i2 = this.pos;
    int i3 = this.limit;
    long l1 = 0L;
    int i = 0;
    int j = 1;
    int k = 0;
    int m = 0;
    int i1 = i3;
    int n = i2;
    if (i2 + m == i3) {
      if (m == arrayOfChar.length) {
        i = 0;
      }
    }
    label59:
    label99:
    char c;
    for (;;)
    {
      return i;
      if (!zzago(m + 1)) {}
      do
      {
        if ((k != 2) || (j == 0) || ((l1 == Long.MIN_VALUE) && (i == 0))) {
          break label538;
        }
        if (i == 0) {
          break label530;
        }
        this.bru = l1;
        this.pos += m;
        i = 15;
        this.brt = 15;
        break;
        n = this.pos;
        i1 = this.limit;
        c = arrayOfChar[(n + m)];
        switch (c)
        {
        default: 
          if ((c >= '0') && (c <= '9')) {
            break label366;
          }
        }
      } while (!zzc(c));
      i = 0;
    }
    if (k == 0)
    {
      i = 1;
      k = 1;
    }
    for (;;)
    {
      int i4 = m + 1;
      m = k;
      i3 = i1;
      i2 = n;
      k = i;
      i = m;
      m = i4;
      break;
      if (k == 5)
      {
        i2 = 6;
        k = i;
        i = i2;
      }
      else
      {
        i = 0;
        break label59;
        if (k == 5)
        {
          i2 = 6;
          k = i;
          i = i2;
        }
        else
        {
          i = 0;
          break label59;
          if ((k == 2) || (k == 4))
          {
            i2 = 5;
            k = i;
            i = i2;
          }
          else
          {
            i = 0;
            break label59;
            if (k == 2)
            {
              i2 = 3;
              k = i;
              i = i2;
            }
            else
            {
              i = 0;
              break label59;
              label366:
              if ((k == 1) || (k == 0))
              {
                l1 = -(c - '0');
                i2 = 2;
                k = i;
                i = i2;
              }
              else
              {
                if (k == 2)
                {
                  if (l1 == 0L)
                  {
                    i = 0;
                    break label59;
                  }
                  long l2 = 10L * l1 - (c - '0');
                  if ((l1 > -922337203685477580L) || ((l1 == -922337203685477580L) && (l2 < l1))) {}
                  for (i3 = 1;; i3 = 0)
                  {
                    i2 = i;
                    l1 = l2;
                    j = i3 & j;
                    i = k;
                    k = i2;
                    break;
                  }
                }
                if (k == 3)
                {
                  i2 = 4;
                  k = i;
                  i = i2;
                }
                else
                {
                  if ((k == 5) || (k == 6))
                  {
                    i2 = 7;
                    k = i;
                    i = i2;
                    continue;
                    label530:
                    l1 = -l1;
                    break label99;
                    label538:
                    if ((k == 2) || (k == 4) || (k == 7))
                    {
                      this.brv = m;
                      i = 16;
                      this.brt = 16;
                      break label59;
                    }
                    i = 0;
                    break label59;
                  }
                  i2 = i;
                  i = k;
                  k = i2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private String bG()
    throws IOException
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      Object localObject2;
      int j;
      if (this.pos + i < this.limit)
      {
        localObject2 = localObject1;
        j = i;
        switch (this.brq[(this.pos + i)])
        {
        default: 
          i++;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          bI();
          j = i;
          localObject2 = localObject1;
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
        case ',': 
        case ':': 
        case '[': 
        case ']': 
        case '{': 
        case '}': 
          label187:
          if (localObject2 != null) {}
          break;
        }
      }
      else
      {
        for (localObject1 = new String(this.brq, this.pos, j);; localObject1 = ((StringBuilder)localObject2).toString())
        {
          this.pos = (j + this.pos);
          return (String)localObject1;
          if (i < this.brq.length)
          {
            localObject2 = localObject1;
            j = i;
            if (!zzago(i + 1)) {
              break label187;
            }
            break;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder();
          }
          ((StringBuilder)localObject2).append(this.brq, this.pos, i);
          this.pos = (i + this.pos);
          if (zzago(1)) {
            break label326;
          }
          j = 0;
          break label187;
          ((StringBuilder)localObject2).append(this.brq, this.pos, j);
        }
        label326:
        i = 0;
        localObject1 = localObject2;
      }
    }
  }
  
  private void bH()
    throws IOException
  {
    int i = 0;
    while (this.pos + i < this.limit) {
      switch (this.brq[(this.pos + i)])
      {
      default: 
        i++;
        break;
      case '#': 
      case '/': 
      case ';': 
      case '=': 
      case '\\': 
        bI();
      case '\t': 
      case '\n': 
      case '\f': 
      case '\r': 
      case ' ': 
      case ',': 
      case ':': 
      case '[': 
      case ']': 
      case '{': 
      case '}': 
        this.pos = (i + this.pos);
      }
    }
    for (;;)
    {
      return;
      this.pos = (i + this.pos);
      if (zzago(1)) {
        break;
      }
    }
  }
  
  private void bI()
    throws IOException
  {
    if (!this.brp) {
      throw zzuv("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
  }
  
  private void bJ()
    throws IOException
  {
    int i;
    if ((this.pos < this.limit) || (zzago(1)))
    {
      char[] arrayOfChar = this.brq;
      i = this.pos;
      this.pos = (i + 1);
      i = arrayOfChar[i];
      if (i != 10) {
        break label65;
      }
      this.brr += 1;
      this.brs = this.pos;
    }
    for (;;)
    {
      return;
      label65:
      if (i != 13) {
        break;
      }
    }
  }
  
  private char bK()
    throws IOException
  {
    if ((this.pos == this.limit) && (!zzago(1))) {
      throw zzuv("Unterminated escape sequence");
    }
    Object localObject = this.brq;
    int i = this.pos;
    this.pos = (i + 1);
    char c = localObject[i];
    switch (c)
    {
    }
    for (;;)
    {
      return c;
      if ((this.pos + 4 > this.limit) && (!zzago(4))) {
        throw zzuv("Unterminated escape sequence");
      }
      int j = this.pos;
      c = '\000';
      i = j;
      if (i < j + 4)
      {
        int m = this.brq[i];
        int k = (char)(c << '\004');
        if ((m >= 48) && (m <= 57)) {
          c = (char)(k + (m - 48));
        }
        for (;;)
        {
          i++;
          break;
          if ((m >= 97) && (m <= 102))
          {
            c = (char)(k + (m - 97 + 10));
          }
          else
          {
            if ((m < 65) || (m > 70)) {
              break label266;
            }
            c = (char)(k + (m - 65 + 10));
          }
        }
        label266:
        localObject = String.valueOf(new String(this.brq, this.pos, 4));
        if (((String)localObject).length() != 0) {}
        for (localObject = "\\u".concat((String)localObject);; localObject = new String("\\u")) {
          throw new NumberFormatException((String)localObject);
        }
      }
      this.pos += 4;
      continue;
      c = '\t';
      continue;
      c = '\b';
      continue;
      c = '\n';
      continue;
      c = '\r';
      continue;
      c = '\f';
      continue;
      this.brr += 1;
      this.brs = this.pos;
    }
  }
  
  private void bL()
    throws IOException
  {
    zzdi(true);
    this.pos -= 1;
    if ((this.pos + bro.length > this.limit) && (!zzago(bro.length))) {}
    for (;;)
    {
      return;
      for (int i = 0;; i++)
      {
        if (i >= bro.length) {
          break label79;
        }
        if (this.brq[(this.pos + i)] != bro[i]) {
          break;
        }
      }
      label79:
      this.pos += bro.length;
    }
  }
  
  private int getColumnNumber()
  {
    return this.pos - this.brs + 1;
  }
  
  private int getLineNumber()
  {
    return this.brr + 1;
  }
  
  private void zzagn(int paramInt)
  {
    if (this.bry == this.brx.length)
    {
      int[] arrayOfInt2 = new int[this.bry * 2];
      arrayOfInt1 = new int[this.bry * 2];
      String[] arrayOfString = new String[this.bry * 2];
      System.arraycopy(this.brx, 0, arrayOfInt2, 0, this.bry);
      System.arraycopy(this.brA, 0, arrayOfInt1, 0, this.bry);
      System.arraycopy(this.brz, 0, arrayOfString, 0, this.bry);
      this.brx = arrayOfInt2;
      this.brA = arrayOfInt1;
      this.brz = arrayOfString;
    }
    int[] arrayOfInt1 = this.brx;
    int i = this.bry;
    this.bry = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
  
  private boolean zzago(int paramInt)
    throws IOException
  {
    boolean bool2 = false;
    char[] arrayOfChar = this.brq;
    this.brs -= this.pos;
    if (this.limit != this.pos)
    {
      this.limit -= this.pos;
      System.arraycopy(arrayOfChar, this.pos, arrayOfChar, 0, this.limit);
    }
    for (;;)
    {
      this.pos = 0;
      int i;
      do
      {
        i = this.in.read(arrayOfChar, this.limit, arrayOfChar.length - this.limit);
        bool1 = bool2;
        if (i == -1) {
          break;
        }
        this.limit = (i + this.limit);
        i = paramInt;
        if (this.brr == 0)
        {
          i = paramInt;
          if (this.brs == 0)
          {
            i = paramInt;
            if (this.limit > 0)
            {
              i = paramInt;
              if (arrayOfChar[0] == 65279)
              {
                this.pos += 1;
                this.brs += 1;
                i = paramInt + 1;
              }
            }
          }
        }
        paramInt = i;
      } while (this.limit < i);
      boolean bool1 = true;
      return bool1;
      this.limit = 0;
    }
  }
  
  private boolean zzc(char paramChar)
    throws IOException
  {
    switch (paramChar)
    {
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      bI();
    }
  }
  
  private String zzd(char paramChar)
    throws IOException
  {
    char[] arrayOfChar = this.brq;
    StringBuilder localStringBuilder = new StringBuilder();
    do
    {
      int m = this.pos;
      int j = this.limit;
      int i = m;
      if (i < j)
      {
        int i1 = i + 1;
        char c = arrayOfChar[i];
        if (c == paramChar)
        {
          this.pos = i1;
          localStringBuilder.append(arrayOfChar, m, i1 - m - 1);
          return localStringBuilder.toString();
        }
        int n;
        int k;
        if (c == '\\')
        {
          this.pos = i1;
          localStringBuilder.append(arrayOfChar, m, i1 - m - 1);
          localStringBuilder.append(bK());
          n = this.pos;
          k = this.limit;
          i = n;
        }
        for (;;)
        {
          m = n;
          j = k;
          break;
          n = m;
          k = j;
          i = i1;
          if (c == '\n')
          {
            this.brr += 1;
            this.brs = i1;
            n = m;
            k = j;
            i = i1;
          }
        }
      }
      localStringBuilder.append(arrayOfChar, m, i - m);
      this.pos = i;
    } while (zzago(1));
    throw zzuv("Unterminated string");
  }
  
  private int zzdi(boolean paramBoolean)
    throws IOException
  {
    Object localObject = this.brq;
    int i = this.pos;
    int j = this.limit;
    for (;;)
    {
      int k = j;
      int m = i;
      if (i == j)
      {
        this.pos = i;
        if (!zzago(1))
        {
          if (paramBoolean)
          {
            localObject = String.valueOf("End of input at line ");
            i = getLineNumber();
            j = getColumnNumber();
            throw new EOFException(String.valueOf(localObject).length() + 30 + (String)localObject + i + " column " + j);
          }
        }
        else
        {
          m = this.pos;
          k = this.limit;
        }
      }
      else
      {
        i = m + 1;
        j = localObject[m];
        if (j == 10)
        {
          this.brr += 1;
          this.brs = i;
          j = k;
          continue;
        }
        if ((j == 32) || (j == 13)) {
          break label394;
        }
        if (j == 9)
        {
          j = k;
          continue;
        }
        if (j == 47)
        {
          this.pos = i;
          if (i == k)
          {
            this.pos -= 1;
            boolean bool = zzago(2);
            this.pos += 1;
            if (!bool) {
              i = j;
            }
          }
        }
      }
      for (;;)
      {
        return i;
        bI();
        switch (localObject[this.pos])
        {
        default: 
          i = j;
          break;
        case '*': 
          this.pos += 1;
          if (!zzuu("*/")) {
            throw zzuv("Unterminated comment");
          }
          i = this.pos + 2;
          j = this.limit;
          break;
        case '/': 
          this.pos += 1;
          bJ();
          i = this.pos;
          j = this.limit;
          break;
          if (j == 35)
          {
            this.pos = i;
            bI();
            bJ();
            i = this.pos;
            j = this.limit;
            break;
          }
          this.pos = i;
          i = j;
          continue;
          i = -1;
        }
      }
      label394:
      j = k;
    }
  }
  
  private void zze(char paramChar)
    throws IOException
  {
    char[] arrayOfChar = this.brq;
    do
    {
      int i = this.pos;
      int j = this.limit;
      if (i < j)
      {
        int m = i + 1;
        char c = arrayOfChar[i];
        if (c == paramChar)
        {
          this.pos = m;
          return;
        }
        int k;
        if (c == '\\')
        {
          this.pos = m;
          bK();
          i = this.pos;
          k = this.limit;
        }
        for (;;)
        {
          j = k;
          break;
          k = j;
          i = m;
          if (c == '\n')
          {
            this.brr += 1;
            this.brs = m;
            k = j;
            i = m;
          }
        }
      }
      this.pos = i;
    } while (zzago(1));
    throw zzuv("Unterminated string");
  }
  
  private boolean zzuu(String paramString)
    throws IOException
  {
    boolean bool2 = false;
    for (;;)
    {
      if (this.pos + paramString.length() > this.limit)
      {
        bool1 = bool2;
        if (!zzago(paramString.length())) {
          return bool1;
        }
      }
      if (this.brq[this.pos] != '\n') {
        break;
      }
      this.brr += 1;
      this.brs = (this.pos + 1);
      this.pos += 1;
    }
    for (int i = 0;; i++)
    {
      if (i >= paramString.length()) {
        break label115;
      }
      if (this.brq[(this.pos + i)] != paramString.charAt(i)) {
        break;
      }
    }
    label115:
    boolean bool1 = true;
    return bool1;
  }
  
  private IOException zzuv(String paramString)
    throws IOException
  {
    int j = getLineNumber();
    int i = getColumnNumber();
    String str = getPath();
    throw new zzaqs(String.valueOf(paramString).length() + 45 + String.valueOf(str).length() + paramString + " at line " + j + " column " + i + " path " + str);
  }
  
  public void beginArray()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    if (i == 3)
    {
      zzagn(1);
      this.brA[(this.bry - 1)] = 0;
      this.brt = 0;
      return;
    }
    String str2 = String.valueOf(bq());
    j = getLineNumber();
    i = getColumnNumber();
    String str1 = getPath();
    throw new IllegalStateException(String.valueOf(str2).length() + 74 + String.valueOf(str1).length() + "Expected BEGIN_ARRAY but was " + str2 + " at line " + j + " column " + i + " path " + str1);
  }
  
  public void beginObject()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    if (i == 1)
    {
      zzagn(3);
      this.brt = 0;
      return;
    }
    String str1 = String.valueOf(bq());
    j = getLineNumber();
    i = getColumnNumber();
    String str2 = getPath();
    throw new IllegalStateException(String.valueOf(str1).length() + 75 + String.valueOf(str2).length() + "Expected BEGIN_OBJECT but was " + str1 + " at line " + j + " column " + i + " path " + str2);
  }
  
  public zzaqq bq()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    zzaqq localzzaqq;
    switch (i)
    {
    default: 
      throw new AssertionError();
    case 1: 
      localzzaqq = zzaqq.brD;
    }
    for (;;)
    {
      return localzzaqq;
      localzzaqq = zzaqq.brE;
      continue;
      localzzaqq = zzaqq.brB;
      continue;
      localzzaqq = zzaqq.brC;
      continue;
      localzzaqq = zzaqq.brF;
      continue;
      localzzaqq = zzaqq.brI;
      continue;
      localzzaqq = zzaqq.brJ;
      continue;
      localzzaqq = zzaqq.brG;
      continue;
      localzzaqq = zzaqq.brH;
      continue;
      localzzaqq = zzaqq.brK;
    }
  }
  
  public void close()
    throws IOException
  {
    this.brt = 0;
    this.brx[0] = 8;
    this.bry = 1;
    this.in.close();
  }
  
  public void endArray()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    if (i == 4)
    {
      this.bry -= 1;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      this.brt = 0;
      return;
    }
    String str = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    Object localObject = getPath();
    throw new IllegalStateException(String.valueOf(str).length() + 72 + String.valueOf(localObject).length() + "Expected END_ARRAY but was " + str + " at line " + i + " column " + j + " path " + (String)localObject);
  }
  
  public void endObject()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    if (i == 2)
    {
      this.bry -= 1;
      this.brz[this.bry] = null;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      this.brt = 0;
      return;
    }
    Object localObject = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    String str = getPath();
    throw new IllegalStateException(String.valueOf(localObject).length() + 73 + String.valueOf(str).length() + "Expected END_OBJECT but was " + (String)localObject + " at line " + i + " column " + j + " path " + str);
  }
  
  public String getPath()
  {
    StringBuilder localStringBuilder = new StringBuilder().append('$');
    int i = 0;
    int j = this.bry;
    if (i < j)
    {
      switch (this.brx[i])
      {
      }
      for (;;)
      {
        i++;
        break;
        localStringBuilder.append('[').append(this.brA[i]).append(']');
        continue;
        localStringBuilder.append('.');
        if (this.brz[i] != null) {
          localStringBuilder.append(this.brz[i]);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean hasNext()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    if ((i != 2) && (i != 4)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean isLenient()
  {
    return this.brp;
  }
  
  public boolean nextBoolean()
    throws IOException
  {
    boolean bool = false;
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    if (i == 5)
    {
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (i != 6) {
        break;
      }
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
    }
    String str = String.valueOf(bq());
    j = getLineNumber();
    i = getColumnNumber();
    Object localObject = getPath();
    throw new IllegalStateException(String.valueOf(str).length() + 72 + String.valueOf(localObject).length() + "Expected a boolean but was " + str + " at line " + j + " column " + i + " path " + (String)localObject);
  }
  
  public double nextDouble()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    Object localObject;
    double d;
    if (i == 15)
    {
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      d = this.bru;
    }
    for (;;)
    {
      return d;
      if (i == 16)
      {
        this.brw = new String(this.brq, this.pos, this.brv);
        this.pos += this.brv;
      }
      do
      {
        for (;;)
        {
          this.brt = 11;
          d = Double.parseDouble(this.brw);
          if ((this.brp) || ((!Double.isNaN(d)) && (!Double.isInfinite(d)))) {
            break label411;
          }
          i = getLineNumber();
          j = getColumnNumber();
          localObject = getPath();
          throw new zzaqs(String.valueOf(localObject).length() + 102 + "JSON forbids NaN and infinities: " + d + " at line " + i + " column " + j + " path " + (String)localObject);
          if ((i == 8) || (i == 9))
          {
            if (i == 8) {}
            for (char c = '\'';; c = '"')
            {
              this.brw = zzd(c);
              break;
            }
          }
          if (i != 10) {
            break;
          }
          this.brw = bG();
        }
      } while (i == 11);
      String str = String.valueOf(bq());
      i = getLineNumber();
      j = getColumnNumber();
      localObject = getPath();
      throw new IllegalStateException(String.valueOf(str).length() + 71 + String.valueOf(localObject).length() + "Expected a double but was " + str + " at line " + i + " column " + j + " path " + (String)localObject);
      label411:
      this.brw = null;
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
    }
  }
  
  public int nextInt()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    Object localObject1;
    if (i == 15)
    {
      i = (int)this.bru;
      if (this.bru != i)
      {
        long l = this.bru;
        i = getLineNumber();
        j = getColumnNumber();
        localObject1 = getPath();
        throw new NumberFormatException(String.valueOf(localObject1).length() + 89 + "Expected an int but was " + l + " at line " + i + " column " + j + " path " + (String)localObject1);
      }
      this.brt = 0;
      localObject1 = this.brA;
      j = this.bry - 1;
      localObject1[j] += 1;
    }
    for (;;)
    {
      return i;
      label220:
      String str;
      if (i == 16)
      {
        this.brw = new String(this.brq, this.pos, this.brv);
        this.pos += this.brv;
        this.brt = 11;
        double d = Double.parseDouble(this.brw);
        i = (int)d;
        if (i != d)
        {
          localObject1 = this.brw;
          i = getLineNumber();
          j = getColumnNumber();
          str = getPath();
          throw new NumberFormatException(String.valueOf(localObject1).length() + 69 + String.valueOf(str).length() + "Expected an int but was " + (String)localObject1 + " at line " + i + " column " + j + " path " + str);
        }
      }
      else
      {
        if ((i == 8) || (i == 9))
        {
          if (i == 8) {}
          for (char c = '\'';; c = '"')
          {
            this.brw = zzd(c);
            try
            {
              i = Integer.parseInt(this.brw);
              this.brt = 0;
              localObject1 = this.brA;
              j = this.bry - 1;
              localObject1[j] += 1;
            }
            catch (NumberFormatException localNumberFormatException) {}
            break label220;
          }
        }
        localObject2 = String.valueOf(bq());
        i = getLineNumber();
        j = getColumnNumber();
        str = getPath();
        throw new IllegalStateException(String.valueOf(localObject2).length() + 69 + String.valueOf(str).length() + "Expected an int but was " + (String)localObject2 + " at line " + i + " column " + j + " path " + str);
      }
      this.brw = null;
      this.brt = 0;
      Object localObject2 = this.brA;
      j = this.bry - 1;
      localObject2[j] += 1;
    }
  }
  
  public long nextLong()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    Object localObject1;
    long l;
    if (i == 15)
    {
      this.brt = 0;
      localObject1 = this.brA;
      i = this.bry - 1;
      localObject1[i] += 1;
      l = this.bru;
    }
    for (;;)
    {
      return l;
      label111:
      String str;
      if (i == 16)
      {
        this.brw = new String(this.brq, this.pos, this.brv);
        this.pos += this.brv;
        this.brt = 11;
        double d = Double.parseDouble(this.brw);
        l = d;
        if (l != d)
        {
          str = this.brw;
          i = getLineNumber();
          j = getColumnNumber();
          localObject1 = getPath();
          throw new NumberFormatException(String.valueOf(str).length() + 69 + String.valueOf(localObject1).length() + "Expected a long but was " + str + " at line " + i + " column " + j + " path " + (String)localObject1);
        }
      }
      else
      {
        if ((i == 8) || (i == 9))
        {
          if (i == 8) {}
          for (char c = '\'';; c = '"')
          {
            this.brw = zzd(c);
            try
            {
              l = Long.parseLong(this.brw);
              this.brt = 0;
              localObject1 = this.brA;
              i = this.bry - 1;
              localObject1[i] += 1;
            }
            catch (NumberFormatException localNumberFormatException) {}
            break label111;
          }
        }
        str = String.valueOf(bq());
        i = getLineNumber();
        j = getColumnNumber();
        localObject2 = getPath();
        throw new IllegalStateException(String.valueOf(str).length() + 69 + String.valueOf(localObject2).length() + "Expected a long but was " + str + " at line " + i + " column " + j + " path " + (String)localObject2);
      }
      this.brw = null;
      this.brt = 0;
      Object localObject2 = this.brA;
      i = this.bry - 1;
      localObject2[i] += 1;
    }
  }
  
  public String nextName()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    if (i == 14) {
      str1 = bG();
    }
    for (;;)
    {
      this.brt = 0;
      this.brz[(this.bry - 1)] = str1;
      return str1;
      if (i == 12)
      {
        str1 = zzd('\'');
      }
      else
      {
        if (i != 13) {
          break;
        }
        str1 = zzd('"');
      }
    }
    String str2 = String.valueOf(bq());
    j = getLineNumber();
    i = getColumnNumber();
    String str1 = getPath();
    throw new IllegalStateException(String.valueOf(str2).length() + 69 + String.valueOf(str1).length() + "Expected a name but was " + str2 + " at line " + j + " column " + i + " path " + str1);
  }
  
  public void nextNull()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    if (i == 7)
    {
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      return;
    }
    String str = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    Object localObject = getPath();
    throw new IllegalStateException(String.valueOf(str).length() + 67 + String.valueOf(localObject).length() + "Expected null but was " + str + " at line " + i + " column " + j + " path " + (String)localObject);
  }
  
  public String nextString()
    throws IOException
  {
    int j = this.brt;
    int i = j;
    if (j == 0) {
      i = bD();
    }
    if (i == 10) {
      str = bG();
    }
    for (;;)
    {
      this.brt = 0;
      localObject = this.brA;
      i = this.bry - 1;
      localObject[i] += 1;
      return str;
      if (i == 8)
      {
        str = zzd('\'');
      }
      else if (i == 9)
      {
        str = zzd('"');
      }
      else if (i == 11)
      {
        str = this.brw;
        this.brw = null;
      }
      else if (i == 15)
      {
        str = Long.toString(this.bru);
      }
      else
      {
        if (i != 16) {
          break;
        }
        str = new String(this.brq, this.pos, this.brv);
        this.pos += this.brv;
      }
    }
    String str = String.valueOf(bq());
    i = getLineNumber();
    j = getColumnNumber();
    Object localObject = getPath();
    throw new IllegalStateException(String.valueOf(str).length() + 71 + String.valueOf(localObject).length() + "Expected a string but was " + str + " at line " + i + " column " + j + " path " + (String)localObject);
  }
  
  public final void setLenient(boolean paramBoolean)
  {
    this.brp = paramBoolean;
  }
  
  public void skipValue()
    throws IOException
  {
    int j = 0;
    int i = this.brt;
    int k = i;
    if (i == 0) {
      k = bD();
    }
    if (k == 3)
    {
      zzagn(1);
      i = j + 1;
    }
    for (;;)
    {
      this.brt = 0;
      j = i;
      if (i != 0) {
        break;
      }
      int[] arrayOfInt = this.brA;
      i = this.bry - 1;
      arrayOfInt[i] += 1;
      this.brz[(this.bry - 1)] = "null";
      return;
      if (k == 1)
      {
        zzagn(3);
        i = j + 1;
      }
      else if (k == 4)
      {
        this.bry -= 1;
        i = j - 1;
      }
      else if (k == 2)
      {
        this.bry -= 1;
        i = j - 1;
      }
      else if ((k == 14) || (k == 10))
      {
        bH();
        i = j;
      }
      else if ((k == 8) || (k == 12))
      {
        zze('\'');
        i = j;
      }
      else if ((k == 9) || (k == 13))
      {
        zze('"');
        i = j;
      }
      else
      {
        i = j;
        if (k == 16)
        {
          this.pos += this.brv;
          i = j;
        }
      }
    }
  }
  
  public String toString()
  {
    String str = String.valueOf(getClass().getSimpleName());
    int j = getLineNumber();
    int i = getColumnNumber();
    return String.valueOf(str).length() + 39 + str + " at line " + j + " column " + i;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\com\google\android\gms\internal\zzaqp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */