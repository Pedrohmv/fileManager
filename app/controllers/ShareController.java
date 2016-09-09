package controllers;


import DAO.DataBase;
import DAO.tables.FileTable;
import DAO.tables.UserTable;
import models.Connection;
import models.File;
import models.Share;
import models.User;
import play.libs.Json;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

import static play.mvc.Results.ok;

public class ShareController {
    private DataBase db = DataBase.getDataBase();
    private UserTable users = db.getUsers();
    private FileTable files = db.getFiles();

    public Result postShare(String username, int id, String friendName){
        User user = users.searchUserByUsername(username);
        User friend = users.searchUserByUsername(friendName);
        File file = files.getFile(user.getRoot(), id);

        makeConnection(user, friend);
        Share share = new Share(friend.getUsername(), file);
        user.getShareArea().add(share);

        return ok();
    }

    public Result getShared(String username){
        User user = users.searchUserByUsername(username);

        List<File> aux = new ArrayList();
        for(Connection conn : user.getConnections()){
            if(!conn.getUser().equals(username)) {
                User friend = users.searchUserByUsername(conn.getUser());
                for (Share s: friend.getShareArea()) {
                    if(s.getFriend().equals(username))
                        aux.add(s.getFile());
                }
            }
        }

        return ok(Json.toJson(aux));
    }

    public Result getMyShared(String username){
        User user = users.searchUserByUsername(username);
        return ok(Json.toJson(user.getShareArea()));
    }

    private void sharedMe(Connection conn, List<Share> shareMe){
        User friend = users.searchUserByUsername(conn.getUser());
        for(Share s : friend.getShareArea()){
            if(s.getFriend().equals(conn.getUser()))
                shareMe.add(s);
        }
    }

    private Boolean hasConnection(User user, User friend){
        for(Connection conn : user.getConnections()){
            if(conn.getFriend().equals(friend.getUsername()))
                return true;
        }
        return false;
    }

    private void makeConnection(User user, User friend){
        if(!hasConnection(user,friend)){
            Connection conn = new Connection(user.getUsername(), friend.getUsername());
            user.getConnections().add(conn);
            friend.getConnections().add(conn);
        }
    }
}
