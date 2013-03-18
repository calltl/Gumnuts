package org.gumtree.gumnuts.sics

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject

class SicsStatusVerticle extends ScalaVerticle {

  def start() = {
    eventBus.registerHandler(EVENT_SICS_CHANNEL_STATUS + "." + CONST_SICS_CHANNEL_STATUS, connectionHandler)
  }

  val connectionHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      val status = SicsChannelState.withName(message.body.getString("status"))
      status match {
        case SicsChannelState.CONNECTED => {
          eventBus.send(ACTION_SICS_CHANNEL_SEND + "." + EVENT_SICS_CHANNEL_STATUS,
            new JsonObject().putString("command", "hnotify / 1"), hnotifyHandler)
          eventBus.send(ACTION_SICS_CHANNEL_SEND + "." + EVENT_SICS_CHANNEL_STATUS,
            new JsonObject().putString("command", "statemon interest"), statemonInterestHandler)
          eventBus.send(ACTION_SICS_CHANNEL_SEND + "." + EVENT_SICS_CHANNEL_STATUS,
            new JsonObject().putString("command", "statemon hdbinterest"), statemonHdbInterestHandler)
          eventBus.send(ACTION_SICS_CHANNEL_SEND + "." + EVENT_SICS_CHANNEL_STATUS,
            new JsonObject().putString("command", "status interest"), statusInterestHandler)
        }
        case _ =>
      }
    }
  }

  val hnotifyHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
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