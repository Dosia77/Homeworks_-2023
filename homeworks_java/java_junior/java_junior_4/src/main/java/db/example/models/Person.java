package db.example.models;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Random;

@Entity
@Table(name = "persons")

public class Person {

    public static String [] names = new String []{"Вася","Петя","Ваня", "Олег","Геннадий"};
    public static String [] last_names = new String []{"Иванов","Петров","Сидоров", "Пупкин","Склифосовский"};
    public static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @Column( name= "first_name")
    private String first_name;

   @Column(name = "last_name")
    private String last_name;

   @Column(name = "age")
    private int age;

    public Person() {

    }
    public Person(String first_name, String last_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;

    }

    public static Person createPerson(){
        return new Person(names[random.nextInt(names.length)], last_names[random.nextInt(names.length)], random.nextInt(20,30));

    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                '}';
    }
}
