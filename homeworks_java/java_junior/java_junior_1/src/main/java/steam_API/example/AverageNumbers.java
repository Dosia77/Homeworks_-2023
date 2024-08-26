package steam_API.example;
import java.util.List;

public class AverageNumbers {

    public static double AverageNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0) // Фильтрация четных чисел
                .mapToDouble(Integer::doubleValue) // Преобразование в double для среднего значения
                .average()
                .getAsDouble();
    }
}
