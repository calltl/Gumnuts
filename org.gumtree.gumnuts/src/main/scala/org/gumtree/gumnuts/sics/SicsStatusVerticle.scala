package org.gumtree.gumnuts.sics

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.json.JsonElement
import scala.collection.JavaConversions._

object SicsStatusVerticle {

  val EVENT_HDB_UPDATE_VALUE = "gumtree.sics.status.hdbUpdateValue"

}

/**
 * Supported events:
 *
 * EVENT_HDB_UPDATE_VALUE
 *   Type:
 *     Outbound
 *   Description:
 *     Used internally to update hdb object value from SICS
 *   Input:
 *     path - hdb path
 *     value - hdb value
 *
 */
class SicsStatusVerticle extends ScalaVerticle {

  def start() = {
    eventBus.send(SicsChannelVerticle.EVENT_STREAM_SEND + "." + CONST_SICS_CHANNEL_STATUS,
      new JsonObject().putString("command", "hnotify / 1"), { m: Message[JsonObject] =>
        eventBus.registerHandler(m.body.getString("address"), hnotifyHandler)
    })
    eventBus.send(SicsChannelVerticle.EVENT_STREAM_SEND + "." + CONST_SICS_CHANNEL_STATUS,
      new JsonObject().putString("command", "statemon interest"), { m: Message[JsonObject] =>
        eventBus.registerHandler(m.body.getString("address"), statemonInterestHandler)
    })
    eventBus.send(SicsChannelVerticle.EVENT_STREAM_SEND + "." + CONST_SICS_CHANNEL_STATUS,
      new JsonObject().putString("command", "statemon hdbinterest"), { m: Message[JsonObject] =>
        eventBus.registerHandler(m.body.getString("address"), statemonHdbInterestHandler)
    })
    eventBus.send(SicsChannelVerticle.EVENT_STREAM_SEND + "." + CONST_SICS_CHANNEL_STATUS,
      new JsonObject().putString("command", "status interest"), { m: Message[JsonObject] =>
        eventBus.registerHandler(m.body.getString("address"), statusInterestHandler)
    })
  }

  val hnotifyHandler = { m: Message[JsonObject] =>
    try {
      val data = m.body.getObject("data") 
      val path = data.getFieldNames.head
      val value = data.getString(path)
      eventBus.send(SicsStatusVerticle.EVENT_HDB_UPDATE_VALUE, new JsonObject().putString("path", path).putString("value", value))
    } catch {
      case e: Exception =>
    }
  }
  
  val hnotifyHandler2 = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      logger.info("hnotify: " + message.body.toString)
    }
  }

  val statemonInterestHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
    }
  }

  val statemonHdbInterestHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
    }
  }

  val statusInterestHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
    }
  }

}