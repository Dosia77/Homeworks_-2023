package impl;
import java.io.*;
import complex.Complex;

public class ComplexLogable implements ComplexCalculable{

    private final ComplexCalculable calculable;

    public ComplexLogable(ComplexCalculable calculable) {
        this.calculable = calculable;
    }

    @Override
    public Complex plus(Complex x1, Complex x2) {
        try(FileWriter writer = new FileWriter("log.0.0.txt", true)) { 
            String text = "Addtion of nambers completed\n"; 
            writer.write(text);       
            writer.flush(); 
        } catch(IOException ex){ System.out.println(ex.getMessage()); 

        } 

       System.out.println(String.format("I summarize %s and %s", x1, x2));

        return calculable.plus(x1,x2);
    }

    @Override
    public Complex multy(Complex x1, Complex x2) {
        try(FileWriter writer = new FileWriter("log.0.0.txt", true)) { 
            String text = "Multiplication of nambers completed\n"; 
            writer.write(text);       
            writer.flush(); 
        } catch(IOException ex){ 
            System.out.println(ex.getMessage()); 
        } 
        System.out.println(String.format("I multiply numbers %s and %s", x1, x2));
        
        return calculable.multy(x1, x2);
    }

    @Override
    public Complex division(Complex x1, Complex x2) {
        try(FileWriter writer = new FileWriter("log.0.0.txt", true)) { 
            String text = "Division of nambers completed\n"; 
            writer.write(text);       
            writer.flush(); 
        } catch(IOException ex){ 
            System.out.println(ex.getMessage()); 
        } 
        System.out.println(String.format("I subtract numbers %s and %s", x1, x2));

        return calculable.division(x1, x2);
    }

    @Override
    public Complex minus(Complex x1, Complex x2) {
        try(FileWriter writer = new FileWriter("log.0.0.txt", true)) { 
            String text = "Subtraction of nambers completed\n"; 
            writer.write(text);       
            writer.flush(); 
        } catch(IOException ex){ 
            System.out.println(ex.getMessage()); 
        } 
        System.out.println(String.format("I divide the numbers %s and %s", x1, x2));

        return  calculable.minus(x1,x2);
    }


    
}
