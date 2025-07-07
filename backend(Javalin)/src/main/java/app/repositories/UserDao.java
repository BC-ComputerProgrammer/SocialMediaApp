package app.repositories;

import java.sql.SQLException;

import app.models.User;

public interface  UserDao {
    void setup() throws SQLException;
    User createUser(String username, String password, String phoneNum, String email, String name) throws SQLException;
    boolean userExists(String username) throws SQLException;
}
