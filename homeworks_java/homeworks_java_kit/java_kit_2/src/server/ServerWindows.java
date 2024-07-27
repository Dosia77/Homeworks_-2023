package server;

import client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ServerWindows extends JFrame implements ServerView{

    private  ServerController serverController;

    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private static final JTextArea log = new JTextArea();

    public ServerWindows() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);

        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                serverController.serverStop();
            }
        });


        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.serverStart();

            }
        });

        JPanel panelBottom = new JPanel(new BorderLayout());
        panelBottom.add(btnStart, BorderLayout.WEST);
        panelBottom.add(btnStop, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

    }

  private void appendLog(String message){
        log.append(message+"\n");
    }

    @Override
   public  void showMessage(String message){
        appendLog(message);
    }

    @Override

    public void setServerController(ServerController serverController){
        this.serverController = serverController;
    }
}
