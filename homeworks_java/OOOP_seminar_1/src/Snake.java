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

  private void pos(){
    System.out.println("Animal is poses");
  }

  public void lifeCycle() {
    wakeup();
    pos();
    eat();
    sleep();

   }
}