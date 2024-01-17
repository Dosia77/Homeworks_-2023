package srp2.model.repository;
import srp2.model.Order;
import srp2.view.UserView;


public class UserRepository {

    public Order inputFromConsole(){
    
        String clientName = UserView.prompt("Client name: ");
        String product = UserView.prompt("Product: ");
        int quantity = Integer.parseInt(UserView.prompt("Quantity: "));
        double price = Integer.parseInt(UserView.prompt("Price: "));

        return new Order(clientName, product, quantity, price);
     }
    
}
