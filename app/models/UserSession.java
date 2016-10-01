package models;

import java.util.List;


public class UserSession {
    private String username;
    private String email;
    private Folder root;
    private List<Share> shareArea;
    private List<Connection> connections;

    public UserSession(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.root = user.getRoot();
        this.shareArea = user.getShareArea();
        this.connections = user.getConnections();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Folder getRoot() {
        return root;
    }

    public List<Share> getShareArea() {
        return shareArea;
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
