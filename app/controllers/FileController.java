package controllers;

import DAO.DataBase;
import DAO.tables.FileTable;
import DAO.tables.FolderTable;
import DAO.tables.UserTable;
import com.fasterxml.jackson.databind.JsonNode;
import models.File;
import models.Folder;
import models.User;
import play.libs.Json;
import play.mvc.Result;

import java.util.List;

import static mylib.MyResults.conflict;
import static play.mvc.Controller.request;
import static play.mvc.Results.notFound;
import static play.mvc.Results.ok;


public class FileController {

    private DataBase db = DataBase.getDataBase();
    private UserTable users = db.getUsers();
    private FolderTable folders = db.getFolders();
    private FileTable files = db.getFiles();

    public Result postArchive(String username, int id){
        JsonNode payload = request().body().asJson();
        String title = payload.get("title").asText();
        String content = payload.get("content").asText();

        User user = users.searchUserByUsername(username);
        if (user != null) {
            Folder folder = folders.searchFolder(user.getRoot(), id);
            if (folder == null)
                return null;

            File newFile = new File(title, content);
            List<File> files = folder.getFiles();
            for(File a : files)
                if(a.getName().equals(title))
                    return conflict("409");

            folder.getFiles().add(newFile);
            return ok(Json.toJson(newFile));
        }
        return notFound("404");
    }

    public Result getFile(String username, int id){
        User user = users.searchUserByUsername(username);
        Folder root = user.getRoot();
        File file = files.getFile(user.getRoot(), id);

        if(file != null)
            return ok(Json.toJson(file));
        return notFound("404");
    }

    public Result putFile(String username, int id){
        JsonNode payload = request().body().asJson();
        String title = payload.get("name").asText();
        String content = payload.get("content").asText();

        User user = users.searchUserByUsername(username);
        File file = files.getFile(user.getRoot(), id);

        file.setName(title);
        file.setContent(content);

        return ok(Json.toJson(file));
    }
}
