package server;

import client.ClientController;
import files.FileInterface;
import java.util.ArrayList;
import java.util.List;

public class ServerController {

    private ServerView serverView;
    private List<ClientController> clientList;
    private boolean isServerWorking;
    private FileInterface file;

    public ServerController(ServerView serverView, FileInterface file){

       this.serverView = serverView;
        serverView.setServerController(this);
        this.file = file;
        clientList = new ArrayList<>();
        isServerWorking = false;

    }

     public void serverStart(){
        if (!isServerWorking) {
            isServerWorking = true;
            serverView.showMessage("Server started");
          //  file.;
            appendLog(file.fileReader());
        } else {

            serverView.showMessage("Сервер включен!");
        }
    }

  public void serverStop(){
        if(isServerWorking) {
            isServerWorking = false;
            serverView.showMessage("Сервер остановлен.");
            offAll();
        }
        else{
            serverView.showMessage("Сервер уже остановлен.");

        }
    }

  private void offAll() {
        for (ClientController clientController : clientList) {
            clientController.disconnectFromServer();
        }
        clientList.clear();
    }

    public void answerAll(String text) {
        for (ClientController clientController : clientList) {
            clientController.answerClient(text);
        }
    }

    public boolean connectUser(ClientController clientController) {
        if (!isServerWorking) {
            return false;
        }
        clientList.add(clientController);
        return true;
    }

    public void appendLog(String message){
        serverView.showMessage(message);
    }

    public void saveMessages(String message){
        file.fileWriter(message);
    }

    private String loadMessage(){
     return file.fileReader();
    }
}
