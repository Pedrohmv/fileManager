
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/pedro/Documentos/projetosi1/conf/routes
// @DATE:Tue Jul 26 21:18:32 BRT 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
