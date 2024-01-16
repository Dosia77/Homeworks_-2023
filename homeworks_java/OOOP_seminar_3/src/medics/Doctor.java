package medics;
public class Doctor extends Medics {
    public Doctor(String name, int phoneNamber, String specialization, String qualification, int experience){
        super(name, phoneNamber, specialization, qualification, experience);
    }

    public void DoctorSet(){     
        test();
        injection();
        examination();
        prescriptions();
        diagnosisAndprescriptions();
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
    public void examination(){
    System.out.printf("%s examining a patient\n",type);
    }
    public void diagnosisAndprescriptions(){
        System.out.println("Doctor makes a diagnosis and gives prescriptions");
    }

    public void prescriptions(){
        System.out.println("Doctor writes prescriptions");
    }
    
}
