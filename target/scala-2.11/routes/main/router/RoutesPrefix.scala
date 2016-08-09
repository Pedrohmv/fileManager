
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/pedro/Música/fileManager/conf/routes
// @DATE:Mon Aug 08 22:14:07 BRT 2016


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
