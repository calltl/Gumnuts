package org.gumtree.gumnuts.rest

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.http.ServerWebSocket
import org.gumtree.gumnuts.sics.HdbManagerVerticle
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.buffer.Buffer

class WebSocketVerticle extends ScalaVerticle {

  var socket: ServerWebSocket = null;
  
  def start() = {
    vertx.createHttpServer().websocketHandler({ s: ServerWebSocket =>
    	socket = s
    }).listen(getConfig().getInteger("port"));
    
    //
    eventBus.registerHandler(HdbManagerVerticle.EVENT_OBJECT_UPDATE, { m: Message[JsonObject] =>
      socket.writeTextFrame(m.body.toString())
    })
  }

}