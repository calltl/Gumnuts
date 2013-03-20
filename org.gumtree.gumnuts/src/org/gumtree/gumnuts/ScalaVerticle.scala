package org.gumtree.gumnuts

import org.vertx.java.core.logging.Logger
import org.vertx.java.deploy.Verticle
import org.vertx.java.core.eventbus.EventBus
import org.vertx.java.core.json.JsonObject

/**
 * Verticle with Scala support
 */
abstract class ScalaVerticle extends Verticle with VerticleConstants {

  lazy val logger: Logger = container.getLogger()
  lazy val eventBus: EventBus = vertx.eventBus()
  
}