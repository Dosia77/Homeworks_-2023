
package VeterinaryClinic;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import Animal.*;
public class VeterinaryClinic {
 private List<Animal> patients = new ArrayList<>();
 private List<Medics> staff = new ArrayList<>();

Nurse nurse = new Nurse("Vasilisa Pupcina", 222333, "therspist","hight", 10);
Doctor doctor = new Doctor("Vasily Pupcin", 334455,"nurse","veryHigh", 15);

public void addMedic(Medics medic){
    staff.add(medic);
 }

 public List<Medics> getMedics(){
    return staff;
 }

 public void entireStaff(){
    staff.forEach(i -> System.out.println(i));
    
}
 public void addPatient(Animal animal){
    patients.add(animal);
 }

 public void addPatients(Animal ... animals){
    Collections.addAll(patients, animals);
 }
    public List<Animal> getPatiens(){

        return patients;
    }
public void printList(){
    patients.forEach(patient -> System.out.println(patient));
    
}
public List<Goable> getGoables(){
    List<Goable> result = new ArrayList<>(patients.size());
    for (Animal animal:patients) {
        if(animal instanceof Goable)
            result.add((Goable) animal);
    }
    return result;
}
    
public List<Swimable> getSwimables(){
    List<Swimable> result = new ArrayList<>(patients.size());
     for (Animal animal:patients) {
        if(animal instanceof Swimable)
            result.add((Swimable) animal);
     }
    return result;
}
public List<Flyable> getFlyables(){
   List<Flyable> result = new ArrayList<>(patients.size()); 
   for (Animal animal:patients) {
        if(animal instanceof Flyable)
            result.add((Flyable) animal);
   }
   return result;
}

public void doctorsAppointment(){
    doctor.examination();
    nurse.assist();
    doctor.diagnosisAndprescriptions();
    nurse.write();
    doctor.prescriptions();
    
  }
  public void NurseSet(){
    nurse.injection();
    nurse.write();
    nurse.assist();
    nurse.examination();
    nurse.test();
    nurse.injection();
}
public void DoctorSet(){     
    doctor.test();
    doctor.injection();
    doctor.examination();
    doctor.prescriptions();
    doctor.diagnosisAndprescriptions();
}
List<Candidate> candidates = new ArrayList<>();
List<Candidate> fallbackOptions = new ArrayList<>();
public void addCandidats(Candidate candidate){
    if(candidate.getQualification().equals("low") || candidate.getExperience()<=2){
        fallbackOptions.add(candidate);
        System.out.printf("%s we will call you back later...\n", candidate.getName());
    }
        else {
           candidates.add(candidate); 
           System.out.printf("%s We are waiting for an interview!\n", candidate.getName());
        }
    }



public List<Candidate> getCandidates(){
    return candidates;
}
public void printListCandidats(){
    candidates.forEach(i -> System.out.println(i));
    
}
public List<Candidate> getfallbackOptions(){
    return fallbackOptions;
}
public void printListFallbackOptions(){
    fallbackOptions.forEach(i -> System.out.println(i));
    
}
}
