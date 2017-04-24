package android.support.v4.util;

public final class CircularArray<E>
{
  private int mCapacityBitmask;
  private E[] mElements;
  private int mHead;
  private int mTail;
  
  public CircularArray()
  {
    this(8);
  }
  
  public CircularArray(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("capacity must be >= 1");
    }
    if (paramInt > 1073741824) {
      throw new IllegalArgumentException("capacity must be <= 2^30");
    }
    if (Integer.bitCount(paramInt) != 1) {
      paramInt = Integer.highestOneBit(paramInt - 1) << 1;
    }
    for (;;)
    {
      this.mCapacityBitmask = (paramInt - 1);
      this.mElements = ((Object[])new Object[paramInt]);
      return;
    }
  }
  
  private void doubleCapacity()
  {
    int j = this.mElements.length;
    int i = j - this.mHead;
    int k = j << 1;
    if (k < 0) {
      throw new RuntimeException("Max array capacity exceeded");
    }
    Object[] arrayOfObject = new Object[k];
    System.arraycopy(this.mElements, this.mHead, arrayOfObject, 0, i);
    System.arraycopy(this.mElements, 0, arrayOfObject, i, this.mHead);
    this.mElements = ((Object[])arrayOfObject);
    this.mHead = 0;
    this.mTail = j;
    this.mCapacityBitmask = (k - 1);
  }
  
  public void addFirst(E paramE)
  {
    this.mHead = (this.mHead - 1 & this.mCapacityBitmask);
    this.mElements[this.mHead] = paramE;
    if (this.mHead == this.mTail) {
      doubleCapacity();
    }
  }
  
  public void addLast(E paramE)
  {
    this.mElements[this.mTail] = paramE;
    this.mTail = (this.mTail + 1 & this.mCapacityBitmask);
    if (this.mTail == this.mHead) {
      doubleCapacity();
    }
  }
  
  public void clear()
  {
    removeFromStart(size());
  }
  
  public E get(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= size())) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return (E)this.mElements[(this.mHead + paramInt & this.mCapacityBitmask)];
  }
  
  public E getFirst()
  {
    if (this.mHead == this.mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return (E)this.mElements[this.mHead];
  }
  
  public E getLast()
  {
    if (this.mHead == this.mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return (E)this.mElements[(this.mTail - 1 & this.mCapacityBitmask)];
  }
  
  public boolean isEmpty()
  {
    if (this.mHead == this.mTail) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public E popFirst()
  {
    if (this.mHead == this.mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    Object localObject = this.mElements[this.mHead];
    this.mElements[this.mHead] = null;
    this.mHead = (this.mHead + 1 & this.mCapacityBitmask);
    return (E)localObject;
  }
  
  public E popLast()
  {
    if (this.mHead == this.mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    int i = this.mTail - 1 & this.mCapacityBitmask;
    Object localObject = this.mElements[i];
    this.mElements[i] = null;
    this.mTail = i;
    return (E)localObject;
  }
  
  public void removeFromEnd(int paramInt)
  {
    if (paramInt <= 0) {}
    for (;;)
    {
      return;
      if (paramInt > size()) {
        throw new ArrayIndexOutOfBoundsException();
      }
      int i = 0;
      if (paramInt < this.mTail) {
        i = this.mTail - paramInt;
      }
      for (int j = i; j < this.mTail; j++) {
        this.mElements[j] = null;
      }
      i = this.mTail - i;
      paramInt -= i;
      this.mTail -= i;
      if (paramInt > 0)
      {
        this.mTail = this.mElements.length;
        i = this.mTail - paramInt;
        for (paramInt = i; paramInt < this.mTail; paramInt++) {
          this.mElements[paramInt] = null;
        }
        this.mTail = i;
      }
    }
  }
  
  public void removeFromStart(int paramInt)
  {
    if (paramInt <= 0) {}
    for (;;)
    {
      return;
      if (paramInt > size()) {
        throw new ArrayIndexOutOfBoundsException();
      }
      int j = this.mElements.length;
      int i = j;
      if (paramInt < j - this.mHead) {
        i = this.mHead + paramInt;
      }
      for (j = this.mHead; j < i; j++) {
        this.mElements[j] = null;
      }
      j = i - this.mHead;
      i = paramInt - j;
      this.mHead = (this.mHead + j & this.mCapacityBitmask);
      if (i > 0)
      {
        for (paramInt = 0; paramInt < i; paramInt++) {
          this.mElements[paramInt] = null;
        }
        this.mHead = i;
      }
    }
  }
  
  public int size()
  {
    return this.mTail - this.mHead & this.mCapacityBitmask;
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\util\CircularArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */