import java.time.LocalDate;
import java.util.List;

public class Eagle extends Animal{
    public Eagle(String name, LocalDate birthDate, List<String> vaccinations, String illness, String owner) {
        super(name, birthDate, vaccinations, illness, owner);
    }
@Override
public void swim(){
    System.out.println("Not every eagle can swim, but some swim well");
}
@Override
public void toGo(){
    System.out.println("Eagles fly better than run");
}
    
}