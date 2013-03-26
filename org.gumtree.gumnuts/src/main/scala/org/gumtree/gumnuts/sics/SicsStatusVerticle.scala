package org.gumtree.gumnuts.sics

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.json.JsonElement
import scala.collection.JavaConversions._

object SicsStatusVerticle {

  val EVENT_HDB_UPDATE_VALUE = "gumtree.sics.status.hdbUpdateValue"
  val EVENT_HDB_UPDATE_STATE = "gumtree.sics.status.hdbUpdateState"
  val EVENT_SUID_UPDATE_VALUE = "gumtree.sics.status.suidUpdateValue"

}

/**
 * Supported events:
 *
 * EVENT_HDB_UPDATE_VALUE
 *   Type:
 *     Outbound
 *   Description:
 *     Used internally to update hdb object value from SICS
 *   Output:
 *     path - hdb path
 *     value - hdb value
 *
 * EVENT_SUID_UPDATE_VALUE
 *   Type:
 *     Outbound
 *   Description:
 *     Used internally to update the SUID for SICS
 *   Output:
 *     suid - SUID
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
      val value = data.getField(path)
      if (path == "/data/sics_suid") {
        eventBus.send(SicsStatusVerticle.EVENT_SUID_UPDATE_VALUE, new JsonObject().putNumber("suid", value.asInstanceOf[Number]))
      } else {
        eventBus.send(SicsStatusVerticle.EVENT_HDB_UPDATE_VALUE, new JsonObject().putString("path", path).putString("value", value.toString()))
      }
    } catch {
      case e: Exception =>
    }
  }

  val statemonInterestHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
    }
  }

  val statemonHdbInterestHandler = { m: Message[JsonObject] =>
    val data = m.body.getString("data").split(" ")
    if (data.length == 2) {
      val path = data(0)
      val state = data(1)
      eventBus.send(SicsStatusVerticle.EVENT_HDB_UPDATE_STATE, new JsonObject().putString("path", path).putString("state", state))
    }
  }

  val statusInterestHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
    }
  }

}