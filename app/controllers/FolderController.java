package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class FolderController extends Controller {

    public Result getFolders(String username) {
        return ok("todo");
    }

    public Result getRoot(String username) {
        return ok("todo");
    }
}
