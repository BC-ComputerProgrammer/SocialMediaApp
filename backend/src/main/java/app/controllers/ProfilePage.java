package app.controllers;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ProfilePage implements Handler {

    public static final String URL = "/api/login";

    @Override
    public void handle(Context ctx) throws Exception {
        String username = ctx.sessionAttribute("user");
        if(username == null) ctx.redirect(LoginPage.URL);

        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }
    
}
