package app;

import java.sql.SQLException;

import app.dao.UserDaoImpl;
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

    // URL of this page relative to http://localhost:7002/
    public static final String URL = "/SignUpPage.html";

    @Override
    @SuppressWarnings("empty-statement")
    public void handle(Context context) throws Exception {
        String username = context.formParam("textUsername");
        String email = context.formParam("textEmail");
        String phoneNumber = context.formParam("textPhoneNumber");
        String fullname = context.formParam("textFullName");
        String password = context.formParam("textPassword");
        
        UserDaoImpl userdao = new UserDaoImpl();
        boolean error = false;
        if(isValid(username) && isValidEmail(email) && isValidPhoneNumber(phoneNumber) && isValid(fullname) && isValid(password)) {
            
            try {
                userdao.createUser(username, password, phoneNumber, email, fullname);
            } catch (SQLException e) {
                error = true;
            }
            System.out.println("Sign up successful");
        } else {
            System.out.println("Not successfully");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Phone: " + phoneNumber);
            System.out.println("Email: " + email);
            System.out.println("Full Name: " + fullname);
        }
        

        // // Create a simple HTML webpage in a String
        String html = "<html>";

        // // Add some Head information
        html = html + "<head>" + "<meta charset=\"UTF-8\">";

        // // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<link rel='stylesheet' type='text/css' href='SignUpPage.css' />";
        html = html + "</head>";

        // // Add the body
        html = html + "<body>";

        // // Add the topnav
        // // This uses a Java v15+ Text Block
        html = html + """
            <div class='topnav'>
                <a href='/'>Homepage</a>
		        <a href='SignUpPage.html'>Sign Up</a>
                <a href="login">Log In</a>
                <a href='Profile.html'>Profile</a>
            </div>
        """;

        // // Add HTML for the page content
        html = html + """
        <body>
            <div class = "main-content">
                <div class = "signup-box">
                    <form method="post" action="/SignUpPage.html">
                        <img src = "cat.png" alt = "person" class = "logo-icon" />
                        <p>Sign up to see photos and videos from your friends.</p><br>
                        <input type = "text" name = "textUsername" placeholder = "Username" required><br> """ + ((error == true) ?
                            """ 
                            <p id="ErrorUsername"> Username Already Taken! Try Again </p> 
                            """ : "");
                        

                        html += """
                        <input type = "text" name = "textEmail" placeholder = "Email" required><br>
                        <input type = "text" name = "textPhoneNumber" placeholder = "Phone Number" required><br>
                        <input type = "text" name = "textFullName" placeholder = "Full Name" required><br>

                        <input type = "text" name = "textPassword" placeholder = "New Password" required><br>
                        <input type = "text" name = "textCPassword" placeholder = "Confirm Password" required><br>
                        <p class = "terms">
                            People who use our service may have uploaded your contact information to Instagram.<br>
                            By signing up, you agree to our Terms, Privacy Policy and Cookies Policy.
                        </p>
                        <button type = "submit" class = "signup-btn">Sign Up</button>
                    </form>

                    <div class = "login-link">
                        <p>Have an account? <a href = "#">Log in</a></p>
                    </div>
                </div>
            </div>
        </body>
            """;

        
        html = html + "</html>";

        // // DO NOT MODIFY THIS
        // // Makes Javalin render the webpage
        context.html(html);
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

