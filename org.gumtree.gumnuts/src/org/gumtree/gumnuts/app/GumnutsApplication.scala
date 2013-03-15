package org.gumtree.gumnuts.app

import org.vertx.java.deploy.Verticle
import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.json.JsonObject
import org.gumtree.gumnuts.rest.RestServerVerticle
import org.gumtree.gumnuts.services.JvmStatusVerticle
import org.gumtree.gumnuts.sics.SicsManagerVerticle

class GumnutsApplication extends ScalaVerticle {

  def start() = {
    // Rest web server
    deployVericle(classOf[RestServerVerticle].getName())
    // Jvm statistics
    deployVericle(classOf[JvmStatusVerticle].getName())
    // Sics manager
    deployVericle(classOf[SicsManagerVerticle].getName(), container.getConfig().getObject("sics"))
    // Web server
    val config: JsonObject = new JsonObject()
    config.putString("web_root", "web")
    config.putString("index_page", "index.html")
    config.putString("host", "localhost")
    config.putNumber("port", 8070)
    deployModule("vertx.web-server-v1.0", config)
  }
  
  private def deployVericle(verticle: String, config: JsonObject = null) = {
    container.deployVerticle(verticle, config)
    logger.info("Deployed verticle " + verticle)
  }
  
  private def deployModule(module: String, config: JsonObject = null) = {
    container.deployModule(module, config)
    logger.info("Deployed module " + module)
  }
  
}