
package view;

import util.Operators;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import impl.*;

import complex.Complex;


public class View {

    private final ComplexCalculable cable;
    private final List<String> validOperators;

        public View(ComplexCalculable cable ) {
        this.cable= cable;
        this.validOperators = Arrays.stream(Operators.values())
                .map(Operators::operator)
                .collect(Collectors.toList());
    }

    public void run() {
        while (true) {
            prepareComplex();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }
    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }

    public Complex input() {
        System.out.println( "Enter real and imaginary numbers separated by a space: ");
        Scanner in = new Scanner(System.in);
        String text =  in.nextLine();
        String [] array = text.split(" ");
        Complex com = new Complex(0, 0);
        com.real = Double.parseDouble(array[0]);
        com.imaginary = Double.parseDouble(array[1]); 

        return com;
        
    }
    private String getOperator() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the math operation (*, +, /, -) : ");
        String operator = in.nextLine();
        while (true) {
            if (isInvalidOperator(operator)) {
                System.err.println("Entered invalid math operator. " + "Enter the math operation (*, +, /, -) : ");
                operator = in.nextLine();
            } else return operator;
        }
    }

    private boolean isInvalidOperator(String operator) {
        return !validOperators.contains(operator);
    }

    public void prepareComplex() {
    
        Complex complex1 = input();
        String operator = getOperator();   
        Complex complex2 = input();
    
        if (operator.equals("*")) {
            System.out.println(cable.multy(complex1,complex2));
        }

        if (operator.equals("+")) {
           System.out.println(cable.plus(complex1, complex2)); 
        }

        if (operator.equals("/")) {
            System.out.println(cable.division(complex1,complex2)); 
        }

        if (operator.equals("-")) {
           System.out.println(cable.minus(complex1, complex2)); 
        }      
    }
}
