import client.Client;
import files.FileStorage;
import server.ServerController;
import server.ServerWindows;
import client.ClientController;

public class Main {
    public static void main(String[] args) {

        ServerController serverController = new ServerController(new ServerWindows(), new FileStorage());
        new ClientController(new Client(), serverController);
        new ClientController(new Client(), serverController);
    }
}