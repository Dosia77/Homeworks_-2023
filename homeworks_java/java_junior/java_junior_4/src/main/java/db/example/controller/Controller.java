package db.example.controller;

import db.example.models.Person;
import db.example.models.PersonRepository;
import java.util.List;

public class Controller {

   // PersonRepositoryImpl repository = new PersonRepositoryImpl();
private final PersonRepository repository;
   // PersonRepository repository = new PersonRepository();

public Controller(PersonRepository repository){

    this.repository = repository;
}

    public void savePersons(){
     repository.insertPersons();
    }
    public Person findPerson(int id) {
        return repository.findById(id);
    }

    public void savePerson(Person person) {
        repository.save(person);
    }

    public void deletePerson(int id) {
        repository.delete(id);
    }

    public void updatePerson(int id, String first_name, String last_name, int age) {
        repository.update(id, first_name, last_name, age);
    }

    public List<Person> findAllPersons() {
        return repository.findAll();
    }

}