import java.time.LocalDate;
import java.util.List;

public class Gull extends Animal{
    
public Gull(String name, LocalDate birthDate, List<String> vaccinations, String illness, String owner){ 
        super(name, birthDate, vaccinations, illness, owner);
    } 


    private void squeak(){
        System.out.println("Animal is beeps loudly");
    }
    public void lifeCycle() {
        wakeup();
        flay();
        squeak();
        swim();
        eat();
        sleep();
   
       }
}
