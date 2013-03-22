package org.gumtree.gumnuts.sics

import org.gumtree.gumnuts.ScalaVerticle
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject

class SicsStatusVerticle extends ScalaVerticle {

  def start() = {
    eventBus.send(SicsChannelVerticle.EVENT_SEND + "." + CONST_SICS_CHANNEL_STATUS,
      new JsonObject().putString("command", "hnotify / 1"), hnotifyHandler)
    eventBus.send(SicsChannelVerticle.EVENT_SEND + "." + CONST_SICS_CHANNEL_STATUS,
      new JsonObject().putString("command", "statemon interest"), statemonInterestHandler)
    eventBus.send(SicsChannelVerticle.EVENT_SEND + "." + CONST_SICS_CHANNEL_STATUS,
      new JsonObject().putString("command", "statemon hdbinterest"), statemonHdbInterestHandler)
    eventBus.send(SicsChannelVerticle.EVENT_SEND + "." + CONST_SICS_CHANNEL_STATUS,
      new JsonObject().putString("command", "status interest"), statusInterestHandler)
  }

  val hnotifyHandler = new Handler[Message[JsonObject]] {
    def handle(message: Message[JsonObject]) = {
      logger.info("hnotify: " + message.body.toString())
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