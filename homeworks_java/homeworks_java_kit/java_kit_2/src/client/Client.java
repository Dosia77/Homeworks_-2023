package client;


import server.ServerController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Client extends JFrame implements ClientView{

   private ServerController server;
   private  ClientController clientController;

   private static final int WIDTH = 400;
   private static final int HEIGHT = 300;
   private String name;

   private JTextArea log = new JTextArea();
   private JPasswordField tfPassword = new JPasswordField("123456");
   private JTextField tfIPAddress = new JTextField("127.0.0.1");
   private JTextField tfPort = new JTextField("8189");
   private JTextField tfLogin = new JTextField();
   private JButton btnLogin = new JButton("Logon");
   private JTextField tfMessage = new JTextField();
   private JPanel panelTop = new JPanel(new GridLayout(2, 3));
   private   JPanel panelBottom = new JPanel(new BorderLayout());
   private JButton btnSend;
   //private JScrollPane scrollLog = new JScrollPane(log);

       public Client() {

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");

        panelTop.add(tfPassword);
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);
        setVisible(true);

        tfMessage = new JTextField();
        btnSend = new JButton("send");
        panelBottom.add(tfMessage);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();

           }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageFromUser();
            }
        });
    }

    @Override
    public void answer(String text){
        log.append(text + "\n");
    }

    @Override

   public void setClientController(ClientController clientController){
            this.clientController = clientController;
    }

    public void login(){
           if(clientController.connectToServer(tfLogin.getText())){
               panelTop.setVisible(false);
           }
    }

    public void messageFromUser(){
           if(!clientController.sendMessage(tfMessage.getText())){
               panelTop.setVisible(true);
           }
    }
}