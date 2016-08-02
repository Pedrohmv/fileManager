package controllers;

import models.Archive;
import models.Folder;
import models.User;
import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Results.notFound;
import static play.mvc.Results.ok;


public class ArchiveController {

    public Result postArchive(String username, int id, String name){
        User user = controllers.UserController.searchUserByUsername(username);
        if (user != null) {
            Folder folder = FolderController.searchFolder(user.getRoot(), id);
            if (folder == null)
                return null;
            Archive newArchive = new Archive(name);
            folder.getFiles().add(newArchive);
            return ok(Json.toJson(newArchive));
        }
        return notFound("404");
    }
}
