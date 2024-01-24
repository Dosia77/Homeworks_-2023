package impl;

import complex.Complex;

public class ComplexCalculator implements ComplexCalculable{

@Override
    public Complex plus(Complex x1, Complex x2){

        x1.real = x1.real + x2.real;
        x1.imaginary = x1.imaginary + x2.imaginary;

        return x1;  
    }
@Override
    public  Complex minus(Complex x1, Complex x2){
        x1.real = x1.real - x2.real;
        x1.imaginary = x1.imaginary - x2.imaginary;
        
        return x1;

    }

    @Override
    public Complex multy(Complex x1, Complex x2){

        double tempA = (x1.real*x2.real)-(x2.imaginary*x1.imaginary);
        double tempB = (x1.real*x2.imaginary)+(x1.imaginary*x2.real);

        return new Complex(tempA,tempB);

    }

    @Override
    public Complex division(Complex x1, Complex x2){
        double  tempA1 = x1.real*x2.real; 
        double tempA2 = x1.real*(-x2.imaginary);
        double tempB1 = x1.imaginary*x2.real;
        double tempB2 = x2.imaginary*x1.imaginary;

        double x1Numerator = tempA1 + tempB2; 
        double x2Numerator = tempA2+tempB1;
        double denumerator = (x2.real*x2.real)+(x2.imaginary*x2.imaginary);

        x1.real = x1Numerator/denumerator;  
        x1.imaginary = x2Numerator/denumerator; 

        return x1;
    }

    
    
    
}
