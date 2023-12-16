import java.time.LocalDate;
import java.util.List;

public class Fish extends Animal{

private String color;
public Fish(String name, LocalDate birthDate, List<String> vaccinations, String illness, String owner, String color) {
        super(name, birthDate, vaccinations, illness, owner);
    this.color = color;
}   
public String getColor(){
    return color;
}

private void bubble(){
    System.out.println("Animal is blows bubbles");
}
public void lifeCycle() {
    wakeup();
    bubble();
    eat();
    swim();
    sleep();

   }
}
