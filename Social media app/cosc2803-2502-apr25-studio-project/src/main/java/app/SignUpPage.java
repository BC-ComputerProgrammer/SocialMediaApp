package app;

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
        String phoneNumber = context.formParam("textPoneNumber");
        String fullname = context.formParam("textFullName");
        String password = context.formParam("textPassword");

        
        // // Create a simple HTML webpage in a String
        String html = "<html>";

        // // Add some Head information
        html = html + "<head>" + "<title>Sign Up</title>";

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
                <a href='Sign Up.html'>Sign Up</a>
		        <a href="equipment.html">Climate Equipment</a>
                <a href='page2A.html'>Sub Task 2.A</a>
                <a href='page2B.html'>Sub Task 2.B</a>
                <a href='page2C.html'>Sub Task 2.C</a>
                <a href='page3A.html'>Sub Task 3.A</a>
                <a href='page3B.html'>Sub Task 3.B</a>
                <a href='page3C.html'>Sub Task 3.C</a>
            </div>
        """;

        // // Add header content block
        html = html + """
            <div>
                <h1>Sign Up</h1>
            </div>
        """;

        

        // // Add Div for page Content
        // html = html + "<div class='content'>";

        // // Add HTML for the page content
        html = html + """
        <body>
            <div class = "container" id = "container">
                <form method = 'POST'>
                    <label for = "Instrcution">Sign up to see photos and videos from your friends.</label><br><br>
                    <input type = "text" name = "textUsername" placeholder = "Username"><br><br>
                    <input type = "text" name = "textEmail" placeholder = "Email"><br><br>
                    <input type = "text" name = "textPoneNumber" placeholder = "PoneNumber"><br><br>
                    <input type = "text" name = "textFullName" placeholder = "Full Name"><br><br>
                    <input type = "text" name = "textPassword" placeholder = "New password"><br><br>
                    <input type = "text" name = "textCPassword" placeholder = "Confirm your password"><br><br>
                    <p>People who use our service may have uploaded your contact information to Instagram.</p>
                    <p>By signing up, you agree to our Terms, Privacy Policy and Cookies Policy.</p><br>
                    <button class = "btn">Sign Up</button>
                </form>
            </div>
        </body>
            """;

        
      

        // // DO NOT MODIFY THIS
        // // Makes Javalin render the webpage
        context.html(html);
    }

}
