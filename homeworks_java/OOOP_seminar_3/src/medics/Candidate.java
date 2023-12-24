package medics;

import java.util.ArrayList;
import java.util.List;

public class Candidate extends Medics{

   
public Candidate(String name, int phoneNamber, String specialization, String qualification, int experience){
        super(name, phoneNamber, specialization, qualification, experience);
        
}
// List<Candidate> candidates = new ArrayList<>();
// List<Candidate> fallbackOptions = new ArrayList<>();

// public void addCandidats(Candidate candidate){
//     if(candidate.getQualification().equals("low") || candidate.getExperience()<=2){
//         fallbackOptions.add(candidate);
//         System.out.printf("%s we will call you back later...\n", candidate.getName());
//     }
//         else {
//            candidates.add(candidate); 
//            System.out.printf("%s We are waiting for an interview!\n", candidate.getName());
//         }
//     }

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
