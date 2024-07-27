package client;

import server.ServerController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientController {

    private String name;
    boolean isServerConnected;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String date = dtf.format(LocalDateTime.now());

   private ClientView clientView;
   private ServerController serverController;

    public ClientController(ClientView clientView, ServerController serverController){
        this.clientView = clientView;
        clientView.setClientController(this);
        this.serverController = serverController;
    }

        public boolean sendMessage(String messageUser){
                if(isServerConnected)
                {
                    String message = date+" "+name+": "+ messageUser;
                    serverController.answerAll(message);
                    serverController.saveMessages(message);
                    return true;
                }
                else{
                    clientView.answer("Сервер не подключен!\n");
                } return false;
    }

    public void disconnectFromServer() {
        if (isServerConnected) {
            isServerConnected = false;
            clientView.answer("Вы отключились от сервера.");
        }
    }

    public void answerClient(String message){
        clientView.answer(message);
    }

    public boolean connectToServer(String name){

        this.name = name;
        if (serverController.connectUser(this)){
            clientView.answer(name + ", " + "вы успешно подключились!\n");
            isServerConnected = true;
           String message = date+": "+name+" "+"connected\n";
            serverController.appendLog(message);

            return  true;
        }
        else {
            clientView.answer("Подключение не удалось\n");
       } return false;
    }
}
