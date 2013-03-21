package org.gumtree.gumnuts.sics

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.buffer.Buffer
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.net.NetClient
import org.vertx.java.core.net.NetSocket

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
 *
 */
class SicsChannelVerticle extends ScalaVerticle {

  // Channel status
  object SicsChannelStatus extends Enumeration {
    val DISCONNECTED = Value("disconnect")
    val CONNECTING = Value("connecting")
    val AUTHENICATING = Value("authenicating")
    val INITIALISING = Value("initialising")
    val CONNECTED = Value("connected")
  }

  class Helper {
    def a = 1
  }

  // Constants
  private def NEWLINE = "\n".getBytes()(0)

  // Configurations
  private lazy val name: String = getConfig.getString(CONFIG_SICS_CHANNEL_NAME)
  private lazy val host: String = getConfig.getString(CONFIG_SICS_HOST)
  private lazy val port: Int = getConfig.getInteger(CONFIG_SICS_PORT)

  // Local variables
  private var client: NetClient = _
  private var socket: NetSocket = _
  private var channelBuffer: Buffer = new Buffer
  private var bufferMap: Map[Int, Message[JsonObject]] = Map()
  private var status: SicsChannelStatus.Value = SicsChannelStatus.DISCONNECTED
  private var contextId = 1

  def start() = {
    // Create client
    client = vertx.createNetClient
    // Connect client
    client.connect(port, host, { s: NetSocket =>
      logger.info("Channel " + name + " connected to " + host + ":" + port)
      setStatus(SicsChannelStatus.CONNECTING)
      socket = s
      socket.dataHandler(socketHandler)
    })
    // Handle send event
    eventBus.registerHandler(EVENT_SICS_CHANNEL_SEND + "." + name, { m: Message[JsonObject] =>
      if (status == SicsChannelStatus.CONNECTED) {
        bufferMap += (contextId -> m)
        send("contextdo " + contextId + " " + m.body.getString("command"))
        contextId = contextId + 1
      }
    })
    // Handle get status
    eventBus.registerHandler(EVENT_SICS_CHANNEL_GET_STATUS + "." + name, { m: Message[JsonObject] =>
      m.reply(new JsonObject().putString("status", status.toString))
    })
  }

  private val socketHandler = { buf: Buffer => 
      status match {
        case x if buf.toString.trim.length == 0 =>
        case SicsChannelStatus.CONNECTING => {
          send(getConfig.getString(CONFIG_SICS_LOGIN)
            + " " + getConfig.getString(CONFIG_SICS_PASSWORD))
          setStatus(SicsChannelStatus.AUTHENICATING)
        }
        case SicsChannelStatus.AUTHENICATING => {
          send("protocol set json")
          setStatus(SicsChannelStatus.INITIALISING)
        }
        case SicsChannelStatus.INITIALISING => {
          logger.info("SICS connection ready")
          setStatus(SicsChannelStatus.CONNECTED)
        }
        case SicsChannelStatus.CONNECTED => {
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

  def setStatus(status: SicsChannelStatus.Value) = {
    logger.info("Channel " + name + " status changed: " + this.status.toString() + " -> " + status.toString)
    this.status = status
    eventBus.publish(EVENT_SICS_CHANNEL_STATUS + "." + name,
      new JsonObject().putString("status", status.toString))
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