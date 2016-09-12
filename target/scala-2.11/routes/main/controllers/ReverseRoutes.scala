
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/vhugo/apps/fileManager/conf/routes
// @DATE:Sun Sep 11 12:13:23 BRT 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:32
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def at(): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/html"), ("file", "index.html")))
      Call("GET", _prefix)
    }
  
    // @LINE:32
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def auth(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/auth")
    }
  
    // @LINE:6
    def getUsers(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users")
    }
  
    // @LINE:7
    def getUser(username:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)))
    }
  
    // @LINE:10
    def logout(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/logout")
    }
  
    // @LINE:8
    def postUser(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/user")
    }
  
    // @LINE:9
    def login(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/login")
    }
  
  }

  // @LINE:20
  class ReverseFileController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def putFile(username:String, id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/file/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:22
    def getFile(username:String, id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/file/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:20
    def postArchive(username:String, id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/root/" + implicitly[PathBindable[Integer]].unbind("id", id) + "/archive")
    }
  
  }

  // @LINE:14
  class ReverseFolderController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def getFolder(username:String, id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/root/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:16
    def postFolder(username:String, id:Integer, name:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/root/" + implicitly[PathBindable[Integer]].unbind("id", id) + "/folder/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
    }
  
    // @LINE:17
    def putFolder(username:String, id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/root/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:15
    def getRoot(username:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/root")
    }
  
  }

  // @LINE:25
  class ReverseShareController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def postShare(username:String, id:Integer, friend:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/file/" + implicitly[PathBindable[Integer]].unbind("id", id) + "/share/" + implicitly[PathBindable[String]].unbind("friend", dynamicString(friend)))
    }
  
    // @LINE:26
    def getMyShared(username:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/myshare")
    }
  
    // @LINE:25
    def getShared(username:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/shared")
    }
  
  }


}
