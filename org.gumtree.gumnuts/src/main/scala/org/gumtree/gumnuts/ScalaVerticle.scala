package org.gumtree.gumnuts

import org.vertx.java.core.logging.Logger
import org.vertx.java.deploy.Verticle
import org.vertx.java.core.eventbus.EventBus
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.Handler

/**
 * Verticle with Scala support
 */
abstract class ScalaVerticle extends Verticle with VerticleConstants {

  lazy val logger: Logger = container.getLogger()
  lazy val eventBus: EventBus = vertx.eventBus()

  def getConfig() = {
	  container.getConfig()
  }
  
  implicit def functionToHandler[T](fn: T => Unit): Handler[T] = new Handler[T]() {
    def handle(event: T) = fn(event)
  }

}