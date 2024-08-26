package steam_API.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        System.out.println("Среднее значение всех четных чисел в списке: "+ AverageNumbers.AverageNumbers(numbers));

    }
}