
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Thales/Documents/FileManager/fileManager/conf/routes
// @DATE:Fri Sep 09 21:11:47 GFT 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFileController FileController = new controllers.ReverseFileController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFolderController FolderController = new controllers.ReverseFolderController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseShareController ShareController = new controllers.ReverseShareController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFileController FileController = new controllers.javascript.ReverseFileController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFolderController FolderController = new controllers.javascript.ReverseFolderController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseShareController ShareController = new controllers.javascript.ReverseShareController(RoutesPrefix.byNamePrefix());
  }

}
