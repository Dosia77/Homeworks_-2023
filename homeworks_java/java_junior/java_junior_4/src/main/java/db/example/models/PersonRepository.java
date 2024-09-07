package db.example.models;


import java.util.List;

public interface PersonRepository{

    void insertPersons();

    Person findById(int id);

    void save(Person person);

    void update(int id, String first_name, String last_name, int age);

    void delete(int id);

    List<Person> findAll();

}
