public class RealNumber{
  private double value;

  public RealNumber(double v){
    value = v;
  }
  public double add(RealNumber other){
    double n = this.getValue() + other.getValue();
    return n;
  }
  public double multiply(RealNumber other){
    double n = this.getValue() * other.getValue();
    return n;
  }
  public double divide(RealNumber other){
    double n = this.getValue() / other.getValue();
    return n;
  }
  public double subtract(RealNumber other){
    double n = this.getValue() - other.getValue();
    return n;
  }
  public double getValue(){
    return value;
  }
  public String toString(){
    return ""+value;
  }
}
