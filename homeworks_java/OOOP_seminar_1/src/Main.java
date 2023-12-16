import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Cat barsik = new Cat("Barsik", LocalDate.of(
                1993, 6, 6),
                new ArrayList<>(), "Chumka", "Boss", 4);
        Eagle eagle = new Eagle("Kesha", LocalDate.of(
                1996, 6, 6),
                new ArrayList<>(), "Chumka", "Boss");
        Gull gull = new Gull("Pipi",LocalDate.of(
                1996, 6, 6), 
                new ArrayList<>(),"wing fracture", "Vasia Pupkin");
        Snake snake = new Snake("Snake", LocalDate.of(2020,1,1),
        new ArrayList<>(), "HZ", "Vasia Pupkin", 1.9);
        
        Fish fish = new Fish("Golden", LocalDate.of(2021,2,3), 
        new ArrayList<>(),"HEZ", "Vasilisa Pupkina", "golden");

        List<Animal> animals = new ArrayList<>();
        animals.add(barsik);
        animals.add(eagle);
        animals.add(gull);
        animals.add(snake);
        animals.add(fish);

        System.out.println("________________________________________");
        barsik.lifeCycle();
        System.out.println("________________________________________");
        eagle.lifeCycle();
        System.out.println("________________________________________");
        gull.lifeCycle();
        System.out.println("________________________________________");
        fish.lifeCycle();
        System.out.println("________________________________________");
        snake.lifeCycle();

    }
}
