
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object signup_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class signup extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.17*/("""

"""),_display_(/*3.2*/main(title)/*3.13*/{_display_(Seq[Any](format.raw/*3.14*/("""
  
  
  """),format.raw/*6.3*/("""<div class="container col-xs-4">
  <form role="form-horizontal" Content-Type="application/json" id="signUpForm" >
  <div class="form-group">
    <label for="username">Username:</label>
    <input type="text" class="form-control" name="username">
  </div>
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" name="email">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" name="password">
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
    <button type="submit" form="signUpForm" formaction="/api/user" formmethod="post" value="Submit">Submit</button>
  </form>
  </div>
  
""")))}),format.raw/*27.2*/("""

"""))
      }
    }
  }

  def render(title:String): play.twirl.api.HtmlFormat.Appendable = apply(title)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (title) => apply(title)

  def ref: this.type = this

}


}

/**/
object signup extends signup_Scope0.signup
              /*
                  -- GENERATED --
                  DATE: Tue Jul 26 20:47:01 BRT 2016
                  SOURCE: /home/pedro/Documentos/projetosi1/app/views/signup.scala.html
                  HASH: 322ac6ff12696b9215a7c0421aa5463c1cbc0622
                  MATRIX: 747->1|857->16|885->19|904->30|942->31|977->40|1776->809
                  LINES: 27->1|32->1|34->3|34->3|34->3|37->6|58->27
                  -- GENERATED --
              */
          