package app.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static final String DB_URL = "jdbc:sqlite:backend/database/application.db";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.err.println("Error connecting to Database: " + e.getMessage());
            throw new RuntimeException(e); 
        }
    }
}