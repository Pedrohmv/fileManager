package controllers;

import models.Archive;
import models.Folder;
import models.User;
import play.libs.Json;
import play.mvc.Result;

import java.util.List;

import static mylib.MyResults.conflict;
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
            List<Archive> files = folder.getFiles();
            for(Archive a : files)
                if(a.getName().equals(name))
                    return conflict("409");

            folder.getFiles().add(newArchive);
            return ok(Json.toJson(newArchive));
        }
        return notFound("404");
    }
}
