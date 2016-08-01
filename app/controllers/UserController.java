package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static mylib.MyResults.conflict;

public class UserController extends Controller {

    private List<User> users = new ArrayList();
    private User userLogin;
    private final int N_PARAMS = 3;
    private final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    public Result getUsers() {
        return ok(Json.toJson(users));
    }

    public Result getUser(String username) {
        User user = searchUserByUsername(username);
        return ok(Json.toJson(user));
    }

    public Result postUser(){
        JsonNode payload = request().body().asJson();

        if(!validateUser(payload))
            return badRequest("400");


        String name = payload.get("username").asText();
        String email = payload.get("email").asText();
        String password = payload.get("password").asText();

        if  (isRegistered(name) || isRegistered(email))
            return conflict("209");

        users.add(new User(name,email,password));
        return created("201");


    }


    private boolean validateUser(JsonNode payload) {
        ObjectNode nullUser = Json.newObject();
        if (payload == null)
            return false;
        else if (payload.equals(nullUser))
            return false;
        else if (payload.size() != N_PARAMS)
            return  false;

        JsonNode param1 = payload.get("username");
        JsonNode param2 = payload.get("email");
        JsonNode param3 = payload.get("password");

        if (param1 == null || param2 == null || param3 == null)
            return false;

        String email = payload.get("email").asText();
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if(!matcher.find())
            return false;

        return true;
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
        if(userLogin == null)
            return ok("false");
        else
            return ok("true");
    }

    private boolean isRegistered(String key) {
        User user;

        user = searchUserByUsername(key);
        if (user != null)
            return true;

        user = searchUserByEmail(key);
        if (user != null)
            return  true;

        return false;
    }



    private User searchUserByUsername(String username){
        for (User u : users) {
            String name = u.getUsername();
            if(name.equals(username))
                return u;
        }
        User nullUser = null;
        return nullUser;
    }

    private User searchUserByEmail(String email){
        for (User u : users) {
            String name = u.getEmail();
            if(name.equals(email))
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
