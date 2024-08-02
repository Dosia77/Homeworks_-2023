//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];
        Object [] names = new Object[]{"Василий", "Петр", "Александр", "Иван", "Андрей"};

        Philosopher ph = new Philosopher(philosophers, forks, names);
        ph.goEat(philosophers,forks,names);

    }
}