package app.controllers;

import java.sql.SQLException;

import app.repositories.UserDaoImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class LoginPage implements Handler {

    public static final String URL = "/api/login";

    @Override
    public void handle(Context context) throws Exception {
        
        LoginRequest request = context.bodyAsClass(LoginRequest.class);

        if (!isValid(request.username) || !isValid(request.password)) {
            context.status(400).json(new ErrorResponse("Invalid username or password"));
            return;
        }
        try {
            UserDaoImpl userDao = new UserDaoImpl();
            boolean isMatch = userDao.checkPassword(request.username, request.password);

            if(isMatch){
                context.status(200).json(new SuccessResponse("Login successful"));
            }else{
                context.status(401).json(new ErrorResponse("Invalid username or password"));
            }
        } catch (SQLException e) {
            context.status(500).json(new ErrorResponse("Database error: " + e.getMessage()));
        }

        
    }
    private boolean isValid(String text){
        return text != null && !text.isBlank();
    }


}

class LoginRequest{
    public String username;
    public String password;    
}

class ErrorResponse{
    public String error;
    public ErrorResponse(String error){
        this.error = error;
    }
}

class SuccessResponse{
    public String message;
    public SuccessResponse(String message){
        this.message = message;
    }
}
