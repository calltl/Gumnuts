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
 * EVENT_SICS_MANAGER_CONNECT_CHANNEL
 *   Type:
 *     Inbound
 *   Description:
 *     Create and connect to a new channel
 *   Input:
 *     name - name of channel
 * 
 * EVENT_SICS_MANAGER_DISCONNECT_CHANNEL
 *   Type:
 *     Inbound
 *   Description:
 *     Disconnect to an existing channel
 *   Input:
 *     name - name of channel
 *
 * EVENT_SICS_MANAGER_GET_CHANNELS
 *   Type:
 *     Inbound
 *   Description:
 *     Get the name of all available channels
 *   Output:
 *     names - array of channel names
 * 
 */
class SicsManagerVerticle extends ScalaVerticle {
  
  private var channelMap = Map[String, String]()
  
  def start() = {
    connectChannel(CONST_SICS_CHANNEL_GENERAL)
//    connectChannel(CONST_SICS_CHANNEL_STATUS)
   
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

  private def connectChannel(name: String) = {
	var channelConfig = new JsonObject
    channelConfig.putString(CONFIG_SICS_CHANNEL_NAME, CONST_SICS_CHANNEL_GENERAL)
    channelConfig.mergeIn(container.getConfig())
    container.deployVerticle(classOf[SicsChannelVerticle].getName(), channelConfig, 1, { id: String => channelMap += (name -> id) })
  } 
  
  private def disconnectChannel(name: String) = {
    val depolymentId = channelMap(name)
    container.undeployModule(depolymentId)
  }
  
}