package client;

import server.ServerController;

public interface ClientView {

    void answer(String text);
    void setClientController(ClientController clientController);

}