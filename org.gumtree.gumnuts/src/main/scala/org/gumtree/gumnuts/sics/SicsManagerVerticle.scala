package org.gumtree.gumnuts.sics

import org.vertx.java.deploy.Verticle
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.logging.Logger
import org.vertx.java.core.eventbus.EventBus
import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonArray
import scala.collection.JavaConversions._
import org.vertx.java.core.eventbus.impl.JsonObjectMessage

object SicsManagerVerticle {

  val STATUS_UNKNOWN = "unknown"
  val STATUS_INITIALISING = "initialising"
  val STATUS_READY = "ready"
  val STATUS_DRIVING = "driving"
  val STATUS_COUNTING = "counting"

  val EVENT_CONNECT_CHANNEL = "gumtree.sics.manager.connectChannel"
  val EVENT_DISCONNECT_CHANNEL = "gumtree.sics.manager.disconnectChannel"
  val EVENT_GET_CHANNELS = "gumtree.sics.manager.getChannels"
  val EVENT_GET_STATUS = "gumtree.sics.manager.getStatus"
  val EVENT_STATUS = "gumtree.sics.manager.status"
  val EVENT_GET_SUID = "gumtree.sics.manager.getSUID"

}

/**
 * Supported events:
 *
 * EVENT_CONNECT_CHANNEL
 *   Type:
 *     Inbound
 *   Description:
 *     Create and connect to a new channel
 *   Input:
 *     name - name of channel
 *
 * EVENT_DISCONNECT_CHANNEL
 *   Type:
 *     Inbound
 *   Description:
 *     Disconnect to an existing channel
 *   Input:
 *     name - name of channel
 *
 * EVENT_GET_CHANNELS
 *   Type:
 *     Inbound
 *   Description:
 *     Get the name of all available channels
 *   Output:
 *     names - array of channel names
 *
 * EVENT_GET_STATUS
 *   Type:
 *     Inbound
 *   Description:
 *     Get manager status
 *   Output:
 *     status - manager status
 * 
 * EVENT_STATUS
 *   Type:
 *     Outbound
 *   Description:
 *     Manager status update
 *   Output:
 *     status - manager status
 *   
 */
class SicsManagerVerticle extends ScalaVerticle {

  private var channelMap = Map[String, String]()
  private var status = SicsManagerVerticle.STATUS_UNKNOWN
  private var suid: Number = 0

  def start() = {
	// Status
    setStatus(SicsManagerVerticle.STATUS_INITIALISING)
    eventBus.registerHandler(SicsManagerVerticle.EVENT_GET_STATUS, { m: Message[JsonObject] => m.reply(new JsonObject().putString("status", status)) })
    
    // Initialise manager when both channels are ready
    var generalChannelReady = false
    var statusChannelReady = false
    var connectionMonitorHandler: Handler[Message[JsonObject]] = null
    connectionMonitorHandler = { m: Message[JsonObject] =>
      if (!generalChannelReady)
        generalChannelReady = m.body.getString("name") == CONST_SICS_CHANNEL_GENERAL && m.body.getString("status") == SicsChannelVerticle.STATUS_CONNECTED
      if (!statusChannelReady)
        statusChannelReady = m.body.getString("name") == CONST_SICS_CHANNEL_STATUS && m.body.getString("status") == SicsChannelVerticle.STATUS_CONNECTED
      if (generalChannelReady && statusChannelReady) {
        eventBus.unregisterHandler(SicsChannelVerticle.EVENT_STATUS, connectionMonitorHandler)
        initialiseManager()
      }
    }
    eventBus.registerHandler(SicsChannelVerticle.EVENT_STATUS, connectionMonitorHandler)

    // Create two default channels
    connectChannel(CONST_SICS_CHANNEL_GENERAL)
    connectChannel(CONST_SICS_CHANNEL_STATUS)
  }

  private def initialiseManager() {
    /**
     * ************************************************************************
     * Event handlers
     * ************************************************************************
     */

    // Handle EVENT_SICS_MANAGER_CONNECT_CHANNEL
    eventBus.registerHandler(SicsManagerVerticle.EVENT_CONNECT_CHANNEL, { m: Message[JsonObject] =>
      val name = m.body.getString("name")
      if (!channelMap.keySet.contains(name)) connectChannel(name)
    })

    // Handle EVENT_SICS_MANAGER_DISCONNECT_CHANNEL
    eventBus.registerHandler(SicsManagerVerticle.EVENT_DISCONNECT_CHANNEL, { m: Message[JsonObject] =>
      val name = m.body.getString("name")
      if (channelMap.keySet.contains(name)) disconnectChannel(name)
    })

    // Handle EVENT_SICS_MANAGER_GET_CHANNELS
    eventBus.registerHandler(SicsManagerVerticle.EVENT_GET_CHANNELS, { m: Message[JsonObject] =>
      m.reply(new JsonObject().putArray("names", new JsonArray(channelMap.keys.toList)))
    })

    // Handle set SUID
    eventBus.registerHandler(SicsStatusVerticle.EVENT_SUID_UPDATE_VALUE, { m: Message[JsonObject] =>
      suid = m.body.getNumber("suid")
    })
    
    // Handle get SUID
    eventBus.registerHandler(SicsManagerVerticle.EVENT_GET_SUID, { m: Message[JsonObject] =>
       m.reply(new JsonObject().putNumber("suid", suid))
    })
    
    // Get initial SUID
    eventBus.send(SicsChannelVerticle.EVENT_SEND + "." + CONST_SICS_CHANNEL_GENERAL, new JsonObject().putString("command", "hget /data/sics_suid"), { m: Message[JsonObject] =>
      val data = m.body.getObject("data")
      suid = data.getNumber("/data/sics_suid")
    })
    
    // Get initial status
    eventBus.send(SicsChannelVerticle.EVENT_SEND + "." + CONST_SICS_CHANNEL_GENERAL, new JsonObject().putString("command", "status"), { m: Message[JsonObject] =>
      val status = m.body.getString("data").split("=")(1).trim()
      status match {
        case "Eager to execute commands" => setStatus(SicsManagerVerticle.STATUS_READY)
        case "Driving" => setStatus(SicsManagerVerticle.STATUS_DRIVING)
        case "Counting" => setStatus(SicsManagerVerticle.STATUS_COUNTING)
        case _ => setStatus(SicsManagerVerticle.STATUS_UNKNOWN)
      }
    })

    /**
     * ************************************************************************
     * Verticle deployments
     * ************************************************************************
     */

    container.deployVerticle(classOf[HdbManagerVerticle].getName())
    container.deployVerticle(classOf[SicsStatusVerticle].getName())
  }

  /**
   * **************************************************************************
   * Properties
   * **************************************************************************
   */

  def setStatus(status: String) = {
    logger.info("SICS manager status changed: " + this.status + " -> " + status)
    this.status = status
    eventBus.publish(SicsManagerVerticle.EVENT_STATUS, new JsonObject().putString("status", status))
  }
  
  /**
   * **************************************************************************
   * Utilities
   * **************************************************************************
   */
  
  private def connectChannel(name: String) = {
    var channelConfig = new JsonObject
    channelConfig.putString(CONFIG_SICS_CHANNEL_NAME, name)
    channelConfig.mergeIn(container.getConfig())
    container.deployVerticle(classOf[SicsChannelVerticle].getName(), channelConfig, 1, { id: String => channelMap += (name -> id) })
  }

  private def disconnectChannel(name: String) = {
    val depolymentId = channelMap(name)
    container.undeployModule(depolymentId)
  }

}