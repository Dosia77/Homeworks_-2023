import java.time.LocalDate;
import java.util.List;

public class Snake extends Animal{
private double length;
public Snake(String name, LocalDate birthDate, List<String> vaccinations, String illness, String owner, double length) {
        super(name, birthDate, vaccinations, illness, owner);
        this.length = length;
}
public double getLength() {
  return length;
}

  public void pos(){
    System.out.println("Animal is poses");
  }
@Override
 public void toGo(){
  System.out.println("Animal is cannot walk or run");
}
@Override
public void flay(){
  System.out.println("Animal is cannot fly");
}

   
}