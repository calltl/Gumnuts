package org.gumtree.gumnuts.sics

import org.vertx.java.deploy.Verticle
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.logging.Logger
import org.vertx.java.core.eventbus.EventBus
import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message

/**
 * Supported events:
 * 
 */
class SicsManagerVerticle extends ScalaVerticle {
  
  def start() = {
    var generalConfig = new JsonObject()
    generalConfig.putString(CONFIG_SICS_CHANNEL_NAME, CONST_SICS_CHANNEL_GENERAL)
    generalConfig.mergeIn(container.getConfig())
    container.deployVerticle(classOf[SicsChannelVerticle].getName(), generalConfig)
    
    var statusConfig = new JsonObject()
    statusConfig.putString(CONFIG_SICS_CHANNEL_NAME, CONST_SICS_CHANNEL_STATUS)
    statusConfig.mergeIn(container.getConfig())
    container.deployVerticle(classOf[SicsChannelVerticle].getName(), statusConfig)
    
    val connectionHandler = new Handler[Message[JsonObject]] {
      var generalChannelConnected = false
      var statusChannelConnected = false
      def handle(message: Message[JsonObject]) = {
      }
    }
    eventBus.registerHandler(EVENT_SICS_CHANNEL_STATUS + "." + CONST_SICS_CHANNEL_GENERAL, connectionHandler)
    eventBus.registerHandler(EVENT_SICS_CHANNEL_STATUS + "." + CONST_SICS_CHANNEL_GENERAL, connectionHandler)
    
    container.deployVerticle(classOf[HdbManagerVerticle].getName())
    container.deployVerticle(classOf[SicsStatusVerticle].getName())
  }

}