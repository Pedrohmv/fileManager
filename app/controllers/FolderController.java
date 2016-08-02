package controllers;

import models.Folder;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;



public class FolderController extends Controller {

    public Result getFolder(String username, int id) {
        User user = controllers.UserController.searchUserByUsername(username);
        if (user != null) {
            Folder folder = searchFolder(user.getRoot(), id);
            if (folder == null)
                return notFound("404");
            return ok(Json.toJson(folder));
        }
        return notFound("404");
    }

    public Result getRoot(String username) {
        User user = controllers.UserController.searchUserByUsername(username);
        if (user != null) {
            return ok(Json.toJson(user.getRoot()));
        }
        return notFound("404");
    }

    public Result postFolder(String username, int id, String name){
        User user = controllers.UserController.searchUserByUsername(username);
        if (user != null) {
            Folder folder = searchFolder(user.getRoot(), id);
            if (folder == null)
                return null;
            Folder newFolder = new Folder(name);
            folder.getInFolder().add(newFolder);
            return ok(Json.toJson(newFolder));
        }
        return notFound("404");
    }

    private Folder searchFolder(Folder root, int id) {
        if(root.getId() == id)
            return  root;
        else if(root.getInFolder().size() == 0)
            return null;

        for(int i = 0; i < root.getInFolder().size(); i++){
            if(root.getInFolder().get(i).getId() == id)
                return root.getInFolder().get(i);
        }

        Folder auxFolder = null;
        for(int i = 0; i < root.getInFolder().size(); i++){
            auxFolder = searchFolder(root.getInFolder().get(i), id);
        }
        return auxFolder;
    }
}
