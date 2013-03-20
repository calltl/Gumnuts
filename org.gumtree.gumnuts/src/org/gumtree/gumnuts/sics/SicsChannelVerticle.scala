package org.gumtree.gumnuts.sics

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.buffer.Buffer
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.net.NetClient
import org.vertx.java.core.net.NetSocket

class SicsChannelVerticle extends ScalaVerticle {
  
  def NEWLINE = "\n".getBytes()(0)

  private lazy val name: String = container.getConfig.getString(CONFIG_SICS_CHANNEL_NAME)
  private lazy val host: String = container.getConfig.getString(CONFIG_SICS_HOST)
  private lazy val port: Int = container.getConfig.getInteger(CONFIG_SICS_PORT)
  
  private var client: NetClient = _
  private var socket: NetSocket = _
  private var channelBuffer: Buffer = new Buffer()
  private var bufferMap: Map[Int, Message[JsonObject]] = Map()
  private var status: SicsChannelStatus.Value = SicsChannelStatus.DISCONNECTED
  private var contextId = 1
  
  
  def start() = {
    client = vertx.createNetClient()
    client.connect(port, host, connectionHandler)
    eventBus.registerHandler(ACTION_SICS_CHANNEL_SEND + "." + name, sendHandler)
    eventBus.registerHandler(ACTION_SICS_CHANNEL_GET_STATUS + "." + name, statusHandler)
  }
  
  /**
   * **************************************************************************
   * Event handlers
   * **************************************************************************
   */
  
  /**
   * Socket connection handler
   */
  private val connectionHandler = new Handler[NetSocket] {
    def handle(socket: NetSocket) = {
      logger.info("Channel " + name + " connected to " + host + ":" + port)
      setStatus(SicsChannelStatus.CONNECTING)
      SicsChannelVerticle.this.socket = socket
      socket.dataHandler(socketHandler)
    }
  }
  
  private val socketHandler = new Handler[Buffer] {
    def handle(buffer: Buffer) = {
      status match {
        case x if buffer.toString().trim().length() == 0 =>
        case SicsChannelStatus.CONNECTING => {
          send(container.getConfig().getString(CONFIG_SICS_LOGIN)
              + " " + container.getConfig().getString(CONFIG_SICS_PASSWORD))
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
          channelBuffer.appendBuffer(buffer)
          if (channelBuffer.getByte(channelBuffer.length() - 1) == NEWLINE) {
            val reply = new JsonObject(channelBuffer.toString().trim())
            logger.info("SICS reply: " + channelBuffer.toString().trim())
            // TODO: clean from the buffer map
            val replyMessage = bufferMap(reply.getInteger("trans"))
            replyMessage.reply(reply)
            channelBuffer = new Buffer()
          }
        }
      }
    }
  }
  
  private val sendHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      if (status == SicsChannelStatus.CONNECTED) {
    	bufferMap += (contextId -> message)
        val text = "contextdo " + contextId + " " + message.body.getString("command")
        send(text)
        contextId = contextId + 1
      }
    }
  }

  private val statusHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      message.reply(new JsonObject().putString("status", status.toString()))
    }
  }
  
  /****************************************************************************
   * Properties 
   ****************************************************************************/
  
  def setStatus(status: SicsChannelStatus.Value) = {
    logger.info("Channel " + name + " status changed: " + this.status.toString() + " -> " +  status.toString())
    this.status = status
    eventBus.publish(EVENT_SICS_CHANNEL_STATUS + "." + name,
        new JsonObject().putString("status", status.toString))
  }

  /****************************************************************************
   * Utilities 
   ****************************************************************************/
  
  private def send(text: String) = {
    socket.write(text + "\n")
    logger.info("Channel " + name + " sent: " + text)
  }

}