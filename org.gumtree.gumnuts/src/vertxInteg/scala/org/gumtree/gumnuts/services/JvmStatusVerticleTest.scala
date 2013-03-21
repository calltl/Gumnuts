package org.gumtree.gumnuts.services

import org.junit.Test
import org.junit.Assert._
import org.vertx.java.core.Vertx
import org.junit.runner.RunWith
import org.vertx.java.test.junit.VertxJUnit4ClassRunner
import org.vertx.java.test.VertxConfiguration
import org.vertx.java.test.VertxAware
import org.vertx.java.test.VerticleManagerAware
import org.vertx.java.deploy.impl.VerticleManager
import org.vertx.java.test.TestVerticle
import org.vertx.java.core.json.JsonObject
import org.gumtree.gumnuts.VerticleConstants
import org.vertx.java.core.eventbus.Message

@RunWith(classOf[VertxJUnit4ClassRunner])
@VertxConfiguration
@TestVerticle(main="org.gumtree.gumnuts.services.JvmStatusVerticle")
class JvmStatusVerticleTest extends VertxAware with VerticleManagerAware with VerticleConstants {

  private var vertx: Vertx = _
  private var manager: VerticleManager = _

  def setVertx(vertx: Vertx) = { this.vertx = vertx }
  def setVerticleManager(manager: VerticleManager) = { this.manager = manager }
 
  
  
  @Test
  def testJvmStatusVerticle() = {
//    vertx.eventBus().send(EVENT_JVM_GET_STATUS, new JsonObject, { m: Message[JsonObject] => m.body.getObject("data") })
  }

}