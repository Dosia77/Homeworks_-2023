import directory.EmployeeDirectory;
import employee.Employee;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Employee vasia = new Employee("Vasiliy Pupkin","123456789", 12);
        Employee petia = new Employee("Petr Ivanov" ,"43214321", 10);
        Employee masha = new Employee("Maria Pavlova", "0987655", 2);
        HashMap<Integer, Employee> employeeHashMap = new HashMap<>();
        employeeHashMap.put(1,vasia);
        employeeHashMap.put(2,petia);

        EmployeeDirectory employeeDirectory = new EmployeeDirectory();

        employeeDirectory.printMap(employeeDirectory.addEmployee(3, masha, employeeHashMap));
        System.out.println("----------------------------------------------");
        System.out.println(employeeDirectory.findFromPhoneNumber("0987655", employeeHashMap));
        System.out.println("----------------------------------------------");
        System.out.println(employeeDirectory.findFromPersonnelNumber(1, employeeHashMap));
        System.out.println("----------------------------------------------");
        System.out.println(employeeDirectory.findFromSeniority(10, employeeHashMap));
    }
}