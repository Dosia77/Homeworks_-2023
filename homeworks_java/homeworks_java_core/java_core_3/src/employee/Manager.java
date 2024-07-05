package employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Manager extends Employee {

    private String firstName;
    private String midName;
    private String lastName;
    private String phone;
    private String position;
    private int salary;
    private LocalDate birthDate;

    public Manager(String firstName, String midName, String lastName, String phone, String position, int salary, LocalDate birthDate) {
        super(firstName, midName, lastName, phone, position, salary, birthDate);
    }

    public String getFirstName(Manager manager) {
        return firstName;
    }

    public String getMidName(Manager manager) {
        return midName;
    }

    public String getLastName(Manager manager) {
        return lastName;
    }

    public String getPhone(Manager manager) {
        return phone;
    }

    public String getPosition(Manager manager) {
        return position;
    }

    public int getSalary(Manager manager) {
        return salary;
    }

    public LocalDate getBirthDate(Manager manager) {
        return birthDate;
    }

    public void info() {
        System.out.println("Employee{" +
                "name='" + firstName + '\'' +
                ", midName='" + midName + '\'' +
                ", surName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}');
    }

  @Override
    public int getAge(Employee emp) {

        if (emp.getBirthDate() != null) {
            return Period.between(emp.getBirthDate(), LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    public static void increaseManager(List<Employee> list,  int increment) {
        for (Employee emp : list) {
               if (!(emp instanceof Manager))
            emp.increaseSalary(increment);

            }
        }
    }

