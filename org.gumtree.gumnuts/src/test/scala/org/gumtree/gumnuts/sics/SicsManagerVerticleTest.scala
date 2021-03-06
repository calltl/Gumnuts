package org.gumtree.gumnuts.sics

import org.junit.Assert._
import org.gumtree.gumnuts.test.ScalaVerticleTest
import org.junit.runner.RunWith
import org.vertx.java.test.TestVerticle
import org.vertx.java.test.junit.VertxJUnit4ClassRunner
import org.junit.Test
import org.vertx.java.test.utils.CountDownLatchHandler
import org.vertx.java.core.json.JsonObject
import scala.collection.JavaConversions._
import org.vertx.java.core.eventbus.Message
import java.util.concurrent.TimeUnit
import org.vertx.java.core.Handler

@RunWith(classOf[VertxJUnit4ClassRunner])
@TestVerticle(main = "org.gumtree.gumnuts.sics.SicsManagerVerticle", jsonConfig = """
{
  "host": "localhost",
  "port": 60002,
  "login": "manager",
  "password": "ansto"
}
""")
class SicsManagerVerticleTest extends ScalaVerticleTest {

  @Test
  def testGetChannels() = {
    
    // Wait for SICS manager to be ready
    var managerReady = false
    vertx.setPeriodic(100, { id: java.lang.Long =>
        eventBus.send(SicsManagerVerticle.EVENT_GET_STATUS, new JsonObject, { m: Message[JsonObject] =>
          if (m.body.getString("status") == SicsManagerVerticle.STATUS_READY) {
            vertx.cancelTimer(id)
            managerReady = true
          }
        })
    })
    while (!managerReady) {
      Thread.sleep(100)
    }
    
    val handler = new CountDownLatchHandler[Message[JsonObject]](1)
    eventBus.send(SicsManagerVerticle.EVENT_GET_CHANNELS, EMPTY_OBJECT, handler)
    val channels = handler.poll(10, TimeUnit.SECONDS).body.getArray("names")
    assertEquals(2, channels.size())
    assertTrue(channels.contains(CONST_SICS_CHANNEL_GENERAL))
    assertTrue(channels.contains(CONST_SICS_CHANNEL_STATUS))
  }

}