package controllers;

import DAO.DataBase;
import DAO.tables.FolderTable;
import DAO.tables.UserTable;
import com.fasterxml.jackson.databind.JsonNode;
import models.Folder;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static mylib.MyResults.conflict;

public class FolderController extends Controller {

    private DataBase db = DataBase.getDataBase();
    private UserTable users = db.getUsers();
    private FolderTable folders = db.getFolders();

    public Result getFolder(String username, int id) {
        User user = users.searchUserByUsername(username);
        if (user != null) {
            Folder folder = folders.searchFolder(user.getRoot(), id);
            if (folder == null)
                return notFound("404");
            return ok(Json.toJson(folder));
        }
        return notFound("404");
    }

    public Result getRoot(String username) {
        User user = users.searchUserByUsername(username);
        if (user != null) {
            return ok(Json.toJson(user.getRoot()));
        }
        return notFound("404");
    }

    public Result postFolder(String username, int id, String name){
        User user = users.searchUserByUsername(username);
        if (user != null) {
            Folder folder = folders.searchFolder(user.getRoot(), id);
            if (folder == null)
                return null;

            Folder newFolder = new Folder(name);
            List<Folder> inFolder = folder.getInFolder();
            for(Folder f : inFolder) {
                if (f.getName().equals(name))
                    return conflict("409");
            }

            folder.getInFolder().add(newFolder);
            return ok(Json.toJson(newFolder));
        }
        return notFound("404");
    }

    public Result putFolder(String username, int id){
        JsonNode payload = request().body().asJson();
        String name = payload.get("name").asText();

        User user = users.searchUserByUsername(username);
        Folder folder = folders.searchFolder(user.getRoot(), id);
        folder.setName(name);

        return ok(Json.toJson(folder));
    }
}
