import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Client extends JFrame{

    private Server server;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private String name;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String date = dtf.format(LocalDateTime.now());

    JTextArea log = new JTextArea();
    JPasswordField tfPassword = new JPasswordField("123456");
    JTextField tfIPAddress = new JTextField("127.0.0.1");
    JTextField tfPort = new JTextField("8189");
    JTextField tfLogin = new JTextField();
    JButton btnLogin = new JButton("Logon");
    JTextField tfMessage = new JTextField();
    JPanel panelTop = new JPanel(new GridLayout(2, 3));
    JPanel panelBottom = new JPanel(new BorderLayout());
    JButton btnSend;
    JScrollPane scrollLog = new JScrollPane(log);

    private boolean isServerConnected;

    public Client(Server server) {

        this.server = server;

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
               connectToServer();
           }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panelTop.setVisible(false);
                if(isServerConnected)
                {
                    String message = date+": "+name+": "+tfMessage.getText();
                    server.answerAll(message);

                try {
                    Server.fileWriter(message);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                }
                else{
                    log.append("Сервер не подключен!\n");
                   panelTop.setVisible(true);
                }
            }
        });
    }

    private void connectToServer() {
        name = tfLogin.getText();
        if (server.connectUser(this )){
                panelTop.setVisible(false);
                log.append(name + ", " + "вы успешно подключились!\n");
                isServerConnected = true;
                String message = date+": "+name+" "+"connected\n";
                server.appendLog(message);
                 try {
                Server.fileWriter(message);
                 } catch (IOException ex) {
                throw new RuntimeException(ex);
                 }

            fileReader();

        } else {
            panelTop.setVisible(true);
            log.append("Подключение не удалось\n");
        }
    }

    public void answer(String text){
        log.append(text + "\n");
    }

    public void fileReader() {
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

    public void disconnectFromServer() {
        if (isServerConnected) {
            panelTop.setVisible(true);
            isServerConnected = false;
            log.append("Your are disconnected\n");
        }
    }
}