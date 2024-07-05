package employee;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.time.*;
public  class Employee {//implements {

    private String firstName;
    private String midName;
    private String lastName;
    private String phone;
    private String position;
    private int salary;
    private LocalDate birthDate;

    public Employee(String firstName, String midName, String lastName, String phone, String position, int salary, LocalDate birthDate) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
        this.birthDate = birthDate;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidName() {
        return midName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }


    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge(Employee emp) {

        if (emp.getBirthDate() != null) {
            return Period.between(emp.getBirthDate(), LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + firstName + ",\n" +
                "midName='" + midName + ",\n" +
                "surName='" + lastName + ",\n" +
                "position='" + position + ",\n" +
                "phone='" + phone + ",\n" +
                "salary=" + salary + ",\n" +
                "birthDate=" + birthDate + ".\n" +
                '}';
    }

    public void increaseSalary(int amount) {
        this.salary += amount;
    }

    public static void increaseEmployee(List<Employee> list, int age, int increment) {

        for (Employee emp : list) {
            if (emp.getAge(emp) > age) {
                emp.increaseSalary(increment);
            }

        }

    }

    public  static LocalDate getEmmployeeBirthDate(List<Employee> list, String name){

        LocalDate date = null;
        for(Employee emp: list)
        {
            if(emp.lastName.equals(name)){
                date = emp.birthDate;
            }
        }
        return date;
    }

    public static LocalDate compare( List<Employee> list, String lastName, int year, int month, int day){
        LocalDate compared = LocalDate.of(year, month, day);
        LocalDate birthEmployee = getEmmployeeBirthDate(list, lastName);
        long resultDays = ChronoUnit.DAYS.between( birthEmployee, compared);
        return LocalDate.of(0, 1, 1).plusDays(resultDays - 1);

    }

    public static List<Employee> createList()
    {
        List<Employee> employeeList = new ArrayList<>();

        Employee ivan = new Employee("Ivan", "Igorevich",
                "Ovchinnikov", "8(495)000-11-22",
                "developer", 50000, LocalDate.of(1985,12,10));
        Employee andrey = new Employee("Andrey", "Viktorovich",
                "Bezrukov", "8(495)111-22-33",
                "fitter", 52000, LocalDate.of(1973,12,25));
        Manager evgeniy = new Manager("Evgeniy", "Viktorovich",
                "Delfinov", "8(495)222-33-44",
                "project manager", 40000, LocalDate.of(1963,2,20));
        Employee natalia = new Employee("Natalia", "Pavlovna",
                "Keks", "8(495)333-44-55",
                "senior developer", 90000, LocalDate.of(1990,10,14));
        Employee tatiana = new Employee("Tatiana", "Sergeevna",
                "Krasotkina", "8(495)444-55-66",
                "accountant", 50000, LocalDate.of(2001,11,8));
        Manager vasily = new Manager("Vasily","Alibabaevich","Pupkin", "8(495)228-77-55", "manager", 150000, LocalDate.of(1968, 8,1));

        Manager nikolay = new Manager("Nikolai", "Ivanovich", "Ivanov","1(234)567-89-11", "manager", 100000, LocalDate.of(1991,6,29));
        employeeList.add(ivan);
        employeeList.add(tatiana);
        employeeList.add(natalia);
        employeeList.add(evgeniy);
        employeeList.add(andrey);
        employeeList.add(vasily);
        employeeList.add(nikolay);

        return employeeList;
    }


}
