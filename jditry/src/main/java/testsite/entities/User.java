package testsite.entities;

/**
 * Created by sergeybp on 22.05.17.
 */
public class User {


    private String name;

    private String password;

    private String lastName;

    private String description;


    public static User emptyUser = new User("","", "", "");

    public User(String name, String password, String lastName, String description) {
        this.name = name;
        this.password = password;
        this.lastName = lastName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    public static User getEmptyUser() {
        return emptyUser;
    }
}
