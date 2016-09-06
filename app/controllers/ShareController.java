package controllers;


import DAO.DataBase;
import DAO.tables.FileTable;
import DAO.tables.UserTable;
import models.User;
import play.mvc.Result;

import static play.mvc.Results.ok;

public class ShareController {
    private DataBase db = DataBase.getDataBase();
    private UserTable users = db.getUsers();
    private FileTable files = db.getFiles();

    public Result postShare(String username, int id, String friendName){
        User user = users.searchUserByUsername(username);
        User friend = users.searchUserByUsername(friendName);
        return ok();
    }
}
