package complex;

public class Complex{
    public double real;
    public double imaginary;
  
  public Complex(double real, double imaginary){
      this.real = real;
      this.imaginary = imaginary;
}
  public double getA(){
      return real;
  }
 
public double getB(){
    return imaginary;
}


 public String toString(){
       return "Complex number("+real+", "+imaginary+"i)";
    }

  }