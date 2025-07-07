package app.controllers;

import java.sql.SQLException;

import app.repositories.UserDaoImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class SignUpPage implements Handler {
    public static final String URL = "/api/signup";

    @Override
    public void handle(Context context) throws Exception {
        SignUpRequest request = context.bodyAsClass((SignUpRequest.class));
        
           
            if(!isValid(request.username) || isValidEmail(request.email) ||
            !isValidPhoneNumber(request.phoneNumber) || !isValid(request.fullName) 
            || !isValid(request.password) || !isValid(request.confirmPassword) || 
            !request.password.equals(request.confirmPassword)) {
                
            context.status(400).json(new ErrorResponse("Invalid input data"));
            return;
            }

            try {
                UserDaoImpl userdao = new UserDaoImpl(); 
                userdao.createUser(request.username, request.password, request.phoneNumber, request.email, request.fullName);
                context.status(201).json(new SuccessResponse("User created successfully"));
            } catch (SQLException e) {
                context.status(409).json(new ErrorResponse("Username already exists"));
            }
                
            }

    private boolean isValid(String text) {
        return text != null && !text.isBlank();
    }

    private boolean isValidPhoneNumber(String text) {
        return text != null && !text.isBlank() && text.matches("[0-9]+") /* &&  text.length() < 8 */;
    }

    private boolean isValidEmail(String text) {
        return text != null && !text.isBlank() && text.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}

    class SignUpRequest {
        public String username;
        public String email;
        public String phoneNumber;
        public String fullName;
        public String password;
        public String confirmPassword;
    }

    class SuccessResponse {
        public String message;
        public SuccessResponse(String message) { this.message = message; }
    }

    class ErrorResponse {
        public String error;
        public ErrorResponse(String error) { this.error = error; }
    }

    


