package srp2.view;

import java.util.Scanner;

import srp2.model.repository.UserRepository;
import srp2.util.SaveTo;

public class UserView {

    //  public void inputFromConsole(){
    //    String clientName = prompt("Client name: ");
    //    String product = prompt("Product: ");
    //    int quantity = Integer.parseInt(prompt("Quantity: "));
    //    int price = Integer.parseInt(prompt("Price: "));
    // }

    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public static void run(){
       UserRepository ur = new UserRepository();
       SaveTo sav = new SaveTo();
       sav.saveToJson(ur.inputFromConsole());

    }

    // public void run(){
    //     UserRepository ur = new UserRepository();
    //     SaveTo sav = new SaveTo();
    //     sav.saveToJson(ur.inputFromConsole());
 
    //  }
    
}
