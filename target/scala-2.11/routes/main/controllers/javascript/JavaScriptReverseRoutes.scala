
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/vhugo/apps/fileManager/conf/routes
// @DATE:Thu Aug 25 08:36:23 BRT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:24
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:24
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

  
    // @LINE:11
    def auth: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.auth",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/auth"})
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
  
    // @LINE:7
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUser",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0))})
        }
      """
    )
  
    // @LINE:10
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.logout",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/logout"})
        }
      """
    )
  
    // @LINE:8
    def postUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.postUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user"})
        }
      """
    )
  
    // @LINE:9
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/login"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseArchiveController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def postArchive: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ArchiveController.postArchive",
      """
        function(username0,id1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/root/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id1) + "/archive"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseFolderController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def getFolder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FolderController.getFolder",
      """
        function(username0,id1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/root/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id1)})
        }
      """
    )
  
    // @LINE:16
    def postFolder: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FolderController.postFolder",
      """
        function(username0,id1,name2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/root/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id1) + "/folder/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name2))})
        }
      """
    )
  
    // @LINE:15
    def getRoot: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FolderController.getRoot",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username0)) + "/root"})
        }
      """
    )
  
  }


}
