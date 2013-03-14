package test.vertx.scala

import org.vertx.java.deploy.Verticle
import org.vertx.java.core.logging.Logger
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.Handler

class Application extends Verticle {

  lazy val logger: Logger = container.getLogger()

  def start() = {
    // Rest web server
//    deployVericle(classOf[RestServerVerticle].getName())
    // Jvm statistics
//    deployVericle(classOf[JvmStatusVerticle].getName())
    // Sics manager
//    deployVericle(classOf[SicsManagerVerticle].getName())
    // Web server
    val config: JsonObject = new JsonObject()
    config.putString("web_root", "web")
    config.putString("index_page", "index.html")
    config.putString("host", "localhost")
    config.putNumber("port", 8070)
    deployModule("vertx.web-server-v1.0", config)
    // Authenication manager
//    deployModule("vertx.auth-mgr-v1.1")
  }

  private def deployVericle(verticle: String) = {
    container.deployVerticle(verticle)
    logger.info("Deployed verticle " + verticle)
  }
  
  private def deployModule(module: String, config: JsonObject = null) = {
    container.deployModule(module, config)
    logger.info("Deployed module " + module)
  }

}
