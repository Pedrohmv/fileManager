
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object inicio_Scope0 {
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

class inicio extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template takes a single argument, a String containing a
 * message to display.
 */
  def apply/*5.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.19*/("""

"""),format.raw/*11.4*/("""
"""),_display_(/*12.2*/main("File Manager SI1")/*12.26*/ {_display_(Seq[Any](format.raw/*12.28*/("""

    """),format.raw/*14.5*/("""<style>
body """),format.raw/*15.6*/("""{"""),format.raw/*15.7*/("""
"""),format.raw/*16.1*/("""padding-top: 50px;
"""),format.raw/*17.1*/("""}"""),format.raw/*17.2*/("""
"""),format.raw/*18.1*/(""".starter-template """),format.raw/*18.19*/("""{"""),format.raw/*18.20*/("""
"""),format.raw/*19.1*/("""padding: 40px 15px;
text-align: center;
"""),format.raw/*21.1*/("""}"""),format.raw/*21.2*/("""

  """),format.raw/*23.3*/(""".modal-header, h4, .close """),format.raw/*23.29*/("""{"""),format.raw/*23.30*/("""
      """),format.raw/*24.7*/("""background-color: #e6e6e6;
      color:#000000 !important;
      text-align: center;
      font-size: 30px;
  """),format.raw/*28.3*/("""}"""),format.raw/*28.4*/("""
  """),format.raw/*29.3*/(""".modal-footer """),format.raw/*29.17*/("""{"""),format.raw/*29.18*/("""
      """),format.raw/*30.7*/("""background-color: #f9f9f9;
  """),format.raw/*31.3*/("""}"""),format.raw/*31.4*/("""

"""),format.raw/*33.1*/("""</style>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="/">File Manager SI1</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="/play">Sobre O PlayFrameWork</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/signup"><button type="button" class="btn btn-link"><span class="glyphicon glyphicon-user"></span> Sign Up</button></a></li>
        <li><a href="#"><button type="button" class="btn btn-link" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-log-in"></span> Login</button></a></li>
      </ul>
    </div>
  </div>
</nav>
  

<div class="container">
<div class="starter-template">
<h1>File Manager SI1</h1>
<p class="lead">Guarde e edite seus arquivos de texto!</p>
<p class="lead">Pedro</p>
<p class="lead">Victor <Hug></Hug></p>
</div>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog" style="padding:80px 85px;">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Login</h4>
        </div>
        <div class="modal-body" style="padding:20px 35px;">
  <form role="form" id="loginForm">
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" name="email" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" name="password" placeholder="Password">
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button type="submit" form="loginForm" formaction="/autent" formmethod="post" value="Submit">Login</button>
  </form>
        </div>
      </div>
    </div>
  </div>
</div>

""")))}),format.raw/*93.2*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/*
 * This template takes a single argument, a String containing a
 * message to display.
 */
object inicio extends inicio_Scope0.inicio
              /*
                  -- GENERATED --
                  DATE: Mon Aug 08 22:14:07 BRT 2016
                  SOURCE: /home/pedro/Música/fileManager/app/views/inicio.scala.html
                  HASH: 719d39ef2f700042670155c4a69a8a5ef740a6ae
                  MATRIX: 836->95|948->112|977->308|1005->310|1038->334|1078->336|1111->342|1151->355|1179->356|1207->357|1253->376|1281->377|1309->378|1355->396|1384->397|1412->398|1479->438|1507->439|1538->443|1592->469|1621->470|1655->477|1792->587|1820->588|1850->591|1892->605|1921->606|1955->613|2011->642|2039->643|2068->645|4358->2905
                  LINES: 30->5|35->5|37->11|38->12|38->12|38->12|40->14|41->15|41->15|42->16|43->17|43->17|44->18|44->18|44->18|45->19|47->21|47->21|49->23|49->23|49->23|50->24|54->28|54->28|55->29|55->29|55->29|56->30|57->31|57->31|59->33|119->93
                  -- GENERATED --
              */
          