package Animal;
import java.time.LocalDate;
import java.util.List;

public class Gull extends Animal implements Goable, Swimable, Flyable{
    
public Gull(String name, LocalDate birthDate, List<String> vaccinations, String illness, String owner){ 
        super(name, birthDate, vaccinations, illness, owner);
    } 
    @Override
    public double run(){
        System.out.printf("%s is runs poorly!\nacceleration is ", type);
        
        return 2.0;
    }
    @Override
    public double swim(){
    System.out.printf("%s  is swim not bad!\nacceleration is ", type);
    return 7.0;
   }
   @Override
    public double flay(){
        System.out.printf("%s is flies not bad!\nacceleration is ", type ); 
        return 20.0;
   }
    public void squeak(){
        System.out.println("Animal is beeps loudly");
    }
   
}
