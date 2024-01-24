
import impl.ComplexCalculator;
import impl.ComplexLogable;
import logger.Log;
import view.View;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
   private static final Logger log = Log.log(Main.class.getName());
    public static void main(String[] args) {
      log.log(Level.INFO, "Method main in OOP_seminar_7 package started");
      View view = new View(new ComplexLogable(new ComplexCalculator()));
      view.run();
        
    }
}
