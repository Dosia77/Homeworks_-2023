package homework;
import homework.util.*;
import homework.user.*;


public class Main{
    public static void main(String[] args){
        User user = new User("Bob");
        Persister p = new Persister();
        p.report(user);
        p.save(user);
        MainUser mus = new User("Vasia"); 
        p.save((User)mus);
        p.report((User)mus);
        
    }
}