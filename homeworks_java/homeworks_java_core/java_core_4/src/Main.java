
import shop.Customer;
import  employee.Employee;

public class Main {
    public static void main(String[] args) {

        var employeeList = Employee.createList();

        Employee.celebrate(employeeList);

        System.out.println("-----------------------------");

        for (Employee emp : employeeList) {
            System.out.println(emp.getGender());
        }

        System.out.println("-----------------------------");
        var customerList = Customer.createListCustomers();

        System.out.println(customerList);

    }

}