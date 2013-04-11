package org.gumtree.gumnuts.app

import org.gumtree.gumnuts.ScalaVerticle
import org.gumtree.gumnuts.rest.RestServerVerticle
import org.gumtree.gumnuts.services.JvmStatusVerticle
import org.gumtree.gumnuts.sics.SicsManagerVerticle
import org.vertx.java.core.json.JsonObject
import org.gumtree.gumnuts.dae.DaeManagerVerticle
import org.gumtree.gumnuts.ws.AnstoWebServerVerticle
import org.gumtree.gumnuts.rest.WebSocketVerticle

/**
 * The application entry point
 */
class GumnutsApplication extends ScalaVerticle {

  def start() = {
    // JVM statistics
    deployVericle(classOf[JvmStatusVerticle].getName)
    // SICS manager
    deployVericle(classOf[SicsManagerVerticle].getName, container.getConfig.getObject(CONFIG_SICS_HEADER))
    // DAE manager
    deployVericle(classOf[DaeManagerVerticle].getName, container.getConfig.getObject(CONFIG_DAE_HEADER))
    // Web services client
    deployVericle(classOf[AnstoWebServerVerticle].getName, container.getConfig.getObject(CONFIG_WS_HEADER))
    // Rest web server
    deployVericle(classOf[RestServerVerticle].getName, container.getConfig.getObject(CONFIG_REST_HEADER))
    // Web socket
    deployVericle(classOf[WebSocketVerticle].getName, container.getConfig.getObject(CONFIG_WEBSOCKET_HEADER))
    // Web server
    deployModule("vertx.web-server-v1.0", container.getConfig.getObject(CONFIG_WEB_HEADER))
    // CRaSH shell
    deployModule("org.crashub.shell-v1.0", container.getConfig.getObject(CONFIG_CRASH_HEADER))
  }

  /**
   * **************************************************************************
   * Utilities
   * **************************************************************************
   */

  private def deployVericle(verticle: String, config: JsonObject = null) = {
    container.deployVerticle(verticle, config)
    logger.info("Deployed verticle " + verticle)
  }

  private def deployModule(module: String, config: JsonObject = null) = {
    container.deployModule(module, config)
    logger.info("Deployed module " + module)
  }

}