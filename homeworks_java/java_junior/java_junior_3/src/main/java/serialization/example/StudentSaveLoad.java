package serialization.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.*;

public class StudentSaveLoad {

    public static final String FILE_JSON = "students.json";
    public static final String FILE_BIN = "students.bin";
    public static final String FILE_XML = "students.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void addNewStudent(Student student){

       saveStudentToFile(FILE_JSON, student);
       saveStudentToFile(FILE_BIN, student);
       saveStudentToFile(FILE_XML, student);

        System.out.println("Новый студент дбавлен.");
 
    }

    public static void showAllStudents(){
        System.out.println(loadStudentFromFile("students.json"));
        System.out.println( loadStudentFromFile("students.bin"));
        System.out.println(loadStudentFromFile("students.xml"));
    }

    public static void saveStudentToFile(String fileName, Student student){
        try{
             if(fileName.endsWith(".json")){
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName),student);
            }
             else if(fileName.endsWith(".bin")) {
                 try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                     oos.writeObject(student);
                 }
             }
              else if (fileName.endsWith(".xml")) {
                    xmlMapper.writeValue(new File(fileName), student);
                }
            }catch(IOException e){
                e.printStackTrace();

            }
        }
        

        public static Student loadStudentFromFile(String fileName){

            Student student = null;
            File file = new File(fileName);
            if(file.exists()){

            try{
                if(fileName.endsWith(".json")){
                  student = objectMapper.readValue(file, Student.class);
                }
                else
                    if(fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                      student =(Student) ois.readObject();
                    }
                }
                else if (fileName.endsWith(".xml")) {
                  student =  xmlMapper.readValue(file,Student.class);
               }
            }  catch(IOException | ClassNotFoundException e){
                e.printStackTrace();

            }
         }
           return student;
    }
}

