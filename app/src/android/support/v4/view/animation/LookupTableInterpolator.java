package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator
  implements Interpolator
{
  private final float mStepSize;
  private final float[] mValues;
  
  public LookupTableInterpolator(float[] paramArrayOfFloat)
  {
    this.mValues = paramArrayOfFloat;
    this.mStepSize = (1.0F / (this.mValues.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f = 1.0F;
    if (paramFloat >= 1.0F) {
      paramFloat = f;
    }
    for (;;)
    {
      return paramFloat;
      if (paramFloat <= 0.0F)
      {
        paramFloat = 0.0F;
      }
      else
      {
        int i = Math.min((int)((this.mValues.length - 1) * paramFloat), this.mValues.length - 2);
        paramFloat = (paramFloat - i * this.mStepSize) / this.mStepSize;
        paramFloat = this.mValues[i] + (this.mValues[(i + 1)] - this.mValues[i]) * paramFloat;
      }
    }
  }
}


/* Location:              C:\ApkExtract\classes-dex2jar.jar!\android\support\v4\view\animation\LookupTableInterpolator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */