package server_client.chat.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable{

    private final Socket socket;

    private BufferedWriter bufferedWriter;
    
    private BufferedReader bufferedReader;

    private String name;

    public final static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket){
        this.socket = socket;
        try{
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name+" подключился к чату.");
            broadcastMessage("Server: "+name+" подключился к чату.");
        }catch (IOException e){
            closeEverithing(socket, bufferedReader, bufferedWriter);
        }

    }

    @Override
    public void run(){
        String messageFromClient;
        while(socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine();
                if(messageFromClient== null){
                    closeEverithing(socket,bufferedReader,bufferedWriter);
                    break;
                }
                
                broadcastMessage(messageFromClient);

            }catch (IOException e){
                closeEverithing(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void broadcastMessage(String message){

        for (ClientManager client: clients){
            try{

                //#region имитация отправки личного сообщения
                 

                String message2;
                if(message.indexOf('@') == message.indexOf(':')+1) {
                    if(message.indexOf(' ') == -1){
                        message2 = message.substring(message.indexOf('@')+1); 
                    }
                    else {
                         message2 = message.substring(message.indexOf('@')+1, message.indexOf(' '));
                    }
                   
                    if(validName(message2) == true & client.name.equals(message2)) {
                        client.bufferedWriter.write(message);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                        System.out.println(name+" отправил личное сообщение пользователю "+ message2);

                    }
                    else if( validName(message2) == false & client.name.equals(name))
                       
                            {
                                client.bufferedWriter.write("Сообщение не отправлено!Нет такого пользователя.");
                                client.bufferedWriter.newLine();
                                client.bufferedWriter.flush();
                            }        
                }

                //#endregion

                // общий чат

                else if(!client.name.equals(name)){
                    client.bufferedWriter.write(message);
                    client.bufferedWriter.newLine();
                    client.bufferedWriter.flush();
                }

            }catch (IOException e){
                closeEverithing(socket,bufferedReader,bufferedWriter);
            }
        }
    }
    private void closeEverithing(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferWriter){
        removeClient();
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void removeClient(){
        clients.remove(this);
        System.out.println(name+" покинул(a) чат");
        broadcastMessage("Server: "+name+ " покинул(a) чат");
    }

    private boolean validName(String message){

        int count = 0;
        for(var client: clients){
            if(client.name.equals(message)){
                count+=1;
            }

        }

        if(count>0){
            return true;
        }
        else return false;

    }
}
