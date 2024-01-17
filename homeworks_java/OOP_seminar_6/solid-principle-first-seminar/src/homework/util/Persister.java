//package homework;
package homework.util;
import homework.user.*;
public class Persister implements Persisterable, Reportable{


  @Override
    public void save(User user) {
        System.out.println("Save user: " + user.getName());
    }

  

  @Override
    public void report(User user){
        System.out.println("Report for user: " + user.getName());
    }


 }
