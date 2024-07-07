package employee;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public  class Employee {

    private Genders gender;
    private String firstName;
    private String midName;
    private String lastName;
    private String phone;
    private String position;
    private int salary;
    private LocalDate birthDate;

    public Employee(Genders gender, String firstName, String midName, String lastName, String phone, String position, int salary, LocalDate birthDate) {
        this.gender = gender;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
        this.birthDate = birthDate;

    }

    public Enum<Genders> getGender()
    {
        return gender;
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

    public int getAge() {

        if (getBirthDate() != null) {
            return Period.between(getBirthDate(), LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }
    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nEmployee{\n" +
                "gender=" + gender+
                "name=" + firstName + ",\n" +
                "midName=" + midName + ",\n" +
                "surName=" + lastName + ",\n" +
                "position=" + position + ",\n" +
                "phone=" + phone + ",\n" +
                "salary=" + salary + ",\n" +
                "birthDate=" + birthDate + ".\n" +
                '}';
    }

    public void increaseSalary(int amount) {
        this.salary += amount;
    }

    public static void increaseEmployee(List<Employee> list, int age, int increment) {

        for (Employee emp : list) {
            if (emp.getAge() > age) {
                emp.increaseSalary(increment);
            }

        }

    }

    public static List<Employee> createList()
    {
        List<Employee> employeeList = new ArrayList<>();

        Employee ivan = new Employee(Genders.MALE, "Ivan","Igorevich",
                "Ovchinnikov", "8(495)000-11-22",
                "developer", 50000, LocalDate.of(1985,12,10));
        Employee andrey = new Employee(Genders.MALE, "Anderey","Viktorovich",
                "Bezrukov", "8(495)111-22-33",
                "fitter", 52000, LocalDate.of(1973,12,25));
        Manager evgeniy = new Manager(Genders.MALE, "Evgenyi","Viktorovich",
                "Delfinov", "8(495)222-33-44",
                "project manager", 40000, LocalDate.of(1963,2,20));
        Employee natalia = new Employee(Genders.FEMALE, "Natalia","Pavlovna",
                "Keks", "8(495)333-44-55",
                "senior developer", 90000, LocalDate.of(1990,10,14));
        Employee tatiana = new Employee(Genders.FEMALE, "Tatiana","Sergeevna",
                "Krasotkina", "8(495)444-55-66",
                "accountant", 50000, LocalDate.of(2001,11,8));
        Manager vasily = new Manager(Genders.MALE, "Vasilyi","Alibabaevich","Pupkin", "8(495)228-77-55", "manager", 150000, LocalDate.of(1968, 8,1));

        Manager nikolay = new Manager(Genders.MALE,"Nikolai", "Ivanovich", "Ivanov","1(234)567-89-11", "manager", 100000, LocalDate.of(1991,6,29));
        employeeList.add(ivan);
        employeeList.add(tatiana);
        employeeList.add(natalia);
        employeeList.add(evgeniy);
        employeeList.add(andrey);
        employeeList.add(vasily);
        employeeList.add(nikolay);

        return employeeList;
    }

    public static Enum<PartyDate> getCommand()
    {
        PartyDate command = PartyDate.NONE;
        LocalDate date = LocalDate.now();

        if(date.getDayOfYear() == 54){
            command = PartyDate.FEB_23;
        } else if (date.getDayOfMonth()==8 && date.getMonthValue()==3) {
            command = PartyDate.MARCH_8;

        } else if (date.getDayOfMonth()==31 && date.getMonthValue()==12) {
            command = PartyDate.NEW_YEAR;
        }
        return command;
    }

    public static void celebrate(List<Employee> list) {

        var command= getCommand();
        for (Employee emp: list) {
            switch (command) {
                case PartyDate.NEW_YEAR:
                    System.out.println(emp.firstName + ", happy New Year!");
                    break;
                case PartyDate.FEB_23:
                    if (emp.gender == Genders.MALE)
                        System.out.println(emp.firstName + ", happy February 23rd!");
                    break;
                case PartyDate.MARCH_8:
                    if (emp.gender == Genders.FEMALE)
                        System.out.println(emp.firstName + ", happy march 8th!");
                    break;
                default:
                    System.out.println(emp.firstName + ", celebrate this morning!");
            }
        }
    }

}
