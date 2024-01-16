package notebook.util;

public enum CommandsNamber {
    
    EXIT("0 - Выход"),
    CREATE("1 - Создать контакт"),
    READ("2 - Просмотреть контакт по имени"),
    UPDATE("3 - Обновить контакт"),
    LIST("4 - Просмотреть все контакты"),
    DELETE("5 - Удалить контакт - 5"),
    ADD_All("6 - Добавить несколько контактов с предварительным просмотром");

    private String numberOperations;

    CommandsNamber(String numberOperations){
        this.numberOperations = numberOperations;
    }
    public String getNumberOperations(){
        return numberOperations;
    }
    
    public static void printMenu(){
        for(CommandsNamber c : CommandsNamber.values()){
            System.out.println(c.getNumberOperations());
        }
    }
    
}
