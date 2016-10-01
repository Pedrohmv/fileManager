package DAO.tables;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import models.User;
import play.libs.Json;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private List<User> users;
    ObjectMapper mapper = new ObjectMapper();
    private ArrayNode usersNode;

    public UserTable(){
        users = new ArrayList();
        usersNode = mapper.createArrayNode();
    }
    public User searchUserByUsername(String username){
        for (User u : users) {
            String name = u.getUsername();
            if(name.equals(username))
                return u;
        }
        User nullUser = null;
        return nullUser;
    }

    public User searchUserByEmail(String email){
        for (User u : users) {
            String name = u.getEmail();
            if(name.equals(email))
                return u;
        }
        User nullUser = null;
        return nullUser;
    }

    public User searchUser(String email, String password){
        User user = searchUserByEmail(email);
        if(user.getPassword().equals(password))
            return user;
        return user;
    }

    public List<User> getAll(){
        return this.users;
    }

    public void add(User user){
        users.add(user);
    }

    public JsonNode getUsersNode(){
        return loadUser();
    }

    public void saveUser(JsonNode user){
        this.usersNode = loadUser();
        try (FileWriter file = new FileWriter("./bd/users.json")) {
            BufferedWriter writerFile = new BufferedWriter(file);
            this.usersNode.add(user);
            writerFile.write(usersNode.toString());
            writerFile.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private ArrayNode loadUser(){
        usersNode.removeAll();
        try (FileReader file = new FileReader("./bd/users.json")) {
            BufferedReader readFile = new BufferedReader(file);
            JsonNode json = mapper.readTree(readFile.readLine());

            for(JsonNode j: json)
                usersNode.add(j);
            readFile.close();
            return this.usersNode;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public JsonNode searchUserNode(String username){
        this.usersNode = loadUser();
        for(int i = 0; i < this.usersNode.size(); i++) {
            JsonNode user = this.usersNode.get(0);
            if(user.get("username").asText().equals(username))
                return user;
        }

        return Json.toJson(new User("null", "null", "null"));
    }

}
