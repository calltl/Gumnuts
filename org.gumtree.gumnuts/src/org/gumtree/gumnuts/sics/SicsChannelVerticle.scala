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

  lazy val name: String = container.getConfig.getString(CONFIG_CHANNEL_NAME)
  lazy val host: String = container.getConfig.getString(CONFIG_CHANNEL_HOST)
  lazy val port: Int = container.getConfig.getInteger(CONFIG_CHANNEL_PORT)
  
  var client: NetClient = _
  var socket: NetSocket = _
  var channdelBuffer: Buffer = new Buffer()
  var bufferMap: Map[Int, Message[JsonObject]] = Map()
  var state: SicsChannelState.Value = SicsChannelState.DISCONNECTED
  var contextId = 1
  
  
  def start() = {
    client = vertx.createNetClient()
    client.connect(port, host, connectionHandler)
    eventBus.registerHandler(ACTION_CHANNEL_SEND + "." + name, sendHandler)
  }
  
  val connectionHandler = new Handler[NetSocket] {
    def handle(socket: NetSocket) = {
      logger.info("Channel " + name + " connected to " + host + ":" + port)
      setState(SicsChannelState.CONNECTING)
      SicsChannelVerticle.this.socket = socket
      socket.dataHandler(socketHandler)
    }
  }
  
  val socketHandler = new Handler[Buffer] {
    def handle(buffer: Buffer) = {
      state match {
        case x if buffer.toString().trim().length() == 0 =>
        case SicsChannelState.CONNECTING => {
          send(container.getConfig().getString(CONFIG_CHANNEL_LOGIN)
              + " " + container.getConfig().getString(CONFIG_CHANNEL_PASSWORD))
          setState(SicsChannelState.AUTHENICATING)
        }
        case SicsChannelState.AUTHENICATING => {
          send("protocol set json")
          setState(SicsChannelState.INITIALISING)
        }
        case SicsChannelState.INITIALISING => {
          logger.info("SICS connection ready")
          setState(SicsChannelState.CONNECTED)
        }
        case SicsChannelState.CONNECTED => handleSicsMessage(buffer)
      }
    }
  }
  
  val sendHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      if (state == SicsChannelState.CONNECTED) {
    	bufferMap += (contextId -> message)
        val text = "contextdo " + contextId + " " + message.body.getString("command")
        send(text)
        contextId = contextId + 1
        message.replyAddress
      }
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
  
  def setState(state: SicsChannelState.Value) = {
    logger.info("Channel " + name + " state changed: " + this.state.toString() + " -> " +  state.toString())
    this.state = state
    eventBus.publish(EVENT_CHANNEL_STATUS + "." + name,
        new JsonObject().putString("status", state.toString))
  }

  private def send(text: String) = {
    socket.write(text + "\n")
    logger.info("Channel " + name + " sent: " + text)
  }

}