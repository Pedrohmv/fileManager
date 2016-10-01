
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/vhugo/apps/fileManager/conf/routes
// @DATE:Sat Oct 01 14:24:00 BRT 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:34
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def at(): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/html"), ("file", "index.html")))
      Call("GET", _prefix)
    }
  
    // @LINE:34
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

  
    // @LINE:13
    def auth(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/auth")
    }
  
    // @LINE:9
    def getUserNode(username:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/usersNode/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)))
    }
  
    // @LINE:7
    def getUsersNode(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/usersNode")
    }
  
    // @LINE:6
    def getUsers(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users")
    }
  
    // @LINE:8
    def getUser(username:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)))
    }
  
    // @LINE:12
    def logout(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/logout")
    }
  
    // @LINE:10
    def postUser(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/user")
    }
  
    // @LINE:11
    def login(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/login")
    }
  
  }

  // @LINE:22
  class ReverseFileController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def putFile(username:String, id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/file/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:24
    def getFile(username:String, id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/file/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:22
    def postArchive(username:String, id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/root/" + implicitly[PathBindable[Integer]].unbind("id", id) + "/archive")
    }
  
  }

  // @LINE:16
  class ReverseFolderController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getFolder(username:String, id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/root/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:18
    def postFolder(username:String, id:Integer, name:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/root/" + implicitly[PathBindable[Integer]].unbind("id", id) + "/folder/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
    }
  
    // @LINE:19
    def putFolder(username:String, id:Integer): Call = {
      import ReverseRouteContext.empty
      Call("PUT", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/root/" + implicitly[PathBindable[Integer]].unbind("id", id))
    }
  
    // @LINE:17
    def getRoot(username:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/root")
    }
  
  }

  // @LINE:27
  class ReverseShareController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def postShare(username:String, id:Integer, friend:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/file/" + implicitly[PathBindable[Integer]].unbind("id", id) + "/share/" + implicitly[PathBindable[String]].unbind("friend", dynamicString(friend)))
    }
  
    // @LINE:28
    def getMyShared(username:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/myshare")
    }
  
    // @LINE:27
    def getShared(username:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users/" + implicitly[PathBindable[String]].unbind("username", dynamicString(username)) + "/shared")
    }
  
  }


}
