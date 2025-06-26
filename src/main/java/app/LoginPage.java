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
public class LoginPage implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/LoginPage.html";

    @Override
    public void handle(Context context) throws Exception {
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
                <a href='mission.html'>Our Mission</a>
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
        <body>
            <div class = "main-content">
                <div class = "login-box">
                    <form method="post" action="/LoginInPage.html">
                        <img src = "cat.png" alt = "icon" class = "logo-icon" /><br><br>
                        <input type = "text" name = "textUsername" placeholder = "Username" required><br>
                        <input type = "text" name = "textPassword" placeholder = "Password" required><br>
                        <p class = "question">
                            Forgot password?
                        </p>
                        <button type = "submit" class = "login-btn">Login In</button>
                    </form>

                    <div class = "login-link">
                        <p>Don't have an account?<a href = "SignUpPage.URL">Sign up</a></p>
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
