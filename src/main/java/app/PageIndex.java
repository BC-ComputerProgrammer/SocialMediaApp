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
 * @editor David Eccles, 2025. email: david.eccles@rmit.edu.au
 */
public class PageIndex implements Handler {

    // URL of this page relative to http://localhost:7002/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Homepage</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

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
                <h1>
                    <img src='logo.png' class='top-image' alt='RMIT logo' height='75'>
                    Homepage
                </h1>
            </div>
        """;

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add HTML for the page content
        html = html + """
            <p>Homepage content</p>
            """;

        // Get the ArrayList of Strings of all FLAGs
        // ArrayList<String> flagNames = getFlags();

        // Add HTML for the FLAG list
        html = html + "<h1>All quality measurement flags in the climate database</h1>" + "<ul>";

        // Finally we can print out all of the FLAGs
        // for (String name : flagNames) {
        //     html = html + "<li>" + name + "</li>";
        // }

        // Finish the List HTML
        html = html + "</ul>";

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

    /**
     * Get the flags and their descriptors from the database.
     */
    // public ArrayList<String> getFlags() {
    //     // Create the ArrayList of FLAG objects to return
    //     ArrayList<String> flags = new ArrayList<String>();

    //     // Setup the variable for the JDBC connection
    //     Connection connection = null;

        // try {
            // Connect to JDBC data base
            //connection = DriverManager.getConnection(JDBCConnection.DATABASE);

            // Prepare a new SQL Query & Set a timeout
            // Statement statement = connection.createStatement();
            // statement.setQueryTimeout(30);

            // The Query
            // String query = "SELECT * FROM FlagQuality";
            
            // // Get Result
            // ResultSet results = statement.executeQuery(query);

            // // Process all of the results
            // while (results.next()) {
            //     String flag  = results.getString("flag");

            //     // Add the flag object to the array
            //     flags.add(flag);
            // }
            // // Close the statement because we are done with it
            // statement.close();
        // } catch (SQLException e) {
            // If there is an error, lets just pring the error
            // System.err.println(e.getMessage());
        // } finally {
        //     // Safety code to cleanup
        //     try {
        //         if (connection != null) {
        //             connection.close();
        //         }
        //     } catch (SQLException e) {
        //         // connection close failed.
        //         System.err.println(e.getMessage());
        //     }
        // }

        // Finally we return all of the flags
        // return flags;
    // }
}
