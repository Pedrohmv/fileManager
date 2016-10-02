package models;

import DAO.DataBase;
import DAO.tables.FolderTable;

import java.util.ArrayList;
import java.util.List;

public class User {
    private DataBase dataBase = DataBase.getDataBase();
    private FolderTable folders = dataBase.getFolders();
    private String username;
    private String email;
    private String password;
    private int root;
    private List<Share> shareArea;
    private List<Connection> connections;

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        this.root = folders.createRoot();
        this.shareArea = new ArrayList();
        this.connections = new ArrayList();
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoot() {
        return root;
    }

    public List<Share> getShareArea() {
        return shareArea;
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
