import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Animal.*;
import VeterinaryClinic.*;
import medics.Candidate;
import medics.Doctor;
import medics.Nurse;
public class Main { 
 
    public static void main(String[] args) throws Exception {

        Cat barsik = new Cat("Barsik", LocalDate.of(
                1993, 6, 6),
                new ArrayList<>(), "Chumka", "Boss", 4);
        Eagle eagle = new Eagle("Kesha", LocalDate.of(
                1996, 6, 6),
                new ArrayList<>(), "Chumka", "Boss");
        Gull gull = new Gull("Pipi",LocalDate.of(
                1996, 6, 6), 
                new ArrayList<>(),"wing fracture", "Vasia Pupkin");
        Snake snake = new Snake("Snake", LocalDate.of(2020,1,1),
        new ArrayList<>(), "HZ", "Vasia Pupkin", 1.9);
        
        Fish fish = new Fish("Golden", LocalDate.of(2021,2,3), 
        new ArrayList<>(),"HEZ", "Vasilisa Pupkina", "golden");

        List<Animal> animals = new ArrayList<>();
        animals.add(barsik);
        animals.add(eagle);
        animals.add(gull);
        animals.add(snake);
        animals.add(fish);

        // clinic.addPatients(barsik,eagle,gull, fish,snake);
        // System.out.println(gull.run());
        // System.out.println(eagle.flay());
        // System.out.println(gull.flay());
        // System.out.println(eagle.swim());
        // System.out.println(barsik.swim());
        // System.out.println(fish.swim());
        // System.out.println(snake.swim());
        // System.out.println("---------------------------");
        // clinic.printList();
        // System.out.println("---------------------------");
           
        // System.out.println(clinic.getGoables());
        // System.out.println("----------------------------");
        // System.out.println(clinic.getSwimables());
        // System.out.println("----------------------------");
        // System.out.println(clinic.getFlyables());


        VeterinaryClinic clinic = new VeterinaryClinic();
        
        Nurse nurse = new Nurse("Vasilisa Pupcina", 222333, "general nurse","hight", 10);
        Doctor doctor = new Doctor("Vasily Pupcin", 334455,"therapist","veryHigh", 15);

        clinic.addAllMedics(nurse, doctor);

        System.out.println(nurse.getName());
        nurse.NurseSet();
        System.out.println("---------------------------");
        System.out.println(doctor.getName());
        doctor.DoctorSet();
        System.out.println("----------------------------");
        clinic.entireStaff();    
         
        Candidate candidate_1 = new Candidate("Ivan", 123455,"therapist","veryHigh", 10);
        Candidate candidate_2 = new Candidate("Pavel", 123432,"surgeon","middle", 5);
        Candidate candidate_3 = new Candidate("Anna",5678766,"therapist","middle", 2);
        Candidate candidate_4 = new Candidate("Marya", 123987,"nurse","low", 1);

        clinic.addCandidats(candidate_1);
        clinic.addCandidats(candidate_2);
        clinic.addCandidats(candidate_3);
        clinic.addCandidats(candidate_4);
        System.out.println("----------------------------------------------");
        clinic.printListCandidats();
        System.out.println("----------------------------------------------");
        clinic.printListFallbackOptions();
        System.out.println("----------------------------------------------");
        clinic.doctorsAppointment();
        //doctorsAppointment();
      
    }

//     public static void doctorsAppointment(){

//         Doctor doctor = new Doctor(null, 0, null, null, 0);
//         Nurse nurse = new Nurse(null, 0, null, null, 0);
//         doctor.examination();
//         nurse.assist();
//         doctor.diagnosisAndprescriptions();
//         nurse.write();
//         doctor.prescriptions();
        
//     }
}
 
