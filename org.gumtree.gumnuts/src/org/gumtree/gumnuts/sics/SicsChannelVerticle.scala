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

  lazy val name: String = container.getConfig.getString(CONFIG_SICS_CHANNEL_NAME)
  lazy val host: String = container.getConfig.getString(CONFIG_SICS_HOST)
  lazy val port: Int = container.getConfig.getInteger(CONFIG_SICS_PORT)
  
  var client: NetClient = _
  var socket: NetSocket = _
  var channdelBuffer: Buffer = new Buffer()
  var bufferMap: Map[Int, Message[JsonObject]] = Map()
  var status: SicsChannelStatus.Value = SicsChannelStatus.DISCONNECTED
  var contextId = 1
  
  
  def start() = {
    client = vertx.createNetClient()
    client.connect(port, host, connectionHandler)
    eventBus.registerHandler(ACTION_SICS_CHANNEL_SEND + "." + name, sendHandler)
    eventBus.registerHandler(ACTION_SICS_CHANNEL_GET_STATUS + "." + name, statusHandler)
  }
  
  val connectionHandler = new Handler[NetSocket] {
    def handle(socket: NetSocket) = {
      logger.info("Channel " + name + " connected to " + host + ":" + port)
      setStatus(SicsChannelStatus.CONNECTING)
      SicsChannelVerticle.this.socket = socket
      socket.dataHandler(socketHandler)
    }
  }
  
  val socketHandler = new Handler[Buffer] {
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
        case SicsChannelStatus.CONNECTED => handleSicsMessage(buffer)
      }
    }
  }
  
  val sendHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      if (status == SicsChannelStatus.CONNECTED) {
    	bufferMap += (contextId -> message)
        val text = "contextdo " + contextId + " " + message.body.getString("command")
        send(text)
        contextId = contextId + 1
        message.replyAddress
      }
    }
  }

  val statusHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      message.reply(new JsonObject().putString("status", status.toString()))
    }
  }
  
  def handleSicsMessage(buffer: Buffer) = {
    channdelBuffer.appendBuffer(buffer)
    if (channdelBuffer.getByte(channdelBuffer.length() - 1) == NEWLINE) {
      val reply = new JsonObject(channdelBuffer.toString().trim())
      logger.info("SICS reply: " + channdelBuffer.toString().trim())
      val replyMessage = bufferMap(reply.getInteger("trans"))
      replyMessage.reply(reply)
      channdelBuffer = new Buffer()
    }
  }
  
  def setStatus(status: SicsChannelStatus.Value) = {
    logger.info("Channel " + name + " status changed: " + this.status.toString() + " -> " +  status.toString())
    this.status = status
    eventBus.publish(EVENT_SICS_CHANNEL_STATUS + "." + name,
        new JsonObject().putString("status", status.toString))
  }

  private def send(text: String) = {
    socket.write(text + "\n")
    logger.info("Channel " + name + " sent: " + text)
  }

}