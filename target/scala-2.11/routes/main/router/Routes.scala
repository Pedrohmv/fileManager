
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Thales/Documents/FileManager/fileManager/conf/routes
// @DATE:Fri Sep 09 21:11:47 GFT 2016

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
  // @LINE:14
  FolderController_2: controllers.FolderController,
  // @LINE:19
  FileController_4: controllers.FileController,
  // @LINE:23
  ShareController_0: controllers.ShareController,
  // @LINE:30
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    UserController_1: controllers.UserController,
    // @LINE:14
    FolderController_2: controllers.FolderController,
    // @LINE:19
    FileController_4: controllers.FileController,
    // @LINE:23
    ShareController_0: controllers.ShareController,
    // @LINE:30
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>""", """controllers.UserController.getUser(username:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user""", """controllers.UserController.postUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/login""", """controllers.UserController.login"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/logout""", """controllers.UserController.logout"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/auth""", """controllers.UserController.auth"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>""", """controllers.FolderController.getFolder(username:String, id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/root""", """controllers.FolderController.getRoot(username:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>/folder/""" + "$" + """name<[^/]+>""", """controllers.FolderController.postFolder(username:String, id:Integer, name:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users/""" + "$" + """username<[^/]+>/root/""" + "$" + """id<[^/]+>/archive""", """controllers.FileController.postArchive(username:String, id:Integer)"""),
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
  private[this] lazy val controllers_UserController_getUser1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser1_invoker = createInvoker(
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

  // @LINE:8
  private[this] lazy val controllers_UserController_postUser2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user")))
  )
  private[this] lazy val controllers_UserController_postUser2_invoker = createInvoker(
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

  // @LINE:9
  private[this] lazy val controllers_UserController_login3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/login")))
  )
  private[this] lazy val controllers_UserController_login3_invoker = createInvoker(
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

  // @LINE:10
  private[this] lazy val controllers_UserController_logout4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/logout")))
  )
  private[this] lazy val controllers_UserController_logout4_invoker = createInvoker(
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

  // @LINE:11
  private[this] lazy val controllers_UserController_auth5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/auth")))
  )
  private[this] lazy val controllers_UserController_auth5_invoker = createInvoker(
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

  // @LINE:14
  private[this] lazy val controllers_FolderController_getFolder6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/root/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FolderController_getFolder6_invoker = createInvoker(
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

  // @LINE:15
  private[this] lazy val controllers_FolderController_getRoot7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/root")))
  )
  private[this] lazy val controllers_FolderController_getRoot7_invoker = createInvoker(
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

  // @LINE:16
  private[this] lazy val controllers_FolderController_postFolder8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/root/"), DynamicPart("id", """[^/]+""",true), StaticPart("/folder/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FolderController_postFolder8_invoker = createInvoker(
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
  private[this] lazy val controllers_FileController_postArchive9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/root/"), DynamicPart("id", """[^/]+""",true), StaticPart("/archive")))
  )
  private[this] lazy val controllers_FileController_postArchive9_invoker = createInvoker(
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

  // @LINE:20
  private[this] lazy val controllers_FileController_getFile10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/file/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FileController_getFile10_invoker = createInvoker(
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

  // @LINE:23
  private[this] lazy val controllers_ShareController_getShared11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/shared")))
  )
  private[this] lazy val controllers_ShareController_getShared11_invoker = createInvoker(
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

  // @LINE:24
  private[this] lazy val controllers_ShareController_getMyShared12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/myshare")))
  )
  private[this] lazy val controllers_ShareController_getMyShared12_invoker = createInvoker(
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

  // @LINE:25
  private[this] lazy val controllers_ShareController_postShare13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true), StaticPart("/file/"), DynamicPart("id", """[^/]+""",true), StaticPart("/share/"), DynamicPart("friend", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ShareController_postShare13_invoker = createInvoker(
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

  // @LINE:30
  private[this] lazy val controllers_Assets_versioned14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned14_invoker = createInvoker(
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

  // @LINE:31
  private[this] lazy val controllers_Assets_at15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Assets_at15_invoker = createInvoker(
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
    case controllers_UserController_getUser1_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_UserController_getUser1_invoker.call(UserController_1.getUser(username))
      }
  
    // @LINE:8
    case controllers_UserController_postUser2_route(params) =>
      call { 
        controllers_UserController_postUser2_invoker.call(UserController_1.postUser)
      }
  
    // @LINE:9
    case controllers_UserController_login3_route(params) =>
      call { 
        controllers_UserController_login3_invoker.call(UserController_1.login)
      }
  
    // @LINE:10
    case controllers_UserController_logout4_route(params) =>
      call { 
        controllers_UserController_logout4_invoker.call(UserController_1.logout)
      }
  
    // @LINE:11
    case controllers_UserController_auth5_route(params) =>
      call { 
        controllers_UserController_auth5_invoker.call(UserController_1.auth)
      }
  
    // @LINE:14
    case controllers_FolderController_getFolder6_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None)) { (username, id) =>
        controllers_FolderController_getFolder6_invoker.call(FolderController_2.getFolder(username, id))
      }
  
    // @LINE:15
    case controllers_FolderController_getRoot7_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_FolderController_getRoot7_invoker.call(FolderController_2.getRoot(username))
      }
  
    // @LINE:16
    case controllers_FolderController_postFolder8_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None), params.fromPath[String]("name", None)) { (username, id, name) =>
        controllers_FolderController_postFolder8_invoker.call(FolderController_2.postFolder(username, id, name))
      }
  
    // @LINE:19
    case controllers_FileController_postArchive9_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None)) { (username, id) =>
        controllers_FileController_postArchive9_invoker.call(FileController_4.postArchive(username, id))
      }
  
    // @LINE:20
    case controllers_FileController_getFile10_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None)) { (username, id) =>
        controllers_FileController_getFile10_invoker.call(FileController_4.getFile(username, id))
      }
  
    // @LINE:23
    case controllers_ShareController_getShared11_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_ShareController_getShared11_invoker.call(ShareController_0.getShared(username))
      }
  
    // @LINE:24
    case controllers_ShareController_getMyShared12_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_ShareController_getMyShared12_invoker.call(ShareController_0.getMyShared(username))
      }
  
    // @LINE:25
    case controllers_ShareController_postShare13_route(params) =>
      call(params.fromPath[String]("username", None), params.fromPath[Integer]("id", None), params.fromPath[String]("friend", None)) { (username, id, friend) =>
        controllers_ShareController_postShare13_invoker.call(ShareController_0.postShare(username, id, friend))
      }
  
    // @LINE:30
    case controllers_Assets_versioned14_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned14_invoker.call(Assets_3.versioned(path, file))
      }
  
    // @LINE:31
    case controllers_Assets_at15_route(params) =>
      call(Param[String]("path", Right("/public/html")), Param[String]("file", Right("index.html"))) { (path, file) =>
        controllers_Assets_at15_invoker.call(Assets_3.at(path, file))
      }
  }
}
