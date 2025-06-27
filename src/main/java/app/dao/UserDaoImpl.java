package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.model.User;

public class UserDaoImpl implements UserDao {

    private final String TABLE_NAME = "users";
    
    @Override
    public void setup() throws SQLException {
        try (Connection conn = DataBase.getConnection();
                Statement stmt = conn.createStatement();) {
                    String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "( " +
                    "username VARCHAR(50) NOT NULL, " +
                    "password CHAR(50) NOT NULL, " +
                    "email VARCHAR(50) NOT NULL, " +
                    "phoneNum VARCHAR(15) NOT NULL, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "PRIMARY KEY (username))";
                    System.out.println("Table created/verified: " + TABLE_NAME);
                    stmt.executeUpdate(sql);
                } catch (SQLException e) {
                    System.err.println("Error setting up table: " + e.getMessage());
                    throw e; 
                }
        } 


    @Override
    public User createUser(String username, String password, String phoneNum, String email, String name) throws SQLException {
        if(userExists(username)) {
            throw new SQLException("Username already exists, Please try again");
        } 
        
        String sql = "INSERT INTO " + TABLE_NAME + " (username, password, phoneNum, email, name) VALUES (?,?,?,?,?)";

        try(Connection conn = DataBase.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql);) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, phoneNum);
                stmt.setString(4, email);
                stmt.setString(5, name);

                stmt.executeUpdate();
                return new User(username, password, phoneNum, email, name);
            } catch (SQLException e) {
                System.err.println("Error Inserting user, Please try again");
                throw e;
            }
    }

    @Override
    public boolean userExists(String username) throws SQLException {
        String sql = "SELECT 1 FROM " + TABLE_NAME + " WHERE username = ?";

        try(Connection conn = DataBase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            try(ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
        
    }

    public boolean checkPassword(String username, String password) throws SQLException {
        String sql = "SELECT password FROM " + TABLE_NAME + " WHERE username = ?";
        boolean passwordMatch = false;
    
        try (Connection conn = DataBase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, username);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    if (password.equals(storedPassword)) {
                        passwordMatch = true;
                    }
                }
            }
        }
        
        return passwordMatch;
    }
    
    
}
