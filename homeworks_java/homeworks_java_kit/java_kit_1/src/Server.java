
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Server extends JFrame {

    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private static final JTextArea log = new JTextArea();
    public boolean isServerWorking;
    public static List<Client> clientList;

    public Server() {
        clientList = new ArrayList<>();
        isServerWorking = false;

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
                if(isServerWorking) {
                    isServerWorking = false;
                    log.append("server stopped " + false + "\n");
                    offAll();
                }
                else{
                    log.append("Сервер уже остановлен!\n");
                }
            }
        });


        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    isServerWorking = true;
                    log.append("Server started " + true + "\n");
                    fileReader();
                } else {
                    log.append("Сервер уже включен!\n");
                }

            }
        });


        JPanel panelBottom = new JPanel(new BorderLayout());
        panelBottom.add(btnStart, BorderLayout.WEST);
        panelBottom.add(btnStop, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);


    }

    public static void fileWriter(String message) throws IOException {

        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(message);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void fileReader() {
        StringBuilder text1 = null;
        try (FileReader reader = new FileReader("log.txt")) {

            int c;
            while ((c = reader.read()) != -1) {

                log.append(String.valueOf((char) c));
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    public boolean connectUser(Client clientGUI) {
        if (!isServerWorking) {
            return false;
        }
        clientList.add(clientGUI);
        return true;
    }

    void answerAll(String text) {
        for (Client client : clientList) {
            client.answer(text);
        }
    }

    void offAll() {
        for (Client client : clientList) {
            client.disconnectFromServer();
        }
        clientList.clear();
    }

    void appendLog(String message){
        log.append(message+"\n");
    }

}