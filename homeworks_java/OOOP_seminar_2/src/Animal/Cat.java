
package Animal;
import java.time.LocalDate;
import java.util.List;


public class Cat extends Animal implements Goable, Swimable{
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
    public double swim(){
        System.out.printf("%s is swims poorly!\nacceleration is ", type );
        return 2.0;
    }
    public void meow(){
        System.out.print("Animal is mew");
    }
    @Override
    public double run(){
        System.out.printf("%s is runs not bad!\nacceleration is ", type);
        return 10.0;
    }
    
}
