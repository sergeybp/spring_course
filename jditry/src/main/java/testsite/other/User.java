package testsite.other;

/**
 * Created by sergeybp on 22.05.17.
 */
public class User {

    public String getName() {
        return name;
    }

    private String name;

    public String getPassword() {
        return password;
    }

    private String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }
}
