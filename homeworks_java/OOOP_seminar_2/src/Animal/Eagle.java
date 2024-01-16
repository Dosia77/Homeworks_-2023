package Animal;
import java.time.LocalDate;
import java.util.List;

public class Eagle extends Animal implements Goable, Swimable, Flyable{
    public Eagle(String name, LocalDate birthDate, List<String> vaccinations, String illness, String owner) {
        super(name, birthDate, vaccinations, illness, owner);
    }
@Override
public double swim(){
    System.out.printf("Not every" + " %s can swim, but some swim well!\nacceleration is ", type );
    return 3.0;
}
@Override
    public double run(){
        System.out.printf("%s is runs poorly!\nacceleration is ", type );
        return 4.0;
    }
@Override 
    public double flay(){
   System.out.printf("%s is flies beautifully!\nacceleration is ", type ); 
   return 30.0;
}
}