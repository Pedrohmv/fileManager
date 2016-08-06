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

    private static List<User> users = new ArrayList();
    private static User userLogin;
    private static final int N_PARAMS_CREATE_USER = 3;
    private static final int N_PARAMS_LOGIN = 2;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public Result getUsers() {
        return ok(Json.toJson(users));
    }

    public Result getUser(String username) {
        User user = searchUserByUsername(username);
        if (user == null)
            return notFound("404");
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

    public Result login(){
        JsonNode payload = request().body().asJson();
        if(!validateLogin(payload))
            return badRequest("400");

        String email = payload.get("email").textValue();
        String password = payload.get("password").textValue();
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

    protected static boolean validateLogin(JsonNode payload){
        if(!validatePayload(payload, N_PARAMS_LOGIN))
            return false;

        JsonNode param1 = payload.get("email");
        JsonNode param2 = payload.get("password");

        if (param1 == null || param2 == null)
            return false;
        return true;
    }

    protected static boolean validateUser(JsonNode payload) {
        if(!validatePayload(payload, N_PARAMS_CREATE_USER))
            return false;

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

    private static boolean validatePayload(JsonNode payload, int nParams){
        ObjectNode nullLogin = Json.newObject();
        if (payload == null)
            return false;
        else if (payload.equals(nullLogin))
            return false;
        else if (payload.size() != nParams)
            return  false;
        return true;
    }

    protected static  boolean isRegistered(String key) {
        User user;

        user = searchUserByUsername(key);
        if (user != null)
            return true;

        user = searchUserByEmail(key);
        if (user != null)
            return  true;

        return false;
    }

    protected static User searchUserByUsername(String username){
        for (User u : users) {
            String name = u.getUsername();
            if(name.equals(username))
                return u;
        }
        User nullUser = null;
        return nullUser;
    }

    protected static User searchUserByEmail(String email){
        for (User u : users) {
            String name = u.getEmail();
            if(name.equals(email))
                return u;
        }
        User nullUser = null;
        return nullUser;
    }
    
    protected static User searchUser(String email, String password){
        User user = searchUserByEmail(email);
        if(user.getPassword().equals(password))
            return user;
        return user;
    }


}
