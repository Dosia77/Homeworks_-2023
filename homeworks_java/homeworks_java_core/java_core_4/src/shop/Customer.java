package shop;

import java.util.ArrayList;
import java.util.List;
import employee.Genders;

public class Customer {

    Genders gender;
    String name;
    int age;
    String phone;

    public Customer(Genders gender, String name, int age, String phone) {
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Enum<Genders> getGender(){
        return gender;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getPhone()
    {
        return  phone;
    }

    public void setAge(int age){
        this.age = age;
    }

    public  void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nCustomer{\ngender "+ gender+"name=" + name +
                ", \nage=" + age + ", \nphone=" + phone + "}";
    }

    public static List<Customer> createListCustomers()
    {
        List<Customer> listCust = new ArrayList<>();
        Customer ivan = new Customer(Genders.MALE, "Ivan",20, "+1-222-333-44-55");
        Customer petr = new Customer(Genders.MALE, "Petr",30, "+2-333-444-55-66");
        listCust.add(ivan);
        listCust.add(petr);

        return listCust;
    }
}

