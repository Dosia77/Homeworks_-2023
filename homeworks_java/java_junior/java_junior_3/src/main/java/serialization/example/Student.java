package serialization.example;

import java.io.Serializable;

public class Student implements Serializable {

    String name;
    int age;
    transient double GPA;

    public Student(String name, int age, double GPA) {

        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public Student() {
    }

    public String getName() {
        return name;

    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}
