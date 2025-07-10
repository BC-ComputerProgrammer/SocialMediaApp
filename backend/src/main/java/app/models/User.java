package app.models;

public class User {
    @SuppressWarnings("unused")
    private final String username;
    @SuppressWarnings("unused")
    private final String password;
    @SuppressWarnings("unused")
    private final String email;
    @SuppressWarnings("unused")
    private final String phoneNum;
    

    public User(String username, String password, String email, String phoneNum) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNum = phoneNum;
    }

}
