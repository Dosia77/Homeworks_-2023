package VeterinaryClinic;
public class Nurse extends Medics{
    public Nurse(String name, int phoneNamber, String specialization, String qualification, int experience){
        super(name, phoneNamber, specialization,  qualification, experience);
    
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

protected void write(){
    System.out.println("Nurse writes down doctor's orders");
}
protected void assist(){
    System.out.println("Nurse helps hold the animal");
}

}