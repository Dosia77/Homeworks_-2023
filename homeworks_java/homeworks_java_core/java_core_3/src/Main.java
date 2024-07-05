import employee.Employee;
import  employee.Manager;

public class Main {
    public static void main(String[] args) {

   var employeeList = Employee.createList();

   System.out.println("Difference between dates in yyyy-mm-dd format: " + Employee.compare(employeeList, "Pupkin", 2023, 10, 11));
   System.out.println("--------------------------------------");
   Manager.increaseManager(employeeList, 5000);
   System.out.println(employeeList);
   System.out.println("----------------------------------------");
   Employee.increaseEmployee(employeeList, 45, 5000);
   System.out.println(employeeList);

    }

}