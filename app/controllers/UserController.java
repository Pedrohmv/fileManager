package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import java.util.ArrayList;
import java.util.List;
import views.html.*;

public class UserController extends Controller {

    private List<User> users = new ArrayList();
    private User userLogin;


    public Result getUsers() {
        return ok(Json.toJson(users));
    }

    public Result getUser(String username) {
        User user = searchUser(username);
        return ok(Json.toJson(user));
    }

    public Result postUser(){
        JsonNode payload = request().body().asJson();

        String name = payload.get("username").asText();
        String email = payload.get("email").asText();
        String password = payload.get("password").asText();
        users.add(new User(name,email,password));
        return ok("200");

    }

    public Result login(){
        JsonNode user = request().body().asJson();
        String email = user.get("email").textValue();
        String password = user.get("password").textValue();
        userLogin = searchUser(email, password);
        return ok(Json.toJson(userLogin));
    }

    public Result logout(){
        User nullUser = null;
        userLogin = nullUser;
        return ok("200");
    }


    public Result auth(){
        JsonNode nullUser = Json.newObject();
        if(userLogin.equals(nullUser))
            return ok("false");
        else
            return ok("true");
    }



    private User searchUser(String username){
        for (User u : users) {
            String name = u.getUsername();
            if(name.equals(username))
                return u;
        }
        User nullUser = null;
        return nullUser;
    }
    
    private User searchUser(String email, String password){
        for (User u : users) {
            String em = u.getEmail();
            String pwd = u.getPassword();
            
            if(em.equals(email) && pwd.equals(password))
                return u;
        }
        User nullUser = null;
        return nullUser;
    }


}
