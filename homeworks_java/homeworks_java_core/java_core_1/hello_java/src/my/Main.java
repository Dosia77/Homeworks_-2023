package my;

import my.file.Calculator;
import my.file.Decorator;
/**
 * Основной класс приложения. Здесь мы можем описать
 * его основное назначение и способы взаимодействия с ним.
 * */
public class Main {
    /**
     * Точка входа в программу. С неё всегда всё начинается.
     *
     * @param args стандартные аргументы командной строки
     * */

    public static void main(String[] args) {
        int result = Calculator.add(2, 2);
        System.out.println(Decorator.decorate(result));
        result = Calculator.sub(2, 2);
        System.out.println(Decorator.decorate(result));
        result = Calculator.mul(2, 2);
        System.out.println(Decorator.decorate(result));
        result = Calculator.div(2, 2);
        System.out.println(Decorator.decorate(result));
    }
}