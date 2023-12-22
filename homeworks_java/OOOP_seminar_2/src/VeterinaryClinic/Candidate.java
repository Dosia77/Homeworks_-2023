package VeterinaryClinic;

public class Candidate extends Medics{

   
public Candidate(String name, int phoneNamber, String specialization, String qualification, int experience){
        super(name, phoneNamber, specialization, qualification, experience);
        
}
    protected void resume(){
    System.out.printf("%s must send a resume\n");
}

@Override
    protected  void injection(){
    System.out.printf("%s must be able to\n",type);

    }
   @Override
    protected void test(){
    System.out.printf("%s must be able to\n",type);
    }
    @Override
    protected void examination(){
    System.out.printf("%s must be able to\n",type);
    }   
}
