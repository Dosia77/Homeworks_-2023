import java.time.LocalDate;
import java.util.List;

public class Animal {
    protected String name;
    protected LocalDate birthDate;
    protected List <String> vaccinations;
    protected String illness;
    protected String owner;

    public Animal(String name, LocalDate birthDate, List<String> vaccinations, String illness, String owner) {
        this.name = name;
        this.birthDate = birthDate;
        this.vaccinations = vaccinations;
        this.illness = illness;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getVaccinations() {
        return vaccinations;
    }

    public String getIllness() {
        return illness;
    }

    public String getOwner() {
        return owner;
    }

    protected void wakeup (){
        System.out.println("Animal is wakeup !!");
    }

    protected void wakeup (int time){
        System.out.println("Animal is wakeup in " + time);
    }

    protected void eat (){
        System.out.println("Animal is ate");
    }

    protected void play (){
        System.out.println("Animal is played");
    }

    protected void sleep () {
        System.out.println("Animal is sleeping");
    }
    protected void flay(){
        System.out.println("Animal flaies");
    }

    protected void swim(){
      System.out.println("Animal is swimming");  
    }
    
    protected void toGo(){
        System.out.println("Animal is runnig"); 
    }
    
    public void lifeCycle() {
        wakeup();
        eat();
        sleep();
   
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", vaccinations=" + vaccinations +
                ", illness='" + illness + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}