
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Thales/Documents/FileManager/fileManager/conf/routes
// @DATE:Fri Sep 09 21:11:47 GFT 2016


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
