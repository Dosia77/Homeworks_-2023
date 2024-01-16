package notebook.model.repository.impl;

import notebook.util.DBConnector;
import notebook.util.UserValidator;
import notebook.util.mapper.impl.UserMapper;
import notebook.view.UserView;
import notebook.model.User;
import notebook.model.repository.GBRepository;
//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements GBRepository {
    private final UserMapper mapper;
   
//    @Override
//     public String prompt(String message) {
//         Scanner in = new Scanner(System.in);
//         System.out.print(message);
//         return in.nextLine();
//     }

   @Override
    public User createUser() {
        
        String firstName = UserView.prompt("Имя: ");
        String lastName = UserView.prompt("Фамилия: ");
        String phone = UserView.prompt("Номер телефона: ");

        return new User(firstName, lastName, phone);
    }


    public UserRepository(String dbPath) {
        this.mapper = new UserMapper();
    
    }

    public List<String> readAll() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(DBConnector.DB_PATH);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void saveAll(List<String> data) {
        try (FileWriter writer = new FileWriter(DBConnector.DB_PATH, false)) {
            for (String line : data) {
                // запись всей строки
                writer.write(line);
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> findAll() {
        List<String> lines = readAll();
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.toOutput(line));
        }
        return users;
    }

    @Override
    public User create(User user) {
        UserValidator validator = new UserValidator();
        user.setFirstName(validator.isNameValid(user.getFirstName()));
        user.setLastName(validator.isNameValid(user.getLastName()));
        
        List<User> users = findAll();
        long max = 0L;
        for (User u : users) {
            long id = u.getId();
            if (max < id){
                max = id;
            }
        }
        long next = max + 1;
        user.setId(next);
        users.add(user);
        write(users);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> delete(Long userId){
        List<User> users = findAll();
        User deleteUser = users.stream()
                .filter(u -> u.getId()
                        .equals(userId))
                .findFirst().orElseThrow(() -> 
                new RuntimeException("User not found"));
               users.remove(deleteUser);
                write(users);

        return users;
    }

    @Override
    public Optional<User> update(Long userId, User update) {
        List<User> users = findAll();
        User editUser = users.stream()
                .filter(u -> u.getId()
                        .equals(userId))
                .findFirst().orElseThrow(() -> 
                new RuntimeException("User not found"));
                
                if(!update.getFirstName().isEmpty()){
                    editUser.setFirstName(update.getFirstName());
                }
                if(!update.getLastName().isEmpty()){
                    editUser.setLastName(update.getLastName());
                }
                if(!update.getPhone().isEmpty()){
                    editUser.setPhone(update.getPhone());
                }
       
                write(users);

        return Optional.of(update);
    }


   
    public void write(List<User> users) {
        List<String> lines = new ArrayList<>();
        for (User u: users) {
            lines.add(mapper.toInput(u));
        }
        saveAll(lines);
    }

    
    @Override
    public List<User> createUser_all() {

        List<User> users = new ArrayList<User>();
        
        String command = UserView.prompt("Введите команду:\n1 - добавить контакт\n2 - предварительный просмотр\n3 - удалить контакт\n0 - запись контакта и выход в меню\n");
        while (!command.equals("0")) {
            if(command.equals("1")){  
        
            User newUser = createUser();
            users.add(newUser);
            }

            else if(command.equals("2") ){

                if(users.size()>0){
                    System.out.println(users); 
                } 
                
                else{
                    System.out.println("Вы ничего не ввели!");
                }
     
            }

            else if(command.equals("3")){ 
             
                users.remove(users.indexOf(UserView.prompt("Введите имя для удаления:\n"))+1);
            }
            else{
                System.out.println("Операция не найдена!");
                break;
            }
        command = UserView.prompt("Введите команду:\n1 - добавить контакт\n2 - предварительный просмотр\n3 - удалить контакт\n0 - запись контакта и выход в меню\n");       
            }
    
        for (User u :users){
            create(u);
        }
        
       
    return users;

}

}