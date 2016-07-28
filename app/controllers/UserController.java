package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import java.util.ArrayList;
import java.util.List;
import views.html.*;

public class UserController extends Controller {

    private List<JsonNode> users = new ArrayList();
    private JsonNode userLogin = Json.newObject();


    public Result getUsers() {
        return ok(Json.toJson(users));
    }

    public Result getUser(String username) {
        JsonNode user = searchUser(username);
        return ok(user);
    }

    public Result postUser(){
        //ObjectNode newUser = Json.newObject();
         JsonNode newUser = request().body().asJson();

        /*DynamicForm form = Form.form().bindFromRequest();
        newUser.put("username",form.get("username"));
        newUser.put("email",form.get("email"));
        newUser.put("password",form.get("password"));*/
        users.add(newUser);
        return ok("200");

    }

    public Result login(){
        JsonNode user = request().body().asJson();
        String email = user.get("email").textValue();
        String password = user.get("password").textValue();
        userLogin = searchUser(email, password);
        return ok(userLogin);
    }

    public Result logout(){
        JsonNode nullUser = Json.newObject();
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



    private JsonNode searchUser(String username){
        for (JsonNode u : users) {
            String name = u.get("username").asText();
            if(name.equals(username))
                return u;
        }
        JsonNode nullUser = Json.newObject();
        return nullUser;
    }
    
    private JsonNode searchUser(String email, String password){
        for (JsonNode u : users) {
            String em = u.get("email").asText();
            String pwd = u.get("password").asText();
            
            if(em.equals(email) && pwd.equals(password))
                return u;
        }
        JsonNode nullUser = Json.newObject();
        return nullUser;
    }


}
