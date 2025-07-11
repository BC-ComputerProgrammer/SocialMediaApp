package app.controllers;

import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ProfilePage implements Handler {

    public static final String URL = "/api/profile";

    @Override
    public void handle(Context ctx) throws Exception {

        String username = ctx.sessionAttribute("user");
        if(username == null){
            ctx.redirect(LoginPage.URL);
            return;
        } 

        ctx.json(Map.of(
        "username", username,
        "bio", "Hello! I love reading, skiing and coding. My dream is to win a lottery and travel around the world!"
        ));
        
    }
    
}
