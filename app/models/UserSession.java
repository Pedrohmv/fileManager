package models;

import com.fasterxml.jackson.databind.JsonNode;


public class UserSession {
    private String username;
    private String email;
    private int root;
    private JsonNode shareArea;
    private JsonNode connections;

    public UserSession(JsonNode user){
        this.username = user.get("username").asText();
        this.email = user.get("email").asText();
        this.root = user.get("root").asInt();
        this.shareArea = user.get("shareArea");
        this.connections = user.get("connections");
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getRoot() {
        return root;
    }

    public JsonNode getShareArea() {
        return shareArea;
    }

    public JsonNode getConnections() {
        return connections;
    }
}
