package app;

import java.sql.SQLException;

import app.controllers.LoginPage;
import app.controllers.SignUpPage;
import app.repositories.UserDaoImpl;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;


/**
 * Main Application Class.
 * <p>
 * Running this class as regular java application will start the 
 * Javalin HTTP Server and our web application.
 *
 */
public class App {

    public static final int         JAVALIN_PORT    = 7001;
    public static final String      CSS_DIR         = "css/";
    public static final String      IMAGES_DIR      = "images/";

    public static void main(String[] args) {
        try {
            UserDaoImpl userDao = new UserDaoImpl();
            userDao.setup();
        } catch (SQLException e) {
            System.err.println("Error setting up");
        }
        
        // Create our HTTP server and listen in port 7000
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));
            config.enableCorsForAllOrigins();
            // Uncomment this if you have files in the CSS Directory
            config.addStaticFiles(CSS_DIR);

            // Uncomment this if you have files in the Images Directory
            config.addStaticFiles(IMAGES_DIR);
        }).start(JAVALIN_PORT);


        // Configure Web Routes
        configureRoutes(app);
    }

    public static void configureRoutes(Javalin app) {
        // All webpages are listed here as GET pages
        // app.get(PageIndex.URL, new PageIndex());
        app.get(SignUpPage.URL, new SignUpPage());

        app.get(LoginPage.URL, new LoginPage());
        // app.get(Profile.URL, new Profile());

        // Add / uncomment POST commands for any pages that need web form POSTS
        // app.post(PageIndex.URL, new PageIndex());
        app.post(SignUpPage.URL, new SignUpPage());

        app.post(LoginPage.URL, new LoginPage());
        // app.post(Profile.URL, new Profile());

        // app.post(PageST2B.URL, new PageST2B());
        // app.post(PageST3A.URL, new PageST3A());
        // app.post(PageST3B.URL, new PageST3B());
    }

}
