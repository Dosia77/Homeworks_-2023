package serialization.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       Student student = new Student("ivan", 16, 3.36);

       StudentSaveLoad.addNewStudent(student);
       StudentSaveLoad.showAllStudents();


    }
}