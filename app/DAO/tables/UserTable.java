package DAO.tables;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class UserTable extends SuperTable {
    private static ObjectMapper  mapper = new ObjectMapper();
    private static ArrayNode usersNode = mapper.createArrayNode();

    public UserTable(){
        super("users", usersNode, mapper);
    }

    public JsonNode getAll(){
        return super.loadUser();
    }

    public JsonNode get(String value){
        JsonNode user =  super.search("username", value);
        if (user.get("username").asText().equals("null"))
            return super.search("email", value);
        return user;
    }

    public void add(JsonNode user){
        this.usersNode.add(user);
        super.updateBd();
    }

    public void remove(String username){
        this.usersNode.remove(searchUserIndex(username));
        super.updateBd();
    }

    private int searchUserIndex(String username){
        return super.searchIndex("username", username);
    }
}
