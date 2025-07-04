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
public class Profile implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/Profile.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "<link rel='stylesheet' type='text/css' href='Profile.css' />";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + """
             <div class='topnav'>
                <a href='/'>Homepage</a>
		        <a href='SignUpPage.html'>Sign Up</a>
                <a href="login">Log In</a>
                <a href='Profile.html'>Profile</a>
            </div>
        """;

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>Welcome to Profile page</h1>
            </div>
        """;

        // Add Div for page Content
        html = html + """
        <div class='profile-section'>
        <img src='default-profile-pic.jpg' alt='Profile Picture' class='profile-pic>
        <div class ='username'>JohnDoe
        """;

        // Add HTML for the page content
        html = html + """
            <p>Subtask 2.A page content</p>
            """;

        // Close Content div
        html = html + "</div>";

        // Footer
        html = html + """
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (ACC-Apr2025)</p>
            </div>
        """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
