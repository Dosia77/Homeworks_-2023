
package homework.user;

public class User extends MainUser{
    private String name;

     public User(String name){
        super(name);
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
