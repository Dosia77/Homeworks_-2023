package employee;

public class Employee {

    private final String name;
    private String phoneNumber;
    private int seniority;

    public Employee(String name, String phoneNumber, int seniority){

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.seniority = seniority;
    }

    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public int getSeniority(){
        return seniority;
    }


    public  void  setPhoneNumber(){
        this.phoneNumber = phoneNumber;
    }
    public void setSeniority(){
        this.seniority = seniority;
    }

    @Override

    public String toString() {
        return " name=" + name +
                ", phoneNumber=" + phoneNumber +
                ", seniority=" + seniority +"\n";
    }
}
