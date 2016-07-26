
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/pedro/Documentos/fileManager/conf/routes
// @DATE:Tue Jul 26 15:00:40 BRT 2016


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
