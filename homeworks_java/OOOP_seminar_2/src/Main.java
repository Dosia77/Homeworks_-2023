import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Animal.*;
import VeterinaryClinic.*;
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

        VeterinaryClinic clinic = new VeterinaryClinic();
        Nurse nurse = new Nurse("Vasilisa Pupcina", "hight", 10);
        Doctor doctor = new Doctor("Vasily Pupcin", "veryHigh", 15);
        clinic.addPatients(barsik,eagle,gull, fish,snake);
        System.out.println(gull.run());
        System.out.println(eagle.flay());
        System.out.println(gull.flay());
        System.out.println(eagle.swim());
        System.out.println(barsik.swim());
        System.out.println(fish.swim());
        System.out.println(snake.swim());
        System.out.println("---------------------------");
        clinic.printList();
        System.out.println("---------------------------");
        System.out.println(nurse.getName());
        clinic.NurseSet();
        System.out.println("---------------------------");
        System.out.println(doctor.getName());
        clinic.DoctorSet();
        System.out.println("----------------------------");
        clinic.doctorsAppointment();
        System.out.println("----------------------------");
        System.out.println(clinic.getGoables());
        System.out.println("----------------------------");
        System.out.println(clinic.getSwimables());
        System.out.println("----------------------------");
        System.out.println(clinic.getFlyables());
        
    }
}
 
//Доброго времени суток! У меня все методы для медиков приватные, доступны из клиники только в комплекте. Возможно, это плохо в конкретном случае, 
//но Вы так много говорили про безопасность на java, что грех не попробовать. А расприватить же легко в любой момент.
//И все звери худо-бедно плавают. Не знаю, существуют ли такие, что плавть совсем не могут