package srp2;

// import srp2.model.Order;
// import srp2.model.repository.UserRepository;
// import srp2.util.SaveTo;
import srp2.view.UserView;

public class Main {
    public static void main(String[] args) {

       System.out.println("Enter order:");
    // статический вариант:
       UserView.run();

    // не статический вариант:
    //    UserView uv = new UserView();
    //    uv.run();

    }
}
