package controllers;

import models.Folder;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static mylib.MyResults.conflict;

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

    protected static Folder searchFolder(Folder root, int id) {
        if(root.getId() == id)
            return  root;
        else if(root.getInFolder().size() == 0)
            return null;

        for(Folder f : root.getInFolder()){
            if(f.getId() == id)
                return f;
        }

        Folder auxFolder = null;
        for(Folder f : root.getInFolder()){
            auxFolder = searchFolder(f, id);
            if(auxFolder != null && auxFolder.getId() == id)
                return auxFolder;
        }

        /*for(int i = 0; i < root.getInFolder().size(); i++){
            if(root.getInFolder().get(i).getId() == id)
                return root.getInFolder().get(i);
        }*/

        /*Folder auxFolder = null;
        for(int i = 0; i < root.getInFolder().size(); i++){
            auxFolder = searchFolder(root.getInFolder().get(i), id);
        }*/
        return auxFolder;
    }
}
