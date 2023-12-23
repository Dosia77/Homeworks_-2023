
package VeterinaryClinic;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import Animal.*;
import medics.*;
public class VeterinaryClinic {
private List<Animal> patients = new ArrayList<>();
private List<Medics> staff = new ArrayList<>();

 public void addAllMedics(Medics ... medics){
    if(medics.length == 0) System.out.println("Нou haven't added anything!");
    Collections.addAll(staff, medics);
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

public void printListCandidats(){
    candidates.forEach(i -> System.out.println(i));
    
}

public void printListFallbackOptions(){
    fallbackOptions.forEach(i -> System.out.println(i));
    
}

public void doctorsAppointment(){

    Doctor doctor = new Doctor(null, 0, null, null, 0);
    Nurse nurse = new Nurse(null, 0, null, null, 0);
    doctor.examination();
    nurse.assist();
    doctor.diagnosisAndprescriptions();
    nurse.write();
    doctor.prescriptions();
    
}
}
