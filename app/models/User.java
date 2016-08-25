package models;

import DAO.DataBase;

public class User {
    private DataBase dataBase = DataBase.getDataBase();
    private String username;
    private String email;
    private String password;
    private Folder root;

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        this.root = new Folder("Root");
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

    public Folder getRoot() {
        return root;
    }
}
