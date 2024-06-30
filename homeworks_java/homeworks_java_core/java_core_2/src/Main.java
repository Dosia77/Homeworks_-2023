import methods.Methods;
public class Main {
    public static void main(String[] args) {

        int [] numbers  = new int[] {1,2,0,0,5,6,7,8,9,10};
        System.out.println("Разница между минимумом и максимумом: " + Methods.range(numbers));
        System.out.println("Количество четных чмсел: " + Methods.countEvens(numbers));
        System.out.println(Methods.twoZeros(numbers));
    }
}