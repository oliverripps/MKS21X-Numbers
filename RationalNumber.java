public class RationalNumber extends RealNumber
{
  private int numerator, denominator;


  public RationalNumber(int numerator, int denominator){
  		super(0);

  		if(denominator == 0){
  			this.numerator = 0;
  			this.denominator = 1;
  		}else{
  			this.numerator = numerator;
  			this.denominator = denominator;


  			reduce();
  		}
  	}

  public double getValue(){
    return (1.0 * numerator) / denominator;
  }

  public int getNumerator(){
    return numerator;
  }
  public int getDenominator(){
    return denominator;
  }
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator,numerator);
  }

  public boolean equals(RationalNumber other){
    return ((this.getNumerator() == other.getNumerator()) && (this.getDenominator() == other.getDenominator()));
  }

  public String toString(){
    if (numerator == 0) {
      return "0";
    }
    if (denominator == 1){
      return "" + numerator;
    }
    return numerator + "/" + denominator;
  }

  private static int gcd(int a, int b){
    if ((a < 0) || (b < 0)) {
      a = Math.abs(a);
      b = Math.abs(b);
    }
    while (b != 0) {
    int temp = b;
    b = a % b;
    a = temp;
  }
  return a;
}

  private void reduce(){
    int gcd = gcd(numerator, denominator);

    numerator /= gcd;
    denominator /= gcd;
}
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(this.getNumerator() * other.getNumerator(),this.getDenominator() * other.getDenominator());
  }

  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }

  public RationalNumber add(RationalNumber other){
  int crossThis = numerator * other.denominator;
  int crossOther = other.numerator * denominator;

  return new RationalNumber(crossThis + crossOther, other.denominator * denominator);
}

public RationalNumber subtract(RationalNumber other){
  return add(new RationalNumber(other.numerator * -1, other.denominator));
}
}
