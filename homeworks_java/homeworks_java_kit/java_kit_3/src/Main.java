import calculator.Calculator;
import pair.Pair;
import compareArr.CompareArr;

public class Main {
    public static void main(String[] args) {

        long t = 1;
        int v = 1111;
        double d = 1.1;
        byte b = 10;
        int i = 0;

        System.out.println(Calculator.subtract(v,t));
        System.out.println(Calculator.multiply(b,d));
        System.out.println(Calculator.sum(v,t));
        System.out.println(Calculator.divide(b,i));
        System.out.println(Calculator.divide(b,v));
        System.out.println("----------------------");

        Object [] arr = {"asd", 11, 1.2, true};
        Object [] arr2 = {"world", 10, 1.2, false};
        Object [] arr3 = {"world", 10, 1.2, false, "hello"};

        System.out.println(CompareArr.compareArrays(arr,arr2));
        System.out.println(CompareArr.compareArrays(arr,arr3));
        System.out.println("-----------------------");

        Pair<String, Integer> strInt = new Pair<>("world", 1);
        Pair<Boolean, String> boolStr = new Pair<>(true, "hello");

        System.out.println(strInt);
        System.out.println(boolStr);
        System.out.println(boolStr.getSecond());
        System.out.println(strInt.getFirst());
    }

}