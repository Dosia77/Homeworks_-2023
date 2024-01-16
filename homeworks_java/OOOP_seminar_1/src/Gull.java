import java.time.LocalDate;
import java.util.List;

public class Gull extends Animal{
    
public Gull(String name, LocalDate birthDate, List<String> vaccinations, String illness, String owner){ 
        super(name, birthDate, vaccinations, illness, owner);
    } 
    @Override
    public void toGo(){
        System.out.println("Animal is runs poorly!");
    }
    public void squeak(){
        System.out.println("Animal is beeps loudly");
    }
   
}
