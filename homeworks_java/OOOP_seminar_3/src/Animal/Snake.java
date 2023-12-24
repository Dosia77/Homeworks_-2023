package Animal;
import java.time.LocalDate;
import java.util.List;

public class Snake extends Animal implements Swimable{
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
  public double swim(){
    System.out.printf("%s is swims not bad"+ "\n", type );
    System.out.print("acceleration is ");
        return 5.0;
  }
}

   
