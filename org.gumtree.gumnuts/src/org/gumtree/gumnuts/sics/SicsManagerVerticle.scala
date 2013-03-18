package org.gumtree.gumnuts.sics

import org.vertx.java.deploy.Verticle
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.logging.Logger
import org.vertx.java.core.eventbus.EventBus
import org.gumtree.gumnuts.ScalaVerticle

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
    
    container.deployVerticle(classOf[HdbManagerVerticle].getName())
    container.deployVerticle(classOf[SicsStatusVerticle].getName())
  }

}