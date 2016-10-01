package controllers;


import DAO.DataBase;
import DAO.tables.TokenTable;
import DAO.tables.UserTable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Token;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static mylib.MyResults.conflict;

public class UserController extends Controller {

    private DataBase db = DataBase.getDataBase();
    private UserTable users = db.getUsers();
    private TokenTable tokens = db.getTokens();
    private User userLogin;
    private final int N_PARAMS_CREATE_USER = 3;
    private final int N_PARAMS_LOGIN = 2;
    private final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    public Result getUsers() {
        return ok(Json.toJson(users.getAll()));
    }
    public Result getUsersNode() {
        return ok(users.getUsersNode());
    }

    public Result getUserNode(String username) {
        return ok(users.searchUserNode(username));
    }

    public Result postUserNode(String username) {
        JsonNode payload = request().body().asJson();

        if(!validateUser(payload))
            return badRequest("400");

        String name = payload.get("username").asText();
        String email = payload.get("email").asText();
        String password = payload.get("password").asText();

        if  (isRegistered(name) || isRegistered(email))
            return conflict("209");

        User newUser = new User(name,email,password);
        users.saveUser(Json.toJson(newUser));
        return ok(users.searchUserNode(username));
    }























    public Result getUser(String username) {
        User user = users.searchUserByUsername(username);
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

        User newUser = new User(name,email,password);
        users.add(newUser);
        return created("201");
    }

    public Result login(){
        JsonNode payload = request().body().asJson();
        if(!validateLogin(payload))
            return badRequest("400");

        String email = payload.get("email").textValue();
        String password = payload.get("password").textValue();
        userLogin = users.searchUser(email, password);
        Token token = new Token(userLogin);
        tokens.add(token);

        return ok(Json.toJson(token));
    }

    public Result logout(){
        User nullUser = null;
        userLogin = nullUser;
        return ok("200");
    }

    public Result auth(){
        JsonNode payload = request().body().asJson();
        int token = payload.get("token").asInt();
        Token userSession = tokens.getToken(token);

        if(userSession != null)
            return ok("true");
        else
            return ok("false");
    }

    private boolean validateLogin(JsonNode payload){
        if(!validatePayload(payload, N_PARAMS_LOGIN))
            return false;

        JsonNode param1 = payload.get("email");
        JsonNode param2 = payload.get("password");

        if (param1 == null || param2 == null)
            return false;
        return true;
    }

    private boolean validateUser(JsonNode payload) {
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

    private boolean validatePayload(JsonNode payload, int nParams){
        ObjectNode nullLogin = Json.newObject();
        if (payload == null)
            return false;
        else if (payload.equals(nullLogin))
            return false;
        else if (payload.size() != nParams)
            return  false;
        return true;
    }

    private boolean isRegistered(String key) {
        User user;
        user = users.searchUserByUsername(key);
        if (user != null)
            return true;

        user = users.searchUserByEmail(key);
        if (user != null)
            return  true;
        return false;
    }




}
