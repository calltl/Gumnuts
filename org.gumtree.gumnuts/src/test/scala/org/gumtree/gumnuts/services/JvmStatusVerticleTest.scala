package org.gumtree.gumnuts.services

import org.junit.Assert._
import org.junit.Test
import org.junit.runner.RunWith
import org.vertx.java.core.Handler
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import org.vertx.java.test.TestVerticle
import org.vertx.java.test.VertxConfiguration
import org.vertx.java.test.junit.VertxJUnit4ClassRunner
import org.vertx.java.test.utils.CountDownLatchHandler
import java.util.concurrent.TimeUnit
import org.gumtree.gumnuts.test.ScalaVerticleTest

@RunWith(classOf[VertxJUnit4ClassRunner])
@TestVerticle(main="org.gumtree.gumnuts.services.JvmStatusVerticle")
class JvmStatusVerticleTest extends ScalaVerticleTest {
  
  @Test
  def testJvmStatusVerticle() = {
    val handler = new CountDownLatchHandler[Message[JsonObject]](1)
    eventBus.send(JvmStatusVerticle.EVENT_GET_STATUS, new JsonObject, handler)
    assertNotNull(handler.poll(10, TimeUnit.SECONDS).body.getObject("data"))
  }

}