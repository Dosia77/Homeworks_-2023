package db.example.models;

import db.example.utils.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Random;

public class PersonRepositoryImpl implements PersonRepository{

    Random random = new Random();

    @Override
    public void insertPersons() {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        int count = random.nextInt(5,11);
           for(int i = 0; i<count; i++){
               session.save(Person.createPerson());
           }
        tx1.commit();
        session.close();
    }

    @Override
    public Person findById(int id) {
       return HibernateSession.getSessionFactory().openSession().get(Person.class, id);
    }

    @Override
    public void save(Person person) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(int id, String first_name, String last_name, int age) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Person person = findById(id);
        session.evict(person);
        person.setFirst_name(first_name);
        person.setLast_name(last_name);
        person.setAge(age);
        session.update(person);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(int id) {

        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(findById(id));
        tx1.commit();
        session.close();
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList = (List<Person>) HibernateSession.getSessionFactory().openSession().createQuery("From Person").list();
        return personList;
    }
}
