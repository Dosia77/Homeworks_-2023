package medics;
public class Nurse extends Medics{
    public Nurse(String name, int phoneNamber, String specialization, String qualification, int experience){
        super(name, phoneNamber, specialization,  qualification, experience);
    
}

public void NurseSet(){
    injection();
    write();
    assist();
    examination();
    test();
    injection();
}
@Override
protected void injection(){
System.out.printf("%s giving injections\n",type);

}
@Override
protected void test(){
System.out.printf("%s takes tests\n",type);
}
@Override
protected void examination(){
System.out.printf("%s examines patients in extreme cases\n",type);
}

public void write(){
    System.out.println("Nurse writes down doctor's orders");
}
public void assist(){
    System.out.println("Nurse helps hold the animal");
}

}