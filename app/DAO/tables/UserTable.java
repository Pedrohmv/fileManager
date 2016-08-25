package DAO.tables;


import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private List<User> users;

    public UserTable(){
        users = new ArrayList();
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
}
