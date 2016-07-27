package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import java.util.ArrayList;
import java.util.List;
import views.html.*;

public class UserController extends Controller {

    private List<ObjectNode> users = new ArrayList();


    public Result getUsers() {
        return ok(Json.toJson(users));
    }

    public Result getUser(String username) {
        ObjectNode user = searchUser(username);
        return ok(Json.toJson(user));
    }

    public Result postUser(){
        ObjectNode newUser = Json.newObject();
        DynamicForm form = Form.form().bindFromRequest();
        newUser.put("username",form.get("username"));
        newUser.put("email",form.get("email"));
        newUser.put("password",form.get("password"));
        users.add(newUser);
        return ok("200");

    }
    
    public Result autent(){
        DynamicForm form = Form.form().bindFromRequest();
        ObjectNode user = searchUser(form.get("email"),form.get("password"));
        if(user.get("username") == null)
            return ok(logged.render("não"));
        return ok(logged.render(user.get("username").asText()));
    }

    private ObjectNode searchUser(String username){
        for (ObjectNode u : users) {
            String name = u.get("username").asText();
            if(name.equals(username))
                return u;
        }
        ObjectNode nullUser = Json.newObject();
        return nullUser;
    }
    
    private ObjectNode searchUser(String email, String password){
        for (ObjectNode u : users) {
            String em = u.get("email").asText();
            String pwd = u.get("password").asText();
            
            if(em.equals(email) && pwd.equals(password))
                return u;
        }
        ObjectNode nullUser = Json.newObject();
        return nullUser;
    }


}
