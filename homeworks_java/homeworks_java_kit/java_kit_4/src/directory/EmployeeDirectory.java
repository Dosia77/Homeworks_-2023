package directory;

import employee.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeDirectory {

    public EmployeeDirectory() {

    }

    public Map<Integer, Employee> addEmployee(int number, Employee employee, Map<Integer, Employee> map) {
        map.put(number, employee);
        return map;
    }

    public Employee createEmployee(String name, String phone, int seniority) {
        Employee employee = new Employee(name, phone, seniority);
        return employee;

    }

    public List<Employee> findFromSeniority(int seniority, Map<Integer, Employee> map) {

        List<Employee> list = new ArrayList<>();
        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
         Employee  value = entry.getValue();
            if (value.getSeniority() >= seniority) {
                list.add(value);
            }
        }
        return list;
    }

   public void printMap(Map<Integer, Employee> map){
        for (Map.Entry<Integer, Employee> entry : map.entrySet()){
            System.out.printf("Personnelnamber: %s  Employee: %s \n", entry.getKey(), entry.getValue());
        }
   }

    public Employee findFromPhoneNumber(String phonenumber, Map<Integer, Employee> map) {

        Employee employee = null;
        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            Employee  value = entry.getValue();
            if (value.getPhoneNumber().equals(phonenumber)) {
                employee = value;
            }
        }
        return employee;
    }

    public Employee findFromPersonnelNumber(int personnelNumber, Map<Integer, Employee> map) {

        Employee employee = null;
        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            Employee  value = entry.getValue();
            int key = entry.getKey();
            if (key == personnelNumber) {
                employee = value;
            }
        }
        return employee;
    }
}
