
package Animal;
import java.time.LocalDate;
import java.util.List;

public class Fish extends Animal implements Swimable{

private String color;
public Fish(String name, LocalDate birthDate, List<String> vaccinations, String illness, String owner, String color) {
        super(name, birthDate, vaccinations, illness, owner);
    this.color = color;
}   
public String getColor(){
    return color;
}
@Override
public double swim(){
    System.out.printf("%s  is swim perfect\nacceleration is ", type);
    return 10.0;
}

public void bubble(){
    System.out.println("Animal is blows bubbles");
}

}
