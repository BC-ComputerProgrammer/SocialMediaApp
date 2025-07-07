package app;

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
public class LoginPage implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/login";

    @Override
    public void handle(Context context) throws Exception {
        
        String username = context.formParam("textUsername");
        String password = context.formParam("textPassword");
        String errorMsg = ""; 

        if (username != null && password != null){
            UserDaoImpl userdao = new UserDaoImpl();
            try {
                if(userdao.checkPassword(username, password)) {
                    context.sessionAttribute("user", username);
                    context.redirect(Profile.URL);
                }else{
                    errorMsg = "<p class = 'error-message'>Invalid username or password!</p>";
                }
            }catch (SQLException e) {
                System.err.println(e.getMessage());
                errorMsg = "<p class='error-message'>Database error. Please try again.</p>";
            }
        }
        
        

        // // Create a simple HTML webpage in a String
        String html = "<html>";

        // // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<link rel='stylesheet' type='text/css' href='LoginPage.css' />";

        // // Add the body
        html = html + "<body>";

        // // Add the topnav
        // // This uses a Java v15+ Text Block
        html = html + """
            <div class='topnav'>
                <a href='/'>Homepage</a>
		        <a href='Sign Up.html'>Sign Up</a>
                <a href="login">Log In</a>
                <a href='Profile.html'>Profile</a>
            </div>
        """;

        // // Add header content block
        html = html + """
        <body>
            <div class = "main-content">
                <div class = "login-box">
                    <form method="post" action="/login">
                        <img src = "cat.png" alt = "icon" class = "logo-icon" /><br><br>
                        <input type = "text" name = "textUsername" placeholder = "Username" required><br>
                        <input type = "text" name = "textPassword" placeholder = "Password" required><br>
                        <p class = "question">
                            Forgot password?
                        </p>
                        <button type = "submit" class = "login-btn">Login In</button>
                    </form>
        """;                            
                            
        html += errorMsg; 
        html += """
                    <div class = "login-link">
                        <p>Don't have an account?<a href = "SignUpPage.URL">  Sign up</a></p>
                    </div>
                </div>
            </div>
        </body>
            """;

        // // Close Content div
        html = html + "</div>";

        // // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // // DO NOT MODIFY THIS
        // // Makes Javalin render the webpage
        context.html(html);
    }

}
