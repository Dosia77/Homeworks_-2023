/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.homework;
import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

class CustomExceptions {
    public static final MyException MY_EXCEPTION_1 = new MyException("Произошла ошибка при работе с консолью");
    public static final MyException MY_EXCEPTION_2 = new MyException("Введено неверное количество параметров");
    public static final MyException MY_EXCEPTION_3 = new MyException("Неверный формат даты рождения");
    public static final MyException MY_EXCEPTION_4 = new MyException("Неверный формат телефона");
    public static final MyException MY_EXCEPTION_5 = new MyException("Неверно введен пол");
    public static final MyException MY_EXCEPTION_6 = new MyException("Возникла ошибка при работе с файлом");
          
}

/**
 *
 * @author XE
 */
  public class Homework {

    public static void main(String[] args){ //throws IOException{
         try {
            makeRecord();
            System.out.println("success");
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        }

    public static void makeRecord() throws MyException{
        System.out.println("Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), номер телефона (число без разделителей) и пол(символ латиницей f или m), разделенные пробелом");

        String text;
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            text = bf.readLine();
        }catch (IOException e){
            throw CustomExceptions.MY_EXCEPTION_1;
        }

        String[] array = text.split(" ");
        if (array.length != 6){
            throw CustomExceptions.MY_EXCEPTION_2;
        }

        String surname = array[0];
        String name = array[1];
        String patronymic = array[2];

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        Date birthdate;
        try {
            birthdate = format.parse(array[3]);
        }catch (ParseException e){
            throw CustomExceptions.MY_EXCEPTION_3;
        }

        int phone;
       try {
            phone = Integer.parseInt(array[4]);
        }catch (NumberFormatException e){
          throw CustomExceptions.MY_EXCEPTION_4;
        }

        String sex = array[5];
        if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f")){
            throw CustomExceptions.MY_EXCEPTION_5;
        }

        String fileName = "files\\" + surname.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, patronymic, format.format(birthdate), phone, sex));
        }catch (IOException e){
            throw CustomExceptions.MY_EXCEPTION_6;
        }
    }
}
