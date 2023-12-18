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

        barsik.swim();
        barsik.flay();
        eagle.swim();
        eagle.toGo();
        fish.toGo();
        snake.toGo();
        snake.swim();
        fish.flay();

    }
}
// Мне по прежнему кажется, что писать и переопределять сто раз одно и то же в базовом классе и в каждом дочернем классе неудобно, с точки зрения разработчика.
//Но теперь я знаю про абстракцию и знаю, что в базовом классе прописвать каждый метод не нужно, если у каждого класса общий метод, но с
//разными свойствами. 