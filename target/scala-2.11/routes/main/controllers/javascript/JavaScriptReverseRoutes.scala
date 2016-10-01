
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/vhugo/apps/fileManager/conf/routes
// @DATE:Sat Oct 01 14:24:00 BRT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:34
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:34
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def auth: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.auth",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/auth"})
        }
      """
    )
  
    // @LINE:9
    def getUserNode: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUserNode",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/usersNode/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0))})
        }
      """
    )
  
    // @LINE:7
    def getUsersNode: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUsersNode",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/usersNode"})
        }
      """
    )
  
    // @LINE:6
    def getUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users"})
        }
      """
    )
  
    // @LINE:8
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUser",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0))})
        }
      """
    )
  
    // @LINE:12
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.logout",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/logout"})
        }
      """
    )
  
    // @LINE:10
    def postUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.postUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user"})
        }
      """
    )
  
    // @LINE:11
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/login"})
        }
      """
    )
  
  }

  // @LINE:22
  class ReverseFileController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def putFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FileController.putFile",
      """
        function(username0,id1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/file/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id1)})
        }
      """
    )
  
    // @LINE:24
    def getFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FileController.getFile",
      """
        function(username0,id1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/file/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id1)})
        }
      """
    )
  
    // @LINE:22
    def postArchive: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FileController.postArchive",
      """
        function(username0,id1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/root/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id1) + "/archive"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseFolderController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getFolder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FolderController.getFolder",
      """
        function(username0,id1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/root/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id1)})
        }
      """
    )
  
    // @LINE:18
    def postFolder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FolderController.postFolder",
      """
        function(username0,id1,name2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/root/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id1) + "/folder/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name2))})
        }
      """
    )
  
    // @LINE:19
    def putFolder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FolderController.putFolder",
      """
        function(username0,id1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/root/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id1)})
        }
      """
    )
  
    // @LINE:17
    def getRoot: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FolderController.getRoot",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/root"})
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseShareController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def postShare: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShareController.postShare",
      """
        function(username0,id1,friend2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/file/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id1) + "/share/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("friend", encodeURIComponent(friend2))})
        }
      """
    )
  
    // @LINE:28
    def getMyShared: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShareController.getMyShared",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/myshare"})
        }
      """
    )
  
    // @LINE:27
    def getShared: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ShareController.getShared",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/shared"})
        }
      """
    )
  
  }


}
