package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.model.repository.GBRepository;
import notebook.util.Commands;
import notebook.util.CommandsNamber;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserView {
    
    private final UserController userController;
    
    public UserView(UserController userController) {
        this.userController = userController;
    }
   
    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public void run(){
       //Commands com;
       
        while (true) {

            CommandsNamber.printMenu();
            String command = prompt("Введите номер команды: ");
            if (command.equals("0")) return;
            //String command = userController.prompt("Введите команду:\n1 - Создать контакт\n2 - Просмотреть контакт\n3 - Обновить контакт\n4 - Посмотреть все контакты\n5 - Удалить контакт\n6 - Добавить несколько контактов с предварительным просмотром\n0 - Выход\n ");
           // com = Commands.values()[Integer.parseInt(command)];
            //if (com == Commands.EXIT) return;
            switch (command){//com}) {
                case "1"://CREATE:
                    User u = userController.createUser();
                    userController.saveUser(u);
                    break;
                case "2":// READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3"://UPDATE:
                    String userId = prompt("Enter user id: ");
                    userController.updateUser(userId, userController.createUser());
                    break;

                case "4"://LIST:
                    System.out.println(userController.readAll());

                    break;

                case "5"://DELETE:
                    String userId1 = prompt("Enter user id: ");
                    userController.deleteUser(userId1);
                    break;
  
                case "6"://ADD_All:
                 System.out.println(userController.createUser_all());

            }

            
        }
    }


} 