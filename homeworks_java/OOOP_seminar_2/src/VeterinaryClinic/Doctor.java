
package VeterinaryClinic;
public class Doctor extends Medics {
    public Doctor(String name, String qualification, int experience){
        super(name, qualification, experience);
    }
    @Override
    protected  void injection(){
    System.out.printf("%s prescribes injections, but rarely does them himself\n",type);

    }
   @Override
    protected void test(){
    System.out.printf("%s prescribes tests, but rarely takes them himself\n",type);
    }
    @Override
    protected void examination(){
    System.out.printf("%s examining a patient\n",type);
    }
    protected void diagnosisAndprescriptions(){
        System.out.println("Doctor makes a diagnosis and gives prescriptions");
    }

    protected void prescriptions(){
        System.out.println("Doctor writes prescriptions");
    }
    
}
