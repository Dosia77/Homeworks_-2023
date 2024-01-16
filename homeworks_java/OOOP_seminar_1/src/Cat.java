import java.time.LocalDate;
import java.util.List;

public class Cat extends Animal {
    private int legsCount;

    public Cat(String name, LocalDate birthDate, List<String> vaccinations, String illness, String owner,
            int legsCount) {
        super(name, birthDate, vaccinations, illness, owner);
        this.legsCount = legsCount;
    }

    public int getLegsCount() {
        return legsCount;
    }
   @Override
    public void flay(){
    System.out.println("Animal is can't fly");
   }
   @Override
    public void swim(){
        System.out.println("Animal is swims poorly");
    }
    public void meow(){
        System.out.print("Animal is mew");
    }
    
}
