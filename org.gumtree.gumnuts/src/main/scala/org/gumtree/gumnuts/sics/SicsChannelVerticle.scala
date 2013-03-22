package org.gumtree.gumnuts.sics

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.buffer.Buffer
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.net.NetClient
import org.vertx.java.core.net.NetSocket

object SicsChannelVerticle {
  val STATUS_DISCONNECTED = "disconnect"
  val STATUS_CONNECTING = "connecting"
  val STATUS_AUTHENICATING = "authenicating"
  val STATUS_INITIALISING = "initialising"
  val STATUS_CONNECTED = "connected"
    
  val EVENT_SEND = "gumtree.sics.channel.send"
  val EVENT_GET_STATUS = "gumtree.sics.channel.getStatus"
  val EVENT_STATUS = "gumtree.sics.channel.status"
}

/**
 * Supported events:
 *
 * EVENT_SICS_CHANNEL_SEND + .CHANNEL_NAME
 *   Type:
 *     Inbound
 *   Description:
 *     Send command to SICS
 *   Output:
 *     SICS reply
 * 
 * EVENT_SICS_CHANNEL_STATUS
 *   Type:
 *     Outbound
 *   Description:
 *     Channel status change
 *   Output:
 *     name - channel name
 *     status - channel status
 *
 */
class SicsChannelVerticle extends ScalaVerticle {

  // Constants
  private def NEWLINE = "\n".getBytes()(0)

  // Configurations
  private lazy val name: String = getConfig.getString(CONFIG_SICS_CHANNEL_NAME)
  private lazy val host: String = getConfig.getString(CONFIG_SICS_HOST)
  private lazy val port: Int = getConfig.getInteger(CONFIG_SICS_PORT)

  // Local variables
  private var client: NetClient = _
  private var socket: NetSocket = _
  private var channelBuffer = new Buffer
  private var bufferMap: Map[Int, Message[JsonObject]] = Map()
  private var status = SicsChannelVerticle.STATUS_DISCONNECTED
  private var contextId = 1

  def start() = {
    // Create client
    client = vertx.createNetClient
    // Connect client
    client.connect(port, host, { s: NetSocket =>
      logger.info("Channel " + name + " connected to " + host + ":" + port)
      setStatus(SicsChannelVerticle.STATUS_CONNECTING)
      socket = s
      socket.dataHandler(socketHandler)
    })
    // Handle send event
    eventBus.registerHandler(SicsChannelVerticle.EVENT_SEND + "." + name, { m: Message[JsonObject] =>
      if (status == SicsChannelVerticle.STATUS_CONNECTED) {
        bufferMap += (contextId -> m)
        send("contextdo " + contextId + " " + m.body.getString("command"))
        contextId = contextId + 1
      }
    })
    // Handle get status
    eventBus.registerHandler(SicsChannelVerticle.EVENT_GET_STATUS + "." + name, { m: Message[JsonObject] =>
      m.reply(new JsonObject().putString("status", status.toString))
    })
  }

  private val socketHandler = { buf: Buffer => 
      status match {
        case x if buf.toString.trim.length == 0 =>
        case SicsChannelVerticle.STATUS_CONNECTING => {
          send(getConfig.getString(CONFIG_SICS_LOGIN)
            + " " + getConfig.getString(CONFIG_SICS_PASSWORD))
          setStatus(SicsChannelVerticle.STATUS_AUTHENICATING)
        }
        case SicsChannelVerticle.STATUS_AUTHENICATING => {
          send("protocol set json")
          setStatus(SicsChannelVerticle.STATUS_INITIALISING)
        }
        case SicsChannelVerticle.STATUS_INITIALISING => {
          logger.info("Channel " + name + " ready")
          setStatus(SicsChannelVerticle.STATUS_CONNECTED)
        }
        case SicsChannelVerticle.STATUS_CONNECTED => {
          channelBuffer.appendBuffer(buf)
          if (channelBuffer.getByte(channelBuffer.length - 1) == NEWLINE) {
            val reply = new JsonObject(channelBuffer.toString.trim)
            logger.info("SICS reply: " + channelBuffer.toString.trim)
            // TODO: clean from the buffer map
            val replyMessage = bufferMap(reply.getInteger("trans"))
            replyMessage.reply(reply)
            channelBuffer = new Buffer
          }
        }
      }
    }

  /**
   * **************************************************************************
   * Properties
   * **************************************************************************
   */

  def setStatus(status: String) = {
    logger.info("Channel " + name + " status changed: " + this.status + " -> " + status)
    this.status = status
    eventBus.publish(SicsChannelVerticle.EVENT_STATUS, new JsonObject().putString("name", name).putString("status", status))
  }

  /**
   * **************************************************************************
   * Utilities
   * **************************************************************************
   */

  private def send(text: String) = {
    socket.write(text + "\n")
    logger.info("Channel " + name + " sent: " + text)
  }

}