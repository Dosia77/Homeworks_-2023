package steam_API.example;

import java.lang.reflect.Method;

public class AllMethodsClass {

    public static void getAllMethodsClass(String className) throws ClassNotFoundException {

        Class<?> classString = Class.forName(className);

        Method[] methods = classString.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method); // Выводим каждый метод
        }
    }

}
