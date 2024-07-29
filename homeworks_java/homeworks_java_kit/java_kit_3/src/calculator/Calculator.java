package calculator;

public class Calculator {

    public static <T extends Number> T getT(T t){
        return t;
    }

    public static <T extends Number, V extends Number> double sum(T t, V v){
       return t.doubleValue()+v.doubleValue();
    }
    public static <T extends Number, V extends Number> double multiply(T t, V v){
        return t.doubleValue()*v.doubleValue();
    }

    public static <T extends Number, V extends Number> double divide(T t, V v) {

        if(v.doubleValue() != 0){
            return t.doubleValue() / v.doubleValue();
        } else {
            System.out.println("Ошибка! Нельзя делить на ноль!");
            return 0;
        }

    }
    public static <T extends Number, V extends Number> double subtract(T t, V v){
        return t.doubleValue()-v.doubleValue();
    }

}    
        

