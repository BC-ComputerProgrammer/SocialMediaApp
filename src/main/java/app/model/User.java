package app.model;

public class User {
    private String username;
    private String password;
    private String email;
    private String phoneNum;
    private String name;

    public User(String username, String password, String email, String phoneNum, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
        this.name = name;
    }

}
