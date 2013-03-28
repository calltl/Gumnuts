package org.gumtree.gumnuts.test

import org.gumtree.gumnuts.VerticleConstants
import org.vertx.java.core.Handler
import org.vertx.java.core.Vertx
import org.vertx.java.core.eventbus.EventBus
import org.vertx.java.deploy.impl.VerticleManager
import org.vertx.java.test.VerticleManagerAware
import org.vertx.java.test.VertxAware

abstract class ScalaVerticleTest extends VertxAware with VerticleManagerAware with VerticleConstants {

  protected var vertx: Vertx = _

  protected var manager: VerticleManager = _
  
  protected lazy val eventBus: EventBus = vertx.eventBus()

  def setVertx(vertx: Vertx) = { this.vertx = vertx }

  def setVerticleManager(manager: VerticleManager) = { this.manager = manager }

  implicit def functionToHandler[T](fn: T => Unit): Handler[T] = new Handler[T]() {
    def handle(event: T) = fn(event)
  }

}