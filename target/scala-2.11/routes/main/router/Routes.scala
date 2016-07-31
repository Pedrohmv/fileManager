
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/vhugo/apps/fileManager/conf/routes
// @DATE:Sat Jul 30 22:44:59 BRT 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:17
  UserController_0: controllers.UserController,
  // @LINE:27
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:17
    UserController_0: controllers.UserController,
    // @LINE:27
    Assets_1: controllers.Assets
  ) = this(errorHandler, UserController_0, Assets_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_0, Assets_1, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/auth""", """controllers.UserController.auth"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix, """controllers.Assets.at(path:String = "/public/html", file:String = "index.html")"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:17
  private[this] lazy val controllers_UserController_getUsers0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users")))
  )
  private[this] lazy val controllers_UserController_getUsers0_invoker = createInvoker(
    UserController_0.getUsers,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUsers",
      Nil,
      "GET",
      """---------------------------------- API --------------------------------------------------
Usuarios""",
      this.prefix + """api/users"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_UserController_getUser1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser1_invoker = createInvoker(
    UserController_0.getUser(fakeValue[String]),
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

  // @LINE:19
  private[this] lazy val controllers_UserController_postUser2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user")))
  )
  private[this] lazy val controllers_UserController_postUser2_invoker = createInvoker(
    UserController_0.postUser,
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

  // @LINE:20
  private[this] lazy val controllers_UserController_login3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/login")))
  )
  private[this] lazy val controllers_UserController_login3_invoker = createInvoker(
    UserController_0.login,
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

  // @LINE:21
  private[this] lazy val controllers_UserController_logout4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/logout")))
  )
  private[this] lazy val controllers_UserController_logout4_invoker = createInvoker(
    UserController_0.logout,
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

  // @LINE:22
  private[this] lazy val controllers_UserController_auth5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/auth")))
  )
  private[this] lazy val controllers_UserController_auth5_invoker = createInvoker(
    UserController_0.auth,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "auth",
      Nil,
      "GET",
      """""",
      this.prefix + """api/auth"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
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

  // @LINE:28
  private[this] lazy val controllers_Assets_at7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Assets_at7_invoker = createInvoker(
    Assets_1.at(fakeValue[String], fakeValue[String]),
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
  
    // @LINE:17
    case controllers_UserController_getUsers0_route(params) =>
      call { 
        controllers_UserController_getUsers0_invoker.call(UserController_0.getUsers)
      }
  
    // @LINE:18
    case controllers_UserController_getUser1_route(params) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_UserController_getUser1_invoker.call(UserController_0.getUser(username))
      }
  
    // @LINE:19
    case controllers_UserController_postUser2_route(params) =>
      call { 
        controllers_UserController_postUser2_invoker.call(UserController_0.postUser)
      }
  
    // @LINE:20
    case controllers_UserController_login3_route(params) =>
      call { 
        controllers_UserController_login3_invoker.call(UserController_0.login)
      }
  
    // @LINE:21
    case controllers_UserController_logout4_route(params) =>
      call { 
        controllers_UserController_logout4_invoker.call(UserController_0.logout)
      }
  
    // @LINE:22
    case controllers_UserController_auth5_route(params) =>
      call { 
        controllers_UserController_auth5_invoker.call(UserController_0.auth)
      }
  
    // @LINE:27
    case controllers_Assets_versioned6_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:28
    case controllers_Assets_at7_route(params) =>
      call(Param[String]("path", Right("/public/html")), Param[String]("file", Right("index.html"))) { (path, file) =>
        controllers_Assets_at7_invoker.call(Assets_1.at(path, file))
      }
  }
}
