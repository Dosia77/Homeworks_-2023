
package VeterinaryClinic;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import Animal.*;
public class VeterinaryClinic {
 private List<Animal> patients = new ArrayList<>();

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

Nurse nurse = new Nurse("Vasilisa Pupcina", "hight", 10);
Doctor doctor = new Doctor("Vasily Pupcin", "veryHigh", 15);

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
}