/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.homework;
import java.util.*;

class Book {

    private HashMap<String, TreeSet<Integer>> phoneBook;

    public Book() {

        phoneBook = new HashMap<>();

    }

    public void addContact(String name, Integer phoneNumber) {

        TreeSet<Integer> phones = phoneBook.getOrDefault(name, new TreeSet<>());

        phones.add(phoneNumber);

        phoneBook.put(name, phones);

    }

   public void removeContact(String name, Integer phoneNumber) {

        TreeSet<Integer> phones = phoneBook.getOrDefault(name, new TreeSet<>());

        phones.remove(phoneNumber);

        if (phones.isEmpty()) {

            phoneBook.remove(name);

        } else {

            phoneBook.put(name, phones);

        }

    }

   public TreeSet<Integer> getPhones(String name) {

      return phoneBook.get(name);
  }


    public List<String> sortContactsByPhones() {

        List<Map.Entry<String, TreeSet<Integer>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        sortedEntries.sort((e1, e2) -> e2.getValue().size() - e1.getValue().size());

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, TreeSet<Integer>> entry : sortedEntries) {

            result.add(entry.getKey() + ": " + entry.getValue());

        }

        return result;

    }

}

public class Homework{
    public static void main(String args[]) {
        String name1;
        String name2;
        String name3;
        Integer phone1;
        Integer phone2;
        Integer phone3;
        Integer phone4;      

            name1 = "Ivanov";
            name2 = "Petrov";
            name3 = "Вася";
            phone1 = 123456;
            phone2 = 654321;
            phone3 = 123478;
            phone4 = 228777;

        Book myPhoneBook = new Book();
        
        myPhoneBook.addContact(name1, phone1);
        myPhoneBook.addContact(name1, phone2);
        myPhoneBook.addContact(name2, phone2);
        myPhoneBook.addContact(name1, phone3);
        myPhoneBook.addContact(name3,phone4);

System.out.println(myPhoneBook.sortContactsByPhones()+"\n");

       Integer phone5 = 109876;
       Integer phone6 = 4567;

       myPhoneBook.addContact(name3,phone5);
       myPhoneBook.addContact(name3,phone6);

       myPhoneBook.removeContact(name1,phone3);

System.out.println(name1+ ":"+ myPhoneBook.getPhones(name1)+"\n");

System.out.println(myPhoneBook.sortContactsByPhones());
      
    
}
}

