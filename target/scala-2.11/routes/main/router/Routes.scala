
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/vhugo/apps/fileManager/conf/routes
// @DATE:Sat Oct 01 14:24:00 BRT 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  UserController_1: controllers.UserController,
  // @LINE:16
  FolderController_2: controllers.FolderController,
  // @LINE:22
  FileController_4: controllers.FileController,
  // @LINE:27
  ShareController_0: controllers.ShareController,
  // @LINE:34
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    UserController_1: controllers.UserController,
    // @LINE:16
    FolderController_2: controllers.FolderController,
    // @LINE:22
    FileController_4: controllers.FileController,
    // @LINE:27
    ShareController_0: controllers.ShareController,
    // @LINE:34
    Assets_3: controllers.Assets
  ) = this(errorHandler, UserController_1, FolderController_2, FileController_4, ShareController_0, Assets_3, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_1, FolderController_2, FileController_4, ShareController_0, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users""", """controllers.UserController.getUsers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/usersNode""", """controllers.UserController.getUsersNode"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>""", """controllers.UserController.getUser(username:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/usersNode/""" + "$" + """username<[^/]+>""", """controllers.UserController.getUserNode(username:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user""", """controllers.UserController.postUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/login""", """controllers.UserController.login"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/logout""", """controllers.UserController.logout"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/auth""", """controllers.UserController.auth"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>""", """controllers.FolderController.getFolder(username:String, id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/root""", """controllers.FolderController.getRoot(username:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>/folder/""" + "$" + """name<[^/]+>""", """controllers.FolderController.postFolder(username:String, id:Integer, name:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>""", """controllers.FolderController.putFolder(username:String, id:Integer)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>/archive""", """controllers.FileController.postArchive(username:String, id:Integer)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/file/""" + "$" + """id<[^/]+>""", """controllers.FileController.putFile(username:String, id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/file/""" + "$" + """id<[^/]+>""", """controllers.FileController.getFile(username:String, id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/shared""", """controllers.ShareController.getShared(username:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/myshare""", """controllers.ShareController.getMyShared(username:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/file/""" + "$" + """id<[^/]+>/share/""" + "$" + """friend<[^/]+>""", """controllers.ShareController.postShare(username:String, id:Integer, friend:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix, """controllers.Assets.at(path:String = "/public/html", file:String = "index.html")"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_UserController_getUsers0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users")))
  )
  private[this] lazy val controllers_UserController_getUsers0_invoker = createInvoker(
    UserController_1.getUsers,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUsers",
      Nil,
      "GET",
      """---------------------------------- API --------------------------------------------------
User""",
      this.prefix + """api/users"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_UserController_getUsersNode1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/usersNode")))
  )
  private[this] lazy val controllers_UserController_getUsersNode1_invoker = createInvoker(
    UserController_1.getUsersNode,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUsersNode",
      Nil,
      "GET",
      """""",
      this.prefix + """api/usersNode"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_UserController_getUser2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser2_invoker = createInvoker(
    UserController_1.getUser(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUser",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_getUserNode3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/usersNode/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUserNode3_invoker = createInvoker(
    UserController_1.getUserNode(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUserNode",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/usersNode/""" + "$" + """username<[^/]+>"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserController_postUser4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user")))
  )
  private[this] lazy val controllers_UserController_postUser4_invoker = createInvoker(
    UserController_1.postUser,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "postUser",
      Nil,
      "POST",
      """""",
      this.prefix + """api/user"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_login5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/login")))
  )
  private[this] lazy val controllers_UserController_login5_invoker = createInvoker(
    UserController_1.login,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "login",
      Nil,
      "POST",
      """""",
      this.prefix + """api/login"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_logout6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/logout")))
  )
  private[this] lazy val controllers_UserController_logout6_invoker = createInvoker(
    UserController_1.logout,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "logout",
      Nil,
      "POST",
      """""",
      this.prefix + """api/logout"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserController_auth7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/auth")))
  )
  private[this] lazy val controllers_UserController_auth7_invoker = createInvoker(
    UserController_1.auth,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "auth",
      Nil,
      "POST",
      """""",
      this.prefix + """api/auth"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_FolderController_getFolder8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/root/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FolderController_getFolder8_invoker = createInvoker(
    FolderController_2.getFolder(fakeValue[String], fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FolderController",
      "getFolder",
      Seq(classOf[String], classOf[Integer]),
      "GET",
      """Folder""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_FolderController_getRoot9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/root")))
  )
  private[this] lazy val controllers_FolderController_getRoot9_invoker = createInvoker(
    FolderController_2.getRoot(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FolderController",
      "getRoot",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>/root"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_FolderController_postFolder10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/root/"), DynamicPart("id", """[^/]+""",true), StaticPart("/folder/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FolderController_postFolder10_invoker = createInvoker(
    FolderController_2.postFolder(fakeValue[String], fakeValue[Integer], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FolderController",
      "postFolder",
      Seq(classOf[String], classOf[Integer], classOf[String]),
      "GET",
      """""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>/folder/""" + "$" + """name<[^/]+>"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_FolderController_putFolder11_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/root/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FolderController_putFolder11_invoker = createInvoker(
    FolderController_2.putFolder(fakeValue[String], fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FolderController",
      "putFolder",
      Seq(classOf[String], classOf[Integer]),
      "PUT",
      """""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_FileController_postArchive12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/root/"), DynamicPart("id", """[^/]+""",true), StaticPart("/archive")))
  )
  private[this] lazy val controllers_FileController_postArchive12_invoker = createInvoker(
    FileController_4.postArchive(fakeValue[String], fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FileController",
      "postArchive",
      Seq(classOf[String], classOf[Integer]),
      "POST",
      """File""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>/archive"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_FileController_putFile13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/file/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FileController_putFile13_invoker = createInvoker(
    FileController_4.putFile(fakeValue[String], fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FileController",
      "putFile",
      Seq(classOf[String], classOf[Integer]),
      "PUT",
      """""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>/file/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_FileController_getFile14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/file/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FileController_getFile14_invoker = createInvoker(
    FileController_4.getFile(fakeValue[String], fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FileController",
      "getFile",
      Seq(classOf[String], classOf[Integer]),
      "GET",
      """""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>/file/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_ShareController_getShared15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/shared")))
  )
  private[this] lazy val controllers_ShareController_getShared15_invoker = createInvoker(
    ShareController_0.getShared(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShareController",
      "getShared",
      Seq(classOf[String]),
      "GET",
      """Share""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>/shared"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_ShareController_getMyShared16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/myshare")))
  )
  private[this] lazy val controllers_ShareController_getMyShared16_invoker = createInvoker(
    ShareController_0.getMyShared(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShareController",
      "getMyShared",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>/myshare"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_ShareController_postShare17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/file/"), DynamicPart("id", """[^/]+""",true), StaticPart("/share/"), DynamicPart("friend", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ShareController_postShare17_invoker = createInvoker(
    ShareController_0.postShare(fakeValue[String], fakeValue[Integer], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ShareController",
      "postShare",
      Seq(classOf[String], classOf[Integer], classOf[String]),
      "GET",
      """""",
      this.prefix + """api/users/""" + "$" + """username<[^/]+>/file/""" + "$" + """id<[^/]+>/share/""" + "$" + """friend<[^/]+>"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_Assets_versioned18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned18_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_Assets_at19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Assets_at19_invoker = createInvoker(
    Assets_3.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_UserController_getUsers0_route(params) =>
      call { 
        controllers_UserController_getUsers0_invoker.call(UserController_1.getUsers)
      }
  
    // @LINE:7
    case controllers_UserController_getUsersNode1_route(params) =>
      call { 
        controllers_UserController_getUsersNode1_invoker.call(UserController_1.getUsersNode)
      }
  
    // @LINE:8
    case controllers_UserController_getUser2_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_UserController_getUser2_invoker.call(UserController_1.getUser(username))
      }
  
    // @LINE:9
    case controllers_UserController_getUserNode3_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_UserController_getUserNode3_invoker.call(UserController_1.getUserNode(username))
      }
  
    // @LINE:10
    case controllers_UserController_postUser4_route(params) =>
      call { 
        controllers_UserController_postUser4_invoker.call(UserController_1.postUser)
      }
  
    // @LINE:11
    case controllers_UserController_login5_route(params) =>
      call { 
        controllers_UserController_login5_invoker.call(UserController_1.login)
      }
  
    // @LINE:12
    case controllers_UserController_logout6_route(params) =>
      call { 
        controllers_UserController_logout6_invoker.call(UserController_1.logout)
      }
  
    // @LINE:13
    case controllers_UserController_auth7_route(params) =>
      call { 
        controllers_UserController_auth7_invoker.call(UserController_1.auth)
      }
  
    // @LINE:16
    case controllers_FolderController_getFolder8_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None)) { (username, id) =>
        controllers_FolderController_getFolder8_invoker.call(FolderController_2.getFolder(username, id))
      }
  
    // @LINE:17
    case controllers_FolderController_getRoot9_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_FolderController_getRoot9_invoker.call(FolderController_2.getRoot(username))
      }
  
    // @LINE:18
    case controllers_FolderController_postFolder10_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None), params.fromPath[String]("name", None)) { (username, id, name) =>
        controllers_FolderController_postFolder10_invoker.call(FolderController_2.postFolder(username, id, name))
      }
  
    // @LINE:19
    case controllers_FolderController_putFolder11_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None)) { (username, id) =>
        controllers_FolderController_putFolder11_invoker.call(FolderController_2.putFolder(username, id))
      }
  
    // @LINE:22
    case controllers_FileController_postArchive12_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None)) { (username, id) =>
        controllers_FileController_postArchive12_invoker.call(FileController_4.postArchive(username, id))
      }
  
    // @LINE:23
    case controllers_FileController_putFile13_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None)) { (username, id) =>
        controllers_FileController_putFile13_invoker.call(FileController_4.putFile(username, id))
      }
  
    // @LINE:24
    case controllers_FileController_getFile14_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None)) { (username, id) =>
        controllers_FileController_getFile14_invoker.call(FileController_4.getFile(username, id))
      }
  
    // @LINE:27
    case controllers_ShareController_getShared15_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_ShareController_getShared15_invoker.call(ShareController_0.getShared(username))
      }
  
    // @LINE:28
    case controllers_ShareController_getMyShared16_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_ShareController_getMyShared16_invoker.call(ShareController_0.getMyShared(username))
      }
  
    // @LINE:29
    case controllers_ShareController_postShare17_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None), params.fromPath[String]("friend", None)) { (username, id, friend) =>
        controllers_ShareController_postShare17_invoker.call(ShareController_0.postShare(username, id, friend))
      }
  
    // @LINE:34
    case controllers_Assets_versioned18_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned18_invoker.call(Assets_3.versioned(path, file))
      }
  
    // @LINE:35
    case controllers_Assets_at19_route(params) =>
      call(Param[String]("path", Right("/public/html")), Param[String]("file", Right("index.html"))) { (path, file) =>
        controllers_Assets_at19_invoker.call(Assets_3.at(path, file))
      }
  }
}
