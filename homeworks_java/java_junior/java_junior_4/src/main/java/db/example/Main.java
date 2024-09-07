package db.example;

import db.example.controller.Controller;
import db.example.models.Person;
import db.example.models.PersonRepository;
import db.example.models.PersonRepositoryImpl;


public class Main {
    public static void main(String[] args) {

        PersonRepository repository = new PersonRepositoryImpl();
        Controller controller = new Controller(repository);

        controller.savePersons();
        controller.savePerson(Person.createPerson());
        controller.deletePerson(6);
        controller.updatePerson(4, "Маша", "Павлова", 21);
        System.out.println(controller.findPerson(9));
        System.out.println(controller.findAllPersons());
    }
}